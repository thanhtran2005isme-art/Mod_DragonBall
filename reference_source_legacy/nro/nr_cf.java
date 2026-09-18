package nro;

import javax.microedition.lcdui.Image;

public final class nr_cf {
   private MyVector d = new MyVector("EffectEnd VecEffEnd");
   private FrameImage e;
   private byte[] f = new byte[10];
   private byte[] g = new byte[10];
   private int h = 0;
   private int i = 0;
   private int j = 0;
   private int k = 0;
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
   private int v;
   private int w;
   private int x;
   private int y;
   private int z;
   private int A;
   private int B;
   private int C;
   private int D;
   private int E;
   private int F;
   private short G;
   private long H;
   public boolean b;
   private boolean I;
   private Char J;
   private Point[] K;
   private Point L;
   public static short[][] c = new short[][]{{68, 264, 4}, {30, 120, 4}, {66, 280, 4}, {0, 0, 1}, {111, 68, 2}, {90, 68, 2}, {125, 68, 2}, {47, 282, 6}, {10, 40, 4}, {92, 525, 7}, {62, 372, 6}, {80, 352, 4}, {80, 352, 4}, {80, 352, 4}, {72, 240, 3}, {20, 42, 3}, {65, 160, 4}, {50, 300, 6}, {84, 168, 2}, {90, 540, 6}, {180, 900, 6}, {62, 186, 3}, {34, 80, 4}, {140, 560, 4}, {64, 600, 6}, {36, 200, 5}, {35, 200, 5}, {50, 250, 5}, {50, 240, 6}};
   private int M;
   private int N;
   private int O;
   private int P;
   private int Q;
   private int[] R;
   private int[] S;
   private int[] T;
   private int[] U;
   private static int[][] V = new int[][]{{16310304, 16298056, 16777215}, {7045120, 12643960, 16777215}, {2407423, 11987199, 16777215}};
   private int[] W;
   private int X;
   private int Y;
   private int Z;
   private FrameImage[] aa;

   public static Image a(int var0) {
      if (var0 < 0) {
         return null;
      } else {
         String var3 = "/e/e_" + var0 + ".png";
         Image var1 = null;

         try {
            var1 = mSystem.load(var3);
         } catch (Exception var2) {
         }

         return var1;
      }
   }

   public nr_cf(int var1, int var2, int var3, Char var4, Point var5, int var6, short var7, short var8) {
      byte[] var10000 = new byte[]{12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, 23, 22, 21, 20, 19, 18, 17, 16, 15, 14, 13};
      var10000 = new byte[]{0, 0, 2, 1, 1, 2, 0, 0, 2, 1, 1, 2, 0, 0, 2, 1, 1, 2, 0, 0, 2, 1, 1, 2};
      var10000 = new byte[]{2, 2, 3, 3, 3, 4, 5, 5, 5, 5, 5, 1, 0, 0, 0, 0, 0, 7, 6, 6, 6, 6, 6, 2};
      this.X = 0;
      this.u = 0;
      this.E = 0;
      this.i = var1;
      this.j = var2;
      this.h = var3;
      this.J = var4;
      if (var4.b((int)1265)) {
         Char var9;
         if (this.i != 21 && this.i != 22 && this.i != 23) {
            if (this.i != 18 && this.i != 19 && this.i != 20) {
               var9 = this.J;
               var9.cx += 15 * this.J.I;
            } else {
               var9 = this.J;
               var9.cx += -15 * this.J.I;
            }
         } else {
            var9 = this.J;
            var9.cx += 10 * this.J.I;
         }
      }

      this.o = this.J.cx;
      this.p = this.J.cy;
      this.s = this.J.I;
      this.t = this.s == -1 ? 2 : 0;
      this.L = var5;
      this.a = var6;
      this.H = mSystem.currentTimeMillis();
      this.G = var7;
      this.k = var8;
      this.b = this.I = false;
      this.n = 4;
      this.f();
      this.b();
   }

