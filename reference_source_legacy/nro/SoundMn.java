package nro;

public final class SoundMn {
   public static boolean a = false;
   private static SoundMn l;
   public static float b = 0.5F;
   public static int c = 30;
   public static int d = 31;
   public static int e = 32;
   public static int f = 33;
   public static int g = 34;
   public static int h = 35;
   public static int i = 36;
   public static int j = 37;
   public static int k = 38;

   public static SoundMn stopAll() {
      if (l == null) {
         l = new SoundMn();
      }

      return l;
   }

   public final void b() {
      if (Char.cU) {
         Rms.saveRMSInt("isPaintAura", 0);
         Char.cU = false;
      } else {
         Rms.saveRMSInt("isPaintAura", 1);
         Char.cU = true;
      }

      g();
   }

   public final void c() {
      if (!main.GameCanvas.isTouch) {
         if (GameScr.bU = !GameScr.bU) {
            Rms.saveRMSInt("serverchat", 0);
         } else {
            Rms.saveRMSInt("serverchat", 1);
         }

         g();
      } else {
         if (GameScr.aN == 0) {
            GameScr.aN = 1;
            Rms.saveRMSInt("analog", GameScr.aN);
            GameScr.p();
         } else {
            GameScr.aN = 0;
            Rms.saveRMSInt("analog", GameScr.aN);
            GameScr.p();
         }

         g();
      }
   }

   public final void d() {
      if (main.GameCanvas.a) {
         Rms.saveRMSInt("lowGraphic", 0);
         main.GameCanvas.startOK(mResources.cL, 8885, (Object)null);
      } else {
         Rms.saveRMSInt("lowGraphic", 1);
         main.GameCanvas.startOK(mResources.cL, 8885, (Object)null);
      }

      g();
   }

   public final void e() {
      if (Char.cV) {
         Rms.saveRMSInt("isPaintAura2", 0);
         Char.cV = false;
      } else {
         Rms.saveRMSInt("isPaintAura2", 1);
         Char.cV = true;
      }

      g();
   }

   public static void f() {
      if (main.GameCanvas.loginScr.isLogin2 && Char.myCharz().aD != null && Char.myCharz().aD.c >= 2) {
         Panel.F = new String[]{mResources.j, mResources.bS, mResources.bR, mResources.bQ, mResources.aF, mResources.bP, mResources.ap, mResources.bT, mResources.T, mResources.I};
         if (Char.myCharz().havePet) {
            Panel.F = new String[]{mResources.j, mResources.bS, mResources.bR, mResources.x, mResources.bQ, mResources.aF, mResources.bP, mResources.ap, mResources.bT, mResources.T, mResources.I};
         }
      } else {
         Panel.F = new String[]{mResources.j, mResources.bS, mResources.bR, mResources.bQ, mResources.aF, mResources.bP, mResources.ap, mResources.bT, mResources.T};
         if (Char.myCharz().havePet) {
            Panel.F = new String[]{mResources.j, mResources.bS, mResources.bR, mResources.x, mResources.bQ, mResources.aF, mResources.bP, mResources.ap, mResources.bT, mResources.T};
         }
      }

      if (a) {
         String[] var0 = new String[Panel.F.length + 1];

         for(int var1 = 0; var1 < Panel.F.length; ++var1) {
            var0[var1] = Panel.F[var1];
         }

         var0[Panel.F.length] = mResources.e;
         Panel.F = var0;
      }

   }

   public static void g() {
      String var0 = "[x]   ";
      String var1 = "[  ]   ";
      String var2 = GameScr.aN == 0 ? var1 + mResources.F : var0 + mResources.G;
      if (!main.GameCanvas.isTouch) {
         var2 = !GameScr.bU ? var1 + mResources.bW : var0 + mResources.bW;
      }

      Panel.G = new String[]{Char.cU ? var1 + mResources.ca : var0 + mResources.ca, Char.cV ? var1 + mResources.cb : var0 + mResources.cb, main.GameCanvas.ai ? var0 + mResources.fz : var1 + mResources.fz, main.GameCanvas.a ? var0 + mResources.z : var1 + mResources.z, var2};
   }

   public static void h() {
      Session_ME2.Session_ME().close();
      main.GameCanvas.panel.A();
      main.GameCanvas.loginScr.endDlg();
      main.GameCanvas.loginScr.switchToMe();
   }
}
