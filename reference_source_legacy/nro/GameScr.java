package nro;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;
import javax.microedition.lcdui.Image;
import main.GameMidlet;

public final class GameScr extends mScreen implements IChatable {
   private boolean cg;
   private long ch;
   private long ci;
   public static boolean a = false;
   public static boolean b = false;
   public static GameScr c;
   public static int d;
   public static int e;
   public static int f;
   private static int cj;
   private static int ck;
   public static int g;
   private static int cl;
   private static int cm;
   private static int cn;
   public static int h;
   public static int i;
   public static int cmx;
   public static int cmy;
   private static int co;
   private static int cp;
   private static int cq;
   private static int cr;
   public static int l;
   public static int m;
   public static int n;
   private static int cs;
   public static int o;
   public static int p;
   public static int q;
   public static int r;
   public CommandLine s;
   public static int hpPotion;
   public static SkillPaint[] u;
   public static nr_ct[] v;
   public static DartInfo[] w;
   public static Rms[] x;
   public static EffectCharPaint[] y;
   public static int z;
   public static MyVector A = new MyVector("vClan");
   public static MyVector B;
   public static MyVector C;
   public static MyVector vCharInMap;
   public static MyVector vItemMap;
   private static MyVector ct;
   public static MyVector F;
   public static MyVector G;
   public static MyVector H;
   public static NClass[] nClass;
   private static int cu;
   public static int J;
   private static int cv;
   public nr_eh[] K;
   private static nr_ds cw;
   private static nr_ds cx;
   public static int L;
   public static boolean M;
   private static boolean cy;
   private static boolean cz;
   private static boolean cA;
   private static boolean cB;
   private static boolean cC;
   private static boolean cD;
   public static boolean N;
   public static boolean O;
   private static boolean cE;
   private static boolean cF;
   private static boolean cG;
   private static boolean cH;
   private static boolean cI;
   private static boolean cJ;
   private static boolean cK;
   private static boolean cL;
   private static boolean cM;
   private static boolean cN;
   private static boolean cO;
   private static boolean cP;
   private static boolean cQ;
   private static boolean cR;
   private static boolean cS;
   private static boolean cT;
   private static boolean cU;
   private static boolean cV;
   private static boolean cW;
   private static boolean cX;
   private static boolean cY;
   private static boolean cZ;
   private static boolean da;
   private static boolean db;
   private static boolean dc;
   private static boolean dd;
   private static boolean de;
   private static boolean df;
   private static boolean dg;
   private static boolean dh;
   public static Char currentCharViewInfo;
   public static long[] Q;
   private int di = 0;
   public int[] R;
   public int[] S;
   public int[] T;
   public int[] U;
   public int[] V;
   public int[] W;
   public String[] X;
   public String[] Y;
   public int Z = 0;
   public int aa = 0;
   private int dj = -1;
   private boolean dk;
   public static int[] ab;
   public static int[] ac;
   public static Image ad;
   public static Image ae;
   public static Image af;
   public static Image ag;
   public static Image ah;
   public static Image ai;
   public static Image aj;
   public static byte vcData;
   public static byte vcMap;
   public static byte am;
   public static byte an;
   public static byte ao;
   public static byte ap;
   public static byte aq;
   public static byte ar;
   private static Image dl;
   private static Image dm;
   public static Image as;
   private static Image dn;
   private static Image _do;
   public static Image at;
   public static Image au;
   private static Image dp;
   private static Image dq;
   private static Image dr;
   private static Image ds;
   private static Image dt;
   private static Image du;
   public static Image imgLbtnFocus;
   public static Image imgLbtn;
   public static Image ax;
   public static Image ay;
   public static Image az;
   public static Image aA;
   public static byte aB;
   public static InfoMe info1;
   public static InfoMe aD;
   private static Image dv;
   private static Image dw;
   private static Image dx;
   public static Image aE;
   private static Image dy;
   private static Image dz;
   public static Image aF;
   public static Image aG;
   public static Image aH;
   public static Image aI;
   public static Image aJ;
   public Mob aK;
   public nr_k aL;
   private int dA;
   public static int aM;
   private static main.nr_b dB;
   public static int aN;
   public static Skill[] aO;
   public static Skill[] aP;
   public CommandLine aQ;
   private static int dC;
   public static long deltaTime;
   public boolean aS;
   private boolean dD;
   private int dE;
   private int dF;
   private int dG;
   private int dH;
   private int dI;
   private boolean dJ;
   public long aT;
   boolean aU;
   private boolean dK;
   private int dL;
   private int dM;
   private int dN;
   private int dO;
   public static boolean aV;
   private long dP;
   private long dQ;
   public int aW;
   int aX;
   public boolean aY;
   public boolean aZ;
   private static Image dR;
   public boolean ba = false;
   public boolean bb = false;
   private boolean dS = false;
   private int dT;
   private int dU;
   private int dV;
   private int dW;
   public boolean bc;
   private boolean dX;
   public int bd;
   public int be;
   public int bf;
   public int bg;
   public int bh;
   private static int dY;
   public static boolean bi;
   public static boolean bj;
   public static boolean bk;
   private int dZ;
   private int ea = 0;
   private int eb = -1;
   private Skill ec;
   public String bl;
   private boolean ed;
   private int ee;
   private int ef = -1;
   private static long eg;
   private static long eh;
   private static long ei;
   private static long ej;
   private static int ek;
   private int el = 0;
   public static int bm;
   public static Image bn;
   public static Image bo;
   public int[] bp;
   public static Image bq;
   public String br;
   private static int em;
   public static boolean bs;
   public static int bt;
   private static int[] en;
   private static int[] eo;
   public static MyVector bu;
   private int ep = 0;
   public static Image bv;
   private static int eq;
   private static int er;
   private static int es;
   private static int et;
   private static int eu;
   public static int bw;
   public static int bx;
   private static int ev;
   private static int ew;
   private static int[] ex;
   private static int[] ey;
   private static int ez;
   private static int eA;
   public int dMP;
   public int bz;
   public boolean bA;
   public int dHP;
   public int bC;
   public boolean bD;
   private long eB;
   private long eC;
   private int eD;
   public static String[] bE;
   public static int[] bF;
   public static int[] bG;
   private static int[] eE;
   private static int[] eF;
   private static int[] eG;
   public static int[] bH;
   public static int[] bI;
   private static int[] eH;
   private static int[] eI;
   private static int[] eJ;
   private static int[] eK;
   private static int[] eL;
   private static int[] eM;
   private static Image[] eN;
   private static int eO;
   private static int eP;
   private static long eQ;
   private int eR;
   public static int bJ;
   public static int bK;
   public static int bL;
   public static int bM;
   private static int eS;
   private static int eT;
   private static int eU;
   private static int eV;
   private CommandLine eW;
   public static boolean bN;
   public static boolean bO;
   public PopUpYesNo popUpYesNo;
   private static Vector eX;
   public boolean bQ;
   private int[] eY;
   private int[] eZ;
   private int[] fa;
   private int[] fb;
   private int[] fc;
   private int fd;
   private String fe;
   private int ff;
   private int fg;
   private int fh;
   private boolean fi;
   public byte bR;
   public boolean bS;
   public int bT;
   public static boolean bU;
   public static byte bV;
   public static byte isNewMember;
   private String fj;
   private String[] fk;
   public ItemOptionTemplate[] iOptionTemplates;
   private static Image fl;
   public static nr_ce bY;
   private static FrameImage fm;
   private static FrameImage fn;
   private static Image fo;
   private static Image fp;
   private static Image fq;
   private static Image fr;

   static {
      new MyVector("vPtMap");
      B = new MyVector("vFriend");
      C = new MyVector("vEnemies");
      vCharInMap = new MyVector("vCharInMap");
      vItemMap = new MyVector("vItemMap");
      ct = new MyVector("vMobAttack");
      new MyVector("vSet");
      F = new MyVector("vMob");
      G = new MyVector("vNpc");
      H = new MyVector("vFlag");
      cu = 0;
      J = -1;
      cv = 0;
      cw = new nr_ds();
      cx = new nr_ds();
      new MyVector("vItemUpGrade");
      M = false;
      cy = false;
      cz = false;
      cA = false;
      cB = false;
      cC = false;
      cD = false;
      N = false;
      O = false;
      cE = false;
      cF = false;
      cG = false;
      cH = false;
      cI = false;
      cJ = false;
      cK = false;
      cL = false;
      cM = false;
      cN = false;
      cO = false;
      cP = false;
      cQ = false;
      cR = false;
      cS = false;
      cT = false;
      cU = false;
      cV = false;
      cW = false;
      cX = false;
      cY = false;
      cZ = false;
      da = false;
      db = false;
      dc = false;
      dd = false;
      de = false;
      df = false;
      dg = false;
      dh = false;
      ad = mSystem.load("/mainImage/myTexture2dstat.png");
      ae = mSystem.load("/mainImage/myTexture2dlineColor20.png");
      af = mSystem.load("/mainImage/myTexture2dlineColor21.png");
      ag = mSystem.load("/mainImage/myTexture2dlineColor22.png");
      ah = mSystem.load("/mainImage/myTexture2dlineColor00.png");
      ai = mSystem.load("/mainImage/myTexture2dlineColor01.png");
      aj = mSystem.load("/mainImage/myTexture2dlineColor02.png");
      aB = 0;
      info1 = new InfoMe();
      aD = new InfoMe();
      dB = new main.nr_b();
      aN = 0;
      fm = new FrameImage(mSystem.load("/mainImage/i_pve_bar_0.png"), 6, 15);
      fn = new FrameImage(mSystem.load("/mainImage/i_pve_bar_1.png"), 38, 21);
      fo = mSystem.load("/mainImage/i_vs.png");
      fp = mSystem.load("/mainImage/i_charlife.png");
      fl = mSystem.load("/mainImage/i_hp.png");
      fq = mSystem.load("/mainImage/i_khung.png");
      imgLbtnFocus = mSystem.load("/mainImage/myTexture2dbtnl.png");
      imgLbtn = mSystem.load("/mainImage/myTexture2dbtnlf.png");
      ax = mSystem.load("/mainImage/myTexture2dbtnl2.png");
      ay = mSystem.load("/mainImage/myTexture2dbtnlf2.png");
      dv = mSystem.load("/mainImage/myTexture2dpanel.png");
      dw = mSystem.load("/mainImage/panel2.png");
      dx = mSystem.load("/mainImage/myTexture2dHP.png");
      dy = mSystem.load("/mainImage/SP.png");
      dz = mSystem.load("/mainImage/myTexture2dhpLost.png");
      aF = mSystem.load("/mainImage/myTexture2dmpLost.png");
      aE = mSystem.load("/mainImage/myTexture2dMP.png");
      at = mSystem.load("/mainImage/myTexture2dskill.png");
      au = mSystem.load("/mainImage/myTexture2dskill2.png");
      as = mSystem.load("/mainImage/myTexture2dmenu.png");
      dn = mSystem.load("/mainImage/myTexture2dfocus.png");
      aG = mSystem.load("/mainImage/tm-do.png");
      aH = mSystem.load("/mainImage/tm-vang.png");
      aI = mSystem.load("/mainImage/tm-xam.png");
      aJ = mSystem.load("/mainImage/tm-xanh.png");
      if (main.GameCanvas.isTouch) {
         mSystem.load("/mainImage/myTexture2darrow.png");
         mSystem.load("/mainImage/myTexture2darrow2.png");
         dl = mSystem.load("/mainImage/myTexture2dchat.png");
         dm = mSystem.load("/mainImage/myTexture2dchat2.png");
         _do = mSystem.load("/mainImage/myTexture2dfocus2.png");
         dp = mSystem.load("/mainImage/myTexture2dPea0.png");
         dq = mSystem.load("/mainImage/myTexture2dPea1.png");
         az = mSystem.load("/mainImage/myTexture2danalog1.png");
         aA = mSystem.load("/mainImage/myTexture2danalog2.png");
         dr = mSystem.load("/mainImage/myTexture2dPea2.png");
         ds = mSystem.load("/mainImage/myTexture2dPea3.png");
         dt = mSystem.load("/mainImage/myTexture2dfirebtn0.png");
         du = mSystem.load("/mainImage/myTexture2dfirebtn1.png");
      }

      aN = Rms.loadRMSInt("analog") == 1 ? 1 : 0;
      dB = new main.nr_b();
      byte[] var0 = Rms.loadRMS("NRdataVersion");
      byte[] var1 = Rms.loadRMS("NRmapVersion");
      byte[] var2 = Rms.loadRMS("NRskillVersion");
      byte[] var3 = Rms.loadRMS("NRitemVersion");
      if (var0 != null) {
         vcData = var0[0];
      }

      if (var1 != null) {
         vcMap = var1[0];
      }

      if (var2 != null) {
         am = var2[0];
      }

      if (var3 != null) {
         an = var3[0];
      }

      aO = new Skill[10];
      aP = new Skill[10];
      dR = mSystem.load("/bg/trans.png");
      dY = 0;
      bn = mSystem.load("/mainImage/myTexture2dnut.png");
      bo = mSystem.load("/mainImage/myTexture2dnutF.png");
      bs = true;
      en = new int[]{1, -1, 1, -1};
      eo = new int[]{1, -1, -1, 1};
      bu = new MyVector("");
      bv = mSystem.load("/mainImage/myTexture2darrow3.png");
      bF = new int[5];
      bG = new int[5];
      eF = new int[5];
      eG = new int[5];
      bH = new int[5];
      bE = new String[5];
      eE = new int[5];
      eH = new int[5];
      bI = new int[8];

      for(int var4 = 0; var4 < 5; ++var4) {
         bH[var4] = -1;
      }

      bL = 140;
      bM = 160;
      bN = false;
      bO = false;
      eX = new Vector();
   }

   public final void a() {
      DataInputStream var1 = null;

      try {
         short var2;
         x = new Rms[var2 = (var1 = new DataInputStream(new ByteArrayInputStream(Rms.loadRMS("NR_part")))).readShort()];

         for(int var3 = 0; var3 < var2; ++var3) {
            byte var4 = var1.readByte();
            x[var3] = new Rms(var4);

            for(int var13 = 0; var13 < x[var3].a.length; ++var13) {
               x[var3].a[var13] = new PartImage();
               x[var3].a[var13].a = var1.readShort();
               x[var3].a[var13].b = var1.readByte();
               x[var3].a[var13].c = var1.readByte();
            }
         }
      } catch (Exception var11) {
         var11.printStackTrace();
      } finally {
         try {
            var1.close();
         } catch (IOException var10) {
            var10.printStackTrace();
         }

      }

      SmallImage.init();
   }

   public static void a(Image var0, Image var1, Image var2, float var3, float var4, int var5, float var6, mGraphics var7) {
      var5 = var7.drawRect();
      int var8 = var7.fillRect();
      int var9 = var7.e();
      int var10 = var7.f();
      var7.e((int)var3, (int)var4, (int)var6, 13);

      for(int var11 = 0; var11 < 4; ++var11) {
         var7.setColor(var1, var3 + (float)((var11 + 1) * 15), var4, 0);
      }

      var7.setColor(var0, var3, var4, 0);
      var7.setColor(var1, var3 + 100.0F - 30.0F, var4, 0);
      var7.setColor(var2, var3 + 100.0F - 15.0F, var4, 0);
      var7.e(var5, var8, var9, var10);
   }

   public static boolean e() {
      return TileMap.l >= 53 && TileMap.l <= 62;
   }

   public static boolean f() {
      return TileMap.l >= 63;
   }

   public final void switchToMe() {
      ServerListScreen.f = false;
      if (BackgroudEffect.b()) {
         SoundMn.stopAll();
      }

      LoginScr.c = false;
      Char.isLoadingMap = false;
      if (!a) {
         Service.gI().s();
      }

      if (TileMap.b() && nr_cu.b) {
         nr_cu.b = false;
         super.cb = null;
      }

      info1.f = true;
      aD.f = true;
      b = true;
      this.dA = 0;
      a = false;
      super.switchToMe();
   }

   public static void g() {
      Teleport.vTeleport.removeAllElements();
      vCharInMap.removeAllElements();
      vItemMap.removeAllElements();
      Effect2.vEffect2.removeAllElements();
      Effect2.vAnimate.removeAllElements();
      Effect2.vEffect2Out.removeAllElements();
      Effect2.vEffectFeet.removeAllElements();
      Effect2.vEffect3.removeAllElements();
      ct.removeAllElements();
      F.removeAllElements();
      G.removeAllElements();
      Char.myCharz().bF.removeAllElements();
   }

   public final void a(byte[] var1) {
      ResLog.c("GET ONSCREENSKILL!");
      aP = new Skill[10];
      if (var1 == null) {
         ResLog.c("null");
         ResLog.c("LOAD DEFAULT ONSCREEN SKILL");

         for(int var5 = 0; var5 < aP.length && var5 < Char.myCharz().vSkillFight.size(); ++var5) {
            Skill var6 = (Skill)Char.myCharz().vSkillFight.elementAt(var5);
            aP[var5] = var6;
         }

         B();
      } else {
         for(int var2 = 0; var2 < var1.length; ++var2) {
            for(int var3 = 0; var3 < Char.myCharz().vSkillFight.size(); ++var3) {
               Skill var4;
               if ((var4 = (Skill)Char.myCharz().vSkillFight.elementAt(var3)).template.id == var1[var2]) {
                  aP[var2] = var4;
                  break;
               }
            }
         }

      }
   }

   public final void b(byte[] var1) {
      ResLog.c("GET KEYSKILL!");
      aO = new Skill[10];
      if (var1 == null) {
         ResLog.c("LOAD DEFAULT KEY SKILL");

         for(int var5 = 0; var5 < aO.length && var5 < Char.myCharz().vSkillFight.size(); ++var5) {
            Skill var6 = (Skill)Char.myCharz().vSkillFight.elementAt(var5);
            aO[var5] = var6;
         }

         C();
      } else {
         for(int var2 = 0; var2 < var1.length; ++var2) {
            for(int var3 = 0; var3 < Char.myCharz().vSkillFight.size(); ++var3) {
               Skill var4;
               if ((var4 = (Skill)Char.myCharz().vSkillFight.elementAt(var3)).template.id == var1[var2]) {
                  aO[var2] = var4;
                  break;
               }
            }
         }

      }
   }

   public final void c(byte[] var1) {
      ResLog.c("GET CURRENTSKILL!");
      if (var1 != null && var1.length != 0) {
         for(int var2 = 0; var2 < Char.myCharz().vSkillFight.size(); ++var2) {
            Skill var3;
            if ((var3 = (Skill)Char.myCharz().vSkillFight.elementAt(var2)).template.id == var1[0]) {
               Char.myCharz().myskill = var3;
               break;
            }
         }
      } else if (Char.myCharz().vSkillFight.size() > 0) {
         Char.myCharz().myskill = (Skill)Char.myCharz().vSkillFight.elementAt(0);
      }

      if (Char.myCharz().myskill != null) {
         Service.gI().selectSkill((int)Char.myCharz().myskill.template.id);
         Char.myCharz();
      }

   }

   protected static void a(SkillTemplate var0) {
      ResLog.c("DO SET ONSCREEN SKILL");
      Skill var5 = Char.myCharz().a(var0);
      MyVector var1 = new MyVector("");

      for(int var2 = 0; var2 < (main.GameCanvas.isTouch ? 10 : 5); ++var2) {
         Object[] var3;
         (var3 = new Object[2])[0] = var5;
         var3[1] = String.valueOf(var2);
         CommandLine var6 = new CommandLine(mResources.cA + (var2 + 1), 11120, var3);
         if (aP[var2] != null) {
            var6.a = true;
         }

         var1.addElement(var6);
      }

      main.GameCanvas.menu.startAt(var1);
   }

   protected static void b(SkillTemplate var0) {
      ResLog.c("DO SET KEY SKILL");
      Skill var5 = Char.myCharz().a(var0);
      String[] var1 = TField.g ? mResources.aQ : mResources.aR;
      MyVector var2 = new MyVector("");

      for(int var3 = 0; var3 < (main.GameCanvas.isTouch ? 10 : 5); ++var3) {
         Object[] var4;
         (var4 = new Object[2])[0] = var5;
         var4[1] = String.valueOf(var3);
         var2.addElement(new CommandLine(var1[var3], 11121, var4));
      }

      main.GameCanvas.menu.startAt(var2);
   }

   private static void B() {
      byte[] var0 = new byte[aP.length];

      for(int var1 = 0; var1 < aP.length; ++var1) {
         if (aP[var1] == null) {
            var0[var1] = -1;
         } else {
            var0[var1] = aP[var1].template.id;
         }
      }

      Service.gI().a(var0);
   }

   private static void C() {
      byte[] var0 = new byte[aO.length];

      for(int var1 = 0; var1 < aO.length; ++var1) {
         if (aO[var1] == null) {
            var0[var1] = -1;
         } else {
            var0[var1] = aO[var1].template.id;
         }
      }

      Service.gI().a(var0);
   }

   public static boolean h() {
      for(int var0 = Char.myCharz().arrItemBag.length - 1; var0 >= 0; --var0) {
         if (Char.myCharz().arrItemBag[var0] == null) {
            return false;
         }
      }

      return true;
   }

   public static void a(String[] var0, Npc var1) {
      MyVector var2 = new MyVector("");

      for(int var3 = 0; var3 < var0.length; ++var3) {
         var2.addElement(new CommandLine(var0[var3], 11057, var1));
      }

      main.GameCanvas.menu.startAt(var2);
   }

   public static void i() {
      DataInputStream var0 = null;

      try {
         short var1;
         y = new EffectCharPaint[var1 = (var0 = new DataInputStream(new ByteArrayInputStream(Rms.loadRMS("NR_effect")))).readShort()];

         for(int var2 = 0; var2 < var1; ++var2) {
            y[var2] = new EffectCharPaint();
            var0.readShort();
            y[var2].a = new EffectInfoPaint[var0.readByte()];

            for(int var3 = 0; var3 < y[var2].a.length; ++var3) {
               y[var2].a[var3] = new EffectInfoPaint();
               y[var2].a[var3].c = var0.readShort();
               y[var2].a[var3].a = var0.readByte();
               y[var2].a[var3].b = var0.readByte();
            }
         }

         return;
      } catch (Exception var10) {
         var10.printStackTrace();
      } finally {
         try {
            var0.close();
         } catch (IOException var9) {
            var9.printStackTrace();
         }

      }

   }

