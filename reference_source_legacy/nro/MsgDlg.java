package nro;

public final class MsgDlg extends Dialog {
   private String[] e;
   public boolean a;
   private int f;
   private int g = 35;
   private long h = -1L;

   public MsgDlg() {
      if (main.GameCanvas.z <= 176) {
         this.g = 10;
      }

      if (main.GameCanvas.z > 320) {
         this.g = 80;
      }

   }

   public final void b() {
      this.setInfo(mResources.aA, (CommandLine)null, (CommandLine)null, (CommandLine)null);
      main.GameCanvas.currentDialog = this;
      this.h = mSystem.currentTimeMillis() + 5000L;
   }

   public final void c() {
      main.GameCanvas.currentDialog = this;
      this.h = -1L;
   }

   public final void a(String var1) {
      this.e = mFont.t.getWidth(var1, main.GameCanvas.z - ((this.g << 1) + 20));
      this.f = 80;
      if (this.e.length >= 5) {
         this.f = this.e.length * mFont.t.getWidth() + 20;
      }

   }

   public final void setInfo(String var1, CommandLine var2, CommandLine var3, CommandLine var4) {
      this.e = mFont.t.getWidth(var1, main.GameCanvas.z - ((this.g << 1) + 20));
      super.b = var2;
      super.c = var3;
      super.d = var4;
      this.f = 80;
      if (this.e.length >= 5) {
         this.f = this.e.length * mFont.t.getWidth() + 20;
      }

      if (main.GameCanvas.isTouch) {
         if (var2 != null) {
            super.b.x = main.GameCanvas.z / 2 - 68 - 5;
            super.b.y = main.GameCanvas.A - 50;
         }

         if (var4 != null) {
            super.d.x = main.GameCanvas.z / 2 + 5;
            super.d.y = main.GameCanvas.A - 50;
         }

         if (var3 != null) {
            super.c.x = main.GameCanvas.z / 2 - 35;
            super.c.y = main.GameCanvas.A - 50;
         }
      }

      this.a = false;
      this.h = -1L;
   }

   public final void a(mGraphics var1) {
      var1.e(0, 0, main.GameCanvas.z, main.GameCanvas.A);
      if (!LoginScr.c) {
         int var2 = main.GameCanvas.A - this.f - 38;
         int var3 = main.GameCanvas.z - (this.g << 1);
         Paint.paintCmdBar(this.g, var2, var3, this.f, var1);
         var2 = var2 + (this.f - this.e.length * mFont.t.getWidth()) / 2 - 2;
         if (this.a) {
            var2 += 8;
            main.GameCanvas.a(main.GameCanvas.B, var2 - 12, var1);
         }

         var3 = 0;

         for(var2 = var2; var3 < this.e.length; var2 += mFont.t.getWidth()) {
            mFont.tahoma_7b_dark.drawStringBd(var1, this.e[var3], main.GameCanvas.B, var2, 2);
            ++var3;
         }

         super.a(var1);
      }
   }

   public final void a() {
      super.a();
      if (this.h != -1L && mSystem.currentTimeMillis() > this.h) {
         main.GameCanvas.endDlg();
      }

   }
}
