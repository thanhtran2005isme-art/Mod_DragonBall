package nro;

import javax.microedition.lcdui.Image;

public final class BackgroudEffect {
   public static MyVector a = new MyVector("vBG Effect");
   private int[] g;
   private int[] h;
   private int[] i;
   private int[] j;
   private static int[] k;
   private int l;
   private int m;
   private int n;
   private int o;
   private int p;
   private int q;
   private int r;
   private int s;
   private int t;
   private boolean u;
   private static Image v;
   private static Image w;
   private static Image x;
   private static Image y;
   private static Image z;
   private static Image A;
   private static Image B;
   private static Image C;
   private int[] D;
   private int E;
   public int b;
   private boolean[] F;
   private int[] G;
   private int[] H;
   private boolean[] I;
   private int J;
   private int K;
   private static int L = 16;
   private static Image M = mSystem.load("/mainImage/myTexture2dwater1.png");
   private static Image N = mSystem.load("/mainImage/myTexture2dwater2.png");
   private static Image O;
   private static Image P;
   public static short c;
   private static Image Q = null;
   public static boolean d;
   private static boolean R;
   public static int e;
   private static Image S;
   private static Image T;
   private static int U;
   private static int V;
   public static int f;
   private static int W;
   private int[] X = new int[]{0, 1, 2, 1, 0, 0};
   private int[] Y;

   public static void a() {
      TileMap.H = 0;
   }

   public static boolean b() {
      for(int var0 = 0; var0 < a.size(); ++var0) {
         BackgroudEffect var1;
         if ((var1 = (BackgroudEffect)a.elementAt(var0)).b == 0 || var1.b == 12) {
            return true;
         }
      }

      return false;
   }

