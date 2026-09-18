package nro;

import javax.microedition.lcdui.Image;
import main.GameMidlet;

public final class Panel implements IActionListener, IChatable {
   public boolean isShow;
   public int b;
   public int c;
   public int d;
   public int e;
   private int aC;
   private int aD;
   private int aE;
   public int f;
   public int g;
   private int aF;
   private int aG;
   private int aH;
   private int[] aI;
   private int aJ;
   public int h;
   private int aK;
   private int aL;
   private int aM;
   private int aN;
   private int aO;
   public static Image i;
   private static Image aP;
   public nr_do tabIcon;
   public MyVector k = new MyVector("");
   private int aQ;
   public int l;
   private boolean aR;
   public boolean m;
   private boolean aS;
   public String n;
   public ChatTextField o;
   public static String p;
   public static short q;
   public static Image r;
   public static Image s;
   public static Image t;
   public static Image u;
   public static Image v;
   public static Image w;
   public static Image x;
   public static Image y;
   private static Image aT;
   private static Image aU;
   private CommandLine aV;
   public int z;
   public int A;
   public int B;
   private int[] aW;
   private String[][] aX;
   private int[] aY;
   public String[][] C;
   public String[] D;
   public String[] E;
   public static String[] F;
   public static String[] G;
   private static String[] aZ;
   private static String[] ba;
   public static int H;
   public String[][] I;
   public int[] J;
   public int[] K;
   private static String[][] bb;
   private static String[][] bc;
   private static String[][] bd;
   private static String[][] be;
   private static String[][] bf;
   private static String[][] bg;
   public String[][][] L;
   private static byte bh;
   private static byte bi;
   private static byte bj;
   private static byte bk;
   private static byte bl;
   private static byte bm;
   private static byte bn;
   public int hasUse;
   public int N;
   private int[] bo;
   private static int[] bp;
   private static int[] bq;
   private static int[] br;
   private static int[] bs;
   private static int[] bt;
   private static int[] bu;
   private static int[] bv;
   private static int[] bw;
   private static int[] bx;
   private static int[][] by;
   private static int[][] bz;
   private static int[][] bA;
   private Item bB;
   private Clan bC;
   private ClanMessage bD;
   private Member bE;
   public Clan[] O;
   public MyVector member;
   public MyVector myMember;
   private MyVector bF;
   public MyVector R;
   public MyVector S;
   public MyVector T;
   public MyVector U;
   public MyVector V;
   public MyVector W;
   public MyVector X;
   public MyVector Y;
   public CommandLine cmdClose;
   public static int aa;
   private int bG;
   public Char ab;
   private boolean bH;
   private int bI;
   public static boolean ac;
   public int ad;
   public int ae;
   public int af;
   public int ag;
   public ChatPopup ah;
   private int bJ;
   private int[] bK;
   private int timeShow;
   public boolean ai;
   public int aj;
   private int bM;
   private int bN;
   private boolean bO;
   public boolean ak;
   public boolean al;
   public boolean am;
   private int bP;
   private int bQ;
   private int[] bR;
   private boolean bS;
   private boolean bT;
   private int bU;
   private int bV;
   private int bW;
   private int bX;
   private boolean bY;
   private int bZ;
   private int ca;
   private int cb;
   private int cc;
   private boolean cd;
   private int ce;
   private String[][] cf;
   private String cg;
   public String an;
   private nr_ds ch;
   private int ci;
   private int cj;
   private boolean ck;
   private String[] cl;
   private int cm;
   private static long[] cn;
   private int[] co;
   public String[] ao;
   public String[] ap;
   private int cp;
   private Item cq;
   public static String aq;
   private int cr;
   private int cs;
   private int ct;
   private int cu;
   private int cv;
   private int cw;
   private int cx;
   private int cy;
   private int cz;
   private int cA;
   private int cB;
   public static boolean ar;
   private boolean isClose;
   private int cD;
   public static MyVector as;
   private static String[] cE;
   public boolean at;
   private int cF;
   private Char cG;
   private boolean cH;
   private boolean cI;
   private boolean cJ;
   private int cK;
   public byte au;
   public int av;
   public int aw;
   public int ax;
   private int cL;
   private int cM;
   private int cN;
   private int cO;
   private int cP;
   private int cQ;
   private int[] cR;
   private int[] cS;
   private int[] cT;
   private int[] cU;
   private int cV;
   private int cW;
   private int cX;
   private int cY;
   private int cZ;
   private boolean da;
   private boolean db;
   private boolean dc;
   public boolean ay;
   public short az;
   private short dd;
   public short aA;
   private short[] de;
   public String[][] aB;
   private static int[] df;
   private static int dg;
   private static int[][] dh;
   private Image di;
   private Image dj;
   private Image dk;
   private Image dl;
   private byte dm;
   private boolean dn;

   static {
      aP = mSystem.load("/img/map" + TileMap.r + ".png");
      i = mSystem.load("/mainImage/myTexture2dbantay.png");
      mSystem.load("/mainImage/myTexture2dbtX.png");
      v = mSystem.load("/mainImage/myTexture2dimgMoney.png");
      x = mSystem.load("/mainImage/myTexture2dimgDiamond.png");
      y = mSystem.load("/mainImage/luongkhoa.png");
      aT = mSystem.load("/mainImage/myTexture2dup.png");
      aU = mSystem.load("/mainImage/myTexture2ddown.png");
      r = mSystem.load("/mainImage/star.png");
      s = mSystem.load("/mainImage/starE.png");
      t = mSystem.load("/mainImage/star8.png");
      u = mSystem.load("/mainImage/new.png");
      w = mSystem.load("/mainImage/ticket12.png");
      F = new String[]{mResources.bR, mResources.bQ, mResources.aF, mResources.bP, mResources.ap, mResources.bT, mResources.T};
      G = new String[]{main.GameCanvas.ai ? mResources.fz : mResources.fA, mResources.bU, mResources.H, mGraphics.zoomLevel > 1 ? mResources.bY : mResources.bX};
      aZ = new String[]{mResources.fU, mResources.bM, mResources.bN, mResources.ad, mResources.fQ};
      ba = new String[]{mResources.o};
      H = 0;
      bb = new String[][]{mResources.cd, mResources.ce};
      bc = new String[][]{mResources.cf, mResources.ce};
      bd = new String[][]{mResources.cj};
      be = new String[][]{mResources.cg};
      bf = new String[][]{mResources.ce, mResources.ch, mResources.ci};
      bg = mResources.aO;
      bh = 0;
      bi = 1;
      bj = 3;
      bk = 4;
      bl = 5;
      bm = 6;
      bn = 7;
      bp = new int[]{21, 0, 1, 2, 24, 3, 4, 5, 6, 27, 28, 29, 30, 42, 47, 46};
      bq = new int[]{39, 42, 105, 93, 61, 93, 142, 165, 210, 100, 165, 220, 233, 10, 125, 125};
      br = new int[]{28, 60, 48, 96, 88, 131, 136, 95, 32, 200, 189, 167, 120, 110, 20, 20};
      bs = new int[]{22, 7, 8, 9, 25, 11, 12, 13, 10, 31, 32, 33, 34, 43};
      bt = new int[]{55, 30, 93, 80, 24, 149, 219, 220, 233, 170, 148, 195, 148, 10};
      bu = new int[]{136, 84, 69, 34, 25, 42, 32, 110, 192, 70, 106, 156, 210, 57};
      bv = new int[]{23, 14, 15, 16, 26, 17, 18, 20, 19, 35, 36, 37, 38, 44};
      bw = new int[]{90, 95, 144, 234, 231, 122, 176, 158, 205, 54, 105, 159, 231, 27};
      bx = new int[]{10, 43, 20, 36, 69, 87, 112, 167, 160, 151, 173, 207, 194, 29};
      by = new int[][]{bp, bs, bv};
      bz = new int[][]{bq, bt, bw};
      bA = new int[][]{br, bu, bx};
      aa = 240;
      ac = false;
      cn = new long[]{50000000L, 250000000L, 1250000000L, 5000000000L, 15000000000L, 30000000000L, 45000000000L, 60000000000L, 75000000000L, 90000000000L, 110000000000L, 130000000000L, 150000000000L, 170000000000L};
      int[] var10000 = new int[]{2327248, 8982199, 16713222};
      var10000 = new int[]{4583423, 16719103, 16714764};
      aq = "";
      ar = true;
      as = new MyVector("");
      df = new int[]{2, 1, 1};
      dg = 1;
      dh = new int[][]{{16777215, 15000805, 13487823, 11711155, 9671828, 7895160}, {61952, 58624, 52224, 45824, 39168, 32768}, {13500671, 12058853, 10682572, 9371827, 7995545, 6684800}, {16744192, 15037184, 13395456, 11753728, 10046464, 8404992}, {37119, 33509, 28108, 24499, 21145, 17536}, {16776192, 15063040, 12635136, 11776256, 10063872, 8290304}, {16711680, 15007744, 13369344, 11730944, 10027008, 8388608}};
   }

   public Panel() {
      this.aV = new CommandLine(mResources.bv, 0);
      this.L = new String[][][]{null, null, bb, bd, be, null, null, {{""}}, {{""}}, {{""}}, {{""}}, {{""}}, bc, bf, {{""}}, {{""}}, {{""}}, {{""}}, {{""}}, {{""}}, {{""}}, bg, {{""}}, {{""}}, {{""}}, {{""}}, {{""}}};
      this.bF = new MyVector("");
      this.R = new MyVector("");
      this.S = new MyVector("");
      this.T = new MyVector("");
      this.U = new MyVector("");
      this.V = new MyVector("");
      this.W = new MyVector("");
      this.X = new MyVector("");
      this.Y = new MyVector("");
      this.bG = 0;
      this.bI = -1;
      this.timeShow = 0;
      this.ai = false;
      this.bR = new int[3];
      this.bX = 0;
      this.bY = false;
      this.bZ = main.GameCanvas.s + this.aK;
      this.ca = main.GameCanvas.t + this.aL;
      this.cb = -1;
      this.cc = -1;
      this.ce = -1;
      this.cf = new String[][]{mResources.dj, mResources.di};
      this.cg = "";
      this.an = "";
      this.cl = new String[]{mResources.u, mResources.t, mResources.s, mResources.w, mResources.gi, mResources.gj};
      this.cm = 0;
      this.co = new int[]{43520, 14743570, 14155776};
      this.cp = 0;
      this.cq = null;
      this.ct = 140;
      this.cu = -1;
      this.cw = 0;
      this.cx = 0;
      this.au = -1;
      this.db = true;
      this.dc = false;
      this.ay = true;
      this.dm = 0;
      this.dn = false;
      this.a();
      this.cmdClose = new CommandLine("", this, 1003, (Object)null);
      this.cmdClose.g = mSystem.load("/mainImage/myTexture2dbtX.png");
      this.cmdClose.p = true;
      this.bB = null;
   }

   public final void a() {
      this.bZ = main.GameCanvas.s + this.aK;
      this.ca = main.GameCanvas.t + this.aL;
      this.aW = new int[this.L.length];

      for(int var1 = 0; var1 < this.aW.length; ++var1) {
         this.aW[var1] = -1;
      }

   }

   private static int G() {
      for(int var0 = 0; var0 < by[TileMap.r].length; ++var0) {
         if (TileMap.l == by[TileMap.r][var0]) {
            return bz[TileMap.r][var0];
         }
      }

      return -1;
   }

   private static int H() {
      for(int var0 = 0; var0 < by[TileMap.r].length; ++var0) {
         if (TileMap.l == by[TileMap.r][var0]) {
            return bA[TileMap.r][var0];
         }
      }

      return -1;
   }

   private static int I() {
      if (Char.myCharz().aD == null) {
         return -1;
      } else {
         for(int var0 = 0; var0 < by[TileMap.r].length; ++var0) {
            if (GameScr.ac[Char.myCharz().aD.a] == by[TileMap.r][var0]) {
               return bz[TileMap.r][var0];
            }
         }

         return -1;
      }
   }

   private static int J() {
      if (Char.myCharz().aD == null) {
         return -1;
      } else {
         for(int var0 = 0; var0 < by[TileMap.r].length; ++var0) {
            if (GameScr.ac[Char.myCharz().aD.a] == by[TileMap.r][var0]) {
               return bA[TileMap.r][var0];
            }
         }

         return -1;
      }
   }

   private void c(int var1) {
      this.bI = -1;
      this.d = aa;
      this.e = main.GameCanvas.A;
      this.b = 0;
      this.c = 0;
      this.aC = 24;
      this.bG = var1;
      if (var1 == 0) {
         this.ad = 2;
         this.ae = 80;
         this.af = this.d - 4;
         this.ag = this.e - 96;
         this.h = this.af;
         this.aJ = 0;
         this.b = 0;
      } else if (var1 == 1) {
         this.af = this.d - 4;
         this.ad = main.GameCanvas.z - this.af;
         this.ae = 80;
         this.ag = this.e - 96;
         this.b = this.ad - 2;
         this.h = -(main.GameCanvas.z + this.d);
         this.aJ = main.GameCanvas.z - this.d;
      }

      this.aD = this.d / 5 - 1;
      this.A = 0;
      this.aX = this.L[this.z];
      if (this.aX.length < 5) {
         this.aD += 5;
      }

      this.B = this.ad + this.af / 2 - this.aX.length * this.aD / 2;
      this.bo = new int[this.aX.length];
      this.aI = new int[this.aX.length];

      for(var1 = 0; var1 < this.aX.length; ++var1) {
         this.bo[var1] = main.GameCanvas.isTouch ? -1 : 0;
      }

      if (this.aW[this.z] != -1) {
         this.A = this.aW[this.z];
      }

      if (this.A < 0) {
         this.A = 0;
      }

      if (this.A > this.aX.length - 1) {
         this.A = this.aX.length - 1;
      }

      this.ch = null;
   }

   public final void b() {
      this.z = 14;
      this.c(0);
      this.aC = 24;
      this.N = this.D.length;
      this.aH = this.N * this.aC - this.ag;
      this.g = this.f = 0;
      this.aj = main.GameCanvas.isTouch ? -1 : 0;
      this.h = this.aJ = 0;
   }

   private void K() {
      GameScr.gI();
      if (!GameScr.f()) {
         if (ar) {
            if (Hint.a(2, 0)) {
               Hint.f = true;
               GameScr.info1.a(mResources.cp, 0);
            }

            if (Hint.a(3, 0)) {
               Hint.h = true;
            }

            this.z = 4;
            this.aX = this.L[this.z];
            this.B = this.ad + this.af / 2 - this.aX.length * this.aD / 2;
            this.h = this.aJ = 0;
            if (ar) {
               if (TileMap.s != TileMap.r) {
                  ResLog.c("LOAD TAM HINH");
                  if (mGraphics.zoomLevel == 1) {
                     SmallImage.b = null;
                     GameScr.bs = false;
                     System.gc();
                  }

                  aP = mSystem.loadImageRMS("/img/map" + TileMap.r + ".png");
                  TileMap.s = TileMap.r;
               }

               this.aK = G() - this.af / 2;
               this.aL = H() + this.ae - (this.ae + this.ag / 2);
               this.bW = this.aK;
               this.bX = this.aL;
               this.aM = 250 - this.af;
               this.aN = 220 - this.ag;
               if (this.aM < 0) {
                  this.aM = 0;
               }

               if (this.aN < 0) {
                  this.aN = 0;
               }

               for(int var2 = 0; var2 < by[TileMap.r].length; ++var2) {
                  if (TileMap.l == by[TileMap.r][var2]) {
                     this.cA = bz[TileMap.r][var2] + this.ad;
                     this.cB = bA[TileMap.r][var2] + this.ae + 5;
                     break;
                  }
               }

               this.cy = G() + this.ad;
               this.cz = H() + this.ae;
               I();
               J();
            }

         }
      }
   }

   public final void setTypeArchivement() {
      this.N = Char.myCharz().arrArchive.length;
      this.c(0);
      this.z = 9;
      this.aH = this.N * this.aC - this.ag;
      this.g = this.f = this.aI[this.A];
      if (this.aH < 0) {
         this.aH = 0;
      }

      if (this.g < 0) {
         this.g = this.f = 0;
      }

      if (this.g > this.aH) {
         this.g = this.f = 0;
      }

      this.aj = main.GameCanvas.isTouch ? -1 : 0;
   }

   public final void d() {
      this.z = 17;
      this.c(1);
      this.e();
      this.bI = 2;
      this.A = 0;
   }

   public final void e() {
      this.aC = 24;
      this.N = Char.myCharz().aJ[4].length;
      this.aH = this.N * this.aC - this.ag;
      if (this.aH < 0) {
         this.aH = 0;
      }

      this.g = this.f = this.aI[this.A];
      if (this.g < 0) {
         this.g = this.f = 0;
      }

      if (this.g > this.aH) {
         this.g = this.f = this.aH;
      }

      this.aj = main.GameCanvas.isTouch ? -1 : 0;
   }

   public final void f() {
      this.z = 7;
      this.c(1);
      this.b(true);
      this.A = 0;
   }

   public final void a(InfoItem var1) {
      this.bF.insertElementAt(var1, 0);
      if (this.bF.size() > 20) {
         this.bF.removeElementAt(this.bF.size() - 1);
      }

   }

   public final void g() {
      this.aC = 24;
      this.N = this.R.size();
      this.aH = this.N * this.aC - this.ag;
      if (this.aH < 0) {
         this.aH = 0;
      }

      this.g = this.f = this.aI[this.A];
      if (this.g < 0) {
         this.g = this.f = 0;
      }

      if (this.g > this.aH) {
         this.g = this.f = this.aH;
      }

      this.aj = main.GameCanvas.isTouch ? -1 : 0;
   }

   public final void h() {
      this.z = 18;
      this.c(0);
      this.aC = 24;
      this.aj = main.GameCanvas.isTouch ? -1 : 0;
      this.N = this.X.size();
      this.aH = this.N * this.aC - this.ag;
      if (this.aH < 0) {
         this.aH = 0;
      }

      this.g = this.f = this.aI[this.A];
      if (this.g < 0) {
         this.g = this.f = 0;
      }

      if (this.g > this.aH) {
         this.g = this.f = this.aH;
      }

      if (this.aj > this.N - 1) {
         this.aj = this.N - 1;
      }

      this.h = this.aJ = 0;
   }

   public final void a(Char var1) {
      this.z = 10;
      this.c(0);
      this.g();
      this.ab = var1;
   }

   public final void i() {
      this.z = 11;
      this.c(0);
      this.aC = 24;
      this.aj = main.GameCanvas.isTouch ? -1 : 0;
      this.k();
   }

   public final void j() {
      this.z = 16;
      this.c(0);
      this.aC = 24;
      this.aj = main.GameCanvas.isTouch ? -1 : 0;
      this.N = this.W.size();
      this.aH = this.N * this.aC - this.ag;
      if (this.aH < 0) {
         this.aH = 0;
      }

      this.g = this.f = this.aI[this.A];
      if (this.g < 0) {
         this.g = this.f = 0;
      }

      if (this.g > this.aH) {
         this.g = this.f = this.aH;
      }

      if (this.aj > this.N - 1) {
         this.aj = this.N - 1;
      }

      this.h = this.aJ = 0;
   }

   public final void a(byte var1) {
      this.z = 15;
      this.c(0);
      this.aC = 24;
      this.aj = main.GameCanvas.isTouch ? -1 : 0;
      this.N = this.V.size();
      this.aH = this.N * this.aC - this.ag;
      if (this.aH < 0) {
         this.aH = 0;
      }

      this.g = this.f = this.aI[this.A];
      if (this.g < 0) {
         this.g = this.f = 0;
      }

      if (this.g > this.aH) {
         this.g = this.f = this.aH;
      }

      if (this.aj > this.N - 1) {
         this.aj = this.N - 1;
      }

      this.h = this.aJ = 0;
      this.bH = var1 != 0;
   }

   public final void k() {
      this.N = this.S.size();
      this.aH = this.N * this.aC - this.ag;
      if (this.aH < 0) {
         this.aH = 0;
      }

      this.g = this.f = this.aI[this.A];
      if (this.g < 0) {
         this.g = this.f = 0;
      }

      if (this.g > this.aH) {
         this.g = this.f = this.aH;
      }

      if (this.aj > this.N - 1) {
         this.aj = this.N - 1;
      }

      this.h = this.aJ = 0;
   }

   public final void l() {
      this.z = 8;
      this.c(0);
      this.aC = 24;
      this.x();
      this.aj = main.GameCanvas.isTouch ? -1 : 0;
      this.A = 0;
   }

   public final void a(int var1) {
      this.z = 1;
      this.c(0);
      this.y();
      this.A = 0;
      this.bI = var1;
   }

   public final void m() {
      this.z = 2;
      if (main.GameCanvas.z > 2 * aa) {
         bb = new String[][]{mResources.cd};
      } else {
         bb = new String[][]{mResources.cd, mResources.ce};
      }

      this.L[2] = bb;
      this.c(0);
      if (this.A == 0) {
         this.T();
      }

      if (this.A == 1) {
         this.b(true);
      }

      if (main.GameCanvas.z > 2 * aa) {
         (main.GameCanvas.G = new Panel()).L[7] = new String[][]{{""}};
         main.GameCanvas.G.f();
         main.GameCanvas.G.show();
      }

   }

   public final void n() {
      this.z = 12;
      if (main.GameCanvas.z > 2 * aa) {
         bc = new String[][]{mResources.cf};
      } else {
         bc = new String[][]{mResources.cf, mResources.ce};
      }

      this.L[this.z] = bc;
      this.c(0);
      if (this.A == 0) {
         this.o();
      }

      if (this.A == 1) {
         this.b(true);
      }

      if (main.GameCanvas.z > 2 * aa) {
         (main.GameCanvas.G = new Panel()).L[7] = new String[][]{{""}};
         main.GameCanvas.G.f();
         main.GameCanvas.G.show();
      }

      this.au = -1;
      this.ay = true;
   }

   public final void o() {
      this.N = this.k.size() + 1;
      this.aC = 24;
      this.aH = this.N * this.aC - this.ag;
      if (this.aH < 0) {
         this.aH = 9;
      }

      this.g = this.f = this.aI[this.A];
      if (this.g < 0) {
         this.g = this.f = 0;
      }

      if (this.g > this.aH) {
         this.g = this.f = this.aH;
      }

      this.aj = main.GameCanvas.isTouch ? -1 : 0;
   }

   private void L() {
      this.z = 22;
      this.c(0);
      this.N = ba.length;
      this.aC = 24;
      this.aj = main.GameCanvas.isTouch ? -1 : 0;
      this.aH = this.N * this.aC - this.ag;
      if (this.aH < 0) {
         this.aH = 0;
      }

      this.g = this.f = this.aI[this.A];
      if (this.g < 0) {
         this.g = this.f = 0;
      }

      if (this.g > this.aH) {
         this.g = this.f = this.aH;
      }

      this.h = this.aJ = 0;
   }

   public final void p() {
      this.z = 21;
      if (main.GameCanvas.G != null) {
         bg = mResources.aP;
      } else {
         bg = mResources.aO;
      }

      this.L[21] = bg;
      if (Char.myCharz().cgender == 1) {
         this.cl = new String[]{mResources.u, mResources.t, mResources.s, mResources.w, mResources.gi, mResources.gj};
      } else {
         this.cl = new String[]{mResources.u, mResources.t, mResources.s, mResources.w, mResources.gi};
      }

      this.c(2);
      if (this.A == 0) {
         this.U();
      }

      if (this.A == 1) {
         this.P();
      }

      if (this.A == 2) {
         this.b(true);
      }

   }

   public final void q() {
      this.z = 0;
      this.c(0);
      if (this.A == 1) {
         this.b(true);
      }

      if (this.A == 2) {
         this.R();
      }

      if (this.A == 3) {
         if (this.C.length == 4) {
            this.Q();
         } else {
            this.setTabClans();
         }
      }

      if (this.A == 4) {
         this.Q();
      }

   }

   public final void r() {
      this.z = 3;
      this.c(0);
      this.S();
      this.h = this.aJ = 0;
   }

   private void b(Item var1) {
      this.ah = new ChatPopup();
      String var3 = "";
      if (var1.template.c != Char.myCharz().cgender) {
         if (var1.template.c == 0) {
            var3 = var3 + "\n|7|1|" + mResources.cq;
         } else if (var1.template.c == 1) {
            var3 = var3 + "\n|7|1|" + mResources.cr;
         } else if (var1.template.c == 2) {
            var3 = var3 + "\n|7|1|" + mResources.cs;
         }
      }

      String var2 = "";
      if (var1.itemOption != null) {
         for(int var4 = 0; var4 < var1.itemOption.length; ++var4) {
            if (var1.itemOption[var4].optionTemplate.name == 72) {
               var2 = " [+" + var1.itemOption[var4].param + "]";
            }
         }
      }

      boolean var6 = false;
      int var5;
      if (var1.itemOption != null) {
         for(var5 = 0; var5 < var1.itemOption.length; ++var5) {
            if (var1.itemOption[var5].optionTemplate.name == 41) {
               var6 = true;
               if (var1.itemOption[var5].param == 1) {
                  var3 = var3 + "|0|1|" + var1.template.d + var2;
               }

               if (var1.itemOption[var5].param == 2) {
                  var3 = var3 + "|2|1|" + var1.template.d + var2;
               }

               if (var1.itemOption[var5].param == 3) {
                  var3 = var3 + "|8|1|" + var1.template.d + var2;
               }

               if (var1.itemOption[var5].param == 4) {
                  var3 = var3 + "|7|1|" + var1.template.d + var2;
               }
            }
         }
      }

      if (!var6) {
         var3 = var3 + "|0|1|" + var1.template.d + var2;
      }

      if (var1.itemOption != null) {
         for(var5 = 0; var5 < var1.itemOption.length; ++var5) {
            if (var1.itemOption[var5].optionTemplate.type.startsWith("$")) {
               var2 = Util.replace(var1.itemOption[var5].optionTemplate.type, "$", "");
               if (var1.itemOption[var5].param == 1) {
                  var3 = var3 + "\n|1|1|" + var2;
               }

               if (var1.itemOption[var5].param == 0) {
                  var3 = var3 + "\n|0|1|" + var2;
               }
            } else if (!(var2 = var1.itemOption[var5].getOptionString()).equals("") && var1.itemOption[var5].optionTemplate.name != 72) {
               if (var1.itemOption[var5].optionTemplate.name == 102) {
                  this.ah.o = (byte)var1.itemOption[var5].param;
                  ResLog.c("STAR SLOT= " + this.ah.o);
               } else if (var1.itemOption[var5].optionTemplate.name == 107) {
                  this.ah.p = (byte)var1.itemOption[var5].param;
                  ResLog.c("STAR SLOT= " + this.ah.p);
               } else {
                  var3 = var3 + "\n|1|1|" + var2;
               }
            }
         }
      }

      if (this.bB.template.i > 1) {
         String var7 = mResources.ct + ": " + this.bB.template.i;
         if ((long)this.bB.template.i > Char.myCharz().cPower) {
            var3 = var3 + "\n|3|1|" + var7;
            var3 = var3 + "\n|3|1|" + mResources.cu + ": " + Char.myCharz().cPower;
         } else {
            var3 = var3 + "\n|6|1|" + var7;
         }
      } else {
         var3 = var3 + "\n|6|1|";
      }

      this.bB.A = this.a(this.bB);
      var3 = var3 + "\n--";
      var3 = var3 + "\n|6|" + var1.template.e;
      if (!var1.z.equals("")) {
         if (!var1.template.e.equals("")) {
            var3 = var3 + "\n--";
         }

         var3 = var3 + "\n|2|" + var1.z;
      }

      if (this.ah.p > 0) {
         var3 = var3 + "\n\n";
      }

      this.a(this.ah, var3);
      this.bJ = var1.template.f;
      this.bK = null;
      this.cG = null;
   }

   private void a(ChatPopup var1, String var2) {
      var1.t = false;
      var1.a = 180;
      var1.e = 3 + this.b - (this.b == 0 ? 0 : ResLog.g(var1.a - this.d) + 8);
      var1.d = mFont.p.getWidth(var2, var1.a - 10);
      var1.b = 10000000;
      var1.i = null;
      var1.c = 7;
      var1.g = 15 - var1.c + var1.d.length * 12 + 10;
      if (var1.g > main.GameCanvas.A - 80) {
         var1.g = main.GameCanvas.A - 80;
         var1.h = var1.d.length * 12 - var1.g + 17;
         if (var1.h < 0) {
            var1.h = 0;
         }

         ChatPopup.u = 0;
         var1.t = true;
      }

      for(var1.f = main.GameCanvas.menu.d - var1.g; var1.f < 10; ++main.GameCanvas.menu.d) {
         ++var1.f;
      }

      var1.s = 10;
   }

   private void a(ClanMessage var1) {
      this.ah = new ChatPopup();
      String var2 = "|0|" + var1.d;
      var2 = var2 + "\n|1|" + Member.a(var1.h);

      int var3;
      for(var3 = 0; var3 < this.myMember.size(); ++var3) {
         Member var4 = (Member)this.myMember.elementAt(var3);
         if (var1.c == var4.a) {
            var2 = var2 + "\n|5|" + mResources.cR + ": " + var4.l;
            var2 = var2 + "\n|5|" + mResources.cS + ": " + var4.k;
            var2 = var2 + "\n|4|" + mResources.cU + ": " + var4.i + mResources.cX;
            var2 = var2 + "\n|4|" + mResources.cV + ": " + var4.j + mResources.cX;
            this.bK = new int[]{var4.b, var4.d, var4.e};
            break;
         }
      }

      var2 = var2 + "\n--";

      for(var3 = 0; var3 < var1.f.length; ++var3) {
         var2 = var2 + "\n" + var1.f[var3];
      }

      if (var1.b == 1) {
         var2 = var2 + "\n|6|" + mResources.cY + " " + var1.i + "/" + var1.j;
      }

      this.a(this.ah, var2);
      this.cG = null;
   }

   private void a(Member var1) {
      String var2 = "|0|1|" + var1.f;
      String var3 = "\n|2|1|";
      if (var1.g == 0) {
         var3 = "\n|7|1|";
      }

      if (var1.g == 1) {
         var3 = "\n|1|1|";
      }

      if (var1.g == 2) {
         var3 = "\n|0|1|";
      }

      var2 = var2 + var3 + Member.a(var1.g);
      var2 = var2 + "\n|2|1|" + mResources.cZ + ": " + var1.h;
      var2 = var2 + "\n--";
      var2 = var2 + "\n|5|" + mResources.cR + ": " + var1.l;
      var2 = var2 + "\n|5|" + mResources.cS + ": " + var1.k;
      var2 = var2 + "\n|4|" + mResources.cU + ": " + var1.i + mResources.cX;
      var2 = var2 + "\n|4|" + mResources.cV + ": " + var1.j + mResources.cX;
      var2 = var2 + "\n|6|" + mResources.da + ": " + var1.m;
      this.ah = new ChatPopup();
      this.a(this.ah, var2);
      this.bK = new int[]{var1.b, var1.d, var1.e};
      this.bB = null;
      this.cG = null;
   }

   private void a(Clan var1) {
      try {
         String var2 = "|0|" + var1.c;
         String[] var3 = mFont.r.getWidth(var1.d, this.af - 60);

         for(int var4 = 0; var4 < var3.length; ++var4) {
            var2 = var2 + "\n|2|" + var3[var4];
         }

         var2 = var2 + "\n--";
         var2 = var2 + "\n|7|" + mResources.db + ": " + var1.i;
         var2 = var2 + "\n|1|" + mResources.dd + ": " + var1.f;
         var2 = var2 + "\n|4|" + mResources.de + ": " + var1.g + "/" + var1.h;
         var2 = var2 + "\n|4|" + mResources.dn + ": " + var1.j;
         var2 = var2 + "\n|4|" + mResources._do + ": " + Util.a(var1.e);
         this.ah = new ChatPopup();
         this.a(this.ah, var2);
         this.bJ = ClanImage.getClanImage((short)var1.b).idImage[0];
         this.bB = null;
      } catch (Exception var5) {
         var5.printStackTrace();
      }
   }

   private void a(SkillTemplate var1, Skill var2, Skill var3) {
      String var4 = "|0|" + var1.b;

      for(int var5 = 0; var5 < var1.g.length; ++var5) {
         var4 = var4 + "\n|4|" + var1.g[var5];
      }

      var4 = var4 + "\n--";
      if (var2 != null) {
         var4 = var4 + "\n|2|" + mResources.fa + ": " + var2.point;
         var4 = var4 + "\n|5|" + Util.replace(var1.i, "#", String.valueOf(var2.k));
         var4 = var4 + "\n|5|" + mResources.fb + var2.i + (var1.d == 1 ? "%" : "");
         var4 = var4 + "\n|5|" + mResources.fc + ": " + var2.a() + "s";
         var4 = var4 + "\n--";
         if (var2.point == var1.maxPoint) {
            var4 = var4 + "\n|0|" + mResources.fd;
         } else {
            if (!var2.template.c()) {
               var4 = var4 + "\n|1|" + mResources.fe + ResLog.a(var3.d) + " " + mResources.ff;
            }

            var4 = var4 + "\n|4|" + Util.replace(var1.i, "#", String.valueOf(var3.k));
         }
      } else {
         var4 = var4 + "\n|2|" + mResources.fg;
         var4 = var4 + "\n|1|" + mResources.fh + ResLog.a(var3.d) + " " + mResources.ff;
         var4 = var4 + "\n|4|" + Util.replace(var1.i, "#", String.valueOf(var3.k));
         var4 = var4 + "\n|4|" + mResources.fb + var3.i + (var1.d == 1 ? "%" : "");
         var4 = var4 + "\n|4|" + mResources.fc + ": " + var3.a() + "s";
      }

      this.bB = null;
      this.bK = null;
      this.cG = null;
      this.ah = new ChatPopup();
      this.a(this.ah, var4);
      this.bJ = 0;
   }

   public final void show() {
      if (main.GameCanvas.isTouch) {
         this.cmdClose.x = 156;
         this.cmdClose.y = 3;
      } else {
         this.cmdClose.x = main.GameCanvas.z - 19;
         this.cmdClose.y = main.GameCanvas.A - 19;
      }

      this.cmdClose.isPlaySoundButton = false;
      ChatPopup.currChatPopup = null;
      InfoDlg.hide();
      this.timeShow = 20;
      this.isShow = true;
      this.isClose = false;
      SoundMn.stopAll();
      if (this.isTypeShop()) {
         Char.myCharz().setPartOld();
      }

   }

   public final void t() {
      if (this.o != null && this.o.b) {
         if (this.o.d != null && (main.GameCanvas.keyPressed[12] || mScreen.a(this.o.d)) && this.o.d != null) {
            this.o.d.performAction();
         }

         if (this.o.e != null && (main.GameCanvas.keyPressed[13] || mScreen.a(this.o.e)) && this.o.e != null) {
            this.o.e.performAction();
         }

         if (this.o.f != null && (main.GameCanvas.keyPressed[5] || mScreen.a(this.o.f)) && this.o.f != null) {
            this.o.f.performAction();
         }

         if (this.o.b && main.GameCanvas.ae != 0) {
            this.o.a(main.GameCanvas.ae);
            main.GameCanvas.ae = 0;
         }

         main.GameCanvas.f();
         main.GameCanvas.clearKeyPressed();
      }
   }

