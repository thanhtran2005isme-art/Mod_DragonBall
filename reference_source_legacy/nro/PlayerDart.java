package nro;

public final class PlayerDart {
   private Char b;
   private DartInfo c;
   private MyVector d = new MyVector("vDARTS");
   private int e;
   private int f;
   private int g;
   private int h;
   private int i;
   private int j;
   private int k;
   private int l = 0;
   private int m = 0;
   private boolean n = false;
   private boolean o = true;
   public SkillPaint a;

   public PlayerDart(Char var1, int var2, SkillPaint var3, int var4, int var5) {
      this.a = var3;
      this.b = var1;
      this.c = GameScr.w[var2];
      this.h = this.c.i;
      this.i = var4;
      this.j = var5;
      IMapObject var6;
      if(var1.aQ == null) {
          var6 = var1.aU;
      }
      else {
          var6 = var1.aQ;
      }
      var2 = ResLog.a(((IMapObject)var6).getX() - var4, ((IMapObject)var6).getY() - var5);
      this.e = var2;
      this.f = this.h * ResLog.b(var2) >> 10;
      this.g = this.h * ResLog.a(var2) >> 10;
   }

   public final void a() {
      if (this.o) {
         if (this.b.aQ == null && this.b.aU == null) {
            this.b();
         } else {
            IMapObject var1;
            if(this.b.aQ == null) {
                var1 = this.b.aU;
            }
            else {
                var1 = this.b.aQ;
            }
            int var2;
            for(var2 = 0; var2 < this.c.h; ++var2) {
               if (this.c.c.length > 0) {
                  this.d.addElement(new nr_du(this.i, this.j));
               }

               int var3 = this.b.getX() > ((IMapObject)var1).getX() ? 10 : -10;
               this.l = ((IMapObject)var1).getX() + var3 - this.i;
               this.m = ((IMapObject)var1).getY() - ((IMapObject)var1).getH() / 2 - this.j;
               ++this.k;
               if (ResLog.g(this.l) < 20 && ResLog.g(this.m) < 20) {
                  if (this.b.aU != null && this.b.aU.me) {
                     this.b.aU.a(this.b.aU.ac, 0, this.b.aU.ae, this.b.aU.ad);
                  }

                  this.b();
                  return;
               }

               if (Math.abs((var3 = ResLog.a(this.l, this.m)) - this.e) < 90 || this.l * this.l + this.m * this.m > 4096) {
                  if (Math.abs(var3 - this.e) < 15) {
                     this.e = var3;
                  } else if ((var3 - this.e < 0 || var3 - this.e >= 180) && var3 - this.e >= -180) {
                     this.e = ResLog.c(this.e - 15);
                  } else {
                     this.e = ResLog.c(this.e + 15);
                  }
               }

               if (this.h < 8192) {
                  this.h += 1024;
               }

               this.f = this.h * ResLog.b(this.e) >> 10;
               this.g = this.h * ResLog.a(this.e) >> 10;
               this.l += this.f;
               var3 = this.l >> 10;
               this.i += var3;
               this.l &= 1023;
               this.m += this.g;
               var3 = this.m >> 10;
               this.j += var3;
               this.m &= 1023;
            }

            for(var2 = 0; var2 < this.d.size(); ++var2) {
               nr_du var4;
               ++(var4 = (nr_du)this.d.elementAt(var2)).a;
               if (var4.a >= this.c.c.length) {
                  this.d.removeElementAt(var2);
               }
            }

         }
      }
   }

   private void b() {
      ResLog.c("END ME!");
      if (!this.b.ch && this.i >= GameScr.cmx && this.i <= GameScr.cmx + main.GameCanvas.z) {
         SoundMn.stopAll();
      }

      this.b.E();
      if (this.b.ch) {
         this.b.ch = false;
         if (this.b.bJ && this.b.me && this.b.statusMe != 14 && this.b.statusMe != 5) {
            this.b.bJ = false;
         }

         GameScr.gI().b(this.i, this.j);
      }

      this.b.dart = null;
      this.b.isCreateDark = false;
      this.b.skillPaint = null;
      this.b.skillPaintRandomPaint = null;
   }

   public final void a(mGraphics var1) {
      if (this.o) {
         int var2 = MonsterDart.a(360 - this.e);
         byte var3 = MonsterDart.c[var2];
         var2 = MonsterDart.b[var2];

         int var4;
         for(var4 = this.d.size() / 2; var4 < this.d.size(); ++var4) {
            nr_du var5 = (nr_du)this.d.elementAt(var4);
            SmallImage.b(var1, this.c.d[var5.a], var5.b, var5.c, 0, 3);
         }

         var4 = main.GameCanvas.v % this.c.b.length;
         SmallImage.b(var1, this.c.b[var4][var3], this.i, this.j, var2, 3);

         nr_du var6;
         int var7;
         for(var7 = 0; var7 < this.d.size(); ++var7) {
            var6 = (nr_du)this.d.elementAt(var7);
            SmallImage.b(var1, this.c.c[var6.a], var6.b, var6.c, 0, 3);
         }

         SmallImage.b(var1, this.c.a[var4][var3], this.i, this.j, var2, 3);

         for(var7 = 0; var7 < this.d.size(); ++var7) {
            var6 = (nr_du)this.d.elementAt(var7);
            if (ResLog.g(MonsterDart.a.nextInt(100)) < this.c.g) {
               SmallImage.b(var1, main.GameCanvas.v % 2 == 0 ? this.c.e[var6.a] : this.c.f[var6.a], var6.b, var6.c, 0, 3);
            }
         }

         var1.setColor(16711680);
      }
   }
}
