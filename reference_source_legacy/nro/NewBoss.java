package nro;

import javax.microedition.lcdui.Image;

public final class NewBoss extends Mob implements IMapObject {
   private static Image ad = mSystem.load("/mainImage/shadowBig.png");
   public int xTo;
   public int yTo;
   private int ae;
   private int af;
   private boolean ag = true;
   private int ah;
   private int ai;
   private Char[] aj;
   private int[] ak;
   private byte al;
   private int am;
   private int an = -1;
   private int ao = -1;
   private int ap = -1;
   private int[][] aq;

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

   public NewBoss(int var1, short var2, short var3, int var4, int var5, int var6) {
      byte[] var10000 = new byte[]{-1, 1};
      this.aq = new int[][]{{0, 0, 0, 0, 1, 1, 1, 1}, {0, 0, 0, 0, 1, 1, 1, 1}, {0, 0, 0, 0, 1, 1, 1, 1}, {0, 0, 0, 0, 1, 1, 1, 1}, {0, 0, 0, 0, 1, 1, 1, 1}, {0, 0, 0, 0, 1, 1, 1, 1}, {0, 0, 0, 0, 1, 1, 1, 1}, {0, 0, 0, 0, 1, 1, 1, 1}, {0, 0, 0, 0, 1, 1, 1, 1}, {0, 0, 0, 0, 1, 1, 1, 1}, {0, 0, 0, 0, 1, 1, 1, 1}, {0, 0, 0, 0, 1, 1, 1, 1}, {0, 0, 0, 0, 1, 1, 1, 1}, {0, 0, 0, 0, 1, 1, 1, 1}, {0, 0, 0, 0, 1, 1, 1, 1}, {0, 0, 0, 0, 1, 1, 1, 1}, {0, 0, 0, 0, 1, 1, 1, 1}};
      super.mobId = var1;
      super.x = super.xFirst = var2 + 20;
      super.y = super.yFirst = var3;
      this.xTo = super.x;
      this.yTo = super.y;
      super.l = var6;
      super.k = var5;
      super.C = var4;
      super.U = 100;
      this.A();
      if (Mob.arrMobTemplate[super.C].data == null) {
         Service.gI().h(super.C);
      }

      super.p = 2;
      this.aq = null;
   }

   public final void a(int[] var1) {
      ++this.ah;
      if (this.ah > var1.length - 1) {
         this.ah = 0;
      }

      this.ai = var1[this.ah];
   }

   public final void updateSuperEff() {
   }

   public final void update() {
      if (this.aq == null && Mob.arrMobTemplate[super.C].data != null) {
         this.B();
      }

      if (this.aq != null) {
         if (this.i()) {
            NewBoss var1 = this;
            int var2 = 0;
            this.ae = super.x;
            if (TileMap.a(super.x, super.y, 2)) {
               this.af = super.y;
            } else {
               this.af = super.y;

               while(var2 < 30) {
                  ++var2;
                  var1.af += 24;
                  if (TileMap.a(var1.ae, var1.af, 2)) {
                     if (var1.af % 24 != 0) {
                        var1.af -= var1.af % 24;
                     }
                     break;
                  }
               }
            }

            switch(super.p) {
            case 0:
            case 1:
               ++this.ah;
               if (this.ah > this.aq[13].length - 1) {
                  this.ah = this.aq[13].length - 1;
               }

               this.ai = this.aq[13][this.ah];
               if (super.x != this.xTo || super.y != this.yTo) {
                  super.x += (this.xTo - super.x) / 4;
                  super.y += (this.yTo - super.y) / 4;
               }
               break;
            case 2:
               this.a(this.aq[0]);
               if (super.x != this.xTo || super.y != this.yTo) {
                  super.x += (this.xTo - super.x) / 4;
                  super.y += (this.yTo - super.y) / 4;
               }

               return;
            case 3:
               this.f();
               return;
            case 4:
            default:
               break;
            case 5:
               super.timeStatus = 0;
               this.g();
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
               super.update();
               return;
            }

         }
      }
   }

