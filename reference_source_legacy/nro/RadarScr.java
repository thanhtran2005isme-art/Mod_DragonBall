package nro;

import javax.microedition.lcdui.Image;

public final class RadarScr extends mScreen {
   private static RadarScr h;
   private static boolean i;
   private static FrameImage j;
   private static FrameImage k;
   public static FrameImage a;
   private static Image l;
   private static Image m;
   private static Image n;
   private static Image o;
   private static Image p;
   private static Image q;
   private static Image r;
   private static Image s;
   private static Image t;
   private static Image u;
   private static Image v;
   private static Image w;
   private static Image x;
   private static Image y;
   private static Image[] z;
   private static int A;
   private static int B;
   private static int C;
   private static int D;
   private static int E;
   private static int F;
   public static int b;
   public static int c;
   public static int d;
   private static int G;
   public static int e;
   private static int H;
   private static int[] I = new int[0];
   private static int[] J = new int[0];
   private static int[][] K;
   private static int[][] L;
   private static int[] M = new int[]{-2, -1, 0, 1, 2};
   private int N;
   private int[] O;
   private int P;
   private int Q;
   private int R = 0;
   public static MyVector list;
   public static MyVector g;
   private static int S;
   private Info_RadaScr T;
   private int U = 0;
   private int V = 0;
   private int W;
   private int X;
   private int Y;

   public static RadarScr a() {
      if (h == null) {
         h = new RadarScr();
      }

      return h;
   }

   public RadarScr() {
      i = true;
      Image var1 = mSystem.load("/radar/17.png");
      Image var2 = mSystem.load("/radar/3.png");
      Image var3 = mSystem.load("/radar/23.png");
      j = new FrameImage(var1, 28, 28);
      k = new FrameImage(var2, 30, 30);
      a = new FrameImage(var3, 11, 11);
      l = mSystem.load("/radar/0.png");
      n = mSystem.load("/radar/1.png");
      o = mSystem.load("/radar/2.png");
      m = mSystem.load("/radar/17.png");
      p = mSystem.load("/radar/4.png");
      q = mSystem.load("/radar/5.png");
      r = mSystem.load("/radar/6.png");
      z = new Image[7];

      for(int var4 = 0; var4 < 7; ++var4) {
         z[var4] = mSystem.load("/radar/" + (var4 + 7) + ".png");
      }

      s = mSystem.load("/radar/14.png");
      t = mSystem.load("/radar/15.png");
      u = mSystem.load("/radar/16.png");
      m = mSystem.load("/radar/18.png");
      w = mSystem.load("/radar/19.png");
      x = mSystem.load("/radar/20.png");
      y = mSystem.load("/radar/21.png");
      v = mSystem.load("/radar/22.png");
      C = 200;
      D = 219;
      A = main.GameCanvas.B - (C + 40) / 2;
      B = main.GameCanvas.hh - D / 2;
      b = A + C - 81;
      c = B + 29;
      d = 120;
      e = 80;
      K = new int[][]{{A + 34, B + D - 42}, {A + C / 2 - p.getWidth() / 2, B + D / 2 + 33}, {A + C - 41, B + D - 42}};
      L = new int[][]{{A + 25, B + D - 82}, {A + 57, B + D - 62}, {A + C / 2 - 14, B + D - 102}, {A + C - 57 - 28, B + D - 62}, {A + C - 25 - 28, B + D - 82}};
      this.O = new int[2];
      this.N = 0;
      E = A + 73;
      F = B + D / 2 + 5;
      H = B + D - 22;
      I = new int[]{A + C / 2 - 8 - 80, A + C / 2 - 8, A + C / 2 - 8 + 80};
      J = new int[3];
      this.X = c + 10 + 70;
      this.Y = 0;
      list = new MyVector("");
      g = new MyVector("");
      this.P = 1;
      this.Q = 2;
   }

   public final void a(MyVector var1, int var2, int var3) {
      list = var1;
      S = var2;
      this.P = 1;
      this.R = 2;
      this.f();
      i = true;
      e();
      if (i) {
         this.Q = var1.size() / 5 + (var1.size() % 5 > 0 ? 1 : 0);
      } else {
         this.Q = g.size() / 5 + (g.size() % 5 > 0 ? 1 : 0);
      }
   }

