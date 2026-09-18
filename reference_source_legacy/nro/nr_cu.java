package nro;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.microedition.lcdui.Image;

public final class nr_cu extends mScreen implements IActionListener {
   public static nr_cu a;
   public static boolean b = false;
   private static TField c;
   private static int d;
   private static int e;
   private static int f;
   private static int[][] g = new int[][]{{64, 30, 31}, {9, 29, 32}, {6, 27, 28}};
   private static int[] h = new int[]{2, 13, 8};
   private static int[] i = new int[]{1, 12, 7};
   private int[] j = new int[]{0, 4, 8};
   private int k = 168;
   private int l = 350;
   private int m = 45;
   private int n;
   private int o;

   public static nr_cu a() {
      if (a == null) {
         a = new nr_cu();
      }

      return a;
   }

   private static void a(byte[] var0) throws IOException {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         InputStream var1 = FireWorkMn.a("/mymap/" + var0[var2]);
         DataInputStream var4 = new DataInputStream(var1);
         nr_di.a[var2] = (char)var4.read();
         nr_di.b[var2] = (char)var4.read();
         nr_di.e[var2] = new int[var4.available()];

         for(int var3 = 0; var3 < nr_di.a[var2] * nr_di.b[var2]; ++var3) {
            nr_di.e[var2][var3] = var4.read();
         }

         nr_di.f[var2] = new int[nr_di.e[var2].length];
      }

   }

   public final void switchToMe() {
      LoginScr.c = false;
      main.GameCanvas.menu.a = false;
      main.GameCanvas.endDlg();
      super.switchToMe();
      d = ResLog.random(0, 3);
      e = ResLog.random(0, 3);
      this.e();
      Char.isLoadingMap = false;
      if (c != null) {
         c.name = mResources.av;
      }

      ServerListScreen.k = 0;
   }

   private void e() {
      TileMap.f = new int[nr_di.e[d].length];

      for(int var1 = 0; var1 < nr_di.e[d].length; ++var1) {
         TileMap.f[var1] = nr_di.e[d][var1];
      }

      TileMap.g = nr_di.f[d];
      TileMap.d = nr_di.d[d];
      TileMap.c = nr_di.c[d];
      TileMap.e = nr_di.c[d];
      TileMap.a = nr_di.a[d];
      TileMap.b = nr_di.b[d];
      TileMap.e = this.j[d] + 1;
      TileMap.h();
      main.GameCanvas.a(this.j[d]);
      GameScr.loadCamera(this.k, this.l);
   }

   public nr_cu() {
      try {
         if (!main.GameCanvas.a) {
            byte[] var1 = new byte[]{39, 40, 41};
            if (!main.GameCanvas.a) {
               try {
                  for(int var3 = 0; var3 < var1.length; ++var3) {
                     InputStream var2 = FireWorkMn.a("/mymap/mapTable" + var1[var3]);
                     DataInputStream var14;
                     short var4 = (var14 = new DataInputStream(var2)).readShort();
                     nr_di.g[var3] = new MyVector("MapTemplate.vCurrItem[a] ");

                     for(int var5 = 0; var5 < var4; ++var5) {
                        short var6 = var14.readShort();
                        short var7 = var14.readShort();
                        short var8 = var14.readShort();
                        if (TileMap.a(var6) != null) {
                           nr_cx var9 = TileMap.a(var6);
                           nr_cx var10;
                           (var10 = new nr_cx()).a = var6;
                           var10.c = var9.c;
                           var10.f = var9.f;
                           var10.g = var9.g;
                           var10.d = var7 * TileMap.i;
                           var10.e = var8 * TileMap.i;
                           var10.h = var9.h;
                           nr_di.g[var3].addElement(var10);
                           if (!nr_cx.k.containsKey(String.valueOf(var10.c))) {
                              Image var15;
                              try {
                                 var15 = mSystem.load("/mapBackGround/" + var10.c + ".png");
                                 nr_cx.k.put(String.valueOf(var10.c), var15);
                              } catch (Exception var11) {
                                 if ((var15 = mSystem.loadImage("/mapBackGround/" + var10.c + ".png")) == null) {
                                    var15 = Image.createRGBImage(new int[]{-2013265920}, 1, 1, true);
                                    Service.gI().c(var10.c);
                                 }

                                 nr_cx.k.put(String.valueOf(var10.c), var15);
                              }

                              nr_cx.m.addElement(String.valueOf(var10.c));
                           }

                           if (!nr_cx.a(String.valueOf(var10.c))) {
                              nr_cx.l.addElement(String.valueOf(var10.c));
                           }
                        }
                     }
                  }
               } catch (Exception var12) {
                  var12.printStackTrace();
               }
            }
         }

         a(new byte[]{39, 40, 41});
      } catch (Exception var13) {
         var13.printStackTrace();
      }

      if (main.GameCanvas.z <= 200) {
         GameScr.d(128, 100);
         GameScr.bK = (main.GameCanvas.z - 128) / 2;
         GameScr.bJ = 10;
         this.l += 15;
         this.m -= 15;
      }

      d = 1;
      (c = new TField()).width = main.GameCanvas.loginScr.tfUser.width;
      if (main.GameCanvas.z < 200) {
         c.width = 60;
      }

      c.height = 26;
      if (main.GameCanvas.z < 200) {
         c.a = GameScr.bK + 45;
         c.b = GameScr.bJ + 12;
      } else {
         c.a = main.GameCanvas.z / 2 - c.width / 2;
         c.b = 35;
      }

      if (!main.GameCanvas.isTouch) {
         c.isFocus = true;
      }

      c.setIputType(0);
      c.name = mResources.av;
      if (c.getText().equals("@")) {
         c.setText(main.GameCanvas.loginScr.tfUser.getText().substring(0, main.GameCanvas.loginScr.tfUser.getText().indexOf("@")));
      }

      d = 1;
      e = 0;
      super.center = new CommandLine(mResources.by, this, 8000, (Object)null);
      super.left = new CommandLine(mResources.bz, this, 8001, (Object)null);
      if (!main.GameCanvas.isTouch) {
         super.cb = c.j;
      }

   }

   public final void keyPress(int var1) {
      c.keyPress(var1);
   }

   public final void update() {
      ++this.n;
      if (this.n > 30) {
         this.n = 0;
      }

      if (this.n % 15 < 5) {
         this.o = 0;
      } else {
         this.o = 1;
      }

      c.update();
      if (f != 0) {
         c.isFocus = false;
      }

   }

   public final void updateKey() {
      if (main.GameCanvas.keyPressed[2] && --f < 0) {
         f = mResources.aJ.length - 1;
      }

      if (main.GameCanvas.keyPressed[8] && ++f >= mResources.aJ.length) {
         f = 0;
      }

      if (f == 0) {
         if (!main.GameCanvas.isTouch) {
            super.cb = c.j;
         }

         c.update();
      }

      if (f == 1) {
         if (main.GameCanvas.keyPressed[4]) {
            if (--d < 0) {
               d = mResources.aK.length - 1;
            }

            this.e();
         }

         if (main.GameCanvas.keyPressed[6]) {
            if (++d > mResources.aK.length - 1) {
               d = 0;
            }

            this.e();
         }

         super.cb = null;
      }

      if (f == 2) {
         if (main.GameCanvas.keyPressed[4] && --e < 0) {
            e = mResources.fm[0].length - 1;
         }

         if (main.GameCanvas.keyPressed[6] && ++e > mResources.fm[0].length - 1) {
            e = 0;
         }

         super.cb = null;
      }

      if (main.GameCanvas.m) {
         byte var1 = 110;
         byte var2 = 60;
         if (main.GameCanvas.z > main.GameCanvas.A) {
            var1 = 100;
            var2 = 40;
         }

         if (main.GameCanvas.isPointerHoldIn(main.GameCanvas.z / 2 - 117, 15, 234, 80)) {
            f = 0;
            c.isFocus = true;
         }

         int var3;
         if (main.GameCanvas.isPointerHoldIn(main.GameCanvas.z / 2 - 117, var1 - 30, 234, var2 + 5)) {
            f = 1;
            var3 = d;
            if ((d = (main.GameCanvas.o - (main.GameCanvas.z / 2 - 117)) / 78) < 0) {
               d = 0;
            }

            if (d > mResources.aK.length - 1) {
               d = mResources.aK.length - 1;
            }

            if (var3 != d) {
               this.e();
            }
         }

         if (main.GameCanvas.isPointerHoldIn(main.GameCanvas.z / 2 - 117, var1 - 30 + var2 + 5, 234, 65)) {
            f = 2;
            var3 = e;
            if ((e = (main.GameCanvas.o - (main.GameCanvas.z / 2 - 117)) / 78) < 0) {
               e = 0;
            }

            if (e > mResources.fm[0].length - 1) {
               e = mResources.fm[0].length - 1;
            }

            if (var3 != f) {
               this.e();
            }
         }
      }

      super.updateKey();
      main.GameCanvas.f();
      main.GameCanvas.clearKeyPressed();
   }

   public final void paint(mGraphics var1) {
      if (!Char.isLoadingMap) {
         main.GameCanvas.paintBackground(var1);
         var1.setColor(-GameScr.cmx, -GameScr.cmy);
         int var2;
         if (!main.GameCanvas.a) {
            for(var2 = 0; var2 < nr_di.g[d].size(); ++var2) {
               nr_cx var3;
               if ((var3 = (nr_cx)nr_di.g[d].elementAt(var2)).c != -1 && var3.h == 1) {
                  var3.a(var1);
               }
            }
         }

         if (mSystem.d == 5) {
            main.GameCanvas.b(var1);
         } else {
            TileMap.a(var1);
         }

         byte var8 = 30;
         if (main.GameCanvas.z == 128) {
            var8 = 20;
         }

         int var9 = g[d][e];
         int var4 = h[d];
         int var5 = i[d];
         var1.drawImage(TileMap.x, this.k, this.l + this.m, 3);
         Rms var10 = GameScr.x[var9];
         Rms var11 = GameScr.x[var4];
         Rms var12 = GameScr.x[var5];
         SmallImage.b(var1, var10.a[Char.bC[this.o][0][0]].a, this.k + Char.bC[this.o][0][1] + var10.a[Char.bC[this.o][0][0]].b, this.l - Char.bC[this.o][0][2] + var10.a[Char.bC[this.o][0][0]].c + this.m, 0, 0);
         SmallImage.b(var1, var11.a[Char.bC[this.o][1][0]].a, this.k + Char.bC[this.o][1][1] + var11.a[Char.bC[this.o][1][0]].b, this.l - Char.bC[this.o][1][2] + var11.a[Char.bC[this.o][1][0]].c + this.m, 0, 0);
         SmallImage.b(var1, var12.a[Char.bC[this.o][2][0]].a, this.k + Char.bC[this.o][2][1] + var12.a[Char.bC[this.o][2][0]].b, this.l - Char.bC[this.o][2][2] + var12.a[Char.bC[this.o][2][0]].c + this.m, 0, 0);
         int var6;
         if (!main.GameCanvas.a) {
            for(var6 = 0; var6 < nr_di.g[d].size(); ++var6) {
               nr_cx var7;
               if ((var7 = (nr_cx)nr_di.g[d].elementAt(var6)).c != -1 && var7.h == 3) {
                  var7.a(var1);
               }
            }
         }

         var1.setColor(-var1.setColor(), -var1.b());
         if (main.GameCanvas.z < 200) {
            Paint.paintFrame(GameScr.bK, GameScr.bJ, GameScr.bL, GameScr.bM, var1);
            SmallImage.b(var1, var10.a[Char.bC[0][0][0]].a, main.GameCanvas.z / 2 + Char.bC[0][0][1] + var10.a[Char.bC[0][0][0]].b, GameScr.bJ + 30 + var8 * 3 - Char.bC[0][0][2] + var10.a[Char.bC[0][0][0]].c + this.m, 0, 0);
            SmallImage.b(var1, var11.a[Char.bC[0][1][0]].a, main.GameCanvas.z / 2 + Char.bC[0][1][1] + var11.a[Char.bC[0][1][0]].b, GameScr.bJ + 30 + var8 * 3 - Char.bC[0][1][2] + var11.a[Char.bC[0][1][0]].c + this.m, 0, 0);
            SmallImage.b(var1, var12.a[Char.bC[0][2][0]].a, main.GameCanvas.z / 2 + Char.bC[0][2][1] + var12.a[Char.bC[0][2][0]].b, GameScr.bJ + 30 + var8 * 3 - Char.bC[0][2][2] + var12.a[Char.bC[0][2][0]].c + this.m, 0, 0);

            for(var6 = 0; var6 < mResources.aJ.length; ++var6) {
               if (f == var6) {
                  var1.setColor(GameScr.bv, 0, 0, 13, 16, 2, GameScr.bK + 10 + (main.GameCanvas.v % 7 > 3 ? 1 : 0), GameScr.bJ + 35 + var6 * var8, StaticObj.f);
                  var1.setColor(GameScr.bv, 0, 0, 13, 16, 0, GameScr.bK + GameScr.bL - 10 - (main.GameCanvas.v % 7 > 3 ? 1 : 0), GameScr.bJ + 35 + var6 * var8, StaticObj.f);
               }

               mFont.tahoma_7b_dark.drawStringBd(var1, mResources.aJ[var6], GameScr.bK + 20, GameScr.bJ + 30 + var6 * var8, 0);
            }

            mFont.tahoma_7b_dark.drawStringBd(var1, mResources.aK[d], GameScr.bK + 70, GameScr.bJ + 30 + var8 * 1, 0);
            mFont.tahoma_7b_dark.drawStringBd(var1, mResources.fm[d][e], GameScr.bK + 55, GameScr.bJ + 30 + var8 * 2, 0);
         } else {
            byte var13 = 110;
            byte var14 = 60;
            if (main.GameCanvas.z > main.GameCanvas.A) {
               var13 = 100;
               var14 = 45;
            }

            for(var2 = 0; var2 < 3; ++var2) {
               if (var2 != d) {
                  var1.drawImage(GameScr.imgLbtnFocus, main.GameCanvas.z / 2 - 78 + var2 * 78, var13, 3);
               } else {
                  if (f == 1) {
                     var1.setColor(GameScr.bv, 0, 0, 13, 16, 4, main.GameCanvas.z / 2 - 78 + var2 * 78, var13 - 20 + (main.GameCanvas.v % 7 > 3 ? 1 : 0), StaticObj.f);
                  }

                  var1.drawImage(GameScr.imgLbtn, main.GameCanvas.z / 2 - 78 + var2 * 78, var13, 3);
               }

               mFont.tahoma_7b_dark.drawStringBd(var1, mResources.aK[var2], main.GameCanvas.z / 2 - 78 + var2 * 78, var13 - 5, 2);
            }

            for(var2 = 0; var2 < 3; ++var2) {
               if (var2 != e) {
                  var1.drawImage(GameScr.imgLbtnFocus, main.GameCanvas.z / 2 - 78 + var2 * 78, var13 + var14, 3);
               } else {
                  if (f == 2) {
                     var1.setColor(GameScr.bv, 0, 0, 13, 16, 4, main.GameCanvas.z / 2 - 78 + var2 * 78, var13 + var14 - 20 + (main.GameCanvas.v % 7 > 3 ? 1 : 0), StaticObj.f);
                  }

                  var1.drawImage(GameScr.imgLbtn, main.GameCanvas.z / 2 - 78 + var2 * 78, var13 + var14, 3);
               }

               mFont.tahoma_7b_dark.drawStringBd(var1, mResources.fm[d][var2], main.GameCanvas.z / 2 - 78 + var2 * 78, var13 + var14 - 5, 2);
            }

            if (f == 0) {
               var1.setColor(GameScr.bv, 0, 0, 13, 16, 4, main.GameCanvas.z / 2, 20 + (main.GameCanvas.v % 7 > 3 ? 1 : 0), StaticObj.f);
            }
         }

         c.paint(var1);
         var1.e(0, 0, main.GameCanvas.z, main.GameCanvas.A);
         mFont.c.drawString(var1, mResources.server + " " + LoginScr.serverName, 5, 5, 0, mFont.tahoma_7b_dark);
         super.paint(var1);
      }
   }

   public final void perform(int var1, Object var2) {
      switch(var1) {
      case 8000:
         if (c.getText().equals("")) {
            main.GameCanvas.startOKDlg(mResources.ar);
            return;
         } else if (c.getText().length() < 5) {
            main.GameCanvas.startOKDlg(mResources.as);
            return;
         } else {
            if (c.getText().length() > 15) {
               main.GameCanvas.startOKDlg(mResources.at);
               return;
            }

            InfoDlg.a();
            Service.gI().a(c.getText(), d, g[d][e]);
            return;
         }
      case 8001:
         if (main.GameCanvas.loginScr.isLogin2) {
            main.GameCanvas.startYesNoDlg(mResources.fS, new CommandLine(mResources.bm, this, 10019, (Object)null), new CommandLine(mResources.bn, this, 10020, (Object)null));
            return;
         }

         Session_ME2.Session_ME().close();
         main.GameCanvas.serverScreen.switchToMe();
         return;
      case 10019:
         Session_ME2.Session_ME().close();
         main.GameCanvas.endDlg();
         main.GameCanvas.serverScreen.switchToMe();
      default:
         return;
      case 10020:
         main.GameCanvas.endDlg();
      }
   }
}
