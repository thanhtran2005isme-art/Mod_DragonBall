package nro;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import main.GameMidlet;

public final class ServerListScreen extends mScreen implements IActionListener {
   public static String[] a;
   public static String[] b;
   public static byte c;
   public static boolean[] d;
   public static short[] e;
   private static int w;
   public static boolean f;
   public static byte[] g;
   private CommandLine[] x;
   private CommandLine y;
   private int z;
   private static String A = "Vũ trụ 1:dragon1.teamobi.com:14445:0,Vũ trụ 2:dragon2.teamobi.com:14445:0,Vũ trụ 3:dragon3.teamobi.com:14445:0,Vũ trụ 4:dragon4.teamobi.com:14445:0,Vũ trụ 5:dragon5.teamobi.com:14445:0,Vũ trụ 6:dragon6.teamobi.com:14445:0,Vũ trụ 7:dragon7.teamobi.com:14445:0,Vũ trụ 8:dragon10.teamobi.com:14446:0,Vũ trụ 9:dragon10.teamobi.com:14447:0,Vũ trụ 10:dragon10.teamobi.com:14445:0,Vũ trụ 11:dragon11.teamobi.com:14445:0,Võ đài liên vũ trụ:dragonwar.teamobi.com:20000:0,Universe 1:dragon.indonaga.com:14445:1,Naga:dragon.indonaga.com:14446:2,0,0";
   private static String B = "Vũ trụ 1:112.213.94.23:14445:0,Vũ trụ 2:210.211.109.199:14445:0,Vũ trụ 3:112.213.85.88:14445:0,Vũ trụ 4:27.0.12.164:14445:0,Vũ trụ 5:27.0.12.16:14445:0,Vũ trụ 6:27.0.12.173:14445:0,Vũ trụ 7:112.213.94.223:14445:0,Vũ trụ 8:27.0.14.66:14446:0,Vũ trụ 9:27.0.14.66:14447:0,Vũ trụ 10:27.0.14.66:14445:0,Vũ trụ 11:112.213.85.35:14445:0,Võ đài liên vũ trụ:27.0.12.173:20000:0,Universe 1:52.74.230.22:14445:1,Naga:52.74.230.22:14446:2,0,0";
   private static String C = "Naga:dragon.indonaga.com:14446:2,2,0";
   private static String D = "Naga:52.74.230.22:14446:2,2,0";
   private static String E = "Universe 1:dragon.indonaga.com:14445:1,1,0";
   private static String F = "Universe 1:52.74.230.22:14445:1,1,0";
   public static String h;
   public static boolean i;
   public static String j;
   public static int k;
   public static boolean l;
   private static int G;
   public static int[] m;
   public static int ipSelect;
   private static int H;
   public static boolean o;
   public static int p;
   public static int q;
   public static int r;
   public static boolean s;
   private static CommandLine I;
   public static int t;
   public static boolean loadScreen;
   public static boolean v;

   static {
      h = B;
      m = new int[3];
      s = false;
      t = -1;
      v = true;
   }

   public ServerListScreen() {
      System.getProperty("com.sonyericsson.imei");
      this.k();
      if (!main.GameCanvas.isTouch) {
         w = 0;
         this.l();
      }

      GameScr.loadCamera(-1, (int)-1);
      GameScr.cmx = 100;
      GameScr.cmy = 200;
      if (this.y == null) {
         this.y = new CommandLine("Gọi hotline", this, 13, (Object)null);
         this.y.x = main.GameCanvas.z - 75;
         if (mSystem.d == 1 && !main.GameCanvas.isTouch) {
            this.y.y = main.GameCanvas.A - 20;
         } else {
            this.y.y = 8;
         }
      }

      boolean var1 = false;
      if (0 == 2) {
         if (mSystem.d == 1) {
            h = D;
         } else {
            h = C;
         }
      } else if (var1) {
         h = F;
         if (mSystem.d == 1) {
            h = F;
         } else {
            h = E;
         }
      } else {
         h = B;
         if (mSystem.d == 1) {
            h = B;
         } else {
            h = A;
         }
      }
   }

