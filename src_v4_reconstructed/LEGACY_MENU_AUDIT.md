# Dragonboy250 v4.0 — exact legacy menu coverage audit

Recovered from the original `nro.N` bytecode. The horizontal menu uses the **same command IDs and Integer payloads** as the old menu.

Navigation-only old menu entries (`Tiện ích`, `Chức năng`, `Auto Item`, `Auto Đậu`, `Auto Login`, `Chức Năng Đệ Tử`, `Cài đặt`, etc.) are flattened into their leaf actions. No feature command is replaced by a guessed ID.

## Coverage

- Static leaf actions exposed by the old mod menus: **72 command/payload actions**.
- Horizontal menu coverage: **72/72**.
- `Khoá Mục Tiêu` keeps original command `25`; it opens the original dynamic character list, whose selected rows use command `26` with a runtime `Char` object.
- `Chuyển khu` keeps original command `4`; the game's dynamic zone list remains handled by the original game code.
- `Hướng dẫn` keeps original command `1010` and opens the original guide.

## Exact mapping

| New group | Menu action | Original source | Command | Payload |
|---|---|---|---:|---:|
| Tàn Sát | Tàn Sát | `N.bt()` | `8` | — |
| Tàn Sát | KC Tàn Sát | `N.bF()` | `83` | — |
| Auto Skill | Auto Skill | `N.bA()` | `64` | — |
| Nhặt Đồ | Auto Nhặt | `N.bu()` | `40` | — |
| Nhặt Đồ | Lọc Đồ | `N.bu()` | `41` | — |
| Nhặt Đồ | Nhặt Đồ | `N.bA()` | `60` | — |
| Nhặt Đồ | Cài Lọc Đồ | `N.bA()` | `65` | — |
| Nhặt Đồ | KC Nhặt | `N.bF()` | `82` | — |
| Xmap | Di chuyển | `N.bt()` | `5` | — |
| Xmap | Xmap | `N.bA()` | `77` | — |
| Xmap | Delay Xmap | `N.bF()` | `73` | — |
| Xmap | Chuyển khu | `N.bt()` | `4` | — |
| Boss | Săn Boss | `N.bA()` | `66` | — |
| Boss | Né Boss | `N.bz()` | `49` | — |
| TĐLT / NV | Tự Động Luyện Tập | `N.bA()` | `81` | — |
| TĐLT / NV | Đánh quái | `N.bA()` | `59` | — |
| TĐLT / NV | Đánh Chuyển Mục Tiêu | `N.bA()` | `62` | — |
| TĐLT / NV | Thoát Khi Đủ SM | `N.bz()` | `47` | — |
| TĐLT / NV | Khoá Vị Trí | `N.bz()` | `50` | — |
| Đậu | Xin Đậu | `N.by()` | `53` | — |
| Đậu | Cho Đậu | `N.by()` | `54` | — |
| Đậu | Thu Đậu | `N.by()` | `55` | — |
| Đậu | Buff Đậu | `N.bA()` | `58` | — |
| Hỗ Trợ | Tự Kết Nối | `N.bE()` | `30` | — |
| Hỗ Trợ | Vào Lại Khu | `N.bE()` | `31` | — |
| Hỗ Trợ | Delay Login | `N.bF()` | `74` | — |
| Hỗ Trợ | Goback | `N.bu()` | `56` | — |
| Hỗ Trợ | Auto Chat | `N.bA()` | `57` | — |
| Hỗ Trợ | Auto Kaioken | `N.bA()` | `63` | — |
| Hỗ Trợ | Auto Kaioken Bật/Tắt | `N.bz()` | `48` | — |
| Hỗ Trợ | Điều Khiển Từ Xa | `N.bA()` | `75` | — |
| Hỗ Trợ | Auto On-Off | `N.bA()` | `76` | — |
| Hỗ Trợ | Treo Cờ Chống PK | `N.bz()` | `46` | — |
| Hỗ Trợ | Đệ: Quái gần nhất | `N.bB()` | `44` | 0 |
| Hỗ Trợ | Đệ: Đánh sư phụ | `N.bB()` | `44` | 1 |
| Hỗ Trợ | Đệ: Đánh đệ tử | `N.bB()` | `44` | 2 |
| Hỗ Trợ | Tắt Đánh Khi Đệ Kêu | `N.bz()` | `45` | — |
| Vật Phẩm | Capsule | `N.bt()` | `2` | — |
| Vật Phẩm | Bông tai | `N.bt()` | `3` | — |
| Vật Phẩm | Cuồng Nộ | `N.bq()` | `33` | — |
| Vật Phẩm | Bổ Huyết | `N.bq()` | `34` | — |
| Vật Phẩm | Bổ Khí | `N.bq()` | `35` | — |
| Vật Phẩm | Giáp Xên | `N.bq()` | `36` | — |
| Vật Phẩm | Ẩn Danh | `N.bq()` | `37` | — |
| Vật Phẩm | Khẩu Trang | `N.bq()` | `38` | — |
| Vật Phẩm | Máy Dò | `N.bq()` | `39` | — |
| Vật Phẩm | List Item | `N.bq()` | `101` | — |
| Vật Phẩm | Porata | `N.bA()` | `61` | — |
| Hiển Thị | Thông Báo Boss | `N.br()` | `11` | — |
| Hiển Thị | Người Trong Map | `N.br()` | `12` | — |
| Hiển Thị | Thông Tin Sư Phụ | `N.br()` | `13` | — |
| Hiển Thị | Thông Tin Đệ Tử | `N.br()` | `14` | — |
| Hiển Thị | Thông Tin Up | `N.br()` | `78` | — |
| Hiển Thị | Check Thông Tin | `N.br()` | `80` | — |
| Hiển Thị | Ẩn Người | `N.bs()` | `16` | — |
| Hiển Thị | Ẩn Quái | `N.bs()` | `17` | — |
| Hiển Thị | Ẩn Item | `N.bs()` | `18` | — |
| Hiển Thị | Hào Quang | `N.bv()` | `20` | — |
| Hiển Thị | Bom & QCKK | `N.bv()` | `21` | — |
| Hiển Thị | Hợp Thể | `N.bv()` | `22` | — |
| Hiển Thị | Thái Dương Hạ San | `N.bv()` | `68` | — |
| Hiển Thị | Ảnh Nền | `N.bA()` | `79` | — |
| Hiển Thị | Màu Nền | `N.bF()` | `70` | — |
| Cài Đặt | Cộng HP | `N.a(23) submenu CỘNG TIỀM NĂNG` | `24` | 0 |
| Cài Đặt | Cộng KI | `N.a(23) submenu CỘNG TIỀM NĂNG` | `24` | 1 |
| Cài Đặt | Cộng Sức Đánh | `N.a(23) submenu CỘNG TIỀM NĂNG` | `24` | 2 |
| Cài Đặt | Cộng Giáp | `N.a(23) submenu CỘNG TIỀM NĂNG` | `24` | 3 |
| Cài Đặt | Khoá Mục Tiêu | `N.bp()` | `25` | — |
| Cài Đặt | Huỷ Khoá Mục Tiêu | `N.bp()` | `27` | — |
| Cài Đặt | Tốc Chạy | `N.bF()` | `71` | — |
| Cài Đặt | Tốc Game | `N.bF()` | `72` | — |
| Cài Đặt | Hướng dẫn | `N.bt() → N.bw()` | `1010` | — |

## Old navigation commands intentionally not shown as duplicate actions

These commands only opened another old vertical menu and are therefore replaced by the corresponding leaf actions above: `9`, `10`, `15`, `19`, `23`, `28`, `29`, `32`, `42`, `43`, `52`, `69`, `200`.

`23` is replaced by command `24` with payloads `0=HP`, `1=KI`, `2=Sức Đánh`, `3=Giáp`. `43` is replaced by command `44` with payloads `0=Quái gần nhất`, `1=Sư Phụ`, `2=Đệ Tử`; command `45` remains the original disable action.

## Legacy submenu suppression

Many toggle commands automatically called their old vertical submenu again after changing state (`bq`, `br`, `bs`, `bv`, `bu`, `by`, `bz`, `bE`, etc.). The patcher now suppresses those reopen calls **only while the horizontal menu is visible**, preventing the old menu from popping back over the new one.
