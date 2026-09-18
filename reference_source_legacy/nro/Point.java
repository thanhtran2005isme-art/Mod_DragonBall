package nro;

public final class Point {
   public byte a;
   public int b;
   public int c;
   public int d;
   public int e;
   public int f;
   public int g;
   public int h;
   public int i;
   public int j;
   public int k;
   public int l;
   public boolean m = false;
   public boolean n = false;
   public boolean o = false;
   public FrameImage p;
   public FrameImage q;
   private byte[] t = new byte[]{12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, 23, 22, 21, 20, 19, 18, 17, 16, 15, 14, 13};
   public byte[] r = new byte[]{0, 0, 2, 1, 1, 2, 0, 0, 2, 1, 1, 2, 0, 0, 2, 1, 1, 2, 0, 0, 2, 1, 1, 2};
   public byte[] s = new byte[]{2, 2, 3, 3, 3, 4, 5, 5, 5, 5, 5, 1, 0, 0, 0, 0, 0, 7, 6, 6, 6, 6, 6, 2};

   public final void a() {
      ++this.i;
      this.b += this.e;
      this.c += this.f;
   }

   public final int a(int var1) {
      byte var2;
      if (var1 > 15 && var1 <= 345) {
         if ((var1 = (var1 - 15) / 15 + 1) > 24) {
            var1 = 24;
         }

         var2 = this.t[var1];
      } else {
         var2 = 12;
      }

      return var2;
   }

   public final void a(mGraphics var1, FrameImage var2, int var3, boolean var4) {
      if (var2 != null) {
         if ((var3 = var2.c / 3) <= 0) {
            var3 = 1;
         }

         int var5;
         if (var2.c > 3) {
            var5 = this.i / 3 % 2 == 0 ? 0 : 3;
         } else {
            var5 = this.i % var3;
         }

         var3 = var3 * this.r[this.k] + var5;
         if (var2.c < 3) {
            var3 = this.i / 3 % var2.c;
         }

         var2.a(var3, this.b, this.c, this.s[this.k], 3, var1);
      }
   }
}
