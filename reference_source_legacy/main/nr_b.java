package main;

import nro.Char;
import nro.ResLog;
import nro.mGraphics;
import nro.mSystem;
import nro.GameScr;

public final class nr_b {
   private int e;
   private int f;
   private int g;
   private int h;
   private int i;
   private int j;
   private int k = 28;
   private int l;
   private int m;
   private int n;
   private int o;
   private int p;
   private int q;
   private int r;
   private int s;
   private int t;
   public int a;
   private int u;
   private boolean v = false;
   public boolean b;
   public boolean c;
   public boolean d;

   public nr_b() {
      if (GameCanvas.z < 300) {
         this.b = true;
         this.c = false;
         this.d = false;
      }

      if (GameCanvas.z >= 300 && GameCanvas.z <= 380) {
         this.b = false;
         this.c = true;
         this.d = false;
      }

      if (GameCanvas.z > 380) {
         this.b = false;
         this.c = false;
         this.d = true;
      }

      if (!this.d) {
         this.s = 0;
         this.a = GameCanvas.B;
         this.t = GameCanvas.hh >> 1;
         this.u = GameCanvas.A - 80;
      } else {
         this.s = 0;
         this.a = GameCanvas.B / 4 * 3 - 20;
         this.t = GameCanvas.hh >> 1;
         this.u = GameCanvas.A;
         if (mSystem.d == 2) {
            this.s = 0;
            this.t = (GameCanvas.A >> 1) + 40;
            this.a = GameCanvas.B / 4 * 3 - 40;
            this.u = GameCanvas.A;
         }

      }
   }

   public final void a() {
      try {
         if (GameScr.aN != 0) {
            if (GameCanvas.k && !GameCanvas.m) {
               this.m = GameCanvas.q;
               this.n = GameCanvas.r;
               if (this.m >= 0 && this.m <= this.a && this.n >= this.t && this.n <= this.u) {
                  if (!this.v) {
                     this.e = this.g = this.m;
                     this.f = this.h = this.n;
                  }

                  this.v = true;
                  this.o = GameCanvas.o - this.e;
                  this.p = GameCanvas.p - this.f;
                  this.q = ResLog.e(this.o, 2) + ResLog.e(this.p, 2);
                  this.l = ResLog.f(this.q);
                  if (ResLog.g(this.o) > 4 || ResLog.g(this.p) > 4) {
                     this.r = ResLog.a(this.o, this.p);
                     if (!GameCanvas.isPointerHoldIn(this.e - this.k, this.f - this.k, 2 * this.k, 2 * this.k)) {
                        if (this.l != 0) {
                           this.h = this.p * this.k / this.l;
                           this.g = this.o * this.k / this.l;
                           this.g += this.e;
                           this.h += this.f;
                           if (!ResLog.a(this.e - this.k, this.f - this.k, 2 * this.k, 2 * this.k, this.g, this.h)) {
                              this.g = this.i;
                              this.h = this.j;
                           } else {
                              this.i = this.g;
                              this.j = this.h;
                           }
                        } else {
                           this.g = this.i;
                           this.h = this.j;
                        }
                     } else {
                        this.g = GameCanvas.o;
                        this.h = GameCanvas.p;
                     }

                     GameCanvas.f();
                     boolean var1 = true;
                     boolean var10000;
                     if (GameScr.aN == 0) {
                        var10000 = false;
                     } else if (Char.myCharz().statusMe == 3) {
                        var10000 = true;
                     } else {
                        int var5 = 2;

                        while(true) {
                           if (var5 <= 0) {
                              var10000 = true;
                              break;
                           }

                           int var2 = GameCanvas.u[var5].a - GameCanvas.u[var5 - 1].a;
                           int var3 = GameCanvas.u[var5].b - GameCanvas.u[var5 - 1].b;
                           if (ResLog.g(var2) > 2 && ResLog.g(var3) > 2) {
                              var10000 = false;
                              break;
                           }

                           --var5;
                        }
                     }

                     if (!var10000) {
                        GameCanvas.f();
                     } else if ((this.r > 360 || this.r < 340) && (this.r < 0 || this.r > 20)) {
                        if (this.r > 40 && this.r < 70) {
                           GameCanvas.j[6] = true;
                           GameCanvas.keyPressed[6] = true;
                        } else if (this.r >= 70 && this.r <= 110) {
                           GameCanvas.j[8] = true;
                           GameCanvas.keyPressed[8] = true;
                        } else if (this.r > 110 && this.r < 120) {
                           GameCanvas.j[4] = true;
                           GameCanvas.keyPressed[4] = true;
                        } else if (this.r >= 120 && this.r <= 200) {
                           GameCanvas.j[4] = true;
                           GameCanvas.keyPressed[4] = true;
                        } else if (this.r > 200 && this.r < 250) {
                           GameCanvas.j[2] = true;
                           GameCanvas.keyPressed[2] = true;
                           GameCanvas.j[4] = true;
                           GameCanvas.keyPressed[4] = true;
                        } else if (this.r >= 250 && this.r <= 290) {
                           GameCanvas.j[2] = true;
                           GameCanvas.keyPressed[2] = true;
                        } else if (this.r > 290 && this.r < 340) {
                           GameCanvas.j[2] = true;
                           GameCanvas.keyPressed[2] = true;
                           GameCanvas.j[6] = true;
                           GameCanvas.keyPressed[6] = true;
                        }
                     } else {
                        GameCanvas.j[6] = true;
                        GameCanvas.keyPressed[6] = true;
                     }
                  }
               }
            } else {
               this.g = this.e = 45;
               if (!this.d) {
                  this.h = this.f = GameCanvas.A - 90;
               } else {
                  this.h = this.f = GameCanvas.A - 45;
               }

               this.v = false;
               GameCanvas.f();
            }
         }
      } catch (Exception var4) {
      }
   }

   public final void a(mGraphics var1) {
      if (GameScr.aN != 0) {
         var1.drawImage(GameScr.az, this.e, this.f, 3);
         var1.drawImage(GameScr.aA, this.g, this.h, 3);
      }
   }

   public final boolean b() {
      return GameScr.aN == 0 ? false : this.v;
   }

   public final boolean c() {
      try {
         if (GameScr.aN == 0) {
            return false;
         } else {
            boolean var1;
            if ((GameCanvas.o < 0 || GameCanvas.o > this.a || GameCanvas.p < this.t || GameCanvas.p > this.u) && GameCanvas.o < GameCanvas.z - 50) {
               var1 = false;
            } else {
               var1 = true;
            }

            return var1;
         }
      } catch (Exception var2) {
         return false;
      }
   }
}
