package nro;

import javax.microedition.lcdui.Image;
import main.GameMidlet;

public final class ChatPopup extends Effect2 implements IActionListener {
   public int a = 100;
   public int b;
   public int c;
   public String[] d;
   public int e;
   public int f;
   public int g;
   public int h;
   public Npc i;
   private static long B;
   private static long C;
   private int D;
   private String[] E;
   public CommandLine j;
   public CommandLine k;
   public CommandLine l;
   public static ChatPopup currChatPopup;
   public static ChatPopup serverChatPopUp;
   private static String F;
   private static Npc G;
   public byte o = 0;
   public byte p = 0;
   public static nr_ds q;
   private static boolean H;
   private int I;
   private static int J;
   private int K;
   public static int r = 7;
   private int L = 0;
   private int M = 0;
   private int N = 0;
   private Image O;
   public int s;
   public boolean t = false;
   public static int u;
   private int P = 0;
   private int Q = 0;

   public static void a(String var0, Npc var1) {
      F = var0;
      G = var1;
      if (currChatPopup == null) {
         b(F, 100000, G);
         F = null;
         G = null;
      }

   }

   public static void a(String var0, int var1, Npc var2) {
      String[] var3 = new String[]{var0};
      if (var2.charID != 5 && GameScr.info1.e) {
         GameScr.info1.f = false;
      }

      Char.bH = true;
      (serverChatPopUp = c(var3[0], 100000, var2)).s = 5;
      serverChatPopUp.e = main.GameCanvas.z / 2 - serverChatPopUp.a / 2 - 1;
      serverChatPopUp.f = main.GameCanvas.A - 20 - serverChatPopUp.g;
      serverChatPopUp.D = 0;
      serverChatPopUp.E = var3;
      q = new nr_ds();
      int var4 = serverChatPopUp.d.length;
      q.a(var4, 12, serverChatPopUp.e, serverChatPopUp.f - serverChatPopUp.s + 12, serverChatPopUp.a + 2, serverChatPopUp.g - 25, true, 1);
      SoundMn.stopAll();
   }

   public static void b(String var0, int var1, Npc var2) {
      ResLog.c("chat= " + var0);
      String[] var3 = ResLog.a(var0, "\n", 0);
      Char.bH = true;
      (currChatPopup = c(var3[0], 100000, var2)).D = 0;
      currChatPopup.E = var3;
      String var4 = mResources.bk;
      if (var3.length == 1) {
         var4 = mResources.CLOSE;
      }

      currChatPopup.j = new CommandLine(var4, currChatPopup, 8000, (Object)null);
      currChatPopup.j.x = main.GameCanvas.z / 2 - 35;
      currChatPopup.j.y = main.GameCanvas.A - 35;
      SoundMn.stopAll();
   }

   public static ChatPopup c(String var0, int var1, Npc var2) {
      ResLog.c("ADD POP");
      ResLog.c(Char.myCharz().aT != null ? "!null" : "null");
      J = 10;
      ChatPopup var3;
      (var3 = new ChatPopup()).a = main.GameCanvas.z - 30 - (main.GameCanvas.menu.a ? main.GameCanvas.menu.c : 0);
      if (var3.a > 320) {
         var3.a = 320;
      }

      if (var0.length() < 10) {
         var3.a = 64;
      }

      if (main.GameCanvas.z == 128) {
         var3.a = 128;
      }

      var3.d = mFont.p.getWidth(var0, var3.a - 10);
      var3.b = var1;
      var3.i = var2;
      Char.x = var3;
      var3.g = 15 - var3.c + var3.d.length * 12 + 10;
      if (var3.g > main.GameCanvas.A - 80) {
         var3.g = main.GameCanvas.A - 80;
      }

      Effect2.vEffect2.addElement(var3);
      H = false;
      if (var2 != null && var2.charID == 5) {
         H = true;
         GameScr.info1.a("", 1);
      }

      B = C = mSystem.currentTimeMillis();
      return var3;
   }

