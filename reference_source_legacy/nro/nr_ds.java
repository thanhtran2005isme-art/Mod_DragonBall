package nro;

public final class nr_ds {
   public int a;
   public int b;
   public int c;
   public int d;
   public int e;
   public int f;
   public int g;
   public int h;
   private int p;
   private int q;
   public int i;
   public int j;
   public int k;
   public int l;
   private int r;
   private int s;
   private int[] t = new int[3];
   public boolean m;
   private boolean u;
   private int v;
   public int n;
   public int o;
   private int w;
   private boolean x = true;

   public final nr_by a() {
      nr_ds var1;
      int var2;
      int var3;
      int var4;
      int var5;
      int var6;
      byte var7;
      if (this.x) {
         boolean var8 = false;
         var1 = this;
         var3 = this.p;
         var4 = this.q;
         var5 = this.i;
         var6 = this.j;
         if (main.GameCanvas.k) {
            if (!this.m && main.GameCanvas.b(var3, var4, var5, var6)) {
               for(var5 = 0; var5 < var1.t.length; ++var5) {
                  var1.t[0] = main.GameCanvas.p;
               }

               var1.s = main.GameCanvas.p;
               var1.m = true;
               var1.n = -1;
               var1.u = var1.v != 0;
               var1.v = 0;
            } else if (this.m) {
               ++this.r;
               if (this.r > 5 && this.s == main.GameCanvas.p && !this.u) {
                  this.s = -1000;
                  if (this.w > 1) {
                     var5 = (this.b + main.GameCanvas.p - var4) / this.o;
                     var2 = (this.a + main.GameCanvas.o - var3) / this.o;
                     this.n = var5 * this.w + var2;
                  } else {
                     this.n = (this.b + main.GameCanvas.p - var4) / this.o;
                  }
               }

               if ((var5 = main.GameCanvas.p - this.t[0]) != 0 && this.n != -1) {
                  this.n = -1;
               }

               for(var2 = this.t.length - 1; var2 > 0; --var2) {
                  var1.t[var2] = var1.t[var2 - 1];
               }

               var1.t[0] = main.GameCanvas.p;
               var1.b -= var5;
               if (var1.b < 0) {
                  var1.b = 0;
               }

               if (var1.b > var1.l) {
                  var1.b = var1.l;
               }

               if (var1.d < 0 || var1.d > var1.l) {
                  var5 /= 2;
               }

               var1.d -= var5;
            }
         }

         boolean var12 = false;
         if (main.GameCanvas.m && var1.m) {
            var2 = main.GameCanvas.p - var1.t[0];
            main.GameCanvas.m = false;
            if (ResLog.g(var2) < 20 && ResLog.g(main.GameCanvas.p - var1.s) < 20 && !var1.u) {
               var1.v = 0;
               var1.b = var1.d;
               var1.s = -1000;
               if (var1.w > 1) {
                  var2 = (var1.b + main.GameCanvas.p - var4) / var1.o;
                  var3 = (var1.a + main.GameCanvas.o - var3) / var1.o;
                  var1.n = var2 * var1.w + var3;
               } else {
                  var1.n = (var1.b + main.GameCanvas.p - var4) / var1.o;
               }

               var1.r = 0;
               var12 = true;
            } else if (var1.n != -1 && var1.r > 5) {
               var1.r = 0;
               var12 = true;
            } else if (var1.n == -1 && !var1.u) {
               if (var1.d < 0) {
                  var1.b = 0;
               } else if (var1.d > var1.l) {
                  var1.b = var1.l;
               } else {
                  if ((var2 = main.GameCanvas.p - var1.t[0] + (var1.t[0] - var1.t[1]) + (var1.t[1] - var1.t[2])) > 10) {
                     var7 = 10;
                  } else if (var2 < -10) {
                     var7 = -10;
                  } else {
                     var7 = 0;
                  }

                  var1.v = -var7 * 100;
               }
            }

            var1.m = false;
            var1.r = 0;
            main.GameCanvas.m = false;
         }

         nr_by var11;
         (var11 = new nr_by()).b = var1.n;
         var11.c = var12;
         var11.a = var1.m;
         return var11;
      } else {
         var1 = this;
         var2 = this.p;
         var3 = this.q;
         var4 = this.i;
         var5 = this.j;
         if (main.GameCanvas.k) {
            if (!this.m && main.GameCanvas.b(var2, var3, var4, var5)) {
               for(var6 = 0; var6 < var1.t.length; ++var6) {
                  var1.t[0] = main.GameCanvas.o;
               }

               var1.s = main.GameCanvas.o;
               var1.m = true;
               var1.n = -1;
               var1.u = var1.v != 0;
               var1.v = 0;
            } else if (this.m) {
               ++this.r;
               if (this.r > 5 && this.s == main.GameCanvas.o && !this.u) {
                  this.s = -1000;
                  this.n = (this.a + main.GameCanvas.o - var2) / this.o;
               }

               if ((var6 = main.GameCanvas.o - this.t[0]) != 0 && this.n != -1) {
                  this.n = -1;
               }

               for(var5 = this.t.length - 1; var5 > 0; --var5) {
                  var1.t[var5] = var1.t[var5 - 1];
               }

               var1.t[0] = main.GameCanvas.o;
               var1.a -= var6;
               if (var1.a < 0) {
                  var1.a = 0;
               }

               if (var1.a > var1.k) {
                  var1.a = var1.k;
               }

               if (var1.c < 0 || var1.c > var1.k) {
                  var6 /= 2;
               }

               var1.c -= var6;
            }
         }

         boolean var10 = false;
         if (main.GameCanvas.m && var1.m) {
            var5 = main.GameCanvas.o - var1.t[0];
            main.GameCanvas.m = false;
            if (ResLog.g(var5) < 20 && ResLog.g(main.GameCanvas.o - var1.s) < 20 && !var1.u) {
               var1.v = 0;
               var1.a = var1.c;
               var1.s = -1000;
               var1.n = (var1.a + main.GameCanvas.o - var2) / var1.o;
               var1.r = 0;
               var10 = true;
            } else if (var1.n != -1 && var1.r > 5) {
               var1.r = 0;
               var10 = true;
            } else if (var1.n == -1 && !var1.u) {
               if (var1.c < 0) {
                  var1.a = 0;
               } else if (var1.c > var1.k) {
                  var1.a = var1.k;
               } else {
                  if ((var2 = main.GameCanvas.o - var1.t[0] + (var1.t[0] - var1.t[1]) + (var1.t[1] - var1.t[2])) > 10) {
                     var7 = 10;
                  } else if (var2 < -10) {
                     var7 = -10;
                  } else {
                     var7 = 0;
                  }

                  var1.v = -var7 * 100;
               }
            }

            var1.m = false;
            var1.r = 0;
            main.GameCanvas.m = false;
         }

         nr_by var9;
         (var9 = new nr_by()).b = var1.n;
         var9.c = var10;
         var9.a = var1.m;
         return var9;
      }
   }