   private void k() {
      String var1;
      label59: {
         this.z = 0;
         if ((var1 = Rms.loadRMSString("acc")) == null) {
            if (Rms.loadRMS("userAo" + ipSelect) == null) {
               break label59;
            }
         } else if (var1.equals("") && Rms.loadRMS("userAo" + ipSelect) == null) {
            break label59;
         }

         this.z = 1;
      }

      this.x = new CommandLine[mGraphics.zoomLevel > 1 ? 3 + this.z : 4 + this.z];
      int var2 = main.GameCanvas.hh - 15 * this.x.length + 28;

      for(int var3 = 0; var3 < this.x.length; ++var3) {
         switch(var3) {
         case 0:
            this.x[0] = new CommandLine("", this, 3, (Object)null);
            if (var1 == null) {
               this.x[0].caption = mResources.ge;
               if (Rms.loadRMS("userAo" + ipSelect) != null) {
                  this.x[0].caption = mResources.r;
               }
            } else if (var1.equals("")) {
               this.x[0].caption = mResources.ge;
               if (Rms.loadRMS("userAo" + ipSelect) != null) {
                  this.x[0].caption = mResources.r;
               }
            } else {
               this.x[0].caption = mResources.gf + ": " + var1;
               if (this.x[0].caption.length() > 23) {
                  this.x[0].caption = this.x[0].caption.substring(0, 23);
                  CommandLine var10000 = this.x[0];
                  var10000.caption = var10000.caption + "...";
               }
            }
            break;
         case 1:
            if (this.z == 1) {
               this.x[1] = new CommandLine("", this, 10100, (Object)null);
               this.x[1].caption = mResources.ge;
            } else {
               this.x[1] = new CommandLine(mResources.T, this, 7, (Object)null);
            }
            break;
         case 2:
            if (this.z == 1) {
               this.x[2] = new CommandLine(mResources.T, this, 7, (Object)null);
            } else {
               this.x[2] = new CommandLine("", this, 17, (Object)null);
            }
            break;
         case 3:
            if (this.z == 1) {
               this.x[3] = new CommandLine("", this, 17, (Object)null);
            } else {
               this.x[3] = new CommandLine(mResources.bT, this, 8, (Object)null);
            }
            break;
         case 4:
            this.x[4] = new CommandLine(mResources.bT, this, 8, (Object)null);
         }

         this.x[var3].y = var2;
         this.x[var3].b();
         this.x[var3].x = (main.GameCanvas.z - this.x[var3].k) / 2;
         var2 += 30;
      }

   }

   public static void doUpdateServer() {
      a(h);
   }

   public static void a(String var0) {
      try {
         m = new int[3];
         String[] var5;
         mResources.a(Byte.parseByte((var5 = ResLog.a(var0.trim(), ",", 0))[var5.length - 2]));
         a = new String[var5.length - 2];
         b = new String[var5.length - 2];
         e = new short[var5.length - 2];
         g = new byte[var5.length - 2];
         d = new boolean[2];

         for(int var1 = 0; var1 < var5.length - 2; ++var1) {
            String[] var2 = ResLog.a(var5[var1].trim(), ":", 0);
            a[var1] = var2[0];
            b[var1] = var2[1];
            e[var1] = Short.parseShort(var2[2]);
            g[var1] = Byte.parseByte(var2[3].trim());
            int var10002 = m[g[var1]]++;
         }

         c = Byte.parseByte(var5[var5.length - 1]);
         ByteArrayOutputStream var6 = new ByteArrayOutputStream();
         DataOutputStream var7 = new DataOutputStream(var6);

         try {
            var7.writeByte(mResources.language);
            var7.writeByte(a.length);

            for(int var8 = 0; var8 < a.length; ++var8) {
               var7.writeUTF(a[var8]);
               var7.writeUTF(b[var8]);
               var7.writeShort(e[var8]);
               var7.writeByte(g[var8]);
            }

            c = (byte)c;
            var7.writeByte(c);
            Rms.saveRMS("NRlink", var6.toByteArray());
            var7.close();
            SplashScr.e();
         } catch (Exception var3) {
            var3.printStackTrace();
            return;
         }
      } catch (Exception var4) {
         var4.printStackTrace();
      }

   }

