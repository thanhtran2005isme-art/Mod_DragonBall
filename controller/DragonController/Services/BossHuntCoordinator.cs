namespace DragonController.Services;

internal sealed class BossClientSnapshot
{
    public int ClientId { get; init; }
    public bool Connected { get; init; }
    public string Map { get; init; } = "";
    public int Zone { get; init; } = -1;
    public int ZoneCount { get; init; }
    public int? AssignedZone { get; init; }
    public string Action { get; init; } = "";
}

internal sealed class BossHuntSnapshot
{
    public bool Monitoring { get; init; }
    public bool Active { get; init; }
    public bool Found { get; init; }
    public int HuntId { get; init; }
    public string TargetBoss { get; init; } = "";
    public string Map { get; init; } = "";
    public int BossZone { get; init; } = -1;
    public string Status { get; init; } = "";
    public string LastAnnouncement { get; init; } = "";
    public IReadOnlyList<BossClientSnapshot> Clients { get; init; } = Array.Empty<BossClientSnapshot>();
}

internal sealed class BossHuntCoordinator : IDisposable
{
    private sealed class ClientState
    {
        public int ClientId;
        public bool Connected;
        public string Map = "";
        public int MapId = -1;
        public int Zone = -1;
        public int ZoneCount;
        public int? AssignedZone;
        public string Action = "Chờ";
    }

    private enum HuntPhase
    {
        Off,
        WaitingAnnouncement,
        MovingToMap,
        Scanning,
        Found
    }

    private readonly object _gate = new();
    private readonly GameBridgeServer _bridge;
    private readonly Dictionary<int, ClientState> _clients = new();
    private readonly HashSet<int> _reservedZones = new();
    private readonly HashSet<int> _scannedZones = new();

    private HuntPhase _phase = HuntPhase.Off;
    private string _targetBoss = "Super Broly";
    private string _targetMap = "";
    private string _lastAnnouncement = "";
    private int _huntId;
    private long _sequence;
    private int _zoneCount;
    private int _bossZone = -1;

    public event Action? Changed;

    public BossHuntCoordinator(GameBridgeServer bridge)
    {
        _bridge = bridge;
        _bridge.ClientConnected += OnClientConnected;
        _bridge.ClientDisconnected += OnClientDisconnected;
        _bridge.MessageReceived += OnMessage;
    }

    public void Enable(string targetBoss)
    {
        targetBoss = (targetBoss ?? "").Trim();
        if (targetBoss.Length == 0) targetBoss = "Super Broly";

        lock (_gate)
        {
            _targetBoss = targetBoss;
            _targetMap = "";
            _lastAnnouncement = "";
            _zoneCount = 0;
            _bossZone = -1;
            _reservedZones.Clear();
            _scannedZones.Clear();

            foreach (var client in _clients.Values)
            {
                client.AssignedZone = null;
                client.Action = client.Connected ? "Chờ thông báo boss" : "Mất kết nối";
            }

            _phase = HuntPhase.WaitingAnnouncement;
        }

        RaiseChanged();
    }

    public void Stop()
    {
        List<int> clientIds;
        int huntId;

        lock (_gate)
        {
            huntId = _huntId;
            clientIds = _clients.Values.Where(x => x.Connected).Select(x => x.ClientId).ToList();

            _phase = HuntPhase.Off;
            _targetMap = "";
            _zoneCount = 0;
            _bossZone = -1;
            _reservedZones.Clear();
            _scannedZones.Clear();

            foreach (var client in _clients.Values)
            {
                client.AssignedZone = null;
                client.Action = client.Connected ? "Dừng săn boss" : "Mất kết nối";
            }
        }

        foreach (var clientId in clientIds)
            Send(clientId, huntId, "STOP_HUNT");

        RaiseChanged();
    }

