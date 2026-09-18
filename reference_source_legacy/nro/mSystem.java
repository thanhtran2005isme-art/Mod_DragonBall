package nro;

import javax.microedition.io.ConnectionNotFoundException;
import javax.microedition.lcdui.Image;
import main.GameMidlet;

public final class mSystem {
   public static boolean a = false;
   public static boolean b = false;
   public static boolean c = false;
   private static Image j = load("/mainImage/black.png");
   public static int d = 1;
   public static byte e = 0;
   public static byte f = 0;
   public static byte g = 5;
   public static String h;
   public static boolean i = false;

   public static void a() {
      f = 0;
   }

   public static int a(Image var0) {
      return d == 5 ? var0.getWidth() : var0.getWidth();
   }

   public static int b(Image var0) {
      return d == 5 ? var0.getHeight() : var0.getWidth();
   }

   public static String a(long var0, int var2, boolean var3, boolean var4) {
      long var5;
      return (var5 = (var0 + (long)(var2 * 1000) - System.currentTimeMillis()) / 1000L) <= 0L ? "" : String.valueOf(var5);
   }

   public static String numberTostring(long var0) {
      String var2 = "" + var0;
      boolean var3 = false;

      try {
         if (var0 < 0L) {
            var3 = true;
            var0 = -var0;
            var2 = "" + var0;
         }

         String var4;
         int var6;
         if (var0 >= 1000000000L) {
            var4 = "b";
            var0 /= 1000000000L;
            var6 = ("" + var0).length();
         } else if (var0 >= 1000000L) {
            var4 = "m";
            var0 /= 1000000L;
            var6 = ("" + var0).length();
         } else {
            if (var0 < 1000L) {
               if (var3) {
                  return "-" + var2;
               }

               return var2;
            }

            var4 = "k";
            var0 /= 1000L;
            var6 = ("" + var0).length();
         }

         int var1;
         if ((var1 = Integer.parseInt(var2.substring(var6, 2))) == 0) {
            var2 = var2.substring(0, var6) + var4;
         } else if (var1 % 10 == 0) {
            var2 = var2.substring(0, var6) + "," + var2.substring(var6, 1) + var4;
         } else {
            var2 = var2.substring(0, var6) + "," + var2.substring(var6, 2) + var4;
         }
      } catch (Exception var5) {
      }

      return var3 ? "-" + var2 : var2;
   }

   public static void b() {
      try {
         GameMidlet.instance.platformRequest(ServerListScreen.j);
      } catch (ConnectionNotFoundException var1) {
         var1.printStackTrace();
      }
   }

   public static void a(mGraphics var0, int var1, int var2, int var3) {
      var3 = var3 / mGraphics.setColor(j) + 1;

      for(int var4 = 0; var4 < var3; ++var4) {
         var0.drawImage(j, var1 + var4 * mGraphics.setColor(j), var2, 0);
      }

   }

   public static void c() {
      while(Controller.b) {
         try {
            Thread.sleep(1000L);
         } catch (InterruptedException var1) {
            var1.printStackTrace();
         }
      }

   }

   public static void a(boolean var0) {
      if (main.GameCanvas.currentScreen.equals(SplashScr.a)) {
         if (ServerListScreen.d != null) {
            int var1;
            if (!ServerListScreen.d[0]) {
               ServerListScreen.d[0] = true;
               ServerListScreen.ipSelect = 0;
               if ((var1 = e()) == -1) {
                  var1 = ServerListScreen.ipSelect;
               }

               GameMidlet.ip = ServerListScreen.b[var1];
               Rms.saveRMSInt("svselect", var1);
               main.GameCanvas.connect();
            } else if (!ServerListScreen.d[2]) {
               ServerListScreen.d[2] = true;
               ServerListScreen.ipSelect = 2;
               if ((var1 = e()) == -1) {
                  var1 = ServerListScreen.ipSelect;
               }

               GameMidlet.ip = ServerListScreen.b[var1];
               Rms.saveRMSInt("svselect", var1);
               main.GameCanvas.connect();
            } else if (Rms.loadRMS("ImageSource") == null) {
               main.GameCanvas.startOK(mResources.aD, 8885, (Object)null);
            } else {
               main.GameCanvas.startOK(mResources.aE, 9000, (Object)null);
            }
         } else if (Rms.loadRMS("ImageSource") == null) {
            main.GameCanvas.startOK(mResources.aD, 8885, (Object)null);
         } else {
            main.GameCanvas.startOK(mResources.aE, 9000, (Object)null);
         }
      } else {
         Session_ME2.Session_ME().c();
         Session_ME2.doSendMessage().c();
         ServerListScreen.f = false;
         if (Controller.a) {
            main.GameCanvas.startOK(mResources.aD, 8885, (Object)null);
         } else {
            LoginScr.c = false;
            if (main.GameCanvas.loginScr != null) {
               main.GameCanvas.h.j();
            } else {
               main.GameCanvas.loginScr = new LoginScr();
            }

            LoginScr.serverName = ServerListScreen.a[ServerListScreen.ipSelect];
            if (main.GameCanvas.currentScreen != main.GameCanvas.serverScreen) {
               ResLog.c("===========> 2 v�o OnconnectFail");
               ServerListScreen.k = 0;
            } else {
               main.GameCanvas.endDlg();
               ServerListScreen.loadScreen = true;
               main.GameCanvas.serverScreen.switchToMe();
            }

            Char.isLoadingMap = false;
            if (var0) {
               ServerListScreen.t = 0;
            }

         }
      }
   }