   public final void paint(mGraphics var1) {
      if (!loadScreen) {
         var1.setColor(0);
         var1.fillRect(0, 0, main.GameCanvas.z, main.GameCanvas.A);
      } else {
         main.GameCanvas.paintBackground(var1);
      }

      mFont.s.drawString(var1, "v2.3.7(" + mGraphics.zoomLevel + ")", main.GameCanvas.z - 2, 17, 1, mFont.o);
      String var2 = "";
      if (t == 0) {
         (new StringBuffer(String.valueOf(var2))).append(a[ipSelect]).append(" disconnect").toString();
      } else {
         (new StringBuffer(String.valueOf(var2))).append(a[ipSelect]).append(" connected").toString();
      }

      if (s && !loadScreen) {
         mFont.s.drawString(var1, j, main.GameCanvas.z - 2, 2, 1, mFont.o);
      } else if (mSystem.d == 1 && !main.GameCanvas.isTouch) {
         mFont.s.drawString(var1, j, main.GameCanvas.z - 2, main.GameCanvas.A - 15, 1, mFont.o);
      } else {
         mFont.s.drawString(var1, j, main.GameCanvas.z - 2, 2, 1, mFont.o);
      }

      if (main.GameCanvas.currentDialog == null) {
         if (!loadScreen) {
            if (!o) {
               var1.drawImage(LoginScr.j, main.GameCanvas.B, main.GameCanvas.hh - 32, 3);
               if (s) {
                  if (I != null) {
                     I.a(var1);
                  }

                  var1.e(0, 0, main.GameCanvas.z, main.GameCanvas.A);
                  mFont.c.drawStringBd(var1, mResources.aC + p + "%", main.GameCanvas.z / 2, main.GameCanvas.hh + 24, 2);
                  GameScr.a(GameScr.ah, GameScr.ai, GameScr.aj, (float)(main.GameCanvas.z / 2 - 50), (float)(main.GameCanvas.hh + 45), 100, 100.0F, var1);
                  GameScr.a(GameScr.ae, GameScr.af, GameScr.ag, (float)(main.GameCanvas.z / 2 - 50), (float)(main.GameCanvas.hh + 45), 100, (float)p, var1);
                  return;
               }

               mFont.c.drawStringBd(var1, mResources.fZ, main.GameCanvas.B, main.GameCanvas.hh + 24, 2);
               if (I != null) {
                  I.a(var1);
                  return;
               }
            }
         } else {
            int var3;
            if ((var3 = main.GameCanvas.hh - 15 * this.x.length - 15) < 25) {
               var3 = 25;
            }

            if (LoginScr.j != null) {
               var1.drawImage(LoginScr.j, main.GameCanvas.B, var3, 3);
            }

            for(var3 = 0; var3 < this.x.length; ++var3) {
               this.x[var3].a(var1);
            }

            var1.e(0, 0, main.GameCanvas.z, main.GameCanvas.A);
            if (t == -1) {
               if (main.GameCanvas.v % 20 > 10) {
                  var1.setColor(GameScr.ad, 0, 14, 7, 7, 0, (main.GameCanvas.z - mFont.tahoma_7b_dark.getWidth(this.x[2 + this.z].caption) >> 1) - 10, this.x[2 + this.z].y + 10, 0);
                  return;
               }
            } else {
               var1.setColor(GameScr.ad, 0, t * 7, 7, 7, 0, (main.GameCanvas.z - mFont.tahoma_7b_dark.getWidth(this.x[2 + this.z].caption) >> 1) - 10, this.x[2 + this.z].y + 9, 0);
            }
         }
      }

   }

