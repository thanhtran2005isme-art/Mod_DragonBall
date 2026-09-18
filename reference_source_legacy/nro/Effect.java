package nro;

import java.io.InputStream;

public final class Effect {
   public int a;
   public int b;
   public int c;
   public int d;
   private boolean m;
   private Char n;
   public int e;
   private int o;
   public int f;
   public int g;
   private int p;
   private int q;
   private int r;
   private boolean s = true;
   public int h;
   public int i = 0;
   private static MyVector t = new MyVector("vEffData");
   public int j = 0;
   public long k = 0L;
   private static MyVector u = new MyVector("vLastEff");
   public static MyVector l = new MyVector("vNewEff");
   private int[] v = new int[]{0, 0, 0, 0, 0, 1, 1, 1, 1, 1};
   private int[] w = new int[]{2, 2, 2, 2, 2, 3, 3, 3, 3, 3};
   private int[] x = new int[]{4, 4, 4, 4, 4, 5, 5, 5, 5, 5};
   private int[] y = new int[]{6, 6, 6, 6, 6, 7, 7, 7, 7, 7};
   private int[] z = new int[]{8, 8, 8, 8, 8, 9, 9, 9, 9, 9};
   private boolean A = false;
   private short[] B;

   private static void b(int var0) {
      for(int var1 = 0; var1 < t.size(); ++var1) {
         EffectData var2;
         if ((var2 = (EffectData)t.elementAt(var1)).d == var0) {
            t.removeElement(var2);
            return;
         }
      }

   }

   private static void a(EffectData var0) {
      t.addElement(var0);
      if (TileMap.l != 130) {
         if (t.size() > 10) {
            for(int var1 = 0; var1 < 5; ++var1) {
               t.removeElementAt(0);
            }
         }

      }
   }

   public static EffectData a(int var0) {
      for(int var1 = 0; var1 < t.size(); ++var1) {
         EffectData var2;
         if ((var2 = (EffectData)t.elementAt(var1)).d == var0) {
            return var2;
         }
      }

      return null;
   }

   public Effect() {
   }

   public Effect(int var1, Char var2, int var3, int var4, int var5, byte var6) {
      this.n = var2;
      this.a = var1;
      this.h = var3;
      this.p = var4;
      this.q = var5;
      this.i = var6;
      if (a(var1) == null) {
         EffectData var8;
         (var8 = new EffectData()).d = var1;
         if (var1 >= 42 && var1 <= 46) {
            var1 = 106;
         }

         String var9 = "/x" + mGraphics.zoomLevel + "/effectdata/" + var1 + "/data";
         InputStream var10 = null;

         try {
            var10 = FireWorkMn.a(var9);
         } catch (Exception var7) {
         }

         if (var10 == null) {
            Service.gI().a((short)var1);
         } else {
            if (var1 > 100 && var1 < 200) {
               var8.readData2(var9);
            } else {
               var8.a(var9);
            }

            var8.a = mSystem.load("/effectdata/" + var1 + "/img.png");
         }

         a(var8);
      }

      this.c = -1;
      this.d = -1;
      this.j = -1;
      this.b = 4;
   }

   public Effect(int var1, int var2, int var3, int var4, int var5, int var6) {
      this.f = var2;
      this.g = var3;
      this.a = var1;
      this.h = var4;
      this.p = var5;
      this.q = var6;
      if (a(var1) == null) {
         EffectData var8;
         (var8 = new EffectData()).d = var1;
         if (var1 >= 42 && var1 <= 46) {
            var1 = 106;
         }

         String var9 = "/x" + mGraphics.zoomLevel + "/effectdata/" + var1 + "/data";
         InputStream var10 = null;

         try {
            var10 = FireWorkMn.a(var9);
         } catch (Exception var7) {
         }

         if (var10 == null) {
            Service.gI().a((short)var1);
         } else {
            if (var1 > 100 && var1 < 200) {
               var8.readData2(var9);
            } else {
               var8.a(var9);
            }

            var8.a = mSystem.load("/effectdata/" + var1 + "/img.png");
         }

         a(var8);
         if (u.size() > 20) {
            b(Integer.parseInt((String)u.elementAt(0)));
            u.removeElementAt(0);
         }

         u.addElement(String.valueOf(this.a));
      }

      this.c = -1;
      this.d = -1;
      this.b = 1;
      if (!a(String.valueOf(this.a))) {
         l.addElement(String.valueOf(this.a));
      }

   }

   private static boolean a(String var0) {
      for(int var1 = 0; var1 < l.size(); ++var1) {
         if (((String)l.elementAt(var1)).equals(var0)) {
            return true;
         }
      }

      return false;
   }

   private boolean b() {
      return this.s;
   }

   public final void a(mGraphics var1, int var2, int var3) {
      if (this.b()) {
         if (a(this.a).a != null) {
            a(this.a).a(var1, this.o, this.f + var2, this.g + var3, this.j, this.h);
         }

      }
   }

