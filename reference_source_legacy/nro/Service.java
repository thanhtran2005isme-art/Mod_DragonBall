package nro;

import java.io.IOException;
import java.io.InputStream;

public final class Service {
   ISession sessionMe2 = Session_ME2.Session_ME();
   private static Service g;
   public static long b;
   public static long c;
   public static long d;
   public static long e;
   public static boolean f;

   public static Service gI() {
      if (g == null) {
         g = new Service();
      }

      return g;
   }

   public final void a(int var1) {
      Message var2 = null;

      try {
         (var2 = new Message((byte)18)).writer().writeInt(var1);
         this.sessionMe2.sendMessage(var2);
         return;
      } catch (Exception var5) {
         var5.printStackTrace();
      } finally {
         var2.cleanup();
      }

   }

   public final void a(String var1, String var2, String var3, String var4, String var5, String var6, String var7, String var8, String var9) {
      Message var10 = null;

      try {
         (var10 = new Message((byte)42)).writer().writeUTF(var1);
         var10.writer().writeUTF(var2);
         var10.writer().writeUTF(var3);
         var10.writer().writeUTF(var4);
         var10.writer().writeUTF(var5);
         var10.writer().writeUTF(var6);
         var10.writer().writeUTF(var7);
         var10.writer().writeUTF(var8);
         var10.writer().writeUTF(var9);
         this.sessionMe2.sendMessage(var10);
         return;
      } catch (Exception var13) {
         var13.printStackTrace();
      } finally {
         var10.cleanup();
      }

   }

   public final void a(byte var1, MyVector var2) {
      ResLog.c("combine");
      Message var8 = null;

      try {
         (var8 = new Message((byte)-81)).writer().writeByte(1);
         var8.writer().writeByte(var2.size());

         for(int var3 = 0; var3 < var2.size(); ++var3) {
            var8.writer().writeByte(((Item)var2.elementAt(var3)).g);
            ResLog.c("gui id " + ((Item)var2.elementAt(var3)).g);
         }

         this.sessionMe2.sendMessage(var8);
         return;
      } catch (Exception var6) {
         var6.printStackTrace();
      } finally {
         var8.cleanup();
      }

   }

   public final void a(byte var1, int var2, byte var3, int var4) {
      ResLog.c("giao dich action = " + var1);
      Message var5 = null;

      try {
         (var5 = new Message((byte)-86)).writer().writeByte(var1);
         if (var1 == 0 || var1 == 1) {
            var5.writer().writeInt(var2);
         }

         if (var1 == 2) {
            ResLog.c("gui len indxe =" + var3 + " num= " + var4);
            var5.writer().writeByte(var3);
            var5.writer().writeInt(var4);
         }

         if (var1 == 4) {
            var5.writer().writeByte(var3);
         }

         this.sessionMe2.sendMessage(var5);
         return;
      } catch (Exception var8) {
         var8.printStackTrace();
      } finally {
         var5.cleanup();
      }

   }

   public final void a(TField[] var1) {
      Message var2 = null;

      try {
         (var2 = new Message((byte)-125)).writer().writeByte(var1.length);

         for(int var3 = 0; var3 < var1.length; ++var3) {
            var2.writer().writeUTF(var1[var3].getText());
         }

         this.sessionMe2.sendMessage(var2);
         return;
      } catch (Exception var6) {
         var6.printStackTrace();
      } finally {
         var2.cleanup();
      }

   }

   public final void a(byte var1) {
      Message var7 = null;

      try {
         (var7 = new Message((byte)112)).writer().writeByte(0);
         this.sessionMe2.sendMessage(var7);
         return;
      } catch (Exception var5) {
         var5.printStackTrace();
      } finally {
         var7.cleanup();
      }

   }

   public final void a(char var1) {
      ResLog.c("cap char c= " + var1);
      Message var2 = null;

      try {
         (var2 = new Message((byte)-85)).writer().writeChar(var1);
         this.sessionMe2.sendMessage(var2);
         return;
      } catch (Exception var5) {
         var5.printStackTrace();
      } finally {
         var2.cleanup();
      }

   }

   public final void a(byte var1, int var2) {
      ResLog.c("add friend");
      Message var3 = null;

      try {
         (var3 = new Message((byte)-80)).writer().writeByte(var1);
         if (var2 != -1) {
            var3.writer().writeInt(var2);
         }

         this.sessionMe2.sendMessage(var3);
         return;
      } catch (Exception var6) {
         var6.printStackTrace();
      } finally {
         var3.cleanup();
      }

   }

   public final void b(int var1) {
      ResLog.c("get ngoc");
      Message var2 = null;

      try {
         (var2 = new Message((byte)-76)).writer().writeByte(var1);
         this.sessionMe2.sendMessage(var2);
         return;
      } catch (Exception var5) {
         var5.printStackTrace();
      } finally {
         var2.cleanup();
      }

   }

   public final void c(int var1) {
      Message var2 = null;

      try {
         (var2 = new Message((byte)-79)).writer().writeInt(var1);
         this.sessionMe2.sendMessage(var2);
         return;
      } catch (Exception var5) {
         var5.printStackTrace();
      } finally {
         var2.cleanup();
      }

   }

   public final void b(byte var1) {
      Message var2 = null;

      try {
         (var2 = new Message((byte)-62)).writer().writeByte(var1);
         this.sessionMe2.sendMessage(var2);
         return;
      } catch (Exception var5) {
         var5.printStackTrace();
      } finally {
         var2.cleanup();
      }

   }

   public final void c(byte var1) {
      ResLog.c("Skill not focus so " + var1);
      Message var2 = null;

      try {
         (var2 = new Message((byte)-45)).writer().writeByte(var1);
         this.sessionMe2.sendMessage(var2);
         return;
      } catch (Exception var5) {
         var5.printStackTrace();
      } finally {
         var2.cleanup();
      }

   }

