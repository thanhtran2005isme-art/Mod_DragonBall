package nro;

public final class InputDlg extends Dialog {
   private String[] e;
   public TField a;
   private int f = 40;

   public InputDlg() {
      if (main.GameCanvas.z <= 176) {
         this.f = 10;
      }

      this.a = new TField();
      this.a.a = this.f + 10;
      this.a.b = main.GameCanvas.A - mScreen.ITEM_HEIGHT - 43;
      this.a.width = main.GameCanvas.z - 2 * (this.f + 10);
      this.a.height = mScreen.ITEM_HEIGHT + 2;
      this.a.isFocus = true;
      super.d = this.a.j;
   }

   public final void a(String var1, CommandLine var2, int var3) {
      this.a.setText("");
      this.a.setIputType(var3);
      this.e = mFont.t.getWidth(var1, main.GameCanvas.z - (this.f << 1));
      super.b = new CommandLine(mResources.CLOSE, main.GameCanvas.a(), 8882, (Object)null);
      super.c = var2;
      main.GameCanvas.currentDialog = this;
   }

   public final void a(mGraphics var1) {
      main.GameCanvas.M.paintCmdBar(var1, this.f, main.GameCanvas.A - 77 - mScreen.ce, main.GameCanvas.z - (this.f << 1), 69, this.e);
      this.a.paint(var1);
      super.a(var1);
   }

   public final void a(int var1) {
      this.a.keyPress(var1);
      super.a(var1);
   }

   public final void a() {
      this.a.update();
      super.a();
   }
}
