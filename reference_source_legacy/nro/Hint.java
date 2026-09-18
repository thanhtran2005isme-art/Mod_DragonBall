package nro;

public final class Hint {
   public static int a;
   public static int b;
   public static int c;
   public static int d;
   public static boolean e;
   public static boolean f;
   public static boolean g;
   public static boolean h;
   public static boolean i;
   public static boolean j;
   public static int k;
   public static boolean l;
   public static boolean m;

   public static boolean a(int var0, int var1) {
      return Char.myCharz().aD != null && Char.myCharz().aD.c == var0 && Char.myCharz().aD.a == 0;
   }

   public static void clickNpc() {
      if (main.GameCanvas.panel.isShow) {
         i = false;
      }

      if (GameScr.v() != null) {
         a = GameScr.v().cx;
         b = GameScr.v().cy;
         k = 0;
         j = true;
         c = main.GameCanvas.isTouch ? 1 : 0;
      }

   }

   public static void a(int var0) {
      if (!main.GameCanvas.panel.isShow) {
         if (PopUp.a.size() - 1 >= var0) {
            PopUp var1;
            a = (var1 = (PopUp)PopUp.a.elementAt(var0)).d + var1.b / 2;
            b = var1.e + 30;
            if (!var1.k && var1.j) {
               i = true;
            } else {
               i = false;
            }

            c = 0;
            j = true;
            k = 0;
            if (!main.GameCanvas.isTouch) {
               i = false;
            }

         }
      }
   }

   public static void clickMob() {
      c = 1;
      if (main.GameCanvas.panel.isShow) {
         i = false;
      }

      boolean var0 = false;

      int var1;
      for(var1 = 0; var1 < GameScr.F.size(); ++var1) {
         if (((Mob)GameScr.F.elementAt(var1)).f) {
            var0 = true;
            break;
         }
      }

      for(var1 = 0; var1 < GameScr.F.size(); ++var1) {
         Mob var2;
         if ((var2 = (Mob)GameScr.F.elementAt(var1)).f) {
            a = var2.x;
            b = var2.y + 5;
            j = true;
            if (var2.p == 0) {
               var2.f = false;
               return;
            }
            break;
         }

         if (!var0) {
            if (var2.p != 0) {
               var2.f = true;
               return;
            }

            var2.f = false;
         }
      }

   }

   public static boolean c() {
      if (main.GameCanvas.panel.isShow) {
         i = false;
      }

      for(int var0 = 0; var0 < GameScr.vItemMap.size(); ++var0) {
         ItemMap var1;
         if ((var1 = (ItemMap)GameScr.vItemMap.elementAt(var0)).c == Char.myCharz().charID && var1.template.a == 73) {
            c = 1;
            a = var1.a;
            b = var1.b + 5;
            j = true;
            return true;
         }
      }

      return false;
   }
}