   private BackgroudEffect(int var1) {
      this.b = var1;
      int var2;
      switch(this.b) {
      case 0:
      case 12:
         if (v == null) {
            v = mSystem.loadImageRMS("/bg/mua.png");
         }

         if (w == null) {
            w = mSystem.loadImageRMS("/bg/mua1.png");
         }

         if (x == null) {
            x = mSystem.loadImageRMS("/bg/mua2.png");
         }

         this.E = ResLog.random(main.GameCanvas.z / 3, main.GameCanvas.z / 2);
         this.g = new int[this.E];
         this.h = new int[this.E];
         this.i = new int[this.E];
         this.j = new int[this.E];
         this.D = new int[this.E];
         this.H = new int[this.E];
         this.G = new int[this.E];
         this.F = new boolean[this.E];
         this.I = new boolean[this.E];

         for(var2 = 0; var2 < this.E; ++var2) {
            this.h[var2] = ResLog.random(-10, main.GameCanvas.A + 100) + GameScr.cmy;
            this.g[var2] = ResLog.random(-10, main.GameCanvas.z + 300) + GameScr.cmx;
            this.H[var2] = ResLog.random(0, 1);
            this.i[var2] = -12;
            this.j[var2] = 12;
            this.D[var2] = ResLog.random(1, 3);
            this.F[var2] = false;
            if (this.D[var2] == 2 && var2 % 2 == 0) {
               this.F[var2] = true;
            }

            this.I[var2] = false;
            this.G[var2] = ResLog.random(1, 2);
         }

         return;
      case 1:
      case 2:
      case 5:
      case 6:
      case 7:
      case 11:
      case 15:
         if (this.b == 1) {
            z = mSystem.loadImageRMS("/bg/lacay.png");
            L = 10;
         }

         if (this.b == 2) {
            z = mSystem.loadImageRMS("/bg/lacay2.png");
            L = 18;
         }

         if (this.b == 5) {
            z = mSystem.loadImageRMS("/bg/lacay3.png");
            L = 14;
         }

         if (this.b == 6) {
            z = mSystem.loadImageRMS("/bg/lacay4.png");
            L = 14;
         }

         if (this.b == 7) {
            z = mSystem.loadImageRMS("/bg/lacay5.png");
            L = 12;
         }

         if (this.b == 11) {
            z = mSystem.loadImageRMS("/bg/tuyet.png");
         }

         if (this.b == 15) {
            if (SmallImage.c[11120] == null) {
               SmallImage.createImage(11120);
            }

            L = 16;
         }

         this.E = ResLog.random(15, 25);
         if (this.b == 11) {
            this.E = 100;
         }

         this.g = new int[this.E];
         this.h = new int[this.E];
         this.i = new int[this.E];
         this.j = new int[this.E];
         this.H = new int[this.E];
         this.G = new int[this.E];
         this.I = new boolean[this.E];

         for(var2 = 0; var2 < this.E; ++var2) {
            this.g[var2] = ResLog.random(-10, TileMap.c + 10);
            this.h[var2] = ResLog.random(0, TileMap.d);
            this.G[var2] = ResLog.random(0, 1);
            this.H[var2] = ResLog.random(0, 1);
            this.i[var2] = ResLog.random(-3, 3);
            this.j[var2] = ResLog.random(1, 4);
            if (this.b == 11) {
               this.G[var2] = ResLog.random(0, 2);
               this.i[var2] = ResLog.g(ResLog.random(1, 3));
               this.j[var2] = ResLog.g(ResLog.random(1, 3));
            }

            if (this.b == 15) {
               this.G[var2] = ResLog.random(0, 2);
               this.i[var2] = ResLog.g(ResLog.random(1, 3));
               this.j[var2] = ResLog.g(ResLog.random(1, 3));
            }
         }

         return;
      case 3:
         main.GameCanvas.aa = true;
         return;
      case 4:
         this.E = ResLog.random(5, 10);
         if (y == null) {
            y = mSystem.loadImageRMS("/bg/sao.png");
         }

         this.g = new int[this.E];
         this.h = new int[this.E];
         this.G = new int[this.E];
         this.H = new int[this.E];
         this.Y = new int[this.E];

         for(var2 = 0; var2 < this.E; ++var2) {
            this.g[var2] = ResLog.random(0, main.GameCanvas.z);
            this.h[var2] = ResLog.random(0, 50);
            if (var2 % 2 == 0) {
               this.Y[var2] = 0;
            } else if (var2 % 3 == 0) {
               this.Y[var2] = 1;
            } else if (var2 % 4 == 0) {
               this.Y[var2] = 2;
            } else {
               this.Y[var2] = 3;
            }

            this.H[var2] = ResLog.random(0, 10);
         }

         return;
      case 8:
         this.s = ResLog.random(100, 300);
         if (A == null) {
            A = mSystem.loadImageRMS("/bg/ship.png");
         }

         if (B == null) {
            B = mSystem.loadImageRMS("/bg/fire1.png");
         }

         if (C == null) {
            C = mSystem.loadImageRMS("/bg/fire2.png");
         }

         this.u = false;
         this.e();
         return;
      case 9:
         if (O == null) {
            O = mSystem.loadImageRMS("/bg/cham-tron1.png");
         }

         if (P == null) {
            P = mSystem.loadImageRMS("/bg/cham-tron2.png");
         }

         this.l = 20;
         this.g = new int[this.l];
         this.h = new int[this.l];
         k = new int[this.l];
         this.i = new int[this.l];

         for(var2 = 0; var2 < this.l; ++var2) {
            this.g[var2] = ResLog.g(ResLog.random(0, main.GameCanvas.z));
            this.h[var2] = ResLog.g(ResLog.random(10, 80));
            k[var2] = ResLog.g(ResLog.random(1, 3));
            this.i[var2] = k[var2];
         }

         return;
      case 10:
         this.l = 30;
         this.g = new int[this.l];
         this.h = new int[this.l];
         k = new int[this.l];
         this.i = new int[this.l];
         var1 = 0;

         for(var2 = 0; var2 < this.l; ++var2) {
            this.g[var2] = ResLog.g(ResLog.random(0, main.GameCanvas.z)) + GameScr.cmx;
            ++var1;
            if (var1 > this.l / 2) {
               this.h[var2] = ResLog.g(ResLog.random(20, 60));
               k[var2] = 10;
            } else {
               this.h[var2] = ResLog.g(ResLog.random(0, 20));
               k[var2] = 7;
            }

            this.i[var2] = k[var2] / 2 - 2;
         }

         return;
      case 13:
         if (ResLog.g(ResLog.random(0, 2)) == 0) {
            if (ResLog.g(ResLog.random(0, 2)) == 0) {
               R = true;
            } else {
               R = false;
            }

            e = ResLog.g(ResLog.random(2, 5));
            d();
            return;
         }
         break;
      case 14:
         if (ResLog.g(ResLog.random(0, 2)) == 0) {
            d = true;
            d();
         }
      }

   }