   public final void d(int var1) {
      Message var2 = null;

      try {
         ResLog.c("CLAN DONATE");
         (var2 = new Message((byte)-54)).writer().writeInt(var1);
         this.sessionMe2.sendMessage(var2);
         return;
      } catch (Exception var5) {
         var5.printStackTrace();
      } finally {
         var2.cleanup();
      }

   }

   public final void a(int var1, String var2, int var3) {
      Message var4 = null;

      try {
         ResLog.c("CLAN MESSAGE");
         (var4 = new Message((byte)-51)).writer().writeByte(var1);
         if (var1 == 0) {
            var4.writer().writeUTF(var2);
         }

         if (var1 == 2) {
            var4.writer().writeInt(var3);
         }

         this.sessionMe2.sendMessage(var4);
         return;
      } catch (Exception var7) {
         var7.printStackTrace();
      } finally {
         var4.cleanup();
      }

   }

   public final void a(byte var1, byte var2, byte var3, short var4) {
      if (Char.myCharz().statusMe != 14) {
         Message var5 = null;

         try {
            (var5 = new Message((byte)-43)).writer().writeByte(var1);
            var5.writer().writeByte(var2);
            var5.writer().writeByte(var3);
            if (var3 == -1) {
               var5.writer().writeShort(var4);
            }

            this.sessionMe2.sendMessage(var5);
            return;
         } catch (Exception var8) {
            var8.printStackTrace();
         } finally {
            var5.cleanup();
         }

      }
   }

   public final void a(int var1, byte var2) {
      ResLog.c("JOIN CLAN " + var1);
      Message var3 = null;

      try {
         (var3 = new Message((byte)-49)).writer().writeInt(var1);
         var3.writer().writeByte(var2);
         this.sessionMe2.sendMessage(var3);
         return;
      } catch (Exception var6) {
         var6.printStackTrace();
      } finally {
         var3.cleanup();
      }

   }

   public final void e(int var1) {
      ResLog.c("MEMBER CLAN " + var1);
      Message var2 = null;

      try {
         (var2 = new Message((byte)-50)).writer().writeInt(var1);
         this.sessionMe2.sendMessage(var2);
         return;
      } catch (Exception var5) {
         var5.printStackTrace();
      } finally {
         var2.cleanup();
      }

   }

   public final void a(String var1) {
      ResLog.c("send SEARCH CLAN " + var1);
      Message var2 = null;

      try {
         (var2 = new Message((byte)-47)).writer().writeUTF(var1);
         this.sessionMe2.sendMessage(var2);
         return;
      } catch (Exception var5) {
         var5.printStackTrace();
      } finally {
         var2.cleanup();
      }

   }

   public final void b(int var1, byte var2) {
      ResLog.c("REMOTE CLAN id = " + var1 + " role= " + var2);
      Message var3 = null;

      try {
         (var3 = new Message((byte)-56)).writer().writeInt(var1);
         var3.writer().writeByte(var2);
         this.sessionMe2.sendMessage(var3);
         return;
      } catch (Exception var6) {
         var6.printStackTrace();
      } finally {
         var3.cleanup();
      }

   }

   public final void b() {
      ResLog.c("LEAVE CLAN");
      Message var1 = null;

      try {
         var1 = new Message((byte)-55);
         this.sessionMe2.sendMessage(var1);
         return;
      } catch (Exception var5) {
         var5.printStackTrace();
      } finally {
         var1.cleanup();
      }

   }

   public final void a(byte var1, int var2, int var3, int var4) {
      ResLog.c("invite action = " + var1 + "layerid= " + var2 + " clanID= " + var3 + " code= " + var4);
      Message var5 = null;

      try {
         (var5 = new Message((byte)-57)).writer().writeByte(var1);
         if (var1 == 0) {
            var5.writer().writeInt(var2);
         }

         if (var1 == 1 || var1 == 2) {
            var5.writer().writeInt(var3);
            var5.writer().writeInt(var4);
         }

         this.sessionMe2.sendMessage(var5);
         return;
      } catch (Exception var8) {
         var8.printStackTrace();
      } finally {
         var5.cleanup();
      }

   }

   public final void a(byte var1, byte var2, String var3) {
      Message var4 = null;

      try {
         (var4 = new Message((byte)-46)).writer().writeByte(var1);
         if (var1 == 2 || var1 == 4) {
            var4.writer().writeByte(var2);
            var4.writer().writeUTF(var3);
            ResLog.c("SEND SLOGAN= " + var3);
         }

         this.sessionMe2.sendMessage(var4);
         return;
      } catch (Exception var7) {
         var7.printStackTrace();
      } finally {
         var4.cleanup();
      }

   }

   public final void a(byte var1, byte var2) {
      Message var3 = null;

      try {
         (var3 = new Message((byte)-40)).writer().writeByte(var1);
         var3.writer().writeByte(var2);
         this.sessionMe2.sendMessage(var3);
         return;
      } catch (Exception var6) {
         var6.printStackTrace();
      } finally {
         var3.cleanup();
      }

   }

   public static Message d(byte var0) throws IOException {
      Message var1;
      (var1 = new Message((byte)-29)).writer().writeByte(var0);
      return var1;
   }

   private static Message j(byte var0) throws IOException {
      Message var1;
      (var1 = new Message((byte)-28)).writer().writeByte(var0);
      return var1;
   }

