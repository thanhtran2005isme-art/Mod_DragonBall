package nro;

import javax.microedition.lcdui.Image;

public final class Teleport {
   public static MyVector vTeleport = new MyVector("vTeleport");
   public int b;
   public int c;
   private int f;
   private int g;
   private boolean h;
   private int i;
   public int d;
   private int j;
   private int k;
   private static Image[] l = new Image[5];
   private static Image m;
   private boolean n;
   private boolean o;
   private boolean p = false;
   public boolean e;
   private boolean q;
   private int r;
   private int s = 1;
   private int t;
   private int u;
   private boolean v;
   private boolean w;

   public Teleport(int var1, int var2, int var3, int var4, int var5, boolean var6, int var7) {
      this.b = var1;
      this.c = 5;
      this.i = var2;
      ResLog.c("TELEPORT x= " + var1 + " y= " + var2 + " type= " + var5);
      this.f = var3;
      this.g = var5;
      this.h = var6;
      this.j = var4;
      this.k = var7;
      this.r = 0;
      var2 = 0;

      while(var2 < 100) {
         ++var2;
         this.i += 12;
         if (TileMap.a(var1, this.i, 2)) {
            if (this.i % 24 != 0) {
               this.i -= this.i % 24;
            }
            break;
         }
      }

      ResLog.c("Y2= " + this.i + "--------------------------------------------------------------");
      this.o = true;
      this.n = false;
      if (this.k > 2) {
         this.i += 4;
         if (l[3] == null) {
            l[3] = mSystem.loadImage("/mainImage/myTexture2dmaybay4a.png");
         }

         if (l[4] == null) {
            l[4] = mSystem.loadImage("/mainImage/myTexture2dmaybay4b.png");
         }

         if (m == null) {
            m = mSystem.loadImage("/mainImage/hole.png");
         }
      } else if (l[var7] == null) {
         l[var7] = mSystem.load("/mainImage/myTexture2dmaybay" + (var7 + 1) + ".png");
      }

      if (var1 > GameScr.cmx && var1 < GameScr.cmx + main.GameCanvas.z && this.i > 100) {
         SoundMn.stopAll();
         SoundMn.stopAll();
         this.p = true;
         SoundMn.stopAll();
      }

   }

   public static void a(Teleport var0) {
      vTeleport.addElement(var0);
   }

   public final void a(mGraphics var1) {
      if (this.k > 2 && this.v) {
         var1.drawImage(m, this.b, this.i + 20, StaticObj.c);
      }

   }

   public final void b(mGraphics var1) {
      if (!Char.isLoadingMap) {
         if (this.b >= GameScr.cmx && this.b <= GameScr.cmx + main.GameCanvas.z) {
            Rms var2 = GameScr.x[this.f];
            byte var3 = 0;
            byte var4 = 0;
            if (this.k == 0) {
               var3 = 15;
               var4 = 40;
            }

            if (this.k == 1) {
               var3 = 7;
               var4 = 55;
            }

            if (this.k == 2) {
               var3 = 18;
               var4 = 52;
            }

            if (this.q && this.k < 3) {
               SmallImage.b(var1, var2.a[Char.bC[0][0][0]].a, this.b + (this.j == 1 ? var3 : -var3), this.c - var4, this.j == 1 ? 0 : 2, StaticObj.a);
            }

            if (this.k < 3) {
               var1.setColor(l[this.k], 0, 0, mGraphics.setColor(l[this.k]), mGraphics.b(l[this.k]), this.j == 1 ? 2 : 0, this.b, this.c, StaticObj.c);
            } else if (this.o) {
               if (this.r > 10) {
                  var1.setColor(l[4], 0, 0, mGraphics.setColor(l[4]), mGraphics.b(l[4]), this.j == 1 ? 2 : 0, this.j == 1 ? this.b - 11 : this.b + 11, this.c + 2, StaticObj.c);
               } else {
                  var1.setColor(l[3], 0, 0, mGraphics.setColor(l[3]), mGraphics.b(l[3]), this.j == 1 ? 2 : 0, this.b, this.c, StaticObj.c);
               }
            } else if (this.r < 20) {
               var1.setColor(l[4], 0, 0, mGraphics.setColor(l[4]), mGraphics.b(l[4]), this.j == 1 ? 2 : 0, this.j == 1 ? this.b - 11 : this.b + 11, this.c + 2, StaticObj.c);
            } else {
               var1.setColor(l[3], 0, 0, mGraphics.setColor(l[3]), mGraphics.b(l[3]), this.j == 1 ? 2 : 0, this.b, this.c, StaticObj.c);
            }
         }
      }
   }

