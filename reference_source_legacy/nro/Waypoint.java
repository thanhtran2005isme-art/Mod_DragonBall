package nro;

public final class Waypoint implements IActionListener {
   public short a;
   public short b;
   public short c;
   public short d;
   public boolean e;
   public boolean f;
   public PopUp g;

   public Waypoint(short var1, short var2, short var3, short var4, boolean var5, boolean var6, String var7) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
      var7 = ResLog.a(var7);
      this.e = var5;
      this.f = var6;
      if (TileMap.l != 21 && TileMap.l != 22 && TileMap.l != 23 || this.a < 0 || this.a > 24) {
         if ((TileMap.l != 0 || Char.myCharz().cgender == 0) && (TileMap.l != 7 || Char.myCharz().cgender == 1) && (TileMap.l != 14 || Char.myCharz().cgender == 2) || !var6) {
            if (!TileMap.f() && TileMap.l != 47) {
               if (!var5 && !var6) {
                  this.g = new PopUp(var7, var1, var2 - 24);
                  this.g.i = new CommandLine((String)null, this, 1, this);
                  this.g.h = true;
                  this.g.j = false;
                  PopUp.a(this.g);
               } else {
                  if (TileMap.b()) {
                     this.g = new PopUp(var7, var1, var2 - 16);
                  } else {
                     int var8 = var1 + (var3 - var1) / 2;
                     this.g = new PopUp(var7, var8, var2 - (var2 != 0 ? 16 : -32));
                  }

                  this.g.i = new CommandLine((String)null, this, 2, this);
                  this.g.h = true;
                  this.g.j = false;
                  PopUp.a(this.g);
               }

               TileMap.t.addElement(this);
            } else if (var2 <= 150 || !TileMap.f()) {
               this.g = new PopUp(var7, var1 + (var3 - var1) / 2, var4 - (var1 > 100 ? 24 : 48));
               this.g.i = new CommandLine((String)null, this, 1, this);
               this.g.h = true;
               this.g.j = false;
               PopUp.a(this.g);
               TileMap.t.addElement(this);
            }
         }
      }
   }

   public final void perform(int var1, Object var2) {
      switch(var1) {
      case 1:
         var1 = (this.a + this.c) / 2;
         int var4 = this.d;
         if (this.d > this.b + 24) {
            var4 = (this.b + this.d) / 2;
         }

         GameScr.gI().aW = 0;
         Char.myCharz().bP = new nr_dj(var1, var4);
         Char.myCharz().I = Char.myCharz().cx - Char.myCharz().bP.a > 0 ? -1 : 1;
         Service.gI().g();
         return;
      case 2:
         GameScr.gI().aW = 0;
         if (Char.myCharz().i() != null) {
            Service.gI().g();
            InfoDlg.a();
            Service.gI().q();
            Char.bG = true;
            return;
         } else if (Char.myCharz().j() != null) {
            Service.gI().g();
            Service.gI().f();
            Char.bH = true;
            Char.bG = true;
            main.GameCanvas.f();
            main.GameCanvas.clearKeyPressed();
            InfoDlg.a();
            return;
         } else {
            var1 = (this.a + this.c) / 2;
            short var3 = this.d;
            Char.myCharz().bP = new nr_dj(var1, var3);
            Char.myCharz().I = Char.myCharz().cx - Char.myCharz().bP.a > 0 ? -1 : 1;
            Char.myCharz().ay = new CommandLine((String)null, this, 2, (Object)null);
         }
      default:
      }
   }
}
