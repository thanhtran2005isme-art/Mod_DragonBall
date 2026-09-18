using System.Diagnostics;
using System.Text;
using DragonController.Models;

namespace DragonController.Services;

/// <summary>
/// Launches one original MicroEmulator process per account and maintains a
/// tiny file bridge used by the patched game:
///
///   *.autologin  controller -> game (1 / 0)
///   *.status     game -> controller (OFF / LOGGING_IN / ONLINE)
///   *.pid        controller bookkeeping
///
/// This keeps account status based on the real game screen/state rather than
/// guessing from the fact that a Java process exists.
/// </summary>
internal sealed class MicroEmulatorLauncher
{
    private readonly string _runtimeRoot;

    public string GamePath { get; set; }

    public MicroEmulatorLauncher()
    {
        var desktop = Environment.GetFolderPath(Environment.SpecialFolder.DesktopDirectory);
        GamePath = Path.Combine(desktop, "EmulatorRemoter", "Dragonboy250-test.jar");

        _runtimeRoot = Path.Combine(
            Environment.GetFolderPath(Environment.SpecialFolder.LocalApplicationData),
            "DragonController",
            "sessions");

        Directory.CreateDirectory(_runtimeRoot);
    }

    public void StartClients(IReadOnlyList<AccountProfile> accounts)
    {
        if (accounts is null || accounts.Count == 0) return;

        ValidateGame();

        var microEmulatorJar = FindOriginalMicroEmulatorJar();
        if (microEmulatorJar is null)
        {
            throw new FileNotFoundException(
                "Không tìm thấy microemulator-2.0.4.jar. " +
                "Hãy giữ file trong thư mục lib của project hoặc Desktop\\EmulatorRemoter.");
        }

        var java = ResolveJavaExecutable();

        for (var i = 0; i < accounts.Count; i++)
        {
            var account = accounts[i];

            // If this account already has a live client, only update Auto Login.
            // This avoids accidentally opening duplicate clients for one account.
            if (TryGetLiveProcess(account.Id, out _))
            {
                SetAutoLogin(account.Id, account.AutoLogin);
                continue;
            }

            StartOne(java, microEmulatorJar, account, i + 1);

            if (i + 1 < accounts.Count)
                Thread.Sleep(300);
        }
    }

    public void SetAutoLogin(int accountId, bool enabled)
    {
        WriteSmallFile(ControlPath(accountId), enabled ? "1" : "0");
    }

    public string GetGameStatus(int accountId)
    {
        if (!TryGetLiveProcess(accountId, out _))
        {
            TryDelete(PidPath(accountId));
            return "Off";
        }

        string raw;
        try
        {
            raw = File.Exists(StatusPath(accountId))
                ? File.ReadAllText(StatusPath(accountId), Encoding.ASCII).Trim()
                : "OFF";
        }
        catch
        {
            raw = "OFF";
        }

        return raw switch
        {
            "ONLINE" => "Đã đăng nhập",
            "LOGGING_IN" => "Đang đăng nhập",
            _ => "Off"
        };
    }

    public bool IsRunning(int accountId) => TryGetLiveProcess(accountId, out _);

    public void CloseClient(int accountId)
    {
        if (TryGetLiveProcess(accountId, out var process))
        {
            try
            {
                process.Kill(entireProcessTree: true);
                process.WaitForExit(2500);
            }
            catch
            {
            }
        }

        WriteSmallFile(StatusPath(accountId), "OFF");
        TryDelete(PidPath(accountId));
    }

    public void CloseAll(IEnumerable<AccountProfile> accounts)
    {
        foreach (var account in accounts)
            CloseClient(account.Id);
    }

    private void StartOne(string java, string microEmulatorJar, AccountProfile account, int clientNumber)
    {
        var statusPath = StatusPath(account.Id);
        var controlPath = ControlPath(account.Id);

        WriteSmallFile(statusPath, "OFF");
        WriteSmallFile(controlPath, account.AutoLogin ? "1" : "0");

        var psi = new ProcessStartInfo
        {
            FileName = java,
            WorkingDirectory = Path.GetDirectoryName(microEmulatorJar) ?? Environment.CurrentDirectory,
            UseShellExecute = false,
            CreateNoWindow = false
        };

        psi.ArgumentList.Add("-Ddragon.auto.login=" + (account.AutoLogin ? "1" : "0"));
        psi.ArgumentList.Add("-Ddragon.auto.login.file=" + controlPath);
        psi.ArgumentList.Add("-Ddragon.status.file=" + statusPath);
        psi.ArgumentList.Add("-Ddragon.auto.user=" + account.Username);
        psi.ArgumentList.Add("-Ddragon.auto.pass=" + account.Password);
        psi.ArgumentList.Add("-Ddragon.auto.server=" + account.Server);

        psi.ArgumentList.Add("-Ddragon.auto.retry.overload=1");
        psi.ArgumentList.Add("-Ddragon.auto.retry.ms=3000");
        psi.ArgumentList.Add("-Ddragon.auto.retry.jitter=0");
        psi.ArgumentList.Add("-Ddragon.auto.retry.max=0");
        psi.ArgumentList.Add("-Ddragon.auto.retry.cooldown=1");
        psi.ArgumentList.Add("-Ddragon.auto.idle.pulse.ms=5000");

        var classPath = microEmulatorJar + Path.PathSeparator + GamePath;
        var (width, height) = ParseWindowSize(account.WindowSize);

        psi.ArgumentList.Add("-cp");
        psi.ArgumentList.Add(classPath);
        psi.ArgumentList.Add("org.microemu.app.Main");
        psi.ArgumentList.Add("--resizableDevice");
        psi.ArgumentList.Add(width.ToString());
        psi.ArgumentList.Add(height.ToString());
        psi.ArgumentList.Add("nro.GameMidlet");

        var process = Process.Start(psi);
        if (process is null)
            throw new InvalidOperationException(
                $"Không thể mở MicroEmulator gốc cho client {clientNumber}.");

        WriteSmallFile(PidPath(account.Id), process.Id.ToString());
    }

