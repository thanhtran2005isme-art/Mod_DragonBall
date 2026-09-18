package nro;

public final class nr_do implements IActionListener {
   int a;
   private int p;
   int b;
   private int q;
   CommandLine c;
   CommandLine d;
   private int r = 24;
   public int e = 0;
   private int s = 50;
   public static nr_ds f;
   public int g;
   public int h;
   public int i;
   public int j;
   public boolean k;
   public boolean l;
   public String m;
   private MyVector t = new MyVector("vItems");
   int n;
   int o;

   public final void a(boolean var1) {
      Char.myCharz();
      this.k = true;
      this.l = false;
      if (this.l) {
         this.b = 170;
         this.q = 118;
         this.a = main.GameCanvas.z / 2 - this.b / 2;
         this.p = main.GameCanvas.A / 2 - this.q / 2;
      } else {
         this.b = 170;
         this.q = 170;
         this.a = main.GameCanvas.z / 2 - this.b / 2;
         this.p = main.GameCanvas.A / 2 - this.q / 2;
         if (main.GameCanvas.A < 240) {
            this.p -= 10;
         }
      }

      this.h = this.a;
      this.g = 0;
      this.e = ClanImage.vClanImage.size();
      if (main.GameCanvas.isTouch) {
         this.c.x = this.a;
         this.c.y = this.p + this.q + 5;
         this.d.x = this.a + this.b - 68;
         this.d.y = this.p + this.q + 5;
      }

      (f = new nr_ds()).a(this.e, this.r, this.a, this.p + this.s, this.b, this.q - this.s, true, 1);
   }

   private void a() {
      this.g = this.a + this.b;
   }

   public nr_do() {
      this.c = new CommandLine(mResources.bv, this, 1, (Object)null);
      this.d = new CommandLine(mResources.CLOSE, this, 2, (Object)null);
   }

   public final void a(mGraphics var1) {
      var1.setColor(-this.h, 0);
      PopUp.paintPopUp(var1, this.a, this.p - 17, this.b, this.q + 17, -1, true);
      mFont.tahoma_7b_dark.drawStringBd(var1, mResources.dy, this.a + this.b / 2, this.p - 7, 2);
      ClanImage var2;
      if (this.o >= 0 && this.o <= ClanImage.vClanImage.size() - 1 && (var2 = (ClanImage) ClanImage.vClanImage.elementAt(this.o)).idImage != null) {
         Char.myCharz().a(var1, var2.idImage, main.GameCanvas.z / 2, this.p + 45, 1, false);
      }

      Char.myCharz().a(var1, main.GameCanvas.z / 2, this.p + 45, 1, Char.myCharz().as, false);
      var1.e(this.a, this.p + this.s, this.b, this.q - this.s - 10);
      if (f != null) {
         var1.setColor(0, -f.d);
      }

      for(int var7 = 0; var7 < this.e; ++var7) {
         int var3 = this.a + 10;
         int var4;
         if ((var4 = this.p + var7 * this.r + this.s) + this.r - (f != null ? f.d : 0) >= this.p + this.s && var4 - (f != null ? f.d : 0) <= this.p + this.s + this.q) {
            ClanImage var5 = (ClanImage) ClanImage.vClanImage.elementAt(var7);
            mFont var6 = mFont.o;
            if (var7 == this.o) {
               var6 = mFont.q;
            }

            if (var5.name != null) {
               var6.drawStringBd(var1, var5.name, var3 + 20, var4, 0);
            }

            if (var5.xu > 0) {
               var6.drawStringBd(var1, var5.xu + " " + mResources.bC, var3 + this.b - 20, var4, 1);
            } else if (var5.luong > 0) {
               var6.drawStringBd(var1, var5.luong + " " + mResources.bD, var3 + this.b - 20, var4, 1);
            }

            if (var5.idImage != null) {
               SmallImage.b(var1, var5.idImage[0], var3, var4, 0, 0);
            }
         }
      }

      var1.setColor(0, -var1.b());
      var1.e(0, 0, main.GameCanvas.z, main.GameCanvas.A);
      Paint.paintCmdBar(var1, this.c, (CommandLine)null, this.d);
   }

   public final void perform(int var1, Object var2) {
      if (var1 == 2) {
         this.a();
      }

      if (var1 == 1 && !this.l && this.o >= 0) {
         this.a();
         if (Char.myCharz().clan == null) {
            Service.gI().a((byte)2, (byte)((byte)((ClanImage) ClanImage.vClanImage.elementAt(this.o)).ID), (String)this.m);
            return;
         }

         Service.gI().a((byte)4, (byte)((byte)((ClanImage) ClanImage.vClanImage.elementAt(this.o)).ID), (String)"");
      }

   }
}