   public nr_cf(int var1, int var2, int var3, int var4, int var5, int var6, int var7, short var8, Point[] var9) {
      byte[] var10000 = new byte[]{12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, 23, 22, 21, 20, 19, 18, 17, 16, 15, 14, 13};
      var10000 = new byte[]{0, 0, 2, 1, 1, 2, 0, 0, 2, 1, 1, 2, 0, 0, 2, 1, 1, 2, 0, 0, 2, 1, 1, 2};
      var10000 = new byte[]{2, 2, 3, 3, 3, 4, 5, 5, 5, 5, 5, 1, 0, 0, 0, 0, 0, 7, 6, 6, 6, 6, 6, 2};
      this.X = 0;
      this.u = 0;
      this.E = 0;
      this.i = var1;
      this.j = var2;
      this.h = var3;
      this.o = var4;
      this.p = var5;
      this.a = var6;
      this.s = var7;
      this.t = var7 == -1 ? 2 : 0;
      this.H = mSystem.currentTimeMillis();
      this.G = var8;
      this.b = this.I = false;
      this.n = 4;
      if (var9 != null) {
         this.K = new Point[var9.length];

         for(var1 = 0; var1 < this.K.length; ++var1) {
            this.K[var1] = var9[var1];
         }
      }

      this.f();
      this.b();
   }

   private void b() {
      try {
         int var2 = this.p;
         int var1 = this.o;

         try {
            ResLog.d(3);
         } catch (Exception var3) {
            ResLog.b("ERR setSoundSkill_END: " + var3.toString());
         }

         switch(this.i) {
         case 0:
         case 1:
         case 2:
            var2 = this.i;
            switch(var2) {
            case 0:
               this.e = new FrameImage(4);
               break;
            case 1:
               this.e = new FrameImage(5);
               break;
            case 2:
               this.e = new FrameImage(6);
            }

            this.l = 100;
            this.B = main.GameCanvas.A / 3 + 10;
            this.x = 10;
            this.z = 0;
            this.I = false;
            return;
         case 3:
            this.c();
            return;
         case 9:
            this.X = this.j;
            this.y = this.o * 1000;
            this.z = this.p * 1000;
            this.l = ResLog.random(4, 6);
            this.C = 5;
            this.Y = 10;
            this.Z = 20;
            this.a(this.C, this.Y, this.Z, 0);
            return;
         case 10:
         case 11:
            this.e();
         case 4:
         case 5:
         case 6:
         case 7:
         case 8:
         case 12:
         case 13:
         case 14:
         case 15:
         default:
            return;
         case 16:
         case 17:
            if (this.i == 17) {
               this.o += this.s == 0 ? 0 : -this.aa[0].a;
               this.p -= this.aa[0].b / 2;
            }

            return;
         case 18:
         case 19:
         case 20:
            this.f = null;
            this.n = 3;
            if (this.i == 18) {
               if (this.j == 0) {
                  this.f = new byte[]{0, 0, 0, 1, 1, 1, 2, 2, 2};
                  break;
               }

               this.f = new byte[]{3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6};
            }

            return;
         case 21:
         case 22:
         case 23:
            if (this.J != null) {
               if (this.i == 21) {
                  this.o = this.J.cx - 3 * this.J.I;
                  this.p = this.J.cy;
                  break;
               }

               if (this.i == 22) {
                  this.o = this.J.cx + 20 * this.J.I;
                  this.p = this.J.cy - 4;
                  break;
               }

               if (this.i == 23) {
                  this.o = this.J.cx;
                  this.p = this.J.cy - 50;
                  break;
               }

               this.o = this.J.cx;
               this.p = this.J.cy;
            }

            return;
         case 24:
            this.q = this.aa[0].a;
            this.r = this.aa[0].b;
            this.C = ResLog.g(this.o - this.L.b);
            this.f = new byte[]{0, 0, 0, 1, 1, 1};
            this.I = false;
            return;
         case 25:
            this.d();
            return;
         case 26:
            this.f = new byte[]{0, 0, 0, 1, 1, 1, 2, 2, 2};
            this.I = false;
            this.m = 10;
            this.y = this.o;
            this.z = this.p + 12;
            this.F = 25;
            this.B = 19;
            if (this.j == 1) {
               this.B = 21;
            } else if (this.j == 2) {
               this.B = 31;
            }

            this.r = this.aa[1].b + 50 - this.B;
            this.x = 1;
            this.A = 1;
            this.p = this.z - this.r;
            this.M = 90;
            this.C = 1;
            this.N = this.O = 25;
            this.Q = 1;
            if (this.K != null && this.K.length > 0) {
               this.Q = this.K.length;
            }

            this.P = 360 / this.Q;
            this.R = new int[this.Q];
            this.S = new int[this.Q];
            this.T = new int[this.Q];
            this.U = new int[this.Q];
            GameScr.a(16, 0, this.h, this.y, this.z, 1, 0, (short)-1, (Point[])null);
            return;
         }
      } catch (Exception var4) {
         ResLog.b("ERR create_Effect: " + var4.toString());
         this.b = true;
      }

   }

