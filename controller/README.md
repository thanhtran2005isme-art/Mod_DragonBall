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


## Direct controller auto-login

The account launcher now starts each MicroEmulator JVM with per-process properties:

```text
-Ddragon.auto.login=1
-Ddragon.auto.user=<account>
-Ddragon.auto.pass=<password>
-Ddragon.auto.server=<server>
```

The patched game reads these properties internally. It selects the requested
server through the original `bR` server-list state machine and lets the
original login flow call `bb.fk()`. Account/password RMS reads are overridden
per JVM, avoiding keyboard automation and avoiding credential mix-ups when
multiple clients start at once.

After updating the repository, rebuild `Dragonboy250-test.jar` with
`build-run.bat` before testing controller auto-login.


## Real game server catalog

The account server ComboBox is no longer populated with a guessed "Vũ trụ 1..20" list.

Dragon Controller now reads MicroEmulator's RMS files and parses the same
`NRlink3` server records used by the obfuscated game class `nro.bR`.
Each parsed row comes from the game's persisted server data:

```text
name | host | port | language | metadata...
```

This preserves special server names such as `Võ đài liên vũ trụ`,
`Super 1`, `VIP 2`, etc. when they are present in the game data.

If the dropdown says `(Chưa đọc được server từ game)`, run the patched game
once in original MicroEmulator so its current server catalog is persisted, then
open the dropdown again.


## Persistent accounts

Account data is now loaded automatically when Dragon Controller starts and
saved after Add / Edit / Delete / Import and again when the controller closes.

Storage path:

```text
%LOCALAPPDATA%\DragonController\accounts.json
```

Passwords are not stored as plain text. They are encrypted with Windows DPAPI
(`CurrentUser`) before being written to disk, so the saved credential blob is
bound to the current Windows user.

## Auto-login fix

Controller auto-login now invokes the same game flow as pressing `Chơi TK`:

```text
select server -> bR.gB() -> bR.ef() -> original connect/login logic
```

This replaces the previous timer/flag approach that could stop after account
and server were filled without actually starting login.


## Automatic retry when a server is overloaded

Controller-launched game clients now retry the login automatically only when
the game receives an overload response such as:

```text
Hệ thống đang quá tải, vui lòng thử lại sau ít phút.
```

Implementation details:

```text
login
  -> overload popup intercepted inside nro.aE
  -> blocking OK popup is suppressed
  -> wait ~1.2s + 0..400ms deterministic jitter
  -> call the original server select + "Chơi TK" login path again
  -> repeat until the real gameplay screen nro.aL is running
  -> stop retry permanently for that client
```

Wrong-password, banned-account, maintenance and unrelated messages are not
consumed and continue through the original game UI.

The launcher currently passes:

```text
-Ddragon.auto.retry.overload=1
-Ddragon.auto.retry.ms=1200
-Ddragon.auto.retry.jitter=400
-Ddragon.auto.retry.max=0
```

where `retry.max=0` means unlimited overload retries.


## Skip the MicroEmulator Launcher screen

Controller no longer starts the game as:

```text
java -jar microemulator-2.0.4.jar Dragonboy250-test.jar
```

because that opens MicroEmulator's built-in Launcher and requires pressing
`Start`.

It now starts the MIDlet class directly:

```text
java -cp "microemulator-2.0.4.jar;Dragonboy250-test.jar" \
  org.microemu.app.Main --resizableDevice <width> <height> nro.GameMidlet
```

This bypasses the Launcher list/Start screen and goes straight into
`nro.GameMidlet`. Width/height come from the account's `K.thước` field.


## Login cooldown + idle disconnect hardening

Two behaviors observed on crowded servers are now handled separately:

```text
"quá tải"
  -> retry after 3 seconds

"vui lòng chờ 30s" (or another numeric wait)
  -> do NOT keep spamming
  -> wait the server-requested number of seconds + 1 second safety margin
  -> retry after that cooldown
```

The 30-second response is treated as a server login cooldown/rate-limit, not as
proof that the character is already fully inside gameplay.

For controller-launched clients, the gameplay hook also watches the character
position. If it has not changed for 5 seconds, it sends one current-position
packet using the game's original `cM.ig()` movement implementation. This is
intended to keep an otherwise idle socket active without visibly moving the
character. Real movement resets the timer.

Launcher properties:

```text
-Ddragon.auto.retry.ms=3000
-Ddragon.auto.retry.jitter=0
-Ddragon.auto.retry.cooldown=1
-Ddragon.auto.idle.pulse.ms=5000
```
