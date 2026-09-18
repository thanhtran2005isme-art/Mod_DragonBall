package nro;

import javax.microedition.lcdui.Image;

public final class BigBoss2 extends Mob implements IMapObject {
   private static Image ad = mSystem.load("/mainImage/shadowBig.png");
   private static EffectData ae;
   public int a;
   public int b;
   private int af;
   private int ag;
   private boolean ah;
   private int ai;
   private boolean aj = true;
   private int ak;
   private int al;
   private boolean am;
   private int an;
   private int ao;
   private Char[] ap;
   private int[] aq;
   private byte ar;
   private int[] as = new int[]{0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1};
   private int[] at;
   private int[] au;
   private int[] av;
   private int[] aw;
   private boolean ax;

   static {
      mSystem.load("/mainImage/myTexture2dmobHP.png");
   }

   public final void setBody(short var1) {
      super.changBody = true;
      super.smallBody = var1;
   }

   public final void clearBody() {
      super.changBody = false;
   }

   public BigBoss2(int var1, short var2, short var3, int var4, int var5, int var6) {
      int[] var10000 = new int[]{1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 2, 2, 2};
      var10000 = new int[]{1, 1, 2, 2, 3, 3, 2};
      this.at = new int[]{0, 0, 0, 7, 7, 7, 8, 8, 8, 9, 9, 9};
      this.au = new int[]{0, 0, 0, 10, 10, 10, 11, 11, 11, 12, 12, 12};
      var10000 = new int[]{0, 0, 1, 1, 4, 4, 6, 6, 8, 8, 25, 25, 26, 26, 28, 28, 30, 30, 32, 32, 2, 2, 1, 1};
      this.av = new int[]{4, 4, 4, 5, 5, 5, 6, 6, 6, 6, 6, 6, 3, 3, 3, 2, 2, 2, 1, 1, 1};
      this.aw = new int[]{6, 6, 6, 3, 3, 3, 2, 2, 2, 1, 1, 1};
      byte[] var9 = new byte[]{-1, 1};
      super.mobId = var1;
      this.a = super.x = var2 + 20;
      this.b = super.y = var3;
      super.yFirst = var3;
      super.k = var5;
      super.l = var6;
      super.C = 72;
      super.U = 100;
      this.A();
      ae = null;
      ae = new EffectData();
      String var8 = "/x" + mGraphics.zoomLevel + "/effectdata/" + 109 + "/data";

      try {
         ae.readData2(var8);
         ae.a = mSystem.loadImage("/effectdata/109/img.png");
      } catch (Exception var7) {
         Service.gI().h(super.C);
      }

      super.v = ae.f;
      super.w = ae.g;
      super.p = 2;
   }

   public final void a(int[] var1) {
      ++this.ak;
      if (this.ak > var1.length - 1) {
         this.ak = 0;
      }

      this.al = var1[this.ak];
   }

   public final void updateSuperEff() {
   }

   public final void update() {
      if (this.i()) {
         BigBoss2 var1 = this;
         byte var2 = TileMap.i;
         this.af = super.x;
         this.ai = 0;
         if (this.ag > 0 && !TileMap.a(this.af, this.ag, 2)) {
            if (TileMap.a(this.af / var2, this.ag / var2) == 0) {
               this.ah = true;
            } else if (TileMap.a(this.af / var2, this.ag / var2) != 0 && !TileMap.a(this.af, this.ag, 2)) {
               this.af = super.x;
               this.ag = super.y;
               this.ah = false;
            }

            while(var1.ah && var1.ai < 10) {
               ++var1.ai;
               var1.ag += 24;
               if (TileMap.a(var1.af, var1.ag, 2)) {
                  if (var1.ag % 24 != 0) {
                     var1.ag -= var1.ag % 24;
                  }
                  break;
               }
            }
         }

         switch(super.p) {
         case 0:
         case 1:
            this.a(this.as);
            if (main.GameCanvas.v % 5 == 0) {
               ServerEffect.addServerEffect(167, ResLog.random(super.x - 50 / 2, super.x + 50 / 2), ResLog.random(super.y - 50 + 40 / 2, super.y - 50 + 40), 1);
            }

            if (super.x != this.a || super.y != this.b) {
               super.x += (this.a - super.x) / 4;
               super.y += (this.b - super.y) / 4;
            }
            break;
         case 2:
            this.a(this.as);
            if (super.x != this.a || super.y != this.b) {
               super.x += (this.a - super.x) / 4;
               super.y += (this.b - super.y) / 4;
            }

            return;
         case 3:
            this.f();
            return;
         case 4:
            super.timeStatus = 0;
            if (this.am) {
               super.x = this.a;
               this.an += 2;
               super.y += this.an;
               this.a(this.aw);
               if (super.y > super.yFirst) {
                  super.y = super.yFirst;
                  this.am = false;
                  this.an = 0;
                  super.p = 2;
                  GameScr.bt = 10;
                  this.ax = true;
               }
            }

            return;
         case 5:
            super.timeStatus = 0;
            return;
         case 6:
            super.timeStatus = 0;
            ++super.q;
            super.y += super.q;
            if (super.y >= super.yFirst) {
               super.y = super.yFirst;
               super.q = 0;
               super.p = 5;
               return;
            }
            break;
         case 7:
            return;
         }

      }
   }

