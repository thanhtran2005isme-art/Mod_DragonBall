package nro;

import javax.microedition.lcdui.Image;
import main.GameMidlet;
import main.GameCanvas;

public final class LoginScr extends mScreen implements IActionListener {
   public TField tfUser;
   public TField tfPass;
   public static boolean c = false;
   private int focus;
   private int wC;
   private int q;
   private int r;
   private boolean isCheck = false;
   private boolean isRes = false;
   private CommandLine u;
   private CommandLine v;
   private CommandLine w;
   private CommandLine x;
   private CommandLine y;
   public static boolean d;
   public static boolean e;
   public static boolean f;
   public static boolean g;
   public static boolean h;
   public static String serverName;
   public static Image j;
   public static short k;
   public static long l;
   public static long m;
   private int z;
   private CommandLine A;
   private int B;
   private int yLog;
   private int D;
   private int E = -1;
   public boolean isLogin2 = false;
   private int F = 2;
   private int G = 0;
   private int H = -40;
   private int I = 1;
   private CommandLine cmdCallHotline;

   static {
      int[] var10000 = new int[]{0, 8, 2, 6, 9};
   }

   public final void switchToMe() {
      SoundMn.stopAll();
      this.tfUser.isFocus = true;
      this.tfPass.isFocus = false;
      if (GameCanvas.isTouch) {
         this.tfUser.isFocus = false;
      }

      GameCanvas.a(0);
      super.switchToMe();
   }

   public LoginScr() {
      this.yLog = GameCanvas.hh - 30;
      if ((TileMap.bgID = (byte)((int)(System.currentTimeMillis() % 9L))) == 5 || TileMap.bgID == 6) {
         TileMap.bgID = 4;
      }

      GameScr.loadCamera(-1, (int)-1);
      GameScr.cmx = 100;
      GameScr.cmy = 200;
      if (GameCanvas.A > 200) {
         this.r = GameCanvas.hh - 80;
      } else {
         this.r = GameCanvas.hh - 65;
      }

      this.q = -50;
      int var1 = GameCanvas.z >= 200 ? 160 : 140;
      this.wC = var1;
      this.z = GameCanvas.hh - mScreen.ITEM_HEIGHT - 5;
      if (GameCanvas.A <= 160) {
         this.z = 20;
      }

      this.tfUser = new TField();
      this.tfUser.b = GameCanvas.hh - mScreen.ITEM_HEIGHT - 9;
      this.tfUser.width = this.wC;
      this.tfUser.height = mScreen.ITEM_HEIGHT + 2;
      this.tfUser.isFocus = true;
      this.tfUser.setIputType(0);
      this.tfUser.name = (mResources.language == 2 ? "" : mResources.phone + "/") + mResources.email;
      this.tfPass = new TField();
      this.tfPass.b = GameCanvas.hh - 4;
      this.tfPass.setIputType(2);
      this.tfPass.width = this.wC;
      this.tfPass.height = mScreen.ITEM_HEIGHT + 2;
      this.z += 35;
      this.isCheck = true;
      if ((var1 = Rms.loadRMSInt("check")) == 1) {
         this.isCheck = true;
      } else if (var1 == 2) {
         this.isCheck = false;
      }

      this.tfUser.setText(Rms.loadRMSString("acc"));
      this.tfPass.setText(Rms.loadRMSString("pass"));
      this.tfUser.setText((String)null);
      this.tfPass.setText((String)null);
      if (this.cmdCallHotline == null) {
         this.cmdCallHotline = new CommandLine("Gọi hotline", this, 13, (Object)null);
         this.cmdCallHotline.x = GameCanvas.z - 75;
         if (mSystem.d == 1 && !GameCanvas.isTouch) {
            this.cmdCallHotline.y = GameCanvas.A - 20;
         } else {
            this.cmdCallHotline.y = 8;
         }
      }

      this.focus = 0;
      this.u = new CommandLine(GameCanvas.z > 200 ? mResources.aw : mResources.ax, GameCanvas.h, 888393, (Object)null);
      new CommandLine(mResources.bs, this, 2001, (Object)null);
      this.w = new CommandLine(mResources.ay, this, 2002, (Object)null);
      this.y = new CommandLine(mResources.bu, this, 10021, (Object)null);
      super.left = this.x = new CommandLine(mResources.bh, this, 2003, (Object)null);
      if (GameCanvas.isTouch) {
         this.u.x = GameCanvas.z / 2 + 8;
         this.x.x = GameCanvas.z / 2 - mScreen.cd - 8;
         if (GameCanvas.A >= 200) {
            this.u.y = this.yLog + 110;
            this.x.y = this.yLog + 110;
         }

         this.y.x = GameCanvas.z / 2 + 3;
         this.y.y = this.yLog + 110;
         this.w.x = GameCanvas.z / 2 - 84;
         this.w.y = this.x.y;
      }

      this.D = 170;
      short var2 = 184;
      if (184 >= GameCanvas.z) {
         var2 = 152;
      }

      this.B = GameCanvas.z / 2 - var2 / 2;
      this.yLog = GameCanvas.hh - 30;
      this.tfUser.a = this.B + 10;
      this.tfUser.b = this.yLog + 20;
      this.A = new CommandLine(mResources.OK, this, 2008, (Object)null);
      this.A.x = GameCanvas.z / 2 - 84;
      this.A.y = this.u.y;
      this.v = new CommandLine(mResources.ab, this, 1003, (Object)null);
      this.v.x = GameCanvas.z / 2 + 3;
      this.v.y = this.u.y;
      super.center = this.A;
      super.left = this.v;
   }

