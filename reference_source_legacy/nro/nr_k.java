package nro;

import javax.microedition.lcdui.Image;

public final class nr_k extends Npc implements IActionListener {
   private static Image di = mSystem.load("/mainImage/myTexture2dhatdau.png");
   public int a;
   public int b;
   public int c;
   public int d;
   public String e;
   public boolean f;
   public int[] g;
   public int[] h;
   private PopUp dj = new PopUp("", 0, 0);
   public boolean i;
   public static boolean j = true;
   public boolean k;
   public int l;
   public long m;
   public long n;
   private boolean dk;
   private int dl = 0;

   public nr_k(int var1, int var2, int var3, int var4, int var5, int var6) {
      super(var1, var2, var3, var4, var5, var6);
      this.dj.i = new CommandLine((String)null, this, 1, (Object)null);
      PopUp.a(this.dj);
   }

   public final void a(mGraphics var1) {
      if (this.a != 0) {
         SmallImage.b(var1, this.a, super.cx, super.cy, 0, StaticObj.c);
         if (Char.myCharz().aT != null && Char.myCharz().aT.equals(this)) {
            var1.setColor(Mob.R, 0, 0, 9, 6, 0, super.cx, super.cy - SmallImage.a[this.a][4] - 1, 33);
            if (this.e != null) {
               mFont.n.drawString(var1, this.e, super.cx, super.cy - SmallImage.a[this.a][4] - 20, 2, mFont.o);
            }
         } else if (this.e != null) {
            mFont.n.drawString(var1, this.e, super.cx, super.cy - SmallImage.a[this.a][4] - 17, 2, mFont.o);
         }

         try {
            for(int var2 = 0; var2 < this.b; ++var2) {
               var1.drawImage(di, super.cx + this.g[var2] - SmallImage.a[this.a][3] / 2, super.cy + this.h[var2] - SmallImage.a[this.a][4], 0);
            }
         } catch (Exception var3) {
         }

         if (super.indexEffTask >= 0 && super.effTask != null && super.cTypePk == 0) {
            SmallImage.b(var1, super.effTask.a[super.indexEffTask].c, super.cx + super.effTask.a[super.indexEffTask].a + SmallImage.a[this.a][3] / 2 + 5, super.cy - 15 + super.effTask.a[super.indexEffTask].b, 0, 3);
            if (main.GameCanvas.v % 2 == 0) {
               ++super.indexEffTask;
               if (super.indexEffTask >= super.effTask.a.length) {
                  super.indexEffTask = 0;
               }
            }
         }

      }
   }

   public final void a() {
      this.dj.j = j;
      this.n = System.currentTimeMillis();
      if (this.n - this.m >= 1000L) {
         --this.l;
         this.m = this.n;
         if (this.l < 0) {
            this.l = 0;
         }
      }

      if (!this.f) {
         if (this.b < this.d && this.l == 0) {
            this.dk = true;
         }
      } else if (this.l == 0) {
         this.f = false;
         this.dk = true;
      }

      if (this.dk) {
         ++this.dl;
         if (this.dl == 20) {
            this.dl = 0;
            this.dk = false;
            Service.gI().g((byte)2);
         }
      }

      if (this.i) {
         this.i = false;
         if ((this.l < 0 || this.b >= this.d) && (this.l < 0 || !this.f) && !this.k) {
            if (this.b == this.d && !this.f) {
               this.dj.a(new String[]{mResources.cI, this.b + "/" + this.d}, super.cx, super.cy - 20 - SmallImage.a[this.a][4]);
            }
         } else {
            this.dj.a(new String[]{!this.f ? this.b + "/" + this.d : mResources.cy, Util.b(this.l)}, super.cx, super.cy - 20 - SmallImage.a[this.a][4]);
         }
      }

      if (this.l >= 0 && this.b < this.d || this.l >= 0 && this.f) {
         this.dj.c[this.dj.c.length - 1] = Util.b(this.l);
      }

      if (this.k) {
         this.dj.j = false;
         ServerEffect.addServerEffect(98, super.cx + this.g[this.b - 1] - SmallImage.a[this.a][3] / 2, super.cy + this.h[this.b - 1] - SmallImage.a[this.a][4], 1);
         --this.b;
         if (main.GameCanvas.v % 2 == 0) {
            SoundMn.stopAll();
         }

         if (this.b == this.c) {
            this.dj.j = true;
            this.i = true;
            this.k = false;
         }
      }

      super.a();
   }

   public final void perform(int var1, Object var2) {
      if (var1 == 1) {
         Service.gI().e((byte)1);
      }

   }
}
