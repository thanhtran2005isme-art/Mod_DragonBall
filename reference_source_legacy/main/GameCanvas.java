package main;

import java.util.Random;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import nro.Panel2;
import nro.Controller;
import nro.ChatPopup;
import nro.Char;
import nro.CrackBallScr;
import nro.Rms;
import nro.mResources;
import nro.Menu;
import nro.mScreen;
import nro.MsgDlg;
import nro.nr_bd;
import nro.RegisterScreen;
import nro.SmallImage;
import nro.PopUp;
import nro.InfoDlg;
import nro.Session_ME2;
import nro.ServerListScreen;
import nro.Service;
import nro.SoundMn;
import nro.TileMap;
import nro.Waypoint;
import nro.ClanMessage;
import nro.ItemMap;
import nro.StaticObj;
import nro.ChatTextField;
import nro.nr_cu;
import nro.Paint;
import nro.Effect2;
import nro.CommandLine;
import nro.ScaledInputCanvas;
import nro.mFont;
import nro.ResLog;
import nro.nr_dr;
import nro.Effect;
import nro.BackgroudEffect;
import nro.EffecMn;
import nro.MyVector;
import nro.SplashScr;
import nro.mGraphics;
import nro.ServerScr;
import nro.Panel;
import nro.Item;
import nro.InputDlg;
import nro.mSystem;
import nro.Dialog;
import nro.GameScr;
import nro.MyHashTable;
import nro.Hint;
import nro.LoginScr;

public final class GameCanvas extends ScaledInputCanvas implements nro.IActionListener {
   public static boolean a = false;
   public static long b = 0L;
   public static boolean c = true;
   public static boolean isLoading;
   public static boolean isTouch = false;
   public static boolean f;
   public static boolean g;
   public static GameCanvas h;
   public static boolean[] keyPressed = new boolean[14];
   private static boolean[] an = new boolean[14];
   public static boolean[] j = new boolean[14];
   public static boolean k;
   public static boolean l;
   public static boolean m;
   public static boolean n;
   public static int o;
   public static int p;
   public static int q;
   public static int r;
   public static int s;
   public static int t;
   public static nr_bd[] u = new nr_bd[4];
   public static int v;
   public static int w;
   private static int ao;
   public static boolean x;
   public static boolean y;
   private static long ap;
   private static long aq;
   public static int z;
   public static int A;
   public static int B;
   public static int hh;
   public static mScreen currentScreen;
   public static Menu menu;
   public static Panel panel;
   public static Panel G;
   public static Panel2 H;
   public static LoginScr loginScr;
   public static RegisterScreen J;
   public static Dialog currentDialog;
   public static MsgDlg msgdlg;
   public static Paint M;
   public static Image[] N;
   public static int O;
   private static int ar;
   public static int[] P;
   public static int[] Q;
   private mGraphics as = new mGraphics();
   public static Image[] R;
   public static Image[] S;
   public static MyHashTable T;
   public static MyVector U;
   private static MyVector at;
   private static MyVector au;
   public static MyVector V;
   public static boolean W;
   private static int av;
   private int aw;
   private static boolean ax;
   private static Image ay;
   private static Image az;
   public static Image[] X;
   private static Image[] aA;
   public static int[] Y;
   public static int[] Z;
   private static int aB;
   private static int aC;
   private static int aD;
   private static int aE;
   private static int[] aF;
   private static int[] aG;
   private static int[] aH;
   public static boolean aa;
   private static boolean aI;
   private static int aJ;
   private static Image aK;
   public static int ab;
   public static int ac;
   private static int[] aL;
   public static int[] ad;
   private static int[] aM;
   private static int aN;
   private static int[] aO;
   private static Image aP;
   private static Image aQ;
   private static boolean aR;
   private static long aS;
   public static int ae;
   public static Image af;
   private static int aT;
   private static int aU;
   private long aV = System.currentTimeMillis() + 1000L;
   private long aW = System.currentTimeMillis() + 1000L;
   public static long ag;
   private static String aX;
   private static int aY;
   private static MyVector aZ;
   private int ba = 12;
   public static boolean ah;
   private int[] bb;
   private int[] bc;
   private int[] bd;
   private static int[] be;
   private static Image[] bf;
   private static Image bg;
   private static Image[][] bh;
   public static boolean ai;
   public static ServerListScreen serverScreen;
   public static ServerScr ak;
   public static boolean al;
   private boolean bi;
   private static long bj;
   private static int bk;

   static {
      new Object();
      ar = 0;
      R = new Image[7];
      S = new Image[7];
      T = new MyHashTable("");
      U = new MyVector("");
      av = -1;
      X = new Image[3];
      aA = new Image[3];
      ab = -1;
      aL = new int[5];
      aN = 0;
      aO = new int[]{1, 4, 11};
      int[] var10000 = new int[]{-1};
      aS = 0L;
      new MyVector("vFlyText");
      aT = 0;
      aY = z - 60;
      aZ = new MyVector("");
      ah = false;
      new Random();
      ai = true;
      bk = 15;
   }

   public GameCanvas() {
      z = this.getNumGridCellsX();
      A = this.getNumGridCellsY();
      mScreen.ITEM_HEIGHT = mFont.t.getWidth() + 8;
      menu = new Menu();
      panel = new Panel();
      new MyVector("vCurrPopup");
      B = z / 2;
      hh = A / 2;
      if (this.hasPointerEvents()) {
         isTouch = true;
         if (z >= 240) {
            f = true;
         }

         if (z < 320) {
            g = true;
         }
      }

      msgdlg = new MsgDlg();
      if (A <= 160) {
         Paint.a = 15;
         mScreen.ce = 17;
      }

      h = this;
      System.gc();
      M = new Paint();
      if (!a) {
         if (bh == null) {
            bh = new Image[2][5];

            for(int var2 = 0; var2 < 2; ++var2) {
               for(int var3 = 0; var3 < 5; ++var3) {
                  bh[var2][var3] = mSystem.load("/e/d" + var2 + var3 + ".png");
               }
            }
         }

         this.bb = new int[2];
         this.bc = new int[2];
         this.bd = new int[2];
         this.bd[0] = this.bd[1] = -1;
      }

      n();
      bg = mSystem.load("/mainImage/myTexture2df.png");
      int var1;
      if ((var1 = Rms.loadRMSInt("clienttype")) != -1) {
         if (var1 > 7) {
            Rms.saveRMSInt("clienttype", mSystem.d);
         } else {
            mSystem.d = var1;
         }
      }

      if (mSystem.d == 7 && (Rms.loadRMSString("fake") == null || Rms.loadRMSString("fake") == "")) {
         bg = mSystem.load("/mainImage/wait.png");
      }

      at = new MyVector("vDebugUpdate");
      au = new MyVector("vDeBugPait");
      V = new MyVector("vDebugSesion");

      for(var1 = 0; var1 < 3; ++var1) {
         X[var1] = mSystem.load("/mainImage/myTexture2dbd" + var1 + ".png");
      }

      mGraphics.setColor(X[0]);
      mGraphics.b(X[0]);
      mGraphics.setColor(X[1]);
      mGraphics.b(X[1]);
      Panel.H = Rms.loadRMSInt("lowGraphic");
      a = Rms.loadRMSInt("lowGraphic") == 1;
      GameScr.bU = Rms.loadRMSInt("serverchat") != 1;
      Char.cU = Rms.loadRMSInt("isPaintAura") == 1;
      Char.cV = Rms.loadRMSInt("isPaintAura2") == 1;
      ResLog.a();
      SmallImage.loadBigImage();
      PopUp.a();
      Panel.aa = 176;
      if (176 > z) {
         Panel.aa = z;
      }

      serverScreen = new ServerListScreen();
      af = mSystem.load("/mainImage/12+.png");

      for(var1 = 0; var1 < 7; ++var1) {
         R[var1] = mSystem.load("/effectdata/blue/" + var1 + ".png");
         S[var1] = mSystem.load("/effectdata/violet/" + var1 + ".png");
      }

      ak = new ServerScr();
      H = new Panel2();
   }

   public static GameCanvas a() {
      return h;
   }

   public static void connect() {
      if (!Session_ME2.Session_ME().d()) {
         Session_ME2.Session_ME().connect(GameMidlet.ip, GameMidlet.port);
      }

   }

   public static void a(String var0, short var1) {
      if (!Session_ME2.Session_ME().d()) {
         Session_ME2.Session_ME().connect((String)var0, (int)var1);
      }

   }

   public static void c() {
      if (!Session_ME2.doSendMessage().d()) {
         ResLog.c("IP2= " + GameMidlet.c + " PORT 2= " + GameMidlet.d);
         Session_ME2.doSendMessage().connect(GameMidlet.c, GameMidlet.d);
      }

   }

   public static void a(mGraphics var0) {
      var0.setColor(-var0.setColor(), -var0.b());
      var0.e(0, 0, z, A);
   }

