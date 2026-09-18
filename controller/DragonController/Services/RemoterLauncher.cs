using System.Diagnostics;

namespace DragonController.Services;

internal enum LauncherMode
{
    Remoter,
    OriginalMicroEmulator
}

internal sealed class RemoterLauncher
{
    public string RemoterPath { get; set; }
    public string AngelChipPath { get; set; }
    public string GamePath { get; set; }

    public RemoterLauncher()
    {
        var desktop = Environment.GetFolderPath(Environment.SpecialFolder.DesktopDirectory);
        var root = Path.Combine(desktop, "EmulatorRemoter");

        RemoterPath = Path.Combine(root, "MicroEmulatorRemoter_v103.exe");
        AngelChipPath = Path.Combine(root, "AngelChipEmulator_AutoSleep.jar");
        GamePath = Path.Combine(root, "Dragonboy250-test.jar");
    }

    /// <summary>
    /// Try MicroEmulatorRemoter first. If it is unavailable, fails to start, or
    /// exits immediately, automatically launch one original MicroEmulator
    /// process per selected account.
    /// </summary>
    public LauncherMode StartClients(int clientCount)
    {
        if (clientCount < 1) clientCount = 1;

        ValidateGame();

        try
        {
            if (TryStartRemoter())
                return LauncherMode.Remoter;
        }
        catch
        {
            // Fall through to the original MicroEmulator.
        }

        StartOriginalMicroEmulators(clientCount);
        return LauncherMode.OriginalMicroEmulator;
    }

    private bool TryStartRemoter()
    {
        if (!File.Exists(RemoterPath))
            return false;

        // AngelChip is only required by the Remoter path. If it is missing,
        // skip straight to original MicroEmulator.
        if (!File.Exists(AngelChipPath))
            return false;

        var processName = Path.GetFileNameWithoutExtension(RemoterPath);
        var existing = Process.GetProcessesByName(processName)
            .FirstOrDefault(p =>
            {
                try { return !p.HasExited; }
                catch { return false; }
            });

        if (existing is not null)
        {
            TryBringToFront(existing);
            return true;
        }

        var process = Process.Start(new ProcessStartInfo
        {
            FileName = RemoterPath,
            WorkingDirectory = Path.GetDirectoryName(RemoterPath) ?? Environment.CurrentDirectory,
            UseShellExecute = true
        });

        if (process is null)
            return false;

        // Some broken/incompatible Remoter builds start and terminate
        // immediately. Treat that as a startup failure and use MicroEmulator.
        try
        {
            if (process.WaitForExit(1200))
                return false;
        }
        catch
        {
            return false;
        }

        try { process.WaitForInputIdle(3000); } catch { }
        TryBringToFront(process);
        return true;
    }

    private void StartOriginalMicroEmulators(int count)
    {
        var microEmulatorJar = FindOriginalMicroEmulatorJar();
        if (microEmulatorJar is null)
        {
            throw new FileNotFoundException(
                "MicroEmulatorRemoter không mở được và cũng không tìm thấy microemulator-2.0.4.jar. " +
                "Hãy giữ file này trong thư mục lib của project hoặc Desktop\\EmulatorRemoter.");
        }

        var java = ResolveJavaExecutable();

        for (var i = 0; i < count; i++)
        {
            var psi = new ProcessStartInfo
            {
                FileName = java,
                WorkingDirectory = Path.GetDirectoryName(microEmulatorJar) ?? Environment.CurrentDirectory,
                UseShellExecute = false,
                CreateNoWindow = false
            };

            psi.ArgumentList.Add("-jar");
            psi.ArgumentList.Add(microEmulatorJar);
            psi.ArgumentList.Add(GamePath);

            var process = Process.Start(psi);
            if (process is null)
                throw new InvalidOperationException($"Không thể mở MicroEmulator gốc cho client {i + 1}.");

            // Small spacing avoids hammering the JVM when many accounts are selected.
            if (i + 1 < count)
                Thread.Sleep(250);
        }
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
            {
                candidates.Add(Path.Combine(dir.FullName, "lib", "microemulator-2.0.4.jar"));
            }
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
            "Không tìm thấy Java. Hãy cài JDK/JRE hoặc đặt JAVA_HOME trước khi mở MicroEmulator gốc.");
    }

    private void ValidateGame()
    {
        if (!File.Exists(GamePath))
            throw new FileNotFoundException("Không tìm thấy Dragonboy250-test.jar.", GamePath);
    }

    private static void TryBringToFront(Process process)
    {
        try
        {
            if (process.MainWindowHandle != IntPtr.Zero)
                NativeMethods.SetForegroundWindow(process.MainWindowHandle);
        }
        catch
        {
        }
    }

    private static class NativeMethods
    {
        [System.Runtime.InteropServices.DllImport("user32.dll")]
        [return: System.Runtime.InteropServices.MarshalAs(System.Runtime.InteropServices.UnmanagedType.Bool)]
        public static extern bool SetForegroundWindow(IntPtr hWnd);
    }
}
