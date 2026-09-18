package nro;

public final class InfoDlg {
   public static boolean a;
   private static String c;
   private static String d;
   private static int e;
   public static boolean b;

   public static void a(String var0, String var1, int var2) {
      if (var0 != null) {
         a = true;
         c = var0;
         d = var1;
         e = var2;
      }
   }

   public static void a() {
      a(mResources.aA, (String)null, 1000);
      b = true;
   }

   public static void a(mGraphics var0) {
      if (a) {
         if (!b || e <= 4990) {
            Paint.paintCmdBar(main.GameCanvas.B - 75, 10, 150, 55, var0);
            if (b) {
               main.GameCanvas.a(main.GameCanvas.B - mFont.t.getWidth(c) / 2 - 10, 38, var0);
               mFont.t.drawStringBd(var0, c, main.GameCanvas.B + 5, 31, 2);
            } else if (d != null) {
               mFont.t.drawStringBd(var0, c, main.GameCanvas.B, 23, 2);
               mFont.m.drawStringBd(var0, d, main.GameCanvas.B, 40, 2);
            } else {
               mFont.t.drawStringBd(var0, c, main.GameCanvas.B, 31, 2);
            }
         }
      }
   }

   public static void b() {
      if (e > 0 && --e == 0) {
         hide();
      }

   }

   public static void hide() {
      c = "";
      d = null;
      b = false;
      e = 0;
      a = false;
   }
}