   private static void d() {
      if (mSystem.d == 1) {
         S = null;
         T = null;
      } else if (main.GameCanvas.a) {
         S = null;
         T = null;
      } else {
         if (e > 0) {
            if (S == null) {
               U = (S = mSystem.load("/bg/fog1.png")).getWidth();
            }
         } else {
            S = null;
         }

         if (!d) {
            T = null;
         } else {
            if (T == null) {
               T = mSystem.load("/bg/fog0.png");
            }

            W = 287;
         }
      }
   }

   private static void g(mGraphics var0) {
      if (mSystem.d != 1) {
         if (!main.GameCanvas.a) {
            if (e != 0) {
               if (S != null) {
                  for(int var1 = 0; var1 < e; ++var1) {
                     var0.setColor(S, (float)main.GameCanvas.Y[var1], (float)main.GameCanvas.Z[var1], 3);
                  }
               }

            }
         }
      }
   }

   public static void a(mGraphics var0) {
      if (mSystem.d != 1) {
         if (!main.GameCanvas.a) {
            if (d) {
               if (T != null) {
                  for(int var1 = V; var1 < TileMap.c; var1 += W) {
                     if (var1 >= GameScr.cmx - W) {
                        var0.setColor(T, (float)var1, (float)f, 0);
                     }
                  }
               }

            }
         }
      }
   }

   private void e() {
      int var1 = GameScr.cmx;
      int var2 = GameScr.cmy;
      this.o = ResLog.random(1, 3);
      this.u = false;
      this.t = ResLog.random(3, 5);
      BackgroudEffect var10000;
      byte var10001;
      if (this.o == 1) {
         this.m = -50;
         this.n = ResLog.random(var2, main.GameCanvas.A - 100 + var2);
         var10000 = this;
         var10001 = 0;
      } else {
         label29: {
            if (this.o == 2) {
               this.m = TileMap.c + 50;
               this.n = ResLog.random(var2, main.GameCanvas.A - 100 + var2);
               var10000 = this;
            } else {
               if (this.o == 3) {
                  this.m = ResLog.random(var1 + 50, main.GameCanvas.z - 50 + var1);
                  this.n = -50;
                  var1 = ResLog.random(0, 2);
                  this.p = var1 == 0 ? 0 : 2;
                  return;
               }

               if (this.o != 4) {
                  return;
               }

               this.m = ResLog.random(var1 + 50, main.GameCanvas.z - 50 + var1);
               this.n = TileMap.d + 50;
               var1 = ResLog.random(0, 2);
               var10000 = this;
               if (var1 == 0) {
                  var10001 = 0;
                  break label29;
               }
            }

            var10001 = 2;
         }
      }

      var10000.p = var10001;
   }

   public static void a(int var0) {
      if (!main.GameCanvas.a) {
         BackgroudEffect var1 = new BackgroudEffect(var0);
         a.addElement(var1);
      }
   }

   public static void a(int var0, int var1) {
      BackgroudEffect var2;
      (var2 = new BackgroudEffect(10)).K = var0;
      var2.J = var1;
      a.addElement(var2);
   }

   public static void b(mGraphics var0) {
      for(int var1 = 0; var1 < a.size(); ++var1) {
         BackgroudEffect var10000 = (BackgroudEffect)a.elementAt(var1);
         mGraphics var3 = var0;
         BackgroudEffect var2 = var10000;
         if (var10000.b == 10) {
            var0.setColor(var2.K);

            int var4;
            for(var4 = 0; var4 < var2.l; ++var4) {
               var3.drawImage(var4 < var2.l / 2 ? N : M, var2.g[var4], var2.h[var4] + var2.J, 0);
            }

            if (c != 0 && Q == null) {
               Q = SmallImage.c[c].a;
            }

            if (Q != null) {
               for(var4 = 0; var4 < var2.l / 2; ++var4) {
                  var3.drawImage(Q, var2.g[var4], var2.h[var4] + var2.J, 0);
               }
            }
         }
      }

   }

