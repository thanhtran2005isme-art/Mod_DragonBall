package nro;

import javax.microedition.lcdui.Image;

public final class MobCapcha {
   private static Image c = mSystem.load("/mainImage/myTexture2dmobCapcha.png");
   private static int d;
   private static int e;
   private static int f;
   private static int g;
   private static int h;
   private static int i;
   private static int j;
   private static int k;
   public static boolean a;
   private static int l = 0;
   private static int m;
   private static int n;
   private static int o;
   public static boolean b;

   public static void a(mGraphics var0, int var1, int var2) {
      if (!b) {
         if (main.GameCanvas.v % 3 == 0) {
            if (Char.myCharz().I == 1) {
               h = var1 - 20 - GameScr.cmx;
            }

            if (Char.myCharz().I == -1) {
               h = var1 + 20 - GameScr.cmx;
            }
         }

         d = Char.myCharz().cy - 40 - GameScr.cmy;
      } else {
         if (++l == 5) {
            b = false;
            l = 0;
         }

         h = var1 - GameScr.cmx;
         d = var2 - GameScr.cmy;
      }

      if (i > var1 - GameScr.cmx) {
         o = -1;
      } else {
         o = 1;
      }

      var0.drawImage(GameScr.bq, i, e - 40, 3);
      PopUp.paintPopUp(var0, i - 25, e - 70, 50, 20, 16777215, false);
      int var10004 = e - 65;
      mFont.tahoma_7b_dark.drawStringBd(var0, GameScr.gI().br, i, var10004, 2);
      if (a) {
         a = false;
         EffecMn.addEff(new Effect(18, i + GameScr.cmx, e + GameScr.cmy, 2, 10, -1));
         GameScr.gI().aK = null;
         h = -GameScr.cmx;
         d = -GameScr.cmy;
      }

      var0.setColor(c, 0, n * 40, 40, 40, o == 1 ? 0 : 2, i, e + 3 + (main.GameCanvas.v % 10 > 5 ? 1 : 0), 3);
      if (e != d) {
         g = d - e << 2;
         f += g;
         e += f >> 4;
         f &= 15;
      }

      if (i != h) {
         k = h - i << 2;
         j += k;
         i += j >> 4;
         j &= 15;
      }

      if (++m == 5) {
         m = 0;
         if (++n > 2) {
            n = 0;
         }
      }

   }
}
