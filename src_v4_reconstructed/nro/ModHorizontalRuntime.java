package nro;

import java.util.Vector;
import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Graphics;

/**
 * Compact horizontal replacement for the original Dragonboy250 v4.0 mod menus.
 *
 * Static menu actions keep the exact recovered command IDs/payloads. Any legacy
 * side-panel submenu that is still created by the original code is captured at
 * aB.dw() and rendered inside this horizontal overlay instead of being shown as
 * the old vertical panel. The captured cw objects are executed unchanged, so
 * dynamic Xmap/zone/target/item lists keep their original data and behavior.
 */
public final class ModHorizontalRuntime {
    private static final int NO_PAYLOAD = -2147483648;

    private static boolean visible;
    private static int group;
    private static int item;
    private static boolean actionFocus;
    private static int tabScroll;
    private static int itemScroll;
    private static int lastW;
    private static int lastH;

    private static boolean legacyMode;
    private static Vector legacyItems;
    private static String legacyTitle = "";
    private static int legacyGeneration;

    // One-shot automatic login state for controller-launched MicroEmulator JVMs.
    private static boolean autoLoginTriggered;
    private static int autoLoginWait;

    private static final String[] GROUPS = new String[] {
        "Tàn Sát", "Auto Skill", "Nhặt Đồ", "Xmap", "Boss",
        "TĐLT / NV", "Đậu", "Hỗ Trợ", "Vật Phẩm", "Hiển Thị", "Cài Đặt"
    };

    private static final String[][] ITEMS = new String[][] {
        {"Tàn Sát", "KC Tàn Sát"},
        {"Auto Skill"},
        {"Auto Nhặt", "Lọc Đồ", "Nhặt Đồ", "Cài Lọc Đồ", "KC Nhặt"},
        {"Di chuyển", "Xmap", "Delay Xmap", "Chuyển khu"},
        {"Săn Boss", "Né Boss"},
        {"Tự Động Luyện Tập", "Đánh quái", "Đánh Chuyển Mục Tiêu", "Thoát Khi Đủ SM", "Khoá Vị Trí"},
        {"Xin Đậu", "Cho Đậu", "Thu Đậu", "Buff Đậu"},
        {"Tự Kết Nối", "Vào Lại Khu", "Delay Login", "Goback", "Auto Chat", "Auto Kaioken", "Auto Kaioken Bật/Tắt", "Điều Khiển Từ Xa", "Auto On-Off", "Treo Cờ Chống PK", "Đệ: Quái gần nhất", "Đệ: Đánh sư phụ", "Đệ: Đánh đệ tử", "Tắt Đánh Khi Đệ Kêu"},
        {"Capsule", "Bông tai", "Cuồng Nộ", "Bổ Huyết", "Bổ Khí", "Giáp Xên", "Ẩn Danh", "Khẩu Trang", "Máy Dò", "List Item", "Porata"},
        {"Thông Báo Boss", "Người Trong Map", "Thông Tin Sư Phụ", "Thông Tin Đệ Tử", "Thông Tin Up", "Check Thông Tin", "Ẩn Người", "Ẩn Quái", "Ẩn Item", "Hào Quang", "Bom & QCKK", "Hợp Thể", "Thái Dương Hạ San", "Ảnh Nền", "Màu Nền"},
        {"Cộng HP", "Cộng KI", "Cộng Sức Đánh", "Cộng Giáp", "Khoá Mục Tiêu", "Huỷ Khoá Mục Tiêu", "Tốc Chạy", "Tốc Game", "Hướng dẫn"}
    };

    private static final int[][] COMMANDS = new int[][] {
        {8, 83},
        {64},
        {40, 41, 60, 65, 82},
        {5, 77, 73, 4},
        {66, 49},
        {81, 59, 62, 47, 50},
        {53, 54, 55, 58},
        {30, 31, 74, 56, 57, 63, 48, 75, 76, 46, 44, 44, 44, 45},
        {2, 3, 33, 34, 35, 36, 37, 38, 39, 101, 61},
        {11, 12, 13, 14, 78, 80, 16, 17, 18, 20, 21, 22, 68, 79, 70},
        {24, 24, 24, 24, 25, 27, 71, 72, 1010}
    };