   public static void c(mGraphics var0) {
      for(int var1 = 0; var1 < a.size(); ++var1) {
         BackgroudEffect var2;
         switch((var2 = (BackgroudEffect)a.elementAt(var1)).b) {
         case 8:
            var0.setColor(A, 0, 0, A.getWidth(), A.getHeight(), var2.p, var2.m, var2.n, 3);
            int var4;
            if (var2.o != 1 && var2.o != 2) {
               var4 = var2.p == 0 ? 11 : -11;
               var0.setColor(C, 0, var2.q * 18, 8, 18, var2.p, var2.m + var4, var2.n + 22, 3);
               break;
            }

            var4 = var2.p == 0 ? -25 : 25;
            var0.setColor(B, 0, var2.q << 3, 20, 8, var2.p, var2.m + var4, var2.n + 5, 3);
            break;
         case 13:
            if (R) {
               g(var0);
            }
         }
      }

   }

   public static void d(mGraphics var0) {
      label91:
      for(int var1 = 0; var1 < a.size(); ++var1) {
         BackgroudEffect var10000 = (BackgroudEffect)a.elementAt(var1);
         mGraphics var3 = var0;
         BackgroudEffect var2 = var10000;

         try {
            switch(var2.b) {
            case 0:
            case 12:
               int var8 = 0;

               while(true) {
                  if (var8 >= var2.E) {
                     continue label91;
                  }

                  if (var2.D[var8] == 2 && var2.g[var8] >= GameScr.cmx && var2.g[var8] <= main.GameCanvas.z + GameScr.cmx && var2.h[var8] >= GameScr.cmy && var2.h[var8] <= main.GameCanvas.A + GameScr.cmy) {
                     if (var2.I[var8]) {
                        var3.setColor(v, 0, 10 * var2.G[var8], 13, 10, 0, var2.g[var8], var2.h[var8] - 10, 0);
                     } else {
                        var3.drawImage(w, var2.g[var8], var2.h[var8], 0);
                     }
                  }

                  ++var8;
               }
            case 1:
            case 2:
            case 5:
            case 6:
            case 7:
            case 11:
            case 15:
               if (var2.b == 15) {
                  if (SmallImage.c[11120] != null && SmallImage.c[11120].a != null) {
                     z = SmallImage.c[11120].a;
                  }

                  if (z == null) {
                     continue;
                  }
               }

               Image var4 = z;
               var3 = var3;
               var2 = var2;

               try {
                  for(int var5 = 0; var5 < var2.E; ++var5) {
                     if (var5 % 3 == 0 && var2.g[var5] >= GameScr.cmx && var2.g[var5] <= main.GameCanvas.z + GameScr.cmx && var2.h[var5] >= GameScr.cmy && var2.h[var5] <= main.GameCanvas.A + GameScr.cmy && var4 != null) {
                        var3.setColor(var4, 0, L * var2.G[var5], var4.getWidth(), L, 0, var2.g[var5], var2.h[var5], 0);
                     }
                  }
               } catch (Exception var6) {
               }
            case 3:
            case 4:
            case 8:
            case 9:
            case 10:
            case 14:
            default:
               break;
            case 13:
               if (!R) {
                  g(var3);
               }
            }
         } catch (Exception var7) {
         }
      }

   }

   public static void e(mGraphics var0) {
      for(int var1 = 0; var1 < a.size(); ++var1) {
         BackgroudEffect var10000 = (BackgroudEffect)a.elementAt(var1);
         mGraphics var3 = var0;
         BackgroudEffect var2 = var10000;
         var0.setColor(-var0.setColor(), -var0.b());
         int var4;
         if (var2.b == 4) {
            for(var4 = 0; var4 < var2.E; ++var4) {
               var3.setColor(y, 0, 16 * var2.G[var4], 16, 16, 0, var2.g[var4], var2.h[var4], 0);
            }
         }

         if (var2.b == 9) {
            var3.setColor(16777215);

            for(var4 = 0; var4 < var2.l; ++var4) {
               var3.drawImage(k[var4] == 1 ? O : P, var2.g[var4], var2.h[var4], 3);
            }
         }
      }

   }