   public final void a(Char var1) {
      super.D = var1;
      super.q = 0;
      super.r = 0;
      super.p = 3;
      this.ah = 0;
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

   public final void setFly() {
      super.p = 4;
   }

   public final void setAttack(Char[] var1, int[] var2, byte var3, byte var4) {
      this.aj = var1;
      this.ak = var2;
      this.al = var3;
      super.o = var4;
      super.p = 3;
      if (super.x != this.xTo || super.y != this.yTo) {
         super.x += (this.xTo - super.x) / 4;
         super.y += (this.yTo - super.y) / 4;
      }

   }

   public final void f() {
      if (this.ah == this.aq[this.al + 1].length - 1) {
         super.p = 2;
      }

      this.a(this.aq[this.al + 1]);
      if (this.ah == this.aq[15][this.al - 1]) {
         for(int var1 = 0; var1 < this.aj.length; ++var1) {
            this.aj[var1].a(this.ak[var1], 0, false, false);
            ServerEffect.addServerEffect(this.aq[16][this.al - 1], this.aj[var1].cx, this.aj[var1].cy, 1);
         }
      }

   }

   public final void g() {
      this.a(this.aq[1]);
      byte var1;
      int var2 = var1 = Mob.arrMobTemplate[super.C].rangeMove;
      if (ResLog.g(super.x - this.xTo) < var1) {
         var2 = ResLog.g(super.x - this.xTo);
      }

      super.x += super.x < this.xTo ? var2 : -var2;
      super.y = this.yTo;
      if (super.x < this.xTo) {
         super.o = 1;
      } else if (super.x > this.xTo) {
         super.o = -1;
      }

      if (ResLog.g(super.x - this.xTo) <= 1) {
         super.x = this.xTo;
         super.p = 2;
      }

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
      if (Mob.arrMobTemplate[super.C].data != null) {
         if (!super.Y) {
            if (super.M) {
               if (!super.changBody) {
                  Mob.arrMobTemplate[super.C].data.a(var1, this.ai, super.N, super.O, super.o == 1 ? 0 : 1, 2);
               } else {
                  SmallImage.b(var1, super.smallBody, super.N, super.O, super.o == 1 ? 0 : 2, 33);
               }
            } else {
               if (this.ag) {
                  byte var4 = TileMap.i;
                  if ((TileMap.l < 114 || TileMap.l > 120) && TileMap.l != 127 && TileMap.l != 128) {
                     if (TileMap.a(this.ae + var4 / 2, this.af + 1, 4)) {
                        var1.e(this.ae / var4 * var4, (this.af - 30) / var4 * var4, var4, 100);
                     } else if (TileMap.a((this.ae - var4 / 2) / var4, (this.af + 1) / var4) == 0) {
                        var1.e(this.ae / var4 * var4, (this.af - 30) / var4 * var4, 100, 100);
                     } else if (TileMap.a((this.ae + var4 / 2) / var4, (this.af + 1) / var4) == 0) {
                        var1.e(this.ae / var4 * var4, (this.af - 30) / var4 * var4, var4, 100);
                     } else if (TileMap.a(this.ae - var4 / 2, this.af + 1, 8)) {
                        var1.e(this.ae / 24 * var4, (this.af - 30) / var4 * var4, var4, 100);
                     }
                  }

                  var1.drawImage(ad, this.ae, this.af - 5, 3);
                  var1.e(GameScr.cmx, GameScr.cmy - main.GameCanvas.ac, GameScr.d, GameScr.e + 2 * main.GameCanvas.ac);
               }

               var1.setColor(0, main.GameCanvas.ac);
               if (!super.changBody) {
                  if (this.ap == -1) {
                     this.ap = super.y;
                  }

                  if (TileMap.a(super.x + 33, super.y, 4)) {
                     this.ao = TileMap.f(super.x + 33) - 33;
                     this.an = TileMap.f(super.x + 33);
                     if (super.x > this.ao && super.x < this.an && this.an != -1) {
                        super.x = this.ao;
                     }
                  }

                  if (super.y < this.ap && this.ap != -1) {
                     this.ap = super.y;
                     super.x += 33;
                  }

                  if (super.y > this.ap) {
                     this.ap = super.y;
                     super.x -= 33;
                  }

                  Mob.arrMobTemplate[super.C].data.a(var1, this.ai, super.x, super.y, super.o == 1 ? 0 : 1, 2);
               } else {
                  SmallImage.b(var1, super.smallBody, super.x, super.y - 9, super.o == 1 ? 0 : 2, 33);
               }

               var1.setColor(0, -main.GameCanvas.ac);
               if (super.k > 0) {
                  int var2 = mGraphics.setColor(super.X);
                  int var3 = mGraphics.b(super.X);
                  int var9 = var2;
                  int var6 = super.x - var2;
                  int var7 = super.y - super.w - 5;
                  int var5;
                  int var8 = var5 = (var2 << 1) * super.V / 100;
                  if (super.W >= super.V) {
                     int var10002 = super.W;
                     int var10003;
                     if (main.GameCanvas.v % 6 > 3) {
                        int var10005 = this.am;
                        var10003 = var10005;
                        this.am = var10005 + 1;
                     } else {
                        var10003 = this.am;
                     }

                     var8 = var2 * (super.W = var10002 - var10003) / 100;
                     if (super.W <= 0) {
                        super.W = 0;
                     }

                     if (super.W < super.V) {
                        super.W = super.V;
                     }

                     if (this.am >= 3) {
                        this.am = 3;
                     }
                  }

                  if (var5 > var2) {
                     if ((var5 -= var2) <= 0) {
                        var5 = 0;
                     }
                  } else {
                     var9 = var5;
                     var5 = 0;
                  }

                  var1.drawImage(GameScr.aI, var6, var7, 20);
                  var1.drawImage(GameScr.aI, var6 + var2, var7, 20);
                  var1.setColor(16777215);
                  var1.fillRect(var6, var7, var8, 2);
                  var1.setColor(super.X, 0, 0, var9, var3, 0, var6, var7, 20);
                  var1.setColor(super.X, 0, 0, var5, var3, 0, var6 + var2, var7, 20);
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
      this.ah = 0;
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
      return super.y;
   }

   public final int getH() {
      return super.w;
   }

   public final int getW() {
      return super.v;
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

   public final void move(short var1, short var2) {
      if (var2 != -1) {
         if (ResLog.a(super.x, super.y, this.xTo, this.yTo) > 100) {
            super.x = var1;
            super.y = var2;
            super.p = 2;
         } else {
            this.xTo = var1;
            this.yTo = var2;
            super.p = 5;
         }
      } else {
         this.xTo = var1;
         super.p = 5;
      }
   }

   public final void B() {
      try {
         this.aq = (int[][]) Controller.frameNewBoss.get(String.valueOf(super.C));
         super.v = Mob.arrMobTemplate[super.C].data.f;
         super.w = Mob.arrMobTemplate[super.C].data.g;
      } catch (Exception var1) {
      }
   }

   public final void setDie() {
      super.p = 0;
   }
}
