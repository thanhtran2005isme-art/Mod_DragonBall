package nro;

import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Graphics;

public final class ModHorizontalRuntime {
    private static boolean visible;
    private static int group;
    private static int item;
    private static boolean gridFocus;
    private static int tabScroll;
    private static int itemScroll;
    private static int lastX;
    private static int lastY;
    private static int lastW;
    private static int lastH;

    private static final String[] GROUPS = new String[] {
        "Tàn Sát", "Auto Skill", "Nhặt Đồ", "Xmap", "Boss",
        "TĐLT / NV", "Đậu", "Hỗ Trợ", "Vật Phẩm", "Hiển Thị", "Cài Đặt"
    };

    private static final String[][] ITEMS = new String[][] {
        {"Bật/Tắt Tàn Sát","KC Tàn Sát","Né siêu quái","Đổi khu hết quái","Đổi khu khi lag"},
        {"Auto Skill","Danh sách Skill","Thêm Skill","Xóa Skill"},
        {"Auto Nhặt","KC Nhặt","Lọc Đồ","ItemConfig"},
        {"Xmap","Delay Xmap","Auto vào khu","Dừng Xmap"},
        {"Săn Boss","Né Boss","Paint Boss","Attack Boss"},
        {"Tự Động Luyện Tập","Auto Nhiệm Vụ"},
        {"Xin Đậu","Cho Đậu","Thu Đậu","Buff Đậu"},
        {"Auto Login","Auto On-Off","Auto Chat","Auto Kaioken"},
        {"Cuồng Nộ","Bổ Huyết","Bổ Khí","Giáp Xên","Ẩn Danh","Khẩu Trang","Máy Dò"},
        {"Ẩn Người","Ẩn Quái","Ẩn Item","Thông Tin Boss","Xóa Hiệu Ứng"},
        {"Tùy Chỉnh","Delay Login","KC Nhặt","KC Tàn Sát"}
    };

    private static final int[][] COMMANDS = new int[][] {
        {8,83,-1,-1,-1},
        {64,-1,-1,-1},
        {40,82,41,101},
        {77,73,-1,-1},
        {66,49,-1,-1},
        {81,-1},
        {53,54,55,58},
        {29,76,57,63},
        {33,34,35,36,37,38,39},
        {16,17,18,11,19},
        {69,74,82,83}
    };

    private ModHorizontalRuntime() {}

    public static void open() {
        visible = true;
        gridFocus = false;
        item = 0;
        itemScroll = 0;
    }

    public static boolean isVisible() {
        return visible;
    }

    public static boolean onKeyPressed(int key) {
        if (!visible) return false;

        if (key == -7 || key == -6 || key == 27 || key == 48) {
            visible = false;
            return true;
        }

        if (!gridFocus) {
            if (isLeft(key)) changeGroup(-1);
            else if (isRight(key)) changeGroup(1);
            else if (isDown(key) || isFire(key)) {
                gridFocus = true;
                item = 0;
                itemScroll = 0;
            }
            return true;
        }

        if (isUp(key)) {
            gridFocus = false;
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

    private static void changeGroup(int d) {
        group += d;
        if (group < 0) group = GROUPS.length - 1;
        if (group >= GROUPS.length) group = 0;

        item = 0;
        itemScroll = 0;
        gridFocus = false;
    }

    private static void activateSelected() {
        if (item < 0 || item >= COMMANDS[group].length) return;

        int id = COMMANDS[group][item];
        if (id >= 0) {
            visible = false;
            N.a().a(id, null);
        }
    }

    public static boolean onPointerPressed(int px, int py) {
        if (!visible) return false;
        if (lastW <= 0 || lastH <= 0) return true;

        Font bold = Font.getFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_SMALL);
        Font plain = Font.getFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, Font.SIZE_SMALL);

        int panelH = panelHeight();
        int panelY = lastY + lastH - panelH;
        int tabY = panelY + 2;
        int tabH = 25;

        if (py >= tabY && py <= tabY + tabH) {
            int x = lastX + 3 - tabScroll;

            for (int i = 0; i < GROUPS.length; i++) {
                int tw = tabWidth(bold, GROUPS[i]);

                if (px >= x && px < x + tw) {
                    group = i;
                    item = 0;
                    itemScroll = 0;
                    gridFocus = false;
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
            int x = lastX + 4 - itemScroll;

            for (int i = 0; i < vals.length; i++) {
                int iw = itemWidth(plain, vals[i]);

                if (px >= x && px < x + iw) {
                    gridFocus = true;
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

        lastX = 0;
        lastY = 0;
        lastW = w;
        lastH = h;

        Font bold = Font.getFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_SMALL);
        Font plain = Font.getFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, Font.SIZE_SMALL);

        int panelH = panelHeight();
        int panelY = h - panelH;

        // Compact bottom overlay: only the menu strip is covered.
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

            if (!gridFocus && i == group) {
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

            g.setColor(gridFocus && i == item ? 0xFFF5B5 : 0xF4E6CE);
            g.fillRect(x, actionY, iw, actionH);
            g.setColor(0x8A6B3E);
            g.drawRect(x, actionY, iw - 1, actionH - 1);

            if (gridFocus && i == item) {
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
            gridFocus ? "← → chức năng   ↑ nhóm   OK chọn   0 đóng" : "← → đổi nhóm   ↓ vào nhóm   0 đóng",
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