   public final void a(mGraphics var1) {
      if (this.b()) {
         if (a(this.a) != null) {
            if (a(this.a).a != null) {
               try {
                  a(this.a).a(var1, this.o, this.f, this.g, this.j, this.h);
                  return;
               } catch (Exception var2) {
                  ResLog.c("Effect " + this.a + " err at frame " + this.o + " vitri " + this.f + "_" + this.g + "   " + this.h);
                  var2.printStackTrace();
               }
            }

         }
      }
   }

   public final void a() {
      try {
         if (this.a >= 42 && this.a <= 46) {
            if (this.a == 42) {
               this.o = this.v[this.e];
            }

            if (this.a == 43) {
               this.o = this.w[this.e];
            }

            if (this.a == 44) {
               this.o = this.x[this.e];
            }

            if (this.a == 45) {
               this.o = this.y[this.e];
            }

            if (this.a == 46) {
               this.o = this.z[this.e];
            }

            ++this.e;
            if (this.e > this.v.length - 1) {
               this.e = 0;
            }

            return;
         }

         if (a(this.a) == null) {
            return;
         }

         if (a(this.a).a == null) {
            return;
         }

         if (this.b == 5) {
            EffectData var10001 = a(this.a);
            int var2 = this.n.statusMe;
            EffectData var1 = var10001;
            if (var2 >= var1.c.length) {
               var2 = 0;
            }

            this.B = var1.c[var2] == null ? new short[1] : var1.c[var2];
         } else {
            this.B = a(this.a).b;
         }

         if (this.B != null) {
            if (!this.A) {
               this.A = true;
               int var4;
               if ((var4 = this.B.length - 1) > 0 && this.b != 1) {
                  this.e = ResLog.random(0, var4);
               }

               if (this.b == 0) {
                  this.e = ResLog.random(this.c, this.d);
               }
            }

            switch(this.b) {
            case 0:
               if (ResLog.a(this.f - 50, this.g - 50, 100, 100, Char.myCharz().cx, Char.myCharz().cy) && this.e > this.c && this.e < this.d) {
                  if (this.e < this.d) {
                     this.e = this.d;
                  }

                  this.m = true;
               }

               if (!this.m) {
                  ++this.e;
                  if (this.e == this.d) {
                     this.e = this.c;
                  }
               } else if (this.e < this.B.length) {
                  ++this.e;
               }
               break;
            case 1:
            case 3:
               if (this.e < this.B.length) {
                  ++this.e;
               }
               break;
            case 2:
               if (this.e < this.B.length) {
                  ++this.e;
               }

               ++this.r;
               if (this.r == this.q) {
                  this.r = 0;
                  this.j = ResLog.random(0, 2);
               }
               break;
            case 4:
               this.f = this.n.cx;
               this.g = this.n.cy;
               if (this.e < this.B.length) {
                  ++this.e;
               }
               break;
            case 5:
               this.j = this.n.I == 1 ? 0 : 1;
               if (this.n.I == 1) {
                  this.f = this.n.cx - 15;
               } else {
                  this.f = this.n.cx + 15;
               }

               if (this.n.cC == 0) {
                  this.g = this.n.cy - 25;
               } else {
                  this.g = this.n.cy - 35;
               }

               if (this.e < this.B.length) {
                  ++this.e;
               }
            }

            if (this.e <= this.B.length - 1) {
               this.o = this.B[this.e];
            }
         }

         if (this.e < this.B.length - 1) {
            this.s = true;
            return;
         }

         if (this.b == 0 || this.b == 3) {
            this.s = false;
         }

         if (this.q == -1) {
            EffecMn.a.removeElement(this);
         }

         if (this.b == 2) {
            this.e = 0;
            return;
         }

         if (this.b == 1 && this.p == 1) {
            this.s = false;
         }

         if (this.b == 4 || this.b == 5) {
            if (this.p == -1) {
               this.e = 0;
               return;
            }

            ++this.r;
            if (this.r == this.q) {
               this.r = 0;
               --this.p;
               this.e = 0;
               if (this.p == 0) {
                  this.n.b((int)0, (int)this.a);
               }
            }

            return;
         }

         this.m = false;
         if (this.p == -1) {
            ++this.r;
            this.e = 0;
            if (this.r == this.q) {
               this.r = 0;
               if (this.q > 1) {
                  this.j = ResLog.random(0, 2);
                  return;
               }
            }
         } else {
            ++this.r;
            this.e = 0;
            if (this.r == this.q) {
               this.r = 0;
               --this.p;
               if (this.p == 0) {
                  EffecMn.a.removeElement(this);
                  return;
               }
            }
         }
      } catch (Exception var3) {
         System.out.println("err  Effect.update: " + this.a + "  " + this.b);
         var3.printStackTrace();
         EffecMn.a.removeElement(this);
      }

   }
}