   public final void setClientType() {
      if (Rms.loadRMSInt("clienttype") != -1) {
         mSystem.d = Rms.loadRMSInt("clienttype");
      }

      try {
         ResLog.c("setType");
         Message var1;
         (var1 = d((byte)2)).writer().writeByte(mSystem.d);
         var1.writer().writeByte(mGraphics.zoomLevel);
         var1.writer().writeBoolean(false);
         var1.writer().writeInt(main.GameCanvas.z);
         var1.writer().writeInt(main.GameCanvas.A);
         var1.writer().writeBoolean(TField.g);
         var1.writer().writeBoolean(main.GameCanvas.isTouch);
         var1.writer().writeUTF(System.getProperty("microedition.platform") + "|" + "2.3.7");
         InputStream var2;
         if ((var2 = this.getClass().getResourceAsStream("res\\info")) != null) {
            var2.read((byte[])null);
            var1.writer().writeShort(((Object[])null).length);
            var1.writer().write((byte[])null);
            ResLog.b("write " + ((Object[])null).length + "|" + "2.3.7");
         }

         this.sessionMe2.sendMessage(var1);
         var1.cleanup();
      } catch (IOException var3) {
         var3.printStackTrace();
      }
   }

   public final void sendCheckController() {
      Message var1 = null;

      try {
         var1 = new Message((byte)-120);
         this.sessionMe2.sendMessage(var1);
         return;
      } catch (Exception var5) {
      } finally {
         b = mSystem.currentTimeMillis();
         var1.cleanup();
      }

   }

   public final void sendCheckMap() {
      Message var1 = null;

      try {
         var1 = new Message((byte)-121);
         this.sessionMe2.sendMessage(var1);
         return;
      } catch (Exception var5) {
      } finally {
         c = mSystem.currentTimeMillis();
         var1.cleanup();
      }

   }

   public final void login(String var1, String var2, String var3, byte var4) {
      ResLog.c("Login " + var1 + " " + var2 + " " + var3);

      try {
         Message var5;
         (var5 = d((byte)0)).writer().writeUTF(var1);
         var5.writer().writeUTF(var2);
         var5.writer().writeUTF(var3);
         var5.writer().writeByte(var4);
         var5.writer().writeByte(mResources.language);
         this.sessionMe2.sendMessage(var5);
         var5.cleanup();
      } catch (IOException var6) {
         var6.printStackTrace();
      }
   }

   public final void requestRegister(String var1, String var2, String var3, String var4) {
      ResLog.c("Request Register " + var1 + " " + var2 + " " + var4);

      try {
         Message var6;
         (var6 = d((byte)1)).writer().writeUTF(var1);
         var6.writer().writeUTF(var2);
         if (var3 != null && !var3.equals("")) {
            var6.writer().writeUTF(var3);
            var6.writer().writeUTF("a");
         }

         this.sessionMe2.sendMessage(var6);
         var6.cleanup();
      } catch (IOException var5) {
         var5.printStackTrace();
      }
   }

   public final void f() {
      Message var1 = new Message((byte)-23);
      this.sessionMe2.sendMessage(var1);
      var1.cleanup();
   }

   public final void e(byte var1) {
      Message var2 = new Message((byte)-34);

      try {
         var2.writer().writeByte(var1);
         this.sessionMe2.sendMessage(var2);
         var2.cleanup();
      } catch (Exception var3) {
      }
   }

   public final void f(int var1) {
      Message var2 = new Message((byte)21);

      try {
         var2.writer().writeByte(var1);
         this.sessionMe2.sendMessage(var2);
         var2.cleanup();
      } catch (Exception var3) {
      }
   }

   public final void g(int var1) {
      Message var2 = new Message((byte)-78);

      try {
         var2.writer().writeInt(var1);
         this.sessionMe2.sendMessage(var2);
         var2.cleanup();
      } catch (Exception var3) {
      }
   }

   public final void g() {
      int var1 = Char.myCharz().cx - Char.myCharz().bD;
      int var2 = Char.myCharz().cy - Char.myCharz().bE;
      if (!Char.bG && (var1 != 0 || var2 != 0) && !Controller.b && !Char.myCharz().s && Char.myCharz().cy > 0 && !Char.myCharz().cN) {
         try {
            Message var4 = new Message((byte)-7);
            Char.myCharz().bD = Char.myCharz().cx;
            Char.myCharz().bE = Char.myCharz().cy;
            Char.myCharz();
            Char.myCharz();
            Char.myCharz();
            Char.myCharz();
            if (TileMap.a(Char.myCharz().cx / TileMap.i, Char.myCharz().cy / TileMap.i) == 0) {
               var4.writer().writeByte(1);
               if (Char.myCharz().ao) {
                  if (!Char.myCharz().bu) {
                     Char var10000 = Char.myCharz();
                     var10000.cMP -= Char.myCharz().cs / 100 * (Char.myCharz().cC == 1 ? 2 : 1);
                  }

                  if (Char.myCharz().cMP < 0) {
                     Char.myCharz().cMP = 0;
                  }

                  GameScr.gI().bA = true;
                  GameScr.gI().bz = 0;
               }
            } else {
               var4.writer().writeByte(0);
            }

            var4.writer().writeShort(Char.myCharz().cx);
            if (var2 != 0) {
               var4.writer().writeShort(Char.myCharz().cy);
            }

            this.sessionMe2.sendMessage(var4);
            ++GameScr.L;
            var4.cleanup();
         } catch (Exception var3) {
            var3.printStackTrace();
         }
      }
   }

   public final void a(String var1, int var2, int var3) {
      Message var4 = new Message((byte)-28);

      try {
         var4.writer().writeByte(2);
         var4.writer().writeUTF(var1);
         var4.writer().writeByte(var2);
         var4.writer().writeByte(var3);
         ResLog.c("name= " + var1 + " gender= " + var2 + " hair=" + var3);
      } catch (Exception var5) {
         var5.printStackTrace();
      }

      this.sessionMe2.sendMessage(var4);
   }

   public final void h(int var1) {
      Message var2 = null;

      try {
         (var2 = new Message((byte)11)).writer().writeByte(var1);
         this.sessionMe2.sendMessage(var2);
         return;
      } catch (Exception var5) {
         var5.printStackTrace();
      } finally {
         var2.cleanup();
      }

   }