   public static void a(int var0, int var1) {
      S = var0;
   }

   public static void e() {
      g = new MyVector("");

      for(int var0 = 0; var0 < list.size(); ++var0) {
         Info_RadaScr var1;
         if ((var1 = (Info_RadaScr) list.elementAt(var0)) != null && var1.k == 1) {
            g.addElement(var1);
         }
      }

   }

   private void f() {
      MyVector var1 = g;
      if (i) {
         var1 = list;
      }

      int var2;
      int var3 = (var2 = (this.P - 1) * 5) + 5;

      for(int var4 = var2; var4 < var3; ++var4) {
         if (var4 >= var1.size()) {
            M[var4 - var2] = -1;
         } else {
            Info_RadaScr var5;
            if ((var5 = (Info_RadaScr)var1.elementAt(var4)) != null) {
               M[var4 - var2] = var5.e;
            }
         }
      }

      SoundMn.stopAll();
   }

   public final void update() {
      try {
         if (e < 80 && (e += 4) > 80) {
            e = 80;
         }

         this.T = Info_RadaScr.a(g, M[this.R]);
         if (i) {
            this.T = Info_RadaScr.a(list, M[this.R]);
         }

         GameScr.gI().update();
         if (main.GameCanvas.v % 10 < 6) {
            if (main.GameCanvas.v % 2 == 0) {
               --this.N;
            }
         } else {
            this.N = 0;
         }

         if (this.T != null) {
            int var1 = this.T.b * 100 / this.T.c;
            this.Y = var1 * w.getHeight() / 100;
            var1 = S * 100 / list.size();
            this.W = var1 * y.getWidth() / 100;
            return;
         }
      } catch (Exception var2) {
         System.out.println("-upd-radaScr-null: " + var2.toString());
      }

   }

   public final void updateKey() {
      if (!InfoDlg.b) {
         if (main.GameCanvas.isTouch && !ChatTextField.gI().b && !main.GameCanvas.menu.a) {
            RadarScr var1 = this;
            if (!main.GameCanvas.l) {
               J[0] = 0;
               J[1] = 0;
               J[2] = 0;
               this.O[0] = 0;
               this.O[1] = 0;
            } else {
               int var2;
               for(var2 = 0; var2 < 5; ++var2) {
                  if (main.GameCanvas.isPointerHoldIn(L[var2][0], L[var2][1], 30, 30) && main.GameCanvas.l && main.GameCanvas.m && var2 != var1.R) {
                     var1.R = var2;
                     e = 0;
                  }
               }

               if (main.GameCanvas.isPointerHoldIn(K[0][0] - 5, K[0][1] - 5, 20, 20)) {
                  if (main.GameCanvas.k) {
                     var1.O[0] = 1;
                  }

                  if (main.GameCanvas.l && main.GameCanvas.m) {
                     var1.c(0);
                     var1.O[0] = 0;
                  }
               }

               if (main.GameCanvas.isPointerHoldIn(K[2][0] - 5, K[2][1] - 5, 20, 20)) {
                  if (main.GameCanvas.k) {
                     var1.O[1] = 1;
                  }

                  if (main.GameCanvas.l && main.GameCanvas.m) {
                     var1.c(1);
                     var1.O[1] = 0;
                  }
               }

               for(var2 = 0; var2 < I.length; ++var2) {
                  if (main.GameCanvas.isPointerHoldIn(I[var2] - 5, H - 5, 20, 20)) {
                     if (main.GameCanvas.k) {
                        J[var2] = 1;
                     }

                     if (main.GameCanvas.l && main.GameCanvas.m) {
                        var1.b(var2);
                        J[var2] = 0;
                     }
                  }
               }
            }

            if (main.GameCanvas.isPointerHoldIn(b, 0, d, c + e)) {
               if (main.GameCanvas.n) {
                  if (var1.V == 0) {
                     var1.V = main.GameCanvas.p;
                  }

                  var1.U = var1.V - main.GameCanvas.p;
                  if (var1.U != 0) {
                     G += var1.U;
                     var1.V = main.GameCanvas.p;
                  }

                  if (G < 0) {
                     G = 0;
                  }

                  if (G > var1.T.r.h) {
                     G = var1.T.r.h;
                  }
               } else {
                  var1.V = 0;
                  var1.V = 0;
               }
            }
         }

         if (main.GameCanvas.keyPressed[8]) {
            main.GameCanvas.keyPressed[8] = false;
            this.d(1);
         }

         if (main.GameCanvas.keyPressed[2]) {
            main.GameCanvas.keyPressed[2] = false;
            this.d(-1);
         }

         if (main.GameCanvas.keyPressed[4]) {
            main.GameCanvas.keyPressed[4] = false;
            this.e(1);
         }

         if (main.GameCanvas.keyPressed[6]) {
            main.GameCanvas.keyPressed[6] = false;
            this.e(0);
         }

         if (main.GameCanvas.keyPressed[12]) {
            main.GameCanvas.keyPressed[12] = false;
            this.b(0);
         }

         if (main.GameCanvas.keyPressed[5]) {
            main.GameCanvas.keyPressed[5] = false;
            this.b(1);
         }

         if (main.GameCanvas.keyPressed[13]) {
            this.b(2);
         }

         main.GameCanvas.clearKeyPressed();
      }
   }