   public final void a() {
      if (this.k > 2 && this.e && this.c != -80) {
         if (this.o && this.r == 0) {
            if (main.GameCanvas.v % 3 == 0) {
               ServerEffect.a(1, this.b, this.c, 1, 0);
            }
         } else if (this.n && main.GameCanvas.v % 3 == 0) {
            ServerEffect.a(1, this.b, this.c + 16, 1, 1);
         }
      }

      ++this.t;
      if (this.t > 3) {
         this.t = 0;
      }

      int var1;
      if (this.o) {
         this.e = true;
         this.q = this.g != 0;
         if (this.k < 3) {
            if ((var1 = this.i - this.c >> 3) <= 0) {
               var1 = 1;
               this.e = false;
            }

            this.c += var1;
         } else {
            if (main.GameCanvas.v % 2 == 0) {
               ++this.s;
            }

            if (this.i - this.c < this.s) {
               this.c = this.i;
               this.e = false;
            } else {
               this.c += this.s;
            }
         }

         if (this.h && this.g == 1 && Char.myCharz().s) {
            Char.myCharz().cx = this.b;
            Char.myCharz().cy = this.c - 30;
            Char.myCharz().statusMe = 4;
            GameScr.l = this.b - GameScr.f;
            GameScr.m = this.c - GameScr.g - 1;
            GameScr.info1.f = false;
         }

         if (GameScr.findCharInMap(this.d) != null && !this.h && this.g == 1 && GameScr.findCharInMap(this.d).s) {
            GameScr.findCharInMap(this.d).cx = this.b;
            GameScr.findCharInMap(this.d).cy = this.c - 30;
            GameScr.findCharInMap(this.d).statusMe = 4;
         }

         if (ResLog.g(this.c - this.i) < 50 && TileMap.a(this.b, this.c, 2)) {
            this.v = true;
            if (this.k < 3) {
               SoundMn.stopAll();
               if (this.c % 24 != 0) {
                  this.c -= this.c % 24;
               }

               ++this.r;
               if (this.r > 10) {
                  this.r = 0;
                  this.o = false;
                  this.n = true;
                  this.e = false;
               }

               if (this.g == 1) {
                  if (this.h) {
                     Char.myCharz().s = false;
                  } else if (GameScr.findCharInMap(this.d) != null) {
                     GameScr.findCharInMap(this.d).s = false;
                  }

                  this.q = false;
               }
            } else {
               this.c = this.i;
               if (!this.w) {
                  ServerEffect.a(92, this.b + 4, this.c + 14, 1, 0);
                  GameScr.bt = 10;
                  this.w = true;
               }

               ++this.r;
               if (this.r > 30) {
                  this.r = 0;
                  this.o = false;
                  this.n = true;
                  this.e = false;
               }

               if (this.g == 1) {
                  if (this.h) {
                     Char.myCharz().s = false;
                  } else if (GameScr.findCharInMap(this.d) != null) {
                     GameScr.findCharInMap(this.d).s = false;
                  }

                  this.q = false;
               }
            }
         }
      } else if (this.n) {
         ++this.r;
         if (this.r > 30) {
            if ((var1 = this.i + 24 - this.c >> 3) > 30) {
               var1 = 30;
            }

            this.c -= var1;
            this.e = true;
         } else {
            if (this.r == 14 && this.p) {
               SoundMn.stopAll();
            }

            if (this.r > 0 && this.g == 0) {
               if (this.h) {
                  Char.myCharz().s = false;
                  if (Char.myCharz().statusMe != 14) {
                     Char.myCharz().statusMe = 3;
                  }

                  Char.myCharz().E = -3;
               } else if (GameScr.findCharInMap(this.d) != null) {
                  GameScr.findCharInMap(this.d).s = false;
                  if (GameScr.findCharInMap(this.d).statusMe != 14) {
                     GameScr.findCharInMap(this.d).statusMe = 3;
                  }

                  GameScr.findCharInMap(this.d).E = -3;
               }

               this.q = false;
            }

            if (this.r > 12 && this.g == 0) {
               if (this.h) {
                  Char.myCharz().s = true;
               } else if (GameScr.findCharInMap(this.d) != null) {
                  GameScr.findCharInMap(this.d).cx = this.b;
                  GameScr.findCharInMap(this.d).cy = this.c;
                  GameScr.findCharInMap(this.d).s = true;
               }

               this.q = true;
            }
         }

         if (this.h) {
            if (this.g == 0) {
               GameScr.l = this.b - GameScr.f;
               GameScr.m = this.c - GameScr.g - 1;
            }

            if (this.g == 1) {
               GameScr.info1.f = true;
            }
         }

         if (this.c <= -80) {
            if (this.h && this.g == 0) {
               Controller.b = false;
               Char.bG = true;
            }

            if (!this.h && GameScr.findCharInMap(this.d) != null && this.g == 0) {
               GameScr.vCharInMap.removeElement(GameScr.findCharInMap(this.d));
            }

            if (this.k < 3) {
               vTeleport.removeElement(this);
            } else {
               this.c = -80;
               ++this.u;
               if (this.u > 80) {
                  this.u = 0;
                  vTeleport.removeElement(this);
               }
            }
         }
      }

      if (this.e && this.k < 3 && ResLog.g(this.c - this.i) <= 50 && main.GameCanvas.v % 5 == 0) {
         EffecMn.addEff(new Effect(19, this.b, this.i + 20, 2, 1, -1));
      }

   }
}
