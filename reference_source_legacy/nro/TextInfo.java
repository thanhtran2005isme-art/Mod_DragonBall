package nro;

public final class TextInfo {
   private static int a;
   private static int b;
   private static int c;
   private static boolean d;
   private static String e = "";

   public static void reset() {
      a = 0;
      b = 0;
      d = false;
   }

   public static void a(mGraphics var0, String var1, int var2, int var3, int var4, int var5, mFont var6) {
      if (c != var6.getWidth(var1) || !e.equals(var1)) {
         e = var1;
         a = 0;
         c = var6.getWidth(var1);
         d = false;
         b = 0;
      }

      var0.e(var2, var3, var4, var5);
      if (c > var4) {
         var6.drawStringBd(var0, var1, var2 - a, var3, 0);
      } else {
         var6.drawStringBd(var0, var1, var2 + var4 / 2, var3, 2);
      }

      main.GameCanvas.a(var0);
      if (c > var4) {
         if (!d) {
            if (++b > 50 && ++a >= c) {
               b = 0;
               a = -var4 + 30;
               d = true;
               return;
            }
         } else {
            if (a < 0) {
               int var7 = var4 + a >> 1;
               a += var7;
            }

            if (a > 0) {
               a = 0;
            }

            if (a == 0 && ++b == 50) {
               b = 0;
               d = false;
            }
         }
      }

   }
}
