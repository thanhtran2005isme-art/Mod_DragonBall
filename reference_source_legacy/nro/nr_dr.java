package nro;

import java.util.Random;
import java.util.Vector;

public final class nr_dr {
   private static Random a = new Random();
   private static Vector b = new Vector();
   private static int c;
   private static int d;
   private static int e;
   private static int f;
   private static int g;
   private static int h;
   private static int i;
   private static float j;
   private static int[] k = new int[3];
   private static int[] l = new int[3];
   private static boolean m = false;
   private static long n = 0L;
   private static long o = 150L;

   public static void a(mGraphics var0) {
      if (m) {
         l[2] = l[1];
         k[2] = k[1];
         l[1] = l[0];
         k[1] = k[0];
         l[0] = d;
         k[0] = c;
         c = (int)(Math.cos((double)e * 3.141592653589793D / 180.0D) * (double)i * (double)h) + f;
         d = (int)((double)i * Math.sin((double)e * 3.141592653589793D / 180.0D) * (double)h - (double)(0.0F * (float)h * (float)h / 2.0F));
         if (System.currentTimeMillis() - n >= o) {
            ++h;
            n = System.currentTimeMillis();
         }
      }

      if (h > 32 && m) {
         m = false;
         b.removeAllElements();
         b.addElement(new FireWorkMn(ResLog.random(50, main.GameCanvas.z - 50), ResLog.random(main.GameCanvas.A - 100, main.GameCanvas.A), 5, 72));
      }

      var0.setColor(0);
      var0.fillRect(0, 0, 0, 0);
      var0.setColor(16711680);

      for(int var1 = 0; var1 < b.size(); ++var1) {
         FireWorkMn var10000 = (FireWorkMn)b.elementAt(var1);
         mGraphics var3 = var0;
         FireWorkMn var2 = var10000;

         for(int var4 = 0; var4 < var2.a.size(); ++var4) {
            Controller2 var5;
            if ((var5 = (Controller2)var2.a.elementAt(var4)).f < -200) {
               var2.a.removeElementAt(var4);
            }

            mGraphics var6 = var3;
            var5 = var5;
            Controller2.a(var3, var5.a - var5.e, var5.b - var5.f, var5.j);

            for(int var7 = 0; var7 < 2; ++var7) {
               Controller2.a(var6, var5.a - var5.o[var7], var5.b - var5.p[var7], var5.j);
            }

            if (var5.n && System.currentTimeMillis() - var5.l >= var5.m) {
               ++var5.i;
               var5.l = System.currentTimeMillis();
               var5.o[1] = var5.o[0];
               var5.p[1] = var5.p[0];
               var5.o[0] = var5.e;
               var5.p[0] = var5.f;
               var5.e = (int)(Math.cos((double)var5.h * 3.141592653589793D / 180.0D) * (double)var5.c * (double)var5.i) + var5.d;
               var5.f = (int)((double)var5.c * Math.sin((double)var5.h * 3.141592653589793D / 180.0D) * (double)var5.i - (double)(var5.k * (float)var5.i * (float)var5.i / 2.0F)) + var5.g;
            }
         }
      }

      if (!m) {
         int var8;
         if ((var8 = -(Math.abs(a.nextInt() % 3) + 5)) == -5 && !m) {
            f = 0;
            e = 80;
            m = true;
            a();
            return;
         }

         if (var8 == -7 && !m) {
            e = 60;
            f = 0;
            m = true;
            a();
            return;
         }

         if (var8 == -6 && !m) {
            e = 120;
            f = 0;
            m = true;
            a();
         }
      }

   }

   private static void a() {
      g = 0;
      i = 16;
      h = 0;
      j = 0.0F;

      for(int var0 = 0; var0 < 3; ++var0) {
         l[var0] = 0;
         k[var0] = f;
      }

      m = true;
   }
}