   public static ChatPopup a(String var0, int var1, Npc var2, int var3) {
      ResLog.c("ADD POP");
      ResLog.c(Char.myCharz().aT != null ? "!null" : "null");
      J = 10;
      ChatPopup var4;
      (var4 = new ChatPopup()).a = main.GameCanvas.z - 30 - (main.GameCanvas.menu.a ? main.GameCanvas.menu.c : 0);
      if (var4.a > 320) {
         var4.a = 320;
      }

      if (var0.length() < 10) {
         var4.a = 64;
      }

      if (main.GameCanvas.z == 128) {
         var4.a = 128;
      }

      var4.d = mFont.p.getWidth(var0, var4.a - 10);
      var4.b = 100000;
      var4.i = var2;
      var4.I = 5820;
      Char.x = var4;
      var4.g = 15 - var4.c + var4.d.length * 12 + 10;
      if (var4.g > main.GameCanvas.A - 80) {
         var4.g = main.GameCanvas.A - 80;
      }

      Effect2.vEffect2.addElement(var4);
      H = false;
      if (var2 != null && var2.charID == 5) {
         H = true;
         GameScr.info1.a("", 1);
      }

      var4.g += 15;
      B = C = mSystem.currentTimeMillis();
      return var4;
   }

   public final void update() {
      if (q != null) {
         GameScr.info1.f = false;
         q.b();
      } else {
         GameScr.info1.f = true;
      }

      if (main.GameCanvas.menu.a) {
         this.s = 0;
         this.e = main.GameCanvas.z / 2 - this.a / 2 - 1;
         this.f = main.GameCanvas.menu.d - this.g;
      } else {
         this.s = 0;
         if (GameScr.gI().cb == null && GameScr.gI().left == null && GameScr.gI().center == null && this.j == null && this.k == null) {
            this.e = main.GameCanvas.z / 2 - this.a / 2 - 1;
            this.f = main.GameCanvas.A - 5 - this.g;
         } else {
            this.s = 5;
            this.e = main.GameCanvas.z / 2 - this.a / 2 - 1;
            this.f = main.GameCanvas.A - 20 - this.g;
         }
      }

      if (this.b > 0) {
         --this.b;
      }

      if (J > 0) {
         --J;
      } else {
         GameScr.info1.b.e = 0;

         for(int var1 = 0; var1 < GameScr.info1.b.infoWaitToShow.size(); ++var1) {
            if (((InfoItem)GameScr.info1.b.infoWaitToShow.elementAt(var1)).b != 70) {
               ((InfoItem)GameScr.info1.b.infoWaitToShow.elementAt(var1)).b = 10;
            }
         }
      }

      if (this.c > 1) {
         --this.c;
      }

      if (this.i != null && Char.x != null && Char.x != this || this.i != null && Char.x == null || this.b <= 0) {
         Effect2.vEffect2Out.removeElement(this);
         Effect2.vEffect2.removeElement(this);
      }

   }