   public final void d() {
      if (mSystem.currentTimeMillis() > this.aV) {
         this.aV += 1000L;
         aT = 0;
      }

      ++aT;
      if (U.size() > 0 && aX == null) {
         aX = (String)U.elementAt(0);
         aY = z - 60;
         av = -1;
         U.removeElementAt(0);
      }

      if (v % 5 == 0) {
         b = mSystem.currentTimeMillis();
      }

      if (mSystem.currentTimeMillis() > this.aW) {
         this.aW += 1000L;
         aU = 0;
      }

      ++aU;
      at.removeAllElements();
      long var1 = System.currentTimeMillis();
      if (GameScr.bO) {
         ResLog.b();
      }

      if (var1 - ap >= 780L && !x) {
         ap = var1;
         x = true;
      } else {
         x = false;
      }

      if (var1 - aq >= 7800L && !y) {
         aq = var1;
         y = true;
      } else {
         y = false;
      }

      if (w > 0) {
         --w;
      }

      if (++v > 10000) {
         if (System.currentTimeMillis() - aS > 20000L && currentScreen == loginScr) {
            GameMidlet.instance.a();
         }

         v = 0;
      }

      if (currentScreen != null) {
         if (ChatPopup.serverChatPopUp != null) {
            ChatPopup.serverChatPopUp.update();
            ChatPopup.serverChatPopUp.b();
         } else if (ChatPopup.currChatPopup != null) {
            ChatPopup.currChatPopup.update();
            ChatPopup.currChatPopup.b();
         } else if (currentDialog != null) {
            currentDialog.a();
         } else if (menu.a) {
            menu.b();
            menu.a();
         } else if (panel.isShow) {
            panel.B();
            if (b(panel.b, 0, panel.d, panel.e)) {
               W = false;
            }

            if (G != null && G.isShow) {
               G.B();
               if (b(G.b, 0, G.d, G.e)) {
                  W = true;
               }
            }

            if (G != null) {
               if (W) {
                  G.u();
               } else {
                  panel.u();
               }
            } else {
               panel.u();
            }

            if (panel.o != null && panel.o.b) {
               panel.t();
            } else if (G != null && G.o != null && G.o.b) {
               G.t();
            } else if ((!b(panel.b, 0, panel.d, panel.e) || G == null) && G != null) {
               if (G != null && G.isShow && b(G.b, 0, G.d, G.e)) {
                  G.u();
               }
            } else {
               panel.u();
            }

            if (b(panel.b + panel.d, 0, z - (panel.d << 1), panel.e) && m && panel.ay) {
               panel.A();
            }
         }

         if (!isLoading) {
            currentScreen.update();
         }

         if (!panel.isShow && ChatPopup.serverChatPopUp == null) {
            currentScreen.updateKey();
         }

         int var4;
         label353: {
            if (Char.myCharz().aD != null && currentScreen == GameScr.c) {
               short var3 = Char.myCharz().aD.c;
               int var2 = Char.myCharz().aD.a;
               Hint.j = false;
               Hint.k = 0;
               Hint.c = 0;
               Hint.i = true;
               Hint.m = true;
               if (menu.a && var3 > 0) {
                  Hint.i = false;
               }

               switch(var3) {
               case 0:
                  if (ChatPopup.currChatPopup == null && Char.myCharz().statusMe != 14) {
                     if (var2 == 0 && TileMap.t.size() != 0) {
                        Hint.a = ((Waypoint)TileMap.t.elementAt(0)).a - 100;
                        Hint.b = ((Waypoint)TileMap.t.elementAt(0)).b + 40;
                        Hint.j = true;
                     }

                     if (var2 == 1) {
                        Hint.a(0);
                     }

                     if (var2 == 2) {
                        Hint.clickNpc();
                     }

                     if (var2 == 3) {
                        if (!panel.isShow) {
                           Hint.clickNpc();
                        } else if (panel.A == 0) {
                           if (panel.ah == null) {
                              Hint.a = panel.ad + panel.af / 2;
                              Hint.b = panel.ae + 20;
                           } else if (menu.e != 0) {
                              Hint.a = panel.ad + 25;
                              Hint.b = panel.ae + 60;
                           }
                        } else if (panel.A == 1) {
                           Hint.a = panel.B + 10;
                           Hint.b = 65;
                        }
                     }

                     if (var2 == 4) {
                        if (panel.isShow) {
                           Hint.a = panel.cmdClose.x + 5;
                           Hint.b = panel.cmdClose.y + 5;
                        } else if (menu.a) {
                           Hint.a = z / 2;
                           Hint.b = A - 20;
                        } else {
                           Hint.clickNpc();
                        }
                     }

                     if (var2 == 5) {
                        Hint.clickNpc();
                     }
                     break label353;
                  }

                  Hint.a = z / 2;
                  Hint.b = A - 15;
                  break label353;
               case 1:
                  if (ChatPopup.currChatPopup == null && Char.myCharz().statusMe != 14) {
                     if (var2 == 0) {
                        if (TileMap.d()) {
                           Hint.a(0);
                        } else {
                           Hint.clickMob();
                        }
                     }

                     if (var2 == 1) {
                        if (!TileMap.d()) {
                           Hint.a(1);
                        } else {
                           Hint.clickNpc();
                        }
                     }
                     break label353;
                  }

                  Hint.a = z / 2;
                  Hint.b = A - 15;
                  break label353;
               case 2:
                  if (ChatPopup.currChatPopup != null || Char.myCharz().statusMe == 14) {
                     Hint.a = z / 2;
                     Hint.b = A - 15;
                     break label353;
                  }

                  if (var2 == 0) {
                     if (!TileMap.d()) {
                        Hint.f = true;
                     }

                     if (!panel.isShow) {
                        if (!Hint.f) {
                           Hint.a = GameScr.gI().aQ.x;
                           Hint.b = GameScr.gI().aQ.y + 13;
                           Hint.k = 1;
                        } else {
                           if (GameScr.z() == TileMap.l) {
                              if (!Hint.c()) {
                                 Hint.clickMob();
                              }
                           } else {
                              Hint.a(0);
                           }

                           if (Hint.f) {
                              Hint.g = true;
                           }
                        }
                     } else if (!Hint.f) {
                        if (panel.A == 0) {
                           var4 = A > 300 ? 15 : 10;
                           Hint.a = panel.ad + panel.af / 2;
                           Hint.b = panel.ae + panel.ag - var4;
                        } else {
                           Hint.a = panel.B + 10;
                           Hint.b = 65;
                        }
                     } else if (!Hint.g) {
                        Hint.a = panel.cmdClose.x + 5;
                        Hint.b = panel.cmdClose.y + 5;
                     } else {
                        Hint.i = false;
                     }

                     if (Char.myCharz().cMP <= 0) {
                        Hint.a = GameScr.bw + 5;
                        Hint.b = GameScr.bx + 13;
                        Hint.j = false;
                     }
                  }

                  if (var2 != 1) {
                     break label353;
                  }
                  break;
               case 3:
                  if (ChatPopup.currChatPopup == null && Char.myCharz().statusMe != 14) {
                     if (var2 == 0) {
                        if (!panel.isShow) {
                           if (!Hint.h) {
                              Hint.a = GameScr.gI().aQ.x;
                              Hint.b = GameScr.gI().aQ.y + 13;
                              Hint.k = 1;
                           } else {
                              if (GameScr.z() == TileMap.l) {
                                 if (!Hint.c()) {
                                    Hint.clickMob();
                                 }
                              } else {
                                 Hint.a(0);
                              }

                              if (Hint.f) {
                                 Hint.g = true;
                              }
                           }
                        } else if (!Hint.h) {
                           Hint.a = panel.ad + 10 + 108 - 18;
                           Hint.b = 65;
                        } else if (!Hint.g) {
                           Hint.a = panel.cmdClose.x + 5;
                           Hint.b = panel.cmdClose.y + 5;
                        } else {
                           Hint.i = false;
                        }

                        if (Char.myCharz().cMP <= 0) {
                           Hint.a = GameScr.bw + 5;
                           Hint.b = GameScr.bx + 13;
                           Hint.j = false;
                        }
                     } else {
                        Hint.i = false;
                        Hint.m = false;
                     }
                     break label353;
                  }

                  Hint.a = z / 2;
                  Hint.b = A - 15;
                  break label353;
               default:
                  if (Char.myCharz().aD.c == 9 && Char.myCharz().aD.a == 2) {
                     for(var4 = 0; var4 < PopUp.a.size(); ++var4) {
                        PopUp var5;
                        if ((var5 = (PopUp)PopUp.a.elementAt(var4)).e <= 24) {
                           Hint.a = var5.d + var5.b / 2;
                           Hint.b = var5.e + 30;
                           Hint.j = true;
                           Hint.i = false;
                           Hint.m = true;
                           break label353;
                        }
                     }
                  }

                  Hint.i = false;
                  Hint.m = false;
                  break label353;
               }
            }

            Hint.i = false;
            Hint.m = false;
         }

         var4 = Hint.k == 0 ? 2 : -2;
         if (!Hint.e) {
            Hint.l = false;
            if (++Hint.d == 50) {
               Hint.d = 0;
               Hint.e = true;
            }
         } else {
            ++Hint.d;
            if (Hint.c == 0) {
               if (Hint.d == 2) {
                  Hint.a += var4 * 2;
                  Hint.b -= 4;
                  Hint.l = true;
               }

               if (Hint.d == 4) {
                  Hint.a -= var4 * 2;
                  Hint.b += 4;
                  Hint.e = false;
                  Hint.l = false;
                  Hint.d = 0;
               }

               if (Hint.d > 4) {
                  Hint.e = false;
               }
            }

            if (Hint.c == 1) {
               if (Hint.d == 2) {
                  if (isTouch) {
                     GameScr.a(mResources.cH, Hint.a, Hint.b + 10, 0, 20, 7);
                  }

                  Hint.l = true;
                  Hint.a += var4 * 2;
                  Hint.b -= 4;
               }

               if (Hint.d == 4) {
                  Hint.l = false;
                  Hint.a -= var4;
                  Hint.b += 2;
               }

               if (Hint.d == 6) {
                  Hint.l = true;
                  Hint.a += var4;
                  Hint.b -= 2;
               }

               if (Hint.d == 8) {
                  Hint.l = false;
                  Hint.a -= var4;
                  Hint.b += 2;
               }

               if (Hint.d == 10) {
                  Hint.a -= var4;
                  Hint.b += 2;
                  Hint.e = false;
                  Hint.d = 0;
               }
            }
         }

         SoundMn.stopAll();
      }

      System.currentTimeMillis();
      InfoDlg.b();
      if (this.bi) {
         this.bi = false;
         doResetToLoginScr((mScreen)serverScreen);
      }

      if (currentScreen != null && currentScreen instanceof GameScr && (aY += av << 1) - Panel.u.getWidth() <= 60) {
         av = 0;
         ++this.aw;
         if (this.aw > 150) {
            this.aw = 0;
            aX = null;
         }
      }

   }