   public final void update() {
      CommandLine var2;
      if (l) {
         if (++G == 50) {
            short var3 = 0;
            var2 = null;
            ServerListScreen var1 = main.GameCanvas.serverScreen;
            H = 30;
            main.GameCanvas.startWaitDlg(mResources.aA);
            GameMidlet.ip = b[ipSelect];
            GameMidlet.port = e[ipSelect];
            var1.k();
            main.GameCanvas.a(GameMidlet.ip, (short)GameMidlet.port);
         }

         if (G >= 100 && Session_ME2.Session_ME().d()) {
            if (main.GameCanvas.loginScr == null) {
               main.GameCanvas.loginScr = new LoginScr();
            }

            main.GameCanvas.loginScr.doLogin();
            Service.gI().finishUpdate();
            l = false;
         }
      }

      if (H > 0) {
         if (--H == 0) {
            main.GameCanvas.endDlg();
         }

         if (t == 2) {
            H = 0;
            main.GameCanvas.endDlg();
         }
      }

      if (H <= 0 && v && ++k > 100000) {
         k = 0;
      }

      for(int var4 = 0; var4 < this.x.length; ++var4) {
         if (var4 == w) {
            this.x[var4].m = true;
         } else {
            this.x[var4].m = false;
         }
      }

      ++GameScr.cmx;
      if (!loadScreen && (o || p == 100)) {
         I = null;
      }

      super.update();
      if (!Char.isLoadingMap) {
         if (loadScreen) {
            if (v) {
               if (main.GameCanvas.currentScreen == this) {
                  if (t != 2) {
                     if (k < (mSystem.d == 1 ? 2 : 5)) {
                        if (H <= 0) {
                           H = 30;
                           main.GameCanvas.startWaitDlg(mResources.aA);
                           main.GameCanvas.connect();
                           return;
                        }
                     } else if (!Session_ME2.Session_ME().d()) {
                        if (H <= 0) {
                           CommandLine var5 = new CommandLine(mResources.bm, main.GameCanvas.serverScreen, 18, (Object)null);
                           var2 = new CommandLine(mResources.bn, main.GameCanvas.serverScreen, 19, (Object)null);
                           main.GameCanvas.startYesNoDlg(mResources.maychutathoacmatsong + "." + mResources.a, var5, var2);
                           H = 30;
                           return;
                        }
                     } else if (H <= 0) {
                        k = 0;
                     }
                  }

               }
            }
         }
      }
   }

   private void l() {
      ResLog.c("load Screen= " + loadScreen + " select= " + w);
      if (loadScreen) {
         super.center = new CommandLine("", this, this.x[w].e, (Object)null);
      } else {
         super.center = I;
      }
   }

   public static void e() {
   }

   public final void updateKey() {
      int var1;
      if (main.GameCanvas.isTouch) {
         if (this.y != null && this.y.isPointerPressInside()) {
            this.y.performAction();
         }

         if (!loadScreen) {
            if (I != null && I.isPointerPressInside()) {
               I.performAction();
            }

            super.updateKey();
            return;
         }

         for(var1 = 0; var1 < this.x.length; ++var1) {
            if (this.x[var1] != null && this.x[var1].isPointerPressInside() && (t != -1 && t != 0 || this.x[var1].caption.indexOf(mResources.server) != -1)) {
               this.x[var1].performAction();
            }
         }
      } else {
         if (mSystem.d == 1 && main.GameCanvas.keyPressed[13]) {
            main.GameCanvas.keyPressed[13] = false;
            this.y.performAction();
         }

         if (loadScreen) {
            if (main.GameCanvas.keyPressed[8]) {
               var1 = this.x.length - 1;
               main.GameCanvas.keyPressed[8] = false;
               if (++w > var1) {
                  w = 0;
               }

               this.l();
            }

            if (main.GameCanvas.keyPressed[2]) {
               var1 = this.x.length - 1;
               main.GameCanvas.keyPressed[2] = false;
               if (--w < 0) {
                  w = var1;
               }

               this.l();
            }
         }
      }

      super.updateKey();
   }