   public final void doLogin() {
      ResLog.c("user ao= " + Rms.loadRMSString("userAo" + ServerListScreen.ipSelect));
      String acc = Rms.loadRMSString("acc");
      String pass = Rms.loadRMSString("pass");
      if ((acc == null || acc.equals("")) && Rms.loadRMSString("userAo" + ServerListScreen.ipSelect) != null && !Rms.loadRMSString("userAo" + ServerListScreen.ipSelect).equals("")) {
         this.isLogin2 = true;
      } else {
         this.isLogin2 = false;
      }

      ResLog.c("isLogin 2= " + this.isLogin2);
      if ((acc == null || acc.equals("")) && this.isLogin2) {
         acc = Rms.loadRMSString("userAo" + ServerListScreen.ipSelect);
         pass = "a";
      }

      ResLog.c("user = " + acc + " pass= " + pass);
      if (acc != null && pass != null && !acc.equals("")) {
         if (pass.equals("")) {
            this.focus = 1;
            this.tfUser.isFocus = false;
            this.tfPass.isFocus = true;
            if (!GameCanvas.isTouch) {
               super.cb = this.tfPass.j;
            }

         } else {
            if (!Session_ME2.Session_ME().d()) {
               GameCanvas.connect();
            }

            Service.gI().login(acc, pass, "2.3.7", (byte)(this.isLogin2 ? 1 : 0));
            ResLog.c(this.getClass().getName() + " doLogin =" + acc);
            if (Session_ME2.Session_ME().connected) {
               GameCanvas.startWaitDlg();
            } else {
               GameCanvas.startOKDlg(mResources.maychutathoacmatsong);
            }

            this.focus = 0;
            if (!this.isLogin2) {
               this.actRegisterLeft();
            }

            GameCanvas.ag = mSystem.currentTimeMillis() + 30000L;
         }
      }
   }

   public final void savePass() {
      if (this.isCheck) {
         Rms.saveRMSInt("check", 1);
         Rms.saveRMSString("acc", this.tfUser.getText().toLowerCase().trim());
         Rms.saveRMSString("pass", this.tfPass.getText().toLowerCase().trim());
      } else {
         Rms.saveRMSInt("check", 2);
         Rms.saveRMSString("acc", "");
         Rms.saveRMSString("pass", "");
      }
   }

