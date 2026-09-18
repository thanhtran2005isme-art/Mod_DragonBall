package nro;

import main.GameMidlet;

public final class RegisterScreen extends mScreen implements IActionListener {
   private TField tfUser;
   private TField tfNgay;
   private TField tfThang;
   private TField tfNam;
   private TField tfDiachi;
   private TField tfCMND;
   private TField tfNgayCap;
   private TField tfNoiCap;
   private TField tfSodt;
   private static boolean isContinueToLogin = false;
   private int k;
   private int l;
   private int m;
   private boolean n = false;
   private boolean o = false;
   private CommandLine cmdLogin;
   private CommandLine cmdFogetPass;
   private CommandLine cmdRes;
   private CommandLine cmdMenu;
   private CommandLine cmdBackFromRegister;
   private int u;
   private CommandLine cmdOK;
   private int w;
   private int x = 130;
   private int y;
   private int z = -1;
   private boolean A = false;
   private int B = 2;
   private int C = 0;
   private int D = -40;
   private int E = 1;

   static {
      int[] var10000 = new int[]{0, 8, 2, 6, 9};
   }

   public final void switchToMe() {
      System.out.println("Res switch");
      SoundMn.stopAll();
      this.tfUser.isFocus = true;
      this.tfNgay.isFocus = false;
      if (main.GameCanvas.isTouch) {
         this.tfUser.isFocus = false;
      }

      super.switchToMe();
   }

