# Horizontal grouped mod menu — v4.0 refactor

This branch starts the requested menu redesign: **horizontal category tabs + grouped functions + 2-column submenu**.

## What has been identified in the current v4.0 bytecode

The active mod menu is primarily in `nro.N`.

| v4.0 method | Current responsibility |
| --- | --- |
| `N.bt()` | Main vertical menu: Chuyển khu, Di chuyển, Tàn Sát, Tiện ích, Chức năng, Cài đặt, Hướng dẫn |
| `N.bu()` | Chức năng submenu |
| `N.bA()` | Cài đặt submenu |
| `N.bp()` | Tiện ích submenu |
| `N.bz()` | Chức năng Đệ Tử submenu |
| `N.bE()` | Auto Login submenu |
| `N.bF()` | Tùy chỉnh (speed/delay/distance) |
| `N.a(int,Object)` | Existing action dispatcher; this must be reused instead of rewriting feature logic |

The v4.0 menu also references image assets such as `/button/btn_B.png`, `btn_C.png`, `btn_G.png`, `btn_J.png`, `btn_K.png`, `btn_L.png`, `btn_S.png`, `btn_X.png`, `btn_Z.png` and `/mainImage/myTexture2dmenu.png`.

## New UI architecture

New files under `src_v4_reconstructed/nro/`:

- `HorizontalModMenu.java`: horizontal scrolling tabs, keypad/touch navigation, 2-column action grid.
- `ModMenuCatalog.java`: category and function grouping requested by the user.
- `ModMenuHandler.java`: tiny bridge interface.

The UI layer deliberately uses **action keys** rather than changing feature logic. The next integration step maps each action key back to the already-existing cases/methods in `N.a(int,Object)`.

## Group layout

1. Tàn Sát
2. Auto Skill
3. Nhặt Đồ
4. Xmap
5. Boss
6. TĐLT / NV
7. Đậu
8. Hỗ Trợ
9. Vật Phẩm
10. Hiển Thị
11. Cài Đặt

The tab bar scrolls horizontally when it is wider than the device screen. Each selected group opens a 2-column grid below it.

## Integration plan

1. Recover the concrete command IDs used by `N.bt()`, `N.bu()`, `N.bA()`, etc.
2. Add a small bridge in reconstructed `N` implementing `ModMenuHandler`.
3. Replace the entry point that currently calls `N.bt()` with `HorizontalModMenu.show()`.
4. Keep the original `N.a(int,Object)` dispatch path for every existing action.
5. Build a patched JAR and verify on both touch and keypad navigation.

**Important:** this commit is the first source-level refactor step. It does not yet replace `N.class` inside the game JAR.