   public final void update() {
      if (k > 0) {
         GameCanvas.startWaitDlg();
         if ((m = System.currentTimeMillis()) - l >= 1000L) {
            if (--k == 0) {
               GameCanvas.loginScr.doLogin();
            }

            l = m;
         }
      }

      if (this.isLogin2 && !this.isRes) {
         this.tfUser.name = (mResources.language == 2 ? "" : mResources.phone + "/") + mResources.email;
         this.tfPass.name = mResources.password;
         this.tfUser.isPaintCarret = false;
         this.tfPass.isPaintCarret = false;
         this.tfUser.update();
         this.tfPass.update();
      } else {
         this.tfUser.name = (mResources.language == 2 ? "" : mResources.phone + "/") + mResources.email;
         this.tfPass.name = mResources.password;
         this.tfUser.update();
         this.tfPass.update();
      }

      for(int var1 = 0; var1 < Effect2.vEffect2.size(); ++var1) {
         ((Effect2)Effect2.vEffect2.elementAt(var1)).update();
      }

      if (d && !e && !h && !f && !g) {
         d = false;
         System.gc();
         Service.gI().finishUpdate();
      }

      if (++GameScr.cmx > GameCanvas.z * 3 + 100) {
         GameScr.cmx = 100;
      }

      if (ChatPopup.currChatPopup == null) {
         if (this.r != this.q) {
            this.q += this.r - this.q >> 1;
         }

         if (this.G >= 0) {
            this.H += this.I * this.G;
            this.G += this.I * this.F;
            if (this.G <= 0) {
               this.I = -this.I;
            }

            if (this.H > 0) {
               this.I = -this.I;
               this.G -= 2 * this.F;
            }
         }

         if (this.E >= 0 && GameCanvas.v % 100 == 0) {
            ++this.E;
            if (this.E >= mResources.aX.length) {
               this.E = 0;
            }

            if (GameCanvas.currentDialog == GameCanvas.msgdlg && GameCanvas.msgdlg.a) {
               GameCanvas.msgdlg.a(mResources.aX[this.E]);
            }
         }

         if (this.isLogin2 && !this.isRes) {
            this.tfUser.isPaintCarret = false;
            this.tfPass.isPaintCarret = false;
            this.tfUser.update();
            this.tfPass.update();
         } else {
            this.tfUser.name = (mResources.language == 2 ? "" : mResources.phone + "/") + mResources.email;
            this.tfPass.name = mResources.password;
            this.tfUser.update();
            this.tfPass.update();
         }

         if (GameCanvas.isTouch) {
            if (this.isRes) {
               super.center = this.w;
               super.left = this.y;
            } else {
               super.center = this.A;
               super.left = this.v;
            }
         } else if (this.isRes) {
            super.center = this.w;
            super.left = this.y;
         } else {
            super.center = this.A;
            super.left = this.v;
         }
      }
   }

   public final void keyPress(int var1) {
      if (this.tfUser.isFocus) {
         this.tfUser.keyPress(var1);
      } else if (this.tfPass.isFocus) {
         this.tfPass.keyPress(var1);
      }

      super.keyPress(var1);
   }

   public final void paint(mGraphics graphics) {
      GameCanvas.paintBackground(graphics);
      int var2 = this.tfUser.b - 50;
      if (GameCanvas.A <= 220) {
         var2 += 5;
      }

      mFont.s.drawString(graphics, "v2.3.7", GameCanvas.z - 2, 17, 1, mFont.o);
      if (mSystem.d == 1 && !GameCanvas.isTouch) {
         mFont.s.drawString(graphics, ServerListScreen.j, GameCanvas.z - 2, GameCanvas.A - 15, 1, mFont.o);
      } else {
         mFont.s.drawString(graphics, ServerListScreen.j, GameCanvas.z - 2, 2, 1, mFont.o);
      }

      if (ChatPopup.currChatPopup == null) {
         if (ChatPopup.serverChatPopUp == null) {
            if (GameCanvas.currentDialog == null) {
               int var3 = GameCanvas.z >= 200 ? 180 : 160;
               PopUp.paintPopUp(graphics, this.B, this.yLog - 10, var3, 105, -1, true);
               if (GameCanvas.A > 160 && j != null) {
                  graphics.drawImage(j, GameCanvas.B, var2, 3);
               }

               short var4 = 184;
               if (184 >= GameCanvas.z) {
                  var4 = 152;
               }

               this.B = GameCanvas.z / 2 - var4 / 2;
               this.tfUser.a = this.B + 10;
               this.tfUser.b = this.yLog + 20;
               this.tfPass.a = this.B + 10;
               this.tfPass.b = this.yLog + 55;
               this.tfUser.paint(graphics);
               this.tfPass.paint(graphics);
               if (GameCanvas.z < 176) {
                  mFont.g.drawStringBd(graphics, mResources.acc + ":", this.tfUser.a - 35, this.tfUser.b + 7, 0);
                  mFont.g.drawStringBd(graphics, mResources.pwd + ":", this.tfPass.a - 35, this.tfPass.b + 7, 0);
                  mFont.g.drawStringBd(graphics, mResources.server + ": " + serverName, GameCanvas.z / 2, this.tfPass.b + 32, 2);
               }
            }

            super.paint(graphics);
         }
      }
   }