   public final void a(byte var1, byte var2, short var3) {
      Message var4 = null;

      try {
         (var4 = new Message((byte)7)).writer().writeByte(var1);
         var4.writer().writeByte(var2);
         var4.writer().writeShort(var3);
         this.sessionMe2.sendMessage(var4);
         return;
      } catch (Exception var7) {
         var7.printStackTrace();
      } finally {
         var4.cleanup();
      }

   }

   public final void a(byte var1, int var2, int var3) {
      Message var8 = null;

      try {
         (var8 = new Message((byte)6)).writer().writeByte(var1);
         var8.writer().writeShort(var2);
         this.sessionMe2.sendMessage(var8);
         return;
      } catch (Exception var6) {
         var6.printStackTrace();
      } finally {
         var8.cleanup();
      }

   }

   public final void selectSkill(int var1) {
      ResLog.c(Char.myCharz().cName + " SELECT SKILL " + var1);
      Message var2 = null;

      try {
         (var2 = new Message((byte)34)).writer().writeShort(var1);
         this.sessionMe2.sendMessage(var2);
         return;
      } catch (Exception var5) {
         var5.printStackTrace();
      } finally {
         var2.cleanup();
      }

   }

   public final void a(short var1) {
      Message var2 = null;

      try {
         (var2 = new Message((byte)-66)).writer().writeShort(var1);
         this.sessionMe2.sendMessage(var2);
         return;
      } catch (Exception var5) {
         var5.printStackTrace();
      } finally {
         var2.cleanup();
      }

   }

   public final void h() {
      Message var1 = null;

      try {
         var1 = new Message((byte)29);
         this.sessionMe2.sendMessage(var1);
         return;
      } catch (Exception var5) {
         var5.printStackTrace();
      } finally {
         var1.cleanup();
      }

   }

   public final void a(short var1, byte var2) {
      ResLog.c("confirme menu=" + var2 + " npc= " + var1);
      Message var3 = null;

      try {
         (var3 = new Message((byte)32)).writer().writeShort(var1);
         var3.writer().writeByte(var2);
         this.sessionMe2.sendMessage(var3);
         return;
      } catch (Exception var6) {
         var6.printStackTrace();
      } finally {
         var3.cleanup();
      }

   }

   public final void j(int var1) {
      ResLog.c("npc id" + var1);
      Message var2 = null;

      try {
         (var2 = new Message((byte)33)).writer().writeShort(var1);
         this.sessionMe2.sendMessage(var2);
         return;
      } catch (Exception var5) {
         var5.printStackTrace();
      } finally {
         var2.cleanup();
      }

   }

   public final void a(int var1, int var2, int var3) {
      Message var4 = null;

      try {
         (var4 = new Message((byte)22)).writer().writeByte(var1);
         var4.writer().writeByte(var2);
         var4.writer().writeByte(var3);
         this.sessionMe2.sendMessage(var4);
         return;
      } catch (Exception var7) {
         var7.printStackTrace();
      } finally {
         var4.cleanup();
      }

   }

   public final void b(short var1) {
      Message var2 = null;

      try {
         (var2 = new Message((byte)27)).writer().writeShort(var1);
         this.sessionMe2.sendMessage(var2);
         return;
      } catch (Exception var5) {
         var5.printStackTrace();
      } finally {
         var2.cleanup();
      }

   }

   public final void textBoxId(short var1, String var2) {
      Message var3 = null;

      try {
         (var3 = new Message((byte)88)).writer().writeShort(var1);
         var3.writer().writeUTF(var2);
         this.sessionMe2.sendMessage(var3);
         return;
      } catch (Exception var6) {
         var6.printStackTrace();
      } finally {
         var3.cleanup();
      }

   }

   public final void a(Item[] var1) {
      main.GameCanvas.msgdlg.b();
      Message var2 = null;

      try {
         var2 = new Message((byte)13);

         for(int var3 = 0; var3 < var1.length; ++var3) {
            if (var1[var3] != null) {
               var2.writer().writeByte(var1[var3].g);
            }
         }

         this.sessionMe2.sendMessage(var2);
         return;
      } catch (Exception var6) {
         var6.printStackTrace();
      } finally {
         var2.cleanup();
      }

   }

   public final void k(int var1) {
      Message var2 = null;

      try {
         (var2 = new Message((byte)37)).writer().writeInt(var1);
         this.sessionMe2.sendMessage(var2);
         return;
      } catch (Exception var5) {
         var5.printStackTrace();
      } finally {
         var2.cleanup();
      }

   }

   public final void i() {
      Message var1 = null;

      try {
         var1 = new Message((byte)50);
         this.sessionMe2.sendMessage(var1);
         return;
      } catch (Exception var5) {
         var5.printStackTrace();
      } finally {
         var1.cleanup();
      }

   }

   public final void a(MyVector var1, MyVector var2, int var3) {
      try {
         ResLog.c("SEND ATTACT vChar=  " + var2.size());
         Message var4 = null;
         if (var3 != 0) {
            Mob var5;
            Char var7;
            if (var1.size() > 0 && var2.size() > 0) {
               if (var3 == 1) {
                  var4 = new Message((byte)-4);
               } else if (var3 == 2) {
                  var4 = new Message((byte)67);
               }

               var4.writer().writeByte(var1.size());

               for(var3 = 0; var3 < var1.size(); ++var3) {
                  var5 = (Mob)var1.elementAt(var3);
                  var4.writer().writeByte(var5.mobId);
               }

               for(var3 = 0; var3 < var2.size(); ++var3) {
                  if ((var7 = (Char)var2.elementAt(var3)) != null) {
                     var4.writer().writeInt(var7.charID);
                  } else {
                     var4.writer().writeInt(-1);
                  }
               }
            } else if (var1.size() > 0) {
               ResLog.c("PLAYER ATTACK NPC");
               var4 = new Message((byte)54);

               for(var3 = 0; var3 < var1.size(); ++var3) {
                  if (!(var5 = (Mob)var1.elementAt(var3)).J) {
                     var4.writer().writeByte(var5.mobId);
                  } else {
                     var4.writer().writeByte(-1);
                     var4.writer().writeInt(var5.mobId);
                  }
               }
            } else if (var2.size() > 0) {
               ResLog.c("player attack player ");
               var4 = new Message((byte)-60);

               for(var3 = 0; var3 < var2.size(); ++var3) {
                  var7 = (Char)var2.elementAt(var3);
                  var4.writer().writeInt(var7.charID);
               }
            }

            var4.writer().writeByte((byte)Char.myCharz().I);
            if (var4 != null) {
               this.sessionMe2.sendMessage(var4);
            }
         }
      } catch (Exception var6) {
      }
   }

