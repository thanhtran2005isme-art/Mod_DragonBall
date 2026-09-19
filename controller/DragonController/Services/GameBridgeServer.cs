using System.Collections.Concurrent;
using System.Net;
using System.Net.Sockets;
using System.Text;

namespace DragonController.Services;

internal sealed class GameBridgeMessage
{
    public int ClientId { get; init; }
    public string Type { get; init; } = "";
    public IReadOnlyList<string> Fields { get; init; } = Array.Empty<string>();
}

internal sealed class GameBridgeServer : IDisposable
{
    public const int DefaultPort = 38475;

    private sealed class ClientConnection : IDisposable
    {
        private readonly object _writeGate = new();

        public int ClientId { get; }
        public TcpClient TcpClient { get; }
        public StreamWriter Writer { get; }

        public ClientConnection(int clientId, TcpClient tcpClient, StreamWriter writer)
        {
            ClientId = clientId;
            TcpClient = tcpClient;
            Writer = writer;
        }

        public bool Send(string line)
        {
            lock (_writeGate)
            {
                try
                {
                    Writer.WriteLine(line);
                    Writer.Flush();
                    return true;
                }
                catch
                {
                    return false;
                }
            }
        }

        public void Dispose()
        {
            try { Writer.Dispose(); } catch { }
            try { TcpClient.Dispose(); } catch { }
        }
    }

    private readonly ConcurrentDictionary<int, ClientConnection> _clients = new();
    private readonly CancellationTokenSource _cts = new();
    private TcpListener? _listener;
    private Task? _acceptTask;

    public event Action<int>? ClientConnected;
    public event Action<int>? ClientDisconnected;
    public event Action<GameBridgeMessage>? MessageReceived;

    public IReadOnlyList<int> ConnectedClientIds =>
        _clients.Keys.OrderBy(x => x).ToArray();

    public void Start()
    {
        if (_listener is not null) return;

        _listener = new TcpListener(IPAddress.Loopback, DefaultPort);
        _listener.Start(64);
        _acceptTask = Task.Run(() => AcceptLoopAsync(_cts.Token));
    }

    public bool SendCommand(int clientId, int huntId, long sequence, string command, params string[] args)
    {
        if (!_clients.TryGetValue(clientId, out var client))
            return false;

        var fields = new List<string>
        {
            "CMD",
            huntId.ToString(),
            sequence.ToString(),
            command
        };
        fields.AddRange(args);

        var line = string.Join("|", fields.Select(Escape));
        if (client.Send(line)) return true;

        RemoveClient(clientId, client);
        return false;
    }

    private async Task AcceptLoopAsync(CancellationToken token)
    {
        while (!token.IsCancellationRequested)
        {
            TcpClient tcp;

            try
            {
                tcp = await _listener!.AcceptTcpClientAsync(token);
            }
            catch (OperationCanceledException)
            {
                return;
            }
            catch
            {
                if (token.IsCancellationRequested) return;
                await Task.Delay(250, token).ConfigureAwait(false);
                continue;
            }

            _ = Task.Run(() => ReadClientAsync(tcp, token), token);
        }
    }

    private async Task ReadClientAsync(TcpClient tcp, CancellationToken token)
    {
        ClientConnection? connection = null;

        try
        {
            tcp.NoDelay = true;
            tcp.Client.SetSocketOption(SocketOptionLevel.Socket, SocketOptionName.KeepAlive, true);

            using var reader = new StreamReader(
                tcp.GetStream(),
                new UTF8Encoding(false),
                detectEncodingFromByteOrderMarks: false,
                bufferSize: 4096,
                leaveOpen: true);

            var writer = new StreamWriter(
                tcp.GetStream(),
                new UTF8Encoding(false),
                bufferSize: 4096,
                leaveOpen: true)
            {
                AutoFlush = true,
                NewLine = "\n"
            };

            var helloLine = await reader.ReadLineAsync(token);
            if (helloLine is null) return;

            var hello = ParseLine(helloLine);
            if (hello.Count < 2 ||
                !string.Equals(hello[0], "HELLO", StringComparison.Ordinal) ||
                !int.TryParse(hello[1], out var clientId) ||
                clientId <= 0)
            {
                writer.Dispose();
                return;
            }

            connection = new ClientConnection(clientId, tcp, writer);

            if (_clients.TryGetValue(clientId, out var old))
            {
                _clients[clientId] = connection;
                old.Dispose();
            }
            else
            {
                _clients[clientId] = connection;
            }

            ClientConnected?.Invoke(clientId);

            while (!token.IsCancellationRequested)
            {
                var line = await reader.ReadLineAsync(token);
                if (line is null) break;

                var parts = ParseLine(line);
                if (parts.Count == 0) continue;

                MessageReceived?.Invoke(new GameBridgeMessage
                {
                    ClientId = clientId,
                    Type = parts[0],
                    Fields = parts.Skip(1).ToArray()
                });
            }
        }
        catch (OperationCanceledException)
        {
        }
        catch
        {
        }
        finally
        {
            if (connection is not null)
                RemoveClient(connection.ClientId, connection);
            else
                try { tcp.Dispose(); } catch { }
        }
    }

    private void RemoveClient(int clientId, ClientConnection expected)
    {
        if (_clients.TryGetValue(clientId, out var current) &&
            ReferenceEquals(current, expected) &&
            _clients.TryRemove(clientId, out var removed))
        {
            removed.Dispose();
            ClientDisconnected?.Invoke(clientId);
        }
    }

    private static string Escape(string value)
    {
        if (string.IsNullOrEmpty(value)) return "";

        return value
            .Replace("\\", "\\\\")
            .Replace("|", "\\p")
            .Replace("\r", "\\r")
            .Replace("\n", "\\n");
    }

    private static IReadOnlyList<string> ParseLine(string line)
    {
        var result = new List<string>();
        var current = new StringBuilder();
        var escaped = false;

        foreach (var c in line)
        {
            if (escaped)
            {
                current.Append(c switch
                {
                    'p' => '|',
                    'n' => '\n',
                    'r' => '\r',
                    '\\' => '\\',
                    _ => c
                });
                escaped = false;
                continue;
            }

            if (c == '\\')
            {
                escaped = true;
                continue;
            }

            if (c == '|')
            {
                result.Add(current.ToString());
                current.Clear();
                continue;
            }

            current.Append(c);
        }

        if (escaped) current.Append('\\');
        result.Add(current.ToString());
        return result;
    }

    public void Dispose()
    {
        _cts.Cancel();

        try { _listener?.Stop(); } catch { }

        foreach (var pair in _clients.ToArray())
            pair.Value.Dispose();

        _clients.Clear();

        try { _acceptTask?.Wait(500); } catch { }
        _cts.Dispose();
    }
}
