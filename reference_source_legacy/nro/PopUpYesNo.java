package nro;

public final class PopUpYesNo implements IActionListener {
   public CommandLine a;
   private CommandLine b;
   private String[] c;
   private int d;
   private int e;
   private int f = 120;
   private int g;
   private int h;
   private long i;
   private long j;

   public final void setPopUp(String var1, CommandLine var2, CommandLine var3) {
      this.c = new String[]{var1};
      this.g = 29;
      this.a = var2;
      this.b = var3;
      this.a.g = this.b.g = GameScr.bn;
      this.a.h = this.b.h = GameScr.bo;
      this.a.k = mGraphics.setColor(var2.g);
      this.b.k = mGraphics.setColor(var2.g);
      this.a.l = mGraphics.b(var2.g);
      this.b.l = mGraphics.b(var2.g);
      this.i = System.currentTimeMillis();
      this.h = this.c[0].length() / 3;
      if (this.h < 15) {
         this.h = 15;
      }

      TextInfo.reset();
   }

   public final void paint(mGraphics var1) {
      PopUp.paintPopUp(var1, this.d, this.e, this.f, this.g + (!main.GameCanvas.isTouch ? 10 : 0), 16777215, false);
      if (this.c != null) {
         TextInfo.a(var1, this.c[0], this.d + 5, this.e + this.g / 2 - (main.GameCanvas.isTouch ? 4 : 6), this.f - 10, this.g, mFont.k);
         if (main.GameCanvas.isTouch) {
            this.a.a(var1);
            mFont.n.drawString(var1, String.valueOf(this.h), this.a.x + this.a.k / 2, this.a.y + this.a.l + 5, 2, mFont.o);
            return;
         }

         if (TField.g) {
            mFont.b.drawStringBd(var1, mResources.cJ + this.h + ")", this.d + this.f / 2, this.e + this.g, 2);
            return;
         }

         mFont.b.drawStringBd(var1, mResources.cK + this.h + ")", this.d + this.f / 2, this.e + this.g, 2);
      }

   }

   public final void a() {
      if (this.c != null) {
         this.d = main.GameCanvas.z - 5 - this.f;
         this.e = 45;
         if (main.GameCanvas.z - 50 > 155 + this.f) {
            this.d = main.GameCanvas.z - 55 - this.f;
            this.e = 5;
         }

         this.a.x = this.d - 35;
         this.a.y = this.e;
         this.j = System.currentTimeMillis();
         ResLog.c("curr - last= " + (this.j - this.i));
         if (this.j - this.i >= 1000L) {
            this.i = System.currentTimeMillis();
            --this.h;
         }

         if (this.h == 0) {
            GameScr.gI().popUpYesNo = null;
         }
      }

   }

   public final void perform(int var1, Object var2) {
   }
}
