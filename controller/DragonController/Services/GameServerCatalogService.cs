using System.Text;
using DragonController.Models;

namespace DragonController.Services;

/// <summary>
/// Reads the server catalog that Dragon Boy itself persisted through
/// MicroEmulator RMS. Nothing is hard-coded: names such as "Super 1",
/// "VIP 2", etc. come from the same NRlink3 binary data used by nro.bR.
/// </summary>
internal sealed class GameServerCatalogService
{
    private const int MaxFileBytes = 12 * 1024 * 1024;

    public IReadOnlyList<GameServerInfo> LoadServers()
    {
        Candidate? best = null;

        foreach (var file in EnumerateRmsFiles())
        {
            byte[] data;
            try
            {
                var info = new FileInfo(file);
                if (!info.Exists || info.Length < 16 || info.Length > MaxFileBytes)
                    continue;

                data = File.ReadAllBytes(file);
            }
            catch
            {
                continue;
            }

            for (var offset = 0; offset + 8 < data.Length; offset++)
            {
                if (!TryReadModifiedUtf8(data, offset, out var firstName, out _))
                    continue;

                if (!LooksLikeServerName(firstName))
                    continue;

                if (!TryParseServerSequence(data, offset, file, out var servers))
                    continue;

                if (servers.Count < 3)
                    continue;

                var score = servers.Count * 100;
                if (Normalize(servers[0].Name) == Normalize("Vũ trụ 1"))
                    score += 5000;
                if (servers.Any(x => x.Name.StartsWith("Super ", StringComparison.OrdinalIgnoreCase)))
                    score += 300;
                if (servers.Any(x => x.Name.StartsWith("VIP ", StringComparison.OrdinalIgnoreCase)))
                    score += 300;

                var modified = SafeLastWriteUtc(file);
                if (best is null || score > best.Score || (score == best.Score && modified > best.ModifiedUtc))
                    best = new Candidate(servers, score, modified);
            }
        }

        return best?.Servers ?? Array.Empty<GameServerInfo>();
    }

    private static bool TryParseServerSequence(byte[] data, int offset, string sourcePath, out List<GameServerInfo> servers)
    {
        servers = new List<GameServerInfo>();
        var cursor = offset;

        for (var i = 0; i < 64; i++)
        {
            if (!TryReadModifiedUtf8(data, cursor, out var name, out cursor))
                break;
            if (!LooksLikeServerName(name) && servers.Count == 0)
                return false;
            if (!LooksLikeReasonableName(name))
                break;

            if (!TryReadModifiedUtf8(data, cursor, out var host, out cursor))
                break;
            if (!LooksLikeHost(host))
                break;

            if (cursor + 5 > data.Length)
                break;

            var port = (data[cursor] << 8) | data[cursor + 1];
            cursor += 2;
            if (port <= 0)
                break;

            var language = data[cursor++];
            var meta1 = data[cursor++];
            var meta2 = data[cursor++];

            servers.Add(new GameServerInfo
            {
                Name = name.Trim(),
                Host = host.Trim(),
                Port = port,
                Language = language,
                Meta1 = meta1,
                Meta2 = meta2,
                SourcePath = sourcePath
            });

            if (cursor + 4 >= data.Length)
                break;
        }

        return servers.Count > 0;
    }

    private static bool TryReadModifiedUtf8(byte[] data, int offset, out string value, out int next)
    {
        value = "";
        next = offset;

        if (offset < 0 || offset + 2 > data.Length)
            return false;

        var byteLength = (data[offset] << 8) | data[offset + 1];
        if (byteLength <= 0 || byteLength > 1024 || offset + 2 + byteLength > data.Length)
            return false;

        try
        {
            // Server names/hosts do not contain NUL, so Java modified UTF-8
            // is byte-compatible with normal UTF-8 for these strings.
            value = Encoding.UTF8.GetString(data, offset + 2, byteLength);
            next = offset + 2 + byteLength;
            return value.Length > 0 && !value.Contains('�');
        }
        catch
        {
            return false;
        }
    }

    private static bool LooksLikeServerName(string value)
    {
        var s = Normalize(value);
        return s.StartsWith(Normalize("Vũ trụ "), StringComparison.Ordinal) ||
               s.StartsWith(Normalize("Võ đài liên vũ trụ"), StringComparison.Ordinal) ||
               s.StartsWith("universe ", StringComparison.Ordinal) ||
               s.StartsWith("naga", StringComparison.Ordinal) ||
               s.StartsWith("super ", StringComparison.Ordinal) ||
               s.StartsWith("vip ", StringComparison.Ordinal);
    }

    private static bool LooksLikeReasonableName(string value)
    {
        if (string.IsNullOrWhiteSpace(value) || value.Length > 80)
            return false;

        foreach (var ch in value)
            if (char.IsControl(ch) && ch != '	')
                return false;

        return true;
    }

    private static bool LooksLikeHost(string value)
    {
        if (string.IsNullOrWhiteSpace(value) || value.Length > 255)
            return false;

        return value.Contains('.') || value.Contains(':') || value.Equals("localhost", StringComparison.OrdinalIgnoreCase);
    }

    private static string Normalize(string value) =>
        (value ?? "").Trim().ToLowerInvariant();

    private static DateTime SafeLastWriteUtc(string path)
    {
        try { return File.GetLastWriteTimeUtc(path); }
        catch { return DateTime.MinValue; }
    }

    private static IEnumerable<string> EnumerateRmsFiles()
    {
        var home = Environment.GetFolderPath(Environment.SpecialFolder.UserProfile);
        var appData = Environment.GetFolderPath(Environment.SpecialFolder.ApplicationData);
        var localData = Environment.GetFolderPath(Environment.SpecialFolder.LocalApplicationData);

        var roots = new[]
        {
            Path.Combine(home, ".microemulator"),
            Path.Combine(appData, ".microemulator"),
            Path.Combine(localData, ".microemulator")
        }
        .Distinct(StringComparer.OrdinalIgnoreCase)
        .Where(Directory.Exists);

        foreach (var root in roots)
        {
            IEnumerator<string>? iterator = null;
            try
            {
                iterator = Directory.EnumerateFiles(root, "*", SearchOption.AllDirectories).GetEnumerator();
                while (true)
                {
                    string current;
                    try
                    {
                        if (!iterator.MoveNext()) break;
                        current = iterator.Current;
                    }
                    catch
                    {
                        break;
                    }

                    yield return current;
                }
            }
            finally
            {
                iterator?.Dispose();
            }
        }
    }

    private sealed record Candidate(
        IReadOnlyList<GameServerInfo> Servers,
        int Score,
        DateTime ModifiedUtc);
}