   private void b(int var1) {
      if (var1 == 0) {
         i = !i;
         this.P = 1;
         this.R = 0;
         if (i) {
            this.Q = list.size() / 5 + (list.size() % 5 > 0 ? 1 : 0);
         } else {
            this.Q = g.size() / 5 + (g.size() % 5 > 0 ? 1 : 0);
         }

         this.f();
         e = 0;
      } else if (var1 == 1) {
         if (this.T != null) {
            Service.gI().b((int)1, (int)this.T.e);
         }
      } else if (var1 == 2) {
         GameScr.gI().switchToMe();
      }

      SoundMn.stopAll();
   }

   private void c(int var1) {
      if (i) {
         this.Q = list.size() / 5 + (list.size() % 5 > 0 ? 1 : 0);
      } else {
         this.Q = g.size() / 5 + (g.size() % 5 > 0 ? 1 : 0);
      }

      int var2 = this.P;
      if (var1 == 0) {
         if (this.P == 1) {
            return;
         }

         --var2;
         if (var2 <= 0) {
            var2 = 1;
         }
      } else {
         if (this.P == this.Q) {
            return;
         }

         ++var2;
         if (var2 > this.Q) {
            var2 = this.Q;
         }
      }

      if (var2 != this.P) {
         this.P = var2;
         this.f();
      }

   }

   private void d(int var1) {
      if ((G += var1 * 12) < 0) {
         G = 0;
      }

      if (G > this.T.r.h) {
         G = this.T.r.h;
      }

   }

   private void e(int var1) {
      int var2 = this.R;
      int var3 = this.P;
      if (var1 == 0) {
         ++var2;
      } else {
         --var2;
      }

      if (var2 >= M.length) {
         if (this.P < this.Q) {
            var2 = 0;
            ++var3;
         } else {
            var2 = M.length - 1;
         }
      }

      if (var2 < 0) {
         if (this.P > 1) {
            var2 = M.length - 1;
            --var3;
         } else {
            var2 = 0;
         }
      }

      if (var2 != this.R) {
         this.R = var2;
         G = 0;
         e = 0;
      }

      if (var3 != this.P) {
         this.P = var3;
         this.f();
      }

   }

