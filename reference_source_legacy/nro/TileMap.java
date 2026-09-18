package nro;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.microedition.lcdui.Image;
import main.GameMidlet;

public final class TileMap {
   public static int a;
   public static int b;
   public static int c;
   public static int d;
   public static int e;
   private static int I = -1;
   public static int[] f;
   public static int[] g;
   private static Image[] J;
   private static Image K;
   private static Image L;
   public static Image h;
   private static Image M;
   private static Image N;
   public static byte i = 24;
   private static int O;
   private static int P;
   private static int Q;
   private static int R;
   public static boolean j = false;
   public static String k = "";
   public static int l;
   public static int m = -1;
   public static int n;
   public static int bgID;
   public static int p;
   public static int q = -1;
   public static byte r;
   public static byte s = -1;
   public static MyVector t = new MyVector("vGO");
   public static MyVector u = new MyVector("vItemBg");
   public static MyVector v = new MyVector("vCurrItem");
   public static String[] mapNames;
   public static Image x = mSystem.load("/mainImage/myTexture2dbong.png");
   private static int[] S;
   public static int[][] y;
   public static int[][][] z;
   public static Image A;
   public static int B;
   public static int C;
   public static int D;
   public static int E;
   public static int F;
   public static int G;
   public static int H;

   static {
      new MyVector("vObject");
      S = new int[]{21, 22, 23, 39, 40, 41};
      int[] var10000 = new int[]{21, 22, 23, 24, 25, 26};
      var10000 = new int[]{0, 7, 14};
      A = mSystem.load("/bg/light.png");
      var10000 = new int[]{5257738, 8807192};
      H = 0;
   }

   public static boolean a() {
      return l == 51 || l == 103 || l == 112 || l == 113 || l == 129 || l == 130;
   }

   public static boolean b() {
      return l == 39 || l == 40 || l == 41;
   }

   public static boolean c() {
      return GameScr.bY != null && l == GameScr.bY.l;
   }

   public static nr_cx a(int var0) {
      for(int var1 = 0; var1 < u.size(); ++var1) {
         nr_cx var2;
         if ((var2 = (nr_cx)u.elementAt(var1)).a == var0) {
            return var2;
         }
      }

      return null;
   }

   public static boolean d() {
      for(int var0 = 0; var0 < S.length; ++var0) {
         if (l == S[var0]) {
            return true;
         }
      }

      return false;
   }