    private static final int[][] PAYLOADS = new int[][] {
        {NO_PAYLOAD, NO_PAYLOAD},
        {NO_PAYLOAD},
        {NO_PAYLOAD, NO_PAYLOAD, NO_PAYLOAD, NO_PAYLOAD, NO_PAYLOAD},
        {NO_PAYLOAD, NO_PAYLOAD, NO_PAYLOAD, NO_PAYLOAD},
        {NO_PAYLOAD, NO_PAYLOAD},
        {NO_PAYLOAD, NO_PAYLOAD, NO_PAYLOAD, NO_PAYLOAD, NO_PAYLOAD},
        {NO_PAYLOAD, NO_PAYLOAD, NO_PAYLOAD, NO_PAYLOAD},
        {NO_PAYLOAD, NO_PAYLOAD, NO_PAYLOAD, NO_PAYLOAD, NO_PAYLOAD, NO_PAYLOAD, NO_PAYLOAD, NO_PAYLOAD, NO_PAYLOAD, NO_PAYLOAD, 0, 1, 2, NO_PAYLOAD},
        {NO_PAYLOAD, NO_PAYLOAD, NO_PAYLOAD, NO_PAYLOAD, NO_PAYLOAD, NO_PAYLOAD, NO_PAYLOAD, NO_PAYLOAD, NO_PAYLOAD, NO_PAYLOAD, NO_PAYLOAD},
        {NO_PAYLOAD, NO_PAYLOAD, NO_PAYLOAD, NO_PAYLOAD, NO_PAYLOAD, NO_PAYLOAD, NO_PAYLOAD, NO_PAYLOAD, NO_PAYLOAD, NO_PAYLOAD, NO_PAYLOAD, NO_PAYLOAD, NO_PAYLOAD, NO_PAYLOAD, NO_PAYLOAD},
        {0, 1, 2, 3, NO_PAYLOAD, NO_PAYLOAD, NO_PAYLOAD, NO_PAYLOAD, NO_PAYLOAD}
    };

    private static final boolean[][] CLOSE_AFTER = new boolean[][] {
        {false, true},
        {true},
        {false, false, true, true, true},
        {false, true, true, true},
        {true, false},
        {true, true, true, true, false},
        {false, false, false, true},
        {false, false, true, false, true, true, false, true, true, false, false, false, false, false},
        {false, false, false, false, false, false, false, false, false, true, true},
        {false, false, false, false, false, false, false, false, false, false, false, false, false, true, true},
        {false, false, false, false, true, false, true, true, true}
    };

    private ModHorizontalRuntime() {
    }

    public static void open() {
        visible = true;
        actionFocus = false;
        item = 0;
        itemScroll = 0;
        clearLegacyMode();
    }

    public static boolean isVisible() {
        return visible;
    }

    public static boolean blockLegacyMenu() {
        return visible;
    }

    public static boolean captureLegacyMenu(Vector source, String title) {
        if (!visible) return false;
        if (source == null || source.size() <= 0) return false;

        Vector copy = new Vector();
        for (int i = 0; i < source.size(); i++) {
            Object row = source.elementAt(i);
            if (row instanceof cw) copy.addElement(row);
        }

        if (copy.size() <= 0) return false;

        legacyItems = copy;
        legacyTitle = title == null ? "" : title;
        legacyMode = true;
        actionFocus = true;
        item = 0;
        itemScroll = 0;
        legacyGeneration++;
        return true;
    }

    private static void clearLegacyMode() {
        legacyMode = false;
        legacyItems = null;
        legacyTitle = "";
    }


    /**
     * Per-process RMS override used by controller-launched clients. This makes
     * each MicroEmulator JVM read its own account/password from -D properties
     * instead of racing on the shared RMS files when many clients start.
     */
    public static String overrideRmsString(String key) {
        if (!autoLoginEnabled() || key == null) return null;

        if (key.equals(bH.ae)) {
            return safeProperty("dragon.auto.user");
        }

        if (key.equals(bH.L)) {
            return safeProperty("dragon.auto.pass");
        }

        return null;
    }