   public final void u() {
      if (this.o == null || !this.o.b) {
         if (main.GameCanvas.panel.ay) {
            if (!InfoDlg.a) {
               if (this.tabIcon != null && this.tabIcon.k) {
                  nr_do var7;
                  if ((var7 = this.tabIcon).c != null && (main.GameCanvas.keyPressed[12] || mScreen.a(var7.c))) {
                     var7.c.performAction();
                  }

                  if (var7.d != null && (main.GameCanvas.keyPressed[13] || mScreen.a(var7.d))) {
                     var7.d.performAction();
                  }

                  if (!var7.l) {
                     if (nr_do.f == null) {
                        return;
                     }

                     if (main.GameCanvas.isTouch) {
                        nr_do.f.a();
                        var7.n = nr_do.f.n;
                     }

                     if (main.GameCanvas.keyPressed[2]) {
                        main.GameCanvas.keyPressed[2] = false;
                        --var7.n;
                        if (var7.n < 0) {
                           var7.n = var7.e - 1;
                        }

                        nr_do.f.a(var7.n * nr_do.f.o);
                     }

                     if (main.GameCanvas.keyPressed[8]) {
                        main.GameCanvas.keyPressed[8] = false;
                        ++var7.n;
                        if (var7.n > var7.e - 1) {
                           var7.n = 0;
                        }

                        nr_do.f.a(var7.n * nr_do.f.o);
                     }

                     if (var7.n != -1) {
                        var7.o = var7.n;
                     }
                  }

                  main.GameCanvas.f();
                  main.GameCanvas.clearKeyPressed();
               } else if (!this.isClose) {
                  if (this.isShow) {
                     if (this.cmdClose.isPointerPressInside()) {
                        this.cmdClose.performAction();
                     } else {
                        if (main.GameCanvas.keyPressed[13]) {
                           if (this.z != 4) {
                              this.A();
                              return;
                           }

                           this.q();
                           this.h = this.aJ = 0;
                        }

                        if (main.GameCanvas.keyPressed[12] || main.GameCanvas.keyPressed[5]) {
                           if (this.aV.e > 0) {
                              this.perform(this.aV.e, this.aV.n);
                           } else {
                              this.bU = 2;
                           }
                        }

                        if (this.equals(main.GameCanvas.panel) && main.GameCanvas.G == null && main.GameCanvas.m && !main.GameCanvas.b(this.b, 0, this.d, this.e) && !this.bS) {
                           this.A();
                        } else {
                           int var2;
                           int var3;
                           if (!this.bO) {
                              Panel var1 = this;
                              if ((this.ch == null || !this.ch.m) && !this.bS) {
                                 boolean var10000;
                                 label513: {
                                    var2 = this.A;
                                    if (this.dm > 0) {
                                       if (this.aX.length > 1) {
                                          if (this.aj == 0) {
                                             var10000 = true;
                                             break label513;
                                          }
                                       } else if (this.aj >= 0) {
                                          var10000 = true;
                                          break label513;
                                       }
                                    }

                                    var10000 = false;
                                 }

                                 if (!var10000) {
                                    if (main.GameCanvas.keyPressed[6]) {
                                       if (this.aw()) {
                                          if (this.aj >= 0) {
                                             this.ax();
                                          } else {
                                             ++this.A;
                                             if (this.A >= this.aX.length) {
                                                if (main.GameCanvas.G != null) {
                                                   this.A = this.aX.length - 1;
                                                   main.GameCanvas.W = true;
                                                } else {
                                                   this.A = 0;
                                                }
                                             }

                                             this.aj = this.bo[this.A];
                                             this.aW[this.z] = this.A;
                                          }
                                       } else {
                                          ++this.A;
                                          if (this.A >= this.aX.length) {
                                             if (main.GameCanvas.G != null) {
                                                this.A = this.aX.length - 1;
                                                main.GameCanvas.W = true;
                                             } else {
                                                this.A = 0;
                                             }
                                          }

                                          this.aj = this.bo[this.A];
                                          this.aW[this.z] = this.A;
                                       }
                                    }

                                    if (main.GameCanvas.keyPressed[4]) {
                                       --this.A;
                                       if (this.A < 0) {
                                          this.A = this.aX.length - 1;
                                       }

                                       if (main.GameCanvas.W) {
                                          main.GameCanvas.W = false;
                                       }

                                       this.aj = this.bo[this.A];
                                       this.aW[this.z] = this.A;
                                    }
                                 }

                                 this.ce = -1;

                                 for(var3 = 0; var3 < var1.aX.length; ++var3) {
                                    if (main.GameCanvas.b(var1.B + var3 * var1.aD, 52, var1.aD - 1, 25)) {
                                       var1.ce = var3;
                                       if (main.GameCanvas.m) {
                                          var1.A = var3;
                                          var1.aW[var1.z] = var3;
                                          main.GameCanvas.m = false;
                                          var1.aj = var1.bo[var1.A];
                                          if (var2 == var1.A && var1.bV == 0) {
                                             var1.f = 0;
                                             var1.aj = main.GameCanvas.isTouch ? -1 : 0;
                                          }
                                          break;
                                       }
                                    }
                                 }

                                 if (var2 != var1.A) {
                                    var1.dm = 0;
                                    SoundMn.stopAll();
                                    switch(var1.z) {
                                    case 0:
                                       if (var1.A == 0) {
                                          var1.aO = 0;
                                       }

                                       if (var1.A == 1) {
                                          var1.b(true);
                                       }

                                       if (var1.A == 2) {
                                          var1.R();
                                       }

                                       if (var1.A == 3) {
                                          if (var1.C.length > 4) {
                                             var1.setTabClans();
                                          } else {
                                             var1.Q();
                                          }
                                       }

                                       if (var1.A == 4) {
                                          var1.Q();
                                       }
                                       break;
                                    case 1:
                                       var1.y();
                                       break;
                                    case 2:
                                       if (var1.A == 0) {
                                          var1.T();
                                       }

                                       if (var1.A == 1) {
                                          var1.b(true);
                                       }
                                       break;
                                    case 3:
                                       var1.S();
                                       break;
                                    case 12:
                                       if (var1.A == 0) {
                                          var1.o();
                                       }

                                       if (var1.A == 1) {
                                          var1.b(true);
                                       }
                                       break;
                                    case 13:
                                       if (var1.A == 0) {
                                          if (var1.equals(main.GameCanvas.panel)) {
                                             var1.b(true);
                                          } else if (var1.equals(main.GameCanvas.G)) {
                                             var1.a(false);
                                          }
                                       }

                                       if (var1.A == 1) {
                                          var1.a(true);
                                       }

                                       if (var1.A == 2) {
                                          var1.a(false);
                                       }
                                       break;
                                    case 21:
                                       if (var1.A == 0) {
                                          var1.U();
                                       }

                                       if (var1.A == 1) {
                                          var1.P();
                                       }

                                       if (var1.A == 2) {
                                          var1.b(true);
                                       }
                                       break;
                                    case 25:
                                       var1.av();
                                    }

                                    var1.aj = var1.bo[var1.A];
                                 }
                              }
                           }

                           switch(this.z) {
                           case 0:
                              if (this.A == 0) {
                                 if (main.GameCanvas.j[2]) {
                                    this.aO -= 5;
                                 }

                                 if (main.GameCanvas.j[8]) {
                                    this.aO += 5;
                                 }

                                 if (this.aO < 0) {
                                    this.aO = 0;
                                 }

                                 if ((var2 = this.cv * 12 - (this.ag - 60)) < 0) {
                                    var2 = 0;
                                 }

                                 if (this.aO > var2) {
                                    this.aO = var2;
                                 }

                                 if (this.ch != null) {
                                    if (!main.GameCanvas.isTouch) {
                                       this.ch.d = this.aO;
                                    }

                                    this.ch.a();
                                 }

                                 var3 = this.ad + this.af / 2 - 35;
                                 int var4 = main.GameCanvas.A > 300 ? 20 : 15;
                                 var2 = this.ae + this.ag - var4 - 15;
                                 var4 = main.GameCanvas.o;
                                 int var5 = main.GameCanvas.p;
                                 this.cc = -1;
                                 if (ar) {
                                    GameScr.gI();
                                    if (!GameScr.e() && var4 >= var3 && var4 <= var3 + 70 && var5 >= var2 && var5 <= var2 + 30 && (this.ch == null || !this.ch.m)) {
                                       this.cc = 1;
                                       if (main.GameCanvas.m) {
                                          SoundMn.stopAll();
                                          this.bU = 2;
                                          main.GameCanvas.k();
                                       }
                                    }
                                 }

                                 main.GameCanvas.clearKeyPressed();
                                 return;
                              }

                              if (this.A == 1) {
                                 this.ay();
                              }

                              if (this.A == 2) {
                                 this.O();
                              }

                              if (this.A == 3) {
                                 if (this.C.length == 4) {
                                    this.O();
                                 } else {
                                    this.O();
                                    if (this.aY != null) {
                                       if (main.GameCanvas.keyPressed[4]) {
                                          this.bD = this.X();
                                          --this.bM;
                                          if (this.aj == 0 && this.bM < 0) {
                                             this.bM = this.aY.length - 1;
                                          }

                                          if (this.aj > 1 && this.al && this.bD.k != null && this.bM < 0) {
                                             this.bM = this.bD.k.length - 1;
                                          }
                                       } else if (main.GameCanvas.keyPressed[6]) {
                                          this.bD = this.X();
                                          ++this.bM;
                                          if (this.aj == 0 && this.bM > this.aY.length - 1) {
                                             this.bM = 0;
                                          }

                                          if (this.aj > 1 && this.al && this.bD.k != null && this.bM > this.bD.k.length - 1) {
                                             this.bM = 0;
                                          }
                                       }
                                    }
                                 }
                              }

                              if (this.A != 4) {
                                 break;
                              }
                           case 20:
                              this.O();
                              break;
                           case 1:
                           case 17:
                           case 25:
                              if (this.A < this.aX.length - (main.GameCanvas.G != null ? 0 : 1) && this.z != 17) {
                                 this.O();
                              } else if (this.bI == 0) {
                                 this.ay();
                              } else {
                                 this.O();
                              }
                              break;
                           case 2:
                              this.ay();
                              break;
                           case 3:
                           case 26:
                              this.O();
                              break;
                           case 4:
                              if (main.GameCanvas.j[2]) {
                                 this.cB -= 5;
                                 this.aL = this.cB - (this.ae + this.ag / 2);
                                 if (this.cB < this.ae) {
                                    this.cB = this.ae;
                                 }
                              }

                              if (main.GameCanvas.j[8]) {
                                 this.cB += 5;
                                 this.aL = this.cB - (this.ae + this.ag / 2);
                                 if (this.cB > this.ae + 200) {
                                    this.cB = this.ae + 200;
                                 }
                              }

                              if (main.GameCanvas.j[4]) {
                                 this.cA -= 5;
                                 this.aK = this.cA - this.af / 2;
                                 if (this.cA < 16) {
                                    this.cA = 16;
                                 }
                              }

                              if (main.GameCanvas.j[6]) {
                                 this.cA += 5;
                                 this.aK = this.cA - this.af / 2;
                                 if (this.cA > 250) {
                                    this.cA = 250;
                                 }
                              }

                              if (main.GameCanvas.k) {
                                 this.bS = true;
                                 if (!this.bY) {
                                    this.bW = this.aK;
                                    this.bX = this.aL;
                                    this.bY = true;
                                 }

                                 this.aK = this.bW + (main.GameCanvas.s - main.GameCanvas.o);
                                 this.aL = this.bX + (main.GameCanvas.t - main.GameCanvas.p);
                              }

                              if (main.GameCanvas.m) {
                                 this.bY = false;
                                 main.GameCanvas.s = main.GameCanvas.o;
                                 main.GameCanvas.t = main.GameCanvas.p;
                                 this.bZ = main.GameCanvas.s + this.aK;
                                 this.ca = main.GameCanvas.t + this.aL;
                              }

                              if (main.GameCanvas.l) {
                                 this.bS = false;
                              }

                              if (this.aK < 0) {
                                 this.aK = 0;
                              }

                              if (this.aK > this.aM) {
                                 this.aK = this.aM;
                              }

                              if (this.aL < 0) {
                                 this.aL = 0;
                              }

                              if (this.aL > this.aN) {
                                 this.aL = this.aN;
                              }

                              main.GameCanvas.clearKeyPressed();
                              return;
                           case 5:
                           case 6:
                           case 22:
                           default:
                              break;
                           case 7:
                              this.ay();
                              break;
                           case 8:
                              this.O();
                              break;
                           case 9:
                              this.O();
                              break;
                           case 10:
                              this.O();
                              break;
                           case 11:
                           case 16:
                              this.O();
                              break;
                           case 12:
                              if (this.A == 0) {
                                 this.O();
                                 this.cb = -1;
                                 if (this.aj == this.k.size() && main.GameCanvas.l) {
                                    main.GameCanvas.l = false;
                                    this.cb = 1;
                                 }
                              }

                              if (this.A == 1) {
                                 this.O();
                              }
                              break;
                           case 13:
                              if (this.A == 0) {
                                 if (this.equals(main.GameCanvas.panel)) {
                                    this.ay();
                                 }

                                 if (this.equals(main.GameCanvas.G)) {
                                    this.O();
                                 }
                              }

                              if (this.A == 1 || this.A == 2) {
                                 this.O();
                              }
                              break;
                           case 14:
                              this.O();
                              break;
                           case 15:
                              this.O();
                              break;
                           case 18:
                              this.O();
                              break;
                           case 19:
                              this.O();
                              break;
                           case 21:
                              if (this.A == 0) {
                                 this.O();
                              }

                              if (this.A == 1) {
                                 this.O();
                              }

                              if (this.A == 2) {
                                 this.O();
                              }
                              break;
                           case 23:
                           case 24:
                              this.O();
                           }

                           main.GameCanvas.f();

                           for(int var6 = 0; var6 < main.GameCanvas.keyPressed.length; ++var6) {
                              main.GameCanvas.keyPressed[var6] = false;
                           }

                        }
                     }
                  }
               }
            }
         }
      }
   }

   public final void a(boolean var1) {
      this.N = var1 ? this.T.size() + 3 : this.U.size() + 3;
      this.aC = 24;
      this.aj = main.GameCanvas.isTouch ? -1 : 0;
      this.aH = this.N * this.aC - this.ag;
      if (this.aH < 0) {
         this.aH = 0;
      }

      this.g = this.f = this.aI[this.A];
      if (this.g < 0) {
         this.g = this.f = 0;
      }

      if (this.g > this.aH) {
         this.g = this.f = this.aH;
      }

   }

   public final void b(Char var1) {
      this.z = 13;
      this.L[this.z] = bf;
      this.aS = false;
      this.aR = false;
      this.m = false;
      this.T.removeAllElements();
      this.U.removeAllElements();
      this.aQ = 0;
      this.l = 0;
      if (main.GameCanvas.z > 2 * aa) {
         (main.GameCanvas.G = new Panel()).z = 13;
         main.GameCanvas.G.L[this.z] = new String[][]{mResources.ci};
         main.GameCanvas.G.c(1);
         main.GameCanvas.G.a(false);
         main.GameCanvas.panel.L[this.z] = new String[][]{mResources.ce, mResources.ch};
         main.GameCanvas.G.show();
         main.GameCanvas.G.ab = var1;
      }

      if (this.equals(main.GameCanvas.panel)) {
         this.c(0);
      }

      if (this.A == 0) {
         this.b(true);
      }

      if (this.A == 1) {
         this.a(true);
      }

      if (this.A == 2) {
         this.a(false);
      }

      this.ab = var1;
   }

   private void a(mGraphics var1, boolean var2) {
      var1.setColor(16711680);
      var1.e(this.ad, this.ae, this.af, this.ag);
      var1.setColor(0, -this.g);
      MyVector var3 = var2 ? this.T : this.U;

      for(int var4 = 0; var4 < this.N; ++var4) {
         int var5 = this.ad + 36;
         int var6 = this.ae + var4 * this.aC;
         int var7 = this.af - 36;
         int var8 = this.aC - 1;
         int var9 = this.ad;
         int var10 = this.ae + var4 * this.aC;
         int var11 = this.aC - 1;
         if (var6 - this.g <= this.ae + this.ag && var6 - this.g >= this.ae - this.aC) {
            if (var4 == this.N - 1) {
               if (var2) {
                  var1.setColor(15196114);
                  var1.b(var9, var6, this.af, var8);
                  if (!this.aR) {
                     if (!this.m) {
                        mFont.o.drawStringBd(var1, mResources.dT + mResources.dL, this.ad + this.af / 2, var6 + var8 / 2 - 4, 2);
                     } else {
                        mFont.o.drawStringBd(var1, mResources.dT + mResources.dN, this.ad + this.af / 2, var6 + var8 / 2 - 4, 2);
                     }
                  } else if (this.m) {
                     var1.setColor(15196114);
                     var1.b(var9, var6, this.af, var8);
                     var1.drawImage(var4 == this.aj ? GameScr.ay : GameScr.ax, this.ad + this.af - 5, var6 + 2, StaticObj.TOP_RIGHT);
                     (var4 == this.aj ? mFont.g : mFont.tahoma_7b_dark).drawStringBd(var1, mResources.dS, this.ad + this.af - 22, var6 + 7, 2);
                     mFont.o.drawStringBd(var1, mResources.dT + mResources.dN, this.ad + 5, var6 + var8 / 2 - 4, 0);
                  } else {
                     mFont.o.drawStringBd(var1, mResources.dT + mResources.dL, this.ad + this.af / 2, var6 + var8 / 2 - 4, 2);
                  }
               }
            } else if (var4 == this.N - 2) {
               if (var2) {
                  var1.setColor(15196114);
                  var1.b(var9, var6, this.af, var8);
                  if (!this.aS) {
                     if (!this.aR) {
                        var1.drawImage(var4 == this.aj ? GameScr.ay : GameScr.ax, this.ad + this.af - 5, var6 + 2, StaticObj.TOP_RIGHT);
                        (var4 == this.aj ? mFont.g : mFont.tahoma_7b_dark).drawStringBd(var1, mResources.dV, this.ad + this.af - 22, var6 + 7, 2);
                        mFont.o.drawStringBd(var1, mResources.dU + mResources.dL, this.ad + 5, var6 + var8 / 2 - 4, 0);
                     } else {
                        var1.drawImage(var4 == this.aj ? GameScr.ay : GameScr.ax, this.ad + this.af - 5, var6 + 2, StaticObj.TOP_RIGHT);
                        (var4 == this.aj ? mFont.g : mFont.tahoma_7b_dark).drawStringBd(var1, mResources.bu, this.ad + this.af - 22, var6 + 7, 2);
                        mFont.o.drawStringBd(var1, mResources.dU + mResources.dN, this.ad + 5, var6 + var8 / 2 - 4, 0);
                     }
                  }
               } else if (!this.m) {
                  mFont.tahoma_7b_dark.drawStringBd(var1, mResources.dM, this.ad + this.af / 2, var6 + var8 / 2 - 4, 2);
               } else {
                  mFont.tahoma_7b_dark.drawStringBd(var1, mResources.dO, this.ad + this.af / 2, var6 + var8 / 2 - 4, 2);
               }
            } else {
               mGraphics var10000;
               int var10001;
               if (var4 == this.N - 3) {
                  if (this.aR) {
                     var10000 = var1;
                     var10001 = 13748667;
                  } else {
                     var10000 = var1;
                     var10001 = var4 == this.aj ? 16383818 : 15196114;
                  }

                  var10000.setColor(var10001);
                  var1.b(var5, var6, var7, var8);
                  if (this.aR) {
                     var10000 = var1;
                     var10001 = 13748667;
                  } else {
                     var10000 = var1;
                     var10001 = var4 == this.aj ? 7300181 : 9993045;
                  }

                  var10000.setColor(var10001);
                  var1.b(var9, var10, 34, var11);
                  var1.drawImage(v, var9 + 17, var10 + var11 / 2, 3);
                  mFont.m.drawStringBd(var1, Util.a((long)(var2 ? this.aQ : this.l)) + " " + mResources.bC, var5 + 5, var6 + 11, 0);
                  mFont.r.drawStringBd(var1, mResources.dW, var5 + 5, var6, 0);
               } else {
                  if (var3.size() == 0) {
                     return;
                  }

                  if (this.aR) {
                     var10000 = var1;
                     var10001 = 13748667;
                  } else {
                     var10000 = var1;
                     var10001 = var4 == this.aj ? 16383818 : 15196114;
                  }

                  var10000.setColor(var10001);
                  var1.b(var5, var6, var7, var8);
                  if (this.aR) {
                     var10000 = var1;
                     var10001 = 13748667;
                  } else {
                     var10000 = var1;
                     var10001 = var4 == this.aj ? 9541120 : 9993045;
                  }

                  var10000.setColor(var10001);
                  Item var14;
                  if ((var14 = (Item)var3.elementAt(var4)) != null) {
                     for(var8 = 0; var8 < var14.itemOption.length; ++var8) {
                        byte var12;
                        if (var14.itemOption[var8].optionTemplate.name == 72 && var14.itemOption[var8].param > 0 && f(var12 = g(var14.itemOption[var8].param)) != -1) {
                           if (this.aR) {
                              var10000 = var1;
                              var10001 = 13748667;
                           } else {
                              var10000 = var1;
                              int var10002 = this.aj;
                              var10001 = f(var12);
                           }

                           var10000.setColor(var10001);
                        }
                     }
                  }

                  var1.b(var9, var10, 34, var11);
                  if (var14 != null) {
                     String var15 = "";
                     mFont var17 = mFont.m;
                     if (var14.itemOption != null) {
                        for(int var13 = 0; var13 < var14.itemOption.length; ++var13) {
                           if (var14.itemOption[var13].optionTemplate.name == 72) {
                              var15 = " [+" + var14.itemOption[var13].param + "]";
                           }

                           if (var14.itemOption[var13].optionTemplate.name == 41) {
                              if (var14.itemOption[var13].param == 1) {
                                 var17 = h(0);
                              } else if (var14.itemOption[var13].param == 2) {
                                 var17 = h(2);
                              } else if (var14.itemOption[var13].param == 3) {
                                 var17 = h(8);
                              } else if (var14.itemOption[var13].param == 4) {
                                 var17 = h(7);
                              }
                           }
                        }
                     }

                     var17.drawStringBd(var1, var14.template.d + var15, var5 + 5, var6 + 1, 0);
                     String var18 = "";
                     if (var14.itemOption != null) {
                        if (var14.itemOption.length > 0 && var14.itemOption[0] != null) {
                           var18 = var18 + var14.itemOption[0].getOptionString();
                        }

                        mFont var16 = mFont.q;
                        if (var14.A < 0 && var14.template.type != 5) {
                           var16 = mFont.p;
                        }

                        if (var14.itemOption.length > 1) {
                           for(int var19 = 1; var19 < var14.itemOption.length; ++var19) {
                              if (var14.itemOption[var19] != null && var14.itemOption[var19].optionTemplate.name != 102 && var14.itemOption[var19].optionTemplate.name != 107) {
                                 var18 = var18 + "," + var14.itemOption[var19].getOptionString();
                              }
                           }
                        }

                        var16.drawStringBd(var1, var18, var5 + 5, var6 + 11, 0);
                     }

                     SmallImage.b(var1, var14.template.f, var9 + 17, var10 + var11 / 2, 0, 3);
                     if (var14.itemOption != null) {
                        for(var8 = 0; var8 < var14.itemOption.length; ++var8) {
                           this.a(var1, var14.itemOption[var8].optionTemplate.name, var9, var10, var11);
                        }

                        for(var8 = 0; var8 < var14.itemOption.length; ++var8) {
                           a(var1, var14.itemOption[var8].optionTemplate.name, var14.itemOption[var8].param, var9, var10, 34, var11);
                        }
                     }

                     if (var14.quantity > 1) {
                        mFont.n.drawStringBd(var1, "" + var14.quantity, var9 + 34, var10 + var11 - mFont.n.getWidth(), 1);
                     }
                  }
               }
            }
         }
      }

      this.f(var1);
   }

   private void M() {
      this.bO = false;
      if (this.z == 0 && this.C.length == 5 && this.A == 3) {
         this.bO = false;
         int var1;
         if (this.aj == 0) {
            this.aY = new int[this.cf.length];

            for(var1 = 0; var1 < this.aY.length; this.aY[var1] = var1++) {
            }

            if (!this.am) {
               this.bO = true;
               return;
            }
         } else if (this.aj != 1) {
            if (this.ak) {
               return;
            }

            if (this.aj > 0) {
               this.aY = new int[1];

               for(var1 = 0; var1 < this.aY.length; this.aY[var1] = var1++) {
               }

               this.bO = true;
            }
         }
      }

   }

   private void N() {
      try {
         if (this.z == 0 && this.A == 3 && this.C.length == 5) {
            if (this.aj == -1) {
               return;
            }

            int var1 = 0;
            if (this.aj == 0) {
               var1 = this.ad + this.af / 2 - this.cf.length * this.aD / 2;
               this.bM = (main.GameCanvas.o - var1) / this.aD;
            } else {
               this.bD = this.X();
               if (this.bD != null && this.bD.k != null) {
                  var1 = this.ad + this.af - 2 - this.bD.k.length * 40;
                  this.bM = (main.GameCanvas.o - var1) / 40;
               }
            }

            if (main.GameCanvas.o < var1) {
               this.bM = -1;
               return;
            }
         }
      } catch (Exception var2) {
         var2.printStackTrace();
      }

   }

   private void O() {
      if (this.N > 0) {
         boolean var1 = false;
         if (main.GameCanvas.keyPressed[2]) {
            var1 = true;
            --this.aj;
            if (this.z == 24) {
               this.aj -= 2;
               if (this.aj < 0) {
                  this.aj = 0;
               }
            } else if (this.aj < 0) {
               if (this.equals(main.GameCanvas.panel) && this.bI == 2 && this.A <= 3 && this.J[this.A] > 1) {
                  InfoDlg.a();
                  if (this.K[this.A] <= 0) {
                     Service.gI().a((byte)4, -1, (byte)this.A, this.J[this.A] - 1, -1);
                     return;
                  }

                  Service.gI().a((byte)4, -1, (byte)this.A, this.K[this.A] - 1, -1);
                  return;
               }

               this.aj = this.N - 1;
               if (this.bO) {
                  this.aj = -1;
               }

               if (this.dm > 0) {
                  this.aj = -1;
               }
            }

            this.bo[this.A] = this.aj;
            this.bM = 0;
            this.M();
         } else if (main.GameCanvas.keyPressed[8]) {
            var1 = true;
            ++this.aj;
            if (this.z == 24) {
               this.aj += 2;
               if (this.aj > this.N - 1) {
                  this.aj = this.N - 1;
               }
            } else if (this.aj > this.N - 1) {
               if (this.equals(main.GameCanvas.panel) && this.bI == 2 && this.A <= 3 && this.J[this.A] > 1) {
                  InfoDlg.a();
                  if (this.K[this.A] >= this.J[this.A] - 1) {
                     Service.gI().a((byte)4, -1, (byte)this.A, 0, -1);
                     return;
                  }

                  Service.gI().a((byte)4, -1, (byte)this.A, this.K[this.A] + 1, -1);
                  return;
               }

               this.aj = 0;
            }

            this.bo[this.A] = this.aj;
            this.bM = 0;
            this.M();
         }

         if (var1) {
            this.f = this.aj * this.aC - this.ag / 2;
            if (this.f > this.aH) {
               this.f = this.aH;
            }

            if (this.f < 0) {
               this.f = 0;
            }

            this.g = this.f;
         }

         int var2;
         int var3;
         if (main.GameCanvas.k) {
            this.cd = false;
            if (!this.bS && main.GameCanvas.b(this.ad, this.ae, this.af, this.ag)) {
               for(var3 = 0; var3 < this.bR.length; ++var3) {
                  this.bR[0] = main.GameCanvas.p;
               }

               this.bQ = main.GameCanvas.p;
               this.bS = true;
               this.bT = this.bV != 0;
               this.bV = 0;
            } else if (this.bS) {
               ++this.bP;
               if (this.bP > 5 && this.bQ == main.GameCanvas.p && !this.bT) {
                  this.bQ = -1000;
                  this.aj = (this.f + main.GameCanvas.p - this.ae) / this.aC;
                  if (this.aj >= this.N) {
                     this.aj = -1;
                  }

                  this.N();
               }

               if ((var3 = main.GameCanvas.p - this.bR[0]) != 0 && this.aj != -1) {
                  this.aj = -1;
                  this.bM = -1;
               }

               for(var2 = this.bR.length - 1; var2 > 0; --var2) {
                  this.bR[var2] = this.bR[var2 - 1];
               }

               this.bR[0] = main.GameCanvas.p;
               this.f -= var3;
               if (this.f < 0) {
                  this.f = 0;
               }

               if (this.f > this.aH) {
                  this.f = this.aH;
               }

               if (this.g < 0 || this.g > this.aH) {
                  var3 /= 2;
               }

               this.g -= var3;
            }
         }

         if (main.GameCanvas.m && this.bS) {
            this.cd = true;
            var3 = main.GameCanvas.p - this.bR[0];
            main.GameCanvas.m = false;
            if (ResLog.g(var3) < 20 && ResLog.g(main.GameCanvas.p - this.bQ) < 20 && !this.bT) {
               this.bV = 0;
               this.f = this.g;
               this.bQ = -1000;
               this.aj = (this.f + main.GameCanvas.p - this.ae) / this.aC;
               if (this.aj >= this.N) {
                  this.aj = -1;
               }

               this.N();
               this.bP = 0;
               this.bU = 10;
               SoundMn.stopAll();
            } else if (this.aj != -1 && this.bP > 5) {
               this.bP = 0;
               this.bU = 1;
            } else if (this.aj == -1 && !this.bT) {
               if (this.g < 0) {
                  this.f = 0;
               } else if (this.g > this.aH) {
                  this.f = this.aH;
               } else {
                  byte var4;
                  if ((var2 = main.GameCanvas.p - this.bR[0] + (this.bR[0] - this.bR[1]) + (this.bR[1] - this.bR[2])) > 10) {
                     var4 = 10;
                  } else if (var2 < -10) {
                     var4 = -10;
                  } else {
                     var4 = 0;
                  }

                  this.bV = -var4 * 100;
               }
            }

            if ((this.aw() || this.z == 13) && main.GameCanvas.p < this.ae + 21) {
               this.aj = 0;
               this.ax();
            }

            this.bS = false;
            this.bP = 0;
            main.GameCanvas.m = false;
         }

      }
   }

   private void P() {
      this.N = this.cl.length;
      this.aC = 24;
      this.aj = main.GameCanvas.isTouch ? -1 : 0;
      this.aH = this.N * this.aC - this.ag;
      if (this.aH < 0) {
         this.aH = 0;
      }

      this.g = this.f = this.aI[this.A];
      if (this.g < 0) {
         this.g = this.f = 0;
      }

      if (this.g > this.aH) {
         this.g = this.f = this.aH;
      }

   }

   private void Q() {
      SoundMn.stopAll();
      SoundMn.f();
      this.N = F.length;
      this.aC = 24;
      this.aj = main.GameCanvas.isTouch ? -1 : 0;
      this.aH = this.N * this.aC - this.ag;
      if (this.aH < 0) {
         this.aH = 0;
      }

      this.g = this.f = this.aI[this.A];
      if (this.g < 0) {
         this.g = this.f = 0;
      }

      if (this.g > this.aH) {
         this.g = this.f = this.aH;
      }

   }

   public final void v() {
      if (this.ak) {
         this.N = this.O == null ? 2 : this.O.length + 2;
         this.cg = mResources.dp;
      } else if (this.am) {
         this.an = "";
         this.N = (this.member == null ? this.myMember.size() : this.member.size()) + 2;
         this.cg = mResources.de + " " + (this.bC != null ? this.bC.c : Char.myCharz().clan.c);
      } else if (this.al) {
         this.N = ClanMessage.vMessage.size() + 2;
         this.cg = mResources.ad;
         this.an = "";
      }

      if (Char.myCharz().clan == null) {
         this.cf = new String[][]{mResources.dj, mResources.di};
      } else if (!this.am) {
         if (this.myMember.size() > 1) {
            this.cf = new String[][]{mResources.dg, mResources.dm, mResources.df};
         } else {
            this.cf = new String[][]{mResources.df};
         }
      } else if (Char.myCharz().aj > 0) {
         this.cf = new String[][]{mResources.ae, mResources.dh};
      } else if (this.myMember.size() > 1) {
         this.cf = new String[][]{mResources.ae, mResources.dh, mResources.dk, mResources.dl};
      } else {
         this.cf = new String[][]{mResources.ae, mResources.dk, mResources.dl};
      }

      this.aH = this.N * this.aC - this.ag;
      if (this.aH < 0) {
         this.aH = 0;
      }

      this.g = this.f = this.aI[this.A];
      if (this.g < 0) {
         this.g = this.f = 0;
      }

      if (this.g > this.aH) {
         this.g = this.f = this.aH;
      }

   }

   public final void setTabClans() {
      GameScr.aV = false;
      this.aC = 24;
      if (this.bo != null && this.bo[3] == 0) {
         this.bo[3] = -1;
      }

      this.N = 2;
      if (Char.myCharz().clan != null) {
         this.al = true;
         this.am = false;
         this.ak = false;
      } else {
         this.al = false;
         this.am = false;
         this.ak = true;
      }

      if (Char.myCharz().clan != null) {
         this.N = ClanMessage.vMessage.size() + 2;
      }

      this.v();
      this.bM = -1;
      if (this.o == null) {
         this.o = new ChatTextField();
         this.o.a.b = main.GameCanvas.A - 35 - ChatTextField.gI().a.height;
         this.o.a();
         this.o.c = main.GameCanvas.panel;
      }

      if (Char.myCharz().clan == null) {
         this.an = mResources.dJ;
         Service.gI().a("");
      }

      this.aj = this.bo[this.A];
      if (main.GameCanvas.isTouch) {
         this.aj = -1;
      }

   }

   public final void x() {
      this.N = this.bF.size() + 1;
      this.aH = this.N * this.aC - this.ag;
      if (this.aH < 0) {
         this.aH = 0;
      }

      this.g = this.f = this.aI[this.A];
      if (this.g < 0) {
         this.g = this.f = 0;
      }

      if (this.g > this.aH) {
         this.g = this.f = this.aH;
      }

      this.h = this.aJ = 0;
   }

   public final void y() {
      this.aC = 24;
      if (this.A == this.aX.length - 1 && main.GameCanvas.G == null && this.bI != 2) {
         this.N = this.i(Char.myCharz().arrItemBody.length + Char.myCharz().arrItemBag.length);
      } else {
         this.N = Char.myCharz().aJ[this.A].length;
      }

      this.aH = this.N * this.aC - this.ag;
      if (this.aH < 0) {
         this.aH = 0;
      }

      this.g = this.f = this.aI[this.A];
      if (this.g < 0) {
         this.g = this.f = 0;
      }

      if (this.g > this.aH) {
         this.g = this.f = this.aH;
      }

      this.aj = main.GameCanvas.isTouch ? -1 : 0;
   }

   private void R() {
      this.aC = 30;
      this.N = Char.myCharz().nClass.b.length + 6;
      this.aH = this.N * this.aC - this.ag;
      if (this.aH < 0) {
         this.aH = 0;
      }

      this.g = this.f = this.aI[this.A];
      if (this.g < 0) {
         this.g = this.f = 0;
      }

      if (this.g > this.aH) {
         this.g = this.aH;
      }

      this.aj = main.GameCanvas.isTouch ? -1 : 0;
   }

   private void S() {
      this.aC = 24;
      this.N = GameScr.gI().R.length;
      this.aH = this.N * this.aC - this.ag;
      this.g = this.f = 0;
      this.aj = main.GameCanvas.isTouch ? -1 : 0;
   }

   private void T() {
      this.N = this.i(Char.myCharz().arrItemBox.length);
      this.aC = 24;
      this.aH = this.N * this.aC - this.ag;
      if (this.aH < 0) {
         this.aH = 9;
      }

      this.g = this.f = this.aI[this.A];
      if (this.g < 0) {
         this.g = this.f = 0;
      }

      if (this.g > this.aH) {
         this.g = this.f = this.aH;
      }

      this.aj = main.GameCanvas.isTouch ? -1 : 0;
   }

   private void U() {
      this.aC = 30;
      Item[] var1 = Char.myPetz().arrItemBody;
      Skill[] var2 = Char.myPetz().arrPetSkill;
      this.N = var1.length + var2.length;
      this.aH = this.N * this.aC - this.ag;
      this.g = this.f = this.aI[this.A];
      if (this.aH < 0) {
         this.aH = 0;
      }

      if (this.g < 0) {
         this.g = this.f = 0;
      }

      if (this.g > this.aH) {
         this.g = this.f = 0;
      }

      this.aj = main.GameCanvas.isTouch ? -1 : 0;
   }