   public static boolean b(int var0) {
      if (var0 != 156 && var0 != 330 && var0 != 345 && var0 != 334) {
         if (l != 54 && l != 55 && l != 56 && l != 57 && l != 58 && l != 59 && l != 103) {
            int var1 = 0;

            for(int var2 = 0; var2 < v.size(); ++var2) {
               if (((nr_cx)v.elementAt(var2)).a == var0) {
                  ++var1;
               }
            }

            if (var1 > 2) {
               return true;
            } else {
               return false;
            }
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   public static final void e() {
      if (K == null) {
         K = mSystem.loadImageRMS("/tWater/wtf.png");
      }

      if (L == null) {
         L = mSystem.loadImageRMS("/tWater/twtf.png");
      }

      if (h == null) {
         h = mSystem.loadImageRMS("/tWater/wts.png");
      }

      if (M == null) {
         M = mSystem.loadImageRMS("/tWater/wtsN.png");
      }

      if (N == null) {
         N = mSystem.loadImageRMS("/tWater/wtsN2.png");
      }

      System.gc();
   }

   public static void c(int var0) {
      d = b * i;
      c = a * i;
      --var0;

      try {
         for(int var1 = 0; var1 < a * b; ++var1) {
            for(int var2 = 0; var2 < y[var0].length; ++var2) {
               int[] var10001 = z[var0][var2];
               int var5 = y[var0][var2];
               int[] var4 = var10001;
               int var3 = var1;

               for(int var6 = 0; var6 < var4.length; ++var6) {
                  if (f[var3] == var4[var6]) {
                     int[] var10000 = g;
                     var10000[var3] |= var5;
                     break;
                  }
               }
            }
         }

      } catch (Exception var7) {
         System.out.println("Error Load Map");
         var7.printStackTrace();
         GameMidlet.instance.a();
      }
   }

   public static boolean f() {
      return l == 45 || l == 46 || l == 48;
   }

   public static boolean g() {
      return j || l == 45 || l == 46 || l == 48 || l == 51 || l == 52 || l == 103 || l == 112 || l == 113 || l == 115 || l == 117 || l == 118 || l == 119 || l == 120 || l == 121 || l == 125 || l == 129 || l == 130;
   }

   private static void a(mGraphics var0, int var1, int var2, int var3) {
      try {
         if (J == null) {
            return;
         }

         if (J.length != 1) {
            var0.drawImage(J[var1], var2 * i, var3 * i, 0);
            return;
         }

         var0.setColor(J[0], 0, var1 * i, i, i, 0, var2 * i, var3 * i, 0);
      } catch (Exception var4) {
      }

   }

   private static void a(mGraphics var0, int var1, int var2, int var3, int var4) {
      try {
         if (J != null) {
            if (J.length == 1) {
               var0.setColor(J[0], 0, var1 * 24, 24, 24, 0, var2, var3, 0);
            } else {
               var0.drawImage(J[var1], var2, var3, 0);
            }
         }
      } catch (Exception var5) {
      }
   }

   public static final void a(mGraphics var0) {
      try {
         if (Char.isLoadingMap) {
            return;
         }

         GameScr.gI();
         GameScr.a(var0, 1);

         int var1;
         int var2;
         int var3;
         for(var1 = GameScr.o; var1 < GameScr.q; ++var1) {
            for(var2 = GameScr.p; var2 < GameScr.r; ++var2) {
               if (var1 != 0 && var1 != a - 1) {
                  var3 = f[var2 * a + var1] - 1;
                  if ((a(var1, var2) & 256) != 256) {
                     if ((a(var1, var2) & 32) == 32) {
                        var0.setColor(K, 0, 24 * (main.GameCanvas.v % 8 >> 1), 24, 24, 0, var1 * i, var2 * i, 0);
                     } else if ((a(var1, var2) & 128) == 128) {
                        var0.setColor(L, 0, 24 * (main.GameCanvas.v % 8 >> 1), 24, 24, 0, var1 * i, var2 * i, 0);
                     } else if (e != 13 || var3 == -1) {
                        if (e == 2 && (a(var1, var2) & 512) == 512 && var3 != -1) {
                           a(var0, var3, var1 * i, var2 * i, 24);
                           a(var0, var3, var1 * i, var2 * i + 1, 24);
                        }

                        if ((a(var1, var2) & 16) == 16) {
                           P = (O = var1 * i - GameScr.cmx) - GameScr.f;
                           Q = (R = (i - 2) * P / i) + GameScr.f;
                           a(var0, var3, Q + GameScr.cmx, var2 * i, 24);
                        } else if ((a(var1, var2) & 512) == 512) {
                           if (var3 != -1) {
                              a(var0, var3, var1 * i, var2 * i, 24);
                              a(var0, var3, var1 * i, var2 * i + 1, 24);
                           }
                        } else if (var3 != -1) {
                           a(var0, var3, var1, var2);
                        }
                     }
                  }
               }
            }
         }

         if (GameScr.cmx < 24) {
            for(var1 = GameScr.p; var1 < GameScr.r; ++var1) {
               if ((var2 = f[var1 * a + 1] - 1) != -1) {
                  a(var0, var2, 0, var1);
               }
            }
         }

         if (GameScr.cmx > GameScr.n) {
            var1 = a - 2;

            for(var2 = GameScr.p; var2 < GameScr.r; ++var2) {
               if ((var3 = f[var2 * a + var1] - 1) != -1) {
                  a(var0, var3, var1 + 1, var2);
               }
            }

            return;
         }
      } catch (Exception var4) {
      }

   }

   private static boolean i() {
      return l != 54 && l != 55 && l != 56 && l != 57 && l != 138 && l != 167;
   }

   public static final void b(mGraphics var0) {
      if (!main.GameCanvas.a) {
         try {
            for(int var1 = GameScr.o; var1 < GameScr.q; ++var1) {
               for(int var2 = GameScr.p; var2 < GameScr.r; ++var2) {
                  if ((a(var1, var2) & 64) == 64) {
                     Image var3;
                     if (e == 5) {
                        var3 = M;
                     } else if (e == 8) {
                        var3 = N;
                     } else {
                        var3 = h;
                     }

                     if (!i()) {
                        var0.setColor(var3, 0, 0, 24, 24, 0, var1 * i, var2 * i - 1, 0);
                        var0.setColor(var3, 0, 0, 24, 24, 0, var1 * i, var2 * i - 3, 0);
                     }

                     var0.setColor(var3, 0, (main.GameCanvas.v % 8 >> 2) * 24, 24, 24, 0, var1 * i, var2 * i - 12, 0);
                     if (H == 0 && i()) {
                        H = var2 * i - 12;
                        int var5 = 16777215;
                        if (main.GameCanvas.ab == 2) {
                           var5 = 10871287;
                        } else if (main.GameCanvas.ab == 4) {
                           var5 = 8111470;
                        } else if (main.GameCanvas.ab == 7) {
                           var5 = 5693125;
                        } else if (main.GameCanvas.ab == 19) {
                           var5 = 16711680;
                        }

                        BackgroudEffect.a(var5, H + 15);
                     }
                  }
               }
            }

            BackgroudEffect.b(var0);
         } catch (Exception var4) {
         }
      }
   }

   public static void d(int var0) throws IOException {
      InputStream var2 = FireWorkMn.a("/mymap/" + var0);
      DataInputStream var3;
      a = (char)(var3 = new DataInputStream(var2)).read();
      b = (char)var3.read();
      f = new int[var3.available()];

      for(int var1 = 0; var1 < a * b; ++var1) {
         f[var1] = (char)var3.read();
      }

      g = new int[f.length];
   }

   public static final int a(int var0, int var1) {
      try {
         return g[var1 * a + var0];
      } catch (Exception var2) {
         return 1000;
      }
   }

   public static final int b(int var0, int var1) {
      try {
         return g[var1 / i * a + var0 / i];
      } catch (Exception var2) {
         return 1000;
      }
   }

   public static final boolean a(int var0, int var1, int var2) {
      try {
         return (g[var1 / i * a + var0 / i] & var2) == var2;
      } catch (Exception var3) {
         return false;
      }
   }

   public static final void b(int var0, int var1, int var2) {
      int[] var10000 = g;
      int var10001 = var1 / i * a + var0 / i;
      var10000[var10001] |= 512;
   }

   public static final void c(int var0, int var1, int var2) {
      int[] var10000 = g;
      int var10001 = var1 / i * a + var0 / i;
      var10000[var10001] &= -513;
   }

   public static final int e(int var0) {
      return var0 / i * i;
   }

   public static final int f(int var0) {
      return var0 / i * i;
   }

   public static void h() {
      System.gc();
      if (I != e) {
         int var0;
         if (mSystem.d != 5 && mSystem.d != 3 && mSystem.d != 8) {
            if (mSystem.loadImageRMS("/t/" + e + "$1.png") != null) {
               Rms.DeleteStorage("x" + mGraphics.zoomLevel + "t" + e);
               J = new Image[100];

               for(var0 = 0; var0 < J.length; ++var0) {
                  J[var0] = mSystem.loadImageRMS("/t/" + e + "$" + (var0 + 1) + ".png");
               }
            } else {
               Image var1;
               if ((var1 = mSystem.loadImageRMS("/t/" + e + ".png")) != null) {
                  Rms.DeleteStorage("$");
                  (J = new Image[1])[0] = var1;
               }
            }
         } else if (mGraphics.zoomLevel == 1) {
            (J = new Image[1])[0] = mSystem.loadImage("/t/" + e + ".png");
         } else {
            J = new Image[100];

            for(var0 = 0; var0 < J.length; ++var0) {
               J[var0] = mSystem.loadImage("/t/" + e + "/" + (var0 + 1) + ".png");
            }
         }

         I = e;
      }

   }
}