    /**
     * Called from the patched bR.cp() (ServerListScreen update). Once the
     * current server list is available, select the requested server and reuse
     * the game's own delayed login path: bR.gB() -> bb.fk().
     */
    public static void autoLoginTick(bR serverScreen) {
        if (autoLoginTriggered || serverScreen == null || !autoLoginEnabled()) return;

        String user = safeProperty("dragon.auto.user");
        String pass = safeProperty("dragon.auto.pass");
        String requestedServer = safeProperty("dragon.auto.server");

        if (user == null || user.trim().length() == 0) return;
        if (pass == null || pass.length() == 0) return;

        String[] servers = bR.y;
        if (servers == null || servers.length == 0) {
            autoLoginWait++;
            return;
        }

        int serverIndex = resolveServerIndex(servers, requestedServer);
        if (serverIndex < 0 || serverIndex >= servers.length) {
            autoLoginWait++;
            return;
        }

        // Keep the original game's server/login state machine. bR.a(index,true)
        // selects + persists the server; aZ/fU starts the existing delayed path
        // which connects, creates the login screen and invokes bb.fk().
        bR.a(serverIndex, true);
        bR.fU = 0;
        bR.aZ = true;
        autoLoginTriggered = true;
    }

    private static boolean autoLoginEnabled() {
        String enabled = safeProperty("dragon.auto.login");
        return "1".equals(enabled);
    }

    private static String safeProperty(String name) {
        try {
            return System.getProperty(name);
        } catch (Throwable ignored) {
            return null;
        }
    }

    private static int resolveServerIndex(String[] servers, String requested) {
        if (servers == null || servers.length == 0) return -1;
        if (requested == null) return -1;

        requested = requested.trim();
        if (requested.length() == 0) return -1;

        for (int i = 0; i < servers.length; i++) {
            String current = servers[i];
            if (current != null && requested.equals(current.trim())) return i;
        }

        int wantedNumber = trailingNumber(requested);
        if (wantedNumber > 0) {
            for (int i = 0; i < servers.length; i++) {
                String current = servers[i];
                if (current != null && trailingNumber(current) == wantedNumber) return i;
            }

            // Server arrays are normally ordered Vũ trụ 1..N. This fallback
            // handles minor text differences while still respecting bounds.
            int ordinal = wantedNumber - 1;
            if (ordinal >= 0 && ordinal < servers.length) return ordinal;
        }

        return -1;
    }

    private static int trailingNumber(String value) {
        if (value == null) return -1;

        int end = value.length() - 1;
        while (end >= 0 && value.charAt(end) == ' ') end--;
        if (end < 0 || value.charAt(end) < '0' || value.charAt(end) > '9') return -1;

        int start = end;
        while (start >= 0) {
            char c = value.charAt(start);
            if (c < '0' || c > '9') break;
            start--;
        }

        try {
            return Integer.parseInt(value.substring(start + 1, end + 1));
        } catch (Exception ignored) {
            return -1;
        }
    }

