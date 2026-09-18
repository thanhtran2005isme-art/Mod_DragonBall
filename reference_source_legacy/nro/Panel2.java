package nro;

public final class Panel2 extends mScreen implements IActionListener {
   private CommandLine[] b;
   public static nr_bf[] a;
   private int c;
   private int[] d;
   private int e;
   private int[] f;
   private int[] g;
   private int h;
   private int i;

   public final void switchToMe() {
      ServerListScreen.f = false;
      Char.isLoadingMap = false;
      LoginScr.c = false;
      ServerListScreen.l = false;
      GameScr.gI().a();
      super.switchToMe();
   }

   public Panel2() {
      this.d = new int[]{main.GameCanvas.z / 2 - 100, main.GameCanvas.z / 2 - 100};
      this.e = 0;
      this.f = new int[2];
      this.g = new int[]{main.GameCanvas.z / 2 - 150, main.GameCanvas.A / 2 - 100, 300, 200};
      this.h = -35;
      this.i = -35;
   }

   public final void update() {
      if (main.GameCanvas.v % 10 > 2) {
         this.c = 1;
      } else {
         this.c = 0;
      }

      int var1;
      for(var1 = 0; var1 < this.b.length; ++var1) {
         if (this.b[var1].isPointerPressInside()) {
            this.b[var1].performAction();
         }
      }

      for(var1 = 0; var1 < this.d.length; ++var1) {
         if (main.GameCanvas.isPointerHoldIn(this.d[var1] + this.i, this.f[var1] + this.h, this.g[2], 60) && main.GameCanvas.k) {
            this.e = var1;
            break;
         }
      }

      super.update();
   }

   public final void paint(mGraphics var1) {
      main.GameCanvas.paintBackground(var1);

      try {
         PopUp.paintPopUp(var1, this.g[0] - 10, this.g[1], this.g[2] + 20, this.g[3], 16777215, true);
         int var2;
         if (this.b != null) {
            for(var2 = 0; var2 < this.b.length; ++var2) {
               this.b[var2].a(var1);
            }
         }

         if (a != null) {
            for(var2 = 0; var2 < a.length; ++var2) {
               PopUp.paintPopUp(var1, this.d[var2] - 20, this.f[var2] + this.h, this.g[2], 60, 16777215, false);
               Rms var3 = GameScr.x[a[var2].c];
               Rms var4 = GameScr.x[a[var2].e];
               Rms var5 = GameScr.x[a[var2].d];
               SmallImage.b(var1, var3.a[Char.bC[this.c][0][0]].a, this.d[var2] + Char.bC[this.c][0][1] + var3.a[Char.bC[this.c][0][0]].b, this.f[var2] - Char.bC[this.c][0][2] + var3.a[Char.bC[this.c][0][0]].c, 0, 0);
               SmallImage.b(var1, var4.a[Char.bC[this.c][1][0]].a, this.d[var2] + Char.bC[this.c][1][1] + var4.a[Char.bC[this.c][1][0]].b, this.f[var2] - Char.bC[this.c][1][2] + var4.a[Char.bC[this.c][1][0]].c, 0, 0);
               SmallImage.b(var1, var5.a[Char.bC[this.c][2][0]].a, this.d[var2] + Char.bC[this.c][2][1] + var5.a[Char.bC[this.c][2][0]].b, this.f[var2] - Char.bC[this.c][2][2] + var5.a[Char.bC[this.c][2][0]].c, 0, 0);
               if (this.e == var2) {
                  mFont.d.drawStringBd(var1, a[var2].b, this.d[var2] + this.g[2] - 25, this.f[var2] + this.h, 1);
                  mFont.d.drawStringBd(var1, mResources.dd + " " + ResLog.b(a[var2].f), this.d[var2] + this.g[2] - 25, this.f[var2] + this.h + mFont.d.getWidth(), 1);
               } else {
                  mFont.tahoma_7b_dark.drawStringBd(var1, a[var2].b, this.d[var2] + this.g[2] - 25, this.f[var2] + this.h, 1);
                  mFont.tahoma_7b_dark.drawStringBd(var1, mResources.dd + " " + ResLog.b(a[var2].f), this.d[var2] + this.g[2] - 25, this.f[var2] + this.h + mFont.tahoma_7b_dark.getWidth(), 1);
               }
            }
         }
      } catch (Exception var6) {
      }

      super.paint(var1);
   }

   public final void a(byte var1) {
      this.d = new int[var1];
      this.f = new int[var1];

      for(int var2 = 0; var2 < var1; ++var2) {
         this.d[var2] = this.g[0] + 20;
         this.f[var2] = var2 * 70 + this.g[1] + 50;
      }

      this.b = new CommandLine[2];
      this.b[1] = new CommandLine("Vào game", this, 1, (Object)null, this.g[0] + this.g[2] - 80 - 80, this.g[1] + this.g[3] - 30);
      this.b[0] = new CommandLine("Trờ ra", this, 2, (Object)null, this.g[0] + this.g[2] - 80, this.g[1] + this.g[3] - 30);
   }

   public final void perform(int var1, Object var2) {
      switch(var1) {
      case 1:
         if (this.e != -1) {
            main.GameCanvas.startWaitDlg();
            Service.gI().t(a[this.e].a);
            return;
         }
         break;
      case 2:
         main.GameCanvas.doResetToLoginScr((mScreen)main.GameCanvas.serverScreen);
      }

   }
}
