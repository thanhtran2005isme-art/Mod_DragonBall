package nro;

import javax.microedition.lcdui.Image;

public final class CommandLine {
   public boolean a = false;
   public String caption;
   public String[] c;
   public IActionListener d;
   public int e;
   public boolean isPlaySoundButton = true;
   public Image g;
   public Image h;
   public int x = 0;
   public int y = 0;
   public int k;
   public int l;
   private int q;
   public boolean m;
   public Object n;
   private int r;
   public String o;
   private static Image btnleft = mSystem.load("/mainImage/btn0left.png");
   private static Image btnmid = mSystem.load("/mainImage/btn0mid.png");
   private static Image btnrighnt = mSystem.load("/mainImage/btn0right.png");
   private static Image btnleft1 = mSystem.load("/mainImage/btn1left.png");
   private static Image btnmid1 = mSystem.load("/mainImage/btn1mid.png");
   private static Image btnrighnt1 = mSystem.load("/mainImage/btn1right.png");
   public boolean p;

   public CommandLine(String var1, IActionListener var2, int var3, Object var4, int var5, int var6) {
      this.k = mScreen.cd;
      this.l = mScreen.ce;
      this.m = false;
      this.o = "";
      this.caption = var1;
      this.e = var3;
      this.d = var2;
      this.n = null;
      this.x = var5;
      this.y = var6;
   }

   public CommandLine(String var1, IActionListener var2, int var3, Object var4) {
      this.k = mScreen.cd;
      this.l = mScreen.ce;
      this.m = false;
      this.o = "";
      this.caption = var1;
      this.e = var3;
      this.d = var2;
      this.n = var4;
   }

   public CommandLine(String var1, int var2, Object var3) {
      this.k = mScreen.cd;
      this.l = mScreen.ce;
      this.m = false;
      this.o = "";
      this.caption = var1;
      this.e = var2;
      this.n = var3;
   }

   public CommandLine(String var1, int var2) {
      this.k = mScreen.cd;
      this.l = mScreen.ce;
      this.m = false;
      this.o = "";
      this.caption = var1;
      this.e = var2;
   }

   public CommandLine(String var1, int var2, int var3, int var4) {
      this.k = mScreen.cd;
      this.l = mScreen.ce;
      this.m = false;
      this.o = "";
      this.caption = var1;
      this.e = 0;
      this.x = var3;
      this.y = var4;
   }

   public final void performAction() {
      main.GameCanvas.k();
      if (this.isPlaySoundButton && (this.caption != null && !this.caption.equals("") && !this.caption.equals(mResources.cD) || this.g != null)) {
         SoundMn.stopAll();
      }

      if (this.e > 0) {
         if (this.d != null) {
            this.d.perform(this.e, this.n);
            return;
         }

         GameScr.gI().a(this.e, this.n);
      }

   }

   public final void b() {
      this.r = 1;
      this.k = 160;
      this.q = 80;
   }

   public final void a(mGraphics var1) {
      if (this.g != null) {
         var1.drawImage(this.g, this.x, this.y, 0);
         if (this.m) {
            if (this.h == null) {
               if (this.p) {
                  var1.drawImage(ItemMap.myTexture2dflare, this.x + 8, this.y + 8, 3);
               } else {
                  var1.drawImage(ItemMap.myTexture2dflare, this.x - (this.g.equals(GameScr.as) ? 10 : 0), this.y, 0);
               }
            } else {
               var1.drawImage(this.h, this.x, this.y, 0);
            }
         }

         if (this.caption != "" && this.caption != null) {
            if (!this.m) {
               mFont.tahoma_7b_dark.drawStringBd(var1, this.caption, this.x + mGraphics.setColor(this.g) / 2, this.y + mGraphics.b(this.g) / 2 - 5, 2);
               return;
            }

            mFont.g.drawStringBd(var1, this.caption, this.x + mGraphics.setColor(this.g) / 2, this.y + mGraphics.b(this.g) / 2 - 5, 2);
         }

      } else {
         if (this.caption != "") {
            if (this.r == 1) {
               if (!this.m) {
                  a(btnleft, btnmid, btnrighnt, this.x, this.y, 160, var1);
               } else {
                  a(btnleft1, btnmid1, btnrighnt1, this.x, this.y, 160, var1);
               }
            } else if (!this.m) {
               a(btnleft, btnmid, btnrighnt, this.x, this.y, 76, var1);
            } else {
               a(btnleft1, btnmid1, btnrighnt1, this.x, this.y, 76, var1);
            }
         }

         int var2;
         if (this.r == 1) {
            var2 = this.x + this.q;
         } else {
            var2 = this.x + 38;
         }

         if (!this.m) {
            mFont.tahoma_7b_dark.drawStringBd(var1, this.caption, var2, this.y + 7, 2);
         } else {
            mFont.g.drawStringBd(var1, this.caption, var2, this.y + 7, 2);
         }
      }
   }

   private static void a(Image var0, Image var1, Image var2, int var3, int var4, int var5, mGraphics var6) {
      int var7;
      for(var7 = 10; var7 <= var5 - 20; var7 += 10) {
         var6.drawImage(var1, var3 + var7, var4, 0);
      }

      if ((var7 = var5 % 10) > 0) {
         var6.setColor(var1, 0, 0, var7, 24, 0, var3 + var5 - 10 - var7, var4, 0);
      }

      var6.drawImage(var0, var3, var4, 0);
      var6.drawImage(var2, var3 + var5 - 10, var4, 0);
   }

   public final boolean isPointerPressInside() {
      this.m = false;
      if (main.GameCanvas.isPointerHoldIn(this.x, this.y, this.k, this.l)) {
         if (main.GameCanvas.k) {
            this.m = true;
         }

         if (main.GameCanvas.m && main.GameCanvas.l) {
            return true;
         }
      }

      return false;
   }
}