   public final void l(int var1) {
      Message var2 = null;

      try {
         (var2 = new Message((byte)-20)).writer().writeShort(var1);
         this.sessionMe2.sendMessage(var2);
         return;
      } catch (Exception var5) {
         var5.printStackTrace();
      } finally {
         var2.cleanup();
      }

   }

   public final void j() {
      Message var1 = null;

      try {
         var1 = new Message((byte)-15);
         this.sessionMe2.sendMessage(var1);
         return;
      } catch (Exception var5) {
         var5.printStackTrace();
      } finally {
         var1.cleanup();
      }

   }

   public final void k() {
      Message var1 = null;

      try {
         var1 = new Message((byte)-16);
         this.sessionMe2.sendMessage(var1);
         return;
      } catch (Exception var5) {
         var5.printStackTrace();
      } finally {
         var1.cleanup();
      }

   }

   public final void b(String var1) {
      Message var2 = null;

      try {
         ResLog.c("Send chat " + var1);
         (var2 = new Message((byte)44)).writer().writeUTF(var1);
         this.sessionMe2.sendMessage(var2);
         return;
      } catch (Exception var5) {
         var5.printStackTrace();
      } finally {
         var2.cleanup();
      }

   }

   public final void l() {
      Message var1 = null;

      try {
         var1 = new Message((byte)-87);
         if (Session_ME2.doSendMessage().d() && !Session_ME2.doSendMessage().e) {
            this.sessionMe2 = Session_ME2.doSendMessage();
         } else {
            this.sessionMe2 = Session_ME2.Session_ME();
         }

         this.sessionMe2.sendMessage(var1);
         this.sessionMe2 = Session_ME2.Session_ME();
         return;
      } catch (Exception var5) {
         var5.printStackTrace();
      } finally {
         var1.cleanup();
      }

   }

   public final void m() {
      Message var1 = null;

      try {
         var1 = j((byte)6);
         if (Session_ME2.doSendMessage().d() && !Session_ME2.doSendMessage().e) {
            this.sessionMe2 = Session_ME2.doSendMessage();
         } else {
            this.sessionMe2 = Session_ME2.Session_ME();
         }

         this.sessionMe2.sendMessage(var1);
         this.sessionMe2 = Session_ME2.Session_ME();
         return;
      } catch (Exception var5) {
         var5.printStackTrace();
      } finally {
         var1.cleanup();
      }

   }

   public final void n() {
      Message var1 = null;

      try {
         var1 = j((byte)7);
         if (Session_ME2.doSendMessage().d() && !Session_ME2.doSendMessage().e) {
            this.sessionMe2 = Session_ME2.doSendMessage();
         } else {
            this.sessionMe2 = Session_ME2.Session_ME();
         }

         this.sessionMe2.sendMessage(var1);
         this.sessionMe2 = Session_ME2.Session_ME();
         return;
      } catch (Exception var5) {
         var5.printStackTrace();
      } finally {
         var1.cleanup();
      }

   }

   public final void o() {
      Message var1 = null;

      try {
         var1 = j((byte)8);
         if (Session_ME2.doSendMessage().d() && !Session_ME2.doSendMessage().e) {
            this.sessionMe2 = Session_ME2.doSendMessage();
         } else {
            this.sessionMe2 = Session_ME2.Session_ME();
         }

         this.sessionMe2.sendMessage(var1);
         this.sessionMe2 = Session_ME2.Session_ME();
         return;
      } catch (Exception var5) {
         var5.printStackTrace();
      } finally {
         var1.cleanup();
      }

   }

   public final void p() {
      Message var1 = null;

      try {
         var1 = j((byte)13);
         this.sessionMe2.sendMessage(var1);
         return;
      } catch (Exception var5) {
         var5.printStackTrace();
      } finally {
         var1.cleanup();
      }

   }

   public final void c(String var1) {
      Message var2 = null;

      try {
         (var2 = new Message((byte)53)).writer().writeUTF(var1);
         this.sessionMe2.sendMessage(var2);
         return;
      } catch (Exception var5) {
         var5.printStackTrace();
      } finally {
         var2.cleanup();
      }

   }

   public final void m(int var1) {
      Message var2 = null;

      try {
         (var2 = new Message((byte)76)).writer().writeInt(var1);
         this.sessionMe2.sendMessage(var2);
         return;
      } catch (Exception var5) {
         var5.printStackTrace();
      } finally {
         var2.cleanup();
      }

   }

   public final void n(int var1) {
      Message var2 = null;

      try {
         (var2 = new Message((byte)77)).writer().writeInt(var1);
         this.sessionMe2.sendMessage(var2);
         return;
      } catch (Exception var5) {
         var5.printStackTrace();
      } finally {
         var2.cleanup();
      }

   }

   public final void a(byte var1, byte var2, int var3) {
      ResLog.c("PLAYER VS PLAYER");
      Message var4 = null;

      try {
         (var4 = new Message((byte)-59)).writer().writeByte(var1);
         var4.writer().writeByte(var2);
         var4.writer().writeInt(var3);
         this.sessionMe2.sendMessage(var4);
         return;
      } catch (Exception var7) {
         var7.printStackTrace();
      } finally {
         var4.cleanup();
      }

   }

