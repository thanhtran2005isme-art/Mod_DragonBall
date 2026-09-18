package nro;

public final class ServerEffect2 extends Effect2 {
   private EffectCharPaint a;
   private int b;
   private int c;
   private int d;
   private short e = 0;
   private long f = 0L;

   public static void a(int var0, int var1, int var2, int var3) {
      ServerEffect2 var4;
      (var4 = new ServerEffect2()).a = GameScr.y[var0 - 1];
      var4.c = var1;
      var4.d = var2;
      var4.e = 2;
      Effect2.vEffect3.addElement(var4);
   }

   public final void paint(mGraphics var1) {
      if (mGraphics.zoomLevel == 1) {
         ++GameScr.aM;
      }

      if (GameScr.aM < 8) {
         int var2 = this.c + this.a.a[this.b].a;
         int var3 = this.d + this.a.a[this.b].b;
         SmallImage.b(var1, this.a.a[this.b].c, var2, var3, 0, 3);
      }

   }

   public final void update() {
      if (0L != 0L) {
         ++this.b;
         if (this.b >= this.a.a.length) {
            this.b = 0;
         }

         if (System.currentTimeMillis() > 0L) {
            Effect2.vEffect3.removeElement(this);
            return;
         }
      } else {
         ++this.b;
         if (this.b >= this.a.a.length) {
            --this.e;
            if (this.e <= 0) {
               Effect2.vEffect3.removeElement(this);
               return;
            }

            this.b = 0;
         }
      }

   }
}