   private void b(boolean var1) {
      this.N = this.i(Char.myCharz().arrItemBody.length + Char.myCharz().arrItemBag.length);
      this.aC = 24;
      this.aH = this.N * this.aC - this.ag;
      this.g = this.f = this.aI[this.A];
      if (this.aH < 0) {
         this.aH = 0;
      }

      if (this.g < 0) {
         this.g = this.f = 0;
      }

      if (this.g > this.aH) {
         this.g = this.f = 0;
      }

      if (var1) {
         this.aj = main.GameCanvas.isTouch ? -1 : 0;
      }

   }

   private void V() {
      if (this.timeShow > 0) {
         --this.timeShow;
      }

      if (this.cd && this.equals(main.GameCanvas.panel) && this.bI == 2 && this.J[this.A] > 1) {
         if (this.g < -50) {
            InfoDlg.a();
            this.cd = false;
            if (this.K[this.A] <= 0) {
               Service.gI().a((byte)4, -1, (byte)this.A, this.J[this.A] - 1, -1);
            } else {
               Service.gI().a((byte)4, -1, (byte)this.A, this.K[this.A] - 1, -1);
            }
         } else if (this.g > this.aH + 50) {
            this.cd = false;
            InfoDlg.a();
            if (this.K[this.A] >= this.J[this.A] - 1) {
               Service.gI().a((byte)4, -1, (byte)this.A, 0, -1);
            } else {
               Service.gI().a((byte)4, -1, (byte)this.A, this.K[this.A] + 1, -1);
            }
         }
      }

      if (this.h != this.aJ && !this.bS) {
         this.ci = this.aJ - this.h << 2;
         this.cj += this.ci;
         this.h += this.cj >> 3;
         this.cj &= 15;
      }

      if (Math.abs(this.aJ - this.h) < 10) {
         this.h = this.aJ;
      }

      if (this.isClose) {
         this.isClose = false;
         this.aJ = this.af;
      }

      if (this.aJ >= this.af - 10 && this.h >= this.af - 10 && this.bG == 0) {
         this.isShow = false;
         this.Z();
         if (this.cH) {
            this.cH = false;
            if (Char.myCharz().cHP > 0 && Char.myCharz().statusMe != 14) {
               InfoDlg.a();
               if (this.z == 3) {
                  Service.gI().f(this.aj);
               } else if (this.z == 14) {
                  Service.gI().u(this.aj);
               }
            }
         }

         if (this.ck) {
            this.ck = false;
            int var1 = this.R.size() - this.Y.size();
            if (Char.myCharz().aU != null) {
               if (this.aj - var1 < 0) {
                  Char.myCharz().aU.M = this.aj;
               } else {
                  Char.myCharz().aU.M = Short.parseShort((String)this.Y.elementAt(this.aj - var1));
               }
            }

            ((CommandLine)this.R.elementAt(this.aj)).performAction();
         }

         this.R.removeAllElements();
         this.ab = null;
      }

      if (this.bV != 0 && !this.bS) {
         this.f += this.bV / 100;
         if (this.f < 0) {
            this.f = 0;
         } else if (this.f > this.aH) {
            this.f = this.aH;
         } else {
            this.g = this.f;
         }

         this.bV = this.bV * 9 / 10;
         if (this.bV < 100 && this.bV > -100) {
            this.bV = 0;
         }
      }

      if (this.g != this.f && !this.bS) {
         this.aG = this.f - this.g << 2;
         this.aF += this.aG;
         this.g += this.aF >> 4;
         this.aF &= 15;
      }

      this.aI[this.A] = this.g;
   }

   private void b(mGraphics var1) {
      var1.e(this.ad, this.ae, this.af, this.ag);
      var1.setColor(0, -this.g);
      var1.setColor(0);
      if (this.N != 0) {
         int var2;
         if ((var2 = (this.g + this.ag) / 24 + 1) < this.ag / 24 + 1) {
            var2 = this.ag / 24 + 1;
         }

         if (var2 > this.N) {
            var2 = this.N;
         }

         int var3;
         if ((var3 = this.g / 24) >= var2) {
            var3 = var2 - 1;
         }

         if (var3 < 0) {
            var3 = 0;
         }

         for(var3 = var3; var3 < var2; ++var3) {
            int var4 = this.ad;
            int var5 = this.ae + var3 * this.aC;
            int var6 = this.aC - 1;
            int var7 = this.ad + 24;
            int var8 = this.ae + var3 * this.aC;
            int var9 = this.af - 24;
            int var10 = this.aC - 1;
            var1.setColor(var3 == this.aj ? 16383818 : 15196114);
            var1.fillRect(var7, var8, var9, var10);
            var1.setColor(var3 == this.aj ? 9541120 : 9993045);
            var1.fillRect(var4, var5, 24, var6);
            TopInfo var12;
            if ((var12 = (TopInfo)this.V.elementAt(var3)).b != -1) {
               SmallImage.b(var1, var12.b, var4, var5, 0, 0);
            } else {
               Rms var11 = GameScr.x[var12.a];
               SmallImage.b(var1, var11.a[Char.bC[0][0][0]].a, var4 + var11.a[Char.bC[0][0][0]].b, var5 + var10 - 1, 0, 36);
            }

            var1.e(this.ad, this.ae + this.g, this.af, this.ag);
            if (var12.g != Char.myCharz().charID) {
               mFont.h.drawStringBd(var1, var12.e, var7 + 5, var8, 0);
            } else {
               mFont.a.drawStringBd(var1, var12.e, var7 + 5, var8, 0);
            }

            mFont.q.drawStringBd(var1, var12.f, var7 + var9 - 5, var8 + 11, 1);
            mFont.m.drawStringBd(var1, mResources.bK + ": " + var12.h, var7 + 5, var8 + 11, 0);
         }

         this.f(var1);
      }
   }

   public final void a(mGraphics var1) {
      var1.setColor(-var1.setColor(), -var1.b());
      var1.setColor(-this.h, 0);
      var1.setColor(this.b, 0);
      Panel var2;
      int var4;
      if (main.GameCanvas.panel.au != -1) {
         if (this.equals(main.GameCanvas.panel)) {
            mGraphics var3 = var1;
            var2 = this;
            GameScr.gI();
            GameScr.b(var1);
            mGraphics var14 = var1;
            Panel var17 = this;
            var1.setColor(-GameScr.cmx, -GameScr.cmy);
            int var16;
            if (this.cW < 3) {
               for(var16 = 0; var16 < GameScr.G.size(); ++var16) {
                  Npc var19;
                  if ((var19 = (Npc)GameScr.G.elementAt(var16)).template.npcTemplateId == var17.av) {
                     var19.a(var14);
                     if (var19.z != null) {
                        var19.z.a(var14, var19.cx, var19.cy - var19.al - main.GameCanvas.ac, var19.I);
                     }
                  }
               }
            }

            main.GameCanvas.a(var14);
            if (main.GameCanvas.v % 4 == 0) {
               var14.drawImage(ItemMap.myTexture2dflare, var17.aw - 5, var17.ax + 15, 33);
               var14.drawImage(ItemMap.myTexture2dflare, var17.aw + 5, var17.ax + 15, 33);
               var14.drawImage(ItemMap.myTexture2dflare, var17.aw, var17.ax + 15, 33);
            }

            var16 = 0;

            while(true) {
               if (var16 >= Effect2.vEffect3.size()) {
                  if (main.GameCanvas.v % 4 == 0) {
                     var1.drawImage(ItemMap.myTexture2dflare, this.aw, this.ax + 15, 33);
                  }

                  if (this.cW == 0) {
                     for(var4 = 0; var4 < var2.cS.length; ++var4) {
                        SmallImage.b(var3, var2.az, var2.aw, var2.ax, 0, 3);
                        if (var2.dc) {
                           SmallImage.b(var3, var2.dd, var2.cT[var4], var2.cU[var4], 0, 3);
                        }
                     }

                     return;
                  } else if (this.cW == 1) {
                     if (!this.dc) {
                        SmallImage.b(var1, this.aA, this.aw, this.ax, 0, 3);
                        break;
                     } else {
                        for(var4 = 0; var4 < var2.cS.length; ++var4) {
                           SmallImage.b(var3, var2.az, var2.cT[0], var2.cU[0], 0, 3);
                           SmallImage.b(var3, var2.dd, var2.cT[1], var2.cU[1], 0, 3);
                        }

                        return;
                     }
                  } else if (this.cW == 2) {
                     if (!this.dc) {
                        SmallImage.b(var1, this.aA, this.aw, this.ax, 0, 3);
                        break;
                     } else {
                        for(var4 = 0; var4 < var2.cS.length; ++var4) {
                           SmallImage.b(var3, var2.az, var2.cT[var4], var2.cU[var4], 0, 3);
                        }

                        return;
                     }
                  } else {
                     if (this.cW == 3) {
                        if (!this.dc) {
                           SmallImage.b(var1, this.aA, this.aw, this.ax, 0, 3);
                        } else {
                           SmallImage.b(var1, this.az, this.aw, this.ax, 0, 3);
                        }
                     } else {
                        if (this.cW != 4) {
                           return;
                        }

                        if (this.dc) {
                           for(var4 = 0; var4 < var2.de.length; ++var4) {
                              SmallImage.b(var3, var2.de[var4], var2.cT[var4], var2.cU[var4], 0, 3);
                           }

                           return;
                        }

                        if (this.aA == -1) {
                           return;
                        }

                        SmallImage.b(var1, this.aA, this.aw, this.ax, 0, 3);
                     }
                     break;
                  }
               }

               ((Effect2)Effect2.vEffect3.elementAt(var16)).paint(var14);
               ++var16;
            }
         }
      } else {
         Paint.paintFrameSimple(this.b, 0, this.d, this.e, var1);
         var2 = this;
         var1.e(this.b + 1, 0, this.d - 2, this.ae - 2);
         var1.setColor(9993045);
         var1.fillRect(this.b, 0, this.d - 2, 50);
         int var5;
         switch(this.z) {
         case 0:
            if (this.A == 0) {
               SmallImage.b(var1, Char.myCharz().d(), this.b + 25, 50, 0, 33);
               this.A(var1);
            }

            if (this.A == 1) {
               SmallImage.b(var1, Char.myCharz().d(), this.b + 25, 50, 0, 33);
               this.C(var1);
            }

            if (this.A == 2) {
               SmallImage.b(var1, Char.myCharz().d(), this.b + 25, 50, 0, 33);
               mFont.s.drawStringBd(var1, "Top " + Char.myCharz().w, this.b + 45 + (this.d - 50) / 2, 2, 2);
               mFont.n.drawStringBd(var1, mResources.eF, this.b + 45 + (this.d - 50) / 2, 14, 2);
               mFont.s.drawStringBd(var1, Util.a(Char.myCharz().cTiemNang), this.b + (main.GameCanvas.v % 20 > 10 ? main.GameCanvas.v % 4 / 2 : 0) + 45 + (this.d - 50) / 2, 26, 2);
               mFont.n.drawStringBd(var1, mResources.bL + ": " + Util.a(Char.myCharz().ab), this.b + (main.GameCanvas.v % 20 > 10 ? main.GameCanvas.v % 4 / 2 : 0) + 45 + (this.d - 50) / 2, 38, 2);
            }

            if (this.A == 3) {
               if (this.C.length == 5) {
                  if (Char.myCharz().clan == null) {
                     SmallImage.b(var1, Char.myCharz().d(), 25, 50, 0, 33);
                     mFont.c.drawStringBd(var1, mResources.dq, (this.af - 50) / 2 + 50, 20, 2);
                  } else {
                     Clan var13;
                     if (!this.am) {
                        if ((var13 = Char.myCharz().clan) != null) {
                           SmallImage.b(var1, Char.myCharz().d(), 25, 50, 0, 33);
                           mFont.c.drawString(var1, var13.c, 60, 4, 0, mFont.tahoma_7b_dark);
                           mFont.n.drawString(var1, mResources.eG + ": " + var13.f, 60, 16, 0, mFont.o);
                           mFont.n.drawString(var1, mResources.cT + ": " + var13.k, 60, 27, 0, mFont.o);
                           mFont.n.drawString(var1, mResources.dn + ": " + var13.j, 60, 38, 0, mFont.o);
                           TextInfo.a(var1, var13.d, 60, 38, this.af - 70, this.aC, mFont.n);
                        }
                     } else {
                        var13 = this.bC != null ? this.bC : Char.myCharz().clan;
                        SmallImage.b(var1, Char.myCharz().d(), 25, 50, 0, 33);
                        mFont.c.drawString(var1, var13.c, 60, 4, 0, mFont.tahoma_7b_dark);
                        mFont.n.drawString(var1, mResources.de + ": " + var13.g + "/" + var13.h, 60, 16, 0, mFont.o);
                        mFont.n.drawString(var1, mResources.db + ": " + var13.i, 60, 27, 0, mFont.o);
                        TextInfo.a(var1, var13.d, 60, 38, this.af - 70, this.aC, mFont.n);
                     }
                  }
               } else {
                  SmallImage.b(var1, Char.myCharz().d(), this.b + 25, 50, 0, 33);
                  z(var1);
               }
            }

            if (this.A != 4) {
               break;
            }
         case 22:
            SmallImage.b(var1, Char.myCharz().d(), this.b + 25, 50, 0, 33);
            z(var1);
            break;
         case 1:
            if (this.A == this.aX.length - 1 && main.GameCanvas.G == null) {
               SmallImage.b(var1, Char.myCharz().d(), this.b + 25, 50, 0, 33);
            } else if (Char.myCharz().aT != null) {
               int var10002 = this.b + 25;
               SmallImage.b(var1, Char.myCharz().aT.aO, var10002, 50, 0, 33);
            }

            if (this.A == this.aX.length - 1 && main.GameCanvas.G == null) {
               this.A(var1);
            } else if (this.aj < 0) {
               if (this.bI != 2) {
                  mFont.s.drawStringBd(var1, mResources.eq, this.b + 60, 14, 0);
                  mFont.s.drawStringBd(var1, aq, this.b + 60, 26, 0);
               } else {
                  mFont.s.drawStringBd(var1, mResources.eq, this.b + 60, 5, 0);
                  mFont.s.drawStringBd(var1, aq, this.b + 60, 17, 0);
                  mFont.s.drawStringBd(var1, mResources.fM + " " + (this.K[this.A] + 1) + "/" + this.J[this.A], this.b + 60, 29, 0);
               }
            } else {
               Item var11;
               if (this.A >= 0 && this.A <= Char.myCharz().aJ.length - 1 && this.aj >= 0 && this.aj <= Char.myCharz().aJ[this.A].length - 1 && (var11 = Char.myCharz().aJ[this.A][this.aj]) != null) {
                  if (this.equals(main.GameCanvas.panel) && this.A <= 3 && this.bI == 2) {
                     mFont.c.drawStringBd(var1, mResources.fM + " " + (this.K[this.A] + 1) + "/" + this.J[this.A], this.b + 55, 4, 0);
                  }

                  mFont.c.drawStringBd(var1, var11.template.d, this.b + 55, 24, 0);
                  String var9 = mResources.ct + " " + ResLog.a((long)var11.template.i);
                  if ((long)var11.template.i > Char.myCharz().cPower) {
                     mFont.n.drawStringBd(var1, var9, this.b + 55, 35, 0);
                  } else {
                     mFont.r.drawStringBd(var1, var9, this.b + 55, 35, 0);
                  }
               }
            }
            break;
         case 2:
            if (this.A == 0) {
               SmallImage.b(var1, 526, this.b + 25, 50, 0, 33);
               String var10 = mResources.cv + ": " + this.hasUse + "/" + Char.myCharz().arrItemBox.length + " " + mResources.cw;
               mFont.c.drawStringBd(var1, mResources.cc, 60, 4, 0);
               mFont.n.drawStringBd(var1, var10, 60, 16, 0);
            }

            if (this.A == 1) {
               SmallImage.b(var1, Char.myCharz().d(), this.b + 25, 50, 0, 33);
               this.C(var1);
            }
            break;
         case 3:
            SmallImage.b(var1, 561, this.b + 25, 50, 0, 33);
            mFont.c.drawString(var1, mResources.ck + " " + TileMap.n, 60, 4, 0, mFont.tahoma_7b_dark);
            mFont.n.drawString(var1, TileMap.k, 60, 16, 0, mFont.o);
            mFont.c.drawStringBd(var1, String.valueOf(TileMap.n), 25, 27, 2);
            break;
         case 4:
            SmallImage.b(var1, Char.myCharz().d(), this.b + 25, 50, 0, 33);
            B(var1);
         case 5:
         case 6:
         default:
            break;
         case 7:
         case 17:
            SmallImage.b(var1, Char.myCharz().d(), this.b + 25, 50, 0, 33);
            this.A(var1);
            break;
         case 8:
            SmallImage.b(var1, Char.myCharz().d(), this.b + 25, 50, 0, 33);
            this.A(var1);
            break;
         case 9:
            SmallImage.b(var1, Char.myCharz().d(), this.b + 25, 50, 0, 33);
            this.A(var1);
            break;
         case 10:
            if (this.ab != null) {
               SmallImage.b(var1, this.ab.d(), this.b + 25, 50, 0, 33);
               this.a(var1, this.ab);
            }
            break;
         case 11:
         case 16:
         case 23:
         case 24:
            SmallImage.b(var1, Char.myCharz().d(), this.b + 25, 50, 0, 33);
            this.A(var1);
            break;
         case 12:
            if (this.A == 0) {
               var4 = 1410;

               for(var5 = 0; var5 < GameScr.G.size(); ++var5) {
                  Npc var6;
                  if ((var6 = (Npc)GameScr.G.elementAt(var5)).template.npcTemplateId == var2.av) {
                     var4 = var6.aO;
                  }
               }

               SmallImage.b(var1, var4, var2.b + 25, 50, 0, 33);
               mGraphics var8 = var1;
               Panel var7 = var2;
               if (var2.ap != null) {
                  for(var4 = 0; var4 < var7.ap.length; ++var4) {
                     mFont.s.drawStringBd(var8, var7.ap[var4], var7.b + 45 + (var7.d - 50) / 2, 5 + var4 * 14, 2);
                  }
               }
            }

            if (var2.A == 1) {
               SmallImage.b(var1, Char.myCharz().d(), var2.b + 25, 50, 0, 33);
               var2.A(var1);
            }
            break;
         case 13:
            if (this.A == 0 || this.A == 1) {
               if (this.equals(main.GameCanvas.panel)) {
                  SmallImage.b(var1, Char.myCharz().d(), this.b + 25, 50, 0, 33);
                  mFont.n.drawString(var1, mResources.eo, 60, 4, 0, mFont.o);
                  mFont.n.drawString(var1, mResources.dP, 60, 16, 0, mFont.o);
                  mFont.n.drawString(var1, mResources.dQ, 60, 27, 0, mFont.o);
                  mFont.n.drawString(var1, mResources.dR, 60, 38, 0, mFont.o);
               }

               if (this.equals(main.GameCanvas.G) && this.ab != null) {
                  SmallImage.b(var1, this.ab.d(), this.b + 25, 50, 0, 33);
                  this.a(var1, this.ab);
               }
            }

            if (this.A == 2 && this.ab != null) {
               SmallImage.b(var1, this.ab.d(), this.b + 25, 50, 0, 33);
               this.a(var1, this.ab);
            }
            break;
         case 14:
            SmallImage.b(var1, Char.myCharz().d(), this.b + 25, 50, 0, 33);
            B(var1);
            break;
         case 15:
            SmallImage.b(var1, Char.myCharz().d(), this.b + 25, 50, 0, 33);
            this.A(var1);
            break;
         case 18:
            SmallImage.b(var1, Char.myCharz().d(), this.b + 25, 50, 0, 33);
            this.A(var1);
            break;
         case 19:
            SmallImage.b(var1, Char.myCharz().d(), this.b + 25, 50, 0, 33);
            z(var1);
            break;
         case 20:
            SmallImage.b(var1, Char.myCharz().d(), this.b + 25, 50, 0, 33);
            z(var1);
            break;
         case 21:
            if (this.A == 0) {
               SmallImage.b(var1, Char.myPetz().d(), this.b + 25, 50, 0, 33);
               mFont.n.drawString(var1, mResources.cZ + ": " + Util.a(Char.myPetz().cPower), this.b + 60, 4, 0, mFont.o);
               if (Char.myPetz().cPower > 0L) {
                  mFont.n.drawString(var1, Char.myPetz().me ? Char.myPetz().c() : Char.myPetz().currStrLevel, this.b + 60, 16, 0, mFont.o);
               }

               if (Char.myPetz().cDamFull > 0) {
                  mFont.n.drawString(var1, mResources.eW + ": " + Char.myPetz().cDamFull, this.b + 60, 27, 0, mFont.o);
               }

               if (Char.myPetz().cMaxStamina > 0) {
                  mFont.n.drawString(var1, mResources.eY, this.b + 60, 38, 0, mFont.o);
                  var1.drawImage(GameScr.aF, this.b + 100, 41, 0);
                  var4 = Char.myPetz().cStamina * mGraphics.setColor(GameScr.aE) / Char.myPetz().cMaxStamina;
                  var1.e(100, this.b + 41, var4, 20);
                  var1.drawImage(GameScr.aE, this.b + 100, 41, 0);
               }

               var1.e(0, 0, main.GameCanvas.z, main.GameCanvas.A);
            }

            if (this.A == 1) {
               SmallImage.b(var1, Char.myPetz().d(), this.b + 25, 50, 0, 33);
               mFont.c.drawString(var1, "HP: " + Char.myPetz().cHP + "/" + Char.myPetz().cHPFull, this.b + 60, 4, 0, mFont.tahoma_7b_dark);
               mFont.c.drawString(var1, "MP: " + Char.myPetz().cMP + "/" + Char.myPetz().cMPFull, this.b + 60, 16, 0, mFont.tahoma_7b_dark);
               mFont.n.drawString(var1, mResources.eZ + ": " + Char.myPetz().cCriticalFull + "   " + mResources.eX + ": " + Char.myPetz().cDefull, this.b + 60, 27, 0, mFont.o);
               mFont.n.drawString(var1, mResources.v + ": " + this.cl[Char.myPetz().petStatus], this.b + 60, 38, 0, mFont.o);
            }

            if (this.A == 2) {
               SmallImage.b(var1, Char.myCharz().d(), this.b + 25, 50, 0, 33);
               this.C(var1);
            }
            break;
         case 25:
            SmallImage.b(var1, Char.myCharz().d(), this.b + 25, 50, 0, 33);
            this.A(var1);
            break;
         case 26:
            SmallImage.b(var1, 561, this.b + 25, 50, 0, 33);
            SmallImage.b(var1, Char.myCharz().d(), this.b + 25, 50, 0, 33);
            this.A(var1);
         }

         if (this.z != 13 || this.A != 2 && !this.equals(main.GameCanvas.G)) {
            var1.e(0, 0, main.GameCanvas.z, main.GameCanvas.A);
            var1.setColor(11837316);
            var1.fillRect(this.b + 1, this.e - 15, this.d - 2, 14);
            var1.setColor(13524492);
            var1.fillRect(this.b + 1, this.e - 15, this.d - 2, 1);
            var1.drawImage(v, this.b + 11, this.e - 7, 3);
            var1.drawImage(x, this.b + 75, this.e - 8, 3);
            mFont.n.drawString(var1, Char.myCharz().xuStr, this.b + 24, this.e - 13, 0, mFont.o);
            mFont.n.drawString(var1, Char.myCharz().luongStr, this.b + 85, this.e - 13, 0, mFont.o);
            var1.drawImage(y, this.b + 130, this.e - 8, 3);
            mFont.n.drawString(var1, Char.myCharz().luongKhoaStr, this.b + 140, this.e - 13, 0, mFont.o);
         }

         this.y(var1);
         switch(this.z) {
         case 0:
            if (this.A == 0) {
               this.E(var1);
            }

            if (this.A == 1) {
               this.x(var1);
            }

            if (this.A == 2) {
               this.j(var1);
            }

            if (this.A == 3) {
               if (this.C.length == 4) {
                  this.g(var1);
               } else {
                  this.u(var1);
               }
            }

            if (this.A == 4) {
               this.g(var1);
            }
            break;
         case 1:
            this.c(var1);
            break;
         case 2:
            if (this.A == 0) {
               this.o(var1);
            }

            if (this.A == 1) {
               this.x(var1);
            }
            break;
         case 3:
            this.m(var1);
            break;
         case 4:
            this.D(var1);
         case 5:
         case 6:
         case 22:
         default:
            break;
         case 7:
            this.x(var1);
            break;
         case 8:
            this.p(var1);
            break;
         case 9:
            this.v(var1);
            break;
         case 10:
            this.t(var1);
            break;
         case 11:
            this.s(var1);
            break;
         case 12:
            if (this.A == 0) {
               this.w(var1);
            }

            if (this.A == 1) {
               this.x(var1);
            }
            break;
         case 13:
            if (this.A == 0) {
               if (this.equals(main.GameCanvas.panel)) {
                  this.x(var1);
               } else {
                  this.a(var1, false);
               }
            }

            if (this.A == 1) {
               this.a(var1, true);
            }

            if (this.A == 2) {
               this.a(var1, false);
            }
            break;
         case 14:
            this.k(var1);
            break;
         case 15:
            this.b(var1);
            break;
         case 16:
            this.r(var1);
            break;
         case 17:
            this.c(var1);
            break;
         case 18:
            this.q(var1);
            break;
         case 19:
            this.F(var1);
            break;
         case 20:
            this.G(var1);
            break;
         case 21:
            if (this.A == 0) {
               this.e(var1);
            }

            if (this.A == 1) {
               this.d(var1);
            }

            if (this.A == 2) {
               this.x(var1);
            }
            break;
         case 23:
            this.i(var1);
            break;
         case 24:
            this.h(var1);
            break;
         case 25:
            this.n(var1);
            break;
         case 26:
            this.l(var1);
         }

         GameScr.c(var1);
         if (this.ah != null && this.ah.d != null) {
            this.ah.paint(var1);
            var4 = this.ah.e + 13;
            var5 = this.ah.f + 11;
            if (this.z == 15) {
               var4 += 5;
               var5 += 26;
            }

            if (this.z == 0 && this.A == 3) {
               if (this.ak) {
                  var4 -= 5;
               } else if (this.bK != null || this.cG != null) {
                  var4 = this.ah.e + 21;
                  var5 = this.ah.f + 40;
               }
            }

            if (this.bK != null) {
               Rms var12 = GameScr.x[this.bK[0]];
               Rms var15 = GameScr.x[this.bK[1]];
               Rms var18 = GameScr.x[this.bK[2]];
               SmallImage.b(var1, var12.a[Char.bC[0][0][0]].a, var4 + Char.bC[0][0][1] + var12.a[Char.bC[0][0][0]].b, var5 - Char.bC[0][0][2] + var12.a[Char.bC[0][0][0]].c, 0, 0);
               SmallImage.b(var1, var15.a[Char.bC[0][1][0]].a, var4 + Char.bC[0][1][1] + var15.a[Char.bC[0][1][0]].b, var5 - Char.bC[0][1][2] + var15.a[Char.bC[0][1][0]].c, 0, 0);
               SmallImage.b(var1, var18.a[Char.bC[0][2][0]].a, var4 + Char.bC[0][2][1] + var18.a[Char.bC[0][2][0]].b, var5 - Char.bC[0][2][2] + var18.a[Char.bC[0][2][0]].c, 0, 0);
            } else if (this.cG != null) {
               this.cG.a(var1, var4 + 5, var5 + 25, 1, 0, true);
            } else if (this.bJ != -1) {
               SmallImage.b(var1, this.bJ, var4, var5, 0, 3);
            }

            if (this.bB != null && this.bB.template.type != 5) {
               if (this.bB.A > 0) {
                  var1.drawImage(aT, var4 - 7, var5 + 13, 3);
                  mFont.h.drawStringBd(var1, String.valueOf(ResLog.g(this.bB.A)), var4 + 1, var5 + 8, 0);
               } else if (this.bB.A < 0 && this.bB.A != -1) {
                  var1.drawImage(aU, var4 - 7, var5 + 13, 3);
                  mFont.a.drawStringBd(var1, String.valueOf(ResLog.g(this.bB.A)), var4 + 1, var5 + 8, 0);
               }
            }
         }

         if (this.h == this.aJ) {
            this.cmdClose.a(var1);
         }

         if (this.tabIcon != null && this.tabIcon.k) {
            this.tabIcon.a(var1);
         }

         var1.setColor(-var1.setColor(), -var1.b());
         var1.setColor(this.b, 0);
         var1.setColor(-this.h, 0);
      }

   }

   private void c(mGraphics var1) {
      try {
         if (this.z == 1 && this.A == this.aX.length - 1 && main.GameCanvas.G == null && this.bI != 2) {
            this.x(var1);
         } else {
            var1.setColor(16711680);
            var1.e(this.ad, this.ae, this.af, this.ag);
            if (this.bI == 2 && this.equals(main.GameCanvas.panel)) {
               if (this.A <= 3 && main.GameCanvas.isTouch) {
                  if (this.g < -50) {
                     main.GameCanvas.a(this.ad + this.af / 2, this.ae + 30, var1);
                  } else if (this.g < 0) {
                     mFont.o.drawStringBd(var1, mResources.fN, this.ad + this.af / 2, this.ae + 15, 2);
                  } else if (this.aH >= 0) {
                     if (this.g > this.aH + 50) {
                        main.GameCanvas.a(this.ad + this.af / 2, this.ae + this.ag - 30, var1);
                     } else if (this.g > this.aH) {
                        mFont.o.drawStringBd(var1, mResources.fO, this.ad + this.af / 2, this.ae + this.ag - 25, 2);
                     }
                  }
               }

               if (Char.myCharz().aJ[this.A].length == 0 && this.z != 17) {
                  mFont.o.drawStringBd(var1, mResources.fP, this.ad + this.af / 2, this.ae + this.ag / 2 - 10, 2);
                  return;
               }
            }

            var1.setColor(0, -this.g);
            Item[] var2 = Char.myCharz().aJ[this.A];
            if (this.bI == 2 && (this.A == 4 || this.z == 17) && (var2 = Char.myCharz().aJ[4]).length == 0) {
               mFont.o.drawStringBd(var1, mResources.fP, this.ad + this.af / 2, this.ae + this.ag / 2 - 10, 2);
            } else {
               int var3 = var2.length;

               for(int var4 = 0; var4 < var3; ++var4) {
                  int var5 = this.ad + 26;
                  int var6 = this.ae + var4 * this.aC;
                  int var7 = this.af - 26;
                  int var8 = this.aC - 1;
                  int var9 = this.ad;
                  int var10 = this.ae + var4 * this.aC;
                  int var11 = this.aC - 1;
                  if (var6 - this.g <= this.ae + this.ag && var6 - this.g >= this.ae - this.aC) {
                     var1.setColor(var4 == this.aj ? 16383818 : 15196114);
                     var1.b(var5, var6, var7, var8);
                     var1.setColor(var4 == this.aj ? 9541120 : 9993045);
                     var1.b(var9, var10, 24, var11);
                     Item var17;
                     if ((var17 = var2[var4]) != null) {
                        String var12 = "";
                        mFont var13 = mFont.m;
                        if (var17.B != 0 && this.bI == 2 && this.A <= 3 && !this.equals(main.GameCanvas.G)) {
                           var13 = mFont.h;
                        }

                        if (var17.itemOption != null) {
                           for(int var14 = 0; var14 < var17.itemOption.length; ++var14) {
                              if (var17.itemOption[var14].optionTemplate.name == 72) {
                                 var12 = " [+" + var17.itemOption[var14].param + "]";
                              }

                              if (var17.itemOption[var14].optionTemplate.name == 41) {
                                 if (var17.itemOption[var14].param == 1) {
                                    var13 = h(0);
                                 } else if (var17.itemOption[var14].param == 2) {
                                    var13 = h(2);
                                 } else if (var17.itemOption[var14].param == 3) {
                                    var13 = h(8);
                                 } else if (var17.itemOption[var14].param == 4) {
                                    var13 = h(7);
                                 }
                              }
                           }
                        }

                        var13.drawStringBd(var1, var17.template.d + var12, var5 + 5, var6 + 1, 0);
                        String var19 = "";
                        if (var17.itemOption != null && var17.itemOption.length > 0) {
                           if (var17.itemOption[0] != null && var17.itemOption[0].optionTemplate.name != 102 && var17.itemOption[0].optionTemplate.name != 107) {
                              var19 = var19 + var17.itemOption[0].getOptionString();
                           }

                           mFont var18 = mFont.q;
                           if (var17.A < 0 && var17.template.type != 5) {
                              var18 = mFont.p;
                           }

                           if (this.bI == 2 && var17.itemOption.length > 1 && var17.v != -1) {
                              var19 = var19;
                           }

                           if (this.bI != 2 || this.bI == 2 && var17.v <= 1) {
                              var18.drawStringBd(var1, var19, var5 + 5, var6 + 11, 0);
                           }
                        }

                        if (var17.s > 0) {
                           SmallImage.b(var1, var17.u, var5 + var7 - 7, var6 + 9, 0, 3);
                           mFont.b.drawStringBd(var1, ResLog.a((long)var17.s), var5 + var7 - 15, var6 + 1, 1);
                        }

                        if (var17.n != 0 || var17.p != 0) {
                           if (this.bI != 2 && var17.j == 0L) {
                              if (var17.n > 0 && var17.p > 0) {
                                 if (var17.n > 0) {
                                    var1.drawImage(v, var5 + var7 - 7, var6 + 7, 3);
                                    mFont.d.drawStringBd(var1, ResLog.a((long)var17.n), var5 + var7 - 15, var6 + 1, 1);
                                 }

                                 if (var17.p > 0) {
                                    var1.drawImage(x, var5 + var7 - 7, var6 + 7 + 11, 3);
                                    mFont.h.drawStringBd(var1, ResLog.a((long)var17.p), var5 + var7 - 15, var6 + 12, 1);
                                 }
                              } else {
                                 if (var17.n > 0) {
                                    var1.drawImage(v, var5 + var7 - 7, var6 + 7, 3);
                                    mFont.d.drawStringBd(var1, ResLog.a((long)var17.n), var5 + var7 - 15, var6 + 1, 1);
                                 }

                                 if (var17.p > 0) {
                                    var1.drawImage(x, var5 + var7 - 7, var6 + 7, 3);
                                    mFont.h.drawStringBd(var1, ResLog.a((long)var17.p), var5 + var7 - 15, var6 + 1, 1);
                                 }
                              }
                           }

                           if (this.bI == 2 && this.A <= 3 && !this.equals(main.GameCanvas.G)) {
                              if (var17.n > 0 && var17.p > 0) {
                                 if (var17.n > 0) {
                                    var1.drawImage(v, var5 + var7 - 7, var6 + 7, 3);
                                    if (Char.myCharz().gold < (long)var17.n) {
                                       var13 = mFont.a;
                                    } else {
                                       var13 = mFont.d;
                                    }

                                    var13.drawStringBd(var1, ResLog.b((long)var17.n), var5 + var7 - 15, var6 + 1, 1);
                                 }

                                 if (var17.p > 0) {
                                    var1.drawImage(x, var5 + var7 - 7, var6 + 7 + 11, 3);
                                    if (Char.myCharz().gem < var17.p) {
                                       var13 = mFont.a;
                                    } else {
                                       var13 = mFont.h;
                                    }

                                    var13.drawStringBd(var1, ResLog.b((long)var17.p), var5 + var7 - 15, var6 + 12, 1);
                                 }
                              } else {
                                 if (var17.n > 0) {
                                    var1.drawImage(v, var5 + var7 - 7, var6 + 7, 3);
                                    if (Char.myCharz().gold < (long)var17.n) {
                                       var13 = mFont.a;
                                    } else {
                                       var13 = mFont.d;
                                    }

                                    var13.drawStringBd(var1, ResLog.b((long)var17.n), var5 + var7 - 15, var6 + 1, 1);
                                 }

                                 if (var17.p > 0) {
                                    var1.drawImage(x, var5 + var7 - 7, var6 + 7, 3);
                                    if (Char.myCharz().gem < var17.p) {
                                       var13 = mFont.a;
                                    } else {
                                       var13 = mFont.h;
                                    }

                                    var13.drawStringBd(var1, ResLog.b((long)var17.p), var5 + var7 - 15, var6 + 1, 1);
                                 }

                                 try {
                                    var13 = mFont.h;
                                    if (!Char.myCharz().cName.equals(var17.H)) {
                                       var13 = mFont.h;
                                    }

                                    var13.drawStringBd(var1, var17.H, var5 + var7, var6 + 1 + mFont.a.getWidth(), 1);
                                 } catch (Exception var15) {
                                 }
                              }
                           }
                        }

                        SmallImage.b(var1, var17.template.f, var9 + 12, var10 + var11 / 2, 0, 3);
                        if (var17.quantity > 1) {
                           mFont.n.drawStringBd(var1, "" + var17.quantity, var9 + 24, var10 + var11 - mFont.n.getWidth(), 1);
                        }

                        if (var17.C && main.GameCanvas.v % 10 > 5) {
                           var1.drawImage(u, var9 + 12, var6 + 19, 3);
                        }
                     }

                     if (this.bI == 2 && (this.equals(main.GameCanvas.G) || this.A == 4) && var17.v != 0) {
                        if (var17.v == 1) {
                           mFont.r.drawStringBd(var1, mResources.fJ, var5 + var7 - 5, var6 + 1, 1);
                           if (var17.n != -1) {
                              var1.drawImage(v, var5 + var7 - 7, var6 + 19, 3);
                              mFont.d.drawStringBd(var1, ResLog.b((long)var17.n), var5 + var7 - 15, var6 + 13, 1);
                           } else if (var17.p != -1) {
                              var1.drawImage(y, var5 + var7 - 7, var6 + 17, 3);
                              mFont.a.drawStringBd(var1, ResLog.b((long)var17.p), var5 + var7 - 15, var6 + 11, 1);
                           }
                        } else if (var17.v == 2) {
                           mFont.b.drawStringBd(var1, mResources.fK, var5 + var7 - 5, var6 + 1, 1);
                           if (var17.n != -1) {
                              var1.drawImage(v, var5 + var7 - 7, var6 + 17, 3);
                              mFont.d.drawStringBd(var1, ResLog.b((long)var17.n), var5 + var7 - 15, var6 + 11, 1);
                           } else if (var17.p != -1) {
                              var1.drawImage(y, var5 + var7 - 7, var6 + 17, 3);
                              mFont.a.drawStringBd(var1, ResLog.b((long)var17.p), var5 + var7 - 15, var6 + 11, 1);
                           }
                        }
                     }

                     this.cm = 7;
                  }
               }

               this.cm = 8;
               this.f(var1);
               this.cm = 9;
            }
         }
      } catch (Exception var16) {
         var16.printStackTrace();
         System.out.println("tt >>:" + this.cm);
      }
   }