   public RegisterScreen(byte var1) {
      if ((TileMap.bgID = (byte)((int)(System.currentTimeMillis() % 9L))) == 5 || TileMap.bgID == 6) {
         TileMap.bgID = 4;
      }

      GameScr.loadCamera(-1, (int)-1);
      GameScr.cmx = 100;
      GameScr.cmy = 200;
      if (main.GameCanvas.A > 200) {
         this.m = main.GameCanvas.hh - 80;
      } else {
         this.m = main.GameCanvas.hh - 65;
      }

      this.l = -50;
      this.u = main.GameCanvas.hh - mScreen.ITEM_HEIGHT - 5;
      if (main.GameCanvas.A <= 160) {
         this.u = 20;
      }

      this.tfSodt = new TField();
      this.tfSodt.setIputType(1);
      this.tfSodt.width = 220;
      this.tfSodt.height = mScreen.ITEM_HEIGHT + 2;
      this.tfSodt.name = "Số điện thoại/ địa chỉ email";
      if (var1 == 1) {
         this.tfSodt.setText("01234567890");
      }

      this.tfUser = new TField();
      this.tfUser.width = 220;
      this.tfUser.height = mScreen.ITEM_HEIGHT + 2;
      this.tfUser.isFocus = true;
      this.tfUser.name = "Họ và tên";
      if (var1 == 1) {
         this.tfUser.setText("Nguyễn Văn A");
      }

      this.tfUser.setIputType(0);
      this.tfNgay = new TField();
      this.tfNgay.setIputType(1);
      this.tfNgay.width = 70;
      this.tfNgay.height = mScreen.ITEM_HEIGHT + 2;
      this.tfNgay.name = "Ngày sinh";
      if (var1 == 1) {
         this.tfNgay.setText("01");
      }

      this.tfThang = new TField();
      this.tfThang.setIputType(1);
      this.tfThang.width = 70;
      this.tfThang.height = mScreen.ITEM_HEIGHT + 2;
      this.tfThang.name = "Tháng sinh";
      if (var1 == 1) {
         this.tfThang.setText("01");
      }

      this.tfNam = new TField();
      this.tfNam.setIputType(1);
      this.tfNam.width = 70;
      this.tfNam.height = mScreen.ITEM_HEIGHT + 2;
      this.tfNam.name = "Năm sinh";
      if (var1 == 1) {
         this.tfNam.setText("1980");
      }

      this.tfDiachi = new TField();
      this.tfDiachi.setIputType(0);
      this.tfDiachi.width = 220;
      this.tfDiachi.height = mScreen.ITEM_HEIGHT + 2;
      this.tfDiachi.name = "Địa chỉ đăng ký thường trú";
      if (var1 == 1) {
         this.tfDiachi.setText("123 đường số 1, Quận 1, TP.HCM");
      }

      this.tfCMND = new TField();
      this.tfCMND.setIputType(1);
      this.tfCMND.width = 220;
      this.tfCMND.height = mScreen.ITEM_HEIGHT + 2;
      this.tfCMND.name = "Số Chứng minh nhân dân hoặc số hộ chiếu";
      if (var1 == 1) {
         this.tfCMND.setText("123456789");
      }

      this.tfNgayCap = new TField();
      this.tfNgayCap.setIputType(1);
      this.tfNgayCap.width = 220;
      this.tfNgayCap.height = mScreen.ITEM_HEIGHT + 2;
      this.tfNgayCap.name = "Ngày cấp";
      if (var1 == 1) {
         this.tfNgayCap.setText("01/01/1990");
      }

      this.tfNoiCap = new TField();
      this.tfNoiCap.setIputType(0);
      this.tfNoiCap.width = 220;
      this.tfNoiCap.height = mScreen.ITEM_HEIGHT + 2;
      this.tfNoiCap.name = "Nơi cấp";
      if (var1 == 1) {
         this.tfNoiCap.setText("TP.HCM");
      }

      this.u += 35;
      this.n = true;
      this.k = 0;
      this.cmdLogin = new CommandLine(main.GameCanvas.z > 200 ? mResources.aw : mResources.ax, main.GameCanvas.h, 888393, (Object)null);
      new CommandLine(mResources.bs, this, 2001, (Object)null);
      this.cmdRes = new CommandLine(mResources.ay, this, 2002, (Object)null);
      this.cmdBackFromRegister = new CommandLine(mResources.bu, this, 10021, (Object)null);
      super.left = this.cmdMenu = new CommandLine(mResources.bh, this, 2003, (Object)null);
      if (main.GameCanvas.isTouch) {
         this.cmdLogin.x = main.GameCanvas.z / 2 - 100;
         this.cmdMenu.x = main.GameCanvas.z / 2 - mScreen.cd - 8;
         if (main.GameCanvas.A >= 200) {
            this.cmdLogin.y = main.GameCanvas.A / 2 - 40;
            this.cmdMenu.y = this.x + 110;
         }

         this.cmdBackFromRegister.x = main.GameCanvas.z / 2 + 3;
         this.cmdBackFromRegister.y = this.x + 110;
         this.cmdRes.x = main.GameCanvas.z / 2 - 84;
         this.cmdRes.y = this.cmdMenu.y;
      }

      this.y = 170;
      short var3 = 184;
      if (184 >= main.GameCanvas.z) {
         var3 = 152;
      }

      this.w = main.GameCanvas.z / 2 - var3 / 2;
      this.x = 5;
      this.tfUser.a = this.w + 10;
      this.tfUser.b = this.x + 20;
      this.cmdOK = new CommandLine(mResources.OK, this, 2008, (Object)null);
      this.cmdOK.x = 260;
      this.cmdOK.y = main.GameCanvas.A - 60;
      this.cmdFogetPass = new CommandLine("Thoát", this, 1003, (Object)null);
      this.cmdFogetPass.x = 260;
      this.cmdFogetPass.y = main.GameCanvas.A - 30;
      if (main.GameCanvas.z < 250) {
         this.cmdOK.x = main.GameCanvas.z / 2 - 80;
         this.cmdFogetPass.x = main.GameCanvas.z / 2 + 10;
         this.cmdFogetPass.y = this.cmdOK.y = main.GameCanvas.A - 25;
      }

      super.center = this.cmdOK;
      super.left = this.cmdFogetPass;
   }

