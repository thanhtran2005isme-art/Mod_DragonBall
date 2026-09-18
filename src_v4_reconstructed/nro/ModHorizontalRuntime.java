package nro;

import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Graphics;

/**
 * Compact horizontal replacement for the original Dragonboy250 v4.0 mod menus.
 *
 * The command IDs and Integer payloads in this class were recovered from the
 * original nro.N bytecode. Navigation-only legacy commands are flattened into
 * their real leaf actions so the new UI does not lose or misroute features.
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

    private static final String[] GROUPS = new String[] {"Tàn Sát", "Auto Skill", "Nhặt Đồ", "Xmap", "Boss", "TĐLT / NV", "Đậu", "Hỗ Trợ", "Vật Phẩm", "Hiển Thị", "Cài Đặt"};

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
        {-2147483648, -2147483648},
        {-2147483648},
        {-2147483648, -2147483648, -2147483648, -2147483648, -2147483648},
        {-2147483648, -2147483648, -2147483648, -2147483648},
        {-2147483648, -2147483648},
        {-2147483648, -2147483648, -2147483648, -2147483648, -2147483648},
        {-2147483648, -2147483648, -2147483648, -2147483648},
        {-2147483648, -2147483648, -2147483648, -2147483648, -2147483648, -2147483648, -2147483648, -2147483648, -2147483648, -2147483648, 0, 1, 2, -2147483648},
        {-2147483648, -2147483648, -2147483648, -2147483648, -2147483648, -2147483648, -2147483648, -2147483648, -2147483648, -2147483648, -2147483648},
        {-2147483648, -2147483648, -2147483648, -2147483648, -2147483648, -2147483648, -2147483648, -2147483648, -2147483648, -2147483648, -2147483648, -2147483648, -2147483648, -2147483648, -2147483648},
        {0, 1, 2, 3, -2147483648, -2147483648, -2147483648, -2147483648, -2147483648}
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
    }

    public static boolean isVisible() {
        return visible;
    }

    /**
     * Called from patched legacy submenu methods. While the horizontal overlay
     * is active, old vertical submenu reopen calls are suppressed.
     */
    public static boolean blockLegacyMenu() {
        return visible;
    }

    public static boolean onKeyPressed(int key) {
        if (!visible) return false;

        if (key == -7 || key == -6 || key == 27 || key == 48) {
            visible = false;
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
            ensureItemVisible(Font.getFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, Font.SIZE_SMALL), lastW);
        } else if (isRight(key)) {
            if (item + 1 < ITEMS[group].length) ++item;
            ensureItemVisible(Font.getFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, Font.SIZE_SMALL), lastW);
        } else if (isFire(key)) {
            activateSelected();
        }

        return true;
    }

    private static boolean isUp(int k) {
        return k == -1 || k == 50;
    }

    private static boolean isDown(int k) {
        return k == -2 || k == 56;
    }

    private static boolean isLeft(int k) {
        return k == -3 || k == 52;
    }

    private static boolean isRight(int k) {
        return k == -4 || k == 54;
    }

    private static boolean isFire(int k) {
        return k == -5 || k == 53 || k == 10 || k == 13;
    }

    private static void changeGroup(int delta) {
        group += delta;
        if (group < 0) group = GROUPS.length - 1;
        if (group >= GROUPS.length) group = 0;

        item = 0;
        itemScroll = 0;
        actionFocus = false;
    }

    private static void activateSelected() {
        if (group < 0 || group >= COMMANDS.length) return;
        if (item < 0 || item >= COMMANDS[group].length) return;

        int command = COMMANDS[group][item];
        int payload = PAYLOADS[group][item];
        boolean close = CLOSE_AFTER[group][item];

        if (close) visible = false;

        Object arg = payload == NO_PAYLOAD ? null : new Integer(payload);
        N.a().a(command, arg);
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
            String[] vals = ITEMS[group];
            int x = 4 - itemScroll;

            for (int i = 0; i < vals.length; i++) {
                int iw = itemWidth(plain, vals[i]);

                if (px >= x && px < x + iw) {
                    actionFocus = true;
                    item = i;
                    ensureItemVisible(plain, lastW);
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

            if (!actionFocus && i == group) {
                g.setColor(0xFFFFFF);
                g.drawRect(x + 2, tabY + 2, tw - 5, tabH - 5);
            }

            g.setFont(bold);
            g.setColor(0x3B2607);
            g.drawString(GROUPS[i], x + tw / 2, tabY + 6, Graphics.HCENTER | Graphics.TOP);

            x += tw + 2;
        }

        String[] vals = ITEMS[group];
        int actionY = panelY + 30;
        int actionH = 36;

        ensureItemVisible(plain, w);
        x = 4 - itemScroll;

        for (int i = 0; i < vals.length; i++) {
            int iw = itemWidth(plain, vals[i]);

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
            g.drawString(vals[i], x + iw / 2, actionY + 10, Graphics.HCENTER | Graphics.TOP);

            x += iw + 3;
        }

        g.setFont(plain);
        g.setColor(0xFFFFFF);
        g.drawString(
            actionFocus ? "< > chuc nang   ^ nhom   OK chon   0 dong" : "< > doi nhom   v vao nhom   0 dong",
            4,
            h - 2,
            Graphics.LEFT | Graphics.BOTTOM
        );

        g.setClip(0, 0, w, h);

        if (tx != 0 || ty != 0) g.translate(tx, ty);
    }

    private static int panelHeight() {
        return 82;
    }

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
        for (int i = 0; i < group; i++) {
            left += tabWidth(f, GROUPS[i]) + 2;
        }

        int right = left + tabWidth(f, GROUPS[group]);

        if (left < tabScroll + 3) tabScroll = left - 3;
        else if (right > tabScroll + width - 3) tabScroll = right - width + 3;

        if (tabScroll < 0) tabScroll = 0;
    }

    private static void ensureItemVisible(Font f, int width) {
        if (width <= 0) return;

        String[] vals = ITEMS[group];
        if (item < 0) item = 0;
        if (item >= vals.length) item = vals.length - 1;

        int left = 4;
        for (int i = 0; i < item; i++) {
            left += itemWidth(f, vals[i]) + 3;
        }

        int right = left + itemWidth(f, vals[item]);

        if (left < itemScroll + 4) itemScroll = left - 4;
        else if (right > itemScroll + width - 4) itemScroll = right - width + 4;

        if (itemScroll < 0) itemScroll = 0;
    }
}
