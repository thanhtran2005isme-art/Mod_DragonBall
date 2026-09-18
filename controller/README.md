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
- Double-click account / Đăng nhập button prepared for the future GameLauncher.
- Close selected / close all status placeholders.
- Summary bar with total / running / selected counts.

## Run

From repository root:

```bat
controller-run.bat
```

Requires .NET 8 SDK.

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
