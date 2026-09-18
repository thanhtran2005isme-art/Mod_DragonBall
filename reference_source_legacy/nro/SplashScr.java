package nro;

import javax.microedition.lcdui.Image;
import main.GameMidlet;

public final class SplashScr extends mScreen {
   private static int c;
   private boolean d = false;
   private static int e = -1;
   private static int f = -1;
   public static SplashScr a;
   public static Image b = mSystem.load("/gamelogo.png");

   public SplashScr() {
      a = this;
   }

   public static void a() {
      c = 0;
   }

   public final void update() {
      if (c == 30 && !this.d) {
         this.d = true;
         if (Rms.loadRMSInt("serverchat") != -1) {
            GameScr.bU = Rms.loadRMSInt("serverchat") == 0;
         }

         if (Rms.loadRMSInt("isPlaySound") != -1) {
            main.GameCanvas.ai = Rms.loadRMSInt("isPlaySound") == 1;
         }

         if (main.GameCanvas.ai) {
            SoundMn.stopAll();
         }

         SoundMn.stopAll();
         SoundMn.g();
         if (Rms.loadRMSInt("svselect") == -1) {
            String[] var1;
            mResources.a(Byte.parseByte((var1 = ResLog.a(ServerListScreen.h.trim(), ",", 0))[var1.length - 2]));
            ServerListScreen.a = new String[var1.length - 2];
            ServerListScreen.b = new String[var1.length - 2];
            ServerListScreen.e = new short[var1.length - 2];
            ServerListScreen.g = new byte[var1.length - 2];
            ServerListScreen.d = new boolean[2];

            for(int var2 = 0; var2 < var1.length - 2; ++var2) {
               String[] var3 = ResLog.a(var1[var2].trim(), ":", 0);
               ServerListScreen.a[var2] = var3[0];
               ServerListScreen.b[var2] = var3[1];
               ServerListScreen.e[var2] = Short.parseShort(var3[2]);
               ServerListScreen.g[var2] = Byte.parseByte(var3[3].trim());
            }

            main.GameCanvas.ak.switchToMe();
         } else {
            ServerListScreen.f();
         }
      }

      ++c;
      ServerListScreen.e();
      if (c >= 150) {
         ResLog.c("cho man hinh nay qa lau");
         if (Session_ME2.Session_ME().d()) {
            ServerListScreen.loadScreen = true;
            main.GameCanvas.serverScreen.switchToMe();
            return;
         }

         mSystem.b(true);
      }

   }

   public static void e() {
      int var0;
      if (Rms.loadRMSInt("svselect") != -1) {
         if ((ServerListScreen.ipSelect = Rms.loadRMSInt("svselect")) > ServerListScreen.a.length - 1) {
            ServerListScreen.ipSelect = ServerListScreen.c;
            if ((var0 = mSystem.e()) == -1) {
               var0 = ServerListScreen.ipSelect;
            }

            Rms.saveRMSInt("svselect", var0);
         }

         GameMidlet.ip = ServerListScreen.b[ServerListScreen.ipSelect];
         GameMidlet.port = ServerListScreen.e[ServerListScreen.ipSelect];
         mResources.a(ServerListScreen.g[ServerListScreen.ipSelect]);
         LoginScr.serverName = ServerListScreen.a[ServerListScreen.ipSelect];
         System.out.println("ipselect = " + ServerListScreen.ipSelect + " , " + LoginScr.serverName);
         ResLog.c("IP:" + GameMidlet.ip + " , PORT:" + GameMidlet.port);
         main.GameCanvas.connect();
      } else {
         var0 = 0;
         int var1;
         if (mResources.language > 0) {
            for(var1 = 0; var1 < mResources.language; ++var1) {
               var0 += ServerListScreen.m[var1];
            }
         }

         if (ServerListScreen.c == -1) {
            ServerListScreen.ipSelect = var0 + ResLog.random(0, ServerListScreen.m[mResources.language]);
         } else {
            ServerListScreen.ipSelect = ServerListScreen.c;
         }

         if ((var1 = mSystem.e()) == -1) {
            var1 = ServerListScreen.ipSelect;
         }

         Rms.saveRMSInt("svselect", var1);
         GameMidlet.ip = ServerListScreen.b[var1];
         GameMidlet.port = ServerListScreen.e[var1];
         mResources.a(ServerListScreen.g[var1]);
         LoginScr.serverName = ServerListScreen.a[var1];
         main.GameCanvas.connect();
      }
   }

   public final void paint(mGraphics var1) {
      if (b != null && c < 30) {
         if (mSystem.d == 3 || mSystem.d == 5) {
            var1.setColor(16777215);
            var1.fillRect(0, 0, main.GameCanvas.z, main.GameCanvas.A);
         }

         var1.drawImage(b, main.GameCanvas.z / 2, main.GameCanvas.A / 2, 3);
      }

      if (e != -1) {
         var1.setColor(0);
         var1.fillRect(0, 0, main.GameCanvas.z, main.GameCanvas.A);
         var1.drawImage(LoginScr.j, main.GameCanvas.z / 2, main.GameCanvas.A / 2 - 24, StaticObj.c);
         main.GameCanvas.a(main.GameCanvas.B, main.GameCanvas.A / 2 + 24, var1);
         mFont.c.drawStringBd(var1, mResources.aC + e * 100 / f + "%", main.GameCanvas.z / 2, main.GameCanvas.A / 2, 2);
      } else {
         if (c >= 30) {
            var1.setColor(0);
            var1.fillRect(0, 0, main.GameCanvas.z, main.GameCanvas.A);
            main.GameCanvas.a(main.GameCanvas.B, main.GameCanvas.hh, var1);
         }

      }
   }

   public static void f() {
      b = mSystem.load("/gamelogo.png");
   }
}
