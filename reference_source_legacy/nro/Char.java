package nro;

import java.util.Random;
import java.util.Vector;
import javax.microedition.lcdui.Image;

public class Char implements IMapObject {
   public String xuStr;
   public String luongStr;
   public String luongKhoaStr;
   public boolean r;
   public boolean s;
   public boolean t;
   private int a;
   private int b;
   private int c;
   public boolean isNhapThe;
   public PetFollow v;
   public int w = 0;
   public static ChatPopup x;
   public long cPower;
   public Info z;
   public byte petStatus;
   public int cx = 24;
   public int cy = 24;
   public int D;
   public int E;
   public int F;
   private int d;
   public int G;
   public int statusMe = 5;
   public int I = 1;
   public int charID;
   public int cgender;
   public int ctaskId;
   public int M;
   public int N;
   public int O = 4;
   public int cDamFull;
   public int cDefull;
   public int cCriticalFull;
   public int S;
   public int cMP;
   public int cHP;
   private int e;
   public int eff5BuffHp;
   public int eff5BuffMp;
   public int cHPFull;
   public int cMPFull;
   public long Z;
   public long cTiemNang;
   public long ab;
   public int ac;
   public boolean ad;
   public boolean ae;
   public boolean af;
   public String cName = "";
   public int ah;
   public Clan clan;
   public byte aj;
   public int ak = 22;
   public int al = 32;
   public int am = 11;
   private int f = 16;
   public CommandLine an;
   public boolean ao = true;
   public boolean ap;
   public boolean me;
   public boolean ar;
   private boolean g;
   public int as;
   private int h;
   public long gold;
   public int au;
   public int gem;
   public int ruby;
   public NClass nClass;
   public CommandLine ay;
   public MyVector vSkill = new MyVector("vSkill");
   public MyVector vSkillFight = new MyVector("vSkillFight");
   public MyVector aB = new MyVector("vEff char");
   public Skill myskill;
   public Util aD;
   private boolean i = true;
   public Archivement[] arrArchive;
   public Item[] arrItemBag;
   public Item[] arrItemBox;
   public Item[] arrItemBody;
   public Skill[] arrPetSkill;
   public Item[][] aJ;
   public String[][] aK;
   public short[][] aL;
   public byte cPk;
   public byte cTypePk;
   public int aO;
   public int skillTemplateId;
   public Mob aQ;
   public Mob aR;
   public int aS;
   public Npc aT;
   public Char aU;
   public ItemMap aV;
   public MyVector aW = new MyVector("focus");
   public Mob[] aX;
   public Char[] aY;
   public short[] aZ;
   public int ba = -9999;
   public int bb = -9999;
   private byte j;
   public boolean bc;
   public boolean bd = true;
   public MyVector be = new MyVector("taskOrders");
   public int cStamina;
   public static short[] idHead;
   public static short[] idAvatar;
   public String[] bi;
   public String currStrLevel;
   private static Image k = mSystem.load("/mainImage/myTexture2dat-trai-dat.png");
   private static Image l = mSystem.load("/mainImage/myTexture2dmat-namek.png");
   public boolean bk = false;
   public boolean bl;
   public int bm;
   public int bn;
   public long bo;
   private long m;
   public long bp;
   public boolean bq;
   public static Vector vItemTime = new Vector();
   public static short bs = 30000;
   public short bt = 0;
   public boolean bu;
   public boolean bv;
   public boolean bw;
   public boolean bx;
   private static Image n = mSystem.load("/mainImage/myTexture2dthucuoi10.png");
   private static Image dc = mSystem.load("/mainImage/myTexture2dthucuoi20.png");
   private static Image dd = mSystem.load("/mainImage/myTexture2dthucuoi21.png");
   private static Image de = mSystem.load("/mainImage/myTexture2dthucuoi30.png");
   private static Image df = mSystem.load("/mainImage/myTexture2dthucuoi11.png");
   private static Image dg = mSystem.load("/mainImage/myTexture2dthucuoi22.png");
   private static Image dh = mSystem.load("/mainImage/myTexture2dthucuoi23.png");
   private static Image di = mSystem.load("/mainImage/myTexture2dthucuoi31.png");
   private static Image dj = mSystem.load("/mainImage/myTexture2drong.png");
   private static Image dk = mSystem.load("/mainImage/myTexture2dcanhrong.png");
   private byte[] dl = new byte[]{0, 0, 1, 1, 2, 2, 1, 1};
   private int dm;
   private int dn;
   private int _do;
   private int dp;
   private int dq;
   private int dr;
   private int ds;
   private int dt;
   private int du;
   private int dv;
   private int dw;
   private boolean dx;
   private boolean dy;
   private boolean dz;
   public byte by;
   public int bz;
   public short bA;
   public short bB;
   public static final int[][][] bC;
   private static Char dA;
   private static Char myPet;
   private int dC;
   public int bD;
   public int bE;
   public MyVector bF = new MyVector("vMovePoints");
   public static boolean bG;
   public static boolean bH;
   public static boolean isLoadingMap;
   public boolean bJ;
   String bK;
   short bL;
   short bM;
   short bN;
   private long dD;
   private long dE;
   public boolean havePet = true;
   public nr_dj bP;
   public int bQ;
   private Effect dF = null;
   private Effect dG = null;
   private int dH;
   private boolean dI;
   private boolean dJ;
   public boolean bR;
   private boolean dK;
   private int dL;
   int bS;
   private int dM;
   private int dN;
   private int dO;
   private int[] dP = new int[]{1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 2, 2, 2};
   private String dQ = "mount_";
   public int headICON = -1;
   public int head;
   public int leg;
   public int body;
   public int bag;
   public int bY;
   private int indexEff = -1;
   public int indexEffTask = -1;
   private EffectCharPaint eff;
   public EffectCharPaint effTask;
   public int cb;
   private int dT;
   private int dU;
   private int dV;
   private int dW;
   private int dX;
   private int dY;
   private int dZ;
   private int ea;
   private int eb;
   private EffectCharPaint eff0 = null;
   private EffectCharPaint eff1 = null;
   private EffectCharPaint eff2 = null;
   public Arrow arr = null;
   public PlayerDart dart = null;
   public boolean isCreateDark = false;
   public SkillPaint skillPaint;
   public SkillPaint skillPaintRandomPaint;
   private EffectPaint[] ef;
   private int eg;
   private byte eh;
   public boolean ch = false;
   public boolean ci = false;
   public boolean cj = false;
   private int ei;
   private int ej = 0;
   private boolean ek;
   boolean ck;
   private long el = 0L;
   private int em;
   private boolean en;
   private boolean eo;
   private int ep = 24;
   private int eq = 24;
   private Image er;
   private boolean es;
   private boolean et;
   public int cl;
   public int cm;
   private int eu = 0;
   private Rms ev;
   private Rms ew;
   private Rms ex;
   private int ey = 32;
   private int ez;
   private int eA = 0;
   public static boolean cn;
   private Char eB;
   private Mob eC;
   public short co;
   public short cp;
   public int cq;
   public int cr;
   public int cs;
   public int ct;
   public int cu;
   public byte hpFrom1000TiemNang;
   public byte mpFrom1000TiemNang;
   public byte damFrom1000TiemNang;
   public byte defFrom1000TiemNang = 1;
   public byte criticalFrom1000Tiemnang = 1;
   public short cMaxStamina;
   public short cB;
   public byte cC;
   public boolean cD;
   public boolean cE = false;
   public boolean cF;
   public int cG;
   public boolean cH;
   public boolean cI;
   private boolean eD = true;
   private boolean eE = false;
   private int eF = 0;
   private short eG;
   private short eH;
   private byte eI;
   boolean cJ;
   int cK;
   public boolean cL;
   public boolean cM;
   public boolean cN;
   public boolean cO;
   public boolean cP;
   public int cQ = 100;
   public int cR;
   private int eJ = -1;
   private int eK = -1;
   private int eL = -1;
   private int eM = -1;
   private MyVector vEff = new MyVector("vEff");
   private static FrameImage eO;
   private int eP = 0;
   private long eQ;
   private int[] eR = new int[]{-1, -1, -1, -1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, -1, -1, -1, -1};
   private int[] eS = new int[]{-1, -1, -1, -1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, -1, -1, -1, -1};
   private int[] eT = new int[]{-1, -1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, -1, -1};
   public static int[][] cS;
   private int eU = 0;
   private String eV = "aura_";
   public short idAuraEff = -1;
   public static boolean cU;
   public static boolean cV;
   private FrameImage eW;
   private FrameImage eX;
   private String eY = "set_eff_";
   public short idEff_Set_Item = -1;
   private FrameImage eZ;
   private FrameImage fa;
   private FrameImage fb;
   private FrameImage fc;
   private String fd = "hat_sau_";
   private String fe = "hat_truoc_";
   private String ff = "ngang_";
   public short idHat = -1;
   private static int[][] fg;
   public boolean cY;
   private boolean fh;
   private long fi;
   private byte fj = 0;
   private short fk;
   private byte[] fl;
   private byte[] fm;
   private byte[] fn;
   private int fo = 0;
   private int fp = 0;
   private Point fq;
   private long fr;
   public boolean cZ = false;
   private short fs;
   public int da;
   public int db;
   private FrameImage ft = null;

   static {
      mSystem.loadImage("/mainImage/glass0.png");
      mSystem.loadImage("/mainImage/glass1.png");
      bC = new int[][][]{{{0, -13, 34}, {1, -8, 10}, {1, -9, 16}, {1, -9, 45}}, {{0, -13, 35}, {1, -8, 10}, {1, -9, 17}, {1, -9, 46}}, {{1, -10, 33}, {2, -10, 11}, {2, -8, 16}, {1, -12, 49}}, {{1, -10, 32}, {3, -12, 10}, {3, -11, 15}, {1, -13, 47}}, {{1, -10, 34}, {4, -8, 11}, {4, -7, 17}, {1, -12, 47}}, {{1, -10, 34}, {5, -12, 11}, {5, -9, 17}, {1, -13, 49}}, {{1, -10, 33}, {6, -10, 10}, {6, -8, 16}, {1, -12, 47}}, {{0, -9, 36}, {7, -5, 17}, {7, -11, 25}, {1, -8, 49}}, {{0, -7, 35}, {0, -18, 22}, {7, -10, 25}, {1, -7, 48}}, {{1, -11, 35}, {10, -3, 25}, {12, -10, 26}, new int[3]}, {{1, -11, 37}, {11, -3, 25}, {12, -11, 27}, new int[3]}, {{0, -14, 34}, {12, -8, 21}, {9, -7, 31}, new int[3]}, {{0, -12, 35}, {8, -5, 14}, {8, -15, 29}, {1, -9, 49}}, {{1, -9, 34}, {9, -12, 9}, {10, -7, 19}, new int[3]}, {{1, -13, 34}, {9, -12, 9}, {11, -10, 19}, new int[3]}, {{1, -8, 32}, {9, -12, 9}, {2, -6, 15}, new int[3]}, {{1, -8, 32}, {9, -12, 9}, {13, -12, 16}, new int[3]}, {{0, -10, 31}, {9, -12, 9}, {7, -13, 20}, new int[3]}, {{0, -11, 32}, {9, -12, 9}, {8, -15, 26}, new int[3]}, {{0, -9, 33}, {9, -12, 9}, {14, -8, 18}, new int[3]}, {{0, -11, 33}, {9, -12, 9}, {15, -6, 19}, new int[3]}, {{0, -16, 31}, {9, -12, 9}, {9, -8, 28}, new int[3]}, {{0, -14, 34}, {1, -8, 10}, {8, -16, 28}, new int[3]}, {{0, -8, 36}, {7, -5, 17}, {0, -5, 25}, new int[3]}, {{0, -9, 31}, {9, -12, 9}, {0, -6, 20}, new int[3]}, {{2, -9, 36}, {13, -5, 17}, {16, -11, 25}, new int[3]}, {{1, -9, 34}, {8, -5, 13}, {10, -7, 19}, new int[3]}, {{1, -13, 34}, {8, -5, 13}, {11, -10, 19}, new int[3]}, {{1, -8, 32}, {8, -5, 13}, {2, -6, 15}, new int[3]}, {{1, -8, 32}, {8, -5, 13}, {13, -12, 16}, new int[3]}, {{0, -9, 33}, {8, -5, 13}, {14, -8, 18}, new int[3]}, {{0, -11, 33}, {8, -5, 13}, {15, -6, 19}, new int[3]}, {{0, -16, 32}, {8, -5, 13}, {9, -8, 29}, new int[3]}};
      int[] var10000 = new int[]{-2, -6, 22, 21, 19, 22, 10, -2, -2, 5, 19};
      var10000 = new int[]{9, 22, 25, 17, 26, 37, 36, 49, 50, 52, 36};
      String[][] var0 = new String[][]{{"1", "1", "chiêu 1", "0"}, {"2", "2", "chiêu 2", "5"}};
      int[][] var1 = new int[][]{{1, 0, 1, 1000, 40, 1, 0, 20, 0, 0, 0, 0}, {2, 1, 10, 1000, 100, 1, 0, 40, 0, 0, 0, 0}, {2, 2, 11, 800, 100, 1, 0, 45, 0, 0, 0, 0}, {2, 3, 12, 600, 100, 1, 0, 50, 0, 0, 0, 0}, {2, 4, 13, 500, 100, 1, 0, 55, 0, 0, 0, 0}, {3, 1, 14, 500, 100, 1, 0, 60, 0, 0, 0, 0}, {3, 2, 14, 500, 100, 1, 0, 60, 0, 0, 0, 0}, {3, 3, 14, 500, 100, 1, 0, 60, 0, 0, 0, 0}, {3, 4, 14, 500, 100, 1, 0, 60, 0, 0, 0, 0}, {3, 5, 14, 500, 100, 1, 0, 60, 0, 0, 0, 0}};
      cn = false;
      cS = new int[][]{{542, 543}};
      cU = true;
      cV = true;
      fg = new int[][]{{5, -7}, {5, -7}, {5, -8}, {5, -7}, {5, -6}, {5, -8}, {5, -7}, {9, 0}, {11, 1}, {4, 0}, {4, -1}, {4, 8}, {6, 5}, {6, -6}, {2, -5}, {7, -8}, {7, -6}, {8, 0}, {7, 5}, {9, -7}, {7, -3}, {2, 8}, {4, 5}, {10, -5}, {9, -5}, {9, -5}, {6, -6}, {2, -5}, {7, -8}, {7, -6}, {9, -7}, {7, -3}};
   }

   public final void applyCharLevelPercent() {
      try {
         long var1 = 1L;
         long var3 = 0L;
         int var5 = 0;

         for(int var6 = GameScr.Q.length - 1; var6 >= 0; --var6) {
            if (this.cPower >= GameScr.Q[var6]) {
               if (var6 == GameScr.Q.length - 1) {
                  var1 = 1L;
               } else {
                  var1 = GameScr.Q[var6 + 1] - GameScr.Q[var6];
               }

               var3 = this.cPower - GameScr.Q[var6];
               var5 = var6;
               break;
            }
         }

         this.S = var5;
         this.Z = (long)((int)(var3 * 10000L / var1));
      } catch (Exception var7) {
      }
   }

   private int aa() {
      return this.myskill != null ? this.myskill.g : 0;
   }

   private int ab() {
      return this.myskill != null ? this.myskill.h : 0;
   }

   public static void a(boolean var0) {
      Util var1;
      String var2;
      if ((var2 = (var1 = myCharz().aD).g[var1.a]) != null && !var2.equals("")) {
         if (var2.startsWith("#")) {
            var2 = Util.replace(var2, "#", "");
            Npc var3;
            (var3 = new Npc(5, 0, -100, -100, 5, GameScr.info1.charId[myCharz().cgender][2])).cx = var3.cy = -100;
            var3.aO = GameScr.info1.charId[myCharz().cgender][2];
            var3.charID = 5;
            if (main.GameCanvas.currentScreen == GameScr.c) {
               ChatPopup.a(var2, var3);
            }
         } else if (var0) {
            GameScr.info1.a(var2, 0);
         }
      }

      GameScr.N = true;
      ResLog.c("TASKx " + myCharz().aD.c);
      if (myCharz().aD.c <= 2) {
         myCharz().ao = false;
      } else {
         myCharz().ao = true;
      }

      GameScr.gI().left = null;
      if (var1.c == 0) {
         Hint.f = false;
         Hint.h = false;
         GameScr.gI().cb = null;
         GameScr.N = false;
         GameScr.gI().left = null;
         if (var1.a < 4) {
            nr_k.j = false;
            GameScr.bm = -1;
         }

         if (var1.a == 4) {
            GameScr.bm = 1;
            nr_k.j = true;
         }

         if (var1.a >= 5) {
            GameScr.gI().cb = GameScr.gI().s;
         }
      }

      if (var1.c == 1) {
         GameScr.N = true;
      }

      if (var1.c > 0) {
         GameScr.gI().cb = GameScr.gI().s;
         GameScr.gI().left = GameScr.gI().aQ;
      }

      if (var1.c >= 0) {
         Panel.ar = true;
      } else {
         Panel.ar = false;
      }

      if (var1.c < 12) {
         main.GameCanvas.panel.C = mResources.aM;
      } else {
         main.GameCanvas.panel.C = mResources.aN;
      }

      main.GameCanvas.panel.L[0] = main.GameCanvas.panel.C;
      if (dA.aD.c > 10) {
         Rms.saveRMSString("fake", "aa");
      }

   }

   public final String c() {
      String var1;
      if ((var1 = this.bi[this.S] + "+" + this.Z / 100L + "." + this.Z % 100L + "%").length() > 23 && var1.indexOf("cấp ") >= 0) {
         var1 = ResLog.a(var1, "cấp ", "c");
      }

      return var1;
   }

   public final int d() {
      int var1 = this.head;

      for(int var2 = 0; var2 < idHead.length; ++var2) {
         if (var1 == idHead[var2]) {
            return idAvatar[var2];
         }
      }

      return -1;
   }

   public final void setPowerInfo(String var1, short var2, short var3, short var4) {
      this.bL = var2;
      this.bK = var1;
      this.bM = var3;
      this.bN = var4;
      ResLog.c("sc= " + var4 + " max= " + var3);
      this.dD = this.dE = System.currentTimeMillis();
   }

   public final void a(String var1) {
      if (this.z == null) {
         this.z = new Info();
      }

      this.z.a(var1, 0, (Char)null, false);
      ResLog.c("ad info");
   }

   public Char() {
      this.statusMe = 6;
   }

   public static Char myCharz() {
      if (dA == null) {
         (dA = new Char()).me = true;
         dA.ap = true;
      }

      return dA;
   }

   public static Char myPetz() {
      if (myPet == null) {
         (myPet = new Char()).me = false;
      }

      return myPet;
   }

   public static void g() {
      dA = null;
   }

   public final void h() {
      try {
         MyVector var1 = new MyVector("items");

         int var2;
         Item var3;
         for(var2 = 0; var2 < this.arrItemBox.length; ++var2) {
            if ((var3 = this.arrItemBox[var2]) != null && var3.template.h && !var3.x) {
               var1.addElement(var3);
            }
         }

         for(var2 = 0; var2 < var1.size(); ++var2) {
            if ((var3 = (Item)var1.elementAt(var2)) != null) {
               for(int var4 = var2 + 1; var4 < var1.size(); ++var4) {
                  Item var5;
                  if ((var5 = (Item)var1.elementAt(var4)) != null && var3.template.equals(var5.template) && var3.k == var5.k) {
                     var3.quantity += var5.quantity;
                     this.arrItemBox[var5.g] = null;
                     var1.setElementAt((Object)null, var4);
                  }
               }
            }
         }

         for(var2 = 0; var2 < this.arrItemBox.length; ++var2) {
            if (this.arrItemBox[var2] != null) {
               for(int var7 = 0; var7 <= var2; ++var7) {
                  if (this.arrItemBox[var7] == null) {
                     this.arrItemBox[var7] = this.arrItemBox[var2];
                     this.arrItemBox[var7].g = var7;
                     this.arrItemBox[var2] = null;
                     break;
                  }
               }
            }
         }

      } catch (Exception var6) {
         var6.printStackTrace();
         ResLog.c("Char.boxSort()");
      }
   }

   public final Skill a(SkillTemplate var1) {
      for(int var2 = 0; var2 < this.vSkill.size(); ++var2) {
         if (((Skill)this.vSkill.elementAt(var2)).template.id == var1.id) {
            return (Skill)this.vSkill.elementAt(var2);
         }
      }

      return null;
   }

   public final Waypoint i() {
      Util var1;
      if ((var1 = dA.aD) != null && var1.c == 0 && var1.a < 6) {
         return null;
      } else {
         int var5 = TileMap.t.size();

         for(byte var2 = 0; var2 < var5; ++var2) {
            Waypoint var3 = (Waypoint)TileMap.t.elementAt(var2);
            if (PopUp.a.size() >= var5 && !((PopUp)PopUp.a.elementAt(var2)).j) {
               return null;
            }

            if (this.cx >= var3.a && this.cx <= var3.c && this.cy >= var3.b && this.cy <= var3.d && var3.e && var3.f) {
               return var3;
            }
         }

         return null;
      }
   }

   public final Waypoint j() {
      Util var1;
      if ((var1 = dA.aD) != null && var1.c == 0 && var1.a < 6) {
         return null;
      } else {
         int var5 = TileMap.t.size();

         for(byte var2 = 0; var2 < var5; ++var2) {
            Waypoint var3 = (Waypoint)TileMap.t.elementAt(var2);
            if (PopUp.a.size() >= var5 && !((PopUp)PopUp.a.elementAt(var2)).j) {
               return null;
            }

            if (this.cx >= var3.a && this.cx <= var3.c && this.cy >= var3.b && this.cy <= var3.d && var3.e && !var3.f) {
               return var3;
            }
         }

         return null;
      }
   }

   private boolean ac() {
      if (TileMap.f() && this.cy >= TileMap.d - 48) {
         return true;
      } else if (!this.s && !this.t) {
         int var1 = TileMap.t.size();

         for(byte var2 = 0; var2 < var1; ++var2) {
            Waypoint var3 = (Waypoint)TileMap.t.elementAt(var2);
            if ((TileMap.l == 47 || TileMap.f()) && this.cy <= var3.b + var3.d && this.cx > var3.a && this.cx < var3.c) {
               if (TileMap.f() && this.cTypePk != 0) {
                  return false;
               }

               return true;
            }

            if (this.cx >= var3.a && this.cx <= var3.c && this.cy >= var3.b && this.cy <= var3.d && !var3.e) {
               return true;
            }
         }

         return false;
      } else {
         return false;
      }
   }