   public static void doResetToLoginScr(mScreen var0) {
      try {
         Char.isLoadingMap = false;
         Char.bG = false;
         SoundMn.stopAll();
         LoginScr.c = false;
         TileMap.p = 0;
         TileMap.q = 0;
         Char.g();
         GameScr.n();
         GameScr.g();
         InfoDlg.hide();
         GameScr.info1.b.a();
         GameScr.aD.b.a();
         GameScr.aD.i = null;
         ChatPopup.currChatPopup = null;
         Controller.b = false;
         GameScr.loadCamera(-1, (int)-1);
         GameScr.bu.removeAllElements();
         GameScr.cmx = 100;
         panel.A = 0;
         panel.aj = isTouch ? -1 : 0;
         panel.a();
         G = null;
         GameScr.bs = true;
         ClanMessage.vMessage.removeAllElements();
         GameScr.A.removeAllElements();
         GameScr.B.removeAllElements();
         GameScr.C.removeAllElements();
         TileMap.v.removeAllElements();
         BackgroudEffect.a.removeAllElements();
         EffecMn.a.removeAllElements();
         Effect.l.removeAllElements();
         menu.a = false;
         panel.isShow = false;
         panel.k.removeAllElements();
         if (panel.tabIcon != null) {
            panel.tabIcon.k = false;
         }

         Session_ME2.Session_ME().close();
         Session_ME2.doSendMessage().close();
         var0.switchToMe();
      } catch (Exception var2) {
      }

      ServerListScreen.v = true;
      ServerListScreen.k = 0;
      ServerListScreen.t = -1;
      ServerListScreen.loadScreen = true;
   }

   private static void a(mGraphics var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      var0.setColor(var1);
      if ((var1 = GameScr.cmy) > A) {
         var1 = A;
      }

      var0.fillRect(0, var3 - (var6 != 0 ? var1 >> var6 : 0), var4, var5 + (var6 != 0 ? var1 >> var6 : 0));
   }

   private static void a(mGraphics var0, int var1, int var2, int var3, int var4) {
      try {
         int var5;
         if ((var5 = var1 - 1) == N.length - 1 && (GameScr.gI().ba || GameScr.gI().bQ)) {
            var0.setColor(GameScr.gI().bd);
            var0.fillRect(0, 0, z, A);
            if (ab == 2 || ab == 4 || ab == 7) {
               d(var0);
               e(var0);
            }

            if (GameScr.gI().bQ && !a) {
               nr_dr.a(var0);
            }

            return;
         }

         if (N != null && N[var5] != null) {
            if (aG[var5] != 0) {
               int[] var10000 = aG;
               var10000[var5] += aH[var5];
            }

            int var6;
            if ((var6 = GameScr.cmy) > A) {
               var6 = A;
            }

            int var7;
            if (aF[var5] != 0) {
               for(var7 = -((GameScr.cmx + aG[var5] >> aF[var5]) % P[var5]); var7 < GameScr.d; var7 += P[var5]) {
                  var0.drawImage(N[var5], var7, aL[var5] - (var2 > 0 ? var6 >> var2 : 0), 0);
               }
            } else {
               for(var7 = 0; var7 < GameScr.d; var7 += P[var5]) {
                  var0.drawImage(N[var5], var7, aL[var5] - (var2 > 0 ? var6 >> var2 : 0), 0);
               }
            }

            if (var3 != -1) {
               if (var5 == aN - 1) {
                  a(var0, var3, 0, -(var6 >> var2), GameScr.d, aL[var5], var2);
               } else {
                  a(var0, var3, 0, aL[var5 - 1] + Q[var5 - 1], GameScr.d, aL[var5] - (aL[var5 - 1] + Q[var5 - 1]), var2);
               }
            }

            if (var4 != -1) {
               if (var5 == 0) {
                  a(var0, var4, 0, aL[var5] + Q[var5], GameScr.d, GameScr.e - (aL[var5] + Q[var5]), var2);
               } else {
                  a(var0, var4, 0, aL[var5] + Q[var5], GameScr.d, aL[var5 - 1] - (aL[var5] + Q[var5]) + 80, var2);
               }
            }

            if (currentScreen == GameScr.c) {
               if (var1 == 1 && ab == 11 && TileMap.p == 0) {
                  var0.drawImage(az, -(GameScr.cmx >> aF[0]) + 400, aL[0] + 30 - (var6 >> 2), StaticObj.c);
               }

               if (var1 == 1 && ab == 13) {
                  var0.drawImage(N[1], -(GameScr.cmx >> aF[0]) + 200, aL[0] - (var6 >> 3) + 30, 0);
                  var0.setColor(N[1], 0, 0, P[1], Q[1], 2, -(GameScr.cmx >> aF[0]) + 200 + P[1], aL[0] - (var6 >> 3) + 30, 0);
               }

               if (var1 == 3 && TileMap.l == 1) {
                  for(var7 = 0; var7 < TileMap.d / mGraphics.b(aP); ++var7) {
                     var0.drawImage(aP, -(GameScr.cmx >> aF[2]) + 300, var7 * mGraphics.b(aP) - (var6 >> 3), 0);
                  }
               }
            }

            var7 = -(GameScr.cmx + aG[var5] >> aF[var5]);
            EffecMn.a(var0, var7, aL[var5] + Q[var5] - (var6 >> var2), var5);
            return;
         }
      } catch (Exception var8) {
         var8.printStackTrace();
      }

   }

   private static void d(mGraphics var0) {
      if (ay != null) {
         var0.drawImage(ay, aB, aC, 0);
      }

      if (aa) {
         if (v % 200 == 0) {
            aI = true;
         }

         if (aI) {
            if (++aJ == 10) {
               aJ = 0;
               aI = false;
            }

            if (aJ % 2 == 0) {
               var0.setColor(16777215);
               var0.fillRect(0, 0, z, A);
            }
         }
      }

   }

   private static void e(mGraphics var0) {
      if (az != null) {
         var0.drawImage(az, aD, aE, 0);
      }

   }

   public static void b(mGraphics var0) {
      if (mSystem.d == 5) {
         int var1;
         if (aK == null) {
            var1 = TileMap.bgID % 2 == 0 ? 2 : 1;
            aK = mSystem.load("/bg/bg_ios_" + var1 + ".png");
         } else {
            var0.setColor(0);
            var0.fillRect(0, 0, z, A);

            for(var1 = 0; var1 < 3; ++var1) {
               var0.drawImage(aK, aK.getWidth() * var1, A / 2, 3);
            }

         }
      }
   }