   public final void a() {
      try {
         ++this.u;
         nr_cf var1;
         int var11;
         int var12;
         Point var13;
         switch(this.i) {
         case 0:
         case 1:
         case 2:
            this.o = main.GameCanvas.B;
            this.p = this.z;
            if (this.u > this.l) {
               this.b = true;
            }

            ++this.x;
            if (this.x > 15) {
               this.x = 15;
            }

            if (this.z + this.x >= this.B) {
               this.z = this.B;
               if (!this.I) {
                  this.I = true;
                  if (this.j != -1) {
                     GameScr.a(this.j, 0, 0, this.o, this.p, this.a, 0, (short)-1, (Point[])null);
                  }
               }

               return;
            }

            this.z += this.x;
            break;
         case 3:
            var1 = this;

            for(var11 = 0; var11 < var1.d.size(); ++var11) {
               (var13 = (Point)var1.d.elementAt(var11)).a();
               if (var13.i - var13.j > var13.p.c * 3 - 1) {
                  var13.i = 0;
                  if (var1.j == 0) {
                     var13.j = ResLog.d(10);
                     byte var17 = 1;
                     if (var11 % 2 == 0) {
                        var17 = -1;
                     }

                     var13.b = var1.o + ResLog.d(c[5][0] / 2) * var17;
                     var13.c = var1.p - ResLog.d(c[5][1] / 2);
                  }
               }
            }

            if (var1.u >= var1.l) {
               var1.b = true;
            }

            return;
         case 9:
            var1 = this;

            for(var11 = 0; var11 < var1.d.size(); ++var11) {
               nr_ck var15;
               nr_ck var16;
               nr_ck var19 = var16 = var15 = (nr_ck)var1.d.elementAt(var11);
               var19.a += var16.e;
               var16.c += var16.e;
               var16.b += var16.f;
               var16.d += var16.f;
               ++var16.g;
               if (var1.u >= var1.l) {
                  var1.d.removeElement(var15);
                  --var11;
               }
            }

            if (var1.u >= var1.l) {
               if (main.GameCanvas.b - var1.H >= (long)var1.G) {
                  var1.d.removeAllElements();
                  var1.b = true;
                  break;
               }

               var1.l = ResLog.random(4, 6);
               var1.u = 0;
               var1.a(var1.C, var1.Y, var1.Z, 0);
            }

            return;
         case 10:
         case 11:
            var1 = this;

            for(var11 = 0; var11 < var1.d.size(); ++var11) {
               (var13 = (Point)var1.d.elementAt(var11)).a();
               if (var13.c < var1.D) {
                  var1.d.removeElementAt(var11);
                  --var11;
               }
            }

            if (var1.u >= var1.l) {
               var1.b = true;
            }
         case 4:
         case 5:
         case 6:
         case 7:
         case 8:
         case 12:
         case 13:
         case 14:
         case 15:
         default:
            return;
         case 16:
         case 17:
            if (this.G > 0) {
               if (main.GameCanvas.b - this.H >= (long)this.G) {
                  this.b = true;
                  break;
               }
            } else if (this.u >= this.aa[0].c * this.n) {
               this.b = true;
            }

            return;
         case 18:
         case 19:
         case 20:
            if (this.J != null) {
               this.o = this.J.cx;
               this.p = this.J.cy + 13;
            }

            if (this.G > 0) {
               if (main.GameCanvas.b - this.H >= (long)this.G) {
                  this.b = true;
                  break;
               }
            } else if (this.f != null) {
               if (this.u > this.f.length) {
                  this.b = true;
                  break;
               }
            } else if (this.u >= this.aa[0].c * this.n) {
               this.b = true;
            }

            return;
         case 21:
         case 22:
         case 23:
            if (this.J != null) {
               if (this.i == 21) {
                  this.o = this.J.cx - 3 * this.J.I;
                  this.p = this.J.cy;
               } else if (this.i == 22) {
                  this.o = this.J.cx + 20 * this.J.I;
                  this.p = this.J.cy - 4;
               } else if (this.i == 23) {
                  this.o = this.J.cx;
                  this.p = this.J.cy - 50;
               } else {
                  this.o = this.J.cx;
                  this.p = this.J.cy;
               }
            }

            if (this.G > 0) {
               if (main.GameCanvas.b - this.H >= (long)this.G) {
                  this.b = true;
                  break;
               }
            } else if (this.u >= this.aa[0].c * this.n) {
               this.b = true;
            }

            return;
         case 24:
            ++this.w;
            this.q += 20;
            if (this.q > this.C) {
               this.q = this.C;
            }

            this.o = this.J.cx + 10;
            this.p = this.J.cy - 3;
            if (this.s == -1) {
               this.o = this.J.cx - this.q - 10;
            }

            if (!this.I && main.GameCanvas.b - this.H >= (long)this.G) {
               this.u = 0;
               this.f = new byte[]{2, 2, 2, 3, 3, 3};
               this.I = true;
            }

            if (this.u > this.f.length - 1) {
               if (this.I) {
                  this.b = true;
                  break;
               }

               this.u = 0;
            }

            return;
         case 25:
            var1 = this;
            var11 = 0;

            for(var12 = 0; var12 < var1.d.size(); ++var12) {
               Point var14;
               if (!(var14 = (Point)var1.d.elementAt(var12)).n && main.GameCanvas.b - var1.H >= (long)(var12 * var1.m)) {
                  var14.n = true;
                  GameScr.a(17, 0, var1.h, var1.J.cx, var1.J.cy - 3, 2, var1.t, (short)-1, (Point[])null);
                  var1.d.size();
               }

               if (var14.n && !var14.m) {
                  ++var14.i;
                  if (!var14.o) {
                     if (var14.i < 10 && var12 == var1.d.size() - 1 && var1.J != null && !TileMap.a(var1.J.cx - (var1.J.am + 1) * var1.J.I, var1.J.cy, var1.J.I == 1 ? 8 : 4)) {
                        Char var10000 = var1.J;
                        var10000.cx -= var1.J.I;
                     }

                     int var7 = var14.h;
                     int var6 = var14.g;
                     int var8 = var6 - var14.b;
                     int var9 = var7 - var14.c;
                     if (var8 > 1) {
                        var8 = ResLog.a(var8, var9);
                        var14.k = var14.a(var8);
                     }

                     if (ResLog.g(var14.e) > 0 && ResLog.g(var14.b - var6) >= ResLog.g(var14.e)) {
                        var14.b += var14.e;
                     } else {
                        var14.b = var6;
                        var14.e = 0;
                     }

                     if (ResLog.g(var14.f) > 0 && ResLog.g(var14.c - var7) >= ResLog.g(var14.f)) {
                        var14.c += var14.f;
                     } else {
                        var14.c = var7;
                        var14.f = 0;
                     }

                     if (var14.b == var14.g) {
                        var14.o = true;
                        var14.i = 0;
                     }
                  }

                  if (var14.o && var14.i >= var1.n * var14.q.c) {
                     var14.m = true;
                  }
               }

               if (var14.m) {
                  ++var11;
               }
            }

            if (var11 == var1.d.size()) {
               var1.b = true;
            }

            return;
         case 26:
            if (this.E == 0) {
               ++this.v;
               if (this.v > this.f.length - 1) {
                  this.v = this.f.length - 1;
               }

               if (this.u == this.m + 4) {
                  GameScr.a(16, 1, this.h, this.o, this.p, 3, 0, (short)2945, (Point[])null);
               }

               if (this.u > this.m + 4) {
                  --this.M;
                  nr_cf var2;
                  if (this.M < 0) {
                     this.M = 0;
                     this.u = 0;
                     this.w = 0;
                     this.g = new byte[]{1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 2};
                     boolean var3 = true;
                     var2 = this;
                     if (this.K != null) {
                        for(int var4 = 0; var4 < var2.K.length; ++var4) {
                           if (var2.K[var4] != null) {
                              if (var2.K[var4].a == 0) {
                                 Mob var5;
                                 if ((var5 = GameScr.c(var2.K[var4].l)) != null) {
                                    var5.Y = true;
                                 }
                              } else {
                                 Point var10001 = var2.K[var4];
                                 Char var18;
                                 if (Char.myCharz().charID == var10001.l) {
                                    var18 = Char.myCharz();
                                 } else {
                                    var18 = GameScr.findCharInMap(var2.K[var4].l);
                                 }

                                 if (var18 != null) {
                                    var18.bR = true;
                                 }
                              }
                           }
                        }
                     }

                     this.E = 1;
                  } else {
                     if (this.C < 40) {
                        this.C += 2;
                     }

                     this.N = this.O;
                     this.N -= this.C;
                     if (this.N >= 360) {
                        this.N -= 360;
                     }

                     if (this.N < 0) {
                        this.N += 360;
                     }

                     this.O = this.N;
                     var2 = this;

                     for(var12 = 0; var12 < var2.S.length; ++var12) {
                        if (var2.N >= 360) {
                           var2.N -= 360;
                        }

                        if (var2.N < 0) {
                           var2.N += 360;
                        }

                        var2.S[var12] = ResLog.g(var2.M * ResLog.a(var2.N) / 1024);
                        var2.R[var12] = ResLog.g(var2.M * ResLog.b(var2.N) / 1024);
                        if (var2.N < 90) {
                           var2.T[var12] = var2.o + var2.R[var12];
                           var2.U[var12] = var2.p - var2.S[var12];
                        } else if (var2.N >= 90 && var2.N < 180) {
                           var2.T[var12] = var2.o - var2.R[var12];
                           var2.U[var12] = var2.p - var2.S[var12];
                        } else if (var2.N >= 180 && var2.N < 270) {
                           var2.T[var12] = var2.o - var2.R[var12];
                           var2.U[var12] = var2.p + var2.S[var12];
                        } else {
                           var2.T[var12] = var2.o + var2.R[var12];
                           var2.U[var12] = var2.p + var2.S[var12];
                        }

                        var2.N -= var2.P;
                     }

                     this.a(true);
                  }

                  return;
               }
            } else if (this.E == 1) {
               ++this.w;
               if (this.w > this.g.length - 1) {
                  this.w = this.g.length - 1;
                  if (main.GameCanvas.v % 2 == 0) {
                     ++this.A;
                  }

                  this.x += this.A;
                  if (this.x >= this.r - this.aa[0].b - this.F + this.B) {
                     this.x = this.r - this.aa[0].b - this.F + this.B;
                     this.u = 0;
                     this.w = 0;
                     this.E = 2;
                     this.g = new byte[]{3, 3, 3, 3, 3, 4, 4, 4, 5, 5, 5};
                     return;
                  }
               }
            } else if (this.E == 2) {
               ++this.w;
               if (this.w > this.g.length - 1) {
                  this.E = 3;
                  this.v = 0;
                  this.f = new byte[]{2, 2, 1, 1, 0, 0, 3, 3, 3, 0, 0, 0, 4, 4, 4, 0, 0};
                  return;
               }
            } else if (this.E == 3) {
               ++this.v;
               if (this.v > this.f.length - 1) {
                  this.v = 0;
                  this.E = 4;
                  this.f = new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 3, 0, 0, 0, 4, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 0, 0, 4, 4};
                  return;
               }
            } else {
               ++this.v;
               if (this.v > this.f.length - 1) {
                  this.v = 0;
               }

               if (main.GameCanvas.b - this.H >= (long)this.G) {
                  GameScr.a(16, 0, this.h, this.y, this.z, 1, 0, (short)-1, (Point[])null);
                  this.a(false);
                  this.b = true;
               }
            }

            return;
         }
      } catch (Exception var10) {
         ResLog.b("ERR update: " + var10.toString());
         this.b = true;
      }

   }

   public final void a(mGraphics var1) {
      try {
         if (this.b || this.u < 0) {
            return;
         }

         mGraphics var2;
         nr_cf var17;
         int var18;
         boolean var19;
         Point var20;
         switch(this.i) {
         case 0:
         case 1:
         case 2:
            if (this.e != null) {
               this.e.a(this.u / 5 % this.e.c, this.o, this.p, 0, 33, var1);
            }

            return;
         case 3:
            var2 = var1;
            var17 = this;

            for(var18 = 0; var18 < var17.d.size(); ++var18) {
               if ((var20 = (Point)var17.d.elementAt(var18)).i - var20.j >= 0 && var20.p != null) {
                  var20.p.a((var20.i - var20.j) / 3 % var20.p.c, var20.b, var20.c, 0, 3, var2);
               }
            }

            return;
         case 9:
            var2 = var1;
            var17 = this;

            for(var18 = 0; var18 < var17.d.size(); ++var18) {
               nr_ck var23;
               if ((var23 = (nr_ck)var17.d.elementAt(var18)) != null) {
                  int var22 = 0;
                  if (var18 / 2 < var17.W.length) {
                     var22 = var17.W[var18 / 2];
                  }

                  var2.setColor(var22);
                  var2.setColor(var23.a / 1000, var23.b / 1000, var23.c / 1000, var23.d / 1000);
                  if (var23.h) {
                     var2.setColor(var23.a / 1000 + 1, var23.b / 1000, var23.c / 1000 + 1, var23.d / 1000);
                  }
               }
            }

            return;
         case 10:
         case 11:
            var2 = var1;
            var17 = this;

            for(var18 = 0; var18 < var17.d.size(); ++var18) {
               var20 = (Point)var17.d.elementAt(var18);
               if (var17.e != null) {
                  var17.e.a(var20.k, var20.b, var20.c, 0, 3, var2);
               }
            }
         case 4:
         case 5:
         case 6:
         case 7:
         case 8:
         case 12:
         case 13:
         case 14:
         case 15:
         default:
            return;
         case 16:
            if (this.j == 0) {
               this.a(var1, 33);
               return;
            }

            this.a(var1, 3);
            return;
         case 17:
            this.a(var1, 0);
            return;
         case 18:
         case 19:
         case 20:
            var19 = true;
            if (this.aa[0] != null) {
               if (this.f != null) {
                  this.aa[0].a(this.f[this.u % this.f.length], this.o, this.p, this.t, 33, var1);
                  break;
               }

               this.aa[0].a(this.u / this.n % this.aa[0].c, this.o, this.p, this.t, 33, var1);
            }

            return;
         case 21:
         case 22:
         case 23:
            var19 = true;
            if (this.aa[0] != null) {
               this.aa[0].a(this.u / this.n % this.aa[0].c, this.o, this.p, this.t, 3, var1);
            }

            return;
         case 24:
            if (this.aa != null) {
               var1.e(this.o, this.p - this.r / 2, this.q, this.r);
               FrameImage var10002 = this.aa[0];
               FrameImage var10003 = this.aa[1];
               FrameImage var10004 = this.aa[2];
               byte var10005 = this.f[this.u];
               int var11 = this.C;
               int var10 = this.p;
               int var9 = this.o;
               byte var8 = var10005;
               FrameImage var7 = var10004;
               FrameImage var6 = var10003;
               FrameImage var5 = var10002;
               mGraphics var21 = var1;
               int var13 = var11;
               boolean var14 = false;
               if (var5 != null && var7 != null) {
                  var14 = true;
                  var13 = var11 - (var5.a + var7.a);
               }

               if (var13 > 0) {
                  int var12 = var13 / var6.a;
                  if (var13 % var6.a > 0) {
                     ++var12;
                  }

                  int var15;
                  if (this.s == -1) {
                     for(var13 = 0; var13 < var12; ++var13) {
                        if (var13 == var12 - 1) {
                           if (var14) {
                              var15 = var9 + var7.a;
                           } else {
                              var15 = var9 + var11 - var6.a;
                           }
                        } else if (var14) {
                           var15 = var9 + var7.a + var6.a + var13 * var6.a;
                        } else {
                           var15 = var9 + var13 * var6.a;
                        }

                        var6.a(var8, var15, var10 - var6.b / 2, 2, 0, var21);
                     }
                  } else {
                     for(var13 = 0; var13 < var12; ++var13) {
                        if (var13 == var12 - 1) {
                           if (var14) {
                              var15 = var9 + var11 - (var6.a + var7.a);
                           } else {
                              var15 = var9 + var11 - var6.a;
                           }
                        } else if (var14) {
                           var15 = var9 + var13 * var6.a + var5.a;
                        } else {
                           var15 = var9 + var13 * var6.a;
                        }

                        var6.a(var8, var15, var10 - var6.b / 2, 0, 0, var21);
                     }
                  }
               }

               if (this.s == -1) {
                  if (var5 != null) {
                     var5.a(var8, var9 + var11 - var5.a, var10 - var5.b / 2, 2, 0, var21);
                  }

                  if (var7 != null) {
                     var7.a(var8, var9, var10 - var7.b / 2, 2, 0, var21);
                  }
               } else {
                  if (var5 != null) {
                     var5.a(var8, var9, var10 - var5.b / 2, 0, 0, var21);
                  }

                  if (var7 != null) {
                     var7.a(var8, var9 + var11 - var7.a - 1, var10 - var7.b / 2, 0, 0, var21);
                  }
               }

               if (this.s == -1 && this.aa[0] != null) {
                  this.aa[0].a(this.f[this.u], this.o + this.q - this.aa[0].a, this.p - this.aa[0].b / 2 - 1, 2, 0, var1);
               }
            }

            return;
         case 25:
            var2 = var1;
            var17 = this;

            for(var18 = 0; var18 < var17.d.size(); ++var18) {
               if ((var20 = (Point)var17.d.elementAt(var18)).n && !var20.m) {
                  if (!var20.o) {
                     var20.a(var2, var20.p, 3, false);
                  }

                  if (var20.o) {
                     var20.q.a(var20.i / var17.n % var20.q.c, var20.b, var20.c, var17.t, 3, var2);
                  }
               }
            }

            return;
         case 26:
            if (this.aa != null) {
               if (this.f != null) {
                  this.aa[0].a(this.f[this.v], this.y, this.z, 0, 33, var1);
               }

               if (this.E == 1 || this.E == 2) {
                  byte var3 = 33;
                  int var4 = this.F;
                  if (this.g[this.w] == 0 || this.g[this.w] == 1) {
                     var3 = 3;
                     var4 = 0;
                  }

                  this.aa[1].a(this.g[this.w], this.o, this.p + var4 + this.x, 0, var3, var1);
               }
            }

            return;
         }
      } catch (Exception var16) {
         ResLog.b(var16.toString());
         this.b = true;
      }

   }

   private void c() {
      int var1 = ResLog.random(3, 5);
      this.l = 90;

      for(int var2 = 0; var2 < var1; ++var2) {
         Point var3;
         (var3 = new Point()).b = this.o + ResLog.e(4);
         var3.c = this.p + ResLog.e(5);
         if (this.j == 0) {
            var3.j = ResLog.d(10);
            byte var4 = 1;
            if (var2 % 2 == 0) {
               var4 = -1;
            }

            var3.b = this.o + ResLog.d(c[5][0] / 2) * var4;
            var3.c = this.p - ResLog.d(c[5][1] / 2);
            var3.p = new FrameImage(7);
         }

         this.d.addElement(var3);
      }

   }

   private void d() {
      this.o = this.J.cx + 20 * this.J.I;
      this.m = this.G / 15;
      if (this.L != null) {
         for(int var1 = 0; var1 < 15; ++var1) {
            Point var2;
            (var2 = new Point()).p = this.aa[0];
            var2.q = this.aa[2];
            var2.b = this.o;
            var2.c = this.p;
            if (this.L != null) {
               var2.g = this.L.b;
               var2.h = this.L.c;
               if (this.k > 0) {
                  var2.g += ResLog.c(0, this.k);
                  var2.h += ResLog.c(0, this.k);
               }
            }

            this.C = ResLog.random(9, 12);
            if (var1 == 14) {
               var2.p = this.aa[1];
               var2.q = this.aa[3];
               var2.g = this.L.b;
               var2.h = this.L.c;
               this.C = 9;
            }

            var2.n = false;
            var2.o = false;
            var2.m = false;
            int var4 = this.C;
            var2.d = var4;
            var4 = var2.g - var2.b;
            int var5 = var2.h - var2.c;
            int var6 = ResLog.a(var4, var5);
            var2.k = var2.a(var6);
            int var8;
            if ((var8 = ResLog.d(var4, var5) / var2.d) == 0) {
               var8 = 1;
            }

            var6 = var4 / var8;
            int var7 = var5 / var8;
            if (var6 == 0 && var4 < var8) {
               var6 = var4 < 0 ? -1 : 1;
            }

            if (var7 == 0 && var5 < var8) {
               var7 = var5 < 0 ? -1 : 1;
            }

            if (ResLog.g(var6) > ResLog.g(var4)) {
               var6 = var4;
            }

            if (ResLog.g(var7) > ResLog.g(var5)) {
               var7 = var5;
            }

            var2.e = var6;
            var2.f = var7;
            this.d.addElement(var2);
         }

      } else {
         this.b = true;
      }
   }

   private void a(int var1, int var2, int var3, int var4) {
      if (this.u == -1) {
         this.d.removeAllElements();
      }

      this.W = new int[4];
      if (var3 <= var2) {
         var3 = var2 + 1;
      }

      for(var4 = 0; var4 < 4; ++var4) {
         if (ResLog.d(2) == 0) {
            this.W[var4] = V[this.X][ResLog.d(3)];
         } else {
            this.W[var4] = V[this.X][2];
         }
      }

      for(var4 = 0; var4 < 4; ++var4) {
         nr_ck var5 = new nr_ck();
         int var6 = 5 + var4 * 45;
         int var7;
         if ((var7 = 45 + var4 * 45 - 5) <= var6) {
            var7 = var6 + 1;
         }

         int var8 = ResLog.random(var2, var3);
         int var9 = ResLog.random(var1, var1 + 3);
         var6 = ResLog.random(var6, var7);
         var7 = ResLog.random(13, 23);
         boolean var10 = ResLog.d(4) == 0;
         var6 = ResLog.c(var6 % 360);
         var5.a(this.y - ResLog.a(var6) * (var8 + var7), this.z - ResLog.b(var6) * (var8 + var7), this.y - ResLog.a(var6) * var7, this.z - ResLog.b(var6) * var7, ResLog.a(var6) * var9, ResLog.b(var6) * var9, var10);
         this.d.addElement(var5);
         var5 = new nr_ck();
         var6 = ResLog.c((var6 + 180 + ResLog.c(2, 5)) % 360);
         var5.a(this.y - ResLog.a(var6) * (var8 + var7), this.z - ResLog.b(var6) * (var8 + var7), this.y - ResLog.a(var6) * var7, this.z - ResLog.b(var6) * var7, ResLog.a(var6) * var9, ResLog.b(var6) * var9, var10);
         this.d.addElement(var5);
      }

   }

   private void e() {
      this.e = new FrameImage(8);
      this.l = ResLog.random(23, 27);
      int var1 = ResLog.random(1, 3);
      this.D = this.p - 40;

      for(int var2 = 0; var2 < var1; ++var2) {
         Point var3;
         (var3 = new Point()).b = this.o + ResLog.c(0, 20);
         var3.c = this.p + ResLog.e(7);
         if (this.i == 10) {
            var3.k = ResLog.random(0, this.e.c - 2);
         } else if (this.i == 11) {
            var3.k = ResLog.random(2, this.e.c);
         } else {
            var3.k = ResLog.random(0, this.e.c);
         }

         ResLog.d(2);
         var3.f = -ResLog.random(1, 4);
         this.d.addElement(var3);
      }

   }

   private void a(boolean var1) {
      if (this.K != null) {
         for(int var2 = 0; var2 < this.K.length; ++var2) {
            if (this.K[var2] != null) {
               if (this.K[var2].a == 0) {
                  Mob var3;
                  if ((var3 = GameScr.c(this.K[var2].l)) != null) {
                     var3.M = var1;
                     var3.Y = false;
                     var3.N = this.T[var2];
                     var3.O = this.U[var2];
                  }
               } else {
                  Point var10001 = this.K[var2];
                  Char var4;
                  if (Char.myCharz().charID == var10001.l) {
                     var4 = Char.myCharz();
                  } else {
                     var4 = GameScr.findCharInMap(this.K[var2].l);
                  }

                  if (var4 != null) {
                     var4.cZ = var1;
                     var4.bR = false;
                     var4.da = this.T[var2];
                     var4.db = this.U[var2];
                  }
               }
            }
         }

      }
   }

   private void f() {
      byte var1 = 0;
      int[] var2 = null;
      int[] var3 = null;
      switch(this.i) {
      case 16:
         var1 = 26;
         if (this.j == 0) {
            var2 = new int[]{7};
            var3 = new int[]{28};
         }

         if (this.j == 1) {
            var2 = new int[]{2};
            var3 = new int[]{23};
         }
         break;
      case 17:
         var1 = 25;
         var2 = new int[]{2};
         var3 = new int[]{16};
         break;
      case 18:
         var1 = 24;
         var2 = new int[1];
         var3 = new int[]{9};
         break;
      case 19:
         var1 = 25;
         var2 = new int[1];
         var3 = new int[]{14};
         break;
      case 20:
         var1 = 26;
         var2 = new int[1];
         var3 = new int[]{21};
         break;
      case 21:
         var1 = 24;
         var2 = new int[]{1};
         var3 = new int[]{10};
         break;
      case 22:
         var1 = 25;
         var2 = new int[]{1};
         var3 = new int[]{15};
         break;
      case 23:
         var1 = 26;
         var2 = new int[]{1};
         var3 = new int[]{22};
         break;
      case 24:
         var1 = 24;
         var2 = new int[]{2, 3, 4};
         var3 = new int[]{11, 12, 13};
         break;
      case 25:
         var1 = 25;
         var2 = new int[]{3, 4, 5, 6};
         var3 = new int[]{17, 18, 19, 20};
         break;
      case 26:
         var1 = 26;
         byte var4 = 0;
         byte var5 = 0;
         if (this.j == 0) {
            var4 = 4;
            var5 = 25;
         } else if (this.j == 1) {
            var4 = 5;
            var5 = 26;
         } else if (this.j == 2) {
            var4 = 6;
            var5 = 27;
         }

         var2 = new int[]{var4, 3};
         var3 = new int[]{var5, 24};
      }

      if (var2 != null && var3 != null) {
         this.aa = new FrameImage[var2.length];

         for(int var6 = 0; var6 < var2.length; ++var6) {
            FrameImage var7;
            if ((var7 = mSystem.d("Skills_" + var1 + "_" + this.h + "_" + var2[var6])) == null) {
               var7 = new FrameImage(var3[var6]);
            }

            if (var7 != null) {
               this.aa[var6] = var7;
            }
         }
      }

   }

   private void a(mGraphics var1, int var2) {
      this.aa[0].a(this.u / this.n % this.aa[0].c, this.o, this.p, this.s, var2, var1);
   }
}
