package nro;

import javax.microedition.lcdui.Image;

public final class TransportScr extends mScreen implements IActionListener {
   private static TransportScr f;
   private static Image g = mSystem.load("/mainImage/myTexture2dfutherShip.png");
   private static Image h = mSystem.load("/mainImage/taungam.png");
   public byte a;
   private int i = 5;
   private int[] j;
   private int[] k;
   private int[] l;
   private int[] m;
   private int n;
   private int o = 20;
   public short b;
   public short c;
   public long d;
   public long e;
   private boolean p;
   private boolean q;
   private int r;

   public TransportScr() {
      this.j = new int[this.o];
      this.k = new int[this.o];

      int var1;
      for(var1 = 0; var1 < this.o; ++var1) {
         this.j[var1] = ResLog.random(0, main.GameCanvas.z);
         this.k[var1] = var1 * (main.GameCanvas.A / this.o);
      }

      this.l = new int[this.o];
      this.m = new int[this.o];

      for(var1 = 0; var1 < this.o; ++var1) {
         this.l[var1] = ResLog.random(0, main.GameCanvas.z);
         this.m[var1] = var1 * (main.GameCanvas.A / this.o);
      }

   }

   public static TransportScr gI() {
      if (f == null) {
         f = new TransportScr();
      }

      return f;
   }

   public final void switchToMe() {
      this.p = false;
      this.q = false;
      if (Char.myCharz().Y() > 0 && this.a == 0) {
         super.center = new CommandLine(mResources.fX, this, 1, (Object)null);
      } else {
         super.center = null;
      }

      this.r = 0;
      super.switchToMe();
   }

   public final void paint(mGraphics var1) {
      var1.setColor(this.a == 0 ? 0 : 3056895);
      var1.fillRect(0, 0, main.GameCanvas.z, main.GameCanvas.A);

      int var2;
      for(var2 = 0; var2 < this.o; ++var2) {
         var1.setColor(this.a == 0 ? 14802654 : 11140863);
         var1.fillRect(this.j[var2], this.k[var2], 10, 2);
      }

      if (this.a == 0) {
         var1.setColor(g, 0, 0, 72, 95, 7, this.n + this.r, main.GameCanvas.A / 2, 3);
      }

      if (this.a == 1) {
         var1.setColor(h, 0, 0, 144, 79, 2, this.n + this.r, main.GameCanvas.A / 2, 3);
      }

      for(var2 = 0; var2 < this.o; ++var2) {
         var1.setColor(this.a == 0 ? 14935011 : 7536127);
         var1.fillRect(this.l[var2], this.m[var2], 18, 3);
      }

      super.paint(var1);
   }

   public final void update() {
      if (this.a == 0) {
         if (!this.p) {
            this.r = main.GameCanvas.z / 2 * this.b / this.c;
         }
      } else {
         this.r += 2;
      }

      Controller.b = false;
      this.n = (((main.GameCanvas.z / 2 + this.n) / 2 + this.n) / 2 + this.n) / 2;
      if (this.a == 1) {
         this.n = 0;
      }

      int[] var10000;
      int var1;
      for(var1 = 0; var1 < this.o; ++var1) {
         var10000 = this.j;
         var10000[var1] -= this.i / 2;
         if (this.j[var1] < -20) {
            this.j[var1] = main.GameCanvas.z;
         }
      }

      for(var1 = 0; var1 < this.o; ++var1) {
         var10000 = this.l;
         var10000[var1] -= this.i;
         if (this.l[var1] < -20) {
            this.l[var1] = main.GameCanvas.z;
         }
      }

      if (main.GameCanvas.v % 3 == 0) {
         this.i += this.p ? 2 : 1;
      }

      if (this.i > (this.p ? 80 : 25)) {
         this.i = this.p ? 80 : 25;
      }

      this.e = System.currentTimeMillis();
      if (this.e - this.d >= 1000L) {
         ++this.b;
         this.d = this.e;
      }

      if (this.p) {
         this.r += 3;
      }

      if (this.r >= main.GameCanvas.z / 2 + 30 && !this.q) {
         this.q = true;
         Service.gI().u();
      }

      super.update();
   }

   public final void updateKey() {
      super.updateKey();
   }

   public final void perform(int var1, Object var2) {
      if (var1 == 1) {
         main.GameCanvas.startYesNoDlg(mResources.fY, new CommandLine(mResources.bm, this, 2, (Object)null), new CommandLine(mResources.bn, this, 3, (Object)null));
      }

      if (var1 == 2 && Char.myCharz().Y() > 0) {
         this.p = true;
         main.GameCanvas.endDlg();
         super.center = null;
      }

      if (var1 == 3) {
         main.GameCanvas.endDlg();
      }

   }
}
