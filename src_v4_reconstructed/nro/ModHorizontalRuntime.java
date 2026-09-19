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

    // Automatic login/retry state for controller-launched MicroEmulator JVMs.
    private static boolean autoLoginStarted;
    private static boolean autoLoginOnline;
    private static boolean autoRetryPending;
    private static long autoRetryAt;
    private static int autoRetryCount;
    private static int autoLoginWait;

    // Controller-only idle activity pulse. The server used by this build can
    // drop an otherwise healthy socket after a short period with no gameplay
    // traffic. We reuse the game's own movement packet with the current
    // position instead of fabricating a visible movement.
    private static boolean autoPositionKnown;
    private static int autoLastX;
    private static int autoLastY;
    private static long autoLastPositionChangeAt;
    private static long autoLastIdlePulseAt;

    // Last status written to the controller file bridge. Avoids touching disk
    // every game frame while the state has not changed.
    private static String controllerStatusLast = "";

    // Low-latency localhost bridge used by the multi-client boss coordinator.
    // The socket reader never mutates game state directly; it only publishes
    // the newest command. The real game loop applies that command in
    // markLoginOnline(), which keeps cM/i/aL access on the game thread.
    private static final Object bridgeWriteLock = new Object();
    private static boolean bridgeStarted;
    private static java.io.BufferedWriter bridgeWriter;

    private static volatile long bridgePendingSeq = -1L;
    private static long bridgeAppliedSeq = -1L;
    private static volatile int bridgePendingHuntId;
    private static volatile String bridgePendingCommand = "";
    private static volatile String bridgePendingMap = "";
    private static volatile String bridgePendingBoss = "";
    private static volatile int bridgePendingZone = -1;

    private static int bridgeHuntId;
    private static String bridgeAction = "";
    private static String bridgeTargetMap = "";
    private static String bridgeTargetBoss = "";
    private static int bridgeTargetZone = -1;
    private static long bridgeLastMapRequestAt;
    private static long bridgeLastZoneRequestAt;
    private static long bridgeZoneEnteredAt;
    private static boolean bridgeZoneEnteredReported;
    private static boolean bridgeZoneClearReported;
    private static boolean bridgeBossFoundReported;
    private static boolean bridgeBossJoinedReported;

    private static int bridgeLastStateMap = -2147483648;
    private static int bridgeLastStateZone = -2147483648;
    private static int bridgeLastStateZoneCount = -2147483648;
    private static String bridgeLastStateMapName = "";

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
     * Called from the patched bR.cp() (ServerListScreen update).
     *
     * First launch: select the requested server and execute the game's own
     * "Chơi TK" flow. If the server later reports overload, handleLoginMessage
     * schedules another attempt and this tick executes it after a short delay.
     */
    public static void autoLoginTick(bR serverScreen) {
        ensureBridge();
        if (serverScreen == null) return;

        // bR is the server/login screen. If gameplay had previously marked the
        // client online, returning here means the character left gameplay.
        if (autoLoginOnline) {
            autoLoginOnline = false;
            autoLoginStarted = false;
            autoRetryPending = false;
        }

        if (!autoLoginEnabled()) {
            autoLoginStarted = false;
            autoRetryPending = false;
            writeControllerStatus("OFF");
            return;
        }

        writeControllerStatus("LOGGING_IN");

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

        if (autoRetryPending) {
            if (System.currentTimeMillis() < autoRetryAt) return;
            autoRetryPending = false;
            autoLoginStarted = false;
        }

        if (autoLoginStarted) return;

        int serverIndex = resolveServerIndex(servers, requestedServer);
        if (serverIndex < 0 || serverIndex >= servers.length) {
            autoLoginWait++;
            return;
        }

        startLoginAttempt(serverScreen, serverIndex);
    }

    private static void startLoginAttempt(bR serverScreen, int serverIndex) {
        // Exact game flow used by the account button:
        // select server -> apply host/port -> "Chơi TK" login.
        writeControllerStatus("LOGGING_IN");
        bR.a(serverIndex, true);
        serverScreen.gB();
        bR.ef();
        autoLoginStarted = true;
    }

    /**
     * Injected at the entry of the game's popup helpers.
     *
     * Two server responses are handled automatically:
     *  - overload: retry after the configured interval;
     *  - explicit cooldown such as "vui lòng chờ 30s": respect the server's
     *    requested wait instead of continuing to hammer login.
     *
     * Wrong password, banned account, maintenance and unrelated messages keep
     * their original game behavior.
     */
    public static boolean handleLoginMessage(String text) {
        if (autoLoginOnline || text == null) return false;
        if (!autoLoginEnabled()) {
            writeControllerStatus("OFF");
            return false;
        }

        int cooldownSeconds = loginCooldownSeconds(text);
        if (cooldownSeconds > 0 && autoRetryCooldownEnabled()) {
            long delay = ((long) cooldownSeconds * 1000L) + 1000L;
            scheduleLoginRetry(delay, false);
            return true;
        }

        if (!isOverloadMessage(text)) return false;
        if (!autoRetryOverloadEnabled()) return false;

        int maxRetries = intProperty("dragon.auto.retry.max", 0);
        if (maxRetries > 0 && autoRetryCount >= maxRetries) {
            return false;
        }

        int baseDelay = intProperty("dragon.auto.retry.ms", 3000);
        int jitterMax = intProperty("dragon.auto.retry.jitter", 0);
        if (baseDelay < 100) baseDelay = 100;
        if (jitterMax < 0) jitterMax = 0;

        autoRetryCount++;
        int jitter = jitterMax == 0
                ? 0
                : (autoRetryCount * 173) % (jitterMax + 1);

        scheduleLoginRetry((long) baseDelay + jitter, true);
        return true;
    }

    private static void scheduleLoginRetry(long delayMs, boolean overloadRetry) {
        if (delayMs < 100L) delayMs = 100L;

        long target = System.currentTimeMillis() + delayMs;

        // A server cooldown always wins over a shorter pending overload retry.
        if (!autoRetryPending || target > autoRetryAt) {
            autoRetryAt = target;
        }

        autoRetryPending = true;
        autoLoginStarted = false;
    }

    /**
     * Injected into the real gameplay screen update. Reaching this screen is
     * the authoritative point where login retry stops.
     *
     * It also sends a conservative position pulse only after the character has
     * remained at exactly the same coordinates for the configured interval.
     * The pulse is the game's own cM.ig() movement packet and carries the
     * current coordinates, so the character does not visibly walk.
     */
    public static void markLoginOnline() {
        ensureBridge();

        // Gameplay itself is authoritative. Status must become ONLINE even if
        // Auto Login was switched off and the user entered manually.
        autoLoginOnline = true;
        autoRetryPending = false;
        autoLoginStarted = true;
        writeControllerStatus("ONLINE");

        bridgeGameplayTick();

        int pulseMs = intProperty("dragon.auto.idle.pulse.ms", 5000);
        if (pulseMs <= 0) return;

        bv me;
        try {
            me = bv.e();
        } catch (Throwable ignored) {
            return;
        }

        if (me == null) return;

        long now = System.currentTimeMillis();
        int x = me.hT;
        int y = me.hP;

        if (!autoPositionKnown || x != autoLastX || y != autoLastY) {
            autoPositionKnown = true;
            autoLastX = x;
            autoLastY = y;
            autoLastPositionChangeAt = now;
            autoLastIdlePulseAt = now;
            return;
        }

        if (now - autoLastPositionChangeAt < pulseMs) return;
        if (now - autoLastIdlePulseAt < pulseMs) return;

        sendIdlePositionPulse(me);
        autoLastIdlePulseAt = now;
    }

    private static void sendIdlePositionPulse(bv me) {
        try {
            if (!bh.b().E()) return;

            int oldPreviousX = me.ie;
            int oldPreviousY = me.ik;

            // cM.ig() normally returns without sending when the current and
            // previous coordinates are identical. Nudge only the cached
            // previous X by one pixel, then let cM.ig() encode the real current
            // coordinates using the exact original packet implementation.
            if (me.hT == oldPreviousX && me.hP == oldPreviousY) {
                me.ie = me.hT == -32768 ? me.hT + 1 : me.hT - 1;
            }

            cM.a().ig();

            // If cM.ig() refused to send due to a game state guard, restore the
            // cached previous position so we do not perturb later real movement.
            if (me.ie != me.hT || me.ik != me.hP) {
                me.ie = oldPreviousX;
                me.ik = oldPreviousY;
            }
        } catch (Throwable ignored) {
        }
    }

    private static boolean isOverloadMessage(String text) {
        String s = text.toLowerCase();

        if (s.indexOf("quá tải") >= 0) return true;
        if (s.indexOf("qua tai") >= 0) return true;

        // Backup match for variants of the exact server response shown by the
        // game: "vui lòng thử lại sau ít phút".
        if (s.indexOf("thử lại sau ít phút") >= 0) return true;
        if (s.indexOf("thu lai sau it phut") >= 0) return true;

        return false;
    }

    private static boolean autoLoginEnabled() {
        String controlFile = safeProperty("dragon.auto.login.file");

        if (controlFile != null && controlFile.length() > 0) {
            java.io.FileInputStream in = null;

            try {
                in = new java.io.FileInputStream(controlFile);
                int value = in.read();
                if (value == '1') return true;
                if (value == '0') return false;
            } catch (Throwable ignored) {
            } finally {
                if (in != null) {
                    try { in.close(); } catch (Throwable ignored) {}
                }
            }
        }

        String enabled = safeProperty("dragon.auto.login");
        return "1".equals(enabled);
    }

    private static void writeControllerStatus(String status) {
        if (status == null) return;
        if (status.equals(controllerStatusLast)) return;

        String statusFile = safeProperty("dragon.status.file");
        if (statusFile == null || statusFile.length() == 0) return;

        java.io.FileOutputStream out = null;

        try {
            out = new java.io.FileOutputStream(statusFile);
            byte[] bytes = status.getBytes("UTF-8");
            out.write(bytes);
            out.flush();
            controllerStatusLast = status;
        } catch (Throwable ignored) {
        } finally {
            if (out != null) {
                try { out.close(); } catch (Throwable ignored) {}
            }
        }
    }

    /**
     * Patched into aL.p(String), the exact game path that receives server
     * announcements. We intentionally reuse w.a(String), the original mod's
     * own boss parser, so Controller sees the same boss/map values as ListBoss.
     */
    public static void onGameAnnouncement(String text) {
        ensureBridge();
        if (text == null) return;

        String lower;
        try {
            lower = text.toLowerCase().trim();
        } catch (Throwable ignored) {
            return;
        }

        if (!lower.startsWith("boss")) return;

        try {
            String[] parsed = w.a(text);
            if (parsed == null || parsed.length < 2) return;

            String boss = parsed[0] == null ? "" : parsed[0].trim();
            String map = parsed[1] == null ? "" : parsed[1].trim();
            if (boss.length() == 0 || map.length() == 0) return;

            bridgeSend(new String[] {"BOSS_ANNOUNCED", boss, map, text});
        } catch (Throwable ignored) {
        }
    }

    private static synchronized void ensureBridge() {
        if (bridgeStarted) return;

        int port = intProperty("dragon.bridge.port", 0);
        int clientId = intProperty("dragon.client.id", 0);
        if (port <= 0 || clientId <= 0) return;

        bridgeStarted = true;

        Thread t = new Thread(new Runnable() {
            public void run() {
                bridgeLoop();
            }
        }, "DragonControllerBridge");

        try {
            t.setDaemon(true);
        } catch (Throwable ignored) {
        }

        t.start();
    }

    private static void bridgeLoop() {
        int port = intProperty("dragon.bridge.port", 0);
        int clientId = intProperty("dragon.client.id", 0);

        while (true) {
            java.net.Socket socket = null;
            java.io.BufferedReader reader = null;
            java.io.BufferedWriter writer = null;

            try {
                socket = new java.net.Socket("127.0.0.1", port);
                try { socket.setTcpNoDelay(true); } catch (Throwable ignored) {}
                try { socket.setKeepAlive(true); } catch (Throwable ignored) {}

                reader = new java.io.BufferedReader(
                        new java.io.InputStreamReader(socket.getInputStream(), "UTF-8"));
                writer = new java.io.BufferedWriter(
                        new java.io.OutputStreamWriter(socket.getOutputStream(), "UTF-8"));

                synchronized (bridgeWriteLock) {
                    bridgeWriter = writer;
                }

                // Force a fresh STATE event after every reconnect.
                bridgeLastStateMap = -2147483648;
                bridgeLastStateZone = -2147483648;
                bridgeLastStateZoneCount = -2147483648;
                bridgeLastStateMapName = "";

                bridgeSend(new String[] {"HELLO", String.valueOf(clientId)});

                String line;
                while ((line = reader.readLine()) != null) {
                    bridgeReadCommand(line);
                }
            } catch (Throwable ignored) {
            } finally {
                synchronized (bridgeWriteLock) {
                    if (bridgeWriter == writer) bridgeWriter = null;
                }

                try { if (reader != null) reader.close(); } catch (Throwable ignored) {}
                try { if (writer != null) writer.close(); } catch (Throwable ignored) {}
                try { if (socket != null) socket.close(); } catch (Throwable ignored) {}
            }

            try {
                Thread.sleep(500L);
            } catch (Throwable ignored) {
            }
        }
    }

    private static boolean bridgeSend(String[] fields) {
        if (fields == null || fields.length == 0) return false;

        StringBuffer line = new StringBuffer();

        for (int i = 0; i < fields.length; i++) {
            if (i > 0) line.append('|');
            line.append(bridgeEscape(fields[i]));
        }

        synchronized (bridgeWriteLock) {
            if (bridgeWriter == null) return false;

            try {
                bridgeWriter.write(line.toString());
                bridgeWriter.newLine();
                bridgeWriter.flush();
                return true;
            } catch (Throwable ignored) {
                bridgeWriter = null;
                return false;
            }
        }
    }

    private static String bridgeEscape(String value) {
        if (value == null || value.length() == 0) return "";

        StringBuffer out = new StringBuffer();

        for (int i = 0; i < value.length(); i++) {
            char ch = value.charAt(i);

            if (ch == '\\') out.append("\\\\");
            else if (ch == '|') out.append("\\p");
            else if (ch == '\n') out.append("\\n");
            else if (ch == '\r') out.append("\\r");
            else out.append(ch);
        }

        return out.toString();
    }

    private static String[] bridgeSplit(String line) {
        Vector values = new Vector();
        StringBuffer current = new StringBuffer();
        boolean escaped = false;

        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);

            if (escaped) {
                if (ch == 'p') current.append('|');
                else if (ch == 'n') current.append('\n');
                else if (ch == 'r') current.append('\r');
                else if (ch == '\\') current.append('\\');
                else current.append(ch);

                escaped = false;
                continue;
            }

            if (ch == '\\') {
                escaped = true;
                continue;
            }

            if (ch == '|') {
                values.addElement(current.toString());
                current.setLength(0);
                continue;
            }

            current.append(ch);
        }

        if (escaped) current.append('\\');
        values.addElement(current.toString());

        String[] result = new String[values.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = (String) values.elementAt(i);
        }

        return result;
    }

    private static void bridgeReadCommand(String line) {
        if (line == null || line.length() == 0) return;

        try {
            String[] parts = bridgeSplit(line);
            if (parts.length < 4 || !"CMD".equals(parts[0])) return;

            int huntId = Integer.parseInt(parts[1]);
            long seq = Long.parseLong(parts[2]);
            String command = parts[3];

            if (seq <= bridgePendingSeq) return;

            String map = "";
            String boss = "";
            int zone = -1;

            if ("MOVE_MAP".equals(command)) {
                if (parts.length > 4) map = parts[4];
                if (parts.length > 5) boss = parts[5];
            } else if ("JOIN_ZONE".equals(command) ||
                       "JOIN_BOSS_ZONE".equals(command)) {
                if (parts.length > 4) zone = Integer.parseInt(parts[4]);
                if (parts.length > 5) boss = parts[5];
                if (parts.length > 6) map = parts[6];
            }

            // Publish payload first and sequence last. The volatile sequence is
            // the hand-off barrier consumed by the game thread.
            bridgePendingHuntId = huntId;
            bridgePendingCommand = command;
            bridgePendingMap = map == null ? "" : map;
            bridgePendingBoss = boss == null ? "" : boss;
            bridgePendingZone = zone;
            bridgePendingSeq = seq;
        } catch (Throwable ignored) {
        }
    }

    private static void bridgeApplyPendingCommand() {
        long seq = bridgePendingSeq;
        if (seq <= bridgeAppliedSeq) return;

        bridgeAppliedSeq = seq;
        bridgeHuntId = bridgePendingHuntId;

        String command = bridgePendingCommand == null ? "" : bridgePendingCommand;

        if ("STOP_HUNT".equals(command)) {
            bridgeAction = "";
            bridgeTargetMap = "";
            bridgeTargetBoss = "";
            bridgeTargetZone = -1;
            bridgeResetZoneProgress();
            return;
        }

        bridgeTargetMap = bridgePendingMap == null ? "" : bridgePendingMap;
        bridgeTargetBoss = bridgePendingBoss == null ? "" : bridgePendingBoss;
        bridgeTargetZone = bridgePendingZone;
        bridgeAction = command;
        bridgeLastMapRequestAt = 0L;
        bridgeLastZoneRequestAt = 0L;
        bridgeResetZoneProgress();
    }

    private static void bridgeResetZoneProgress() {
        bridgeZoneEnteredAt = 0L;
        bridgeZoneEnteredReported = false;
        bridgeZoneClearReported = false;
        bridgeBossFoundReported = false;
        bridgeBossJoinedReported = false;
    }

    private static void bridgeGameplayTick() {
        bridgeApplyPendingCommand();

        int mapId = cF.y;
        int zone = cF.v;
        int zoneCount = 0;
        String mapName = bridgeCurrentMapName(mapId);

        try {
            aL screen = aL.a();
            if (screen != null && screen.r != null) {
                zoneCount = screen.r.length;
            }
        } catch (Throwable ignored) {
        }

        if (mapId != bridgeLastStateMap ||
            zone != bridgeLastStateZone ||
            zoneCount != bridgeLastStateZoneCount ||
            !mapName.equals(bridgeLastStateMapName)) {

            if (bridgeSend(new String[] {
                    "STATE",
                    String.valueOf(mapId),
                    mapName,
                    String.valueOf(zone),
                    String.valueOf(zoneCount)})) {

                bridgeLastStateMap = mapId;
                bridgeLastStateZone = zone;
                bridgeLastStateZoneCount = zoneCount;
                bridgeLastStateMapName = mapName;
            }
        }

        if ("MOVE_MAP".equals(bridgeAction)) {
            bridgeMoveToTargetMap(mapName);
            return;
        }

        if ("JOIN_ZONE".equals(bridgeAction)) {
            bridgeScanAssignedZone(mapName, false);
            return;
        }

        if ("JOIN_BOSS_ZONE".equals(bridgeAction)) {
            bridgeScanAssignedZone(mapName, true);
        }
    }

    private static String bridgeCurrentMapName(int mapId) {
        try {
            if (cF.f != null && mapId >= 0 && mapId < cF.f.length) {
                String name = cF.f[mapId];
                return name == null ? "" : name;
            }
        } catch (Throwable ignored) {
        }

        return "";
    }

    private static void bridgeMoveToTargetMap(String currentMapName) {
        if (bridgeTargetMap == null || bridgeTargetMap.length() == 0) return;

        if (bridgeSameText(currentMapName, bridgeTargetMap)) {
            bridgeSend(new String[] {
                    "MAP_REACHED",
                    String.valueOf(bridgeHuntId),
                    String.valueOf(cF.y),
                    currentMapName});
            bridgeAction = "WAIT_ASSIGN";
            return;
        }

        long now = System.currentTimeMillis();
        if (now - bridgeLastMapRequestAt < 1000L) return;
        bridgeLastMapRequestAt = now;

        int mapId = bridgeFindMapId(bridgeTargetMap);
        if (mapId < 0) return;

        try {
            i.d(mapId);
        } catch (Throwable ignored) {
        }
    }

    private static int bridgeFindMapId(String mapName) {
        if (mapName == null || mapName.length() == 0 || cF.f == null) return -1;

        String wanted = mapName.trim().toLowerCase();

        for (int i = 0; i < cF.f.length; i++) {
            String current = cF.f[i];
            if (current == null) continue;

            String normalized = current.trim().toLowerCase();
            if (wanted.equals(normalized)) return i;
        }

        for (int i = 0; i < cF.f.length; i++) {
            String current = cF.f[i];
            if (current == null) continue;

            String normalized = current.trim().toLowerCase();
            if (normalized.indexOf(wanted) >= 0 || wanted.indexOf(normalized) >= 0) {
                return i;
            }
        }

        return -1;
    }

    private static void bridgeScanAssignedZone(String currentMapName, boolean bossRally) {
        if (bridgeTargetMap != null &&
            bridgeTargetMap.length() > 0 &&
            !bridgeSameText(currentMapName, bridgeTargetMap)) {

            bridgeMoveToTargetMap(currentMapName);
            return;
        }

        if (bridgeTargetZone < 0) return;

        long now = System.currentTimeMillis();

        if (cF.v != bridgeTargetZone) {
            bridgeResetZoneProgress();

            // Deliberately retry the SAME assigned zone until the server accepts
            // it. Controller never gives this client another zone meanwhile.
            if (now - bridgeLastZoneRequestAt >= 250L) {
                bridgeLastZoneRequestAt = now;
                try {
                    cM.a().W(bridgeTargetZone);
                } catch (Throwable ignored) {
                }
            }

            return;
        }

        if (bridgeZoneEnteredAt == 0L) {
            bridgeZoneEnteredAt = now;
        }

        if (!bridgeZoneEnteredReported) {
            bridgeZoneEnteredReported = true;
            bridgeSend(new String[] {
                    "ZONE_ENTERED",
                    String.valueOf(bridgeHuntId),
                    String.valueOf(bridgeTargetZone)});
        }

        if (bossRally) {
            if (!bridgeBossJoinedReported) {
                bridgeBossJoinedReported = true;
                bridgeSend(new String[] {
                        "BOSS_JOINED",
                        String.valueOf(bridgeHuntId),
                        String.valueOf(bridgeTargetZone)});
            }
            return;
        }

        bv found = bridgeFindTargetBoss(bridgeTargetBoss);
        if (found != null) {
            if (!bridgeBossFoundReported) {
                bridgeBossFoundReported = true;
                String name = found.aq == null ? bridgeTargetBoss : found.aq;
                bridgeSend(new String[] {
                        "BOSS_FOUND",
                        String.valueOf(bridgeHuntId),
                        String.valueOf(bridgeTargetZone),
                        name});
            }

            bridgeAction = "WAIT_FOUND";
            return;
        }

        // Scan every frame immediately, but allow the map's entity list a short
        // settle window before declaring the zone empty. This prevents a false
        // ZONE_CLEAR on the first frame after a zone transition.
        if (!bridgeZoneClearReported && now - bridgeZoneEnteredAt >= 800L) {
            bridgeZoneClearReported = true;
            bridgeSend(new String[] {
                    "ZONE_CLEAR",
                    String.valueOf(bridgeHuntId),
                    String.valueOf(bridgeTargetZone)});
            bridgeAction = "WAIT_ASSIGN";
        }
    }

    private static bv bridgeFindTargetBoss(String targetBoss) {
        if (targetBoss == null || targetBoss.trim().length() == 0) return null;

        try {
            Vector characters = aL.N;
            if (characters == null) return null;

            for (int i = 0; i < characters.size(); i++) {
                Object row = characters.elementAt(i);
                if (!(row instanceof bv)) continue;

                bv candidate = (bv) row;
                if (candidate == null || candidate.aq == null) continue;
                if (!v.a(candidate)) continue;

                if (bridgeBossNameMatches(candidate.aq, targetBoss)) {
                    return candidate;
                }
            }
        } catch (Throwable ignored) {
        }

        return null;
    }

    private static boolean bridgeBossNameMatches(String actual, String wanted) {
        if (actual == null || wanted == null) return false;

        String a = actual.trim().toLowerCase();
        String b = wanted.trim().toLowerCase();

        if (a.length() == 0 || b.length() == 0) return false;
        return a.indexOf(b) >= 0 || b.indexOf(a) >= 0;
    }

    private static boolean bridgeSameText(String left, String right) {
        if (left == null || right == null) return false;
        return left.trim().equalsIgnoreCase(right.trim());
    }

    private static int loginCooldownSeconds(String text) {
        String s = text.toLowerCase();

        boolean waitMessage =
                s.indexOf("vui lòng chờ") >= 0 ||
                s.indexOf("vui long cho") >= 0 ||
                s.indexOf("vui lòng đợi") >= 0 ||
                s.indexOf("vui long doi") >= 0;

        if (!waitMessage) return -1;

        int value = 0;
        boolean found = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                found = true;
                value = value * 10 + (c - '0');
                if (value > 600) return 600;
            } else if (found) {
                break;
            }
        }

        if (!found || value <= 0) return -1;
        if (value > 600) value = 600;
        return value;
    }

    private static boolean autoRetryOverloadEnabled() {
        String enabled = safeProperty("dragon.auto.retry.overload");
        return enabled == null || !"0".equals(enabled);
    }

    private static boolean autoRetryCooldownEnabled() {
        String enabled = safeProperty("dragon.auto.retry.cooldown");
        return enabled == null || !"0".equals(enabled);
    }

    private static int intProperty(String name, int defaultValue) {
        String value = safeProperty(name);
        if (value == null) return defaultValue;

        try {
            return Integer.parseInt(value.trim());
        } catch (Exception ignored) {
            return defaultValue;
        }
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