   public static void f() {
      byte[] var0;
      if ((var0 = Rms.loadRMS("NRlink")) == null) {
         a(h);
      } else {
         ByteArrayInputStream var4 = new ByteArrayInputStream(var0);
         DataInputStream var5 = new DataInputStream(var4);

         try {
            m = new int[3];
            ResLog.c(" NRlink = " + var5.available());
            mResources.a(var5.readByte());
            byte var1;
            a = new String[var1 = var5.readByte()];
            b = new String[var1];
            e = new short[var1];
            g = new byte[var1];

            for(int var2 = 0; var2 < var1; ++var2) {
               a[var2] = var5.readUTF();
               b[var2] = var5.readUTF();
               e[var2] = var5.readShort();
               g[var2] = var5.readByte();
               int var10002 = m[g[var2]]++;
            }

            c = var5.readByte();
            var5.close();
            SplashScr.e();
         } catch (IOException var3) {
            var3.printStackTrace();
         }
      }
   }

   public final void switchToMe() {
      nr_df.b();
      GameScr.cmy = 0;
      GameScr.cmx = 0;
      this.k();
      f = false;
      main.GameCanvas.loginScr = null;
      String var1;
      if (((var1 = Rms.loadRMSString("ResVersion")) != null && var1 != "" ? Integer.parseInt(var1) : -1) > 0) {
         loadScreen = true;
         main.GameCanvas.a(0);
      }

      o = true;
      this.x[2 + this.z].caption = mResources.server + ": " + a[ipSelect];
      super.center = new CommandLine("", this, this.x[w].e, (Object)null);
      this.x[1 + this.z].caption = mResources.T;
      if (this.x.length == 4 + this.z) {
         this.x[3 + this.z].caption = mResources.bT;
      }

      Char.isLoadingMap = false;
      mSystem.a();
      super.switchToMe();
   }

   public final void g() {
      GameScr.cmy = 0;
      GameScr.cmx = 0;
      this.k();
      f = false;
      main.GameCanvas.loginScr = null;
      String var1;
      if (((var1 = Rms.loadRMSString("ResVersion")) != null && var1 != "" ? Integer.parseInt(var1) : -1) > 0) {
         loadScreen = true;
         main.GameCanvas.a(0);
      }

      o = true;
      this.x[2 + this.z].caption = mResources.server + ": " + a[ipSelect];
      super.center = new CommandLine("", this, this.x[w].e, (Object)null);
      this.x[1 + this.z].caption = mResources.T;
      if (this.x.length == 4 + this.z) {
         this.x[3 + this.z].caption = mResources.bT;
      }

      super.switchToMe();
   }

   public final void h() {
      if (main.GameCanvas.serverScreen == null) {
         main.GameCanvas.serverScreen = new ServerListScreen();
      }

      r = 0;
      p = 0;
      i = true;
      main.GameCanvas.serverScreen.show2();
      s = false;
      I.m = true;
      super.center = new CommandLine("", this, 2, (Object)null);
   }

   public final void i() {
      H = 30;
      main.GameCanvas.startWaitDlg(mResources.aA);
      Session_ME2.Session_ME().close();
      GameMidlet.ip = b[ipSelect];
      GameMidlet.port = e[ipSelect];
      Rms.saveRMSInt("svselect", ipSelect);
      if (g[ipSelect] != mResources.language) {
         mResources.a(g[ipSelect]);
      }

      LoginScr.serverName = a[ipSelect];
      this.k();
      loadScreen = true;
      k = 0;
      t = -1;
      v = true;
   }