   public static void paintBackground(mGraphics var0) {
      if (!aR) {
         var0.setColor(0);
         var0.fillRect(0, 0, z, A);
      }

      if (!Char.isLoadingMap) {
         int var1 = GameScr.d;
         var0.setColor(-var0.setColor(), -var0.b());

         try {
            int var2;
            if (ax && !a) {
               if (currentScreen == GameScr.gI()) {
                  if (TileMap.l == 137 || TileMap.l == 115 || TileMap.l == 117 || TileMap.l == 118 || TileMap.l == 120 || TileMap.j) {
                     var0.setColor(0);
                     var0.fillRect(0, 0, z, A);
                     return;
                  }

                  if (TileMap.l == 138) {
                     var0.setColor(6776679);
                     var0.fillRect(0, 0, z, A);
                     return;
                  }
               }

               if (ab == 0) {
                  a(var0, 4, 6, ad[3], aM[3]);
                  a(var0, 3, 4, -1, aM[2]);
                  a(var0, 2, 3, -1, aM[1]);
                  a(var0, 1, 2, -1, aM[0]);
                  return;
               }

               if (ab == 1) {
                  a(var0, 4, 6, -1, -1);
                  a(var0, 3, 3, -1, -1);
                  a(var0, ad[2], 0, -(GameScr.cmy >> 5), var1, aL[2], 5);
                  a(var0, aM[2], 0, aL[2] + Q[2] - (GameScr.cmy >> 3), var1, 70, 3);
                  a(var0, 2, 2, -1, -1);
                  a(var0, 1, 1, -1, aM[0]);
                  return;
               }

               if (ab == 2) {
                  a(var0, 5, 10, ad[4], aM[4]);
                  a(var0, 4, 8, -1, ad[2]);
                  a(var0, 3, 5, -1, aM[2]);
                  a(var0, 2, 2, -1, aM[1]);
                  a(var0, 1, 1, -1, aM[0]);
                  return;
               }

               if (ab == 3) {
                  var2 = GameScr.cmy - (325 - GameScr.g);
                  var0.setColor(0, -var2);
                  a(var0, !GameScr.gI().ba && !GameScr.gI().bQ ? ad[2] : GameScr.gI().bd, 0, var2 - (GameScr.cmy >> 3), var1, aL[2] - var2 + (GameScr.cmy >> 3) + 100, 2);
                  a(var0, 3, 2, -1, aM[2]);
                  a(var0, 2, 0, -1, -1);
                  a(var0, 1, 0, -1, aM[0]);
                  var0.setColor(0, -var0.b());
                  return;
               }

               if (ab == 4) {
                  a(var0, 4, 7, ad[3], -1);
                  a(var0, 3, 3, -1, mGraphics.zoomLevel > 1 ? aM[2] : ad[1]);
                  a(var0, 2, 2, ad[1], aM[1]);
                  a(var0, 1, 1, -1, aM[0]);
                  return;
               }

               if (ab == 5) {
                  a(var0, 4, 15, ad[3], -1);
                  d(var0);
                  var0.setColor(100, 10);
                  d(var0);
                  var0.setColor(-100, -10);
                  e(var0);
                  a(var0, 3, 10, -1, -1);
                  a(var0, 2, 6, -1, -1);
                  a(var0, 1, 4, -1, -1);
                  var0.setColor(0, 27);
                  a(var0, 1, 2, -1, -1);
                  var0.setColor(0, 20);
                  a(var0, 1, 2, -1, aM[0]);
                  var0.setColor(-var0.setColor(), -var0.b());
                  return;
               }

               if (ab == 6) {
                  a(var0, 5, 10, ad[4], aM[4]);
                  d(var0);
                  e(var0);
                  var0.setColor(60, 40);
                  e(var0);
                  var0.setColor(-60, -40);
                  a(var0, 4, 7, -1, aM[3]);
                  BackgroudEffect.e(var0);
                  a(var0, 3, 4, -1, -1);
                  a(var0, 2, 3, -1, aM[1]);
                  a(var0, 1, 2, -1, aM[0]);
                  return;
               }

               if (ab == 7) {
                  a(var0, 4, 6, ad[3], aM[3]);
                  a(var0, 3, 5, -1, -1);
                  a(var0, 2, 4, -1, -1);
                  a(var0, 1, 3, -1, aM[0]);
                  return;
               }

               if (ab != 8) {
                  if (ab == 9) {
                     a(var0, 4, 8, ad[3], aM[3]);
                     d(var0);
                     e(var0);
                     var0.setColor(-80, 20);
                     e(var0);
                     var0.setColor(80, -20);
                     BackgroudEffect.e(var0);
                     a(var0, 3, 5, -1, -1);
                     a(var0, 2, 3, -1, -1);
                     a(var0, 1, 2, -1, aM[0]);
                     return;
                  }

                  if (ab == 10) {
                     var2 = GameScr.cmy - (380 - GameScr.g);
                     var0.setColor(0, -var2);
                     a(var0, GameScr.gI().ba ? GameScr.gI().bd : ad[1], 0, var2 - (GameScr.cmy >> 2), var1, aL[1] - var2 + (GameScr.cmy >> 2) + 100, 2);
                     a(var0, 2, 2, -1, aM[1]);
                     d(var0);
                     e(var0);
                     a(var0, 1, 0, -1, -1);
                     var0.setColor(0, -var0.b());
                     return;
                  }

                  if (ab == 11) {
                     a(var0, 3, 6, ad[2], aM[2]);
                     d(var0);
                     a(var0, 2, 3, -1, aM[1]);
                     a(var0, 1, 2, -1, aM[0]);
                     return;
                  }

                  if (ab == 12) {
                     var0.setColor(9161471);
                     var0.fillRect(0, 0, z, A);
                     a(var0, 3, 4, -1, 14417919);
                     a(var0, 2, 3, -1, 14417919);
                     a(var0, 1, 2, -1, 14417919);
                     return;
                  }

                  if (ab == 13) {
                     var0.setColor(15268088);
                     var0.fillRect(0, 0, z, A);
                     a(var0, 1, 5, -1, 15268088);
                     return;
                  }

                  if (ab == 15) {
                     var0.setColor(2631752);
                     var0.fillRect(0, 0, z, A);
                     a(var0, 2, 3, -1, aM[1]);
                     a(var0, 1, 2, -1, aM[0]);
                     return;
                  }

                  if (ab != 16) {
                     if (ab == 19) {
                        a(var0, 5, 10, ad[4], aM[4]);
                        a(var0, 4, 8, -1, ad[2]);
                        a(var0, 3, 5, -1, aM[2]);
                        a(var0, 2, 2, -1, aM[1]);
                        a(var0, 1, 1, -1, aM[0]);
                        return;
                     }

                     a(var0, aM[3], 0, aL[3] + Q[3], GameScr.d, aL[2] + Q[2], 6);
                     a(var0, 4, 6, ad[3], aM[3]);
                     d(var0);
                     a(var0, 3, 4, -1, aM[2]);
                     a(var0, 2, 3, -1, aM[1]);
                     a(var0, 1, 2, -1, aM[0]);
                     return;
                  }

                  a(var0, 4, 6, ad[3], aM[3]);

                  for(var2 = 0; var2 < aA.length; ++var2) {
                     var0.drawImage(aA[var2], Y[var2], Z[var2], 33);
                  }

                  a(var0, 3, 4, -1, aM[2]);
                  a(var0, 2, 3, -1, aM[1]);
                  a(var0, 1, 2, -1, aM[0]);
                  return;
               }

               a(var0, 4, 8, ad[3], aM[3]);
               d(var0);
               e(var0);
               a(var0, 3, 4, -1, aM[2]);
               a(var0, 2, 2, -1, aM[1]);
               if ((TileMap.l < 92 || TileMap.l > 96) && TileMap.l != 51 && TileMap.l != 52 || currentScreen == loginScr) {
                  a(var0, 1, 1, -1, aM[0]);
                  return;
               }
            } else {
               var0.setColor(2315859);
               var0.fillRect(0, 0, z, A);
               if (aQ != null) {
                  for(var2 = -((GameScr.cmx >> 2) % mGraphics.setColor(aQ)); var2 < GameScr.d; var2 += mGraphics.setColor(aQ)) {
                     var0.drawImage(aQ, var2, (GameScr.cmy >> 3) + A / 2 - 50, 0);
                  }

                  var0.setColor(5084791);
                  var0.fillRect(0, (GameScr.cmy >> 3) + A / 2 - 50 + mGraphics.b(aQ), var1, A);
                  return;
               }
            }
         } catch (Exception var3) {
            var0.setColor(0);
            var0.fillRect(0, 0, z, A);
         }

      }
   }

   private static void b(int var0) {
      try {
         int var1 = GameScr.g;
         switch(var0) {
         case 0:
            aL[0] = var1 - Q[0] + 70;
            aL[1] = aL[0] - Q[1] + 20;
            aL[2] = aL[1] - Q[2] + 30;
            aL[3] = aL[2] - Q[3] + 50;
            return;
         case 1:
            aL[0] = var1 - Q[0] + 120;
            aL[1] = aL[0] - Q[1] + 40;
            aL[2] = aL[1] - 90;
            aL[3] = aL[2] - 25;
            return;
         case 2:
            aL[0] = var1 - Q[0] + 150;
            aL[1] = aL[0] - Q[1] - 60;
            aL[2] = aL[1] - Q[2] - 40;
            aL[3] = aL[2] - Q[3] - 10;
            aL[4] = aL[3] - Q[4];
            return;
         case 3:
            aL[0] = var1 - Q[0] + 10;
            aL[1] = aL[0] + 80;
            aL[2] = aL[1] - Q[2] - 10;
            return;
         case 4:
            aL[0] = var1 - Q[0] + 130;
            aL[1] = aL[0] - Q[1];
            aL[2] = aL[1] - Q[2] - 20;
            aL[3] = aL[1] - Q[2] - 80;
            return;
         case 5:
            aL[0] = var1 - Q[0] + 40;
            aL[1] = aL[0] - Q[1] + 10;
            aL[2] = aL[1] - Q[2] + 15;
            aL[3] = aL[2] - Q[3] + 50;
            return;
         case 6:
            aL[0] = var1 - Q[0] + 100;
            aL[1] = aL[0] - Q[1] - 30;
            aL[2] = aL[1] - Q[2] + 10;
            aL[3] = aL[2] - Q[3] + 15;
            aL[4] = aL[3] - Q[4] + 15;
            return;
         case 7:
            aL[0] = var1 - Q[0] + 20;
            aL[1] = aL[0] - Q[1] + 15;
            aL[2] = aL[1] - Q[2] + 20;
            aL[3] = aL[1] - Q[2] - 10;
            return;
         case 8:
            aL[0] = var1 - 103 + 150;
            if (TileMap.l == 103) {
               int[] var10000 = aL;
               var10000[0] -= 100;
            }

            aL[1] = aL[0] - Q[1] - 10;
            aL[2] = aL[1] - Q[2] + 40;
            aL[3] = aL[2] - Q[3] + 10;
            return;
         case 9:
            aL[0] = var1 - Q[0] + 100;
            aL[1] = aL[0] - Q[1] + 22;
            aL[2] = aL[1] - Q[2] + 50;
            aL[3] = aL[2] - Q[3];
            return;
         case 10:
            aL[0] = var1 - Q[0] - 45;
            aL[1] = aL[0] - Q[1] - 10;
            return;
         case 11:
            aL[0] = var1 - Q[0] + 60;
            aL[1] = aL[0] - Q[1] + 5;
            aL[2] = aL[1] - Q[2] - 15;
            return;
         case 12:
            aL[0] = var1 + 40;
            aL[1] = aL[0] - 40;
            aL[2] = aL[1] - 40;
            return;
         case 13:
            aL[0] = var1 - 80;
            aL[1] = aL[0];
            return;
         case 14:
         case 17:
         case 18:
         default:
            aL[0] = var1 - Q[0] + 75;
            aL[1] = aL[0] - Q[1] + 50;
            aL[2] = aL[1] - Q[2] + 50;
            aL[3] = aL[2] - Q[3] + 90;
            return;
         case 15:
            aL[0] = var1 - 20;
            aL[1] = aL[0] - 80;
            return;
         case 16:
            aL[0] = var1 - Q[0] + 75;
            aL[1] = aL[0] - Q[1] + 50;
            aL[2] = aL[1] - Q[2] + 50;
            aL[3] = aL[2] - Q[3] + 90;
            return;
         case 19:
            aL[0] = var1 - Q[0] + 150;
            aL[1] = aL[0] - Q[1] - 60;
            aL[2] = aL[1] - Q[2] - 40;
            aL[3] = aL[2] - Q[3] - 10;
            aL[4] = aL[3] - Q[4];
         }
      } catch (Exception var2) {
         for(var0 = 0; var0 < aL.length; ++var0) {
            aL[var0] = 1;
         }

      }
   }