   public final void update() {
      this.tfUser.update();
      this.tfNgay.update();
      this.tfThang.update();
      this.tfNam.update();
      this.tfDiachi.update();
      this.tfCMND.update();
      this.tfNoiCap.update();
      this.tfSodt.update();
      this.tfNgayCap.update();

      for(int var1 = 0; var1 < Effect2.vEffect2.size(); ++var1) {
         ((Effect2)Effect2.vEffect2.elementAt(var1)).update();
      }

      if (++GameScr.cmx > main.GameCanvas.z * 3 + 100) {
         GameScr.cmx = 100;
      }

      if (ChatPopup.currChatPopup == null) {
         if (this.m != this.l) {
            this.l += this.m - this.l >> 1;
         }

         if (this.C >= 0) {
            this.D += this.E * this.C;
            this.C += this.E * this.B;
            if (this.C <= 0) {
               this.E = -this.E;
            }

            if (this.D > 0) {
               this.E = -this.E;
               this.C -= 2 * this.B;
            }
         }

         if (this.z >= 0 && main.GameCanvas.v % 100 == 0) {
            ++this.z;
            if (this.z >= mResources.aX.length) {
               this.z = 0;
            }

            if (main.GameCanvas.currentDialog == main.GameCanvas.msgdlg && main.GameCanvas.msgdlg.a) {
               main.GameCanvas.msgdlg.a(mResources.aX[this.z]);
            }
         }

         if (main.GameCanvas.isTouch) {
            if (this.o) {
               super.center = this.cmdRes;
               super.left = this.cmdBackFromRegister;
            } else {
               super.center = this.cmdOK;
               super.left = this.cmdFogetPass;
            }
         } else if (this.o) {
            super.center = this.cmdRes;
            super.left = this.cmdBackFromRegister;
         } else {
            super.center = this.cmdOK;
            super.left = this.cmdFogetPass;
         }
      }
   }

   public final void keyPress(int var1) {
      if (this.tfUser.isFocus) {
         this.tfUser.keyPress(var1);
      } else if (this.tfNgay.isFocus) {
         this.tfNgay.keyPress(var1);
      }

      super.keyPress(var1);
   }

   public final void paint(mGraphics var1) {
      main.GameCanvas.paintBackground(var1);
      if (ChatPopup.currChatPopup == null) {
         if (ChatPopup.serverChatPopUp == null) {
            if (main.GameCanvas.currentDialog == null) {
               this.w = 5;
               if (main.GameCanvas.z < 260) {
                  this.w = (main.GameCanvas.z - 240) / 2;
               }

               this.x = (main.GameCanvas.A - 233) / 2;
               PopUp.paintPopUp(var1, this.w, this.x, 240, 233, -1, true);
               this.tfSodt.a = this.w + 10;
               this.tfSodt.b = this.x + 15;
               this.tfUser.a = this.tfSodt.a;
               this.tfUser.b = this.tfSodt.b + 30;
               this.tfNgay.a = this.w + 10;
               this.tfNgay.b = this.tfUser.b + 30;
               this.tfThang.a = this.tfNgay.a + 75;
               this.tfThang.b = this.tfNgay.b;
               this.tfNam.a = this.tfThang.a + 75;
               this.tfNam.b = this.tfThang.b;
               this.tfDiachi.a = this.tfUser.a;
               this.tfDiachi.b = this.tfNgay.b + 30;
               this.tfCMND.a = this.tfUser.a;
               this.tfCMND.b = this.tfDiachi.b + 30;
               this.tfNgayCap.a = this.tfUser.a;
               this.tfNgayCap.b = this.tfCMND.b + 30;
               this.tfNoiCap.a = this.tfUser.a;
               this.tfNoiCap.b = this.tfNgayCap.b + 30;
               this.tfUser.paint(var1);
               this.tfNgay.paint(var1);
               this.tfThang.paint(var1);
               this.tfNam.paint(var1);
               this.tfDiachi.paint(var1);
               this.tfCMND.paint(var1);
               this.tfNgayCap.paint(var1);
               this.tfNoiCap.paint(var1);
               this.tfSodt.paint(var1);
               if (main.GameCanvas.z < 176) {
                  mFont.g.drawStringBd(var1, mResources.acc + ":", this.tfUser.a - 35, this.tfUser.b + 7, 0);
                  mFont.g.drawStringBd(var1, mResources.pwd + ":", this.tfNgay.a - 35, this.tfNgay.b + 7, 0);
                  mFont.g.drawStringBd(var1, mResources.server + ": " + null, main.GameCanvas.z / 2, this.tfNgay.b + 32, 2);
               }
            }

            String var2 = "2.3.7";
            var1.setColor(main.GameCanvas.O);
            var1.fillRect(main.GameCanvas.z - 40, 4, 36, 11);
            mFont.o.drawStringBd(var1, var2, main.GameCanvas.z - 22, 4, 2);
            main.GameCanvas.a(var1);
            if (main.GameCanvas.currentDialog == null) {
               if (main.GameCanvas.z > 250) {
                  mFont.c.drawString(var1, "Dưới 18 tuổi", 260, 10, 0, mFont.tahoma_7b_dark);
                  mFont.c.drawString(var1, "chỉ có thể chơi", 260, 25, 0, mFont.tahoma_7b_dark);
                  mFont.c.drawString(var1, "180p 1 ngày", 260, 40, 0, mFont.tahoma_7b_dark);
               } else {
                  mFont.c.drawString(var1, "Dưới 18 tuổi chỉ có thể chơi", main.GameCanvas.z / 2, 5, 2, mFont.tahoma_7b_dark);
                  mFont.c.drawString(var1, "180p 1 ngày", main.GameCanvas.z / 2, 15, 2, mFont.tahoma_7b_dark);
               }
            }

            super.paint(var1);
         }
      }
   }

