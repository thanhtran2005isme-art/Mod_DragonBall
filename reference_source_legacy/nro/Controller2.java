package nro;

import java.io.IOException;
import main.GameMidlet;

public class Controller2 {

    int a;
    int b;
    int c;
    int d;
    int e;
    int f;
    int g;
    int h;
    int i;
    int j;
    float k;
    long l;
    long m;
    boolean n;
    int[] o;
    int[] p;

    public Controller2(int var1, int var2, int var3, int var4, int var5) {
        this.i = 0;
        this.j = 16711680;
        this.l = 0L;
        this.m = 150L;
        this.n = true;
        this.o = new int[2];
        this.p = new int[2];
        this.g = var2;
        this.d = var1;
        this.k = 1.0F;
        this.c = var3;
        this.h = var4;
        this.a = main.GameCanvas.z;
        this.b = main.GameCanvas.A;
        this.l = System.currentTimeMillis();

        for (var3 = 0; var3 < 2; ++var3) {
            this.o[var3] = var1;
            this.p[var3] = var2;
        }

        this.j = var5;
    }

    public static void a(mGraphics message, int var1, int var2, int var3) {
        message.setColor(var3);
        message.fillRect(var1, var2, 1, 2);
    }

    public Controller2() {
    }

    public static void a(Message msg) {
        try {
            ResLog.c("readMessage trong Controller2:" + msg.command);
            int var1;
            short var2;
            short var3;
            byte var4;
            short var5;
            short var6;
            int var30;
            Npc var88;
            byte var89;
            byte var90;
            int var92;
            byte b1;
            String var99;
            short var100;
            Char var102;
            int var104;
            int var105;
            String var110;
            int var116;
            byte var124;
            switch (msg.command) {
                case -128:
                    Message var71 = msg;

                    try {
                        byte var72 = var71.reader().readByte();
                        int var73;
                        Char var74;
                        if ((var73 = var71.reader().readInt()) == Char.myCharz().charID) {
                            var74 = Char.myCharz();
                        } else {
                            var74 = GameScr.findCharInMap(var73);
                        }

                        short var75;
                        if (var72 == 0) {
                            var75 = var71.reader().readShort();
                            byte var76 = var71.reader().readByte();
                            byte var77 = var71.reader().readByte();
                            short var78 = var71.reader().readShort();
                            byte var79 = var71.reader().readByte();
                            if (var74 != null) {
                                var74.a(new Effect(var75, var74, var76, var77, var78, var79));
                            }
                            break;
                        }

                        if (var72 == 1) {
                            var75 = var71.reader().readShort();
                            if (var74 != null) {
                                var74.b((int) 0, (int) var75);
                            }
                            break;
                        }

                        if (var72 == 2) {
                            if (var74 != null) {
                                var74.b((int) -1, (int) 0);
                            }
                            break;
                        }
                    } catch (Exception var83) {
                        var83.printStackTrace();
                    }

                    return;
                case -127:
                    readLuckyRound(msg);
                    return;
                case -126:
                    var4 = msg.reader().readByte();
                    ResLog.c("type quay= " + var4);
                    if (var4 == 1) {
                        msg.reader().readByte();
                        var99 = msg.reader().readUTF();
                        var110 = msg.reader().readUTF();
                        GameScr.gI().b(var99, var110);
                    }

                    if (var4 == 0) {
                        GameScr.gI().b(msg.reader().readUTF());
                        return;
                    }
                    break;
                case -125:
                    ChatTextField.gI().b = false;
                    String var125 = msg.reader().readUTF();
                    ResLog.c("titile= " + var125);
                    var4 = msg.reader().readByte();
                    ClientInput.gI().a(var4, (String) var125);

                    for (var104 = 0; var104 < var4; ++var104) {
                        ClientInput.gI().tf[var104].name = msg.reader().readUTF();
                        if ((var89 = msg.reader().readByte()) == 0) {
                            ClientInput.gI().tf[var104].setIputType(1);
                        }

                        if (var89 == 1) {
                            ClientInput.gI().tf[var104].setIputType(0);
                        }

                        if (var89 == 2) {
                            ClientInput.gI().tf[var104].setIputType(2);
                        }
                    }

                    return;
                case -124:
                    var89 = msg.reader().readByte();
                    if ((var90 = msg.reader().readByte()) == 0) {
                        if (var89 == 2) {
                            if ((var92 = msg.reader().readInt()) == Char.myCharz().charID) {
                                Char.myCharz().S();
                            } else if (GameScr.findCharInMap(var92) != null) {
                                GameScr.findCharInMap(var92).S();
                            }
                        }

                        var92 = msg.reader().readUnsignedByte();
                        var105 = msg.reader().readInt();
                        ResLog.c("playerID= " + var105 + " skillID= " + var92);
                        if (var92 == 32) {
                            if (var89 == 1) {
                                var104 = msg.reader().readInt();
                                if (var105 == Char.myCharz().charID) {
                                    Char.myCharz().cG = var92;
                                    GameScr.findCharInMap(var104).b(Char.myCharz());
                                } else if (GameScr.findCharInMap(var105) != null && var104 != Char.myCharz().charID) {
                                    GameScr.findCharInMap(var105).cG = var92;
                                    GameScr.findCharInMap(var104).b(GameScr.findCharInMap(var105));
                                } else if (GameScr.findCharInMap(var105) != null && var104 == Char.myCharz().charID) {
                                    GameScr.findCharInMap(var105).cG = var92;
                                    Char.myCharz().b(GameScr.findCharInMap(var105));
                                }
                            } else if (var105 == Char.myCharz().charID) {
                                Char.myCharz().P();
                            } else if (GameScr.findCharInMap(var105) != null) {
                                GameScr.findCharInMap(var105).P();
                            }
                        }

                        if (var92 == 33) {
                            if (var89 == 1) {
                                if (var105 == Char.myCharz().charID) {
                                    Char.myCharz().cI = true;
                                } else if (GameScr.findCharInMap(var105) != null) {
                                    GameScr.findCharInMap(var105).cI = true;
                                }
                            } else if (var105 == Char.myCharz().charID) {
                                Char.myCharz().Q();
                            } else if (GameScr.findCharInMap(var105) != null) {
                                GameScr.findCharInMap(var105).Q();
                            }
                        }

                        if (var92 == 39) {
                            if (var89 == 1) {
                                if (var105 == Char.myCharz().charID) {
                                    Char.myCharz().cL = true;
                                } else if (GameScr.findCharInMap(var105) != null) {
                                    GameScr.findCharInMap(var105).cL = true;
                                }
                            } else if (var105 == Char.myCharz().charID) {
                                Char.myCharz().T();
                            } else if (GameScr.findCharInMap(var105) != null) {
                                GameScr.findCharInMap(var105).T();
                            }
                        }

                        if (var92 == 40) {
                            if (var89 == 1) {
                                if (var105 == Char.myCharz().charID) {
                                    Char.myCharz().cM = true;
                                } else if (GameScr.findCharInMap(var105) != null) {
                                    GameScr.findCharInMap(var105).cM = true;
                                }
                            } else if (var105 == Char.myCharz().charID) {
                                Char.myCharz().R();
                            } else if (GameScr.findCharInMap(var105) != null) {
                                GameScr.findCharInMap(var105).R();
                            }
                        }

                        if (var92 == 41) {
                            if (var89 == 1) {
                                if (var105 == Char.myCharz().charID) {
                                    Char.myCharz().cO = true;
                                } else if (GameScr.findCharInMap(var105) != null) {
                                    GameScr.findCharInMap(var105).cO = true;
                                }
                            } else if (var105 == Char.myCharz().charID) {
                                Char.myCharz().V();
                            } else if (GameScr.findCharInMap(var105) != null) {
                                GameScr.findCharInMap(var105).V();
                            }
                        }

                        if (var92 == 42) {
                            if (var89 == 1) {
                                if (var105 == Char.myCharz().charID) {
                                    Char.myCharz().cP = true;
                                }
                            } else if (var105 == Char.myCharz().charID) {
                                Char.myCharz().cP = false;
                                ResLog.c("tra ve huy chieu 2");
                            }
                        }
                    }

                    if (var90 == 1) {
                        var92 = msg.reader().readUnsignedByte();
                        var4 = msg.reader().readByte();
                        ResLog.c("modbHoldID= " + var4 + " skillID= " + var92 + "eff ID= " + var89);
                        if (var92 == 32) {
                            if (var89 == 1) {
                                if ((var104 = msg.reader().readInt()) == Char.myCharz().charID) {
                                    GameScr.a(var4).j = var92;
                                    Char.myCharz().a(GameScr.a(var4));
                                } else if (GameScr.findCharInMap(var104) != null) {
                                    GameScr.a(var4).j = var92;
                                    GameScr.findCharInMap(var104).a(GameScr.a(var4));
                                }
                            } else {
                                GameScr.a(var4).r();
                            }
                        }

                        if (var92 == 40) {
                            if (var89 == 1) {
                                GameScr.a(var4).ab = true;
                            } else {
                                GameScr.a(var4).s();
                            }
                        }

                        if (var92 == 41) {
                            if (var89 == 1) {
                                GameScr.a(var4).ac = true;
                                return;
                            }

                            GameScr.a(var4).t();
                            return;
                        }
                    }
                    break;
                case -123:
                    if (GameScr.findCharInMap(var1 = msg.reader().readInt()) != null) {
                        GameScr.findCharInMap(var1).cQ = msg.reader().readByte();
                        return;
                    }
                    break;
                case -122:
                    var88 = GameScr.a(msg.reader().readShort());
                    var90 = msg.reader().readByte();
                    var88.dg = new int[var90];

                    for (var92 = 0; var92 < var90; ++var92) {
                        var88.dg[var92] = msg.reader().readShort();
                    }

                    var88.a(msg.reader().readByte(), msg.reader().readInt());
                    return;
                case -121:
                    Service.e = mSystem.currentTimeMillis() - Service.c;
                    Service.gI().sendCheckMap();
                    return;
                case -120:
                    Service.d = mSystem.currentTimeMillis() - Service.b;
                    Service.gI().sendCheckController();
                    return;
                case -119:
                    Char.myCharz().w = msg.reader().readInt();
                    return;
                case -117:
                    GameScr.gI().bT = 0;
                    GameScr.gI().bR = msg.reader().readByte();
                    if (GameScr.gI().bR == 100) {
                        GameScr.gI().bS = true;
                    }

                    if (GameScr.gI().bR == 101) {
                        Npc.df = true;
                        return;
                    }
                    break;
                case -116:
                    GameScr.bj = msg.reader().readByte() == 1;
                    return;
                case -115:
                    Char.myCharz().setPowerInfo(msg.reader().readUTF(), msg.reader().readShort(), msg.reader().readShort(), msg.reader().readShort());
                    return;
                case -113:
                    byte[] var121 = new byte[10];

                    for (var92 = 0; var92 < 10; ++var92) {
                        var121[var92] = msg.reader().readByte();
                    }

                    GameScr.gI().b(var121);
                    GameScr.gI().a(var121);
                    GameScr.gI().c(var121);
                    return;
                case -111:
                    ResLog.c("LAY HINH");
                    var3 = msg.reader().readShort();
                    ImageSource.b = new MyVector("");

                    for (var105 = 0; var105 < var3; ++var105) {
                        var99 = msg.reader().readUTF();
                        var90 = msg.reader().readByte();
                        ImageSource.b.addElement(new ImageSource(var99, var90));
                    }

                    ImageSource.a();
                    ImageSource.b();
                    return;
                case -110:
                    if ((var124 = msg.reader().readByte()) == 1) {
                        var1 = msg.reader().readInt();
                        byte[] var122;
                        if ((var122 = Rms.loadRMS(String.valueOf(var1))) == null) {
                            Service.gI().a((byte) 1, (int) -1, (byte[]) null);
                        } else {
                            Service.gI().a((byte) 1, (int) var1, (byte[]) var122);
                        }
                    }

                    if (var124 == 0) {
                        var1 = msg.reader().readInt();
                        byte[] var123 = new byte[var2 = msg.reader().readShort()];
                        msg.reader().read(var123, 0, var2);
                        Rms.saveRMS(String.valueOf(var1), var123);
                        return;
                    }
                    break;
                case -106:
                    var2 = msg.reader().readShort();
                    var3 = msg.reader().readShort();
                    if (ItemTime.a(var2)) {
                        ItemTime.c(var2).a(var3, false);
                        return;
                    }

                    ItemTime var113 = new ItemTime(var2, var3);
                    Char.vItemTime.addElement(var113);
                    return;
                case -105:
                    TransportScr.gI().b = 0;
                    TransportScr.gI().c = msg.reader().readShort();
                    TransportScr.gI().d = TransportScr.gI().e = System.currentTimeMillis();
                    TransportScr.gI().a = msg.reader().readByte();
                    TransportScr.gI().switchToMe();
                    return;
                case -103:
                    var89 = msg.reader().readByte();
                    ResLog.c("server gui ve actionFlag = " + var89);
                    if (var89 == 0) {
                        main.GameCanvas.panel.X.removeAllElements();
                        var89 = msg.reader().readByte();

                        for (int var115 = 0; var115 < var89; ++var115) {
                            Item var119 = new Item();
                            if ((var100 = msg.reader().readShort()) != -1) {
                                var119.template = ItemTemplates.get(var100);
                                if ((var124 = msg.reader().readByte()) != -1) {
                                    var119.itemOption = new ItemOption[var124];

                                    for (var116 = 0; var116 < var119.itemOption.length; ++var116) {
                                        int var129 = msg.reader().readUnsignedByte();
                                        int var130 = msg.reader().readUnsignedShort();
                                        if (var129 != -1) {
                                            var119.itemOption[var116] = new ItemOption(var129, var130);
                                        }
                                    }
                                }
                            }

                            main.GameCanvas.panel.X.addElement(var119);
                        }

                        main.GameCanvas.panel.h();
                        main.GameCanvas.panel.show();
                        return;
                    }

                    if (var89 == 1) {
                        var1 = msg.reader().readInt();
                        var90 = msg.reader().readByte();
                        ResLog.c("---------------actionFlag1:  " + var1 + " : " + var90);
                        if (var1 == Char.myCharz().charID) {
                            Char.myCharz().by = var90;
                        } else if (GameScr.findCharInMap(var1) != null) {
                            GameScr.findCharInMap(var1).by = var90;
                        }

                        GameScr.gI();
                        GameScr.a(var1, var90);
                        return;
                    }

                    if (var89 == 2) {
                        var89 = msg.reader().readByte();
                        var2 = msg.reader().readShort();
                        nr_em var118;
                        (var118 = new nr_em()).a = var89;
                        var118.b = var2;
                        GameScr.H.addElement(var118);

                        for (var105 = 0; var105 < GameScr.H.size(); ++var105) {
                            nr_em var120 = (nr_em) GameScr.H.elementAt(var105);
                            ResLog.c("i: " + var105 + "  cflag: " + var120.a + "   IDimageFlag: " + var120.b);
                        }

                        for (var105 = 0; var105 < GameScr.vCharInMap.size(); ++var105) {
                            if ((var102 = (Char) GameScr.vCharInMap.elementAt(var105)) != null && var102.by == var89) {
                                var102.bz = var2;
                            }
                        }

                        if (Char.myCharz().by == var89) {
                            Char.myCharz().bz = var2;
                            return;
                        }
                    }
                    break;
                case -102:
                    if ((var89 = msg.reader().readByte()) != 0 && var89 == 1) {
                        main.GameCanvas.loginScr.isLogin2 = false;
                        Service.gI().login(Rms.loadRMSString("acc"), Rms.loadRMSString("pass"), "2.3.7", (byte) 0);
                        return;
                    }
                    break;
                case -101:
                    main.GameCanvas.loginScr.isLogin2 = true;
                    main.GameCanvas.connect();
                    var110 = msg.reader().readUTF();
                    Rms.saveRMSString("userAo" + ServerListScreen.ipSelect, var110);
                    Service.gI().setClientType();
                    Service.gI().login(var110, "", "2.3.7", (byte) 1);
                    return;
                case -100:
                    InfoDlg.hide();
                    boolean var111 = false;
                    if (main.GameCanvas.z > 2 * Panel.aa) {
                        var111 = true;
                    }

                    var4 = msg.reader().readByte();
                    ResLog.c("t Indxe= " + var4);
                    main.GameCanvas.panel.J[var4] = msg.reader().readByte();
                    main.GameCanvas.panel.K[var4] = msg.reader().readByte();
                    ResLog.c("max page= " + main.GameCanvas.panel.J[var4] + " curr page= " + main.GameCanvas.panel.K[var4]);
                    var104 = msg.reader().readUnsignedByte();
                    Char.myCharz().aJ[var4] = new Item[var104];
                    Panel.aq = mResources.er;

                    for (var116 = 0; var116 < var104; ++var116) {
                        short var64;
                        if ((var64 = msg.reader().readShort()) != -1) {
                            Char.myCharz().aJ[var4][var116] = new Item();
                            Char.myCharz().aJ[var4][var116].template = ItemTemplates.get(var64);
                            Char.myCharz().aJ[var4][var116].d = msg.reader().readShort();
                            Char.myCharz().aJ[var4][var116].n = msg.reader().readInt();
                            Char.myCharz().aJ[var4][var116].p = msg.reader().readInt();
                            Char.myCharz().aJ[var4][var116].v = msg.reader().readByte();
                            Char.myCharz().aJ[var4][var116].quantity = msg.reader().readInt();
                            Char.myCharz().aJ[var4][var116].B = msg.reader().readByte();
                            byte var65;
                            if ((var65 = msg.reader().readByte()) != -1) {
                                Char.myCharz().aJ[var4][var116].itemOption = new ItemOption[var65];

                                for (int var66 = 0; var66 < Char.myCharz().aJ[var4][var116].itemOption.length; ++var66) {
                                    int var67 = msg.reader().readUnsignedByte();
                                    int var68 = msg.reader().readUnsignedShort();
                                    if (var67 != -1) {
                                        Char.myCharz().aJ[var4][var116].itemOption[var66] = new ItemOption(var67, var68);
                                        Char.myCharz().aJ[var4][var116].A = main.GameCanvas.panel.a(Char.myCharz().aJ[var4][var116]);
                                    }
                                }
                            }

                            if (msg.reader().readByte() == 1) {
                                short var131 = msg.reader().readShort();
                                short var132 = msg.reader().readShort();
                                short var69 = msg.reader().readShort();
                                short var70 = msg.reader().readShort();
                                Char.myCharz().aJ[var4][var116].a(var131, var132, var69, var70);
                            }

                            if (GameMidlet.e >= 237) {
                                Char.myCharz().aJ[var4][var116].H = msg.reader().readUTF();
                                ResLog.b("nguoi ki gui  " + Char.myCharz().aJ[var4][var116].H);
                            }
                        }
                    }

                    if (var111) {
                        main.GameCanvas.G.e();
                    }

                    main.GameCanvas.panel.y();
                    main.GameCanvas.panel.g = main.GameCanvas.panel.f = 0;
                default:
                    return;
                case -89:
                    main.GameCanvas.al = msg.reader().readByte() == 1;
                    return;
                case 31:
                    var1 = msg.reader().readInt();
                    if (msg.reader().readByte() != 1) {
                        if (var1 == Char.myCharz().charID) {
                            Char.myCharz().v.remove();
                            Char.myCharz().v = null;
                            return;
                        }

                        Char var108;
                        (var108 = GameScr.findCharInMap(var1)).v.remove();
                        var108.v = null;
                        return;
                    }

                    var2 = msg.reader().readShort();
                    b1 = -1;
                    int[] var117 = null;
                    var5 = 0;
                    var6 = 0;

                    try {
                        if ((b1 = msg.reader().readByte()) > 0) {
                            byte var109;
                            var117 = new int[var109 = msg.reader().readByte()];

                            for (int var114 = 0; var114 < var109; ++var114) {
                                var117[var114] = msg.reader().readByte();
                            }

                            var5 = msg.reader().readShort();
                            var6 = msg.reader().readShort();
                        }
                    } catch (Exception var82) {
                    }

                    if (var1 == Char.myCharz().charID) {
                        Char.myCharz().v = new PetFollow();
                        Char.myCharz().v.a = var2;
                        if (b1 > 0) {
                            Char.myCharz().v.SetImg(b1, var117, var5, var6);
                            return;
                        }
                    } else {
                        Char var112;
                        (var112 = GameScr.findCharInMap(var1)).v = new PetFollow();
                        var112.v.a = var2;
                        if (b1 > 0) {
                            var112.v.SetImg(b1, var117, var5, var6);
                            return;
                        }
                    }
                    break;
                case 42:
                    main.GameCanvas.endDlg();
                    LoginScr.c = false;
                    Char.isLoadingMap = false;
                    var90 = msg.reader().readByte();
                    if (main.GameCanvas.J == null) {
                        main.GameCanvas.J = new RegisterScreen(var90);
                    }

                    main.GameCanvas.J.switchToMe();
                    return;
                case 48:
                    ServerListScreen.ipSelect = msg.reader().readByte();
                    main.GameCanvas.doResetToLoginScr((mScreen) main.GameCanvas.serverScreen);
                    Session_ME2.Session_ME().close();
                    main.GameCanvas.endDlg();
                    ServerListScreen.l = true;
                    return;
                case 51:
                    Mabu var106 = (Mabu) GameScr.findCharInMap(msg.reader().readInt());
                    byte var107 = msg.reader().readByte();
                    short var7 = msg.reader().readShort();
                    short var8 = msg.reader().readShort();
                    Char[] var103 = new Char[var89 = msg.reader().readByte()];
                    int[] var101 = new int[var89];

                    for (var105 = 0; var105 < var89; ++var105) {
                        int var9 = msg.reader().readInt();
                        ResLog.c("char ID=" + var9);
                        var103[var105] = null;
                        if (var9 != Char.myCharz().charID) {
                            var103[var105] = GameScr.findCharInMap(var9);
                        } else {
                            var103[var105] = Char.myCharz();
                        }

                        var101[var105] = msg.reader().readInt();
                    }

                    var106.a(var107, var7, var8, var103, var101);
                    return;
                case 52:
                    if ((b1 = msg.reader().readByte()) == 1) {
                        if ((var105 = msg.reader().readInt()) == Char.myCharz().charID) {
                            Char.myCharz().c(true);
                            Char.myCharz().cx = msg.reader().readShort();
                            Char.myCharz().cy = msg.reader().readShort();
                        } else if ((var102 = GameScr.findCharInMap(var105)) != null) {
                            var102.c(true);
                            var102.cx = msg.reader().readShort();
                            var102.cy = msg.reader().readShort();
                        }
                    }

                    if (b1 == 0) {
                        if ((var105 = msg.reader().readInt()) == Char.myCharz().charID) {
                            Char.myCharz().c(false);
                        } else if ((var102 = GameScr.findCharInMap(var105)) != null) {
                            var102.c(false);
                        }
                    }

                    if (b1 == 2) {
                        var105 = msg.reader().readInt();
                        var104 = msg.reader().readInt();
                        ((Mabu) GameScr.findCharInMap(var105)).c(var104);
                    }

                    if (b1 == 3) {
                        GameScr.bV = msg.reader().readByte();
                        return;
                    }
                    break;
                case 93:
                    var99 = ResLog.a(msg.reader().readUTF());
                    GameScr.gI().a(var99);
                    return;
                case 100:
                    b1 = msg.reader().readByte();
                    var89 = msg.reader().readByte();
                    Item var98 = null;
                    if (b1 == 0) {
                        var98 = Char.myCharz().arrItemBody[var89];
                    }

                    if (b1 == 1) {
                        var98 = Char.myCharz().arrItemBag[var89];
                    }

                    short var97;
                    if ((var97 = msg.reader().readShort()) != -1) {
                        var98.template = ItemTemplates.get(var97);
                        var98.quantity = msg.reader().readInt();
                        msg.reader().readUTF();
                        msg.reader().readUTF();
                        if ((var89 = msg.reader().readByte()) != 0) {
                            var98.itemOption = new ItemOption[var89];

                            for (var1 = 0; var1 < var98.itemOption.length; ++var1) {
                                var92 = msg.reader().readUnsignedByte();
                                var105 = msg.reader().readUnsignedShort();
                                if (var92 != -1) {
                                    var98.itemOption[var1] = new ItemOption(var92, var105);
                                }
                            }
                        }

                        if (var98.quantity <= 0) {
                            return;
                        }
                    }
                    break;
                case 101:
                    ResLog.c("big boss--------------------------------------------------");
                    BigBoss var94;
                    if ((var94 = Mob.w()) == null) {
                        return;
                    }

                    if ((var90 = msg.reader().readByte()) == 0 || var90 == 1 || var90 == 2 || var90 == 4 || var90 == 3) {
                        if (var90 == 3) {
                            var94.a = var94.xFirst = msg.reader().readShort();
                            var94.yFirst = msg.reader().readShort();
                            var94.D();
                        } else {
                            byte var126 = msg.reader().readByte();
                            ResLog.c("CHUONG nChar= " + var126);
                            Char[] var127 = new Char[var126];
                            int[] var128 = new int[var126];

                            for (var30 = 0; var30 < var126; ++var30) {
                                var92 = msg.reader().readInt();
                                ResLog.c("char ID=" + var92);
                                var127[var30] = null;
                                if (var92 != Char.myCharz().charID) {
                                    var127[var30] = GameScr.findCharInMap(var92);
                                } else {
                                    var127[var30] = Char.myCharz();
                                }

                                var128[var30] = msg.reader().readInt();
                            }

                            var94.a(var127, var128, var90);
                        }
                    }

                    if (var90 == 5) {
                        var94.b = true;
                        var94.p = 2;
                    }

                    if (var90 == 6) {
                        var94.C();
                        var94.x = msg.reader().readShort();
                        var94.y = msg.reader().readShort();
                    }

                    if (var90 == 7) {
                        var94.a((Char[]) null, (int[]) null, var90);
                    }

                    if (var90 == 8) {
                        var94.a = var94.xFirst = msg.reader().readShort();
                        var94.yFirst = msg.reader().readShort();
                        var94.p = 2;
                    }

                    if (var90 == 9) {
                        var94.x = var94.y = var94.a = var94.xFirst = var94.yFirst = -1000;
                        return;
                    }
                    break;
                case 102:
                    Char[] arr;
                    int[] ints;
                    int i1;
                    if ((b1 = msg.reader().readByte()) == 0 || b1 == 1 || b1 == 2 || b1 == 6) {
                        BigBoss2 bigBoss2;
                        if ((bigBoss2 = Mob.x()) == null) {
                            return;
                        }

                        if (b1 == 6) {
                            bigBoss2.x = bigBoss2.y = bigBoss2.a = bigBoss2.b = bigBoss2.xFirst = bigBoss2.yFirst = -1000;
                            return;
                        }

                        arr = new Char[var90 = msg.reader().readByte()];
                        ints = new int[var90];

                        for (i1 = 0; i1 < var90; ++i1) {
                            var30 = msg.reader().readInt();
                            arr[i1] = null;
                            if (var30 != Char.myCharz().charID) {
                                arr[i1] = GameScr.findCharInMap(var30);
                            } else {
                                arr[i1] = Char.myCharz();
                            }

                            ints[i1] = msg.reader().readInt();
                        }

                        bigBoss2.a(arr, ints, b1);
                    }

                    if (b1 == 3 || b1 == 4 || b1 == 5 || b1 == 7) {
                        BachTuoc bachTuoc;
                        if ((bachTuoc = Mob.y()) == null) {
                            return;
                        }

                        if (b1 == 7) {
                            bachTuoc.x = bachTuoc.y = bachTuoc.xTo = bachTuoc.yTo = bachTuoc.xFirst = bachTuoc.yFirst = -1000;
                            return;
                        }

                        if (b1 == 3 || b1 == 4) {
                            arr = new Char[var90 = msg.reader().readByte()];
                            ints = new int[var90];

                            for (i1 = 0; i1 < var90; ++i1) {
                                var30 = msg.reader().readInt();
                                arr[i1] = null;
                                if (var30 != Char.myCharz().charID) {
                                    arr[i1] = GameScr.findCharInMap(var30);
                                } else {
                                    arr[i1] = Char.myCharz();
                                }

                                ints[i1] = msg.reader().readInt();
                            }

                            bachTuoc.setAttack(arr, ints, b1);
                        }

                        if (b1 == 5) {
                            var2 = msg.reader().readShort();
                            bachTuoc.move(var2);
                        }
                    }

                    if (b1 > 9 && b1 < 30) {
                        readActionBoss(msg, b1);
                        return;
                    }
                    break;
                case 113:
                    var89 = 0;
                    var90 = 0;
                    var92 = 0;
                    var100 = 0;
                    var5 = 0;
                    var6 = -1;

                    try {
                        var89 = msg.reader().readByte();
                        var90 = msg.reader().readByte();
                        var92 = msg.reader().readUnsignedByte();
                        var100 = msg.reader().readShort();
                        var5 = msg.reader().readShort();
                        var6 = msg.reader().readShort();
                    } catch (Exception var80) {
                    }

                    EffecMn.addEff(new Effect(var92, var100, var5, var90, var89, var6));
                    return;
                case 114:
                    try {
                        msg.reader().readUTF();
                        mSystem.f = msg.reader().readByte();
                        mSystem.g = msg.reader().readByte();
                        return;
                    } catch (Exception var81) {
                        return;
                    }
                case 121:
                    mSystem.h = msg.reader().readUTF();
                    msg.reader().readUTF();
                    ResLog.c("SHOW AD public ID= " + mSystem.h);
                    return;
                case 122:
                    short var87 = msg.reader().readShort();
                    ResLog.c("second login = " + var87);
                    LoginScr.k = var87;
                    LoginScr.m = LoginScr.l = System.currentTimeMillis();
                    main.GameCanvas.endDlg();
                    return;
                case 123:
                    var1 = msg.reader().readInt();
                    var2 = msg.reader().readShort();
                    var3 = msg.reader().readShort();
                    byte var86 = msg.reader().readByte();
                    ResLog.c("SET POSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSss x= " + var2 + " y= " + var3 + "chaPos= " + var1 + "type Pos= " + var86);
                    Char var95 = null;
                    if (var1 == Char.myCharz().charID) {
                        var95 = Char.myCharz();
                    } else if (GameScr.findCharInMap(var1) != null) {
                        var95 = GameScr.findCharInMap(var1);
                    }

                    if (var95 != null) {
                        ServerEffect.a(var86 == 0 ? 60 : 173, (Char) var95, 1);
                        var95.a(var2, var3, var86);
                        return;
                    }
                    break;
                case 124:
                    var2 = msg.reader().readShort();
                    String var85 = msg.reader().readUTF();
                    if ((var88 = GameScr.a(var2)) != null) {
                        var88.a(var85);
                        return;
                    }
                    break;
                case 125:
                    var4 = msg.reader().readByte();
                    if ((var1 = msg.reader().readInt()) == Char.myCharz().charID) {
                        Char.myCharz().b(var4);
                        return;
                    }

                    if (GameScr.findCharInMap(var1) != null) {
                        GameScr.findCharInMap(var1).b(var4);
                        return;
                    }
                    break;
            }
        } catch (Exception var84) {
        }

    }