   public final void d() {
   }

   public final void a(Char var1) {
      super.D = var1;
      super.q = 0;
      super.r = 0;
      super.p = 3;
      this.ak = 0;
      super.o = var1.cx > super.x ? 1 : -1;
      int var2 = var1.cx;
      int var3 = var1.cy;
      if (ResLog.g(var2 - super.x) < super.v << 1 && ResLog.g(var3 - super.y) < super.w << 1) {
         if (super.x < var2) {
            super.x = var2 - super.v;
         } else {
            super.x = var2 + super.v;
         }

         super.s = 0;
      } else {
         super.s = 1;
      }
   }

   final boolean e() {
      return super.C >= 58 && super.C <= 65 || super.C == 67 || super.C == 68;
   }

   public final void a(Char[] var1, int[] var2, byte var3) {
      super.p = 3;
      this.ap = var1;
      this.aq = var2;
      this.ar = var3;
      this.ak = 0;
   }

   public final void f() {
      int var1;
      if (this.ar == 0) {
         if (this.ak == this.at.length - 1) {
            super.p = 2;
         }

         super.o = super.x < this.ap[0].cx ? 1 : -1;
         this.a(this.at);
         super.x += (this.ap[0].cx - super.x) / 4;
         super.y += (this.ap[0].cy - super.y) / 4;
         this.a = super.x;
         if (this.ak == 8) {
            for(var1 = 0; var1 < this.ap.length; ++var1) {
               this.ap[var1].a(this.aq[var1], 0, false, false);
               ServerEffect.addServerEffect(102, this.ap[var1].cx, this.ap[var1].cy, 1);
            }
         }
      }

      if (this.ar == 1) {
         if (this.ak == this.au.length - 1) {
            super.p = 2;
         }

         super.o = super.x < this.ap[0].cx ? 1 : -1;
         this.a(this.au);
         if (this.ak == 8) {
            for(var1 = 0; var1 < this.ap.length; ++var1) {
               MonsterDart.addMonsterDart(super.x + (super.o == 1 ? 45 : -45), super.y - 25, true, this.aq[var1], 0, this.ap[var1], 24);
            }
         }
      }

      if (this.ar == 2) {
         if (this.ak == this.av.length - 1) {
            super.p = 2;
         }

         super.o = super.x < this.ap[0].cx ? 1 : -1;
         this.a(this.av);
         super.x += (this.ap[0].cx - super.x) / 4;
         this.a = super.x;
         this.b = super.y;
         if (this.ak == 12) {
            for(var1 = 0; var1 < this.ap.length; ++var1) {
               this.ap[var1].a(this.aq[var1], 0, false, false);
               ServerEffect.addServerEffect(102, this.ap[var1].cx, this.ap[var1].cy, 1);
            }
         }
      }

   }

   public final void g() {
   }

