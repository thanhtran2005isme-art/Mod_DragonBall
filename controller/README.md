# Dragon Controller UI

WinForms controller scaffold matching the supplied account-manager reference.

## Current UI

- Top tabs: Tài khoản, Điều khiển, Cài đặt mặc định, Cài đặt phím tắt.
- Account DataGridView with ID, account, server, note, size and status.
- Search/filter.
- Password masking + reveal toggle.
- Server selection.
- Add / edit / delete.
- Multi-row selection.
- Import text accounts using `username|password|server|note`.
- Double-click account / Đăng nhập launches the original `microemulator-2.0.4.jar` directly; one MicroEmulator process is created per selected account.
- Close selected / close all status placeholders.
- Summary bar with total / running / selected counts.

## Run

From repository root:

```bat
controller-run.bat
```

Requires .NET 10 SDK.

The WinForms project targets:

```text
net10.0-windows
```

## Next integration

The `RequestLogin(AccountProfile)` method is intentionally the seam for:

```text
Account row
  -> GameLauncher
  -> unique sessionId
  -> AngelChip/MicroEmulator client
  -> J2ME RemoteBridge
  -> server/account/password
  -> login
  -> realtime status back to controller
```

Passwords are still in-memory only in this UI scaffold. Persistence should use SQLite + Windows DPAPI rather than plain text.


## Launcher

Dragon Controller now uses only the original MicroEmulator. It does not start or depend on `MicroEmulatorRemoter_v103.exe` or `AngelChipEmulator_AutoSleep.jar`.

For every selected account:

```text
java -jar microemulator-2.0.4.jar Dragonboy250-test.jar
```

is started as a separate process.

The game JAR defaults to:

```text
%USERPROFILE%\Desktop\EmulatorRemoter\Dragonboy250-test.jar
```

Original MicroEmulator is searched in:

```text
%USERPROFILE%\Desktop\EmulatorRemoter\microemulator-2.0.4.jar
%USERPROFILE%\Desktop\EmulatorRemoter\MicroEmulator\microemulator-2.0.4.jar
<repo>\lib\microemulator-2.0.4.jar
```
