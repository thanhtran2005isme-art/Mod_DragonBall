package nro;

import javax.microedition.lcdui.Image;

public final class PopUp {
   public static MyVector a = new MyVector("vPopups");
   public int b = 100;
   private int l;
   public String[] c;
   public int d;
   public int e;
   public int f;
   public int g;
   public boolean h = false;
   private int m = 0;
   private int n;
   public CommandLine i;
   public boolean j = true;
   public boolean k = false;
   private static Image o;
   private static Image p;
   private static Image q;
   private static Image r;

   public static void a() {
      if (o == null) {
         o = mSystem.load("/mainImage/myTexture2dbd3.png");
      }

      if (q == null) {
         q = mSystem.load("/mainImage/myTexture2dimgPopup.png");
      }

      if (r == null) {
         r = mSystem.load("/mainImage/myTexture2dimgPopup2.png");
      }

      if (p == null && mSystem.d == 1) {
         p = mSystem.load("/mainImage/portal.png");
      }

   }

   public PopUp(String var1, int var2, int var3) {
      if (var1.length() < 10) {
         this.b = 60;
      }

      if (main.GameCanvas.z == 128) {
         this.b = 128;
      }

      this.c = mFont.tahoma_7b_dark.getWidth(var1, this.b - 10);
      this.l = 7;
      this.d = var2 - this.b / 2 - 1;
      this.e = var3 - 15 + this.l - this.c.length * 12 - 10;
      this.f = this.b + 2;

      for(this.g = (this.c.length + 1) * 12 + 1; this.f % 10 != 0; ++this.f) {
      }

      while(this.g % 10 != 0) {
         ++this.g;
      }

      if (var2 >= 0 && var2 <= 24) {
         this.d += this.f / 2 + 30;
      }

      if (var2 <= TileMap.a * 24 && var2 >= TileMap.a * 24 - 24) {
         this.d -= this.f / 2 + 6;
      }

      while(this.d <= 30) {
         this.d += 2;
      }

      while(this.d + this.f >= TileMap.a * 24 - 30) {
         this.d -= 2;
      }

   }

   public final void a(String[] var1, int var2, int var3) {
      this.b = 0;

      for(int var4 = 0; var4 < var1.length; ++var4) {
         if (this.b < mFont.tahoma_7b_dark.getWidth(var1[var4])) {
            this.b = mFont.tahoma_7b_dark.getWidth(var1[var4]);
         }
      }

      this.b += 20;
      this.c = var1;
      this.l = 7;
      this.d = var2 - this.b / 2 - 1;
      this.e = var3 - 15 + this.l - this.c.length * 12 - 10;
      this.f = this.b + 2;

      for(this.g = (this.c.length + 1) * 12 + 1; this.f % 10 != 0; ++this.f) {
      }

      while(this.g % 10 != 0) {
         ++this.g;
      }

      if (var2 >= 0 && var2 <= 24) {
         this.d += this.f / 2 + 30;
      }

      if (var2 <= TileMap.a * 24 && var2 >= TileMap.a * 24 - 24) {
         this.d -= this.f / 2 + 6;
      }

      while(this.d <= 30) {
         this.d += 2;
      }

      while(this.d + this.f >= TileMap.a * 24 - 30) {
         this.d -= 2;
      }

   }

   public static void a(PopUp var0) {
      a.addElement(var0);
   }

   public static void paintPopUp(mGraphics var0, int var1, int var2, int var3, int var4, int var5, boolean var6) {
      if (!var6) {
         var0.setColor(0);
         var0.fillRect(var1 + 6, var2, var3 - 14 + 1, var4);
         var0.fillRect(var1, var2 + 6, var3, var4 - 12 + 1);
         var0.setColor(var5);
         var0.fillRect(var1 + 6, var2 + 1, var3 - 12, var4 - 2);
         var0.fillRect(var1 + 1, var2 + 6, var3 - 2, var4 - 12);
         var0.setColor(o, 0, 0, 7, 6, 0, var1, var2, 0);
         var0.setColor(o, 0, 0, 7, 6, 2, var1 + var3 - 7, var2, 0);
         var0.setColor(o, 0, 0, 7, 6, 6, var1, var2 + var4 - 7, 0);
         var0.setColor(o, 0, 0, 7, 6, 3, var1 + var3 - 7, var2 + var4 - 6, 0);
      } else {
         Image var10 = var5 == 1 ? r : q;
         var0.setColor(var10, 0, 0, 10, 10, 0, var1, var2, 0);
         var0.setColor(var10, 0, 20, 10, 10, 0, var1 + var3 - 10, var2, 0);
         var0.setColor(var10, 0, 50, 10, 10, 0, var1, var2 + var4 - 10, 0);
         var0.setColor(var10, 0, 70, 10, 10, 0, var1 + var3 - 10, var2 + var4 - 10, 0);
         int var7 = (var3 - 20) % 10 == 0 ? (var3 - 20) / 10 : (var3 - 20) / 10 + 1;
         int var8 = (var4 - 20) % 10 == 0 ? (var4 - 20) / 10 : (var4 - 20) / 10 + 1;

         int var9;
         for(var9 = 0; var9 < var7; ++var9) {
            var0.setColor(var10, 0, 10, 10, 10, 0, var1 + 10 + var9 * 10, var2, 0);
         }

         for(var9 = 0; var9 < var8; ++var9) {
            var0.setColor(var10, 0, 30, 10, 10, 0, var1, var2 + 10 + var9 * 10, 0);
         }

         for(var9 = 0; var9 < var7; ++var9) {
            var0.setColor(var10, 0, 60, 10, 10, 0, var1 + 10 + var9 * 10, var2 + var4 - 10, 0);
         }

         for(var9 = 0; var9 < var8; ++var9) {
            var0.setColor(var10, 0, 40, 10, 10, 0, var1 + var3 - 10, var2 + 10 + var9 * 10, 0);
         }

         var0.setColor(var5 == 1 ? 12052656 : 16770503);
         var0.fillRect(var1 + 10, var2 + 10, var3 - 20, var4 - 20);
      }
   }