   public static void f(mGraphics var0) {
      label76:
      for(int var1 = 0; var1 < a.size(); ++var1) {
         BackgroudEffect var10000 = (BackgroudEffect)a.elementAt(var1);
         mGraphics var3 = var0;
         BackgroudEffect var2 = var10000;
         switch(var10000.b) {
         case 0:
            var0.setColor(10742731);
            int var7 = 0;

            while(true) {
               if (var7 >= var2.E) {
                  continue label76;
               }

               if (var2.D[var7] != 2 && var2.g[var7] >= GameScr.cmx && var2.g[var7] <= main.GameCanvas.z + GameScr.cmx && var2.h[var7] >= GameScr.cmy && var2.h[var7] <= main.GameCanvas.A + GameScr.cmy) {
                  var3.drawImage(x, var2.g[var7], var2.h[var7], 0);
               }

               ++var7;
            }
         case 1:
         case 2:
         case 5:
         case 6:
         case 7:
         case 11:
         case 15:
            if (var2.b == 15) {
               if (SmallImage.c[11120] != null && SmallImage.c[11120].a != null) {
                  z = SmallImage.c[11120].a;
               }

               if (z == null) {
                  continue;
               }
            }

            Image var4 = z;
            var3 = var0;
            var2 = var2;

            try {
               for(int var5 = 0; var5 < var2.E; ++var5) {
                  if (var5 % 3 != 0 && var2.g[var5] >= GameScr.cmx && var2.g[var5] <= main.GameCanvas.z + GameScr.cmx && var2.h[var5] >= GameScr.cmy && var2.h[var5] <= main.GameCanvas.A + GameScr.cmy && var4 != null) {
                     var3.setColor(var4, 0, L * var2.G[var5], var4.getWidth(), L, 0, var2.g[var5], var2.h[var5], 0);
                  }
               }
            } catch (Exception var6) {
            }
         case 3:
         case 4:
         case 8:
         case 9:
         case 10:
         case 12:
         case 13:
         case 14:
         }
      }

   }