   public final void paint(mGraphics var1) {
      try {
         GameScr.gI().paint(var1);
         var1.setColor(-GameScr.cmx, -GameScr.cmy);
         var1.setColor(0, main.GameCanvas.ac);
         GameScr.c(var1);
         var1.drawImage(l, A, B, 0);
         var1.drawImage(x, A + C / 2 - mSystem.a(x) / 2, B - mSystem.b(x) / 2 - 2, 0);
         var1.e(A + C / 2 - mSystem.a(x) / 2 + 13, B - mSystem.b(x) / 2 + 3, this.W, mSystem.b(x));
         var1.drawImage(y, A + C / 2 - mSystem.a(x) / 2 + 13, B - mSystem.b(x) / 2 + 3, 0);
         GameScr.c(var1);
         var1.drawImage(u, I[0], H + J[0], 0);
         var1.drawImage(r, I[1], H + J[1], 0);
         var1.drawImage(t, I[2], H + J[2], 0);
         if (i) {
            var1.setColor(s, 0, 0, 17, 17, 0, I[1], H + J[1], 0);
         } else {
            var1.setColor(s, 0, 0, 17, 17, 1, I[1], H + J[1], 0);
         }

         if (this.T != null) {
            var1.e(A + 30, B + 13, C - 60, D / 2);
            Info_RadaScr var10000 = this.T;
            int var5 = F;
            int var4 = E;
            Info_RadaScr var2 = var10000;
            ++var10000.p;
            if (var2.p > var2.o.length - 1) {
               var2.p = 0;
            }

            if (var2.d == 0) {
               if (Mob.arrMobTemplate[var2.m.C] != null) {
                  if (Mob.arrMobTemplate[var2.m.C].data != null) {
                     Mob.arrMobTemplate[var2.m.C].data.a(var1, var2.o[var2.p], var4, var5, 0, 0);
                  } else if (var2.q - main.GameCanvas.b < 0L) {
                     var2.q = main.GameCanvas.b + 1500L;
                     var2.m.getData();
                  }
               }
            } else if (var2.l != null) {
               var2.l.a(var1, var4, var5, 1, var2.o[var2.p], true);
            }

            GameScr.c(var1);
            mFont.d.drawStringBd(var1, (this.T.j > 0 ? "Lv." + this.T.j + " " : "") + this.T.h, A + C / 2, B + 15, 2);
            mFont.s.drawStringBd(var1, "no." + this.T.f, A + 30, c - 2, 0);
            var1.drawImage(v, A + 36, c + 10, 0);
            var1.e(A + 36, this.X - this.Y, 7, this.Y);
            var1.drawImage(w, A + 36, c + 10, 0);
            GameScr.c(var1);
            var1.drawImage(z[this.T.a], A + 39 - 5 + 14, c + 12, 0);
         }

         var1.e(b, c, d + 5, e + 8);
         if (this.T != null) {
            var1.drawImage(m, b, c, 0);
         }

         GameScr.c(var1);
         var1.e(b, c + 1, d, e + 5);
         if (this.T != null && this.T.r != null) {
            if (this.T.r.d == null) {
               return;
            }

            this.T.r.a(var1, G);
         }

         GameScr.c(var1);
         if (!i && g.size() > 5 || i) {
            if (this.P > 1) {
               var1.drawImage(n, K[0][0], K[0][1] + this.O[0], 0);
            }

            if (this.P < this.Q) {
               var1.drawImage(o, K[2][0], K[2][1] + this.O[1], 0);
            }
         }

         for(int var8 = 0; var8 < M.length; ++var8) {
            int var3 = 0;
            byte var9 = 0;
            byte var10 = 0;
            if (var8 == this.R) {
               var3 = this.N;
               var9 = -10;
               var10 = 1;
               var1.drawImage(p, L[var8][0] + 10, L[var8][1] + this.N + 29 + -10, 0);
            }

            Info_RadaScr var6 = Info_RadaScr.a(g, M[var8]);
            if (i) {
               var6 = Info_RadaScr.a(list, M[var8]);
            }

            if (var6 != null) {
               j.a(var6.a, L[var8][0], L[var8][1] + var3 + var9, 0, 0, var1);
               SmallImage.b(var1, var6.g, L[var8][0] + 14, L[var8][1] + 14 + var3 + var9, 0, StaticObj.f);
               var6.a(var1, L[var8][0], L[var8][1] + var3 + var9);
               if (var6.j == 0) {
                  var1.drawImage(q, L[var8][0], L[var8][1] + var3 + var9, 0);
               }

               if (var8 == this.R) {
                  j.a(7, L[var8][0], L[var8][1] + var3 + var9, 0, 0, var1);
               }

               if (var6.k == 1) {
                  j.a(8, L[var8][0], L[var8][1] + var3 + var9, 0, 0, var1);
               }
            } else {
               k.a(var10, L[var8][0] - 1, L[var8][1] - 1 + var3 + var9, 0, 0, var1);
            }
         }

      } catch (Exception var7) {
         System.out.println("-paint-radaScr-null: " + var7.toString());
      }
   }

   public final void switchToMe() {
      GameScr.a = true;
      super.switchToMe();
   }
}
