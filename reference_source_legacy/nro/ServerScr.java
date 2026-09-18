package nro;

public final class ServerScr extends mScreen implements IActionListener {
   private int a = 0;
   private MyVector b = new MyVector("");
   private CommandLine c;
   private int d;
   private int e;
   private int f;
   private int g;
   private int h;
   private CommandLine i;
   private CommandLine j;

   public final void switchToMe() {
      SoundMn.stopAll();
      super.switchToMe();
      this.i = new CommandLine("VIỆT NAM", this, 98, (Object)null);
      this.i.x = 0;
      this.i.y = 0;
      this.j = new CommandLine("GLOBAL", this, 97, (Object)null);
      this.j.x = 50;
      this.j.y = 0;
      this.b = new MyVector("");
      this.b.addElement(this.i);
      this.b.addElement(this.j);
      this.a();
   }

   public ServerScr() {
      if ((TileMap.bgID = (byte)((int)(System.currentTimeMillis() % 9L))) == 5 || TileMap.bgID == 6) {
         TileMap.bgID = 4;
      }

      GameScr.loadCamera(-1, (int)-1);
      GameScr.cmx = 100;
      GameScr.cmy = 200;
   }

   private void a() {
      this.a = ServerListScreen.ipSelect;
      this.f = 5;
      this.d = 76;
      this.e = mScreen.ce;
      this.g = 2;
      if (main.GameCanvas.z > 3 * (this.d + this.f)) {
         this.g = 3;
      }

      if (this.b.size() < 3) {
         this.g = 2;
      }

      this.h = this.b.size() / this.g + (this.b.size() % this.g == 0 ? 0 : 1);

      for(int var1 = 0; var1 < this.b.size(); ++var1) {
         CommandLine var2;
         if ((var2 = (CommandLine)this.b.elementAt(var1)) != null) {
            int var3 = main.GameCanvas.B - this.g * (this.d + this.f) / 2 + var1 % this.g * (this.d + this.f);
            int var4 = main.GameCanvas.hh - this.h * (this.e + this.f) / 2 + var1 / this.g * (this.e + this.f);
            var2.x = var3;
            var2.y = var4;
         }
      }

   }

   public final void update() {
      if (++GameScr.cmx > main.GameCanvas.z * 3 + 100) {
         GameScr.cmx = 100;
      }

      for(int var1 = 0; var1 < this.b.size(); ++var1) {
         CommandLine var2 = (CommandLine)this.b.elementAt(var1);
         if (!main.GameCanvas.isTouch) {
            if (var1 == this.a) {
               if (main.GameCanvas.v % 10 < 4) {
                  var2.m = true;
               } else {
                  var2.m = false;
               }

               this.c = new CommandLine(mResources.bv, this, var2.e, (Object)null);
               super.center = this.c;
            } else {
               var2.m = false;
            }
         } else if (var2 != null && var2.isPointerPressInside()) {
            var2.performAction();
         }
      }

   }

   public final void paint(mGraphics var1) {
      main.GameCanvas.paintBackground(var1);

      for(int var2 = 0; var2 < this.b.size(); ++var2) {
         if (this.b.elementAt(var2) != null) {
            ((CommandLine)this.b.elementAt(var2)).a(var1);
         }
      }

      super.paint(var1);
   }

   public final void updateKey() {
      super.updateKey();
      int var1 = this.a % this.g;
      int var2 = this.a / this.g;
      if (main.GameCanvas.keyPressed[4]) {
         if (var1 > 0) {
            --this.a;
         }

         main.GameCanvas.keyPressed[4] = false;
      } else if (main.GameCanvas.keyPressed[6]) {
         if (var1 < this.g - 1) {
            ++this.a;
         }

         main.GameCanvas.keyPressed[6] = false;
      } else if (main.GameCanvas.keyPressed[2]) {
         if (var2 > 0) {
            this.a -= this.g;
         }

         main.GameCanvas.keyPressed[2] = false;
      } else if (main.GameCanvas.keyPressed[8]) {
         System.out.println("-----------vo: " + this.a);
         if (var2 < this.h - 1) {
            this.a += this.g;
         }

         main.GameCanvas.keyPressed[8] = false;
      }

      if (this.a < 0) {
         this.a = 0;
      }

      if (this.a >= this.b.size()) {
         this.a = this.b.size() - 1;
      }

      if (main.GameCanvas.keyPressed[5]) {
         ((CommandLine)this.b.elementAt(var1)).performAction();
         main.GameCanvas.keyPressed[5] = false;
      }

      main.GameCanvas.clearKeyPressed();
   }

   public final void perform(int var1, Object var2) {
      ResLog.c("perform trong ServerScr:" + var1);
      switch(var1) {
      case 97:
         this.b.removeAllElements();

         for(var1 = 0; var1 < ServerListScreen.a.length; ++var1) {
            if (ServerListScreen.g[var1] != 0) {
               this.b.addElement(new CommandLine(ServerListScreen.a[var1], this, var1 + 100, (Object)null));
            }
         }

         this.a();
         return;
      case 98:
         this.b.removeAllElements();

         for(var1 = 0; var1 < ServerListScreen.a.length; ++var1) {
            if (ServerListScreen.g[var1] == 0) {
               this.b.addElement(new CommandLine(ServerListScreen.a[var1], this, var1 + 100, (Object)null));
            }
         }

         this.a();
         return;
      case 99:
         Session_ME2.Session_ME().c();
         ServerListScreen.ipSelect = this.a;
         main.GameCanvas.serverScreen.i();
         main.GameCanvas.serverScreen.switchToMe();
         return;
      default:
         Session_ME2.Session_ME().c();
         ServerListScreen.ipSelect = var1 - 100;
         main.GameCanvas.serverScreen.i();
         main.GameCanvas.serverScreen.switchToMe();
      }
   }
}