   public static void c() {
      label248:
      for(int var0 = 0; var0 < a.size(); ++var0) {
         BackgroudEffect var1 = (BackgroudEffect)a.elementAt(var0);

         try {
            int[] var10000;
            int var2;
            int var10002;
            int var3;
            switch(var1.b) {
            case 0:
            case 12:
               var2 = 0;

               while(true) {
                  if (var2 >= var1.E) {
                     continue label248;
                  }

                  if (var2 % 3 != 0 && var1.b != 12 && TileMap.a(var1.g[var2], var1.h[var2] - main.GameCanvas.ac, 2)) {
                     var1.I[var2] = true;
                  }

                  if (var2 % 3 == 0 && var1.h[var2] > main.GameCanvas.A + GameScr.cmy) {
                     var1.g[var2] = ResLog.random(-10, main.GameCanvas.z + 300) + GameScr.cmx;
                     var1.h[var2] = ResLog.random(-100, 0) + GameScr.cmy;
                  }

                  if (!var1.I[var2]) {
                     var10000 = var1.h;
                     var10000[var2] += var1.j[var2];
                     var10000 = var1.g;
                     var10000[var2] += var1.i[var2];
                  }

                  if (var1.I[var2]) {
                     var10002 = var1.H[var2]++;
                     if (var1.H[var2] > 2) {
                        var10002 = var1.G[var2]++;
                        var1.H[var2] = 0;
                        if (var1.G[var2] > 1) {
                           var1.G[var2] = 0;
                           var1.I[var2] = false;
                           var1.g[var2] = ResLog.random(-10, main.GameCanvas.z + 300) + GameScr.cmx;
                           var1.h[var2] = ResLog.random(-100, 0) + GameScr.cmy;
                        }
                     }
                  }

                  ++var2;
               }
            case 1:
            case 2:
            case 5:
            case 6:
            case 7:
            case 11:
            case 15:
               for(var2 = 0; var2 < var1.E; ++var2) {
                  if (var2 % 3 != 0 && TileMap.a(var1.g[var2], var1.h[var2] + (TileMap.e == 15 ? 10 : 0), 2)) {
                     var1.I[var2] = true;
                  }

                  if (var2 % 3 == 0 && var1.h[var2] > TileMap.d) {
                     var1.g[var2] = ResLog.random(-10, TileMap.c + 50);
                     var1.h[var2] = ResLog.random(-50, 0);
                  }

                  if (var1.I[var2]) {
                     var10002 = var1.H[var2]++;
                     if (var1.H[var2] == 100) {
                        var1.H[var2] = 0;
                        var1.g[var2] = ResLog.random(-10, TileMap.c + 50);
                        var1.h[var2] = ResLog.random(-50, 0);
                        var1.I[var2] = false;
                     }
                  } else {
                     for(var3 = 0; var3 < Teleport.vTeleport.size(); ++var3) {
                        Teleport var4;
                        if ((var4 = (Teleport) Teleport.vTeleport.elementAt(var3)) != null && var4.e && var1.g[var2] < var4.b + 80 && var1.g[var2] > var4.b - 80 && var1.h[var2] < var4.c + 80 && var1.h[var2] > var4.c - 80) {
                           var10000 = var1.g;
                           var10000[var2] += var1.g[var2] < var4.b ? -10 : 10;
                        }
                     }

                     var10000 = var1.h;
                     var10000[var2] += var1.j[var2];
                     var10000 = var1.g;
                     var10000[var2] += var1.i[var2];
                     var10002 = var1.H[var2]++;
                     if (var1.H[var2] > (var1.b != 2 ? 2 : 4)) {
                        if (var1.b != 11 && var1.b != 15) {
                           var10002 = var1.G[var2]++;
                        }

                        var1.H[var2] = 0;
                        if (var1.G[var2] > 3) {
                           var1.G[var2] = 0;
                        }
                     }
                  }
               }
            case 3:
            default:
               break;
            case 4:
               var2 = 0;

               while(true) {
                  if (var2 >= var1.E) {
                     continue label248;
                  }

                  var10002 = var1.H[var2]++;
                  if (var1.H[var2] > 10) {
                     var10002 = var1.Y[var2]++;
                     var1.H[var2] = 0;
                     if (var1.Y[var2] > 5) {
                        var1.Y[var2] = 0;
                     }

                     var1.G[var2] = var1.X[var1.Y[var2]];
                  }

                  ++var2;
               }
            case 8:
               ++var1.r;
               if (var1.r == 3) {
                  var1.r = 0;
                  ++var1.q;
                  if (var1.q > 1) {
                     var1.q = 0;
                  }
               }

               if (main.GameCanvas.v % var1.s == 0) {
                  var1.u = true;
               }

               if (var1.u) {
                  if (var1.o == 1) {
                     var1.m += var1.t;
                     if (var1.m > TileMap.c + 50) {
                        var1.e();
                     }
                  } else if (var1.o == 2) {
                     var1.m -= var1.t;
                     if (var1.m < -50) {
                        var1.e();
                     }
                  } else if (var1.o == 3) {
                     var1.n += var1.t;
                     if (var1.n > TileMap.d + 50) {
                        var1.e();
                     }
                  } else if (var1.o == 4) {
                     var1.n -= var1.t;
                     if (var1.n < -50) {
                        var1.e();
                     }
                  }
               }
               break;
            case 9:
               var2 = 0;

               while(true) {
                  if (var2 >= var1.l) {
                     continue label248;
                  }

                  var10000 = var1.g;
                  var10000[var2] -= var1.i[var2];
                  if (var1.g[var2] < -var1.i[var2]) {
                     k[var2] = ResLog.g(ResLog.random(1, 3));
                     var1.i[var2] = k[var2];
                     var1.g[var2] = main.GameCanvas.z + var1.i[var2];
                  }

                  ++var2;
               }
            case 10:
               var2 = 0;

               while(true) {
                  if (var2 >= var1.l) {
                     continue label248;
                  }

                  var10000 = var1.g;
                  var10000[var2] -= var1.i[var2];
                  if (var1.g[var2] < -var1.i[var2] + GameScr.cmx) {
                     var1.g[var2] = main.GameCanvas.z + var1.i[var2] + GameScr.cmx;
                  }

                  ++var2;
               }
            case 13:
               if (mSystem.d != 1 && !main.GameCanvas.a && e > 0) {
                  int var6 = main.GameCanvas.currentScreen == GameScr.gI() ? TileMap.c : GameScr.cmx + main.GameCanvas.z;

                  for(var2 = 0; var2 < e; ++var2) {
                     var3 = var2 + 1;
                     var10000 = main.GameCanvas.Y;
                     var10000[var2] -= var3;
                     if (main.GameCanvas.Y[var2] < -U) {
                        main.GameCanvas.Y[var2] = var6 + 100;
                     }
                  }
               }
               break;
            case 14:
               if (mSystem.d != 1 && !main.GameCanvas.a && d && --V < -W) {
                  V = 0;
               }
            }
         } catch (Exception var5) {
         }
      }

   }
}