   public final void o(int var1) {
      Message var2 = null;

      try {
         (var2 = j((byte)10)).writer().writeByte(var1);
         this.sessionMe2.sendMessage(var2);
         return;
      } catch (Exception var5) {
         var5.printStackTrace();
      } finally {
         var2.cleanup();
      }

   }

   public final void d(String var1) {
      Message var2 = null;

      try {
         (var2 = new Message((byte)17)).writer().writeUTF(var1);
         this.sessionMe2.sendMessage(var2);
         return;
      } catch (Exception var5) {
         var5.printStackTrace();
      } finally {
         var2.cleanup();
      }

   }

   public final void a(String var1, int var2) {
      Message var3 = null;

      try {
         (var3 = new Message((byte)-72)).writer().writeInt(var2);
         var3.writer().writeUTF(var1);
         this.sessionMe2.sendMessage(var3);
         return;
      } catch (Exception var6) {
         var6.printStackTrace();
      } finally {
         var3.cleanup();
      }

   }

   public final void e(String var1) {
      Message var2 = null;

      try {
         (var2 = new Message((byte)-71)).writer().writeUTF(var1);
         this.sessionMe2.sendMessage(var2);
         return;
      } catch (Exception var5) {
         var5.printStackTrace();
      } finally {
         var2.cleanup();
      }

   }

   public final void a(String var1, String var2) {
      Message var3 = null;

      try {
         (var3 = j((byte)16)).writer().writeUTF(var1);
         var3.writer().writeUTF(var2);
         this.sessionMe2.sendMessage(var3);
         return;
      } catch (Exception var6) {
         var6.printStackTrace();
      } finally {
         var3.cleanup();
      }

   }

   public final void b(String var1, int var2) {
      Message var3 = null;

      try {
         (var3 = j((byte)18)).writer().writeInt(var2);
         var3.writer().writeUTF(var1);
         this.sessionMe2.sendMessage(var3);
         return;
      } catch (Exception var6) {
         var6.printStackTrace();
      } finally {
         var3.cleanup();
      }

   }

   public final void p(int var1) {
      main.GameCanvas.connect();
      Message var2 = null;

      try {
         (var2 = new Message((byte)-67)).writer().writeInt(var1);
         if (Session_ME2.doSendMessage().d() && !Session_ME2.doSendMessage().e) {
            this.sessionMe2 = Session_ME2.doSendMessage();
         } else {
            this.sessionMe2 = Session_ME2.Session_ME();
         }

         this.sessionMe2.sendMessage(var2);
         this.sessionMe2 = Session_ME2.Session_ME();
         return;
      } catch (Exception var5) {
         var5.printStackTrace();
      } finally {
         var2.cleanup();
      }

   }

   public final void q(int var1) {
      Message var2 = null;

      try {
         (var2 = j((byte)37)).writer().writeInt(var1);
         this.sessionMe2.sendMessage(var2);
         return;
      } catch (Exception var5) {
         var5.printStackTrace();
      } finally {
         var2.cleanup();
      }

   }

   public final void r(int var1) {
      Message var2 = null;

      try {
         (var2 = j((byte)41)).writer().writeInt(var1);
         this.sessionMe2.sendMessage(var2);
         return;
      } catch (Exception var5) {
         var5.printStackTrace();
      } finally {
         var2.cleanup();
      }

   }

   public final void s(int var1) {
      Message var2 = null;

      try {
         (var2 = j((byte)39)).writer().writeInt(var1);
         this.sessionMe2.sendMessage(var2);
         return;
      } catch (Exception var5) {
         var5.printStackTrace();
      } finally {
         var2.cleanup();
      }

   }

   public final void c(short var1) {
      ResLog.c("get image id= " + var1);
      Message var2 = null;

      try {
         (var2 = new Message((byte)-32)).writer().writeShort(var1);
         if (Session_ME2.doSendMessage().d() && !Session_ME2.doSendMessage().e) {
            this.sessionMe2 = Session_ME2.doSendMessage();
         } else {
            this.sessionMe2 = Session_ME2.Session_ME();
         }

         this.sessionMe2.sendMessage(var2);
         this.sessionMe2 = Session_ME2.Session_ME();
         return;
      } catch (Exception var5) {
         var5.printStackTrace();
      } finally {
         var2.cleanup();
      }

   }

   public final void q() {
      ResLog.c("send map offline");
      Message var1 = null;

      try {
         var1 = new Message((byte)-33);
         this.sessionMe2.sendMessage(var1);
         return;
      } catch (Exception var5) {
         var5.printStackTrace();
      } finally {
         var1.cleanup();
      }

   }

   public final void finishUpdate() {
      Message var1 = null;

      try {
         var1 = new Message((byte)-38);
         this.sessionMe2.sendMessage(var1);
         return;
      } catch (Exception var5) {
         var5.printStackTrace();
      } finally {
         var1.cleanup();
      }

   }

   public final void t(int var1) {
      Message var2 = null;

      try {
         (var2 = new Message((byte)-38)).writer().writeInt(var1);
         this.sessionMe2.sendMessage(var2);
         return;
      } catch (Exception var5) {
      } finally {
         var2.cleanup();
      }

   }

   public final void s() {
      ResLog.c("finishLoadMap");
      Message var1 = null;

      try {
         var1 = new Message((byte)-39);
         this.sessionMe2.sendMessage(var1);
         return;
      } catch (Exception var5) {
         var5.printStackTrace();
      } finally {
         var1.cleanup();
      }

   }

   public final void f(byte var1) {
      ResLog.c("request bag image");
      Message var2 = null;

      try {
         (var2 = new Message((byte)-63)).writer().writeByte(var1);
         this.sessionMe2.sendMessage(var2);
         return;
      } catch (Exception var5) {
         var5.printStackTrace();
      } finally {
         var2.cleanup();
      }

   }

