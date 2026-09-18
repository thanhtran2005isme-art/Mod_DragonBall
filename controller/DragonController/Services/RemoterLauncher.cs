using System.Diagnostics;
using DragonController.Models;

namespace DragonController.Services;

/// <summary>
/// Launches the original MicroEmulator directly. Dragon Controller no longer
/// starts or depends on MicroEmulatorRemoter_v103.exe / AngelChip.
/// </summary>
internal sealed class MicroEmulatorLauncher
{
    public string GamePath { get; set; }

    public MicroEmulatorLauncher()
    {
        var desktop = Environment.GetFolderPath(Environment.SpecialFolder.DesktopDirectory);
        GamePath = Path.Combine(desktop, "EmulatorRemoter", "Dragonboy250-test.jar");
    }

    /// <summary>
    /// Starts one original MicroEmulator process for each selected account.
    /// </summary>
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
            StartOne(java, microEmulatorJar, accounts[i], i + 1);

            // Tránh khởi động nhiều JVM đúng cùng một thời điểm.
            if (i + 1 < accounts.Count)
                Thread.Sleep(300);
        }
    }

    private void StartOne(string java, string microEmulatorJar, AccountProfile account, int clientNumber)
    {
        var psi = new ProcessStartInfo
        {
            FileName = java,
            WorkingDirectory = Path.GetDirectoryName(microEmulatorJar) ?? Environment.CurrentDirectory,
            UseShellExecute = false,
            CreateNoWindow = false
        };

        // Each JVM gets its own credentials/server. The patched game reads
        // these directly, so multiple MicroEmulator processes do not need
        // keyboard/mouse automation and do not share login credentials.
        psi.ArgumentList.Add("-Ddragon.auto.login=1");
        psi.ArgumentList.Add("-Ddragon.auto.user=" + account.Username);
        psi.ArgumentList.Add("-Ddragon.auto.pass=" + account.Password);
        psi.ArgumentList.Add("-Ddragon.auto.server=" + account.Server);

        // Retry only the specific server-overload response. Other login errors
        // are left to the game's normal popup/handling.
        psi.ArgumentList.Add("-Ddragon.auto.retry.overload=1");
        psi.ArgumentList.Add("-Ddragon.auto.retry.ms=1200");
        psi.ArgumentList.Add("-Ddragon.auto.retry.jitter=400");
        psi.ArgumentList.Add("-Ddragon.auto.retry.max=0");

        // IMPORTANT: passing the game JAR to "java -jar microemulator.jar"
        // opens MicroEmulator's Launcher screen and still requires pressing Start.
        // Put both JARs on the classpath and start nro.GameMidlet directly instead.
        // This bypasses Launcher completely.
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

        // Keep obviously broken profile values away from MicroEmulator.
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
