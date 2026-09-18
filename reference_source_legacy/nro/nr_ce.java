package nro;

public final class nr_ce {
   public int a;
   public int b;
   public int c;
   public int d;
   public int e;
   public int f;
   public int g = 1;
   public int h;
   public int i;
   public String j;
   public String k;
   public short l;
   public short m;
   public long n;

   public nr_ce(int var1, short var2, String var3, String var4, int var5, short var6) {
      new MyVector("vecInfo chientruong");
      this.a = var1;
      this.l = var2;
      this.j = var3;
      this.k = var4;
      this.m = var6;
      this.n = main.GameCanvas.b;
      this.b = var5;
      if (this.b <= 0) {
         this.b = 1;
      }

      this.c = 0;
      this.d = 0;
      this.e = 4;
      this.f = 6;
   }

   public final void a(int var1, int var2, int var3) {
      this.a = var1;
      this.h = var2;
      this.i = var3;
   }
}