   public final void f(String var1) {
      ResLog.c("Login 2");
      Message var2 = null;

      try {
         (var2 = new Message((byte)-101)).writer().writeUTF(var1);
         var2.writer().writeByte(1);
         this.sessionMe2.sendMessage(var2);
         return;
      } catch (Exception var5) {
         var5.printStackTrace();
      } finally {
         var2.cleanup();
      }

   }

   public final void g(byte var1) {
      ResLog.c("request magic tree");
      Message var7 = null;

      try {
         (var7 = new Message((byte)-34)).writer().writeByte(2);
         this.sessionMe2.sendMessage(var7);
         return;
      } catch (Exception var5) {
         var5.printStackTrace();
      } finally {
         var7.cleanup();
      }

   }

   public final void a(int var1, int var2) {
      Message var3 = null;

      try {
         boolean var4 = true;
         Message var9;
         (var9 = new Message((byte)-30)).writer().writeByte(16);
         var3 = var9;
         var9.writer().writeByte(var1);
         var9.writer().writeShort(var2);
         ResLog.c("gửi tăng tiềm năng NUM= " + var2 + " type= " + var1);
         this.sessionMe2.sendMessage(var9);
         return;
      } catch (Exception var7) {
         var7.printStackTrace();
      } finally {
         var3.cleanup();
      }

   }

   public final void b(byte var1, MyVector var2) {
      ResLog.c("request resource action= " + var1);
      Message var7 = null;

      try {
         (var7 = new Message((byte)-74)).writer().writeByte(var1);
         if (Session_ME2.doSendMessage().d() && !Session_ME2.doSendMessage().e) {
            this.sessionMe2 = Session_ME2.doSendMessage();
         } else {
            f = true;
            this.sessionMe2 = Session_ME2.Session_ME();
         }

         this.sessionMe2.sendMessage(var7);
         this.sessionMe2 = Session_ME2.Session_ME();
         return;
      } catch (Exception var5) {
         var5.printStackTrace();
      } finally {
         var7.cleanup();
      }

   }

   public final void u(int var1) {
      ResLog.c("request magic tree");
      Message var2 = null;

      try {
         (var2 = new Message((byte)-91)).writer().writeByte(var1);
         this.sessionMe2.sendMessage(var2);
         return;
      } catch (Exception var5) {
         var5.printStackTrace();
      } finally {
         var2.cleanup();
      }

   }

   public final void t() {
      Message var1 = null;

      try {
         var1 = new Message((byte)-107);
         this.sessionMe2.sendMessage(var1);
         return;
      } catch (Exception var5) {
         var5.printStackTrace();
      } finally {
         var1.cleanup();
      }

   }

   public final void a(String var1, byte var2) {
      Message var3 = null;

      try {
         (var3 = new Message((byte)-96)).writer().writeUTF(var1);
         var3.writer().writeByte(var2);
         this.sessionMe2.sendMessage(var3);
         return;
      } catch (Exception var6) {
         var6.printStackTrace();
      } finally {
         var3.cleanup();
      }

   }

   public final void v(int var1) {
      ResLog.c("GUI THACH DAUA");
      Message var2 = null;

      try {
         (var2 = new Message((byte)-118)).writer().writeInt(var1);
         this.sessionMe2.sendMessage(var2);
         return;
      } catch (Exception var5) {
         var5.printStackTrace();
      } finally {
         var2.cleanup();
      }

   }

   public final void b(byte var1, int var2) {
      ResLog.c("add friend");
      Message var3 = null;

      try {
         (var3 = new Message((byte)-99)).writer().writeByte(var1);
         if (var1 == 1 || var1 == 2) {
            var3.writer().writeInt(var2);
         }

         this.sessionMe2.sendMessage(var3);
         return;
      } catch (Exception var6) {
         var6.printStackTrace();
      } finally {
         var3.cleanup();
      }

   }

   public final void a(byte var1, int var2, byte var3, int var4, int var5) {
      Message var6 = null;

      try {
         ResLog.c("ki gui action= " + var1 + " item id= " + var2);
         (var6 = new Message((byte)-100)).writer().writeByte(var1);
         if (var1 == 0) {
            var6.writer().writeShort(var2);
            var6.writer().writeByte(var3);
            var6.writer().writeInt(var4);
            var6.writer().writeInt(var5);
            ResLog.c("ki gui so luong " + var5);
         }

         if (var1 == 1 || var1 == 2) {
            var6.writer().writeShort(var2);
         }

         if (var1 == 3) {
            var6.writer().writeShort(var2);
            var6.writer().writeByte(var3);
            var6.writer().writeInt(var4);
         }

         if (var1 == 4) {
            var6.writer().writeByte(var3);
            var6.writer().writeByte(var4);
            ResLog.c("currTab= " + var3 + " page= " + var4);
         }

         if (var1 == 5) {
            var6.writer().writeShort(var2);
         }

         this.sessionMe2.sendMessage(var6);
         return;
      } catch (Exception var9) {
         var9.printStackTrace();
      } finally {
         var6.cleanup();
      }

   }

   public final void b(byte var1, byte var2) {
      Message var3 = null;

      try {
         (var3 = new Message((byte)-103)).writer().writeByte(var1);
         ResLog.c("------------service--  " + var1 + "   " + var2);
         if (var1 != 0) {
            var3.writer().writeByte(var2);
         }

         this.sessionMe2.sendMessage(var3);
         return;
      } catch (Exception var6) {
         var6.printStackTrace();
      } finally {
         var3.cleanup();
      }

   }

   public final void w(int var1) {
      Message var2 = null;

      try {
         (var2 = new Message((byte)-104)).writer().writeInt(var1);
         this.sessionMe2.sendMessage(var2);
         return;
      } catch (Exception var5) {
         var5.printStackTrace();
      } finally {
         var2.cleanup();
      }

   }

