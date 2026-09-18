package nro;

public final class Mabu extends Char {
   private static EffectData effectData;
   private static EffectData effectData1;
   private int tick = 0;
   private int d;
   private boolean addFoot;
   private Effect f;
   private Char g;
   private int h;
   private int i;
   private Char[] j;
   private int[] k;
   private int l;
   private int[] m = new int[]{0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5};
   private int[] n = new int[]{0, 0, 6, 6, 7, 7, 8, 8, 9, 9, 9, 9, 9, 10, 10};
   private int[] dc = new int[]{0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 10, 10, 11, 11, 12, 12};
   private int[] dd = new int[]{13, 13, 14, 14, 15, 15, 16, 16};
   private int[][] de;
   private byte skillID;
   private int frame;
   private int dh;

   public final void c(int var1) {
      this.f = new Effect(105, this.cx, this.cy + 20, 2, 1, -1);
      EffecMn.addEff(this.f);
      if (var1 == Char.myCharz().charID) {
         this.g = Char.myCharz();
      } else {
         this.g = GameScr.findCharInMap(var1);
      }
   }

   public final void checkFrameTick(int[] var1) {
      if (this.skillID == 0) {
         if (this.tick == 11) {
            this.addFoot = true;
            EffecMn.addEff(new Effect(19, this.cx, this.cy + 20, 2, 1, -1));
         }

         if (this.tick >= var1.length - 1) {
            this.skillID = 2;
            return;
         }
      }

      if (this.skillID == 1 && this.tick == var1.length - 1) {
         this.skillID = 3;
         this.cy -= 15;
      } else {
         ++this.tick;
         if (this.tick > var1.length - 1) {
            this.tick = 0;
         }

         this.frame = var1[this.tick];
      }
   }

   public Mabu() {
      this.de = new int[][]{this.m, this.n, this.dc, this.dd};
      this.skillID = -1;
      effectData = null;
      effectData = new EffectData();
      String var1 = "/x" + mGraphics.zoomLevel + "/effectdata/" + 102 + "/data";

      try {
         effectData.readData2(var1);
         effectData.a = mSystem.loadImage("/effectdata/102/img.png");
      } catch (Exception var3) {
      }

      effectData1 = null;
      effectData1 = new EffectData();
      var1 = "/x" + mGraphics.zoomLevel + "/effectdata/" + 103 + "/data";

      try {
         effectData1.readData2(var1);
         effectData1.a = mSystem.loadImage("/effectdata/103/img.png");
      } catch (Exception var2) {
      }
   }

   public final void a(byte var1, short var2, short var3, Char[] var4, int[] var5) {
      this.skillID = var1;
      this.h = var2;
      this.i = var3;
      this.d = this.I;
      this.I = this.h > this.cx ? 1 : -1;
      this.j = var4;
      this.k = var5;
   }

   public final void a() {
      if (this.g != null) {
         Effect var10000;
         if (this.f.e >= 30) {
            var10000 = this.f;
            var10000.f += (this.cx - this.f.f) / 4;
            var10000 = this.f;
            var10000.g += (this.cy - this.f.g) / 4;
            this.g.cx = this.f.f;
            this.g.cy = this.f.g;
            this.g.ck = true;
         } else {
            this.f.j = this.f.f > this.g.cx ? 1 : 0;
            var10000 = this.f;
            var10000.f += (this.g.cx - this.f.f) / 3;
            var10000 = this.f;
            var10000.g += (this.g.cy - this.f.g) / 3;
         }
      }

      if (this.skillID == -1) {
         this.a();
      } else {
         if (this.skillID == 0 && this.addFoot && main.GameCanvas.v % 2 == 0) {
            this.l += this.h > this.cx ? 30 : -30;
            Effect var1;
            (var1 = new Effect(103, this.cx + this.l, this.cy + 20, 2, 1, -1)).j = this.h > this.cx ? 0 : 1;
            EffecMn.addEff(var1);
            if (this.I == 1 && this.cx + this.l >= this.h || this.I == -1 && this.cx + this.l <= this.h) {
               this.addFoot = false;
               this.skillID = -1;
               this.l = 0;
               this.tick = 0;
               this.I = this.d;

               for(int var2 = 0; var2 < this.j.length; ++var2) {
                  this.j[var2].a(this.k[var2], 0, false, false);
               }
            }
         }

         if (this.skillID == 3) {
            this.h = this.j[this.dh].cx;
            this.i = this.j[this.dh].cy;
            this.cx += (this.h - this.cx) / 3;
            this.cy += (this.i - this.cy) / 3;
            if (main.GameCanvas.v % 5 == 0) {
               EffecMn.addEff(new Effect(19, this.cx, this.cy, 2, 1, -1));
            }

            if (ResLog.g(this.cx - this.h) <= 20 && ResLog.g(this.cy - this.i) <= 20) {
               this.cx = this.h;
               this.cy = this.i;
               this.j[this.dh].a(this.k[this.dh], 0, false, false);
               ++this.dh;
               if (this.dh == this.j.length) {
                  this.skillID = -1;
                  this.dh = 0;
               }
            }
         }

      }
   }

   public final void a(mGraphics var1) {
      if (this.skillID == -1) {
         this.a(var1);
      } else {
         this.c(var1);
         var1.setColor(0, main.GameCanvas.ac);
         this.checkFrameTick(this.de[this.skillID]);
         if (this.skillID != 0 && this.skillID != 1) {
            effectData1.a(var1, this.frame, this.cx, this.cy + this.bS, this.I == 1 ? 0 : 1, 2);
         } else {
            effectData.a(var1, this.frame, this.cx, this.cy + this.bS, this.I == 1 ? 0 : 1, 2);
         }

         var1.setColor(0, -main.GameCanvas.ac);
      }
   }
}
