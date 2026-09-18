package nro;

public abstract class Dialog {
   public CommandLine b;
   public CommandLine c;
   public CommandLine d;

   public void a(mGraphics var1) {
      var1.setColor(-var1.setColor(), -var1.b());
      var1.e(0, 0, main.GameCanvas.z, main.GameCanvas.A);
      Paint.paintCmdBar(var1, this.b, this.c, this.d);
   }

   public void a(int var1) {
      switch(var1) {
      case -39:
      case -2:
         main.GameCanvas.j[8] = true;
         main.GameCanvas.keyPressed[8] = true;
         return;
      case -38:
      case -1:
         main.GameCanvas.j[2] = true;
         main.GameCanvas.keyPressed[2] = true;
         return;
      case -27:
         return;
      case -22:
      case -7:
         main.GameCanvas.j[13] = true;
         main.GameCanvas.keyPressed[13] = true;
         return;
      case -21:
      case -6:
         main.GameCanvas.j[12] = true;
         main.GameCanvas.keyPressed[12] = true;
         return;
      case -5:
      case 10:
         main.GameCanvas.j[5] = true;
         main.GameCanvas.keyPressed[5] = true;
         return;
      default:
      }
   }

   public void a() {
      if (this.c != null && (main.GameCanvas.keyPressed[5] || mScreen.a(this.c))) {
         main.GameCanvas.keyPressed[5] = false;
         main.GameCanvas.l = false;
         mScreen.cf = -1;
         main.GameCanvas.m = false;
         if (this.c != null) {
            this.c.performAction();
         }

         mScreen.cf = -1;
      }

      if (this.b != null && (main.GameCanvas.keyPressed[12] || mScreen.a(this.b))) {
         main.GameCanvas.keyPressed[12] = false;
         main.GameCanvas.l = false;
         mScreen.cf = -1;
         main.GameCanvas.m = false;
         if (this.b != null) {
            this.b.performAction();
         }

         mScreen.cf = -1;
      }

      if (this.d != null && (main.GameCanvas.keyPressed[13] || mScreen.a(this.d))) {
         main.GameCanvas.keyPressed[13] = false;
         main.GameCanvas.l = false;
         main.GameCanvas.m = false;
         mScreen.cf = -1;
         if (this.d != null) {
            this.d.performAction();
         }

         mScreen.cf = -1;
      }

      main.GameCanvas.clearKeyPressed();
      main.GameCanvas.f();
   }
}