   public final void updateKey() {
      if (!main.GameCanvas.isTouch) {
         if (this.tfUser.isFocus) {
            super.cb = this.tfUser.j;
         } else {
            super.cb = this.tfNgay.j;
         }
      }

      if (main.GameCanvas.keyPressed[2]) {
         --this.k;
         if (this.k < 0) {
            this.k = 1;
         }
      } else if (main.GameCanvas.keyPressed[8]) {
         ++this.k;
         if (this.k > 1) {
            this.k = 1;
         }
      }

      if (main.GameCanvas.keyPressed[2] || main.GameCanvas.keyPressed[8]) {
         main.GameCanvas.clearKeyPressed();
         if (this.k == 1) {
            this.tfUser.isFocus = false;
            this.tfNgay.isFocus = true;
         } else if (this.k == 0) {
            this.tfUser.isFocus = true;
            this.tfNgay.isFocus = false;
         } else {
            this.tfUser.isFocus = false;
            this.tfNgay.isFocus = false;
         }
      }

      if (main.GameCanvas.isTouch) {
         if (this.o) {
            super.center = this.cmdRes;
            super.left = this.cmdBackFromRegister;
         } else {
            super.center = this.cmdOK;
            super.left = this.cmdFogetPass;
         }
      } else if (this.o) {
         super.center = this.cmdRes;
         super.left = this.cmdBackFromRegister;
      } else {
         super.center = this.cmdOK;
         super.left = this.cmdFogetPass;
      }

      if (main.GameCanvas.m) {
         if (main.GameCanvas.isPointerHoldIn(this.tfUser.a, this.tfUser.b, this.tfUser.width, this.tfUser.height)) {
            this.k = 0;
         } else if (main.GameCanvas.isPointerHoldIn(this.tfNgay.a, this.tfNgay.b, this.tfNgay.width, this.tfNgay.height)) {
            this.k = 1;
         }
      }

      super.updateKey();
      main.GameCanvas.clearKeyPressed();
   }

