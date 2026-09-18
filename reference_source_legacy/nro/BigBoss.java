package nro;

import javax.microedition.lcdui.Image;

public final class BigBoss extends Mob implements IMapObject {
   private static Image ad = mSystem.load("/mainImage/shadowBig.png");
   private static EffectData ae;
   public int a;
   public boolean b;
   private int af;
   private int ag;
   private boolean ah;
   private int ai;
   private boolean aj = true;
   private int ak;
   private int al;
   private boolean am;
   private boolean an;
   private int ao;
   private int ap;
   private Char[] aq;
   private int[] ar;
   private byte as;
   private int[] at = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1};
   private int[] au = new int[]{37, 37, 37, 38, 38, 38, 39, 39, 40, 40, 40, 39, 39, 39, 38, 38, 38};
   private int[] av;
   private int[] aw;
   private int[] ax;
   private int[] ay;
   private int[] az;
   private int[] aA;
   private int[] aB;
   private boolean aC;

   public final void C() {
      ae = null;
      ae = new EffectData();
      String var1 = "/x" + mGraphics.zoomLevel + "/effectdata/" + 100 + "/data";

      try {
         ae.readData2(var1);
         ae.a = mSystem.loadImage("/effectdata/100/img.png");
      } catch (Exception var2) {
         Service.gI().h(this.C);
      }

      this.p = 2;
      this.v = ae.f;
      this.w = ae.g;
   }

   public final void setBody(short var1) {
      this.changBody = true;
      this.smallBody = var1;
   }

   public final void clearBody() {
      this.changBody = false;
   }

   public BigBoss(int var1, short var2, short var3, int var4, int var5, int var6, int var7) {
      int[] var10000 = new int[]{1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 2, 2, 2};
      var10000 = new int[]{1, 1, 2, 2, 3, 3, 2};
      this.av = new int[]{0, 0, 34, 34, 35, 35, 36, 36, 2, 2, 1, 1};
      this.aw = new int[]{0, 0, 0, 4, 4, 6, 6, 9, 9, 10, 10, 13, 13, 15, 15, 17, 17, 19, 19, 21, 21, 23, 23};
      this.ax = new int[]{0, 0, 1, 1, 4, 4, 6, 6, 8, 8, 25, 25, 26, 26, 28, 28, 30, 30, 32, 32, 2, 2, 1, 1};
      this.ay = new int[]{37, 37, 5, 5, 7, 7, 11, 11, 14, 14, 16, 16, 18, 18, 20, 20, 22, 22, 24, 24};
      this.az = new int[]{37, 37, 37, 38, 38, 5, 5, 7, 7, 11, 11, 27, 27, 29, 29, 31, 31, 33, 33, 38, 38};
      this.aA = new int[]{8, 8, 9, 9, 10, 10, 12, 12};
      this.aB = new int[]{0, 0, 1, 1, 4, 4, 6, 6, 8, 8, 25, 25, 26, 26, 28, 28, 30, 30, 32, 32, 2, 2, 1, 1};
      byte[] var10 = new byte[]{-1, 1};
      this.xFirst = this.x = var2 + 20;
      this.yFirst = this.y = var3;
      this.mobId = var1;
      this.k = var5;
      this.l = var6;
      this.C = 70;
      this.U = 100;
      this.A();
      if (var7 == 0) {
         ae = null;
         ae = new EffectData();
         String var9 = "/x" + mGraphics.zoomLevel + "/effectdata/" + 101 + "/data";

         try {
            ae.readData2(var9);
            ae.a = mSystem.loadImage("/effectdata/101/img.png");
         } catch (Exception var8) {
            Service.gI().h(this.C);
         }

         this.v = ae.f;
         this.w = ae.g;
      }

      if (var7 == 1) {
         this.C();
      }

      if (var7 == 2) {
         this.C();
         this.b = true;
      }

      this.p = 2;
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
         BigBoss var1 = this;
         byte var2 = TileMap.i;
         this.af = this.x;
         this.ai = 0;
         if (this.ag > 0 && !TileMap.a(this.af, this.ag, 2)) {
            if (TileMap.a(this.af / var2, this.ag / var2) == 0) {
               this.ah = true;
            } else if (TileMap.a(this.af / var2, this.ag / var2) != 0 && !TileMap.a(this.af, this.ag, 2)) {
               this.af = this.x;
               this.ag = this.y;
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

         switch(this.p) {
         case 0:
         case 1:
            this.a(this.b ? this.au : this.at);
            if (main.GameCanvas.v % 5 == 0) {
               ServerEffect.addServerEffect(167, ResLog.random(this.x - 60 / 2, this.x + 60 / 2), ResLog.random(this.getY() + 40 / 2, this.getY() + 40), 1);
            }

            if (this.x != this.xFirst || this.y != this.yFirst) {
               this.x += (this.xFirst - this.x) / 4;
               this.y += (this.yFirst - this.y) / 4;
            }
            break;
         case 2:
            this.a(this.b ? this.au : this.at);
            if (this.x != this.xFirst || this.y != this.yFirst) {
               this.x += (this.xFirst - this.x) / 4;
               this.y += (this.yFirst - this.y) / 4;
            }

            return;
         case 3:
            this.f();
            return;
         case 4:
            this.timeStatus = 0;
            if (this.am) {
               ++this.ao;
               this.y -= this.ao;
               this.a(this.aA);
               if (this.y <= -500) {
                  this.am = false;
                  this.an = true;
                  this.ao = 0;
               }
            }

            if (this.an) {
               this.x = this.a;
               this.ao += 2;
               this.y += this.ao;
               this.a(this.aB);
               if (this.y > this.yFirst) {
                  this.y = this.yFirst;
                  this.an = false;
                  this.ao = 0;
                  this.p = 2;
                  GameScr.bt = 10;
                  this.aC = true;
               }
            }

            return;
         case 5:
            this.timeStatus = 0;
            return;
         case 6:
            this.timeStatus = 0;
            ++this.q;
            this.y += this.q;
            if (this.y >= this.yFirst) {
               this.y = this.yFirst;
               this.q = 0;
               this.p = 5;
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
      this.D = var1;
      this.q = 0;
      this.r = 0;
      this.p = 3;
      this.ak = 0;
      this.o = var1.cx > this.x ? 1 : -1;
      int var2 = var1.cx;
      int var3 = var1.cy;
      if (ResLog.g(var2 - this.x) < this.v << 1 && ResLog.g(var3 - this.y) < this.w << 1) {
         if (this.x < var2) {
            this.x = var2 - this.v;
         } else {
            this.x = var2 + this.v;
         }

         this.s = 0;
      } else {
         this.s = 1;
      }
   }

   final boolean e() {
      return this.C >= 58 && this.C <= 65 || this.C == 67 || this.C == 68;
   }

   public final void D() {
      this.p = 4;
      this.am = true;
   }

   public final void a(Char[] var1, int[] var2, byte var3) {
      this.aq = var1;
      this.ar = var2;
      this.as = var3;
      this.ak = 0;
      if (var3 < 3) {
         this.p = 3;
      }

      if (var3 == 3) {
         this.am = true;
         this.p = 4;
      }

      if (var3 == 4) {
         for(int var4 = 0; var4 < this.aq.length; ++var4) {
            this.aq[var4].a(this.ar[var4], 0, false, false);
         }
      }

      if (var3 == 7) {
         this.p = 3;
      }

   }

   public final void f() {
      if (this.as == 7) {
         if (this.ak > 8) {
            this.ak = 8;
         }

         this.a(this.av);
         if (main.GameCanvas.v % 4 == 0) {
            ServerEffect.addServerEffect(70, this.x + (this.o == 1 ? 15 : -15), this.y - 40, 1);
         }
      }

      int var1;
      if (this.as == 0) {
         if (this.ak == this.av.length - 1) {
            this.p = 2;
         }

         this.o = this.x < this.aq[0].cx ? 1 : -1;
         this.a(this.av);
         if (this.ak == 8) {
            for(var1 = 0; var1 < this.aq.length; ++var1) {
               MonsterDart.addMonsterDart(this.x + (this.o == 1 ? 45 : -45), this.y - 30, true, this.ar[var1], 0, this.aq[var1], 24);
            }
         }
      }

      if (this.as == 1) {
         if (this.ak == (this.b ? this.ay.length - 1 : this.aw.length - 1)) {
            this.p = 2;
         }

         this.o = this.x < this.aq[0].cx ? 1 : -1;
         this.a(this.b ? this.ay : this.aw);
         this.x += (this.aq[0].cx - this.x) / 4;
         this.y += (this.aq[0].cy - this.y) / 4;
         if (this.ak == 18) {
            for(var1 = 0; var1 < this.aq.length; ++var1) {
               this.aq[var1].a(this.ar[var1], 0, false, false);
               ServerEffect.addServerEffect(102, this.aq[var1].cx, this.aq[var1].cy, 1);
            }
         }
      }

      if (this.as == 2) {
         if (this.ak == (this.b ? this.az.length - 1 : this.ax.length - 1)) {
            this.p = 2;
         }

         this.o = this.x < this.aq[0].cx ? 1 : -1;
         this.a(this.b ? this.az : this.ax);
         if (this.ak == 13) {
            GameScr.bt = 10;
            this.aC = true;

            for(var1 = 0; var1 < this.aq.length; ++var1) {
               this.aq[var1].a(this.ar[var1], 0, false, false);
            }
         }
      }

   }

   public final void g() {
   }

   public final boolean h() {
      if (this.x < GameScr.cmx) {
         return false;
      } else if (this.x > GameScr.cmx + GameScr.d) {
         return false;
      } else if (this.y < GameScr.cmy) {
         return false;
      } else if (this.y > GameScr.cmy + GameScr.e + 30) {
         return false;
      } else {
         return this.p != 0;
      }
   }

   public final boolean i() {
      return this.p != 0;
   }

   public final boolean checkIsBoss() {
      return this.I || this.H > 0;
   }

   public final void a(mGraphics var1) {
      if (ae != null) {
         if (!this.Y) {
            if (this.M) {
               if (!this.changBody) {
                  ae.a(var1, this.al, this.N, this.O, this.o == 1 ? 0 : 1, 2);
               } else {
                  SmallImage.b(var1, this.smallBody, this.N, this.O, this.o == 1 ? 0 : 2, 33);
               }
            } else {
               if (this.aj && this.p != 0) {
                  var1.drawImage(ad, this.af, this.yFirst, 3);
                  var1.e(GameScr.cmx, GameScr.cmy - main.GameCanvas.ac, GameScr.d, GameScr.e + 2 * main.GameCanvas.ac);
               }

               var1.setColor(0, main.GameCanvas.ac);
               if (!this.changBody) {
                  ae.a(var1, this.al, this.x, this.y, this.o == 1 ? 0 : 1, 2);
               } else {
                  SmallImage.b(var1, this.smallBody, this.x, this.y - 9, this.o == 1 ? 0 : 2, 33);
               }

               var1.setColor(0, -main.GameCanvas.ac);
               int var2 = mGraphics.setColor(this.X);
               int var3 = mGraphics.b(this.X);
               int var4 = var2;
               int var6 = this.x - var2;
               int var7 = this.y - this.w - 5;
               int var5;
               if ((var5 = (var2 << 1) * this.V / 100) > var2) {
                  if ((var5 -= var2) <= 0) {
                     var5 = 0;
                  }
               } else {
                  var4 = var5;
                  var5 = 0;
               }

               var1.drawImage(GameScr.aI, var6, var7, 20);
               var1.drawImage(GameScr.aI, var6 + var2, var7, 20);
               var1.setColor(this.X, 0, 0, var4, var3, 0, var6, var7, 20);
               var1.setColor(this.X, 0, 0, var5, var3, 0, var6 + var2, var7, 20);
               if (this.aC) {
                  ++this.ap;
                  EffecMn.addEff(new Effect(this.as == 2 ? 19 : 22, this.x + this.ap * 50, this.y + 25, 2, 1, -1));
                  EffecMn.addEff(new Effect(this.as == 2 ? 19 : 22, this.x - this.ap * 50, this.y + 25, 2, 1, -1));
                  if (this.ap == 50) {
                     this.ap = 0;
                     this.aC = false;
                  }
               }

            }
         }
      }
   }

   public final void k() {
      this.k = 0;
      this.k = 0;
      this.p = 1;
      this.q = -3;
      this.r = -this.o;
      this.s = 0;
   }

   public final void a(Mob var1) {
      this.D = null;
      this.q = 0;
      this.r = 0;
      this.p = 3;
      this.ak = 0;
      this.o = var1.x > this.x ? 1 : -1;
      int var2 = var1.x;
      int var3 = var1.y;
      if (ResLog.g(var2 - this.x) < this.v << 1 && ResLog.g(var3 - this.y) < this.w << 1) {
         if (this.x < var2) {
            this.x = var2 - this.v;
         } else {
            this.x = var2 + this.v;
         }

         this.s = 0;
      } else {
         this.s = 1;
      }
   }

   public final int getX() {
      return this.x;
   }

   public final int getY() {
      return this.b ? this.y - 20 : this.y - 60;
   }

   public final int getH() {
      return 40;
   }

   public final int getW() {
      return 60;
   }

   public final void stopMoving() {
      if (this.p == 5) {
         this.p = 2;
         this.q = this.r = this.s = 0;
      }

   }

   public final boolean isInvisible() {
      return this.p == 0 || this.p == 1;
   }

   public final void r() {
      if (this.j != 0) {
         this.j = 0;
      }

   }

   public final void s() {
   }

   public final void t() {
   }
}
