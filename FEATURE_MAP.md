# Dragonboy250 v4.0 — Feature/Class Map

> Mapping below is inferred from the actual bytecode and the 5,059 decoded string calls in the uploaded JAR. Obfuscated names are preserved because the original symbols were removed during obfuscation.

| Obfuscated class | Likely responsibility | Strong evidence from decoded strings |
|---|---|---|
| `nro.h` | Central mod command/config engine | `Auto TDLT`, `Auto skill`, `Auto nhặt`, `Auto chat`, `xmap`, `additem`, `delitem`, `listitem`, `Auto nhiệm vụ`, `DistanceAutoPick`, `DelayXmap`, `ItemConfig` |
| `nro.N` | Main mod menu / actions | `AUTO ITEM`, `Auto Login`, `Auto Đậu`, `Auto Kaioken`, `Né Boss`, `Auto Skill`, `Săn Boss`, `Auto On-Off`, `Xmap`, `KC Tàn Sát` |
| `nro.D` | Tàn Sát + Auto Skill list/state | add/remove target from `danh sách tàn sát`, `listSkillsAuto`, add/remove skill slot |
| `nro.E` | Auto worker thread | `Lỗi Auto:` |
| `nro.K` | Auto area/channel switching | `Đang auto vào khu`, timeout, successful area entry |
| `nro.i` | Xmap navigation | `XMAP - BẢN ĐỒ`, `XMAP - HÀNH TINH`, quest gate |
| `nro.w` | Boss list / Xmap target helper | `ListBoss`, `Xmap đến`, boss parsing |
| `nro.u` | Boss/Tàn Sát overlay painting | `PaintBoss`, `Tàn sát`, area display |
| `nro.R` | Item auto-config persistence/helper | `ItemConfig` |
| `nro.O` | Remove/visibility helper | `RemoveChar`, `RemoveMob`, `RemoveItem` |
| `nro.Q` | Boss/area switching status | `Đã thấy boss`, `Chuyển sang khu` |
| `nro.aB` | Inventory/item UI and item actions | item pick/ignore lists, use/remove item, auto-item list, `danh sách cho đậu` |
| `nro.aJ` | Network controller / packet decoder | map/item/skill version packets, `REQUEST MAP TEMPLATE`, `ADD ITEM TO MAP`, chat, skill events |
| `nro.aL` | Main gameplay screen | on-screen skills, current skill, `vItemMap`, chat UI, xmap command hook |
| `nro.bQ` | Language/resource strings | core game UI strings + `Chức năng auto` |
| `nro.dh` | AutoPlay/Tàn Sát settings form | `Setup_AutoPlay`, monster avoidance, area list |
| `nro.di` | TDLT settings form | `Setup_AutoTDLT`, `Auto TDLT` |
| `nro.dk` | Auto Skill settings form | `Setup_AutoSkill` |
| `nro.dl` | Character/bean buff settings | `Buff Đậu Sư Phụ`, `Buff Đậu Đệ Tử` |
| `nro.dm` | Boss attack settings | `Setup_AttackBoss`, boss filter, area switch, boss name/HP |
| `nro.do` | Item filter/sell/drop settings | `Setup_FilterItem`, item IDs to sell/drop |
| `nro.dp` | Xmap settings form | `Setup_Xmap`, `Xmap` |
| `nro.cX` | String obfuscation decoder | short table + XOR/index/key decode routine |
| `nro.GameMidlet` | MIDlet entry point | game bootstrap; decoded server host `112.213.94.23` |

## v4.0 feature hooks found in the JAR

The command parser in `nro.h` contains the newest visible hooks, including:

- `additem <id> <effectId>` / `delitem <id>` / `listitem`
- Auto nhiệm vụ
- Auto TDLT
- Auto Skill
- Auto Nhặt
- Auto Chat
- Auto item consumables
- Tàn Sát
- Xmap and Xmap delay
- Auto xin/cho/thu đậu
- Auto Kaioken
- Boss avoidance / boss focus / boss hunting
- Auto login and return-to-old-area behavior

For a new feature, start with `nro.h` (command/state), add menu exposure in `nro.N`, then connect gameplay behavior in the corresponding worker/helper (`D`, `E`, `i`, `w`, etc.). If the feature needs packets, inspect `nro.aJ`; if it needs drawing/input/gameplay state, inspect `nro.aL`.