   public static void j() {
      DataInputStream var0 = null;

      try {
         short var1;
         v = new nr_ct[var1 = (var0 = new DataInputStream(new ByteArrayInputStream(Rms.loadRMS("NR_arrow")))).readShort()];

         for(int var2 = 0; var2 < var1; ++var2) {
            v[var2] = new nr_ct();
            var0.readShort();
            v[var2].a[0] = var0.readShort();
            v[var2].a[1] = var0.readShort();
            v[var2].a[2] = var0.readShort();
         }

         return;
      } catch (Exception var9) {
         var9.printStackTrace();
      } finally {
         try {
            var0.close();
         } catch (IOException var8) {
            var8.printStackTrace();
         }

      }

   }

   public static void k() {
      DataInputStream var0 = null;

      try {
         short var1;
         w = new DartInfo[var1 = (var0 = new DataInputStream(new ByteArrayInputStream(Rms.loadRMS("NR_dart")))).readShort()];

         for(int var2 = 0; var2 < var1; ++var2) {
            w[var2] = new DartInfo();
            var0.readShort();
            w[var2].h = var0.readShort();
            w[var2].i = var0.readShort() << 8;
            w[var2].g = var0.readShort();
            short var3 = var0.readShort();
            w[var2].c = new short[var3];

            int var4;
            for(var4 = 0; var4 < var3; ++var4) {
               w[var2].c[var4] = var0.readShort();
            }

            var3 = var0.readShort();
            w[var2].d = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               w[var2].d[var4] = var0.readShort();
            }

            var3 = var0.readShort();
            w[var2].e = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               w[var2].e[var4] = var0.readShort();
            }

            var3 = var0.readShort();
            w[var2].f = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               w[var2].f[var4] = var0.readShort();
            }

            var3 = var0.readShort();
            w[var2].a = new short[var3][];

            short var5;
            int var6;
            for(var4 = 0; var4 < var3; ++var4) {
               var5 = var0.readShort();
               w[var2].a[var4] = new short[var5];

               for(var6 = 0; var6 < var5; ++var6) {
                  w[var2].a[var4][var6] = var0.readShort();
               }
            }

            var3 = var0.readShort();
            w[var2].b = new short[var3][];

