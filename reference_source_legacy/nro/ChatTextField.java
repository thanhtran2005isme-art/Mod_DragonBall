package nro;

public final class ChatTextField implements IActionListener {
   private static ChatTextField i;
   public TField a;
   public boolean b = false;
   public IChatable c;
   private long j = 0L;
   public CommandLine d;
   public CommandLine e;
   public CommandLine f = null;
   private int k;
   private int l;
   private int m;
   private int n;
   public String g;
   public String h;

   public final void a() {
      this.d = new CommandLine(mResources.OK, this, 8000, (Object)null, 1, main.GameCanvas.A - mScreen.ce + 1);
      this.e = new CommandLine(mResources.bj, this, 8001, (Object)null, main.GameCanvas.z - 70, main.GameCanvas.A - mScreen.ce + 1);
      this.f = null;
      this.m = this.a.width + 28;
      this.n = this.a.height + 26;
      this.k = main.GameCanvas.z / 2 - this.m / 2;
      this.l = this.a.b - 18;
      if (this.m > 320) {
         this.m = 320;
      }

      this.d.x = this.k;
      this.e.x = this.k + this.m - 68;
      if (main.GameCanvas.isTouch) {
         TField var10000 = this.a;
         var10000.b -= 5;
         this.l -= 20;
         this.n += 30;
         this.d.x = main.GameCanvas.z / 2 - 68 - 5;
         this.e.x = main.GameCanvas.z / 2 + 5;
         this.d.y = main.GameCanvas.A - 30;
         this.e.y = main.GameCanvas.A - 30;
      }

   }

   public final void a(int var1) {
      if (this.b) {
         this.a.keyPress(var1);
      }

      if (this.a.getText().equals("")) {
         this.e.caption = mResources.CLOSE;
      } else {
         this.e.caption = mResources.bj;
      }
   }

   public static ChatTextField gI() {
      return i == null ? (i = new ChatTextField()) : i;
   }

   public ChatTextField() {
      this.h = mResources.bp + " ";
      this.a = new TField();
      this.a.name = mResources.bp;
      this.a.width = main.GameCanvas.z - 32;
      if (this.a.width > 250) {
         this.a.width = 250;
      }

      this.a.height = mScreen.ITEM_HEIGHT + 2;
      this.a.a = main.GameCanvas.z / 2 - this.a.width / 2;
      this.a.isFocus = true;
      this.a.b(80);
   }

   public final void a(int var1, IChatable var2, String var3) {
      this.e.caption = mResources.CLOSE;
      this.g = var3;
      this.a.keyPress(var1);
      if (!this.a.getText().equals("") && main.GameCanvas.currentDialog == null) {
         this.c = var2;
         this.b = true;
      }

   }

   public final void a(String var1) {
      this.e.caption = mResources.CLOSE;
      this.g = var1;
      if (main.GameCanvas.currentDialog == null) {
         this.b = true;
         if (main.GameCanvas.isTouch) {
            this.a.a();
         }
      }

   }

   public final void c() {
      if (this.b) {
         if (mSystem.d != 5 && mSystem.d != 3) {
            this.a.update();
         }

         if (this.a.h) {
            this.a.h = false;
            this.c.onChatFromMe(this.a.getText(), this.g);
            this.a.setText("");
            this.e.caption = mResources.CLOSE;
         }

      }
   }

   public final void a(mGraphics var1) {
      if (this.b) {
         if (mSystem.d != 5 && mSystem.d != 3) {
            PopUp.paintPopUp(var1, this.k, this.l, this.m, this.n, -1, true);
            mFont.g.drawStringBd(var1, this.h + this.g, this.a.a, this.a.b - (main.GameCanvas.isTouch ? 17 : 12), 0);
            Paint.paintCmdBar(var1, this.d, this.f, this.e);
            this.a.paint(var1);
         }
      }
   }

   public final void perform(int var1, Object var2) {
      switch(var1) {
      case 8000:
         ResLog.c("perform chat 1");
         if (this.c != null) {
            long var3;
            if ((var3 = System.currentTimeMillis()) - this.j < 1000L) {
               return;
            }

            this.j = var3;
            this.c.onChatFromMe(this.a.getText(), this.g);
            this.a.setText("");
            this.e.caption = mResources.CLOSE;
            return;
         }
         break;
      case 8001:
         ResLog.c("perform chat 2");
         if (this.a.getText().equals("")) {
            this.b = false;
            this.c.onCancelChat();
         }

         this.a.b();
      case 8002:
      }

   }
}