    public BossHuntSnapshot Snapshot()
    {
        lock (_gate)
        {
            return new BossHuntSnapshot
            {
                Monitoring = _phase != HuntPhase.Off,
                Active = _phase is HuntPhase.MovingToMap or HuntPhase.Scanning or HuntPhase.Found,
                Found = _phase == HuntPhase.Found,
                HuntId = _huntId,
                TargetBoss = _targetBoss,
                Map = _targetMap,
                BossZone = _bossZone,
                Status = StatusTextLocked(),
                LastAnnouncement = _lastAnnouncement,
                Clients = _clients.Values
                    .OrderBy(x => x.ClientId)
                    .Select(x => new BossClientSnapshot
                    {
                        ClientId = x.ClientId,
                        Connected = x.Connected,
                        Map = x.Map,
                        Zone = x.Zone,
                        ZoneCount = x.ZoneCount,
                        AssignedZone = x.AssignedZone,
                        Action = x.Action
                    })
                    .ToArray()
            };
        }
    }

    private void OnClientConnected(int clientId)
    {
        lock (_gate)
        {
            var state = GetOrCreateClientLocked(clientId);
            state.Connected = true;
            state.Action = _phase switch
            {
                HuntPhase.WaitingAnnouncement => "Chờ thông báo boss",
                HuntPhase.MovingToMap => "Chuẩn bị tới map boss",
                HuntPhase.Scanning => "Đang đồng bộ",
                HuntPhase.Found => _bossZone >= 0 ? $"→ Khu {_bossZone}" : "Hội quân",
                _ => "Chờ"
            };

            if (_phase is HuntPhase.MovingToMap or HuntPhase.Scanning && _targetMap.Length > 0)
                SendLocked(clientId, "MOVE_MAP", _targetMap, _targetBoss);
            else if (_phase == HuntPhase.Found && _bossZone >= 0)
                SendLocked(clientId, "JOIN_BOSS_ZONE", _bossZone.ToString(), _targetBoss, _targetMap);
        }

        RaiseChanged();
    }

    private void OnClientDisconnected(int clientId)
    {
        lock (_gate)
        {
            var state = GetOrCreateClientLocked(clientId);
            state.Connected = false;
            state.Action = "Mất kết nối";

            if (state.AssignedZone is int zone)
            {
                _reservedZones.Remove(zone);
                state.AssignedZone = null;
            }

            AssignAvailableClientsLocked();
        }

        RaiseChanged();
    }

    private void OnMessage(GameBridgeMessage message)
    {
        var changed = false;

        lock (_gate)
        {
            var client = GetOrCreateClientLocked(message.ClientId);
            client.Connected = true;

            switch (message.Type)
            {
                case "STATE":
                    changed = HandleStateLocked(client, message.Fields);
                    break;

                case "BOSS_ANNOUNCED":
                    changed = HandleBossAnnouncementLocked(message.Fields);
                    break;

                case "ZONE_ENTERED":
                    changed = HandleZoneEnteredLocked(client, message.Fields);
                    break;

                case "ZONE_CLEAR":
                    changed = HandleZoneClearLocked(client, message.Fields);
                    break;

                case "BOSS_FOUND":
                    changed = HandleBossFoundLocked(client, message.Fields);
                    break;

                case "BOSS_JOINED":
                    changed = HandleBossJoinedLocked(client, message.Fields);
                    break;
            }
        }

        if (changed) RaiseChanged();
    }

    private bool HandleStateLocked(ClientState client, IReadOnlyList<string> fields)
    {
        if (fields.Count < 4) return false;
        if (!int.TryParse(fields[0], out var mapId)) mapId = -1;
        var map = fields[1];
        if (!int.TryParse(fields[2], out var zone)) zone = -1;
        if (!int.TryParse(fields[3], out var zoneCount)) zoneCount = 0;

        client.MapId = mapId;
        client.Map = map;
        client.Zone = zone;
        client.ZoneCount = zoneCount;

        if (_phase is HuntPhase.MovingToMap or HuntPhase.Scanning)
        {
            if (SameMap(map, _targetMap))
            {
                if (zoneCount > _zoneCount) _zoneCount = zoneCount;
                _phase = HuntPhase.Scanning;
                if (client.AssignedZone is null)
                    client.Action = "Đã tới map boss";

                AssignAvailableClientsLocked();
            }
            else
            {
                client.Action = "Đang tới " + _targetMap;
            }
        }
        else if (_phase == HuntPhase.Found && _bossZone >= 0)
        {
            client.Action = zone == _bossZone && SameMap(map, _targetMap)
                ? $"Đã ở Khu {_bossZone}"
                : $"→ Khu {_bossZone}";
        }

        return true;
    }