   public static void a(int var0) {
      try {
         aR = true;
         if (ab == 12) {
            BackgroudEffect.f = TileMap.d - 100;
         } else {
            BackgroudEffect.f = TileMap.d - 160;
         }

         ResLog.c("load bg id= " + var0 + "map ID= " + TileMap.l);
         BackgroudEffect.a();
         c(var0);
         if (TileMap.m == var0 && TileMap.q == TileMap.p || var0 == -1) {
            return;
         }

         ac = 12;
         TileMap.m = (byte)var0;
         TileMap.q = (byte)TileMap.p;
         aF = new int[]{1, 2, 3, 7, 8};
         aG = new int[5];
         aH = new int[5];
         ab = var0;
         aa = false;
         N = null;
         ay = null;
         aP = null;
         switch(ab) {
         case 0:
            aP = mSystem.loadImageRMS("/bg/caycot.png");
            aF = new int[]{1, 3, 5, 7};
            aN = 4;
            if (TileMap.p == 2) {
               ac = 8;
            }
            break;
         case 1:
            ac = 7;
            aN = 4;
            break;
         case 2:
            aG = new int[]{0, 0, 1, 0, 0};
            aH = new int[]{0, 0, 2, 0, 0};
            aN = 5;
            break;
         case 3:
            aN = 3;
            break;
         case 4:
            BackgroudEffect.a(3);
            aG = new int[]{0, 1, 0, 0, 0};
            aH = new int[]{0, 1, 0, 0, 0};
            aN = 4;
            break;
         case 5:
            aN = 4;
            break;
         case 6:
            aG = new int[]{1, 0, 0, 0, 0};
            aH = new int[]{2, 0, 0, 0, 0};
            aN = 5;
            break;
         case 7:
            aN = 4;
            break;
         case 8:
            ac = 8;
            aN = 4;
            break;
         case 9:
            BackgroudEffect.a(9);
            aN = 4;
            break;
         case 10:
            aN = 2;
            break;
         case 11:
            ac = 7;
            aF[2] = 0;
            aN = 3;
            break;
         case 12:
            aG = new int[]{1, 1, 0, 0, 0};
            aH = new int[]{2, 1, 0, 0, 0};
            aN = 3;
            break;
         case 13:
            aN = 2;
            break;
         case 14:
         case 17:
         case 18:
         default:
            aF = new int[]{1, 3, 5, 7};
            aN = 4;
            break;
         case 15:
            ResLog.c("HELL");
            aN = 2;
            break;
         case 16:
            aF = new int[]{1, 3, 5, 7};
            aN = 4;
            break;
         case 19:
            aG = new int[]{0, 2, 1, 0, 0};
            aH = new int[]{0, 2, 1, 0, 0};
            aN = 5;
         }

         int[] var2;
         if (var0 <= 16) {
            O = StaticObj.g[ab];
         } else {
            try {
               String var1 = "/bg/b" + ab + 3 + ".png";
               if (TileMap.p != 0) {
                  var1 = "/bg/b" + ab + 3 + "-" + TileMap.p + ".png";
               }

               var2 = new int[1];
               Image var3;
               (var3 = mSystem.loadImageRMS(var1)).getRGB(var2, 0, 1, mGraphics.drawRect(var3) / 2, 0, 1, 1);
               O = var2[0];
                System.out.println(O);
            } catch (Exception var4) {
               O = StaticObj.g[StaticObj.g.length - 1];
            }
         }

         ad = new int[StaticObj.g.length];
         aM = new int[StaticObj.g.length];

         int var6;
         for(var6 = 0; var6 < StaticObj.g.length; ++var6) {
            ad[var6] = StaticObj.g[var6];
            aM[var6] = StaticObj.g[var6];
         }

         if (a) {
            aQ = mSystem.loadImageRMS("/bg/b63.png");
            return;
         }

         N = new Image[aN];
         P = new int[aN];
         Q = new int[aN];
         aM = new int[aN];
         ad = new int[aN];
         if (TileMap.p == 100) {
            N[0] = mSystem.loadImageRMS("/bg/b100.png");
            N[1] = mSystem.loadImageRMS("/bg/b100.png");
            N[2] = mSystem.loadImageRMS("/bg/b82-1.png");
            N[3] = mSystem.loadImageRMS("/bg/b93.png");

            for(var6 = 0; var6 < aN; ++var6) {
               if (N[var6] != null) {
                  var2 = new int[1];
                  N[var6].getRGB(var2, 0, 1, mGraphics.drawRect(N[var6]) / 2, 0, 1, 1);
                  ad[var6] = var2[0];

                  var2 = new int[1];
                  N[var6].getRGB(var2, 0, 1, mGraphics.drawRect(N[var6]) / 2, mGraphics.fillRect(N[var6]) - 1, 1, 1);
                  aM[var6] = var2[0];           

                  P[var6] = mGraphics.setColor(N[var6]);
                  Q[var6] = mGraphics.b(N[var6]);
               } else if (aN > 1) {
                  N[var6] = mSystem.loadImageRMS("/bg/b" + ab + "0.png");
                  P[var6] = mGraphics.setColor(N[var6]);
                  Q[var6] = mGraphics.b(N[var6]);
               }
            }
         } else {
            for(var6 = 0; var6 < aN; ++var6) {
               String var7 = "/bg/b" + ab + var6 + ".png";
               if (TileMap.p != 0) {
                  var7 = "/bg/b" + ab + var6 + "-" + TileMap.p + ".png";
               }

               N[var6] = mSystem.loadImageRMS(var7);
               if (N[var6] != null) {
                  int[] var8 = new int[1];
                  N[var6].getRGB(var8, 0, 1, mGraphics.drawRect(N[var6]) / 2, 0, 1, 1);
                  ad[var6] = var8[0];
                  var8 = new int[1];
                  N[var6].getRGB(var8, 0, 1, mGraphics.drawRect(N[var6]) / 2, mGraphics.fillRect(N[var6]) - 1, 1, 1);
                  aM[var6] = var8[0];
                  P[var6] = mGraphics.setColor(N[var6]);
                  Q[var6] = mGraphics.b(N[var6]);
               } else if (aN > 1) {
                  N[var6] = mSystem.loadImageRMS("/bg/b" + ab + "0.png");
                  P[var6] = mGraphics.setColor(N[var6]);
                  Q[var6] = mGraphics.b(N[var6]);
               }
            }
         }

         b(ab);
         ResLog.c("5");
         Y = new int[]{GameScr.d / 2 - 40, GameScr.d / 2 + 40, GameScr.d / 2 - 100, GameScr.d / 2 - 80, GameScr.d / 2 - 120};
         Z = new int[]{130, 100, 150, 140, 80};
         aA = null;
         if (ab != 0) {
            if (ab == 2) {
               ay = mSystem.loadImageRMS("/bg/sun0.png");
               aB = GameScr.d / 2 + 50;
               aC = aL[4] - 40;
               TileMap.h = mSystem.loadImageRMS("/tWater/wts");
            } else if (ab == 19) {
               TileMap.h = mSystem.loadImageRMS("/tWater/water_flow_32");
            } else if (ab == 4) {
               ay = mSystem.loadImageRMS("/bg/sun2.png");
               aB = GameScr.d / 2 + 30;
               aC = aL[3];
            } else if (ab == 7) {
               ay = mSystem.loadImageRMS("/bg/sun3" + (TileMap.p == 0 ? "" : "-" + TileMap.p) + ".png");
               az = mSystem.loadImageRMS("/bg/sun4" + (TileMap.p == 0 ? "" : "-" + TileMap.p) + ".png");
               aB = GameScr.d - GameScr.d / 3;
               aC = aL[3] - 80;
               aD = aB - 100;
               aE = aL[3] - 30;
            } else if (ab == 6) {
               ay = mSystem.loadImageRMS("/bg/sun5" + (TileMap.p == 0 ? "" : "-" + TileMap.p) + ".png");
               az = mSystem.loadImageRMS("/bg/sun6" + (TileMap.p == 0 ? "" : "-" + TileMap.p) + ".png");
               aB = GameScr.d - GameScr.d / 3;
               aC = aL[4];
               aD = aB - 100;
               aE = aL[4] + 20;
            } else if (var0 == 5) {
               ay = mSystem.loadImageRMS("/bg/sun8" + (TileMap.p == 0 ? "" : "-" + TileMap.p) + ".png");
               az = mSystem.loadImageRMS("/bg/sun7" + (TileMap.p == 0 ? "" : "-" + TileMap.p) + ".png");
               aB = GameScr.d / 2 - 50;
               aC = aL[3] + 20;
               aD = GameScr.d / 2 + 20;
               aE = aL[3] - 30;
            } else if (ab == 8 && TileMap.l < 90) {
               ay = mSystem.loadImageRMS("/bg/sun9" + (TileMap.p == 0 ? "" : "-" + TileMap.p) + ".png");
               az = mSystem.loadImageRMS("/bg/sun10" + (TileMap.p == 0 ? "" : "-" + TileMap.p) + ".png");
               aB = GameScr.d / 2 - 30;
               aC = aL[3] + 60;
               aD = GameScr.d / 2 + 20;
               aE = aL[3] + 10;
            } else if (var0 == 9) {
               ay = mSystem.loadImageRMS("/bg/sun11" + (TileMap.p == 0 ? "" : "-" + TileMap.p) + ".png");
               az = mSystem.loadImageRMS("/bg/sun12" + (TileMap.p == 0 ? "" : "-" + TileMap.p) + ".png");
               aB = GameScr.d - GameScr.d / 3;
               aC = aL[4] + 20;
               aD = aB - 80;
               aE = aL[4] + 40;
            } else if (var0 == 10) {
               ay = mSystem.loadImageRMS("/bg/sun13" + (TileMap.p == 0 ? "" : "-" + TileMap.p) + ".png");
               az = mSystem.loadImageRMS("/bg/sun14" + (TileMap.p == 0 ? "" : "-" + TileMap.p) + ".png");
               aB = GameScr.d - GameScr.d / 3;
               aC = aL[1] - 30;
               aD = aB - 80;
               aE = aL[1];
            } else if (var0 == 11) {
               ay = mSystem.loadImageRMS("/bg/sun15" + (TileMap.p == 0 ? "" : "-" + TileMap.p) + ".png");
               az = mSystem.loadImageRMS("/bg/b113" + (TileMap.p == 0 ? "" : "-" + TileMap.p) + ".png");
               aB = GameScr.d / 2 - 30;
               aC = aL[2] - 30;
            } else if (var0 == 12) {
               Z = new int[]{200, 170, 220, 150, 250};
            } else if (var0 != 16) {
               if (var0 == 19) {
                  aG = new int[]{0, 2, 1, 0, 0};
                  aH = new int[]{0, 2, 1, 0, 0};
                  aN = 5;
               } else {
                  ay = null;
                  az = null;
                  ay = mSystem.loadImageRMS("/bg/sun" + var0 + (TileMap.p == 0 ? "" : "-" + TileMap.p) + ".png");
                  aB = GameScr.d - GameScr.d / 3;
                  aC = aL[2] - 30;
               }
            } else {
               Y = new int[]{90, 170, 250, 320, 400, 450, 500};
               Z = new int[]{aL[2] + 5, aL[2] - 20, aL[2] - 50, aL[2] - 30, aL[2] - 50, aL[2], aL[2] - 40};
               aA = new Image[7];

               for(var6 = 0; var6 < aA.length; ++var6) {
                  short var9 = 160;
                  if (var6 == 1 || var6 == 3) {
                     var9 = 161;
                  }

                  aA[var6] = mSystem.loadImageRMS("/bg/sun" + var9 + ".png");
               }
            }
         }

         ax = false;
         if (true) {
            ax = true;
            return;
         }
      } catch (Exception var5) {
         aR = false;
      }

   }