   public final void paint(mGraphics var1) {
      if (!GameScr.gI().bc || !GameScr.gI().aZ) {
         main.GameCanvas.a(var1);
         int var2 = this.e;
         int var3 = this.f;
         int var4 = this.a + 2;
         int var5 = this.g;
         if (var2 > 0 && var3 > 0 || main.GameCanvas.panel.isShow) {
            PopUp.paintPopUp(var1, var2, var3, var4, var5, 16777215, false);
            byte var6;
            if (this.i != null) {
               if (main.GameCanvas.v % 10 > 2) {
                  var6 = 0;
               } else {
                  var6 = 1;
               }

               SmallImage.b(var1, this.i.aO, this.e + 14, this.f + var6, 0, StaticObj.BOTTOM_LEFT);
            }

            if (this.I != 0) {
               if (main.GameCanvas.v % 10 > 2) {
                  var6 = 0;
               } else {
                  var6 = 1;
               }

               SmallImage.b(var1, this.I, this.e + var4 / 2, this.f + this.g - 15 + var6, 0, StaticObj.f);
            }

            if (q != null) {
               var1.e(var2, var3, var4, var5 - 16);
               var1.setColor(0, -q.d);
            }

            int var14 = 0;
            int var7 = 0;
            if (this.t) {
               var14 = var1.setColor();
               var7 = var1.b();
               var1.e(var2, var3 + 1, var4, var5 - 17);
               var1.setColor(0, -u);
            }

            int var8 = -1;

            int var9;
            for(var9 = 0; var9 < this.d.length; ++var9) {
               if (this.d[var9].startsWith("--")) {
                  var1.setColor(0);
                  var1.fillRect(var2 + 10, this.f + this.c + var9 * 12 + 6, var4 - 20, 1);
               } else {
                  mFont var10 = mFont.k;
                  int var11 = 2;
                  String var12 = this.d[var9];
                  int var16;
                  if (this.d[var9].startsWith("|")) {
                     String[] var13;
                     if ((var13 = ResLog.a(this.d[var9], "|", 0)).length == 3) {
                        var12 = var13[2];
                     }

                     if (var13.length == 4) {
                        var12 = var13[3];
                        var11 = Integer.parseInt(var13[2]);
                     }

                     var8 = var16 = Integer.parseInt(var13[1]);
                  } else {
                     var16 = var8;
                  }

                  switch(var16) {
                  case -1:
                     var10 = mFont.k;
                     break;
                  case 0:
                     var10 = mFont.tahoma_7b_dark;
                     break;
                  case 1:
                     var10 = mFont.h;
                     break;
                  case 2:
                     var10 = mFont.b;
                     break;
                  case 3:
                     var10 = mFont.p;
                     break;
                  case 4:
                     var10 = mFont.r;
                     break;
                  case 5:
                     var10 = mFont.q;
                  case 6:
                  default:
                     break;
                  case 7:
                     var10 = mFont.a;
                     break;
                  case 8:
                     var10 = mFont.d;
                     break;
                  case 9:
                     var10 = mFont.d;
                  }

                  if (this.d[var9].startsWith("<")) {
                     String[] var15 = ResLog.a(ResLog.a(this.d[var9], "<", 0)[1], ">", 1);
                     if (this.K == 0) {
                        this.K = Integer.parseInt(var15[1]);
                     } else if ((B = mSystem.currentTimeMillis()) - C >= 1000L) {
                        C = B;
                        --this.K;
                     }

                     var12 = this.K + " " + var15[2];
                     var10.drawStringBd(var1, var12, this.e + this.a / 2, this.f + this.c + var9 * 12 - this.s + 12, var11);
                  } else {
                     if (var11 == 2) {
                        var10.drawStringBd(var1, var12, this.e + this.a / 2, this.f + this.c + var9 * 12 - this.s + 12, var11);
                     }

                     if (var11 == 1) {
                        var10.drawStringBd(var1, var12, this.e + this.a - 5, this.f + this.c + var9 * 12 - this.s + 12, var11);
                     }
                  }
               }
            }

            if (this.t) {
               main.GameCanvas.a(var1);
               var1.setColor(var14, var7);
            }

            if (this.p > 4) {
               this.M = (this.p + 1) / 2;
               this.L = this.p - this.M;

               for(var9 = 0; var9 < this.M; ++var9) {
                  var1.drawImage(Panel.s, var2 + var4 / 2 - this.M * 20 / 2 + var9 * 20 + mGraphics.setColor(Panel.s), var3 + var5 - 17, 3);
               }

               for(var9 = 0; var9 < this.L; ++var9) {
                  var1.drawImage(Panel.s, var2 + var4 / 2 - this.L * 20 / 2 + var9 * 20 + mGraphics.setColor(Panel.s), var3 + var5 - 8, 3);
               }

               if (this.o > 0) {
                  this.O = Panel.r;
                  if (this.o >= this.M) {
                     this.N = this.o - this.M;

                     for(var9 = 0; var9 < this.M; ++var9) {
                        var1.drawImage(this.O, var2 + var4 / 2 - this.M * 20 / 2 + var9 * 20 + mGraphics.setColor(this.O), var3 + var5 - 17, 3);
                     }

                     for(var9 = 0; var9 < this.N; ++var9) {
                        if (var9 + this.M >= r) {
                           this.O = Panel.t;
                        }

                        var1.drawImage(this.O, var2 + var4 / 2 - this.L * 20 / 2 + var9 * 20 + mGraphics.setColor(this.O), var3 + var5 - 8, 3);
                     }
                  } else {
                     for(var9 = 0; var9 < this.o; ++var9) {
                        var1.drawImage(this.O, var2 + var4 / 2 - this.M * 20 / 2 + var9 * 20 + mGraphics.setColor(this.O), var3 + var5 - 17, 3);
                     }
                  }
               }
            } else {
               for(var9 = 0; var9 < this.p; ++var9) {
                  var1.drawImage(Panel.s, var2 + var4 / 2 - this.p * 20 / 2 + var9 * 20 + mGraphics.setColor(Panel.s), var3 + var5 - 13, 3);
               }

               if (this.o > 0) {
                  for(var9 = 0; var9 < this.o; ++var9) {
                     var1.drawImage(Panel.r, var2 + var4 / 2 - this.p * 20 / 2 + var9 * 20 + mGraphics.setColor(Panel.r), var3 + var5 - 13, 3);
                  }
               }
            }

            var1.setColor(-var1.setColor(), -var1.b());
            var1.e(0, 0, main.GameCanvas.z, main.GameCanvas.A);
            if (this.j != null) {
               Paint.paintCmdBar(var1, (CommandLine)null, this.j, (CommandLine)null);
            }

            if (this.k != null) {
               Paint.paintCmdBar(var1, this.k, (CommandLine)null, this.l);
            }

         }
      }
   }