   public final void updateKey() {
      if (GameCanvas.isTouch && this.cmdCallHotline != null && this.cmdCallHotline.isPointerPressInside()) {
         this.cmdCallHotline.performAction();
      }

      if (!c) {
         if (!GameCanvas.isTouch) {
            if (this.tfUser.isFocus) {
               super.cb = this.tfUser.j;
            } else {
               super.cb = this.tfPass.j;
            }
         }

         if (GameCanvas.keyPressed[2]) {
            --this.focus;
            if (this.focus < 0) {
               this.focus = 1;
            }
         } else if (GameCanvas.keyPressed[8]) {
            ++this.focus;
            if (this.focus > 1) {
               this.focus = 1;
            }
         }

         if (GameCanvas.keyPressed[2] || GameCanvas.keyPressed[8]) {
            GameCanvas.clearKeyPressed();
            if (!this.isLogin2 || this.isRes) {
               if (this.focus == 1) {
                  this.tfUser.isFocus = false;
                  this.tfPass.isFocus = true;
               } else if (this.focus == 0) {
                  this.tfUser.isFocus = true;
                  this.tfPass.isFocus = false;
               } else {
                  this.tfUser.isFocus = false;
                  this.tfPass.isFocus = false;
               }
            }
         }

         if (GameCanvas.isTouch) {
            if (this.isRes) {
               super.center = this.w;
               super.left = this.y;
            } else {
               super.center = this.A;
               super.left = this.v;
            }
         } else if (this.isRes) {
            super.center = this.w;
            super.left = this.y;
         } else {
            super.center = this.A;
            super.left = this.v;
         }

         if (GameCanvas.m && (!this.isLogin2 || this.isRes)) {
            if (GameCanvas.isPointerHoldIn(this.tfUser.a, this.tfUser.b, this.tfUser.width, this.tfUser.height)) {
               this.focus = 0;
            } else if (GameCanvas.isPointerHoldIn(this.tfPass.a, this.tfPass.b, this.tfPass.width, this.tfPass.height)) {
               this.focus = 1;
            }
         }

         super.updateKey();
         GameCanvas.clearKeyPressed();
      }
   }

