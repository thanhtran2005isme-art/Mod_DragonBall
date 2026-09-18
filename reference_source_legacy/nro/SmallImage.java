package nro;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import javax.microedition.lcdui.Image;

public final class SmallImage {
   public static int[][] a;
   public static Image[] b;
   public static Small[] c;
   public static MyVector d = new MyVector("vKeys");
   private static Image g = null;
   public static byte[] e;
   private static int h;
   public static short f;

   public static void loadBigRMS() {
      if (b == null) {
         b = new Image[]{mSystem.loadImageRMS("/img/Big0.png"), mSystem.loadImageRMS("/img/Big1.png"), mSystem.loadImageRMS("/img/Big2.png"), mSystem.loadImageRMS("/img/Big3.png")};
         System.gc();
      }

   }

   public static void loadBigImage() {
      System.gc();
      g = Image.createRGBImage(new int[]{-2013265920}, 1, 1, true);
   }

   public SmallImage() {
      readImage();
   }

   public static void init() {
      new SmallImage();
   }

   private static void readImage() {
      try {
         DataInputStream var0;
         short var1;
         a = new int[var1 = (var0 = new DataInputStream(new ByteArrayInputStream(Rms.loadRMS("NR_image")))).readShort()][5];

         for(int var2 = 0; var2 < var1; ++var2) {
            a[var2][0] = var0.readUnsignedByte();
            a[var2][1] = var0.readShort();
            a[var2][2] = var0.readShort();
            a[var2][3] = var0.readShort();
            a[var2][4] = var0.readShort();
            if ((var2 < 84 || var2 > 90) && (var2 < 372 || var2 > 384) && (var2 < 371 || var2 > 377) && (a[var2][1] >= 256 || a[var2][3] >= 256 || a[var2][2] >= 256 || a[var2][4] >= 256)) {
               a[var2] = null;
            }
         }

      } catch (Exception var3) {
         var3.printStackTrace();
      }
   }

   public static void createImage(int var0) {
      Image var1;
      if (mGraphics.zoomLevel == 1) {
         if ((var1 = mSystem.load("/SmallImage/Small" + var0 + ".png")) != null) {
            c[var0] = new Small(var1, var0);
         } else {
            c[var0] = new Small(g, var0);
            Service.gI().p(var0);
         }
      } else if ((var1 = mSystem.load("/SmallImage/Small" + var0 + ".png")) != null) {
         c[var0] = new Small(var1, var0);
      } else {
         boolean var3 = false;
         byte[] var2;
         if ((var2 = Rms.loadRMS(mGraphics.zoomLevel + "Small" + var0)) != null) {
            if (e != null && var2.length % 127 != e[var0]) {
               var3 = true;
            }

            if (!var3) {
               Image var4;
               if ((var4 = Image.createImage(var2, 0, var2.length)) != null) {
                  c[var0] = new Small(var4, var0);
               } else {
                  var3 = true;
               }
            }
         } else {
            var3 = true;
         }

         if (var3) {
            c[var0] = new Small(g, var0);
            Service.gI().p(var0);
         }

      }
   }

   public static void drawSmallImage(mGraphics var0, int var1, int var2, int var3, int var4, int var5) {
      b(var0, var1, var2, var3, 0, var5);
   }

   public static void b(mGraphics var0, int var1, int var2, int var3, int var4, int var5) {
      try {
         Small var6;
         if (b == null) {
            if ((var6 = c[var1]) == null) {
               createImage(var1);
               return;
            }

            var0.setColor(var6.a, 0, 0, mGraphics.setColor(var6.a), mGraphics.b(var6.a), var4, var2, var3, var5);
            return;
         }

         if (a != null) {
            if (var1 < a.length && a[var1] != null && a[var1][1] < 256 && a[var1][3] < 256 && a[var1][2] < 256 && a[var1][4] < 256) {
               if (a[var1][0] != 4 && b[a[var1][0]] != null) {
                  var0.setColor(b[a[var1][0]], a[var1][1], a[var1][2], a[var1][3], a[var1][4], var4, var2, var3, var5);
                  return;
               }

               if ((var6 = c[var1]) == null) {
                  createImage(var1);
                  return;
               }

               var6.a(var0, var4, var2, var3, var5);
               return;
            }

            if ((var6 = c[var1]) == null) {
               createImage(var1);
               return;
            }

            var6.a(var0, var4, var2, var3, var5);
            return;
         }

         if (main.GameCanvas.currentScreen != GameScr.gI()) {
            if ((var6 = c[var1]) == null) {
               createImage(var1);
               return;
            }

            var6.a(var0, var4, var2, var3, var5);
            return;
         }
      } catch (Exception var7) {
      }

   }

   public static void drawSmallImage(mGraphics var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      try {
         Small var9;
         if (b == null) {
            if ((var9 = c[var1]) == null) {
               createImage(var1);
               return;
            }

            var0.setColor(var9.a, 0, var2 * var5, var5, var6, var7, var3, var4, var8);
            return;
         }

         if (a != null) {
            if (var1 < a.length && a[var1] != null && a[var1][1] < 256 && a[var1][3] < 256 && a[var1][2] < 256 && a[var1][4] < 256) {
               if (a[var1][0] != 4 && b[a[var1][0]] != null) {
                  var0.setColor(b[a[var1][0]], 0, var2 * var5, var5, var6, var7, var3, var4, var8);
                  return;
               }

               if ((var9 = c[var1]) == null) {
                  createImage(var1);
                  return;
               }

               var9.a(var0, var7, var2, var3, var4, var5, var6, var8);
               return;
            }

            if ((var9 = c[var1]) == null) {
               createImage(var1);
               return;
            }

            var9.a(var0, var7, var2, var3, var4, var5, var6, var8);
            return;
         }

         if (main.GameCanvas.currentScreen != GameScr.gI()) {
            if ((var9 = c[var1]) == null) {
               createImage(var1);
               return;
            }

            var9.a(var0, var7, var2, var3, var4, var5, var6, var8);
            return;
         }
      } catch (Exception var10) {
      }

   }

   public static void update() {
      int var0 = 0;
      if (main.GameCanvas.v % 1000 == 0) {
         for(int var1 = 0; var1 < c.length; ++var1) {
            if (c[var1] != null) {
               ++var0;
               Small var2;
               ++(var2 = c[var1]).d;
               if (var2.d - var2.c > 1 && !Char.myCharz().a(var2.b)) {
                  c[var2.b] = null;
               }

               ++h;
            }
         }

         if (var0 > 200 && main.GameCanvas.a) {
            c = new Small[f];
         }
      }

   }
}