    public static boolean onKeyPressed(int key) {
        if (!visible) return false;

        if (key == -7 || key == -6 || key == 27 || key == 48) {
            visible = false;
            clearLegacyMode();
            return true;
        }

        if (legacyMode) {
            if (isUp(key)) {
                clearLegacyMode();
                actionFocus = true;
                item = 0;
                itemScroll = 0;
            } else if (isLeft(key)) {
                if (item > 0) --item;
                ensureCurrentItemVisible(Font.getFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, Font.SIZE_SMALL), lastW);
            } else if (isRight(key)) {
                if (item + 1 < currentItemCount()) ++item;
                ensureCurrentItemVisible(Font.getFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, Font.SIZE_SMALL), lastW);
            } else if (isFire(key)) {
                activateSelected();
            }
            return true;
        }

        if (!actionFocus) {
            if (isLeft(key)) changeGroup(-1);
            else if (isRight(key)) changeGroup(1);
            else if (isDown(key) || isFire(key)) {
                actionFocus = true;
                item = 0;
                itemScroll = 0;
            }
            return true;
        }

        if (isUp(key)) {
            actionFocus = false;
        } else if (isLeft(key)) {
            if (item > 0) --item;
            ensureCurrentItemVisible(Font.getFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, Font.SIZE_SMALL), lastW);
        } else if (isRight(key)) {
            if (item + 1 < currentItemCount()) ++item;
            ensureCurrentItemVisible(Font.getFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, Font.SIZE_SMALL), lastW);
        } else if (isFire(key)) {
            activateSelected();
        }

        return true;
    }

    private static boolean isUp(int k) { return k == -1 || k == 50; }
    private static boolean isDown(int k) { return k == -2 || k == 56; }
    private static boolean isLeft(int k) { return k == -3 || k == 52; }
    private static boolean isRight(int k) { return k == -4 || k == 54; }
    private static boolean isFire(int k) { return k == -5 || k == 53 || k == 10 || k == 13; }

    private static void changeGroup(int delta) {
        group += delta;
        if (group < 0) group = GROUPS.length - 1;
        if (group >= GROUPS.length) group = 0;

        clearLegacyMode();
        item = 0;
        itemScroll = 0;
        actionFocus = false;
    }

    private static void activateSelected() {
        if (legacyMode) {
            if (legacyItems == null || item < 0 || item >= legacyItems.size()) return;
            Object row = legacyItems.elementAt(item);
            if (!(row instanceof cw)) return;

            int before = legacyGeneration;
            ((cw) row).ht();

            if (before == legacyGeneration) {
                visible = false;
                clearLegacyMode();
            }
            return;
        }

        if (group < 0 || group >= COMMANDS.length) return;
        if (item < 0 || item >= COMMANDS[group].length) return;

        int command = COMMANDS[group][item];
        int payload = PAYLOADS[group][item];
        boolean close = CLOSE_AFTER[group][item];
        int before = legacyGeneration;

        Object arg = payload == NO_PAYLOAD ? null : new Integer(payload);
        N.a().a(command, arg);

        if (before != legacyGeneration) return;
        if (close) visible = false;
    }

    public static boolean onPointerPressed(int px, int py) {
        if (!visible) return false;
        if (lastW <= 0 || lastH <= 0) return true;

        Font bold = Font.getFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_SMALL);
        Font plain = Font.getFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, Font.SIZE_SMALL);

        int panelY = lastH - panelHeight();
        int tabY = panelY + 2;
        int tabH = 25;

        if (py >= tabY && py <= tabY + tabH) {
            int x = 3 - tabScroll;

            for (int i = 0; i < GROUPS.length; i++) {
                int tw = tabWidth(bold, GROUPS[i]);

                if (px >= x && px < x + tw) {
                    group = i;
                    clearLegacyMode();
                    item = 0;
                    itemScroll = 0;
                    actionFocus = false;
                    ensureTabVisible(bold, lastW);
                    return true;
                }
                x += tw + 2;
            }
            return true;
        }

        int actionY = panelY + 30;
        int actionH = 36;

        if (py >= actionY && py <= actionY + actionH) {
            int x = 4 - itemScroll;
            int count = currentItemCount();

            for (int i = 0; i < count; i++) {
                String label = currentItemLabel(i);
                int iw = itemWidth(plain, label);

                if (px >= x && px < x + iw) {
                    actionFocus = true;
                    item = i;
                    ensureCurrentItemVisible(plain, lastW);
                    activateSelected();
                    return true;
                }
                x += iw + 3;
            }
        }

        return true;
    }

    public static boolean consumePointer() {
        return visible;
    }

    public static void paint(Graphics g) {
        if (!visible || g == null) return;

        int tx = g.getTranslateX();
        int ty = g.getTranslateY();
        if (tx != 0 || ty != 0) g.translate(-tx, -ty);

        int w = aE.a().getWidth();
        int h = aE.a().getHeight();

        if (w <= 0 || h <= 0) {
            if (tx != 0 || ty != 0) g.translate(tx, ty);
            return;
        }

        lastW = w;
        lastH = h;

        Font bold = Font.getFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_SMALL);
        Font plain = Font.getFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, Font.SIZE_SMALL);

        int panelH = panelHeight();
        int panelY = h - panelH;

        g.setClip(0, panelY, w, panelH);
        g.setColor(0xD8C7AA);
        g.fillRect(0, panelY, w, panelH);
        g.setColor(0x138EB7);
        g.fillRect(0, panelY, w, 2);

        ensureTabVisible(bold, w);

        int tabY = panelY + 2;
        int tabH = 25;
        int x = 3 - tabScroll;

        for (int i = 0; i < GROUPS.length; i++) {
            int tw = tabWidth(bold, GROUPS[i]);

            g.setColor(i == group ? 0xFFF1A6 : 0xF3C94F);
            g.fillRect(x, tabY, tw, tabH);
            g.setColor(0x73500D);
            g.drawRect(x, tabY, tw - 1, tabH - 1);

            if (!actionFocus && !legacyMode && i == group) {
                g.setColor(0xFFFFFF);
                g.drawRect(x + 2, tabY + 2, tw - 5, tabH - 5);
            }

            g.setFont(bold);
            g.setColor(0x3B2607);
            g.drawString(GROUPS[i], x + tw / 2, tabY + 6, Graphics.HCENTER | Graphics.TOP);
            x += tw + 2;
        }

        int actionY = panelY + 30;
        int actionH = 36;

        ensureCurrentItemVisible(plain, w);
        x = 4 - itemScroll;
        int count = currentItemCount();

        for (int i = 0; i < count; i++) {
            String label = currentItemLabel(i);
            int iw = itemWidth(plain, label);

            g.setColor(actionFocus && i == item ? 0xFFF5B5 : 0xF4E6CE);
            g.fillRect(x, actionY, iw, actionH);
            g.setColor(0x8A6B3E);
            g.drawRect(x, actionY, iw - 1, actionH - 1);

            if (actionFocus && i == item) {
                g.setColor(0xFFFFFF);
                g.drawRect(x + 2, actionY + 2, iw - 5, actionH - 5);
            }

            g.setFont(plain);
            g.setColor(0x402B0C);
            g.drawString(label, x + iw / 2, actionY + 10, Graphics.HCENTER | Graphics.TOP);
            x += iw + 3;
        }

        g.setFont(plain);
        g.setColor(0xFFFFFF);
        String help;
        if (legacyMode) help = "< > chon   OK mo   ^ tro lai   0 dong";
        else if (actionFocus) help = "< > chuc nang   ^ nhom   OK chon   0 dong";
        else help = "< > doi nhom   v vao nhom   0 dong";
        g.drawString(help, 4, h - 2, Graphics.LEFT | Graphics.BOTTOM);

        g.setClip(0, 0, w, h);
        if (tx != 0 || ty != 0) g.translate(tx, ty);
    }

    private static int currentItemCount() {
        if (legacyMode && legacyItems != null) return legacyItems.size();
        return ITEMS[group].length;
    }

    private static String currentItemLabel(int index) {
        if (legacyMode && legacyItems != null) {
            if (index < 0 || index >= legacyItems.size()) return "";
            Object row = legacyItems.elementAt(index);
            if (row instanceof cw) {
                String s = row.toString();
                if (s == null) return "";
                return s.replace('\n', ' ');
            }
            return "";
        }
        return ITEMS[group][index];
    }

    private static int panelHeight() { return 82; }

    private static int tabWidth(Font f, String s) {
        int tw = f.stringWidth(s) + 16;
        return tw < 68 ? 68 : tw;
    }

    private static int itemWidth(Font f, String s) {
        int iw = f.stringWidth(s) + 22;
        return iw < 105 ? 105 : iw;
    }

    private static void ensureTabVisible(Font f, int width) {
        if (width <= 0) return;

        int left = 3;
        for (int i = 0; i < group; i++) left += tabWidth(f, GROUPS[i]) + 2;
        int right = left + tabWidth(f, GROUPS[group]);

        if (left < tabScroll + 3) tabScroll = left - 3;
        else if (right > tabScroll + width - 3) tabScroll = right - width + 3;
        if (tabScroll < 0) tabScroll = 0;
    }

    private static void ensureCurrentItemVisible(Font f, int width) {
        if (width <= 0) return;

        int count = currentItemCount();
        if (count <= 0) {
            item = 0;
            itemScroll = 0;
            return;
        }

        if (item < 0) item = 0;
        if (item >= count) item = count - 1;

        int left = 4;
        for (int i = 0; i < item; i++) left += itemWidth(f, currentItemLabel(i)) + 3;
        int right = left + itemWidth(f, currentItemLabel(item));

        if (left < itemScroll + 4) itemScroll = left - 4;
        else if (right > itemScroll + width - 4) itemScroll = right - width + 4;
        if (itemScroll < 0) itemScroll = 0;
    }
}
