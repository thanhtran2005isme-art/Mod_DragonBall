package nro;

/**
 * Grouping model for the Dragonboy250 v4.0 mod menu.
 *
 * This file contains labels/action keys only. The action keys are bridged
 * to the existing v4.0 handlers in class N during integration.
 */
public final class ModMenuCatalog {

   private ModMenuCatalog() {
   }

   public static final String[] GROUP_TITLES = new String[] {
      "Tàn Sát",
      "Auto Skill",
      "Nhặt Đồ",
      "Xmap",
      "Boss",
      "TĐLT / NV",
      "Đậu",
      "Hỗ Trợ",
      "Vật Phẩm",
      "Hiển Thị",
      "Cài Đặt"
   };

   public static final String[][] ITEM_TITLES = new String[][] {
      {
         "Bật/Tắt Tàn Sát",
         "Chọn quái / vị trí",
         "KC Tàn Sát",
         "Né siêu quái",
         "Đổi khu khi hết quái",
         "Đổi khu khi lag"
      },
      {
         "Bật/Tắt Auto Skill",
         "Thêm Skill",
         "Xóa Skill",
         "Danh sách Skill"
      },
      {
         "Auto Nhặt",
         "KC Nhặt",
         "Thêm Item",
         "Xóa Item",
         "Danh sách Item",
         "Lọc Đồ",
         "ItemConfig"
      },
      {
         "Bật/Dừng Xmap",
         "Chọn Bản Đồ",
         "Chọn Hành Tinh",
         "Delay Xmap",
         "Xmap tới Boss",
         "Auto vào khu"
      },
      {
         "Săn Boss",
         "Attack Boss",
         "Focus Boss",
         "Né Boss",
         "Paint Boss",
         "Cài Attack Boss"
      },
      {
         "Auto TDLT",
         "Cài TDLT",
         "Auto Nhiệm Vụ"
      },
      {
         "Xin Đậu",
         "Cho Đậu",
         "Thu Đậu",
         "Buff Đậu Sư Phụ",
         "Buff Đậu Đệ Tử",
         "Delay Buff Đậu"
      },
      {
         "Auto Login",
         "Delay Login",
         "Auto On-Off",
         "Auto Chat",
         "Auto Kaioken",
         "Auto Hồi Sinh",
         "Auto HS Namek"
      },
      {
         "Cuồng Nộ",
         "Bổ Huyết",
         "Bổ Khí",
         "Giáp Xên",
         "Ẩn Danh",
         "Khẩu Trang",
         "Máy Dò",
         "Capsule"
      },
      {
         "Ẩn Người",
         "Ẩn Quái",
         "Ẩn Item",
         "Xóa Hiệu Ứng",
         "Ảnh Nền",
         "Thông Tin Boss"
      },
      {
         "Setup AutoPlay",
         "Setup Auto Skill",
         "Setup Filter Item",
         "Setup Attack Boss",
         "Setup Xmap",
         "Tùy Chỉnh"
      }
   };

   public static final String[][] ACTION_KEYS = new String[][] {
      {
         "TS_TOGGLE",
         "TS_TARGET",
         "TS_DISTANCE",
         "TS_AVOID_SUPER_MOB",
         "TS_SWITCH_ZONE_EMPTY",
         "TS_SWITCH_ZONE_LAG"
      },
      {
         "AUTO_SKILL_TOGGLE",
         "AUTO_SKILL_ADD",
         "AUTO_SKILL_REMOVE",
         "AUTO_SKILL_LIST"
      },
      {
         "AUTO_PICK_TOGGLE",
         "AUTO_PICK_DISTANCE",
         "ITEM_ADD",
         "ITEM_DELETE",
         "ITEM_LIST",
         "ITEM_FILTER_TOGGLE",
         "ITEM_CONFIG"
      },
      {
         "XMAP_TOGGLE",
         "XMAP_MAP",
         "XMAP_PLANET",
         "XMAP_DELAY",
         "XMAP_BOSS",
         "AUTO_ZONE"
      },
      {
         "BOSS_HUNT",
         "BOSS_ATTACK",
         "BOSS_FOCUS",
         "BOSS_AVOID",
         "BOSS_PAINT",
         "BOSS_SETUP"
      },
      {
         "TDLT_TOGGLE",
         "TDLT_SETUP",
         "QUEST_AUTO"
      },
      {
         "BEAN_REQUEST",
         "BEAN_GIVE",
         "BEAN_COLLECT",
         "BEAN_BUFF_MASTER",
         "BEAN_BUFF_DISCIPLE",
         "BEAN_BUFF_DELAY"
      },
      {
         "LOGIN_AUTO",
         "LOGIN_DELAY",
         "AUTO_ON_OFF",
         "AUTO_CHAT",
         "AUTO_KAIOKEN",
         "AUTO_REVIVE",
         "AUTO_REVIVE_NAMEK"
      },
      {
         "ITEM_RAGE",
         "ITEM_HP",
         "ITEM_KI",
         "ITEM_ARMOR",
         "ITEM_INVISIBLE",
         "ITEM_MASK",
         "ITEM_RADAR",
         "ITEM_CAPSULE"
      },
      {
         "VIEW_HIDE_CHAR",
         "VIEW_HIDE_MOB",
         "VIEW_HIDE_ITEM",
         "VIEW_REMOVE_EFFECT",
         "VIEW_BACKGROUND",
         "VIEW_BOSS_INFO"
      },
      {
         "SETUP_AUTOPLAY",
         "SETUP_AUTO_SKILL",
         "SETUP_FILTER_ITEM",
         "SETUP_ATTACK_BOSS",
         "SETUP_XMAP",
         "SETUP_CUSTOM"
      }
   };
}