   public final boolean h() {
      if (super.x < GameScr.cmx) {
         return false;
      } else if (super.x > GameScr.cmx + GameScr.d) {
         return false;
      } else if (super.y < GameScr.cmy) {
         return false;
      } else if (super.y > GameScr.cmy + GameScr.e + 30) {
         return false;
      } else {
         return super.p != 0;
      }
   }

   public final boolean i() {
      return super.p != 0;
   }

   public final boolean checkIsBoss() {
      return super.I || super.H > 0;
   }

   public final void a(mGraphics var1) {
      if (ae != null) {
         if (!super.Y) {
            if (super.M) {
               if (!super.changBody) {
                  ae.a(var1, this.al, super.N, super.O, super.o == 1 ? 0 : 1, 2);
               } else {
                  SmallImage.b(var1, super.smallBody, super.N, super.O, super.o == 1 ? 0 : 2, 33);
               }
            } else {
               if (this.aj && super.p != 0) {
                  var1.drawImage(ad, this.af, super.yFirst, 3);
                  var1.e(GameScr.cmx, GameScr.cmy - main.GameCanvas.ac, GameScr.d, GameScr.e + 2 * main.GameCanvas.ac);
               }

               var1.setColor(0, main.GameCanvas.ac);
               if (!super.changBody) {
                  ae.a(var1, this.al, super.x, super.y, super.o == 1 ? 0 : 1, 2);
               } else {
                  SmallImage.b(var1, super.smallBody, super.x, super.y - 9, super.o == 1 ? 0 : 2, 33);
               }

               var1.setColor(0, -main.GameCanvas.ac);
               int var2 = mGraphics.setColor(super.X);
               int var3 = mGraphics.b(super.X);
               int var4 = var2;
               int var6 = super.x - var2;
               int var7 = super.y - super.w - 5;
               int var5;
               if ((var5 = (var2 << 1) * super.V / 100) > var2) {
                  if ((var5 -= var2) <= 0) {
                     var5 = 0;
                  }
               } else {
                  var4 = var5;
                  var5 = 0;
               }

               var1.drawImage(GameScr.aI, var6, var7, 20);
               var1.drawImage(GameScr.aI, var6 + var2, var7, 20);
               var1.setColor(super.X, 0, 0, var4, var3, 0, var6, var7, 20);
               var1.setColor(super.X, 0, 0, var5, var3, 0, var6 + var2, var7, 20);
               if (this.ax) {
                  ++this.ao;
                  EffecMn.addEff(new Effect(this.ar == 2 ? 19 : 22, super.x + this.ao * 50, super.y + 25, 2, 1, -1));
                  EffecMn.addEff(new Effect(this.ar == 2 ? 19 : 22, super.x - this.ao * 50, super.y + 25, 2, 1, -1));
                  if (this.ao == 50) {
                     this.ao = 0;
                     this.ax = false;
                  }
               }

            }
         }
      }
   }

   public final void k() {
      super.k = 0;
      super.k = 0;
      super.p = 1;
      super.q = -3;
      super.r = -super.o;
      super.s = 0;
   }

   public final void a(Mob var1) {
      super.D = null;
      super.q = 0;
      super.r = 0;
      super.p = 3;
      this.ak = 0;
      super.o = var1.x > super.x ? 1 : -1;
      int var2 = var1.x;
      int var3 = var1.y;
      if (ResLog.g(var2 - super.x) < super.v << 1 && ResLog.g(var3 - super.y) < super.w << 1) {
         if (super.x < var2) {
            super.x = var2 - super.v;
         } else {
            super.x = var2 + super.v;
         }

         super.s = 0;
      } else {
         super.s = 1;
      }
   }

   public final int getX() {
      return super.x;
   }

   public final int getY() {
      return super.y - 50;
   }

   public final int getH() {
      return 40;
   }

   public final int getW() {
      return 50;
   }

   public final void stopMoving() {
      if (super.p == 5) {
         super.p = 2;
         super.q = super.r = super.s = 0;
      }

   }

   public final boolean isInvisible() {
      return super.p == 0 || super.p == 1;
   }

   public final void r() {
      if (super.j != 0) {
         super.j = 0;
      }

   }

   public final void s() {
   }

   public final void t() {
   }
}