   public final void perform(int var1, Object var2) {
      String var9;
      switch(var1) {
      case 13:
         switch(mSystem.d) {
         case 1:
            mSystem.b();
            return;
         case 2:
         case 4:
         default:
            return;
         case 3:
         case 5:
            return;
         case 6:
            return;
         }
      case 1000:
         try {
            GameMidlet.instance.platformRequest((String)var2);
         } catch (Exception var5) {
            var5.printStackTrace();
         }

         GameCanvas.endDlg();
         return;
      case 1001:
         GameCanvas.endDlg();
         this.isRes = false;
         return;
      case 1002:
         GameCanvas.startWaitDlg();
         String var8;
         if ((var8 = Rms.loadRMSString("userAo" + ServerListScreen.ipSelect)) != null && !var8.equals("")) {
            GameCanvas.loginScr.isLogin2 = true;
            GameCanvas.connect();
            Service.gI().setClientType();
            Service.gI().login(var8, "", "2.3.7", (byte)1);
            return;
         }

         Service.gI().f("");
         return;
      case 1003:
         GameCanvas.startOKDlg(mResources.am);
         return;
      case 1004:
         ServerListScreen.doUpdateServer();
         GameCanvas.serverScreen.switchToMe();
         return;
      case 1005:
         try {
            GameMidlet.instance.platformRequest("http://ngocrongonline.com");
            return;
         } catch (Exception var4) {
            var4.printStackTrace();
            return;
         }
      case 2000:
         return;
      case 2001:
         if (this.isCheck) {
            this.isCheck = false;
            return;
         }

         this.isCheck = true;
         return;
      case 2002:
         LoginScr var7 = this;
         if (this.tfUser.getText().equals("")) {
            GameCanvas.startOKDlg(mResources.U);
         } else {
            this.tfUser.getText().toCharArray();
            if (this.tfPass.getText().equals("")) {
               GameCanvas.startOKDlg(mResources.V);
            } else {
               if (this.tfUser.getText().length() >= 5) {
                  var9 = null;
                  boolean var3;
                  if (mResources.language == 2) {
                     if (this.tfUser.getText().indexOf("@") == -1 || this.tfUser.getText().indexOf(".") == -1) {
                        var9 = mResources.Y;
                     }

                     var3 = false;
                  } else {
                     try {
                        Long.parseLong(var7.tfUser.getText());
                        if (var7.tfUser.getText().length() < 8 || var7.tfUser.getText().length() > 12 || !var7.tfUser.getText().startsWith("0") && !var7.tfUser.getText().startsWith("84")) {
                           var9 = mResources.X;
                        }

                        var3 = true;
                     } catch (Exception var6) {
                        if (this.tfUser.getText().indexOf("@") == -1 || this.tfUser.getText().indexOf(".") == -1) {
                           var9 = mResources.Y;
                        }

                        var3 = false;
                     }
                  }

                  if (var9 != null) {
                     GameCanvas.startOKDlg(var9);
                  } else {
                     GameCanvas.msgdlg.setInfo(mResources.ah + (var3 ? mResources.phone + ": " : mResources.email + ": ") + this.tfUser.getText() + "\n" + mResources.password + ": " + this.tfPass.getText(), new CommandLine(mResources.bt, this, 4000, (Object)null), (CommandLine)null, new CommandLine(mResources.bn, GameCanvas.h, 8882, (Object)null));
                  }

                  GameCanvas.currentDialog = GameCanvas.msgdlg;
                  return;
               }

               GameCanvas.startOKDlg(mResources.W);
            }
         }
         break;
      case 2003:
         MyVector var10;
         (var10 = new MyVector("vMenu Login")).addElement(new CommandLine(mResources.Z, this, 2004, (Object)null));
         if (!this.isLogin2) {
            var10.addElement(new CommandLine(mResources.aa, this, 1004, (Object)null));
         }

         var10.addElement(new CommandLine(mResources.ab, this, 1003, (Object)null));
         var10.addElement(new CommandLine(mResources.aH, this, 1005, (Object)null));
         if (Rms.loadRMSInt("lowGraphic") == 1) {
            var10.addElement(new CommandLine(mResources.bU, this, 10041, (Object)null));
         } else {
            var10.addElement(new CommandLine(mResources.bV, this, 10042, (Object)null));
         }

         var10.addElement(new CommandLine(mResources.bo, GameCanvas.h, 8885, (Object)null));
         GameCanvas.menu.startAt(var10);
         return;
      case 2004:
         this.endDlg();
         return;
      case 2008:
         Rms.saveRMSString("acc", this.tfUser.getText().trim());
         Rms.saveRMSString("pass", this.tfPass.getText().trim());
         if (ServerListScreen.loadScreen) {
            GameCanvas.serverScreen.switchToMe();
            return;
         }

         GameCanvas.serverScreen.show2();
         return;
      case 4000:
         var9 = this.tfUser.getText();
         GameCanvas.startWaitDlg(mResources.aB);
         GameCanvas.connect();
         GameCanvas.startWaitDlg(mResources.J);
         Service var10000 = Service.gI();
         String var10002 = this.tfPass.getText();
         String var10003 = Rms.loadRMSString("userAo" + ServerListScreen.ipSelect);
         Rms.loadRMSString("passAo");
         var10000.requestRegister(var9, var10002, var10003, "2.3.7");
         Rms.saveRMSString("acc", var9);
         Rms.saveRMSString("pass", this.tfPass.getText());
         break;
      case 10021:
         this.actRegisterLeft();
         return;
      case 10041:
         Rms.saveRMSInt("lowGraphic", 0);
         GameCanvas.startOK(mResources.cL, 8885, (Object)null);
         return;
      case 10042:
         Rms.saveRMSInt("lowGraphic", 1);
         GameCanvas.startOK(mResources.cL, 8885, (Object)null);
         return;
      }

   }

   private void actRegisterLeft() {
      if (this.isLogin2) {
         this.doLogin();
      } else {
         this.isRes = false;
         this.tfPass.isFocus = false;
         this.tfUser.isFocus = true;
         super.left = this.x;
      }
   }

   public final void endDlg() {
      GameCanvas.endDlg();
      GameCanvas.startOKDlg(mResources.fT);
      this.isRes = true;
      this.tfPass.isFocus = false;
      this.tfUser.isFocus = true;
   }

   public static void backToRegister() {
      GameCanvas.ag = mSystem.currentTimeMillis() + 30000L;
      ServerListScreen.k = 0;
      if (GameCanvas.loginScr.isLogin2) {
         GameCanvas.startYesNoDlg(mResources.fS, new CommandLine(mResources.bm, GameCanvas.panel, 10019, (Object)null), new CommandLine(mResources.bn, GameCanvas.panel, 10020, (Object)null));
      } else {
         GameCanvas.doResetToLoginScr((mScreen)GameCanvas.loginScr);
      }
   }
}