    private bool TryGetLiveProcess(int accountId, out Process process)
    {
        process = null!;

        try
        {
            var pidPath = PidPath(accountId);
            if (!File.Exists(pidPath))
                return false;

            var text = File.ReadAllText(pidPath).Trim();
            if (!int.TryParse(text, out var pid) || pid <= 0)
                return false;

            var candidate = Process.GetProcessById(pid);
            if (candidate.HasExited)
                return false;

            process = candidate;
            return true;
        }
        catch
        {
            return false;
        }
    }

    private string StatusPath(int accountId) =>
        Path.Combine(_runtimeRoot, $"account-{accountId}.status");

    private string ControlPath(int accountId) =>
        Path.Combine(_runtimeRoot, $"account-{accountId}.autologin");

    private string PidPath(int accountId) =>
        Path.Combine(_runtimeRoot, $"account-{accountId}.pid");

    private static void WriteSmallFile(string path, string value)
    {
        var temp = path + ".tmp";
        File.WriteAllText(temp, value, Encoding.ASCII);
        File.Move(temp, path, true);
    }

    private static void TryDelete(string path)
    {
        try
        {
            if (File.Exists(path)) File.Delete(path);
        }
        catch
        {
        }
    }

    private static (int Width, int Height) ParseWindowSize(string? value)
    {
        const int defaultWidth = 1000;
        const int defaultHeight = 500;

        if (string.IsNullOrWhiteSpace(value))
            return (defaultWidth, defaultHeight);

        var normalized = value.Trim()
            .Replace('×', 'x')
            .Replace('X', 'x');

        var parts = normalized.Split('x', StringSplitOptions.RemoveEmptyEntries | StringSplitOptions.TrimEntries);
        if (parts.Length != 2 ||
            !int.TryParse(parts[0], out var width) ||
            !int.TryParse(parts[1], out var height))
        {
            return (defaultWidth, defaultHeight);
        }

        width = Math.Clamp(width, 240, 3840);
        height = Math.Clamp(height, 240, 2160);
        return (width, height);
    }

    private string? FindOriginalMicroEmulatorJar()
    {
        var desktop = Environment.GetFolderPath(Environment.SpecialFolder.DesktopDirectory);
        var candidates = new List<string>
        {
            Path.Combine(desktop, "EmulatorRemoter", "microemulator-2.0.4.jar"),
            Path.Combine(desktop, "EmulatorRemoter", "MicroEmulator", "microemulator-2.0.4.jar")
        };

        AddRepoCandidates(candidates, AppContext.BaseDirectory);
        AddRepoCandidates(candidates, Environment.CurrentDirectory);

        return candidates
            .Distinct(StringComparer.OrdinalIgnoreCase)
            .FirstOrDefault(File.Exists);
    }

    private static void AddRepoCandidates(List<string> candidates, string start)
    {
        try
        {
            var dir = new DirectoryInfo(start);
            for (var i = 0; dir is not null && i < 10; i++, dir = dir.Parent)
                candidates.Add(Path.Combine(dir.FullName, "lib", "microemulator-2.0.4.jar"));
        }
        catch
        {
        }
    }

    private static string ResolveJavaExecutable()
    {
        var javaHome = Environment.GetEnvironmentVariable("JAVA_HOME");
        if (!string.IsNullOrWhiteSpace(javaHome))
        {
            var javaw = Path.Combine(javaHome, "bin", "javaw.exe");
            if (File.Exists(javaw)) return javaw;

            var java = Path.Combine(javaHome, "bin", "java.exe");
            if (File.Exists(java)) return java;
        }

        var path = Environment.GetEnvironmentVariable("PATH") ?? "";
        foreach (var raw in path.Split(Path.PathSeparator))
        {
            var dir = raw.Trim().Trim('"');
            if (dir.Length == 0) continue;

            var javaw = Path.Combine(dir, "javaw.exe");
            if (File.Exists(javaw)) return javaw;

            var java = Path.Combine(dir, "java.exe");
            if (File.Exists(java)) return java;
        }

        throw new FileNotFoundException(
            "Không tìm thấy Java. Hãy cài JDK/JRE hoặc đặt JAVA_HOME trước khi mở MicroEmulator.");
    }

    private void ValidateGame()
    {
        if (!File.Exists(GamePath))
            throw new FileNotFoundException("Không tìm thấy Dragonboy250-test.jar.", GamePath);
    }
}