   public final void h(byte var1) {
      Message var2 = null;

      try {
         (var2 = new Message((byte)-108)).writer().writeByte(var1);
         this.sessionMe2.sendMessage(var2);
         return;
      } catch (Exception var5) {
         var5.printStackTrace();
      } finally {
         var2.cleanup();
      }

   }

   public final void u() {
      Message var1 = null;

      try {
         var1 = new Message((byte)-105);
         this.sessionMe2.sendMessage(var1);
         return;
      } catch (Exception var5) {
         var5.printStackTrace();
      } finally {
         var1.cleanup();
      }

   }

   public final void i(byte var1) {
      Message var2 = null;

      try {
         ResLog.c("FUNSION");
         (var2 = new Message((byte)125)).writer().writeByte(var1);
         this.sessionMe2.sendMessage(var2);
         return;
      } catch (Exception var5) {
         var5.printStackTrace();
      } finally {
         var2.cleanup();
      }

   }

   public final void a(MyVector var1) {
      Message var2 = null;

      try {
         ResLog.c("IMAGE SOURCE size= " + var1.size());
         (var2 = new Message((byte)-111)).writer().writeShort(var1.size());
         if (var1.size() > 0) {
            for(int var3 = 0; var3 < var1.size(); ++var3) {
               ResLog.c("gui len str " + ((ImageSource)var1.elementAt(var3)).a);
               var2.writer().writeUTF(((ImageSource)var1.elementAt(var3)).a);
            }
         }

         if (Session_ME2.doSendMessage().d() && !Session_ME2.doSendMessage().e) {
            this.sessionMe2 = Session_ME2.doSendMessage();
         } else {
            this.sessionMe2 = Session_ME2.Session_ME();
            f = true;
         }

         this.sessionMe2.sendMessage(var2);
         this.sessionMe2 = Session_ME2.Session_ME();
         return;
      } catch (Exception var6) {
         var6.printStackTrace();
      } finally {
         var2.cleanup();
      }

   }

   public final void a(byte var1, int var2, byte[] var3) {
      Message var8 = null;

      try {
         ResLog.c("SERVER DATA");
         (var8 = new Message((byte)-110)).writer().writeByte(1);
         var8.writer().writeInt(var2);
         if (var3 != null) {
            var2 = var3.length;
            var8.writer().writeShort(var2);
            var8.writer().write(var3, 0, var2);
         }

         this.sessionMe2.sendMessage(var8);
         return;
      } catch (Exception var6) {
         var6.printStackTrace();
      } finally {
         var8.cleanup();
      }

   }

   public final void a(byte[] var1) {
      Message var2 = null;

      try {
         var2 = new Message((byte)-113);

         for(int var3 = 0; var3 < GameScr.aP.length; ++var3) {
            var2.writer().writeByte(var1[var3]);
         }

         this.sessionMe2.sendMessage(var2);
         return;
      } catch (Exception var6) {
         var6.printStackTrace();
      } finally {
         var2.cleanup();
      }

   }

   public final void v() {
      Message var1 = null;

      try {
         var1 = new Message((byte)-114);
         this.sessionMe2.sendMessage(var1);
         return;
      } catch (Exception var5) {
         var5.printStackTrace();
      } finally {
         var1.cleanup();
      }

   }

   public final void x(int var1) {
      Message var2 = null;

      try {
         (var2 = new Message((byte)-30)).writer().writeByte(63);
         var2.writer().writeInt(var1);
         this.sessionMe2.sendMessage(var2);
         return;
      } catch (Exception var5) {
         var5.printStackTrace();
      } finally {
         var2.cleanup();
      }

   }

   public final void a(int var1, short var2) {
      Message var3 = null;

      try {
         (var3 = new Message((byte)-30)).writer().writeByte(64);
         var3.writer().writeInt(var1);
         var3.writer().writeShort(var2);
         this.sessionMe2.sendMessage(var3);
         return;
      } catch (Exception var6) {
         var6.printStackTrace();
      } finally {
         var3.cleanup();
      }

   }

   public final void g(String var1) {
      Message var2 = null;

      try {
         (var2 = new Message((byte)66)).writer().writeUTF(var1);
         ResLog.c(">>>getGetImgByName = " + var1);
         this.sessionMe2.sendMessage(var2);
         return;
      } catch (Exception var5) {
         var5.printStackTrace();
      } finally {
         var2.cleanup();
      }

   }

   public final void c(byte var1, byte var2) {
      Message var3 = new Message((byte)-127);

      try {
         var3.writer().writeByte(var1);
         if (var2 > 0) {
            var3.writer().writeByte(var2);
         }

         this.sessionMe2.sendMessage(var3);
         return;
      } catch (Exception var6) {
         var6.printStackTrace();
      } finally {
         var3.cleanup();
      }

   }

   public final void b(int var1, int var2) {
      Message var3 = new Message((byte)127);

      try {
         var3.writer().writeByte(var1);
         if (var2 != -1) {
            var3.writer().writeShort(var2);
         }

         this.sessionMe2.sendMessage(var3);
         return;
      } catch (Exception var6) {
         var6.printStackTrace();
      } finally {
         var3.cleanup();
      }

   }

   public final void w() {
      Message var1 = new Message((byte)69);

      try {
         this.sessionMe2.sendMessage(var1);
         return;
      } catch (Exception var5) {
      } finally {
         var1.cleanup();
      }

   }

   public final void a(byte var1, byte var2, short var3, short var4) {
      Message var5 = null;

      try {
         (var5 = new Message((byte)-45)).writer().writeByte(20);
         var5.writer().writeByte(var1);
         var5.writer().writeShort(Char.myCharz().cx);
         var5.writer().writeShort(Char.myCharz().cy);
         var5.writer().writeByte(var2);
         var5.writer().writeShort(var3);
         var5.writer().writeShort(var4);
         this.sessionMe2.sendMessage(var5);
         return;
      } catch (Exception var8) {
      } finally {
         var5.cleanup();
      }

   }
}