   private static void c(int var0) {
      for(int var1 = 0; var1 < aO.length; ++var1) {
         if (var0 == aO[var1] && ResLog.random(0, 2) == 0) {
            BackgroudEffect.a(0);
            return;
         }
      }

   }

   public final void keyPressed(int var1) {
       System.out.println(var1);
      aS = System.currentTimeMillis();
      if (var1 >= 48 && var1 <= 57 || var1 >= 65 && var1 <= 122 || var1 == 10 || var1 == 8 || var1 == 13 || var1 == 32 || var1 == 31) {
         ae = var1;
      }

      if (currentDialog != null) {
         currentDialog.a(var1);
         ae = 0;
      } else {
         currentScreen.keyPress(var1);
         switch(var1) {
         case -39:
         case -2:
            if (currentScreen instanceof GameScr || currentScreen instanceof CrackBallScr) {
               Char.myCharz();
            }

            j[8] = true;
            keyPressed[8] = true;
            return;
         case -38:
         case -1:
            if (currentScreen instanceof GameScr || currentScreen instanceof CrackBallScr) {
               Char.myCharz();
            }

            j[2] = true;
            keyPressed[2] = true;
            return;
         case -22:
         case -7:
            j[13] = true;
            keyPressed[13] = true;
            return;
         case -21:
         case -6:
            j[12] = true;
            keyPressed[12] = true;
            return;
         case -5:
         case 10:
            if (currentScreen instanceof GameScr || currentScreen instanceof CrackBallScr) {
               Char.myCharz();
            }

            j[5] = true;
            keyPressed[5] = true;
            return;
         case -4:
            if (currentScreen instanceof GameScr || currentScreen instanceof CrackBallScr) {
               Char.myCharz();
            }

            j[6] = true;
            keyPressed[6] = true;
            return;
         case -3:
            if (currentScreen instanceof GameScr || currentScreen instanceof CrackBallScr) {
               Char.myCharz();
            }

            j[4] = true;
            keyPressed[4] = true;
            return;
         case 35:
            j[11] = true;
            keyPressed[11] = true;
            return;
         case 42:
            j[10] = true;
            keyPressed[10] = true;
            return;
         case 48:
            j[0] = true;
            keyPressed[0] = true;
            return;
         case 49:
            if (currentScreen == CrackBallScr.a || currentScreen == GameScr.c && c && !ChatTextField.gI().b) {
               j[1] = true;
               keyPressed[1] = true;
            }

            return;
         case 50:
            if (currentScreen == CrackBallScr.a || currentScreen == GameScr.c && c && !ChatTextField.gI().b) {
               j[2] = true;
               keyPressed[2] = true;
            }

            return;
         case 51:
            if (currentScreen == CrackBallScr.a || currentScreen == GameScr.c && c && !ChatTextField.gI().b) {
               j[3] = true;
               keyPressed[3] = true;
            }

            return;
         case 52:
            if (currentScreen == CrackBallScr.a || currentScreen == GameScr.c && c && !ChatTextField.gI().b) {
               j[4] = true;
               keyPressed[4] = true;
            }

            return;
         case 53:
            if (currentScreen == CrackBallScr.a || currentScreen == GameScr.c && c && !ChatTextField.gI().b) {
               j[5] = true;
               keyPressed[5] = true;
            }
         default:
            return;
         case 54:
            if (currentScreen == CrackBallScr.a || currentScreen == GameScr.c && c && !ChatTextField.gI().b) {
               j[6] = true;
               keyPressed[6] = true;
            }

            return;
         case 55:
            j[7] = true;
            keyPressed[7] = true;
            return;
         case 56:
            if (currentScreen == CrackBallScr.a || currentScreen == GameScr.c && c && !ChatTextField.gI().b) {
               j[8] = true;
               keyPressed[8] = true;
            }

            return;
         case 57:
            j[9] = true;
            keyPressed[9] = true;
         }
      }
   }

   public final void keyReleased(int var1) {
      ae = 0;
      switch(var1) {
      case -39:
      case -2:
         j[8] = false;
         return;
      case -38:
      case -1:
         j[2] = false;
         return;
      case -22:
      case -7:
         j[13] = false;
         an[13] = true;
         return;
      case -21:
      case -6:
         j[12] = false;
         an[12] = true;
         return;
      case -5:
      case 10:
         j[5] = false;
         an[5] = true;
         return;
      case -4:
         j[6] = false;
         return;
      case -3:
         j[4] = false;
         return;
      case 35:
         j[11] = false;
         an[11] = true;
         return;
      case 42:
         j[10] = false;
         an[10] = true;
         return;
      case 48:
         j[0] = false;
         an[0] = true;
         return;
      case 49:
         if (currentScreen == GameScr.c && c && !ChatTextField.gI().b) {
            j[1] = false;
            an[1] = true;
         }

         return;
      case 50:
         if (currentScreen == GameScr.c && c && !ChatTextField.gI().b) {
            j[2] = false;
            an[2] = true;
         }

         return;
      case 51:
         if (currentScreen == GameScr.c && c && !ChatTextField.gI().b) {
            j[3] = false;
            an[3] = true;
         }

         return;
      case 52:
         if (currentScreen == GameScr.c && c && !ChatTextField.gI().b) {
            j[4] = false;
            an[4] = true;
         }

         return;
      case 53:
         if (currentScreen == GameScr.c && c && !ChatTextField.gI().b) {
            j[5] = false;
            an[5] = true;
         }
      default:
         return;
      case 54:
         if (currentScreen == GameScr.c && c && !ChatTextField.gI().b) {
            j[6] = false;
            an[6] = true;
         }

         return;
      case 55:
         j[7] = false;
         an[7] = true;
         return;
      case 56:
         if (currentScreen == GameScr.c && c && !ChatTextField.gI().b) {
            j[8] = false;
            an[8] = true;
         }

         return;
      case 57:
         j[9] = false;
         an[9] = true;
      }
   }

   public final void onDrag(int var1, int var2) {
      if (ResLog.g(var1 - s) >= 10 || ResLog.g(var2 - t) >= 10) {
         l = false;
         k = true;
         n = true;
      }

      o = var1;
      p = var2;
      if (++ar > 3) {
         ar = 0;
      }

      u[ar] = new nr_bd(var1, var2);
   }

   public final void onPress(int var1, int var2) {
      m = false;
      ah = true;
      k = true;
      l = true;
      n = false;
      aS = System.currentTimeMillis();
      q = var1;
      r = var2;
      s = var1;
      t = var2;
      o = var1;
      p = var2;
   }

   public final void onRelease(int var1, int var2) {
      k = false;
      m = true;
      n = false;
      mScreen.cf = -1;
      o = var1;
      p = var2;
   }