   public final void b() {
      if (this.v != 0 && !this.m) {
         if (this.x) {
            this.b += this.v / 100;
            if (this.b < 0) {
               this.b = 0;
            } else if (this.b > this.l) {
               this.b = this.l;
            } else {
               this.d = this.b;
            }
         } else {
            this.a += this.v / 100;
            if (this.a < 0) {
               this.a = 0;
            } else if (this.a > this.k) {
               this.a = this.k;
            } else {
               this.c = this.a;
            }
         }

         this.v = this.v * 9 / 10;
         if (this.v < 100 && this.v > -100) {
            this.v = 0;
         }
      }

      if (this.c != this.a && !this.m) {
         this.e = this.a - this.c << 2;
         this.g += this.e;
         this.c += this.g >> 4;
         this.g &= 15;
      }

      if (this.d != this.b && !this.m) {
         this.f = this.b - this.d << 2;
         this.h += this.f;
         this.d += this.h >> 4;
         this.h &= 15;
      }

   }

   public final void a(int var1, int var2, int var3, int var4, int var5, int var6, boolean var7, int var8) {
      this.p = var3;
      this.q = var4;
      this.o = var2;
      this.i = var5;
      this.j = var6;
      this.x = true;
      this.w = 1;
      var3 = var1;
      if (false) {
         var3 = var1 + 1;
      }

      this.l = var3 * var2 - var6;
      if (this.l < 0) {
         this.l = 0;
      }

      if (this.k < 0) {
         this.k = 0;
      }

   }

   public final void a(int var1) {
      if (this.x) {
         var1 -= (this.j - this.o) / 2;
         this.b = var1;
         if (this.b < 0) {
            this.b = 0;
         }

         if (this.b > this.l) {
            this.b = this.l;
            return;
         }
      } else {
         var1 -= (this.i - this.o) / 2;
         this.a = var1;
         if (this.a < 0) {
            this.a = 0;
         }

         if (this.a > this.k) {
            this.a = this.k;
         }
      }

   }
}