   public final void perform(int var1, Object var2) {
      ResLog.c("perform trong ServerListScreen" + var1);
      if (var1 == 1000) {
         main.GameCanvas.connect();
      }

      if (var1 == 1 || var1 == 4) {
         Session_ME2.Session_ME().close();
         v = false;
         k = 0;
         loadScreen = true;
         t = 0;
         s = false;
         Rms.a();
         this.switchToMe();
      }

      if (var1 == 2) {
         i = false;
         (I = new CommandLine(mResources.ga, this, 4, (Object)null)).x = main.GameCanvas.z / 2 - mScreen.cd / 2;
         I.y = main.GameCanvas.hh + 65;
         super.cb = null;
         if (!main.GameCanvas.isTouch) {
            I.x = main.GameCanvas.z / 2 - mScreen.cd / 2;
            I.y = main.GameCanvas.A - mScreen.ce - 1;
         }

         super.center = new CommandLine("", this, 4, (Object)null);
         if (!s) {
            Service.gI().b((byte)1, (MyVector)null);
            if (!main.GameCanvas.isTouch) {
               I.m = true;
               super.center = new CommandLine("", this, 4, (Object)null);
            }

            s = true;
         }
      }

      boolean var4;
      String var5;
      if (var1 == 3) {
         if (main.GameCanvas.loginScr == null) {
            main.GameCanvas.loginScr = new LoginScr();
         }

         main.GameCanvas.loginScr.switchToMe();
         if (Rms.loadRMSString("acc") == null) {
            var4 = false;
         } else if (Rms.loadRMSString("acc").equals("")) {
            var4 = false;
         } else {
            var4 = true;
         }

         boolean var3;
         if (Rms.loadRMSString("userAo" + ipSelect) == null) {
            var3 = false;
         } else if (Rms.loadRMSString("userAo" + ipSelect).equals("")) {
            var3 = false;
         } else {
            var3 = true;
         }

         if (!var4 && !var3) {
            main.GameCanvas.connect();
            if ((var5 = Rms.loadRMSString("userAo" + ipSelect)) != null && !var5.equals("")) {
               main.GameCanvas.loginScr.isLogin2 = true;
               main.GameCanvas.connect();
               Service.gI().setClientType();
               Service.gI().login(var5, "", "2.3.7", (byte)1);
            } else {
               Service.gI().f("");
            }

            main.GameCanvas.startWaitDlg();
         } else {
            main.GameCanvas.loginScr.doLogin();
         }

         LoginScr.serverName = a[ipSelect];
      }

      if (var1 == 10100) {
         if (main.GameCanvas.loginScr == null) {
            main.GameCanvas.loginScr = new LoginScr();
         }

         main.GameCanvas.loginScr.switchToMe();
         main.GameCanvas.connect();
         Service.gI().f("");
         ResLog.c("tao user ao");
         main.GameCanvas.startWaitDlg();
         LoginScr.serverName = a[ipSelect];
      }

      if (var1 == 5) {
         doUpdateServer();
         if (a.length == 1) {
            return;
         }

         MyVector var6 = new MyVector("");

         for(int var7 = 0; var7 < a.length; ++var7) {
            var6.addElement(new CommandLine(a[var7], this, 6, (Object)null));
         }

         main.GameCanvas.menu.startAt(var6);
         if (!main.GameCanvas.isTouch) {
            main.GameCanvas.menu.b = ipSelect;
         }
      }

      if (var1 == 6) {
         ipSelect = main.GameCanvas.menu.b;
         this.i();
      }

      if (var1 == 7) {
         if (main.GameCanvas.loginScr == null) {
            main.GameCanvas.loginScr = new LoginScr();
         }

         main.GameCanvas.loginScr.switchToMe();
      }

      if (var1 == 8) {
         var4 = Rms.loadRMSInt("lowGraphic") == 1;
         MyVector var8;
         (var8 = new MyVector("cau hinh")).addElement(new CommandLine(mResources.z, this, 9, (Object)null));
         var8.addElement(new CommandLine(mResources.A, this, 10, (Object)null));
         main.GameCanvas.menu.startAt(var8);
         if (var4) {
            main.GameCanvas.menu.b = 0;
         } else {
            main.GameCanvas.menu.b = 1;
         }
      }

      if (var1 == 9) {
         Rms.saveRMSInt("lowGraphic", 1);
         main.GameCanvas.startOK(mResources.cL, 8885, (Object)null);
      }

      if (var1 == 10) {
         Rms.saveRMSInt("lowGraphic", 0);
         main.GameCanvas.startOK(mResources.cL, 8885, (Object)null);
      }

      if (var1 == 11) {
         if (main.GameCanvas.loginScr == null) {
            main.GameCanvas.loginScr = new LoginScr();
         }

         main.GameCanvas.loginScr.switchToMe();
         if ((var5 = Rms.loadRMSString("userAo" + ipSelect)) != null && !var5.equals("")) {
            main.GameCanvas.loginScr.isLogin2 = true;
            main.GameCanvas.connect();
            Service.gI().setClientType();
            Service.gI().login(var5, "", "2.3.7", (byte)1);
         } else {
            Service.gI().f("");
         }

         main.GameCanvas.startWaitDlg(mResources.aA);
         ResLog.c("tao user ao");
      }

      if (var1 == 12) {
         GameMidlet.instance.a();
      }

      if (var1 == 13 && (!s || loadScreen)) {
         switch(mSystem.d) {
         case 1:
            mSystem.b();
         case 2:
         case 3:
         case 4:
         case 5:
         case 6:
         }
      }

      if (var1 == 14) {
         CommandLine var9 = new CommandLine(mResources.bm, main.GameCanvas.serverScreen, 15, (Object)null);
         CommandLine var10 = new CommandLine(mResources.bn, main.GameCanvas.serverScreen, 16, (Object)null);
         main.GameCanvas.startYesNoDlg(mResources.gd, var9, var10);
      }

      if (var1 == 15) {
         Rms.a();
         main.GameCanvas.startOK(mResources.cL, 8885, (Object)null);
      }

      if (var1 == 16) {
         InfoDlg.hide();
         main.GameCanvas.currentDialog = null;
      }

      if (var1 == 17) {
         if (main.GameCanvas.ak == null) {
            main.GameCanvas.ak = new ServerScr();
         }

         main.GameCanvas.ak.switchToMe();
      }

      if (var1 == 18) {
         main.GameCanvas.endDlg();
         InfoDlg.hide();
         if (main.GameCanvas.ak == null) {
            main.GameCanvas.ak = new ServerScr();
         }

         main.GameCanvas.ak.switchToMe();
      }

      if (var1 == 19) {
         if (mSystem.d == 1) {
            InfoDlg.hide();
            main.GameCanvas.currentDialog = null;
            return;
         }

         k = 0;
         t = 0;
         v = true;
      }

   }

   public final void show2() {
      GameScr.cmx = 0;
      GameScr.cmy = 0;
      this.k();
      loadScreen = false;
      p = 0;
      o = false;
      s = false;
      r = 0;
      Char.isLoadingMap = false;
      if (!loadScreen) {
         (I = new CommandLine(mResources.gb, this, 2, (Object)null)).m = true;
         I.x = main.GameCanvas.z / 2 - mScreen.cd / 2;
         I.y = main.GameCanvas.hh + 45;
         if (I.y > main.GameCanvas.A - 26) {
            I.y = main.GameCanvas.A - 26;
         }
      }

      if (!main.GameCanvas.isTouch) {
         w = 0;
         this.l();
      }

      super.switchToMe();
   }
}