    private bool HandleBossAnnouncementLocked(IReadOnlyList<string> fields)
    {
        if (fields.Count < 3) return false;

        var boss = fields[0].Trim();
        var map = fields[1].Trim();
        var raw = fields[2].Trim();

        _lastAnnouncement = raw.Length > 0 ? raw : $"{boss} - {map}";

        if (_phase != HuntPhase.WaitingAnnouncement)
            return true;

        if (!BossMatches(boss, _targetBoss) || map.Length == 0)
            return true;

        StartHuntLocked(boss, map);
        return true;
    }

    private bool HandleZoneEnteredLocked(ClientState client, IReadOnlyList<string> fields)
    {
        if (fields.Count < 2) return false;
        if (!int.TryParse(fields[0], out var huntId) || huntId != _huntId) return false;
        if (!int.TryParse(fields[1], out var zone)) return false;

        if (client.AssignedZone == zone)
            client.Action = $"Khu {zone}: đang kiểm tra boss";

        return true;
    }

    private bool HandleZoneClearLocked(ClientState client, IReadOnlyList<string> fields)
    {
        if (_phase != HuntPhase.Scanning || fields.Count < 2) return false;
        if (!int.TryParse(fields[0], out var huntId) || huntId != _huntId) return false;
        if (!int.TryParse(fields[1], out var zone)) return false;
        if (client.AssignedZone != zone) return false;

        _reservedZones.Remove(zone);
        _scannedZones.Add(zone);
        client.AssignedZone = null;
        client.Action = $"Khu {zone}: không có boss";

        AssignAvailableClientsLocked();
        return true;
    }

    private bool HandleBossFoundLocked(ClientState client, IReadOnlyList<string> fields)
    {
        if (_phase != HuntPhase.Scanning || fields.Count < 3) return false;
        if (!int.TryParse(fields[0], out var huntId) || huntId != _huntId) return false;
        if (!int.TryParse(fields[1], out var zone)) return false;

        var bossName = fields[2];
        if (!BossMatches(bossName, _targetBoss)) return false;

        _phase = HuntPhase.Found;
        _bossZone = zone;
        _reservedZones.Clear();

        foreach (var state in _clients.Values)
        {
            state.AssignedZone = null;

            if (!state.Connected) continue;

            state.Action = state.ClientId == client.ClientId
                ? $"PHÁT HIỆN {_targetBoss} - Khu {zone}"
                : $"→ Khu {zone}";

            SendLocked(
                state.ClientId,
                "JOIN_BOSS_ZONE",
                zone.ToString(),
                _targetBoss,
                _targetMap);
        }

        return true;
    }

    private bool HandleBossJoinedLocked(ClientState client, IReadOnlyList<string> fields)
    {
        if (_phase != HuntPhase.Found || fields.Count < 2) return false;
        if (!int.TryParse(fields[0], out var huntId) || huntId != _huntId) return false;
        if (!int.TryParse(fields[1], out var zone) || zone != _bossZone) return false;

        client.Action = $"Đã ở Khu {_bossZone}";
        return true;
    }