   public void a() {
      if (this.cZ) {
         this.as = 23;
         ++this.fs;
         if (this.fs > 150) {
            this.cZ = false;
         }

      } else {
         this.fs = 0;
         if (!this.bR) {
            if (!this.ck) {
               if (this.v != null) {
                  if (main.GameCanvas.v % 3 == 0) {
                     if (myCharz().I == 1) {
                        this.v.h = this.cx - 20;
                     }

                     if (myCharz().I == -1) {
                        this.v.h = this.cx + 20;
                     }

                     this.v.d = this.cy - 40;
                     if (this.v.i > this.cx) {
                        this.v.b = -1;
                     } else {
                        this.v.b = 1;
                     }

                     if (this.v.h < 100) {
                        this.v.h = 100;
                     }

                     if (this.v.h > TileMap.c - 100) {
                        this.v.h = TileMap.c - 100;
                     }
                  }

                  PetFollow var1;
                  PetFollow var2;
                  if ((var2 = var1 = this.v).e != var2.d) {
                     var2.g = var2.d - var2.e << 2;
                     var2.f += var2.g;
                     var2.e += var2.f >> 4;
                     var2.f &= 15;
                  }

                  if (var2.i != var2.h) {
                     var2.k = var2.h - var2.i << 2;
                     var2.j += var2.k;
                     var2.i += var2.j >> 4;
                     var2.j &= 15;
                  }

                  if (main.GameCanvas.v % 3 == 0) {
                     var1.c = var1.o[var1.p];
                     ++var1.p;
                  }

                  if (var1.p >= var1.o.length) {
                     var1.p = 0;
                  }
               }

               if (!this.me && this.cHP <= 0 && this.ah != -100 && this.statusMe != 14 && this.statusMe != 5) {
                  this.a((short)this.cx, (short)this.cy);
               }

               int var4;
               if (this.dI) {
                  ++this.dH;
                  if (this.dH == 20) {
                     this.dH = 0;
                     this.dI = false;
                  }
               } else if (this.cR > this.cHP) {
                  if ((var4 = this.cR - this.cHP >> 1) <= 0) {
                     var4 = 1;
                  }

                  this.cR -= var4;
               } else {
                  this.cR = this.cHP;
               }

               if (this.bN != 0) {
                  this.dE = System.currentTimeMillis();
                  if (this.dE - this.dD >= 1000L) {
                     this.dD = System.currentTimeMillis();
                     --this.bN;
                  }
               }

               if (this.cY) {
                  if (main.GameCanvas.b > this.fi || this.statusMe == 14 || this.statusMe == 5) {
                     this.fi = 0L;
                     this.cY = false;
                  }

                  if (this.fp == 0) {
                     if (this.fh && this.fo < 20) {
                        this.E = -3;
                        this.cy += this.E;
                     }

                     if (this.fl.length == 1) {
                        this.as = this.fl[0];
                     } else if (this.fo > this.fl.length - 1) {
                        this.as = this.fl[this.fl.length - 1];
                     } else {
                        this.as = this.fl[this.fo];
                     }
                  } else if (this.fp == 1) {
                     this.as = this.fm[this.fo % this.fm.length];
                     if (mSystem.currentTimeMillis() - this.fr > 0L) {
                        this.a(2, (short)0, (Point)null, (short)0, (short)0, (byte)0, (Point[])null, (byte)0);
                     }

                     if (this.fo % 5 == 0) {
                        GameScr.bt = 5;
                     }

                     if (this.fj == 1 && this.fo < 10 && !TileMap.a(this.cx - (this.am + 1) * this.I, this.cy, this.I == 1 ? 8 : 4)) {
                        this.cx -= this.I;
                     }
                  } else if (this.fp == 2) {
                     if (this.fn.length == 1) {
                        this.as = this.fn[0];
                     } else if (this.fo > this.fn.length - 1) {
                        this.as = this.fn[this.fn.length - 1];
                     } else {
                        this.as = this.fn[this.fo];
                     }

                     if (this.fh) {
                        this.D = this.E = 0;
                        this.statusMe = 4;
                     }

                     this.cY = false;
                  }

                  ++this.fo;
                  if (this.bd) {
                     this.H();
                  }

               } else {
                  if (this.cO && main.GameCanvas.v % 10 == 0) {
                     EffecMn.addEff(new Effect(41, this.cx, this.cy, 3, 1, 1));
                  }

                  if (this.cL) {
                     this.cL = false;
                     EffecMn.addEff(new Effect(39, this.cx, this.cy, 3, 3, 1));
                  }

                  if (this.cM && main.GameCanvas.v % 5 == 0) {
                     ServerEffect.a(113, (Char)this, 1);
                  }

                  if (this.cI) {
                     var4 = this.ey + 73;
                     if (main.GameCanvas.v % 5 == 0) {
                        this.dF = new Effect(33, this.cx, var4, 3, 3, 1);
                     }

                     if (this.dF != null) {
                        this.dF.a();
                        this.dF.f = this.cx;
                        this.dF.g = var4;
                     }
                  }

                  if (this.eD) {
                     String var6;
                     if (this.dG == null && (var6 = (String)main.GameCanvas.T.get(String.valueOf(this.charID))) != null) {
                        String[] var5;
                        short var3 = Short.parseShort((var5 = ResLog.a(var6.trim(), ",", 0))[0]);
                        short var8 = Short.parseShort(var5[1]);
                        this.dG = new Effect(var3, this.cx, this.ey + 73, 1, -1, -1);
                        this.dG.k = (long)(var8 * 1000) + mSystem.currentTimeMillis();
                     }

                     if (this.dG != null) {
                        this.dG.a();
                        this.dG.f = this.cx;
                        this.dG.g = this.ey;
                        if (this.dG.k <= mSystem.currentTimeMillis()) {
                           this.dG = null;
                           main.GameCanvas.T.remove(String.valueOf(this.charID));
                        }
                     }
                  }

                  if (this.aU != null && this.aU.cy < 0) {
                     this.aU = null;
                  }

                  if (this.cJ) {
                     ++this.cK;
                  }

                  if (this.isNhapThe && main.GameCanvas.v % 25 == 0) {
                     ServerEffect.a(114, (Char)this, 1);
                  }

                  if (this.eE) {
                     ++this.eF;
                     if (this.eF == 1) {
                        this.eF = 0;
                        this.eE = false;
                        this.cx = this.eG;
                        this.cy = this.eH;
                        this.F = this.d = this.G = 0;
                        ResLog.c("set pox x= " + this.eG + " y= " + this.eH);
                        if (this.eI == 1) {
                           if (this.me) {
                              this.bD = this.cx;
                              this.bE = this.cy;
                           }

                           this.bP = null;
                           this.cN = false;
                           ServerEffect.addServerEffect(173, this.cx, this.cy, 1);
                        } else {
                           ServerEffect.addServerEffect(60, this.cx, this.cy, 1);
                        }

                        if ((TileMap.b(this.cx, this.cy) & 2) == 2) {
                           this.statusMe = 1;
                           return;
                        }

                        this.statusMe = 4;
                     }

                  } else {
                     if (this.me && this.statusMe == 10 && this.as == 8 && this.dM > 20 && main.GameCanvas.v % 20 == 0) {
                        SoundMn.stopAll();
                     }

                     if (this.skillPaint != null && this.D() != null && this.cb < this.D().length) {
                        boolean var10000;
                        label1083: {
                           if (this.skillPaint != null) {
                              if (this.skillPaint.a >= 0 && this.skillPaint.a <= 6) {
                                 var10000 = true;
                                 break label1083;
                              }

                              if (this.skillPaint.a >= 14 && this.skillPaint.a <= 20) {
                                 var10000 = true;
                                 break label1083;
                              }

                              if (this.skillPaint.a >= 28 && this.skillPaint.a <= 34) {
                                 var10000 = true;
                                 break label1083;
                              }

                              if (this.skillPaint.a >= 63 && this.skillPaint.a <= 69) {
                                 var10000 = true;
                                 break label1083;
                              }
                           }

                           var10000 = false;
                        }

                        if (var10000 && (this.me || !this.me && this.cx >= GameScr.cmx && this.cx <= GameScr.cmx + main.GameCanvas.z) && main.GameCanvas.v % 5 == 0) {
                           if (this.as != 9 && this.as != 10 && this.as != 11) {
                              SoundMn.stopAll();
                           } else {
                              SoundMn.stopAll();
                           }
                        }
                     }

                     if (!this.cP) {
                        long var14;
                        if (this.bk) {
                           if (main.GameCanvas.v % 5 == 0) {
                              ServerEffect.addServerEffect(113, this.cx, this.cy, 1);
                           }

                           this.as = 23;
                           if ((var14 = System.currentTimeMillis()) - this.bp >= 1000L) {
                              --this.bn;
                              this.bp = var14;
                              if (this.bn < 0) {
                                 this.bk = false;
                                 this.bm = 0;
                                 if (this.me) {
                                    myCharz().bJ = false;
                                    GameScr.gI().aX = 0;
                                    GameScr.gI().aY = false;
                                 }
                              }
                           }

                           if (TileMap.a(this.cx / TileMap.i, this.cy / TileMap.i) == 0) {
                              ++this.dM;
                              ++this.dL;
                              this.bS += !this.dK ? 1 : -1;
                              if (this.dL == 10) {
                                 this.dL = 0;
                                 this.dK = !this.dK;
                              }
                           }

                        } else if (this.cE) {
                           this.bJ = true;
                           this.as = 17;
                           if (main.GameCanvas.v % 5 == 0) {
                              ServerEffect.addServerEffect(154, this.cx, this.cy - 10, 2);
                           }

                           if (main.GameCanvas.v % 5 == 0) {
                              ServerEffect.addServerEffect(1, this.cx, this.cy + 10, 1);
                           }

                           ++this.ej;
                           if (this.ej == 500) {
                              this.cE = false;
                              this.bJ = false;
                           }

                        } else {
                           boolean var12;
                           if (this.cj) {
                              ++this.ej;
                              var12 = !TileMap.a(myCharz().cx, myCharz().cy, 2);
                              this.ad();
                              this.ag();
                              this.aZ = null;
                              this.bP = null;
                              this.as = 17;
                              if (var12 && this.cgender != 2) {
                                 this.as = 12;
                              }

                              if (this.cgender == 2) {
                                 if (main.GameCanvas.v % 3 == 0) {
                                    ServerEffect.addServerEffect(154, this.cx, this.cy - this.al / 2 + 10, 1);
                                 }

                                 if (main.GameCanvas.v % 5 == 0) {
                                    ServerEffect.addServerEffect(114, this.cx + ResLog.random(-20, 20), this.cy + ResLog.random(-20, 20), 1);
                                 }
                              }

                              if (this.cgender == 1 && main.GameCanvas.v % 2 == 0) {
                                 if (this.I == 1) {
                                    ServerEffect.addServerEffect(70, this.cx - 18, this.cy - this.al / 2 + 8, 1);
                                    ServerEffect.addServerEffect(70, this.cx + 23, this.cy - this.al / 2 + 15, 1);
                                 } else {
                                    ServerEffect.addServerEffect(70, this.cx + 18, this.cy - this.al / 2 + 8, 1);
                                    ServerEffect.addServerEffect(70, this.cx - 23, this.cy - this.al / 2 + 15, 1);
                                 }
                              }

                              this.m = System.currentTimeMillis();
                              if (this.m - this.bo > (long)this.bm || this.m - this.bo > 10000L) {
                                 this.C();
                                 if (this.me) {
                                    GameScr.gI().aW = 0;
                                    if (this.cgender == 2) {
                                       myCharz().b(GameScr.u[myCharz().myskill.b], !var12 ? 0 : 1);
                                       Service.gI().c((byte)8);
                                    }

                                    if (this.cgender == 1) {
                                       this.isCreateDark = true;
                                       myCharz().a(GameScr.u[myCharz().myskill.b], !var12 ? 0 : 1);
                                    }
                                 } else if (this.cgender == 2) {
                                    this.b(GameScr.u[this.skillTemplateId], !var12 ? 0 : 1);
                                 }

                                 ResLog.c("24234234234 status= " + this.statusMe + " hp= " + this.cHP);
                                 if (this.cgender == 2 && this.statusMe != 14 && this.statusMe != 5) {
                                    ResLog.c("ASDSADSD");
                                    GameScr.gI().b(this.cx, this.cy);
                                 }
                              }

                              ++this.ej;
                              if (this.ej == 500) {
                                 this.C();
                              }

                           } else if (this.ci) {
                              this.ad();
                              this.ag();
                              this.aZ = null;
                              this.bP = null;
                              ++this.ei;
                              if (TileMap.a(this.cx, this.cy - this.al, 8192)) {
                                 this.C();
                              } else {
                                 if (this.ei == 20) {
                                    this.bo = System.currentTimeMillis();
                                 }

                                 if (this.ei > 20) {
                                    this.m = System.currentTimeMillis();
                                    if (this.m - this.bo <= (long)this.bm && this.m - this.bo <= 10000L) {
                                       this.as = 32;
                                       if (this.cgender == 0 && main.GameCanvas.v % 3 == 0) {
                                          ServerEffect.addServerEffect(153, this.cx, this.cy - this.al, 2);
                                       }

                                       ++this.ej;
                                       if (this.ej == 500) {
                                          this.C();
                                       }

                                    } else {
                                       this.ci = false;
                                       if (this.me) {
                                          this.isCreateDark = true;
                                          var12 = TileMap.a(myCharz().cx, myCharz().cy, 2);
                                          this.ch = true;
                                          myCharz().a(GameScr.u[myCharz().myskill.b], var12 ? 0 : 1);
                                       }

                                    }
                                 } else {
                                    if (this.statusMe != 14) {
                                       this.statusMe = 3;
                                    }

                                    this.E = -3;
                                    this.cy += this.E;
                                    this.as = 7;
                                 }
                              }
                           } else {
                              int var7;
                              if (this.me && main.GameCanvas.isTouch) {
                                 if (this.aU != null && this.aU.charID >= 0 && this.aU.cx > 100 && this.aU.cx < TileMap.c - 100 && this.j() == null && this.i() == null && !this.I() && TileMap.l != 51 && TileMap.l != 52 && main.GameCanvas.panel.R.size() > 0 && GameScr.gI().popUpYesNo == null) {
                                    var4 = Math.abs(this.cx - this.aU.cx);
                                    var7 = Math.abs(this.cy - this.aU.cy);
                                    if (var4 < 60 && var7 < 40) {
                                       if (this.an == null) {
                                          this.an = new CommandLine(mResources.bh, 11111);
                                          this.an.isPlaySoundButton = false;
                                       }

                                       this.an.x = this.aU.cx - GameScr.cmx;
                                       this.an.y = this.aU.cy - this.aU.al - 30 - GameScr.cmy;
                                    } else {
                                       this.an = null;
                                    }
                                 } else {
                                    this.an = null;
                                 }
                              }

                              if (this.bd) {
                                 this.H();
                              }

                              if (!this.s) {
                                 if (this.z != null) {
                                    this.z.b();
                                 }

                                 if (this.c > 0) {
                                    --this.c;
                                 }

                                 if (this.j > 0 && main.GameCanvas.v % 2 == 0) {
                                    --this.j;
                                    if (this.j == 30 || this.j == 60) {
                                       this.j = 0;
                                    }
                                 }

                                 this.ag();
                                 int var9;
                                 if (this.aR != null) {
                                    if (this.aS != 0) {
                                       --this.aS;
                                    }

                                    if (this.aS == 0) {
                                       this.aR.xFirst = this.I == 1 ? this.cx - 30 : this.cx + 30;
                                       this.aR.yFirst = this.cy - 60;
                                       var7 = this.aR.xFirst - this.aR.x;
                                       var9 = this.aR.yFirst - this.aR.y;
                                       Mob var15 = this.aR;
                                       var15.x += var7 / 4;
                                       var15 = this.aR;
                                       var15.y += var9 / 4;
                                       this.aR.o = this.I;
                                    }
                                 }

                                 if (this.arr != null) {
                                    this.arr.a();
                                 }

                                 if (this.dart != null) {
                                    this.dart.a();
                                 }

                                 this.ad();
                                 if (this.cG != 0) {
                                    if (main.GameCanvas.v % 5 == 0) {
                                       EffecMn.addEff(new Effect(32, this.cx, this.cy + 24, 3, 5, 1));
                                    }

                                 } else if (!this.cM) {
                                    if (!this.cO) {
                                       if (this.cH) {
                                          if (this.eB != null && (this.eB.statusMe == 14 || this.eB.statusMe == 5)) {
                                             this.P();
                                          }

                                          if (this.eC != null && this.eC.p == 1) {
                                             this.P();
                                          }

                                          if (this.me && this.statusMe == 2 && this.bP != null) {
                                             this.cH = false;
                                             this.eB = null;
                                             this.eC = null;
                                          }

                                          if (TileMap.a(this.cx, this.cy, 2)) {
                                             this.as = 16;
                                          } else {
                                             this.as = 31;
                                          }
                                       } else {
                                          if (this.cHP > 0) {
                                             for(var4 = 0; var4 < this.aB.size(); ++var4) {
                                                nr_dz var10 = (nr_dz)this.aB.elementAt(var4);
                                                if (main.GameCanvas.x) {
                                                   this.cHP += var10.a;
                                                   this.cMP += var10.a;
                                                }
                                             }

                                             if (this.eff5BuffHp > 0 && main.GameCanvas.y) {
                                                this.cHP += this.eff5BuffHp;
                                             }

                                             if (this.eff5BuffMp > 0 && main.GameCanvas.y) {
                                                this.cMP += this.eff5BuffMp;
                                             }

                                             if (this.cHP > this.cHPFull) {
                                                this.cHP = this.cHPFull;
                                             }

                                             if (this.cMP > this.cMPFull) {
                                                this.cMP = this.cMPFull;
                                             }
                                          }

                                          if (this.ap) {
                                             GameScr.l = this.cx - GameScr.f;
                                             GameScr.m = this.cy - GameScr.g - 1;
                                             if (!main.GameCanvas.f) {
                                                GameScr.l += GameScr.i * this.I;
                                             }
                                          }

                                          this.h = (this.h + 1) % 100;
                                          if (this.me) {
                                             if (this.aU != null && !GameScr.vCharInMap.contains(this.aU)) {
                                                this.aU = null;
                                             }

                                             if (this.cx < 10) {
                                                this.D = 0;
                                                this.cx = 10;
                                             } else if (this.cx > TileMap.c - 10) {
                                                this.cx = TileMap.c - 10;
                                                this.D = 0;
                                             }

                                             if (this.me && !bG && this.ac()) {
                                                Service.gI().g();
                                                if (TileMap.b()) {
                                                   Service.gI().q();
                                                   bG = true;
                                                } else {
                                                   Service.gI().f();
                                                }

                                                bH = true;
                                                bG = true;
                                                main.GameCanvas.f();
                                                main.GameCanvas.clearKeyPressed();
                                                InfoDlg.a();
                                                return;
                                             }

                                             if (this.statusMe != 4 && ResLog.g(this.cx - this.bD) + ResLog.g(this.cy - this.bE) >= 70 && this.cy - this.bE <= 0 && this.me) {
                                                Service.gI().g();
                                             }

                                             if (this.bJ) {
                                                this.bP = null;
                                             }

                                             if (this.bP != null) {
                                                if (c(this.cx - this.bP.a) <= 16 && c(this.cy - this.bP.b) <= 16) {
                                                   this.cx = (this.bP.a + this.cx) / 2;
                                                   this.cy = this.bP.b;
                                                   this.bP = null;
                                                   GameScr.c.aU = false;
                                                   this.ae();
                                                   this.D = this.E = 0;
                                                   if ((TileMap.b(this.cx, this.cy) & 2) == 2) {
                                                      this.statusMe = 1;
                                                   } else {
                                                      this.ao();
                                                      this.au();
                                                   }

                                                   Service.gI().g();
                                                } else {
                                                   this.I = this.bP.a > this.cx ? 1 : -1;
                                                   if (TileMap.a(this.cx, this.cy, 2)) {
                                                      this.statusMe = 2;
                                                      if (this.bP != null) {
                                                         this.D = this.O * this.I;
                                                         this.E = 0;
                                                      }

                                                      if (c(this.cx - this.bP.a) <= 10) {
                                                         if (this.bP.b > this.cy) {
                                                            if (this.bP.b > this.cy) {
                                                               var12 = false;
                                                               byte var11;
                                                               if (this.I == 1) {
                                                                  var11 = 1;
                                                               } else {
                                                                  var11 = -1;
                                                               }

                                                               for(var9 = 0; var9 < 2; ++var9) {
                                                                  if (TileMap.a(this.bP.a + this.am * var11, this.cy + this.f * var9, 2)) {
                                                                     var12 = true;
                                                                     break;
                                                                  }
                                                               }

                                                               if (var12) {
                                                                  this.bP = null;
                                                                  GameScr.c.aU = false;
                                                                  this.statusMe = 1;
                                                                  this.D = this.E = 0;
                                                                  this.ae();
                                                               } else {
                                                                  SoundMn.stopAll();
                                                                  this.cx = this.bP.a;
                                                                  this.statusMe = 10;
                                                                  this.E = -5;
                                                                  this.D = 0;
                                                                  ResLog.c("Jum lun");
                                                               }
                                                            }
                                                         } else {
                                                            SoundMn.stopAll();
                                                            this.cx = this.bP.a;
                                                            this.statusMe = 10;
                                                            this.E = -5;
                                                            this.D = 0;
                                                         }
                                                      }

                                                      if (this.I == 1) {
                                                         if (TileMap.a(this.cx + this.am, this.cy - this.f, 4)) {
                                                            this.D = this.O * this.I;
                                                            this.statusMe = 10;
                                                            this.E = -5;
                                                         }
                                                      } else if (TileMap.a(this.cx - this.am - 1, this.cy - this.f, 8)) {
                                                         this.D = this.O * this.I;
                                                         this.statusMe = 10;
                                                         this.E = -5;
                                                      }
                                                   } else {
                                                      if (this.bP.b < this.cy + 10) {
                                                         this.statusMe = 10;
                                                         this.E = -5;
                                                         if (c(this.cy - this.bP.b) <= 10) {
                                                            this.cy = this.bP.b;
                                                            this.E = 0;
                                                         }

                                                         if (c(this.cx - this.bP.a) <= 10) {
                                                            this.D = 0;
                                                         } else {
                                                            this.D = this.O * this.I;
                                                         }
                                                      } else if (TileMap.a(this.cx, this.cy, 2)) {
                                                         this.bP = null;
                                                         GameScr.c.aU = false;
                                                         this.statusMe = 1;
                                                         this.D = this.E = 0;
                                                         this.ae();
                                                      } else {
                                                         if (this.statusMe == 10 || this.statusMe == 2) {
                                                            this.E = 0;
                                                         }

                                                         this.statusMe = 4;
                                                      }

                                                      if (this.bP.b > this.cy) {
                                                         if (this.I == 1) {
                                                            if (TileMap.a(this.cx + this.am, this.cy - this.f, 4)) {
                                                               this.D = this.E = 0;
                                                               this.statusMe = 4;
                                                               this.bP = null;
                                                               GameScr.c.aU = false;
                                                               this.ae();
                                                            }
                                                         } else if (TileMap.a(this.cx - this.am - 1, this.cy - this.f, 8)) {
                                                            this.D = this.E = 0;
                                                            this.statusMe = 4;
                                                            this.bP = null;
                                                            GameScr.c.aU = false;
                                                            this.ae();
                                                         }
                                                      }
                                                   }
                                                }
                                             }

                                             this.av();
                                          } else {
                                             this.af();
                                             if (this.statusMe == 1 || this.statusMe == 6) {
                                                label1183: {
                                                   var12 = false;
                                                   if (this.bP != null) {
                                                      if (c(this.bP.a - this.cx) < 17 && c(this.bP.b - this.cy) < 25) {
                                                         this.cx = this.bP.a;
                                                         this.cy = this.bP.b;
                                                         this.bP = null;
                                                         if ((TileMap.b(this.cx, this.cy) & 2) == 2) {
                                                            this.statusMe = 1;
                                                            this.G = 0;
                                                            main.GameCanvas.a().a(-1, this.cx - -8, this.cy);
                                                            main.GameCanvas.a().a(1, this.cx - 8, this.cy);
                                                         } else {
                                                            this.statusMe = 4;
                                                            this.E = 0;
                                                            this.F = 0;
                                                         }

                                                         var12 = true;
                                                         break label1183;
                                                      }

                                                      if (this.ez != 10 && this.as != 8 || this.bF.size() <= 0) {
                                                         if (this.cy == this.bP.b) {
                                                            if (this.cx != this.bP.a) {
                                                               this.cx = (this.cx + this.bP.a) / 2;
                                                               this.as = main.GameCanvas.v % 5 + 2;
                                                            }
                                                         } else if (this.cy < this.bP.b) {
                                                            this.as = 12;
                                                            this.cx = (this.cx + this.bP.a) / 2;
                                                            if (this.E < 0) {
                                                               this.E = 0;
                                                            }

                                                            this.cy += this.E;
                                                            if ((TileMap.b(this.cx, this.cy) & 2) == 2) {
                                                               main.GameCanvas.a().a(-1, this.cx - -8, this.cy);
                                                               main.GameCanvas.a().a(1, this.cx - 8, this.cy);
                                                            }

                                                            ++this.E;
                                                            if (this.E > 16) {
                                                               this.cy = (this.cy + this.bP.b) / 2;
                                                            }
                                                         } else {
                                                            this.as = 7;
                                                            this.cx = (this.cx + this.bP.a) / 2;
                                                            this.cy = (this.cy + this.bP.b) / 2;
                                                         }
                                                         break label1183;
                                                      }
                                                   }

                                                   var12 = true;
                                                }

                                                if (var12 && this.bF.size() > 0) {
                                                   this.bP = (nr_dj)this.bF.firstElement();
                                                   this.bF.removeElementAt(0);
                                                   if (this.bP.c == 2) {
                                                      if ((TileMap.b(this.cx, this.cy + 12) & 2) != 2) {
                                                         this.statusMe = 10;
                                                         this.F = 0;
                                                         this.d = 0;
                                                         this.D = -(this.cx - this.bP.a) / 10;
                                                         this.E = -(this.cy - this.bP.b) / 10;
                                                         if (this.cx - this.bP.a > 0) {
                                                            this.I = -1;
                                                         } else if (this.cx - this.bP.a < 0) {
                                                            this.I = 1;
                                                         }
                                                      } else {
                                                         this.statusMe = 2;
                                                         if (this.cx - this.bP.a > 0) {
                                                            this.I = -1;
                                                         } else if (this.cx - this.bP.a < 0) {
                                                            this.I = 1;
                                                         }

                                                         this.D = this.O * this.I;
                                                         this.E = 0;
                                                      }
                                                   } else if (this.bP.c == 3) {
                                                      if ((TileMap.b(this.cx, this.cy + 23) & 2) != 2) {
                                                         this.statusMe = 10;
                                                         this.F = 0;
                                                         this.d = 0;
                                                         this.D = -(this.cx - this.bP.a) / 10;
                                                         this.E = -(this.cy - this.bP.b) / 10;
                                                         if (this.cx - this.bP.a > 0) {
                                                            this.I = -1;
                                                         } else if (this.cx - this.bP.a < 0) {
                                                            this.I = 1;
                                                         }
                                                      } else {
                                                         this.statusMe = 3;
                                                         main.GameCanvas.a().a(-1, this.cx - -8, this.cy);
                                                         main.GameCanvas.a().a(1, this.cx - 8, this.cy);
                                                         if (this.cx - this.bP.a > 0) {
                                                            this.I = -1;
                                                         } else if (this.cx - this.bP.a < 0) {
                                                            this.I = 1;
                                                         }

                                                         this.D = c(this.cx - this.bP.a) / 10 * this.I;
                                                         this.E = -10;
                                                      }
                                                   } else if (this.bP.c == 4) {
                                                      this.statusMe = 4;
                                                      if (this.cx - this.bP.a > 0) {
                                                         this.I = -1;
                                                      } else if (this.cx - this.bP.a < 0) {
                                                         this.I = 1;
                                                      }

                                                      this.D = c(this.cx - this.bP.a) / 9 * this.I;
                                                      this.E = 0;
                                                   } else {
                                                      this.cx = this.bP.a;
                                                      this.cy = this.bP.b;
                                                      this.bP = null;
                                                   }
                                                }
                                             }
                                          }

                                          switch(this.statusMe) {
                                          case 1:
                                             this.ar = false;
                                             this.g = false;
                                             this.D = 0;
                                             this.E = 0;
                                             ++this.F;
                                             if (this.F > 30) {
                                                this.F = 0;
                                             }

                                             if (this.F % 15 < 5) {
                                                this.as = 0;
                                             } else {
                                                this.as = 1;
                                             }

                                             this.ax();
                                             if (!this.me) {
                                                ++this.G;
                                                if (this.G > 50) {
                                                   this.G = 0;
                                                   this.bP = null;
                                                }
                                             }

                                             this.ak();
                                             if (this.me && GameScr.vCharInMap.size() != 0 && TileMap.l == 50) {
                                                Char var13;
                                                if (!(var13 = (Char)GameScr.vCharInMap.elementAt(0)).dJ) {
                                                   if (var13.statusMe != 2) {
                                                      var13.b(this.cx - 45, this.cy, 0);
                                                   }

                                                   System.currentTimeMillis();
                                                   if (ResLog.g(this.cx - 45 - var13.cx) <= 10) {
                                                      var13.dJ = true;
                                                   }
                                                } else {
                                                   if (var13.statusMe != 2) {
                                                      var13.b(this.cx + 45, this.cy, 0);
                                                   }

                                                   System.currentTimeMillis();
                                                   if (ResLog.g(this.cx + 45 - var13.cx) <= 10) {
                                                      var13.dJ = false;
                                                   }
                                                }

                                                if (main.GameCanvas.v % 100 == 0) {
                                                   var13.a("Cắc cùm cum");
                                                }
                                             }
                                             break;
                                          case 2:
                                             this.al();
                                             break;
                                          case 3:
                                             this.an();
                                             break;
                                          case 4:
                                             this.ap();
                                             break;
                                          case 5:
                                             this.bk = false;
                                             if (this.bl) {
                                                this.bl = false;
                                                SoundMn.stopAll();
                                                Service.gI().c((byte)3);
                                             }

                                             ++this.F;
                                             this.cx += (this.d - this.cx) / 4;
                                             if (this.F > 7) {
                                                this.cy += (this.G - this.cy) / 4;
                                             } else {
                                                this.cy += this.F - 10;
                                             }

                                             if (ResLog.g(this.d - this.cx) < 4 && ResLog.g(this.G - this.cy) < 10) {
                                                this.cx = this.d;
                                                this.cy = this.G;
                                                this.statusMe = 14;
                                                if (this.me) {
                                                   GameScr.gI().q();
                                                   Service.gI().g();
                                                }
                                             }

                                             this.as = 23;
                                             break;
                                          case 6:
                                             if (this.eh <= 0) {
                                                this.as = 0;
                                             } else if (this.ez == 10) {
                                                this.cx += this.D;
                                             } else if (this.as <= 1) {
                                                ++this.F;
                                                if (this.F > 6) {
                                                   this.as = 0;
                                                } else {
                                                   this.as = 1;
                                                }

                                                if (this.F > 10) {
                                                   this.F = 0;
                                                }
                                             }

                                             if (this.as != 7 && this.as != 12 && (TileMap.b(this.cx, this.cy + 1) & 2) != 2) {
                                                this.D = 0;
                                                this.E = 0;
                                                this.statusMe = 4;
                                                this.as = 7;
                                             }

                                             if (!this.me) {
                                                ++this.G;
                                                if (this.G > 10) {
                                                   if ((TileMap.b(this.cx, this.cy + 1) & 2) != 2) {
                                                      this.cy += 5;
                                                   } else {
                                                      this.as = 0;
                                                   }
                                                }

                                                if (this.G > 50) {
                                                   this.G = 0;
                                                   this.bP = null;
                                                }
                                             }
                                          case 7:
                                          case 8:
                                          case 11:
                                          case 13:
                                          case 15:
                                          default:
                                             break;
                                          case 9:
                                             this.aj();
                                             break;
                                          case 10:
                                             this.aq();
                                             break;
                                          case 12:
                                             this.ai();
                                             break;
                                          case 14:
                                             ++this.F;
                                             if (this.F > 30) {
                                                this.F = 0;
                                             }

                                             if (this.F % 15 < 5) {
                                                this.as = 0;
                                             } else {
                                                this.as = 1;
                                             }
                                             break;
                                          case 16:
                                             this.ah();
                                          }

                                          if (this.eh > 0) {
                                             this.as = 23;
                                             --this.eh;
                                          }

                                          if (this.co != 0 || this.cp != 0) {
                                             this.a(this.co, this.cp);
                                             this.co = 0;
                                             this.cp = 0;
                                          }

                                          if (this.aZ != null) {
                                             if (this.aZ[0] == 0) {
                                                ++this.aZ[0];
                                                ServerEffect.a(60, (Char)this, 1);
                                             } else if (this.aZ[0] < 10) {
                                                ++this.aZ[0];
                                             } else {
                                                this.cx = this.aZ[1];
                                                this.cy = this.aZ[2];
                                                this.aZ = null;
                                                ServerEffect.a(60, (Char)this, 1);
                                                if (this.me) {
                                                   if ((TileMap.b(this.cx, this.cy) & 2) != 2) {
                                                      this.statusMe = 4;
                                                      myCharz().b(GameScr.u[38], 1);
                                                   } else {
                                                      Service.gI().g();
                                                      myCharz().b(GameScr.u[38], 0);
                                                   }
                                                }
                                             }
                                          }

                                          if (this.statusMe != 10) {
                                             this.bS = 0;
                                          }

                                          if (this.bl) {
                                             this.as = 17;
                                             if (main.GameCanvas.v % 4 == 0) {
                                                ServerEffect.addServerEffect(1, this.cx, this.cy + main.GameCanvas.ac, 1);
                                             }

                                             if (this.me && (var14 = System.currentTimeMillis()) - this.bo >= 1000L) {
                                                ResLog.c("%= " + this.myskill.k);
                                                this.bo = var14;
                                                this.cHP += this.cHPFull * this.myskill.k / 100;
                                                this.cMP += this.cMPFull * this.myskill.k / 100;
                                                if (this.cHP < this.cHPFull) {
                                                   GameScr.a("+" + this.cHPFull * this.myskill.k / 100 + " " + mResources.eU, this.cx, this.cy - this.al - 20, 0, -1, 9);
                                                }

                                                if (this.cMP < this.cMPFull) {
                                                   GameScr.a("+" + this.cMPFull * this.myskill.k / 100 + " " + mResources.eV, this.cx, this.cy - this.al - 20, 0, -2, 10);
                                                }

                                                Service.gI().c((byte)2);
                                             }
                                          }

                                          if (this.bq) {
                                             if (this.me) {
                                                bH = true;
                                                this.statusMe = 3;
                                                this.E = -8;
                                                if (this.cy <= TileMap.d - 240) {
                                                   this.bq = false;
                                                   bH = false;
                                                   this.statusMe = 4;
                                                }
                                             } else {
                                                this.statusMe = 3;
                                                this.E = -8;
                                                if (this.cy <= TileMap.d - 240) {
                                                   this.E = 0;
                                                   this.bq = false;
                                                   this.E = 0;
                                                   this.statusMe = 1;
                                                }
                                             }
                                          }

                                          this.ar();
                                          this.az();
                                          if (this.head == 934) {
                                             if (main.GameCanvas.b - this.eQ > 0L) {
                                                ++this.eP;
                                                if (this.eP > this.eT.length - 1) {
                                                   this.eP = 0;
                                                   this.eQ = main.GameCanvas.b + (long)ResLog.random(2000, 3500);
                                                   this.eT = this.eS;
                                                   if (ResLog.d(2) == 0) {
                                                      this.eT = this.eR;
                                                   }
                                                }
                                             } else {
                                                this.eP = 0;
                                             }
                                          }

                                          this.aA();
                                       }
                                    }
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }
         }
      }
   }

   private void ad() {
      if (this.ef != null) {
         for(int var1 = 0; var1 < this.ef.length; ++var1) {
            if (this.ef[var1] != null) {
               if (this.ef[var1].b != null) {
                  if (!this.ef[var1].e) {
                     this.ef[var1].b.d();
                     this.ef[var1].b.Z = this;
                     if (this.me) {
                        myCharz();
                        myCharz();
                        boolean var2 = true;
                        (new Random()).nextInt(11);
                     }

                     int var3 = this.ef[var1].b.w >> 1;
                     if (this.ef[var1].b.isBigBoss()) {
                        var3 = this.ef[var1].b.getY() + 20;
                     }

                     GameScr.a(this.ef[var1].b.x, this.ef[var1].b.y - var3, this.I);
                     this.ef[var1].e = true;
                  }
               } else if (this.ef[var1].c != null && !this.ef[var1].e) {
                  if (this.ef[var1].c.charID >= 0) {
                     this.ef[var1].c.K();
                  }

                  GameScr.a(this.ef[var1].c.cx, this.ef[var1].c.cy - (this.ef[var1].c.al >> 1), this.I);
                  this.ef[var1].e = true;
               }

               ++this.ef[var1].a;
               if (this.ef[var1].a >= this.ef[var1].d.a.length) {
                  this.ef[var1] = null;
               }
            }
         }
      }

      if (this.indexEffTask >= 0 && this.effTask != null && main.GameCanvas.v % 2 == 0) {
         ++this.indexEffTask;
         if (this.indexEffTask >= this.effTask.a.length) {
            this.indexEffTask = -1;
            this.effTask = null;
         }
      }

   }

   private void ae() {
      if (this.ay != null) {
         CommandLine var1 = this.ay;
         this.ay = null;
         var1.performAction();
      }

   }

   private void af() {
      if (main.GameCanvas.v % 20 == 0 && this.charID >= 0) {
         this.i = true;

         int var1;
         for(var1 = 0; var1 < GameScr.vCharInMap.size(); ++var1) {
            Char var2 = null;

            try {
               var2 = (Char)GameScr.vCharInMap.elementAt(var1);
            } catch (Exception var4) {
            }

            if (var2 != null && !var2.equals(this) && (var2.cy == this.cy && ResLog.g(var2.cx - this.cx) < 35 || this.cy - var2.cy < 32 && this.cy - var2.cy > 0 && ResLog.g(var2.cx - this.cx) < 24)) {
               this.i = false;
            }
         }

         for(var1 = 0; var1 < GameScr.G.size(); ++var1) {
            Npc var5 = null;

            try {
               var5 = (Npc)GameScr.G.elementAt(var1);
            } catch (Exception var3) {
            }

            if (var5 != null && var5.cy == this.cy && ResLog.g(var5.cx - this.cx) < 24) {
               this.i = false;
            }
         }
      }

   }

   private void ag() {
      if (this.statusMe != 14 && this.statusMe != 5) {
         if (this.skillPaint != null && (this.aU != null && this.c(this.aU) && this.aU.statusMe == 14 || this.aQ != null && this.aQ.p == 0)) {
            if (!this.me) {
               if ((TileMap.b(this.cx, this.cy) & 2) == 2) {
                  this.statusMe = 1;
               } else {
                  this.statusMe = 6;
               }

               this.G = 0;
            }

            this.cb = 0;
            this.skillPaint = null;
            this.skillPaintRandomPaint = null;
            this.eff0 = this.eff1 = this.eff2 = null;
            this.dT = this.dU = this.dV = 0;
            this.aQ = null;
            this.aU = null;
            this.ef = null;
            this.bP = null;
            this.arr = null;
            if ((TileMap.b(this.cx, this.cy) & 2) != 2) {
               this.bQ = 5;
            }
         }

         if (this.skillPaint != null && this.arr == null && this.D() != null && this.cb >= this.D().length) {
            if (!this.me) {
               if ((TileMap.b(this.cx, this.cy) & 2) == 2) {
                  this.statusMe = 1;
               } else {
                  this.statusMe = 6;
               }

               this.G = 0;
            }

            this.cb = 0;
            this.skillPaint = null;
            this.skillPaintRandomPaint = null;
            this.eff0 = this.eff1 = this.eff2 = null;
            this.dT = this.dU = this.dV = 0;
            this.arr = null;
            if ((TileMap.b(this.cx, this.cy) & 2) != 2) {
               this.bQ = 5;
            }
         }

         nr_f[] var1;
         if ((var1 = this.D()) != null && this.cb >= 0 && this.cb <= var1.length - 1) {
            if (var1[this.cb].b != 0) {
               this.eff0 = GameScr.y[var1[this.cb].b - 1];
               this.dT = this.dW = this.dZ = 0;
            }

            if (var1[this.cb].e != 0) {
               this.eff1 = GameScr.y[var1[this.cb].e - 1];
               this.dU = this.dX = this.ea = 0;
            }

            if (var1[this.cb].h != 0) {
               this.eff2 = GameScr.y[var1[this.cb].h - 1];
               this.dV = this.dY = this.eb = 0;
            }

            int var3 = this.cb;
            if (var1 != null && var1[var3] != null && var3 >= 0 && var3 <= var1.length - 1 && var1[var3].k != 0) {
               int var4;
               if ((var4 = var1[var3].k) >= 100) {
                  IMapObject var10000;
                  if(this.aQ == null) {
                      var10000 = this.aU;
                  }
                  else {
                      var10000 = this.aQ;
                  }
                  IMapObject var5 = var10000;
                  if (var10000 != null) {
                     int var6 = ResLog.g(((IMapObject)var5).getX() - this.cx);
                     int var7 = ResLog.g(((IMapObject)var5).getY() - this.cy);
                     byte var10;
                     if (var6 > var7 * 4) {
                        var10 = 0;
                     } else {
                        if (((IMapObject)var5).getY() < this.cy) {
                           var10 = -3;
                        } else {
                           var10 = 3;
                        }

                        BigBoss var9;
                        if (var5 instanceof BigBoss && (var9 = (BigBoss)var5).b) {
                           var10 = -20;
                        }
                     }

                     this.dart = new PlayerDart(this, var4 - 100, this.skillPaintRandomPaint, this.cx + (var1[var3].l - 10) * this.I, this.cy + var1[var3].m + var10);
                     if (this.myskill != null) {
                        if (this.myskill.template.id == 1) {
                           SoundMn.stopAll();
                        } else if (this.myskill.template.id == 3) {
                           SoundMn.stopAll();
                        } else if (this.myskill.template.id == 5) {
                           SoundMn.stopAll();
                        } else if (this.myskill.template.id == 11) {
                           SoundMn.stopAll();
                        }
                     }
                  } else if (this.ci || this.ch) {
                     this.C();
                  }
               } else {
                  this.arr = new Arrow(this, GameScr.v[var4 - 1]);
                  this.arr.a = 10;
                  this.arr.b = this.cx + var1[var3].l;
                  this.arr.c = this.cy + var1[var3].m;
               }
            }

            if ((this.aQ != null || !this.me && this.aU != null || this.me && this.aU != null && (this.c(this.aU) || this.y()) && this.arr == null && this.dart == null) && this.cb == var1.length - 1) {
               this.E();
            }

            if (!this.me) {
               Object var8 = null;
               if (this.aQ != null) {
                  var8 = this.aQ;
               } else if (this.aU != null) {
                  var8 = this.aU;
               }

               if (var8 != null) {
                  if (ResLog.g(((IMapObject)var8).getX() - this.cx) < 10) {
                     if (((IMapObject)var8).getX() > this.cx) {
                        this.cx -= 10;
                     } else {
                        this.cx += 10;
                     }
                  }

                  if (((IMapObject)var8).getX() > this.cx) {
                     this.I = 1;
                     return;
                  }

                  this.I = -1;
               }
            }
         }

      }
   }

   public final void a(int var1, int var2) {
      InfoDlg.hide();
      ResLog.c("REST POINT x= " + var1 + " y= " + var2);
      this.bP = null;
      if (this.cy - var2 == 0) {
         this.cx = var1;
         bG = false;
         bH = false;
      } else {
         this.statusMe = 16;
         this.d = var1;
         this.G = var2;
         this.F = 0;
         myCharz().bD = var1;
         myCharz().bE = var2;
      }
   }

   private void ah() {
      InfoDlg.hide();
      main.GameCanvas.k();
      this.bP = null;
      ++this.F;
      this.cx += (this.d - this.cx) / 4;
      if (this.F > 7) {
         this.cy += (this.G - this.cy) / 4;
      } else {
         this.cy += this.F - 10;
      }

      if (ResLog.g(this.d - this.cx) < 4 && ResLog.g(this.G - this.cy) < 10) {
         this.cx = this.d;
         this.cy = this.G;
         this.statusMe = 1;
         this.G = 0;
         bG = false;
         Service.gI().g();
      }

      this.as = 23;
   }

   private void ai() {
      this.dM = 0;
      ++this.F;
      if (this.I == 1) {
         if ((TileMap.b(this.cx + this.am, this.cy - this.f) & 4) == 4) {
            this.D = 0;
         }
      } else if ((TileMap.b(this.cx - this.am, this.cy - this.f) & 8) == 8) {
         this.D = 0;
      }

      if (this.cy > this.al && TileMap.a(this.cx, this.cy - this.al + 24, 8192)) {
         if (!TileMap.a(this.cx, this.cy, 2)) {
            this.statusMe = 4;
            this.F = 0;
            this.d = 0;
            this.E = 1;
         } else {
            this.cy = TileMap.e(this.cy);
         }
      }

      this.cx += this.D;
      this.cy += this.E;
      if (this.cy < 0) {
         this.cy = this.E = 0;
      }

      if (this.E == 0) {
         if ((TileMap.b(this.cx, this.cy) & 2) != 2) {
            this.statusMe = 4;
            this.D = (this.O >> 1) * this.I;
            this.F = this.d = 0;
         }
      } else if (this.E < 0) {
         ++this.E;
         if (this.E == 0) {
            this.E = 1;
         }
      } else {
         if (this.E < 20 && this.F % 5 == 0) {
            ++this.E;
         }

         if (this.E > 3) {
            this.E = 3;
         }

         if ((TileMap.b(this.cx, this.cy + 3) & 2) == 2 && this.cy <= TileMap.f(this.cy + 3)) {
            this.D = this.E = 0;
            this.cy = TileMap.f(this.cy + 3);
         }
      }

      if (this.D > 0) {
         --this.D;
      } else {
         if (this.D < 0) {
            ++this.D;
         }

      }
   }

   private void aj() {
      this.bk = false;
      if (this.bl) {
         this.bl = false;
         SoundMn.stopAll();
         Service.gI().c((byte)3);
      }

      this.cx += this.D * this.I;
      this.cy += this.dC;
      ++this.dC;
      if (this.F == 0) {
         this.as = 7;
      } else {
         this.as = 23;
      }

      if (this.dC == -3) {
         this.as = 8;
      } else if (this.dC == -2) {
         this.as = 9;
      } else if (this.dC == -1) {
         this.as = 10;
      } else if (this.dC == 0) {
         this.as = 11;
      }

      if (this.dC == 0) {
         this.statusMe = 6;
         this.G = 0;
         ((nr_dj)this.bF.firstElement()).c = 4;
         this.F = 0;
         this.E = 1;
      }

   }

   public void k() {
      this.bR = true;
      EffecMn.addEff(new Effect(107, this.cx, this.cy + 25, 3, 15, 1));
   }

   public final void r() {
      this.bR = false;
      EffecMn.addEff(new Effect(107, this.cx, this.cy + 25, 3, 10, 1));
   }

   private void ak() {
      if (!main.GameCanvas.panel.isShow) {
         if (!this.cD) {
            if (!this.cJ) {
               if (!this.eE) {
                  if (!this.es && !this.et) {
                     if (!main.GameCanvas.a) {
                        if (this.cC != 1) {
                           if (this.me) {
                              if (!cU && this.idAuraEff >= 0) {
                                 return;
                              }
                           } else if (this.idAuraEff >= 0) {
                              return;
                           }

                           ++this.dM;
                           if (this.S < 14) {
                              if (this.S >= 9 && !main.GameCanvas.a && (this.dM == 40 || this.dM == 50)) {
                                 main.GameCanvas.a().a(-1, this.cx - -8, this.cy);
                                 main.GameCanvas.a().a(1, this.cx - 8, this.cy);
                                 this.e(1);
                              }

                              if (this.dM > 50 && this.S >= 9) {
                                 if (this.cgender == 0) {
                                    if (main.GameCanvas.v % 25 == 0) {
                                       ServerEffect.a(114, (Char)this, 1);
                                    }

                                    if (this.S >= 13 && main.GameCanvas.v % 4 == 0) {
                                       ServerEffect.a(132, (Char)this, 1);
                                    }
                                 }

                                 if (this.cgender == 1) {
                                    if (main.GameCanvas.v % 4 == 0) {
                                       ServerEffect.a(132, (Char)this, 1);
                                    }

                                    if (this.S >= 13 && main.GameCanvas.v % 7 == 0) {
                                       ServerEffect.a(131, (Char)this, 1);
                                    }
                                 }

                                 if (this.cgender == 2) {
                                    if (main.GameCanvas.v % 7 == 0) {
                                       ServerEffect.a(131, (Char)this, 1);
                                    }

                                    if (this.S >= 13 && main.GameCanvas.v % 25 == 0) {
                                       ServerEffect.a(114, (Char)this, 1);
                                    }
                                 }
                              }
                           }

                        }
                     }
                  }
               }
            }
         }
      }
   }

   private void al() {
      int var1 = this.cC == 1 && !this.me ? 2 : 1;
      if (this.cx >= GameScr.cmx && this.cx <= GameScr.cmx + main.GameCanvas.z) {
         if (this.cC == 0) {
            SoundMn.stopAll();
         } else {
            SoundMn.stopAll();
         }
      }

      this.dM = 0;
      this.bk = false;
      if (this.bl) {
         this.bl = false;
         SoundMn.stopAll();
         Service.gI().c((byte)3);
      }

      int var2 = 0;
      if (!this.me && this.bP != null) {
         var2 = c(this.cx - this.bP.a);
      }

      ++this.F;
      if (this.F >= 10) {
         this.F = 0;
         this.N = 0;
      }

      this.as = (this.F >> 1) + 2;
      if ((TileMap.b(this.cx, this.cy - 1) & 64) == 64) {
         this.cx += this.D * var1 >> 1;
      } else {
         this.cx += this.D * var1;
      }

      if (this.I == 1) {
         if (TileMap.a(this.cx + this.am, this.cy - this.f, 4)) {
            if (this.me) {
               this.D = 0;
               this.cx = TileMap.f(this.cx + this.am) - this.am;
            } else {
               this.am();
            }
         }
      } else if (TileMap.a(this.cx - this.am - 1, this.cy - this.f, 8)) {
         if (this.me) {
            this.D = 0;
            this.cx = TileMap.f(this.cx - this.am - 1) + TileMap.i + this.am;
         } else {
            this.am();
         }
      }

      if (this.me) {
         if (this.D > 0) {
            --this.D;
         } else if (this.D < 0) {
            ++this.D;
         } else {
            if (this.cx - this.bD != 0 && this.me) {
               Service.gI().g();
            }

            this.statusMe = 1;
            this.N = 0;
         }
      }

      if ((TileMap.b(this.cx, this.cy) & 2) != 2) {
         if (this.me) {
            if (this.cx - this.bD != 0 || this.cy - this.bE != 0) {
               Service.gI().g();
            }

            this.as = 7;
            this.statusMe = 4;
            this.bQ = 0;
            this.D = 3 * this.I;
            this.d = 0;
         } else {
            this.am();
         }
      }

      if (!this.me && this.bP != null && c(this.cx - this.bP.a) > var2) {
         this.am();
      }

      main.GameCanvas.a().a(this.I, this.cx - (this.I << 3), this.cy);
      this.ax();
      this.e(2);
   }

   private void am() {
      this.statusMe = 6;
      this.G = 0;
      this.D = 0;
      this.E = 0;
      this.F = this.d = 0;
   }

   private static int c(int var0) {
      return var0 > 0 ? var0 : -var0;
   }

   private void an() {
      this.at();
      this.e(3);
      this.dM = 0;
      this.bk = false;
      if (this.bl) {
         this.bl = false;
         SoundMn.stopAll();
         Service.gI().c((byte)3);
      }

      this.cx += this.D;
      this.cy += this.E;
      if (this.cy < 0) {
         this.cy = 0;
         this.E = -1;
      }

      ++this.E;
      if (this.E > 0) {
         this.E = 0;
      }

      if (!this.me && this.bP != null) {
         label93: {
            int var1;
            if ((var1 = this.bP.a - this.cx) > 0) {
               if (this.D > var1) {
                  this.D = var1;
               }

               if (this.D >= 0) {
                  break label93;
               }
            } else if (var1 < 0) {
               if (this.D < var1) {
                  this.D = var1;
               }

               if (this.D <= 0) {
                  break label93;
               }
            }

            this.D = var1;
         }
      }

      if (this.I == 1) {
         if ((TileMap.b(this.cx + this.am, this.cy - 1) & 4) == 4 && this.cx <= TileMap.f(this.cx + this.am) + 12) {
            this.cx = TileMap.f(this.cx + this.am) - this.am;
            this.D = 0;
         }
      } else if ((TileMap.b(this.cx - this.am, this.cy - 1) & 8) == 8 && this.cx >= TileMap.f(this.cx - this.am) + 12) {
         this.cx = TileMap.f(this.cx + 24 - this.am) + this.am;
         this.D = 0;
      }

      if (this.E == 0) {
         if (this.me) {
            this.ao();
         } else {
            this.am();
         }
      }

      if (this.me && !bG && this.ac()) {
         Service.gI().g();
         if (TileMap.b()) {
            bG = true;
            Service.gI().q();
         } else {
            Service.gI().f();
         }

         bH = true;
         bG = true;
         main.GameCanvas.f();
         main.GameCanvas.clearKeyPressed();
         InfoDlg.a();
      } else {
         if (this.statusMe != 16 && (TileMap.a(this.cx, this.cy - this.al + 24, 8192) || this.cy < 0)) {
            this.statusMe = 4;
            this.F = 0;
            this.d = 0;
            this.E = 1;
            this.bQ = 0;
            if (this.cy < 0) {
               this.cy = 0;
            }

            this.cy = TileMap.e(this.cy + 25);
            main.GameCanvas.f();
         }

         if (this.G < 0) {
            ++this.G;
         }

         this.as = 7;
         if (!this.me && this.bP != null && this.cy < this.bP.b) {
            this.am();
         }

      }
   }

   private void ao() {
      this.e = this.cy;
      this.F = 0;
      this.d = 0;
      this.statusMe = 10;
      this.D = this.I << 2;
      this.E = 0;
      this.cy = TileMap.e(this.cy) + 12;
      if (this.me && (this.cx - this.bD != 0 || this.cy - this.bE != 0) && (ResLog.g(myCharz().cx - myCharz().bD) > 96 || ResLog.g(myCharz().cy - myCharz().bE) > 24)) {
         Service.gI().g();
      }

   }

   private void ap() {
      if (!this.cH) {
         this.dM = 0;
         if (this.cy + 4 >= TileMap.d) {
            this.statusMe = 1;
            if (this.me) {
               SoundMn.stopAll();
            }

            this.D = this.E = 0;
            this.G = 0;
         } else {
            if (this.cy % 24 == 0 && (TileMap.b(this.cx, this.cy) & 2) == 2) {
               this.bQ = 0;
               if (this.me) {
                  if (this.cy - this.bE > 0 || this.cx - this.bD != 0 || this.cy - this.bE < 0) {
                     Service.gI().g();
                  }

                  this.D = this.E = 0;
                  this.F = this.d = 0;
                  this.statusMe = 1;
                  this.G = 0;
                  return;
               }

               this.am();
               this.as = 0;
               main.GameCanvas.a().a(-1, this.cx - -8, this.cy);
               main.GameCanvas.a().a(1, this.cx - 8, this.cy);
               this.e(1);
            }

            if (this.bQ > 0) {
               --this.bQ;
               if (this.bQ % 10 > 5) {
                  ++this.cy;
               } else {
                  --this.cy;
               }
            } else {
               if (this.E < -4) {
                  this.as = 7;
               } else {
                  this.as = 12;
               }

               this.cx += this.D;
               if (!this.me && this.bP != null) {
                  label132: {
                     int var1;
                     if ((var1 = this.bP.a - this.cx) > 0) {
                        if (this.D > var1) {
                           this.D = var1;
                        }

                        if (this.D >= 0) {
                           break label132;
                        }
                     } else if (var1 < 0) {
                        if (this.D < var1) {
                           this.D = var1;
                        }

                        if (this.D <= 0) {
                           break label132;
                        }
                     }

                     this.D = var1;
                  }
               }

               ++this.E;
               if (this.E > 8) {
                  this.E = 8;
               }

               if (this.skillPaintRandomPaint == null) {
                  this.cy += this.E;
               }

               if (this.I == 1) {
                  if ((TileMap.b(this.cx + this.am, this.cy - 1) & 4) == 4 && this.cx <= TileMap.f(this.cx + this.am) + 12) {
                     this.cx = TileMap.f(this.cx + this.am) - this.am;
                     this.D = 0;
                  }
               } else if ((TileMap.b(this.cx - this.am, this.cy - 1) & 8) == 8 && this.cx >= TileMap.f(this.cx - this.am) + 12) {
                  this.cx = TileMap.f(this.cx + 24 - this.am) + this.am;
                  this.D = 0;
               }

               if (this.E > 3 && (this.e == 0 || this.e <= TileMap.e(this.cy + 3)) && (TileMap.b(this.cx, this.cy + 3) & 2) == 2) {
                  if (this.me) {
                     this.e = 0;
                     this.D = this.E = 0;
                     this.F = this.d = 0;
                     this.cy = TileMap.f(this.cy + 3);
                     this.statusMe = 1;
                     if (this.me) {
                        SoundMn.stopAll();
                     }

                     this.G = 0;
                     main.GameCanvas.a().a(-1, this.cx - -8, this.cy);
                     main.GameCanvas.a().a(1, this.cx - 8, this.cy);
                     this.e(1);
                     if (this.cy - this.bE > 0) {
                        if (this.me) {
                           Service.gI().g();
                           return;
                        }
                     } else if ((this.cx - this.bD != 0 || this.cy - this.bE < 0) && this.me) {
                        Service.gI().g();
                        return;
                     }
                  } else {
                     this.am();
                     this.cy = TileMap.f(this.cy + 3);
                     this.as = 0;
                     main.GameCanvas.a().a(-1, this.cx - -8, this.cy);
                     main.GameCanvas.a().a(1, this.cx - 8, this.cy);
                     this.e(1);
                  }

               } else {
                  this.as = 12;
                  if (!this.me) {
                     if ((TileMap.b(this.cx, this.cy + 1) & 2) == 2) {
                        this.as = 0;
                     }

                     if (this.bP != null && this.cy > this.bP.b) {
                        this.am();
                     }
                  }

               }
            }
         }
      }
   }

   private void aq() {
      int var1 = this.cC == 1 && !this.me ? 2 : 1;
      this.at();
      if (this.statusMe == 16 || !TileMap.a(this.cx, this.cy - this.al + 24, 8192) && this.cy >= 0) {
         int var2 = this.cy;
         ++this.F;
         if (this.F >= 9) {
            this.F = 0;
            if (!this.me) {
               this.D = this.E = 0;
            }

            this.N = 0;
         }

         this.as = 8;
         if (ResLog.g(this.D) <= 4 && this.me) {
            if (this.bP != null) {
               int var3 = c(this.cx - this.bP.a);
               int var4 = c(this.cy - this.bP.b);
               if (var3 > var4 * 10) {
                  this.as = 8;
               } else if (var3 > var4 && var3 > 48 && var4 > 32) {
                  this.as = 8;
               } else {
                  this.as = 7;
               }
            } else {
               if (this.E < 0) {
                  this.E = 0;
               }

               if (this.E > 16) {
                  this.E = 16;
               }

               this.as = 7;
            }
         }

         if (!this.me) {
            if (c(this.D) < 2) {
               this.D = (this.I << 1) * var1;
            }

            if (this.E != 0) {
               this.as = 7;
            }

            if (c(this.D) <= 2) {
               ++this.d;
               if (this.d > 32) {
                  this.statusMe = 4;
                  this.D = 0;
                  this.E = 0;
               }
            }
         }

         if (this.I == 1) {
            if (TileMap.a(this.cx + this.am, this.cy - 1, 4)) {
               this.D = 0;
               this.cx = TileMap.f(this.cx + this.am) - this.am;
               if (this.E == 0) {
                  this.bP = null;
               }
            }
         } else if (TileMap.a(this.cx - this.am - 1, this.cy - 1, 8)) {
            this.D = 0;
            this.cx = TileMap.f(this.cx - this.am - 1) + TileMap.i + this.am;
            if (this.E == 0) {
               this.bP = null;
            }
         }

         this.cx += this.D * var1;
         this.cy += this.E * var1;
         if (!this.dy && var2 - this.cy == 0) {
            ++this.dM;
            ++this.dL;
            this.bS += !this.dK ? 1 : -1;
            if (this.dL == 10) {
               this.dL = 0;
               this.dK = !this.dK;
            }

            if (this.dM > 20) {
               this.bQ = 10;
               if (main.GameCanvas.v % 3 == 0) {
                  ServerEffect.a(111, this.cx + (this.I == 1 ? -17 : 27), this.cy + this.bS + 13, 1, this.I != 1 ? 2 : 0);
               }
            }
         }

         if (this.me) {
            if (this.D > 0) {
               --this.D;
            } else if (this.D < 0) {
               ++this.D;
            } else if (this.E == 0) {
               this.statusMe = 4;
               this.au();
               Service.gI().g();
            }

            if ((TileMap.b(this.cx, this.cy + 20) & 2) == 2 || (TileMap.b(this.cx, this.cy + 40) & 2) == 2) {
               if (this.E == 0) {
                  this.bQ = 0;
               }

               this.e = 0;
               this.D = this.E = 0;
               this.F = this.d = 0;
               this.statusMe = 4;
               this.e(3);
            }

            if (c(this.cx - this.bD) > 96 || c(this.cy - this.bE) > 24) {
               Service.gI().g();
            }
         }

      } else {
         if (this.cy - this.al < 0) {
            this.cy = this.al;
         }

         this.as = 7;
         this.statusMe = 4;
         this.D = 0;
         this.d = 0;
         this.bP = null;
      }
   }

   private void ar() {
      ++this.dm;
      if (this.dm > this.dl.length - 1) {
         this.dm = 0;
      }

      ++this.dn;
      if (this.dn > 1000) {
         this.dn = 0;
      }

      if (this.dx && !this.dy) {
         this.dr = this.cy;
         if (this._do == 0) {
            if (this.dq - this.cx >= this.dw) {
               this.dq -= this.dw;
               return;
            }

            this.dq = this.cx;
            this.dy = true;
            this.dz = false;
            return;
         }

         if (this._do == 2) {
            if (this.cx - this.dq >= this.dw) {
               this.dq += this.dw;
               return;
            }

            this.dq = this.cx;
            this.dy = true;
            this.dz = false;
            return;
         }
      } else {
         if (this.dy) {
            if ((this.statusMe == 14 || this.cm - this.cy < 24) && this.cm - this.cy < 24 && !this.dz) {
               this.dx = false;
               this.dy = false;
               this.dz = true;
               this.dv = 0;
            }

            if (this.F % 15 < 5) {
               this.as = 0;
            } else {
               this.as = 1;
            }

            this._do = this.I;
            this.ak();
            if (this._do < 0) {
               this._do = 0;
               this.ds = -20;
            } else if (this._do == 1) {
               this._do = 2;
               this.ds = -30;
               if (this.bw) {
                  this.ds = -38;
               }
            }

            if (this.D() != null) {
               this.dt = -15;
            } else {
               this.dt = -17;
            }

            this.dr = this.cy;
            this.dq = this.cx;
            return;
         }

         if (this.dz) {
            if (this._do == 0) {
               if (this.dq > GameScr.cmx - 100) {
                  this.dq -= 20;
                  return;
               }

               this.dx = false;
               this.dy = false;
               this.dz = false;
               return;
            }

            if (this._do == 2) {
               if (this.dq < GameScr.cmx + main.GameCanvas.z + 50) {
                  this.dq += 20;
                  return;
               }

               this.dx = false;
               this.dy = false;
               this.dz = false;
               return;
            }
         } else if (!this.dx || !this.dy || !this.dz) {
            this.dq = GameScr.cmx - 100;
            this.dr = GameScr.cmy - 100;
         }
      }

   }

   private static void as() {
      if (Mob.arrMobTemplate[50].data == null) {
         Mob.arrMobTemplate[50].data = new EffectData();
         String var0 = "/Mob/50";
         if ("".getClass().getResourceAsStream(var0) != null) {
            Mob.arrMobTemplate[50].data.a(var0 + "/data");
            Mob.arrMobTemplate[50].data.a = mSystem.load(var0 + "/img.png");
         } else {
            Service.gI().h((int)50);
         }

         Mob.K.addElement("50");
      }

   }

   public void checkFrameTick(int[] var1) {
      ++this.dN;
      if (this.dN > var1.length - 1) {
         this.dN = 0;
      }

      this.dO = var1[this.dN];
   }

   public final void b(mGraphics var1) {
      if (this.dq > GameScr.cmx && this.dq < GameScr.cmx + main.GameCanvas.z) {
         FrameImage var2;
         if (this.me) {
            if (this.dz || this.dx || this.dy) {
               if (this.bt >= bs) {
                  if ((var2 = mSystem.d(this.dQ + (this.bt - bs) + "_1")) != null) {
                     var2.a(this.dn / 2 % var2.c, this.dq, this.dr + this.bS, this._do, 3, var1);
                  }

                  return;
               }

               if (this.bx) {
                  this.checkFrameTick(this.dP);
                  if (Mob.arrMobTemplate[50] != null && Mob.arrMobTemplate[50].data != null) {
                     Mob.arrMobTemplate[50].data.a(var1, this.dO, this.dq + (this.I == 1 ? -8 : 8), this.dr + 35, this.I == 1 ? 0 : 1, 0);
                     return;
                  }

                  as();
                  return;
               }

               if (this.bw) {
                  var1.setColor(dj, 0, this.dl[this.dm] * 60, 60, 60, this._do, this.dq + this.ds, this.dr + this.dt + this.bS, 0);
                  return;
               }

               if (this.dp == 0) {
                  if (!this.bv) {
                     var1.setColor(n, 0, this.dl[this.dm] * 40, 50, 40, this._do, this.dq + this.ds, this.dr + this.dt + this.bS, 0);
                     return;
                  }

                  var1.setColor(df, 0, this.dl[this.dm] * 40, 50, 40, this._do, this.dq + this.ds, this.dr + this.dt + this.bS, 0);
                  return;
               }

               if (this.dp == 1) {
                  if (!this.bv) {
                     var1.setColor(dd, 0, this.dl[this.dm] * 40, 50, 40, this._do, this.dq + this.ds, this.dr + this.dt + this.bS, 0);
                     return;
                  }

                  var1.setColor(dh, 0, this.dl[this.dm] * 40, 50, 40, this._do, this.dq + this.ds, this.dr + this.dt + this.bS, 0);
                  return;
               }
            }
         } else if (!this.me) {
            if (this.bt >= bs) {
               if ((var2 = mSystem.d(this.dQ + (this.bt - bs) + "_1")) != null) {
                  var2.a(this.dn / 2 % var2.c, this.dq, this.dr + this.bS, this._do, 3, var1);
               }

               return;
            }

            if (this.bx) {
               this.checkFrameTick(this.dP);
               if (Mob.arrMobTemplate[50] != null && Mob.arrMobTemplate[50].data != null) {
                  Mob.arrMobTemplate[50].data.a(var1, this.dO, this.dq + (this.I == 1 ? -8 : 8), this.dr + 35, this.I == 1 ? 0 : 1, 0);
                  return;
               }

               as();
               return;
            }

            if (this.bw) {
               var1.setColor(dj, 0, this.dl[this.dm] * 60, 60, 60, this._do, this.dq + this.ds, this.dr + this.dt + this.bS, 0);
               return;
            }

            if (this.dy) {
               if (this.dp == 0) {
                  if (!this.bv) {
                     var1.setColor(n, 0, this.dl[this.dm] * 40, 50, 40, this._do, this.dq + this.ds, this.dr + this.dt + this.bS, 0);
                     return;
                  }

                  var1.setColor(df, 0, this.dl[this.dm] * 40, 50, 40, this._do, this.dq + this.ds, this.dr + this.dt + this.bS, 0);
                  return;
               }

               if (this.dp == 1) {
                  if (!this.bv) {
                     var1.setColor(dd, 0, this.dl[this.dm] * 40, 50, 40, this._do, this.dq + this.ds, this.dr + this.dt + this.bS, 0);
                     return;
                  }

                  var1.setColor(dh, 0, this.dl[this.dm] * 40, 50, 40, this._do, this.dq + this.ds, this.dr + this.dt + this.bS, 0);
               }
            }
         }
      }

   }

   private void at() {
      if (this.me) {
         boolean var2 = false;
         short var3 = -1;
         Item[] var4 = this.arrItemBody;

         for(int var5 = 0; var5 < var4.length; ++var5) {
            if (var4[var5] != null && (var4[var5].template.type == 24 || var4[var5].template.type == 23)) {
               if (var4[var5].template.part >= 0) {
                  var3 = (short)(bs + var4[var5].template.part);
               } else {
                  var3 = var4[var5].template.a;
               }

               var2 = true;
               break;
            }
         }

         this.bv = false;
         this.bx = false;
         this.bw = false;
         this.bt = -1;
         if (var3 != 349 && var3 != 350 && var3 != 351) {
            if (var3 == 396) {
               this.bw = true;
            } else if (var3 == 532) {
               this.bx = true;
            } else if (var3 >= bs) {
               this.bt = var3;
            }
         } else {
            this.bv = true;
         }

         this.bu = var2;
         if (TileMap.a()) {
            this.bu = false;
         }
      }

      if (this.bu) {
         if (this.cm - this.cy <= 20) {
            this.du = this.cx;
         }

         if (this.dv < 100) {
            this.dv = ResLog.g(this.du - this.cx);
         }

         if (this.dv >= 70 && this.cm - this.cy > 30 && !this.dx && !this.dz) {
            int var7 = this.cgender;
            int var8 = this.I;
            int var6 = this.charID;
            this._do = var8;
            this.dp = var7;
            this.dw = 30;
            if (this._do < 0) {
               this._do = 0;
               this.dq = GameScr.cmx + main.GameCanvas.z + 50;
               this.ds = -20;
            } else if (this._do == 1) {
               this._do = 2;
               this.dq = GameScr.cmx - 100;
               this.ds = -30;
            }

            this.dt = -17;
            this.dr = this.cy;
            this.dm = 0;
            this.dn = 0;
            this.dy = false;
            this.dz = false;
            this.dx = true;
         }
      }

   }

   private void au() {
      boolean var1 = true;

      for(int var2 = 0; var2 < 150; var2 += 24) {
         if ((TileMap.b(this.cx, this.cy + var2) & 2) == 2 || this.cy + var2 > TileMap.b * TileMap.i - 24) {
            var1 = false;
            break;
         }
      }

      if (var1) {
         this.bQ = 40;
      }

   }

   public final void setDefaultPart() {
      this.setDefaultWeapon();
      this.setDefaultBody();
      this.setDefaultLeg();
   }

   public final void setDefaultWeapon() {
      if (this.cgender == 0) {
         this.bY = 0;
      }

   }

   public final void setDefaultBody() {
      if (this.cgender == 0) {
         this.body = 57;
      } else if (this.cgender == 1) {
         this.body = 59;
      } else {
         if (this.cgender == 2) {
            this.body = 57;
         }

      }
   }

   public final void setDefaultLeg() {
      if (this.cgender == 0) {
         this.leg = 58;
      } else if (this.cgender == 1) {
         this.leg = 60;
      } else {
         if (this.cgender == 2) {
            this.leg = 58;
         }

      }
   }

   public final boolean w() {
      return this.myskill != null && this.myskill.template.b();
   }

   public final boolean x() {
      return this.myskill != null && this.myskill.template.c();
   }

   public final boolean y() {
      return this.myskill != null && this.myskill.template.a();
   }

   public final boolean z() {
      return !this.ch && this.myskill != null && (this.myskill.template.id == 10 || this.myskill.template.id == 11);
   }

   public final void a(SkillPaint var1, int var2) {
      this.ek = false;
      if (!this.cP) {
         if (!this.me || this.myskill.template.id != 9 || this.cHP > this.cHPFull / 10) {
            if (this.me) {
               if (this.aQ == null && this.aU == null) {
                  this.C();
               }

               if (this.aQ != null && (this.aQ.p == 1 || this.aQ.p == 0)) {
                  this.C();
               }

               if (this.aU != null && (this.aU.statusMe == 14 || this.aU.statusMe == 5)) {
                  this.C();
               }

               if (this.myskill.template.id == 23) {
                  if (this.aU != null && this.aU.cG != 0) {
                     return;
                  }

                  if (this.aQ != null && this.aQ.j != 0) {
                     return;
                  }

                  if (this.cG != 0) {
                     return;
                  }
               }

               if (this.cO || this.cM) {
                  return;
               }
            }

            if (!this.me || this.dart == null) {
               if (!TileMap.d()) {
                  long var3 = System.currentTimeMillis();
                  if (this.me) {
                     if (this.y() && this.aU == null) {
                        return;
                     }

                     if (var3 - this.myskill.f < (long)this.myskill.e) {
                        this.myskill.j = true;
                        return;
                     }

                     this.myskill.f = var3;
                     if (this.myskill.template.d == 2) {
                        this.cMP = 1;
                     } else if (this.myskill.template.d != 1) {
                        this.cMP -= this.myskill.i;
                     } else {
                        this.cMP -= this.myskill.i * this.cMPFull / 100;
                     }

                     --myCharz().cStamina;
                     GameScr.gI().bA = true;
                     GameScr.gI().bz = 0;
                     if (this.cMP < 0) {
                        this.cMP = 0;
                     }
                  }

                  if (this.me) {
                     if (this.myskill.template.id == 7) {
                        SoundMn.stopAll();
                     }

                     if (this.myskill.template.id == 6) {
                        Service.gI().c((byte)0);
                        GameScr.gI().aZ = true;
                        SoundMn.stopAll();
                     }

                     if (this.myskill.template.id == 8) {
                        if (!this.bl) {
                           SoundMn.stopAll();
                           Service.gI().c((byte)1);
                           this.bl = true;
                           this.bo = this.m = System.currentTimeMillis();
                        } else {
                           Service.gI().c((byte)3);
                           this.bl = false;
                           SoundMn.stopAll();
                        }
                     }

                     if (this.myskill.template.id == 13) {
                        if (this.cC != 0) {
                           GameScr.gI().aW = 0;
                           return;
                        }

                        if (this.isCreateDark) {
                           return;
                        }

                        SoundMn.stopAll();
                        Service.gI().c((byte)6);
                        this.ej = 0;
                        this.cE = true;
                        return;
                     }

                     if (this.myskill.template.id == 14) {
                        SoundMn.stopAll();
                        Service.gI().c((byte)7);
                        this.b(true);
                     }

                     if (this.myskill.template.id == 21) {
                        Service.gI().c((byte)10);
                        return;
                     }

                     if (this.myskill.template.id == 12) {
                        Service.gI().c((byte)8);
                     }

                     if (this.myskill.template.id == 19) {
                        Service.gI().c((byte)9);
                        return;
                     }
                  }

                  if (this.cC == 1 && var1.a >= 35 && var1.a <= 41) {
                     var1 = GameScr.u[106];
                  }

                  if (var1.a >= 128 && var1.a <= 134) {
                     var1 = GameScr.u[var1.a - 65];
                     if (this.aU != null) {
                        this.cx = this.aU.cx;
                        this.cy = this.aU.cy;
                        this.bP = null;
                     }

                     if (this.aQ != null) {
                        this.cx = this.aQ.x;
                        this.cy = this.aQ.y;
                        this.bP = null;
                     }

                     ServerEffect.addServerEffect(60, this.cx, this.cy, 1);
                     this.cN = true;
                  }

                  if (var1.a >= 107 && var1.a <= 113) {
                     var1 = GameScr.u[var1.a - 44];
                     EffecMn.addEff(new Effect(23, this.cx, this.cy + this.al / 2, 3, 2, 1));
                  }

                  this.b(var1, var2);
               }
            }
         }
      }
   }

   public static void A() {
      GameScr.gI().aW = 0;
      myCharz().a(GameScr.u[myCharz().myskill.b], TileMap.a(myCharz().cx, myCharz().cy, 2) ? 0 : 1);
   }

   public final void B() {
      if (!this.me || !this.bk && !this.t) {
         long var1 = System.currentTimeMillis();
         if (this.me && var1 - this.myskill.f < (long)this.myskill.e) {
            this.myskill.j = true;
         } else {
            if (this.myskill.template.id == 10) {
               this.b(false);
            }

            if (this.myskill.template.id == 11) {
               this.b(true);
            }

         }
      } else {
         GameScr.gI().aW = 0;
      }
   }

   public final void C() {
      this.ci = false;
      this.cj = false;
      this.ch = false;
      this.isCreateDark = false;
      if (this.me && this.statusMe != 14 && this.statusMe != 5) {
         this.bJ = false;
      }

      GameScr.gI().aW = 0;
   }

   public final void b(boolean var1) {
      if (!this.isCreateDark) {
         GameScr.gI().aW = 0;
         if (var1) {
            if (!this.cj) {
               this.ej = 0;
               this.bm = 50000;
               this.ei = 0;
               this.bo = System.currentTimeMillis();
               if (this.me) {
                  this.bJ = true;
                  if (this.cgender == 1) {
                     Service.gI().c((byte)4);
                  }
               }

               if (this.cgender == 1) {
                  SoundMn.stopAll();
               }

               this.cj = true;
               return;
            }
         } else if (!this.ci) {
            if (this.me) {
               GameScr.gI().aW = 0;
               this.bJ = true;
               Service.gI().c((byte)4);
            }

            this.ch = false;
            this.ej = 0;
            this.ci = true;
            this.ei = 0;
            this.bm = 50000;
         }

      }
   }

   public final void b(SkillPaint var1, int var2) {
      this.skillPaint = var1;
      int var3;
      if (var1.a >= 0 && var1.a <= 6) {
         if ((var3 = ResLog.random(0, var1.a + 4) - 1) < 0) {
            var3 = 0;
         }

         if (var3 > 6) {
            var3 = 6;
         }

         this.skillPaintRandomPaint = GameScr.u[var3];
      } else if (var1.a >= 14 && var1.a <= 20) {
         if ((var3 = ResLog.random(0, var1.a - 14 + 4) - 1) < 0) {
            var3 = 0;
         }

         if (var3 > 6) {
            var3 = 6;
         }

         this.skillPaintRandomPaint = GameScr.u[var3 + 14];
      } else if (var1.a >= 28 && var1.a <= 34) {
         if ((var3 = ResLog.random(0, (this.cC == 1 ? 105 : var1.a) - (this.cC == 1 ? 105 : 28) + 4) - 1) < 0) {
            var3 = 0;
         }

         if (var3 > 6) {
            var3 = 6;
         }

         if (this.cC == 1) {
            var3 = 0;
         }

         this.skillPaintRandomPaint = GameScr.u[var3 + (this.cC == 1 ? 105 : 28)];
      } else if (var1.a >= 63 && var1.a <= 69) {
         if ((var3 = ResLog.random(0, var1.a - 63 + 4) - 1) < 0) {
            var3 = 0;
         }

         if (var3 > 6) {
            var3 = 6;
         }

         this.skillPaintRandomPaint = GameScr.u[var3 + 63];
      } else if (var1.a >= 107 && var1.a <= 109) {
         if ((var3 = ResLog.random(0, var1.a - 107 + 4) - 1) < 0) {
            var3 = 0;
         }

         if (var3 > 6) {
            var3 = 6;
         }

         this.skillPaintRandomPaint = GameScr.u[var3 + 107];
      } else {
         this.skillPaintRandomPaint = var1;
      }

      this.eg = var2;
      this.cb = 0;
      this.dT = this.dU = this.dV = this.dW = this.dX = this.dY = this.dZ = this.ea = this.eb = 0;
      this.eff0 = null;
      this.eff1 = null;
      this.eff2 = null;
      this.E = 0;
   }

   public final nr_f[] D() {
      if (this.skillPaint == null) {
         return null;
      } else if (this.skillPaintRandomPaint == null) {
         return null;
      } else {
         return this.eg == 0 ? this.skillPaintRandomPaint.c : this.skillPaintRandomPaint.d;
      }
   }

   public final void E() {
      SkillPaint var1;
      if (this.me) {
         var1 = this.skillPaintRandomPaint;
         if (this.dart != null) {
            var1 = this.dart.a;
         }

         if (var1 != null) {
            MyVector var2 = new MyVector("vMob");
            MyVector var3 = new MyVector("vChar");
            if (this.aU != null) {
               var3.addElement(this.aU);
            } else if (this.aQ != null) {
               var2.addElement(this.aQ);
            }

            this.ef = new EffectPaint[var2.size() + var3.size()];

            int var4;
            for(var4 = 0; var4 < var2.size(); ++var4) {
               this.ef[var4] = new EffectPaint();
               this.ef[var4].d = GameScr.y[var1.b - 1];
               if (!this.w()) {
                  this.ef[var4].b = (Mob)var2.elementAt(var4);
               }
            }

            for(var4 = 0; var4 < var3.size(); ++var4) {
               this.ef[var4 + var2.size()] = new EffectPaint();
               this.ef[var4 + var2.size()].d = GameScr.y[var1.b - 1];
               this.ef[var4 + var2.size()].c = (Char)var3.elementAt(var4);
            }

            byte var6 = 0;
            if (this.aQ != null) {
               var6 = 1;
            } else if (this.aU != null) {
               var6 = 2;
            }

            if (var2.size() == 0 && var3.size() == 0) {
               this.C();
            }

            if (this.me && !this.w() && !this.ek) {
               Service.gI().a(var2, var3, var6);
               this.ek = true;
               return;
            }
         }
      } else {
         var1 = this.skillPaintRandomPaint;
         if (this.dart != null) {
            var1 = this.dart.a;
         }

         if (var1 != null) {
            int var5;
            if (this.aX != null) {
               this.ef = new EffectPaint[this.aX.length];

               for(var5 = 0; var5 < this.aX.length; ++var5) {
                  this.ef[var5] = new EffectPaint();
                  this.ef[var5].d = GameScr.y[var1.b - 1];
                  this.ef[var5].b = this.aX[var5];
               }

               this.aX = null;
               return;
            }

            if (this.aY != null) {
               this.ef = new EffectPaint[this.aY.length];

               for(var5 = 0; var5 < this.aY.length; ++var5) {
                  this.ef[var5] = new EffectPaint();
                  this.ef[var5].d = GameScr.y[var1.b - 1];
                  this.ef[var5].c = this.aY[var5];
               }

               this.aY = null;
            }
         }
      }

   }

   public final boolean F() {
      if (this.cx < GameScr.cmx) {
         return true;
      } else {
         return this.cx > GameScr.cmx + GameScr.d;
      }
   }

   public final boolean G() {
      if (this.cy < GameScr.cmy) {
         return false;
      } else if (this.cy > GameScr.cmy + GameScr.e + 30) {
         return false;
      } else if (this.F()) {
         return false;
      } else if (this.eE) {
         return false;
      } else {
         return !this.cJ;
      }
   }

   public final void a(int var1, int var2, int var3) {
      this.a = var1;
      this.b = var2;
      this.c = 10;
   }

   public final void c(boolean var1) {
      this.ck = var1;
   }

   public void a(mGraphics var1) {
      if (!this.bR) {
         if (this.cZ) {
            this.g(var1);
         } else if (this.ck) {
            if (this.ap) {
               GameScr.l = this.cx - GameScr.f;
               GameScr.m = this.cy - GameScr.g - 1;
               if (!main.GameCanvas.f) {
                  GameScr.l += GameScr.i * this.I;
               }
            }

         } else if (this.G()) {
            int var4;
            int var5;
            int var6;
            if (this.v != null) {
               PetFollow var2 = this.v;
               var4 = 32;
               var5 = 32;
               var6 = main.GameCanvas.v % 10 > 5 ? 1 : 0;
               if (var2.l > 0) {
                  var4 = var2.m;
                  var5 = var2.n;
                  var6 = 0;
               }

               SmallImage.drawSmallImage(var1, var2.a, var2.c, var2.i, var2.e + 3 + var6, var4, var5, var2.b == 1 ? 0 : 2, StaticObj.f);
            }

            FrameImage var10;
            if (this.dq > GameScr.cmx && this.dq < GameScr.cmx + main.GameCanvas.z) {
               if (this.me) {
                  if (this.dz || this.dx || this.dy) {
                     if (this.bt >= bs) {
                        if ((var10 = mSystem.d(this.dQ + (this.bt - bs) + "_0")) != null) {
                           var10.a(this.dn / 2 % var10.c, this.dq, this.dr + this.bS, this._do, 3, var1);
                        }
                     } else if (!this.bx) {
                        if (this.bw) {
                           var1.setColor(dk, 0, this.dl[this.dm] * 60, 60, 60, this._do, this.dq + this.ds, this.dr + this.dt + this.bS, 0);
                        } else if (this.dp == 2) {
                           if (!this.bv) {
                              var1.setColor(de, 0, this.dl[this.dm] * 40, 50, 40, this._do, this.dq + this.ds, this.dr + this.dt + this.bS, 0);
                           } else {
                              var1.setColor(di, 0, this.dl[this.dm] * 40, 50, 40, this._do, this.dq + this.ds, this.dr + this.dt + this.bS, 0);
                           }
                        } else if (this.dp == 1) {
                           if (!this.bv) {
                              var1.setColor(dc, 0, this.dl[this.dm] * 40, 50, 40, this._do, this.dq + this.ds, this.dr + this.dt + this.bS, 0);
                           } else {
                              var1.setColor(dg, 0, this.dl[this.dm] * 40, 50, 40, this._do, this.dq + this.ds, this.dr + this.dt + this.bS, 0);
                           }
                        }
                     }
                  }
               } else if (!this.me) {
                  if (this.bt >= bs) {
                     if ((var10 = mSystem.d(this.dQ + (this.bt - bs) + "_0")) != null) {
                        var10.a(this.dn / 2 % var10.c, this.dq, this.dr + this.bS, this._do, 3, var1);
                     }
                  } else if (!this.bx) {
                     if (this.bw) {
                        var1.setColor(dk, 0, this.dl[this.dm] * 60, 60, 60, this._do, this.dq + this.ds, this.dr + this.dt + this.bS, 0);
                     } else if (this.dy) {
                        if (this.dp == 2) {
                           if (!this.bv) {
                              var1.setColor(de, 0, this.dl[this.dm] * 40, 50, 40, this._do, this.dq + this.ds, this.dr + this.dt + this.bS, 0);
                           } else {
                              var1.setColor(di, 0, this.dl[this.dm] * 40, 50, 40, this._do, this.dq + this.ds, this.dr + this.dt + this.bS, 0);
                           }
                        } else if (this.dp == 1) {
                           if (!this.bv) {
                              var1.setColor(dc, 0, this.dl[this.dm] * 40, 50, 40, this._do, this.dq + this.ds, this.dr + this.dt + this.bS, 0);
                           } else {
                              var1.setColor(dg, 0, this.dl[this.dm] * 40, 50, 40, this._do, this.dq + this.ds, this.dr + this.dt + this.bS, 0);
                           }
                        }
                     }
                  }
               }
            }

            if (!TileMap.f() || this.cy < TileMap.d - 48) {
               if (!this.s) {
                  if (this.cH && main.GameCanvas.v % 2 == 0) {
                     var1.setColor(16185600);
                     if (this.eB != null) {
                        var1.setColor(this.cx, this.cy - this.al / 2, this.eB.cx, this.eB.cy - this.eB.al / 2);
                     }

                     if (this.eC != null) {
                        var1.setColor(this.cx, this.cy - this.al / 2, this.eC.x, this.eC.y - this.eC.w / 2);
                     }
                  }

                  Small var12;
                  label547: {
                     if (this.me) {
                        if (!cU && this.idAuraEff >= 0) {
                           break label547;
                        }
                     } else if (this.idAuraEff >= 0) {
                        break label547;
                     }

                     if (cV && (this.statusMe == 1 || this.statusMe == 6) && !main.GameCanvas.panel.isShow && mSystem.currentTimeMillis() - this.el > 0L && !this.cD && this.S >= 16) {
                        short var9 = 7598;
                        if (this.S >= 19) {
                           var9 = 7676;
                        }

                        if (this.S >= 22) {
                           var9 = 7677;
                        }

                        if (this.S >= 25) {
                           var9 = 7678;
                        }

                        if (var9 != -1) {
                           if ((var12 = SmallImage.c[var9]) == null) {
                              SmallImage.createImage(var9);
                           } else {
                              var4 = main.GameCanvas.v / 4 % 4 * (mGraphics.b(var12.a) / 4);
                              var1.setColor(var12.a, 0, var4, mGraphics.setColor(var12.a), mGraphics.b(var12.a) / 4, 0, this.cx, this.cy + 2, 33);
                           }
                        }
                     }
                  }

                  if ((!this.me || !cU) && this.idAuraEff >= 0 && (this.statusMe == 1 || this.statusMe == 6) && !main.GameCanvas.panel.isShow && mSystem.currentTimeMillis() - this.el > 0L && (var10 = mSystem.d(this.eV + this.idAuraEff + "_0")) != null) {
                     var10.a(main.GameCanvas.v / 4 % var10.c, this.cx, this.cy, this.I == 1 ? 0 : 2, 33, var1);
                  }

                  this.h(var1);
                  if (this.idEff_Set_Item != -1) {
                     if (this.eW != null) {
                        this.eW.a(main.GameCanvas.v / 4 % this.eW.c, this.cx, this.cy + 3, this.I == 1 ? 0 : 2, 33, var1);
                     } else {
                        this.eW = mSystem.d(this.eY + this.idEff_Set_Item + "_0");
                     }
                  }

                  this.e(var1);
                  if (this.c > 0) {
                     if (main.GameCanvas.v % 2 == 0) {
                        this.a(var1, this.a, this.b, this.I, 25, true);
                     } else if (this.c > 5) {
                        this.a(var1, this.a, this.b, this.I, 7, true);
                     }
                  }

                  if (this.G() || this.skillPaint == null || this.skillPaint.a >= 70 && this.skillPaint.a <= 76 || this.skillPaint.a >= 77 && this.skillPaint.a <= 83) {
                     if (this.statusMe != 15 && (this.aZ == null || this.aZ[0] <= 0)) {
                        Rms var11 = GameScr.x[this.h(this.head)];
                        var5 = bC[this.as][0][2] - var11.a[bC[this.as][0][0]].c + 5;
                        boolean var14;
                        if ((!this.bc || this.me) && (this.me || TileMap.l != 113 || this.cy < 360)) {
                           if (this.me) {
                              var5 += 5;
                              this.a(var1, this.cx, this.cy - var5 + 3);
                           } else {
                              boolean var13 = dA.clan != null && this.ah == dA.clan.a;
                              var14 = this.cTypePk == 3 || this.cTypePk == 5;
                              boolean var7 = this.cTypePk == 4;
                              if (this.cName.startsWith("$")) {
                                 this.cName = this.cName.substring(1);
                                 this.es = true;
                              }

                              if (this.cName.startsWith("#")) {
                                 this.cName = this.cName.substring(1);
                                 this.et = true;
                              }

                              if (myCharz().aU != null && myCharz().aU.equals(this)) {
                                 var5 += 5;
                                 this.a(var1, this.cx, this.cy - var5 + 3);
                              }

                              var5 += mFont.k.getWidth();
                              mFont var8 = mFont.H;
                              if (!this.es && !this.et) {
                                 if (var14) {
                                    var8 = mFont.B;
                                 } else if (var7) {
                                    var8 = mFont.C;
                                 } else if (var13) {
                                    var8 = mFont.D;
                                 }
                              } else {
                                 var8 = mFont.J;
                              }

                              if ((this.i || var14 || var7) && !var13) {
                                 if (mSystem.d == 1) {
                                    var8.drawString(var1, this.cName, this.cx, this.cy - var5, 2, mFont.E);
                                 } else if (this.charID == -83) {
                                    var8.drawString(var1, this.cName, this.cx, this.cy - var5, 2, mFont.E);
                                 } else {
                                    var8.drawStringBd(var1, this.cName, this.cx, this.cy - var5, 2);
                                 }

                                 var5 += mFont.k.getWidth();
                              }

                              if (var13) {
                                 if (myCharz().aU != null && myCharz().aU.equals(this)) {
                                    var8.drawString(var1, this.cName, this.cx, this.cy - var5, 2, mFont.E);
                                 } else if (this.aU == null) {
                                    var8.drawString(var1, this.cName, this.cx - 10, this.cy - var5 + 3, 0, mFont.o);
                                    this.a(var1, this.cx - 16, this.cy - var5 + 10);
                                 }
                              }
                           }
                        }

                        if (this.skillPaint == null || this.D() == null || this.cb >= this.D().length) {
                           this.g(var1);
                        }

                        if (this.arr != null) {
                           this.arr.a(var1);
                        }

                        if (this.dart != null) {
                           this.dart.a(var1);
                        }

                        this.f(var1);
                        this.b(var1);
                        if (this.idEff_Set_Item != -1) {
                           if (this.eX != null) {
                              this.eX.a(main.GameCanvas.v / 4 % this.eX.c, this.cx, this.cy + 8, this.I == 1 ? 0 : 2, 33, var1);
                           } else {
                              this.eX = mSystem.d(this.eY + this.idEff_Set_Item + "_1");
                           }
                        }

                        label448: {
                           if (this.me) {
                              if (!cU && this.idAuraEff >= 0) {
                                 break label448;
                              }
                           } else if (this.idAuraEff >= 0) {
                              break label448;
                           }

                           if (cV) {
                              if (this.statusMe != 1 && this.statusMe != 6) {
                                 this.el = mSystem.currentTimeMillis() + 1500L;
                                 this.en = true;
                                 this.eo = true;
                              } else if (!main.GameCanvas.panel.isShow && mSystem.currentTimeMillis() - this.el > 0L) {
                                 if (this.cD) {
                                    if (main.GameCanvas.v % 2 == 0) {
                                       ++this.em;
                                    }

                                    if (this.em > 6) {
                                       this.em = 0;
                                    }

                                    var1.drawImage(main.GameCanvas.S[this.em], this.cx, this.cy + 9, 33);
                                 } else {
                                    if (this.S >= 14 && !main.GameCanvas.a) {
                                       var14 = false;
                                       if (mSystem.currentTimeMillis() - this.el > -1000L && this.en) {
                                          var14 = true;
                                          this.en = false;
                                       }

                                       if (mSystem.currentTimeMillis() - this.el > -500L && this.eo) {
                                          var14 = true;
                                          this.eo = false;
                                       }

                                       if (var14) {
                                          main.GameCanvas.a().a(-1, this.cx - -8, this.cy);
                                          main.GameCanvas.a().a(1, this.cx - 8, this.cy);
                                          this.e(1);
                                       }
                                    }

                                    if (this.S == 14) {
                                       if (main.GameCanvas.v % 2 == 0) {
                                          ++this.em;
                                       }

                                       if (this.em > 6) {
                                          this.em = 0;
                                       }

                                       var1.drawImage(main.GameCanvas.R[this.em], this.cx, this.cy + 9, 33);
                                    } else if (this.S == 15) {
                                       if (main.GameCanvas.v % 2 == 0) {
                                          ++this.em;
                                       }

                                       if (this.em > 6) {
                                          this.em = 0;
                                       }

                                       var1.drawImage(main.GameCanvas.S[this.em], this.cx, this.cy + 9, 33);
                                    } else if (this.S >= 16) {
                                       short var16 = -1;
                                       if (this.S >= 16 && this.S < 22) {
                                          var16 = 7599;
                                       }

                                       if (var16 != -1) {
                                          if ((var12 = SmallImage.c[7599]) == null) {
                                             SmallImage.createImage(7599);
                                          } else {
                                             var4 = main.GameCanvas.v / 4 % 4 * (mGraphics.b(var12.a) / 4);
                                             var1.setColor(var12.a, 0, var4, mGraphics.setColor(var12.a), mGraphics.b(var12.a) / 4, 0, this.cx, this.cy + 2, 33);
                                          }
                                       }
                                    }
                                 }
                              }
                           }
                        }

                        if ((!this.me || cU) && this.idAuraEff >= 0) {
                           if (this.statusMe != 1 && this.statusMe != 6) {
                              this.el = mSystem.currentTimeMillis() + 1500L;
                              this.en = true;
                              this.eo = true;
                           } else if (!main.GameCanvas.panel.isShow && !main.GameCanvas.a) {
                              var14 = false;
                              if (mSystem.currentTimeMillis() - this.el > -1000L && this.en) {
                                 var14 = true;
                                 this.en = false;
                              }

                              if (mSystem.currentTimeMillis() - this.el > -500L && this.eo) {
                                 var14 = true;
                                 this.eo = false;
                              }

                              if (var14) {
                                 main.GameCanvas.a().a(-1, this.cx - -8, this.cy);
                                 main.GameCanvas.a().a(1, this.cx - 8, this.cy);
                                 this.e(1);
                              }

                              FrameImage var15;
                              if (mSystem.currentTimeMillis() - this.el > 0L && (var15 = mSystem.d(this.eV + this.idAuraEff + "_1")) != null) {
                                 var15.a(main.GameCanvas.v / 4 % var15.c, this.cx, this.cy + 2, this.I == 1 ? 0 : 2, 33, var1);
                              }
                           }
                        }

                        this.i(var1);
                        if (!this.cY && this.bA != 0 && this.bB != 0 && this.statusMe != 14) {
                           byte var17 = 0;
                           var5 = this.cx - 30;
                           var6 = this.cy - 15;
                           if (ResLog.g(this.cy - this.bB) > 150) {
                              if (this.cy > this.bB) {
                                 var17 = 7;
                                 var5 = this.cx;
                                 var6 = this.cy - 15 - 60;
                              } else {
                                 var17 = 5;
                                 var5 = this.cx;
                                 var6 = this.cy - 15 + 60;
                              }
                           } else if (this.cx > this.bA) {
                              var17 = 2;
                           } else if (this.cx <= this.bA) {
                              var5 = this.cx + 30;
                           }

                           if (main.GameCanvas.v % 10 >= 5) {
                              if (ResLog.g(this.cx - this.bA) > 100) {
                                 var1.setColor(GameScr.bv, 0, 0, 13, 16, var17, var5, var6, StaticObj.f);
                                 return;
                              }

                              var1.drawImage(Panel.i, this.bA, this.bB - 60 + -10, 0);
                           }
                        }

                     }
                  } else {
                     if (this.skillPaint != null) {
                        this.cb = this.D().length;
                        this.skillPaint = null;
                     }

                     this.ef = null;
                     this.eff = null;
                     this.effTask = null;
                     this.indexEff = -1;
                     this.indexEffTask = -1;
                  }
               }
            }
         }
      }
   }

   private void e(mGraphics var1) {
      for(int var2 = 0; var2 < this.vEff.size(); ++var2) {
         Effect var3;
         if ((var3 = (Effect)this.vEff.elementAt(var2)).a >= 201) {
            var3.a(var1);
         }
      }

   }

   private void f(mGraphics var1) {
      if (this.ef != null) {
         for(int var2 = 0; var2 < this.ef.length; ++var2) {
            if (this.ef[var2] != null) {
               if (this.ef[var2].b != null) {
                  int var3 = this.ef[var2].b.y;
                  if (this.ef[var2].b instanceof BigBoss) {
                     var3 = this.ef[var2].b.y - 60;
                  }

                  if (this.ef[var2].b instanceof BigBoss2) {
                     var3 = this.ef[var2].b.y - 50;
                  }

                  if (this.ef[var2].b instanceof BachTuoc) {
                     var3 = this.ef[var2].b.y - 40;
                  }

                  SmallImage.b(var1, this.ef[var2].a(), this.ef[var2].b.x, var3, 0, 33);
               } else if (this.ef[var2].c != null) {
                  SmallImage.b(var1, this.ef[var2].a(), this.ef[var2].c.cx, this.ef[var2].c.cy, 0, 33);
               }
            }
         }
      }

      if (this.indexEffTask >= 0 && this.effTask != null) {
         SmallImage.b(var1, this.effTask.a[this.indexEffTask].c, this.cx + this.effTask.a[this.indexEffTask].a, this.cy + this.effTask.a[this.indexEffTask].b, 0, 3);
      }

   }

   public final void a(mGraphics var1, int var2, int var3) {
      int var4;
      if ((var4 = this.cHP * 100 / this.cHPFull / 10 - 1) < 0) {
         var4 = 0;
      }

      if (var4 > 9) {
         var4 = 9;
      }

      if (!this.me) {
         var1.setColor(Mob.R, 0, 6 * (9 - var4), 9, 6, 0, var2, var3, 3);
      }

      if (this.cTypePk != 0 || myCharz().by != 0 && this.by != 0 && (this.by == 8 || myCharz().by == 8 || this.by != myCharz().by)) {
         this.ep = (int)((long)this.cHP * 100L / (long)this.cHPFull * (long)this.eq) / 100;
         if ((var4 = (int)((long)this.cHP * 100L / (long)this.cHPFull)) < 30) {
            this.er = GameScr.aG;
         } else if (var4 < 60) {
            this.er = GameScr.aH;
         } else {
            this.er = GameScr.aJ;
         }

         int var5 = mGraphics.setColor(GameScr.aG);
         int var6 = mGraphics.b(GameScr.aG);
         var4 = var5 * var4 / 100;
         var1.drawImage(GameScr.aI, var2 - (var5 >> 1), var3 - 1, 20);
         if (this.ep >= 5 || main.GameCanvas.v % 6 < 3) {
            var1.setColor(this.er, 0, 0, var4, var6, 0, var2 - (var5 >> 1), var3 - 1, 20);
         }
      }

   }

   public final void c(mGraphics var1) {
      if (!this.ck) {
         if (this.head != 377) {
            if (this.leg != 471) {
               if (!this.s) {
                  if (!this.bq) {
                     byte var2 = TileMap.i;
                     if ((TileMap.l < 114 || TileMap.l > 120) && TileMap.l != 127 && TileMap.l != 128 && !TileMap.a(this.cl + var2 / 2, this.cm + 1, 4)) {
                        if (TileMap.a((this.cl - var2 / 2) / var2, (this.cm + 1) / var2) == 0) {
                           var1.e(this.cl / var2 * var2, (this.cm - 30) / var2 * var2, 100, 100);
                        } else if (TileMap.a((this.cl + var2 / 2) / var2, (this.cm + 1) / var2) == 0) {
                           var1.e(this.cl / var2 * var2, (this.cm - 30) / var2 * var2, var2, 100);
                        } else if (TileMap.a(this.cl - var2 / 2, this.cm + 1, 8)) {
                           var1.e(this.cl / 24 * var2, (this.cm - 30) / var2 * var2, var2, 100);
                        }
                     }

                     var1.drawImage(TileMap.x, this.cl, this.cm, 3);
                     var1.e(GameScr.cmx, GameScr.cmy - main.GameCanvas.ac, GameScr.d, GameScr.e + 2 * main.GameCanvas.ac);
                  }
               }
            }
         }
      }
   }

   public final void H() {
      int var1 = 0;
      this.cl = this.cx;
      if (TileMap.a(this.cx, this.cy, 2)) {
         this.cm = this.cy;
      } else {
         this.cm = this.cy;

         while(var1 < 30) {
            ++var1;
            this.cm += 24;
            if (TileMap.a(this.cl, this.cm, 2)) {
               if (this.cm % 24 != 0) {
                  this.cm -= this.cm % 24;
                  return;
               }
               break;
            }
         }

      }
   }

   private void g(mGraphics var1) {
      try {
         if (this.cZ) {
            this.a(var1, this.da, this.db, this.I, this.as, false);
         } else {
            if (this.bc) {
               if (this.me) {
                  if (main.GameCanvas.v % 50 != 48 && main.GameCanvas.v % 50 != 90) {
                     SmallImage.b(var1, 1195, this.cx, this.cy - 18, 0, 3);
                  } else {
                     SmallImage.b(var1, 1196, this.cx, this.cy - 18, 0, 3);
                  }

                  return;
               }
            } else {
               this.a(var1, this.cx, this.cy + this.bS, this.I, this.as, true);
            }

         }
      } catch (Exception var2) {
      }
   }

   public final void a(mGraphics var1, short[] var2, int var3, int var4, int var5, boolean var6) {
      byte var7 = 0;
      byte var8 = 0;
      if (this.statusMe == 6) {
         var7 = 8;
         var8 = 17;
      }

      if (this.statusMe == 1) {
         if (this.F % 15 < 5) {
            var7 = 8;
            var8 = 17;
         } else {
            var7 = 8;
            var8 = 18;
         }
      }

      if (this.statusMe == 2) {
         if (this.as <= 3) {
            var7 = 7;
            var8 = 17;
         } else {
            var7 = 7;
            var8 = 18;
         }
      }

      if (this.statusMe == 3 || this.statusMe == 9) {
         var7 = 5;
         var8 = 20;
      }

      if (this.statusMe == 4) {
         if (this.as == 8) {
            var7 = 5;
            var8 = 16;
         } else {
            var7 = 5;
            var8 = 20;
         }
      }

      if (this.statusMe == 10) {
         if (this.as == 8) {
            var7 = 0;
            var8 = 23;
         } else {
            var7 = 5;
            var8 = 22;
         }
      }

      if (this.eh > 0) {
         var7 = 5;
         var8 = 18;
      }

      if (this.skillPaint != null && this.D() != null && this.cb < this.D().length) {
         var7 = -1;
         var8 = 17;
      }

      ++this.eu;
      if (this.eu > 10000) {
         this.eu = 0;
      }

      byte var9 = (byte)(this.eu / 4 % var2.length);
      if (!var6) {
         if (var2.length == 2) {
            var9 = 1;
         }

         if (var2.length == 3) {
            if (var2[2] >= 0) {
               var9 = 2;
               if (main.GameCanvas.v % 10 > 5) {
                  var9 = 1;
               }
            } else {
               var9 = 1;
            }
         }
      } else if (var2.length > 1 && (var9 == 0 || var9 == 1) && this.statusMe != 1 && this.statusMe != 6) {
         this.eu = 0;
         var9 = 0;
         if (main.GameCanvas.v % 10 > 5) {
            var9 = 1;
         }
      }

      SmallImage.b(var1, var2[var9], var3 + (var5 == 1 ? -var7 : var7), var4 - var8, var5 == 1 ? 0 : 2, StaticObj.f);
   }

   public final boolean a(int var1) {
      Rms var2 = GameScr.x[this.head];
      Rms var3 = GameScr.x[this.leg];
      Rms var4 = GameScr.x[this.body];

      for(int var5 = 0; var5 < bC.length; ++var5) {
         if (var1 == var2.a[bC[var5][0][0]].a) {
            return true;
         }

         if (var1 == var3.a[bC[var5][1][0]].a) {
            return true;
         }

         if (var1 == var4.a[bC[var5][2][0]].a) {
            return true;
         }
      }

      return false;
   }

   public final void a(mGraphics var1, int var2, int var3, int var4) {
      Rms var5 = GameScr.x[this.head];
      SmallImage.b(var1, var5.a[bC[0][0][0]].a, var2, var3, 0, 10);
   }

   public final void b(mGraphics var1, int var2, int var3, int var4) {
      Rms var5 = GameScr.x[this.head];
      SmallImage.b(var1, var5.a[bC[0][0][0]].a, var2 + bC[0][0][1] + var5.a[bC[0][0][0]].b - 3, var3 + 3, var4, 36);
   }

   public final void a(mGraphics var1, int var2, int var3, int var4, int var5, boolean var6) {
      this.ev = GameScr.x[this.head];
      this.ew = GameScr.x[this.leg];
      this.ex = GameScr.x[this.body];
      if (this.bag >= 0 && this.statusMe != 14) {
         if (!ClanImage.idImages.containsKey(String.valueOf(this.bag))) {
            ClanImage.idImages.put(String.valueOf(this.bag), new ClanImage());
            Service.gI().f((byte)this.bag);
         } else {
            ClanImage var7;
            if ((var7 = (ClanImage) ClanImage.idImages.get(String.valueOf(this.bag))).idImage != null && var6) {
               this.a(var1, var7.idImage, var2, var3, var4, true);
            }
         }
      }

      byte var18 = 2;
      byte var17 = 24;
      int var8 = StaticObj.TOP_RIGHT;
      byte var9 = -1;
      if (var4 == 1) {
         var18 = 0;
         var17 = 0;
         var8 = 0;
         var9 = 1;
      }

      Rms var15;
      if (this.statusMe == 14) {
         if (main.GameCanvas.v % 4 > 0) {
            var1.drawImage(ItemMap.myTexture2dflare, var2, var3 - this.al - 11, 3);
         }

         byte var14 = 0;
         if (this.head == 89 || this.head == 457 || this.head == 460 || this.head == 461 || this.head == 462 || this.head == 463 || this.head == 464 || this.head == 465 || this.head == 466) {
            var14 = 15;
         }

         SmallImage.b(var1, 834, var2, var3 - bC[var5][2][2] + this.ex.a[bC[var5][2][0]].c - 2 + var14, var18, StaticObj.a);
         SmallImage.b(var1, 79, var2, var3 - this.al - 8, 0, 33);
         SmallImage.b(var1, this.ev.a[bC[var5][0][0]].a, var2 + (bC[var5][0][1] + this.ev.a[bC[var5][0][0]].b) * var9, var3 - bC[var5][0][2] + this.ev.a[bC[var5][0][0]].c, var18, var17);
         this.b(var1, var5, var3 - bC[var5][2][2] + this.ex.a[bC[var5][2][0]].c);
         if (g(this.head)) {
            var15 = GameScr.x[this.h(this.head)];
            SmallImage.b(var1, var15.a[bC[var5][0][0]].a, var2 + (bC[var5][0][1] + var15.a[bC[var5][0][0]].b) * var9, var3 - bC[var5][0][2] + var15.a[bC[var5][0][0]].c, var18, var17);
         } else {
            SmallImage.b(var1, this.ev.a[bC[var5][0][0]].a, var2 + (bC[var5][0][1] + this.ev.a[bC[var5][0][0]].b) * var9, var3 - bC[var5][0][2] + this.ev.a[bC[var5][0][0]].c, var18, var17);
         }

         int var12 = var3 - bC[var5][2][2] + this.ex.a[bC[var5][2][0]].c;
         int var11 = var5;
         mGraphics var10 = var1;
         Char var16 = this;

         try {
            if (var16.idHat != -1) {
               if (i(var11)) {
                  if (var16.fc != null) {
                     var16.fc.a(main.GameCanvas.v / 4 % var16.fc.c, var16.cx + fg[var11][0] * (var16.I == 1 ? 1 : -1), var12 + fg[var11][1], var16.I == 1 ? 0 : 2, 33, var10);
                  } else {
                     var16.fc = mSystem.d(var16.fe + var16.ff + var16.idHat);
                  }
               } else if (var16.fa != null) {
                  var16.fa.a(main.GameCanvas.v / 4 % var16.fa.c, var16.cx + fg[var11][0] * (var16.I == 1 ? 1 : -1), var12 + fg[var11][1], var16.I == 1 ? 0 : 2, 33, var10);
               } else {
                  var16.fa = mSystem.d(var16.fe + var16.idHat);
               }
            }
         } catch (Exception var13) {
         }

         this.a(var1, var2 + (bC[var5][0][1] + this.ev.a[bC[var5][0][0]].b) * var9, var3 - bC[var5][0][2] + this.ev.a[bC[var5][0][0]].c, var18, var17);
      } else {
         this.b(var1, var5, var3 - bC[var5][2][2] + this.ex.a[bC[var5][2][0]].c);
         if (g(this.head)) {
            var15 = GameScr.x[this.h(this.head)];
            SmallImage.b(var1, var15.a[bC[var5][0][0]].a, var2 + (bC[var5][0][1] + var15.a[bC[var5][0][0]].b) * var9, var3 - bC[var5][0][2] + var15.a[bC[var5][0][0]].c, var18, var17);
         } else {
            SmallImage.b(var1, this.ev.a[bC[var5][0][0]].a, var2 + (bC[var5][0][1] + this.ev.a[bC[var5][0][0]].b) * var9, var3 - bC[var5][0][2] + this.ev.a[bC[var5][0][0]].c, var18, var17);
         }

         SmallImage.b(var1, this.ew.a[bC[var5][1][0]].a, var2 + (bC[var5][1][1] + this.ew.a[bC[var5][1][0]].b) * var9, var3 - bC[var5][1][2] + this.ew.a[bC[var5][1][0]].c, var18, var17);
         SmallImage.b(var1, this.ex.a[bC[var5][2][0]].a, var2 + (bC[var5][2][1] + this.ex.a[bC[var5][2][0]].b) * var9, var3 - bC[var5][2][2] + this.ex.a[bC[var5][2][0]].c, var18, var17);
         this.a(var1, var2 + (bC[var5][0][1] + this.ev.a[bC[var5][0][0]].b) * var9, var3 - bC[var5][0][2] + this.ev.a[bC[var5][0][0]].c, var18, var17);
      }

      this.al = this.cC != 1 && !this.cJ ? bC[0][0][2] + this.ev.a[bC[0][0][0]].c + 10 : 60;
      var4 = ResLog.g(this.ev.a[bC[var5][0][0]].c) >= 22 ? (this.ev.a[bC[var5][0][0]].c < 0 ? this.ev.a[bC[var5][0][0]].c + 5 : this.ev.a[bC[var5][0][0]].c - 5) : this.ev.a[bC[var5][0][0]].c;
      this.ey = var3 - bC[var5][0][2] + var4;
      if (this.statusMe == 1 && this.charID > 0 && !this.r && !this.z() && !this.cE && this.skillPaint == null && var5 != 23 && this.bag < 0 && ((main.GameCanvas.v + this.charID) % 30 == 0 || this.bk)) {
         var1.drawImage(this.cgender == 1 ? l : k, var2 + var9 * -2, var3 - 32 + (this.cgender == 1 ? 10 : 11) - var5, var8);
      }

      if (this.dF != null) {
         this.dF.a(var1);
      }

      if (this.dG != null) {
         this.dG.a(var1);
      }

      int var10003;
      boolean var10004;
      if (this.I == 1) {
         if (this.by != 0 && this.by != -1) {
            int var10002 = this.cx - 10;
            var10003 = this.cy - this.al;
            var10004 = this.me;
            SmallImage.b(var1, this.bz, var10002, var10003 - 30 + (main.GameCanvas.v % 20 > 10 ? main.GameCanvas.v % 4 / 2 : 0), 2, 0);
            return;
         }
      } else if (this.by != 0 && this.by != -1) {
         var10003 = this.cy - this.al;
         var10004 = this.me;
         SmallImage.b(var1, this.bz, this.cx, var10003 - 30 + (main.GameCanvas.v % 20 > 10 ? main.GameCanvas.v % 4 / 2 : 0), 0, 0);
      }

   }

   public final void d(mGraphics var1) {
      this.dM = 0;
      nr_f[] var2 = this.D();
      this.as = var2[this.cb].a;
      this.g(var1);
      if (this.I == 1) {
         if (this.eff0 != null) {
            if (this.dW == 0) {
               this.dW = var2[this.cb].c;
            }

            if (this.dZ == 0) {
               this.dZ = var2[this.cb].d;
            }

            SmallImage.b(var1, this.eff0.a[this.dT].c, this.cx + this.dW + this.eff0.a[this.dT].a, this.cy + this.dZ + this.eff0.a[this.dT].b, 0, 3);
            ++this.dT;
            if (this.dT >= this.eff0.a.length) {
               this.eff0 = null;
               this.dT = this.dW = this.dZ = 0;
            }
         }

         if (this.eff1 != null) {
            if (this.dX == 0) {
               this.dX = var2[this.cb].f;
            }

            if (this.ea == 0) {
               this.ea = var2[this.cb].g;
            }

            SmallImage.b(var1, this.eff1.a[this.dU].c, this.cx + this.dX + this.eff1.a[this.dU].a, this.cy + this.ea + this.eff1.a[this.dU].b, 0, 3);
            ++this.dU;
            if (this.dU >= this.eff1.a.length) {
               this.eff1 = null;
               this.dU = this.dX = this.ea = 0;
            }
         }

         if (this.eff2 != null) {
            if (this.dY == 0) {
               this.dY = var2[this.cb].i;
            }

            if (this.eb == 0) {
               this.eb = var2[this.cb].j;
            }

            SmallImage.b(var1, this.eff2.a[this.dV].c, this.cx + this.dY + this.eff2.a[this.dV].a, this.cy + this.eb + this.eff2.a[this.dV].b, 0, 3);
            ++this.dV;
            if (this.dV >= this.eff2.a.length) {
               this.eff2 = null;
               this.dV = this.dY = this.eb = 0;
            }
         }
      } else {
         if (this.eff0 != null) {
            if (this.dW == 0) {
               this.dW = var2[this.cb].c;
            }

            if (this.dZ == 0) {
               this.dZ = var2[this.cb].d;
            }

            SmallImage.b(var1, this.eff0.a[this.dT].c, this.cx - this.dW - this.eff0.a[this.dT].a, this.cy + this.dZ + this.eff0.a[this.dT].b, 2, 3);
            ++this.dT;
            if (this.dT >= this.eff0.a.length) {
               this.eff0 = null;
               this.dT = 0;
               this.dW = 0;
               this.dZ = 0;
            }
         }

         if (this.eff1 != null) {
            if (this.dX == 0) {
               this.dX = var2[this.cb].f;
            }

            if (this.ea == 0) {
               this.ea = var2[this.cb].g;
            }

            SmallImage.b(var1, this.eff1.a[this.dU].c, this.cx - this.dX - this.eff1.a[this.dU].a, this.cy + this.ea + this.eff1.a[this.dU].b, 2, 3);
            ++this.dU;
            if (this.dU >= this.eff1.a.length) {
               this.eff1 = null;
               this.dU = 0;
               this.dX = 0;
               this.ea = 0;
            }
         }

         if (this.eff2 != null) {
            if (this.dY == 0) {
               this.dY = var2[this.cb].i;
            }

            if (this.eb == 0) {
               this.eb = var2[this.cb].j;
            }

            SmallImage.b(var1, this.eff2.a[this.dV].c, this.cx - this.dY - this.eff2.a[this.dV].a, this.cy + this.eb + this.eff2.a[this.dV].b, 2, 3);
            ++this.dV;
            if (this.dV >= this.eff2.a.length) {
               this.eff2 = null;
               this.dV = 0;
               this.dY = 0;
               this.eb = 0;
            }
         }
      }

      ++this.cb;
   }

   public final void b(int var1, int var2, int var3) {
      if (var3 != 1 && ResLog.g(var1 - this.cx) <= 100 && ResLog.g(var2 - this.cy) <= 300) {
         byte var7 = 0;
         byte var4 = 0;
         int var5 = var1 - this.cx;
         int var6 = var2 - this.cy;
         if (var5 == 0 && var6 == 0) {
            var4 = 1;
            this.G = 0;
         } else if (var6 == 0) {
            var4 = 2;
            if (var5 > 0) {
               var7 = 1;
            }

            if (var5 < 0) {
               var7 = -1;
            }
         } else if (var6 != 0) {
            if (var6 < 0) {
               var4 = 3;
            }

            if (var6 > 0) {
               var4 = 4;
            }

            if (var5 < 0) {
               var7 = -1;
            }

            if (var5 > 0) {
               var7 = 1;
            }
         }

         this.bF.addElement(new nr_dj(var1, var2, var4, var7));
         if (this.statusMe != 6) {
            this.ez = this.statusMe;
         }

         this.statusMe = 6;
         this.G = 0;
      } else {
         this.a((int)this.cx, (int)this.cy, (int)10);
         this.cx = var1;
         this.cy = var2;
         this.bF.removeAllElements();
         this.statusMe = 6;
         this.G = 0;
         this.bP = null;
         this.as = 25;
      }
   }

   private void av() {
      if (myCharz().skillPaint == null && myCharz().arr == null && myCharz().dart == null) {
         if (this.eA > 0) {
            --this.eA;
         } else {
            if (cn && this.aU != null && (this.aU.statusMe == 15 || this.aU.bc)) {
               this.aU = null;
            }

            if (main.GameCanvas.v % 2 != 0) {
               if (!this.c(this.aU)) {
                  byte var1 = 0;
                  if (this.nClass != null && (this.nClass.a == 0 || this.nClass.a == 1 || this.nClass.a == 3 || this.nClass.a == 5)) {
                     var1 = 40;
                  }

                  int[] var2 = new int[]{-1, -1, -1, -1};
                  int var3 = GameScr.cmx - 10;
                  int var4 = GameScr.cmx + main.GameCanvas.z + 10;
                  int var5 = GameScr.cmy;
                  int var6 = GameScr.cmy + main.GameCanvas.A - GameScr.h + 10;
                  if (cn) {
                     if (this.aQ != null && this.aQ.p != 1 && this.aQ.p != 0 && var3 <= this.aQ.x && this.aQ.x <= var4 && var5 <= this.aQ.y && this.aQ.y <= var6 || this.aT != null && var3 <= this.aT.cx && this.aT.cx <= var4 && var5 <= this.aT.cy && this.aT.cy <= var6 || this.aU != null && var3 <= this.aU.cx && this.aU.cx <= var4 && var5 <= this.aU.cy && this.aU.cy <= var6 || this.aV != null && var3 <= this.aV.a && this.aV.a <= var4 && var5 <= this.aV.b && this.aV.b <= var6) {
                        return;
                     }

                     cn = false;
                  }

                  var3 = myCharz().cx - 80;
                  var4 = myCharz().cx + 80;
                  var5 = myCharz().cy - 30;
                  var6 = myCharz().cy + 30;
                  if (this.aT != null && this.aT.template.npcTemplateId == 6) {
                     var3 = myCharz().cx - 20;
                     var4 = myCharz().cx + 20;
                     var5 = myCharz().cy - 10;
                     var6 = myCharz().cy + 10;
                  }

                  int var7;
                  Npc var8;
                  int var9;
                  int var10;
                  int var11;
                  if (this.aT == null) {
                     for(var7 = 0; var7 < GameScr.G.size(); ++var7) {
                        if ((var8 = (Npc)GameScr.G.elementAt(var7)).statusMe != 15) {
                           var9 = Math.abs(myCharz().cx - var8.cx);
                           var10 = Math.abs(myCharz().cy - var8.cy);
                           var11 = var9 > var10 ? var9 : var10;
                           var3 = myCharz().cx - 80;
                           var4 = myCharz().cx + 80;
                           var5 = myCharz().cy - 30;
                           var6 = myCharz().cy + 30;
                           if (var8.template.npcTemplateId == 6) {
                              var3 = myCharz().cx - 20;
                              var4 = myCharz().cx + 20;
                              var5 = myCharz().cy - 10;
                              var6 = myCharz().cy + 10;
                           }

                           if (var3 <= var8.cx && var8.cx <= var4 && var5 <= var8.cy && var8.cy <= var6 && (this.aT == null || var11 < var2[1])) {
                              this.aT = var8;
                              var2[1] = var11;
                           }
                        }
                     }
                  } else {
                     if (var3 <= this.aT.cx && this.aT.cx <= var4 && var5 <= this.aT.cy && this.aT.cy <= var6) {
                        this.d(1);
                        return;
                     }

                     this.aw();

                     for(var7 = 0; var7 < GameScr.G.size(); ++var7) {
                        if ((var8 = (Npc)GameScr.G.elementAt(var7)).statusMe != 15) {
                           var9 = Math.abs(myCharz().cx - var8.cx);
                           var10 = Math.abs(myCharz().cy - var8.cy);
                           var11 = var9 > var10 ? var9 : var10;
                           var3 = myCharz().cx - 80;
                           var4 = myCharz().cx + 80;
                           var5 = myCharz().cy - 30;
                           var6 = myCharz().cy + 30;
                           if (var8.template.npcTemplateId == 6) {
                              var3 = myCharz().cx - 20;
                              var4 = myCharz().cx + 20;
                              var5 = myCharz().cy - 10;
                              var6 = myCharz().cy + 10;
                           }

                           if (var3 <= var8.cx && var8.cx <= var4 && var5 <= var8.cy && var8.cy <= var6 && (this.aT == null || var11 < var2[1])) {
                              this.aT = var8;
                              var2[1] = var11;
                           }
                        }
                     }
                  }

                  ItemMap var12;
                  if (this.aV == null) {
                     for(var7 = 0; var7 < GameScr.vItemMap.size(); ++var7) {
                        var12 = (ItemMap)GameScr.vItemMap.elementAt(var7);
                        var9 = Math.abs(myCharz().cx - var12.a);
                        var10 = Math.abs(myCharz().cy - var12.b);
                        var11 = var9 > var10 ? var9 : var10;
                        if (var9 <= 48 && var10 <= 48 && (this.aV == null || var11 < var2[3])) {
                           if (GameScr.gI().aW != 0) {
                              GameScr.gI();
                              if (GameScr.h() && var12.template.type != 9) {
                                 continue;
                              }
                           }

                           this.aV = var12;
                           var2[3] = var11;
                        }
                     }
                  } else {
                     if (var3 <= this.aV.a && this.aV.a <= var4 && var5 <= this.aV.b && this.aV.b <= var6) {
                        this.d(3);
                        return;
                     }

                     this.aV = null;

                     for(var7 = 0; var7 < GameScr.vItemMap.size(); ++var7) {
                        var12 = (ItemMap)GameScr.vItemMap.elementAt(var7);
                        var9 = Math.abs(myCharz().cx - var12.a);
                        var10 = Math.abs(myCharz().cy - var12.b);
                        var11 = var9 > var10 ? var9 : var10;
                        if (var3 <= var12.a && var12.a <= var4 && var5 <= var12.b && var12.b <= var6 && (this.aV == null || var11 < var2[3])) {
                           if (GameScr.gI().aW != 0) {
                              GameScr.gI();
                              if (GameScr.h() && var12.template.type != 9) {
                                 continue;
                              }
                           }

                           this.aV = var12;
                           var2[3] = var11;
                        }
                     }
                  }

                  var3 = myCharz().cx - myCharz().aa() - 10;
                  var4 = myCharz().cx + myCharz().aa() + 10;
                  var5 = myCharz().cy - myCharz().ab() - var1 - 20;
                  if ((var6 = myCharz().cy + myCharz().ab() + 20) > myCharz().cy + 30) {
                     var6 = myCharz().cy + 30;
                  }

                  Mob var13;
                  if (this.aQ == null) {
                     for(var7 = 0; var7 < GameScr.F.size(); ++var7) {
                        var13 = (Mob)GameScr.F.elementAt(var7);
                        var9 = Math.abs(myCharz().cx - var13.x);
                        var10 = Math.abs(myCharz().cy - var13.y);
                        var11 = var9 > var10 ? var9 : var10;
                        if (var3 <= var13.x && var13.x <= var4 && var5 <= var13.y && var13.y <= var6 && (this.aQ == null || var11 < var2[0])) {
                           this.aQ = var13;
                           var2[0] = var11;
                        }
                     }
                  } else {
                     if (this.aQ.p != 1 && this.aQ.p != 0 && var3 <= this.aQ.x && this.aQ.x <= var4 && var5 <= this.aQ.y && this.aQ.y <= var6) {
                        this.d(0);
                        return;
                     }

                     this.aQ = null;

                     for(var7 = 0; var7 < GameScr.F.size(); ++var7) {
                        var13 = (Mob)GameScr.F.elementAt(var7);
                        var9 = Math.abs(myCharz().cx - var13.x);
                        var10 = Math.abs(myCharz().cy - var13.y);
                        var11 = var9 > var10 ? var9 : var10;
                        if (var3 <= var13.x && var13.x <= var4 && var5 <= var13.y && var13.y <= var6 && (this.aQ == null || var11 < var2[0])) {
                           this.aQ = var13;
                           var2[0] = var11;
                        }
                     }
                  }

                  Char var14;
                  if (this.aU == null) {
                     for(var7 = 0; var7 < GameScr.vCharInMap.size(); ++var7) {
                        if ((var14 = (Char)GameScr.vCharInMap.elementAt(var7)).statusMe != 15 && !var14.bc && this.co == 0 && this.cp == 0) {
                           var9 = Math.abs(myCharz().cx - var14.cx);
                           var10 = Math.abs(myCharz().cy - var14.cy);
                           var11 = var9 > var10 ? var9 : var10;
                           if (var3 <= var14.cx && var14.cx <= var4 && var5 <= var14.cy && var14.cy <= var6 && (this.aU == null || var11 < var2[2])) {
                              this.aU = var14;
                              var2[2] = var11;
                           }
                        }
                     }
                  } else {
                     if (var3 <= this.aU.cx && this.aU.cx <= var4 && var5 <= this.aU.cy && this.aU.cy <= var6 && this.aU.statusMe != 15 && !this.aU.bc) {
                        this.d(2);
                        return;
                     }

                     this.aU = null;

                     for(var7 = 0; var7 < GameScr.vCharInMap.size(); ++var7) {
                        if ((var14 = (Char)GameScr.vCharInMap.elementAt(var7)).statusMe != 15 && !var14.bc && this.co == 0 && this.cp == 0) {
                           var9 = Math.abs(myCharz().cx - var14.cx);
                           var10 = Math.abs(myCharz().cy - var14.cy);
                           var11 = var9 > var10 ? var9 : var10;
                           if (var3 <= var14.cx && var14.cx <= var4 && var5 <= var14.cy && var14.cy <= var6 && (this.aU == null || var11 < var2[2])) {
                              this.aU = var14;
                              var2[2] = var11;
                           }
                        }
                     }
                  }

                  var7 = -1;

                  for(int var15 = 0; var15 < var2.length; ++var15) {
                     if (var7 == -1) {
                        if (var2[var15] != -1) {
                           var7 = var15;
                        }
                     } else if (var2[var15] < var2[var7] && var2[var15] != -1) {
                        var7 = var15;
                     }
                  }

                  this.d(var7);
                  if (this.me && this.I()) {
                     if (this.aQ != null && !this.aQ.J) {
                        this.aQ = null;
                     }

                     this.aT = null;
                     this.aV = null;
                  }

               }
            }
         }
      } else {
         this.eA = 200;
      }
   }

   private void d(int var1) {
      if (var1 == 0) {
         this.aw();
         this.aU = null;
         this.aV = null;
      } else if (var1 == 1) {
         this.aQ = null;
         this.aU = null;
         this.aV = null;
      } else if (var1 == 2) {
         this.aQ = null;
         this.aw();
         this.aV = null;
      } else {
         if (var1 == 3) {
            this.aQ = null;
            this.aw();
            this.aU = null;
         }

      }
   }

   public static boolean a(Char var0) {
      int var1 = GameScr.cmx;
      int var2 = GameScr.cmx + main.GameCanvas.z;
      int var3 = GameScr.cmy + 10;
      int var4 = GameScr.cmy + GameScr.e;
      return var0.statusMe != 15 && !var0.bc && var1 <= var0.cx && var0.cx <= var2 && var3 <= var0.cy && var0.cy <= var4;
   }

   public final boolean I() {
      return this.cTypePk == 4 || this.cTypePk == 3;
   }

   public final void b(Char var1) {
      if (this.cx < var1.cx) {
         this.I = 1;
      } else {
         this.I = -1;
      }

      this.eB = var1;
      this.cH = true;
   }

   public final void a(Mob var1) {
      if (this.cx < var1.x) {
         this.I = 1;
      } else {
         this.I = -1;
      }

      this.eC = var1;
      this.cH = true;
   }

   public final void J() {
      if (myCharz().skillPaint == null && myCharz().arr == null && myCharz().dart == null && myCharz().D() == null || this.aW.size() != 0) {
         this.aW.removeAllElements();
         int var1 = 0;
         int var2 = GameScr.cmx + 10;
         int var3 = GameScr.cmx + main.GameCanvas.z - 10;
         int var4 = GameScr.cmy + 10;
         int var5 = GameScr.cmy + GameScr.e;

         int var6;
         for(var6 = 0; var6 < GameScr.vCharInMap.size(); ++var6) {
            Char var7;
            if ((var7 = (Char)GameScr.vCharInMap.elementAt(var6)).statusMe != 15 && !var7.bc && var2 <= var7.cx && var7.cx <= var3 && var4 <= var7.cy && var7.cy <= var5 && var7.charID != -114 && (TileMap.l != 129 || TileMap.l == 129 && myCharz().cy > 264)) {
               this.aW.addElement(var7);
               if (this.aU != null && var7.equals(this.aU)) {
                  var1 = this.aW.size();
               }
            }
         }

         Mob var9;
         if (this.me && this.I()) {
            ResLog.c("co the tan cong nguoi");

            for(var6 = 0; var6 < GameScr.F.size(); ++var6) {
               var9 = (Mob)GameScr.F.elementAt(var6);
               GameScr.gI();
               if (!GameScr.a(var9)) {
                  ResLog.c("khong the tan cong quai");
                  this.aQ = null;
               } else {
                  ResLog.c("co the tan ong quai");
                  this.aW.addElement(var9);
                  if (this.aQ != null) {
                     var1 = this.aW.size();
                  }
               }
            }

            this.aT = null;
            this.aV = null;
            if (this.aW.size() > 0) {
               if (var1 >= this.aW.size()) {
                  var1 = 0;
               }

               this.a(this.aW.elementAt(var1));
            } else {
               this.aQ = null;
               this.aw();
               this.aU = null;
               this.aV = null;
               cn = false;
            }
         } else {
            for(var6 = 0; var6 < GameScr.vItemMap.size(); ++var6) {
               ItemMap var8 = (ItemMap)GameScr.vItemMap.elementAt(var6);
               if (var2 <= var8.a && var8.a <= var3 && var4 <= var8.b && var8.b <= var5) {
                  this.aW.addElement(var8);
                  if (this.aV != null && var8.equals(this.aV)) {
                     var1 = this.aW.size();
                  }
               }
            }

            for(var6 = 0; var6 < GameScr.F.size(); ++var6) {
               if ((var9 = (Mob)GameScr.F.elementAt(var6)).p != 1 && var9.p != 0 && var2 <= var9.x && var9.x <= var3 && var4 <= var9.y && var9.y <= var5) {
                  this.aW.addElement(var9);
                  if (this.aQ != null && var9.equals(this.aQ)) {
                     var1 = this.aW.size();
                  }
               }
            }

            for(var6 = 0; var6 < GameScr.G.size(); ++var6) {
               Npc var10;
               if ((var10 = (Npc)GameScr.G.elementAt(var6)).statusMe != 15 && var2 <= var10.cx && var10.cx <= var3 && var4 <= var10.cy && var10.cy <= var5) {
                  this.aW.addElement(var10);
                  if (this.aT != null && var10.equals(this.aT)) {
                     var1 = this.aW.size();
                  }
               }
            }

            if (this.aW.size() > 0) {
               if (var1 >= this.aW.size()) {
                  var1 = 0;
               }

               this.a(this.aW.elementAt(var1));
            } else {
               this.aQ = null;
               this.aw();
               this.aU = null;
               this.aV = null;
               cn = false;
            }
         }
      }
   }

   private void aw() {
      if (this.me && this.aT != null) {
         if (!main.GameCanvas.menu.a) {
            x = null;
         }

         this.aT = null;
      }

   }

   private void ax() {
      if (!main.GameCanvas.a) {
         if (TileMap.a(this.cx, this.cy + 1, 1024)) {
            TileMap.b(this.cx, this.cy + 1, 512);
            TileMap.b(this.cx, this.cy - 2, 512);
         }

         if (TileMap.a(this.cx - TileMap.i, this.cy + 1, 512)) {
            TileMap.c(this.cx - TileMap.i, this.cy + 1, 512);
            TileMap.c(this.cx - TileMap.i, this.cy - 2, 512);
         }

         if (TileMap.a(this.cx + TileMap.i, this.cy + 1, 512)) {
            TileMap.c(this.cx + TileMap.i, this.cy + 1, 512);
            TileMap.c(this.cx + TileMap.i, this.cy - 2, 512);
         }

      }
   }

   public final void a(int var1, int var2, boolean var3, boolean var4) {
      this.ae = var3;
      this.ad = var4;
      this.cHP -= var1;
      this.cMP -= var2;
      GameScr.gI().bD = true;
      GameScr.gI().bC = 0;
      GameScr.gI().bA = true;
      GameScr.gI().bz = 0;
      if (this.cHP < 0) {
         this.cHP = 0;
      }

      if (this.cMP < 0) {
         this.cMP = 0;
      }

      if (var4 || !var4 && this.cTypePk != 4) {
         String var10000;
         int var10001;
         int var10002;
         byte var10003;
         byte var10004;
         int var10005;
         if (var1 <= 0) {
            if (this.me) {
               var10000 = mResources.cE;
               var10001 = this.cx;
               var10002 = this.cy - this.al;
               var10003 = 0;
               var10004 = -2;
               var10005 = 7;
            } else {
               var10000 = mResources.cE;
               var10001 = this.cx;
               var10002 = this.cy - this.al;
               var10003 = 0;
               var10004 = -2;
               var10005 = 4;
            }
         } else {
            var10000 = "-" + var1;
            var10001 = this.cx;
            var10002 = this.cy - this.al;
            var10003 = 0;
            var10004 = -2;
            var10005 = !var3 ? 0 : 3;
         }

         GameScr.a(var10000, var10001, var10002, var10003, var10004, var10005);
      }

      if (var1 > 0) {
         this.eh = 6;
      }

      ServerEffect.a(80, (Char)this, 1);
      if (this.af) {
         this.af = false;
         bH = false;
         this.a((short)this.cl, (short)this.cm);
      }

   }

   public final void K() {
      GameScr.gI().bD = true;
      GameScr.gI().bC = 0;
      GameScr.gI().bA = true;
      GameScr.gI().bz = 0;
      this.eh = 6;
      ServerEffect.a(8, (Char)this, 1);
      this.dI = true;
      this.dH = 0;
   }

   public final void a(short var1, short var2) {
      this.cC = 0;
      this.cE = false;
      if (!this.me || !this.af) {
         if (this.me) {
            this.bJ = true;

            for(int var3 = 0; var3 < GameScr.vCharInMap.size(); ++var3) {
               ((Char)GameScr.vCharInMap.elementAt(var3)).bb = -9999;
            }

            if (main.GameCanvas.panel != null && main.GameCanvas.panel.ah != null) {
               main.GameCanvas.panel.ah = null;
            }

            if (main.GameCanvas.G != null && main.GameCanvas.G.ah != null) {
               main.GameCanvas.G.ah = null;
            }
         }

         this.statusMe = 5;
         this.d = var1;
         this.G = var2;
         this.F = 0;
         this.cHP = 0;
         this.ba = -9999;
         this.bb = -9999;
         if (this.me && this.myskill != null && this.myskill.template.id != 14) {
            this.C();
         }

         this.cTypePk = 0;
      }
   }

   public final void b(short var1, short var2) {
      this.co = var1;
      this.cp = var2;
   }

   public final void L() {
      this.cHP = this.cHPFull;
      this.cMP = this.cMPFull;
      this.statusMe = 1;
      this.F = this.d = this.G = 0;
      ServerEffect.a(109, (Char)this, 2);
      GameScr.gI().center = null;
      GameScr.N = true;
   }

   public final boolean M() {
      if (this.arrItemBag == null) {
         return false;
      } else {
         for(int var1 = 0; var1 < this.arrItemBag.length; ++var1) {
            if (this.arrItemBag[var1] != null && this.arrItemBag[var1].template.type == 6) {
               Service.gI().a((byte)0, (byte)1, (byte)-1, (short)this.arrItemBag[var1].template.a);
               return true;
            }
         }

         return false;
      }
   }

   private static boolean ay() {
      return TileMap.l == 1 || TileMap.l == 27 || TileMap.l == 72 || TileMap.l == 10 || TileMap.l == 17 || TileMap.l == 22 || TileMap.l == 32 || TileMap.l == 38 || TileMap.l == 43 || TileMap.l == 48;
   }

   public final boolean c(Char var1) {
      if (var1 == null || myCharz().myskill == null || myCharz().myskill.template.type == 2 || myCharz().myskill.template.type == 4 && var1.statusMe != 14 && var1.statusMe != 5) {
         return false;
      } else {
         return (var1.cTypePk == 3 && myCharz().cTypePk == 3 || myCharz().cTypePk == 5 || var1.cTypePk == 5 || myCharz().cTypePk == 1 && var1.cTypePk == 1 || myCharz().cTypePk == 4 && var1.cTypePk == 4 || myCharz().ba >= 0 && myCharz().ba == var1.charID || myCharz().bb >= 0 && myCharz().bb == var1.charID && !ay() || var1.bb >= 0 && var1.bb == myCharz().charID && !ay() || myCharz().by == 8 && var1.by != 0 || myCharz().by != 0 && var1.by == 8 || myCharz().by != var1.by && myCharz().by != 0 && var1.by != 0) && var1.statusMe != 14 && var1.statusMe != 5;
      }
   }

   public static void N() {
      myCharz().aD = null;

      for(int var0 = 0; var0 < myCharz().arrItemBag.length; ++var0) {
         if (myCharz().arrItemBag[var0] != null && myCharz().arrItemBag[var0].template.type == 8) {
            myCharz().arrItemBag[var0] = null;
         }
      }

      Npc.aa();
   }

   public final int getX() {
      return this.cx;
   }

   public final int getY() {
      return this.cy;
   }

   public final int getH() {
      return 32;
   }

   public final int getW() {
      return 24;
   }

   public final void a(Object var1) {
      if (var1 instanceof Mob) {
         this.aQ = (Mob)var1;
         this.aw();
         this.aU = null;
         this.aV = null;
      } else if (var1 instanceof Npc) {
         myCharz().aQ = null;
         myCharz().aw();
         myCharz().aT = (Npc)var1;
         myCharz().aU = null;
         myCharz().aV = null;
      } else if (var1 instanceof Char) {
         myCharz().aQ = null;
         myCharz().aw();
         myCharz().aU = (Char)var1;
         myCharz().aV = null;
      } else if (var1 instanceof ItemMap) {
         myCharz().aQ = null;
         myCharz().aw();
         myCharz().aU = null;
         myCharz().aV = (ItemMap)var1;
      }

      cn = true;
   }

   public final void stopMoving() {
   }

   public final boolean isInvisible() {
      return false;
   }

   public final boolean O() {
      return this.aQ != null || this.aU != null && this.c(this.aU);
   }

   private void e(int var1) {
      if (!main.GameCanvas.a) {
         if (var1 == 1) {
            EffecMn.addEff(new Effect(19, this.cx - 5, this.cy + 20, 2, 1, -1));
            return;
         }

         if (var1 == 2) {
            if (this.me && this.cC == 1) {
               return;
            }

            if (this.isNhapThe && main.GameCanvas.v % 5 == 0) {
               EffecMn.addEff(new Effect(22, this.cx - 5, this.cy + 35, 2, 1, -1));
               return;
            }
         } else if (var1 == 3 && this.cm - this.cy <= 5) {
            EffecMn.addEff(new Effect(19, this.cx - 5, this.cm + 20, 2, 1, -1));
         }
      }

   }

   public static boolean a(byte var0) {
      boolean var1 = true;

      for(int var2 = 0; var2 < GameScr.H.size(); ++var2) {
         nr_em var3;
         if ((var3 = (nr_em)GameScr.H.elementAt(var2)) != null) {
            if (var3.a == var0) {
               return true;
            }

            var1 = false;
         }
      }

      return var1;
   }

   public final void P() {
      if (this.cH) {
         this.cH = false;
         this.eB = null;
         this.eC = null;
      } else {
         this.cG = 0;
         this.eB = null;
         this.eC = null;
      }
   }

   public final void Q() {
      this.cI = false;
      this.dF = null;
   }

   public final void R() {
      this.cM = false;
   }

   public final void S() {
      if (this.cG != 0) {
         this.cG = 0;
      }

      if (this.cH) {
         this.cH = false;
      }

      if (this.cI) {
         this.cI = false;
      }

      this.dF = null;
      this.eB = null;
      this.eC = null;
      this.cM = false;
      this.cO = false;
   }

   public final void a(short var1, short var2, byte var3) {
      this.eE = true;
      this.eG = var1;
      this.eH = var2;
      this.eI = var3;
      this.eF = 0;
      if (this.me) {
         if (main.GameCanvas.panel != null) {
            main.GameCanvas.panel.A();
         }

         if (main.GameCanvas.G != null) {
            main.GameCanvas.G.A();
         }
      }

   }

   public final void T() {
      this.cL = false;
   }

   public final void U() {
      this.cJ = false;
      bH = false;
      this.cK = 0;
   }

   public final void b(byte var1) {
      this.cK = 0;
      if (var1 == 4 || var1 == 5) {
         if (this.me) {
            Service.gI().i(var1);
         }

         EffecMn.addEff(new Effect(34, this.cx, this.cy + 12, 2, 1, -1));
      }

      if (var1 == 6) {
         EffecMn.addEff(new Effect(38, this.cx, this.cy + 12, 2, 1, -1));
      }

      if (this.me) {
         main.GameCanvas.panel.z();
         bH = true;
      }

      this.cJ = true;
      if (var1 == 1) {
         this.isNhapThe = false;
      } else {
         this.isNhapThe = true;
      }
   }

   public final void V() {
      this.cO = false;
   }

   public final void setPartOld() {
      this.eJ = this.head;
      this.eK = this.body;
      this.eL = this.leg;
      this.eM = this.bag;
   }

   public final void a(int var1, int var2, int var3, int var4) {
      if (var1 != -1) {
         this.head = var1;
      }

      if (var2 != -1) {
         this.body = var2;
      }

      if (var3 != -1) {
         this.leg = var3;
      }

      if (var4 != -1) {
         this.bag = var4;
      }

   }

   public final void X() {
      if (this.eJ != -1) {
         this.head = this.eJ;
         this.eJ = -1;
      }

      if (this.eK != -1) {
         this.body = this.eK;
         this.eK = -1;
      }

      if (this.eL != -1) {
         this.leg = this.eL;
         this.eL = -1;
      }

      if (this.eM != -1) {
         this.bag = this.eM;
         this.eM = -1;
      }

   }

   private Effect f(int var1) {
      for(int var2 = 0; var2 < this.vEff.size(); ++var2) {
         Effect var3;
         if ((var3 = (Effect)this.vEff.elementAt(var2)).a == var1) {
            return var3;
         }
      }

      return null;
   }

   public final void a(Effect var1) {
      this.b((int)0, (int)var1.a);
      this.vEff.addElement(var1);
   }

   public final void b(int var1, int var2) {
      if (var1 == -1) {
         this.vEff.removeAllElements();
      } else {
         if (this.f(var2) != null) {
            this.vEff.removeElement(this.f(var2));
         }

      }
   }

   private void h(mGraphics var1) {
      for(int var2 = 0; var2 < this.vEff.size(); ++var2) {
         Effect var3;
         if ((var3 = (Effect)this.vEff.elementAt(var2)).h == 0) {
            boolean var4 = true;
            if (var3.i == 0) {
               if (this.statusMe != 1 && this.statusMe != 6) {
                  var4 = false;
               } else {
                  var4 = true;
               }
            }

            if (var4) {
               var3.a(var1);
            }
         }
      }

   }

   private void i(mGraphics var1) {
      for(int var2 = 0; var2 < this.vEff.size(); ++var2) {
         Effect var3;
         if ((var3 = (Effect)this.vEff.elementAt(var2)).h == 1) {
            boolean var4 = true;
            if (var3.i == 0) {
               if (this.statusMe != 1 && this.statusMe != 6) {
                  var4 = false;
               } else {
                  var4 = true;
               }
            }

            if (var4) {
               var3.a(var1);
            }
         }
      }

   }

   private void az() {
      for(int var1 = 0; var1 < this.vEff.size(); ++var1) {
         ((Effect)this.vEff.elementAt(var1)).a();
      }

   }

   public final int Y() {
      return this.gem + this.ruby;
   }

   private void a(mGraphics var1, int var2, int var3, int var4, int var5) {
      if (this.head == 934 && (this.statusMe == 1 || this.statusMe == 6)) {
         if (eO == null || eO.d == null) {
            Image var7 = mSystem.load("/redeye.png");
            eO = new FrameImage(var7, 14, 10);
            return;
         }

         if (this.eT[this.eP] != -1) {
            byte var6 = 8;
            if (var4 == 2) {
               var6 = -8;
            }

            eO.a(this.eT[this.eP], var2 + var6, var3 + 15, var4, var5, var1);
         }
      }

   }

   private static boolean g(int var0) {
      for(int var1 = 0; var1 < cS.length; ++var1) {
         if (cS[var1][0] == var0) {
            return true;
         }
      }

      return false;
   }

   private void aA() {
      if (g(this.head)) {
         ++this.eU;
         if (this.eU <= 10000) {
            return;
         }
      }

      this.eU = 0;
   }

   private int h(int var1) {
      for(int var2 = 0; var2 < cS.length; ++var2) {
         if (cS[var2][0] == var1) {
            return cS[var2][this.eU / 4 % cS[var2].length];
         }
      }

      return var1;
   }

   private void b(mGraphics var1, int var2, int var3) {
      try {
         if (this.idHat != -1) {
            if (i(var2)) {
               if (this.fb != null) {
                  this.fb.a(main.GameCanvas.v / 4 % this.fb.c, this.cx + fg[var2][0] * (this.I == 1 ? 1 : -1), var3 + fg[var2][1], this.I == 1 ? 0 : 2, 33, var1);
               } else {
                  this.fb = mSystem.d(this.fd + this.ff + this.idHat);
               }
            } else if (this.eZ != null) {
               this.eZ.a(main.GameCanvas.v / 4 % this.eZ.c, this.cx + fg[var2][0] * (this.I == 1 ? 1 : -1), var3 + fg[var2][1], this.I == 1 ? 0 : 2, 33, var1);
            } else {
               this.eZ = mSystem.d(this.fd + this.idHat);
            }
         }
      } catch (Exception var4) {
      }
   }

   private static boolean i(int var0) {
      return var0 == 2 || var0 == 3 || var0 == 4 || var0 == 5 || var0 == 6 || var0 == 9 || var0 == 10 || var0 == 13 || var0 == 14 || var0 == 15 || var0 == 16 || var0 == 26 || var0 == 27 || var0 == 28 || var0 == 29;
   }

   public final void a(short var1) {
      short var2 = -1;
      short var3 = -1;
      if (this.aQ != null) {
         var2 = (short)this.aQ.x;
         var3 = (short)this.aQ.y;
      }

      if (this.aU != null && !this.aU.es && !this.aU.et) {
         var2 = (short)this.aU.cx;
         var3 = (short)this.aU.cy;
      }

      Service.gI().a((byte)var1, (byte)this.I, var2, var3);
   }

   public final void a(short var1, boolean var2, byte var3, byte var4, byte var5, short var6, byte var7) {
      this.cY = true;
      this.fi = main.GameCanvas.b + 10000L;
      this.fk = var1;
      this.fh = var2;
      this.fj = var3;
      this.I = var5;
      this.fo = 0;
      this.fp = 0;
      long var8 = mSystem.currentTimeMillis();
      if (this.me) {
         this.myskill.f = var8;
         if (this.myskill.template.d == 2) {
            this.cMP = 1;
         } else if (this.myskill.template.d != 1) {
            this.cMP -= this.myskill.i;
         } else {
            this.cMP -= this.myskill.i * this.cMPFull / 100;
         }

         --myCharz().cStamina;
         GameScr.gI().bA = true;
         GameScr.gI().bz = 0;
         if (this.cMP < 0) {
            this.cMP = 0;
         }
      }

      if (var1 == 24) {
         GameScr.a(18, 0, var4, this.Z(), (Point)null, 3, var6, (short)0);
         GameScr.a(21, 0, var4, this.Z(), (Point)null, 1, var6, (short)0);
      } else if (var1 == 25) {
         GameScr.a(19, 0, var4, this.Z(), (Point)null, 3, var6, (short)0);
         GameScr.a(22, 0, var4, this.Z(), (Point)null, 1, var6, (short)0);
      } else if (var1 == 26) {
         GameScr.a(20, 0, var4, this.Z(), (Point)null, 3, var6, (short)0);
         GameScr.a(23, 0, var4, this.Z(), (Point)null, 1, var6, (short)0);
      }

      if (this.fj == 1) {
         if (!this.fh) {
            this.fl = new byte[]{20, 20, 20, 20, 20, 20, 19};
            this.fm = new byte[]{20};
            this.fn = new byte[1];
         } else {
            this.fl = new byte[]{31, 31, 31, 31, 31, 31, 30};
            this.fm = new byte[]{31};
            this.fn = new byte[]{12};
         }
      }

      if (this.fj == 2) {
         if (!this.fh) {
            this.fl = new byte[]{20};
            this.fm = new byte[]{13, 13, 13, 14, 14, 14};
            this.fn = new byte[1];
         } else {
            this.fl = new byte[]{31};
            this.fm = new byte[]{26, 26, 26, 27, 27, 27};
            this.fn = new byte[]{12};
         }
      }

      if (this.fj == 4) {
         if (!this.fh) {
            this.fl = new byte[]{17, 17, 17, 18, 18, 18};
            this.fm = new byte[]{18};
            this.fn = new byte[1];
         } else {
            this.fl = new byte[]{7, 7, 7, 12, 12, 12, 12};
            this.fm = new byte[]{12};
            this.fn = new byte[]{12};
         }
      }

      if (this.fj == 3) {
         if (!this.fh) {
            this.fl = new byte[]{24, 24, 24, 17, 17, 17, 18, 18, 18};
            this.fm = new byte[]{20};
            this.fn = new byte[1];
            return;
         }

         this.fl = new byte[]{23, 23, 23, 7, 7, 7, 12, 12, 12, 12};
         this.fm = new byte[]{31};
         this.fn = new byte[]{12};
      }

   }

   public final void a(int var1, short var2, Point var3, short var4, short var5, byte var6, Point[] var7, byte var8) {
      this.fp = var1;
      this.fk = var2;
      this.fo = 0;
      this.fq = var3;
      this.fr = mSystem.currentTimeMillis() + (long)var4;
      if (this.fp == 1) {
         if (this.fk == 24) {
            GameScr.a(18, 1, var6, this, (Point)null, 3, var4, (short)0);
            GameScr.a(24, 0, var6, this, this.fq, 1, var4, var5);
         }

         if (this.fk == 25) {
            GameScr.a(19, 0, var6, this, (Point)null, 3, var4, (short)0);
            GameScr.a(25, 0, var6, this, this.fq, 1, var4, var5);
         }

         if (this.fk == 26) {
            GameScr.a(20, 0, var6, this, (Point)null, 3, var4, (short)0);
            GameScr.a(26, var8, var6, var3.b, var3.c, 1, 0, var4, var7);
         }

      }
   }

   public final Char Z() {
      Char var1;
      (var1 = new Char()).charID = this.charID;
      var1.cx = this.cx;
      var1.cy = this.cy;
      var1.I = this.I;
      if (this.arrItemBody != null) {
         var1.arrItemBody = new Item[this.arrItemBody.length];

         for(int var2 = 0; var2 < this.arrItemBody.length; ++var2) {
            if (this.arrItemBody[var2] == null) {
               var1.arrItemBody[var2] = null;
            } else {
               Item[] var10000 = var1.arrItemBody;
               Item var3 = this.arrItemBody[var2];
               Item var4;
               (var4 = new Item()).template = var3.template;
               if (var3.c != null) {
                  var4.c = new MyVector("item.options");

                  for(int var5 = 0; var5 < var3.c.size(); ++var5) {
                     ItemOption var6;
                     (var6 = new ItemOption()).optionTemplate = ((ItemOption)var3.c.elementAt(var5)).optionTemplate;
                     var6.param = ((ItemOption)var3.c.elementAt(var5)).param;
                     var4.c.addElement(var6);
                  }
               }

               var4.d = var3.d;
               var4.e = var3.e;
               var4.g = var3.g;
               var4.quantity = var3.quantity;
               var4.k = var3.k;
               var4.l = var3.l;
               var4.m = var3.m;
               var4.n = var3.n;
               var4.o = var3.o;
               var4.p = var3.p;
               var4.q = var3.q;
               var4.r = var3.r;
               var4.w = var3.w;
               var4.x = var3.x;
               var10000[var2] = var4;
            }
         }
      }

      return var1;
   }

   public final boolean b(int var1) {
      if (this.arrItemBody != null) {
         for(var1 = 0; var1 < this.arrItemBody.length; ++var1) {
            if (this.arrItemBody[var1] != null && this.arrItemBody[var1].template != null && this.arrItemBody[var1].template.a == 1265) {
               return true;
            }
         }
      }

      ResLog.b("tim kiem id cai trang " + 1265 + " ko tim thay");
      return false;
   }
}
