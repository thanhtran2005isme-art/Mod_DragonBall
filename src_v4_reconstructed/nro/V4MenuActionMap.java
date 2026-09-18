package nro;

/**
 * Verified command IDs recovered from Dragonboy250 v4.0 class N.
 *
 * These IDs are the values passed to N.a(int,Object) by the existing
 * vertical menu. Unknown/unverified actions intentionally return -1.
 */
public final class V4MenuActionMap {

   private V4MenuActionMap() {
   }

   public static int getCommandId(String key) {
      if (key == null) {
         return -1;
      }

      // Main / feature entry points recovered from N.bt(), N.bu(), N.bA().
      if (key.equals("TS_TOGGLE")) return 8;
      if (key.equals("AUTO_PICK_TOGGLE")) return 40;
      if (key.equals("ITEM_FILTER_TOGGLE")) return 41;
      if (key.equals("XMAP_TOGGLE")) return 77;
      if (key.equals("BOSS_HUNT")) return 66;
      if (key.equals("AUTO_ON_OFF")) return 76;
      if (key.equals("AUTO_CHAT")) return 57;
      if (key.equals("AUTO_KAIOKEN")) return 63;
      if (key.equals("TDLT_SETUP")) return 81;
      if (key.equals("LOGIN_AUTO")) return 29;
      if (key.equals("SETUP_CUSTOM")) return 69;

      // Auto Login submenu.
      if (key.equals("LOGIN_RECONNECT_TOGGLE")) return 30;
      if (key.equals("LOGIN_REJOIN_ZONE_TOGGLE")) return 31;

      // Item support / consumables from N.bq().
      if (key.equals("ITEM_RAGE")) return 33;
      if (key.equals("ITEM_HP")) return 34;
      if (key.equals("ITEM_KI")) return 35;
      if (key.equals("ITEM_ARMOR")) return 36;
      if (key.equals("ITEM_INVISIBLE")) return 37;
      if (key.equals("ITEM_MASK")) return 38;
      if (key.equals("ITEM_RADAR")) return 39;
      if (key.equals("ITEM_CONFIG")) return 101;

      // Display / hide features.
      if (key.equals("VIEW_BOSS_INFO")) return 11;
      if (key.equals("VIEW_HIDE_CHAR")) return 16;
      if (key.equals("VIEW_HIDE_MOB")) return 17;
      if (key.equals("VIEW_HIDE_ITEM")) return 18;
      if (key.equals("VIEW_REMOVE_EFFECT")) return 19;

      // Disciple / combat support from N.bz().
      if (key.equals("BOSS_AVOID")) return 49;

      // Bean automation from N.by().
      if (key.equals("BEAN_REQUEST")) return 53;
      if (key.equals("BEAN_GIVE")) return 54;
      if (key.equals("BEAN_COLLECT")) return 55;

      // Settings from N.bF().
      if (key.equals("XMAP_DELAY")) return 73;
      if (key.equals("LOGIN_DELAY")) return 74;
      if (key.equals("AUTO_PICK_DISTANCE")) return 82;
      if (key.equals("TS_DISTANCE")) return 83;

      // These menu entries open existing v4.0 setup screens.
      if (key.equals("SETUP_AUTO_SKILL")) return 64;
      if (key.equals("SETUP_FILTER_ITEM")) return 65;
      if (key.equals("SETUP_BOSS_HUNT")) return 66;
      if (key.equals("SETUP_TDLT")) return 81;
      if (key.equals("SETUP_BEAN_BUFF")) return 58;

      return -1;
   }
}