    private void StartHuntLocked(string announcedBoss, string map)
    {
        _huntId++;
        _targetBoss = announcedBoss;
        _targetMap = map;
        _zoneCount = 0;
        _bossZone = -1;
        _reservedZones.Clear();
        _scannedZones.Clear();
        _phase = HuntPhase.MovingToMap;

        foreach (var client in _clients.Values.OrderBy(x => x.ClientId))
        {
            client.AssignedZone = null;
            if (!client.Connected) continue;

            client.Action = SameMap(client.Map, _targetMap)
                ? "Đã ở map boss"
                : "Đang tới " + _targetMap;

            SendLocked(client.ClientId, "MOVE_MAP", _targetMap, _targetBoss);
        }

        AssignAvailableClientsLocked();
    }

    private void AssignAvailableClientsLocked()
    {
        if (_phase is not (HuntPhase.MovingToMap or HuntPhase.Scanning))
            return;

        foreach (var client in _clients.Values.OrderBy(x => x.ClientId))
        {
            if (!client.Connected || client.AssignedZone is not null)
                continue;

            if (!SameMap(client.Map, _targetMap))
                continue;

            if (client.ZoneCount > _zoneCount)
                _zoneCount = client.ZoneCount;

            var zone = NextFreeZoneLocked();
            if (zone < 0)
            {
                client.Action = _zoneCount > 0 ? "Đã cấp hết khu" : "Đang đọc danh sách khu";
                continue;
            }

            _reservedZones.Add(zone);
            client.AssignedZone = zone;
            client.Action = $"→ Dò Khu {zone}";

            SendLocked(
                client.ClientId,
                "JOIN_ZONE",
                zone.ToString(),
                _targetBoss,
                _targetMap);
        }
    }

    private int NextFreeZoneLocked()
    {
        if (_zoneCount <= 0) return -1;

        // cF.v and cM.W(int) use the game's raw zone id. The original Q.bN()
        // cycles (current + 1) % aL.r.length, so valid ids are 0..count-1.
        for (var zone = 0; zone < _zoneCount; zone++)
        {
            if (_reservedZones.Contains(zone)) continue;
            if (_scannedZones.Contains(zone)) continue;
            return zone;
        }

        return -1;
    }

    private void SendLocked(int clientId, string command, params string[] args)
    {
        Send(clientId, _huntId, command, args);
    }

    private void Send(int clientId, int huntId, string command, params string[] args)
    {
        var sequence = Interlocked.Increment(ref _sequence);
        _bridge.SendCommand(clientId, huntId, sequence, command, args);
    }

    private ClientState GetOrCreateClientLocked(int clientId)
    {
        if (_clients.TryGetValue(clientId, out var state))
            return state;

        state = new ClientState { ClientId = clientId };
        _clients[clientId] = state;
        return state;
    }

    private string StatusTextLocked()
    {
        return _phase switch
        {
            HuntPhase.Off => "Săn boss: Tắt",
            HuntPhase.WaitingAnnouncement => $"Đang chờ thông báo {_targetBoss}",
            HuntPhase.MovingToMap => $"Đã nhận {_targetBoss} - đang tới {_targetMap}",
            HuntPhase.Scanning => $"Đang dò {_targetBoss} tại {_targetMap}",
            HuntPhase.Found => $"ĐÃ THẤY {_targetBoss} - {_targetMap} - Khu {_bossZone}",
            _ => ""
        };
    }

    private static bool BossMatches(string actual, string target)
    {
        actual = (actual ?? "").Trim();
        target = (target ?? "").Trim();

        if (actual.Length == 0 || target.Length == 0) return false;

        return actual.Contains(target, StringComparison.OrdinalIgnoreCase) ||
               target.Contains(actual, StringComparison.OrdinalIgnoreCase);
    }

    private static bool SameMap(string left, string right) =>
        string.Equals((left ?? "").Trim(), (right ?? "").Trim(), StringComparison.OrdinalIgnoreCase);

    private void RaiseChanged()
    {
        try { Changed?.Invoke(); } catch { }
    }

    public void Dispose()
    {
        _bridge.ClientConnected -= OnClientConnected;
        _bridge.ClientDisconnected -= OnClientDisconnected;
        _bridge.MessageReceived -= OnMessage;
    }
}