   public static boolean isPointerHoldIn(int var0, int var1, int var2, int var3) {
      if (!k && !m) {
         return false;
      } else {
         return o >= var0 && o <= var0 + var2 && p >= var1 && p <= var1 + var3;
      }
   }

   public static void clearKeyPressed() {
      for(int var0 = 0; var0 < 14; ++var0) {
         keyPressed[var0] = false;
      }

      m = false;
   }

   public static void f() {
      for(int var0 = 0; var0 < 14; ++var0) {
         j[var0] = false;
      }

   }

   public final void paint(Graphics var1) {
      this.as.graphics = var1;
      au.removeAllElements();
      if (currentScreen != null) {
         currentScreen.paint(this.as);
      }

      this.as.setColor(-this.as.setColor(), -this.as.b());
      this.as.e(0, 0, z, A);
      if (panel.isShow) {
         panel.a(this.as);
         if (G != null && G.isShow) {
            G.a(this.as);
         }

         if (panel.o != null && panel.o.b) {
            panel.o.a(this.as);
         }

         if (G != null && G.o != null && G.o.b) {
            G.o.a(this.as);
         }
      }

      if (GameScr.bO) {
         ResLog.a(this.as);
      }

      InfoDlg.a(this.as);
      if (currentDialog != null) {
         currentDialog.a(this.as);
      } else if (menu.a) {
         menu.a(this.as);
      }

      GameScr.info1.a(this.as);
      GameScr.aD.a(this.as);
      if (GameScr.gI().popUpYesNo != null) {
         GameScr.gI().popUpYesNo.paint(this.as);
      }

      if (ChatPopup.currChatPopup != null) {
         ChatPopup.currChatPopup.paint(this.as);
      }

      mGraphics var9 = this.as;
      if (ChatPopup.serverChatPopUp == null && !Char.myCharz().t && !Char.myCharz().s) {
         mGraphics var2 = var9;

         try {
            if (Hint.m && (Hint.a <= GameScr.cmx || Hint.a >= GameScr.cmx + GameScr.d || Hint.b <= GameScr.cmy || Hint.b >= GameScr.cmy + GameScr.e) && v % 10 >= 5 && ChatPopup.currChatPopup == null && ChatPopup.serverChatPopUp == null && !panel.isShow && Hint.j) {
               int var3 = Hint.a - Char.myCharz().cx;
               int var4 = Hint.b - Char.myCharz().cy;
               int var5 = 0;
               int var6 = 0;
               byte var7 = 0;
               if (var3 > 0 && var4 >= 0) {
                  if (ResLog.g(var3) >= ResLog.g(var4)) {
                     var5 = GameScr.d - 10;
                     var6 = GameScr.e / 2 + 30;
                     if (isTouch) {
                        var6 = GameScr.e / 2 + 10;
                     }

                     var7 = 0;
                  } else {
                     var5 = GameScr.d / 2;
                     var6 = GameScr.e - 10;
                     var7 = 5;
                  }
               } else if (var3 >= 0 && var4 < 0) {
                  if (ResLog.g(var3) >= ResLog.g(var4)) {
                     var5 = GameScr.d - 10;
                     var6 = GameScr.e / 2 + 30;
                     if (isTouch) {
                        var6 = GameScr.e / 2 + 10;
                     }

                     var7 = 0;
                  } else {
                     var5 = GameScr.d / 2;
                     var6 = 10;
                     var7 = 6;
                  }
               }

               if (var3 < 0 && var4 >= 0) {
                  if (ResLog.g(var3) >= ResLog.g(var4)) {
                     var5 = 10;
                     var6 = GameScr.e / 2 + 30;
                     if (isTouch) {
                        var6 = GameScr.e / 2 + 10;
                     }

                     var7 = 3;
                  } else {
                     var5 = GameScr.d / 2;
                     var6 = GameScr.e - 10;
                     var7 = 5;
                  }
               } else if (var3 <= 0 && var4 < 0) {
                  if (ResLog.g(var3) >= ResLog.g(var4)) {
                     var5 = 10;
                     var6 = GameScr.e / 2 + 30;
                     if (isTouch) {
                        var6 = GameScr.e / 2 + 10;
                     }

                     var7 = 3;
                  } else {
                     var5 = GameScr.d / 2;
                     var6 = 10;
                     var7 = 6;
                  }
               }

               GameScr.c(var2);
               var2.setColor(GameScr.bv, 0, 0, 13, 16, var7, var5, var6, StaticObj.f);
            }
         } catch (Exception var8) {
         }

         if (menu.e == 0 && Hint.i && ChatPopup.q == null && !Char.bG && currentScreen == GameScr.gI() && (!panel.isShow || panel.h == 0)) {
            if (Hint.j) {
               var9.setColor(-GameScr.cmx, -GameScr.cmy);
            }

            if (Hint.k == 0) {
               var9.drawImage(Panel.i, Hint.a - 15, Hint.b, 0);
            }

            if (Hint.k == 1) {
               var9.setColor(Panel.i, 0, 0, 14, 16, 2, Hint.a + 15, Hint.b, StaticObj.TOP_RIGHT);
            }

            if (Hint.l) {
               var9.drawImage(ItemMap.myTexture2dflare, Hint.a, Hint.b, 3);
            }

            var9.setColor(-var9.setColor(), -var9.b());
         }
      }

      if (ChatPopup.serverChatPopUp != null) {
         ChatPopup.serverChatPopUp.paint(this.as);
      }

      int var10;
      for(var10 = 0; var10 < Effect2.vEffect2.size(); ++var10) {
         Effect2 var11;
         if ((var11 = (Effect2)Effect2.vEffect2.elementAt(var10)) instanceof ChatPopup && !var11.equals(ChatPopup.currChatPopup) && !var11.equals(ChatPopup.serverChatPopUp)) {
            var11.paint(this.as);
         }
      }

      if (Char.isLoadingMap || LoginScr.c || ServerListScreen.l) {
         var9 = this.as;
         String var13 = "";
         a(var9);
         var9.setColor(0);
         var9.fillRect(0, 0, z, A);
         var9.drawImage(LoginScr.j, z / 2, A / 2 - 24, StaticObj.c);
         a(B, A / 2 + 24, var9);
         mFont.c.drawStringBd(var9, mResources.aA + (LoginScr.k > 0 ? " " + LoginScr.k + "s" : var13), z / 2, A / 2, 2);
         if (bk > 0 && LoginScr.k <= 0) {
            Char.isLoadingMap = true;
            if (mSystem.currentTimeMillis() - bj >= 1000L) {
               if (--bk == 0) {
                  bk = 15;
               }

               bj = mSystem.currentTimeMillis();
            }
         }

         if (mSystem.currentTimeMillis() > ag) {
            ag = mSystem.currentTimeMillis() + 30000L;
            if (currentScreen != null) {
               if (currentScreen instanceof GameScr) {
                  GameScr.gI().switchToMe();
               } else if (!(currentScreen instanceof SplashScr) && currentScreen instanceof LoginScr) {
                  h.bi = true;
               }
            }
         }
      }

      a(this.as);
      EffecMn.d(this.as);
      if (al && !isLoading) {
         if (currentScreen == loginScr || currentScreen == serverScreen || currentScreen == ak) {
            this.as.drawImage(af, 5, 5, 0);
         }

         if (currentScreen == nr_cu.a) {
            this.as.drawImage(af, 5, 20, 0);
         }
      }

      for(var10 = 0; var10 < aZ.size(); ++var10) {
         String var12 = (String)aZ.elementAt(var10);
         mFont.a.drawStringBd(this.as, var12, z, A - this.ba - var10 * this.ba, 1);
         mFont.c.drawStringBd(this.as, var12, z - 1, A - this.ba - var10 * this.ba - 1, 1);
      }

      a(this.as);
      var10 = A / 4;
      if (currentScreen != null && currentScreen instanceof GameScr && aX != null) {
         this.as.e(60, var10, z - 120, mFont.s.getWidth() + 2);
         mFont.o.drawStringBd(this.as, aX, aY, var10 + 1, 0);
         mFont.n.drawStringBd(this.as, aX, aY, var10, 0);
         this.as.e(0, 0, z, A);
      }

   }

   public static void endDlg() {
      currentDialog = null;
      InfoDlg.hide();
   }

   public static void startOKDlg(String var0) {
      msgdlg.setInfo(var0, (CommandLine)null, new CommandLine(mResources.OK, h, 8882, (Object)null), (CommandLine)null);
      currentDialog = msgdlg;
   }

   public static void startWaitDlg(String var0) {
      msgdlg.setInfo(var0, (CommandLine)null, new CommandLine(mResources.bu, h, 8882, (Object)null), (CommandLine)null);
      currentDialog = msgdlg;
      msgdlg.a = true;
   }

   public static void c(String var0) {
      msgdlg.setInfo(var0, (CommandLine)null, new CommandLine(mResources.bu, h, 8882, (Object)null), (CommandLine)null);
      currentDialog = msgdlg;
      msgdlg.a = true;
   }

   public static void startWaitDlg() {
      Char.isLoadingMap = true;
   }

   public static void startOK(String var0, int var1, Object var2) {
      msgdlg.setInfo(var0, (CommandLine)null, new CommandLine(mResources.OK, h, var1, (Object)null), (CommandLine)null);
      msgdlg.c();
   }

   public static void startYesNoDlg(String var0, CommandLine var1, CommandLine var2) {
      msgdlg.setInfo(var0, var1, (CommandLine)null, var2);
      msgdlg.c();
   }

   public final void sizeChanged(int var1, int var2) {
   }