    private static void readLuckyRound(Message msg) {
        try {
            byte type;
            short[] shorts;
            int i;
            if ((type = msg.reader().readByte()) == 0) {
                shorts = new short[type = msg.reader().readByte()];
                for (i = 0; i < type; ++i) {
                    shorts[i] = msg.reader().readShort();
                }
                byte var7 = msg.reader().readByte();
                int var6 = msg.reader().readInt();
                short var5 = msg.reader().readShort();
                CrackBallScr.gI().SetCrackBallScr(shorts, var7, var6, var5);
                return;
            }

            if (type == 1) {
                shorts = new short[type = msg.reader().readByte()];
                for (i = 0; i < type; ++i) {
                    shorts[i] = msg.reader().readShort();
                }

                CrackBallScr.gI().a(shorts);
            }
        } catch (IOException var4) {
            var4.printStackTrace();
        }

    }

    private static void readActionBoss(Message message, int var1) {
        try {
            NewBoss newBoss;
            if ((newBoss = Mob.a(message.reader().readByte())) == null) {
                return;
            }

            if (var1 == 10) {
                short x = message.reader().readShort();
                short y = message.reader().readShort();
                newBoss.move(x, y);
            }

            if (var1 >= 11 && var1 <= 20) {
                byte var9;
                Char[] arr = new Char[var9 = message.reader().readByte()];
                int[] var5 = new int[var9];

                for (int i = 0; i < var9; ++i) {
                    int var7 = message.reader().readInt();
                    arr[i] = null;
                    if (var7 != Char.myCharz().charID) {
                        arr[i] = GameScr.findCharInMap(var7);
                    } else {
                        arr[i] = Char.myCharz();
                    }

                    var5[i] = message.reader().readInt();
                }

                byte var11 = message.reader().readByte();
                newBoss.setAttack(arr, var5, (byte) (var1 - 10), var11);
            }

            if (var1 == 21) {
                newBoss.xTo = message.reader().readShort();
                newBoss.yTo = message.reader().readShort();
                newBoss.setFly();
            }

            if (var1 == 23) {
                newBoss.setDie();
            }
        } catch (Exception var8) {
            var8.printStackTrace();
        }

    }
}
