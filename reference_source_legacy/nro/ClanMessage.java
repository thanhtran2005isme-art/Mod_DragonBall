package nro;

public final class ClanMessage implements IActionListener {
   public int a;
   public int b;
   public int c;
   public String d;
   public long e;
   public String[] f;
   public byte g;
   public byte h;
   private int m;
   public int i;
   public int j;
   public String[] k;
   public static MyVector vMessage = new MyVector("v Message");

   public static void a(ClanMessage var0, int var1, boolean var2) {
      for(int var3 = 0; var3 < vMessage.size(); ++var3) {
         ClanMessage var4;
         if ((var4 = (ClanMessage) vMessage.elementAt(var3)).a == var0.a) {
            vMessage.removeElement(var4);
            if (!var2) {
               vMessage.insertElementAt(var0, var3);
               return;
            }

            vMessage.insertElementAt(var0, 0);
            return;
         }

         if (var4.j != 0 && var4.i == var4.j) {
            vMessage.removeElement(var4);
         }
      }

      if (var1 == -1) {
         vMessage.addElement(var0);
      } else {
         vMessage.insertElementAt(var0, 0);
      }

      if (vMessage.size() > 20) {
         vMessage.removeElementAt(vMessage.size() - 1);
      }

   }

   public final void a(mGraphics var1, int var2, int var3) {
      mFont var4 = mFont.tahoma_7b_dark;
      if (this.h == 0) {
         var4 = mFont.a;
      } else if (this.h == 1) {
         var4 = mFont.h;
      } else if (this.h == 2) {
         var4 = mFont.g;
      }

      if (this.b == 0) {
         var4.drawStringBd(var1, this.d, var2 + 3, var3 + 1, 0);
         if (this.g == 0) {
            mFont.o.drawStringBd(var1, this.f[0] + (this.f.length > 1 ? "..." : ""), var2 + 3, var3 + 11, 0);
         } else {
            mFont.p.drawStringBd(var1, this.f[0] + (this.f.length > 1 ? "..." : ""), var2 + 3, var3 + 11, 0);
         }

         mFont.o.drawStringBd(var1, Util.c(this.m) + " " + mResources.dI, var2 + main.GameCanvas.panel.af - 3, var3 + 1, 1);
      }

      if (this.b == 1) {
         var4.drawStringBd(var1, this.d + " (" + this.i + "/" + this.j + ")", var2 + 3, var3 + 1, 0);
         mFont.q.drawStringBd(var1, mResources.cW + " " + Util.c(this.m) + " " + mResources.dI, var2 + 3, var3 + 11, 0);
      }

      if (this.b == 2) {
         var4.drawStringBd(var1, this.d, var2 + 3, var3 + 1, 0);
         mFont.q.drawStringBd(var1, mResources.dz, var2 + 3, var3 + 11, 0);
      }

   }

   public final void perform(int var1, Object var2) {
   }

   public final void a() {
      if (this.e != 0L) {
         this.m = (int)(System.currentTimeMillis() / 1000L - this.e);
      }

   }
}
