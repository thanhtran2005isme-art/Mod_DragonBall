package nro;

import javax.microedition.lcdui.Image;

public class BachTuoc extends Mob implements IMapObject {
   private static Image ad = mSystem.load("/mainImage/shadowBig.png");
   private static EffectData data;
   public int xTo;
   public int yTo;
   private int af;
   private int ag;
   private boolean ah;
   private int ai;
   private boolean aj = true;
   private int tick;
   private int frame;
   private Char[] am;
   private int[] an;
   private byte ao;
   private int[] stand = new int[]{0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1};
   private int[] aq = new int[]{0, 0, 0, 2, 2, 2, 3, 3, 3, 4, 4, 4};
   private int[] ar = new int[]{0, 0, 0, 4, 4, 4, 5, 5, 5, 6, 6, 6};
   private int[] as = new int[]{0, 0, 0, 7, 7, 7, 8, 8, 8, 9, 9, 9, 10, 10, 10, 11, 11};

   static {
      mSystem.load("/mainImage/myTexture2dmobHP.png");
   }

   public void setBody(short var1) {
      this.changBody = true;
      this.smallBody = var1;
   }

   public void clearBody() {
      this.changBody = false;
   }

   public BachTuoc(int var1, short var2, short var3, int var4, int var5, int var6) {
      int[] var10000 = new int[]{1, 1, 7, 7};
      byte[] var9 = new byte[]{-1, 1};
      this.mobId = var1;
      this.x = var2 + 20;
      this.y = var3;
      this.xTo = this.x;
      this.yTo = this.y;
      this.l = var6;
      this.k = var5;
      this.C = 71;
      this.U = 100;
      this.A();
      data = null;
      data = new EffectData();
      String var8 = "/x" + mGraphics.zoomLevel + "/effectdata/" + 108 + "/data";

      try {
         data.readData2(var8);
         data.a = mSystem.loadImage("/effectdata/108/img.png");
      } catch (Exception var7) {
         Service.gI().h(this.C);
      }

      this.v = data.f;
      this.w = data.g;
      this.p = 2;
   }

   public void checkFrameTick(int[] var1) {
      ++this.tick;
      if (this.tick > var1.length - 1) {
         this.tick = 0;
      }

      this.frame = var1[this.tick];
   }

   public void updateSuperEff() {
   }

   public void update() {
      if (this.i()) {
         BachTuoc var1 = this;
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
            this.checkFrameTick(this.stand);
            if (main.GameCanvas.v % 5 == 0) {
               ServerEffect.addServerEffect(167, ResLog.random(this.x - 40 / 2, this.x + 40 / 2), ResLog.random(this.y - 40 + 40 / 2, this.y - 40 + 40), 1);
            }

            if (this.x != this.xTo || this.y != this.yTo) {
               this.x += (this.xTo - this.x) / 4;
               this.y += (this.yTo - this.y) / 4;
            }
            break;
         case 2:
            this.checkFrameTick(this.stand);
            if (this.x != this.xTo || this.y != this.yTo) {
               this.x += (this.xTo - this.x) / 4;
               this.y += (this.yTo - this.y) / 4;
            }

            return;
         case 3:
            this.f();
            return;
         case 4:
         default:
            break;
         case 5:
            this.timeStatus = 0;
            this.g();
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

   public void d() {
   }

   public void a(Char var1) {
      this.D = var1;
      this.q = 0;
      this.r = 0;
      this.p = 3;
      this.tick = 0;
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

   boolean e() {
      return this.C >= 58 && this.C <= 65 || this.C == 67 || this.C == 68;
   }

   public void setAttack(Char[] var1, int[] var2, byte var3) {
      this.am = var1;
      this.an = var2;
      this.ao = var3;
      this.p = 3;
   }

   public void f() {
      int var1;
      if (this.ao == 3) {
         if (this.tick == this.ar.length - 1) {
            this.p = 2;
         }

         this.o = this.x < this.am[0].cx ? 1 : -1;
         this.checkFrameTick(this.ar);
         this.x += (this.am[0].cx - this.x) / 4;
         this.y += (this.am[0].cy - this.y) / 4;
         this.xTo = this.x;
         if (this.tick == 8) {
            for(var1 = 0; var1 < this.am.length; ++var1) {
               this.am[var1].a(this.an[var1], 0, false, false);
               ServerEffect.addServerEffect(102, this.am[var1].cx, this.am[var1].cy, 1);
            }
         }
      }

      if (this.ao == 4) {
         if (this.tick == this.as.length - 1) {
            this.p = 2;
         }

         this.o = this.x < this.am[0].cx ? 1 : -1;
         this.checkFrameTick(this.as);
         if (this.tick == 8) {
            for(var1 = 0; var1 < this.am.length; ++var1) {
               this.am[var1].a(this.an[var1], 0, false, false);
               ServerEffect.addServerEffect(102, this.am[var1].cx, this.am[var1].cy, 1);
            }
         }
      }

   }

   public void g() {
      this.checkFrameTick(this.aq);
      this.x += this.x < this.xTo ? 2 : -2;
      this.y = this.yTo;
      this.o = this.x < this.xTo ? 1 : -1;
      if (ResLog.g(this.x - this.xTo) <= 1) {
         this.x = this.xTo;
         this.p = 2;
      }

   }

   public boolean h() {
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

   public boolean i() {
      return this.p != 0;
   }

   public boolean checkIsBoss() {
      return this.I || this.H > 0;
   }

   public void a(mGraphics var1) {
      if (data != null) {
         if (!this.Y) {
            if (this.M) {
               if (!this.changBody) {
                  data.a(var1, this.frame, this.N, this.O, this.o == 1 ? 0 : 1, 2);
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
                  data.a(var1, this.frame, this.x, this.y, this.o == 1 ? 0 : 1, 2);
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
            }
         }
      }
   }

   public void k() {
      this.k = 0;
      this.k = 0;
      this.p = 1;
      this.q = -3;
      this.r = -this.o;
      this.s = 0;
   }

   public void a(Mob var1) {
      this.D = null;
      this.q = 0;
      this.r = 0;
      this.p = 3;
      this.tick = 0;
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

   public int getX() {
      return this.x;
   }

   public int getY() {
      return this.y - 40;
   }

   public int getH() {
      return 40;
   }

   public int getW() {
      return 40;
   }

   public void stopMoving() {
      if (this.p == 5) {
         this.p = 2;
         this.q = this.r = this.s = 0;
      }

   }

   public boolean isInvisible() {
      return this.p == 0 || this.p == 1;
   }

   public void r() {
      if (this.j != 0) {
         this.j = 0;
      }

   }

   public void s() {
   }

   public void t() {
   }

   public void move(short var1) {
      this.xTo = var1;
      this.p = 5;
   }
}