   public final void perform(int var1, Object var2) {
      switch(var1) {
      case 1000:
         try {
            GameMidlet.instance.platformRequest((String)var2);
         } catch (Exception var5) {
            var5.printStackTrace();
         }

         main.GameCanvas.endDlg();
         return;
      case 1001:
         main.GameCanvas.endDlg();
         this.o = false;
         return;
      case 1002:
         return;
      case 1003:
         main.GameCanvas.serverScreen.switchToMe();
         Session_ME2.Session_ME().close();
         return;
      case 1004:
         ServerListScreen.doUpdateServer();
         main.GameCanvas.serverScreen.switchToMe();
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
         if (this.n) {
            this.n = false;
            return;
         }

         this.n = true;
         return;
      case 2002:
         RegisterScreen var7 = this;
         if (this.tfUser.getText().equals("")) {
            main.GameCanvas.startOKDlg(mResources.U);
         } else {
            this.tfUser.getText().toCharArray();
            if (this.tfNgay.getText().equals("")) {
               main.GameCanvas.startOKDlg(mResources.V);
            } else {
               if (this.tfUser.getText().length() >= 5) {
                  String var9 = null;
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
                     main.GameCanvas.startOKDlg(var9);
                  } else {
                     main.GameCanvas.msgdlg.setInfo(mResources.ah + (var3 ? mResources.phone + ": " : mResources.email + ": ") + this.tfUser.getText() + "\n" + mResources.password + ": " + this.tfNgay.getText(), new CommandLine(mResources.bt, this, 4000, (Object)null), (CommandLine)null, new CommandLine(mResources.bn, main.GameCanvas.h, 8882, (Object)null));
                  }

                  main.GameCanvas.currentDialog = main.GameCanvas.msgdlg;
                  return;
               }

               main.GameCanvas.startOKDlg(mResources.W);
            }
         }
         break;
      case 2003:
         MyVector var8;
         (var8 = new MyVector("vMenu Login")).addElement(new CommandLine(mResources.Z, this, 2004, (Object)null));
         var8.addElement(new CommandLine(mResources.aa, this, 1004, (Object)null));
         var8.addElement(new CommandLine(mResources.ab, this, 1003, (Object)null));
         var8.addElement(new CommandLine(mResources.aH, this, 1005, (Object)null));
         if (Rms.loadRMSInt("lowGraphic") == 1) {
            var8.addElement(new CommandLine(mResources.bU, this, 10041, (Object)null));
         } else {
            var8.addElement(new CommandLine(mResources.bV, this, 10042, (Object)null));
         }

         var8.addElement(new CommandLine(mResources.bo, main.GameCanvas.h, 8885, (Object)null));
         main.GameCanvas.menu.startAt(var8);
         return;
      case 2004:
         main.GameCanvas.endDlg();
         main.GameCanvas.startOKDlg(mResources.fT);
         this.o = true;
         this.tfNgay.isFocus = false;
         this.tfUser.isFocus = true;
         return;
      case 2008:
         if (this.tfNgay.getText().equals("") || this.tfThang.getText().equals("") || this.tfNam.getText().equals("") || this.tfDiachi.getText().equals("") || this.tfCMND.getText().equals("") || this.tfNgayCap.getText().equals("") || this.tfNoiCap.getText().equals("") || this.tfSodt.getText().equals("") || this.tfUser.getText().equals("")) {
            main.GameCanvas.startOKDlg("Vui lòng điền đầy đủ thông tin");
            return;
         }

         main.GameCanvas.startOKDlg(mResources.aA);
         Service.gI().a(this.tfNgay.getText(), this.tfThang.getText(), this.tfNam.getText(), this.tfDiachi.getText(), this.tfCMND.getText(), this.tfNgayCap.getText(), this.tfNoiCap.getText(), this.tfSodt.getText(), this.tfUser.getText());
      case 4000:
      default:
         break;
      case 10021:
         this.o = false;
         this.tfNgay.isFocus = false;
         this.tfUser.isFocus = true;
         super.left = this.cmdMenu;
         return;
      case 10041:
         return;
      case 10042:
         return;
      }

   }
}