            for(var4 = 0; var4 < var3; ++var4) {
               var5 = var0.readShort();
               w[var2].b[var4] = new short[var5];

               for(var6 = 0; var6 < var5; ++var6) {
                  w[var2].b[var4][var6] = var0.readShort();
               }
            }
         }

         return;
      } catch (Exception var13) {
         var13.printStackTrace();
      } finally {
         try {
            var0.close();
         } catch (IOException var12) {
            var12.printStackTrace();
         }

      }

   }

   public static void l() {
      DataInputStream var0 = null;

      try {
         short var1 = (var0 = new DataInputStream(new ByteArrayInputStream(Rms.loadRMS("NR_skill")))).readShort();
         u = new SkillPaint[nr_o.a.size()];

         for(int var2 = 0; var2 < var1; ++var2) {
            short var3;
            if ((var3 = var0.readShort()) == 1111) {
               var3 = (short)(var1 - 1);
            }

            u[var3] = new SkillPaint();
            u[var3].a = var3;
            u[var3].b = var0.readShort();
            if (u[var3].b <= 0) {
               u[var3].b = 80;
            }

            var0.readByte();
            u[var3].c = new nr_f[var0.readByte()];

            int var4;
            for(var4 = 0; var4 < u[var3].c.length; ++var4) {
               u[var3].c[var4] = new nr_f();
               u[var3].c[var4].a = var0.readByte();
               u[var3].c[var4].b = var0.readShort();
               u[var3].c[var4].c = var0.readShort();
               u[var3].c[var4].d = var0.readShort();
               u[var3].c[var4].e = var0.readShort();
               u[var3].c[var4].f = var0.readShort();
               u[var3].c[var4].g = var0.readShort();
               u[var3].c[var4].h = var0.readShort();
               u[var3].c[var4].i = var0.readShort();
               u[var3].c[var4].j = var0.readShort();
               u[var3].c[var4].k = var0.readShort();
               u[var3].c[var4].l = var0.readShort();
               u[var3].c[var4].m = var0.readShort();
            }

            u[var3].d = new nr_f[var0.readByte()];

            for(var4 = 0; var4 < u[var3].d.length; ++var4) {
               u[var3].d[var4] = new nr_f();
               u[var3].d[var4].a = var0.readByte();
               u[var3].d[var4].b = var0.readShort();
               u[var3].d[var4].c = var0.readShort();
               u[var3].d[var4].d = var0.readShort();
               u[var3].d[var4].e = var0.readShort();
               u[var3].d[var4].f = var0.readShort();
               u[var3].d[var4].g = var0.readShort();
               u[var3].d[var4].h = var0.readShort();
               u[var3].d[var4].i = var0.readShort();
               u[var3].d[var4].j = var0.readShort();
               u[var3].d[var4].k = var0.readShort();
               u[var3].d[var4].l = var0.readShort();
               u[var3].d[var4].m = var0.readShort();
            }
         }
      } catch (Exception var11) {
         var11.printStackTrace();
      } finally {
         try {
            var0.close();
         } catch (IOException var10) {
            var10.printStackTrace();
         }

      }

      ResLog.c("READ SKILL DONE");
   }

   public static GameScr gI() {
      if (c == null) {
         c = new GameScr();
      }

      return c;
   }

   public static void n() {
      c = null;
   }

   public final void o() {
      if (eN == null) {
         eN = new Image[3];

         for(int var1 = 0; var1 < 3; ++var1) {
            eN[var1] = mSystem.load("/e/sp" + var1 + ".png");
         }
      }

      eI = new int[2];
      eJ = new int[2];
      eK = new int[2];
      eL = new int[2];
      eM = new int[2];
      eK[0] = eK[1] = -1;
      this.eR = 84;
      eQ = 66L;
      eP = 59;
      eO = 61;
   }

   public GameScr() {
      int[] var10000 = new int[]{-1, -1};
      this.bQ = false;
      this.fj = "";
      new CommandLine("", 11021);
      this.aQ = new CommandLine("  ", 11000);
      this.s = new CommandLine("", 11001);
      this.aQ.g = as;
      this.aQ.k = mGraphics.setColor(this.aQ.g) + 20;
      this.aQ.isPlaySoundButton = false;
      this.s.g = dn;
      if (main.GameCanvas.isTouch) {
         this.aQ.x = 0;
         this.aQ.y = 50;
         this.s = null;
      } else {
         this.aQ.x = 0;
         this.aQ.y = e - 30;
         this.s.x = d - 32;
         this.s.y = e - 32;
      }

      super.cb = this.s;
      bm = 1;
      if (main.GameCanvas.isTouch) {
         N = true;
      }

   }

   public static final void loadCamera(int var0, int var1) {
      d = main.GameCanvas.z;
      h = 39;
      e = main.GameCanvas.A;
      if ((cn = main.GameCanvas.A / 6) < 48) {
         cn = 48;
      }

      f = d >> 1;
      cm = e >> 1;
      cl = e - 120;
      g = (e << 1) / 3;
      i = d / 6;
      cj = d / TileMap.i + 2;
      ck = e / TileMap.i + 2;
      if (d % 24 != 0) {
         ++cj;
      }

      n = (TileMap.a - 1) * TileMap.i - d;
      cs = (TileMap.b - 1) * TileMap.i - e;
      if (var0 == -1 && var1 == -1) {
         cmx = l = Char.myCharz().cx - f + i * Char.myCharz().I;
         cmy = m = Char.myCharz().cy - g - 1;
      } else {
         cmx = l = var0 - cl + i * Char.myCharz().I;
         cmy = m = var1 - g - 1;
      }

      if (cmx < 24) {
         l = 24;
         cmx = 24;
      }

      if (cmx > n) {
         cmx = l = n;
      }

      if (cmy < 0) {
         m = 0;
         cmy = 0;
      }

      if (cmy > cs) {
         cmy = m = cs;
      }

      if ((o = cmx / TileMap.i - 1) < 0) {
         o = 0;
      }

      p = cmy / TileMap.i;
      q = o + cj;
      r = p + ck;
      if (p < 0) {
         p = 0;
      }

      if (r > TileMap.b - 1) {
         r = TileMap.b - 1;
      }

      if ((TileMap.F = q - o << 2) > TileMap.a) {
         TileMap.F = TileMap.a;
      }

      if ((TileMap.G = r - p << 2) > TileMap.b) {
         TileMap.G = TileMap.b;
      }

      if ((TileMap.B = (Char.myCharz().cx - 2 * d) / TileMap.i) < 0) {
         TileMap.B = 0;
      }

      if ((TileMap.C = TileMap.B + TileMap.F) > TileMap.a) {
         TileMap.C = TileMap.a;
      }

      if ((TileMap.D = (Char.myCharz().cy - 2 * e) / TileMap.i) < 0) {
         TileMap.D = 0;
      }

      if ((TileMap.E = TileMap.D + TileMap.G) > TileMap.b) {
         TileMap.E = TileMap.b;
      }

      ChatTextField.gI().c = c;
      ChatTextField.gI().a.b = main.GameCanvas.A - 35 - ChatTextField.gI().a.height;
      ChatTextField.gI().a();
      if (main.GameCanvas.isTouch) {
         eq = e - 88;
         er = d - 40;
         es = 2;
         if (main.GameCanvas.z <= 240) {
            er = d - 35;
            es = 5;
         }

         et = d - 55;
         eu = eq + 35;
         ev = d - 37;
         ew = eq - 1;
         if (main.GameCanvas.z >= 450) {
            ew -= 12;
            bx -= 7;
            et -= 10;
            eu -= 5;
            ev -= 10;
         }
      }

      p();
      em = main.GameCanvas.z > 200 ? 40 : 30;
      Panel var10000;
      boolean var10001;
      if (Rms.loadRMSInt("viewchat") == -1) {
         var10000 = main.GameCanvas.panel;
         var10001 = true;
      } else {
         var10000 = main.GameCanvas.panel;
         var10001 = Rms.loadRMSInt("viewchat") == 1;
      }

      var10000.at = var10001;
   }

   public static void p() {
      Skill[] var0;
      ex = new int[(var0 = main.GameCanvas.isTouch ? aP : aO).length];
      ey = new int[var0.length];
      dC = 30;
      if (main.GameCanvas.z <= 320) {
         eA = e - dC - 6;
         ez = f - var0.length * dC / 2 - 25;
      } else {
         dC = 40;
         ez = 10;
         eA = main.GameCanvas.A - dC + 7;
      }

      int var1;
      for(var1 = 0; var1 < ex.length; ++var1) {
         ex[var1] = var1 * dC;
         ey[var1] = eA;
         if (ex.length > 5 && var1 >= ex.length / 2) {
            ex[var1] = (var1 - ex.length / 2) * dC;
            ey[var1] = eA - 32;
         }
      }

      bw = var0.length * dC;
      bx = eA;
      if (main.GameCanvas.isTouch) {
         ez = 17;
         eA = main.GameCanvas.A - 40;
         if (dB.b && aN == 1) {
            bw = var0.length * dC;
            bx = eA;
         } else {
            bw = main.GameCanvas.z - 45;
            bx = main.GameCanvas.A - 45;
         }

         if (aN != 0) {
            ev = et = main.GameCanvas.z - 45;
            if (dB.d) {
               ez = dB.a + 20;
               dC = 35;
               bw = et - 45;
            } else if (dB.c) {
               bw = et - 45;
            }

            ew = (eu = main.GameCanvas.A - 45) - 45;
         }

         for(var1 = 0; var1 < ex.length; ++var1) {
            ex[var1] = var1 * dC;
            ey[var1] = eA;
            if (ex.length > 5 && var1 >= ex.length / 2) {
               ex[var1] = (var1 - ex.length / 2) * dC;
               ey[var1] = eA - 32;
            }
         }
      }

   }

   public final void a(String var1, int var2, int var3) {
      nr_i var4;
      (var4 = new nr_i()).b = var3;
      var4.a = var2;
      this.startYesNoPopUp(var1, new CommandLine(mResources.bm, 12002, var4), new CommandLine(mResources.bn, 12003, var4));
   }

   private void E() {
      this.aW = 0;
      main.GameCanvas.f();
      if (Char.myCharz().aU.charID >= 0) {
         if (Char.myCharz().charID >= 0) {
            MyVector var1;
            if ((var1 = main.GameCanvas.panel.R).size() <= 0) {
               if (Char.myCharz().aD != null && Char.myCharz().aD.c > 1) {
                  var1.addElement(new CommandLine(mResources.cO, 11112, Char.myCharz().aU));
                  var1.addElement(new CommandLine(mResources.dK, 11113, Char.myCharz().aU));
               }

               if (Char.myCharz().clan != null && Char.myCharz().aj < 2 && Char.myCharz().aU.ah == -1) {
                  var1.addElement(new CommandLine(mResources.aL[4], 110391));
               }

               if (Char.myCharz().aU.statusMe != 14 && Char.myCharz().aU.statusMe != 5) {
                  if (Char.myCharz().aD != null && Char.myCharz().aD.c >= 14) {
                     var1.addElement(new CommandLine(mResources.aL[0], 2003));
                  }
               } else {
                  Char.myCharz();
               }

               if (Char.myCharz().clan != null && Char.myCharz().clan.a == Char.myCharz().aU.ah && Char.myCharz().aU.statusMe != 14 && Char.myCharz().aD != null && Char.myCharz().aD.c >= 14) {
                  var1.addElement(new CommandLine(mResources.aL[1], 2004));
               }

               int var2 = Char.myCharz().nClass.b.length;

               for(int var3 = 0; var3 < var2; ++var3) {
                  SkillTemplate var4 = Char.myCharz().nClass.b[var3];
                  Skill var5;
                  if ((var5 = Char.myCharz().a(var4)) != null && var4.a() && var5.point > 0) {
                     var1.addElement(new CommandLine(var4.b, 12004, var5));
                  }
               }

            }
         }
      }
   }

   public static boolean a(Mob var0) {
      if (var0 == null) {
         return false;
      } else if (Char.myCharz().cTypePk == 5) {
         return true;
      } else if (Char.myCharz().I() && !var0.J) {
         return false;
      } else if (Char.myCharz().aR != null && var0.equals(Char.myCharz().aR)) {
         return false;
      } else {
         Char var1;
         if ((var1 = findCharInMap(var0.mobId)) == null) {
            return true;
         } else if (var1.cTypePk == 5) {
            return true;
         } else {
            return Char.myCharz().c(var1);
         }
      }
   }

   private boolean F() {
      if (Char.myCharz().myskill == null || (Char.myCharz().myskill.template.d == 1 || Char.myCharz().cMP >= Char.myCharz().myskill.i) && (Char.myCharz().myskill.template.d != 1 || Char.myCharz().cMP >= Char.myCharz().cMPFull * Char.myCharz().myskill.i / 100)) {
         if (Char.myCharz().myskill != null && (Char.myCharz().myskill.template.maxPoint <= 0 || Char.myCharz().myskill.point != 0)) {
            return true;
         } else {
            main.GameCanvas.startOKDlg(mResources.aS);
            return false;
         }
      } else {
         info1.a(mResources.bH, 0);
         this.aW = 0;
         return false;
      }
   }

   public final void q() {
      main.GameCanvas.menu.a = false;
      ChatTextField var1;
      (var1 = ChatTextField.gI()).a.setText("");
      var1.b = false;
      ChatTextField.gI().f = null;
      this.dk = false;
      this.Z = 0;
      cv = 0;
      cu = 0;
      this.dj = -1;
      J = -1;
      this.Z = this.aa = 0;
      if (Char.myCharz().cHP > 0 && Char.myCharz().statusMe != 14 && Char.myCharz().statusMe != 5) {
         N = true;
      } else {
         if (Char.myCharz().cF) {
            this.eW = new CommandLine(mResources.aW[0], 11038);
            super.center = this.eW;
            Char.myCharz().cHP = 0;
         }

         N = false;
      }

      nr_ds var2;
      (var2 = cx).a = 0;
      var2.b = 0;
      var2.c = 0;
      var2.d = 0;
      var2.e = 0;
      var2.f = 0;
      var2.g = 0;
      var2.h = 0;
      var2.k = 0;
      var2.l = 0;
      var2.i = 0;
      var2.j = 0;
   }

   public final void keyPress(int var1) {
      super.keyPress(var1);
   }

   public final void updateKey() {
      if (!Controller.b && !Char.myCharz().s && !Char.myCharz().cY) {
         if (!InfoDlg.b) {
            int var1;
            MyVector var2;
            int var4;
            int var5;
            int var7;
            int var8;
            char[] var10;
            if (main.GameCanvas.isTouch && !ChatTextField.gI().b && !main.GameCanvas.menu.a && !this.L()) {
               label1075: {
                  mScreen.cf = -1;
                  if (main.GameCanvas.f) {
                     label1076: {
                        if (main.GameCanvas.isPointerHoldIn(0, 0, 60, 50) && main.GameCanvas.l && main.GameCanvas.m) {
                           if (Char.myCharz().an != null) {
                              Char.myCharz().an.performAction();
                           }

                           Char.myCharz().bP = null;
                           main.GameCanvas.k();
                           this.ed = true;
                           this.ee = 5;
                           break label1075;
                        }

                        if (!TileMap.d() && main.GameCanvas.isPointerHoldIn(er, es, 34, 34)) {
                           mScreen.cf = 15;
                           main.GameCanvas.ah = false;
                           this.aS = false;
                           ChatTextField.gI().h = mResources.bp;
                           if (main.GameCanvas.l && main.GameCanvas.m) {
                              ChatTextField.gI().a("");
                              SoundMn.stopAll();
                              Char.myCharz().bP = null;
                              main.GameCanvas.k();
                              break label1075;
                           }
                        }

                        if (Char.myCharz().an != null && main.GameCanvas.isPointerHoldIn(Char.myCharz().an.x - 17, Char.myCharz().an.y - 17, 34, 34)) {
                           mScreen.cf = 20;
                           main.GameCanvas.ah = false;
                           this.aS = false;
                           if (main.GameCanvas.l && main.GameCanvas.m) {
                              main.GameCanvas.k();
                              Char.myCharz().an.performAction();
                              break label1075;
                           }
                        }

                        if (aN != 0 && Char.myCharz().statusMe != 14) {
                           if (main.GameCanvas.isPointerHoldIn(et, eu, 40, 40)) {
                              mScreen.cf = 5;
                              if (main.GameCanvas.m) {
                                 main.GameCanvas.keyPressed[5] = true;
                                 main.GameCanvas.m = false;
                                 main.GameCanvas.ah = false;
                                 main.GameCanvas.l = false;
                              }
                           }

                           dB.a();
                           if (main.GameCanvas.isPointerHoldIn(ev, ew, 34, 34)) {
                              mScreen.cf = 13;
                              main.GameCanvas.ah = false;
                              this.aS = false;
                              if (main.GameCanvas.l && main.GameCanvas.m) {
                                 Char.myCharz().J();
                                 main.GameCanvas.m = false;
                                 main.GameCanvas.ah = false;
                                 main.GameCanvas.l = false;
                              }
                           }
                        }

                        if (aN == 0) {
                           if (!main.GameCanvas.isPointerHoldIn(bw, bx, 40, 40)) {
                              break label1076;
                           }
                        } else if (!main.GameCanvas.isPointerHoldIn(bw, bx, 34, 34)) {
                           break label1076;
                        }

                        if (Char.myCharz().statusMe != 14 && this.aK == null) {
                           mScreen.cf = 10;
                           main.GameCanvas.ah = false;
                           this.aS = false;
                           if (main.GameCanvas.l && main.GameCanvas.m) {
                              main.GameCanvas.keyPressed[10] = true;
                              main.GameCanvas.m = false;
                              main.GameCanvas.ah = false;
                              main.GameCanvas.l = false;
                           }
                        }
                     }
                  }

                  if (this.aK != null) {
                     GameScr var3 = this;
                     if (!this.L()) {
                        for(var4 = 0; var4 < var3.bl.length(); ++var4) {
                           var3.bp[var4] = -1;
                           if (main.GameCanvas.f) {
                              var5 = (main.GameCanvas.z - var3.bl.length() * em) / 2;
                              var8 = var3.bl.length() * em;
                              int var9 = main.GameCanvas.A - 40;
                              var1 = em;
                              if (main.GameCanvas.isPointerHoldIn(var5, var9, var8, var1)) {
                                 var1 = (main.GameCanvas.o - var5) / em;
                                 if (var4 == var1) {
                                    var3.bp[var4] = 1;
                                 }

                                 if (main.GameCanvas.l && main.GameCanvas.m && var4 == var1) {
                                    var10 = var3.br.toCharArray();
                                    var2 = new MyVector("");

                                    for(var5 = 0; var5 < var10.length; ++var5) {
                                       var2.addElement(String.valueOf(var10[var5]));
                                    }

                                    var2.removeElementAt(0);
                                    var2.insertElementAt(String.valueOf(var3.bl.charAt(var4)), var2.size());
                                    var3.br = "";

                                    for(var5 = 0; var5 < var2.size(); ++var5) {
                                       var3.br = var3.br + ((String)var2.elementAt(var5)).toUpperCase();
                                    }

                                    Service.gI().a(var3.bl.charAt(var4));
                                 }
                              }
                           }
                        }
                     }
                  } else if (N) {
                     if (this.I()) {
                        break label1075;
                     }

                     this.ef = -1;
                     boolean var6 = false;
                     if (aP.length > 5 && (main.GameCanvas.isPointerHoldIn(ez + ex[0] - dC / 2 + 12, ey[0] - dC / 2 + 12, 5 * dC, dC) || main.GameCanvas.isPointerHoldIn(ez + ex[5] - dC / 2 + 12, ey[5] - dC / 2 + 12, 5 * dC, dC))) {
                        var6 = true;
                     }

                     if (var6 || main.GameCanvas.isPointerHoldIn(ez + ex[0] - dC / 2 + 12, ey[0] - dC / 2 + 12, 5 * dC, dC) || !main.GameCanvas.f && main.GameCanvas.isPointerHoldIn(ez + ex[0] - dC / 2 + 12, ey[0] - dC / 2 + 12, dC, aP.length * dC)) {
                        main.GameCanvas.ah = false;
                        this.aS = false;
                        var7 = (main.GameCanvas.s - (ez + ex[0] - dC / 2 + 12)) / dC;
                        if (var6 && main.GameCanvas.t < ey[0]) {
                           var7 += 5;
                        }

                        this.ef = var7;
                        if (main.GameCanvas.l && main.GameCanvas.m) {
                           main.GameCanvas.m = false;
                           main.GameCanvas.ah = false;
                           main.GameCanvas.l = false;
                           this.eb = var7;
                           if (this.eb > aP.length - 1) {
                              this.eb = aP.length - 1;
                           }

                           Skill var12;
                           if ((var12 = aP[this.eb]) != null) {
                              this.a(var12, true);
                           }
                        }
                     }
                  }

                  if (main.GameCanvas.m) {
                     if (main.GameCanvas.j[1] || main.GameCanvas.j[2] || main.GameCanvas.j[3] || main.GameCanvas.j[4] || main.GameCanvas.j[6]) {
                        main.GameCanvas.m = false;
                     }

                     main.GameCanvas.j[1] = false;
                     main.GameCanvas.j[2] = false;
                     main.GameCanvas.j[3] = false;
                     main.GameCanvas.j[4] = false;
                     main.GameCanvas.j[6] = false;
                  }
               }
            }

            long var17 = System.currentTimeMillis();
            if (main.GameCanvas.keyPressed[2] || main.GameCanvas.keyPressed[4] || main.GameCanvas.keyPressed[6] || main.GameCanvas.keyPressed[1] || main.GameCanvas.keyPressed[3]) {
               this.aW = 0;
               bi = false;
            }

            if (main.GameCanvas.keyPressed[5]) {
               if (this.aW == 0) {
                  if (var17 - this.dP < 800L && (Char.myCharz().myskill != null && (Char.myCharz().myskill.template.d != 1 && Char.myCharz().cMP < Char.myCharz().myskill.i || Char.myCharz().myskill.template.d == 1 && Char.myCharz().cMP < Char.myCharz().cMPFull * Char.myCharz().myskill.i / 100) ? false : Char.myCharz().myskill != null && (Char.myCharz().myskill.template.maxPoint <= 0 || Char.myCharz().myskill.point != 0)) && (Char.myCharz().aQ != null || Char.myCharz().aU != null && Char.myCharz().c(Char.myCharz().aU))) {
                     this.aW = 10;
                     main.GameCanvas.keyPressed[5] = false;
                  }
               } else {
                  this.aW = 0;
                  main.GameCanvas.keyPressed[4] = main.GameCanvas.keyPressed[6] = false;
               }

               this.dP = var17;
            }

            label934: {
               if (main.GameCanvas.v % 5 == 0 && this.aW > 0 && Char.myCharz().bP == null) {
                  if (Char.myCharz().myskill != null && (Char.myCharz().myskill.template.b() || Char.myCharz().myskill.j)) {
                     break label934;
                  }

                  if (Char.myCharz().aQ != null && Char.myCharz().aQ.p != 1 && Char.myCharz().aQ.p != 0 && Char.myCharz().aU == null || Char.myCharz().aU != null && Char.myCharz().c(Char.myCharz().aU)) {
                     if (Char.myCharz().myskill.j) {
                        break label934;
                     }

                     this.a(false, true);
                  }
               }

               if (this.aW > 1) {
                  --this.aW;
               }
            }

            if (ChatPopup.currChatPopup != null) {
               CommandLine var11 = ChatPopup.currChatPopup.j;
               if ((main.GameCanvas.keyPressed[5] || mScreen.a(var11)) && var11 != null) {
                  main.GameCanvas.m = false;
                  main.GameCanvas.keyPressed[5] = false;
                  mScreen.cf = -1;
                  if (var11 != null) {
                     var11.performAction();
                  }
               }
            } else if (!ChatTextField.gI().b) {
               if ((main.GameCanvas.keyPressed[12] || mScreen.a(main.GameCanvas.currentScreen.left)) && super.left != null) {
                  main.GameCanvas.m = false;
                  main.GameCanvas.l = false;
                  main.GameCanvas.keyPressed[12] = false;
                  mScreen.cf = -1;
                  if (super.left != null) {
                     super.left.performAction();
                  }
               }

               if ((main.GameCanvas.keyPressed[13] || mScreen.a(main.GameCanvas.currentScreen.cb)) && super.cb != null) {
                  main.GameCanvas.m = false;
                  main.GameCanvas.l = false;
                  main.GameCanvas.keyPressed[13] = false;
                  mScreen.cf = -1;
                  if (super.cb != null) {
                     super.cb.performAction();
                  }
               }

               if ((main.GameCanvas.keyPressed[5] || mScreen.a(main.GameCanvas.currentScreen.center)) && super.center != null) {
                  main.GameCanvas.m = false;
                  main.GameCanvas.keyPressed[5] = false;
                  mScreen.cf = -1;
                  if (super.center != null) {
                     super.center.performAction();
                  }
               }
            } else {
               if (ChatTextField.gI().d != null && (main.GameCanvas.keyPressed[12] || mScreen.a(ChatTextField.gI().d)) && ChatTextField.gI().d != null) {
                  ChatTextField.gI().d.performAction();
               }

               if (ChatTextField.gI().e != null && (main.GameCanvas.keyPressed[13] || mScreen.a(ChatTextField.gI().e)) && ChatTextField.gI().e != null) {
                  ChatTextField.gI().e.performAction();
               }

               if (ChatTextField.gI().f != null && (main.GameCanvas.keyPressed[5] || mScreen.a(ChatTextField.gI().f)) && ChatTextField.gI().f != null) {
                  ChatTextField.gI().f.performAction();
               }
            }

            if (Char.myCharz().bP != null) {
               for(var1 = 0; var1 < main.GameCanvas.keyPressed.length; ++var1) {
                  if (main.GameCanvas.keyPressed[var1]) {
                     Char.myCharz().bP = null;
                     break;
                  }
               }
            }

            if (ChatTextField.gI().b && main.GameCanvas.ae != 0) {
               ChatTextField.gI().a(main.GameCanvas.ae);
               main.GameCanvas.ae = 0;
            } else if (!main.GameCanvas.menu.a && !Char.bH) {
               if (main.GameCanvas.keyPressed[10]) {
                  main.GameCanvas.keyPressed[10] = false;
                  this.G();
                  main.GameCanvas.clearKeyPressed();
               }

               if (main.GameCanvas.keyPressed[11] && this.aK == null) {
                  if (this.popUpYesNo != null) {
                     this.popUpYesNo.a.performAction();
                  } else if (aD.b.info != null && aD.b.info.c != null) {
                     main.GameCanvas.panel.l();
                     main.GameCanvas.panel.show();
                  }

                  main.GameCanvas.keyPressed[11] = false;
                  main.GameCanvas.clearKeyPressed();
               }

               if (main.GameCanvas.ae != 0 && TField.g && main.GameCanvas.ae == 32) {
                  this.G();
                  main.GameCanvas.ae = 0;
                  main.GameCanvas.clearKeyPressed();
               }

               if (main.GameCanvas.ae != 0 && this.aK == null && TField.g && main.GameCanvas.ae == 121) {
                  if (this.popUpYesNo != null) {
                     this.popUpYesNo.a.performAction();
                     main.GameCanvas.ae = 0;
                     main.GameCanvas.clearKeyPressed();
                  } else if (aD.b.info != null && aD.b.info.c != null) {
                     main.GameCanvas.panel.l();
                     main.GameCanvas.panel.show();
                     main.GameCanvas.ae = 0;
                     main.GameCanvas.clearKeyPressed();
                  }
               }

               boolean var14;
               if (main.GameCanvas.keyPressed[10] && this.aK == null) {
                  main.GameCanvas.keyPressed[10] = false;
                  var14 = true;
                  aD.g = 10;
                  main.GameCanvas.clearKeyPressed();
               }

               if (!dB.b() && aN != 1) {
                  Char.myCharz().ap = true;
                  if (main.GameCanvas.ah) {
                     main.GameCanvas.ah = false;
                     this.aS = true;
                     this.dI = 0;
                     this.dE = this.dG = main.GameCanvas.o;
                     this.dF = this.dH = main.GameCanvas.p;
                  }

                  if (this.aS) {
                     int var19 = main.GameCanvas.o - this.dE;
                     var7 = main.GameCanvas.p - this.dF;
                     if (!this.dD && (ResLog.g(main.GameCanvas.o - this.dG) > 15 || ResLog.g(main.GameCanvas.p - this.dH) > 15)) {
                        this.dD = true;
                     }

                     this.dE = main.GameCanvas.o;
                     this.dF = main.GameCanvas.p;
                     ++this.dI;
                     if (this.dD) {
                        Char.myCharz().ap = false;
                        cmx -= var19;
                        cmy -= var7;
                        int var13;
                        if (cmx < 24 && (var13 = (24 - cmx) / 3) != 0) {
                           cmx += var19 - var19 / var13;
                        }

                        if (cmx < 24) {
                           cmx = 24;
                        }

                        if (cmx > n && (var13 = (cmx - n) / 3) != 0) {
                           cmx += var19 - var19 / var13;
                        }

                        if (cmx > n) {
                           cmx = n;
                        }

                        if (cmy < 0 && (var13 = (0 - cmy) / 3) != 0) {
                           cmy += var7 - var7 / var13;
                        }

                        if (cmy < 0) {
                           cmy = 0;
                        }

                        if (cmy > cs) {
                           cmy = cs;
                        }

                        l = cmx;
                        m = cmy;
                     }
                  }

                  if (this.aS && main.GameCanvas.m) {
                     this.aS = false;
                     this.dD = false;
                     if (ResLog.g(main.GameCanvas.o - this.dG) > 15 || ResLog.g(main.GameCanvas.p - this.dH) > 15) {
                        main.GameCanvas.m = false;
                     }
                  }
               }

               int var15;
               if (!Char.myCharz().ci && !this.I()) {
                  if (this.popUpYesNo != null && this.popUpYesNo.a != null && this.popUpYesNo.a.isPointerPressInside()) {
                     this.popUpYesNo.a.performAction();
                  } else {
                     boolean var10000;
                     label822: {
                        if (this.aK != null) {
                           var15 = (main.GameCanvas.z - 5 * em) / 2;
                           var4 = 5 * em;
                           var5 = main.GameCanvas.A - 40;
                           var8 = em;
                           if (main.GameCanvas.isPointerHoldIn(var15, var5, var4, var8)) {
                              var10000 = true;
                              break label822;
                           }
                        }

                        var10000 = false;
                     }

                     if (!var10000) {
                        var17 = System.currentTimeMillis();
                        if (this.aT != 0L) {
                           this.aT = 0L;
                           main.GameCanvas.ah = false;
                           if (!this.dJ) {
                              var15 = main.GameCanvas.o + this.dN;
                              var4 = main.GameCanvas.p + this.dO;
                              if (!this.g(var15, var4) && !this.f(var15, var4)) {
                                 this.h(var15, var4);
                              }

                              main.GameCanvas.m = false;
                              this.cg = true;
                              this.ch = mSystem.currentTimeMillis();
                           }
                        }

                        if (this.cg) {
                           this.ci = mSystem.currentTimeMillis();
                           if (this.ci - this.ch < 300L && main.GameCanvas.m) {
                              label1177: {
                                 this.cg = false;
                                 var15 = main.GameCanvas.o + this.dN;
                                 var4 = main.GameCanvas.p + this.dO;
                                 Char.myCharz();
                                 IMapObject var20;
                                 if ((var20 = this.e(var15, var4)) != null) {
                                    if (!(var20 instanceof Mob) || a((Mob)var20)) {
                                       if (this.a(var20) || !var20.equals(Char.myCharz().aT) && this.aK != null) {
                                          break label1177;
                                       }

                                       Char var22;
                                       if ((!Char.myCharz().I() || Char.myCharz().aU == null || var20.equals(Char.myCharz().aU) || var20.equals(Char.myCharz().aU.aR) || !(var20 instanceof Char) || (var22 = (Char)var20).cTypePk == 5 || var22.I()) && (TileMap.l != 51 || !var20.equals(Char.myCharz().aT))) {
                                          this.b(var20);
                                          break label1177;
                                       }
                                    }
                                 } else if (this.g(var15, var4) || this.f(var15, var4)) {
                                    break label1177;
                                 }

                                 this.h(var15, var4);
                              }
                           }
                        }

                        if (main.GameCanvas.m) {
                           boolean var10001;
                           label1139: {
                              var15 = main.GameCanvas.o + cmx;
                              var4 = main.GameCanvas.p + cmy;
                              Char.myCharz();
                              IMapObject var18;
                              if ((var18 = this.e(var15, var4)) != null) {
                                 Char var21;
                                 if (Char.myCharz().I() && Char.myCharz().aU != null && !var18.equals(Char.myCharz().aU) && !var18.equals(Char.myCharz().aU.aR) && var18 instanceof Char && (var21 = (Char)var18).cTypePk != 5 && !var21.I()) {
                                    this.h(var15, var4);
                                 } else {
                                    if (Char.myCharz().aQ == var18 || Char.myCharz().aV == var18) {
                                       this.b(var18);
                                       var10001 = true;
                                       break label1139;
                                    }

                                    if (TileMap.l == 51 && var18.equals(Char.myCharz().aT)) {
                                       this.h(var15, var4);
                                    } else {
                                       if (Char.myCharz().skillPaint != null || Char.myCharz().arr != null || Char.myCharz().dart != null || Char.myCharz().D() != null) {
                                          var10001 = false;
                                          break label1139;
                                       }

                                       Char.myCharz().a((Object)var18);
                                       var18.stopMoving();
                                    }
                                 }
                              }

                              var10001 = false;
                           }

                           this.dJ = var10001;
                           this.aT = var17;
                           this.dN = cmx;
                           this.dO = cmy;
                           main.GameCanvas.m = false;
                        }
                     }
                  }
               }

               if (Char.myCharz().an != null && Char.myCharz().an.isPointerPressInside()) {
                  Char.myCharz().an.performAction();
               }

               if (Char.myCharz().skillPaint == null) {
                  if (Char.myCharz().statusMe == 1) {
                     if (main.GameCanvas.keyPressed[5]) {
                        main.GameCanvas.keyPressed[5] = false;
                        this.a(false, false);
                     } else if (main.GameCanvas.j[2]) {
                        if (!Char.myCharz().bJ) {
                           var14 = false;
                           if (Char.myCharz().cx - Char.myCharz().bD != 0 || Char.myCharz().cy - Char.myCharz().bE != 0) {
                              Service.gI().g();
                           }

                           Char.myCharz().E = -10;
                           Char.myCharz().D = 0;
                           Char.myCharz().statusMe = 3;
                           Char.myCharz().F = 0;
                        }
                     } else if (main.GameCanvas.j[4]) {
                        bi = false;
                        Char.myCharz().ar = false;
                        if (Char.myCharz().I == 1) {
                           Char.myCharz().I = -1;
                        } else if (!Char.myCharz().bJ) {
                           if (Char.myCharz().cx - Char.myCharz().bD != 0) {
                              Service.gI().g();
                           }

                           Char.myCharz().statusMe = 2;
                           Char.myCharz().D = -Char.myCharz().O;
                        }

                        Char.myCharz().cH = false;
                     } else if (main.GameCanvas.j[6]) {
                        bi = false;
                        Char.myCharz().ar = false;
                        if (Char.myCharz().I == -1) {
                           Char.myCharz().I = 1;
                        } else if (!Char.myCharz().bJ) {
                           if (Char.myCharz().cx - Char.myCharz().bD != 0) {
                              Service.gI().g();
                           }

                           Char.myCharz().statusMe = 2;
                           Char.myCharz().D = Char.myCharz().O;
                        }

                        Char.myCharz().cH = false;
                     }
                  } else if (Char.myCharz().statusMe == 2) {
                     if (main.GameCanvas.keyPressed[5]) {
                        main.GameCanvas.keyPressed[5] = false;
                        this.a(false, true);
                     } else if (main.GameCanvas.j[2]) {
                        if (Char.myCharz().cx - Char.myCharz().bD != 0 || Char.myCharz().cy - Char.myCharz().bE != 0) {
                           Service.gI().g();
                        }

                        Char.myCharz().E = -10;
                        Char.myCharz().statusMe = 3;
                        Char.myCharz().F = 0;
                     } else {
                        Char var23;
                        int var24;
                        if (main.GameCanvas.j[4]) {
                           bi = false;
                           if (Char.myCharz().I == 1) {
                              Char.myCharz().I = -1;
                           } else {
                              var23 = Char.myCharz();
                              var24 = -Char.myCharz().O;
                              Char.myCharz();
                              var23.D = var24;
                           }
                        } else if (main.GameCanvas.j[6]) {
                           bi = false;
                           if (Char.myCharz().I == -1) {
                              Char.myCharz().I = 1;
                           } else {
                              var23 = Char.myCharz();
                              var24 = Char.myCharz().O;
                              Char.myCharz();
                              var23.D = var24;
                           }
                        }
                     }
                  } else if (Char.myCharz().statusMe == 3) {
                     bi = false;
                     if (main.GameCanvas.keyPressed[5]) {
                        main.GameCanvas.keyPressed[5] = false;
                        this.a(false, true);
                     }

                     if (!main.GameCanvas.j[4] && (!main.GameCanvas.j[1] || this.aK != null)) {
                        if (main.GameCanvas.j[6] || main.GameCanvas.j[3] && this.aK == null) {
                           if (Char.myCharz().I == -1) {
                              Char.myCharz().I = 1;
                           } else {
                              Char.myCharz().D = Char.myCharz().O;
                           }
                        }
                     } else if (Char.myCharz().I == 1) {
                        Char.myCharz().I = -1;
                     } else {
                        Char.myCharz().D = -Char.myCharz().O;
                     }

                     if ((main.GameCanvas.j[2] || (main.GameCanvas.j[1] || main.GameCanvas.j[3]) && this.aK == null) && Char.myCharz().ao && Char.myCharz().cMP > 0 && Char.myCharz().F < 8 && Char.myCharz().E > -4) {
                        ++Char.myCharz().F;
                        Char.myCharz().E = -7;
                     }
                  } else if (Char.myCharz().statusMe == 4) {
                     if (main.GameCanvas.keyPressed[5]) {
                        main.GameCanvas.keyPressed[5] = false;
                        this.a(false, true);
                     }

                     if (main.GameCanvas.j[2] && Char.myCharz().cMP > 0 && Char.myCharz().ao) {
                        bi = false;
                        if ((Char.myCharz().cx - Char.myCharz().bD != 0 || Char.myCharz().cy - Char.myCharz().bE != 0) && (ResLog.g(Char.myCharz().cx - Char.myCharz().bD) > 96 || ResLog.g(Char.myCharz().cy - Char.myCharz().bE) > 24)) {
                           Service.gI().g();
                        }

                        Char.myCharz().E = -10;
                        Char.myCharz().statusMe = 3;
                        Char.myCharz().F = 0;
                     }

                     if (main.GameCanvas.j[4]) {
                        bi = false;
                        if (Char.myCharz().I == 1) {
                           Char.myCharz().I = -1;
                        } else {
                           ++Char.myCharz().F;
                           Char.myCharz().D = -Char.myCharz().O;
                           if (Char.myCharz().F > 5 && Char.myCharz().E > 6) {
                              Char.myCharz().statusMe = 10;
                              Char.myCharz().F = 0;
                              Char.myCharz().E = 0;
                           }
                        }
                     } else if (main.GameCanvas.j[6]) {
                        bi = false;
                        if (Char.myCharz().I == -1) {
                           Char.myCharz().I = 1;
                        } else {
                           ++Char.myCharz().F;
                           Char.myCharz().D = Char.myCharz().O;
                           if (Char.myCharz().F > 5 && Char.myCharz().E > 6) {
                              Char.myCharz().statusMe = 10;
                              Char.myCharz().F = 0;
                              Char.myCharz().E = 0;
                           }
                        }
                     }
                  } else if (Char.myCharz().statusMe == 10) {
                     if (main.GameCanvas.keyPressed[5]) {
                        main.GameCanvas.keyPressed[5] = false;
                        this.a(false, true);
                     }

                     if (Char.myCharz().ao && Char.myCharz().cMP > 0) {
                        if (main.GameCanvas.j[2]) {
                           bi = false;
                           if ((Char.myCharz().cx - Char.myCharz().bD != 0 || Char.myCharz().cy - Char.myCharz().bE != 0) && (ResLog.g(Char.myCharz().cx - Char.myCharz().bD) > 96 || ResLog.g(Char.myCharz().cy - Char.myCharz().bE) > 24)) {
                              Service.gI().g();
                           }

                           Char.myCharz().E = -10;
                           Char.myCharz().statusMe = 3;
                           Char.myCharz().F = 0;
                        } else if (main.GameCanvas.j[4]) {
                           bi = false;
                           if (Char.myCharz().I == 1) {
                              Char.myCharz().I = -1;
                           } else {
                              Char.myCharz().D = -(Char.myCharz().O + 1);
                           }
                        } else if (main.GameCanvas.j[6]) {
                           if (Char.myCharz().I == -1) {
                              Char.myCharz().I = 1;
                           } else {
                              Char.myCharz().D = Char.myCharz().O + 1;
                           }
                        }
                     }
                  } else if (Char.myCharz().statusMe == 7) {
                     if (main.GameCanvas.keyPressed[5]) {
                        main.GameCanvas.keyPressed[5] = false;
                     }

                     if (main.GameCanvas.j[4]) {
                        bi = false;
                        if (Char.myCharz().I == 1) {
                           Char.myCharz().I = -1;
                        } else {
                           Char.myCharz().D = -Char.myCharz().O + 2;
                        }
                     } else if (main.GameCanvas.j[6]) {
                        bi = false;
                        if (Char.myCharz().I == -1) {
                           Char.myCharz().I = 1;
                        } else {
                           Char.myCharz().D = Char.myCharz().O - 2;
                        }
                     }
                  }

                  if (main.GameCanvas.keyPressed[8] && main.GameCanvas.ae != 56) {
                     main.GameCanvas.keyPressed[8] = false;
                     Char.myCharz().bQ = 0;
                  }

                  if (main.GameCanvas.keyPressed[10]) {
                     main.GameCanvas.keyPressed[10] = false;
                     this.G();
                  }

                  if (main.GameCanvas.ae != 0) {
                     if (this.aK == null) {
                        if (TField.g) {
                           if (main.GameCanvas.ae == 113) {
                              if (aO[0] != null) {
                                 this.a(aO[0], true);
                              }
                           } else if (main.GameCanvas.ae == 119) {
                              if (aO[1] != null) {
                                 this.a(aO[1], true);
                              }
                           } else if (main.GameCanvas.ae == 101) {
                              if (aO[2] != null) {
                                 this.a(aO[2], true);
                              }
                           } else if (main.GameCanvas.ae == 114) {
                              if (aO[3] != null) {
                                 this.a(aO[3], true);
                              }
                           } else if (main.GameCanvas.ae == 116) {
                              if (aO[4] != null) {
                                 this.a(aO[4], true);
                              }
                           } else if (main.GameCanvas.ae != 50 && main.GameCanvas.ae != 53) {
                              ChatTextField.gI().a(main.GameCanvas.ae, this, "");
                           }
                        } else if (!main.GameCanvas.c) {
                           ChatTextField.gI().a(main.GameCanvas.ae, this, "");
                        } else if (main.GameCanvas.ae == 55) {
                           if (aO[0] != null) {
                              this.a(aO[0], true);
                           }
                        } else if (main.GameCanvas.ae == 56) {
                           if (aO[1] != null) {
                              this.a(aO[1], true);
                           }
                        } else if (main.GameCanvas.ae == 57) {
                           if (aO[2] != null) {
                              this.a(aO[2], true);
                           }
                        } else if (main.GameCanvas.ae == 49) {
                           if (aO[3] != null) {
                              this.a(aO[3], true);
                           }
                        } else if (main.GameCanvas.ae == 51) {
                           if (aO[4] != null) {
                              this.a(aO[4], true);
                           }
                        } else if (main.GameCanvas.ae == 48) {
                           ChatTextField.gI().a("");
                        }
                     } else {
                        var10 = this.br.toCharArray();
                        var2 = new MyVector("");

                        for(var15 = 0; var15 < var10.length; ++var15) {
                           var2.addElement(String.valueOf(var10[var15]));
                        }

                        var2.removeElementAt(0);
                        String var16;
                        if ((var16 = String.valueOf((char)main.GameCanvas.ae)).equals("") || var16 == null || var16.equals("\n")) {
                           var16 = "-";
                        }

                        var2.insertElementAt(var16, var2.size());
                        this.br = "";

                        for(var1 = 0; var1 < var2.size(); ++var1) {
                           this.br = this.br + ((String)var2.elementAt(var1)).toUpperCase();
                        }

                        Service.gI().a((char)main.GameCanvas.ae);
                     }

                     main.GameCanvas.ae = 0;
                  }

                  main.GameCanvas.clearKeyPressed();
               }
            }
         }
      }
   }

   private IMapObject e(int var1, int var2) {
      IMapObject var3 = null;
      int var4 = 0;
      MyVector[] var5 = new MyVector[]{F, G, vItemMap, vCharInMap};

      for(int var6 = 0; var6 < var5.length; ++var6) {
         for(int var7 = 0; var7 < var5[var6].size(); ++var7) {
            IMapObject var8;
            Mob var9;
            if (!(var8 = (IMapObject)var5[var6].elementAt(var7)).isInvisible() && (!(var8 instanceof Mob) || !(var9 = (Mob)var8).J || !var9.equals(Char.myCharz().aR))) {
               int var13 = var8.getX();
               int var10 = var8.getY();
               int var11 = var8.getW();
               int var12 = var8.getH();
               if (a(var1, var2, var13 - var11 / 2 - 30, var10 - var12 - 30, var11 + 60, var12 + 60)) {
                  if (var3 == null) {
                     var3 = var8;
                     var4 = ResLog.g(var1 - var13) + ResLog.g(var2 - var10);
                     if (var6 == 1) {
                        return var8;
                     }
                  } else if ((var13 = ResLog.g(var1 - var13) + ResLog.g(var2 - var10)) < var4) {
                     var3 = var8;
                     var4 = var13;
                  }
               }
            }
         }
      }

      return var3;
   }

   private static boolean a(int var0, int var1, int var2, int var3, int var4, int var5) {
      return var0 >= var2 && var0 <= var2 + var4 && var1 >= var3 && var1 <= var3 + var5;
   }

   private boolean a(IMapObject var1) {
      if (var1 == null) {
         return false;
      } else {
         int var3 = var1.getY();
         int var2 = Char.myCharz().cy;
         if (var3 < var2) {
            while(var3 < var2) {
               var2 -= 5;
               if (TileMap.a(Char.myCharz().cx, var2, 8192)) {
                  this.aW = 0;
                  Char.myCharz();
                  Char.myCharz().bP = null;
                  return true;
               }
            }
         }

         return false;
      }
   }

   private void b(IMapObject var1) {
      if (var1.equals(Char.myCharz().aT) || this.aK == null) {
         if (!this.a(var1)) {
            boolean var2 = false;
            if (var1 != null && this.ep <= 0) {
               this.ep = 10;
               int var4 = var1.getX();
               byte var5;
               if ((var4 = ResLog.g(Char.myCharz().cx - var4)) <= 80) {
                  var5 = 1;
               } else if (var4 > 80 && var4 <= 200) {
                  var5 = 2;
               } else if (var4 > 200 && var4 <= 400) {
                  var5 = 3;
               } else {
                  var5 = 4;
               }

               if (var1.equals(Char.myCharz().aQ) || var1.equals(Char.myCharz().aU) && Char.myCharz().c(Char.myCharz().aU)) {
                  ServerEffect.addServerEffect(135, var1.getX(), var1.getY(), var5);
               } else if (var1.equals(Char.myCharz().aT) || var1.equals(Char.myCharz().aV) || var1.equals(Char.myCharz().aU)) {
                  ServerEffect.addServerEffect(136, var1.getX(), var1.getY(), var5);
               }
            }

            Char.myCharz();
            Char.myCharz().bP = null;
            Char.myCharz().D = Char.myCharz().E = 0;
            var1.stopMoving();
            this.aW = 10;
            this.a(false, true);
            this.dL = var1.getX();
            this.dM = var1.getY();
            this.dK = false;
            this.aU = true;
         }
      }
   }

   private boolean f(int var1, int var2) {
      if (this.equals(aD) && gI().popUpYesNo != null) {
         return false;
      } else {
         if (aD.b.info != null && aD.b.info.c != null) {
            int var3 = ResLog.g(aD.d) + aD.b.g - 40;
            int var4 = ResLog.g(aD.c) + aD.b.h;
            if (a(var1 - cmx, var2 - cmy, var3, var4, 200, aD.b.j)) {
               boolean var5 = true;
               aD.g = 10;
               return true;
            }
         }

         return false;
      }
   }

   private boolean g(int var1, int var2) {
      for(int var3 = 0; var3 < PopUp.a.size(); ++var3) {
         PopUp var4 = (PopUp)PopUp.a.elementAt(var3);
         if (a(var1, var2, var4.d, var4.e, var4.f, var4.g)) {
            if (var4.e <= 24 && TileMap.f() && Char.myCharz().cTypePk != 0) {
               return false;
            }

            if (var4.j) {
               var4.a(10);
               return true;
            }
         }
      }

      return false;
   }

   private void h(int var1, int var2) {
      if (!dB.c()) {
         Char.myCharz();
         if (var1 < TileMap.c && var1 > TileMap.c - 32) {
            Char.myCharz().bP = new nr_dj(TileMap.c, var2);
         } else if (var1 < 32 && var1 > 0) {
            Char.myCharz().bP = new nr_dj(0, var2);
         } else {
            this.dL = var1;
            this.dM = var2;
            this.dK = false;
            Char.myCharz().bQ = 0;
            var1 = Char.myCharz().ao && Char.myCharz().cMP > 0 ? 0 : 1000;
            if (this.dM <= Char.myCharz().cy || ResLog.g(this.dL - Char.myCharz().cx) >= 12) {
               for(var2 = 0; var2 < var1 + 60 && this.dM + var2 < TileMap.d - 24; var2 += 24) {
                  if (TileMap.a(this.dL, this.dM + var2, 2)) {
                     this.dM = TileMap.e(this.dM + var2);
                     this.dK = true;
                     break;
                  }
               }

               for(var2 = 0; var2 < var1 + 40; var2 += 24) {
                  if (TileMap.a(this.dL, this.dM - var2, 2)) {
                     this.dM = TileMap.e(this.dM - var2);
                     this.dK = true;
                     break;
                  }
               }

               this.aU = true;
               Char.myCharz().bQ = 0;
               if (!this.dK && this.dM < Char.myCharz().cy - 50) {
                  Char.myCharz().bQ = 20;
               }

               this.aW = 0;
               if (Char.myCharz().cH) {
                  Char.myCharz().P();
               }

               Char.myCharz().bP = new nr_dj(this.dL, this.dM);
               Char.myCharz().I = Char.myCharz().cx - Char.myCharz().bP.a > 0 ? -1 : 1;
               Char.myCharz().ay = null;
               bi = false;
            }
         }
      }
   }

   private void G() {
      if (!Char.myCharz().cP) {
         if (!Char.myCharz().cM) {
            if (Char.myCharz().cG <= 0) {
               long var1;
               if ((var1 = System.currentTimeMillis()) - this.dQ >= 10000L) {
                  if (!Char.myCharz().M()) {
                     info1.a(mResources.aT, 0);
                  } else {
                     ServerEffect.a(11, (Char)Char.myCharz(), 5);
                     ServerEffect.a(104, (Char)Char.myCharz(), 4);
                     this.dQ = var1;
                     SoundMn.stopAll();
                  }
               }
            }
         }
      }
   }

   public final void b(int var1, int var2) {
      if (!this.dS) {
         SoundMn.stopAll();
         ResLog.c("ACTIVE SUPER POWER");
         this.dS = true;
         this.dT = 0;
         this.dW = 0;
         this.dU = var1 - cmx;
         this.dV = var2 - cmy;
      }

   }

   public final void a(boolean var1) {
      this.bc = true;
      this.aZ = true;
      this.dX = true;
      if (var1) {
         EffecMn.addEff(new Effect(20, Char.myCharz().cx, Char.myCharz().cy - 77, 2, 8, 1));
      }

   }

   public final void r() {
      this.bc = false;
      this.aZ = true;
      this.dX = false;
   }

   public final void s() {
      this.ba = true;
      this.bd = mGraphics.setColor(0.4F, 0, main.GameCanvas.ad[main.GameCanvas.ad.length - 1]);
   }

   public final void c(int var1, int var2) {
      ResLog.c("VE RONG THAN O VI TRI x= " + var1 + " y=" + var2);
      this.s();
      EffecMn.addEff(new Effect(this.bb ? 25 : 17, var1, var2 - 77, 2, -1, 1));
   }

   private void a(boolean var1, boolean var2) {
      if (Char.myCharz().aU != null && Char.myCharz().aU.cy >= Char.myCharz().cy + 48 && TileMap.a(Char.myCharz().cx, Char.myCharz().cy, 2)) {
         this.aW = 0;
         Char.myCharz().bP = null;
         Char.bH = false;
         Char.myCharz().bJ = false;
      } else {
         ResLog.c("do fire");
         ++dY;
         Waypoint var6 = Char.myCharz().i();
         Waypoint var3 = Char.myCharz().j();
         if (!var2 && var6 != null && (Char.myCharz().aQ == null || Char.myCharz().aQ != null && Char.myCharz().aQ.C == 0)) {
            var6.g.i.performAction();
         } else if (var2 || var3 == null || Char.myCharz().aQ != null && (Char.myCharz().aQ == null || Char.myCharz().aQ.C != 0)) {
            if (TileMap.l != 51 || Char.myCharz().aT == null) {
               if (Char.myCharz().statusMe != 14) {
                  Char.myCharz().D = Char.myCharz().E = 0;
                  if (Char.myCharz().w() && Char.myCharz().O()) {
                     if (this.F()) {
                        Char.myCharz();
                        Char.myCharz();
                        Char.A();
                     }
                  } else {
                     boolean var10000;
                     if (this.a((IMapObject)Char.myCharz().aU)) {
                        var10000 = false;
                     } else if (this.a((IMapObject)Char.myCharz().aQ)) {
                        var10000 = false;
                     } else if (this.a((IMapObject)Char.myCharz().aT)) {
                        var10000 = false;
                     } else if (ChatTextField.gI().b) {
                        var10000 = false;
                     } else {
                        label430: {
                           if (!InfoDlg.b) {
                              Char.myCharz();
                              if (!Char.bH) {
                                 if (Char.myCharz().myskill != null && Char.myCharz().myskill.template.id == 6 && Char.myCharz().aV != null) {
                                    this.H();
                                    var10000 = false;
                                 } else if (Char.myCharz().myskill != null && Char.myCharz().myskill.template.type == 2 && Char.myCharz().aT == null && Char.myCharz().myskill.template.id != 6) {
                                    var10000 = this.F();
                                 } else if (Char.myCharz().skillPaint != null || Char.myCharz().aQ == null && Char.myCharz().aT == null && Char.myCharz().aU == null && Char.myCharz().aV == null) {
                                    var10000 = false;
                                 } else {
                                    int var8;
                                    int var9;
                                    int var10;
                                    boolean var11;
                                    if (Char.myCharz().aQ != null) {
                                       if (Char.myCharz().aQ.isBigBoss() && Char.myCharz().aQ.p == 4) {
                                          Char.myCharz().aQ = null;
                                          Char.myCharz().bP = null;
                                       }

                                       bi = true;
                                       if (!a(Char.myCharz().aQ)) {
                                          var10000 = false;
                                          break label430;
                                       }

                                       if (this.aK != null) {
                                          var10000 = false;
                                          break label430;
                                       }

                                       if (Char.myCharz().myskill == null) {
                                          var10000 = false;
                                          break label430;
                                       }

                                       if (Char.myCharz().w()) {
                                          var10000 = false;
                                          break label430;
                                       }

                                       var8 = -1;
                                       var10 = ResLog.g(Char.myCharz().cx - cmx) * mGraphics.zoomLevel;
                                       if (Char.myCharz().aU != null) {
                                          var8 = ResLog.g(Char.myCharz().cx - Char.myCharz().aU.cx) * mGraphics.zoomLevel;
                                       } else if (Char.myCharz().aQ != null) {
                                          var8 = ResLog.g(Char.myCharz().cx - Char.myCharz().aQ.x) * mGraphics.zoomLevel;
                                       }

                                       if (Char.myCharz().aQ.p == 1 || Char.myCharz().aQ.p == 0 || Char.myCharz().myskill.template.type == 4 || var8 == -1 || var8 > var10) {
                                          if (Char.myCharz().myskill.template.type == 4) {
                                             if (Char.myCharz().aQ.x < Char.myCharz().cx) {
                                                Char.myCharz().I = -1;
                                             } else {
                                                Char.myCharz().I = 1;
                                             }

                                             this.a(Char.myCharz().myskill, true);
                                          }

                                          var10000 = false;
                                          break label430;
                                       }

                                       if (!this.F()) {
                                          var10000 = false;
                                          break label430;
                                       }

                                       if (Char.myCharz().cx < Char.myCharz().aQ.getX()) {
                                          Char.myCharz().I = 1;
                                       } else {
                                          Char.myCharz().I = -1;
                                       }

                                       var9 = Math.abs(Char.myCharz().cx - Char.myCharz().aQ.getX());
                                       var10 = Math.abs(Char.myCharz().cy - Char.myCharz().aQ.getY());
                                       Char.myCharz().D = 0;
                                       if (var9 > Char.myCharz().myskill.g || var10 > Char.myCharz().myskill.h) {
                                          boolean var13 = false;
                                          if (Char.myCharz().aQ instanceof BigBoss || Char.myCharz().aQ instanceof BigBoss2) {
                                             var13 = true;
                                          }

                                          var8 = (Char.myCharz().myskill.g - (var13 ? 50 : 20)) * (Char.myCharz().cx > Char.myCharz().aQ.getX() ? 1 : -1);
                                          if (var9 <= Char.myCharz().myskill.g) {
                                             var8 = 0;
                                          }

                                          Char.myCharz().bP = new nr_dj(Char.myCharz().aQ.getX() + var8, Char.myCharz().aQ.getY());
                                          Char.myCharz().ay = new CommandLine((String)null, (IActionListener)null, 8002, (Object)null);
                                          main.GameCanvas.f();
                                          main.GameCanvas.clearKeyPressed();
                                          var10000 = false;
                                          break label430;
                                       }

                                       if (Char.myCharz().myskill.template.id != 20) {
                                          if (var10 > var9 && ResLog.g(Char.myCharz().cy - Char.myCharz().aQ.getY()) > 30 && Char.myCharz().aQ.z().mobTemplateId == 4) {
                                             Char.myCharz().bP = new nr_dj(Char.myCharz().cx + Char.myCharz().I, Char.myCharz().aQ.getY());
                                             Char.myCharz().ay = new CommandLine((String)null, (IActionListener)null, 8002, (Object)null);
                                             main.GameCanvas.f();
                                             main.GameCanvas.clearKeyPressed();
                                             var10000 = false;
                                             break label430;
                                          }

                                          byte var12 = 20;
                                          var2 = false;
                                          if (Char.myCharz().aQ instanceof BigBoss || Char.myCharz().aQ instanceof BigBoss2) {
                                             var2 = true;
                                          }

                                          if (Char.myCharz().myskill.g > 100) {
                                             var12 = 60;
                                             if (var9 < 20) {
                                                Char.myCharz().a((int)Char.myCharz().cx, (int)Char.myCharz().cy, (int)10);
                                             }
                                          }

                                          ResLog.c("dt= " + var12);
                                          var11 = false;
                                          if ((TileMap.b(Char.myCharz().cx, Char.myCharz().cy + 3) & 2) == 2) {
                                             int var5 = Char.myCharz().cx > Char.myCharz().aQ.getX() ? 1 : -1;
                                             if ((TileMap.b(Char.myCharz().aQ.getX() + var12 * var5, Char.myCharz().cy + 3) & 2) != 2) {
                                                var11 = true;
                                             }
                                          }

                                          if (var9 <= var12 && !var11) {
                                             if (Char.myCharz().cx > Char.myCharz().aQ.getX()) {
                                                Char.myCharz().cx = Char.myCharz().aQ.getX() + var12 + (var2 ? 30 : 0);
                                                Char.myCharz().I = -1;
                                             } else {
                                                Char.myCharz().cx = Char.myCharz().aQ.getX() - var12 - (var2 ? 30 : 0);
                                                Char.myCharz().I = 1;
                                             }

                                             Service.gI().g();
                                          }

                                          main.GameCanvas.f();
                                          main.GameCanvas.clearKeyPressed();
                                       }
                                    } else {
                                       if (Char.myCharz().aT != null) {
                                          if (Char.myCharz().aT.de) {
                                             var10000 = false;
                                          } else {
                                             if (Char.myCharz().cx < Char.myCharz().aT.cx) {
                                                Char.myCharz().I = 1;
                                             } else {
                                                Char.myCharz().I = -1;
                                             }

                                             if (Char.myCharz().cx < Char.myCharz().aT.cx) {
                                                Char.myCharz().aT.I = -1;
                                             } else {
                                                Char.myCharz().aT.I = 1;
                                             }

                                             var8 = Math.abs(Char.myCharz().cx - Char.myCharz().aT.cx);
                                             if (Math.abs(Char.myCharz().cy - Char.myCharz().aT.cy) > 40) {
                                                Char.myCharz().cy = Char.myCharz().aT.cy - 40;
                                             }

                                             if (var8 < 60) {
                                                main.GameCanvas.f();
                                                main.GameCanvas.clearKeyPressed();
                                                if (this.di == 0) {
                                                   if (Char.myCharz().aD != null && Char.myCharz().aD.c == 0) {
                                                      if (Char.myCharz().aD.a < 4 && Char.myCharz().aT.template.npcTemplateId == 4) {
                                                         var10000 = false;
                                                         break label430;
                                                      }

                                                      if (Char.myCharz().aD.a < 3 && Char.myCharz().aT.template.npcTemplateId == 3) {
                                                         var10000 = false;
                                                         break label430;
                                                      }
                                                   }

                                                   this.di = 50;
                                                   InfoDlg.a();
                                                   Service.gI().g();
                                                   Service.gI().j(Char.myCharz().aT.template.npcTemplateId);
                                                }
                                             } else {
                                                var9 = (20 + ResLog.a.nextInt(20)) * (Char.myCharz().cx > Char.myCharz().aT.cx ? 1 : -1);
                                                Char.myCharz().bP = new nr_dj(Char.myCharz().aT.cx + var9, Char.myCharz().cy);
                                                Char.myCharz().ay = new CommandLine((String)null, (IActionListener)null, 8002, (Object)null);
                                                main.GameCanvas.f();
                                                main.GameCanvas.clearKeyPressed();
                                             }

                                             var10000 = false;
                                          }
                                          break label430;
                                       }

                                       if (Char.myCharz().aU != null) {
                                          if (this.aK != null) {
                                             var10000 = false;
                                             break label430;
                                          }

                                          if (Char.myCharz().cx < Char.myCharz().aU.cx) {
                                             Char.myCharz().I = 1;
                                          } else {
                                             Char.myCharz().I = -1;
                                          }

                                          var8 = Math.abs(Char.myCharz().cx - Char.myCharz().aU.cx);
                                          var10 = Math.abs(Char.myCharz().cy - Char.myCharz().aU.cy);
                                          if (!Char.myCharz().c(Char.myCharz().aU) && !Char.myCharz().y()) {
                                             if (var8 < 60 && var10 < 40) {
                                                Char.myCharz();
                                                this.E();
                                                if (!main.GameCanvas.isTouch && Char.myCharz().aU.charID >= 0 && TileMap.l != 51 && TileMap.l != 52 && this.popUpYesNo == null) {
                                                   main.GameCanvas.panel.a(Char.myCharz().aU);
                                                   main.GameCanvas.panel.show();
                                                   Service.gI().c(Char.myCharz().aU.charID);
                                                   Service.gI().x(Char.myCharz().aU.charID);
                                                }
                                             } else {
                                                var9 = (20 + ResLog.a.nextInt(20)) * (Char.myCharz().cx > Char.myCharz().aU.cx ? 1 : -1);
                                                Char.myCharz().bP = new nr_dj(Char.myCharz().aU.cx + var9, Char.myCharz().aU.cy);
                                                Char.myCharz().ay = new CommandLine((String)null, (IActionListener)null, 8002, (Object)null);
                                                main.GameCanvas.f();
                                                main.GameCanvas.clearKeyPressed();
                                             }

                                             var10000 = false;
                                             break label430;
                                          }

                                          if (Char.myCharz().myskill == null) {
                                             var10000 = false;
                                             break label430;
                                          }

                                          if (!this.F()) {
                                             var10000 = false;
                                             break label430;
                                          }

                                          if (Char.myCharz().cx < Char.myCharz().aU.cx) {
                                             Char.myCharz().I = 1;
                                          } else {
                                             Char.myCharz().I = -1;
                                          }

                                          Char.myCharz().D = 0;
                                          if (var8 > Char.myCharz().myskill.g || var10 > Char.myCharz().myskill.h) {
                                             var9 = (Char.myCharz().myskill.g - 20) * (Char.myCharz().cx > Char.myCharz().aU.cx ? 1 : -1);
                                             if (var8 <= Char.myCharz().myskill.g) {
                                                var9 = 0;
                                             }

                                             Char.myCharz().bP = new nr_dj(Char.myCharz().aU.cx + var9, Char.myCharz().aU.cy);
                                             Char.myCharz().ay = new CommandLine((String)null, (IActionListener)null, 8002, (Object)null);
                                             main.GameCanvas.f();
                                             main.GameCanvas.clearKeyPressed();
                                             var10000 = false;
                                             break label430;
                                          }

                                          if (Char.myCharz().myskill.template.id != 20) {
                                             byte var7 = 20;
                                             if (Char.myCharz().myskill.g > 60) {
                                                var7 = 60;
                                                if (var8 < 20) {
                                                   Char.myCharz().a((int)Char.myCharz().cx, (int)Char.myCharz().cy, (int)10);
                                                }
                                             }

                                             var11 = false;
                                             if ((TileMap.b(Char.myCharz().cx, Char.myCharz().cy + 3) & 2) == 2) {
                                                int var4 = Char.myCharz().cx > Char.myCharz().aU.cx ? 1 : -1;
                                                if ((TileMap.b(Char.myCharz().aU.cx + var7 * var4, Char.myCharz().cy + 3) & 2) != 2) {
                                                   var11 = true;
                                                }
                                             }

                                             if (var8 <= var7 && !var11) {
                                                if (Char.myCharz().cx > Char.myCharz().aU.cx) {
                                                   Char.myCharz().cx = Char.myCharz().aU.cx + var7;
                                                   Char.myCharz().I = -1;
                                                } else {
                                                   Char.myCharz().cx = Char.myCharz().aU.cx - var7;
                                                   Char.myCharz().I = 1;
                                                }

                                                Service.gI().g();
                                             }

                                             main.GameCanvas.f();
                                             main.GameCanvas.clearKeyPressed();
                                          }
                                       } else if (Char.myCharz().aV != null) {
                                          this.H();
                                          var10000 = false;
                                          break label430;
                                       }
                                    }

                                    var10000 = true;
                                 }
                                 break label430;
                              }
                           }

                           var10000 = false;
                        }
                     }

                     if (var10000) {
                        if (Char.myCharz().z() && Char.myCharz().O()) {
                           if (this.F()) {
                              Char.myCharz();
                              Char.myCharz().B();
                           } else {
                              Char.myCharz().C();
                           }
                        } else {
                           var1 = TileMap.a(Char.myCharz().cx, Char.myCharz().cy, 2);
                           Char.myCharz().a(u[Char.myCharz().myskill.b], var1 ? 0 : 1);
                           if (var1) {
                              Char.myCharz().bQ = 20;
                           }

                           Char.myCharz();
                        }
                     }
                  }

                  if (Char.myCharz().y()) {
                     this.aW = 0;
                  }
               }

            }
         } else {
            var3.g.i.performAction();
         }
      }
   }

   private void H() {
      if (Char.myCharz().aV != null) {
         if (Char.myCharz().cx < Char.myCharz().aV.a) {
            Char.myCharz().I = 1;
         } else {
            Char.myCharz().I = -1;
         }

         int var1 = Math.abs(Char.myCharz().cx - Char.myCharz().aV.a);
         int var2 = Math.abs(Char.myCharz().cy - Char.myCharz().aV.b);
         if (var1 <= 40 && var2 < 40) {
            main.GameCanvas.f();
            main.GameCanvas.clearKeyPressed();
            if (Char.myCharz().aV.template.a != 673) {
               Service.gI().l(Char.myCharz().aV.d);
               return;
            }

            Npc var4 = new Npc(5, 0, -100, 100, 5, info1.charId[Char.myCharz().cgender][2]);
            ResLog.c(Char.myCharz().aT != null ? "!null" : "null");
            String var5 = mResources.az;
            String[] var3 = new String[]{mResources.bm, mResources.bn};
            ResLog.c(Char.myCharz().aT != null ? "!null" : "null");
            var4.dh = 673;
            gI();
            a(var3, var4);
            ChatPopup.a(var5, 100000, var4, 5820);
            return;
         }

         Char.myCharz().bP = new nr_dj(Char.myCharz().aV.a, Char.myCharz().aV.b);
         Char.myCharz().ay = new CommandLine((String)null, (IActionListener)null, 8002, (Object)null);
         main.GameCanvas.f();
         main.GameCanvas.clearKeyPressed();
      }

   }

   private boolean I() {
      return Char.myCharz().ci || Char.myCharz().ch || Char.myCharz().cj || Char.myCharz().cE || this.dS || Char.myCharz().bk;
   }

   private void a(Skill var1, boolean var2) {
      if (!Char.myCharz().isCreateDark) {
         if (!this.I()) {
            if (Char.myCharz().aD.c > 1) {
               Char.myCharz().myskill = var1;
               if (this.ec != var1 && this.ec != null) {
                  Service.gI().selectSkill((int)var1.template.id);
                  this.q();
                  this.ec = var1;
                  this.eb = -1;
                  gI().aW = 0;
               } else if (Char.myCharz().x()) {
                  ResLog.c(">>>use skill spec: " + var1.template.id);
                  Char.myCharz().a((short)var1.template.id);
                  this.q();
                  this.ec = var1;
                  this.eb = -1;
                  gI().aW = 0;
               } else if (Char.myCharz().w()) {
                  ResLog.c("use skill not focus");
                  this.a(var1);
                  this.ec = var1;
               } else {
                  this.eb = -1;
                  if (var1 != null) {
                     ResLog.c("only select skill");
                     if (this.ec != var1) {
                        Service.gI().selectSkill((int)var1.template.id);
                        this.q();
                     }

                     if (Char.myCharz().aU == null && Char.myCharz().y()) {
                        ResLog.c("return o day");
                        return;
                     }

                     if (Char.myCharz().O()) {
                        this.a(true, true);
                     }

                     this.ec = var1;
                  }

               }
            }
         }
      }
   }

   private void b(Skill var1, boolean var2) {
      if (TileMap.l != 112 && TileMap.l != 113 || Char.myCharz().cTypePk != 0) {
         if (Char.myCharz().w()) {
            this.a(var1);
         } else {
            this.eb = -1;
            if (var1 != null) {
               Service.gI().selectSkill((int)var1.template.id);
               this.q();
               Char.myCharz().myskill = var1;
               this.a(var2, true);
            }

         }
      }
   }

   private void a(Skill var1) {
      if (TileMap.l != 112 && TileMap.l != 113 || Char.myCharz().cTypePk != 0) {
         if (this.F()) {
            this.eb = -1;
            if (var1 != null) {
               Service.gI().selectSkill((int)var1.template.id);
               this.q();
               Char.myCharz().myskill = var1;
               Char.myCharz();
               Char.A();
               Char.myCharz();
               this.aW = 0;
            }
         }

      }
   }

   public static void sortSkill() {
      for(int var0 = 0; var0 < Char.myCharz().vSkillFight.size() - 1; ++var0) {
         Skill var1 = (Skill)Char.myCharz().vSkillFight.elementAt(var0);

         for(int var2 = var0 + 1; var2 < Char.myCharz().vSkillFight.size(); ++var2) {
            Skill var3;
            if ((var3 = (Skill)Char.myCharz().vSkillFight.elementAt(var2)).template.id < var1.template.id) {
               Skill var4 = var3;
               var3 = var1;
               var1 = var4;
               Char.myCharz().vSkillFight.setElementAt(var4, var0);
               Char.myCharz().vSkillFight.setElementAt(var3, var2);
            }
         }
      }

   }

   public final void update() {
      if (main.GameCanvas.v % 100 == 0 && TileMap.l == 137) {
         bt = 30;
      }

      int var9;
      if (bi && main.GameCanvas.v % 20 == 0) {
         if (this.dZ > 0) {
            --this.dZ;
         }

         if (bj && !bk && Char.myCharz().statusMe != 14 && Char.myCharz().statusMe != 5 && !Char.myCharz().bl && !Char.myCharz().ci && !Char.myCharz().z()) {
            boolean var2 = false;

            int var3;
            for(var3 = 0; var3 < F.size(); ++var3) {
               Mob var4;
               if ((var4 = (Mob)F.elementAt(var3)).p != 0 && var4.p != 1) {
                  var2 = true;
               }
            }

            if (var2) {
               boolean var10 = false;

               int var11;
               for(var11 = 0; var11 < Char.myCharz().arrItemBag.length; ++var11) {
                  Item var7;
                  if ((var7 = Char.myCharz().arrItemBag[var11]) != null && var7.template.type == 6) {
                     var10 = true;
                     break;
                  }
               }

               if (!var10 && main.GameCanvas.v % 150 == 0) {
                  Service.gI().v();
               }

               if (Char.myCharz().cHP <= Char.myCharz().cHPFull * 20 / 100 || Char.myCharz().cMP <= Char.myCharz().cMPFull * 20 / 100) {
                  this.G();
               }

               if (Char.myCharz().aQ != null && (Char.myCharz().aQ == null || !Char.myCharz().aQ.J)) {
                  if (Char.myCharz().aQ.k <= 0 || Char.myCharz().aQ.p == 1 || Char.myCharz().aQ.p == 0) {
                     Char.myCharz().aQ = null;
                  }
               } else {
                  for(var11 = 0; var11 < F.size(); ++var11) {
                     Mob var8;
                     if ((var8 = (Mob)F.elementAt(var11)).p != 0 && var8.p != 1 && var8.k > 0 && !var8.J) {
                        Char.myCharz().cx = var8.x;
                        Char.myCharz().cy = var8.y;
                        Char.myCharz().aQ = var8;
                        Service.gI().g();
                        ResLog.c("focus 1 con bossssssssssssssssssssssssssssssssssssssssssssssssss");
                        break;
                     }
                  }
               }

               if (Char.myCharz().aQ != null && this.dZ == 0 && (Char.myCharz().D() == null || Char.myCharz().cb >= Char.myCharz().D().length || Char.myCharz().dart == null || Char.myCharz().arr == null)) {
                  Skill var12 = null;
                  if (main.GameCanvas.isTouch) {
                     for(var9 = 0; var9 < aP.length; ++var9) {
                        if (aP[var9] != null && !aP[var9].j && aP[var9].template.id != 10 && aP[var9].template.id != 11 && aP[var9].template.id != 14 && aP[var9].template.id != 23 && aP[var9].template.id != 7 && Char.myCharz().D() == null && !aP[var9].template.c()) {
                           if (aP[var9].template.d == 2) {
                              var3 = 1;
                           } else if (aP[var9].template.d != 1) {
                              var3 = aP[var9].i;
                           } else {
                              var3 = aP[var9].i * Char.myCharz().cMPFull / 100;
                           }

                           if (Char.myCharz().cMP >= var3) {
                              if (var12 == null) {
                                 var12 = aP[var9];
                              } else if (var12.e < aP[var9].e) {
                                 var12 = aP[var9];
                              }
                           }
                        }
                     }

                     if (var12 != null) {
                        this.a(var12, true);
                        this.b((IMapObject)Char.myCharz().aQ);
                     }
                  } else {
                     for(var9 = 0; var9 < aO.length; ++var9) {
                        if (aO[var9] != null && !aO[var9].j && aO[var9].template.id != 10 && aO[var9].template.id != 11 && aO[var9].template.id != 14 && aO[var9].template.id != 23 && aO[var9].template.id != 7 && Char.myCharz().D() == null) {
                           if (aO[var9].template.d == 2) {
                              var3 = 1;
                           } else if (aO[var9].template.d != 1) {
                              var3 = aO[var9].i;
                           } else {
                              var3 = aO[var9].i * Char.myCharz().cMPFull / 100;
                           }

                           if (Char.myCharz().cMP >= var3) {
                              if (var12 == null) {
                                 var12 = aO[var9];
                              } else if (var12.e < aO[var9].e) {
                                 var12 = aO[var9];
                              }
                           }
                        }
                     }

                     if (var12 != null) {
                        this.a(var12, true);
                        this.b((IMapObject)Char.myCharz().aQ);
                     }
                  }
               }
            }
         }
      }

      GameScr var1 = this;
      int var10002;
      if (this.ff != 0) {
         if ((ej = System.currentTimeMillis()) - ei > 1000L) {
            ei = System.currentTimeMillis();
            ++ek;
         }

         if (ek > 20) {
            for(var9 = 0; var9 < var1.eY.length; ++var9) {
               var1.eZ[var9] = var1.eY[var9];
            }

            --var1.ff;
            if (var1.ff == 0) {
               var1.fj = "";
               info1.a(var1.fe, 0);
               ek = 0;
            }
         } else if (this.fd > this.eY.length - 1) {
            --this.ff;
            if (this.ff == 0) {
               this.fj = "";
               info1.a(this.fe, 0);
            }
         } else {
            if (this.fd < this.eZ.length) {
               if (this.fa[this.fd] == 15) {
                  if (this.eZ[this.fd] == this.eY[this.fd] - 1) {
                     this.fc[this.fd] = 10;
                  }

                  if (this.eZ[this.fd] == this.eY[this.fd]) {
                     this.fa[this.fd] = -1;
                     ++this.fd;
                  }
               } else if (main.GameCanvas.v % 5 == 0) {
                  var10002 = this.fa[this.fd]++;
               }
            }

            for(var9 = 0; var9 < var1.eY.length; ++var9) {
               if (var1.fa[var9] != -1) {
                  var10002 = var1.fb[var9]++;
                  if (var1.fb[var9] > var1.fa[var9] + var1.fc[var9]) {
                     var1.fb[var9] = 0;
                     var10002 = var1.eZ[var9]++;
                     if (var1.eZ[var9] >= 10) {
                        var1.eZ[var9] = 0;
                     }
                  }
               }
            }
         }
      }

      SmallImage.update();
      ++this.dA;
      if (this.dA == 100) {
         this.dA = 0;
      }

      try {
         if (LoginScr.c) {
            LoginScr.c = false;
         }

         if (L == 1) {
            eg = System.currentTimeMillis();
         }

         int var6;
         if (L == 100) {
            L = 0;
            var6 = (int)((eh = System.currentTimeMillis()) - eg) / 1000;
            Service.gI().g(var6);
         }

         if (z > 0 && --z == 0) {
            Controller.b = false;
         }

         if (!a) {
            if (cmx != l || cmy != m) {
               cq = l - cmx << 2;
               cr = m - cmy << 2;
               co += cq;
               cmx += co >> 4;
               co &= 15;
               cp += cr;
               cmy += cp >> 4;
               cp &= 15;
               if (cmx < 24) {
                  cmx = 24;
               }

               if (cmx > n) {
                  cmx = n;
               }

               if (cmy < 0) {
                  cmy = 0;
               }

               if (cmy > cs) {
                  cmy = cs;
               }
            }

            if ((o = cmx / TileMap.i - 1) < 0) {
               o = 0;
            }

            p = cmy / TileMap.i;
            q = o + cj;
            r = p + ck;
            if (p < 0) {
               p = 0;
            }

            if (r > TileMap.b - 1) {
               r = TileMap.b - 1;
            }

            if ((TileMap.B = (Char.myCharz().cx - 2 * d) / TileMap.i) < 0) {
               TileMap.B = 0;
            }

            if ((TileMap.C = TileMap.B + TileMap.F) > TileMap.a) {
               TileMap.B = (TileMap.C = TileMap.a) - TileMap.F;
            }

            if ((TileMap.D = (Char.myCharz().cy - 2 * e) / TileMap.i) < 0) {
               TileMap.D = 0;
            }

            if ((TileMap.E = TileMap.D + TileMap.G) > TileMap.b) {
               TileMap.D = (TileMap.E = TileMap.b) - TileMap.G;
            }

            cx.b();
            cw.b();
         }

         ChatTextField.gI().c();

         for(var6 = 0; var6 < vCharInMap.size(); ++var6) {
            ((Char) vCharInMap.elementAt(var6)).a();
         }

         for(var6 = 0; var6 < Teleport.vTeleport.size(); ++var6) {
            ((Teleport) Teleport.vTeleport.elementAt(var6)).a();
         }

         Char.myCharz().a();
         if (Char.myCharz().statusMe == 1 && main.GameCanvas.v % 100 == 0) {
            System.gc();
         }

         if (this.popUpYesNo != null) {
            this.popUpYesNo.a();
         }

         EffecMn.a();

         for(var6 = 0; var6 < F.size(); ++var6) {
            ((Mob)F.elementAt(var6)).update();
         }

         for(var6 = 0; var6 < G.size(); ++var6) {
            ((Npc)G.elementAt(var6)).a();
         }

         this.ea = aP.length;

         for(var6 = aP.length - 1; var6 >= 0; --var6) {
            if (aP[var6] != null) {
               this.ea = var6 + 1;
               break;
            }

            --this.ea;
         }

         if (this.ea == 1 && main.GameCanvas.isTouch) {
            ez = -200;
         } else if (ez < 0) {
            p();
         }

         main.GameCanvas.a().i();

         int[] var10000;
         for(var6 = 0; var6 < 5; ++var6) {
            if (bH[var6] != -1) {
               if (bH[var6] > eE[var6]) {
                  var10002 = eH[var6]++;
                  if (eH[var6] == 25) {
                     eH[var6] = 0;
                     bH[var6] = -1;
                     eE[var6] = 0;
                     eF[var6] = 0;
                     bF[var6] = 0;
                  }
               } else {
                  var10000 = bH;
                  var10000[var6] += ResLog.g(eG[var6]);
                  var10000 = bF;
                  var10000[var6] += eF[var6];
                  var10000 = bG;
                  var10000[var6] += eG[var6];
               }
            }
         }

         PopUp.b();

         for(var6 = 0; var6 < 2; ++var6) {
            if (eK[var6] != -1) {
               var10002 = eK[var6]++;
               var10000 = eI;
               var10000[var6] += eM[var6] << 2;
               var10002 = eJ[var6]--;
               if (eK[var6] >= 6) {
                  eK[var6] = -1;
               } else {
                  eL[var6] = (eK[var6] >> 1) % 3;
               }
            }
         }

         if (eS != eT) {
            eV = eT - eS << 2;
            eU += eV;
            eS += eU >> 4;
            eU &= 15;
         }

         if (Math.abs(eT - eS) < 15 && eS < 0) {
            eT = 0;
         }

         if (Math.abs(eT - eS) < 15 && eS > 0) {
            eT = 0;
         }

         if (this.ep > 0) {
            --this.ep;
         }

         if (this.aU) {
            this.aU = false;
            IMapObject var13;
            if ((var13 = this.e(this.dL, this.dM)) == null || var13 != null && var13.equals(Char.myCharz().aT) && TileMap.l == 51) {
               ServerEffect.addServerEffect(134, this.dL, this.dM + main.GameCanvas.ac / 2, 3);
            }
         }

         for(var6 = 0; var6 < vItemMap.size(); ++var6) {
            ((ItemMap) vItemMap.elementAt(var6)).a();
         }

         for(var6 = Effect2.vRemoveEff2.size() - 1; var6 >= 0; --var6) {
            Effect2.vEffect2.removeElement(Effect2.vRemoveEff2.elementAt(var6));
            Effect2.vRemoveEff2.removeElementAt(var6);
         }

         for(var6 = 0; var6 < Effect2.vEffect2.size(); ++var6) {
            ((Effect2)Effect2.vEffect2.elementAt(var6)).update();
         }

         for(var6 = 0; var6 < Effect2.vEffect2Out.size(); ++var6) {
            ((Effect2)Effect2.vEffect2Out.elementAt(var6)).update();
         }

         for(var6 = 0; var6 < Effect2.vAnimate.size(); ++var6) {
            ((Effect2)Effect2.vAnimate.elementAt(var6)).update();
         }

         for(var6 = 0; var6 < Effect2.vEffectFeet.size(); ++var6) {
            ((Effect2)Effect2.vEffectFeet.elementAt(var6)).update();
         }

         for(var6 = 0; var6 < Effect2.vEffect3.size(); ++var6) {
            ((Effect2)Effect2.vEffect3.elementAt(var6)).update();
         }

         BackgroudEffect.c();
         info1.a();
         aD.a();
         if (currentCharViewInfo != null && !currentCharViewInfo.equals(Char.myCharz())) {
            currentCharViewInfo.a();
         }

         ++this.el;
         if (this.el > 3) {
            this.el = 0;
         }

         if (this.bD) {
            ++this.bC;
            if (this.bC == 20) {
               this.bC = 0;
               this.bD = false;
            }
         } else if (this.dHP > Char.myCharz().cHP) {
            if ((var9 = this.dHP - Char.myCharz().cHP >> 1) <= 0) {
               var9 = 1;
            }

            this.dHP -= var9;
         } else {
            this.dHP = Char.myCharz().cHP;
         }

         if (this.bA) {
            ++this.bz;
            if (this.bz == 20) {
               this.bz = 0;
               this.bA = false;
            }
         } else if (this.dMP > Char.myCharz().cMP) {
            if ((var9 = this.dMP - Char.myCharz().cMP >> 1) <= 0) {
               var9 = 1;
            }

            this.dMP -= var9;
         } else {
            this.dMP = Char.myCharz().cMP;
         }

         if (this.di > 0) {
            --this.di;
         }

         if (this.u()) {
            while(this.bf - 100 < cmy) {
               --cmy;
            }
         }

         for(var6 = 0; var6 < Char.vItemTime.size(); ++var6) {
            ((ItemTime)Char.vItemTime.elementAt(var6)).a();
         }

         for(var6 = 0; var6 < bu.size(); ++var6) {
            ((ItemTime)bu.elementAt(var6)).a();
         }

         if (this.fi) {
            this.fg -= 2;
            if (this.fg < -this.fh) {
               this.fg = main.GameCanvas.z;
               eX.removeElementAt(0);
               if (eX.size() == 0) {
                  this.bQ = false;
                  this.fi = false;
               } else {
                  this.fh = mFont.c.getWidth((String)eX.elementAt(0));
               }
            }
         }
      } catch (Exception var5) {
         var5.printStackTrace();
      }

      if (main.GameCanvas.v % 4000 == 1000) {
         ImgByName.a(ImgByName.a, 10);
      }

      nr_df.a();
   }

   public final boolean u() {
      return this.dX;
   }

   private static void d(mGraphics var0) {
      int var1;
      for(var1 = 0; var1 < Effect2.vEffect2.size(); ++var1) {
         Effect2 var2;
         if ((var2 = (Effect2)Effect2.vEffect2.elementAt(var1)) != null && !(var2 instanceof ChatPopup)) {
            var2.paint(var0);
         }
      }

      if (!main.GameCanvas.a) {
         for(var1 = 0; var1 < Effect2.vAnimate.size(); ++var1) {
            ((Effect2)Effect2.vAnimate.elementAt(var1)).paint(var0);
         }
      }

      for(var1 = 0; var1 < Effect2.vEffect2Out.size(); ++var1) {
         ((Effect2)Effect2.vEffect2Out.elementAt(var1)).paint(var0);
      }

   }

   public static void a(mGraphics var0, int var1) {
      int var2;
      for(var2 = 0; var2 < TileMap.v.size(); ++var2) {
         nr_cx var3;
         if ((var3 = (nr_cx)TileMap.v.elementAt(var2)).c != -1 && var3.h == var1) {
            var3.a(var0);
         }
      }

      if (TileMap.l == 48 && var1 == 3 && main.GameCanvas.P != null && main.GameCanvas.P[0] != 0) {
         for(var2 = 0; var2 < TileMap.c / main.GameCanvas.P[0] + 1; ++var2) {
            var0.drawImage(main.GameCanvas.N[0], var2 * main.GameCanvas.P[0], TileMap.d - main.GameCanvas.Q[0] - 70, 0);
         }
      }

   }

   public static void b(mGraphics var0) {
      if (!main.GameCanvas.a) {
         var0.setColor(dR, 0, 0, main.GameCanvas.z, main.GameCanvas.A);
      }
   }

   public final void paint(mGraphics var1) {
      aM = 0;
      if (bs) {
         if (this.aY || this.aZ && ChatPopup.currChatPopup == null) {
            ++this.aX;
            if (this.aX < 30 && this.aX >= 0 && main.GameCanvas.v % 4 == 0 || this.aX >= 30 && this.aX <= 50 && main.GameCanvas.v % 3 == 0 || this.aX > 50) {
               var1.setColor(16777215);
               var1.fillRect(0, 0, main.GameCanvas.z, main.GameCanvas.A);
               if (this.aX > 50) {
                  if (this.aZ) {
                     this.aZ = false;
                     this.aX = 0;
                     if (this.bc) {
                        this.c(this.be, this.bf);
                     } else {
                        this.ba = false;
                        EffecMn.a(17);
                        if (this.bb) {
                           this.bb = false;
                           EffecMn.a(25);
                        }
                     }
                  }

                  this.g(var1);
                  var1.setColor(-cmx, -cmy);
                  var1.setColor(0, main.GameCanvas.ac);
                  Char.myCharz().a(var1);
                  mSystem.a(var1);
                  c(var1);
                  this.h(var1);
                  return;
               }

               return;
            }
         }

         main.GameCanvas.paintBackground(var1);
         int var3;
         if (mSystem.d == 5) {
            if (fr != null) {
               var1.setColor(16777215);
               var1.fillRect(0, 0, main.GameCanvas.z, main.GameCanvas.A);
               var1.drawImage(fr, main.GameCanvas.z / 2, main.GameCanvas.A / 2, 3);
            } else {
               var3 = TileMap.bgID % 2 == 0 ? 2 : 1;
               fr = mSystem.load("/bg/bg_ios_" + var3 + ".png");
            }
         }

         if ((this.ba || this.bQ) && TileMap.bgID != 3) {
            b(var1);
         }

         if (bt > 0) {
            var1.setColor(-cmx + en[bt % en.length], -cmy + eo[bt % eo.length]);
            --bt;
         } else {
            var1.setColor(-cmx, -cmy);
         }

         if (this.dS) {
            var3 = main.GameCanvas.v % 3 == 0 ? 3 : -3;
            var1.setColor(var3, 0);
         }

         BackgroudEffect.c(var1);
         EffecMn.a(var1);
         TileMap.a(var1);
         TileMap.b(var1);

         int var2;
         Char var17;
         for(var2 = 0; var2 < vCharInMap.size(); ++var2) {
            if ((var17 = (Char) vCharInMap.elementAt(var2)).ck && TileMap.l == 128) {
               var17.b(var1, var17.cx, var17.cy, 0);
            }
         }

         if (Char.myCharz().ck && TileMap.l == 128) {
            Char.myCharz().b(var1, Char.myCharz().cx, Char.myCharz().cy, 0);
         }

         a(var1, 2);
         if (Char.myCharz().an != null && main.GameCanvas.isTouch) {
            if (mScreen.cf == 20) {
               var1.drawImage(dm, Char.myCharz().an.x + cmx, Char.myCharz().an.y + cmy, 3);
            } else {
               var1.drawImage(dl, Char.myCharz().an.x + cmx, Char.myCharz().an.y + cmy, 3);
            }
         }

         BackgroudEffect.f(var1);
         nr_df.a.a(var1);

         for(var2 = 0; var2 < Effect2.vEffectFeet.size(); ++var2) {
            ((Effect2)Effect2.vEffectFeet.elementAt(var2)).paint(var1);
         }

         for(var2 = 0; var2 < Teleport.vTeleport.size(); ++var2) {
            ((Teleport) Teleport.vTeleport.elementAt(var2)).a(var1);
         }

         Npc var18;
         for(var2 = 0; var2 < G.size(); ++var2) {
            if ((var18 = (Npc)G.elementAt(var2)).cHP > 0) {
               var18.c(var1);
            }
         }

         for(var2 = 0; var2 < G.size(); ++var2) {
            ((Npc)G.elementAt(var2)).a(var1);
         }

         var1.setColor(0, main.GameCanvas.ac);

         for(var2 = 0; var2 < vCharInMap.size(); ++var2) {
            var17 = null;

            try {
               var17 = (Char) vCharInMap.elementAt(var2);
            } catch (Exception var16) {
            }

            if (var17 != null && (!main.GameCanvas.panel.isShow || !main.GameCanvas.panel.isTypeShop()) && var17.bd) {
               var17.c(var1);
            }
         }

         Char.myCharz().c(var1);
         EffecMn.b(var1);

         for(var2 = 0; var2 < F.size(); ++var2) {
            ((Mob)F.elementAt(var2)).a(var1);
         }

         for(var2 = 0; var2 < Teleport.vTeleport.size(); ++var2) {
            ((Teleport) Teleport.vTeleport.elementAt(var2)).b(var1);
         }

         for(var2 = 0; var2 < vCharInMap.size(); ++var2) {
            var17 = null;

            try {
               var17 = (Char) vCharInMap.elementAt(var2);
            } catch (Exception var15) {
            }

            if (var17 != null && (!main.GameCanvas.panel.isShow || !main.GameCanvas.panel.isTypeShop())) {
               var17.a(var1);
            }
         }

         Char.myCharz().a(var1);
         if (Char.myCharz().skillPaint != null && Char.myCharz().D() != null && Char.myCharz().cb < Char.myCharz().D().length) {
            Char.myCharz().d(var1);
            Char.myCharz().b(var1);
         }

         for(var2 = 0; var2 < vCharInMap.size(); ++var2) {
            var17 = null;

            try {
               var17 = (Char) vCharInMap.elementAt(var2);
            } catch (Exception var14) {
            }

            if (var17 != null && (!main.GameCanvas.panel.isShow || !main.GameCanvas.panel.isTypeShop()) && var17.skillPaint != null && var17.D() != null && var17.cb < var17.D().length) {
               var17.d(var1);
               var17.b(var1);
            }
         }

         for(var2 = 0; var2 < vItemMap.size(); ++var2) {
            ((ItemMap) vItemMap.elementAt(var2)).a(var1);
         }

         var1.setColor(0, -main.GameCanvas.ac);
         i(var1);
         d(var1);
         a(var1, 3);

         for(var2 = 0; var2 < G.size(); ++var2) {
            ((Npc)G.elementAt(var2)).e(var1);
         }

         EffecMn.c(var1);

         for(var2 = 0; var2 < G.size(); ++var2) {
            if ((var18 = (Npc)G.elementAt(var2)) != null && var18.z != null) {
               var18.z.a(var1, var18.cx, var18.cy - var18.al - main.GameCanvas.ac, var18.I);
            }
         }

         for(var2 = 0; var2 < vCharInMap.size(); ++var2) {
            var17 = null;

            try {
               var17 = (Char) vCharInMap.elementAt(var2);
            } catch (Exception var13) {
            }

            if (var17 != null && var17.z != null) {
               var17.z.a(var1, var17.cx, var17.cy - var17.al, var17.I);
            }
         }

         if (Char.myCharz().z != null) {
            Char.myCharz().z.a(var1, Char.myCharz().cx, Char.myCharz().cy - Char.myCharz().al, Char.myCharz().I);
         }

         nr_df.c.a(var1);
         nr_df.b.a(var1);
         BackgroudEffect.d(var1);

         for(var3 = 0; var3 < TileMap.v.size(); ++var3) {
            nr_cx var4;
            if ((var4 = (nr_cx)TileMap.v.elementAt(var3)).c != -1 && var4.h > 3) {
               var4.a(var1);
            }
         }

         PopUp.a(var1);
         if (TileMap.l == 120) {
            if (this.bR != 100) {
               var3 = this.bR * mGraphics.setColor(dz) / 100;
               var1.drawImage(dz, TileMap.c / 2 - mGraphics.setColor(dz) / 2, 220, 0);
               var1.e(TileMap.c / 2 - mGraphics.setColor(dz) / 2, 220, var3, 10);
               var1.drawImage(dx, TileMap.c / 2 - mGraphics.setColor(dz) / 2, 220, 0);
               var1.e(0, 0, main.GameCanvas.z, main.GameCanvas.A);
            }

            if (this.bS) {
               ++this.bT;
               if (main.GameCanvas.v % 3 == 0) {
                  EffecMn.addEff(new Effect(19, ResLog.random(TileMap.c / 2 - 50, TileMap.c / 2 + 50), 340, 2, 1, -1));
               }

               if (main.GameCanvas.v % 15 == 0) {
                  EffecMn.addEff(new Effect(18, ResLog.random(TileMap.c / 2 - 5, TileMap.c / 2 + 5), ResLog.random(300, 320), 2, 1, -1));
               }

               if (this.bT == 100) {
                  this.b(TileMap.c / 2, 300);
               }

               if (this.bT == 110) {
                  this.bT = 0;
                  this.bS = false;
               }
            }
         }

         BackgroudEffect.a(var1);
         boolean var24 = true;

         for(var2 = 0; var2 < BackgroudEffect.a.size(); ++var2) {
            if (((BackgroudEffect) BackgroudEffect.a.elementAt(var2)).b == 0) {
               var24 = false;
               break;
            }
         }

         if (mGraphics.zoomLevel <= 1) {
            var24 = false;
         }

         int var5;
         int var19;
         if (var24 && !this.ba) {
            if ((var19 = TileMap.c / (mGraphics.setColor(TileMap.A) + 50)) <= 0) {
               var19 = 1;
            }

            if (TileMap.e != 28) {
               for(var2 = 0; var2 < var19; ++var2) {
                  var5 = 100 + var2 * (mGraphics.setColor(TileMap.A) + 50) - cmx / 2;
                  var3 = mGraphics.setColor(TileMap.A);
                  if (var5 + var3 >= cmx && var5 <= cmx + main.GameCanvas.z && -20 + mGraphics.b(TileMap.A) >= cmy && -20 <= cmy + main.GameCanvas.A) {
                     var1.drawImage(TileMap.A, 100 + var2 * (mGraphics.setColor(TileMap.A) + 50) - cmx / 2, -20, 0);
                  }
               }
            }
         }

         mSystem.a(var1);
         f(var1);
         if (!a && bm == 1 && !main.GameCanvas.panel.isShow) {
            this.g(var1);
         }

         c(var1);
         j(var1);
         if (!a) {
            if (main.GameCanvas.al) {
               if (main.GameCanvas.z > 250) {
                  var1.drawImage(main.GameCanvas.af, 160, 6, 0);
                  mFont.s.drawStringBd(var1, "Dành cho người chơi trên 12 tuổi.", 180, 2, 0);
                  mFont.s.drawStringBd(var1, "Chơi quá 180 phút mỗi ngày ", 180, 12, 0);
                  mFont.s.drawStringBd(var1, "sẽ hại sức khỏe.", 180, 22, 0);
               } else {
                  var1.drawImage(main.GameCanvas.af, 5, main.GameCanvas.A - 67, 0);
                  mFont.s.drawStringBd(var1, "Dành cho người chơi trên 12 tuổi.", 25, main.GameCanvas.A - 70, 0);
                  mFont.s.drawStringBd(var1, "Chơi quá 180 phút mỗi ngày sẽ hại sức khỏe.", 25, main.GameCanvas.A - 60, 0);
               }
            }

            var1.setColor(-var1.setColor(), -var1.b());
            if ((TileMap.l == 128 || TileMap.l == 127) && bV != 0) {
               var1.setColor(0);
               var1.fillRect(3, 88, 54, 8);
               var1.setColor(16711680);
               var1.e(5, 90, bV, 4);
               var1.fillRect(5, 90, 50, 4);
               var1.e(0, 0, 3000, 3000);
               mFont.c.drawString(var1, "Mabu", 30, 98, 2, mFont.tahoma_7b_dark);
            }

            if (Char.myCharz().cJ) {
               ++Char.myCharz().cK;
               if (main.GameCanvas.v % 3 == 0) {
                  var1.setColor(16777215);
                  var1.fillRect(0, 0, main.GameCanvas.z, main.GameCanvas.A);
               }

               if (Char.myCharz().cK >= 100) {
                  Char.myCharz().U();
               }
            }

            for(var2 = 0; var2 < vCharInMap.size(); ++var2) {
               Char var20 = null;

               try {
                  var20 = (Char) vCharInMap.elementAt(var2);
               } catch (Exception var12) {
               }

               if (var20 != null && var20.cJ && Char.a(var20)) {
                  ++var20.cK;
                  if (main.GameCanvas.v % 3 == 0) {
                     var1.setColor(16777215);
                     var1.fillRect(0, 0, main.GameCanvas.z, main.GameCanvas.A);
                  }

                  if (var20.cK >= 100) {
                     var20.U();
                  }
               }
            }

            c(var1);
            this.h(var1);
            c(var1);
            if (main.GameCanvas.isTouch && main.GameCanvas.f && !this.L()) {
               c(var1);
               if (!TileMap.d() && !this.x()) {
                  if (mScreen.cf == 15) {
                     var1.drawImage(dm, er + 17, es + 17, 3);
                  } else {
                     var1.drawImage(dl, er + 17, es + 17, 3);
                  }
               }
            }

            c(var1);
            if (eX.size() != 0 && bU) {
               var1.e(0, main.GameCanvas.A - 13, main.GameCanvas.z, 15);
               var1.setColor(0, main.GameCanvas.A - 13, main.GameCanvas.z, 15, 0);
               String var25 = (String)eX.elementAt(0);
               mFont.e.drawStringBd(var1, var25, this.fg, main.GameCanvas.A - 12, 0);
            }

            if (!main.GameCanvas.panel.isShow && main.GameCanvas.currentDialog == null && ChatPopup.currChatPopup == null && ChatPopup.serverChatPopUp == null && main.GameCanvas.currentScreen.equals(c)) {
               super.paint(var1);
            }

            c(var1);
            var19 = 100 + (Char.vItemTime.size() != 0 ? bu.size() * 12 : 0);
            if (Char.myCharz().clan != null) {
               var5 = 0;
               int var6 = 0;
               var3 = (main.GameCanvas.A - 100 - 60) / 12;

               for(var2 = 0; var2 < vCharInMap.size(); ++var2) {
                  Char var7;
                  if ((var7 = (Char) vCharInMap.elementAt(var2)).ah != -1 && var7.ah == Char.myCharz().clan.a) {
                     if (var7.F() && var7.cx < Char.myCharz().cx) {
                        int var8 = var3;
                        if (Char.vItemTime.size() != 0) {
                           var8 = var3 - bu.size();
                        }

                        if (var5 <= var8) {
                           mFont.r.drawString(var1, var7.cName, 20, var19 - 12 + var5 * 12, 0, mFont.o);
                           var7.a(var1, 10, var19 + var5 * 12 - 5);
                           ++var5;
                        }
                     } else if (var7.F() && var7.cx > Char.myCharz().cx && var6 <= var3) {
                        mFont.r.drawString(var1, var7.cName, main.GameCanvas.z - 25, var19 - 12 + var6 * 12, 1, mFont.o);
                        var7.a(var1, main.GameCanvas.z - 15, var19 + var6 * 12 - 5);
                        ++var6;
                     }
                  }
               }
            }

            ChatTextField.gI().a(var1);
            if (aV && !main.GameCanvas.panel.isShow && main.GameCanvas.v % 4 == 0) {
               var1.drawImage(ItemMap.myTexture2dflare, this.aQ.x + 15, this.aQ.y + 30, 33);
            }

            if (this.dS) {
               this.dW += 5;
               if (this.dT >= 0) {
                  this.dT += this.dW;
               }

               if (this.dT < 0) {
                  --this.dT;
                  if (this.dT == -20) {
                     this.dS = false;
                     this.dT = 0;
                     this.dW = 0;
                  }
               } else if ((this.dU - this.dT > 0 || this.dT < TileMap.c) && this.dT > 0) {
                  var1.setColor(16777215);
                  if (!main.GameCanvas.a && mSystem.d != 3 && mSystem.d != 5) {
                     var1.setColor(this.dU - this.dT, this.dV - this.dT, 2 * this.dT, 2 * this.dT, 0, 360);
                  } else {
                     var1.fillRect(0, 0, main.GameCanvas.z, main.GameCanvas.A);
                  }
               } else {
                  this.dT = -1;
               }
            }

            for(var2 = 0; var2 < Char.vItemTime.size(); ++var2) {
               ItemTime var27 = (ItemTime)Char.vItemTime.elementAt(var2);
               int var10002 = this.aQ.x + 32 + var2 * 24;
               boolean var22 = true;
               var3 = var10002;
               ItemTime var10 = var27;
               SmallImage.b(var1, var10.a, var3, 55, 0, 3);
               String var21 = var10.c + "'";
               if (var10.c == 0) {
                  var21 = var10.b + "s";
               }

               mFont.c.drawString(var1, var21, var3, 70, 2, mFont.tahoma_7b_dark);
            }

            for(var2 = 0; var2 < bu.size(); ++var2) {
               ((ItemTime)bu.elementAt(var2)).a(var1, this.aQ.x + (Char.vItemTime.size() != 0 ? 5 : 25), (Char.vItemTime.size() != 0 ? 90 : 45) + var2 * 12);
            }

            this.e(var1);
            if (mResources.language == 1) {
               long var23 = mSystem.currentTimeMillis() - deltaTime;
               mFont var28 = mFont.c;
               Calendar var26;
               (var26 = Calendar.getInstance()).setTime(new Date(var23 + 25200000L));
               var19 = var26.get(11);
               var5 = var26.get(12);
               var28.drawString(var1, var19 + "h" + var5 + "m", 10, main.GameCanvas.A - 65, 0, mFont.tahoma_7b_dark);
            }

            if (!this.fj.equals("")) {
               for(var2 = 0; var2 < this.fk.length; ++var2) {
                  mFont.c.drawString(var1, this.fk[var2], 5, 85 + var2 * 18, 0, mFont.tahoma_7b_dark);
               }
            }
         }

         if ((var5 = main.GameCanvas.B) > 200) {
            var5 = 200;
         }

         a(var1, 0 + main.GameCanvas.z / 2, 0, var5);
         nr_df.d.a(var1);
      }
   }

   private void e(mGraphics var1) {
      if (this.ff != 0) {
         String var2 = "";

         for(int var3 = 0; var3 < this.eY.length; ++var3) {
            var2 = var2 + this.eZ[var3] + " ";
         }

         PopUp.paintPopUp(var1, 20, 45, 95, 35, 16777215, false);
         mFont.tahoma_7b_dark.drawStringBd(var1, mResources.n, 68, 50, 2);
         mFont.tahoma_7b_dark.drawStringBd(var1, var2, 68, 65, 2);
      }

   }

   public static Npc a(short var0) {
      for(int var1 = 0; var1 < G.size(); ++var1) {
         Npc var2;
         if ((var2 = (Npc)G.elementAt(var1)).template.npcTemplateId == var0) {
            return var2;
         }
      }

      return null;
   }

   public static Char findCharInMap(int var0) {
      for(int var1 = 0; var1 < vCharInMap.size(); ++var1) {
         Char var2;
         if ((var2 = (Char) vCharInMap.elementAt(var1)).charID == var0) {
            return var2;
         }
      }

      return null;
   }

   public static Mob c(int var0) {
      for(int var1 = 0; var1 < F.size(); ++var1) {
         Mob var2;
         if ((var2 = (Mob)F.elementAt(var1)).mobId == var0) {
            return var2;
         }
      }

      return null;
   }

   public static Mob a(byte var0) {
      return (Mob)F.elementAt(var0);
   }

   public static Npc v() {
      for(int var0 = 0; var0 < G.size(); ++var0) {
         Npc var1;
         if ((var1 = (Npc)G.elementAt(var0)).template.npcTemplateId == A()) {
            return var1;
         }
      }

      return null;
   }

   private static void f(mGraphics var0) {
      try {
         if (ChatPopup.currChatPopup == null) {
            byte var1;
            if ((var1 = A()) != -1) {
               Npc var2 = null;

               int var3;
               for(var3 = 0; var3 < G.size(); ++var3) {
                  Npc var4;
                  if ((var4 = (Npc)G.elementAt(var3)).template.npcTemplateId == var1) {
                     if (var2 == null) {
                        var2 = var4;
                     } else if (ResLog.g(var4.cx - Char.myCharz().cx) < ResLog.g(var2.cx - Char.myCharz().cx)) {
                        var2 = var4;
                     }
                  }
               }

               if (var2 != null && var2.statusMe != 15) {
                  if (var2.cx <= cmx || var2.cx >= cmx + d || var2.cy <= cmy || var2.cy >= cmy + e) {
                     if (main.GameCanvas.v % 10 >= 5) {
                        var3 = var2.cx - Char.myCharz().cx;
                        int var9 = var2.cy - Char.myCharz().cy;
                        int var7 = 0;
                        int var8 = 0;
                        byte var5 = 0;
                        if (var3 > 0 && var9 >= 0) {
                           if (ResLog.g(var3) >= ResLog.g(var9)) {
                              var7 = d - 10;
                              var8 = e / 2 + 30;
                              if (main.GameCanvas.isTouch) {
                                 var8 = e / 2 + 10;
                              }

                              var5 = 0;
                           } else {
                              var7 = d / 2;
                              var8 = e - 10;
                              var5 = 5;
                           }
                        } else if (var3 >= 0 && var9 < 0) {
                           if (ResLog.g(var3) >= ResLog.g(var9)) {
                              var7 = d - 10;
                              var8 = e / 2 + 30;
                              if (main.GameCanvas.isTouch) {
                                 var8 = e / 2 + 10;
                              }

                              var5 = 0;
                           } else {
                              var7 = d / 2;
                              var8 = 10;
                              var5 = 6;
                           }
                        }

                        if (var3 < 0 && var9 >= 0) {
                           if (ResLog.g(var3) >= ResLog.g(var9)) {
                              var7 = 10;
                              var8 = e / 2 + 30;
                              if (main.GameCanvas.isTouch) {
                                 var8 = e / 2 + 10;
                              }

                              var5 = 3;
                           } else {
                              var7 = d / 2;
                              var8 = e - 10;
                              var5 = 5;
                           }
                        } else if (var3 <= 0 && var9 < 0) {
                           if (ResLog.g(var3) >= ResLog.g(var9)) {
                              var7 = 10;
                              var8 = e / 2 + 30;
                              if (main.GameCanvas.isTouch) {
                                 var8 = e / 2 + 10;
                              }

                              var5 = 3;
                           } else {
                              var7 = d / 2;
                              var8 = 10;
                              var5 = 6;
                           }
                        }

                        c(var0);
                        var0.setColor(bv, 0, 0, 13, 16, var5, var7, var8, StaticObj.f);
                     }
                  }
               }
            }
         }
      } catch (Exception var6) {
      }
   }

   public static void c(mGraphics var0) {
      var0.setColor(-var0.setColor(), -var0.b());
      var0.e(0, -200, main.GameCanvas.z, 200 + main.GameCanvas.A);
   }

   private void a(mGraphics var1, Char var2) {
      int var3 = (int)((long)var2.cHP * eQ / (long)var2.cHPFull);
      int var4 = var2.cMP * eP;
      int var6 = (int)((long)this.dHP * eQ / (long)var2.cHPFull);
      int var5 = this.dMP * eP;
      var1.e(main.GameCanvas.z / 2 + 58 - mGraphics.setColor(dv), 0, 95, 100);
      var1.b(dv, 0, 0, mGraphics.setColor(dv), mGraphics.b(dv), 2, main.GameCanvas.z / 2 + 60, 0, 24);
      var1.e((int)((long)(main.GameCanvas.z / 2 + 60 - 83) - eQ + eQ - (long)var6), 5, var6, 10);
      var1.drawImage(dz, main.GameCanvas.z / 2 + 60 - 83, 5, 24);
      var1.e(0, 0, main.GameCanvas.z, main.GameCanvas.A);
      var1.e((int)((long)(main.GameCanvas.z / 2 + 60 - 83) - eQ + eQ - (long)var3), 5, var3, 10);
      var1.drawImage(dx, main.GameCanvas.z / 2 + 60 - 83, 5, 24);
      var1.e(0, 0, main.GameCanvas.z, main.GameCanvas.A);
      var1.e((int)((long)(main.GameCanvas.z / 2 + 60 - 83 - eP) + eQ - (long)var5), 20, var5, 6);
      var1.drawImage(aF, main.GameCanvas.z / 2 + 60 - 83, 20, 24);
      var1.e(0, 0, main.GameCanvas.z, main.GameCanvas.A);
      var1.e((int)((long)(main.GameCanvas.z / 2 + 60 - 83 - eP) + eQ - (long)var4), 20, var4, 6);
      var1.drawImage(aE, main.GameCanvas.z / 2 + 60 - 83, 20, 24);
      var1.e(0, 0, main.GameCanvas.z, main.GameCanvas.A);
   }

   private void a(mGraphics var1, boolean var2, Char var3) {
      if (var3 != null) {
         int var4;
         int var5;
         int var7;
         if (var3.charID == Char.myCharz().charID) {
            var7 = (int)((long)this.dHP * eQ / (long)var3.cHPFull);
            var4 = this.dMP * eP / var3.cMPFull;
            var5 = (int)((long)var3.cHP * eQ / (long)var3.cHPFull);
         } else {
            var7 = (int)((long)var3.cR * eQ / (long)var3.cHPFull);
            var4 = var3.cQ * eP / 100;
            var5 = (int)((long)var3.cHP * eQ / (long)var3.cHPFull);
         }

         if (Char.myCharz().bN > 0) {
            int var6 = Char.myCharz().bL * eO / Char.myCharz().bM;
            var1.drawImage(dw, 58, 29, 0);
            var1.e(83, 31, var6, 10);
            var1.drawImage(dy, 83, 31, 0);
            var1.e(0, 0, main.GameCanvas.z, main.GameCanvas.A);
            mFont.s.drawStringBd(var1, Char.myCharz().bK + ":" + Char.myCharz().bL + "/" + Char.myCharz().bM, 115, 29, 2);
         }

         if (var3.charID != Char.myCharz().charID) {
            var1.e(mGraphics.setColor(dv) - 95, 0, 95, 100);
         }

         var1.drawImage(dv, 0, 0, 0);
         var1.e(83, 5, var7, 10);
         var1.drawImage(dz, 83, 5, 0);
         var1.e(0, 0, main.GameCanvas.z, main.GameCanvas.A);
         var1.e(83, 5, var5, 10);
         var1.drawImage(dx, 83, 5, 0);
         var1.e(0, 0, main.GameCanvas.z, main.GameCanvas.A);
         var1.e(83, 20, var4, 6);
         var1.drawImage(aF, 83, 20, 0);
         var1.e(0, 0, main.GameCanvas.z, main.GameCanvas.A);
         var1.e(83, 20, var4, 6);
         var1.drawImage(aE, 83, 20, 0);
         var1.e(0, 0, main.GameCanvas.z, main.GameCanvas.A);
         if (Char.myCharz().cMP == 0 && main.GameCanvas.v % 10 > 5) {
            var1.e(83, 20, 2, 6);
            var1.drawImage(aF, 83, 20, 0);
            var1.e(0, 0, main.GameCanvas.z, main.GameCanvas.A);
         }

      }
   }

   public final void w() {
      this.eB = this.eC = System.currentTimeMillis();
      this.eD = 180;
   }

   private static Char J() {
      for(int var0 = 0; var0 < vCharInMap.size(); ++var0) {
         Char var1;
         if ((var1 = (Char) vCharInMap.elementAt(var0)).cTypePk != 0) {
            return var1;
         }
      }

      return null;
   }

   private Char K() {
      for(int var1 = 0; var1 < vCharInMap.size(); ++var1) {
         Char var2;
         if ((var2 = (Char) vCharInMap.elementAt(var1)).cTypePk != 0 && var2 != J()) {
            return var2;
         }
      }

      return null;
   }

   private void g(mGraphics var1) {
      if (!Char.isLoadingMap) {
         c(var1);
         if (TileMap.l == 130 && J() != null && this.K() != null) {
            var1.setColor(main.GameCanvas.z / 2 - 62, 0);
            this.a(var1, true, J());
            var1.setColor(-(main.GameCanvas.z / 2 - 65), 0);
            this.a(var1, this.K());
            J().b(var1, 137, 25, 0);
            this.K().b(var1, main.GameCanvas.z - 15 - 122, 25, 2);
         } else if (this.x() && Char.myCharz().aU != null) {
            var1.setColor(main.GameCanvas.z / 2 - 62, 0);
            this.a(var1, true, Char.myCharz().aU);
            var1.setColor(-(main.GameCanvas.z / 2 - 65), 0);
            this.a(var1, Char.myCharz());
            Char.myCharz().b(var1, 137, 25, 0);
            Char.myCharz().aU.b(var1, main.GameCanvas.z - 15 - 122, 25, 2);
         } else if (M() && main.GameCanvas.z <= 320) {
            Char var3 = Char.myCharz();
            boolean var2 = true;
            var2 = true;
            var1.drawImage(fq, 1, 1, 0);
            int var5 = fl.getWidth();
            int var6 = fl.getHeight() / 2;
            int var4;
            if ((var4 = var3.cHP * var5 / var3.cHPFull) <= 0) {
               var4 = 1;
            } else if (var4 > var5) {
               var4 = var5;
            }

            var1.setColor(fl, 0, var6, var4, var6, 0, 4, 20, 0);
            if ((var4 = var3.cMP * var5 / var3.cMPFull) <= 0) {
               var4 = 1;
            } else if (var4 > var5) {
               var4 = var5;
            }

            var1.setColor(fl, 0, 0, var4, var6, 0, 4, 26, 0);
            var4 = 1 + fq.getWidth() / 2 + 1;
            mFont.m.drawStringBd(var1, var3.cName, var4, 5, 2);
            if (var3.aQ != null) {
               if (var3.aQ.z() != null) {
                  mFont.m.drawStringBd(var1, var3.aQ.z().type, var4, 33, 2);
               }
            } else if (var3.aT != null) {
               mFont.m.drawStringBd(var1, var3.aT.template.name, var4, 33, 2);
            } else if (var3.aU != null) {
               mFont.m.drawStringBd(var1, var3.aU.cName, var4, 33, 2);
            }
         } else {
            this.a(var1, true, Char.myCharz());
            if (Char.myCharz().i() == null && Char.myCharz().j() == null) {
               int var10003;
               if (Char.myCharz().aQ != null) {
                  if (Char.myCharz().aQ.z() != null) {
                     var10003 = this.eR / 2;
                     mFont.m.drawStringBd(var1, Char.myCharz().aQ.z().type, var10003, 9, 2);
                  }

                  if (Char.myCharz().aQ.C != 0) {
                     mFont.m.drawStringBd(var1, Util.a((long)Char.myCharz().aQ.k), this.eR / 2, 22, 2);
                  }
               } else if (Char.myCharz().aT != null) {
                  var10003 = this.eR / 2;
                  mFont.m.drawStringBd(var1, Char.myCharz().aT.template.name, var10003, 9, 2);
                  if (Char.myCharz().aT.template.npcTemplateId == 4) {
                     mFont.m.drawStringBd(var1, gI().aL.b + "/" + gI().aL.d, this.eR / 2, 22, 2);
                  }
               } else if (Char.myCharz().aU != null) {
                  var10003 = this.eR / 2;
                  mFont.m.drawStringBd(var1, Char.myCharz().aU.cName, var10003, 9, 2);
                  mFont.m.drawStringBd(var1, Util.a((long)Char.myCharz().aU.cHP), this.eR / 2, 22, 2);
               } else {
                  var10003 = this.eR / 2;
                  mFont.m.drawStringBd(var1, Char.myCharz().cName, var10003, 9, 2);
                  mFont.m.drawStringBd(var1, Util.a(Char.myCharz().cPower), this.eR / 2, 22, 2);
               }
            } else {
               mFont.m.drawStringBd(var1, mResources.bw, this.eR / 2, 8, 2);
            }
         }

         var1.setColor(-var1.setColor(), -var1.b());
         if (this.x() && this.eD > 0) {
            this.eB = System.currentTimeMillis();
            if (this.eB - this.eC >= 1000L) {
               this.eC = System.currentTimeMillis();
               --this.eD;
            }

            mFont.c.drawString(var1, String.valueOf(this.eD), main.GameCanvas.z / 2, 13, 2, mFont.tahoma_7b_dark);
         }

         if (this.ed) {
            var1.drawImage(ItemMap.myTexture2dflare, 40, 35, 33);
            --this.ee;
            if (this.ee < 0) {
               this.ee = 0;
               this.ed = false;
            }
         }

      }
   }

   public final boolean x() {
      return TileMap.a() && (Char.myCharz().cTypePk != 0 || TileMap.l == 130 && J() != null && this.K() != null);
   }

   private void h(mGraphics var1) {
      int var7;
      if (this.aK != null) {
         mGraphics var24 = var1;
         GameScr var23 = this;
         MobCapcha.a(var1, Char.myCharz().cx, Char.myCharz().cy);
         var1.setColor(-var1.setColor(), -var1.b());
         if (!main.GameCanvas.menu.a && !main.GameCanvas.panel.isShow && ChatPopup.currChatPopup == null && main.GameCanvas.isTouch) {
            for(var7 = 0; var7 < var23.bl.length(); ++var7) {
               int var8 = (main.GameCanvas.z - var23.bl.length() * em) / 2 + var7 * em + em / 2;
               if (var23.bp[var7] == -1) {
                  var24.drawImage(bn, var8, main.GameCanvas.A - 25, 3);
                  mFont.tahoma_7b_dark.drawStringBd(var24, String.valueOf(var23.bl.charAt(var7)), var8, main.GameCanvas.A - 30, 2);
               } else {
                  var24.drawImage(bo, var8, main.GameCanvas.A - 25, 3);
                  mFont.g.drawStringBd(var24, String.valueOf(var23.bl.charAt(var7)), var8, main.GameCanvas.A - 30, 2);
               }
            }
         }

      } else if (main.GameCanvas.currentDialog == null && ChatPopup.currChatPopup == null && !main.GameCanvas.menu.a && !main.GameCanvas.panel.isShow && Char.myCharz().aD.c != 0 && !ChatTextField.gI().b && main.GameCanvas.currentScreen != MoneyCharge.a) {
         long var4 = mSystem.currentTimeMillis() - this.dQ;
         int var2 = 0;
         if (var4 < 10000L) {
            var2 = (int)(var4 * 20L / 10000L);
         }

         if (!main.GameCanvas.isTouch) {
            var1.drawImage(mScreen.cf == 10 ? au : at, ez + bw - 1, bx - 1, 0);
            SmallImage.b(var1, 542, ez + bw + 3, bx + 3, 0, 0);
            mFont.u.drawStringBd(var1, "" + hpPotion, ez + bw + 22, bx + 15, 1);
            if (var4 < 10000L) {
               var1.setColor(2721889);
               var2 = (int)(var4 * 20L / 10000L);
               var1.fillRect(ez + bw + 3, bx + 3 + var2, 20, 20 - var2);
            }
         } else if (Char.myCharz().statusMe != 14) {
            if (dB.b) {
               if (aN != 1) {
                  var1.setColor(9670800);
                  var1.fillRect(bw + 9, bx + 10, 22, 20);
                  var1.setColor(16777215);
                  var1.fillRect(bw + 9, bx + 10 + (var2 != 0 ? 20 - var2 : 0), 22, var2 != 0 ? var2 : 20);
                  var1.drawImage(mScreen.cf == 10 ? dq : dp, bw, bx, 0);
                  mFont.p.drawStringBd(var1, "" + hpPotion, bw + 20, bx + 15, 2);
               } else if (aN == 1) {
                  var1.drawImage(mScreen.cf == 10 ? au : at, ez + bw - 1, bx - 1, 0);
                  SmallImage.b(var1, 542, ez + bw + 3, bx + 3, 0, 0);
                  mFont.u.drawStringBd(var1, "" + hpPotion, ez + bw + 22, bx + 13, 1);
                  if (var4 < 10000L) {
                     var1.setColor(2721889);
                     var2 = (int)(var4 * 20L / 10000L);
                     var1.fillRect(ez + bw + 3, bx + 3 + var2, 20, 20 - var2);
                  }
               }
            } else if (aN != 1) {
               var1.setColor(9670800);
               var1.fillRect(bw + 9, bx + 10 - 6, 22, 20);
               var1.setColor(16777215);
               var1.fillRect(bw + 9, bx + 10 + (var2 != 0 ? 20 - var2 : 0) - 6, 22, var2 != 0 ? var2 : 20);
               var1.drawImage(mScreen.cf == 10 ? dq : dp, bw, bx - 6, 0);
               mFont.p.drawStringBd(var1, "" + hpPotion, bw + 20, bx + 15 - 6, 2);
            } else {
               var1.setColor(9670800);
               var1.fillRect(bw + 10, bx + 10 - 6, 20, 18);
               var1.setColor(16777215);
               var1.fillRect(bw + 10, bx + 10 + (var2 != 0 ? 20 - var2 : 0) - 6, 20, var2 != 0 ? var2 : 18);
               var1.drawImage(mScreen.cf == 10 ? ds : dr, bw + 20, bx + 20 - 6, 3);
               mFont.p.drawStringBd(var1, "" + hpPotion, bw + 20, bx + 15 - 6, 2);
            }
         }

         if (N) {
            Skill[] var19 = main.GameCanvas.isTouch ? aP : aO;
            if (!main.GameCanvas.isTouch) {
               var1.setColor(11152401);
               var1.fillRect(ez + bw + 2, bx - 10 + 6, 20, 10);
               mFont.s.drawStringBd(var1, "*", ez + bw + 12, bx - 8 + 6, 2);
            }

            int var3 = main.GameCanvas.isTouch ? this.ea : var19.length;

            for(int var20 = 0; var20 < var3; ++var20) {
               if (!main.GameCanvas.isTouch) {
                  String[] var5 = TField.g ? new String[]{"Q", "W", "E", "R", "T"} : new String[]{"7", "8", "9", "1", "3"};
                  var1.setColor(11152401);
                  var1.fillRect(ez + ex[var20] + 2, ey[var20] - 10 + 8, 20, 10);
                  mFont.s.drawStringBd(var1, var5[var20], ez + ex[var20] + 12, ey[var20] - 10 + 6, 2);
               }

               Skill var21;
               if ((var21 = var19[var20]) != Char.myCharz().myskill) {
                  var1.drawImage(at, ez + ex[var20] - 1, ey[var20] - 1, 0);
               }

               if (var21 != null) {
                  if (var21 == Char.myCharz().myskill) {
                     var1.drawImage(au, ez + ex[var20] - 1, ey[var20] - 1, 0);
                     if (main.GameCanvas.isTouch) {
                        var1.setColor(Mob.R, 0, 12, 9, 6, 0, ez + ex[var20] + 8, ey[var20] - 7, 0);
                     }
                  }

                  int var10001 = ez + ex[var20] + 13;
                  var7 = ey[var20] + 13;
                  int var6 = var10001;
                  SmallImage.b(var1, var21.template.f, var6, var7, 0, StaticObj.f);
                  long var17;
                  if ((var17 = System.currentTimeMillis() - var21.f) < (long)var21.e) {
                     var1.setColor(2721889);
                     if (var21.j && main.GameCanvas.v % 6 > 2) {
                        var1.setColor(876862);
                     }

                     int var22 = (int)(var17 * 20L / (long)var21.e);
                     var1.fillRect(var6 - 10, var7 - 10 + var22, 20, 20 - var22);
                  } else {
                     var21.j = false;
                  }

                  if (var20 == this.eb && main.GameCanvas.v % 10 > 5 || var20 == this.ef) {
                     var1.drawImage(ItemMap.myTexture2dflare, ez + ex[var20] + 13, ey[var20] + 14, 3);
                  }
               }
            }
         }

         if (aN != 0 && Char.myCharz().statusMe != 14) {
            var1.drawImage(mScreen.cf == 5 ? du : dt, et + 20, eu + 20, 3);
            dB.a(var1);
            var1.drawImage(mScreen.cf == 13 ? _do : dn, ev + 20, ew + 20, 3);
         }

      }
   }

   public static final void a(String var0, int var1, int var2, int var3, int var4, int var5) {
      var3 = -1;

      int var6;
      for(var6 = 0; var6 < 5; ++var6) {
         if (bH[var6] == -1) {
            var3 = var6;
            break;
         }
      }

      if (var3 != -1) {
         bI[var3] = var5;
         bE[var3] = var0;
         bF[var3] = var1;
         bG[var3] = var2;
         eF[var3] = 0;
         eG[var3] = var4 < 0 ? -5 : 5;
         bH[var3] = 0;
         eH[var3] = 0;
         eE[var3] = 10;

         for(var6 = 0; var6 < 5; ++var6) {
            if (bH[var6] != -1 && var3 != var6 && eG[var3] < 0 && ResLog.g(bF[var3] - bF[var6]) <= 20 && eE[var3] == eE[var6]) {
               int[] var10000 = eE;
               var10000[var3] += 10;
            }
         }

      }
   }

   public static final boolean a(int var0, int var1, int var2) {
      int var3 = eK[0] == -1 ? 0 : 1;
      if (eK[var3] != -1) {
         return false;
      } else {
         eK[var3] = 0;
         eM[var3] = var2;
         eI[var3] = var0;
         eJ[var3] = var1;
         return true;
      }
   }

   private static void i(mGraphics var0) {
      for(int var1 = 0; var1 < 2; ++var1) {
         if (eK[var1] != -1) {
            if (eM[var1] == 1) {
               var0.drawImage(eN[eL[var1]], eI[var1], eJ[var1], 3);
            } else {
               var0.setColor(eN[eL[var1]], 0, 0, mGraphics.setColor(eN[eL[var1]]), mGraphics.b(eN[eL[var1]]), 2, eI[var1], eJ[var1], 3);
            }
         }
      }

   }

   private boolean L() {
      if (!main.GameCanvas.f && main.GameCanvas.currentScreen == gI()) {
         return true;
      } else if (!main.GameCanvas.isTouch) {
         return true;
      } else if (ChatTextField.gI().b) {
         return true;
      } else if (InfoDlg.a) {
         return true;
      } else {
         return main.GameCanvas.currentDialog != null || ChatPopup.currChatPopup != null || main.GameCanvas.menu.a || main.GameCanvas.panel.isShow;
      }
   }

   public static void d(int var0, int var1) {
      if (main.GameCanvas.z == 128 || main.GameCanvas.A <= 208) {
         var0 = 126;
         var1 = 160;
      }

      bL = var0;
      bM = var1;
      bK = f - var0 / 2;
      bJ = cm - var1 / 2;
      if (main.GameCanvas.isTouch) {
         if (main.GameCanvas.A <= 240) {
            bJ -= 10;
         }

         if (main.GameCanvas.isTouch && !main.GameCanvas.g && main.GameCanvas.currentScreen instanceof GameScr) {
            bL = 310;
            bK = d / 2 - bL / 2;
         }
      }

      if (bJ < -10) {
         bJ = -10;
      }

      if (main.GameCanvas.A > 208 && bJ < 0) {
         bJ = 0;
      }

      if (main.GameCanvas.A == 208 && bJ < 10) {
         bJ = 10;
      }

   }

   public static void loadImg() {
      TileMap.e();
   }

   public static int z() {
      int var0;
      if (Char.myCharz().aD == null) {
         var0 = -1;
      } else {
         var0 = ac[Char.myCharz().aD.a];
      }

      return var0;
   }

   public static byte A() {
      byte var0 = 0;
      if (Char.myCharz().aD == null) {
         var0 = -1;
      } else {
         int var10001 = ab.length;
         if (Char.myCharz().aD.a <= var10001 - 1) {
            var0 = (byte)ab[Char.myCharz().aD.a];
         }
      }

      return var0;
   }

   public final void onChatFromMe(String var1, String var2) {
      ChatTextField.gI().b = false;
      if (var2.equals(mResources.cP)) {
         if (aD.h != Char.myCharz().charID) {
            Service.gI().a(var1, aD.h);
         }
      } else if (!var1.equals("")) {
         if (var1.equals("pingABCD")) {
            Service.gI().sendCheckController();
            Service.gI().sendCheckMap();
            bO = !bO;
         }

         if (var1.equals("icon")) {
            ResLog.b = !ResLog.b;
         }

         if (var1.equals("big")) {
            ResLog.c = !ResLog.c;
         }

         Service.gI().b(var1);
      }
   }

   public final void onCancelChat() {
   }

   public final void a(Message var1) {
      InfoDlg.hide();

      try {
         this.R = new int[var1.reader().readByte()];
         this.S = new int[this.R.length];
         this.T = new int[this.R.length];
         this.U = new int[this.R.length];
         this.V = new int[this.R.length];
         this.X = new String[this.R.length];
         this.W = new int[this.R.length];
         this.Y = new String[this.R.length];

         for(int var2 = 0; var2 < this.R.length; ++var2) {
            this.R[var2] = var1.reader().readByte();
            this.S[var2] = var1.reader().readByte();
            this.T[var2] = var1.reader().readByte();
            this.U[var2] = var1.reader().readByte();
            if (var1.reader().readByte() == 1) {
               this.X[var2] = var1.reader().readUTF();
               this.V[var2] = var1.reader().readInt();
               this.Y[var2] = var1.reader().readUTF();
               this.W[var2] = var1.reader().readInt();
            }
         }
      } catch (Exception var4) {
         var4.printStackTrace();
      }

      main.GameCanvas.panel.r();
      main.GameCanvas.panel.show();
   }

   private void startYesNoPopUp(String var1, CommandLine var2, CommandLine var3) {
      this.popUpYesNo = new PopUpYesNo();
      this.popUpYesNo.setPopUp(var1, var2, var3);
   }

   public final void a(int var1, String var2, byte var3) {
      Char var4;
      if ((var4 = findCharInMap(var1)) != null) {
         if (var3 == 3) {
            this.startYesNoPopUp(var2, new CommandLine(mResources.OK, 2000, var4), new CommandLine(mResources.CLOSE, 2009, var4));
         }

         if (var3 == 4) {
            this.startYesNoPopUp(var2, new CommandLine(mResources.OK, 2005, var4), new CommandLine(mResources.CLOSE, 2009, var4));
         }
      }

   }

   public final void d(int var1) {
      Char var2;
      if ((var2 = findCharInMap(var1)) != null) {
         this.startYesNoPopUp(var2.cName + mResources.eB, new CommandLine(mResources.bm, 11114, var2), new CommandLine(mResources.bn, 2009, var2));
      }

   }

   public static void a(int var0, byte var1) {
      if (H.size() == 0) {
         Service.gI().b((byte)2, (byte)var1);
         ResLog.c("getFlag1");
      } else {
         int var2;
         nr_em var3;
         if (var0 == Char.myCharz().charID) {
            ResLog.c("my cflag: isme");
            Char.myCharz();
            if (Char.a(var1)) {
               ResLog.c("my cflag: true");

               for(var2 = 0; var2 < H.size(); ++var2) {
                  if ((var3 = (nr_em)H.elementAt(var2)) != null && var3.a == var1) {
                     ResLog.c("my cflag: cflag==");
                     Char.myCharz().bz = var3.b;
                  }
               }

               return;
            }

            Char.myCharz();
            if (!Char.a(var1)) {
               ResLog.c("my cflag: false");
               Service.gI().b((byte)2, (byte)var1);
               return;
            }
         } else {
            ResLog.c("my cflag: not me");
            if (findCharInMap(var0) != null) {
               findCharInMap(var0);
               if (Char.a(var1)) {
                  ResLog.c("my cflag: true");

                  for(var2 = 0; var2 < H.size(); ++var2) {
                     if ((var3 = (nr_em)H.elementAt(var2)) != null && var3.a == var1) {
                        ResLog.c("my cflag: cflag==");
                        findCharInMap(var0).bz = var3.b;
                     }
                  }

                  return;
               }

               findCharInMap(var0);
               if (!Char.a(var1)) {
                  ResLog.c("my cflag: false");
                  Service.gI().b((byte)2, (byte)var1);
               }
            }
         }

      }
   }

   public final void a(int var1, Object var2) {
      ResLog.c("PERFORM WITH ID GameScr = " + var1);
      Skill var4;
      nr_i var5;
      int var9;
      Char var10;
      switch(var1) {
      case 1:
         main.GameCanvas.endDlg();
         return;
      case 2:
         main.GameCanvas.menu.a = false;
         return;
      case 2000:
         this.popUpYesNo = null;
         if ((Char)var2 == null) {
            Service.gI().a((byte)1, (byte)3, (int)-1);
            return;
         }

         Service.gI().a((byte)1, (byte)3, (int)((Char)var2).charID);
         Service.gI().g();
         return;
      case 2001:
         main.GameCanvas.endDlg();
         return;
      case 2003:
         main.GameCanvas.endDlg();
         InfoDlg.a();
         Service.gI().a((byte)0, (byte)3, (int)Char.myCharz().aU.charID);
         return;
      case 2004:
         main.GameCanvas.endDlg();
         Service.gI().a((byte)0, (byte)4, (int)Char.myCharz().aU.charID);
         return;
      case 2005:
         main.GameCanvas.endDlg();
         this.popUpYesNo = null;
         if ((Char)var2 == null) {
            Service.gI().a((byte)1, (byte)4, (int)-1);
            return;
         }

         Service.gI().a((byte)1, (byte)4, (int)((Char)var2).charID);
         return;
      case 2006:
         main.GameCanvas.endDlg();
         Service.gI().a((byte)2, (byte)4, (int)Char.myCharz().aU.charID);
         return;
      case 2007:
         main.GameCanvas.endDlg();
      case 12006:
         GameMidlet.instance.a();
         break;
      case 2009:
         this.popUpYesNo = null;
         return;
      case 8002:
         this.a(false, true);
         main.GameCanvas.f();
         main.GameCanvas.clearKeyPressed();
         return;
      case 11000:
         main.GameCanvas.panel.q();
         main.GameCanvas.panel.show();
         return;
      case 11001:
         Char.myCharz().J();
         return;
      case 11002:
         main.GameCanvas.panel.A();
         return;
      case 11038:
         MyVector var12;
         (var12 = new MyVector("")).addElement(new CommandLine(mResources.aW[1], 110381));
         var12.addElement(new CommandLine(mResources.aW[2], 110382));
         var12.addElement(new CommandLine(mResources.aW[3], 110383));
         main.GameCanvas.menu.startAt(var12);
         return;
      case 11057:
         Effect2.vEffect2Out.removeAllElements();
         Effect2.vEffect2.removeAllElements();
         Npc var11;
         if ((var11 = (Npc)var2).dh == 0) {
            Service.gI().a((short)var11.template.npcTemplateId, (byte)main.GameCanvas.menu.b);
            return;
         }

         if (main.GameCanvas.menu.b == 0) {
            Service.gI().l(var11.dh);
            return;
         }
         break;
      case 11059:
         Skill var13 = aP[this.eb];
         this.b(var13, false);
         super.center = null;
         return;
      case 11067:
         if (TileMap.n != 0) {
            Service.gI().f((int)0);
            InfoDlg.a();
            return;
         }

         info1.a(mResources.aU, 0);
         return;
      case 11111:
         if (Char.myCharz().aU == null) {
            return;
         }

         InfoDlg.a();
         if (main.GameCanvas.panel.R.size() <= 0) {
            Char.myCharz();
            this.E();
         }

         main.GameCanvas.panel.a(Char.myCharz().aU);
         main.GameCanvas.panel.show();
         Service.gI().c(Char.myCharz().aU.charID);
         Service.gI().x(Char.myCharz().aU.charID);
         return;
      case 11112:
         var10 = (Char)var2;
         Service.gI().a((byte)1, (int)var10.charID);
         return;
      case 11113:
         if ((var10 = (Char)var2) != null) {
            Service.gI().a((byte)0, (int)var10.charID, (byte)-1, (int)-1);
            return;
         }
         break;
      case 11114:
         this.popUpYesNo = null;
         if ((var10 = (Char)var2) == null) {
            return;
         }

         Service.gI().a((byte)1, (int)var10.charID, (byte)-1, (int)-1);
         return;
      case 11115:
         if (Char.myCharz().aU == null) {
            return;
         }

         InfoDlg.a();
         Service.gI().a(Char.myCharz().aU.charID, (short)Char.myCharz().aU.M);
         return;
      case 11120:
         Object[] var7;
         Skill var8 = (Skill)(var7 = (Object[])var2)[0];
         var1 = Integer.parseInt((String)var7[1]);

         for(var9 = 0; var9 < aP.length; ++var9) {
            if (aP[var9] == var8) {
               aP[var9] = null;
            }
         }

         aP[var1] = var8;
         B();
         return;
      case 11121:
         Object[] var3;
         var4 = (Skill)(var3 = (Object[])var2)[0];
         int var6 = Integer.parseInt((String)var3[1]);

         for(var9 = 0; var9 < aO.length; ++var9) {
            if (aO[var9] == var4) {
               aO[var9] = null;
            }
         }

         aO[var6] = var4;
         C();
         return;
      case 12000:
         Service.gI().a((byte)1, (byte)-1, (String)null);
         return;
      case 12001:
         main.GameCanvas.endDlg();
         return;
      case 12002:
         main.GameCanvas.endDlg();
         var5 = (nr_i)var2;
         Service.gI().a((byte)1, (int)-1, (int)var5.a, (int)var5.b);
         this.popUpYesNo = null;
         return;
      case 12003:
         var5 = (nr_i)var2;
         main.GameCanvas.endDlg();
         Service.gI().a((byte)2, (int)-1, (int)var5.a, (int)var5.b);
         this.popUpYesNo = null;
         return;
      case 12004:
         var4 = (Skill)var2;
         this.b(var4, true);
         Char.myCharz();
         return;
      case 12005:
         if (main.GameCanvas.ak == null) {
            main.GameCanvas.ak = new ServerScr();
         }

         main.GameCanvas.ak.switchToMe();
         main.GameCanvas.endDlg();
         return;
      case 110001:
         main.GameCanvas.panel.q();
         main.GameCanvas.panel.show();
         return;
      case 110004:
         main.GameCanvas.menu.a = false;
         return;
      case 110382:
         Service.gI().j();
         return;
      case 110383:
         Service.gI().k();
         return;
      case 110391:
         Service.gI().a((byte)0, (int)Char.myCharz().aU.charID, (int)-1, (int)-1);
         return;
      case 888351:
         Service.gI().h((byte)5);
         main.GameCanvas.endDlg();
         return;
      }

   }

   public final void b(String var1, String var2) {
      var1 = var1;
      this.eY = new int[var1.length()];
      this.eZ = new int[var1.length()];
      this.fa = new int[var1.length()];
      this.fb = new int[var1.length()];
      this.fc = new int[var1.length()];

      for(int var3 = 0; var3 < var1.length(); ++var3) {
         this.eY[var3] = Short.parseShort(var1.substring(var3, var3 + 1));
         this.eZ[var3] = ResLog.random(0, 11);
         this.fa[var3] = 1;
         this.fc[var3] = 0;
      }

      this.ff = 100;
      this.fd = 0;
      this.fe = var2;
      ei = ej = mSystem.currentTimeMillis();
   }

   public final void a(String var1) {
      if (!this.fi) {
         this.fh = mFont.e.getWidth(var1);
         this.fg = main.GameCanvas.z;
         this.fi = true;
      }

      if (var1.startsWith("!")) {
         var1 = var1.substring(1, var1.length());
         this.bQ = true;
      }

      eX.addElement(var1);
   }

   public final void b(String var1) {
      this.fj = var1;
      this.fk = mFont.k.getWidth(this.fj, 500);
   }

   private static boolean M() {
      return TileMap.c() && bY.a == 0;
   }

   private static void a(mGraphics var0, int var1, int var2, int var3) {
      if (bY != null) {
         if (!a && bm == 1 && !main.GameCanvas.panel.isShow && M()) {
            if (var3 < fn.a + (fm.a << 2)) {
               var3 = fn.a + (fm.a << 2);
            }

            if (var1 > main.GameCanvas.z - var3 / 2) {
               var1 = main.GameCanvas.z - var3 / 2;
            }

            if (var1 < mGraphics.setColor(fq) + var3 / 2 + 10) {
               var1 = mGraphics.setColor(fq) + var3 / 2 + 10;
            }

            var2 = fm.b;
            int var4 = var2 + 0 + mGraphics.b(fp) / 2 + 2;
            int var5 = fn.a;
            int var6 = var3 / 2 - var5 / 2;
            var3 = var1 - var3 / 2;
            int var7 = var1 + var5 / 2;
            int var8;
            int var9 = (var8 = var6 - fm.a) / fm.a;
            if (var8 % fm.a > 0) {
               ++var9;
            }

            for(int var10 = 0; var10 < var9; ++var10) {
               if (var10 < var9 - 1) {
                  fm.a(1, var3 + fm.a + var10 * fm.a, 3, 0, 0, var0);
               } else {
                  fm.a(1, var3 + var8, 3, 0, 0, var0);
               }

               if (var10 < var9 - 1) {
                  fm.a(1, var7 + var10 * fm.a, 3, 0, 0, var0);
               } else {
                  fm.a(1, var7 + var8 - fm.a, 3, 0, 0, var0);
               }
            }

            fm.a(0, var3, 3, 2, 0, var0);
            fm.a(0, var7 + var8, 3, 0, 0, var0);
            byte var11;
            int var12;
            byte var13;
            if (bY.c > 0) {
               var13 = 2;
               var11 = 3;
               if (bY.e == 4) {
                  var13 = 4;
                  var11 = 5;
               }

               if ((var12 = bY.c * var6 / bY.b) < 0) {
                  var12 = 0;
               }

               if (var12 > var6) {
                  var12 = var6;
               }

               var0.e(var3 + var6 - var12, 3, var12, var2);

               for(var12 = 0; var12 < var9; ++var12) {
                  if (var12 < var9 - 1) {
                     fm.a(var11, var3 + fm.a + var12 * fm.a, 3, 0, 0, var0);
                  } else {
                     fm.a(var11, var3 + var8, 3, 0, 0, var0);
                  }
               }

               fm.a(var13, var3, 3, 2, 0, var0);
               main.GameCanvas.a(var0);
            }

            if (bY.d > 0) {
               var13 = 2;
               var11 = 3;
               if (bY.f == 4) {
                  var13 = 4;
                  var11 = 5;
               }

               if ((var12 = bY.d * var6 / bY.b) < 0) {
                  var12 = 0;
               }

               if (var12 > var6) {
                  var12 = var6;
               }

               var0.e(var7, 3, var12, var2);

               for(var12 = 0; var12 < var9; ++var12) {
                  if (var12 < var9 - 1) {
                     fm.a(var11, var7 + var12 * fm.a, 3, 0, 0, var0);
                  } else {
                     fm.a(var11, var7 + var8 - fm.a, 3, 0, 0, var0);
                  }
               }

               fm.a(var13, var7 + var8, 3, 0, 0, var0);
               main.GameCanvas.a(var0);
            }

            fn.a(0, var1 - var5 / 2, 0, 0, 0, var0);
            String var14 = mSystem.a(bY.n, bY.m, true, false);
            mFont.d.drawStringBd(var0, var14, var1 + 1, 0 + fn.b / 2 - mFont.g.getWidth() / 2, 2);
            Panel.b(bY.e, 1).b(var0, bY.j, var1 - 5, var4 + 5, 1, mFont.tahoma_7b_dark);
            Panel.b(bY.f, 1).b(var0, bY.k, var1 + 5, var4 + 5, 0, mFont.tahoma_7b_dark);
            if (bY.a != 0) {
               int var15 = 0 + var2 / 2 - 2;
               mFont.w.drawStringBd(var0, "" + bY.c, var3 + var6 / 2, var15, 2);
               mFont.w.drawStringBd(var0, "" + bY.d, var7 + var6 / 2, var15, 2);
            }

            var0.drawImage(fo, var1, 0 + fn.b + 2, 3);
            if (bY.a == 0) {
               a(var0, bY.g, bY.h, var1 - 13, bY.i, var1 + 13, var4);
            }
         }

      }
   }

   private static void a(mGraphics var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if (fp != null) {
         int var7 = mGraphics.b(fp) / 2;

         int var8;
         byte var9;
         for(var8 = 0; var8 < var1; ++var8) {
            var9 = 0;
            if (var8 < var2) {
               var9 = 1;
            }

            var0.setColor(fp, 0, var9 * var7, mGraphics.setColor(fp), var7, 0, var3 - var8 * (var7 + 1), var6, 3);
         }

         for(var8 = 0; var8 < var1; ++var8) {
            var9 = 0;
            if (var8 < var4) {
               var9 = 1;
            }

            var0.setColor(fp, 0, var9 * var7, mGraphics.setColor(fp), var7, 0, var5 + var8 * (var7 + 1), var6, 3);
         }
      }

   }

   public static void a(int var0, int var1, int var2, int var3, int var4, int var5, int var6, short var7, Point[] var8) {
      a(new nr_cf(var0, var1, var2, var3, var4, var5, var6, var7, var8));
   }

   public static void a(int var0, int var1, int var2, Char var3, Point var4, int var5, short var6, short var7) {
      a(new nr_cf(var0, var1, var2, var3.Z(), var4, var5, var6, var7));
   }

   private static void a(nr_cf var0) {
      if (var0.a == 0) {
         nr_df.a(var0);
      } else if (var0.a == 1) {
         nr_df.b(var0);
      } else if (var0.a == 2) {
         nr_df.c(var0);
      } else {
         nr_df.d(var0);
      }
   }

   private static void j(mGraphics var0) {
      var0.setColor(8421504);
      var0.fillRect(0, main.GameCanvas.A - 2, main.GameCanvas.z, 2);
      int var1 = (int)(Char.myCharz().Z * (long)main.GameCanvas.z / 10000L);
      var0.setColor(16777215);
      var0.fillRect(0, main.GameCanvas.A - 2, var1, 2);
      var0.setColor(0);
      var1 = main.GameCanvas.z / 10;

      for(int var2 = 1; var2 < 10; ++var2) {
         var0.fillRect(var2 * var1, main.GameCanvas.A - 2, 1, 2);
      }

   }
}