   public final void a(int var1) {
      this.n = 10;
   }

   public static void a(mGraphics var0) {
      for(int var1 = 0; var1 < a.size(); ++var1) {
         PopUp var10000 = (PopUp)a.elementAt(var1);
         mGraphics var3 = var0;
         PopUp var2 = var10000;
         if (var10000.j && var2.c != null && ChatPopup.currChatPopup == null && !var2.k) {
            int var4;
            int var5;
            if (mSystem.d == 1) {
               var4 = var2.d;
               var5 = var2.e - main.GameCanvas.ac;
               var0.e(var4, var5, var2.f, var2.g);
               var0.drawImage(p, var4, var5, 0);
               if (var2.f > 70) {
                  var0.drawImage(p, var4 + 70, var5, 0);
               }

               if (var2.g > 30) {
                  var0.drawImage(p, var4, var5 + 30, 0);
                  if (var2.f > 70) {
                     var0.drawImage(p, var4 + 70, var5 + 30, 0);
                  }
               }

               var0.e(GameScr.cmx, GameScr.cmy, main.GameCanvas.z, main.GameCanvas.A);
            } else {
               int var10002 = var2.e - main.GameCanvas.ac;
               boolean var9 = var2.n != 0;
               int var8 = var2.g;
               int var7 = var2.f;
               int var6 = var10002;
               var5 = var2.d;
               if (var9) {
                  var0.setColor(var5, var6, var7, var8, 16777215);
               } else {
                  var0.setColor(var5, var6, var7, var8, 0);
               }
            }

            for(var4 = 0; var4 < var2.c.length; ++var4) {
               (var2.n == 0 ? mFont.c : mFont.g).drawStringBd(var3, var2.c[var4], var2.d + var2.f / 2, var2.e + (var2.g / 2 - var2.c.length * 12 / 2) + var4 * 12 - main.GameCanvas.ac, 2);
            }
         }
      }

   }

   public static void b() {
      for(int var0 = 0; var0 < a.size(); ++var0) {
         PopUp var1 = (PopUp)a.elementAt(var0);
         if (Char.myCharz().aD != null && Char.myCharz().aD.c == 0) {
            if (var1.d + var1.f >= GameScr.cmx && var1.d <= main.GameCanvas.z + GameScr.cmx && var1.e + var1.g >= GameScr.cmy && var1.e <= main.GameCanvas.A + GameScr.cmy) {
               var1.k = false;
            } else {
               var1.k = true;
            }
         }

         if (Char.myCharz().aD == null || Char.myCharz().aD != null && Char.myCharz().aD.c != 0) {
            if (var1.d + var1.f / 2 >= Char.myCharz().cx - 100 && var1.d + var1.f / 2 <= Char.myCharz().cx + 100 && var1.e + var1.g >= GameScr.cmy && var1.e <= main.GameCanvas.A + GameScr.cmy) {
               var1.k = false;
            } else {
               var1.k = true;
            }
         }

         if (var1.n > 0) {
            --var1.n;
            if (var1.n == 0 && var1.i != null) {
               var1.i.performAction();
            }
         }

         if (var1.h) {
            if (Char.myCharz().aD != null) {
               if (Char.myCharz().aD.c == 0) {
                  if (Char.myCharz().aD.a == 0) {
                     var1.j = false;
                  }

                  if (Char.myCharz().aD.a == 1) {
                     var1.j = true;
                  }

                  if (Char.myCharz().aD.a > 1 && Char.myCharz().aD.a < 6) {
                     var1.j = false;
                  }
               } else if (!var1.j) {
                  ++var1.m;
                  if (var1.m == 50) {
                     var1.j = true;
                  }
               }
            } else if (!var1.j) {
               Hint.i = false;
               ++var1.m;
               if (var1.m == 50) {
                  var1.j = true;
                  Hint.i = true;
               }
            }
         }
      }

   }
}
