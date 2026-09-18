package nro;

import java.util.Random;

public final class MonsterDart extends Effect2 {
   private int d;
   private DartInfo e;
   public static Random a = new Random(System.currentTimeMillis());
   private int f;
   private int g;
   private int h;
   private int i;
   private int j;
   private int k;
   private boolean l = false;
   private int m;
   private int n;
   private Char o;
   private MyVector p = new MyVector("vDarts");
   private int q = 0;
   private int r = 0;
   private static int[] s = new int[]{0, 15, 37, 52, 75, 105, 127, 142, 165, 195, 217, 232, 255, 285, 307, 322, 345, 370};
   public static final int[] b = new int[]{0, 0, 0, 7, 6, 6, 6, 2, 2, 3, 3, 4, 5, 5, 5, 1};
   public static final byte[] c = new byte[]{0, 1, 2, 1, 0, 1, 2, 1, 0, 1, 2, 1, 0, 1, 2, 1, 0, 1, 2, 1, 0, 1, 2, 1, 0};

   public static void addMonsterDart(int var0, int var1, boolean var2, int var3, int var4, Char var5, int var6) {
      Effect2.vEffect2.addElement(new MonsterDart(var0, var1, var2, var3, var4, var5, var6));
   }

   private MonsterDart(int var1, int var2, boolean var3, int var4, int var5, Char var6, int var7) {
      this.e = GameScr.w[var7];
      this.i = var1;
      this.j = var2;
      this.m = var4;
      this.n = var5;
      this.o = var6;
      this.d = this.e.i;
      int var8 = ResLog.a(var6.cx - var1, var6.cy - var2);
      this.f = var8;
      this.g = this.d * ResLog.b(var8) >> 10;
      this.h = this.d * ResLog.a(var8) >> 10;
      if (var1 >= GameScr.cmx && var1 <= GameScr.cmx + main.GameCanvas.z) {
         SoundMn.stopAll();
      }

   }

   public final void update() {
      int var1;
      for(var1 = 0; var1 < this.e.h; ++var1) {
         if (this.e.c.length > 0) {
            this.p.addElement(new nr_du(this.i, this.j));
         }

         this.q = (this.o != null ? this.o.cx : 0) - this.i;
         this.r = (this.o != null ? this.o.cy : 0) - 10 - this.j;
         short var2 = 60;
         if (TileMap.l == 0) {
            var2 = 600;
         }

         ++this.k;
         if (this.o != null && (this.o.statusMe == 5 || this.o.statusMe == 14) || this.o == null) {
            this.i += ((this.o != null ? this.o.cx : 0) - this.i) / 2;
            this.j += ((this.o != null ? this.o.cy : 0) - this.j) / 2;
         }

         if (ResLog.g(this.q) < 16 && ResLog.g(this.r) < 16 || this.k > var2) {
            if (this.o != null && this.o.charID >= 0 && this.n != -1) {
               if (this.n != -100) {
                  this.o.a(this.m, this.n, false, true);
               } else {
                  ServerEffect.a(80, (Char)this.o, 1);
               }
            }

            Effect2.vEffect2.removeElement(this);
            if (this.n != -100) {
               ServerEffect.a(81, (Char)this.o, 1);
               if (this.i >= GameScr.cmx && this.i <= GameScr.cmx + main.GameCanvas.z) {
                  SoundMn.stopAll();
               }
            }

            return;
         }

         int var3;
         if (Math.abs((var3 = ResLog.a(this.q, this.r)) - this.f) < 90 || this.q * this.q + this.r * this.r > 4096) {
            if (Math.abs(var3 - this.f) < 15) {
               this.f = var3;
            } else if ((var3 - this.f < 0 || var3 - this.f >= 180) && var3 - this.f >= -180) {
               this.f = ResLog.c(this.f - 15);
            } else {
               this.f = ResLog.c(this.f + 15);
            }
         }

         if (this.d < 8192) {
            this.d += 1024;
         }

         this.g = this.d * ResLog.b(this.f) >> 10;
         this.h = this.d * ResLog.a(this.f) >> 10;
         this.q += this.g;
         var3 = this.q >> 10;
         this.i += var3;
         this.q &= 1023;
         this.r += this.h;
         var3 = this.r >> 10;
         this.j += var3;
         this.r &= 1023;
      }

      for(var1 = 0; var1 < this.p.size(); ++var1) {
         nr_du var4;
         ++(var4 = (nr_du)this.p.elementAt(var1)).a;
         if (var4.a >= this.e.c.length) {
            this.p.removeElementAt(var1);
         }
      }

   }

   public static int a(int var0) {
      for(int var1 = 0; var1 < s.length - 1; ++var1) {
         if (var0 >= s[var1] && var0 <= s[var1 + 1]) {
            if (var1 >= 16) {
               return 0;
            }

            return var1;
         }
      }

      return 0;
   }

   public final void paint(mGraphics var1) {
      int var2 = a(360 - this.f);
      byte var3 = c[var2];
      var2 = b[var2];

      int var4;
      for(var4 = this.p.size() / 2; var4 < this.p.size(); ++var4) {
         nr_du var5 = (nr_du)this.p.elementAt(var4);
         SmallImage.b(var1, this.e.d[var5.a], var5.b, var5.c, 0, 3);
      }

      var4 = main.GameCanvas.v % this.e.b.length;
      SmallImage.b(var1, this.e.b[var4][var3], this.i, this.j, var2, 3);

      nr_du var6;
      int var7;
      for(var7 = 0; var7 < this.p.size(); ++var7) {
         var6 = (nr_du)this.p.elementAt(var7);
         SmallImage.b(var1, this.e.c[var6.a], var6.b, var6.c, 0, 3);
      }

      SmallImage.b(var1, this.e.a[var4][var3], this.i, this.j, var2, 3);

      for(var7 = 0; var7 < this.p.size(); ++var7) {
         var6 = (nr_du)this.p.elementAt(var7);
         if (ResLog.g(a.nextInt(100)) < this.e.g) {
            SmallImage.b(var1, main.GameCanvas.v % 2 == 0 ? this.e.e[var6.a] : this.e.f[var6.a], var6.b, var6.c, 0, 3);
         }
      }

   }
}
