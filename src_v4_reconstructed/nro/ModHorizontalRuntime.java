package nro;

import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Graphics;

public final class ModHorizontalRuntime {
    private static boolean visible;
    private static int group;
    private static int item;
    private static boolean gridFocus;
    private static int tabScroll;
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
            }
            return true;
        }

        if (isUp(key)) {
            if (item < 2) gridFocus = false;
            else item -= 2;
        } else if (isDown(key)) {
            if (item + 2 < ITEMS[group].length) item += 2;
        } else if (isLeft(key)) {
            if ((item & 1) == 1) --item;
        } else if (isRight(key)) {
            if ((item & 1) == 0 && item + 1 < ITEMS[group].length) ++item;
        } else if (isFire(key)) {
            int id = COMMANDS[group][item];
            if (id >= 0) {
                visible = false;
                N.a().a(id, null);
            }
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
        gridFocus = false;
    }

    public static boolean onPointerPressed(int px, int py) {
        if (!visible) return false;
        if (lastW <= 0 || lastH <= 0) return true;

        Font bold = Font.getFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_SMALL);
        int tabY = lastY + 2;
        int tabH = 30;

        if (py >= tabY && py <= tabY + tabH) {
            int x = lastX + 3 - tabScroll;
            int i;
            for (i = 0; i < GROUPS.length; i++) {
                int tw = tabWidth(bold, GROUPS[i]);
                if (px >= x && px < x + tw) {
                    group = i;
                    item = 0;
                    gridFocus = false;
                    ensureTabVisible(bold, lastW);
                    return true;
                }
                x += tw + 2;
            }
            return true;
        }

        int gridY = lastY + 37;
        int cellGap = 3;
        int cellH = 29;
        int cellW = (lastW - 9) / 2;

        if (py >= gridY + 3) {
            int row = (py - (gridY + 3)) / (cellH + cellGap);
            int col = px < lastX + 4 + cellW ? 0 : 1;
            int index = row * 2 + col;

            if (index >= 0 && index < ITEMS[group].length) {
                gridFocus = true;
                item = index;
                int id = COMMANDS[group][item];
                if (id >= 0) {
                    visible = false;
                    N.a().a(id, null);
                }
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

        int clipX = 0;
        int clipY = 0;
        int w = aE.a().getWidth();
        int h = aE.a().getHeight();

        if (w <= 0 || h <= 0) {
            if (tx != 0 || ty != 0) g.translate(tx, ty);
            return;
        }

        lastX = clipX;
        lastY = clipY;
        lastW = w;
        lastH = h;

        Font bold = Font.getFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_SMALL);
        Font plain = Font.getFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, Font.SIZE_SMALL);

        int tabY = 2;
        int tabH = 30;
        int tabGap = 2;
        int x = clipX + 3 - tabScroll;

        ensureTabVisible(bold, w);
        x = clipX + 3 - tabScroll;
        g.setClip(clipX, clipY, w, h);

        int i;
        for (i = 0; i < GROUPS.length; i++) {
            int tw = tabWidth(bold, GROUPS[i]);
            g.setColor(i == group ? 0xFFF1A6 : 0xF3C94F);
            g.fillRect(x, clipY + tabY, tw, tabH);
            g.setColor(0x73500D);
            g.drawRect(x, clipY + tabY, tw - 1, tabH - 1);
            g.setFont(bold);
            g.drawString(GROUPS[i], x + tw / 2, clipY + tabY + 8, Graphics.HCENTER | Graphics.TOP);
            x += tw + tabGap;
        }

        int gridY = clipY + tabY + tabH + 5;
        int bottom = clipY + h - 18;
        int cellGap = 3;
        int cellH = 29;
        int cellW = (w - 9) / 2;
        String[] vals = ITEMS[group];

        g.setColor(0xD8C7AA);
        g.fillRect(clipX + 2, gridY, w - 4, bottom - gridY);

        for (i = 0; i < vals.length; i++) {
            int row = i / 2;
            int col = i & 1;
            int cx = clipX + 4 + col * (cellW + cellGap);
            int cy = gridY + 3 + row * (cellH + cellGap);
            if (cy + cellH > bottom) break;

            g.setColor(gridFocus && i == item ? 0xFFF5B5 : 0xF4E6CE);
            g.fillRect(cx, cy, cellW, cellH);
            g.setColor(0x8A6B3E);
            g.drawRect(cx, cy, cellW - 1, cellH - 1);
            g.setFont(plain);
            g.drawString(vals[i], cx + cellW / 2, cy + 7, Graphics.HCENTER | Graphics.TOP);
        }

        g.setFont(plain);
        g.setColor(0xFFFFFF);
        g.drawString("← → nhóm   ↓ vào nhóm   0 đóng", clipX + 3, clipY + h - 2, Graphics.LEFT | Graphics.BOTTOM);

        if (tx != 0 || ty != 0) g.translate(tx, ty);
    }

    private static int tabWidth(Font f, String s) {
        int tw = f.stringWidth(s) + 18;
        return tw < 72 ? 72 : tw;
    }

    private static void ensureTabVisible(Font f, int width) {
        int left = 3;
        int i;
        for (i = 0; i < group; i++) {
            left += tabWidth(f, GROUPS[i]) + 2;
        }

        int right = left + tabWidth(f, GROUPS[group]);
        if (left < tabScroll + 3) tabScroll = left - 3;
        else if (right > tabScroll + width - 3) tabScroll = right - width + 3;
        if (tabScroll < 0) tabScroll = 0;
    }
}