   private void d(mGraphics var1) {
      var1.e(this.ad, this.ae, this.af, this.ag);
      var1.setColor(0, -this.g);

      for(int var2 = 0; var2 < this.cl.length; ++var2) {
         int var3 = this.ad;
         int var4 = this.ae + var2 * this.aC;
         int var5 = this.af - 1;
         int var6 = this.aC - 1;
         if (var4 - this.g <= this.ae + this.ag && var4 - this.g >= this.ae - this.aC) {
            var1.setColor(var2 == this.aj ? 16383818 : 15196114);
            var1.fillRect(var3, var4, var5, var6);
            mFont.tahoma_7b_dark.drawStringBd(var1, this.cl[var2], this.ad + this.af / 2, var4 + 6, 2);
         }
      }

      this.f(var1);
   }

   private void e(mGraphics var1) {
      var1.setColor(16711680);
      var1.e(this.ad, this.ae, this.af, this.ag);
      var1.setColor(0, -this.g);
      Item[] var2 = Char.myPetz().arrItemBody;
      Skill[] var3 = Char.myPetz().arrPetSkill;

      for(int var4 = 0; var4 < var2.length + var3.length; ++var4) {
         boolean var5 = var4 < var2.length;
         int var7 = var4 - var2.length;
         int var8 = this.ad + 36;
         int var9 = this.ae + var4 * this.aC;
         int var10 = this.af - 36;
         int var11 = this.aC - 1;
         int var12 = this.ad;
         int var13 = this.ae + var4 * this.aC;
         int var14 = this.aC - 1;
         if (var9 - this.g <= this.ae + this.ag && var9 - this.g >= this.ae - this.aC) {
            Item var6 = var5 ? var2[var4] : null;
            var1.setColor(var4 == this.aj ? 16383818 : (var5 ? 15196114 : 15723751));
            var1.b(var8, var9, var10, var11);
            var1.setColor(var4 == this.aj ? 9541120 : (var5 ? 9993045 : 11837316));
            if (var6 != null) {
               for(var10 = 0; var10 < var6.itemOption.length; ++var10) {
                  byte var19;
                  if (var6.itemOption[var10].optionTemplate.name == 72 && var6.itemOption[var10].param > 0 && f(var19 = g(var6.itemOption[var10].param)) != -1) {
                     int var10002 = this.aj;
                     var1.setColor(f(var19));
                  }
               }
            }

            var1.b(var12, var13, 34, var14);
            if (var6 != null && var6.f && main.GameCanvas.panel.z == 12) {
               var1.setColor(var4 == this.aj ? 7040779 : 6047789);
               var1.b(var12, var13, 34, var14);
            }

            if (var6 == null) {
               if (!var5) {
                  Skill var21 = var3[var7];
                  var1.drawImage(GameScr.at, var12 + 17, var13 + var14 / 2, 3);
                  if (var21.template != null) {
                     mFont.q.drawStringBd(var1, var21.template.b, var8 + 5, var9 + 1, 0);
                     mFont.m.drawStringBd(var1, mResources.dn + ": " + var21.point, var8 + 5, var9 + 11, 0);
                     SmallImage.b(var1, var21.template.f, var12 + 17, var13 + var14 / 2, 0, 3);
                  } else {
                     mFont.m.drawStringBd(var1, var21.moreInfo, var8 + 5, var9 + 5, 0);
                     SmallImage.b(var1, GameScr.y[98].a[0].c, var12 + 17, var13 + var14 / 2, 0, 3);
                  }
               }
            } else {
               String var18 = "";
               mFont var20 = mFont.m;
               if (var6.itemOption != null) {
                  for(int var15 = 0; var15 < var6.itemOption.length; ++var15) {
                     if (var6.itemOption[var15].optionTemplate.name == 72) {
                        var18 = " [+" + var6.itemOption[var15].param + "]";
                     }

                     if (var6.itemOption[var15].optionTemplate.name == 41) {
                        if (var6.itemOption[var15].param == 1) {
                           var20 = h(0);
                        } else if (var6.itemOption[var15].param == 2) {
                           var20 = h(2);
                        } else if (var6.itemOption[var15].param == 3) {
                           var20 = h(8);
                        } else if (var6.itemOption[var15].param == 4) {
                           var20 = h(7);
                        }
                     }
                  }
               }

               var20.drawStringBd(var1, var6.template.d + var18, var8 + 5, var9 + 1, 0);
               String var22 = "";
               if (var6.itemOption != null) {
                  if (var6.itemOption.length > 0 && var6.itemOption[0] != null && var6.itemOption[0].optionTemplate.name != 102 && var6.itemOption[0].optionTemplate.name != 107) {
                     var22 = var22 + var6.itemOption[0].getOptionString();
                  }

                  mFont var16 = mFont.q;
                  if (var6.A < 0 && var6.template.type != 5) {
                     var16 = mFont.p;
                  }

                  if (var6.itemOption.length > 1) {
                     for(var7 = 1; var7 < 2; ++var7) {
                        if (var6.itemOption[var7] != null && var6.itemOption[var7].optionTemplate.name != 102 && var6.itemOption[var7].optionTemplate.name != 107) {
                           var22 = var22 + "," + var6.itemOption[var7].getOptionString();
                        }
                     }
                  }

                  var16.drawStringBd(var1, var22, var8 + 5, var9 + 11, 0);
               }

               SmallImage.b(var1, var6.template.f, var12 + 17, var13 + var14 / 2, 0, 3);
               if (var6.itemOption != null) {
                  int var17;
                  for(var17 = 0; var17 < var6.itemOption.length; ++var17) {
                     this.a(var1, var6.itemOption[var17].optionTemplate.name, var12, var13, var14);
                  }

                  for(var17 = 0; var17 < var6.itemOption.length; ++var17) {
                     a(var1, var6.itemOption[var17].optionTemplate.name, var6.itemOption[var17].param, var12, var13, 34, var14);
                  }
               }

               if (var6.quantity > 1) {
                  mFont.n.drawStringBd(var1, "" + var6.quantity, var12 + 34, var13 + var14 - mFont.n.getWidth(), 1);
               }
            }
         }
      }

      this.f(var1);
   }

   private void f(mGraphics var1) {
      var1.setColor(-var1.setColor(), -var1.b());
      if (this.g > 24 && this.N > 0 || this.equals(main.GameCanvas.panel) && this.bI == 2 && this.J[this.A] > 1) {
         var1.setColor(Mob.R, 0, 0, 9, 6, 1, this.ad + this.af - 12, this.ae + 3, 0);
      }

      if (this.g < this.aH && this.N > 0 || this.equals(main.GameCanvas.panel) && this.bI == 2 && this.J[this.A] > 1) {
         var1.setColor(Mob.R, 0, 0, 9, 6, 0, this.ad + this.af - 12, this.ae + this.ag - 8, 0);
      }

   }

   private void g(mGraphics var1) {
      var1.e(this.ad, this.ae, this.af, this.ag);
      var1.setColor(0, -this.g);

      for(int var2 = 0; var2 < F.length; ++var2) {
         int var3 = this.ad;
         int var4 = this.ae + var2 * this.aC;
         int var5 = this.af - 1;
         int var6 = this.aC - 1;
         if (var4 - this.g <= this.ae + this.ag && var4 - this.g >= this.ae - this.aC) {
            var1.setColor(var2 == this.aj ? 16383818 : 15196114);
            var1.fillRect(var3, var4, var5, var6);
            mFont.tahoma_7b_dark.drawStringBd(var1, F[var2], this.ad + this.af / 2, var4 + 6, 2);
            if (F[var2].equals(mResources.bR)) {
               for(var5 = 0; var5 < as.size(); ++var5) {
                  if (!((nr_az)as.elementAt(var5)).d) {
                     if (main.GameCanvas.v % 20 > 10) {
                        var1.drawImage(u, var3 + 10, var4 + 10, 3);
                     }
                     break;
                  }
               }
            }
         }
      }

      this.f(var1);
   }

   private void h(mGraphics var1) {
      var1.e(this.ad, this.ae, this.af, this.ag);
      var1.setColor(0, -this.g);

      for(int var2 = 0; var2 < cE.length; ++var2) {
         int var3;
         if ((var3 = this.ae + var2 * 15) - this.g <= this.ae + this.ag && var3 - this.g >= this.ae - this.aC) {
            mFont.tahoma_7b_dark.drawStringBd(var1, cE[var2], this.ad + 5, var3 + 6, 0);
         }
      }

      this.f(var1);
   }

   private void i(mGraphics var1) {
      var1.e(this.ad, this.ae, this.af, this.ag);
      var1.setColor(0, -this.g);

      for(int var2 = 0; var2 < as.size(); ++var2) {
         nr_az var3 = (nr_az)as.elementAt(var2);
         int var4 = this.ad;
         int var5 = this.ae + var2 * this.aC;
         int var6 = this.af - 1;
         int var7 = this.aC - 1;
         if (var5 - this.g <= this.ae + this.ag && var5 - this.g >= this.ae - this.aC) {
            var1.setColor(var2 == this.aj ? 16383818 : 15196114);
            var1.fillRect(var4, var5, var6, var7);
            mFont.tahoma_7b_dark.drawStringBd(var1, var3.a, this.ad + this.af / 2, var5 + 6, 2);
            if (!var3.d && main.GameCanvas.v % 20 > 10) {
               var1.drawImage(u, var4 + 10, var5 + 10, 3);
            }
         }
      }

      this.f(var1);
   }

   private void j(mGraphics var1) {
      var1.setColor(16711680);
      var1.e(this.ad, this.ae, this.af, this.ag);
      var1.setColor(0, -this.g);
      int var2 = Char.myCharz().nClass.b.length;

      for(int var3 = 0; var3 < var2 + 6; ++var3) {
         int var4 = this.ad + 30;
         int var5 = this.ae + var3 * this.aC;
         int var6 = this.af - 30;
         int var7 = this.aC - 1;
         int var8 = this.ad;
         int var9 = this.ae + var3 * this.aC;
         if (var5 - this.g <= this.ae + this.ag && var5 - this.g >= this.ae - this.aC) {
            var1.setColor(var3 == this.aj ? 16383818 : 15196114);
            if (var3 == 5) {
               var1.setColor(var3 == this.aj ? 16776068 : 16765060);
            }

            var1.fillRect(var4, var5, var6, var7);
            var1.drawImage(GameScr.at, var8, var9, 0);
            String var16;
            if (var3 == 0) {
               SmallImage.b(var1, 567, var8 + 4, var9 + 4, 0, 0);
               var16 = mResources.eU + " " + mResources.ek + ": " + Util.a((long)Char.myCharz().cr);
               mFont.b.drawStringBd(var1, var16, var4 + 5, var5 + 3, 0);
               mFont.m.drawStringBd(var1, Util.a((long)(Char.myCharz().cr + 1000)) + " " + mResources.ff + ": " + mResources.eH + " " + Char.myCharz().hpFrom1000TiemNang, var4 + 5, var5 + 15, 0);
            }

            if (var3 == 1) {
               SmallImage.b(var1, 569, var8 + 4, var9 + 4, 0, 0);
               var16 = mResources.eV + " " + mResources.ek + ": " + Util.a((long)Char.myCharz().cs);
               mFont.b.drawStringBd(var1, var16, var4 + 5, var5 + 3, 0);
               mFont.m.drawStringBd(var1, Util.a((long)(Char.myCharz().cs + 1000)) + " " + mResources.ff + ": " + mResources.eH + " " + Char.myCharz().mpFrom1000TiemNang, var4 + 5, var5 + 15, 0);
            }

            if (var3 == 2) {
               SmallImage.b(var1, 568, var8 + 4, var9 + 4, 0, 0);
               var16 = mResources.eW + " " + mResources.ek + ": " + Util.a((long)Char.myCharz().cq);
               mFont.b.drawStringBd(var1, var16, var4 + 5, var5 + 3, 0);
               mFont.m.drawStringBd(var1, Util.a((long)(Char.myCharz().cq * 100)) + " " + mResources.ff + ": " + mResources.eH + " " + Char.myCharz().damFrom1000TiemNang, var4 + 5, var5 + 15, 0);
            }

            if (var3 == 3) {
               SmallImage.b(var1, 721, var8 + 4, var9 + 4, 0, 0);
               var16 = mResources.eX + " " + mResources.ek + ": " + Util.a((long)Char.myCharz().ct);
               mFont.b.drawStringBd(var1, var16, var4 + 5, var5 + 3, 0);
               mFont.m.drawStringBd(var1, Util.a((long)(500000 + Char.myCharz().ct * 100000)) + " " + mResources.ff + ": " + mResources.eH + " " + Char.myCharz().defFrom1000TiemNang, var4 + 5, var5 + 15, 0);
            }

            if (var3 == 4) {
               SmallImage.b(var1, 719, var8 + 4, var9 + 4, 0, 0);
               var16 = mResources.eZ + " " + mResources.ek + ": " + Char.myCharz().cu + "%";
               int var10;
               if ((var10 = Char.myCharz().cu) > cn.length - 1) {
                  var10 = cn.length - 1;
               }

               long var11 = cn[var10];
               mFont.b.drawStringBd(var1, var16, var4 + 5, var5 + 3, 0);
               mFont.m.drawStringBd(var1, ResLog.b(var11) + " " + mResources.ff + ": " + mResources.eH + " " + Char.myCharz().criticalFrom1000Tiemnang, var4 + 5, var5 + 15, 0);
            }

            if (var3 == 5) {
               if (p != null) {
                  SmallImage.b(var1, q, var8 + 4, var9 + 4, 0, 0);
                  String[] var17 = mFont.k.getWidth(p, 120);

                  for(int var19 = 0; var19 < var17.length; ++var19) {
                     mFont.m.drawStringBd(var1, var17[var19], var4 + 5, var5 + 3 + var19 * 12, 0);
                  }
               } else {
                  mFont.m.drawStringBd(var1, "", var4 + 5, var5 + 9, 0);
               }
            }

            if (var3 >= 6) {
               var7 = var3 - 6;
               SkillTemplate var21 = Char.myCharz().nClass.b[var7];
               SmallImage.b(var1, var21.f, var8 + 4, var9 + 4, 0, 0);
               Skill var12;
               Skill var20;
               if ((var12 = Char.myCharz().a(var21)) != null) {
                  mFont.b.drawStringBd(var1, var21.b, var4 + 5, var5 + 3, 0);
                  mFont.q.drawStringBd(var1, mResources.dn + ": " + var12.point, var4 + var6 - 5, var5 + 3, 1);
                  if (var12.point == var21.maxPoint) {
                     mFont.m.drawStringBd(var1, mResources.fd, var4 + 5, var5 + 15, 0);
                  } else if (var12.template.c()) {
                     String var18 = mResources.d + ": ";
                     int var14 = mFont.m.getWidth(var18) + var4 + 5;
                     int var15 = var5 + 15;
                     mFont.m.drawStringBd(var1, var18, var4 + 5, var15, 0);
                     mFont var10000 = mFont.m;
                     StringBuffer var10002 = new StringBuffer("(");
                     String var10003;
                     if (var12.m / 10 >= 100) {
                        var10003 = "MAX";
                     } else if (var12.m % 10 == 0) {
                        var10003 = var12.m / 10 + "%";
                     } else {
                        var7 = var12.m % 10;
                        var10003 = var12.m / 10 + "." + var7 % 10 + "%";
                     }

                     var10000.drawStringBd(var1, var10002.append(var10003).append(")").toString(), var4 + var6 - 5, var15, 1);
                     var15 += 4;
                     var1.setColor(7169134);
                     var1.fillRect(var14, var15, 50, 5);
                     var4 = var12.m * 50 / 1000;
                     var1.setColor(11992374);
                     var1.fillRect(var14, var15, var4, 5);
                  } else {
                     var20 = var21.h[var12.point];
                     mFont.m.drawStringBd(var1, mResources.dn + " " + (var12.point + 1) + " " + mResources.el + " " + ResLog.b(var20.d) + " " + mResources.ff, var4 + 5, var5 + 15, 0);
                  }
               } else {
                  var20 = var21.h[0];
                  mFont.h.drawStringBd(var1, var21.b, var4 + 5, var5 + 3, 0);
                  mFont.m.drawStringBd(var1, mResources.em + " " + ResLog.b(var20.d) + " " + mResources.eE, var4 + 5, var5 + 15, 0);
               }
            }
         }
      }

      this.f(var1);
   }

   private void k(mGraphics var1) {
      var1.setColor(16711680);
      var1.e(this.ad, this.ae, this.af, this.ag);
      var1.setColor(0, -this.g);

      for(int var2 = 0; var2 < this.D.length; ++var2) {
         int var3 = this.ae + var2 * this.aC;
         int var4 = this.aC - 1;
         if (var3 - this.g <= this.ae + this.ag && var3 - this.g >= this.ae - this.aC) {
            var1.setColor(var2 == this.aj ? 16383818 : 15196114);
            var1.fillRect(this.ad, var3, this.af, var4);
            mFont.b.drawStringBd(var1, this.D[var2], 5, var3 + 1, 0);
            mFont.o.drawStringBd(var1, this.E[var2], 5, var3 + 11, 0);
         }
      }

      this.f(var1);
   }

   private void l(mGraphics var1) {
      var1.setColor(16711680);
      var1.e(this.ad, this.ae, this.af, this.ag);
      var1.setColor(0, -this.g);
      String[] var2 = NapTien.b;
      String[] var3 = NapTien.c;

      for(int var4 = 0; var4 < var3.length; ++var4) {
         int var5 = this.ad;
         int var6 = this.ae + var4 * this.aC;
         int var7 = this.af;
         int var8 = this.aC - 1;
         int var9 = this.ad;
         if (var6 - this.g <= this.ae + this.ag && var6 - this.g >= this.ae - this.aC) {
            var1.setColor(var4 == this.aj ? 16383818 : 15196114);
            var1.b(var5, var6, var7, var8);
            mFont.o.drawStringBd(var1, var2[var4], var9 + 5, var6 + 6, 0);
            mFont.o.drawStringBd(var1, var3[var4], var5 + var7 - 2, var6 + 6, 1);
         }
      }

      this.f(var1);
   }

   private void m(mGraphics var1) {
      var1.setColor(16711680);
      var1.e(this.ad, this.ae, this.af, this.ag);
      var1.setColor(0, -this.g);
      int[] var2 = GameScr.gI().R;
      int[] var3 = GameScr.gI().S;

      for(int var4 = 0; var4 < var3.length; ++var4) {
         int var5 = this.ad + 36;
         int var6 = this.ae + var4 * this.aC;
         int var7 = this.af - 36;
         int var8 = this.aC - 1;
         int var9 = this.ad;
         int var10 = this.ae + var4 * this.aC;
         int var11 = this.aC - 1;
         if (var6 - this.g <= this.ae + this.ag && var6 - this.g >= this.ae - this.aC) {
            var1.setColor(var4 == this.aj ? 16383818 : 15196114);
            var1.b(var5, var6, var7, var8);
            var1.setColor(this.co[var3[var4]]);
            var1.b(var9, var10, 34, var11);
            if (var2[var4] != -1) {
               if (var3[var4] != 1) {
                  mFont.n.drawStringBd(var1, String.valueOf(var2[var4]), var9 + 17, var6 + 6, 2);
               } else {
                  mFont.o.drawStringBd(var1, String.valueOf(var2[var4]), var9 + 17, var6 + 6, 2);
               }

               mFont.m.drawStringBd(var1, GameScr.gI().T[var4] + "/" + GameScr.gI().U[var4], var5 + 5, var6 + 6, 0);
            }

            if (GameScr.gI().X[var4] != null) {
               mFont.o.drawStringBd(var1, GameScr.gI().X[var4] + "(Top " + GameScr.gI().V[var4] + ")", var5 + var7 - 2, var6 + 1, 1);
               mFont.o.drawStringBd(var1, GameScr.gI().Y[var4] + "(Top " + GameScr.gI().W[var4] + ")", var5 + var7 - 2, var6 + 11, 1);
            }
         }
      }

      this.f(var1);
   }

   private void n(mGraphics var1) {
      var1.e(this.ad, this.ae, this.af, this.ag);
      var1.setColor(0, -this.g);
      var1.setColor(0);
      if (this.N != 0) {
         int var2;
         if ((var2 = (this.g + this.ag) / 24 + 1) < this.ag / 24 + 1) {
            var2 = this.ag / 24 + 1;
         }

         if (var2 > this.N) {
            var2 = this.N;
         }

         int var3;
         if ((var3 = this.g / 24) >= var2) {
            var3 = var2 - 1;
         }

         if (var3 < 0) {
            var3 = 0;
         }

         for(var3 = var3; var3 < var2; ++var3) {
            int var4 = this.ad;
            int var5 = this.ae + var3 * this.aC;
            int var6 = this.aC - 1;
            int var7 = this.ad + 24;
            int var8 = this.ae + var3 * this.aC;
            int var9 = this.af - 24;
            int var10 = this.aC - 1;
            var1.setColor(var3 == this.aj ? 16383818 : 15196114);
            var1.b(var7, var8, var9, var10);
            var1.setColor(var3 == this.aj ? 9541120 : 9993045);
            var1.b(var4, var5, 24, var6);
            SmallImage.b(var1, Char.myCharz().aL[this.A][var3], var4 + 12, var5 + var6 / 2, 0, 3);
            String[] var11 = mFont.o.getWidth(Char.myCharz().aK[this.A][var3], 140);

            for(var5 = 0; var5 < var11.length; ++var5) {
               mFont.o.drawStringBd(var1, var11[var5], var7 + 5, var8 + 1 + var5 * 11, 0);
            }
         }

         this.f(var1);
      }
   }

   private void o(mGraphics var1) {
      var1.setColor(16711680);
      var1.e(this.ad, this.ae, this.af, this.ag);
      var1.setColor(0, -this.g);

      try {
         Item[] var2 = Char.myCharz().arrItemBox;
         this.N = this.i(var2.length);
         int var3 = var2.length / 20 + (var2.length % 20 > 0 ? 1 : 0);
         this.aE = this.af / var3;

         for(int var4 = 0; var4 < this.N; ++var4) {
            int var5 = this.ad + 36;
            int var6 = this.ae + var4 * this.aC;
            int var7 = this.af - 36;
            int var8 = this.aC - 1;
            int var9 = this.ad;
            int var10 = this.ae + var4 * this.aC;
            int var11 = this.aC - 1;
            if (var6 - this.g <= this.ae + this.ag && var6 - this.g >= this.ae - this.aC) {
               if (var4 == 0) {
                  for(var7 = 0; var7 < var3; ++var7) {
                     var8 = var7 == this.bN && this.aj == 0 ? (main.GameCanvas.v % 10 < 7 ? -1 : 0) : 0;
                     var1.setColor(var7 == this.bN ? 16383818 : 15723751);
                     var1.fillRect(this.ad + var7 * this.aE, var6 + 9 + var8, this.aE - 1, 14);
                     mFont.o.drawStringBd(var1, "" + var7, this.ad + var7 * this.aE + this.aE / 2, this.ae + 11 + var8, 2);
                  }
               } else {
                  var1.setColor(var4 == this.aj ? 16383818 : 15196114);
                  var1.fillRect(var5, var6, var7, var8);
                  var1.setColor(var4 == this.aj ? 9541120 : 9993045);
                  var7 = c(var4, this.bN);
                  Item var15;
                  if ((var15 = var2[var7]) != null) {
                     for(var7 = 0; var7 < var15.itemOption.length; ++var7) {
                        byte var12;
                        if (var15.itemOption[var7].optionTemplate.name == 72 && var15.itemOption[var7].param > 0 && f(var12 = g(var15.itemOption[var7].param)) != -1) {
                           int var10002 = this.aj;
                           var1.setColor(f(var12));
                        }
                     }
                  }

                  var1.b(var9, var10, 34, var11);
                  if (var15 != null) {
                     String var16 = "";
                     mFont var18 = mFont.m;
                     if (var15.itemOption != null) {
                        for(int var13 = 0; var13 < var15.itemOption.length; ++var13) {
                           if (var15.itemOption[var13].optionTemplate.name == 72) {
                              var16 = " [+" + var15.itemOption[var13].getOptionString() + "]";
                           }

                           if (var15.itemOption[var13].optionTemplate.name == 41) {
                              if (var15.itemOption[var13].param == 1) {
                                 var18 = h(0);
                              } else if (var15.itemOption[var13].param == 2) {
                                 var18 = h(2);
                              } else if (var15.itemOption[var13].param == 3) {
                                 var18 = h(8);
                              } else if (var15.itemOption[var13].param == 4) {
                                 var18 = h(7);
                              }
                           }
                        }
                     }

                     var18.drawStringBd(var1, var15.template.d + var16, var5 + 5, var6 + 1, 0);
                     String var19 = "";
                     if (var15.itemOption != null) {
                        if (var15.itemOption.length > 0 && var15.itemOption[0] != null) {
                           var19 = var19 + var15.itemOption[0].getOptionString();
                        }

                        mFont var17 = mFont.q;
                        if (var15.A < 0 && var15.template.type != 5) {
                           var17 = mFont.p;
                        }

                        if (var15.itemOption.length > 1) {
                           for(int var20 = 1; var20 < var15.itemOption.length; ++var20) {
                              if (var15.itemOption[var20] != null && var15.itemOption[var20].optionTemplate.name != 102 && var15.itemOption[var20].optionTemplate.name != 107) {
                                 var19 = var19 + "," + var15.itemOption[var20].getOptionString();
                              }
                           }
                        }

                        var17.drawStringBd(var1, var19, var5 + 5, var6 + 11, 0);
                     }

                     SmallImage.b(var1, var15.template.f, var9 + 17, var10 + var11 / 2, 0, 3);
                     if (var15.itemOption != null) {
                        for(var7 = 0; var7 < var15.itemOption.length; ++var7) {
                           this.a(var1, var15.itemOption[var7].optionTemplate.name, var9, var10, var11);
                        }

                        for(var7 = 0; var7 < var15.itemOption.length; ++var7) {
                           a(var1, var15.itemOption[var7].optionTemplate.name, var15.itemOption[var7].param, var9, var10, 34, var11);
                        }
                     }

                     if (var15.quantity > 1) {
                        mFont.n.drawStringBd(var1, "" + var15.quantity, var9 + 34, var10 + var11 - mFont.n.getWidth(), 1);
                     }
                  }
               }
            }
         }
      } catch (Exception var14) {
      }

      this.f(var1);
   }

   private Member W() {
      if (this.aj < 2) {
         return null;
      } else if (this.aj > (this.member != null ? this.member.size() : this.myMember.size()) + 1) {
         return null;
      } else {
         return this.member != null ? (Member)this.member.elementAt(this.aj - 2) : (Member)this.myMember.elementAt(this.aj - 2);
      }
   }

   private ClanMessage X() {
      if (this.aj < 2) {
         return null;
      } else {
         return this.aj > ClanMessage.vMessage.size() + 1 ? null : (ClanMessage) ClanMessage.vMessage.elementAt(this.aj - 2);
      }
   }

   private Clan Y() {
      if (this.aj < 2) {
         return null;
      } else {
         return this.aj > this.O.length + 1 ? null : this.O[this.aj - 2];
      }
   }

   private void p(mGraphics var1) {
      var1.e(this.ad, this.ae, this.af, this.ag);
      var1.setColor(0, -this.g);
      var1.setColor(0);
      if (this.bF.size() == 0) {
         mFont.m.drawStringBd(var1, mResources.af, this.ad + this.af / 2, this.ae + this.ag / 2 - mFont.k.getWidth() / 2 + 24, 2);
      }

      for(int var2 = 0; var2 < this.N; ++var2) {
         int var3 = this.ad;
         int var4 = this.ae + var2 * this.aC;
         int var5 = this.aC - 1;
         int var6 = this.ad + 24;
         int var7 = this.ae + var2 * this.aC;
         int var8 = this.af - 24;
         int var9 = this.aC - 1;
         if (var2 == 0) {
            var1.setColor(15196114);
            var1.b(var3, var7, this.af, var9);
            var1.drawImage(var2 == this.aj ? GameScr.ay : GameScr.ax, this.ad + this.af - 5, var7 + 2, StaticObj.TOP_RIGHT);
            (var2 == this.aj ? mFont.g : mFont.tahoma_7b_dark).drawStringBd(var1, this.at ? mResources.ft : mResources.fu, this.ad + this.af - 22, var7 + 7, 2);
            mFont.o.drawStringBd(var1, this.at ? mResources.fw : mResources.fx, this.ad + 5, var7 + var9 / 2 - 4, 0);
         } else {
            var1.setColor(var2 == this.aj ? 16383818 : 15196114);
            var1.b(var6, var7, var8, var9);
            var1.setColor(var2 == this.aj ? 9541120 : 9993045);
            var1.b(var3, var4, 24, var5);
            InfoItem var10;
            if ((var10 = (InfoItem)this.bF.elementAt(var2 - 1)).c.headICON != -1) {
               SmallImage.b(var1, var10.c.headICON, var3, var4, 0, 0);
            } else {
               Rms var11 = GameScr.x[var10.c.head];
               SmallImage.b(var1, var11.a[Char.bC[0][0][0]].a, var3 + var11.a[Char.bC[0][0][0]].b, var4 + var11.a[Char.bC[0][0][0]].c, 0, 0);
            }

            var1.e(this.ad, this.ae + this.g, this.af, this.ag);
            mFont.g.drawStringBd(var1, var10.c.cName, var6 + 5, var7, 0);
            if (!var10.d) {
               mFont.q.drawStringBd(var1, ResLog.a(var10.a, "|", 0)[2], var6 + 5, var7 + 11, 0);
            } else {
               mFont.p.drawStringBd(var1, ResLog.a(var10.a, "|", 0)[2], var6 + 5, var7 + 11, 0);
            }
         }
      }

      this.f(var1);
   }

   private void q(mGraphics var1) {
      var1.e(this.ad, this.ae, this.af, this.ag);
      var1.setColor(0, -this.g);
      var1.setColor(0);

      for(int var2 = 0; var2 < this.N; ++var2) {
         int var3 = this.ad + 26;
         int var4 = this.ae + var2 * this.aC;
         int var5 = this.af - 26;
         int var6 = this.aC - 1;
         int var7 = this.ad;
         int var8 = this.ae + var2 * this.aC;
         int var9 = this.aC - 1;
         if (var4 - this.g <= this.ae + this.ag && var4 - this.g >= this.ae - this.aC) {
            var1.setColor(var2 == this.aj ? 16383818 : 15196114);
            var1.b(var3, var4, var5, var6);
            var1.setColor(var2 == this.aj ? 9541120 : 9993045);
            var1.b(var7, var8, 24, var9);
            Item var11;
            if ((var11 = (Item)this.X.elementAt(var2)) != null) {
               mFont.m.drawStringBd(var1, var11.template.d, var3 + 5, var4 + 1, 0);
               String var12 = "";
               if (var11.itemOption != null && var11.itemOption.length > 0) {
                  if (var11.itemOption[0] != null && var11.itemOption[0].optionTemplate.name != 102 && var11.itemOption[0].optionTemplate.name != 107) {
                     var12 = var12 + var11.itemOption[0].getOptionString();
                  }

                  mFont.q.drawStringBd(var1, var12, var3 + 5, var4 + 11, 0);
                  SmallImage.b(var1, var11.template.f, var7 + 12, var8 + var9 / 2, 0, 3);
               }
            }
         }
      }

      this.f(var1);
   }

   private void r(mGraphics var1) {
      var1.e(this.ad, this.ae, this.af, this.ag);
      var1.setColor(0, -this.g);
      var1.setColor(0);
      if (this.N == 0) {
         mFont.m.drawStringBd(var1, mResources.fB, this.ad + this.af / 2, this.ae + this.ag / 2 - mFont.k.getWidth() / 2, 2);
      } else {
         for(int var2 = 0; var2 < this.N; ++var2) {
            int var3 = this.ad;
            int var4 = this.ae + var2 * this.aC;
            int var5 = this.aC - 1;
            int var6 = this.ad + 24;
            int var7 = this.ae + var2 * this.aC;
            int var8 = this.af - 24;
            int var9 = this.aC - 1;
            var1.setColor(var2 == this.aj ? 16383818 : 15196114);
            var1.b(var6, var7, var8, var9);
            var1.setColor(var2 == this.aj ? 9541120 : 9993045);
            var1.b(var3, var4, 24, var5);
            InfoItem var10;
            if ((var10 = (InfoItem)this.W.elementAt(var2)).c.headICON != -1) {
               SmallImage.b(var1, var10.c.headICON, var3, var4, 0, 0);
            } else {
               Rms var11 = GameScr.x[var10.c.head];
               SmallImage.b(var1, var11.a[Char.bC[0][0][0]].a, var3 + var11.a[Char.bC[0][0][0]].b, var4 + 3 + var11.a[Char.bC[0][0][0]].c, 0, 0);
            }

            var1.e(this.ad, this.ae + this.g, this.af, this.ag);
            if (var10.e) {
               mFont.h.drawStringBd(var1, var10.c.cName, var6 + 5, var7, 0);
               mFont.q.drawStringBd(var1, var10.a, var6 + 5, var7 + 11, 0);
            } else {
               mFont.o.drawStringBd(var1, var10.c.cName, var6 + 5, var7, 0);
               mFont.o.drawStringBd(var1, var10.a, var6 + 5, var7 + 11, 0);
            }
         }

         this.f(var1);
      }
   }