   public static void b(boolean var0) {
      Session_ME2.Session_ME().c();
      Session_ME2.doSendMessage().c();
      if (Controller.a) {
         main.GameCanvas.h.j();
         main.GameCanvas.startOK(mResources.aD, 8885, (Object)null);
      } else {
         if (main.GameCanvas.currentScreen != main.GameCanvas.serverScreen) {
            main.GameCanvas.startOKDlg(mResources.maychutathoacmatsong);
         } else {
            main.GameCanvas.endDlg();
         }

         Char.isLoadingMap = false;
         if (var0) {
            ServerListScreen.t = 0;
         }

         main.GameCanvas.h.j();
      }
   }

   public static Image loadImageRMS(String var0) {
      String var1 = "/x" + mGraphics.zoomLevel + var0;
      Image var2;
      if ((var2 = ImageRes.a(var0)) == null) {
         String[] var3 = ResLog.a(ResLog.a(var1, ".", 0)[0], "/", 0);
         byte[] var4;
         if ((var4 = Rms.loadRMS("x" + mGraphics.zoomLevel + var3[var3.length - 1])) != null) {
            var2 = Image.createImage(var4, 0, var4.length);
         }
      }

      return var2;
   }

   public static Image load(String var0) {
      Image var1 = null;

      try {
         var1 = ImageRes.a(var0);
      } catch (Exception var2) {
      }

      return var1;
   }

   public static Image loadImage(String var0) {
      var0 = "/x" + mGraphics.zoomLevel + var0;
      Image var1 = null;

      try {
         var1 = Image.createImage(var0);
      } catch (Exception var2) {
      }

      return var1;
   }

   public static void a(mGraphics var0) {
      for(int var1 = 0; var1 < 5; ++var1) {
         if (GameScr.bH[var1] != -1 && main.GameCanvas.d(GameScr.bF[var1], GameScr.bG[var1])) {
            if (GameScr.bI[var1] == 0) {
               mFont.v.b(var0, GameScr.bE[var1], GameScr.bF[var1], GameScr.bG[var1], 2);
            } else if (GameScr.bI[var1] == 1) {
               mFont.x.b(var0, GameScr.bE[var1], GameScr.bF[var1], GameScr.bG[var1], 2);
            } else if (GameScr.bI[var1] == 2) {
               mFont.y.b(var0, GameScr.bE[var1], GameScr.bF[var1], GameScr.bG[var1], 2);
            } else if (GameScr.bI[var1] == 3) {
               mFont.x.b(var0, GameScr.bE[var1], GameScr.bF[var1], GameScr.bG[var1], 2, mFont.y);
            } else if (GameScr.bI[var1] == 8) {
               mFont.r.b(var0, GameScr.bE[var1], GameScr.bF[var1], GameScr.bG[var1], 2, mFont.tahoma_7b_dark);
            } else if (GameScr.bI[var1] == 4) {
               mFont.s.b(var0, GameScr.bE[var1], GameScr.bF[var1], GameScr.bG[var1], 2, mFont.o);
            } else if (GameScr.bI[var1] == 5) {
               mFont.z.b(var0, GameScr.bE[var1], GameScr.bF[var1], GameScr.bG[var1], 2);
            } else if (GameScr.bI[var1] == 6) {
               mFont.x.b(var0, GameScr.bE[var1], GameScr.bF[var1], GameScr.bG[var1], 2, mFont.v);
            } else if (GameScr.bI[var1] == 7) {
               mFont.c.b(var0, GameScr.bE[var1], GameScr.bF[var1], GameScr.bG[var1], 2, mFont.tahoma_7b_dark);
            } else if (GameScr.bI[var1] == 9) {
               mFont.p.b(var0, GameScr.bE[var1], GameScr.bF[var1], GameScr.bG[var1], 2, mFont.tahoma_7b_dark);
            } else if (GameScr.bI[var1] == 10) {
               mFont.l.b(var0, GameScr.bE[var1], GameScr.bF[var1], GameScr.bG[var1], 2, mFont.tahoma_7b_dark);
            }
         }
      }

   }

   public static long currentTimeMillis() {
      return System.currentTimeMillis();
   }

   public static FrameImage d(String var0) {
      FrameImage var1 = null;
      nr_bk var2 = null;
      if ((var2 = ImgByName.getImagePath(var0, ImgByName.a)).a != null) {
         int var3;
         if ((var3 = var2.a.getHeight() / var2.d) <= 0) {
            var3 = 1;
         }

         var1 = new FrameImage(var2.a, var2.a.getWidth(), var3);
      }

      return var1;
   }

   public static int e() {
      String[] var0 = ResLog.a(ServerListScreen.h.trim(), ",", 0);

      for(int var1 = 0; var1 < var0.length - 2; ++var1) {
         ResLog.a(var0[var1].trim(), ":", 0);
      }

      return -1;
   }
}