   public final boolean a(int var1, int var2, int var3) {
      if (a) {
         return false;
      } else {
         var1 = var1 == 1 ? 0 : 1;
         if (this.bd[var1] != -1) {
            return false;
         } else {
            this.bd[var1] = 0;
            this.bb[var1] = var2;
            this.bc[var1] = var3;
            return true;
         }
      }
   }

   private static void n() {
      if (!a) {
         bf = new Image[3];

         for(int var0 = 0; var0 < 3; ++var0) {
            bf[var0] = mSystem.load("/e/w" + var0 + ".png");
         }

         (be = new int[2])[0] = be[1] = -1;
      }
   }

   public final void i() {
      if (!a) {
         try {
            for(int var1 = 0; var1 < 2; ++var1) {
               if (this.bd[var1] != -1) {
                  int var10002 = this.bd[var1]++;
                  if (this.bd[var1] >= 5) {
                     this.bd[var1] = -1;
                  }

                  if (var1 == 0) {
                     var10002 = this.bb[var1]--;
                  } else {
                     var10002 = this.bb[var1]++;
                  }

                  var10002 = this.bc[var1]--;
               }
            }

         } catch (Exception var2) {
         }
      }
   }

   public static boolean d(int var0, int var1) {
      if (var0 < GameScr.cmx) {
         return false;
      } else if (var0 > GameScr.cmx + GameScr.d) {
         return false;
      } else if (var1 < GameScr.cmy) {
         return false;
      } else {
         return var1 <= GameScr.cmy + GameScr.e + 30;
      }
   }

   public static void a(int var0, int var1, mGraphics var2) {
      int var3 = ao % (mSystem.d == 7 ? 8 : 9);
      if (++ao == 1000) {
         ao = 0;
      }

      var2.setColor(bg, 0, var3 << 4, 16, 16, 0, var0, var1, 3);
   }

   public final void j() {
      this.bi = true;
   }

   public static boolean b(int var0, int var1, int var2, int var3) {
      if (!k && !m) {
         return false;
      } else {
         return o >= var0 && o <= var0 + var2 && p >= var1 && p <= var1 + var3;
      }
   }

   public final void perform(int var1, Object var2) {
      String var9;
      short var15;
      switch(var1) {
      case 999:
         currentDialog = null;
         InfoDlg.hide();
         return;
      case 8881:
         var9 = (String)var2;

         try {
            GameMidlet.instance.platformRequest(var9);
         } catch (Exception var8) {
            var8.printStackTrace();
         }

         currentDialog = null;
         return;
      case 8882:
         InfoDlg.hide();
         currentDialog = null;
         ServerListScreen.v = false;
         ServerListScreen.k = 0;
         return;
      case 8884:
         currentDialog = null;
         InfoDlg.hide();
         loginScr.switchToMe();
         return;
      case 8885:
         GameMidlet.instance.a();
         return;
      case 8886:
         currentDialog = null;
         InfoDlg.hide();
         var9 = (String)var2;
         Service.gI().c(var9);
         return;
      case 8887:
         currentDialog = null;
         InfoDlg.hide();
         var1 = ((Integer)var2).intValue();
         Service.gI().m(var1);
         return;
      case 8888:
         var1 = ((Integer)var2).intValue();
         Service.gI().n(var1);
         currentDialog = null;
         InfoDlg.hide();
         return;
      case 8889:
         var9 = (String)var2;
         currentDialog = null;
         InfoDlg.hide();
         Service.gI().d(var9);
         return;
      case 9000:
         currentDialog = null;
         InfoDlg.hide();
         SplashScr.b = null;
         SmallImage.loadBigRMS();
         System.gc();
         ServerListScreen.o = true;
         ServerListScreen.loadScreen = true;
         GameScr.gI().o();
         if (currentScreen != loginScr) {
            serverScreen.g();
            return;
         }
         break;
      case 9999:
         currentDialog = null;
         InfoDlg.hide();
         connect();
         Service.gI().setClientType();
         loginScr.doLogin();
         return;
      case 10000:
         currentDialog = null;
         InfoDlg.hide();
         return;
      case 10001:
         currentDialog = null;
         InfoDlg.hide();
         return;
      case 88810:
         var1 = ((Integer)var2).intValue();
         currentDialog = null;
         InfoDlg.hide();
         Service.gI().k(var1);
         return;
      case 88811:
         currentDialog = null;
         InfoDlg.hide();
         Service.gI().i();
         return;
      case 88814:
         Item[] var17 = (Item[])var2;
         currentDialog = null;
         InfoDlg.hide();
         Service.gI().a(var17);
         return;
      case 88815:
         return;
      case 88817:
         ChatPopup.c("", 1, Char.myCharz().aT);
         Service.gI().a((int)Char.myCharz().aT.template.npcTemplateId, (int)menu.b, (int)0);
         return;
      case 88818:
         var15 = ((Short)var2).shortValue();
         Service.gI().textBoxId(var15, ((InputDlg)null).a.getText());
         currentDialog = null;
         InfoDlg.hide();
         return;
      case 88819:
         var15 = ((Short)var2).shortValue();
         Service.gI().b(var15);
         return;
      case 88820:
         String[] var14 = (String[])var2;
         if (Char.myCharz().aT == null) {
            return;
         }

         Integer var11 = new Integer(menu.b);
         if (var14.length <= 1) {
            ChatPopup.c("", 1, Char.myCharz().aT);
            Service.gI().a((int)Char.myCharz().aT.template.npcTemplateId, var11.intValue(), (int)0);
            return;
         }

         MyVector var13 = new MyVector("vSub");

         for(int var16 = 0; var16 < var14.length - 1; ++var16) {
            var13.addElement(new CommandLine(var14[var16 + 1], h, 88821, var11));
         }

         menu.startAt(var13);
         return;
      case 88821:
         Integer var3 = (Integer)var2;
         ChatPopup.c("", 1, Char.myCharz().aT);
         Service.gI().a(Char.myCharz().aT.template.npcTemplateId, var3.intValue(), menu.b);
         return;
      case 88822:
         ChatPopup.c("", 1, Char.myCharz().aT);
         Service.gI().a((int)Char.myCharz().aT.template.npcTemplateId, (int)menu.b, (int)0);
         return;
      case 88823:
         startOKDlg(mResources.K);
         return;
      case 88824:
         startOKDlg(mResources.L);
         return;
      case 88825:
         c(mResources.M);
         return;
      case 88826:
         c(mResources.N);
         return;
      case 88827:
         startOKDlg(mResources.O);
         return;
      case 88828:
         startOKDlg(mResources.P);
         return;
      case 88829:
         String var4;
         if ((var4 = ((InputDlg)null).a.getText()).equals("")) {
            return;
         }

         Service.gI().b(var4, ((Integer)var2).intValue());
         InfoDlg.a();
         return;
      case 88836:
         ((InputDlg)null).a.b(6);
         //null.a(nr_av.S, new nr_dc(nr_av.bt, h, 888361, (Object)null), 1);
         return;
      case 88837:
         var9 = ((InputDlg)null).a.getText();
         currentDialog = null;
         InfoDlg.hide();

         try {
            Service.gI().s(Integer.parseInt(var9.trim()));
            return;
         } catch (Exception var7) {
            return;
         }
      case 88839:
         var9 = ((InputDlg)null).a.getText();
         currentDialog = null;
         InfoDlg.hide();
         if (var9.length() >= 6 && !var9.equals("")) {
            try {
               String var10002 = var9;
               var9 = null;
               boolean var12 = true;
               String var10 = var10002;
               var1 = 888391;
               var9 = mResources.ag;
               msgdlg.setInfo(var9, new CommandLine(mResources.bm, h, 888391, var10), new CommandLine("", h, 888391, var10), new CommandLine(mResources.bn, h, 8882, (Object)null));
               msgdlg.c();
               return;
            } catch (Exception var6) {
               startOKDlg(mResources.R);
               return;
            }
         }

         startOKDlg(mResources.Q);
         return;
      case 101024:
         currentDialog = null;
         InfoDlg.hide();
         return;
      case 101025:
         currentDialog = null;
         InfoDlg.hide();
         if (ServerListScreen.loadScreen) {
            serverScreen.switchToMe();
            return;
         }

         serverScreen.show2();
         break;
      case 888361:
         var9 = ((InputDlg)null).a.getText();
         currentDialog = null;
         InfoDlg.hide();
         if (var9.length() >= 6 && !var9.equals("")) {
            try {
               Service.gI().q(Integer.parseInt(var9));
               return;
            } catch (Exception var5) {
               startOKDlg(mResources.R);
               return;
            }
         }

         startOKDlg(mResources.Q);
         return;
      case 888391:
         var9 = (String)var2;
         currentDialog = null;
         InfoDlg.hide();
         Service.gI().r(Integer.parseInt(var9));
         return;
      case 888392:
         Service.gI().a((int)4, (int)menu.b, (int)0);
         return;
      case 888393:
         loginScr.doLogin();
         return;
      case 888394:
         currentDialog = null;
         InfoDlg.hide();
         return;
      case 888395:
         if (!currentScreen.equals(SplashScr.a) && !currentScreen.equals(serverScreen)) {
            loginScr.switchToMe();
         } else {
            serverScreen.switchToMe();
         }

         currentDialog = null;
         InfoDlg.hide();
         return;
      case 888396:
         currentDialog = null;
         InfoDlg.hide();
         return;
      case 888397:
         currentDialog = null;
         InfoDlg.hide();
         return;
      }

   }

   public static void k() {
      l = false;
      k = false;
      ah = false;
      m = false;
      GameScr.gI().aT = 0L;
      GameScr.gI().aS = false;
   }
}