   private void s(mGraphics var1) {
      var1.e(this.ad, this.ae, this.af, this.ag);
      var1.setColor(0, -this.g);
      var1.setColor(0);
      if (this.N == 0) {
         mFont.m.drawStringBd(var1, mResources.bO, this.ad + this.af / 2, this.ae + this.ag / 2 - mFont.k.getWidth() / 2, 2);
      } else {
         for(int var2 = 0; var2 < this.N; ++var2) {
            int var3 = this.ad;
            int var4 = this.ae + var2 * this.aC;
            int var5 = this.aC - 1;
            int var6 = this.ad + 24;
            int var7 = this.ae + var2 * this.aC;
            int var8 = this.af - 24;
            int var9 = this.aC - 1;
            var1.setColor(var2 == this.aj ? 16383818 : 15196114);
            var1.b(var6, var7, var8, var9);
            var1.setColor(var2 == this.aj ? 9541120 : 9993045);
            var1.b(var3, var4, 24, var5);
            InfoItem var10;
            if ((var10 = (InfoItem)this.S.elementAt(var2)).c.headICON != -1) {
               SmallImage.b(var1, var10.c.headICON, var3, var4, 0, 0);
            } else {
               Rms var11 = GameScr.x[var10.c.head];
               SmallImage.b(var1, var11.a[Char.bC[0][0][0]].a, var3 + var11.a[Char.bC[0][0][0]].b, var4 + 3 + var11.a[Char.bC[0][0][0]].c, 0, 0);
            }

            var1.e(this.ad, this.ae + this.g, this.af, this.ag);
            if (var10.e) {
               mFont.h.drawStringBd(var1, var10.c.cName, var6 + 5, var7, 0);
               mFont.q.drawStringBd(var1, var10.a, var6 + 5, var7 + 11, 0);
            } else {
               mFont.o.drawStringBd(var1, var10.c.cName, var6 + 5, var7, 0);
               mFont.o.drawStringBd(var1, var10.a, var6 + 5, var7 + 11, 0);
            }
         }

         this.f(var1);
      }
   }

   private void t(mGraphics var1) {
      var1.e(this.ad, this.ae, this.af, this.ag);
      var1.setColor(0, -this.g);

      for(int var2 = 0; var2 < this.R.size(); ++var2) {
         int var3 = this.ad;
         int var4 = this.ae + var2 * this.aC;
         int var5 = this.af - 1;
         int var6 = this.aC - 1;
         if (var4 - this.g <= this.ae + this.ag && var4 - this.g >= this.ae - this.aC) {
            CommandLine var7 = (CommandLine)this.R.elementAt(var2);
            var1.setColor(var2 == this.aj ? 16383818 : 15196114);
            var1.b(var3, var4, var5, var6);
            if (var7.o.equals("")) {
               mFont.tahoma_7b_dark.drawStringBd(var1, var7.caption, this.ad + this.af / 2, var4 + 6, 2);
            } else {
               mFont.tahoma_7b_dark.drawStringBd(var1, var7.caption, this.ad + this.af / 2, var4 + 1, 2);
               mFont.tahoma_7b_dark.drawStringBd(var1, var7.o, this.ad + this.af / 2, var4 + 11, 2);
            }
         }
      }

      this.f(var1);
   }

   private void u(mGraphics var1) {
      try {
         var1.e(this.ad, this.ae, this.af, this.ag);
         var1.setColor(-this.h, -this.g);
         var1.setColor(0);
         int var2 = this.ad + this.af / 2 - this.cf.length * this.aD / 2;
         int var3;
         if (this.N == 2) {
            mFont.m.drawStringBd(var1, this.an, this.ad + this.af / 2, this.ae + 24 + this.ag / 2 - mFont.k.getWidth() / 2, 2);
            if (this.al && this.myMember.size() == 1) {
               for(var3 = 0; var3 < mResources.dr.length; ++var3) {
                  mFont.tahoma_7b_dark.drawStringBd(var1, mResources.dr[var3], this.ad + this.af / 2, this.ae + 24 + this.ag / 2 - mResources.dr.length * 12 / 2 + var3 * 12, 2);
               }
            }
         }

         if (this.al) {
            this.N = ClanMessage.vMessage.size() + 2;
         }

         for(var3 = 0; var3 < this.N; ++var3) {
            int var4 = this.ad;
            int var5 = this.ae + var3 * this.aC;
            int var6 = this.aC - 1;
            int var7 = this.ad + 24;
            int var8 = this.ae + var3 * this.aC;
            int var9 = this.af - 24;
            int var10 = this.aC - 1;
            if (var8 - this.g <= this.ae + this.ag && var8 - this.g >= this.ae - this.aC) {
               int var11;
               if (var3 == 0) {
                  for(var6 = 0; var6 < this.cf.length; ++var6) {
                     var1.setColor(var6 == this.bM && var3 == this.aj ? 16383818 : 15723751);
                     var1.b(var2 + var6 * this.aD, var8, this.aD - 1, 23);

                     for(var11 = 0; var11 < this.cf[var6].length; ++var11) {
                        mFont.o.drawStringBd(var1, this.cf[var6][var11], var2 + var6 * this.aD + this.aD / 2, this.ae + var11 * 11, 2);
                     }
                  }
               } else if (var3 == 1) {
                  var1.setColor(var3 == this.aj ? 16383818 : 15196114);
                  var1.b(this.ad, var8, this.af, var10);
                  if (this.cg != null) {
                     mFont.tahoma_7b_dark.drawStringBd(var1, this.cg, this.ad + this.af / 2, var8 + 6, 2);
                  }
               } else if (this.ak) {
                  if (this.O != null && this.O.length != 0) {
                     var1.setColor(var3 == this.aj ? 16383818 : 15196114);
                     var1.b(var7, var8, var9, var10);
                     var1.setColor(var3 == this.aj ? 9541120 : 9993045);
                     var1.b(var4, var5, 24, var6);
                     if (ClanImage.isExistClanImage(this.O[var3 - 2].b)) {
                        if (ClanImage.getClanImage((short)this.O[var3 - 2].b).idImage != null) {
                           SmallImage.drawSmallImage(var1, ClanImage.getClanImage((short)this.O[var3 - 2].b).idImage[0], var4 + 12, var5 + var6 / 2, 0, StaticObj.f);
                        }
                     } else {
                        ClanImage var15;
                        (var15 = new ClanImage()).ID = this.O[var3 - 2].b;
                        if (!ClanImage.isExistClanImage(var15.ID)) {
                           ClanImage.getClanImage(var15);
                        }
                     }

                     String var16 = this.O[var3 - 2].c.length() > 17 ? this.O[var3 - 2].c.substring(0, 17) + "..." : this.O[var3 - 2].c;
                     mFont.g.drawStringBd(var1, var16, var7 + 5, var8, 0);
                     mFont.q.drawStringBd(var1, this.O[var3 - 2].d, var7 + 5, var8 + 11, 0);
                     mFont.m.drawStringBd(var1, this.O[var3 - 2].g + "/" + this.O[var3 - 2].h, var7 + var9 - 5, var8, 1);
                  }
               } else if (this.am) {
                  var1.setColor(var3 == this.aj ? 16383818 : 15196114);
                  var1.b(var7, var8, var9, var10);
                  var1.setColor(var3 == this.aj ? 9541120 : 9993045);
                  var1.b(var4, var5, 24, var6);
                  Member var14;
                  if ((var14 = this.member != null ? (Member)this.member.elementAt(var3 - 2) : (Member)this.myMember.elementAt(var3 - 2)).c != -1) {
                     SmallImage.b(var1, var14.c, var4, var5, 0, 0);
                  } else {
                     Rms var17 = GameScr.x[var14.b];
                     SmallImage.b(var1, var17.a[Char.bC[0][0][0]].a, var4 + var17.a[Char.bC[0][0][0]].b, var5 + 3 + var17.a[Char.bC[0][0][0]].c, 0, 0);
                  }

                  var1.e(this.ad, this.ae + this.g, this.af, this.ag);
                  mFont var18 = mFont.tahoma_7b_dark;
                  if (var14.g == 0) {
                     var18 = mFont.a;
                  } else if (var14.g == 1) {
                     var18 = mFont.h;
                  } else if (var14.g == 2) {
                     var18 = mFont.g;
                  }

                  var18.drawStringBd(var1, var14.f, var7 + 5, var8, 0);
                  mFont.q.drawStringBd(var1, mResources.cZ + ": " + var14.h, var7 + 5, var8 + 11, 0);
                  SmallImage.b(var1, 7223, var7 + var9 - 7, var8 + 12, 0, 3);
                  mFont.m.drawStringBd(var1, "" + var14.l, var7 + var9 - 15, var8 + 6, 1);
               } else if (this.al && ClanMessage.vMessage.size() != 0) {
                  ClanMessage var13 = (ClanMessage) ClanMessage.vMessage.elementAt(var3 - 2);
                  var1.setColor(var3 == this.aj && var13.k == null ? 16383818 : 15196114);
                  var1.b(var4, var5, var9 + 24, var10);
                  var13.a(var1, var4, var5);
                  if (var13.k != null) {
                     var11 = this.ad + this.af - 2 - var13.k.length * 40;

                     for(var4 = 0; var4 < var13.k.length; ++var4) {
                        if (var4 == this.bM && var3 == this.aj) {
                           var1.drawImage(GameScr.ay, var11 + var4 * 40 + 20, var8 + var10 / 2, StaticObj.f);
                           mFont.g.drawStringBd(var1, var13.k[var4], var11 + var4 * 40 + 20, var8 + 6, 2);
                        } else {
                           var1.drawImage(GameScr.ax, var11 + var4 * 40 + 20, var8 + var10 / 2, StaticObj.f);
                           mFont.tahoma_7b_dark.drawStringBd(var1, var13.k[var4], var11 + var4 * 40 + 20, var8 + 6, 2);
                        }
                     }
                  }
               }
            }
         }

         this.f(var1);
      } catch (Exception var12) {
         var12.printStackTrace();
      }
   }

   private void v(mGraphics var1) {
      var1.e(this.ad, this.ae, this.af, this.ag);
      var1.setColor(0, -this.g);
      var1.setColor(0);
      if (this.N == 0) {
         mFont.m.drawStringBd(var1, mResources.fo, this.ad + this.af / 2, this.ae + this.ag / 2 - mFont.k.getWidth() / 2, 2);
      } else if (Char.myCharz().arrArchive != null) {
         if (Char.myCharz().arrArchive.length == this.N) {
            for(int var2 = 0; var2 < this.N; ++var2) {
               int var3 = this.ad;
               int var4 = this.ae + var2 * this.aC;
               int var5 = this.af;
               int var6 = this.aC - 1;
               Archivement var7 = Char.myCharz().arrArchive[var2];
               var1.setColor(var2 != this.aj || (var7.isRecieve || var7.d) && (!var7.isRecieve || !var7.d) ? 15196114 : 16383818);
               var1.b(var3, var4, var5, var6);
               if (var7 != null) {
                  if (!var7.d) {
                     mFont.k.drawStringBd(var1, var7.a, var3 + 5, var4, 0);
                     mFont.r.drawStringBd(var1, var7.c + " " + mResources.bE, var3 + var5 - 5, var4, 1);
                     mFont.p.drawStringBd(var1, var7.b, var3 + 5, var4 + 11, 0);
                  } else if (var7.d && !var7.isRecieve) {
                     mFont.k.drawStringBd(var1, var7.a, var3 + 5, var4, 0);
                     mFont.q.drawStringBd(var1, mResources.fp + var7.c + " " + mResources.bE, var3 + 5, var4 + 11, 0);
                     if (var2 == this.aj) {
                        mFont.g.drawStringBd(var1, mResources.cn, var3 + var5 - 20, var4 + 6, 2);
                        mFont.tahoma_7b_dark.drawStringBd(var1, mResources.cn, var3 + var5 - 20, var4 + 6, 2);
                     } else {
                        var1.drawImage(GameScr.ax, var3 + var5 - 20, var4 + var6 / 2, StaticObj.f);
                        mFont.tahoma_7b_dark.drawStringBd(var1, mResources.cn, var3 + var5 - 20, var4 + 6, 2);
                     }
                  } else if (var7.d && var7.isRecieve) {
                     mFont.r.drawStringBd(var1, var7.a, var3 + 5, var4, 0);
                     mFont.r.drawStringBd(var1, var7.b, var3 + 5, var4 + 11, 0);
                  }
               }
            }

            this.f(var1);
         }
      }
   }

   private void w(mGraphics var1) {
      var1.setColor(16711680);
      var1.e(this.ad, this.ae, this.af, this.ag);
      var1.setColor(0, -this.g);
      int var2;
      if (this.k.size() == 0) {
         if (this.ao != null) {
            for(var2 = 0; var2 < this.ao.length; ++var2) {
               mFont.tahoma_7b_dark.drawStringBd(var1, this.ao[var2], this.ad + this.af / 2, this.ae + this.ag / 2 - this.ao.length * 14 / 2 + var2 * 14 + 5, 2);
            }
         }

      } else {
         for(var2 = 0; var2 < this.k.size() + 1; ++var2) {
            int var3 = this.ad + 36;
            int var4 = this.ae + var2 * this.aC;
            int var5 = this.af - 36;
            int var6 = this.aC - 1;
            int var7 = this.ad;
            int var8 = this.ae + var2 * this.aC;
            int var9 = this.aC - 1;
            if (var4 - this.g <= this.ae + this.ag && var4 - this.g >= this.ae - this.aC) {
               if (var2 == this.k.size()) {
                  if (this.k.size() > 0) {
                     if (!main.GameCanvas.isTouch && var2 == this.aj) {
                        var1.setColor(16383818);
                        var1.b(var7, var4, this.af, var6 + 2);
                     }

                     if ((var2 != this.aj || this.cb != 1) && (main.GameCanvas.isTouch || var2 != this.aj)) {
                        var1.drawImage(GameScr.imgLbtnFocus, this.ad + this.af / 2, var4 + var6 / 2 + 1, StaticObj.f);
                        mFont.tahoma_7b_dark.drawStringBd(var1, mResources.cx, this.ad + this.af / 2, var4 + var6 / 2 - 4, 2);
                     } else {
                        var1.drawImage(GameScr.imgLbtn, this.ad + this.af / 2, var4 + var6 / 2 + 1, StaticObj.f);
                        mFont.g.drawStringBd(var1, mResources.cx, this.ad + this.af / 2, var4 + var6 / 2 - 4, 2);
                     }
                  }
               } else {
                  var1.setColor(var2 == this.aj ? 16383818 : 15196114);
                  var1.b(var3, var4, var5, var6);
                  var1.setColor(var2 == this.aj ? 9541120 : 9993045);
                  Item var12;
                  if ((var12 = (Item)this.k.elementAt(var2)) != null) {
                     for(var6 = 0; var6 < var12.itemOption.length; ++var6) {
                        byte var10;
                        if (var12.itemOption[var6].optionTemplate.name == 72 && var12.itemOption[var6].param > 0 && f(var10 = g(var12.itemOption[var6].param)) != -1) {
                           int var10002 = this.aj;
                           var1.setColor(f(var10));
                        }
                     }
                  }

                  var1.b(var7, var8, 34, var9);
                  if (var12 != null) {
                     String var13 = "";
                     mFont var15 = mFont.m;
                     if (var12.itemOption != null) {
                        for(int var11 = 0; var11 < var12.itemOption.length; ++var11) {
                           if (var12.itemOption[var11].optionTemplate.name == 72) {
                              var13 = " [+" + var12.itemOption[var11].param + "]";
                           }

                           if (var12.itemOption[var11].optionTemplate.name == 41) {
                              if (var12.itemOption[var11].param == 1) {
                                 var15 = h(0);
                              } else if (var12.itemOption[var11].param == 2) {
                                 var15 = h(2);
                              } else if (var12.itemOption[var11].param == 3) {
                                 var15 = h(8);
                              } else if (var12.itemOption[var11].param == 4) {
                                 var15 = h(7);
                              }
                           }
                        }
                     }

                     var15.drawStringBd(var1, var12.template.d + var13, var3 + 5, var4 + 1, 0);
                     String var16 = "";
                     if (var12.itemOption != null) {
                        if (var12.itemOption.length > 0 && var12.itemOption[0] != null && var12.itemOption[0].optionTemplate.name != 102 && var12.itemOption[0].optionTemplate.name != 107) {
                           var16 = var16 + var12.itemOption[0].getOptionString();
                        }

                        mFont var14 = mFont.q;
                        if (var12.A < 0 && var12.template.type != 5) {
                           var14 = mFont.p;
                        }

                        if (var12.itemOption.length > 1) {
                           for(int var17 = 1; var17 < var12.itemOption.length; ++var17) {
                              if (var12.itemOption[var17] != null && var12.itemOption[var17].optionTemplate.name != 102 && var12.itemOption[var17].optionTemplate.name != 107) {
                                 var16 = var16 + "," + var12.itemOption[var17].getOptionString();
                              }
                           }
                        }

                        var14.drawStringBd(var1, var16, var3 + 5, var4 + 11, 0);
                     }

                     SmallImage.b(var1, var12.template.f, var7 + 17, var8 + var9 / 2, 0, 3);
                     if (var12.itemOption != null) {
                        for(var6 = 0; var6 < var12.itemOption.length; ++var6) {
                           this.a(var1, var12.itemOption[var6].optionTemplate.name, var7, var8, var9);
                        }

                        for(var6 = 0; var6 < var12.itemOption.length; ++var6) {
                           a(var1, var12.itemOption[var6].optionTemplate.name, var12.itemOption[var6].param, var7, var8, 34, var9);
                        }
                     }

                     if (var12.quantity > 1) {
                        mFont.n.drawStringBd(var1, "" + var12.quantity, var7 + 34, var8 + var9 - mFont.n.getWidth(), 1);
                     }
                  }
               }
            }
         }

         this.f(var1);
      }
   }

   private void x(mGraphics var1) {
      var1.setColor(16711680);
      Item[] var2 = Char.myCharz().arrItemBody;
      Item[] var3 = Char.myCharz().arrItemBag;
      this.N = this.i(var2.length + var3.length);
      int var4 = (var2.length + var3.length) / 20 + ((var2.length + var3.length) % 20 > 0 ? 1 : 0);
      this.aE = this.af / var4;

      int var5;
      int var6;
      int var7;
      int var8;
      for(var5 = 0; var5 < var4; ++var5) {
         var6 = var5 == this.bN && this.aj == 0 ? (main.GameCanvas.v % 10 < 7 ? -1 : 0) : 0;
         var1.setColor(var5 == this.bN ? 16383818 : 15723751);
         var1.fillRect(this.ad + var5 * this.aE, var6 + 89 - 10, this.aE - 1, 21);
         if (var5 == this.bN) {
            var1.setColor(13524492);
            var7 = this.ad + var5 * this.aE;
            var8 = var6 + 89 - 10 + 21;
            var1.fillRect(var7, var8 - 3, this.aE - 1, 3);
         }

         mFont.o.drawStringBd(var1, "" + (var5 + 1), this.ad + var5 * this.aE + this.aE / 2, var6 + 91 - 10, 2);
      }

      var1.e(this.ad, this.ae + 21, this.af, this.ag - 21);
      var1.setColor(0, -this.g);

      try {
         for(var5 = 1; var5 < this.N; ++var5) {
            var6 = this.ad + 36;
            var7 = this.ae + var5 * this.aC;
            var8 = this.af - 36;
            var4 = this.aC - 1;
            int var9 = this.ad;
            int var10 = this.ae + var5 * this.aC;
            int var11 = this.aC - 1;
            if (var7 - this.g <= this.ae + this.ag && var7 - this.g >= this.ae - this.aC) {
               boolean var12 = a(var5, this.bN, Char.myCharz().arrItemBody);
               int var13 = c(var5, this.bN);
               int var14 = b(var5, this.bN, Char.myCharz().arrItemBody);
               var1.setColor(var5 == this.aj ? 16383818 : (var12 ? 15196114 : 15723751));
               var1.b(var6, var7, var8, var4);
               var1.setColor(var5 == this.aj ? 9541120 : (var12 ? 9993045 : 11837316));
               Item var16;
               if ((var16 = var12 ? var2[var13] : var3[var14]) != null) {
                  for(var8 = 0; var8 < var16.itemOption.length; ++var8) {
                     byte var19;
                     if (var16.itemOption[var8].optionTemplate.name == 72 && var16.itemOption[var8].param > 0 && f(var19 = g(var16.itemOption[var8].param)) != -1) {
                        int var10002 = this.aj;
                        var1.setColor(f(var19));
                     }
                  }
               }

               var1.b(var9, var10, 34, var11);
               if (var16 != null && var16.f && main.GameCanvas.panel.z == 12) {
                  var1.setColor(var5 == this.aj ? 7040779 : 6047789);
                  var1.b(var9, var10, 34, var11);
               }

               if (var16 != null) {
                  String var17 = "";
                  mFont var20 = mFont.m;
                  if (var16.itemOption != null) {
                     for(var13 = 0; var13 < var16.itemOption.length; ++var13) {
                        if (var16.itemOption[var13].optionTemplate.name == 72) {
                           var17 = " [+" + var16.itemOption[var13].param + "]";
                        }

                        if (var16.itemOption[var13].optionTemplate.name == 41) {
                           if (var16.itemOption[var13].param == 1) {
                              var20 = h(0);
                           } else if (var16.itemOption[var13].param == 2) {
                              var20 = h(2);
                           } else if (var16.itemOption[var13].param == 3) {
                              var20 = h(8);
                           } else if (var16.itemOption[var13].param == 4) {
                              var20 = h(7);
                           }
                        }
                     }
                  }

                  var20.drawStringBd(var1, var16.template.d + var17, var6 + 5, var7 + 1, 0);
                  String var21 = "";
                  if (var16.itemOption != null) {
                     if (var16.itemOption.length > 0 && var16.itemOption[0] != null && var16.itemOption[0].optionTemplate.name != 102 && var16.itemOption[0].optionTemplate.name != 107) {
                        var21 = var21 + var16.itemOption[0].getOptionString();
                     }

                     mFont var18 = mFont.q;
                     if (var16.A < 0 && var16.template.type != 5) {
                        var18 = mFont.p;
                     }

                     if (var16.itemOption.length > 1) {
                        for(int var22 = 1; var22 < 2; ++var22) {
                           if (var16.itemOption[var22] != null && var16.itemOption[var22].optionTemplate.name != 102 && var16.itemOption[var22].optionTemplate.name != 107) {
                              var21 = var21 + "," + var16.itemOption[var22].getOptionString();
                           }
                        }
                     }

                     var18.drawStringBd(var1, var21, var6 + 5, var7 + 11, 0);
                  }

                  SmallImage.b(var1, var16.template.f, var9 + 17, var10 + var11 / 2, 0, 3);
                  if (var16.itemOption != null) {
                     for(var8 = 0; var8 < var16.itemOption.length; ++var8) {
                        this.a(var1, var16.itemOption[var8].optionTemplate.name, var9, var10, var11);
                     }

                     for(var8 = 0; var8 < var16.itemOption.length; ++var8) {
                        a(var1, var16.itemOption[var8].optionTemplate.name, var16.itemOption[var8].param, var9, var10, 34, var11);
                     }
                  }

                  if (var16.quantity > 1) {
                     mFont.n.drawStringBd(var1, "" + var16.quantity, var9 + 34, var10 + var11 - mFont.n.getWidth(), 1);
                  }
               }
            }
         }
      } catch (Exception var15) {
      }

      this.f(var1);
   }

   private void y(mGraphics var1) {
      if (this.z != 23 && this.z != 24) {
         if (this.z == 20) {
            var1.setColor(13524492);
            var1.fillRect(this.b + 1, 78, this.d - 2, 1);
            mFont.tahoma_7b_dark.drawStringBd(var1, mResources.ap, this.ad + this.af / 2, 59, 2);
         } else if (this.z == 22) {
            var1.setColor(13524492);
            var1.fillRect(this.b + 1, 78, this.d - 2, 1);
            mFont.tahoma_7b_dark.drawStringBd(var1, mResources.p, this.ad + this.af / 2, 59, 2);
         } else if (this.z == 19) {
            var1.setColor(13524492);
            var1.fillRect(this.b + 1, 78, this.d - 2, 1);
            mFont.tahoma_7b_dark.drawStringBd(var1, mResources.bT, this.ad + this.af / 2, 59, 2);
         } else if (this.z == 18) {
            var1.setColor(13524492);
            var1.fillRect(this.b + 1, 78, this.d - 2, 1);
            mFont.tahoma_7b_dark.drawStringBd(var1, mResources.bQ, this.ad + this.af / 2, 59, 2);
         } else if (this.z == 13 && this.equals(main.GameCanvas.G)) {
            var1.setColor(13524492);
            var1.fillRect(this.b + 1, 78, this.d - 2, 1);
            mFont.tahoma_7b_dark.drawStringBd(var1, mResources.cm, this.ad + this.af / 2, 59, 2);
         } else if (this.z == 12 && main.GameCanvas.G != null) {
            var1.setColor(13524492);
            var1.fillRect(this.b + 1, 78, this.d - 2, 1);
            mFont.tahoma_7b_dark.drawStringBd(var1, mResources.cx, this.ad + this.af / 2, 59, 2);
         } else if (this.z == 11) {
            var1.setColor(13524492);
            var1.fillRect(this.b + 1, 78, this.d - 2, 1);
            mFont.tahoma_7b_dark.drawStringBd(var1, mResources.bM, this.ad + this.af / 2, 59, 2);
         } else if (this.z == 16) {
            var1.setColor(13524492);
            var1.fillRect(this.b + 1, 78, this.d - 2, 1);
            mFont.tahoma_7b_dark.drawStringBd(var1, mResources.bN, this.ad + this.af / 2, 59, 2);
         } else if (this.z == 15) {
            var1.setColor(13524492);
            var1.fillRect(this.b + 1, 78, this.d - 2, 1);
            mFont.tahoma_7b_dark.drawStringBd(var1, this.n, this.ad + this.af / 2, 59, 2);
         } else if (this.z == 2 && main.GameCanvas.G != null) {
            var1.setColor(13524492);
            var1.fillRect(this.b + 1, 78, this.d - 2, 1);
            mFont.tahoma_7b_dark.drawStringBd(var1, mResources.cc, this.ad + this.af / 2, 59, 2);
         } else if (this.z == 9) {
            var1.setColor(13524492);
            var1.fillRect(this.b + 1, 78, this.d - 2, 1);
            mFont.tahoma_7b_dark.drawStringBd(var1, mResources.fq, this.ad + this.af / 2, 59, 2);
         } else if (this.z == 3) {
            var1.setColor(13524492);
            var1.fillRect(this.b + 1, 78, this.d - 2, 1);
            mFont.tahoma_7b_dark.drawStringBd(var1, mResources.aG, this.B + this.aD / 2, 59, 2);
         } else if (this.z == 26) {
            var1.setColor(13524492);
            var1.fillRect(this.b + 1, 78, this.d - 2, 1);
            mFont.tahoma_7b_dark.drawStringBd(var1, mResources.D, this.B + this.aD / 2, 59, 2);
         } else if (this.z == 14) {
            var1.setColor(13524492);
            var1.fillRect(this.b + 1, 78, this.d - 2, 1);
            mFont.tahoma_7b_dark.drawStringBd(var1, mResources.fv, this.B + this.aD / 2, 59, 2);
         } else if (this.z == 4) {
            mFont.tahoma_7b_dark.drawStringBd(var1, mResources.cl, this.B + this.aD / 2, 59, 2);
            var1.setColor(13524492);
            var1.fillRect(this.b + 1, 78, this.d - 2, 1);
         } else if (this.z == 7) {
            mFont.tahoma_7b_dark.drawStringBd(var1, mResources.fr, this.B + this.aD / 2, 59, 2);
            var1.setColor(13524492);
            var1.fillRect(this.b + 1, 78, this.d - 2, 1);
         } else if (this.z == 17) {
            mFont.tahoma_7b_dark.drawStringBd(var1, mResources.fC, this.B + this.aD / 2, 59, 2);
            var1.setColor(13524492);
            var1.fillRect(this.b + 1, 78, this.d - 2, 1);
         } else if (this.z == 8) {
            mFont.tahoma_7b_dark.drawStringBd(var1, mResources.ad, this.B + this.aD / 2, 59, 2);
            var1.setColor(13524492);
            var1.fillRect(this.b + 1, 78, this.d - 2, 1);
         } else if (this.z == 10) {
            mFont.tahoma_7b_dark.drawStringBd(var1, mResources.fs, this.B + this.aD / 2, 59, 2);
            var1.setColor(13524492);
            var1.fillRect(this.b + 1, 78, this.d - 2, 1);
         } else {
            if (this.A == 3 && this.C.length != 4) {
               var1.setColor(-this.h, 0);
            }

            for(int var2 = 0; var2 < this.aX.length; ++var2) {
               var1.setColor(var2 == this.A ? 6805896 : 16773296);
               PopUp.paintPopUp(var1, this.B + var2 * this.aD, 52, this.aD - 1, 25, var2 == this.A ? 1 : 0, true);
               if (var2 == this.ce) {
                  var1.drawImage(ItemMap.myTexture2dflare, this.B + var2 * this.aD + this.aD / 2, 62, 3);
               }

               mFont var3 = var2 == this.A ? mFont.m : mFont.o;
               if (!this.aX[var2][1].equals("")) {
                  var3.drawStringBd(var1, this.aX[var2][0], this.B + var2 * this.aD + this.aD / 2, 53, 2);
                  var3.drawStringBd(var1, this.aX[var2][1], this.B + var2 * this.aD + this.aD / 2, 64, 2);
               } else {
                  var3.drawStringBd(var1, this.aX[var2][0], this.B + var2 * this.aD + this.aD / 2, 59, 2);
               }

               if (this.z == 0 && this.aX.length == 5 && GameScr.aV && main.GameCanvas.v % 4 == 0) {
                  var1.drawImage(ItemMap.myTexture2dflare, this.B + 3 * this.aD + this.aD / 2, 77, 33);
               }
            }

            var1.setColor(13524492);
            var1.fillRect(1, 78, this.d - 2, 1);
         }
      } else {
         var1.setColor(13524492);
         var1.fillRect(this.b + 1, 78, this.d - 2, 1);
         mFont.tahoma_7b_dark.drawStringBd(var1, mResources.bR, this.ad + this.af / 2, 59, 2);
      }
   }

   private static void z(mGraphics var0) {
      mFont.c.drawString(var0, mResources.an + " " + "2.3.7", 60, 4, 0, mFont.tahoma_7b_dark);
      mFont.n.drawString(var0, mResources.ao + ": " + Char.myCharz().cName, 60, 16, 0, mFont.o);
      String var1 = main.GameCanvas.loginScr.tfUser.getText().equals("") ? mResources.gh : main.GameCanvas.loginScr.tfUser.getText();
      mFont.n.drawString(var0, mResources.aq + " " + ServerListScreen.a[ServerListScreen.ipSelect] + ": " + var1, 60, 27, 0, mFont.o);
   }

   private void A(mGraphics var1) {
      this.a(var1, Char.myCharz());
   }

   private void a(mGraphics var1, Char var2) {
      mFont.c.drawString(var1, (GameScr.isNewMember != 1 ? "" : "       ") + var2.cName, this.b + 60, 4, 0, mFont.tahoma_7b_dark);
      if (GameScr.isNewMember == 1) {
         SmallImage.b(var1, 5427, this.b + 55, 4, 0, 0);
      }

      if (var2.cMaxStamina > 0) {
         mFont.n.drawString(var1, mResources.eY, this.b + 60, 16, 0, mFont.o);
         var1.drawImage(GameScr.aF, this.b + 95, 19, 0);
         int var3 = var2.cStamina * mGraphics.setColor(GameScr.aE) / var2.cMaxStamina;
         var1.e(95, this.b + 19, var3, 20);
         var1.drawImage(GameScr.aE, this.b + 95, 19, 0);
      }

      var1.e(0, 0, main.GameCanvas.z, main.GameCanvas.A);
      if (var2.cPower > 0L) {
         mFont.n.drawString(var1, var2.me ? var2.c() : var2.currStrLevel, this.b + 60, 27, 0, mFont.o);
      }

      mFont.n.drawString(var1, mResources.cZ + ": " + Util.a(var2.cPower), this.b + 60, 38, 0, mFont.o);
   }

   public final int a(Item var1) {
      if (var1 == null) {
         return -1;
      } else if (!var1.b()) {
         return 0;
      } else if (var1.itemOption == null) {
         return -1;
      } else {
         ItemOption var2;
         if ((var2 = var1.itemOption[0]).optionTemplate.name == 22) {
            var2.optionTemplate = GameScr.gI().iOptionTemplates[6];
            var2.param *= 1000;
         }

         if (var2.optionTemplate.name == 23) {
            var2.optionTemplate = GameScr.gI().iOptionTemplates[7];
            var2.param *= 1000;
         }

         Item var3 = null;

         int var4;
         for(var4 = 0; var4 < Char.myCharz().arrItemBody.length; ++var4) {
            Item var5 = Char.myCharz().arrItemBody[var4];
            if (var2.optionTemplate.name == 22) {
               var2.optionTemplate = GameScr.gI().iOptionTemplates[6];
               var2.param *= 1000;
            }

            if (var2.optionTemplate.name == 23) {
               var2.optionTemplate = GameScr.gI().iOptionTemplates[7];
               var2.param *= 1000;
            }

            if (var5 != null && var5.itemOption != null && var5.template.type == var1.template.type) {
               var3 = var5;
               break;
            }
         }

         if (var3 == null) {
            ResLog.c("5");
            return var2.param;
         } else {
            if (var3 != null && var3.itemOption != null) {
               var4 = var2.param - var3.itemOption[0].param;
            } else {
               var4 = var2.param;
            }

            return var4;
         }
      }
   }

   private static void B(mGraphics var0) {
      mFont.c.drawStringBd(var0, mResources.aK[TileMap.r], 60, 4, 0);
      String var1 = "";
      if (TileMap.l >= 135 && TileMap.l <= 138) {
         var1 = " " + mResources.m + TileMap.n;
      }

      mFont.n.drawStringBd(var0, TileMap.k + var1, 60, 16, 0);
      mFont.c.drawStringBd(var0, mResources.fn + ": ", 60, 27, 0);
      if (GameScr.z() >= 0 && GameScr.z() <= TileMap.mapNames.length - 1) {
         mFont.n.drawStringBd(var0, TileMap.mapNames[GameScr.z()], 60, 38, 0);
      } else {
         mFont.n.drawStringBd(var0, mResources.ep, 60, 38, 0);
      }
   }

   private void C(mGraphics var1) {
      mFont.n.drawString(var1, mResources.eU + ": " + Char.myCharz().cHP + " / " + Char.myCharz().cHPFull, this.b + 60, 2, 0, mFont.o);
      mFont.n.drawString(var1, mResources.eV + ": " + Char.myCharz().cMP + " / " + Char.myCharz().cMPFull, this.b + 60, 14, 0, mFont.o);
      mFont.n.drawString(var1, mResources.eW + ": " + Char.myCharz().cDamFull, this.b + 60, 26, 0, mFont.o);
      mFont.n.drawString(var1, mResources.eX + ": " + Char.myCharz().cDefull + ", " + mResources.eZ + ": " + Char.myCharz().cCriticalFull + "%", this.b + 60, 38, 0, mFont.o);
   }

