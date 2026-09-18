package nro;

import main.GameMidlet;

public final class MoneyCharge extends mScreen implements IActionListener {
   public static MoneyCharge a;
   private TField b;
   private TField c;
   private int d;
   private int e;
   private int f;
   private int g;
   private String[] h;
   private int i;

   public MoneyCharge() {
      this.f = main.GameCanvas.z - 20;
      if (this.f > 320) {
         this.f = 320;
      }

      this.h = mFont.g.getWidth(mResources.bb, this.f - 20);
      this.d = (main.GameCanvas.z - this.f) / 2;
      this.e = main.GameCanvas.A - 150 - (this.h.length - 1) * 20;
      this.g = 110 + (this.h.length - 1) * 20;
      this.b = new TField();
      this.b.name = mResources.aZ;
      this.b.a = this.d + 10;
      this.b.b = this.e + 35 + (this.h.length - 1) * 20;
      this.b.width = this.f - 20;
      this.b.height = mScreen.ITEM_HEIGHT + 2;
      if (main.GameCanvas.isTouch) {
         this.b.isFocus = false;
      } else {
         this.b.isFocus = true;
      }

      this.b.setIputType(0);
      if (!main.GameCanvas.isTouch) {
         super.cb = this.b.j;
      }

      this.c = new TField();
      this.c.name = mResources.ba;
      this.c.a = this.d + 10;
      this.c.b = this.b.b + 35;
      this.c.width = this.f - 20;
      this.c.height = mScreen.ITEM_HEIGHT + 2;
      this.c.isFocus = false;
      this.c.setIputType(0);
      super.left = new CommandLine(mResources.CLOSE, this, 1, (Object)null);
      super.center = new CommandLine(mResources.bc, this, 2, (Object)null);
      if (main.GameCanvas.isTouch) {
         super.center.x = main.GameCanvas.z / 2 + 18;
         super.left.x = main.GameCanvas.z / 2 - 85;
         super.center.y = super.left.y = this.e + this.g + 5;
      }

   }

   public static MoneyCharge gI() {
      if (a == null) {
         a = new MoneyCharge();
      }

      return a;
   }

   public final void switchToMe() {
      this.i = 0;

      try {
         if (mResources.language == 0) {
            GameMidlet.instance.platformRequest("http://ngocrongonline.com/");
         }

         if (mResources.language == 2) {
            GameMidlet.instance.platformRequest("http://dragonball.indonaga.com/");
         }

         if (mResources.language == 1) {
            GameMidlet.instance.platformRequest("http://world.teamobi.com/games-page-0.html");
            return;
         }
      } catch (Exception var2) {
         var2.printStackTrace();
      }

   }

   public final void paint(mGraphics var1) {
      GameScr.gI().paint(var1);
      PopUp.paintPopUp(var1, this.d, this.e, this.f, this.g, -1, true);

      for(int var2 = 0; var2 < this.h.length; ++var2) {
         mFont.g.drawStringBd(var1, this.h[var2], main.GameCanvas.z / 2, this.e + 15 + var2 * 20, 2);
      }

      this.b.paint(var1);
      this.c.paint(var1);
      super.paint(var1);
   }

   public final void update() {
      GameScr.gI().update();
      this.b.update();
      this.c.update();
   }

   public final void keyPress(int var1) {
      if (this.b.isFocus) {
         this.b.keyPress(var1);
      } else if (this.c.isFocus) {
         this.c.keyPress(var1);
      }

      super.keyPress(var1);
   }

   public final void updateKey() {
      if (main.GameCanvas.keyPressed[2]) {
         --this.i;
         if (this.i < 0) {
            this.i = 1;
         }
      } else if (main.GameCanvas.keyPressed[8]) {
         ++this.i;
         if (this.i > 1) {
            this.i = 1;
         }
      }

      if (main.GameCanvas.keyPressed[2] || main.GameCanvas.keyPressed[8]) {
         main.GameCanvas.clearKeyPressed();
         if (this.i == 1) {
            this.b.isFocus = false;
            this.c.isFocus = true;
            if (!main.GameCanvas.isTouch) {
               super.cb = this.c.j;
            }
         } else if (this.i == 0) {
            this.b.isFocus = true;
            this.c.isFocus = false;
            if (!main.GameCanvas.isTouch) {
               super.cb = this.b.j;
            }
         } else {
            this.b.isFocus = false;
            this.c.isFocus = false;
         }
      }

      if (main.GameCanvas.m) {
         if (main.GameCanvas.isPointerHoldIn(this.b.a, this.b.b, this.b.width, this.b.height)) {
            this.i = 0;
         } else if (main.GameCanvas.isPointerHoldIn(this.c.a, this.c.b, this.c.width, this.c.height)) {
            this.i = 1;
         }
      }

      super.updateKey();
      main.GameCanvas.clearKeyPressed();
   }

   public final void perform(int var1, Object var2) {
      if (var1 == 1) {
         GameScr.c.switchToMe();
         a = null;
      }

      if (var1 == 2) {
         if (this.b.getText() == null || this.b.getText().equals("")) {
            main.GameCanvas.startOKDlg(mResources.bd);
            return;
         }

         if (this.c.getText() == null || this.c.getText().equals("")) {
            main.GameCanvas.startOKDlg(mResources.be);
            return;
         }

         Service.gI().a(this.b.getText(), this.c.getText());
         GameScr.c.switchToMe();
         a = null;
      }

   }
}
