package nro;

import javax.microedition.lcdui.Image;

public final class ItemMap implements IMapObject {
   public int a;
   public int b;
   private int g;
   private int h;
   private int i;
   private int j;
   public int c;
   public int d;
   public ItemTemplate template;
   private byte k;
   private int l;
   private int m;
   private int n;
   private int o;
   private int p;
   private int q;
   private int[] r;
   private int[] s;
   private int[] t;
   private int[] u;
   private int v;
   private int w;
   public static Image myTexture2dflare = mSystem.load("/mainImage/myTexture2dflare.png");
   private static Image myTexture2ditemaura1 = mSystem.load("/mainImage/myTexture2ditemaura1.png");
   private static Image myTexture2ditemaura2 = mSystem.load("/mainImage/myTexture2ditemaura2.png");
   private static Image myTexture2ditemaura3 = mSystem.load("/mainImage/myTexture2ditemaura3.png");

   public ItemMap(short var1, short var2, int var3, int var4, int var5, int var6) {
      this.d = var1;
      this.template = ItemTemplates.get(var2);
      this.a = var5;
      this.b = var4;
      this.g = var5;
      this.h = var6;
      this.i = var5 - var3 >> 2;
      this.j = 5;
   }

   public ItemMap(int var1, short var2, short var3, int var4, int var5, short var6) {
      this.d = var2;
      this.template = ItemTemplates.get(var3);
      this.a = this.g = var4;
      this.b = this.h = var5;
      this.k = 1;
      this.c = var1;
      if (this.b()) {
         this.l = var6;
         this.m = this.a;
         this.n = this.b;
         this.q = 120;
         this.o = 0;
         if (!main.GameCanvas.a) {
            this.p = 360 / this.q;
            this.r = new int[this.q];
            this.s = new int[this.q];
            this.t = new int[this.q];
            this.u = new int[this.q];
            this.c();
         }
      }

   }

   public final void a(int var1, int var2) {
      this.g = var1;
      this.h = var2;
      this.i = var1 - this.a >> 2;
      this.j = var2 - this.b >> 2;
      this.k = 2;
   }

   public final void a() {
      if (this.k == 2 && this.a == this.g && this.b == this.h) {
         GameScr.vItemMap.removeElement(this);
         if (Char.myCharz().aV != null && Char.myCharz().aV.equals(this)) {
            Char.myCharz().aV = null;
         }

      } else {
         if (this.k > 0) {
            if (this.i == 0) {
               this.a = this.g;
            }

            if (this.j == 0) {
               this.b = this.h;
            }

            if (this.a != this.g) {
               this.a += this.i;
               if (this.i > 0 && this.a > this.g || this.i < 0 && this.a < this.g) {
                  this.a = this.g;
               }
            }

            if (this.b != this.h) {
               this.b += this.j;
               if (this.j > 0 && this.b > this.h || this.j < 0 && this.b < this.h) {
                  this.b = this.h;
               }
            }
         } else {
            this.k = (byte)(this.k - 4);
            if (this.k < -12) {
               this.b -= 12;
               this.k = 1;
            }
         }

         if (this.b()) {
            ++this.v;
            ++this.w;
            if (this.w >= 40) {
               this.w = 0;
            }

            if (this.v >= this.q) {
               this.v = 0;
            }

            if (this.v % 10 == 0 && !main.GameCanvas.a) {
               ServerEffect.addServerEffect(114, this.a - 5, this.b - 30, 1);
            }
         }

      }
   }

   public final void a(mGraphics var1) {
      if (this.b()) {
         var1.drawImage(TileMap.x, this.a + 3, this.b, 3);
         if (this.k <= 0) {
            if (this.w < 10) {
               var1.drawImage(myTexture2ditemaura1, this.a, this.b + this.k + 3, 33);
            } else {
               var1.drawImage(myTexture2ditemaura2, this.a, this.b + this.k + 3, 33);
            }
         } else if (this.w < 10) {
            var1.drawImage(myTexture2ditemaura1, this.a, this.b + 3, 33);
         } else {
            var1.drawImage(myTexture2ditemaura2, this.a, this.b + 3, 33);
         }

         mGraphics var2 = var1;
         ItemMap var4 = this;
         if (!main.GameCanvas.a) {
            for(int var3 = 0; var3 < var4.s.length; ++var3) {
               if (var4.v == var3) {
                  if (var4.w <= 20) {
                     var2.drawImage(myTexture2ditemaura3, var4.t[var3], var4.u[var3] + 3, 33);
                  } else {
                     SmallImage.b(var2, var4.template.f, var4.t[var3], var4.u[var3] + 3, 0, 33);
                  }
               }
            }
         }

      } else {
         if (!this.b()) {
            if (main.GameCanvas.v % 4 == 0) {
               var1.drawImage(myTexture2dflare, this.a, this.b + this.k + 13, 33);
            }

            if (this.k <= 0) {
               SmallImage.b(var1, this.template.f, this.a, this.b + this.k + 3, 0, 33);
            } else {
               SmallImage.b(var1, this.template.f, this.a, this.b + 3, 0, 33);
            }

            if (Char.myCharz().aV != null && Char.myCharz().aV.equals(this) && this.k != 2) {
               var1.setColor(Mob.R, 0, 24, 9, 6, 0, this.a, this.b - 17, 3);
            }
         }

      }
   }

   private boolean b() {
      boolean var1;
      if (this.template.type == 22) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   private void c() {
      if (!main.GameCanvas.a) {
         for(int var1 = 0; var1 < this.s.length; ++var1) {
            this.s[var1] = ResLog.g(this.l * ResLog.a(this.o) / 1024);
            this.r[var1] = ResLog.g(this.l * ResLog.b(this.o) / 1024);
            if (this.o < 90) {
               this.t[var1] = this.m + this.r[var1];
               this.u[var1] = this.n - this.s[var1];
            } else if (this.o >= 90 && this.o < 180) {
               this.t[var1] = this.m - this.r[var1];
               this.u[var1] = this.n - this.s[var1];
            } else if (this.o >= 180 && this.o < 270) {
               this.t[var1] = this.m - this.r[var1];
               this.u[var1] = this.n + this.s[var1];
            } else {
               this.t[var1] = this.m + this.r[var1];
               this.u[var1] = this.n + this.s[var1];
            }

            this.o += this.p;
         }
      }

   }

   public final int getX() {
      return this.a;
   }

   public final int getY() {
      return this.b;
   }

   public final int getH() {
      return 20;
   }

   public final int getW() {
      return 20;
   }

   public final void stopMoving() {
   }

   public final boolean isInvisible() {
      return false;
   }
}