   private void D(mGraphics var1) {
      var1.e(this.ad, this.ae, this.af, this.ag);
      var1.setColor(-this.aK, -this.aL);
      var1.drawImage(aP, this.ad, this.ae, 0);
      int var2 = Char.myCharz().head;
      Rms var7 = GameScr.x[var2];
      SmallImage.b(var1, var7.a[Char.bC[0][0][0]].a, this.cy, this.cz + 5, 0, 3);
      byte var8 = 2;
      if (this.cy <= 40) {
         var8 = 0;
      }

      if (this.cy >= 220) {
         var8 = 1;
      }

      mFont.d.drawString(var1, TileMap.k, this.cy, this.cz - 12, var8, mFont.o);
      int var3 = -1;
      int var4;
      if (GameScr.z() != -1) {
         for(var4 = 0; var4 < by[TileMap.r].length; ++var4) {
            if (by[TileMap.r][var4] == GameScr.z()) {
               var3 = var4;
               break;
            }

            var3 = 4;
         }

         if (main.GameCanvas.v % 4 > 0) {
            var1.drawImage(ItemMap.myTexture2dflare, this.ad + bz[TileMap.r][var3], this.ae + bA[TileMap.r][var3], 3);
         }
      }

      int var5;
      int var6;
      if (!main.GameCanvas.isTouch) {
         var1.drawImage(i, this.cA, this.cB, StaticObj.TOP_RIGHT);

         for(var4 = 0; var4 < bz[TileMap.r].length; ++var4) {
            var5 = bz[TileMap.r][var4] + this.ad;
            var6 = bA[TileMap.r][var4] + this.ae;
            if (ResLog.a(var5 - 15, var6 - 15, 30, 30, this.cA, this.cB)) {
               var8 = 2;
               if (var5 <= 20) {
                  var8 = 0;
               }

               if (var5 >= 220) {
                  var8 = 1;
               }

               mFont.d.drawString(var1, TileMap.mapNames[by[TileMap.r][var4]], var5, var6 - 12, var8, mFont.o);
               break;
            }
         }
      } else if (!this.bY) {
         for(var4 = 0; var4 < bz[TileMap.r].length; ++var4) {
            var5 = bz[TileMap.r][var4] + this.ad;
            var6 = bA[TileMap.r][var4] + this.ae;
            if (ResLog.a(var5 - 15, var6 - 15, 30, 30, this.bZ, this.ca)) {
               var8 = 2;
               if (var5 <= 30) {
                  var8 = 0;
               }

               if (var5 >= 220) {
                  var8 = 1;
               }

               var1.drawImage(i, var5, var6, StaticObj.TOP_RIGHT);
               mFont.d.drawString(var1, TileMap.mapNames[by[TileMap.r][var4]], var5, var6 - 12, var8, mFont.o);
               break;
            }
         }
      }

      var1.setColor(-var1.setColor(), -var1.b());
      if (var3 != -1) {
         if (bz[TileMap.r][var3] + this.ad < this.aK) {
            var1.setColor(Mob.R, 0, 0, 9, 6, 5, this.ad + 5, this.ae + this.ag / 2 - 4, 0);
         }

         if (this.aK + this.af < bz[TileMap.r][var3] + this.ad) {
            var1.setColor(Mob.R, 0, 0, 9, 6, 6, this.ad + this.af - 5, this.ae + this.ag / 2 - 4, StaticObj.TOP_RIGHT);
         }

         if (bA[TileMap.r][var3] < this.aL) {
            var1.setColor(Mob.R, 0, 0, 9, 6, 1, this.ad + this.af / 2, this.ae + 5, StaticObj.a);
         }

         if (bA[TileMap.r][var3] > this.aL + this.ag) {
            var1.setColor(Mob.R, 0, 0, 9, 6, 0, this.ad + this.af / 2, this.ae + this.ag - 5, StaticObj.c);
         }
      }

   }

   private void E(mGraphics var1) {
      int var2 = main.GameCanvas.A > 300 ? 20 : 15;
      if (ar) {
         GameScr.gI();
         if (!GameScr.e()) {
            GameScr.gI();
            if (!GameScr.f()) {
               var1.drawImage(this.cc == 1 ? GameScr.imgLbtn : GameScr.imgLbtnFocus, this.ad + this.af / 2, this.ae + this.ag - var2, 3);
               mFont.tahoma_7b_dark.drawStringBd(var1, mResources.cl, this.ad + this.af / 2, this.ae + this.ag - (var2 + 5), 2);
            }
         }
      }

      this.cr = this.ad + 5;
      this.cs = this.ae + 14;
      this.cx = this.cs;
      var1.e(this.ad, this.ae, this.af, this.ag - 35);
      if (this.ch != null) {
         if (this.ch.d > 0) {
            var1.setColor(Mob.R, 0, 0, 9, 6, 1, this.ad + this.af - 12, this.ae + 3, 0);
         }

         if (this.ch.d < this.ch.l) {
            var1.setColor(Mob.R, 0, 0, 9, 6, 0, this.ad + this.af - 12, this.ae + this.ag - 45, 0);
         }

         var1.setColor(0, -this.ch.d);
      }

      this.cv = 0;
      boolean var3 = false;
      int var4;
      if (Char.myCharz().aD != null) {
         for(var4 = 0; var4 < Char.myCharz().aD.d.length; ++var4) {
            mFont.o.drawStringBd(var1, Char.myCharz().aD.d[var4], this.ad + this.af / 2, this.cx - 5 + var4 * 12, 2);
            ++this.cv;
         }

         this.cx += (Char.myCharz().aD.d.length - 1) * 12;
         var4 = 0;

         int var10;
         for(var10 = 0; var10 < Char.myCharz().aD.f.length; ++var10) {
            String var9;
            mFont var11;
            if (Char.myCharz().aD.f[var10] != null) {
               label185: {
                  var4 = var10;
                  var9 = "- " + Char.myCharz().aD.f[var10];
                  mFont var10000;
                  mGraphics var10001;
                  String var10002;
                  int var10003;
                  int var10004;
                  if (Char.myCharz().aD.b[var10] != -1) {
                     if (Char.myCharz().aD.a == var10) {
                        if (Char.myCharz().aD.b[var10] != 1) {
                           var9 = var9 + " (" + Char.myCharz().aD.h + "/" + Char.myCharz().aD.b[var10] + ")";
                        }

                        if (Char.myCharz().aD.h != Char.myCharz().aD.b[var10]) {
                           var11 = mFont.o;
                           if (!var3) {
                              var3 = true;
                              (var11 = mFont.q).drawStringBd(var1, var9, this.cr + 5 + (var11 == mFont.q && main.GameCanvas.v % 20 > 10 ? main.GameCanvas.v % 4 / 2 : 0), this.cx += 12, 0);
                           } else {
                              var11.drawStringBd(var1, "- ...", this.cr + 5 + (var11 == mFont.q && main.GameCanvas.v % 20 > 10 ? main.GameCanvas.v % 4 / 2 : 0), this.cx += 12, 0);
                           }
                           break label185;
                        }

                        var10000 = mFont.k;
                        var10001 = var1;
                        var10002 = var9;
                        var10003 = this.cr;
                        var10004 = 5;
                     } else {
                        if (Char.myCharz().aD.a <= var10) {
                           if (Char.myCharz().aD.b[var10] != 1) {
                              var9 = var9 + " 0/" + Char.myCharz().aD.b[var10];
                           }

                           var11 = mFont.o;
                           if (!var3) {
                              var3 = true;
                              (var11 = mFont.q).drawStringBd(var1, var9, this.cr + 5 + (var11 == mFont.q && main.GameCanvas.v % 20 > 10 ? main.GameCanvas.v % 4 / 2 : 0), this.cx += 12, 0);
                           } else {
                              var11.drawStringBd(var1, "- ...", this.cr + 5 + (var11 == mFont.q && main.GameCanvas.v % 20 > 10 ? main.GameCanvas.v % 4 / 2 : 0), this.cx += 12, 0);
                           }
                           break label185;
                        }

                        if (Char.myCharz().aD.b[var10] != 1) {
                           var9 = var9 + " (" + Char.myCharz().aD.b[var10] + "/" + Char.myCharz().aD.b[var10] + ")";
                        }

                        var10000 = mFont.s;
                        var10001 = var1;
                        var10002 = var9;
                        var10003 = this.cr;
                        var10004 = 5;
                     }
                  } else if (Char.myCharz().aD.a > var10) {
                     var10000 = mFont.s;
                     var10001 = var1;
                     var10002 = var9;
                     var10003 = this.cr;
                     var10004 = 5;
                  } else {
                     var11 = mFont.o;
                     if (!var3) {
                        var3 = true;
                        (var11 = mFont.q).drawStringBd(var1, var9, this.cr + 5 + (var11 == mFont.q && main.GameCanvas.v % 20 > 10 ? main.GameCanvas.v % 4 / 2 : 0), this.cx += 12, 0);
                        break label185;
                     }

                     var10000 = var11;
                     var10001 = var1;
                     var10002 = "- ...";
                     var10003 = this.cr + 5;
                     var10004 = var11 == mFont.q && main.GameCanvas.v % 20 > 10 ? main.GameCanvas.v % 4 / 2 : 0;
                  }

                  var10000.drawStringBd(var10001, var10002, var10003 + var10004, this.cx += 12, 0);
               }

               ++this.cv;
            } else if (Char.myCharz().aD.a <= var10) {
               var9 = "- " + Char.myCharz().aD.f[var4];
               var11 = mFont.o;
               if (!var3) {
                  var3 = true;
                  var11 = mFont.q;
               }

               var11.drawStringBd(var1, var9, this.cr + 5 + (var11 == mFont.q && main.GameCanvas.v % 20 > 10 ? main.GameCanvas.v % 4 / 2 : 0), this.cx += 12, 0);
            }
         }

         this.cx += 5;

         for(var10 = 0; var10 < Char.myCharz().aD.e.length; ++var10) {
            mFont.m.drawStringBd(var1, Char.myCharz().aD.e[var10], this.cr + 5, this.cx += 12, 0);
            ++this.cv;
         }
      } else {
         var4 = GameScr.z();
         byte var5 = GameScr.A();
         String var6;
         if (var4 != -3 && var5 != -3) {
            if (Char.myCharz().aD == null && Char.myCharz().ctaskId == 9 && Char.myCharz().nClass.a == 0) {
               var6 = mResources.aY;
            } else {
               if (var5 < 0 || var4 < 0) {
                  return;
               }

               var6 = mResources.aV[0] + Npc.npcTemplates[var5].name + mResources.aV[1] + TileMap.mapNames[var4] + mResources.aV[2];
            }
         } else {
            var6 = mResources.aV[3];
         }

         String[] var7 = mFont.s.getWidth(var6, 150);

         for(int var8 = 0; var8 < var7.length; ++var8) {
            if (var8 == 0) {
               mFont.s.drawStringBd(var1, var7[var8], this.cr + 5, this.cx = this.cs, 0);
            } else {
               mFont.s.drawStringBd(var1, var7[var8], this.cr + 5, this.cx += 12, 0);
            }
         }
      }

      if (this.ch == null) {
         this.ch = new nr_ds();
         this.ch.a(this.cv, 12, this.ad, this.ae, this.af, this.ag - var2 - 40, true, 1);
      }

   }

   private void Z() {
      for(int var1 = 0; var1 < this.k.size(); ++var1) {
         ((Item)this.k.elementAt(var1)).f = false;
      }

      this.k.removeAllElements();
   }

   public final void z() {
      if (this.timeShow > 0) {
         this.isClose = false;
      } else {
         if (this.isTypeShop()) {
            Char.myCharz().X();
         }

         if (this.o != null && this.z == 13 && this.o.b) {
            this.o = null;
         }

         if (this.z == 13 && !this.aS) {
            Service.gI().a((byte)3, (int)-1, (byte)-1, (int)-1);
         }

         ResLog.c("HIDE PANELLLLLLLLLLLLLLLLLLLLLL");
         SoundMn.stopAll();
         GameScr.bs = true;
         TileMap.s = -1;
         aP = null;
         System.gc();
         this.bO = false;
         this.isClose = true;
         this.Z();
         Hint.clickNpc();
         main.GameCanvas.G = null;
         main.GameCanvas.k();
         main.GameCanvas.clearKeyPressed();
         this.bP = this.bQ = 0;
         this.bS = false;
         this.isShow = false;
         if ((Char.myCharz().cHP <= 0 || Char.myCharz().statusMe == 14 || Char.myCharz().statusMe == 5) && Char.myCharz().cF) {
            CommandLine var1 = new CommandLine(mResources.aW[0], 11038, GameScr.gI());
            GameScr.gI().center = var1;
            Char.myCharz().cHP = 0;
         }

      }
   }

   public final void A() {
      if (this.timeShow > 0) {
         this.isClose = false;
      } else {
         if (this.isTypeShop()) {
            Char.myCharz().X();
         }

         if (this.o != null && this.z == 13 && this.o.b) {
            this.o = null;
         }

         if (this.z == 13 && !this.aS) {
            Service.gI().a((byte)3, (int)-1, (byte)-1, (int)-1);
         }

         if (this.z == 15) {
            Service.gI().v(-1);
         }

         SoundMn.stopAll();
         GameScr.bs = true;
         TileMap.s = -1;
         if (aP != null) {
            aP = null;
         }

         System.gc();
         this.bO = false;
         if (this.z != 4) {
            if (this.z == 24) {
               this.ah();
            } else if (this.z == 23) {
               this.q();
            } else if (this.z != 3 && this.z != 14) {
               if (this.z != 18 && this.z != 19 && this.z != 20 && this.z != 21) {
                  if (this.z != 8 && this.z != 11 && this.z != 16) {
                     this.isClose = true;
                  } else {
                     this.at();
                     this.h = this.aJ = 0;
                  }
               } else {
                  this.q();
                  this.h = this.aJ = 0;
               }
            } else if (this.cH) {
               this.isClose = true;
            } else {
               this.q();
               this.h = this.aJ = 0;
            }
         } else {
            this.q();
            this.h = this.aJ = 0;
         }

         Hint.clickNpc();
         main.GameCanvas.G = null;
         main.GameCanvas.k();
         main.GameCanvas.clearKeyPressed();
         main.GameCanvas.W = false;
         this.bP = this.bQ = 0;
         this.bS = false;
         if ((Char.myCharz().cHP <= 0 || Char.myCharz().statusMe == 14 || Char.myCharz().statusMe == 5) && Char.myCharz().cF) {
            CommandLine var1 = new CommandLine(mResources.aW[0], 11038, GameScr.gI());
            GameScr.gI().center = var1;
            Char.myCharz().cHP = 0;
         }

      }
   }

   public final void B() {
      if (this.o != null && this.o.b) {
         this.o.c();
      } else if (this.cI) {
         ++this.cK;
         if (this.cK == 10) {
            this.cK = 0;
            this.cI = false;
            this.o.a.setText("");
            this.o.h = mResources.fF + " ";
            this.o.a.name = mResources.ec;
            this.o.g = "";
            this.o.b = true;
            this.o.a.setIputType(1);
            this.o.a.b(10);
            if (main.GameCanvas.isTouch) {
               this.o.a.a();
            }
         }

      } else if (this.cJ) {
         ++this.cK;
         if (this.cK == 10) {
            this.cK = 0;
            this.cJ = false;
            this.o.a.setText("");
            this.o.h = mResources.fG + "  ";
            this.o.a.name = mResources.ec;
            this.o.g = "";
            this.o.b = true;
            this.o.a.setIputType(1);
            this.o.a.b(10);
            if (main.GameCanvas.isTouch) {
               this.o.a.a();
            }
         }

      } else {
         if (this.ch != null) {
            this.ch.b();
         }

         if (this.tabIcon != null && this.tabIcon.k) {
            nr_do var19 = this.tabIcon;
            if (nr_do.f != null) {
               nr_do.f.b();
            }

            if (var19.h != var19.g) {
               var19.i = var19.g - var19.h << 2;
               var19.j += var19.i;
               var19.h += var19.j >> 3;
               var19.j &= 15;
            }

            if (Math.abs(var19.g - var19.h) < 10) {
               var19.h = var19.g;
            }

            if (var19.h >= var19.a + var19.b - 10 && var19.g >= var19.a + var19.b - 10) {
               var19.k = false;
            }

         } else {
            this.V();
            if (this.bU > 0) {
               --this.bU;
               if (this.bU == 0) {
                  this.bo[this.A] = this.aj;
                  MyVector var2;
                  Item var21;
                  switch(this.z) {
                  case 0:
                     Panel var1 = this;

                     try {
                        if (var1.A == 0) {
                           var1.K();
                        }

                        if (var1.A == 1) {
                           var1.ae();
                        }

                        if (var1.A == 2 && var1.aj >= 0) {
                           if (Char.myCharz().statusMe == 14) {
                              main.GameCanvas.startOKDlg(mResources.ew);
                           } else if (var1.aj != 0 && var1.aj != 1 && var1.aj != 2 && var1.aj != 3 && var1.aj != 4 && var1.aj != 5) {
                              int var24 = var1.aj - 6;
                              SkillTemplate var6 = Char.myCharz().nClass.b[var24];
                              Skill var22 = Char.myCharz().a(var6);
                              Skill var23 = null;
                              MyVector var26 = new MyVector("");
                              if (var22 != null) {
                                 if (var22.point == var6.maxPoint) {
                                    var26.addElement(new CommandLine(mResources.cz, var1, 9003, var22.template));
                                    var26.addElement(new CommandLine(mResources.CLOSE, 2));
                                 } else {
                                    var23 = var6.h[var22.point];
                                    var26.addElement(new CommandLine(mResources.cx, var1, 9002, var23));
                                    var26.addElement(new CommandLine(mResources.cz, var1, 9003, var22.template));
                                 }
                              } else {
                                 var23 = var6.h[0];
                                 var26.addElement(new CommandLine(mResources.fi, var1, 9004, var23));
                              }

                              main.GameCanvas.menu.a(var26, var1.b, (var1.aj + 1) * var1.aC - var1.g + var1.ae);
                              var1.a(var6, var22, var23);
                           } else {
                              label615: {
                                 long var5 = Char.myCharz().cTiemNang;
                                 int var20 = Char.myCharz().cr;
                                 int var4 = Char.myCharz().cs;
                                 int var7 = Char.myCharz().cq;
                                 int var8 = Char.myCharz().ct;
                                 Char.myCharz();
                                 MyVector var11;
                                 if (var1.aj == 0) {
                                    if (var5 < (long)(Char.myCharz().cr + 1000)) {
                                       main.GameCanvas.c(mResources.eJ + Char.myCharz().cTiemNang + mResources.eK + (Char.myCharz().cr + 1000));
                                       break label615;
                                    }

                                    if (var5 > (long)var20 && var5 < (long)(10 * (2 * (var20 + 1000) + 180) / 2)) {
                                       main.GameCanvas.startYesNoDlg(mResources.eL + (var20 + 1000) + mResources.eM + Char.myCharz().hpFrom1000TiemNang + mResources.eN, new CommandLine(mResources.eI, var1, 9000, (Object)null), new CommandLine(mResources.bu, var1, 4007, (Object)null));
                                       break label615;
                                    }

                                    if (var5 >= (long)(10 * (2 * (var20 + 1000) + 180) / 2) && var5 < (long)(100 * (2 * (var20 + 1000) + 1980) / 2)) {
                                       (var11 = new MyVector("")).addElement(new CommandLine(mResources.eI + "\n" + Char.myCharz().hpFrom1000TiemNang + mResources.eU + "\n" + "-" + ResLog.b((long)(var20 + 1000)), var1, 9000, (Object)null));
                                       var11.addElement(new CommandLine(mResources.eI + "\n" + 10 * Char.myCharz().hpFrom1000TiemNang + mResources.eU + "\n" + "-" + ResLog.b((long)(10 * (2 * (var20 + 1000) + 180) / 2)), var1, 9006, (Object)null));
                                       main.GameCanvas.menu.a(var11, var1.b, (var1.aj + 1) * var1.aC - var1.g + var1.ae);
                                       var1.d(var1.aj);
                                    }

                                    if (var5 >= (long)(100 * (2 * (var20 + 1000) + 1980) / 2)) {
                                       (var11 = new MyVector("")).addElement(new CommandLine(mResources.eI + "\n" + Char.myCharz().hpFrom1000TiemNang + mResources.eU + "\n" + "-" + ResLog.b((long)(var20 + 1000)), var1, 9000, (Object)null));
                                       var11.addElement(new CommandLine(mResources.eI + "\n" + 10 * Char.myCharz().hpFrom1000TiemNang + mResources.eU + "\n" + "-" + ResLog.b((long)(10 * (2 * (var20 + 1000) + 180) / 2)), var1, 9006, (Object)null));
                                       var11.addElement(new CommandLine(mResources.eI + "\n" + 100 * Char.myCharz().hpFrom1000TiemNang + mResources.eU + "\n" + "-" + ResLog.b((long)(100 * (2 * (var20 + 1000) + 1980) / 2)), var1, 9007, (Object)null));
                                       main.GameCanvas.menu.a(var11, var1.b, (var1.aj + 1) * var1.aC - var1.g + var1.ae);
                                       var1.d(var1.aj);
                                    }
                                 }

                                 if (var1.aj == 1) {
                                    if (Char.myCharz().cTiemNang < (long)(Char.myCharz().cs + 1000)) {
                                       main.GameCanvas.startOKDlg(mResources.eJ + Char.myCharz().cTiemNang + mResources.eK + (Char.myCharz().cs + 1000));
                                       break label615;
                                    }

                                    if (var5 > (long)var4 && var5 < (long)(10 * (2 * (var4 + 1000) + 180) / 2)) {
                                       main.GameCanvas.startYesNoDlg(mResources.eL + (var4 + 1000) + mResources.eM + Char.myCharz().mpFrom1000TiemNang + mResources.eO, new CommandLine(mResources.eI, var1, 9000, (Object)null), new CommandLine(mResources.bu, var1, 4007, (Object)null));
                                       break label615;
                                    }

                                    if (var5 >= (long)(10 * (2 * (var4 + 1000) + 180) / 2) && var5 < (long)(100 * (2 * (var4 + 1000) + 1980) / 2)) {
                                       (var11 = new MyVector("")).addElement(new CommandLine(mResources.eI + "\n" + Char.myCharz().mpFrom1000TiemNang + mResources.eV + "\n" + "-" + ResLog.b((long)(var20 + 1000)), var1, 9000, (Object)null));
                                       var11.addElement(new CommandLine(mResources.eI + "\n" + 10 * Char.myCharz().mpFrom1000TiemNang + mResources.eV + "\n" + "-" + ResLog.b((long)(10 * (2 * (var20 + 1000) + 180) / 2)), var1, 9006, (Object)null));
                                       main.GameCanvas.menu.a(var11, var1.b, (var1.aj + 1) * var1.aC - var1.g + var1.ae);
                                       var1.d(var1.aj);
                                    }

                                    if (var5 >= (long)(100 * (2 * (var4 + 1000) + 1980) / 2)) {
                                       (var11 = new MyVector("")).addElement(new CommandLine(mResources.eI + "\n" + Char.myCharz().mpFrom1000TiemNang + mResources.eV + "\n" + "-" + ResLog.b((long)(var4 + 1000)), var1, 9000, (Object)null));
                                       var11.addElement(new CommandLine(mResources.eI + "\n" + 10 * Char.myCharz().mpFrom1000TiemNang + mResources.eV + "\n" + "-" + ResLog.b((long)(10 * (2 * (var4 + 1000) + 180) / 2)), var1, 9006, (Object)null));
                                       var11.addElement(new CommandLine(mResources.eI + "\n" + 100 * Char.myCharz().mpFrom1000TiemNang + mResources.eV + "\n" + "-" + ResLog.b((long)(100 * (2 * (var4 + 1000) + 1980) / 2)), var1, 9007, (Object)null));
                                       main.GameCanvas.menu.a(var11, var1.b, (var1.aj + 1) * var1.aC - var1.g + var1.ae);
                                       var1.d(var1.aj);
                                    }
                                 }

                                 if (var1.aj == 2) {
                                    if (Char.myCharz().cTiemNang < (long)(Char.myCharz().cq * Char.myCharz().cB)) {
                                       main.GameCanvas.startOKDlg(mResources.eJ + Char.myCharz().cTiemNang + mResources.eK + var7 * 100);
                                       break label615;
                                    }

                                    if (var5 > (long)var7 && var5 < (long)(10 * (var7 * 2 + 9) / 2 * Char.myCharz().cB)) {
                                       main.GameCanvas.startYesNoDlg(mResources.eL + var7 * 100 + mResources.eM + Char.myCharz().damFrom1000TiemNang + mResources.eP, new CommandLine(mResources.eI, var1, 9000, (Object)null), new CommandLine(mResources.bu, var1, 4007, (Object)null));
                                       break label615;
                                    }

                                    if (var5 >= (long)(10 * (var7 * 2 + 9) / 2 * Char.myCharz().cB) && var5 < (long)(100 * (var7 * 2 + 99) / 2 * Char.myCharz().cB)) {
                                       (var11 = new MyVector("")).addElement(new CommandLine(mResources.eI + "\n" + Char.myCharz().damFrom1000TiemNang + "\n" + mResources.eW + "\n" + "-" + ResLog.b((long)(var7 * 100)), var1, 9000, (Object)null));
                                       var11.addElement(new CommandLine(mResources.eI + "\n" + 10 * Char.myCharz().damFrom1000TiemNang + "\n" + mResources.eW + "\n" + "-" + ResLog.b((long)(10 * (var7 * 2 + 9) / 2 * Char.myCharz().cB)), var1, 9006, (Object)null));
                                       main.GameCanvas.menu.a(var11, var1.b, (var1.aj + 1) * var1.aC - var1.g + var1.ae);
                                       var1.d(var1.aj);
                                    }

                                    if (var5 >= (long)(100 * (var7 * 2 + 99) / 2 * Char.myCharz().cB)) {
                                       (var11 = new MyVector("")).addElement(new CommandLine(mResources.eI + "\n" + Char.myCharz().damFrom1000TiemNang + "\n" + mResources.eW + "\n" + "-" + ResLog.b((long)(var7 * 100)), var1, 9000, (Object)null));
                                       var11.addElement(new CommandLine(mResources.eI + "\n" + 10 * Char.myCharz().damFrom1000TiemNang + "\n" + mResources.eW + "\n" + "-" + ResLog.b((long)(10 * (var7 * 2 + 9) / 2 * Char.myCharz().cB)), var1, 9006, (Object)null));
                                       var11.addElement(new CommandLine(mResources.eI + "\n" + 100 * Char.myCharz().damFrom1000TiemNang + "\n" + mResources.eW + "\n" + "-" + ResLog.b((long)(100 * (var7 * 2 + 99) / 2 * Char.myCharz().cB)), var1, 9007, (Object)null));
                                       main.GameCanvas.menu.a(var11, var1.b, (var1.aj + 1) * var1.aC - var1.g + var1.ae);
                                       var1.d(var1.aj);
                                    }
                                 }

                                 long var27;
                                 if (var1.aj == 3) {
                                    if (Char.myCharz().cTiemNang < (long)('썐' + Char.myCharz().ct * 1000)) {
                                       main.GameCanvas.startOKDlg(mResources.eJ + Util.a(Char.myCharz().cTiemNang) + mResources.eK + Util.a((long)('썐' + Char.myCharz().ct * 1000)));
                                    } else {
                                       var27 = 1L * (long)(2 * (var8 + 5)) / 2L * 100000L;
                                       long var13 = 10L * (long)(2 * (var8 + 5) + 9) / 2L * 100000L;
                                       long var15 = 100L * (long)(2 * (var8 + 5) + 99) / 2L * 100000L;
                                       mResources.eL = mResources.eI;
                                       (var2 = new MyVector("")).addElement(new CommandLine(mResources.eL + "\n" + "1 " + mResources.eX + "\n" + ResLog.b(var27), var1, 9000, (Object)null));
                                       var2.addElement(new CommandLine(mResources.eL + "\n" + "10 " + mResources.eX + "\n" + ResLog.b(var13), var1, 9006, (Object)null));
                                       var2.addElement(new CommandLine(mResources.eL + "\n" + "100 " + mResources.eX + "\n" + ResLog.b(var15), var1, 9007, (Object)null));
                                       main.GameCanvas.menu.a(var2, var1.b, (var1.aj + 1) * var1.aC - var1.g + var1.ae);
                                       var1.d(var1.aj);
                                    }
                                 } else if (var1.aj == 4) {
                                    int var28;
                                    if ((var28 = Char.myCharz().cu) > cn.length - 1) {
                                       var28 = cn.length - 1;
                                    }

                                    var27 = cn[var28];
                                    if (Char.myCharz().cTiemNang < var27) {
                                       main.GameCanvas.startOKDlg(mResources.eJ + ResLog.b(Char.myCharz().cTiemNang) + mResources.eK + ResLog.b(var27));
                                    } else {
                                       main.GameCanvas.startYesNoDlg(mResources.eL + ResLog.a(var27) + mResources.eM + Char.myCharz().criticalFrom1000Tiemnang + mResources.eQ, new CommandLine(mResources.eI, var1, 9000, (Object)null), new CommandLine(mResources.bu, var1, 4007, (Object)null));
                                    }
                                 } else if (var1.aj == 5) {
                                    Service.gI().a((byte)0);
                                 }
                              }
                           }
                        }

                        if (var1.A == 3) {
                           if (var1.C.length == 4) {
                              var1.ag();
                           } else {
                              var1.bK = null;
                              var1.cG = null;
                              if (var1.aj < 0) {
                                 var1.bM = -1;
                              } else {
                                 MyVector var25;
                                 if (Char.myCharz().clan == null) {
                                    if (var1.aj == 0) {
                                       if (var1.bM == 0) {
                                          var1.o.h = mResources.ds;
                                          var1.o.a.name = mResources.dt;
                                          var1.o.g = "";
                                          var1.o.b = true;
                                          var1.o.a.isFocus = true;
                                          var1.o.a.setIputType(0);
                                          if (main.GameCanvas.isTouch) {
                                             var1.o.a.a();
                                          }
                                       } else if (var1.bM == 1) {
                                          InfoDlg.a();
                                          var1.o.h = mResources.dv;
                                          var1.o.a.name = mResources.ds;
                                          var1.o.g = "";
                                          var1.o.b = true;
                                          var1.o.a.setIputType(0);
                                          if (main.GameCanvas.isTouch) {
                                             var1.o.a.a();
                                          }

                                          Service.gI().a((byte)1, (byte)-1, (String)null);
                                       }
                                    } else if (var1.aj != -1) {
                                       if (var1.aj == 1) {
                                          if (var1.ak) {
                                             Service.gI().a("");
                                          } else if (var1.am && var1.bC != null) {
                                             main.GameCanvas.startYesNoDlg(mResources.dx + var1.bC.c, new CommandLine(mResources.bm, var1, 4000, var1.bC), new CommandLine(mResources.bn, var1, 4005, var1.bC));
                                          }
                                       } else if (var1.ak) {
                                          var1.bC = var1.Y();
                                          if (var1.bC != null) {
                                             (var25 = new MyVector("")).addElement(new CommandLine(mResources.dz, var1, 4000, var1.bC));
                                             var25.addElement(new CommandLine(mResources.dA, var1, 4001, var1.bC));
                                             main.GameCanvas.menu.a(var25, var1.b, (var1.aj + 1) * var1.aC - var1.g + var1.ae);
                                             var1.a(var1.Y());
                                          }
                                       } else if (var1.am) {
                                          var1.bE = var1.W();
                                          if (var1.bE != null) {
                                             (var25 = new MyVector("")).addElement(new CommandLine(mResources.CLOSE, var1, 8000, var1.bC));
                                             main.GameCanvas.menu.a(var25, var1.b, (var1.aj + 1) * var1.aC - var1.g + var1.ae);
                                             main.GameCanvas.menu.a(var25, 0, (var1.aj + 1) * var1.aC - var1.g + var1.ae);
                                             var1.a(var1.bE);
                                          }
                                       }
                                    }
                                 } else if (var1.aj == 0) {
                                    if (var1.al) {
                                       if (var1.bM == 0) {
                                          if (var1.myMember.size() > 1) {
                                             var1.o.h = mResources.du;
                                             var1.o.a.name = mResources.bp;
                                             var1.o.g = "";
                                             var1.o.b = true;
                                             var1.o.a.isFocus = true;
                                             var1.o.a.setIputType(0);
                                             if (main.GameCanvas.isTouch) {
                                                var1.o.a.a();
                                             }
                                          } else {
                                             var1.member = null;
                                             var1.ak = false;
                                             var1.am = true;
                                             var1.al = false;
                                             var1.N = var1.myMember.size() + 2;
                                             var1.v();
                                          }
                                       }

                                       if (var1.bM == 1) {
                                          Service.gI().a(1, (String)null, -1);
                                       }

                                       if (var1.bM == 2) {
                                          var1.member = null;
                                          var1.ak = false;
                                          var1.am = true;
                                          var1.al = false;
                                          var1.N = var1.myMember.size() + 2;
                                          var1.v();
                                          var1.M();
                                       }
                                    } else if (var1.am) {
                                       if (var1.bM == 0) {
                                          var1.ak = false;
                                          var1.am = false;
                                          var1.al = true;
                                          var1.N = ClanMessage.vMessage.size() + 2;
                                          var1.v();
                                       }

                                       if (var1.bM == 1) {
                                          if (var1.myMember.size() > 1) {
                                             Service.gI().b();
                                          } else {
                                             var1.ai();
                                          }
                                       }

                                       if (var1.bM == 2) {
                                          if (var1.myMember.size() > 1) {
                                             var1.ai();
                                          } else {
                                             Service.gI().a((byte)3, (byte)-1, (String)null);
                                          }
                                       }

                                       if (var1.bM == 3) {
                                          Service.gI().a((byte)3, (byte)-1, (String)null);
                                       }
                                    }
                                 } else if (var1.aj == 1) {
                                    if (var1.ak) {
                                       Service.gI().a("");
                                    }
                                 } else if (var1.ak) {
                                    var1.bC = var1.Y();
                                    if (var1.bC != null) {
                                       (var25 = new MyVector("")).addElement(new CommandLine(mResources.dA, var1, 4001, var1.bC));
                                       main.GameCanvas.menu.a(var25, var1.b, (var1.aj + 1) * var1.aC - var1.g + var1.ae);
                                       var1.a(var1.Y());
                                    }
                                 } else if (var1.am) {
                                    ResLog.c("TOI DAY 1");
                                    var1.bE = var1.W();
                                    if (var1.bE != null) {
                                       var25 = new MyVector("");
                                       ResLog.c("TOI DAY 2");
                                       if (var1.member != null) {
                                          var25.addElement(new CommandLine(mResources.CLOSE, var1, 8000, (Object)null));
                                          ResLog.c("TOI DAY 3");
                                       } else if (var1.myMember != null) {
                                          ResLog.c("TOI DAY 4");
                                          ResLog.c("my role= " + Char.myCharz().aj);
                                          if (Char.myCharz().charID == var1.bE.a || Char.myCharz().aj == 2) {
                                             var25.addElement(new CommandLine(mResources.CLOSE, var1, 8000, var1.bE));
                                          }

                                          if (Char.myCharz().aj < 2 && Char.myCharz().charID != var1.bE.a) {
                                             ResLog.c("TOI DAY");
                                             if (var1.bE.g == 0 || var1.bE.g == 1) {
                                                var25.addElement(new CommandLine(mResources.CLOSE, var1, 8000, var1.bE));
                                             }

                                             if (var1.bE.g == 2) {
                                                var25.addElement(new CommandLine(mResources.dB, var1, 5002, var1.bE));
                                             }

                                             if (Char.myCharz().aj == 0) {
                                                var25.addElement(new CommandLine(mResources.dC, var1, 5001, var1.bE));
                                                if (var1.bE.g == 1) {
                                                   var25.addElement(new CommandLine(mResources.dD, var1, 5003, var1.bE));
                                                }
                                             }
                                          }

                                          if (Char.myCharz().aj < var1.bE.g) {
                                             var25.addElement(new CommandLine(mResources.dE, var1, 5004, var1.bE));
                                          }
                                       }

                                       main.GameCanvas.menu.a(var25, var1.b, (var1.aj + 1) * var1.aC - var1.g + var1.ae);
                                       var1.a(var1.bE);
                                    }
                                 } else if (var1.al) {
                                    var1.bD = var1.X();
                                    if (var1.bD != null) {
                                       if (var1.bD.b == 0) {
                                          (var25 = new MyVector("")).addElement(new CommandLine(mResources.CLOSE, var1, 8000, var1.bD));
                                          main.GameCanvas.menu.a(var25, var1.b, (var1.aj + 1) * var1.aC - var1.g + var1.ae);
                                          var1.a(var1.bD);
                                       } else if (var1.bD.b == 1) {
                                          if (var1.bD.c != Char.myCharz().charID && var1.bM != -1) {
                                             Service.gI().d(var1.bD.a);
                                          }
                                       } else if (var1.bD.b == 2 && var1.bD.k != null) {
                                          if (var1.bM == 0) {
                                             Service.gI().a((int)var1.bD.a, (byte)1);
                                          } else if (var1.bM == 1) {
                                             Service.gI().a((int)var1.bD.a, (byte)0);
                                          }
                                       }
                                    }
                                 }

                                 if (main.GameCanvas.isTouch) {
                                    var1.bM = -1;
                                    var1.aj = -1;
                                 }
                              }
                           }
                        }

                        if (var1.A == 4) {
                           var1.ag();
                        }
                     } catch (Exception var17) {
                        var17.printStackTrace();
                     }
                     break;
                  case 1:
                  case 17:
                     this.bB = null;
                     if (this.aj >= 0) {
                        var2 = new MyVector("");
                        if (this.A < this.aX.length - (main.GameCanvas.G != null ? 0 : 1) && this.z != 17) {
                           this.bB = Char.myCharz().aJ[this.A][this.aj];
                           if (this.bB != null) {
                              if (this.bB.y) {
                                 if (this.bB.s > 0) {
                                    var2.addElement(new CommandLine(mResources.ev + "\n" + ResLog.b((long)this.bB.s), this, 3005, this.bB));
                                 }
                              } else if (this.bI == 4) {
                                 var2.addElement(new CommandLine(mResources.cn, this, 30001, this.bB));
                                 var2.addElement(new CommandLine(mResources.bj, this, 30002, this.bB));
                                 var2.addElement(new CommandLine(mResources.co, this, 30003, this.bB));
                              } else if (this.bB.n == 0 && this.bB.p == 0) {
                                 if (this.bB.j != 0L) {
                                    var2.addElement(new CommandLine(mResources.eu + "\n" + ResLog.a(this.bB.j) + " \n" + mResources.ff, this, 3004, this.bB));
                                 } else {
                                    var2.addElement(new CommandLine(mResources.cn + "\n" + mResources.en, this, 3000, this.bB));
                                 }
                              } else if (this.bI == 8) {
                                 if (this.bB.n > 0) {
                                    var2.addElement(new CommandLine(mResources.ev + "\n" + ResLog.b((long)this.bB.n) + "\n" + mResources.bC, this, 30001, this.bB));
                                 }

                                 if (this.bB.p > 0) {
                                    var2.addElement(new CommandLine(mResources.ev + "\n" + ResLog.b((long)this.bB.p) + "\n" + mResources.bD, this, 30002, this.bB));
                                 }
                              } else if (this.bI != 2) {
                                 if (this.bB.n > 0) {
                                    var2.addElement(new CommandLine(mResources.ev + "\n" + ResLog.b((long)this.bB.n) + "\n" + mResources.bC, this, 3000, this.bB));
                                 }

                                 if (this.bB.p > 0) {
                                    var2.addElement(new CommandLine(mResources.ev + "\n" + ResLog.b((long)this.bB.p) + "\n" + mResources.bD, this, 3001, this.bB));
                                 }
                              } else {
                                 if (this.bB.n != -1) {
                                    var2.addElement(new CommandLine(mResources.ev + "\n" + ResLog.b((long)this.bB.n) + "\n" + mResources.bC, this, 10016, this.bB));
                                 }

                                 if (this.bB.p != -1) {
                                    var2.addElement(new CommandLine(mResources.ev + "\n" + ResLog.b((long)this.bB.p) + "\n" + mResources.bD, this, 10017, this.bB));
                                 }
                              }
                           }
                        } else if (this.bI == 0) {
                           if (this.aj == 0) {
                              this.a(Char.myCharz().arrItemBody.length + Char.myCharz().arrItemBag.length, false);
                           } else {
                              this.bB = null;
                              if (!a(this.aj, this.bN, Char.myCharz().arrItemBody)) {
                                 if ((var21 = Char.myCharz().arrItemBag[b(this.aj, this.bN, Char.myCharz().arrItemBody)]) != null) {
                                    this.bB = var21;
                                 }
                              } else if ((var21 = Char.myCharz().arrItemBody[c(this.aj, this.bN)]) != null) {
                                 this.bB = var21;
                              }

                              if (this.bB != null) {
                                 var2.addElement(new CommandLine(mResources.ea, this, 3002, this.bB));
                              }
                           }
                        } else {
                           if (this.z == 17) {
                              this.bB = Char.myCharz().aJ[4][this.aj];
                           } else {
                              this.bB = Char.myCharz().aJ[this.A][this.aj];
                           }

                           if (this.bB.v == 0) {
                              if (this.bB.a(87)) {
                                 var2.addElement(new CommandLine(mResources.fE, this, 10013, this.bB));
                              } else {
                                 var2.addElement(new CommandLine(mResources.fD, this, 10012, this.bB));
                              }
                           } else if (this.bB.v == 1) {
                              var2.addElement(new CommandLine(mResources.fH, this, 10014, this.bB));
                              var2.addElement(new CommandLine(mResources.fL, this, 10018, this.bB));
                           } else if (this.bB.v == 2) {
                              var2.addElement(new CommandLine(mResources.fI, this, 10015, this.bB));
                           }
                        }

                        if (this.bB != null) {
                           Char.myCharz().a(this.bB.D, this.bB.E, this.bB.F, this.bB.G);
                           main.GameCanvas.menu.a(var2, this.b, (this.aj + 1) * this.aC - this.g + this.ae);
                           this.b(this.bB);
                        } else {
                           this.ah = null;
                        }
                     }
                     break;
                  case 2:
                     this.ao();
                     break;
                  case 3:
                     this.an();
                     break;
                  case 4:
                     if (aP != null) {
                        aP = null;
                     }

                     TileMap.s = -1;
                     System.gc();
                     SmallImage.loadBigRMS();
                     this.q();
                     this.h = this.aJ = 0;
                  case 5:
                  case 6:
                  case 22:
                  case 24:
                  case 25:
                  default:
                     break;
                  case 7:
                     if (this.equals(main.GameCanvas.G) && main.GameCanvas.panel.z == 2) {
                        this.ao();
                        return;
                     }

                     this.ae();
                     break;
                  case 8:
                     this.am();
                     break;
                  case 9:
                     this.ad();
                     break;
                  case 10:
                     if (this.aj != -1) {
                        this.ck = true;
                        this.A();
                     }
                     break;
                  case 11:
                     this.ak();
                     break;
                  case 12:
                     this.ac();
                     break;
                  case 13:
                     this.ab();
                     break;
                  case 14:
                     this.an();
                     break;
                  case 15:
                     this.aa();
                     break;
                  case 16:
                     this.aj();
                     break;
                  case 18:
                     this.al();
                     break;
                  case 19:
                     this.as();
                     break;
                  case 20:
                     this.au();
                     break;
                  case 21:
                     if (this.A == 0) {
                        if (this.aj == -1 || this.aj > Char.myPetz().arrItemBody.length - 1) {
                           break;
                        }

                        var2 = new MyVector("");
                        var21 = Char.myPetz().arrItemBody[this.aj];
                        this.bB = var21;
                        if (this.bB != null) {
                           var2.addElement(new CommandLine(mResources.dY, this, 2006, this.bB));
                           main.GameCanvas.menu.a(var2, this.b, (this.aj + 1) * this.aC - this.g + this.ae);
                           this.b(this.bB);
                        } else {
                           this.ah = null;
                        }
                     }

                     if (this.A == 1 && this.aj != -1) {
                        if (this.aj == 5) {
                           main.GameCanvas.startYesNoDlg(mResources.q, new CommandLine(mResources.bm, 888351), new CommandLine(mResources.bn, 2001));
                        } else {
                           Service.gI().h((byte)this.aj);
                           if (this.aj < 4) {
                              Char.myPetz().petStatus = (byte)this.aj;
                           }
                        }
                     }

                     if (this.A == 2) {
                        this.ae();
                     }
                     break;
                  case 23:
                     if (this.aj != -1) {
                        this.cD = this.aj;
                        ((nr_az)as.elementAt(this.cD)).d = true;
                        Rms.saveRMSInt(String.valueOf(((nr_az)as.elementAt(this.cD)).c), 1);
                        String var3 = ((nr_az)as.elementAt(this.cD)).b;
                        cE = mFont.o.getWidth(var3, this.af - 40);
                        this.N = cE.length;
                        this.aC = 16;
                        this.aj = main.GameCanvas.isTouch ? -1 : 0;
                        this.aH = this.N * this.aC - this.ag;
                        if (this.aH < 0) {
                           this.aH = 0;
                        }

                        if (this.g < 0) {
                           this.g = this.f = 0;
                        }

                        if (this.g > this.aH) {
                           this.g = this.f = this.aH;
                        }

                        this.z = 24;
                        this.c(0);
                     }
                     break;
                  case 26:
                     if (this.aj != -1) {
                        main.GameCanvas.panel.A();
                     }
                  }
               }
            }

            for(int var18 = 0; var18 < ClanMessage.vMessage.size(); ++var18) {
               ((ClanMessage) ClanMessage.vMessage.elementAt(var18)).a();
            }

            this.ap();
         }
      }
   }

