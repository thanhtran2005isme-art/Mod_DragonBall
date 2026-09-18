using System.Diagnostics;

namespace DragonController.Services;

internal sealed class RemoterLauncher
{
    public string RemoterPath { get; set; }
    public string EmulatorPath { get; set; }
    public string GamePath { get; set; }

    public RemoterLauncher()
    {
        var desktop = Environment.GetFolderPath(Environment.SpecialFolder.DesktopDirectory);
        var root = Path.Combine(desktop, "EmulatorRemoter");

        RemoterPath = Path.Combine(root, "MicroEmulatorRemoter_v103.exe");
        EmulatorPath = Path.Combine(root, "AngelChipEmulator_AutoSleep.jar");
        GamePath = Path.Combine(root, "Dragonboy250-test.jar");
    }

    public Process EnsureStarted()
    {
        ValidateFiles();

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
            return existing;
        }

        var process = Process.Start(new ProcessStartInfo
        {
            FileName = RemoterPath,
            WorkingDirectory = Path.GetDirectoryName(RemoterPath) ?? Environment.CurrentDirectory,
            UseShellExecute = true
        });

        if (process is null)
            throw new InvalidOperationException("Không thể mở MicroEmulatorRemoter.");

        try { process.WaitForInputIdle(5000); } catch { }
        TryBringToFront(process);
        return process;
    }

    private void ValidateFiles()
    {
        if (!File.Exists(RemoterPath))
            throw new FileNotFoundException("Không tìm thấy MicroEmulatorRemoter.", RemoterPath);

        if (!File.Exists(EmulatorPath))
            throw new FileNotFoundException("Không tìm thấy AngelChipEmulator_AutoSleep.jar.", EmulatorPath);

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