   public final void a(mGraphics var1, int var2) {
      int var3 = this.e;
      int var4 = this.f;
      int var5 = this.a;
      int var6 = var1.setColor();
      int var7 = var1.b();
      var1.setColor(0, -var2);
      if (var3 > 0 && var4 > 0 || main.GameCanvas.panel.isShow) {
         var2 = -1;

         for(var4 = 0; var4 < this.d.length; ++var4) {
            if (this.d[var4].startsWith("--")) {
               var1.setColor(16777215);
               var1.fillRect(var3 + 10, this.f + this.c + var4 * 12 - 6, var5 - 20, 1);
            } else {
               mFont var8 = mFont.s;
               int var9 = 2;
               String var10 = this.d[var4];
               int var13;
               if (this.d[var4].startsWith("|")) {
                  String[] var11;
                  if ((var11 = ResLog.a(this.d[var4], "|", 0)).length == 3) {
                     var10 = var11[2];
                  }

                  if (var11.length == 4) {
                     var10 = var11[3];
                     var9 = Integer.parseInt(var11[2]);
                  }

                  var2 = var13 = Integer.parseInt(var11[1]);
               } else {
                  var13 = var2;
               }

               switch(var13) {
               case -1:
                  var8 = mFont.s;
                  break;
               case 0:
                  var8 = mFont.c;
                  break;
               case 1:
                  var8 = mFont.h;
                  break;
               case 2:
                  var8 = mFont.a;
               }

               if (this.d[var4].startsWith("<")) {
                  String[] var12 = ResLog.a(ResLog.a(this.d[var4], "<", 0)[1], ">", 1);
                  if (this.K == 0) {
                     this.K = Integer.parseInt(var12[1]);
                  } else if ((B = mSystem.currentTimeMillis()) - C >= 1000L) {
                     C = B;
                     --this.K;
                  }

                  var10 = this.K + " " + var12[2];
                  var8.drawStringBd(var1, var10, this.e + this.a / 2, this.f + this.c + var4 * 12 - this.s, var9);
               } else {
                  if (var9 == 2) {
                     var8.drawStringBd(var1, var10, this.e + this.a / 2, this.f + this.c + var4 * 12 - this.s, var9);
                  }

                  if (var9 == 1) {
                     var8.drawStringBd(var1, var10, this.e + this.a - 5, this.f + this.c + var4 * 12 - this.s, var9);
                  }
               }
            }
         }

         main.GameCanvas.a(var1);
         var1.setColor(var6, var7);
      }
   }

   private void a(int var1) {
      if ((u += var1 * 12) < 0) {
         u = 0;
      }

      if (u > this.h) {
         u = this.h;
      }

   }