   private void aa() {
      if (this.aj >= -1) {
         if (this.bH) {
            Service.gI().a(this.n, (byte)this.aj);
         } else {
            MyVector var1;
            (var1 = new MyVector("")).addElement(new CommandLine(mResources.aL[0], this, 9999, (TopInfo)this.V.elementAt(this.aj)));
            main.GameCanvas.menu.a(var1, this.b, (this.aj + 1) * this.aC - this.g + this.ae);
            TopInfo var2 = (TopInfo)this.V.elementAt(this.aj);
            String var3 = "|0|1|" + var2.e;
            var3 = var3 + "\n|1|Top " + var2.h;
            var3 = var3 + "\n|1|" + var2.f;
            var3 = var3 + "\n|2|" + var2.i;
            this.ah = new ChatPopup();
            this.a(this.ah, var3);
            this.bK = new int[]{var2.a, var2.d, var2.c};
            this.bB = null;
            this.cG = null;
         }
      }
   }

   private void ab() {
      if (this.A == 0 && this.equals(main.GameCanvas.panel)) {
         this.ae();
      } else {
         MyVector var1;
         if (this.A == 0 && this.equals(main.GameCanvas.G) || this.A == 2) {
            if (this.equals(main.GameCanvas.G)) {
               this.bB = (Item)main.GameCanvas.G.U.elementAt(this.aj);
            } else {
               this.bB = (Item)main.GameCanvas.panel.U.elementAt(this.aj);
            }

            ResLog.c("toi day select= " + this.aj);
            (var1 = new MyVector("")).addElement(new CommandLine(mResources.CLOSE, this, 8000, this.bB));
            if (this.bB != null) {
               main.GameCanvas.menu.a(var1, this.b, (this.aj + 1) * this.aC - this.g + this.ae);
               this.b(this.bB);
            } else {
               this.ah = null;
            }
         }

         if (this.A == 1) {
            if (this.aj == this.N - 3) {
               if (this.aR) {
                  return;
               }

               if (this.o == null) {
                  this.o = new ChatTextField();
                  this.o.a.b = main.GameCanvas.A - 35 - ChatTextField.gI().a.height;
                  this.o.a();
                  this.o.c = main.GameCanvas.panel;
               }

               this.o.h = mResources.eb;
               this.o.a.name = mResources.ec;
               this.o.g = "";
               this.o.b = true;
               this.o.a.setIputType(1);
               this.o.a.b(10);
               if (main.GameCanvas.isTouch) {
                  this.o.a.a();
               }
            } else if (this.aj == this.N - 2) {
               if (!this.aS) {
                  this.aR = !this.aR;
                  if (this.aR) {
                     Service.gI().a((byte)5, (int)-1, (byte)-1, (int)-1);
                  } else {
                     this.A();
                     InfoDlg.a();
                     Service.gI().a((byte)3, (int)-1, (byte)-1, (int)-1);
                  }
               } else {
                  this.aS = false;
               }
            } else if (this.aj == this.N - 1) {
               if (this.aR && !this.aS && this.m) {
                  main.GameCanvas.startYesNoDlg(mResources.et, new CommandLine(mResources.bm, this, 7002, (Object)null), new CommandLine(mResources.bn, this, 4005, (Object)null));
               }
            } else {
               if (this.aR) {
                  return;
               }

               this.bB = (Item)main.GameCanvas.panel.T.elementAt(this.aj);
               (var1 = new MyVector("")).addElement(new CommandLine(mResources.CLOSE, this, 8000, this.bB));
               if (this.bB != null) {
                  main.GameCanvas.menu.a(var1, this.b, (this.aj + 1) * this.aC - this.g + this.ae);
                  this.b(this.bB);
               } else {
                  this.ah = null;
               }
            }
         }

         if (main.GameCanvas.isTouch) {
            this.aj = -1;
         }

      }
   }

   private void ac() {
      if (this.A == 0) {
         if (this.aj == -1) {
            return;
         }

         if (this.k.size() == 0) {
            return;
         }

         if (this.aj == this.k.size()) {
            this.cb = -1;
            this.aj = main.GameCanvas.isTouch ? -1 : 0;
            InfoDlg.a();
            Service.gI().a((byte)1, (MyVector)this.k);
            return;
         }

         if (this.aj > this.k.size() - 1) {
            return;
         }

         this.bB = (Item)main.GameCanvas.panel.k.elementAt(this.aj);
         MyVector var1;
         (var1 = new MyVector("")).addElement(new CommandLine(mResources.dX, this, 6001, this.bB));
         if (this.bB != null) {
            main.GameCanvas.menu.a(var1, this.b, (this.aj + 1) * this.aC - this.g + this.ae);
            this.b(this.bB);
         } else {
            this.ah = null;
         }
      }

      if (this.A == 1) {
         this.ae();
      }

   }

   private void ad() {
      if (this.aj >= 0) {
         if (Char.myCharz().arrArchive[this.aj].d && !Char.myCharz().arrArchive[this.aj].isRecieve) {
            if (!main.GameCanvas.isTouch) {
               Service.gI().b(this.aj);
               return;
            }

            if (main.GameCanvas.o > this.ad + this.af - 40) {
               Service.gI().b(this.aj);
            }
         }

      }
   }

   private void ae() {
      ResLog.c("fire inventory");
      if (Char.myCharz().statusMe == 14) {
         main.GameCanvas.startOKDlg(mResources.ew);
      } else if (this.aj != -1) {
         if (this.aj == 0) {
            this.a(Char.myCharz().arrItemBody.length + Char.myCharz().arrItemBag.length, false);
         } else {
            this.bB = null;
            MyVector var1 = new MyVector("");
            Item var2;
            if (!a(this.aj, this.bN, Char.myCharz().arrItemBody)) {
               if ((var2 = Char.myCharz().arrItemBag[b(this.aj, this.bN, Char.myCharz().arrItemBody)]) != null) {
                  this.bB = var2;
                  if (main.GameCanvas.panel.z == 12) {
                     var1.addElement(new CommandLine(mResources.ex, this, 6000, this.bB));
                  } else if (main.GameCanvas.panel.z == 13) {
                     var1.addElement(new CommandLine(mResources.ey, this, 7000, this.bB));
                  } else if (var2.b()) {
                     var1.addElement(new CommandLine(mResources.bl, this, 2000, this.bB));
                     if (Char.myCharz().havePet) {
                        var1.addElement(new CommandLine(mResources.dZ, this, 2005, this.bB));
                     }
                  } else {
                     var1.addElement(new CommandLine(mResources.bl, this, 2001, this.bB));
                  }
               }
            } else if ((var2 = Char.myCharz().arrItemBody[c(this.aj, this.bN)]) != null) {
               this.bB = var2;
               var1.addElement(new CommandLine(mResources.dX, this, 2002, this.bB));
            }

            if (this.bB != null) {
               Char.myCharz().a(this.bB.D, this.bB.E, this.bB.F, this.bB.G);
               if (main.GameCanvas.panel.z != 12 && main.GameCanvas.panel.z != 13) {
                  if (this.bG == 0) {
                     var1.addElement(new CommandLine(mResources.dY, this, 2003, this.bB));
                  }

                  if (this.bG == 1) {
                     var1.addElement(new CommandLine(mResources.ea, this, 3002, this.bB));
                  }
               }

               main.GameCanvas.menu.a(var1, this.b, (this.aj + 1) * this.aC - this.g + this.ae);
               this.b(this.bB);
            } else {
               this.ah = null;
            }
         }
      }
   }

   private void af() {
      this.A();
      if (RadarScr.list == null || RadarScr.list.size() == 0) {
         Service.gI().b((int)0, (int)-1);
      }

      RadarScr.a().switchToMe();
   }

   private void ag() {
      ResLog.c("selected doFireTool trong Panel:" + this.aj);
      if (this.aj >= 0) {
         if (SoundMn.a && this.aj == F.length - 1) {
            Service.gI().w();
         } else {
            if (!Char.myCharz().havePet) {
               switch(this.aj) {
               case 0:
                  this.af();
                  return;
               case 1:
                  Service.gI().j((int)54);
                  return;
               case 2:
                  this.ah();
                  return;
               case 3:
                  Service.gI().b((byte)0, (byte)-1);
                  InfoDlg.a();
                  return;
               case 4:
                  if (Char.myCharz().statusMe == 14) {
                     main.GameCanvas.startOKDlg(mResources.ew);
                     return;
                  }

                  Service.gI().h();
                  return;
               case 5:
                  main.GameCanvas.endDlg();
                  if (Char.myCharz().Y() < 5) {
                     main.GameCanvas.startOKDlg(mResources.ez);
                     return;
                  }

                  if (this.o == null) {
                     this.o = new ChatTextField();
                     this.o.a.b = main.GameCanvas.A - 35 - ChatTextField.gI().a.height;
                     this.o.a();
                     this.o.c = main.GameCanvas.panel;
                  }

                  this.o.h = mResources.eA;
                  this.o.a.name = mResources.bp;
                  this.o.g = "";
                  this.o.b = true;
                  this.o.a.setIputType(0);
                  if (main.GameCanvas.isTouch) {
                     this.o.a.a();
                     return;
                  }
                  break;
               case 6:
                  this.at();
                  return;
               case 7:
                  this.ar();
                  return;
               case 8:
                  LoginScr.backToRegister();
                  return;
               case 9:
                  if (main.GameCanvas.loginScr.isLogin2) {
                     SoundMn.stopAll();
                     SoundMn.h();
                     return;
                  }
                  break;
               default:
                  return;
               }
            } else {
               switch(this.aj) {
               case 0:
                  this.af();
                  return;
               case 1:
                  Service.gI().j((int)54);
                  return;
               case 2:
                  this.ah();
                  return;
               case 3:
                  InfoDlg.a();
                  Service.gI().t();
                  this.timeShow = 20;
                  return;
               case 4:
                  Service.gI().b((byte)0, (byte)-1);
                  InfoDlg.a();
                  return;
               case 5:
                  if (Char.myCharz().statusMe == 14) {
                     main.GameCanvas.startOKDlg(mResources.ew);
                     return;
                  }

                  Service.gI().h();
                  return;
               case 6:
                  main.GameCanvas.endDlg();
                  if (Char.myCharz().Y() < 5) {
                     main.GameCanvas.startOKDlg(mResources.ez);
                     return;
                  }

                  if (this.o == null) {
                     this.o = new ChatTextField();
                     this.o.a.b = main.GameCanvas.A - 35 - ChatTextField.gI().a.height;
                     this.o.a();
                     this.o.c = main.GameCanvas.panel;
                  }

                  this.o.h = mResources.eA;
                  this.o.a.name = mResources.bp;
                  this.o.g = "";
                  this.o.b = true;
                  this.o.a.setIputType(0);
                  if (main.GameCanvas.isTouch) {
                     this.o.a.a();
                     return;
                  }
                  break;
               case 7:
                  this.at();
                  return;
               case 8:
                  this.ar();
                  return;
               case 9:
                  LoginScr.backToRegister();
                  return;
               case 10:
                  if (main.GameCanvas.loginScr.isLogin2) {
                     SoundMn.stopAll();
                     SoundMn.h();
                  }
               }
            }

         }
      }
   }

   private void ah() {
      this.N = as.size();
      this.aC = 24;
      this.aj = main.GameCanvas.isTouch ? -1 : 0;
      this.aH = this.N * this.aC - this.ag;
      if (this.aH < 0) {
         this.aH = 0;
      }

      if (this.g < 0) {
         this.g = this.f = 0;
      }

      if (this.g > this.aH) {
         this.g = this.f = this.aH;
      }

      this.z = 23;
      this.c(0);
   }

   private void ai() {
      this.o.h = mResources.dw;
      this.o.a.name = mResources.dw;
      this.o.g = "";
      this.o.b = true;
      this.o.a.isFocus = true;
      this.o.a.setIputType(0);
      if (main.GameCanvas.isTouch) {
         this.o.a.a();
      }

   }

   public final void C() {
      if (this.tabIcon == null) {
         this.tabIcon = new nr_do();
      }

      this.tabIcon.m = this.o.a.getText();
      this.tabIcon.a(false);
      this.o.b = false;
   }

   private void b(InfoItem var1) {
      String var2 = "|0|1|" + var1.c.cName;
      var2 = var2 + "\n";
      if (var1.e) {
         var2 = var2 + "|4|1|" + mResources.cM;
      } else {
         var2 = var2 + "|3|1|" + mResources.cN;
      }

      var2 = var2 + "\n--";
      var2 = var2 + "\n|5|" + mResources.cZ + ": " + var1.a;
      this.ah = new ChatPopup();
      this.a(this.ah, var2);
      this.cG = var1.c;
      this.bB = null;
   }

   private void aj() {
      if (this.aj >= 0) {
         if (this.W.size() != 0) {
            MyVector var1 = new MyVector("");
            this.cF = this.aj;
            var1.addElement(new CommandLine(mResources.bq, this, 10000, (InfoItem)this.W.elementAt(this.cF)));
            var1.addElement(new CommandLine(mResources.bj, this, 10001, (InfoItem)this.W.elementAt(this.cF)));
            main.GameCanvas.menu.a(var1, this.b, (this.aj + 1) * this.aC - this.g + this.ae);
            this.b((InfoItem)this.W.elementAt(this.aj));
         }
      }
   }

   private void ak() {
      if (this.aj >= 0) {
         if (this.S.size() != 0) {
            MyVector var1 = new MyVector("");
            this.cF = this.aj;
            var1.addElement(new CommandLine(mResources.bp, this, 8001, (InfoItem)this.S.elementAt(this.cF)));
            var1.addElement(new CommandLine(mResources.bj, this, 8002, (InfoItem)this.S.elementAt(this.cF)));
            var1.addElement(new CommandLine(mResources.gk, this, 8004, (InfoItem)this.S.elementAt(this.cF)));
            main.GameCanvas.menu.a(var1, this.b, (this.aj + 1) * this.aC - this.g + this.ae);
            this.b((InfoItem)this.S.elementAt(this.aj));
         }
      }
   }

   private void al() {
      if (this.aj >= 0) {
         MyVector var1 = new MyVector("");
         this.cF = this.aj;
         var1.addElement(new CommandLine(mResources.bQ, this, 10030, (Object)null));
         var1.addElement(new CommandLine(mResources.bz, this, 10031, (Object)null));
         main.GameCanvas.menu.a(var1, this.b, (this.aj + 1) * this.aC - this.g + this.ae);
      }
   }

   private void am() {
      if (this.aj == 0) {
         this.at = !this.at;
         Rms.saveRMSInt("viewchat", this.at ? 1 : 0);
         if (main.GameCanvas.isTouch) {
            this.aj = -1;
         }

      } else if (this.aj >= 0) {
         if (this.bF.size() != 0) {
            MyVector var1 = new MyVector("");
            this.cF = this.aj - 1;
            var1.addElement(new CommandLine(mResources.bp, this, 8001, (InfoItem)this.bF.elementAt(this.cF)));
            var1.addElement(new CommandLine(mResources.cO, this, 8003, (InfoItem)this.bF.elementAt(this.cF)));
            main.GameCanvas.menu.a(var1, this.b, (this.aj + 1) * this.aC - this.g + this.ae);
            InfoItem var2 = (InfoItem)this.bF.elementAt(this.aj - 1);
            String var3 = "|0|1|" + var2.c.cName;
            var3 = var3 + "\n";
            var3 = var3 + "\n--";
            var3 = var3 + "\n|5|" + ResLog.a(var2.a, "|", 0)[2];
            this.ah = new ChatPopup();
            this.a(this.ah, var3);
            this.cG = var2.c;
            this.bB = null;
         }
      }
   }

   private void d(int var1) {
      String var2 = "";
      int var3 = 0;
      if (this.aj == 0) {
         var3 = Char.myCharz().cr + 1000;
      }

      if (this.aj == 1) {
         var3 = Char.myCharz().cs + 1000;
      }

      if (this.aj == 2) {
         var3 = Char.myCharz().cq * Char.myCharz().cB;
      }

      if (this.aj == 3) {
         var3 = 500000 + Char.myCharz().ct * 100000;
      }

      var2 = var2 + "|5|2|" + mResources.bl + " " + var3 + " " + mResources.ff;
      if (var1 == 0) {
         var2 = var2 + "\n|5|2|" + mResources.fj;
      }

      if (var1 == 1) {
         var2 = var2 + "\n|5|2|" + mResources.fk;
      }

      if (var1 == 2) {
         var2 = var2 + "\n|5|2|" + mResources.fl;
      }

      if (var1 == 3) {
         var2 = var2 + "\n|5|2|" + mResources.fl;
      }

      this.bB = null;
      this.bK = null;
      this.cG = null;
      this.bJ = -1;
      this.ah = new ChatPopup();
      this.a(this.ah, var2);
   }

   private void an() {
      if (this.aj != -1) {
         ResLog.c("FIRE ZONE");
         this.cH = true;
         main.GameCanvas.panel.A();
      }
   }

   public final void a(int var1, int var2) {
      this.ah.d[this.ah.d.length - 1] = mResources.cY + " " + var1 + "/" + var2;
   }

   private void ao() {
      if (this.aj >= 0) {
         this.bB = null;
         MyVector var1 = new MyVector("");
         byte var2;
         if (this.A == 0 && !this.equals(main.GameCanvas.G)) {
            if (this.aj == 0) {
               this.a(Char.myCharz().arrItemBox.length, false);
            } else {
               var2 = (byte)c(this.aj, this.bN);
               Item var3;
               if ((var3 = Char.myCharz().arrItemBox[var2]) != null) {
                  if (this.ai) {
                     var1.addElement(new CommandLine(mResources.dX, this, 1000, var3));
                     var1.addElement(new CommandLine(mResources.bl, this, 2010, var3));
                  } else if (var3.b()) {
                     var1.addElement(new CommandLine(mResources.dX, this, 1000, var3));
                  } else {
                     var1.addElement(new CommandLine(mResources.dX, this, 1000, var3));
                  }

                  this.bB = var3;
               }
            }
         }

         if (this.A == 1 || this.equals(main.GameCanvas.G)) {
            if (this.aj == 0) {
               this.a(Char.myCharz().arrItemBody.length + Char.myCharz().arrItemBag.length, true);
            } else {
               Item[] var4 = Char.myCharz().arrItemBody;
               Item var5;
               if (!a(this.aj, this.bN, var4)) {
                  var2 = (byte)b(this.aj, this.bN, var4);
                  if ((var5 = Char.myCharz().arrItemBag[var2]) != null) {
                     var1.addElement(new CommandLine(mResources.cB, this, 1001, var5));
                     if (var5.b()) {
                        var1.addElement(new CommandLine(mResources.bl, this, 2000, var5));
                     } else {
                        var1.addElement(new CommandLine(mResources.bl, this, 2001, var5));
                     }

                     this.bB = var5;
                  }
               } else if ((var5 = Char.myCharz().arrItemBody[c(this.aj, this.bN)]) != null) {
                  var1.addElement(new CommandLine(mResources.cC, this, 1002, var5));
                  this.bB = var5;
               }
            }
         }

         if (this.bB != null) {
            Char.myCharz().a(this.bB.D, this.bB.E, this.bB.F, this.bB.G);
            if (this.ai) {
               var1.addElement(new CommandLine(mResources.dY, this, 2011, this.bB));
            }

            main.GameCanvas.menu.a(var1, this.b, (this.aj + 1) * this.aC - this.g + this.ae);
            this.b(this.bB);
         } else {
            this.ah = null;
         }

         this.aH = this.N * this.aC - this.ag;
      }
   }

   public final void a(byte var1, String var2, byte var3, byte var4) {
      main.GameCanvas.endDlg();
      nr_cm var5;
      (var5 = new nr_cm()).c = var1;
      var5.a = var4;
      var5.b = var3;
      main.GameCanvas.startYesNoDlg(var2, new CommandLine(mResources.bm, this, 2004, var5), new CommandLine(mResources.bn, this, 4005, (Object)null));
   }

   public final void a(byte var1, String var2, short var3) {
      nr_cm var4;
      (var4 = new nr_cm()).c = var1;
      var4.a = var3;
      main.GameCanvas.startYesNoDlg(var2, new CommandLine(mResources.bm, this, 3003, var4), new CommandLine(mResources.bn, this, 4005, (Object)null));
   }

