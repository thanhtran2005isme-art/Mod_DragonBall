package nro;

import main.GameMidlet;

import javax.microedition.lcdui.Image;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class Controller implements IMessageHandler {
    private static Controller d;
    private Message message;
    public static boolean a = false;
    private float f;
    public static boolean b;
    public static MyHashTable frameNewBoss = new MyHashTable("frame new boss");

    public static Controller onMessage() {
        if (d == null) {
            d = new Controller();
        }

        return d;
    }

    public final void onConnectOK(boolean var1) {
        Service var5;
        if (var1) {
            System.out.println("connect 1 ok");
            int var6;
            if ((var6 = mSystem.e()) == -1) {
                var6 = ServerListScreen.ipSelect;
            }

            GameMidlet.ip = ServerListScreen.b[var6];
            GameMidlet.port = ServerListScreen.e[var6];
            ServerListScreen.t = 2;
            Rms.saveRMSInt("svselect", var6);
            String var7 = GameMidlet.ip + ":" + GameMidlet.port;
            Rms.saveRMS("NRIPlink", var7.getBytes());
            Service.gI().setClientType();
            var5 = Service.gI();
        } else {
            var5 = Service.gI();
            if (Rms.loadRMSInt("clienttype") != -1) {
                mSystem.d = Rms.loadRMSInt("clienttype");
            }

            try {
                ResLog.c("setType");
                Message var2;
                (var2 = Service.d((byte) 2)).writer().writeByte(mSystem.d);
                var2.writer().writeByte(mGraphics.zoomLevel);
                var2.writer().writeBoolean(false);
                var2.writer().writeInt(main.GameCanvas.z);
                var2.writer().writeInt(main.GameCanvas.A);
                var2.writer().writeBoolean(TField.g);
                var2.writer().writeBoolean(main.GameCanvas.isTouch);
                var2.writer().writeUTF(System.getProperty("microedition.platform") + "|" + "2.3.7");
                InputStream var3;
                if ((var3 = var5.getClass().getResourceAsStream("res\\info")) != null) {
                    var3.read((byte[]) null);
                    var2.writer().writeShort(((Object[]) null).length);
                    var2.writer().write((byte[]) null);
                    ResLog.b("write " + ((Object[]) null).length + "|" + "2.3.7");
                }

                var5.sessionMe2 = Session_ME2.doSendMessage();
                var5.sessionMe2.sendMessage(var2);
                var5.sessionMe2 = Session_ME2.Session_ME();
                var2.cleanup();
            } catch (IOException var4) {
                var4.printStackTrace();
            }

            var5 = Service.gI();
        }
    }

    public final void onConnectionFail(boolean var1) {
        if (!var1) {
            if (main.GameCanvas.currentScreen == main.GameCanvas.serverScreen && ServerListScreen.s && !Service.f) {
                ServerListScreen.t = 0;
                main.GameCanvas.serverScreen.h();
            }

            if (main.GameCanvas.currentScreen != main.GameCanvas.loginScr || Service.f) {
                return;
            }
        }

        mSystem.a(var1);
    }

    public final void onDisconnected(boolean var1) {
        if (!var1) {
            System.out.println("connect 2 fail");
            if (main.GameCanvas.currentScreen == main.GameCanvas.serverScreen && !Service.f) {
                main.GameCanvas.serverScreen.h();
            }

            if (main.GameCanvas.currentScreen == main.GameCanvas.loginScr && !Service.f) {
                mSystem.b(var1);
                return;
            }
        } else {
            System.out.println("onDisconnected 1 fail");
            mSystem.b(var1);
        }

    }

    private static void b(Message var0) {
        try {
            int var1 = var0.reader().readUnsignedByte();
            Item var4;
            (var4 = GameScr.currentCharViewInfo.arrItemBody[var1]).r = var0.reader().readInt();
            var4.l = var0.reader().readByte();
            var4.c = new MyVector("item.options");

            try {
                while (true) {
                    var4.c.addElement(new ItemOption(var0.reader().readUnsignedByte(), var0.reader().readUnsignedShort()));
                }
            } catch (Exception var2) {
            }
        } catch (Exception var3) {
            var3.printStackTrace();
        }
    }

    public final void onMessage(Message msg) {
        mSystem.c();
        main.GameCanvas.V.removeAllElements();

        label5961:
        {
            try {
                byte var2;
                int var3;
                int var6;
                int var8;
                int var11;
                int var12;
                int var224;
                short var229;
                byte var230;
                int var233;
                byte var241;
                short var250;
                int var253;
                Mob var269;
                Char var10000;
                Char var274;
                String var285;
                byte var286;
                int var287;
                ResLog.c("cmd trong Controller= " + msg.command);
                Controller2.a(msg);
                String[] var4;
                byte var5;
                short var7;
                byte var10;
                int var64;
                int var65;
                int var66;
                int var67;
                byte var68;
                byte var69;
                byte var70;
                int var71;
                byte var73;
                int var74;
                short var76;
                Char var91;
                int var92;
                MyVector var94;
                short var110;
                short var114;
                short var123;
                String var124;
                Npc var126;
                int var133;
                int var134;
                byte var228;
                int var231;
                ClanImage var235;
                int var236;
                Char var237;
                Member var238;
                short var239;
                String var242;
                byte var244;
                short var246;
                Char var248;
                int var254;
                String var262;
                Char var263;
                short var266;
                InfoItem var267;
                byte var273;
                short var275;
                byte var302;
                byte var306;
                int var326;
                int var336;
                int var347;
                ItemMap var350;
                Char[] var362;
                label5529:
                switch (msg.command) {
                    case -112:
                        if ((var273 = msg.reader().readByte()) == 0) {
                            GameScr.a(msg.reader().readByte()).clearBody();
                        }

                        if (var273 == 1) {
                            GameScr.a(msg.reader().readByte()).setBody(msg.reader().readShort());
                        }
                        break;
                    case -107:
                        if ((var5 = msg.reader().readByte()) == 0) {
                            Char.myCharz().havePet = false;
                        }

                        if (var5 == 1) {
                            Char.myCharz().havePet = true;
                        }

                        if (var5 == 2) {
                            InfoDlg.hide();
                            Char.myPetz().head = msg.reader().readShort();
                            Char.myPetz().setDefaultPart();
                            var224 = msg.reader().readUnsignedByte();
                            Char.myPetz().arrItemBody = new Item[var224];

                            for (var3 = 0; var3 < var224; ++var3) {
                                var229 = msg.reader().readShort();
                                ResLog.c("template id= " + var229);
                                if (var229 != -1) {
                                    ResLog.c("1");
                                    Char.myPetz().arrItemBody[var3] = new Item();
                                    Char.myPetz().arrItemBody[var3].template = ItemTemplates.get(var229);
                                    var5 = Char.myPetz().arrItemBody[var3].template.type;
                                    Char.myPetz().arrItemBody[var3].quantity = msg.reader().readInt();
                                    ResLog.c("3");
                                    Char.myPetz();
                                    msg.reader().readUTF();
                                    Char.myPetz();
                                    msg.reader().readUTF();
                                    var6 = msg.reader().readUnsignedByte();
                                    ResLog.c("option size= " + var6);
                                    if (var6 != 0) {
                                        Char.myPetz().arrItemBody[var3].itemOption = new ItemOption[var6];

                                        for (var236 = 0; var236 < Char.myPetz().arrItemBody[var3].itemOption.length; ++var236) {
                                            var64 = msg.reader().readUnsignedByte();
                                            var65 = msg.reader().readUnsignedShort();
                                            if (var64 != -1) {
                                                Char.myPetz().arrItemBody[var3].itemOption[var236] = new ItemOption(var64, var65);
                                            }
                                        }
                                    }

                                    if (var5 == 0) {
                                        Char.myPetz().body = Char.myPetz().arrItemBody[var3].template.part;
                                    } else if (var5 == 1) {
                                        Char.myPetz().leg = Char.myPetz().arrItemBody[var3].template.part;
                                    }
                                }
                            }

                            Char.myPetz().cHP = msg.readInt();
                            Char.myPetz().cHPFull = msg.readInt();
                            Char.myPetz().cMP = msg.readInt();
                            Char.myPetz().cMPFull = msg.readInt();
                            Char.myPetz().cDamFull = msg.readInt();
                            Char.myPetz().cName = msg.reader().readUTF();
                            Char.myPetz().currStrLevel = msg.reader().readUTF();
                            Char.myPetz().cPower = msg.reader().readLong();
                            Char.myPetz().cTiemNang = msg.reader().readLong();
                            Char.myPetz().petStatus = msg.reader().readByte();
                            Char.myPetz().cStamina = msg.reader().readShort();
                            Char.myPetz().cMaxStamina = msg.reader().readShort();
                            Char.myPetz().cCriticalFull = msg.reader().readByte();
                            Char.myPetz().cDefull = msg.reader().readShort();
                            Char.myPetz().arrPetSkill = new Skill[msg.reader().readByte()];
                            ResLog.c("SKILLENT = " + Char.myPetz().arrPetSkill);

                            for (var3 = 0; var3 < Char.myPetz().arrPetSkill.length; ++var3) {
                                if ((var229 = msg.reader().readShort()) != -1) {
                                    Char.myPetz().arrPetSkill[var3] = nr_o.a(var229);
                                } else {
                                    Char.myPetz().arrPetSkill[var3] = new Skill();
                                    Char.myPetz().arrPetSkill[var3].template = null;
                                    Char.myPetz().arrPetSkill[var3].moreInfo = msg.reader().readUTF();
                                }
                            }

                            if (main.GameCanvas.z > 2 * Panel.aa) {
                                (main.GameCanvas.G = new Panel()).L[7] = new String[][]{{""}};
                                main.GameCanvas.G.f();
                                main.GameCanvas.G.show();
                                main.GameCanvas.panel.p();
                                main.GameCanvas.panel.show();
                            } else {
                                main.GameCanvas.panel.p();
                                main.GameCanvas.panel.show();
                            }
                        }
                        break;
                    case -99:
                        InfoDlg.hide();
                        byte var280 = msg.reader().readByte();
                        ResLog.c("byte size= " + var280);
                        if (var280 == 0) {
                            main.GameCanvas.panel.W.removeAllElements();
                            var3 = msg.reader().readUnsignedByte();

                            for (var224 = 0; var224 < var3; ++var224) {
                                Char var296;
                                (var296 = new Char()).charID = msg.reader().readInt();
                                var296.head = msg.reader().readShort();
                                var296.headICON = msg.reader().readShort();
                                var296.body = msg.reader().readShort();
                                var296.leg = msg.reader().readShort();
                                var296.bag = msg.reader().readShort();
                                var296.cName = msg.reader().readUTF();
                                ResLog.c("head = " + var296.head + " body" + var296.body + " leg=" + var296.leg);
                                var267 = new InfoItem(msg.reader().readUTF());
                                boolean var277 = msg.reader().readBoolean();
                                var267.c = var296;
                                var267.e = var277;
                                ResLog.c("isonline = " + var277);
                                main.GameCanvas.panel.W.addElement(var267);
                            }

                            main.GameCanvas.panel.j();
                            main.GameCanvas.panel.show();
                        }
                        break;
                    case -98:
                        var2 = msg.reader().readByte();
                        main.GameCanvas.menu.a = false;
                        if (var2 == 0) {
                            main.GameCanvas.startYesNoDlg(msg.reader().readUTF(), new CommandLine(mResources.bm, main.GameCanvas.h, 888397, msg.reader().readUTF()), new CommandLine(mResources.bn, main.GameCanvas.h, 888396, (Object) null));
                        }
                        break;
                    case -97:
                        Char.myCharz().ab = (long) msg.reader().readInt();
                        break;
                    case -96:
                        var228 = msg.reader().readByte();
                        main.GameCanvas.panel.V.removeAllElements();
                        var242 = msg.reader().readUTF();
                        var5 = msg.reader().readByte();

                        for (var6 = 0; var6 < var5; ++var6) {
                            var224 = msg.reader().readInt();
                            var236 = msg.reader().readInt();
                            var250 = msg.reader().readShort();
                            short var256 = msg.reader().readShort();
                            var266 = msg.reader().readShort();
                            var275 = msg.reader().readShort();
                            var285 = msg.reader().readUTF();
                            String var290 = msg.reader().readUTF();
                            TopInfo var291;
                            (var291 = new TopInfo()).h = var224;
                            var291.a = var250;
                            var291.b = var256;
                            var291.c = var266;
                            var291.d = var275;
                            var291.e = var285;
                            var291.f = var290;
                            var291.i = msg.reader().readUTF();
                            var291.g = var236;
                            main.GameCanvas.panel.V.addElement(var291);
                        }

                        main.GameCanvas.panel.n = var242;
                        main.GameCanvas.panel.a(var228);
                        main.GameCanvas.panel.show();
                        break;
                    case -95:
                        if ((var244 = msg.reader().readByte()) == 0) {
                            var224 = msg.reader().readInt();
                            var7 = msg.reader().readShort();
                            var8 = msg.readInt();
                            SoundMn.stopAll();
                            if (var224 == Char.myCharz().charID) {
                                Char.myCharz().aR = new Mob(var224, false, false, false, false, false, var7, 1, var8, (byte) 0, var8, (short) (Char.myCharz().cx + (Char.myCharz().I == 1 ? 40 : -40)), (short) Char.myCharz().cy, (byte) 4, (byte) 0);
                                Char.myCharz().aR.J = true;
                                EffecMn.addEff(new Effect(18, Char.myCharz().aR.x, Char.myCharz().aR.y, 2, 10, -1));
                                Char.myCharz().aS = 30;
                                GameScr.F.addElement(Char.myCharz().aR);
                            } else if ((var248 = GameScr.findCharInMap(var224)) != null) {
                                (var269 = new Mob(var224, false, false, false, false, false, var7, 1, var8, (byte) 0, var8, (short) var248.cx, (short) var248.cy, (byte) 4, (byte) 0)).J = true;
                                var248.aR = var269;
                                GameScr.F.addElement(var248.aR);
                            } else if (GameScr.c(var224) == null) {
                                (var269 = new Mob(var224, false, false, false, false, false, var7, 1, var8, (byte) 0, var8, (short) -100, (short) -100, (byte) 4, (byte) 0)).J = true;
                                GameScr.F.addElement(var269);
                            }
                        }

                        if (var244 == 1) {
                            var224 = msg.reader().readInt();
                            var241 = msg.reader().readByte();
                            ResLog.c("mod attack id= " + var224);
                            if (var224 == Char.myCharz().charID) {
                                if (GameScr.c(var241) != null) {
                                    Char.myCharz().aR.a(GameScr.c(var241));
                                }
                            } else {
                                Char var264;
                                if ((var264 = GameScr.findCharInMap(var224)) != null && GameScr.c(var241) != null) {
                                    var264.aR.a(GameScr.c(var241));
                                }
                            }
                        }

                        if (var244 == 2) {
                            var224 = msg.reader().readInt();
                            var236 = msg.reader().readInt();
                            var8 = msg.readInt();
                            msg.readInt();
                            if (var224 == Char.myCharz().charID) {
                                ResLog.c("mob dame= " + var8);
                                if ((var274 = GameScr.findCharInMap(var236)) != null) {
                                    if (Char.myCharz().aR.T) {
                                        var274.a(var8, 0, false, true);
                                    } else {
                                        Char.myCharz().aR.E = var8;
                                        Char.myCharz().aR.a(var274);
                                    }
                                }
                            } else if ((var269 = GameScr.c(var224)) != null) {
                                if (var236 == Char.myCharz().charID) {
                                    Char.myCharz();
                                    if (var269.T) {
                                        Char.myCharz().a(var8, 0, false, true);
                                    } else {
                                        var269.E = var8;
                                        var269.a(Char.myCharz());
                                    }
                                } else if ((var263 = GameScr.findCharInMap(var236)) != null) {
                                    if (var269.T) {
                                        var263.a(var8, 0, false, true);
                                    } else {
                                        var269.E = var8;
                                        var269.a(var263);
                                    }
                                }
                            }
                        }

                        if (var244 == 3) {
                            var224 = msg.reader().readInt();
                            var236 = msg.reader().readInt();
                            var8 = msg.readInt();
                            var253 = msg.readInt();
                            if (Char.myCharz().charID == var224) {
                                var274 = Char.myCharz();
                            } else {
                                var274 = GameScr.findCharInMap(var224);
                            }

                            if (var274 != null) {
                                Mob var278 = GameScr.c(var236);
                                if (var274.aR != null) {
                                    var274.aR.a(var278);
                                }

                                if (var278 != null) {
                                    var278.k = var8;
                                    var278.A();
                                    if (var253 == 0) {
                                        var278.x = var278.xFirst;
                                        var278.y = var278.yFirst;
                                        GameScr.a(mResources.cE, var278.x, var278.y - var278.w, 0, -2, 4);
                                    } else {
                                        GameScr.a("-" + var253, var278.x, var278.y - var278.w, 0, -2, 5);
                                    }
                                }
                            }
                        }

                        if (var244 == 5) {
                            var224 = msg.reader().readInt();
                            var241 = msg.reader().readByte();
                            var8 = msg.reader().readInt();
                            var253 = msg.readInt();
                            var254 = msg.readInt();
                            if (var224 == Char.myCharz().charID) {
                                var263 = Char.myCharz();
                            } else {
                                var263 = GameScr.findCharInMap(var224);
                            }

                            if (var263 == null) {
                                return;
                            }

                            if ((TileMap.b(var263.cx, var263.cy) & 2) == 2) {
                                var263.a(GameScr.u[var241], 0);
                            } else {
                                var263.a(GameScr.u[var241], 1);
                            }

                            Mob var282 = GameScr.c(var8);
                            if (var263.cx <= var282.x) {
                                var263.I = 1;
                            } else {
                                var263.I = -1;
                            }

                            var263.aQ = var282;
                            var282.k = var254;
                            var282.A();
                            if (var253 == 0) {
                                var282.x = var282.xFirst;
                                var282.y = var282.yFirst;
                                GameScr.a(mResources.cE, var282.x, var282.y - var282.w, 0, -2, 4);
                            } else {
                                GameScr.a("-" + var253, var282.x, var282.y - var282.w, 0, -2, 5);
                            }
                        }

                        Char var289;
                        if (var244 == 6) {
                            ResLog.c("REMOVE QUÁI");
                            if ((var224 = msg.reader().readInt()) == Char.myCharz().charID) {
                                Char.myCharz().aR.k();
                            } else if ((var289 = GameScr.findCharInMap(var224)) != null) {
                                var289.aR.k();
                            }
                        }

                        if (var244 == 7) {
                            if ((var224 = msg.reader().readInt()) == Char.myCharz().charID) {
                                Char.myCharz().aR = null;

                                for (var236 = 0; var236 < GameScr.F.size(); ++var236) {
                                    if (((Mob) GameScr.F.elementAt(var236)).mobId == var224) {
                                        GameScr.F.removeElementAt(var236);
                                    }
                                }
                            } else {
                                var289 = GameScr.findCharInMap(var224);

                                for (var8 = 0; var8 < GameScr.F.size(); ++var8) {
                                    if (((Mob) GameScr.F.elementAt(var8)).mobId == var224) {
                                        GameScr.F.removeElementAt(var8);
                                    }
                                }

                                if (var289 != null) {
                                    var289.aR = null;
                                }
                            }
                        }
                        break;
                    case -94:
                        while (msg.reader().available() > 0) {
                            var239 = msg.reader().readShort();
                            var224 = msg.reader().readInt();

                            for (var236 = 0; var236 < Char.myCharz().vSkill.size(); ++var236) {
                                Skill var258;
                                if ((var258 = (Skill) Char.myCharz().vSkill.elementAt(var236)) != null && var258.b == var239 && var224 < var258.e) {
                                    var258.f = System.currentTimeMillis() - (long) (var258.e - var224);
                                }
                            }
                        }
                        break;
                    case -93:
                        nr_cx.n = new byte[var229 = msg.reader().readShort()];
                        var233 = 0;

                        while (true) {
                            if (var233 >= var229) {
                                break label5529;
                            }

                            nr_cx.n[var233] = msg.reader().readByte();
                            ++var233;
                        }
                    case -92:
                        mSystem.d = msg.reader().readByte();
                        if (Rms.loadRMSString("ResVersion") == null) {
                            Rms.a();
                        }

                        Rms.saveRMSInt("clienttype", mSystem.d);
                        Rms.saveRMSInt("lastZoomlevel", mGraphics.zoomLevel);
                        if (Rms.loadRMSString("ResVersion") == null) {
                            main.GameCanvas.startOK(mResources.cL, 8885, (Object) null);
                        }
                        break;
                    case -91:
                        var2 = msg.reader().readByte();
                        ResLog.c("nList= " + var2);
                        main.GameCanvas.panel.D = new String[var2];
                        main.GameCanvas.panel.E = new String[var2];

                        for (var236 = 0; var236 < var2; ++var236) {
                            main.GameCanvas.panel.D[var236] = msg.reader().readUTF();
                            main.GameCanvas.panel.E[var236] = msg.reader().readUTF();
                        }

                        main.GameCanvas.panel.b();
                        main.GameCanvas.panel.show();
                        break;
                    case -90:
                        var241 = msg.reader().readByte();
                        var8 = msg.reader().readInt();
                        ResLog.c("===> UPDATE_BODY:    type = " + var241);
                        var248 = Char.myCharz().charID == var8 ? Char.myCharz() : GameScr.findCharInMap(var8);
                        if (var241 != -1) {
                            var266 = msg.reader().readShort();
                            var275 = msg.reader().readShort();
                            short var279 = msg.reader().readShort();
                            var286 = msg.reader().readByte();
                            ResLog.b("====> Cmd: -90 UPDATE_BODY   \n  isMonkey= " + var286 + " head=  " + var266 + " body= " + var275 + " legU= " + var279);
                            if (var248 != null) {
                                if (var248.charID == var8) {
                                    var248.r = true;
                                    var248.cC = var286;
                                    if (var248.cC != 0) {
                                        var248.cE = false;
                                        var248.bJ = false;
                                    }
                                } else if (var248 != null) {
                                    var248.r = true;
                                    var248.cC = var286;
                                }

                                if (var266 != -1) {
                                    var248.head = var266;
                                }

                                if (var275 != -1) {
                                    var248.body = var275;
                                }

                                if (var279 != -1) {
                                    var248.leg = var279;
                                }
                            }
                        }

                        if (var241 == -1 && var248 != null) {
                            var248.r = false;
                            var248.cC = 0;
                        }
                        break;
                    case -88:
                        main.GameCanvas.endDlg();
                        main.GameCanvas.serverScreen.switchToMe();
                        break;
                    case -87:
                        ResLog.c("GET UPDATE_DATA " + msg.reader().available() + " bytes");
                        msg.reader().mark(100000);
                        onMessage(msg.reader(), true);
                        msg.reader().reset();
                        byte[] var260 = new byte[msg.reader().available()];
                        msg.reader().readFully(var260);
                        byte[] var252 = new byte[]{GameScr.vcData};
                        Rms.saveRMS("NRdataVersion", var252);
                        LoginScr.e = false;
                        if (GameScr.ao == GameScr.vcData && GameScr.ap == GameScr.vcMap && GameScr.aq == GameScr.am && GameScr.ar == GameScr.an) {
                            ResLog.c(GameScr.ao + "," + GameScr.ap + "," + GameScr.aq + "," + GameScr.ar);
                            GameScr.gI();
                            GameScr.k();
                            GameScr.gI();
                            GameScr.i();
                            GameScr.gI();
                            GameScr.j();
                            GameScr.gI();
                            GameScr.l();
                            Service.gI().p();
                            return;
                        }
                        break;
                    case -86:
                        byte b21;
                        if ((b21 = msg.reader().readByte()) == 0) {
                            var254 = msg.reader().readInt();
                            GameScr.gI().d(var254);
                        }

                        if (b21 == 1) {
                            if ((var263 = GameScr.findCharInMap(var254 = msg.reader().readInt())) == null) {
                                return;
                            }

                            main.GameCanvas.panel.b(var263);
                            main.GameCanvas.panel.show();
                            Service.gI().c(var254);
                        }

                        if (b21 == 2) {
                            var10 = msg.reader().readByte();

                            for (var11 = 0; var11 < main.GameCanvas.panel.T.size(); ++var11) {
                                Item var276;
                                if ((var276 = (Item) main.GameCanvas.panel.T.elementAt(var11)).g == var10) {
                                    main.GameCanvas.panel.T.removeElement(var276);
                                    break;
                                }
                            }
                        }

                        if (b21 == 6) {
                            main.GameCanvas.panel.m = true;
                            if (main.GameCanvas.G != null) {
                                main.GameCanvas.G.m = true;
                            }

                            main.GameCanvas.panel.U.removeAllElements();
                            if (main.GameCanvas.G != null) {
                                main.GameCanvas.G.U.removeAllElements();
                            }

                            var254 = msg.reader().readInt();
                            var273 = msg.reader().readByte();
                            var12 = 0;

                            while (true) {
                                if (var12 >= var273) {
                                    if (main.GameCanvas.G != null) {
                                        main.GameCanvas.G.a(false);
                                        main.GameCanvas.G.l = var254;
                                    } else {
                                        main.GameCanvas.panel.l = var254;
                                        if (main.GameCanvas.panel.A == 2) {
                                            main.GameCanvas.panel.a(false);
                                        }
                                    }
                                    break;
                                }

                                Item var284;
                                (var284 = new Item()).template = ItemTemplates.get(msg.reader().readShort());
                                var284.quantity = msg.reader().readInt();
                                if ((var287 = msg.reader().readUnsignedByte()) != 0) {
                                    var284.itemOption = new ItemOption[var287];

                                    for (var224 = 0; var224 < var284.itemOption.length; ++var224) {
                                        var3 = msg.reader().readUnsignedByte();
                                        var231 = msg.reader().readUnsignedShort();
                                        if (var3 != -1) {
                                            var284.itemOption[var224] = new ItemOption(var3, var231);
                                            var284.A = main.GameCanvas.panel.a(var284);
                                        }
                                    }
                                }

                                if (main.GameCanvas.G != null) {
                                    main.GameCanvas.G.U.addElement(var284);
                                } else {
                                    main.GameCanvas.panel.U.addElement(var284);
                                }

                                ++var12;
                            }
                        }

                        if (b21 == 7) {
                            InfoDlg.hide();
                            if (main.GameCanvas.panel.isShow) {
                                main.GameCanvas.panel.A();
                            }
                        }
                        break;
                    case -85:
                        if ((var10 = msg.reader().readByte()) == 0) {
                            byte[] var271 = new byte[var11 = msg.reader().readUnsignedShort()];
                            msg.reader().read(var271, 0, var11);
                            GameScr.gI();
                            GameScr.bq = Image.createImage(var271, 0, var11);
                            GameScr.gI().br = "-----";
                            GameScr.gI().bl = msg.reader().readUTF();
                            GameScr.gI().bp = new int[GameScr.gI().bl.length()];
                            GameScr.gI().aK = new Mob();
                            GameScr.gI().cb = null;
                        }

                        if (var10 == 1) {
                            MobCapcha.b = true;
                        }

                        if (var10 == 2) {
                            MobCapcha.a = true;
                            GameScr.gI().cb = GameScr.gI().s;
                        }
                        break;
                    case -84:
                        var12 = msg.reader().readUnsignedByte();
                        Mob var13 = null;

                        try {
                            var13 = (Mob) GameScr.F.elementAt(var12);
                        } catch (Exception var210) {
                        }

                        if (var13 != null) {
                            var13.l = msg.reader().readInt();
                        }
                        break;
                    case -83:
                        byte var14;
                        if ((var14 = msg.reader().readByte()) == 0) {
                            short var270 = msg.reader().readShort();
                            msg.reader().readShort();
                            var231 = msg.reader().readUnsignedByte();
                            var233 = msg.reader().readInt();
                            msg.reader().readUTF();
                            var7 = msg.reader().readShort();
                            var250 = msg.reader().readShort();
                            if (msg.reader().readByte() == 1) {
                                GameScr.gI().bb = true;
                            } else {
                                GameScr.gI().bb = false;
                            }

                            GameScr.gI().be = var7;
                            GameScr.gI().bf = var250;
                            ResLog.c("xR= " + var7 + " yR= " + var250 + " +++++++++++++++++++++++++++++++++++++++");
                            if (Char.myCharz().charID == var233) {
                                main.GameCanvas.panel.z();
                                GameScr.gI().a(true);
                            } else if (TileMap.l == var270 && TileMap.n == var231) {
                                GameScr.gI().a(false);
                            } else if (mGraphics.zoomLevel > 1) {
                                GameScr.gI().s();
                            }

                            GameScr.gI().bg = var270;
                            GameScr.gI();
                            GameScr.gI().bh = var231;
                        }

                        if (var14 == 1) {
                            ResLog.c("map RID = " + GameScr.gI().bg + " zone RID= " + GameScr.gI().bh);
                            ResLog.c("map ID = " + TileMap.l + " zone ID= " + TileMap.n);
                            if (TileMap.l == GameScr.gI().bg && TileMap.n == GameScr.gI().bh) {
                                GameScr.gI().r();
                            } else {
                                GameScr.gI().ba = false;
                                if (GameScr.gI().bb) {
                                    GameScr.gI().bb = false;
                                }
                            }
                        }
                        break;
                    case -82:
                        TileMap.z = new int[var2 = msg.reader().readByte()][][];
                        TileMap.y = new int[var2][];
                        var3 = 0;

                        while (true) {
                            if (var3 >= var2) {
                                break label5529;
                            }

                            var230 = msg.reader().readByte();
                            TileMap.y[var3] = new int[var230];
                            TileMap.z[var3] = new int[var230][];

                            for (var233 = 0; var233 < var230; ++var233) {
                                TileMap.y[var3][var233] = msg.reader().readInt();
                                var244 = msg.reader().readByte();
                                TileMap.z[var3][var233] = new int[var244];

                                for (var236 = 0; var236 < var244; ++var236) {
                                    TileMap.z[var3][var233][var236] = msg.reader().readByte();
                                }
                            }

                            ++var3;
                        }
                    case -81:
                        var228 = msg.reader().readByte();
                        ResLog.c("combine action =" + var228);
                        if (var228 == 0) {
                            var242 = msg.reader().readUTF();
                            var262 = msg.reader().readUTF();
                            main.GameCanvas.panel.n();
                            main.GameCanvas.panel.ao = mFont.b.getWidth(var242, Panel.aa);
                            main.GameCanvas.panel.ap = mFont.k.getWidth(var262, Panel.aa);
                            main.GameCanvas.panel.show();
                        }

                        if (var228 == 1) {
                            main.GameCanvas.panel.k.removeAllElements();
                            var230 = msg.reader().readByte();
                            var233 = 0;

                            while (true) {
                                if (var233 >= var230) {
                                    if (main.GameCanvas.panel.isShow) {
                                        main.GameCanvas.panel.o();
                                    }
                                    break;
                                }

                                var244 = msg.reader().readByte();

                                for (var236 = 0; var236 < Char.myCharz().arrItemBag.length; ++var236) {
                                    Item var247;
                                    if ((var247 = Char.myCharz().arrItemBag[var236]) != null && var247.g == var244) {
                                        var247.f = true;
                                        main.GameCanvas.panel.k.addElement(var247);
                                    }
                                }

                                ++var233;
                            }
                        }

                        if (var228 == 2) {
                            main.GameCanvas.panel.au = 0;
                            main.GameCanvas.panel.b(0);
                        }

                        if (var228 == 3) {
                            main.GameCanvas.panel.au = 1;
                            main.GameCanvas.panel.b(0);
                        }

                        if (var228 == 4) {
                            var229 = msg.reader().readShort();
                            main.GameCanvas.panel.aA = var229;
                            main.GameCanvas.panel.au = 0;
                            main.GameCanvas.panel.b(1);
                        }

                        if (var228 == 5) {
                            var229 = msg.reader().readShort();
                            main.GameCanvas.panel.aA = var229;
                            main.GameCanvas.panel.au = 0;
                            main.GameCanvas.panel.b(2);
                        }

                        if (var228 == 6) {
                            var229 = msg.reader().readShort();
                            var246 = msg.reader().readShort();
                            main.GameCanvas.panel.au = 0;
                            main.GameCanvas.panel.b(3);
                            main.GameCanvas.panel.az = var229;
                            main.GameCanvas.panel.aA = var246;
                        }

                        if (var228 == 7) {
                            var229 = msg.reader().readShort();
                            main.GameCanvas.panel.aA = var229;
                            main.GameCanvas.panel.au = 0;
                            main.GameCanvas.panel.b(4);
                        }

                        if (var228 == 8) {
                            main.GameCanvas.panel.aA = -1;
                            main.GameCanvas.panel.au = 1;
                            main.GameCanvas.panel.b(4);
                        }

                        var229 = 21;

                        try {
                            var229 = msg.reader().readShort();
                            var246 = msg.reader().readShort();
                            var239 = msg.reader().readShort();
                            main.GameCanvas.panel.aw = var246 - GameScr.cmx;
                            main.GameCanvas.panel.ax = var239 - GameScr.cmy;
                        } catch (Exception var209) {
                        }

                        var236 = 0;

                        while (true) {
                            if (var236 >= GameScr.G.size()) {
                                break label5529;
                            }

                            Npc var249;
                            if ((var249 = (Npc) GameScr.G.elementAt(var236)).template.npcTemplateId == var229) {
                                main.GameCanvas.panel.aw = var249.cx - GameScr.cmx;
                                main.GameCanvas.panel.ax = var249.cy - GameScr.cmy;
                                main.GameCanvas.panel.av = var229;
                                break label5529;
                            }

                            ++var236;
                        }
                    case -80:
                        var241 = msg.reader().readByte();
                        InfoDlg.hide();
                        if (var241 == 0) {
                            main.GameCanvas.panel.S.removeAllElements();
                            var8 = msg.reader().readUnsignedByte();

                            for (var3 = 0; var3 < var8; ++var3) {
                                (var237 = new Char()).charID = msg.reader().readInt();
                                var237.head = msg.reader().readShort();
                                var237.headICON = msg.reader().readShort();
                                var237.body = msg.reader().readShort();
                                var237.leg = msg.reader().readShort();
                                var237.bag = msg.reader().readUnsignedByte();
                                var237.cName = msg.reader().readUTF();
                                ResLog.c("head = " + var237.head + " body" + var237.body + " leg=" + var237.leg);
                                boolean var268 = msg.reader().readBoolean();
                                (var267 = new InfoItem(mResources.cZ + ": " + msg.reader().readUTF())).c = var237;
                                var267.e = var268;
                                main.GameCanvas.panel.S.addElement(var267);
                            }

                            main.GameCanvas.panel.i();
                            main.GameCanvas.panel.show();
                        }

                        MyVector var243;
                        InfoItem var272;
                        if (var241 == 3) {
                            var243 = main.GameCanvas.panel.S;
                            var3 = msg.reader().readInt();
                            ResLog.c("online offline id=" + var3);

                            for (var224 = 0; var224 < var243.size(); ++var224) {
                                if ((var272 = (InfoItem) var243.elementAt(var224)).c != null && var272.c.charID == var3) {
                                    ResLog.c("online= " + var272.e);
                                    var272.e = msg.reader().readBoolean();
                                    break;
                                }
                            }
                        }

                        if (var241 == 2) {
                            var243 = main.GameCanvas.panel.S;
                            var3 = msg.reader().readInt();

                            for (var224 = 0; var224 < var243.size(); ++var224) {
                                if ((var272 = (InfoItem) var243.elementAt(var224)).c != null && var272.c.charID == var3) {
                                    var243.removeElement(var272);
                                    break;
                                }
                            }

                            if (main.GameCanvas.panel.isShow) {
                                main.GameCanvas.panel.k();
                            }
                        }
                        break;
                    case -79:
                        InfoDlg.hide();
                        msg.reader().readInt();
                        if ((var237 = main.GameCanvas.panel.ab) == null) {
                            return;
                        }

                        var237.cPower = msg.reader().readLong();
                        var237.currStrLevel = msg.reader().readUTF();
                        break;
                    case -77:
                        SmallImage.e = new byte[var246 = msg.reader().readShort()];
                        SmallImage.f = var246;
                        SmallImage.c = new Small[var246];
                        var6 = 0;

                        while (true) {
                            if (var6 >= var246) {
                                break label5529;
                            }

                            SmallImage.e[var6] = msg.reader().readByte();
                            ++var6;
                        }
                    case -76:
                        if ((var244 = msg.reader().readByte()) == 0) {
                            if ((var2 = msg.reader().readByte()) <= 0) {
                                return;
                            }

                            Char.myCharz().arrArchive = new Archivement[var2];

                            for (var3 = 0; var3 < var2; ++var3) {
                                Char.myCharz().arrArchive[var3] = new Archivement();
                                Char.myCharz().arrArchive[var3].a = var3 + 1 + ". " + msg.reader().readUTF();
                                Char.myCharz().arrArchive[var3].b = msg.reader().readUTF();
                                Char.myCharz().arrArchive[var3].c = msg.reader().readShort();
                                Char.myCharz().arrArchive[var3].d = msg.reader().readBoolean();
                                Char.myCharz().arrArchive[var3].isRecieve = msg.reader().readBoolean();
                            }

                            main.GameCanvas.panel.setTypeArchivement();
                            main.GameCanvas.panel.show();
                        } else if (var244 == 1) {
                            var224 = msg.reader().readUnsignedByte();
                            if (Char.myCharz().arrArchive[var224] != null) {
                                Char.myCharz().arrArchive[var224].isRecieve = true;
                            }
                        }
                        break;
                    case -74:
                        if (ServerListScreen.i) {
                            return;
                        }

                        if ((var2 = msg.reader().readByte()) == 0) {
                            var3 = msg.reader().readInt();
                            if ((var233 = (var242 = Rms.loadRMSString("ResVersion")) != null && var242 != "" ? Integer.parseInt(var242) : -1) != -1 && var233 == var3) {
                                ResLog.c("login ngay");
                                SmallImage.loadBigRMS();
                                SplashScr.b = null;
                                ServerListScreen.loadScreen = true;
                                if (main.GameCanvas.currentScreen != main.GameCanvas.loginScr) {
                                    main.GameCanvas.serverScreen.switchToMe();
                                }
                            } else {
                                main.GameCanvas.serverScreen.show2();
                            }
                        }

                        if (var2 == 1) {
                            ServerListScreen.q = msg.reader().readShort();
                            Service.gI().b((byte) 2, (MyVector) null);
                        }

                        if (var2 == 2) {
                            try {
                                a = true;
                                main.GameCanvas.endDlg();
                                var4 = ResLog.a(msg.reader().readUTF(), "/", 0);
                                var262 = "x" + mGraphics.zoomLevel + var4[var4.length - 1];
                                byte[] var265 = new byte[var6 = msg.reader().readInt()];
                                msg.reader().read(var265, 0, var6);
                                ResLog.c("path save= " + var262 + " data save lent= " + var265.length + " === " + ServerListScreen.p + "% " + ServerListScreen.q);
                                Rms.saveRMS(var262, var265);
                                ServerListScreen.p = ++ServerListScreen.r * 100 / ServerListScreen.q;
                                if (mSystem.d != 5) {
                                }
                            } catch (Exception var208) {
                                main.GameCanvas.startOK(mResources.aD, 8885, (Object) null);
                            }
                        }

                        if (var2 == 3) {
                            a = false;
                            var3 = msg.reader().readInt();
                            ResLog.c("last version= " + var3);
                            Rms.saveRMSString("ResVersion", String.valueOf(var3));
                            Service.gI().b((byte) 3, (MyVector) null);
                            main.GameCanvas.endDlg();
                            SplashScr.b = null;
                            SmallImage.loadBigRMS();
                            System.gc();
                            ServerListScreen.o = true;
                            ServerListScreen.loadScreen = true;
                            GameScr.gI().o();
                            if (main.GameCanvas.currentScreen != main.GameCanvas.loginScr) {
                                main.GameCanvas.serverScreen.switchToMe();
                            }
                        }
                        break;
                    case -70:
                        ResLog.c("BIG MESSAGE .......................................");
                        main.GameCanvas.endDlg();
                        short var352 = msg.reader().readShort();
                        String var120 = msg.reader().readUTF();
                        Npc var121;
                        (var121 = new Npc(-1, 0, 0, 0, 0, 0)).aO = var352;
                        ChatPopup.a(var120, 100000, var121);
                        byte var122;
                        if ((var122 = msg.reader().readByte()) == 0) {
                            ChatPopup.serverChatPopUp.k = new CommandLine(mResources.CLOSE, ChatPopup.serverChatPopUp, 1001, (Object) null);
                            ChatPopup.serverChatPopUp.k.x = main.GameCanvas.z / 2 - 35;
                            ChatPopup.serverChatPopUp.k.y = main.GameCanvas.A - 35;
                        }

                        if (var122 == 1) {
                            String var353 = msg.reader().readUTF();
                            var124 = msg.reader().readUTF();
                            ChatPopup.serverChatPopUp.k = new CommandLine(var124, ChatPopup.serverChatPopUp, 1000, var353);
                            ChatPopup.serverChatPopUp.k.x = main.GameCanvas.z / 2 - 75;
                            ChatPopup.serverChatPopUp.k.y = main.GameCanvas.A - 35;
                            ChatPopup.serverChatPopUp.l = new CommandLine(mResources.CLOSE, ChatPopup.serverChatPopUp, 1001, (Object) null);
                            ChatPopup.serverChatPopUp.l.x = main.GameCanvas.z / 2 + 11;
                            ChatPopup.serverChatPopUp.l.y = main.GameCanvas.A - 35;
                        }
                        break;
                    case -69:
                        Char.myCharz().cMaxStamina = msg.reader().readShort();
                        break;
                    case -68:
                        Char.myCharz().cStamina = msg.reader().readShort();
                        break;
                    case -67:
                        ++this.f;
                        var74 = msg.reader().readInt();

                        byte[] var330;
                        try {
                            var330 = Util.a(msg);
                            if (SmallImage.c != null) {
                                SmallImage.c[var74].a = onMessage(var330);
                            }
                        } catch (Exception var216) {
                            var330 = null;
                            if (SmallImage.c != null && SmallImage.c[var74] != null) {
                                SmallImage.c[var74].a = Image.createRGBImage(new int[]{-2013265920}, 1, 1, true);
                            }
                        }

                        if (var330 != null && mGraphics.zoomLevel > 1) {
                            Rms.saveRMS(mGraphics.zoomLevel + "Small" + var74, var330);
                        }
                        break;
                    case -66:
                        var76 = msg.reader().readShort();
                        byte[] var331 = Util.a(msg);
                        EffectData var332 = Effect.a(var76);
                        byte var79;
                        if ((var79 = msg.reader().readByte()) == 0) {
                            var332.a(var331);
                        } else {
                            var332.a(var331, var79);
                        }

                        byte[] var80 = Util.a(msg);
                        var332.a = Image.createImage(var80, 0, var80.length);
                        break;
                    case -65:
                        InfoDlg.hide();
                        var224 = msg.reader().readInt();
                        var230 = msg.reader().readByte();
                        ResLog.c("TELEPORT ..................................................." + var230);
                        if (var230 != 0) {
                            if (Char.myCharz().charID == var224) {
                                b = true;
                                GameScr.z = 500;
                                GameScr.gI().center = null;
                                if (var230 == 0 || var230 == 1 || var230 == 3) {
                                    Teleport.a(new Teleport(Char.myCharz().cx, Char.myCharz().cy, Char.myCharz().head, Char.myCharz().I, 0, true, var230 == 1 ? Char.myCharz().cgender : var230));
                                }

                                if (var230 == 2) {
                                    GameScr.z = 50;
                                    Char.myCharz().k();
                                }
                            } else {
                                Char var255 = GameScr.findCharInMap(var224);
                                if ((var230 == 0 || var230 == 1 || var230 == 3) && var255 != null) {
                                    var255.t = true;
                                    Teleport var257;
                                    (var257 = new Teleport(var255.cx, var255.cy, var255.head, var255.I, 0, false, var230 == 1 ? var255.cgender : var230)).d = var224;
                                    Teleport.a(var257);
                                }

                                if (var230 == 2) {
                                    var255.k();
                                }
                            }
                        }
                        break;
                    case -64:
                        var3 = msg.reader().readInt();
                        var233 = msg.reader().readUnsignedByte();
                        if (var3 == Char.myCharz().charID) {
                            var237 = Char.myCharz();
                        } else {
                            var237 = GameScr.findCharInMap(var3);
                        }

                        if (var237 == null) {
                            return;
                        }

                        var237.bag = var233;

                        for (var231 = 0; var231 < 54; ++var231) {
                            var237.b((int) 0, (int) (var231 + 201));
                        }

                        if (var237.bag >= 201 && var237.bag < 255) {
                            Effect var259;
                            (var259 = new Effect(var237.bag, var237, 2, -1, 10, (byte) 1)).b = 5;
                            var237.a(var259);
                        }

                        ResLog.c("cmd:-64 UPDATE BAG PLAER = " + (var237 == null ? "" : var237.cName) + var3 + " BAG ID= " + var233);
                        break;
                    case -63:
                        ResLog.c("GET BAG");
                        var3 = msg.reader().readUnsignedByte();
                        var5 = msg.reader().readByte();
                        (var235 = new ClanImage()).ID = var3;
                        if (var5 > 0) {
                            var235.idImage = new short[var5];

                            for (var231 = 0; var231 < var5; ++var231) {
                                var235.idImage[var231] = msg.reader().readShort();
                                ResLog.c("ID=  " + var3 + " frame= " + var235.idImage[var231]);
                            }

                            ClanImage.idImages.put(String.valueOf(var3), var235);
                        }
                        break;
                    case -62:
                        var224 = msg.reader().readUnsignedByte();
                        var228 = msg.reader().readByte();
                        ResLog.c("cmd: -62 CLAN_IMAGE id= " + var224 + " nImage= " + var228);
                        if (var228 > 0 && (var235 = ClanImage.getClanImage((short) var224)) != null) {
                            var235.idImage = new short[var228];

                            for (var231 = 0; var231 < var228; ++var231) {
                                var235.idImage[var231] = msg.reader().readShort();
                                if (var235.idImage[var231] > 0) {
                                    SmallImage.d.addElement(String.valueOf(var235.idImage[var231]));
                                }
                            }
                        }
                        break;
                    case -61:
                        if ((var224 = msg.reader().readInt()) != Char.myCharz().charID) {
                            if (GameScr.findCharInMap(var224) != null) {
                                GameScr.findCharInMap(var224).ah = msg.reader().readInt();
                                if (GameScr.findCharInMap(var224).ah == -2) {
                                    GameScr.findCharInMap(var224).cD = true;
                                }
                            }
                        } else if (Char.myCharz().clan != null) {
                            Char.myCharz().clan.a = msg.reader().readInt();
                        }
                        break;
                    case -60:
                        int var367 = msg.reader().readInt();
                        int var138 = -1;
                        if (var367 == Char.myCharz().charID) {
                            msg.reader().readByte();
                            msg.reader().readByte();
                            var138 = msg.reader().readInt();
                        } else {
                            Char var139;
                            if ((var139 = GameScr.findCharInMap(var367)) == null) {
                                return;
                            }

                            if (var139.bP != null) {
                                var139.a((int) var139.cx, (int) var139.cy, (int) 10);
                                var139.cx = var139.bP.a;
                                var139.cy = var139.bP.b;
                            }

                            int var140 = msg.reader().readUnsignedByte();
                            if ((TileMap.b(var139.cx, var139.cy) & 2) == 2) {
                                var139.a(GameScr.u[var140], 0);
                            } else {
                                var139.a(GameScr.u[var140], 1);
                            }

                            var362 = new Char[msg.reader().readByte()];

                            for (var134 = 0; var134 < var362.length; ++var134) {
                                Char var142;
                                if ((var138 = msg.reader().readInt()) == Char.myCharz().charID) {
                                    var142 = Char.myCharz();
                                    if (!GameScr.bk && GameScr.bi && GameScr.bj) {
                                        Service.gI().f((int) -1);
                                        GameScr.bk = true;
                                    }
                                } else {
                                    var142 = GameScr.findCharInMap(var138);
                                }

                                var362[var134] = var142;
                                if (var134 == 0) {
                                    if (var139.cx <= var142.cx) {
                                        var139.I = 1;
                                    } else {
                                        var139.I = -1;
                                    }
                                }
                            }

                            if (var134 > 0) {
                                var139.aY = new Char[var134];

                                for (var134 = 0; var134 < var139.aY.length; ++var134) {
                                    var139.aY[var134] = var362[var134];
                                }

                                var139.aQ = null;
                                var139.aU = var139.aY[0];
                            }
                        }

                        try {
                            if (msg.reader().readByte() == 1) {
                                byte var369 = msg.reader().readByte();
                                boolean var141;
                                int var370;
                                if (var138 == Char.myCharz().charID) {
                                    var91 = Char.myCharz();
                                    var370 = msg.readInt();
                                    var91.af = msg.reader().readBoolean();
                                    if (var91.af) {
                                        Char.bH = true;
                                    }

                                    var141 = msg.reader().readBoolean();
                                    var91.ae = var141;
                                    var91.ad = false;
                                    var91.ac = var370;
                                    if (var369 == 0) {
                                        var91.a(var370, 0, var141, false);
                                    }
                                } else {
                                    if ((var91 = GameScr.findCharInMap(var138)) == null) {
                                        return;
                                    }

                                    var370 = msg.readInt();
                                    var91.af = msg.reader().readBoolean();
                                    var141 = msg.reader().readBoolean();
                                    var91.ae = var141;
                                    var91.ad = false;
                                    var91.ac = var370;
                                    if (var369 == 0) {
                                        var91.a(var370, 0, var141, false);
                                    }
                                }
                            }
                        } catch (Exception var213) {
                        }
                        break;
                    case -59:
                        var228 = msg.reader().readByte();
                        GameScr var374 = GameScr.gI();
                        int var373 = msg.reader().readInt();
                        msg.reader().readInt();
                        var374.a(var373, msg.reader().readUTF(), var228);
                        break;
                    case -57:
                        var242 = msg.reader().readUTF();
                        var224 = msg.reader().readInt();
                        var3 = msg.reader().readInt();
                        GameScr.gI().a(var242, var224, var3);
                        break;
                    case -53:
                        ResLog.c("MY CLAN INFO");
                        InfoDlg.hide();
                        var224 = msg.reader().readInt();
                        ResLog.c("clanId= " + var224);
                        if (var224 == -1) {
                            Char.myCharz().clan = null;
                            ClanMessage.vMessage.removeAllElements();
                            if (main.GameCanvas.panel.member != null) {
                                main.GameCanvas.panel.member.removeAllElements();
                            }

                            if (main.GameCanvas.panel.myMember != null) {
                                main.GameCanvas.panel.myMember.removeAllElements();
                            }

                            if (main.GameCanvas.currentScreen == GameScr.gI()) {
                                main.GameCanvas.panel.setTabClans();
                            }

                            return;
                        }

                        main.GameCanvas.panel.tabIcon = null;
                        if (Char.myCharz().clan == null) {
                            Char.myCharz().clan = new Clan();
                        }

                        Char.myCharz().clan.a = var224;
                        Char.myCharz().clan.c = msg.reader().readUTF();
                        Char.myCharz().clan.d = msg.reader().readUTF();
                        Char.myCharz().clan.b = msg.reader().readUnsignedByte();
                        Char.myCharz().clan.f = msg.reader().readUTF();
                        Char.myCharz().clan.i = msg.reader().readUTF();
                        Char.myCharz().clan.g = msg.reader().readUnsignedByte();
                        Char.myCharz().clan.h = msg.reader().readUnsignedByte();
                        Char.myCharz().aj = msg.reader().readByte();
                        Char.myCharz().clan.k = msg.reader().readInt();
                        Char.myCharz().clan.j = msg.reader().readByte();
                        main.GameCanvas.panel.myMember = new MyVector("GameCanvas.panel.myMember ");

                        for (var224 = 0; var224 < Char.myCharz().clan.g; ++var224) {
                            Member member;
                            (member = new Member()).a = msg.reader().readInt();
                            member.b = msg.reader().readShort();
                            member.c = msg.reader().readShort();
                            member.d = msg.reader().readShort();
                            member.e = msg.reader().readShort();
                            member.f = msg.reader().readUTF();
                            member.g = msg.reader().readByte();
                            member.h = msg.reader().readUTF();
                            member.i = msg.reader().readInt();
                            member.j = msg.reader().readInt();
                            member.l = msg.reader().readInt();
                            member.k = msg.reader().readInt();
                            member.m = Util.a(msg.reader().readInt());
                            main.GameCanvas.panel.myMember.addElement(member);
                        }

                        var224 = msg.reader().readUnsignedByte();

                        for (var3 = 0; var3 < var224; ++var3) {
                            onMessage(msg, -1);
                        }

                        if (main.GameCanvas.panel.ak || main.GameCanvas.panel.am || main.GameCanvas.panel.al) {
                            main.GameCanvas.panel.setTabClans();
                        }
                        break;
                    case -52:
                        Member var227;
                        if ((var228 = msg.reader().readByte()) == 0) {
                            (var227 = new Member()).a = msg.reader().readInt();
                            var227.b = msg.reader().readShort();
                            var227.c = msg.reader().readShort();
                            var227.d = msg.reader().readShort();
                            var227.e = msg.reader().readShort();
                            var227.f = msg.reader().readUTF();
                            var227.g = msg.reader().readByte();
                            var227.h = msg.reader().readUTF();
                            var227.i = msg.reader().readInt();
                            var227.j = msg.reader().readInt();
                            var227.l = msg.reader().readInt();
                            var227.m = Util.a(msg.reader().readInt());
                            if (main.GameCanvas.panel.myMember == null) {
                                main.GameCanvas.panel.myMember = new MyVector("ameCanvas.panel.myMember");
                            }

                            main.GameCanvas.panel.myMember.addElement(var227);
                            main.GameCanvas.panel.v();
                        }

                        if (var228 == 1) {
                            main.GameCanvas.panel.myMember.removeElementAt(msg.reader().readByte());
                            --main.GameCanvas.panel.N;
                            main.GameCanvas.panel.v();
                        }

                        if (var228 == 2) {
                            (var227 = new Member()).a = msg.reader().readInt();
                            var227.b = msg.reader().readShort();
                            var227.c = msg.reader().readShort();
                            var227.d = msg.reader().readShort();
                            var227.e = msg.reader().readShort();
                            var227.f = msg.reader().readUTF();
                            var227.g = msg.reader().readByte();
                            var227.h = msg.reader().readUTF();
                            var227.i = msg.reader().readInt();
                            var227.j = msg.reader().readInt();
                            var227.l = msg.reader().readInt();
                            var227.m = Util.a(msg.reader().readInt());

                            for (var3 = 0; var3 < main.GameCanvas.panel.myMember.size(); ++var3) {
                                if ((var238 = (Member) main.GameCanvas.panel.myMember.elementAt(var3)).a == var227.a) {
                                    if (Char.myCharz().charID == var227.a) {
                                        Char.myCharz().aj = var227.g;
                                    }

                                    main.GameCanvas.panel.myMember.removeElement(var238);
                                    main.GameCanvas.panel.myMember.insertElementAt(var227, var3);
                                    return;
                                }
                            }
                        }
                        break;
                    case -51:
                        InfoDlg.hide();
                        onMessage(msg, 0);
                        if (main.GameCanvas.panel.al && main.GameCanvas.panel.z == 5) {
                            main.GameCanvas.panel.v();
                        }
                        break;
                    case -50:
                        InfoDlg.hide();
                        main.GameCanvas.panel.member = new MyVector(".panel.member");
                        var2 = msg.reader().readByte();

                        for (var3 = 0; var3 < var2; ++var3) {
                            (var238 = new Member()).a = msg.reader().readInt();
                            var238.b = msg.reader().readShort();
                            var238.c = msg.reader().readShort();
                            var238.d = msg.reader().readShort();
                            var238.e = msg.reader().readShort();
                            var238.f = msg.reader().readUTF();
                            var238.g = msg.reader().readByte();
                            var238.h = msg.reader().readUTF();
                            var238.i = msg.reader().readInt();
                            var238.j = msg.reader().readInt();
                            var238.l = msg.reader().readInt();
                            var238.m = Util.a(msg.reader().readInt());
                            main.GameCanvas.panel.member.addElement(var238);
                        }

                        main.GameCanvas.panel.am = true;
                        main.GameCanvas.panel.ak = false;
                        main.GameCanvas.panel.al = false;
                        main.GameCanvas.panel.N = main.GameCanvas.panel.member.size() + 2;
                        main.GameCanvas.panel.v();
                        break;
                    case -47:
                        InfoDlg.hide();
                        var228 = msg.reader().readByte();
                        ResLog.c("clan = " + var228);
                        if (var228 == 0) {
                            main.GameCanvas.panel.an = mResources.dH;
                            main.GameCanvas.panel.O = null;
                        } else {
                            main.GameCanvas.panel.O = new Clan[var228];
                            ResLog.c("clan search lent= " + main.GameCanvas.panel.O.length);

                            for (var231 = 0; var231 < main.GameCanvas.panel.O.length; ++var231) {
                                main.GameCanvas.panel.O[var231] = new Clan();
                                main.GameCanvas.panel.O[var231].a = msg.reader().readInt();
                                main.GameCanvas.panel.O[var231].c = msg.reader().readUTF();
                                main.GameCanvas.panel.O[var231].d = msg.reader().readUTF();
                                main.GameCanvas.panel.O[var231].b = msg.reader().readUnsignedByte();
                                main.GameCanvas.panel.O[var231].f = msg.reader().readUTF();
                                main.GameCanvas.panel.O[var231].i = msg.reader().readUTF();
                                main.GameCanvas.panel.O[var231].g = msg.reader().readUnsignedByte();
                                main.GameCanvas.panel.O[var231].h = msg.reader().readUnsignedByte();
                                main.GameCanvas.panel.O[var231].e = msg.reader().readInt();
                            }
                        }

                        main.GameCanvas.panel.ak = true;
                        main.GameCanvas.panel.am = false;
                        main.GameCanvas.panel.al = false;
                        if (main.GameCanvas.panel.ak) {
                            main.GameCanvas.panel.v();
                        }
                        break;
                    case -46:
                        InfoDlg.hide();
                        var230 = msg.reader().readByte();
                        ResLog.c("cAction= " + var230);
                        if (var230 == 1 || var230 == 3) {
                            main.GameCanvas.endDlg();
                            ClanImage.vClanImage.removeAllElements();
                            var224 = msg.reader().readUnsignedByte();

                            for (var3 = 0; var3 < var224; ++var3) {
                                ClanImage var251;
                                (var251 = new ClanImage()).ID = msg.reader().readUnsignedByte();
                                var251.name = msg.reader().readUTF();
                                var251.xu = msg.reader().readInt();
                                var251.luong = msg.reader().readInt();
                                if (!ClanImage.isExistClanImage(var251.ID)) {
                                    ClanImage.getClanImage(var251);
                                } else {
                                    ClanImage.getClanImage((short) var251.ID).name = var251.name;
                                    ClanImage.getClanImage((short) var251.ID).xu = var251.xu;
                                    ClanImage.getClanImage((short) var251.ID).luong = var251.luong;
                                }
                            }

                            if (Char.myCharz().clan != null) {
                                main.GameCanvas.panel.C();
                            }
                        }

                        if (var230 == 4) {
                            Char.myCharz().clan.b = msg.reader().readUnsignedByte();
                            Char.myCharz().clan.d = msg.reader().readUTF();
                            ResLog.c("change slogan " + Char.myCharz().clan.d);
                        }
                        break;
                    case -45:
                        var5 = msg.reader().readByte();
                        var6 = msg.reader().readInt();
                        var7 = msg.reader().readShort();
                        ResLog.c(">.SKILL_NOT_FOCUS  skill type= " + var5 + "   player use= " + var6);
                        byte var303;
                        short var307;
                        Char var321;
                        if (var5 == 20) {
                            var303 = msg.reader().readByte();
                            var302 = msg.reader().readByte();
                            var307 = msg.reader().readShort();
                            boolean var312 = msg.reader().readByte() != 0;
                            var68 = msg.reader().readByte();
                            var69 = -1;

                            try {
                                var69 = msg.reader().readByte();
                            } catch (Exception var206) {
                            }

                            ResLog.c(">.SKILL_NOT_FOCUS  skill playerDir= " + var302);
                            if (Char.myCharz().charID == var6) {
                                var321 = Char.myCharz();
                            } else {
                                var321 = GameScr.findCharInMap(var6);
                            }

                            var321.a(var7, var312, var303, var68, var302, var307, var69);
                        }

                        if (var5 == 21) {
                            Point var304;
                            (var304 = new Point()).b = msg.reader().readShort();
                            var304.c = msg.reader().readShort();
                            short var305 = msg.reader().readShort();
                            var307 = msg.reader().readShort();
                            var306 = 0;
                            var68 = -1;
                            Point[] var320 = null;
                            if (Char.myCharz().charID == var6) {
                                var321 = Char.myCharz();
                            } else {
                                var321 = GameScr.findCharInMap(var6);
                            }

                            try {
                                var306 = msg.reader().readByte();
                                var320 = new Point[msg.reader().readByte()];

                                for (var326 = 0; var326 < var320.length; ++var326) {
                                    var320[var326] = new Point();
                                    var320[var326].a = msg.reader().readByte();
                                    if (var320[var326].a == 0) {
                                        var320[var326].l = msg.reader().readByte();
                                    } else {
                                        var320[var326].l = msg.reader().readInt();
                                    }
                                }
                            } catch (Exception var214) {
                            }

                            try {
                                var68 = msg.reader().readByte();
                            } catch (Exception var205) {
                            }

                            ResLog.c(">.SKILL_NOT_FOCUS  skill targetDame= " + var304.b + ":" + var304.c + "    c:" + var321.cx + ":" + var321.cy + "   cdir:" + var321.I);
                            var321.a(1, var7, var304, var305, var307, var306, var320, var68);
                        }

                        if (var5 == 0) {
                            ResLog.c("id use= " + var6);
                            if (Char.myCharz().charID != var6) {
                                Char var308;
                                if ((TileMap.b((var308 = GameScr.findCharInMap(var6)).cx, var308.cy) & 2) == 2) {
                                    var308.a(GameScr.u[var7], 0);
                                } else {
                                    var308.a(GameScr.u[var7], 1);
                                    var308.bQ = 20;
                                }
                            } else {
                                Char.myCharz();
                                ResLog.c("LOAD LAST SKILL");
                            }

                            var303 = msg.reader().readByte();
                            ResLog.c("npc size= " + var303);

                            for (var65 = 0; var65 < var303; ++var65) {
                                byte var309 = msg.reader().readByte();
                                var306 = msg.reader().readByte();
                                ResLog.c("index= " + var309);
                                if (var7 >= 42 && var7 <= 48) {
                                    ((Mob) GameScr.F.elementAt(var309)).g = true;
                                    ((Mob) GameScr.F.elementAt(var309)).h = var306;
                                    Mob var372 = (Mob) GameScr.F.elementAt(var309);
                                    GameScr.F.elementAt(var309);
                                    var372.i = System.currentTimeMillis();
                                }
                            }

                            var302 = msg.reader().readByte();

                            for (var66 = 0; var66 < var302; ++var66) {
                                var67 = msg.reader().readInt();
                                var68 = msg.reader().readByte();
                                ResLog.c("player ID= " + var67 + " my ID= " + Char.myCharz().charID);
                                if (var7 >= 42 && var7 <= 48) {
                                    if (var67 == Char.myCharz().charID) {
                                        if (!Char.myCharz().ci && !Char.myCharz().cj) {
                                            GameScr.gI().aY = true;
                                            Char.myCharz().bk = true;
                                            Char.myCharz().bn = var68;
                                            var10000 = Char.myCharz();
                                            Char.myCharz();
                                            var10000.bp = System.currentTimeMillis();
                                            Char.myCharz().bJ = true;
                                        }
                                    } else {
                                        Char var325;
                                        if ((var325 = GameScr.findCharInMap(var67)) != null && !var325.ci && !var325.cj) {
                                            var325.bk = true;
                                            var325.bn = var68;
                                            GameScr.findCharInMap(var67);
                                            var325.bp = System.currentTimeMillis();
                                        }
                                    }
                                }
                            }
                        }

                        if (var5 == 1 && var6 != Char.myCharz().charID) {
                            GameScr.findCharInMap(var6).bl = true;
                        }

                        if (var5 == 3) {
                            if (var6 == Char.myCharz().charID) {
                                Char.myCharz().bl = false;
                                SoundMn.stopAll();
                                Char.myCharz();
                            } else {
                                GameScr.findCharInMap(var6).bl = false;
                            }
                        }

                        if (var5 == 4) {
                            if (var6 == Char.myCharz().charID) {
                                Char.myCharz().bm = msg.reader().readShort() - 1000;
                                Char.myCharz().bo = System.currentTimeMillis();
                                ResLog.c("second= " + Char.myCharz().bm + " last= " + Char.myCharz().bo);
                            } else if (GameScr.findCharInMap(var6) != null) {
                                if ((var64 = GameScr.findCharInMap(var6).cgender) == 0) {
                                    GameScr.findCharInMap(var6).b(false);
                                } else if (var64 == 1) {
                                    GameScr.findCharInMap(var6).b(true);
                                }

                                GameScr.findCharInMap(var6).skillTemplateId = var7;
                                GameScr.findCharInMap(var6).ch = true;
                                GameScr.findCharInMap(var6).bm = msg.reader().readShort();
                                GameScr.findCharInMap(var6).bo = System.currentTimeMillis();
                            }
                        }

                        if (var5 == 5) {
                            if (var6 == Char.myCharz().charID) {
                                Char.myCharz().C();
                            } else if (GameScr.findCharInMap(var6) != null) {
                                GameScr.findCharInMap(var6).C();
                            }
                        }

                        if (var5 == 6) {
                            if (var6 == Char.myCharz().charID) {
                                Char.myCharz().b(GameScr.u[var7], 0);
                            } else if (GameScr.findCharInMap(var6) != null) {
                                GameScr.findCharInMap(var6).b(GameScr.u[var7], 0);
                                SoundMn.stopAll();
                            }
                        }

                        if (var5 == 7) {
                            if (var6 == Char.myCharz().charID) {
                                Char.myCharz().bm = msg.reader().readShort();
                                ResLog.c("second = " + Char.myCharz().bm);
                                Char.myCharz().bo = System.currentTimeMillis();
                            } else if (GameScr.findCharInMap(var6) != null) {
                                GameScr.findCharInMap(var6).b(true);
                                GameScr.findCharInMap(var6).bm = msg.reader().readShort();
                                GameScr.findCharInMap(var6).bo = System.currentTimeMillis();
                                SoundMn.stopAll();
                            }
                        }

                        if (var5 == 8 && var6 != Char.myCharz().charID && GameScr.findCharInMap(var6) != null) {
                            GameScr.findCharInMap(var6).b(GameScr.u[var7], 0);
                        }
                        break;
                    case -44:
                        boolean var301 = false;
                        if (main.GameCanvas.z > 2 * Panel.aa) {
                            var301 = true;
                        }

                        var302 = msg.reader().readByte();
                        var66 = msg.reader().readUnsignedByte();
                        Char.myCharz().aJ = new Item[var66][];
                        main.GameCanvas.panel.I = new String[var66 + (!var301 ? 1 : 0)][2];
                        if (var302 == 2) {
                            main.GameCanvas.panel.J = new int[var66];
                            main.GameCanvas.panel.K = new int[var66];
                        }

                        if (!var301) {
                            main.GameCanvas.panel.I[var66] = mResources.ce;
                        }

                        for (var67 = 0; var67 < var66; ++var67) {
                            String[] var313 = ResLog.a(msg.reader().readUTF(), "\n", 0);
                            if (var302 == 2) {
                                main.GameCanvas.panel.J[var67] = msg.reader().readUnsignedByte();
                            }

                            if (var313.length == 2) {
                                main.GameCanvas.panel.I[var67] = var313;
                            }

                            if (var313.length == 1) {
                                main.GameCanvas.panel.I[var67][0] = var313[0];
                                main.GameCanvas.panel.I[var67][1] = "";
                            }

                            int var317 = msg.reader().readUnsignedByte();
                            Char.myCharz().aJ[var67] = new Item[var317];

                            for (int var319 = 0; var319 < var317; ++var319) {
                                short var327;
                                if ((var327 = msg.reader().readShort()) != -1) {
                                    Char.myCharz().aJ[var67][var319] = new Item();
                                    Char.myCharz().aJ[var67][var319].template = ItemTemplates.get(var327);
                                    Panel.aq = mResources.er;
                                    if (var302 == 8) {
                                        Char.myCharz().aJ[var67][var319].n = msg.reader().readInt();
                                        Char.myCharz().aJ[var67][var319].p = msg.reader().readInt();
                                        Char.myCharz().aJ[var67][var319].quantity = msg.reader().readInt();
                                    } else if (var302 == 4) {
                                        Char.myCharz().aJ[var67][var319].z = msg.reader().readUTF();
                                    } else if (var302 == 0) {
                                        Char.myCharz().aJ[var67][var319].n = msg.reader().readInt();
                                        Char.myCharz().aJ[var67][var319].p = msg.reader().readInt();
                                    } else if (var302 == 1) {
                                        Char.myCharz().aJ[var67][var319].j = msg.reader().readLong();
                                        Panel.aq = mResources.es;
                                    } else if (var302 == 2) {
                                        Char.myCharz().aJ[var67][var319].d = msg.reader().readShort();
                                        Char.myCharz().aJ[var67][var319].n = msg.reader().readInt();
                                        Char.myCharz().aJ[var67][var319].p = msg.reader().readInt();
                                        Char.myCharz().aJ[var67][var319].v = msg.reader().readByte();
                                        Char.myCharz().aJ[var67][var319].quantity = msg.reader().readInt();
                                        Char.myCharz().aJ[var67][var319].B = msg.reader().readByte();
                                    } else if (var302 == 3) {
                                        Char.myCharz().aJ[var67][var319].y = true;
                                        Char.myCharz().aJ[var67][var319].u = msg.reader().readShort();
                                        Char.myCharz().aJ[var67][var319].s = msg.reader().readInt();
                                    }

                                    if ((var326 = msg.reader().readUnsignedByte()) != 0) {
                                        Char.myCharz().aJ[var67][var319].itemOption = new ItemOption[var326];

                                        for (int var328 = 0; var328 < Char.myCharz().aJ[var67][var319].itemOption.length; ++var328) {
                                            var74 = msg.reader().readUnsignedByte();
                                            int var75 = msg.reader().readUnsignedShort();
                                            if (var74 != -1) {
                                                Char.myCharz().aJ[var67][var319].itemOption[var328] = new ItemOption(var74, var75);
                                                Char.myCharz().aJ[var67][var319].A = main.GameCanvas.panel.a(Char.myCharz().aJ[var67][var319]);
                                            }
                                        }
                                    }

                                    var73 = msg.reader().readByte();
                                    Char.myCharz().aJ[var67][var319].C = var73 != 0;
                                    if (msg.reader().readByte() == 1) {
                                        short var329 = msg.reader().readShort();
                                        var76 = msg.reader().readShort();
                                        short var77 = msg.reader().readShort();
                                        short var78 = msg.reader().readShort();
                                        Char.myCharz().aJ[var67][var319].a(var329, var76, var77, var78);
                                    }

                                    if (var302 == 2 && GameMidlet.e >= 237) {
                                        Char.myCharz().aJ[var67][var319].H = msg.reader().readUTF();
                                        ResLog.b("nguoi ki gui  " + Char.myCharz().aJ[var67][var319].H);
                                    }
                                }
                            }
                        }

                        if (var301) {
                            if (var302 != 2) {
                                (main.GameCanvas.G = new Panel()).L[7] = new String[][]{{""}};
                                main.GameCanvas.G.f();
                                main.GameCanvas.G.show();
                            } else {
                                (main.GameCanvas.G = new Panel()).d();
                                main.GameCanvas.G.show();
                            }
                        }

                        main.GameCanvas.panel.L[1] = main.GameCanvas.panel.I;
                        if (var302 == 2) {
                            String[][] var311 = main.GameCanvas.panel.L[1];
                            if (var301) {
                                main.GameCanvas.panel.L[1] = new String[][]{var311[0], var311[1], var311[2], var311[3]};
                            } else {
                                main.GameCanvas.panel.L[1] = new String[][]{var311[0], var311[1], var311[2], var311[3], var311[4]};
                            }
                        }

                        main.GameCanvas.panel.a((int) var302);
                        main.GameCanvas.panel.show();
                        break;
                    case -43:
                        var228 = msg.reader().readByte();
                        var230 = msg.reader().readByte();
                        var5 = msg.reader().readByte();
                        String var245 = msg.reader().readUTF();
                        main.GameCanvas.panel.a(var228, var245, var230, var5);
                        break;
                    case -42:
                        Char.myCharz().cr = msg.readInt();
                        Char.myCharz().cs = msg.readInt();
                        Char.myCharz().cq = msg.reader().readInt();
                        Char.myCharz().cHPFull = msg.readInt();
                        Char.myCharz().cMPFull = msg.readInt();
                        Char.myCharz().cHP = msg.readInt();
                        Char.myCharz().cMP = msg.readInt();
                        Char.myCharz().O = msg.reader().readByte();
                        Char.myCharz().hpFrom1000TiemNang = msg.reader().readByte();
                        Char.myCharz().mpFrom1000TiemNang = msg.reader().readByte();
                        Char.myCharz().damFrom1000TiemNang = msg.reader().readByte();
                        Char.myCharz().cDamFull = msg.reader().readInt();
                        Char.myCharz().cDefull = msg.reader().readInt();
                        Char.myCharz().cCriticalFull = msg.reader().readByte();
                        Char.myCharz().cTiemNang = msg.reader().readLong();
                        Char.myCharz().cB = msg.reader().readShort();
                        Char.myCharz().ct = msg.reader().readShort();
                        Char.myCharz().cu = msg.reader().readByte();
                        InfoDlg.hide();
                        break;
                    case -41:
                        var306 = msg.reader().readByte();
                        Char.myCharz().bi = new String[var306];
                        int var310 = 0;

                        while (true) {
                            if (var310 >= var306) {
                                break label5529;
                            }

                            String var316 = msg.reader().readUTF();
                            Char.myCharz().bi[var310] = var316;
                            ++var310;
                        }
                    case -37:
                        var2 = msg.reader().readByte();
                        ResLog.c("cAction= " + var2);
                        if (var2 == 0) {
                            Char.myCharz().head = msg.reader().readShort();
                            Char.myCharz().setDefaultPart();
                            var3 = msg.reader().readUnsignedByte();
                            ResLog.c("num body = " + var3);
                            Char.myCharz().arrItemBody = new Item[var3];

                            for (var231 = 0; var231 < var3; ++var231) {
                                if ((var246 = msg.reader().readShort()) != -1) {
                                    Char.myCharz().arrItemBody[var231] = new Item();
                                    Char.myCharz().arrItemBody[var231].template = ItemTemplates.get(var246);
                                    var244 = Char.myCharz().arrItemBody[var231].template.type;
                                    Char.myCharz().arrItemBody[var231].quantity = msg.reader().readInt();
                                    Char.myCharz();
                                    msg.reader().readUTF();
                                    Char.myCharz();
                                    msg.reader().readUTF();
                                    if ((var236 = msg.reader().readUnsignedByte()) != 0) {
                                        Char.myCharz().arrItemBody[var231].itemOption = new ItemOption[var236];

                                        for (var64 = 0; var64 < Char.myCharz().arrItemBody[var231].itemOption.length; ++var64) {
                                            var65 = msg.reader().readUnsignedByte();
                                            var66 = msg.reader().readUnsignedShort();
                                            if (var65 != -1) {
                                                Char.myCharz().arrItemBody[var231].itemOption[var64] = new ItemOption(var65, var66);
                                            }
                                        }
                                    }

                                    if (var244 == 0) {
                                        Char.myCharz().body = Char.myCharz().arrItemBody[var231].template.part;
                                    } else if (var244 == 1) {
                                        Char.myCharz().leg = Char.myCharz().arrItemBody[var231].template.part;
                                    }
                                }
                            }
                        }

                        ResLog.c("head= " + Char.myCharz().head + " body= " + Char.myCharz().body + " leg= " + Char.myCharz().leg);
                        break;
                    case -36:
                        var228 = msg.reader().readByte();
                        ResLog.c("cAction= " + var228);
                        if (var228 == 0) {
                            var231 = msg.reader().readUnsignedByte();
                            Char.myCharz().arrItemBag = new Item[var231];
                            GameScr.hpPotion = 0;
                            ResLog.c("numC=" + var231);

                            for (var233 = 0; var233 < var231; ++var233) {
                                if ((var239 = msg.reader().readShort()) != -1) {
                                    Char.myCharz().arrItemBag[var233] = new Item();
                                    Char.myCharz().arrItemBag[var233].template = ItemTemplates.get(var239);
                                    Char.myCharz().arrItemBag[var233].quantity = msg.reader().readInt();
                                    Char.myCharz();
                                    msg.reader().readUTF();
                                    Char.myCharz();
                                    msg.reader().readUTF();
                                    Char.myCharz().arrItemBag[var233].g = var233;
                                    if ((var236 = msg.reader().readUnsignedByte()) != 0) {
                                        Char.myCharz().arrItemBag[var233].itemOption = new ItemOption[var236];

                                        for (var64 = 0; var64 < Char.myCharz().arrItemBag[var233].itemOption.length; ++var64) {
                                            var65 = msg.reader().readUnsignedByte();
                                            var66 = msg.reader().readUnsignedShort();
                                            if (var65 != -1) {
                                                Char.myCharz().arrItemBag[var233].itemOption[var64] = new ItemOption(var65, var66);
                                            }
                                        }

                                        Char.myCharz().arrItemBag[var233].A = main.GameCanvas.panel.a(Char.myCharz().arrItemBag[var233]);
                                    }

                                    Char.myCharz();
                                    if (Char.myCharz().arrItemBag[var233].template.type == 6) {
                                        GameScr.hpPotion += Char.myCharz().arrItemBag[var233].quantity;
                                    }
                                }
                            }
                        }

                        if (var228 == 2) {
                            var230 = msg.reader().readByte();
                            var233 = msg.reader().readInt();
                            var6 = Char.myCharz().arrItemBag[var230].quantity;
                            Char.myCharz().arrItemBag[var230].quantity = var233;
                            if (Char.myCharz().arrItemBag[var230].quantity < var6 && Char.myCharz().arrItemBag[var230].template.type == 6) {
                                GameScr.hpPotion -= var6 - Char.myCharz().arrItemBag[var230].quantity;
                            }

                            if (Char.myCharz().arrItemBag[var230].quantity == 0) {
                                Char.myCharz().arrItemBag[var230] = null;
                            }
                        }
                        break;
                    case -35:
                        var230 = msg.reader().readByte();
                        ResLog.c("cAction= " + var230);
                        if (var230 == 0) {
                            var233 = msg.reader().readUnsignedByte();
                            Char.myCharz().arrItemBox = new Item[var233];
                            main.GameCanvas.panel.hasUse = 0;

                            for (var6 = 0; var6 < var233; ++var6) {
                                if ((var7 = msg.reader().readShort()) != -1) {
                                    Char.myCharz().arrItemBox[var6] = new Item();
                                    Char.myCharz().arrItemBox[var6].template = ItemTemplates.get(var7);
                                    Char.myCharz().arrItemBox[var6].quantity = msg.reader().readInt();
                                    Char.myCharz();
                                    msg.reader().readUTF();
                                    Char.myCharz();
                                    msg.reader().readUTF();
                                    if ((var64 = msg.reader().readUnsignedByte()) != 0) {
                                        Char.myCharz().arrItemBox[var6].itemOption = new ItemOption[var64];

                                        for (var65 = 0; var65 < Char.myCharz().arrItemBox[var6].itemOption.length; ++var65) {
                                            var66 = msg.reader().readUnsignedByte();
                                            var67 = msg.reader().readUnsignedShort();
                                            if (var66 != -1) {
                                                Char.myCharz().arrItemBox[var6].itemOption[var65] = new ItemOption(var66, var67);
                                            }
                                        }
                                    }

                                    ++main.GameCanvas.panel.hasUse;
                                }
                            }
                        }

                        if (var230 == 1) {
                            boolean var234 = false;

                            try {
                                if (msg.reader().readByte() == 1) {
                                    var234 = true;
                                }
                            } catch (Exception var207) {
                            }

                            main.GameCanvas.panel.m();
                            main.GameCanvas.panel.ai = var234;
                            main.GameCanvas.panel.show();
                        }

                        if (var230 == 2) {
                            var5 = msg.reader().readByte();
                            var6 = msg.reader().readInt();
                            Char.myCharz().arrItemBox[var5].quantity = var6;
                            if (Char.myCharz().arrItemBox[var5].quantity == 0) {
                                Char.myCharz().arrItemBox[var5] = null;
                            }
                        }
                        break;
                    case -34:
                        var68 = msg.reader().readByte();
                        ResLog.c("act= " + var68);
                        if (var68 == 0 && GameScr.gI().aL != null) {
                            ResLog.c("toi duoc day");
                            nr_k var314;
                            (var314 = GameScr.gI().aL).a = msg.reader().readShort();
                            var314.e = msg.reader().readUTF();
                            var314.e = ResLog.a(var314.e);
                            msg.reader().readShort();
                            msg.reader().readShort();
                            msg.reader().readByte();
                            var314.b = msg.reader().readShort();
                            var314.d = msg.reader().readShort();
                            ResLog.c("curr Peas= " + var314.b);
                            msg.reader().readUTF();
                            var314.l = msg.reader().readInt();
                            var70 = msg.reader().readByte();
                            var314.g = new int[var70];
                            var314.h = new int[var70];

                            for (var71 = 0; var71 < var70; ++var71) {
                                var314.g[var71] = msg.reader().readByte();
                                var314.h[var71] = msg.reader().readByte();
                            }

                            var314.f = msg.reader().readBoolean();
                            var314.m = var314.n = System.currentTimeMillis();
                            GameScr.gI().aL.i = true;
                        }

                        if (var68 == 1) {
                            MyVector var315 = new MyVector("vmenu controle 2");

                            try {
                                while (msg.reader().available() > 0) {
                                    String var318 = msg.reader().readUTF();
                                    var315.addElement(new CommandLine(var318, main.GameCanvas.h, 888392, (Object) null));
                                }
                            } catch (Exception var215) {
                            }

                            main.GameCanvas.menu.startAt(var315);
                        }

                        if (var68 == 2) {
                            GameScr.gI().aL.c = msg.reader().readShort();
                            ResLog.c("Curr pea= " + GameScr.gI().aL.c);
                            GameScr.gI().aL.l = msg.reader().readInt();
                            GameScr.gI().aL.m = GameScr.gI().aL.n = System.currentTimeMillis();
                            GameScr.gI().aL.i = true;
                            GameScr.gI().aL.k = true;
                        }
                        break;
                    case -32:
                        short var81 = msg.reader().readShort();
                        ResLog.c("BACK GROUND template id= " + var81);
                        int var82 = msg.reader().readInt();
                        Image var84 = null;

                        byte[] var83;
                        try {
                            var83 = new byte[var82];
                            msg.reader().read(var83, 0, var82);
                            var84 = Image.createImage(var83, 0, var82);
                            nr_cx.k.put(String.valueOf(var81), var84);
                        } catch (Exception var204) {
                            var83 = null;
                            nr_cx.k.put(String.valueOf(var81), Image.createRGBImage(new int[]{-2013265920}, 1, 1, true));
                        }

                        if (var83 != null && mGraphics.zoomLevel > 1) {
                            Rms.saveRMS(mGraphics.zoomLevel + "bgItem" + var81, var83);
                        }
                        break;
                    case -31:
                        TileMap.u.removeAllElements();
                        short var132 = msg.reader().readShort();
                        ResLog.c("nItem= " + var132);
                        var133 = 0;

                        while (true) {
                            if (var133 >= var132) {
                                break label5529;
                            }

                            nr_cx var368;
                            (var368 = new nr_cx()).a = var133;
                            var368.c = msg.reader().readShort();
                            var368.h = msg.reader().readByte();
                            var368.f = msg.reader().readShort();
                            var368.g = msg.reader().readShort();
                            byte var365 = msg.reader().readByte();
                            var368.i = new int[var365];
                            var368.j = new int[var365];

                            for (int var366 = 0; var366 < var365; ++var366) {
                                var368.i[var133] = msg.reader().readByte();
                                var368.j[var133] = msg.reader().readByte();
                            }

                            TileMap.u.addElement(var368);
                            ++var133;
                        }
                    case -30:
                        this.g(msg);
                        break;
                    case -29:
                        f(msg);
                        break;
                    case -28:
                        this.e(msg);
                        break;
                    case -26:
                        ServerListScreen.t = 2;
                        main.GameCanvas.startOKDlg(msg.reader().readUTF());
                        InfoDlg.hide();
                        LoginScr.c = false;
                        Char.isLoadingMap = false;
                        if (main.GameCanvas.currentScreen == main.GameCanvas.loginScr) {
                            main.GameCanvas.serverScreen.switchToMe();
                        }
                        break;
                    case -25:
                        GameScr.info1.a(msg.reader().readUTF(), 0);
                        break;
                    case -24:
                        if (main.GameCanvas.currentScreen instanceof GameScr) {
                            main.GameCanvas.ag = mSystem.currentTimeMillis() + 3000L;
                        } else {
                            main.GameCanvas.ag = mSystem.currentTimeMillis() + 30000L;
                        }

                        Char.isLoadingMap = true;
                        ResLog.c("GET MAP INFO");
                        GameScr.gI().aL = null;
                        main.GameCanvas.isLoading = true;
                        GameScr.g();
                        main.GameCanvas.endDlg();
                        TileMap.t.removeAllElements();
                        PopUp.a.removeAllElements();
                        System.gc();
                        TileMap.l = msg.reader().readUnsignedByte();
                        TileMap.r = msg.reader().readByte();
                        TileMap.e = msg.reader().readByte();
                        TileMap.bgID = msg.reader().readByte();
                        ResLog.c("load planet from server: " + TileMap.r + "bgType= " + TileMap.p + ".............................");
                        msg.reader().readByte();
                        TileMap.k = msg.reader().readUTF();
                        TileMap.n = msg.reader().readByte();

                        try {
                            TileMap.d(TileMap.l);
                        } catch (Exception var212) {
                            ResLog.c("load map from server: " + TileMap.l);
                            Service.gI().o(TileMap.l);
                            this.message = msg;
                            return;
                        }

                        this.d(msg);

                        try {
                            TileMap.j = msg.reader().readByte() != 0;
                        } catch (Exception var196) {
                        }

                        GameScr.cmx = GameScr.l;
                        GameScr.cmy = GameScr.m;
                        break;
                    case -22:
                        Char.bH = true;
                        Char.bG = true;
                        GameScr.gI();
                        GameScr.gI();
                        Char.myCharz().aQ = null;
                        Char.myCharz().aT = null;
                        Char.myCharz().aU = null;
                        Char.myCharz().aV = null;
                        Char.myCharz().aW.removeAllElements();
                        Char.myCharz().ba = -9999;
                        Char.myCharz().bb = -9999;
                        GameScr.gI().q();
                        GameScr.gI().center = null;
                        break;
                    case -21:
                        var110 = msg.reader().readShort();
                        var347 = 0;

                        while (true) {
                            if (var347 >= GameScr.vItemMap.size()) {
                                break label5529;
                            }

                            if (((ItemMap) GameScr.vItemMap.elementAt(var347)).d == var110) {
                                GameScr.vItemMap.removeElementAt(var347);
                                break label5529;
                            }

                            ++var347;
                        }
                    case -20:
                        Char.myCharz().aV = null;
                        var110 = msg.reader().readShort();
                        var347 = 0;

                        while (true) {
                            if (var347 >= GameScr.vItemMap.size()) {
                                break label5529;
                            }

                            if ((var350 = (ItemMap) GameScr.vItemMap.elementAt(var347)).d == var110) {
                                var350.a(Char.myCharz().cx, Char.myCharz().cy - 10);
                                String var351 = msg.reader().readUTF();
                                var114 = 0;

                                try {
                                    var114 = msg.reader().readShort();
                                    if (var350.template.type == 9) {
                                        var114 = msg.reader().readShort();
                                        var10000 = Char.myCharz();
                                        var10000.gold += (long) var114;
                                        Char.myCharz().xuStr = mSystem.numberTostring(Char.myCharz().gold);
                                    } else if (var350.template.type == 10) {
                                        var114 = msg.reader().readShort();
                                        var10000 = Char.myCharz();
                                        var10000.gem += var114;
                                        Char.myCharz().luongStr = mSystem.numberTostring((long) Char.myCharz().gem);
                                    } else if (var350.template.type == 34) {
                                        var114 = msg.reader().readShort();
                                        var10000 = Char.myCharz();
                                        var10000.ruby += var114;
                                        Char.myCharz().luongKhoaStr = mSystem.numberTostring((long) Char.myCharz().ruby);
                                    }
                                } catch (Exception var199) {
                                }

                                if (var351.equals("")) {
                                    if (var350.template.type == 9) {
                                        GameScr.a((var114 < 0 ? "" : "+") + var114, Char.myCharz().cx, Char.myCharz().cy - Char.myCharz().al, 0, -2, 1);
                                        SoundMn.stopAll();
                                    } else if (var350.template.type == 10) {
                                        GameScr.a((var114 < 0 ? "" : "+") + var114, Char.myCharz().cx, Char.myCharz().cy - Char.myCharz().al, 0, -2, 2);
                                        SoundMn.stopAll();
                                    } else if (var350.template.type == 34) {
                                        GameScr.a((var114 < 0 ? "" : "+") + var114, Char.myCharz().cx, Char.myCharz().cy - Char.myCharz().al, 0, -2, 0);
                                        SoundMn.stopAll();
                                    } else {
                                        GameScr.info1.a(mResources.bI + " " + (var114 > 0 ? var114 + " " : "") + var350.template.d, 0);
                                        SoundMn.stopAll();
                                    }

                                    if (var114 > 0 && Char.myCharz().v != null && Char.myCharz().v.a == 4683) {
                                        ServerEffect.addServerEffect(55, Char.myCharz().v.i, Char.myCharz().v.e, 1);
                                        ServerEffect.addServerEffect(55, Char.myCharz().cx, Char.myCharz().cy, 1);
                                    }
                                } else if (var351.length() != 1) {
                                    GameScr.info1.a(var351, 0);
                                }
                                break label5529;
                            }

                            ++var347;
                        }
                    case -19:
                        var110 = msg.reader().readShort();
                        var91 = GameScr.findCharInMap(msg.reader().readInt());
                        var347 = 0;

                        while (true) {
                            if (var347 >= GameScr.vItemMap.size()) {
                                break label5529;
                            }

                            if ((var350 = (ItemMap) GameScr.vItemMap.elementAt(var347)).d == var110) {
                                if (var91 == null) {
                                    return;
                                }

                                var350.a(var91.cx, var91.cy - 10);
                                if (var350.a < var91.cx) {
                                    var91.I = -1;
                                } else if (var350.a > var91.cx) {
                                    var91.I = 1;
                                }
                                break label5529;
                            }

                            ++var347;
                        }
                    case -18:
                        byte var346 = msg.reader().readByte();
                        GameScr.vItemMap.addElement(new ItemMap(msg.reader().readShort(), Char.myCharz().arrItemBag[var346].template.a, Char.myCharz().cx, Char.myCharz().cy, msg.reader().readShort(), msg.reader().readShort()));
                        Char.myCharz().arrItemBag[var346] = null;
                        break;
                    case -14:
                        if ((var91 = GameScr.findCharInMap(msg.reader().readInt())) == null) {
                            return;
                        }

                        GameScr.vItemMap.addElement(new ItemMap(msg.reader().readShort(), msg.reader().readShort(), var91.cx, var91.cy, msg.reader().readShort(), msg.reader().readShort()));
                        break;
                    case -4:
                        if ((var91 = GameScr.findCharInMap(msg.reader().readInt())) == null) {
                            return;
                        }

                        if ((TileMap.b(var91.cx, var91.cy) & 2) == 2) {
                            var91.a(GameScr.u[msg.reader().readUnsignedByte()], 0);
                        } else {
                            var91.a(GameScr.u[msg.reader().readUnsignedByte()], 1);
                        }

                        var91.aX = new Mob[msg.reader().readByte()];

                        for (var133 = 0; var133 < var91.aX.length; ++var133) {
                            Mob var364 = (Mob) GameScr.F.elementAt(msg.reader().readByte());
                            var91.aX[var133] = var364;
                            if (var133 == 0) {
                                if (var91.cx <= var364.x) {
                                    var91.I = 1;
                                } else {
                                    var91.I = -1;
                                }
                            }
                        }

                        var91.aU = null;
                        var91.aQ = var91.aX[0];
                        var362 = new Char[10];
                        var134 = 0;

                        try {
                            for (var134 = 0; var134 < var362.length; ++var134) {
                                Char var363;
                                if ((var92 = msg.reader().readInt()) == Char.myCharz().charID) {
                                    var363 = Char.myCharz();
                                } else {
                                    var363 = GameScr.findCharInMap(var92);
                                }

                                var362[var134] = var363;
                                if (var134 == 0) {
                                    if (var91.cx <= var363.cx) {
                                        var91.I = 1;
                                    } else {
                                        var91.I = -1;
                                    }
                                }
                            }
                        } catch (Exception var219) {
                        }

                        if (var134 > 0) {
                            var91.aY = new Char[var134];

                            for (var134 = 0; var134 < var91.aY.length; ++var134) {
                                var91.aY[var134] = var362[var134];
                            }

                            var91.aU = var91.aY[0];
                            var91.aQ = null;
                        }
                        break;
                    case 0:
                        c(msg);
                        break;
                    case 1:
                        boolean var226 = msg.reader().readBoolean();
                        ResLog.c("isRes= " + var226);
                        if (!var226) {
                            main.GameCanvas.startOKDlg(msg.reader().readUTF());
                        } else {
                            main.GameCanvas.loginScr.isLogin2 = false;
                            Rms.saveRMSString("userAo" + ServerListScreen.ipSelect, "");
                            main.GameCanvas.endDlg();
                            main.GameCanvas.loginScr.doLogin();
                        }
                        break;
                    case 2:
                        Char.isLoadingMap = false;
                        if (!GameScr.b) {
                            GameScr.gI().a();
                        }

                        nr_cx.a();
                        main.GameCanvas.endDlg();
                        nr_cu.b = true;
                        nr_cu.a().switchToMe();
                        break;
                    case 6:
                        Char.myCharz().gold = msg.reader().readLong();
                        Char.myCharz().gem = msg.reader().readInt();
                        Char.myCharz().ruby = msg.reader().readInt();
                        Char.myCharz().xuStr = mSystem.numberTostring(Char.myCharz().gold);
                        Char.myCharz().luongStr = mSystem.numberTostring((long) Char.myCharz().gem);
                        Char.myCharz().luongKhoaStr = mSystem.numberTostring((long) Char.myCharz().ruby);
                        main.GameCanvas.endDlg();
                        break;
                    case 7:
                        byte var360 = msg.reader().readByte();
                        short var361 = msg.reader().readShort();
                        String var131 = msg.reader().readUTF();
                        main.GameCanvas.panel.a(var360, var131, var361);
                        break;
                    case 11:
                        var69 = msg.reader().readByte();
                        ResLog.c("====> 2 NEW DATA TEMPLATE  = " + var69);
                        if ((var70 = msg.reader().readByte()) != 0) {
                            Mob.arrMobTemplate[var69].data.a(Util.a(msg), var70);
                        } else {
                            Mob.arrMobTemplate[var69].data.a(Util.a(msg));
                        }

                        for (var71 = 0; var71 < GameScr.F.size(); ++var71) {
                            Mob var72;
                            if ((var72 = (Mob) GameScr.F.elementAt(var71)).C == var69) {
                                var72.v = Mob.arrMobTemplate[var69].data.f;
                                var72.w = Mob.arrMobTemplate[var69].data.g;
                            }
                        }

                        for (var71 = 0; var71 < GameScr.vCharInMap.size(); ++var71) {
                            Char var322;
                            if ((var322 = (Char) GameScr.vCharInMap.elementAt(var71)) != null && var322.aR != null && var322.aR.C == var69) {
                                var322.aR.v = Mob.arrMobTemplate[var69].data.f;
                                var322.aR.w = Mob.arrMobTemplate[var69].data.g;
                            }
                        }

                        if (Char.myCharz().aR != null && Char.myCharz().aR.C == var69) {
                            MobTemplate var10001 = Mob.arrMobTemplate[var69];
                            Char.myCharz().aR.v = var10001.data.f;
                            var10001 = Mob.arrMobTemplate[var69];
                            Char.myCharz().aR.w = var10001.data.g;
                        }

                        byte[] var323 = Util.a(msg);
                        ResLog.c("mob image lent= " + var323.length);
                        Image var324 = Image.createImage(var323, 0, var323.length);
                        Mob.arrMobTemplate[var69].data.a = var324;
                        var73 = msg.reader().readByte();
                        Mob.arrMobTemplate[var69].data.e = var73;
                        if (var73 == 1 || var73 == 2) {
                            b(msg, var69);
                        }
                        break;
                    case 20:
                        this.i(msg);
                        break;
                    case 24:
                        j(msg);
                        break;
                    case 27:
                        var94 = new MyVector("menu open ui");
                        msg.reader().readUTF();
                        var2 = msg.reader().readByte();

                        for (var336 = 0; var336 < var2; ++var336) {
                            String var339 = msg.reader().readUTF();
                            Short var340 = new Short(msg.reader().readShort());
                            var94.addElement(new CommandLine(var339, main.GameCanvas.h, 88819, var340));
                        }

                        main.GameCanvas.menu.a(var94, 3);
                        break;
                    case 29:
                        GameScr.gI().a(msg);
                        break;
                    case 32:
                        var123 = msg.reader().readShort();
                        ResLog.c("npc template id= " + var123);

                        for (int var355 = 0; var355 < GameScr.G.size(); ++var355) {
                            Npc var127;
                            if ((var127 = (Npc) GameScr.G.elementAt(var355)).template.npcTemplateId == var123 && var127.equals(Char.myCharz().aT)) {
                                String var128 = msg.reader().readUTF();
                                String[] var129 = new String[msg.reader().readByte()];

                                for (int var130 = 0; var130 < var129.length; ++var130) {
                                    var129[var130] = msg.reader().readUTF();
                                }

                                GameScr.gI();
                                GameScr.a(var129, var127);
                                ChatPopup.c(var128, 100000, var127);
                                return;
                            }
                        }

                        var126 = new Npc(var123, 0, -100, 100, var123, GameScr.info1.charId[Char.myCharz().cgender][2]);
                        ResLog.c(Char.myCharz().aT != null ? "!null" : "null");
                        String var356 = msg.reader().readUTF();
                        String[] var357 = new String[msg.reader().readByte()];

                        for (int var358 = 0; var358 < var357.length; ++var358) {
                            var357[var358] = msg.reader().readUTF();
                        }

                        try {
                            short var359 = msg.reader().readShort();
                            var126.aO = var359;
                        } catch (Exception var197) {
                        }

                        ResLog.c(Char.myCharz().aT != null ? "!null" : "null");
                        GameScr.gI();
                        GameScr.a(var357, var126);
                        ChatPopup.c(var356, 100000, var126);
                        break;
                    case 33:
                        InfoDlg.hide();
                        main.GameCanvas.f();
                        main.GameCanvas.clearKeyPressed();
                        var94 = new MyVector("vt menu");

                        try {
                            while (true) {
                                String var337 = msg.reader().readUTF();
                                var94.addElement(new CommandLine(var337, main.GameCanvas.h, 88822, (Object) null));
                            }
                        } catch (Exception var221) {
                            if (Char.myCharz().aT == null) {
                                return;
                            }

                            for (var336 = 0; var336 < Char.myCharz().aT.template.menu.length; ++var336) {
                                String[] var338 = Char.myCharz().aT.template.menu[var336];
                                var94.addElement(new CommandLine(var338[0], main.GameCanvas.h, 88820, var338));
                            }

                            main.GameCanvas.menu.startAt(var94);
                            break;
                        }
                    case 38:
                        InfoDlg.hide();
                        var123 = msg.reader().readShort();
                        ResLog.c("OPEN_UI_SAY ID= " + var123);
                        var124 = ResLog.a(msg.reader().readUTF());

                        for (int var125 = 0; var125 < GameScr.G.size(); ++var125) {
                            var126 = (Npc) GameScr.G.elementAt(var125);
                            ResLog.c("npc id= " + var126.template.npcTemplateId);
                            if (var126.template.npcTemplateId == var123) {
                                ChatPopup.b(var124, 100000, var126);
                                main.GameCanvas.panel.z();
                                return;
                            }
                        }

                        Npc var354;
                        if ((var354 = new Npc(var123, 0, 0, 0, var123, GameScr.info1.charId[Char.myCharz().cgender][2])).template.npcTemplateId == 5) {
                            var354.charID = 5;
                        }

                        try {
                            var354.aO = msg.reader().readShort();
                        } catch (Exception var198) {
                        }

                        ChatPopup.b(var124, 100000, var354);
                        main.GameCanvas.panel.z();
                        break;
                    case 39:
                        GameScr.gI().aa = 2;
                        GameScr.gI();
                        break;
                    case 40:
                        main.GameCanvas.w = 150;
                        short var101 = msg.reader().readShort();
                        byte var102 = msg.reader().readByte();
                        ResLog.c("TASK GET index= " + var102);
                        String var103 = ResLog.a(msg.reader().readUTF());
                        String var104 = ResLog.a(msg.reader().readUTF());
                        String[] var105;
                        String[] var106 = new String[(var105 = new String[msg.reader().readByte()]).length];
                        GameScr.ab = new int[var105.length];
                        GameScr.ac = new int[var105.length];
                        short[] var107 = new short[var105.length];
                        short var108 = -1;

                        int var341;
                        for (var341 = 0; var341 < var105.length; ++var341) {
                            String var343 = ResLog.a(msg.reader().readUTF());
                            GameScr.ab[var341] = msg.reader().readByte();
                            GameScr.ac[var341] = msg.reader().readShort();
                            String var345 = ResLog.a(msg.reader().readUTF());
                            var107[var341] = -1;
                            if (!var343.equals("")) {
                                var105[var341] = var343;
                                var106[var341] = var345;
                            }
                        }

                        try {
                            var108 = msg.reader().readShort();

                            for (var341 = 0; var341 < var105.length; ++var341) {
                                var107[var341] = msg.reader().readShort();
                            }
                        } catch (Exception var217) {
                        }

                        Char.myCharz().aD = new Util(var101, var102, var103, var104, var105, var107, var108, var106);
                        if (Char.myCharz().aT != null) {
                            Npc.aa();
                        }

                        Char.a(false);
                        break;
                    case 41:
                        main.GameCanvas.w = 100;
                        ResLog.c("TASK NEXT");
                        ++Char.myCharz().aD.a;
                        Char.myCharz().aD.h = 0;
                        Npc.aa();
                        Char.a(true);
                        break;
                    case 43:
                        main.GameCanvas.w = 50;
                        Char.myCharz().aD.h = msg.reader().readShort();
                        if (Char.myCharz().aT != null) {
                            Npc.aa();
                        }

                        try {
                            var110 = msg.reader().readShort();
                            short var344 = msg.reader().readShort();
                            Char.myCharz().bA = var110;
                            Char.myCharz().bB = var344;
                            ResLog.c("CMD   TASK_UPDATE:43_mapID =    x|y " + var110 + "|" + var344);
                            int var349 = 0;

                            while (true) {
                                if (var349 >= TileMap.t.size()) {
                                    break label5529;
                                }

                                ResLog.c("===> " + TileMap.t.elementAt(var349));
                                ++var349;
                            }
                        } catch (Exception var220) {
                            break;
                        }
                    case 46:
                        Char.bH = false;
                        Char.myCharz().a((int) msg.reader().readShort(), (int) msg.reader().readShort());
                        break;
                    case 47:
                        GameScr.gI().q();
                        break;
                    case 50:
                        byte var109 = msg.reader().readByte();
                        Panel.as.removeAllElements();
                        int var342 = 0;

                        while (true) {
                            if (var342 >= var109) {
                                break label5529;
                            }

                            nr_az var111;
                            (var111 = new nr_az()).c = msg.reader().readShort();
                            var111.a = msg.reader().readUTF();
                            var111.b = msg.reader().readUTF();
                            Panel.as.addElement(var111);
                            boolean var348 = Rms.loadRMSInt(String.valueOf(var111.c)) != -1;
                            var111.d = var348;
                            ++var342;
                        }
                    case 54:
                        if ((var91 = GameScr.findCharInMap(msg.reader().readInt())) == null) {
                            return;
                        }

                        int var135 = msg.reader().readUnsignedByte();
                        if ((TileMap.b(var91.cx, var91.cy) & 2) == 2) {
                            var91.a(GameScr.u[var135], 0);
                        } else {
                            var91.a(GameScr.u[var135], 1);
                        }

                        Mob[] var136 = new Mob[10];
                        var134 = 0;

                        try {
                            for (var134 = 0; var134 < var136.length; ++var134) {
                                (new StringBuffer("SA769991v4-num")).append(var134).toString();
                                Mob var137 = (Mob) GameScr.F.elementAt(msg.reader().readByte());
                                var136[var134] = var137;
                                if (var134 == 0) {
                                    if (var91.cx <= var137.x) {
                                        var91.I = 1;
                                    } else {
                                        var91.I = -1;
                                    }
                                }

                                (new StringBuffer("SA769991v5-num")).append(var134).toString();
                            }
                        } catch (Exception var218) {
                        }

                        if (var134 > 0) {
                            var91.aX = new Mob[var134];

                            for (var134 = 0; var134 < var91.aX.length; ++var134) {
                                var91.aX[var134] = var136[var134];
                            }

                            var91.aU = null;
                            var91.aQ = var91.aX[0];
                        }
                        break;
                    case 56:
                        boolean var333;
                        int var334;
                        byte var335;
                        if ((var92 = msg.reader().readInt()) == Char.myCharz().charID) {
                            var333 = false;
                            (var91 = Char.myCharz()).cHP = msg.readInt();
                            if ((var334 = msg.readInt()) != 0) {
                                var91.K();
                            }

                            try {
                                var333 = msg.reader().readBoolean();
                                if ((var335 = msg.reader().readByte()) != -1) {
                                    ResLog.c("hit eff= " + var335);
                                    EffecMn.addEff(new Effect(var335, var91.cx, var91.cy, 3, 1, -1));
                                }
                            } catch (Exception var203) {
                            }

                            if (Char.myCharz().cTypePk != 4) {
                                if (var334 == 0) {
                                    GameScr.a(mResources.cE, var91.cx, var91.cy - var91.al, 0, -3, 7);
                                } else {
                                    GameScr.a("-" + var334, var91.cx, var91.cy - var91.al, 0, -3, !var333 ? 0 : 3);
                                }
                            }
                        } else {
                            if ((var91 = GameScr.findCharInMap(var92)) == null) {
                                return;
                            }

                            var91.cHP = msg.readInt();
                            var333 = false;
                            if ((var334 = msg.readInt()) != 0) {
                                var91.K();
                            }

                            try {
                                var333 = msg.reader().readBoolean();
                                if ((var335 = msg.reader().readByte()) != -1) {
                                    ResLog.c("hit eff= " + var335);
                                    EffecMn.addEff(new Effect(var335, var91.cx, var91.cy, 3, 1, -1));
                                }
                            } catch (Exception var202) {
                            }

                            if (var91.cTypePk != 4) {
                                if (var334 == 0) {
                                    GameScr.a(mResources.cE, var91.cx, var91.cy - var91.al, 0, -3, 4);
                                } else {
                                    GameScr.a("-" + var334, var91.cx, var91.cy - var91.al, 0, -3, !var333 ? 5 : 3);
                                }
                            }
                        }
                        break;
                    case 57:
                        (var94 = new MyVector("vmenu UI")).addElement(new CommandLine(msg.reader().readUTF(), main.GameCanvas.h, 88817, (Object) null));
                        main.GameCanvas.menu.startAt(var94);
                        break;
                    case 58:
                        Char var95;
                        if ((var92 = msg.reader().readInt()) == Char.myCharz().charID) {
                            var95 = Char.myCharz();
                        } else {
                            var95 = GameScr.findCharInMap(var92);
                        }

                        var95.aZ = new short[3];
                        var95.aZ[0] = 0;
                        short var97 = msg.reader().readShort();
                        short var98 = msg.reader().readShort();
                        var95.aZ[1] = var97;
                        var95.aZ[2] = var98;

                        try {
                            Char var96;
                            if ((var92 = msg.reader().readInt()) == Char.myCharz().charID) {
                                var96 = Char.myCharz();
                            } else {
                                var96 = GameScr.findCharInMap(var92);
                            }

                            var96.cx = var97;
                            var96.cy = var98;
                        } catch (Exception var200) {
                            var200.printStackTrace();
                        }
                        break;
                    case 62:
                        if ((var91 = GameScr.findCharInMap(msg.reader().readInt())) != null) {
                            var91.bb = Char.myCharz().charID;
                            Char.myCharz().aT = null;
                            Char.myCharz().aQ = null;
                            Char.myCharz().aV = null;
                            Char.myCharz().aU = var91;
                            Char.cn = true;
                            GameScr.info1.a(var91.cName + mResources.bG, 0);
                        }
                        break;
                    case 63:
                        Char.myCharz().bb = msg.reader().readInt();
                        Char.myCharz().aT = null;
                        Char.myCharz().aQ = null;
                        Char.myCharz().aV = null;
                        Char.myCharz().aU = GameScr.findCharInMap(Char.myCharz().bb);
                        Char.cn = true;
                        break;
                    case 64:
                        var91 = Char.myCharz();

                        try {
                            var91 = GameScr.findCharInMap(msg.reader().readInt());
                        } catch (Exception var201) {
                        }

                        var91.bb = -9999;
                        break;
                    case 65:
                        var2 = msg.reader().readByte();
                        String var225 = msg.reader().readUTF();
                        var229 = msg.reader().readShort();
                        if (ItemTime.b(var2)) {
                            if (var229 != 0) {
                                ItemTime.d(var2).a(var2, var225, var229);
                            } else {
                                GameScr.bu.removeElement(ItemTime.d(var2));
                            }
                        } else {
                            ItemTime var232;
                            (var232 = new ItemTime()).a(var2, var225, var229);
                            GameScr.bu.addElement(var232);
                        }

                        ResLog.c("idMessageTime + messageStr + timeMessage:::  " + var2 + "_" + var225 + "_" + var229);
                        break;
                    case 66:
                        this.h(msg);
                        break;
                    case 68:
                        ResLog.c("ADD ITEM TO MAP --------------------------------------");
                        var110 = msg.reader().readShort();
                        short var112 = msg.reader().readShort();
                        short var113 = msg.reader().readShort();
                        var114 = msg.reader().readShort();
                        int var115 = msg.reader().readInt();
                        short var116 = 0;
                        if (var115 == -2) {
                            var116 = msg.reader().readShort();
                        }

                        ItemMap var117 = new ItemMap(var115, var110, var112, var113, var114, var116);
                        boolean var118 = false;

                        for (int var119 = 0; var119 < GameScr.vItemMap.size(); ++var119) {
                            if (((ItemMap) GameScr.vItemMap.elementAt(var119)).d == var117.d) {
                                var118 = true;
                                break;
                            }
                        }

                        if (!var118) {
                            GameScr.vItemMap.addElement(var117);
                        }
                        break;
                    case 69:
                        SoundMn.a = msg.reader().readByte() != 0;
                        break;
                    case 81:
                        GameScr.F.elementAt(msg.reader().readUnsignedByte());
                        msg.reader().readBoolean();
                        break;
                    case 82:
                        ((Mob) GameScr.F.elementAt(msg.reader().readUnsignedByte())).z = msg.reader().readBoolean();
                        break;
                    case 83:
                        if ((var92 = msg.reader().readInt()) == Char.myCharz().charID) {
                            var91 = Char.myCharz();
                        } else {
                            var91 = GameScr.findCharInMap(var92);
                        }

                        if (var91 == null) {
                            return;
                        }

                        Mob var93 = (Mob) GameScr.F.elementAt(msg.reader().readUnsignedByte());
                        if (var91.aR != null) {
                            var91.aR.a(var93);
                        }
                        break;
                    case 84:
                        if ((var92 = msg.reader().readInt()) == Char.myCharz().charID) {
                            var91 = Char.myCharz();
                        } else if ((var91 = GameScr.findCharInMap(var92)) == null) {
                            return;
                        }

                        var91.cHP = var91.cHPFull;
                        var91.cMP = var91.cMPFull;
                        var91.cx = msg.reader().readShort();
                        var91.cy = msg.reader().readShort();
                        var91.L();
                        break;
                    case 85:
                        GameScr.F.elementAt(msg.reader().readUnsignedByte());
                        msg.reader().readBoolean();
                        break;
                    case 86:
                        Mob var90;
                        (var90 = (Mob) GameScr.F.elementAt(msg.reader().readUnsignedByte())).A = msg.reader().readBoolean();
                        if (!var90.A) {
                            ServerEffect.addServerEffect(77, var90.x, var90.y - 9, 1);
                        }
                        break;
                    case 87:
                        ((Mob) GameScr.F.elementAt(msg.reader().readUnsignedByte())).B = msg.reader().readBoolean();
                        break;
                    case 88:
                        String var99 = msg.reader().readUTF();
                        Short var100 = new Short(msg.reader().readShort());
                        //null.a(var99, new nr_dc(nr_av.bt, main.nr_a.h, 88818, var100), 0);
                        break;
                    case 90:
                        b(msg);
                        break;
                    case 92:
                        if (main.GameCanvas.currentScreen == GameScr.c) {
                            main.GameCanvas.endDlg();
                        }

                        String var85 = msg.reader().readUTF();
                        String var86 = ResLog.a(msg.reader().readUTF());
                        ResLog.c("chat text= " + var86);
                        String var87 = "";
                        Char var88 = null;
                        byte var89 = 0;
                        if (!var85.equals("")) {
                            (var88 = new Char()).charID = msg.reader().readInt();
                            var88.head = msg.reader().readShort();
                            var88.headICON = msg.reader().readShort();
                            var88.body = msg.reader().readShort();
                            var88.bag = msg.reader().readShort();
                            var88.leg = msg.reader().readShort();
                            var89 = msg.reader().readByte();
                            var88.cName = var85;
                        }

                        var87 = var87 + var86;
                        InfoDlg.hide();
                        if (var85.equals("")) {
                            GameScr.info1.a(var87, 0);
                        } else {
                            GameScr.aD.a(var87, var88, var89 == 0);
                            if (main.GameCanvas.panel.isShow && main.GameCanvas.panel.z == 8) {
                                main.GameCanvas.panel.x();
                            }
                        }
                        break;
                    case 94:
                        GameScr.info1.a(msg.reader().readUTF(), 0);
                        break;
                    case 112:
                        if ((var5 = msg.reader().readByte()) == 0) {
                            Panel.q = msg.reader().readShort();
                            Panel.p = msg.reader().readUTF();
                        } else if (var5 == 1) {
                            var2 = msg.reader().readByte();
                            Char.myCharz().aK = new String[var2][];
                            Char.myCharz().aL = new short[var2][];
                            main.GameCanvas.panel.aB = new String[var2][];

                            for (var3 = 0; var3 < var2; ++var3) {
                                main.GameCanvas.panel.aB[var3] = new String[2];
                                if ((var4 = ResLog.a(msg.reader().readUTF(), "\n", 0)).length == 2) {
                                    main.GameCanvas.panel.aB[var3] = var4;
                                }

                                if (var4.length == 1) {
                                    main.GameCanvas.panel.aB[var3][0] = var4[0];
                                    main.GameCanvas.panel.aB[var3][1] = "";
                                }

                                var5 = msg.reader().readByte();
                                Char.myCharz().aK[var3] = new String[var5];
                                Char.myCharz().aL[var3] = new short[var5];

                                for (var6 = 0; var6 < var5; ++var6) {
                                    Char.myCharz().aL[var3][var6] = msg.reader().readShort();
                                    Char.myCharz().aK[var3][var6] = msg.reader().readUTF();
                                }
                            }

                            main.GameCanvas.panel.L[25] = main.GameCanvas.panel.aB;
                            main.GameCanvas.panel.E();
                            main.GameCanvas.panel.show();
                        }
                }

                Char var295;
                switch (msg.command) {
                    case -75:
                        var269 = null;

                        try {
                            var269 = (Mob) GameScr.F.elementAt(msg.reader().readUnsignedByte());
                        } catch (Exception var193) {
                        }

                        if (var269 != null) {
                            var269.H = msg.reader().readByte();
                            if (var269.H > 0) {
                                var269.S = ResLog.random(0, 3);
                                return;
                            }
                        }

                        return;
                    case -73:
                        var230 = msg.reader().readByte();

                        for (var233 = 0; var233 < GameScr.G.size(); ++var233) {
                            Npc var288;
                            if ((var288 = (Npc) GameScr.G.elementAt(var233)).template.npcTemplateId == var230) {
                                if (msg.reader().readByte() == 0) {
                                    var288.de = true;
                                } else {
                                    var288.de = false;
                                }

                                return;
                            }
                        }

                        return;
                    case -17:
                        Char.myCharz().cF = true;
                        Char.myCharz().cPk = msg.reader().readByte();
                        Char.myCharz().a(msg.reader().readShort(), msg.reader().readShort());

                        try {
                            Char.myCharz().cPower = msg.reader().readLong();
                            Char.myCharz().applyCharLevelPercent();
                        } catch (Exception var184) {
                        }

                        Char.myCharz();
                        return;
                    case -16:
                        if (Char.myCharz().co != 0 || Char.myCharz().cp != 0) {
                            Char.myCharz().cx = Char.myCharz().co;
                            Char.myCharz().cy = Char.myCharz().cp;
                            Char.myCharz().co = Char.myCharz().cp = 0;
                        }

                        Char.myCharz().L();
                        Char.myCharz().bJ = false;
                        Char.myCharz().cF = false;
                        return;
                    case -13:
                        if ((var253 = msg.reader().readUnsignedByte()) <= GameScr.F.size() - 1 && var253 >= 0) {
                            (var269 = (Mob) GameScr.F.elementAt(var253)).G = msg.reader().readByte();
                            var269.H = msg.reader().readByte();
                            if (var269.H != 0) {
                                var269.S = ResLog.random(0, 3);
                            }

                            var269.x = var269.xFirst;
                            var269.y = var269.yFirst;
                            ResLog.c("HOI SINH x= " + var269.xFirst + " y= " + var269.yFirst);
                            var269.p = 5;
                            var269.aa = false;
                            var269.k = msg.reader().readInt();
                            var269.l = var269.k;
                            var269.A();
                            ServerEffect.addServerEffect(60, var269.x, var269.y, 1);
                            return;
                        }

                        return;
                    case -12:
                        ResLog.c("SERVER SEND MOB DIE");
                        var269 = null;

                        try {
                            var269 = (Mob) GameScr.F.elementAt(msg.reader().readUnsignedByte());
                        } catch (Exception var190) {
                        }

                        if (var269 == null || var269.p == 0 || var269.p == 0) {
                            return;
                        }

                        var269.k();

                        try {
                            var11 = msg.readInt();
                            if (msg.reader().readBoolean()) {
                                GameScr.a("-" + var11, var269.x, var269.y - var269.w, 0, -2, 3);
                            } else {
                                GameScr.a("-" + var11, var269.x, var269.y - var269.w, 0, -2, 5);
                            }

                            var286 = msg.reader().readByte();

                            for (var287 = 0; var287 < var286; ++var287) {
                                ItemMap var300 = new ItemMap(msg.reader().readShort(), msg.reader().readShort(), var269.x, var269.y, msg.reader().readShort(), msg.reader().readShort());
                                var3 = msg.reader().readInt();
                                var300.c = var3;
                                ResLog.c("playerid= " + var3 + " my id= " + Char.myCharz().charID);
                                GameScr.vItemMap.addElement(var300);
                                if (ResLog.g(var300.b - Char.myCharz().cy) < 24 && ResLog.g(var300.a - Char.myCharz().cx) < 24) {
                                    Char.myCharz().aU = null;
                                }
                            }

                            return;
                        } catch (Exception var211) {
                            return;
                        }
                    case -11:
                        var269 = null;

                        try {
                            var11 = msg.reader().readUnsignedByte();
                            ResLog.c("mob index= " + var11);
                            var269 = (Mob) GameScr.F.elementAt(var11);
                        } catch (Exception var188) {
                        }

                        if (var269 != null) {
                            Char.myCharz().af = false;
                            Char.bH = false;
                            var11 = msg.readInt();

                            try {
                                var12 = msg.readInt();
                            } catch (Exception var187) {
                                var12 = 0;
                            }

                            if (var269.T) {
                                Char.myCharz().a(var11, var12, false, true);
                            } else {
                                var269.E = var11;
                                var269.F = var12;
                                var269.a(Char.myCharz());
                            }

                            return;
                        }

                        return;
                    case -10:
                        var269 = null;

                        try {
                            var269 = (Mob) GameScr.F.elementAt(msg.reader().readUnsignedByte());
                        } catch (Exception var186) {
                        }

                        if (var269 == null) {
                            return;
                        }

                        if ((var295 = GameScr.findCharInMap(msg.reader().readInt())) != null) {
                            var11 = msg.readInt();
                            var269.E = var295.cHP - var11;

                            try {
                                var295.cMP = msg.readInt();
                            } catch (Exception var185) {
                            }

                            if (var269.T) {
                                var295.a(var269.E, 0, false, true);
                            } else {
                                var269.a(var295);
                            }

                            return;
                        }

                        return;
                    case -9:
                        var269 = null;

                        try {
                            var269 = (Mob) GameScr.F.elementAt(msg.reader().readUnsignedByte());
                        } catch (Exception var192) {
                        }

                        if (var269 == null) {
                            return;
                        }

                        var269.k = msg.readInt();
                        var269.A();
                        if ((var11 = msg.readInt()) != 1) {
                            if (var11 > 1) {
                                var269.d();
                            }

                            boolean var292 = msg.reader().readBoolean();
                            if ((var286 = msg.reader().readByte()) != -1) {
                                EffecMn.addEff(new Effect(var286, var269.x, var269.getY(), 3, 1, -1));
                            }

                            if (var292) {
                                GameScr.a("-" + var11, var269.x, var269.getY() - var269.getH(), 0, -2, 3);
                                return;
                            } else {
                                if (var11 == 0) {
                                    var269.x = var269.xFirst;
                                    var269.y = var269.yFirst;
                                    GameScr.a(mResources.cE, var269.x, var269.getY() - var269.getH(), 0, -2, 4);
                                } else if (var11 > 1) {
                                    GameScr.a("-" + var11, var269.x, var269.getY() - var269.getH(), 0, -2, 5);
                                    return;
                                }

                                return;
                            }
                        }

                        return;
                    case -8:
                        if ((var295 = GameScr.findCharInMap(msg.reader().readInt())) != null) {
                            var295.cPk = msg.reader().readByte();
                            var295.b(msg.reader().readShort(), msg.reader().readShort());
                            return;
                        }

                        return;
                    case -7:
                        var8 = msg.reader().readInt();

                        for (var253 = 0; var253 < GameScr.vCharInMap.size(); ++var253) {
                            var274 = null;

                            try {
                                var274 = (Char) GameScr.vCharInMap.elementAt(var253);
                            } catch (Exception var194) {
                            }

                            if (var274 == null) {
                                return;
                            }

                            if (var274.charID == var8) {
                                (new StringBuffer("SA8x2y")).append(var253).toString();
                                var274.b(msg.reader().readShort(), msg.reader().readShort(), 0);
                                System.currentTimeMillis();
                                return;
                            }
                        }

                        return;
                    case -6:
                        ResLog.c("PLAYER REMOVED!!!!!============");
                        var8 = msg.reader().readInt();

                        for (var253 = 0; var253 < GameScr.vCharInMap.size(); ++var253) {
                            if ((var274 = (Char) GameScr.vCharInMap.elementAt(var253)) != null && var274.charID == var8) {
                                if (!var274.bc && !var274.t) {
                                    ServerEffect.addServerEffect(60, var274.cx, var274.cy, 1);
                                }

                                if (!var274.t) {
                                    GameScr.vCharInMap.removeElementAt(var253);
                                }

                                return;
                            }
                        }

                        return;
                    case -5:
                        var6 = msg.reader().readInt();
                        Object var299;
                        if ((var224 = msg.reader().readInt()) != -100) {
                            ((Char) (var299 = new Char())).charID = var6;
                            ((Char) var299).ah = var224;
                        } else {
                            ((Char) (var299 = new Mabu())).charID = var6;
                            ((Char) var299).ah = var224;
                        }

                        if (((Char) var299).ah == -2) {
                            ((Char) var299).cD = true;
                        }

                        if (onMessage((Char) var299, msg)) {
                            var241 = msg.reader().readByte();
                            if (((Char) var299).cy <= 10 && var241 != 0 && var241 != 2) {
                                Teleport var283;
                                (var283 = new Teleport(((Char) var299).cx, ((Char) var299).cy, ((Char) var299).head, ((Char) var299).I, 1, false, var241 == 1 ? ((Char) var299).cgender : var241)).d = ((Char) var299).charID;
                                ((Char) var299).s = true;
                                Teleport.a(var283);
                            }

                            if (var241 == 2) {
                                ((Char) var299).r();
                            }

                            for (var8 = 0; var8 < GameScr.F.size(); ++var8) {
                                Mob var261;
                                if ((var261 = (Mob) GameScr.F.elementAt(var8)) != null && var261.J && var261.mobId == ((Char) var299).charID) {
                                    ResLog.c("co 1 con quai");
                                    ((Char) var299).aR = var261;
                                    ((Char) var299).aR.x = ((Char) var299).cx;
                                    ((Char) var299).aR.y = ((Char) var299).cy - 40;
                                    break;
                                }
                            }

                            if (GameScr.findCharInMap(((Char) var299).charID) == null) {
                                GameScr.vCharInMap.addElement(var299);
                            }

                            ((Char) var299).cC = msg.reader().readByte();
                            if ((var250 = msg.reader().readShort()) != -1) {
                                ((Char) var299).bu = true;
                                if (var250 != 346 && var250 != 347 && var250 != 348) {
                                    if (var250 != 349 && var250 != 350 && var250 != 351) {
                                        if (var250 == 396) {
                                            ((Char) var299).bw = true;
                                        } else if (var250 == 532) {
                                            ((Char) var299).bx = true;
                                        } else if (var250 >= Char.bs) {
                                            ((Char) var299).bt = var250;
                                        }
                                    } else {
                                        ((Char) var299).bv = true;
                                    }
                                } else {
                                    ((Char) var299).bv = false;
                                }
                            } else {
                                ((Char) var299).bu = false;
                            }
                        }

                        var241 = msg.reader().readByte();
                        ((Char) var299).by = var241;
                        ((Char) var299).isNhapThe = msg.reader().readByte() == 1;

                        try {
                            ((Char) var299).idAuraEff = msg.reader().readShort();
                            ((Char) var299).idEff_Set_Item = msg.reader().readByte();
                            ((Char) var299).idHat = msg.reader().readShort();
                        } catch (Exception var195) {
                        }

                        GameScr.gI();
                        GameScr.a(((Char) var299).charID, ((Char) var299).by);
                        if (((Char) var299).bag >= 201 && ((Char) var299).bag < 255) {
                            Effect var294;
                            (var294 = new Effect(((Char) var299).bag, (Char) var299, 2, -1, 10, (byte) 1)).b = 5;
                            ((Char) var299).a(var294);
                            return;
                        }

                        for (var8 = 0; var8 < 54; ++var8) {
                            ((Char) var299).b((int) 0, (int) (var8 + 201));
                        }

                        return;
                    case -3:
                        var2 = msg.reader().readByte();
                        var3 = msg.reader().readInt();
                        if (var2 == 0) {
                            var10000 = Char.myCharz();
                            var10000.cPower += (long) var3;
                        }

                        if (var2 == 1) {
                            var10000 = Char.myCharz();
                            var10000.cTiemNang += (long) var3;
                        }

                        if (var2 == 2) {
                            var10000 = Char.myCharz();
                            var10000.cPower += (long) var3;
                            var10000 = Char.myCharz();
                            var10000.cTiemNang += (long) var3;
                        }

                        Char.myCharz().applyCharLevelPercent();
                        if (Char.myCharz().cTypePk != 3) {
                            GameScr.a((var3 > 0 ? "+" : "") + var3, Char.myCharz().cx, Char.myCharz().cy - Char.myCharz().al, 0, -4, 2);
                            if (var3 > 0 && Char.myCharz().v != null && Char.myCharz().v.a == 5002) {
                                ServerEffect.addServerEffect(55, Char.myCharz().v.i, Char.myCharz().v.e, 1);
                                ServerEffect.addServerEffect(55, Char.myCharz().cx, Char.myCharz().cy, 1);
                                return;
                            }
                        }

                        return;
                    case -2:
                        var224 = msg.reader().readInt();
                        var10000 = Char.myCharz();
                        var10000.au += var224;
                        GameScr.a(var224 > 0 ? "+" + var224 : "" + var224, Char.myCharz().cx, Char.myCharz().cy - Char.myCharz().al - 10, 0, -2, 1);
                        return;
                    case -1:
                        var233 = msg.reader().readInt();
                        var10000 = Char.myCharz();
                        var10000.gold += (long) var233;
                        Char.myCharz().xuStr = mSystem.numberTostring(Char.myCharz().gold);
                        var10000 = Char.myCharz();
                        var10000.au -= var233;
                        GameScr.a("+" + var233, Char.myCharz().cx, Char.myCharz().cy - Char.myCharz().al - 10, 0, -2, 1);
                        return;
                    case 18:
                        var286 = msg.reader().readByte();

                        for (var287 = 0; var287 < var286; ++var287) {
                            var224 = msg.reader().readInt();
                            short var297 = msg.reader().readShort();
                            var229 = msg.reader().readShort();
                            var233 = msg.readInt();
                            Char var281;
                            if ((var281 = GameScr.findCharInMap(var224)) != null) {
                                var281.cx = var297;
                                var281.cy = var229;
                                var281.cHP = var233;
                                System.currentTimeMillis();
                            }
                        }

                        return;
                    case 19:
                        Char.myCharz();
                        msg.reader().readUnsignedShort();
                        Char.myCharz();
                        msg.reader().readUnsignedShort();
                        return;
                    case 44:
                        var11 = msg.reader().readInt();
                        var285 = msg.reader().readUTF();
                        ResLog.c("user id= " + var11 + " text= " + var285);
                        if (Char.myCharz().charID == var11) {
                            var295 = Char.myCharz();
                        } else {
                            var295 = GameScr.findCharInMap(var11);
                        }

                        if (var295 != null) {
                            var295.a(var285);
                            return;
                        }

                        return;
                    case 45:
                        var269 = null;

                        try {
                            var269 = (Mob) GameScr.F.elementAt(msg.reader().readUnsignedByte());
                        } catch (Exception var191) {
                        }

                        if (var269 != null) {
                            var269.k = msg.reader().readInt();
                            var269.A();
                            GameScr.a(mResources.cE, var269.x, var269.y - var269.w, 0, -2, 4);
                        }

                        return;
                    case 66:
                        ResLog.c("ME DIE XP DOWN NOT IMPLEMENT YET!!!!!!!!!!!!!!!!!!!!!!!!!!");
                        return;
                    case 74:
                        var269 = null;

                        try {
                            var269 = (Mob) GameScr.F.elementAt(msg.reader().readUnsignedByte());
                        } catch (Exception var189) {
                        }

                        if (var269 != null && var269.p != 0 && var269.p != 0) {
                            var269.p = 0;
                            ServerEffect.addServerEffect(60, var269.x, var269.y, 1);
                            ItemMap var293 = new ItemMap(msg.reader().readShort(), msg.reader().readShort(), var269.x, var269.y, msg.reader().readShort(), msg.reader().readShort());
                            GameScr.vItemMap.addElement(var293);
                            if (ResLog.g(var293.b - Char.myCharz().cy) < 24 && ResLog.g(var293.a - Char.myCharz().cx) < 24) {
                                Char.myCharz().aU = null;
                                return;
                            }
                        }

                        return;
                    case 95:
                        var3 = msg.reader().readInt();
                        var10000 = Char.myCharz();
                        var10000.gold += (long) var3;
                        Char.myCharz().xuStr = mSystem.numberTostring(Char.myCharz().gold);
                        GameScr.a(var3 > 0 ? "+" + var3 : "" + var3, Char.myCharz().cx, Char.myCharz().cy - Char.myCharz().al - 10, 0, -2, 1);
                        return;
                    case 96:
                        Char.myCharz().be.addElement(new nr_co(msg.reader().readByte(), msg.reader().readShort(), msg.reader().readShort(), msg.reader().readUTF(), msg.reader().readUTF(), msg.reader().readByte(), msg.reader().readByte()));
                        return;
                    case 97:
                        var230 = msg.reader().readByte();

                        for (var233 = 0; var233 < Char.myCharz().be.size(); ++var233) {
                            nr_co var298;
                            if ((var298 = (nr_co) Char.myCharz().be.elementAt(var233)).a == var230) {
                                var298.b = msg.reader().readShort();
                                return;
                            }
                        }
                        break label5961;
                    default:
                        return;
                }
            } catch (Exception var222) {
                (new StringBuffer(String.valueOf(var222.getMessage()))).append(" ").append(var222.toString()).toString();
                var222.printStackTrace();
            } finally {
                if (msg != null) {
                    msg.cleanup();
                }

            }

            return;
        }

    }

    private static void c(Message var0) throws IOException {
        byte var1;
        Panel2.a = new nr_bf[var1 = var0.reader().readByte()];
        ResLog.c("[LEN] sl nguoi choi " + var1);

        for (int var2 = 0; var2 < var1; ++var2) {
            int var3 = var0.reader().readInt();
            String var4 = var0.reader().readUTF();
            short var5 = var0.reader().readShort();
            short var6 = var0.reader().readShort();
            short var7 = var0.reader().readShort();
            long var8 = var0.reader().readLong();
            Panel2.a[var2] = new nr_bf(var3, var4, var5, var6, var7, var8);
        }

        main.GameCanvas.H.switchToMe();
        main.GameCanvas.H.a(var1);
    }

    private static void onMessage(DataInputStream var0) throws IOException {
        GameScr.am = var0.readByte();
        GameScr.gI().K = new nr_eh[var0.readByte()];

        int var1;
        for (var1 = 0; var1 < GameScr.gI().K.length; ++var1) {
            GameScr.gI().K[var1] = new nr_eh();
            GameScr.gI();
            GameScr.gI();
            var0.readUTF();
        }

        GameScr.nClass = new NClass[var0.readByte()];

        for (var1 = 0; var1 < GameScr.nClass.length; ++var1) {
            GameScr.nClass[var1] = new NClass();
            GameScr.nClass[var1].a = var1;
            var0.readUTF();
            GameScr.nClass[var1].b = new SkillTemplate[var0.readByte()];

            for (int var2 = 0; var2 < GameScr.nClass[var1].b.length; ++var2) {
                GameScr.nClass[var1].b[var2] = new SkillTemplate();
                GameScr.nClass[var1].b[var2].id = var0.readByte();
                GameScr.nClass[var1].b[var2].b = var0.readUTF();
                GameScr.nClass[var1].b[var2].maxPoint = var0.readByte();
                GameScr.nClass[var1].b[var2].d = var0.readByte();
                GameScr.nClass[var1].b[var2].type = var0.readByte();
                GameScr.nClass[var1].b[var2].f = var0.readShort();
                GameScr.nClass[var1].b[var2].i = var0.readUTF();
                short var3 = 130;
                if (main.GameCanvas.z == 128 || main.GameCanvas.A <= 208) {
                    var3 = 100;
                }

                GameScr.nClass[var1].b[var2].g = mFont.m.getWidth(var0.readUTF(), var3);
                GameScr.nClass[var1].b[var2].h = new Skill[var0.readByte()];

                for (int var4 = 0; var4 < GameScr.nClass[var1].b[var2].h.length; ++var4) {
                    GameScr.nClass[var1].b[var2].h[var4] = new Skill();
                    GameScr.nClass[var1].b[var2].h[var4].b = var0.readShort();
                    GameScr.nClass[var1].b[var2].h[var4].template = GameScr.nClass[var1].b[var2];
                    GameScr.nClass[var1].b[var2].h[var4].point = var0.readByte();
                    GameScr.nClass[var1].b[var2].h[var4].d = var0.readLong();
                    GameScr.nClass[var1].b[var2].h[var4].i = var0.readShort();
                    GameScr.nClass[var1].b[var2].h[var4].e = var0.readInt();
                    GameScr.nClass[var1].b[var2].h[var4].g = var0.readShort();
                    GameScr.nClass[var1].b[var2].h[var4].h = var0.readShort();
                    var0.readByte();
                    GameScr.nClass[var1].b[var2].h[var4].k = var0.readShort();
                    var0.readShort();
                    GameScr.nClass[var1].b[var2].h[var4].moreInfo = var0.readUTF();
                    nr_o.a(GameScr.nClass[var1].b[var2].h[var4]);
                }
            }
        }

    }

    private static void createMap(DataInputStream stream) throws IOException {
        GameScr.vcMap = stream.readByte();
        TileMap.mapNames = new String[stream.readUnsignedByte()];

        for (int var1 = 0; var1 < TileMap.mapNames.length; ++var1) {
            TileMap.mapNames[var1] = stream.readUTF();
        }

        Npc.npcTemplates = new NpcTemplate[stream.readByte()];

        byte b;
        for (b = 0; b < Npc.npcTemplates.length; ++b) {
            Npc.npcTemplates[b] = new NpcTemplate();
            Npc.npcTemplates[b].npcTemplateId = b;
            Npc.npcTemplates[b].name = stream.readUTF();
            Npc.npcTemplates[b].headId = stream.readShort();
            Npc.npcTemplates[b].bodyId = stream.readShort();
            Npc.npcTemplates[b].legId = stream.readShort();
            Npc.npcTemplates[b].menu = new String[stream.readByte()][];

            for (int i = 0; i < Npc.npcTemplates[b].menu.length; ++i) {
                Npc.npcTemplates[b].menu[i] = new String[stream.readByte()];

                for (int a = 0; a < Npc.npcTemplates[b].menu[i].length; ++a) {
                    Npc.npcTemplates[b].menu[i][a] = stream.readUTF();
                }
            }
        }

        Mob.arrMobTemplate = new MobTemplate[stream.readByte()];

        for (b = 0; b < Mob.arrMobTemplate.length; ++b) {
            Mob.arrMobTemplate[b] = new MobTemplate();
            Mob.arrMobTemplate[b].mobTemplateId = stream.readByte();
            Mob.arrMobTemplate[b].type = stream.readUTF();
            Mob.arrMobTemplate[b].name = stream.readInt();
            Mob.arrMobTemplate[b].hp = stream.readByte();
            Mob.arrMobTemplate[b].rangeMove = stream.readByte();
            Mob.arrMobTemplate[b].dartType = stream.readByte();
        }

    }

    private static void onMessage(DataInputStream var0, boolean var1) throws IOException {
        GameScr.vcData = var0.readByte();
        ResLog.c("vcData= " + GameScr.vcData + " vData=" + GameScr.ao);
        Rms.saveRMS("NR_dart", Util.readByteArray(var0));
        Rms.saveRMS("NR_arrow", Util.readByteArray(var0));
        Rms.saveRMS("NR_effect", Util.readByteArray(var0));
        Rms.saveRMS("NR_image", Util.readByteArray(var0));
        Rms.saveRMS("NR_part", Util.readByteArray(var0));
        Rms.saveRMS("NR_skill", Util.readByteArray(var0));
        Rms.DeleteStorage("NRdata");
    }

    private static Image onMessage(byte[] var0) {
        try {
            return Image.createImage(var0, 0, var0.length);
        } catch (Exception var1) {
            return null;
        }
    }

    private static void onMessage(Message var0, int var1) {
        try {
            ClanMessage var2 = new ClanMessage();
            byte var3 = var0.reader().readByte();
            var2.b = var3;
            var2.a = var0.reader().readInt();
            var2.c = var0.reader().readInt();
            var2.d = var0.reader().readUTF();
            var2.h = var0.reader().readByte();
            var2.e = (long) (var0.reader().readInt() + 1000000000);
            ResLog.c("type= " + var2.b + " id= " + var2.a + " playID= " + var2.c + " time= " + var2.e);
            boolean var4 = false;
            GameScr.aV = false;
            if (var3 == 0) {
                String var6 = var0.reader().readUTF();
                ResLog.c("str chat " + var6);
                GameScr.aV = true;
                if (mFont.k.getWidth(var6) > Panel.aa - 60) {
                    var2.f = mFont.k.getWidth(var6, Panel.aa - 10);
                } else {
                    var2.f = new String[1];
                    var2.f[0] = var6;
                }

                var2.g = var0.reader().readByte();
            } else if (var3 == 1) {
                var2.i = var0.reader().readByte();
                var2.j = var0.reader().readByte();
                if (var4 = var0.reader().readByte() == 1) {
                    GameScr.aV = true;
                }

                if (var2.c != Char.myCharz().charID) {
                    if (var2.i < var2.j) {
                        var2.k = new String[]{mResources.cF};
                    } else {
                        var2.k = null;
                    }
                }

                if (main.GameCanvas.panel.ah != null) {
                    main.GameCanvas.panel.a(var2.i, var2.j);
                }
            } else if (var3 == 2 && Char.myCharz().aj == 0) {
                GameScr.aV = true;
                var2.k = new String[]{mResources.bu, mResources.cG};
            }

            if (main.GameCanvas.currentScreen != GameScr.c) {
                GameScr.aV = false;
            } else if (main.GameCanvas.panel.isShow && main.GameCanvas.panel.z == 0 && main.GameCanvas.panel.A == 3) {
                GameScr.aV = false;
            }

            ClanMessage.a(var2, var1, var4);
        } catch (Exception var5) {
            var5.printStackTrace();
        }
    }

    private static void onMessage(byte var0) {
        ResLog.c("is loading map = " + Char.isLoadingMap);
        GameScr.gI().aW = 0;
        GameScr.bk = false;
        nr_cu.a = null;
        GameScr.info1.f = false;
        GameScr.aD.f = false;
        GameScr.z = 0;
        main.GameCanvas.panel.isShow = false;
        SoundMn.stopAll();
        if (!GameScr.b && !nr_cu.b) {
            GameScr.gI().a();
        }

        GameScr.loadCamera(var0 == 1 ? Char.myCharz().cx : -1, var0 == 0 ? -1 : 0);
        TileMap.h();
        TileMap.c(TileMap.e);
        ResLog.c("LOAD GAMESCR 2");
        Char.myCharz().D = 0;
        Char.myCharz().statusMe = 4;
        Char.myCharz().bP = null;
        Char.myCharz().aQ = null;
        Char.myCharz().aU = null;
        Char.myCharz().aT = null;
        Char.myCharz().aV = null;
        Char.myCharz().skillPaint = null;
        Char.myCharz().c(false);
        Char.myCharz().skillPaintRandomPaint = null;
        main.GameCanvas.k();
        if (Char.myCharz().cy >= TileMap.d - 100) {
            Char.myCharz().bq = true;
            Char var10000 = Char.myCharz();
            var10000.cx += ResLog.g(ResLog.random(0, 80));
            Service.gI().g();
        }

        GameScr.gI().o();
        main.GameCanvas.a(TileMap.bgID);
        Char.bH = false;

        for (int var1 = 0; var1 < Char.myCharz().aB.size(); ++var1) {
            Char.myCharz().aB.elementAt(var1);
        }

        main.GameCanvas.f();
        main.GameCanvas.clearKeyPressed();
        GameScr.gI().dHP = Char.myCharz().cHP;
        GameScr.gI().dMP = Char.myCharz().cMP;
        Char.bG = false;
        GameScr.gI().switchToMe();
        if (Char.myCharz().cy <= 10 && var0 != 0 && var0 != 2) {
            Teleport.a(new Teleport(Char.myCharz().cx, Char.myCharz().cy, Char.myCharz().head, Char.myCharz().I, 1, true, var0 == 1 ? Char.myCharz().cgender : var0));
            Char.myCharz().s = true;
        }

        if (var0 == 2) {
            Char.myCharz().r();
        }

        if (GameScr.gI().ba) {
            if (TileMap.l == GameScr.gI().bg && TileMap.n == GameScr.gI().bh) {
                GameScr.gI().c(GameScr.gI().be, GameScr.gI().bf);
            }

            if (mGraphics.zoomLevel > 1) {
                GameScr.gI().s();
            }
        }

        InfoDlg.hide();
        InfoDlg.a(TileMap.k, mResources.ck + " " + TileMap.n, 30);
        main.GameCanvas.endDlg();
        main.GameCanvas.isLoading = false;
        Hint.clickMob();
        Hint.clickNpc();
    }

    private void d(Message var1) {
        try {
            ResLog.c("123 char= " + Char.myCharz() == null ? "null" : "!null");
            Char var10000 = Char.myCharz();
            Char var10001 = Char.myCharz();
            Char.myCharz();
            var10000.cx = var10001.bD = var1.reader().readShort();
            var10000 = Char.myCharz();
            var10001 = Char.myCharz();
            Char.myCharz();
            var10000.cy = var10001.bE = var1.reader().readShort();
            Char.myCharz().cl = Char.myCharz().cx;
            Char.myCharz().cm = Char.myCharz().cy;
            ResLog.c("head= " + Char.myCharz().head + " body= " + Char.myCharz().body + " left= " + Char.myCharz().leg + " x= " + Char.myCharz().cx + " y= " + Char.myCharz().cy + " chung toc= " + Char.myCharz().cgender);
            if (Char.myCharz().cx >= 0 && Char.myCharz().cx <= 100) {
                Char.myCharz().I = 1;
            } else if (Char.myCharz().cx >= TileMap.a - 100 && Char.myCharz().cx <= TileMap.a) {
                Char.myCharz().I = -1;
            }

            byte var2 = var1.reader().readByte();
            ResLog.c("vGo size= " + var2);
            if (!GameScr.info1.e) {
                GameScr.info1.d = Char.myCharz().cx - GameScr.cmx;
                GameScr.info1.c = Char.myCharz().cy - GameScr.cmy;
            }

            int var3;
            for (var3 = 0; var3 < var2; ++var3) {
                new Waypoint(var1.reader().readShort(), var1.reader().readShort(), var1.reader().readShort(), var1.reader().readShort(), var1.reader().readBoolean(), var1.reader().readBoolean(), var1.reader().readUTF());
            }

            var2 = var1.reader().readByte();
            Mob.L.removeAllElements();

            for (byte var13 = 0; var13 < var2; ++var13) {
                Mob var4;
                (var4 = new Mob(var13, var1.reader().readBoolean(), var1.reader().readBoolean(), var1.reader().readBoolean(), var1.reader().readBoolean(), var1.reader().readBoolean(), var1.reader().readByte(), var1.reader().readByte(), var1.reader().readInt(), var1.reader().readByte(), var1.reader().readInt(), var1.reader().readShort(), var1.reader().readShort(), var1.reader().readByte(), var1.reader().readByte())).P = var4.x;
                var4.Q = var4.y;
                var4.I = var1.reader().readBoolean();
                if (Mob.arrMobTemplate[var4.C].mobTemplateId != 0) {
                    if (var13 % 3 == 0) {
                        var4.o = -1;
                    } else {
                        var4.o = 1;
                    }

                    var4.x += 10 - var13 % 20;
                }

                var4.J = false;
                BigBoss var5 = null;
                BachTuoc var6 = null;
                BigBoss2 var7 = null;
                NewBoss var8 = null;
                if (var4.C == 70) {
                    var5 = new BigBoss(var13, (short) var4.x, (short) var4.y, 70, var4.k, var4.l, var4.G);
                }

                if (var4.C == 71) {
                    var6 = new BachTuoc(var13, (short) var4.x, (short) var4.y, 71, var4.k, var4.l);
                }

                if (var4.C == 72) {
                    var7 = new BigBoss2(var13, (short) var4.x, (short) var4.y, 72, var4.k, var4.l);
                }

                if (var4.I) {
                    var8 = new NewBoss(var13, (short) var4.x, (short) var4.y, var4.C, var4.k, var4.l);
                }

                if (var8 != null) {
                    GameScr.F.addElement(var8);
                } else if (var5 != null) {
                    GameScr.F.addElement(var5);
                } else if (var6 != null) {
                    GameScr.F.addElement(var6);
                } else if (var7 != null) {
                    GameScr.F.addElement(var7);
                } else {
                    GameScr.F.addElement(var4);
                }
            }

            if (Char.myCharz().aR != null && GameScr.c(Char.myCharz().aR.mobId) == null) {
                Char.myCharz().aR.getData();
                Char.myCharz().aR.x = Char.myCharz().cx;
                Char.myCharz().aR.y = Char.myCharz().cy - 40;
                GameScr.F.addElement(Char.myCharz().aR);
            }

            var1.reader().readByte();
            var2 = var1.reader().readByte();
            ResLog.c("NPC size= " + var2);

            short var21;
            short var24;
            for (var3 = 0; var3 < var2; ++var3) {
                byte var15 = var1.reader().readByte();
                var21 = var1.reader().readShort();
                var24 = var1.reader().readShort();
                byte var26 = var1.reader().readByte();
                ResLog.c("tempalte = " + var26);
                short var34 = var1.reader().readShort();
                ResLog.c("1");
                if (var26 != 6) {
                    ResLog.c("2");
                    if (Char.myCharz().aD.c < 7 || Char.myCharz().aD.c == 7 && Char.myCharz().aD.a <= 1) {
                        if (var26 == 7 || var26 == 8 || var26 == 9) {
                            continue;
                        }

                        ResLog.c("3");
                    }

                    if (Char.myCharz().aD.c >= 6 || var26 != 16) {
                        if (var26 == 4) {
                            GameScr.gI().aL = new nr_k(var3, var15, var21, var24, var26, var34);
                            Service.gI().e((byte) 2);
                            GameScr.G.addElement(GameScr.gI().aL);
                            ResLog.c("5");
                        } else {
                            Npc var9 = new Npc(var3, var15, var21, var24 + 3, var26, var34);
                            GameScr.G.addElement(var9);
                            ResLog.c("6");
                        }
                    }
                }
            }

            var2 = var1.reader().readByte();
            ResLog.c("item size = " + var2);

            short var16;
            short var18;
            boolean var19;
            int var25;
            int var37;
            int var38;
            for (var37 = 0; var37 < var2; ++var37) {
                var18 = var1.reader().readShort();
                var16 = var1.reader().readShort();
                var24 = var1.reader().readShort();
                short var28 = var1.reader().readShort();
                var38 = var1.reader().readInt();
                var21 = 0;
                if (var38 == -2) {
                    var21 = var1.reader().readShort();
                }

                ItemMap var20 = new ItemMap(var38, var18, var16, var24, var28, var21);
                var19 = false;

                for (var25 = 0; var25 < GameScr.vItemMap.size(); ++var25) {
                    if (((ItemMap) GameScr.vItemMap.elementAt(var25)).d == var20.d) {
                        var19 = true;
                        break;
                    }
                }

                if (!var19) {
                    GameScr.vItemMap.addElement(var20);
                }
            }

            TileMap.v.removeAllElements();
            if (mGraphics.zoomLevel == 1) {
                nr_cx.a();
            }

            nr_cx.l.removeAllElements();
            int var33;
            short var39;
            if (main.GameCanvas.a && (!main.GameCanvas.a || !TileMap.a()) && TileMap.l != 45 && TileMap.l != 46 && TileMap.l != 47 && TileMap.l != 48) {
                var39 = var1.reader().readShort();

                for (var3 = 0; var3 < var39; ++var3) {
                    var1.reader().readShort();
                    var1.reader().readShort();
                    var1.reader().readShort();
                }

                var18 = var1.reader().readShort();

                for (var33 = 0; var33 < var18; ++var33) {
                    var1.reader().readUTF();
                    var1.reader().readUTF();
                }
            } else {
                var39 = var1.reader().readShort();

                for (var3 = 0; var3 < var39; ++var3) {
                    var16 = var1.reader().readShort();
                    var21 = var1.reader().readShort();
                    var24 = var1.reader().readShort();
                    if (TileMap.a(var16) != null) {
                        nr_cx var12 = TileMap.a(var16);
                        nr_cx var32;
                        (var32 = new nr_cx()).a = var16;
                        var32.c = var12.c;
                        var32.f = var12.f;
                        var32.g = var12.g;
                        var32.d = var21 * TileMap.i;
                        var32.e = var24 * TileMap.i;
                        var32.h = var12.h;
                        if (TileMap.b(var32.a)) {
                            var32.b = var3 % 2 == 0 ? 0 : 2;
                            if (TileMap.l == 45) {
                                var32.b = 0;
                            }
                        }

                        if (!nr_cx.k.containsKey(String.valueOf(var32.c))) {
                            Image var14;
                            if (mGraphics.zoomLevel == 1) {
                                if ((var14 = mSystem.loadImage("/mapBackGround/" + var32.c + ".png")) == null) {
                                    var14 = Image.createRGBImage(new int[]{-2013265920}, 1, 1, true);
                                    Session_ME2.doSendMessage().d();
                                    Service.gI().c(var32.c);
                                }

                                nr_cx.k.put(String.valueOf(var32.c), var14);
                            } else {
                                var19 = false;
                                byte[] var17;
                                if ((var17 = Rms.loadRMS(mGraphics.zoomLevel + "bgItem" + var32.c)) != null) {
                                    if (nr_cx.n != null) {
                                        ResLog.c("Small  last= " + var17.length % 127 + "new Version= " + nr_cx.n[var32.c]);
                                        if (var17.length % 127 != nr_cx.n[var32.c]) {
                                            var19 = true;
                                        }
                                    }

                                    if (!var19) {
                                        if ((var14 = Image.createImage(var17, 0, var17.length)) != null) {
                                            nr_cx.k.put(String.valueOf(var32.c), var14);
                                        } else {
                                            var19 = true;
                                        }
                                    }
                                } else {
                                    var19 = true;
                                }

                                if (var19) {
                                    if ((var14 = mSystem.loadImage("/mapBackGround/" + var32.c + ".png")) == null) {
                                        var14 = Image.createRGBImage(new int[]{-2013265920}, 1, 1, true);
                                        Service.gI().c(var32.c);
                                    }

                                    nr_cx.k.put(String.valueOf(var32.c), var14);
                                }
                            }

                            nr_cx.m.addElement(String.valueOf(var32.c));
                        }

                        if (!nr_cx.a(String.valueOf(var32.c))) {
                            nr_cx.l.addElement(String.valueOf(var32.c));
                        }

                        TileMap.v.addElement(var32);
                    }
                }

                for (var3 = 0; var3 < nr_cx.m.size(); ++var3) {
                    String var29;
                    if (!nr_cx.a(var29 = (String) nr_cx.m.elementAt(var3))) {
                        nr_cx.k.remove(var29);
                        if (nr_cx.k.containsKey(var29 + "blend" + 1)) {
                            nr_cx.k.remove(var29 + "blend" + 1);
                        }

                        if (nr_cx.k.containsKey(var29 + "blend" + 3)) {
                            nr_cx.k.remove(var29 + "blend" + 3);
                        }

                        nr_cx.m.removeElementAt(var3);
                        --var3;
                    }
                }

                BackgroudEffect.d = false;
                BackgroudEffect.e = 0;
                EffecMn.a.removeAllElements();
                BackgroudEffect.a.removeAllElements();
                Effect.l.removeAllElements();
                var18 = var1.reader().readShort();

                for (var33 = 0; var33 < var18; ++var33) {
                    String var30 = var1.reader().readUTF();
                    String var27 = var1.reader().readUTF();
                    String var22;
                    if ((var22 = var30).equals("eff")) {
                        if (Panel.H <= 0) {
                            String[] var23;
                            var25 = Integer.parseInt((var23 = ResLog.a(var27, ".", 0))[0]);
                            int var31 = Integer.parseInt(var23[1]);
                            int var35 = Integer.parseInt(var23[2]);
                            var38 = Integer.parseInt(var23[3]);
                            int var10;
                            if (var23.length <= 4) {
                                var37 = -1;
                                var10 = 1;
                            } else {
                                var37 = Integer.parseInt(var23[4]);
                                var10 = Integer.parseInt(var23[5]);
                            }

                            Effect var36 = new Effect(var25, var35, var38, var31, var37, var10);
                            if (var23.length > 6) {
                                var36.b = Integer.parseInt(var23[6]);
                                if (var23.length > 7) {
                                    var36.c = Integer.parseInt(var23[7]);
                                    var36.d = Integer.parseInt(var23[8]);
                                }
                            }

                            EffecMn.addEff(var36);
                        }
                    } else if (var22.equals("beff") && Panel.H <= 1) {
                        BackgroudEffect.a(Integer.parseInt(var27));
                    }
                }
            }

            TileMap.p = var1.reader().readByte();
            onMessage(var1.reader().readByte());
            Char.isLoadingMap = false;
        } catch (Exception var11) {
            var11.printStackTrace();
        }
    }

    private void e(Message var1) {
        label328:
        {
            try {
                int var22;
                byte[] var24;
                switch (var1.reader().readByte()) {
                    case 4:
                        main.GameCanvas.loginScr.savePass();
                        GameScr.bi = false;
                        GameScr.bj = false;
                        LoginScr.d = true;
                        LoginScr.e = true;
                        LoginScr.f = true;
                        LoginScr.g = true;
                        LoginScr.h = true;
                        GameScr.ao = var1.reader().readByte();
                        GameScr.ap = var1.reader().readByte();
                        GameScr.aq = var1.reader().readByte();
                        GameScr.ar = var1.reader().readByte();
                        var1.reader().readByte();
                        if (main.GameCanvas.loginScr.isLogin2) {
                            Rms.saveRMSString("acc", "");
                            Rms.saveRMSString("pass", "");
                        } else {
                            Rms.saveRMSString("userAo" + ServerListScreen.ipSelect, "");
                        }

                        ResLog.c("****** DATA VERSION: Server " + GameScr.ao + " Client " + GameScr.vcData);
                        ResLog.c("****** MAP VERSION: Server " + GameScr.ap + " Client " + GameScr.vcMap);
                        ResLog.c("****** SKILL VERSION: Server " + GameScr.aq + " Client " + GameScr.am);
                        ResLog.c("****** ITEM VERSION: Server " + GameScr.ar + " Client " + GameScr.an);
                        if (GameScr.ao != GameScr.vcData) {
                            ResLog.c("send update data");
                            GameScr.b = false;
                            Service.gI().l();
                        } else {
                            try {
                                LoginScr.e = false;
                            } catch (Exception var18) {
                                var18.printStackTrace();
                                GameScr.vcData = -1;
                                Service.gI().l();
                            }
                        }

                        if (GameScr.ap != GameScr.vcMap) {
                            GameScr.b = false;
                            Service.gI().m();
                        } else {
                            try {
                                if (!GameScr.b) {
                                    createMap(new DataInputStream(new ByteArrayInputStream(Rms.loadRMS("NRmap"))));
                                }

                                LoginScr.f = false;
                            } catch (Exception var17) {
                                GameScr.vcMap = -1;
                                Service.gI().m();
                            }
                        }

                        if (GameScr.aq != GameScr.am) {
                            GameScr.b = false;
                            Service.gI().n();
                        } else {
                            try {
                                if (!GameScr.b) {
                                    onMessage(new DataInputStream(new ByteArrayInputStream(Rms.loadRMS("NRskill"))));
                                }

                                LoginScr.g = false;
                            } catch (Exception var16) {
                                GameScr.am = -1;
                                Service.gI().n();
                            }
                        }

                        if (GameScr.ar != GameScr.an) {
                            GameScr.b = false;
                            Service.gI().o();
                        } else {
                            try {
                                DataInputStream var26 = new DataInputStream(new ByteArrayInputStream(Rms.loadRMS("NRitem0")));
                                this.b(var26, false);
                                var26 = new DataInputStream(new ByteArrayInputStream(Rms.loadRMS("NRitem1")));
                                this.b(var26, false);
                                var26 = new DataInputStream(new ByteArrayInputStream(Rms.loadRMS("NRitem2")));
                                this.b(var26, false);
                                var26 = new DataInputStream(new ByteArrayInputStream(Rms.loadRMS("NRitem100")));
                                this.b(var26, false);
                                LoginScr.h = false;
                            } catch (Exception var15) {
                                GameScr.an = -1;
                                Service.gI().o();
                            }
                        }

                        if (GameScr.ao == GameScr.vcData && GameScr.ap == GameScr.vcMap && GameScr.aq == GameScr.am && GameScr.ar == GameScr.an) {
                            if (!GameScr.b) {
                                GameScr.gI();
                                GameScr.k();
                                GameScr.gI();
                                GameScr.i();
                                GameScr.gI();
                                GameScr.j();
                                GameScr.gI();
                                GameScr.l();
                            }

                            Service.gI().p();
                        }

                        byte var27 = var1.reader().readByte();
                        ResLog.c("CAPTION LENT= " + var27);
                        GameScr.Q = new long[var27];

                        for (var22 = 0; var22 < GameScr.Q.length; ++var22) {
                            GameScr.Q[var22] = var1.reader().readLong();
                        }
                        break label328;
                    case 5:
                    case 9:
                    case 11:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                    case 19:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    default:
                        return;
                    case 6:
                        ResLog.c("GET UPDATE_MAP " + var1.reader().available() + " bytes");
                        var1.reader().mark(100000);
                        createMap(var1.reader());
                        var1.reader().reset();
                        var24 = new byte[var1.reader().available()];
                        var1.reader().readFully(var24);
                        Rms.saveRMS("NRmap", var24);
                        var24 = new byte[]{GameScr.vcMap};
                        Rms.saveRMS("NRmapVersion", var24);
                        LoginScr.f = false;
                        if (GameScr.ao == GameScr.vcData && GameScr.ap == GameScr.vcMap && GameScr.aq == GameScr.am && GameScr.ar == GameScr.an) {
                            GameScr.gI();
                            GameScr.k();
                            GameScr.gI();
                            GameScr.i();
                            GameScr.gI();
                            GameScr.j();
                            GameScr.gI();
                            GameScr.l();
                            Service.gI().p();
                            return;
                        }

                        return;
                    case 7:
                        ResLog.c("GET UPDATE_SKILL " + var1.reader().available() + " bytes");
                        var1.reader().mark(100000);
                        onMessage(var1.reader());
                        var1.reader().reset();
                        var24 = new byte[var1.reader().available()];
                        var1.reader().readFully(var24);
                        Rms.saveRMS("NRskill", var24);
                        var24 = new byte[]{GameScr.am};
                        Rms.saveRMS("NRskillVersion", var24);
                        LoginScr.g = false;
                        if (GameScr.ao == GameScr.vcData && GameScr.ap == GameScr.vcMap && GameScr.aq == GameScr.am && GameScr.ar == GameScr.an) {
                            GameScr.gI();
                            GameScr.k();
                            GameScr.gI();
                            GameScr.i();
                            GameScr.gI();
                            GameScr.j();
                            GameScr.gI();
                            GameScr.l();
                            Service.gI().p();
                            return;
                        }

                        return;
                    case 8:
                        ResLog.c("GET UPDATE_ITEM " + var1.reader().available() + " bytes");
                        DataInputStream var25 = var1.reader();
                        Controller var23 = this;

                        try {
                            var23.b(var25, true);
                        } catch (Exception var14) {
                            var14.printStackTrace();
                        }

                        return;
                    case 10:
                        try {
                            Char.isLoadingMap = true;
                            ResLog.c("REQUEST MAP TEMPLATE");
                            main.GameCanvas.isLoading = true;
                            TileMap.f = null;
                            TileMap.g = null;
                            System.gc();
                            TileMap.a = var1.reader().readByte();
                            TileMap.b = var1.reader().readByte();
                            TileMap.f = new int[TileMap.a * TileMap.b];
                            ResLog.c("Cmd.REQUEST_MAPTEMPLATE=10  w|H= " + TileMap.a + "|" + TileMap.b + "\n Dien Tich = " + TileMap.a * TileMap.b);

                            for (var22 = 0; var22 < TileMap.f.length; ++var22) {
                                int var3;
                                if ((var3 = var1.reader().readByte()) < 0) {
                                    var3 += 256;
                                }

                                TileMap.f[var22] = (char) var3;
                            }

                            TileMap.g = new int[TileMap.f.length];
                            var1 = this.message;
                            this.d(var1);

                            try {
                                TileMap.j = var1.reader().readByte() != 0;
                            } catch (Exception var13) {
                            }
                        } catch (Exception var19) {
                            var19.printStackTrace();
                        }

                        var1.cleanup();
                        this.message.cleanup();
                        var1 = this.message = null;
                        GameScr.gI().switchToMe();
                        return;
                    case 16:
                        MoneyCharge.gI().switchToMe();
                        return;
                    case 17:
                        Char.myCharz();
                        Char.N();
                        return;
                    case 18:
                        main.GameCanvas.isLoading = false;
                        main.GameCanvas.endDlg();
                        Integer var2 = new Integer(var1.reader().readInt());
                        //null.a(nr_av.au, new nr_dc(nr_av.br, main.nr_a.h, 88829, var2), 0);
                        return;
                    case 20:
                        Char.myCharz().cPk = var1.reader().readByte();
                        GameScr.info1.a(mResources.bF + " " + Char.myCharz().cPk, 0);
                        return;
                    case 35:
                        main.GameCanvas.endDlg();
                        GameScr.gI().q();
                        GameScr.info1.a(var1.reader().readUTF(), 0);
                        return;
                    case 36:
                        GameScr.aB = var1.reader().readByte();
                        ResLog.c("load Me Active: " + GameScr.aB);
                        return;
                }
            } catch (Exception var20) {
            } finally {
                if (var1 != null) {
                    var1.cleanup();
                }

            }

            return;
        }

    }

    private static void f(Message var0) {
        try {
            switch (var0.reader().readByte()) {
                case 2:
                    String var1 = var0.reader().readUTF();
                    if (Rms.loadRMSInt("AdminLink") == 1) {
                        return;
                    }

                    int var10000 = mSystem.d;
                    boolean var10001 = true;
                    ServerListScreen.h = var1;
                    ServerListScreen.a(var1);

                    try {
                        Panel.ac = var0.reader().readByte() == 1;
                        byte var8 = var0.reader().readByte();
                        Rms.saveRMSInt("AdminLink", var8);
                    } catch (Exception var5) {
                    }
            }
        } catch (Exception var6) {
            var6.printStackTrace();
            return;
        } finally {
            if (var0 != null) {
                var0.cleanup();
            }

        }

    }

    private void g(Message var1) {
        try {
            byte var2 = var1.reader().readByte();
            ResLog.c("sub: " + var2);
            int var4;
            int var33;
            byte var37;
            int var41;
            byte var42;
            Char var44;
            int var45;
            int var49;
            short var52;
            switch (var2) {
                case 0:
                    RadarScr.list = new MyVector("");
                    Teleport.vTeleport.removeAllElements();
                    GameScr.vCharInMap.removeAllElements();
                    GameScr.vItemMap.removeAllElements();
                    Char.vItemTime.removeAllElements();
                    GameScr.loadImg();
                    GameScr.currentCharViewInfo = Char.myCharz();
                    Char.myCharz().charID = var1.reader().readInt();
                    Char.myCharz().ctaskId = var1.reader().readByte();
                    Char.myCharz().cgender = var1.reader().readByte();
                    Char.myCharz().head = var1.reader().readShort();
                    ResLog.c("Char head = " + Char.myCharz().head + "+++++++++++++++++++++++++++++++++");
                    Char.myCharz().cName = var1.reader().readUTF();
                    Char.myCharz().cPk = var1.reader().readByte();
                    Char.myCharz().cTypePk = var1.reader().readByte();
                    Char.myCharz().cPower = var1.reader().readLong();
                    Char.myCharz().applyCharLevelPercent();
                    Char.myCharz().eff5BuffHp = var1.reader().readShort();
                    Char.myCharz().eff5BuffMp = var1.reader().readShort();
                    Char.myCharz().nClass = GameScr.nClass[var1.reader().readByte()];
                    Char.myCharz().vSkill.removeAllElements();
                    Char.myCharz().vSkillFight.removeAllElements();
                    GameScr.gI().dHP = Char.myCharz().cHP;
                    GameScr.gI().dMP = Char.myCharz().cMP;
                    var42 = var1.reader().readByte();

                    for (var37 = 0; var37 < var42; ++var37) {
                        onMessage(nr_o.a(var1.reader().readShort()));
                    }

                    GameScr.gI();
                    GameScr.sortSkill();
                    GameScr.gI();
                    Char.myCharz().gold = var1.reader().readLong();
                    Char.myCharz().ruby = var1.reader().readInt();
                    Char.myCharz().gem = var1.reader().readInt();
                    Char.myCharz().xuStr = mSystem.numberTostring(Char.myCharz().gold);
                    Char.myCharz().luongStr = mSystem.numberTostring(Char.myCharz().gem);
                    Char.myCharz().luongKhoaStr = mSystem.numberTostring(Char.myCharz().ruby);
                    Char.myCharz().arrItemBody = new Item[var1.reader().readByte()];

                    try {
                        Char.myCharz().setDefaultPart();

                        for (var4 = 0; var4 < Char.myCharz().arrItemBody.length; ++var4) {
                            if ((var52 = var1.reader().readShort()) != -1) {
                                ItemTemplate var46;
                                byte var50 = (var46 = ItemTemplates.get(var52)).type;
                                Char.myCharz().arrItemBody[var4] = new Item();
                                Char.myCharz().arrItemBody[var4].template = var46;
                                Char.myCharz().arrItemBody[var4].quantity = var1.reader().readInt();
                                Char.myCharz();
                                var1.reader().readUTF();
                                Char.myCharz();
                                var1.reader().readUTF();
                                var41 = var1.reader().readUnsignedByte();
                                ResLog.c("option size= " + var41);
                                if (var41 != 0) {
                                    Char.myCharz().arrItemBody[var4].itemOption = new ItemOption[var41];

                                    for (var33 = 0; var33 < Char.myCharz().arrItemBody[var4].itemOption.length; ++var33) {
                                        int var47 = var1.reader().readUnsignedByte();
                                        var41 = var1.reader().readUnsignedShort();
                                        if (var47 != -1) {
                                            Char.myCharz().arrItemBody[var4].itemOption[var33] = new ItemOption(var47, var41);
                                        }
                                    }
                                }

                                if (var50 == 0) {
                                    ResLog.c("toi day =======================================" + Char.myCharz().body);
                                    Char.myCharz().body = Char.myCharz().arrItemBody[var4].template.part;
                                } else if (var50 == 1) {
                                    Char.myCharz().leg = Char.myCharz().arrItemBody[var4].template.part;
                                    ResLog.c("toi day =======================================" + Char.myCharz().leg);
                                }
                            }
                        }
                    } catch (Exception var29) {
                        var29.printStackTrace();
                    }

                    Char.myCharz().arrItemBag = new Item[var1.reader().readByte()];
                    GameScr.hpPotion = 0;

                    for (var4 = 0; var4 < Char.myCharz().arrItemBag.length; ++var4) {
                        if ((var52 = var1.reader().readShort()) != -1) {
                            Char.myCharz().arrItemBag[var4] = new Item();
                            Char.myCharz().arrItemBag[var4].template = ItemTemplates.get(var52);
                            Char.myCharz().arrItemBag[var4].quantity = var1.reader().readInt();
                            Char.myCharz();
                            var1.reader().readUTF();
                            Char.myCharz();
                            var1.reader().readUTF();
                            Char.myCharz().arrItemBag[var4].g = var4;
                            byte var48;
                            if ((var48 = var1.reader().readByte()) != 0) {
                                Char.myCharz().arrItemBag[var4].itemOption = new ItemOption[var48];

                                for (var49 = 0; var49 < Char.myCharz().arrItemBag[var4].itemOption.length; ++var49) {
                                    var41 = var1.reader().readUnsignedByte();
                                    var33 = var1.reader().readUnsignedShort();
                                    if (var41 != -1) {
                                        Char.myCharz().arrItemBag[var4].itemOption[var49] = new ItemOption(var41, var33);
                                        Char.myCharz().arrItemBag[var4].a();
                                    }
                                }
                            }

                            if (Char.myCharz().arrItemBag[var4].template.type == 6) {
                                GameScr.hpPotion += Char.myCharz().arrItemBag[var4].quantity;
                            }
                        }
                    }

                    Char.myCharz().arrItemBox = new Item[var1.reader().readByte()];
                    main.GameCanvas.panel.hasUse = 0;

                    for (var4 = 0; var4 < Char.myCharz().arrItemBox.length; ++var4) {
                        if ((var52 = var1.reader().readShort()) != -1) {
                            Char.myCharz().arrItemBox[var4] = new Item();
                            Char.myCharz().arrItemBox[var4].template = ItemTemplates.get(var52);
                            Char.myCharz().arrItemBox[var4].quantity = var1.reader().readInt();
                            Char.myCharz();
                            var1.reader().readUTF();
                            Char.myCharz();
                            var1.reader().readUTF();
                            Char.myCharz().arrItemBox[var4].itemOption = new ItemOption[var1.reader().readByte()];

                            for (var45 = 0; var45 < Char.myCharz().arrItemBox[var4].itemOption.length; ++var45) {
                                var49 = var1.reader().readUnsignedByte();
                                var41 = var1.reader().readUnsignedShort();
                                if (var49 != -1) {
                                    Char.myCharz().arrItemBox[var4].itemOption[var45] = new ItemOption(var49, var41);
                                    Char.myCharz().arrItemBox[var4].a();
                                }
                            }

                            ++main.GameCanvas.panel.hasUse;
                        }
                    }

                    Char.myCharz().statusMe = 4;
                    Rms.loadRMSInt(Char.myCharz().cName + "vci");
                    Char.idHead = new short[var52 = var1.reader().readShort()];
                    Char.idAvatar = new short[var52];

                    for (var45 = 0; var45 < var52; ++var45) {
                        Char.idHead[var45] = var1.reader().readShort();
                        Char.idAvatar[var45] = var1.reader().readShort();
                    }

                    GameScr.info1.charId[Char.myCharz().cgender][0] = var1.reader().readShort();
                    GameScr.info1.charId[Char.myCharz().cgender][1] = var1.reader().readShort();
                    GameScr.info1.charId[Char.myCharz().cgender][2] = var1.reader().readShort();
                    Char.myCharz().isNhapThe = var1.reader().readByte() == 1;
                    GameScr.deltaTime = mSystem.currentTimeMillis() - (long) var1.reader().readInt() * 1000L;
                    GameScr.isNewMember = var1.reader().readByte();
                    ResLog.c("delta time= " + GameScr.deltaTime);
                    Service var53 = Service.gI();
                    var42 = (byte) Char.myCharz().cgender;
                    Service var43 = var53;
                    Message var51 = null;

                    try {
                        (var51 = new Message((byte) -41)).writer().writeByte(var42);
                        var43.sessionMe2.sendMessage(var51);
                    } catch (Exception var27) {
                        var27.printStackTrace();
                    } finally {
                        var51.cleanup();
                    }

                    var43 = Service.gI();

                    try {
                        Char.myCharz().idAuraEff = var1.reader().readShort();
                        Char.myCharz().idEff_Set_Item = var1.reader().readByte();
                        Char.myCharz().idHat = var1.reader().readShort();
                    } catch (Exception var26) {
                    }

                    return;
                case 1:
                    Char.myCharz().nClass = GameScr.nClass[var1.reader().readByte()];
                    Char.myCharz().cTiemNang = var1.reader().readLong();
                    Char.myCharz().vSkill.removeAllElements();
                    Char.myCharz().vSkillFight.removeAllElements();
                    Char.myCharz().myskill = null;
                    return;
                case 2:
                    if (Char.myCharz().statusMe != 14 && Char.myCharz().statusMe != 5) {
                        Char.myCharz().cHP = Char.myCharz().cHPFull;
                        Char.myCharz().cMP = Char.myCharz().cMPFull;
                    }

                    Char.myCharz().vSkill.removeAllElements();
                    Char.myCharz().vSkillFight.removeAllElements();
                    var42 = var1.reader().readByte();

                    for (var37 = 0; var37 < var42; ++var37) {
                        var52 = var1.reader().readShort();
                        ResLog.c("skidd id my  char= " + var52);
                        onMessage(nr_o.a(var52));
                    }

                    GameScr.gI();
                    GameScr.sortSkill();
                    return;
                case 4:
                    Char.myCharz().gold = var1.reader().readLong();
                    Char.myCharz().gem = var1.reader().readInt();
                    Char.myCharz().cHP = var1.readInt();
                    Char.myCharz().cMP = var1.readInt();
                    Char.myCharz().ruby = var1.reader().readInt();
                    Char.myCharz().xuStr = mSystem.numberTostring(Char.myCharz().gold);
                    Char.myCharz().luongStr = mSystem.numberTostring((long) Char.myCharz().gem);
                    Char.myCharz().luongKhoaStr = mSystem.numberTostring((long) Char.myCharz().ruby);
                    return;
                case 5:
                    var45 = Char.myCharz().cHP;
                    Char.myCharz().cHP = var1.readInt();
                    ResLog.c("hpgoc  =" + Char.myCharz().cr + " hp full= " + Char.myCharz().cHPFull);
                    if (Char.myCharz().cHP > var45 && Char.myCharz().cTypePk != 4) {
                        GameScr.a("+" + (Char.myCharz().cHP - var45) + " " + mResources.eU, Char.myCharz().cx, Char.myCharz().cy - Char.myCharz().al - 20, 0, -1, 9);
                        SoundMn.stopAll();
                        if (Char.myCharz().v != null && Char.myCharz().v.a == 5003) {
                            MonsterDart.addMonsterDart(Char.myCharz().v.i + (Char.myCharz().v.b == 1 ? 10 : -10), Char.myCharz().v.e + 10, true, -1, -1, Char.myCharz(), 29);
                        }
                    }

                    if (Char.myCharz().cHP < var45) {
                        GameScr.a("-" + (var45 - Char.myCharz().cHP) + " " + mResources.eU, Char.myCharz().cx, Char.myCharz().cy - Char.myCharz().al - 20, 0, -1, 9);
                    }

                    ResLog.c("curr HP= " + Char.myCharz().cHP);
                    GameScr.gI().dHP = Char.myCharz().cHP;
                    return;
                case 6:
                    var49 = Char.myCharz().cMP;
                    Char.myCharz().cMP = var1.readInt();
                    if (Char.myCharz().cMP > var49) {
                        GameScr.a("+" + (Char.myCharz().cMP - var49) + " " + mResources.eV, Char.myCharz().cx, Char.myCharz().cy - Char.myCharz().al - 23, 0, -2, 10);
                        SoundMn.stopAll();
                        if (Char.myCharz().v != null && Char.myCharz().v.a == 5001) {
                            MonsterDart.addMonsterDart(Char.myCharz().v.i + (Char.myCharz().v.b == 1 ? 10 : -10), Char.myCharz().v.e + 10, true, -1, -1, Char.myCharz(), 29);
                        }
                    }

                    if (Char.myCharz().cMP < var49) {
                        GameScr.a("-" + (var49 - Char.myCharz().cMP) + " " + mResources.eV, Char.myCharz().cx, Char.myCharz().cy - Char.myCharz().al - 23, 0, -2, 10);
                    }

                    ResLog.c("curr MP= " + Char.myCharz().cMP);
                    GameScr.gI().dMP = Char.myCharz().cMP;
                    return;
                case 7:
                    if ((var44 = GameScr.findCharInMap(var1.reader().readInt())) != null) {
                        var44.ah = var1.reader().readInt();
                        if (var44.ah == -2) {
                            var44.cD = true;
                        }

                        onMessage(var44, var1);

                        try {
                            var44.idAuraEff = var1.reader().readShort();
                            var44.idEff_Set_Item = var1.reader().readByte();
                            var44.idHat = var1.reader().readShort();
                            if (var44.bag >= 201) {
                                Effect var36;
                                (var36 = new Effect(var44.bag, var44, 2, -1, 10, (byte) 1)).b = 5;
                                var44.a(var36);
                            } else {
                                var44.b((int) 0, (int) 201);
                            }

                            return;
                        } catch (Exception var25) {
                            return;
                        }
                    }

                    return;
                case 8:
                    if ((var44 = GameScr.findCharInMap(var1.reader().readInt())) == null) {
                        return;
                    }

                    var44.O = var1.reader().readByte();
                    return;
                case 9:
                    if ((var44 = GameScr.findCharInMap(var1.reader().readInt())) == null) {
                        return;
                    }

                    var44.cHP = var1.readInt();
                    var44.cHPFull = var1.readInt();
                    return;
                case 10:
                    if ((var44 = GameScr.findCharInMap(var1.reader().readInt())) == null) {
                        return;
                    }

                    var44.cHP = var1.readInt();
                    var44.cHPFull = var1.readInt();
                    var44.eff5BuffHp = var1.reader().readShort();
                    var44.eff5BuffMp = var1.reader().readShort();
                    var44.bY = var1.reader().readShort();
                    if (var44.bY == -1) {
                        var44.setDefaultWeapon();
                    }

                    return;
                case 11:
                    if ((var44 = GameScr.findCharInMap(var1.reader().readInt())) == null) {
                        return;
                    }

                    var44.cHP = var1.readInt();
                    var44.cHPFull = var1.readInt();
                    var44.eff5BuffHp = var1.reader().readShort();
                    var44.eff5BuffMp = var1.reader().readShort();
                    var44.body = var1.reader().readShort();
                    if (var44.body == -1) {
                        var44.setDefaultBody();
                    }

                    return;
                case 12:
                    if ((var44 = GameScr.findCharInMap(var1.reader().readInt())) == null) {
                        return;
                    }

                    var44.cHP = var1.readInt();
                    var44.cHPFull = var1.readInt();
                    var44.eff5BuffHp = var1.reader().readShort();
                    var44.eff5BuffMp = var1.reader().readShort();
                    var44.leg = var1.reader().readShort();
                    if (var44.leg == -1) {
                        var44.setDefaultLeg();
                    }

                    return;
                case 13:
                    if ((var33 = var1.reader().readInt()) == Char.myCharz().charID) {
                        var44 = Char.myCharz();
                    } else {
                        var44 = GameScr.findCharInMap(var33);
                    }

                    if (var44 == null) {
                        return;
                    }

                    var44.cHP = var1.readInt();
                    var44.cHPFull = var1.readInt();
                    var44.eff5BuffHp = var1.reader().readShort();
                    var44.eff5BuffMp = var1.reader().readShort();
                    return;
                case 14:
                    if ((var44 = GameScr.findCharInMap(var1.reader().readInt())) == null) {
                        return;
                    }

                    var44.cHP = var1.readInt();
                    if ((var42 = var1.reader().readByte()) == 1) {
                        ServerEffect.a(11, (Char) var44, 5);
                        ServerEffect.a(104, (Char) var44, 4);
                    }

                    if (var42 == 2) {
                        var44.K();
                    }

                    try {
                        var44.cHPFull = var1.readInt();
                    } catch (Exception var24) {
                    }

                    return;
                case 15:
                    if ((var44 = GameScr.findCharInMap(var1.reader().readInt())) == null) {
                        return;
                    }

                    var44.cHP = var1.readInt();
                    var44.cHPFull = var1.readInt();
                    var44.cx = var1.reader().readShort();
                    var44.cy = var1.reader().readShort();
                    var44.statusMe = 1;
                    var44.G = 0;
                    ServerEffect.a(109, (Char) var44, 2);
                    return;
                case 19:
                    Char.myCharz().h();
                    return;
                case 23:
                    short var35;
                    Skill var39;
                    onMessage(var39 = nr_o.a(var35 = var1.reader().readShort()));
                    if (var35 != 0 && var35 != 14 && var35 != 28) {
                        GameScr.info1.a(mResources.bJ + " " + var39.template.b, 0);
                    }

                    return;
                case 35:
                    var41 = var1.reader().readInt();
                    ResLog.c("CID = " + var41);
                    if (TileMap.l == 130) {
                        GameScr.gI().w();
                    }

                    if (var41 == Char.myCharz().charID) {
                        Char.myCharz().cTypePk = var1.reader().readByte();
                        if (GameScr.gI().x() && Char.myCharz().cTypePk != 0) {
                            GameScr.gI().w();
                        }

                        ResLog.c("type pk= " + Char.myCharz().cTypePk);
                        Char.myCharz().aT = null;
                        GameScr.gI();
                        if (!GameScr.a(Char.myCharz().aQ)) {
                            Char.myCharz().aQ = null;
                        }

                        Char.myCharz().aV = null;
                    } else if ((var44 = GameScr.findCharInMap(var41)) != null) {
                        ResLog.c("type pk= " + var44.cTypePk);
                        var44.cTypePk = var1.reader().readByte();
                        if (var44.I()) {
                            Char.myCharz().aU = var44;
                        }
                    }

                    for (var33 = 0; var33 < GameScr.vCharInMap.size(); ++var33) {
                        Char var38;
                        if ((var38 = GameScr.findCharInMap(var33)) != null && var38.cTypePk != 0 && var38.cTypePk == Char.myCharz().cTypePk) {
                            if (!Char.myCharz().aQ.J) {
                                Char.myCharz().aQ = null;
                            }

                            Char.myCharz().aT = null;
                            Char.myCharz().aV = null;
                            break;
                        }
                    }

                    ResLog.c("update type pk= ");
                    return;
                case 61:
                    String var32 = var1.reader().readUTF();
                    byte[] var34 = new byte[var1.reader().readInt()];
                    var1.reader().read(var34);
                    if (var34.length == 0) {
                        var34 = null;
                    }

                    if (var32.equals("KSkill")) {
                        GameScr.gI().b(var34);
                        return;
                    } else {
                        if (var32.equals("OSkill")) {
                            GameScr.gI().a(var34);
                        } else if (var32.equals("CSkill")) {
                            GameScr.gI().c(var34);
                            return;
                        }

                        return;
                    }
                case 62:
                    ResLog.c("ME UPDATE SKILL");
                    readUpdateSkill(var1);
                    return;
                case 63:
                    if ((var2 = var1.reader().readByte()) > 0) {
                        main.GameCanvas.panel.Y.removeAllElements();
                        InfoDlg.a();
                        MyVector var3 = main.GameCanvas.panel.R;

                        for (var4 = 0; var4 < var2; ++var4) {
                            String var5 = var1.reader().readUTF();
                            String var6 = var1.reader().readUTF();
                            short var7 = var1.reader().readShort();
                            main.GameCanvas.panel.Y.addElement(String.valueOf(var7));
                            Char.myCharz().aU.M = var7;
                            CommandLine var40;
                            (var40 = new CommandLine(var5, 11115, Char.myCharz().aU)).o = var6;
                            var3.addElement(var40);
                        }

                        InfoDlg.hide();
                        main.GameCanvas.panel.g();
                    }

                    return;
                default:
                    return;
            }
        } catch (Exception var30) {
            var30.printStackTrace();
        } finally {
            if (var1 != null) {
                var1.cleanup();
            }

        }

    }

    private static void onMessage(Skill skill) {
        if (Char.myCharz().myskill == null) {
            Char.myCharz().myskill = skill;
        } else if (skill.template.equals(Char.myCharz().myskill.template)) {
            Char.myCharz().myskill = skill;
        }

        Char.myCharz().vSkill.addElement(skill);
        if ((skill.template.type == 1 || skill.template.type == 4 || skill.template.type == 2 || skill.template.type == 3) && (skill.template.maxPoint == 0 || skill.template.maxPoint > 0 && skill.point > 0)) {
            if (skill.template.id == Char.myCharz().skillTemplateId) {
                Service.gI().selectSkill(Char.myCharz().skillTemplateId);
            }

            Char.myCharz().vSkillFight.addElement(skill);
        }

    }

    private static boolean onMessage(Char var0, Message var1) {
        try {
            var0.S = var1.reader().readByte();
            var0.bc = var1.reader().readBoolean();
            var0.cTypePk = var1.reader().readByte();
            ResLog.c("ADD TYPE PK= " + var0.cTypePk + " to player " + var0.charID);
            var0.nClass = GameScr.nClass[var1.reader().readByte()];
            var0.cgender = var1.reader().readByte();
            var0.head = var1.reader().readShort();
            var0.cName = var1.reader().readUTF();
            var0.cHP = var1.readInt();
            var0.cR = var0.cHP;
            if (var0.cHP == 0) {
                var0.statusMe = 14;
            }

            var0.cHPFull = var1.readInt();
            if (var0.cy >= TileMap.d - 100) {
                var0.bq = true;
            }

            var0.body = var1.reader().readShort();
            var0.leg = var1.reader().readShort();
            var0.bag = var1.reader().readUnsignedByte();
            ResLog.c(" body= " + var0.body + " leg= " + var0.leg + " bag=" + var0.bag + "BAG ==" + var0.bag + "*********************************");
            var0.bd = true;
            var1.reader().readByte();
            if (var0.bY == -1) {
                var0.setDefaultWeapon();
            }

            if (var0.body == -1) {
                var0.setDefaultBody();
            }

            if (var0.leg == -1) {
                var0.setDefaultLeg();
            }

            ResLog.c("1");
            var0.cx = var1.reader().readShort();
            var0.cy = var1.reader().readShort();
            var0.cl = var0.cx;
            var0.cm = var0.cy;
            var0.eff5BuffHp = var1.reader().readShort();
            var0.eff5BuffMp = var1.reader().readShort();
            byte var2 = var1.reader().readByte();

            for (int var3 = 0; var3 < var2; ++var3) {
                nr_dz var4 = new nr_dz(var1.reader().readByte(), var1.reader().readInt(), var1.reader().readInt(), var1.reader().readShort());
                var0.aB.addElement(var4);
            }

            ResLog.c("Controller readCharInfo body: body|leg|bag " + var0.body + var0.leg + var0.bag);
            return true;
        } catch (Exception var5) {
            var5.printStackTrace();
            return false;
        }
    }

    private void h(Message var1) {
        try {
            String var2 = var1.reader().readUTF();
            byte var3 = var1.reader().readByte();
            byte[] var6;
            Image var4 = onMessage(var6 = Util.a(var1));
            ImgByName.a(var2, var4, var3);
            if (var6 != null) {
                ImgByName.a(var2, var3, var6);
                return;
            }
        } catch (Exception var5) {
            var5.printStackTrace();
        }

    }

    private void b(DataInputStream var1, boolean var2) {
        try {
            var1.mark(100000);
            GameScr.an = var1.readByte();
            byte var3;
            byte[] var8;
            if ((var3 = var1.readByte()) == 0) {
                GameScr.gI().iOptionTemplates = new ItemOptionTemplate[var1.readUnsignedByte()];

                for (int var7 = 0; var7 < GameScr.gI().iOptionTemplates.length; ++var7) {
                    GameScr.gI().iOptionTemplates[var7] = new ItemOptionTemplate();
                    GameScr.gI().iOptionTemplates[var7].name = var7;
                    GameScr.gI().iOptionTemplates[var7].type = var1.readUTF();
                    GameScr.gI();
                    var1.readByte();
                }

                if (var2) {
                    var1.reset();
                    var8 = new byte[var1.available()];
                    var1.readFully(var8);
                    Rms.saveRMS("NRitem0", var8);
                    return;
                }
            } else {
                short var9;
                if (var3 == 1) {
                    ItemTemplates.itemTemplate.clear();
                    var9 = var1.readShort();

                    for (int var4 = 0; var4 < var9; ++var4) {
                        ItemTemplates.add(new ItemTemplate((short) var4, var1.readByte(), var1.readByte(), var1.readUTF(), var1.readUTF(), var1.readByte(), var1.readInt(), var1.readShort(), var1.readShort(), var1.readBoolean()));
                    }

                    if (var2) {
                        var1.reset();
                        byte[] var10 = new byte[var1.available()];
                        var1.readFully(var10);
                        Rms.saveRMS("NRitem1", var10);
                        return;
                    }
                } else if (var3 == 2) {
                    var9 = var1.readShort();
                    short var11 = var1.readShort();

                    for (int var5 = var9; var5 < var11; ++var5) {
                        ItemTemplates.add(new ItemTemplate((short) var5, var1.readByte(), var1.readByte(), var1.readUTF(), var1.readUTF(), var1.readByte(), var1.readInt(), var1.readShort(), var1.readShort(), var1.readBoolean()));
                    }

                    if (var2) {
                        var1.reset();
                        byte[] var12 = new byte[var1.available()];
                        var1.readFully(var12);
                        Rms.saveRMS("NRitem2", var12);
                        var8 = new byte[]{GameScr.an};
                        Rms.saveRMS("NRitemVersion", var8);
                        LoginScr.h = false;
                        if (GameScr.ao == GameScr.vcData && GameScr.ap == GameScr.vcMap && GameScr.aq == GameScr.am && GameScr.ar == GameScr.an) {
                            GameScr.gI();
                            GameScr.k();
                            GameScr.gI();
                            GameScr.i();
                            GameScr.gI();
                            GameScr.j();
                            GameScr.gI();
                            GameScr.l();
                            Service.gI().p();
                            return;
                        }
                    }
                } else if (var3 == 100) {
                    Char.cS = c(var1);
                    if (var2) {
                        var1.reset();
                        var8 = new byte[var1.available()];
                        var1.readFully(var8);
                        Rms.saveRMS("NRitem100", var8);
                        return;
                    }
                }
            }
        } catch (Exception var6) {
            var6.printStackTrace();
        }

    }

    private static void b(Message var0, int var1) {
        try {
            byte var2;
            int[][] var3 = new int[var2 = var0.reader().readByte()][];

            for (int var4 = 0; var4 < var2; ++var4) {
                byte var5 = var0.reader().readByte();
                var3[var4] = new int[var5];

                for (int var6 = 0; var6 < var5; ++var6) {
                    var3[var4][var6] = var0.reader().readByte();
                }
            }

            frameNewBoss.put(String.valueOf(var1), var3);
        } catch (Exception var7) {
            var7.printStackTrace();
        }
    }

    private static int[][] c(DataInputStream var0) {
        int[][] var1 = new int[][]{{542, 543}};

        try {
            var1 = new int[var0.readShort()][];

            for (int var2 = 0; var2 < var1.length; ++var2) {
                byte var3 = var0.readByte();
                var1[var2] = new int[var3];

                for (int var4 = 0; var4 < var3; ++var4) {
                    var1[var2][var4] = var0.readShort();
                }
            }
        } catch (Exception var5) {
            var5.printStackTrace();
        }

        return var1;
    }

    private void i(Message var1) {
        try {
            byte var2;
            if ((var2 = var1.reader().readByte()) == 0) {
                var2 = var2;
                var1 = var1;

                try {
                    byte var3;
                    short var13;
                    if ((var3 = var1.reader().readByte()) == 0) {
                        var13 = var1.reader().readShort();
                        String var16 = var1.reader().readUTF();
                        String var5 = var1.reader().readUTF();
                        int var6 = var1.reader().readInt();
                        short var7 = var1.reader().readShort();
                        byte var11 = var1.reader().readByte();
                        (GameScr.bY = new nr_ce(var2, var13, var16, var5, var6, var7)).g = var11;
                        GameScr.bY.a(var2, 0, 0);
                        return;
                    }

                    nr_ce var10;
                    if (var3 == 1) {
                        int var12 = var1.reader().readInt();
                        int var4 = var1.reader().readInt();
                        if (GameScr.bY != null) {
                            (var10 = GameScr.bY).a = var2;
                            var10.c = var12;
                            var10.d = var4;
                            return;
                        }
                    } else {
                        if (var3 == 2) {
                            var3 = var1.reader().readByte();
                            byte var15 = 0;
                            if (var3 == 1) {
                                var15 = 1;
                            } else if (var3 == 2) {
                                var15 = 2;
                            }

                            GameScr.bY = null;
                            GameScr.a(var15, -1, 0, main.GameCanvas.B, main.GameCanvas.hh, 0, 0, (short) -1, (Point[]) null);
                            return;
                        }

                        if (var3 == 5) {
                            var13 = var1.reader().readShort();
                            if (GameScr.bY != null) {
                                (var10 = GameScr.bY).a = var2;
                                var10.m = var13;
                                var10.n = main.GameCanvas.b;
                                return;
                            }
                        } else if (var3 == 4) {
                            var3 = var1.reader().readByte();
                            byte var14 = var1.reader().readByte();
                            if (GameScr.bY != null) {
                                GameScr.bY.a(var2, var3, var14);
                                return;
                            }
                        }
                    }
                } catch (Exception var8) {
                }

                return;
            }
        } catch (Exception var9) {
        }

    }

    private static void j(Message var0) {
        try {
            byte var1;
            short var6;
            if ((var1 = var0.reader().readByte()) == 0) {
                var6 = var0.reader().readShort();
                Char.myCharz().idHat = var6;
                SoundMn.stopAll();
                SoundMn.g();
                return;
            }

            if (var1 == 2) {
                int var7 = var0.reader().readInt();
                byte var2 = var0.reader().readByte();
                short var4 = var0.reader().readShort();
                String var8 = var4 + "," + var2;
                ImgByName.getImagePath("banner_" + var4, ImgByName.a);
                main.GameCanvas.T.put(String.valueOf(var7), var8);
                return;
            }

            if (var1 == 3) {
                SmallImage.createImage(var6 = var0.reader().readShort());
                BackgroudEffect.c = var6;
                return;
            }

            if (var1 == 4) {
                String var5 = var0.reader().readUTF();
                main.GameCanvas.U.addElement(var5);
                return;
            }
        } catch (Exception var3) {
        }

    }

    private static void readUpdateSkill(Message msg) {
        try {
            short var1 = msg.reader().readShort();
            byte var2 = -1;

            try {
                var2 = msg.reader().readByte();
            } catch (Exception var4) {
            }

            Skill var3;
            int var10;
            if (var2 == 0) {
                short var8 = msg.reader().readShort();

                for (var10 = 0; var10 < Char.myCharz().vSkill.size(); ++var10) {
                    if ((var3 = (Skill) Char.myCharz().vSkill.elementAt(var10)).b == var1) {
                        var3.m = var8;
                        return;
                    }
                }

                return;
            }

            if (var2 == 1) {
                byte var7 = msg.reader().readByte();

                for (var10 = 0; var10 < Char.myCharz().vSkill.size(); ++var10) {
                    if ((var3 = (Skill) Char.myCharz().vSkill.elementAt(var10)).b == var1) {
                        for (int var9 = 0; var9 < 20; ++var9) {
                            ImgByName.getImagePath("Skills_" + var3.template.id + "_" + var7 + "_" + var9, ImgByName.a);
                        }

                        return;
                    }
                }

                return;
            }

            if (var2 == -1) {
                Skill var6 = nr_o.a(var1);

                for (var10 = 0; var10 < Char.myCharz().vSkill.size(); ++var10) {
                    if (((Skill) Char.myCharz().vSkill.elementAt(var10)).template.id == var6.template.id) {
                        Char.myCharz().vSkill.setElementAt(var6, var10);
                        break;
                    }
                }

                for (var10 = 0; var10 < Char.myCharz().vSkillFight.size(); ++var10) {
                    if (((Skill) Char.myCharz().vSkillFight.elementAt(var10)).template.id == var6.template.id) {
                        Char.myCharz().vSkillFight.setElementAt(var6, var10);
                        break;
                    }
                }

                for (var10 = 0; var10 < GameScr.aP.length; ++var10) {
                    if (GameScr.aP[var10] != null && GameScr.aP[var10].template.id == var6.template.id) {
                        GameScr.aP[var10] = var6;
                        break;
                    }
                }

                for (var10 = 0; var10 < GameScr.aO.length; ++var10) {
                    if (GameScr.aO[var10] != null && GameScr.aO[var10].template.id == var6.template.id) {
                        GameScr.aO[var10] = var6;
                        break;
                    }
                }

                if (Char.myCharz().myskill.template.id == var6.template.id) {
                    Char.myCharz().myskill = var6;
                }

                GameScr.info1.a(mResources.eC + var6.template.b + mResources.eD + var6.point, 0);
                return;
            }
        } catch (Exception var5) {
        }

    }
}