   public final void b() {
      if (this.t) {
         if (main.GameCanvas.keyPressed[8]) {
            main.GameCanvas.keyPressed[8] = false;
            this.a(1);
         }

         if (main.GameCanvas.keyPressed[2]) {
            main.GameCanvas.keyPressed[2] = false;
            this.a(-1);
         }

         if (main.GameCanvas.isPointerHoldIn(this.e, 0, this.a + 2, this.g)) {
            if (main.GameCanvas.n) {
               if (this.Q == 0) {
                  this.Q = main.GameCanvas.p;
               }

               this.P = this.Q - main.GameCanvas.p;
               if (this.P != 0) {
                  u += this.P;
                  this.Q = main.GameCanvas.p;
               }

               if (u < 0) {
                  u = 0;
               }

               if (u > this.h) {
                  u = this.h;
               }
            } else {
               this.Q = 0;
               this.Q = 0;
            }
         }
      }

      if (q != null) {
         if (main.GameCanvas.isTouch) {
            q.a();
         }

         nr_ds var10000;
         if (main.GameCanvas.j[2]) {
            var10000 = q;
            var10000.b -= 12;
            if (q.b < 0) {
               q.b = 0;
            }
         }

         if (main.GameCanvas.j[8]) {
            main.GameCanvas.keyPressed[8] = false;
            var10000 = q;
            var10000.b += 12;
            if (q.b > q.l) {
               q.b = q.l;
            }
         }
      }

      if (main.GameCanvas.keyPressed[5] || mScreen.a(main.GameCanvas.currentScreen.center)) {
         main.GameCanvas.keyPressed[5] = false;
         mScreen.cf = -1;
         if (this.j != null) {
            this.j.performAction();
         } else if (this.k != null) {
            this.k.performAction();
         } else if (this.l != null) {
            this.l.performAction();
         }
      }

      if (q == null || !q.m) {
         if (this.k != null && (main.GameCanvas.keyPressed[12] || main.GameCanvas.keyPressed[5] || mScreen.a(this.k))) {
            main.GameCanvas.keyPressed[12] = false;
            main.GameCanvas.keyPressed[5] = false;
            main.GameCanvas.l = false;
            main.GameCanvas.m = false;
            this.k.performAction();
            mScreen.cf = -1;
         }

         if (this.l != null && (main.GameCanvas.keyPressed[13] || mScreen.a(this.l))) {
            main.GameCanvas.keyPressed[13] = false;
            main.GameCanvas.l = false;
            main.GameCanvas.m = false;
            this.l.performAction();
            mScreen.cf = -1;
         }

      }
   }

   public final void perform(int var1, Object var2) {
      if (var1 == 1000) {
         try {
            GameMidlet.instance.platformRequest((String)var2);
         } catch (Exception var3) {
            var3.printStackTrace();
         }

         GameMidlet.instance.notifyDestroyed();
         main.GameCanvas.endDlg();
      }

      if (var1 == 1001) {
         q = null;
         Char.x = null;
         serverChatPopUp = null;
         GameScr.info1.f = true;
         Char.bH = false;
         if (H) {
            GameScr.info1.b.e = 0;
            GameScr.info1.b.info.b = 10;
         }
      }

      if (var1 == 8000) {
         if (J > 0) {
            return;
         }

         int var5 = currChatPopup.D;
         ++var5;
         if (var5 >= currChatPopup.E.length) {
            Char.x = null;
            currChatPopup = null;
            GameScr.info1.f = true;
            Char.bH = false;
            if (F != null) {
               b(F, 100000, G);
               F = null;
               G = null;
               return;
            }

            if (H) {
               GameScr.info1.b.e = 0;

               for(var1 = 0; var1 < GameScr.info1.b.infoWaitToShow.size(); ++var1) {
                  if (((InfoItem)GameScr.info1.b.infoWaitToShow.elementAt(var1)).b == 10000000) {
                     ((InfoItem)GameScr.info1.b.infoWaitToShow.elementAt(var1)).b = 10;
                  }
               }
            }

            return;
         }

         ChatPopup var4;
         (var4 = c(currChatPopup.E[var5], currChatPopup.b, currChatPopup.i)).D = var5;
         var4.E = currChatPopup.E;
         var4.j = currChatPopup.j;
         currChatPopup = var4;
      }

   }
}