   public final void perform(int var1, Object var2) {
      ResLog.c("perform trong Panel:" + var1);
      if (var1 == 9999) {
         TopInfo var3 = (TopInfo)var2;
         Service.gI().v(var3.g);
      }

      if (var1 == 170391) {
         Rms.a();
         if (mGraphics.zoomLevel > 1) {
            Rms.saveRMSInt("levelScreenKN", 1);
         } else {
            Rms.saveRMSInt("levelScreenKN", 0);
         }

         GameMidlet.instance.a();
      }

      Item var6;
      if (var1 == 6001) {
         (var6 = (Item)var2).f = false;
         main.GameCanvas.panel.k.removeElement(var6);
         if (main.GameCanvas.panel.A == 0) {
            main.GameCanvas.panel.o();
         }
      }

      int var4;
      if (var1 == 6000) {
         var6 = (Item)var2;

         for(var4 = 0; var4 < main.GameCanvas.panel.k.size(); ++var4) {
            if (((Item)main.GameCanvas.panel.k.elementAt(var4)).template.a == var6.template.a) {
               main.GameCanvas.startOKDlg(mResources.ei);
               return;
            }
         }

         var6.f = true;
         main.GameCanvas.panel.k.addElement(var6);
         if (main.GameCanvas.panel.A == 0) {
            main.GameCanvas.panel.o();
         }
      }

      if (var1 == 7000) {
         if (this.aR) {
            main.GameCanvas.startOKDlg(mResources.ej);
            return;
         }

         var6 = (Item)var2;

         for(var4 = 0; var4 < main.GameCanvas.panel.T.size(); ++var4) {
            if (((Item)main.GameCanvas.panel.T.elementAt(var4)).g == var6.g) {
               main.GameCanvas.startOKDlg(mResources.ei);
               return;
            }
         }

         if (var6.quantity > 1) {
            if (this.o == null) {
               this.o = new ChatTextField();
               this.o.a.b = main.GameCanvas.A - 35 - ChatTextField.gI().a.height;
               this.o.a();
               this.o.c = main.GameCanvas.panel;
            }

            this.o.h = mResources.ef;
            this.o.a.name = mResources.eg;
            this.o.g = "";
            this.o.b = true;
            this.o.a.setIputType(1);
            if (main.GameCanvas.isTouch) {
               this.o.a.a();
            }

            return;
         }

         var6.f = true;
         Item var8;
         (var8 = new Item()).template = var6.template;
         var8.itemOption = var6.itemOption;
         var8.g = var6.g;
         main.GameCanvas.panel.T.addElement(var8);
         Service.gI().a((byte)2, (int)-1, (byte)((byte)var8.g), (int)var8.quantity);
      }

      if (var1 == 7001) {
         (var6 = (Item)var2).f = false;
         main.GameCanvas.panel.T.removeElement(var6);
         if (main.GameCanvas.panel.A == 1) {
            main.GameCanvas.panel.a(true);
         }

         Service.gI().a((byte)4, (int)-1, (byte)((byte)var6.g), (int)-1);
      }

      if (var1 == 7002) {
         this.aS = true;
         main.GameCanvas.endDlg();
         Service.gI().a((byte)7, (int)-1, (byte)-1, (int)-1);
         this.A();
      }

      InfoItem var7;
      if (var1 == 8003) {
         var7 = (InfoItem)var2;
         Service.gI().a((byte)1, (int)var7.c.charID);
      }

      if (var1 == 8002) {
         var7 = (InfoItem)var2;
         Service.gI().a((byte)2, (int)var7.c.charID);
      }

      if (var1 == 8004) {
         var7 = (InfoItem)var2;
         Service.gI().a(var7.c.charID);
      }

      if (var1 == 8001) {
         ResLog.c("chat player");
         var7 = (InfoItem)var2;
         if (this.o == null) {
            this.o = new ChatTextField();
            this.o.a.b = main.GameCanvas.A - 35 - ChatTextField.gI().a.height;
            this.o.a();
            this.o.c = main.GameCanvas.panel;
         }

         this.o.h = mResources.cP;
         this.o.a.name = mResources.cQ + " " + var7.c.cName;
         this.o.g = "";
         this.o.b = true;
         this.o.a.isFocus = true;
         this.o.a.setIputType(0);
         if (main.GameCanvas.isTouch) {
            this.o.a.a();
         }
      }

      if (var1 == 1000) {
         Service.gI().a((byte)0, (byte)((byte)c(this.aj, this.bN)));
      }

      byte var10;
      if (var1 == 1001) {
         var10 = (byte)b(this.aj, this.bN, Char.myCharz().arrItemBody);
         Service.gI().a(bi, var10);
      }

      if (var1 == 1003) {
         this.A();
      }

      if (var1 == 1002) {
         Service.gI().a(bj, (byte)c(this.aj, this.bN));
      }

      if (var1 == 2011) {
         Service.gI().a((byte)1, (byte)2, (byte)((byte)c(this.aj, this.bN)), (short)-1);
      }

      if (var1 == 2010) {
         Service.gI().a((byte)0, (byte)2, (byte)((byte)c(this.aj, this.bN)), (short)-1);
         if ((var6 = (Item)var2) != null && (var6.template.a == 193 || var6.template.a == 194)) {
            main.GameCanvas.panel.A();
         }
      }

      byte var9;
      if (var1 == 2000) {
         Item[] var12 = Char.myCharz().arrItemBody;
         var9 = (byte)b(this.aj, this.bN, var12);
         Service.gI().a(bk, var9);
      }

      byte var5;
      if (var1 == 2001) {
         ResLog.c("use item");
         var6 = (Item)var2;
         boolean var11;
         if (!(var11 = a(this.aj, this.bN, Char.myCharz().arrItemBody))) {
            var5 = (byte)b(this.aj, this.bN, Char.myCharz().arrItemBody);
         } else {
            var5 = (byte)c(this.aj, this.bN);
         }

         Service.gI().a((byte)0, (byte)((byte)(var11 ? 0 : 1)), (byte)var5, (short)-1);
         if (var6.template.a == 193 || var6.template.a == 194) {
            main.GameCanvas.panel.A();
         }
      }

      if (var1 == 2002) {
         Service.gI().a(bl, (byte)c(this.aj, this.bN));
      }

      boolean var13;
      if (var1 == 2003) {
         ResLog.c("remove item");
         if (!(var13 = a(this.aj, this.bN, Char.myCharz().arrItemBody))) {
            var9 = (byte)b(this.aj, this.bN, Char.myCharz().arrItemBody);
         } else {
            var9 = (byte)c(this.aj, this.bN);
         }

         Service.gI().a((byte)1, (byte)((byte)(var13 ? 0 : 1)), (byte)var9, (short)-1);
      }

      nr_cm var14;
      if (var1 == 2004) {
         main.GameCanvas.endDlg();
         var9 = (byte)(var14 = (nr_cm)var2).b;
         var5 = (byte)var14.a;
         Service.gI().a((byte)(var14.c == 0 ? 3 : 2), (byte)var9, (byte)var5, (short)-1);
      }

      if (var1 == 2005) {
         var10 = (byte)b(this.aj, this.bN, Char.myCharz().arrItemBody);
         Service.gI().a(bm, var10);
      }

      if (var1 == 2006) {
         Char.myPetz();
         var9 = (byte)this.aj;
         Service.gI().a(bn, var9);
      }

      if (var1 == 30001) {
         ResLog.c("nhan do");
         Service.gI().a((byte)0, (int)this.aj, (int)0);
      }

      if (var1 == 30002) {
         ResLog.c("xoa do");
         Service.gI().a((byte)1, (int)this.aj, (int)0);
      }

      if (var1 == 30003) {
         ResLog.c("nhan tat");
         Service.gI().a((byte)2, (int)this.aj, (int)0);
      }

      if (var1 == 3000) {
         ResLog.c("mua do");
         var6 = (Item)var2;
         Service.gI().a((byte)0, (int)var6.template.a, (int)0);
      }

      if (var1 == 3001) {
         var6 = (Item)var2;
         main.GameCanvas.msgdlg.b();
         Service.gI().a((byte)1, (int)var6.template.a, (int)0);
      }

      if (var1 == 3002) {
         main.GameCanvas.endDlg();
         if (!(var13 = a(this.aj, this.bN, Char.myCharz().arrItemBody))) {
            var9 = (byte)b(this.aj, this.bN, Char.myCharz().arrItemBody);
         } else {
            var9 = (byte)c(this.aj, this.bN);
         }

         Service.gI().a((byte)0, (byte)((byte)(var13 ? 0 : 1)), (short)((short)var9));
      }

      if (var1 == 3003) {
         main.GameCanvas.endDlg();
         var14 = (nr_cm)var2;
         Service.gI().a((byte)1, (byte)((byte)var14.c), (short)((short)var14.a));
      }

      if (var1 == 3004) {
         var6 = (Item)var2;
         Service.gI().a((byte)3, (int)var6.template.a, (int)0);
      }

      if (var1 == 3005) {
         ResLog.c("mua do");
         var6 = (Item)var2;
         Service.gI().a((byte)3, (int)var6.template.a, (int)0);
      }

      Clan var15;
      if (var1 == 4000 && (var15 = (Clan)var2) != null) {
         main.GameCanvas.endDlg();
         Service.gI().a(2, (String)null, var15.a);
      }

      if (var1 == 4001 && (var15 = (Clan)var2) != null) {
         InfoDlg.a();
         this.an = mResources.aA;
         Service.gI().e(var15.a);
      }

      if (var1 == 4005) {
         main.GameCanvas.endDlg();
      }

      if (var1 == 4007) {
         main.GameCanvas.endDlg();
      }

      if (var1 == 4006) {
         ClanMessage var16 = (ClanMessage)var2;
         Service.gI().d(var16.a);
      }

      Member var17;
      if (var1 == 5001) {
         var17 = (Member)var2;
         Service.gI().b((int)var17.a, (byte)0);
      }

      if (var1 == 5002) {
         var17 = (Member)var2;
         Service.gI().b((int)var17.a, (byte)1);
      }

      if (var1 == 5003) {
         var17 = (Member)var2;
         Service.gI().b((int)var17.a, (byte)2);
      }

      if (var1 == 5004) {
         var17 = (Member)var2;
         Service.gI().b(var17.a, (byte)-1);
      }

      if (var1 == 9000) {
         Service.gI().a((int)this.aj, (int)1);
         main.GameCanvas.endDlg();
         InfoDlg.a();
      }

      if (var1 == 9006) {
         Service.gI().a((int)this.aj, (int)10);
         main.GameCanvas.endDlg();
         InfoDlg.a();
      }

      if (var1 == 9007) {
         Service.gI().a((int)this.aj, (int)100);
         main.GameCanvas.endDlg();
         InfoDlg.a();
      }

      Skill var18;
      if (var1 == 9002) {
         if ((var18 = (Skill)var2).template.c()) {
            main.GameCanvas.startOKDlg(mResources.c);
         } else {
            main.GameCanvas.startOKDlg(mResources.eR + var18.d + mResources.eS + var18.moreInfo + mResources.eT);
         }
      }

      if (var1 == 9003) {
         if (main.GameCanvas.isTouch) {
            GameScr.gI();
            GameScr.a((SkillTemplate)var2);
         } else {
            GameScr.gI();
            GameScr.b((SkillTemplate)var2);
         }
      }

      if (var1 == 9004) {
         if ((var18 = (Skill)var2).template.c()) {
            main.GameCanvas.startOKDlg(mResources.b);
         } else {
            main.GameCanvas.startOKDlg(mResources.eR + var18.d + mResources.eS + var18.moreInfo + mResources.eT);
         }
      }

      if (var1 == 10000) {
         var7 = (InfoItem)var2;
         Service.gI().b((byte)1, (int)var7.c.charID);
         main.GameCanvas.panel.z();
      }

      if (var1 == 10001) {
         var7 = (InfoItem)var2;
         Service.gI().b((byte)2, (int)var7.c.charID);
         InfoDlg.a();
      }

      if (var1 == 10012) {
         if (this.o == null) {
            this.o = new ChatTextField();
            this.o.a.b = main.GameCanvas.A - 35 - ChatTextField.gI().a.height;
            this.o.a();
            this.o.c = main.GameCanvas.G == null ? main.GameCanvas.panel : main.GameCanvas.G;
         }

         this.o.a.setIputType(1);
         this.o.a.setText("");
         if (this.bB.quantity == 1) {
            this.o.h = mResources.fF;
            this.o.a.name = mResources.ec;
         } else {
            this.o.h = mResources.eg + " ";
            this.o.a.name = mResources.eg;
         }

         this.o.a.b(10);
         this.o.g = "";
         this.o.b = true;
         this.o.a.setIputType(1);
         if (main.GameCanvas.isTouch) {
            this.o.a.a();
         }
      }

      if (var1 == 10013) {
         if (this.o == null) {
            this.o = new ChatTextField();
            this.o.a.b = main.GameCanvas.A - 35 - ChatTextField.gI().a.height;
            this.o.a();
            this.o.c = main.GameCanvas.G == null ? main.GameCanvas.panel : main.GameCanvas.G;
         }

         this.o.a.setIputType(1);
         this.o.a.setText("");
         if (this.bB.quantity == 1) {
            this.o.h = mResources.fG;
            this.o.a.name = mResources.ec;
         } else {
            this.o.h = mResources.eg + "  ";
            this.o.a.name = mResources.eg;
         }

         this.o.g = "";
         this.o.b = true;
         this.o.a.setIputType(1);
         if (main.GameCanvas.isTouch) {
            this.o.a.a();
         }
      }

      if (var1 == 10014) {
         var6 = (Item)var2;
         Service.gI().a((byte)1, var6.d, (byte)-1, -1, -1);
         InfoDlg.a();
      }

      if (var1 == 10015) {
         var6 = (Item)var2;
         Service.gI().a((byte)2, var6.d, (byte)-1, -1, -1);
         InfoDlg.a();
      }

      if (var1 == 10016) {
         var6 = (Item)var2;
         Service.gI().a((byte)3, var6.d, (byte)0, var6.n, -1);
         InfoDlg.a();
      }

      if (var1 == 10017) {
         var6 = (Item)var2;
         Service.gI().a((byte)3, var6.d, (byte)1, var6.p, -1);
         InfoDlg.a();
      }

      if (var1 == 10018) {
         var6 = (Item)var2;
         Service.gI().a((byte)5, var6.d, (byte)-1, -1, -1);
         InfoDlg.a();
      }

      if (var1 == 10019) {
         Session_ME2.Session_ME().close();
         Rms.saveRMSString("acc", "");
         Rms.saveRMSString("pass", "");
         main.GameCanvas.loginScr.tfPass.setText("");
         main.GameCanvas.loginScr.tfUser.setText("");
         main.GameCanvas.loginScr.isLogin2 = false;
         main.GameCanvas.loginScr.switchToMe();
         main.GameCanvas.endDlg();
         this.A();
      }

      if (var1 == 10020) {
         main.GameCanvas.endDlg();
      }

      if (var1 == 10030) {
         Service.gI().b((byte)1, (byte)((byte)this.aj));
         main.GameCanvas.panel.z();
      }

      if (var1 == 10031) {
         Session_ME2.Session_ME().close();
      }

      if (var1 == 11000) {
         Service.gI().a((byte)0, this.bB.d, (byte)1, this.bB.t, 1);
         main.GameCanvas.endDlg();
      }

      if (var1 == 11001) {
         Service.gI().a((byte)0, this.bB.d, (byte)1, this.bB.t, this.bB.i);
         main.GameCanvas.endDlg();
      }

      if (var1 == 11002) {
         this.o.b = false;
         main.GameCanvas.endDlg();
      }

   }

   public final void onChatFromMe(String var1, String var2) {
      if (this.o.a.getText() != null && !this.o.a.getText().equals("") && !var1.equals("") && var1 != null) {
         if (this.o.h.equals(mResources.ds)) {
            InfoDlg.a();
            this.o.b = false;
            Service.gI().a(var1);
         } else if (this.o.h.equals(mResources.du)) {
            InfoDlg.a();
            this.o.b = false;
            Service.gI().a(0, var1, -1);
         } else if (this.o.h.equals(mResources.dv)) {
            if (this.o.a.getText() == "") {
               GameScr.info1.a(mResources.dF, 0);
            } else {
               if (this.tabIcon == null) {
                  this.tabIcon = new nr_do();
               }

               this.tabIcon.m = this.o.a.getText();
               this.tabIcon.a(false);
               this.o.b = false;
            }
         } else if (this.o.h.equals(mResources.dw)) {
            if (this.o.a.getText() == "") {
               GameScr.info1.a(mResources.dG, 0);
            } else {
               Service.gI().a((byte)4, (byte)((byte)Char.myCharz().clan.b), (String)this.o.a.getText());
               this.o.b = false;
            }
         } else {
            int var7;
            if (this.o.h.equals(mResources.fV)) {
               try {
                  var7 = Integer.parseInt(this.o.a.getText());
                  this.o.b = false;
                  this.o.a.setIputType(0);
                  this.A();
                  if (this.o.a.getText().length() == 6 && !this.o.a.getText().equals("")) {
                     Service.gI().w(var7);
                     this.o.b = false;
                     this.o.a.setIputType(0);
                     this.A();
                  } else {
                     main.GameCanvas.startOKDlg(mResources.fW);
                  }
               } catch (Exception var3) {
                  main.GameCanvas.startOKDlg(mResources.R);
               }
            } else if (this.o.h.equals(mResources.eA)) {
               if (!this.o.a.getText().equals("")) {
                  Service.gI().e(this.o.a.getText());
                  this.o.b = false;
                  this.A();
               }
            } else if (this.o.h.equals(mResources.cP)) {
               this.o.b = false;
               InfoItem var8 = null;
               if (this.z == 8) {
                  var8 = (InfoItem)this.bF.elementAt(this.cF);
               } else if (this.z == 11) {
                  var8 = (InfoItem)this.S.elementAt(this.cF);
               }

               if (var8.c.charID != Char.myCharz().charID) {
                  Service.gI().a(var1, var8.c.charID);
               }
            } else if (this.o.h.equals(mResources.ef)) {
               try {
                  var7 = Integer.parseInt(this.o.a.getText());
               } catch (Exception var4) {
                  main.GameCanvas.startOKDlg(mResources.eh);
                  this.o.b = false;
                  this.o.a.setIputType(0);
                  return;
               }

               if (var7 > 0 && var7 <= this.bB.quantity) {
                  this.bB.f = true;
                  Item var6;
                  (var6 = new Item()).template = this.bB.template;
                  var6.quantity = var7;
                  var6.g = this.bB.g;
                  var6.itemOption = this.bB.itemOption;
                  main.GameCanvas.panel.T.addElement(var6);
                  Service.gI().a((byte)2, (int)-1, (byte)((byte)var6.g), (int)var6.quantity);
                  this.o.b = false;
                  this.o.a.setIputType(0);
               } else {
                  main.GameCanvas.startOKDlg(mResources.eh);
                  this.o.b = false;
                  this.o.a.setIputType(0);
               }
            } else if (this.o.h == mResources.eb) {
               try {
                  var7 = Integer.parseInt(this.o.a.getText());
               } catch (Exception var5) {
                  main.GameCanvas.startOKDlg(mResources.ed);
                  this.o.b = false;
                  this.o.a.setIputType(0);
                  return;
               }

               if ((long)var7 > Char.myCharz().gold) {
                  main.GameCanvas.startOKDlg(mResources.ee);
                  this.o.b = false;
                  this.o.a.setIputType(0);
               } else {
                  this.aQ = var7;
                  Service.gI().a((byte)2, (int)-1, (byte)-1, (int)var7);
                  this.o.b = false;
                  this.o.a.setIputType(0);
               }
            } else if (this.o.h.equals(mResources.fF)) {
               Service.gI().a((byte)0, this.bB.d, (byte)0, Integer.parseInt(this.o.a.getText()), 1);
               this.o.b = false;
            } else if (this.o.h.equals(mResources.fF + " ")) {
               Service.gI().a((byte)0, this.bB.d, (byte)0, Integer.parseInt(this.o.a.getText()), this.bB.i);
               this.o.b = false;
            } else if (this.o.h.equals(mResources.fG)) {
               this.e(0);
               this.o.b = false;
            } else if (this.o.h.equals(mResources.fG + "  ")) {
               this.e(1);
               this.o.b = false;
            } else if (this.o.h.equals(mResources.eg + " ")) {
               this.bB.i = Integer.parseInt(this.o.a.getText());
               if (this.bB.i > this.bB.quantity) {
                  main.GameCanvas.startOKDlg(mResources.eh);
               } else {
                  this.cI = true;
                  this.o.b = false;
               }
            } else {
               if (this.o.h.equals(mResources.eg + "  ")) {
                  this.bB.i = Integer.parseInt(this.o.a.getText());
                  if (this.bB.i > this.bB.quantity) {
                     main.GameCanvas.startOKDlg(mResources.eh);
                     return;
                  }

                  this.cJ = true;
                  this.o.b = false;
               }

            }
         }
      } else {
         this.o.b = false;
      }
   }

   public final void onCancelChat() {
      this.o.a.setIputType(0);
   }

   public final void b(int var1) {
      this.cW = var1;
      this.cL = 90;
      Item var2;
      if (this.cW == 0) {
         this.cP = 5;
         this.cM = this.cN = 90;
         this.cV = 2;

         for(var1 = 0; var1 < this.k.size(); ++var1) {
            if ((var2 = (Item)this.k.elementAt(var1)) != null) {
               if (var2.template.type == 14) {
                  this.dd = var2.template.f;
               } else {
                  this.az = var2.template.f;
               }
            }
         }
      } else if (this.cW == 1) {
         this.cP = 2;
         this.cM = this.cN = 0;
         this.cV = 1;

         for(var1 = 0; var1 < this.k.size(); ++var1) {
            if ((var2 = (Item)this.k.elementAt(var1)) != null) {
               if (var1 == 0) {
                  this.az = var2.template.f;
               } else {
                  this.dd = var2.template.f;
               }
            }
         }
      } else if (this.cW == 2) {
         this.cP = 7;
         this.cM = this.cN = 25;
         this.cV = 1;

         for(var1 = 0; var1 < this.k.size(); ++var1) {
            if ((var2 = (Item)this.k.elementAt(var1)) != null) {
               this.az = var2.template.f;
            }
         }
      } else if (this.cW == 3) {
         this.aw = main.GameCanvas.B;
         this.ax = main.GameCanvas.hh;
         this.cP = 1;
         this.cM = this.cN = 1;
         this.cV = 4;

         for(var1 = 0; var1 < this.k.size(); ++var1) {
            if ((var2 = (Item)this.k.elementAt(var1)) != null) {
               this.az = var2.template.f;
            }
         }
      } else if (this.cW == 4) {
         this.cP = this.k.size();
         this.de = new short[this.cP];
         this.cM = this.cN = 25;
         this.cV = 1;

         for(var1 = 0; var1 < this.k.size(); ++var1) {
            if ((var2 = (Item)this.k.elementAt(var1)) != null) {
               this.de[var1] = var2.template.f;
            }
         }
      }

      this.cQ = 1;
      this.da = true;
      this.ay = false;
      this.db = false;
      this.cO = 360 / this.cP;
      this.cR = new int[this.cP];
      this.cS = new int[this.cP];
      this.cT = new int[this.cP];
      this.cU = new int[this.cP];
      this.aq();
      this.dc = true;
      this.cX = 10;
      this.cY = 30;
      this.cZ = 10;
      this.a(this.av, mResources.B);
   }

   private void ap() {
      --this.cX;
      if (this.cX < 0) {
         this.cX = 0;
      }

      --this.cY;
      if (this.cY < 0) {
         this.cY = 0;
      }

      if (this.cX == 0) {
         if (!this.db) {
            if (this.cV > 0) {
               if (this.au != -1) {
                  if (this.cW == 3) {
                     if (main.GameCanvas.v % 10 == 0) {
                        EffecMn.addEff(new Effect(21, this.aw - 10, this.ax + 25, 4, 1, 1));
                        --this.cV;
                     }
                  } else {
                     if (main.GameCanvas.v % 2 == 0) {
                        if (this.da) {
                           if (this.cQ < 40) {
                              this.cQ += 2;
                           }
                        } else if (this.cQ > 10) {
                           this.cQ -= 2;
                        }
                     }

                     if (this.cY == 0) {
                        if (this.da) {
                           if (this.cL > 0) {
                              this.cL -= 5;
                           } else if (main.GameCanvas.v % 10 == 0) {
                              this.da = false;
                              --this.cV;
                              this.cY = 5;
                              this.cZ = 10;
                           }
                        } else if (this.cL < 90) {
                           this.cL += 5;
                        } else if (main.GameCanvas.v % 10 == 0) {
                           this.da = true;
                           this.cY = 10;
                        }
                     }

                     this.cM = this.cN;
                     this.cM -= this.cQ;
                     if (this.cM >= 360) {
                        this.cM -= 360;
                     }

                     if (this.cM < 0) {
                        this.cM += 360;
                     }

                     this.cN = this.cM;
                     this.aq();
                  }
               }
            } else if (main.GameCanvas.v % 20 == 0) {
               this.db = true;
            }

            if (main.GameCanvas.v % 20 == 0) {
               if (this.cW != 3) {
                  ServerEffect2.a(132, this.aw, this.ax, 2);
               }

               ServerEffect2.a(114, this.aw, this.ax + 20, 2);
               return;
            }
         } else if (this.db) {
            if (this.au == 1) {
               if (this.cZ == 10) {
                  EffecMn.addEff(new Effect(22, this.aw - 3, this.ax + 25, 4, 1, 1));
               }

               --this.cZ;
               if (this.cZ < 0) {
                  this.cZ = 0;
               }

               if (this.cL < 300) {
                  this.cL = ResLog.g(this.cL + 10);
                  if (this.cL == 20) {
                     this.a(this.av, mResources.C);
                  }
               } else if (main.GameCanvas.v % 20 == 0) {
                  if (main.GameCanvas.z > 2 * aa) {
                     (main.GameCanvas.G = new Panel()).L[7] = new String[][]{{""}};
                     main.GameCanvas.G.f();
                     main.GameCanvas.G.show();
                  }

                  this.au = -1;
                  this.ay = true;
                  if (this.cW == 4) {
                     main.GameCanvas.panel.z();
                  }
               }

               this.aq();
               return;
            }

            if (this.au == 0) {
               if (this.cZ == 10) {
                  if (this.cW == 2) {
                     EffecMn.addEff(new Effect(20, this.aw - 3, this.ax + 15, 4, 2, 1));
                  } else {
                     EffecMn.addEff(new Effect(21, this.aw - 10, this.ax + 25, 4, 1, 1));
                  }

                  this.a(this.av, mResources.E);
                  this.dc = false;
               }

               if (!this.dc) {
                  --this.cZ;
                  if (this.cZ < -50) {
                     this.cZ = -50;
                     if (this.cW < 3 && main.GameCanvas.z > 2 * aa) {
                        (main.GameCanvas.G = new Panel()).L[7] = new String[][]{{""}};
                        main.GameCanvas.G.f();
                        main.GameCanvas.G.show();
                     }

                     this.au = -1;
                     this.ay = true;
                     if (this.cW == 4) {
                        main.GameCanvas.panel.z();
                     }
                  }
               }
            }
         }
      }

   }

   private void aq() {
      for(int var1 = 0; var1 < this.cS.length; ++var1) {
         if (this.cM >= 360) {
            this.cM -= 360;
         }

         if (this.cM < 0) {
            this.cM += 360;
         }

         this.cS[var1] = ResLog.g(this.cL * ResLog.a(this.cM) / 1024);
         this.cR[var1] = ResLog.g(this.cL * ResLog.b(this.cM) / 1024);
         if (this.cM < 90) {
            this.cT[var1] = this.aw + this.cR[var1];
            this.cU[var1] = this.ax - this.cS[var1];
         } else if (this.cM >= 90 && this.cM < 180) {
            this.cT[var1] = this.aw - this.cR[var1];
            this.cU[var1] = this.ax - this.cS[var1];
         } else if (this.cM >= 180 && this.cM < 270) {
            this.cT[var1] = this.aw - this.cR[var1];
            this.cU[var1] = this.ax + this.cS[var1];
         } else {
            this.cT[var1] = this.aw + this.cR[var1];
            this.cU[var1] = this.ax + this.cS[var1];
         }

         this.cM -= this.cO;
      }

   }

   private void a(int var1, String var2) {
      if (this.cW < 3) {
         for(int var3 = 0; var3 < GameScr.G.size(); ++var3) {
            Npc var4;
            if ((var4 = (Npc)GameScr.G.elementAt(var3)).template.npcTemplateId == var1) {
               var4.a(var2);
            }
         }
      }

   }

   private void ar() {
      this.z = 19;
      this.c(0);
      SoundMn.stopAll();
      SoundMn.g();
      this.N = G.length;
      this.aC = 24;
      this.aj = main.GameCanvas.isTouch ? -1 : 0;
      this.aH = this.N * this.aC - this.ag;
      if (this.aH < 0) {
         this.aH = 0;
      }

      this.g = this.f = this.aI[this.A];
      if (this.g < 0) {
         this.g = this.f = 0;
      }

      if (this.g > this.aH) {
         this.g = this.f = this.aH;
      }

      this.h = this.aJ = 0;
   }

   private void F(mGraphics var1) {
      var1.e(this.ad, this.ae, this.af, this.ag);
      var1.setColor(0, -this.g);

      for(int var2 = 0; var2 < G.length; ++var2) {
         int var3 = this.ad;
         int var4 = this.ae + var2 * this.aC;
         int var5 = this.af - 1;
         int var6 = this.aC - 1;
         if (var4 - this.g <= this.ae + this.ag && var4 - this.g >= this.ae - this.aC) {
            var1.setColor(var2 == this.aj ? 16383818 : 15196114);
            var1.fillRect(var3, var4, var5, var6);
            mFont.tahoma_7b_dark.drawStringBd(var1, G[var2], this.ad + 25, var4 + 6, 0);
         }
      }

      this.f(var1);
   }

   private void as() {
      if (this.aj >= 0) {
         switch(this.aj) {
         case 0:
            SoundMn.stopAll().b();
            return;
         case 1:
            SoundMn.stopAll().e();
            return;
         case 2:
            return;
         case 3:
            SoundMn.stopAll().d();
            return;
         case 4:
            SoundMn.stopAll().c();
         case 5:
         default:
         }
      }
   }

   private void at() {
      this.z = 20;
      this.c(0);
      if (mSystem.d == 5) {
         aZ = new String[]{mResources.fU, mResources.bM, mResources.bN, mResources.ad};
         if (GameScr.bj) {
            aZ = new String[]{mResources.fU, mResources.bM, mResources.bN, mResources.ad, mResources.p};
         }
      } else {
         aZ = new String[]{mResources.fU, mResources.bM, mResources.bN, mResources.ad, mResources.fQ};
         if (GameScr.bj) {
            aZ = new String[]{mResources.fU, mResources.bM, mResources.bN, mResources.ad, mResources.fQ, mResources.p};
         }

         if ((mSystem.d == 2 || mSystem.d == 7) && mResources.language != 2) {
            aZ = new String[]{mResources.fU, mResources.bM, mResources.bN, mResources.ad, mResources.fQ};
            if (GameScr.bj) {
               aZ = new String[]{mResources.fU, mResources.bM, mResources.bN, mResources.ad, mResources.fQ, mResources.p};
            }
         }
      }

      this.N = aZ.length;
      this.aC = 24;
      this.aj = main.GameCanvas.isTouch ? -1 : 0;
      this.aH = this.N * this.aC - this.ag;
      if (this.aH < 0) {
         this.aH = 0;
      }

      this.g = this.f = this.aI[this.A];
      if (this.g < 0) {
         this.g = this.f = 0;
      }

      if (this.g > this.aH) {
         this.g = this.f = this.aH;
      }

      this.h = this.aJ = 0;
   }

   private void G(mGraphics var1) {
      var1.e(this.ad, this.ae, this.af, this.ag);
      var1.setColor(0, -this.g);

      for(int var2 = 0; var2 < aZ.length; ++var2) {
         int var3 = this.ad;
         int var4 = this.ae + var2 * this.aC;
         int var5 = this.af - 1;
         int var6 = this.aC - 1;
         if (var4 - this.g <= this.ae + this.ag && var4 - this.g >= this.ae - this.aC) {
            var1.setColor(var2 == this.aj ? 16383818 : 15196114);
            var1.fillRect(var3, var4, var5, var6);
            mFont.tahoma_7b_dark.drawStringBd(var1, aZ[var2], this.ad + this.af / 2, var4 + 6, 2);
         }
      }

      this.f(var1);
   }

   private void au() {
      if (this.aj >= 0) {
         switch(this.aj) {
         case 0:
            main.GameCanvas.endDlg();
            if (this.o == null) {
               this.o = new ChatTextField();
               this.o.a.b = main.GameCanvas.A - 35 - ChatTextField.gI().a.height;
               this.o.a();
               this.o.c = main.GameCanvas.panel;
            }

            this.o.a.setText("");
            this.o.h = mResources.fV;
            this.o.a.name = mResources.fV;
            this.o.g = "";
            this.o.b = true;
            this.o.a.isFocus = true;
            this.o.a.setIputType(1);
            if (main.GameCanvas.isTouch) {
               this.o.a.a();
               return;
            }
            break;
         case 1:
            Service.gI().a((byte)0, (int)-1);
            InfoDlg.a();
            return;
         case 2:
            Service.gI().b((byte)0, (int)-1);
            InfoDlg.a();
            return;
         case 3:
            this.l();
            if (this.o == null) {
               this.o = new ChatTextField();
               this.o.a.b = main.GameCanvas.A - 35 - ChatTextField.gI().a.height;
               this.o.a();
               this.o.c = main.GameCanvas.panel;
               return;
            }
            break;
         case 4:
            if (mResources.language == 2) {
               String var1 = "http://dragonball.indonaga.com/coda/?username=" + main.GameCanvas.loginScr.tfUser.getText();
               this.z();

               try {
                  GameMidlet.instance.platformRequest(var1);
                  return;
               } catch (Exception var2) {
                  var2.toString();
                  return;
               }
            }

            this.z();
            if (Char.myCharz().aD.c <= 10) {
               main.GameCanvas.startOKDlg(mResources.fR);
               return;
            }

            MoneyCharge.gI().switchToMe();
            return;
         case 5:
            this.L();
         }

      }
   }

   public final void E() {
      this.z = 25;
      this.c(0);
      this.av();
      this.A = 0;
   }

   private void av() {
      this.aC = 24;
      this.N = Char.myCharz().aK[this.A].length;
      this.aH = this.N * this.aC - this.ag;
      if (this.aH < 0) {
         this.aH = 0;
      }

      this.g = this.f = this.aI[this.A];
      if (this.g < 0) {
         this.g = this.f = 0;
      }

      if (this.g > this.aH) {
         this.g = this.f = this.aH;
      }

      this.aj = main.GameCanvas.isTouch ? -1 : 0;
   }

   public final boolean isTypeShop() {
      return this.z == 1;
   }

   private void e(int var1) {
      try {
         this.bB.t = Integer.parseInt(this.o.a.getText());
      } catch (Exception var3) {
         main.GameCanvas.startOKDlg(mResources.ed);
         this.o.b = false;
         return;
      }

      CommandLine var4 = new CommandLine(mResources.bm, this, var1 == 0 ? 11000 : 11001, (Object)null);
      CommandLine var2 = new CommandLine(mResources.bn, this, 11002, (Object)null);
      main.GameCanvas.startYesNoDlg(mResources.g, var4, var2);
   }

   private static int f(int var0) {
      switch(var0) {
      case 1:
         return 2786816;
      case 2:
         return 7078041;
      case 3:
         return 12537346;
      case 4:
         return 1269146;
      case 5:
         return 13279744;
      case 6:
         return 11599872;
      default:
         return -1;
      }
   }

   private static byte g(int var0) {
      if (var0 < 0) {
         return 0;
      } else {
         switch(var0) {
         case 0:
         case 1:
         case 2:
         case 3:
         case 4:
         case 5:
         case 6:
         case 7:
         case 8:
            return 0;
         case 9:
            return 4;
         case 10:
            return 1;
         case 11:
            return 5;
         case 12:
            return 3;
         case 13:
            return 2;
         default:
            return 6;
         }
      }
   }

   private static mFont h(int var0) {
      mFont var1 = mFont.k;
      switch(var0) {
      case -1:
         var1 = mFont.k;
         break;
      case 0:
         var1 = mFont.tahoma_7b_dark;
         break;
      case 1:
         var1 = mFont.h;
         break;
      case 2:
         var1 = mFont.b;
         break;
      case 3:
         var1 = mFont.p;
         break;
      case 4:
         var1 = mFont.r;
         break;
      case 5:
         var1 = mFont.q;
      case 6:
      default:
         break;
      case 7:
         var1 = mFont.a;
         break;
      case 8:
         var1 = mFont.d;
      }

      return var1;
   }

   private void a(mGraphics var1, int var2, int var3, int var4, int var5) {
      if (var2 == 34) {
         if (this.di != null) {
            var1.drawImage(this.di, var3, var4 + var5 - this.di.getHeight(), 0);
         } else {
            this.di = mSystem.load("/mainImage/o_0.png");
         }

         if (this.dj != null) {
            var1.drawImage(this.dj, var3, var4 + var5 - this.dj.getHeight(), 0);
         } else {
            this.dj = mSystem.load("/mainImage/o_1.png");
         }
      } else if (var2 == 35) {
         if (this.di != null) {
            var1.drawImage(this.di, var3, var4 + var5 - this.di.getHeight(), 0);
         } else {
            this.di = mSystem.load("/mainImage/o_0.png");
         }

         if (this.dk != null) {
            var1.drawImage(this.dk, var3, var4 + var5 - this.dk.getHeight(), 0);
         } else {
            this.dk = mSystem.load("/mainImage/o_2.png");
         }
      } else {
         if (var2 == 36) {
            if (this.di != null) {
               var1.drawImage(this.di, var3, var4 + var5 - this.di.getHeight(), 0);
            } else {
               this.di = mSystem.load("/mainImage/o_0.png");
            }

            if (this.dl != null) {
               var1.drawImage(this.dl, var3, var4 + var5 - this.dl.getHeight(), 0);
               return;
            }

            this.dl = mSystem.load("/mainImage/o_3.png");
         }

      }
   }

   private static void a(mGraphics var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if (var1 == 102 && var2 > ChatPopup.r) {
         byte var19 = g(var2);
         var2 -= ChatPopup.r;
         int var10000 = var3;
         int var10001 = var4;
         mGraphics var22 = var0;
         byte var21 = var19;
         var4 = var2;
         var3 = var6;
         byte var20 = 34;
         var1 = var10001;
         int var18 = var10000;

         try {
            int var7 = ((var20 << 1) + (var3 << 1)) / var4;
            dg = df.length;
            if (var4 > 4) {
               dg = 2;
            }

            for(int var8 = 0; var8 < var4; ++var8) {
               for(int var9 = 0; var9 < dg; ++var9) {
                  int var10 = df[var9] > 1 ? (df[var9] >> 1) + 1 : 1;
                  var10001 = var7 * var8;
                  int var13 = main.GameCanvas.v - (var9 << 2);
                  int var12 = var10001;
                  int var11 = var18 + ((var12 = (var13 + var12) % ((var20 << 1) + (var3 << 1))) >= 0 && var12 < var20 ? var12 % var20 : (var20 <= var12 && var12 < var20 + var3 ? var20 - var10 : (var20 + var3 <= var12 && var12 < (var20 << 1) + var3 ? var20 - (var12 - var3) % var20 - var10 : 0)));
                  var10001 = var7 * var8;
                  var13 = main.GameCanvas.v - (var9 << 2);
                  var12 = var10001;
                  var10 = var1 + ((var12 = (var13 + var12) % ((var20 << 1) + (var3 << 1))) >= 0 && var12 < var20 ? 0 : (var20 <= var12 && var12 < var20 + var3 ? var12 % var20 : (var20 + var3 <= var12 && var12 < (var20 << 1) + var3 ? var3 - var10 : var3 - (var12 - (var20 << 1)) % var3 - var10)));
                  var22.setColor(dh[var21][var9]);
                  var22.fillRect(var11, var10, df[var9], df[var9]);
               }
            }

            return;
         } catch (Exception var17) {
         }
      }

   }

   public static mFont b(int var0, int var1) {
      switch(var0) {
      case 0:
         return mFont.c;
      case 1:
         return mFont.h;
      case 2:
      default:
         return mFont.c;
      case 3:
         return mFont.F;
      case 4:
         return mFont.b;
      case 5:
         return mFont.d;
      case 6:
         return mFont.a;
      case 7:
         return mFont.tahoma_7b_dark;
      }
   }

   private static boolean a(int var0, int var1, Item[] var2) {
      var0 = var0 - 1 + var1 * 20;
      return var1 == 0 ? var0 < var2.length : false;
   }

   private static int c(int var0, int var1) {
      return var0 - 1 + var1 * 20;
   }

   private static int b(int var0, int var1, Item[] var2) {
      return var0 - 1 + var1 * 20 - var2.length;
   }

   private boolean aw() {
      return this.z == 0 && this.A == 1 || this.z == 7 && this.A == 0;
   }

   private void ax() {
      if (this.aj >= 0) {
         if (main.GameCanvas.keyPressed[4]) {
            --this.bN;
            if (this.bN < 0) {
               this.bN = 0;
               if (main.GameCanvas.W) {
                  main.GameCanvas.W = false;
                  main.GameCanvas.panel.aj = 0;
                  return;
               }
            }
         } else if (main.GameCanvas.keyPressed[6]) {
            ++this.bN;
            if (this.bN > this.dm - 1) {
               this.bN = this.dm - 1;
               if (main.GameCanvas.G != null) {
                  main.GameCanvas.W = true;
                  main.GameCanvas.G.aj = 0;
               }
            }
         }
      }

   }

   private void ay() {
      this.O();
      if (this.aj == 0) {
         this.ax();
      }

   }

   private int i(int var1) {
      int var2 = 20;
      int var3 = var1 / 20 + (var1 % 20 > 0 ? 1 : 0);
      this.dm = (byte)var3;
      if (this.bN > var3 - 1) {
         this.bN = var3 - 1;
      }

      if (var1 % 20 > 0 && this.bN == var3 - 1) {
         var2 = var1 % 20;
      }

      ++var2;
      return var2;
   }

   private void a(int var1, boolean var2) {
      var1 = var1 / 20 + (var1 % 20 > 0 ? 1 : 0);
      int var3 = this.ad;
      this.bN = (main.GameCanvas.o - var3) / this.aE;
      if (this.bN > var1 - 1) {
         this.bN = var1 - 1;
      }

      if (main.GameCanvas.o < var3) {
         this.bN = 0;
      }

      this.b(var2);
   }
}
