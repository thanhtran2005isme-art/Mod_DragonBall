package nro;

public final class ServerEffect extends Effect2 {
   private EffectCharPaint a;
   private int b;
   private int c;
   private int d;
   private Char e;
   private Mob f;
   private short g = 0;
   private long h = 0L;
   private int i;

   public static void addServerEffect(int var0, int var1, int var2, int var3) {
      ServerEffect var4;
      (var4 = new ServerEffect()).a = GameScr.y[var0 - 1];
      var4.c = var1;
      var4.d = var2;
      var4.g = (short)var3;
      Effect2.vEffect2.addElement(var4);
   }

   public static void a(int var0, int var1, int var2, int var3, int var4) {
      ServerEffect var5;
      (var5 = new ServerEffect()).a = GameScr.y[var0 - 1];
      var5.c = var1;
      var5.d = var2;
      var5.g = 1;
      var5.i = var4;
      Effect2.vEffect2.addElement(var5);
   }

   public static void addServerEffect(int var0, Mob var1, int var2) {
      ServerEffect var3;
      (var3 = new ServerEffect()).a = GameScr.y[var0 - 1];
      var3.f = var1;
      var3.g = 1;
      Effect2.vEffect2.addElement(var3);
   }

   public static void a(int var0, Char var1, int var2) {
      ServerEffect var3;
      (var3 = new ServerEffect()).a = GameScr.y[var0 - 1];
      var3.e = var1;
      var3.g = (short)var2;
      Effect2.vEffect2.addElement(var3);
   }

   public final void paint(mGraphics var1) {
      if (mGraphics.zoomLevel == 1) {
         ++GameScr.aM;
      }

      if (GameScr.aM < 11) {
         if (this.e != null) {
            this.c = this.e.cx;
            this.d = this.e.cy + main.GameCanvas.ac;
         }

         if (this.f != null) {
            this.c = this.f.x;
            this.d = this.f.y + main.GameCanvas.ac;
         }

         int var2 = this.c + this.a.a[this.b].a;
         int var3 = this.d + this.a.a[this.b].b;
         if (main.GameCanvas.d(var2, var3)) {
            SmallImage.b(var1, this.a.a[this.b].c, var2, var3, this.i, 3);
         }
      }

   }

   public final void update() {
      if (0L != 0L) {
         ++this.b;
         if (this.b >= this.a.a.length) {
            this.b = 0;
         }

         if (System.currentTimeMillis() > 0L) {
            Effect2.vEffect2.removeElement(this);
         }
      } else {
         ++this.b;
         if (this.b >= this.a.a.length) {
            --this.g;
            if (this.g <= 0) {
               Effect2.vEffect2.removeElement(this);
            } else {
               this.b = 0;
            }
         }
      }

      if (main.GameCanvas.v % 11 == 0 && this.e != null && this.e != Char.myCharz() && !GameScr.vCharInMap.contains(this.e)) {
         Effect2.vEffect2.removeElement(this);
      }

   }
}
