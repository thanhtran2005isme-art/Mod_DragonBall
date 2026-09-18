package nro;

import javax.microedition.lcdui.Image;

public class Mob implements IMapObject {
   public static MobTemplate[] arrMobTemplate;
   boolean changBody;
   short smallBody;
   public boolean f;
   public boolean g = false;
   public int h;
   public long i;
   public int j;
   public int k;
   public int l;
   public int x;
   public int y;
   public int o = 1;
   private int a = 1;
   public int p;
   public int q;
   public int r;
   public int s;
   public int xFirst;
   public int yFirst;
   public int v;
   public int w;
   public int timeStatus;
   public int mobId;
   public boolean z;
   public boolean A;
   public boolean B;
   private boolean b;
   private MyVector ad = new MyVector("vMobMove");
   public int C;
   public Char D;
   public int E;
   public int F;
   public int G;
   public byte H;
   public boolean I;
   public boolean J;
   public static MyVector K = new MyVector("lastMob");
   public static MyVector L = new MyVector("newMob");
   public boolean M = false;
   public int N;
   public int O;
   public int P;
   public int Q;
   private boolean ae;
   private int af;
   private boolean ag = true;
   private int ah;
   private int ai;
   public static Image R = mSystem.load("/mainImage/myTexture2dmobHP.png");
   private boolean aj;
   private int ak;
   private int al;
   private int am;
   public int S;
   public boolean T = true;
   private int[] an = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1};
   private int[] ao = new int[]{1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 2, 2, 2};
   private int[] ap = new int[]{1, 1, 2, 2, 3, 3, 2};
   private int[] aq = new int[]{4, 5, 6};
   private int[] ar = new int[]{7, 8, 9};
   private int[] as = new int[1];
   public int U = 24;
   public int V = 100;
   public int W = 100;
   public Image X;
   private int at = 0;
   public boolean Y = false;
   public Char Z;
   public boolean aa;
   private Mob au;
   private int av;
   public boolean ab;
   public boolean ac;
   private int[][] aw;
   private boolean ax;

   public final boolean isBigBoss() {
      return this instanceof BachTuoc || this instanceof BigBoss2 || this instanceof BigBoss || this instanceof NewBoss;
   }

   public Mob() {
      byte[] var10000 = new byte[]{-1, 1};
      this.aa = false;
      this.aw = new int[][]{{0, 0, 0, 0, 1, 1, 1, 1}, {0, 0, 0, 0, 1, 1, 1, 1}, {0, 0, 0, 0, 1, 1, 1, 1}, {0, 0, 0, 0, 1, 1, 1, 1}, {0, 0, 0, 0, 1, 1, 1, 1}, {0, 0, 0, 0, 1, 1, 1, 1}};
      this.ax = true;
   }

   public final void getData() {
      if (arrMobTemplate[this.C].data == null) {
         arrMobTemplate[this.C].data = new EffectData();
         String var1 = "/Mob/" + this.C;
         if ("".getClass().getResourceAsStream(var1) != null) {
            arrMobTemplate[this.C].data.a(var1 + "/data");
            arrMobTemplate[this.C].data.a = mSystem.load(var1 + "/img.png");
         } else {
            Service.gI().h(this.C);
         }

         if (K.size() > 15) {
            arrMobTemplate[Integer.parseInt((String)K.elementAt(0))].data = null;
            K.removeElementAt(0);
         }

         K.addElement(String.valueOf(this.C));
      } else {
         this.v = arrMobTemplate[this.C].data.f;
         this.w = arrMobTemplate[this.C].data.g;
      }
   }

   public void setBody(short id) {
      this.changBody = true;
      this.smallBody = id;
   }

   public void clearBody() {
      this.changBody = false;
   }

   public Mob(int mobId, boolean var2, boolean var3, boolean var4, boolean var5, boolean var6, int var7, int var8, int var9, byte var10, int var11, short var12, short var13, byte var14, byte var15) {
      byte[] var10000 = new byte[]{-1, 1};
      this.aa = false;
      this.aw = new int[][]{{0, 0, 0, 0, 1, 1, 1, 1}, {0, 0, 0, 0, 1, 1, 1, 1}, {0, 0, 0, 0, 1, 1, 1, 1}, {0, 0, 0, 0, 1, 1, 1, 1}, {0, 0, 0, 0, 1, 1, 1, 1}, {0, 0, 0, 0, 1, 1, 1, 1}};
      this.ax = true;
      this.z = var3;
      this.A = var5;
      this.B = var6;
      this.G = var8;
      this.mobId = mobId;
      this.C = var7;
      this.k = var9;
      this.xFirst = this.x = var12;
      this.yFirst = this.y = var13;
      this.p = var14;
      if (var7 != 70) {
         C();
         this.getData();
      }

      if (!a(String.valueOf(var7))) {
         L.addElement(String.valueOf(var7));
      }

      this.l = var11;
      this.H = var15;
      this.A();
      this.b = false;
      this.P = var12;
      this.Q = var13;
      if (this.D()) {
         this.an = new int[]{0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2};
         this.ao = new int[]{0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2};
         this.ap = new int[]{0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2};
         this.aq = new int[]{3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5};
         this.ar = new int[]{3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5};
      } else if (this.E()) {
         this.an = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1};
         this.ao = new int[]{1, 1, 1, 1, 2, 2, 2, 2, 1, 1, 1, 1, 3, 3, 3, 3};
         this.ap = new int[]{1, 1, 2, 2, 1, 1, 3, 3};
         this.aq = new int[]{4, 4, 4, 5, 5, 5, 6, 6, 6, 6, 6};
         this.ar = new int[]{7, 7, 7, 8, 8, 8, 9, 9, 9, 9, 9};
      } else if (this.e()) {
         this.an = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1};
         this.ao = new int[]{2, 2, 3, 3, 2, 2, 4, 4, 2, 2, 3, 3, 2, 2, 4, 4};
         this.ap = new int[]{2, 2, 3, 3, 2, 2, 4, 4};
         this.aq = new int[]{5, 6, 7, 8, 9, 10, 11, 12};
         this.ar = new int[]{5, 12, 13, 14};
      } else {
         this.an = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1};
         this.ao = new int[]{1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 2, 2, 2};
         this.ap = new int[]{1, 1, 2, 2, 3, 3, 2};
         this.aq = new int[]{4, 5, 6};
         this.ar = new int[]{7, 8, 9};
      }

      ResLog.c("MOB ID= " + mobId);
   }

   private static boolean a(String var0) {
      for(int var1 = 0; var1 < L.size(); ++var1) {
         if (((String)L.elementAt(var1)).equals(var0)) {
            return true;
         }
      }

      return false;
   }

   private static void C() {
      int var0 = 0;

      int var1;
      for(var1 = 0; var1 < arrMobTemplate.length; ++var1) {
         if (arrMobTemplate[var1].data != null) {
            ++var0;
         }
      }

      if (var0 >= 10) {
         for(var1 = 0; var1 < arrMobTemplate.length; ++var1) {
            if (arrMobTemplate[var1].data != null && var0 > 5) {
               arrMobTemplate[var1].data = null;
            }
         }
      }

   }

   public void a(int[] var1) {
      if (this.ah > var1.length - 1) {
         this.ah = 0;
      }

      this.ai = var1[this.ah];
      ++this.ah;
   }

   public void updateSuperEff() {
      if (this.S == 0 && main.GameCanvas.v % 25 == 0) {
         ServerEffect.addServerEffect(114, (Mob)this, 1);
      }

      if (this.S == 1 && main.GameCanvas.v % 4 == 0) {
         ServerEffect.addServerEffect(132, (Mob)this, 1);
      }

      if (this.S == 2 && main.GameCanvas.v % 7 == 0) {
         ServerEffect.addServerEffect(131, (Mob)this, 1);
      }

   }

   public void update() {
      if (!this.M) {
         this.B();
         if (this.ab && main.GameCanvas.v % 5 == 0) {
            ServerEffect.addServerEffect(113, this.x, this.y, 1);
         }

         if (this.ac && main.GameCanvas.v % 10 == 0) {
            EffecMn.addEff(new Effect(41, this.x, this.y, 3, 1, 1));
         }

         int var1;
         if (!main.GameCanvas.a && this.p != 1 && this.p != 0 && !main.GameCanvas.a && main.GameCanvas.v % (15 + (this.mobId << 1)) == 0) {
            for(var1 = 0; var1 < GameScr.vCharInMap.size(); ++var1) {
               Char var2;
               if ((var2 = (Char)GameScr.vCharInMap.elementAt(var1)) != null && var2.ci && var2.as == 32) {
                  Char var3;
                  (var3 = new Char()).cx = var2.cx;
                  var3.cy = var2.cy - var2.al;
                  if (var2.cgender == 0) {
                     MonsterDart.addMonsterDart(this.x + this.o * this.v, this.y, this.checkIsBoss(), -100, -100, var3, 25);
                  }
               }
            }

            if (Char.myCharz().ci && Char.myCharz().as == 32) {
               Char var4;
               (var4 = new Char()).cx = Char.myCharz().cx;
               var4.cy = Char.myCharz().cy - Char.myCharz().al;
               if (Char.myCharz().cgender == 0) {
                  MonsterDart.addMonsterDart(this.x + this.o * this.v, this.y, this.checkIsBoss(), -100, -100, var4, 25);
               }
            }
         }

         if (this.j != 0 && main.GameCanvas.v % 5 == 0) {
            EffecMn.addEff(new Effect(this.j, this.x, this.y + 24, 3, 5, 1));
         }

         if (this.g) {
            if (main.GameCanvas.v % 5 == 0) {
               ServerEffect.addServerEffect(113, this.x, this.y, 1);
            }

            long var5;
            if ((var5 = System.currentTimeMillis()) - this.i >= 1000L) {
               --this.h;
               this.i = var5;
               if (this.h < 0) {
                  this.g = false;
                  this.h = 0;
               }
            }

            if (this.F()) {
               this.ai = this.as[main.GameCanvas.v % this.as.length];
            } else if (this.D()) {
               this.ai = this.aq[main.GameCanvas.v % this.aq.length];
            } else if (this.E()) {
               if (main.GameCanvas.v % 20 > 5) {
                  this.ai = 11;
               } else {
                  this.ai = 10;
               }
            } else if (this.e()) {
               if (main.GameCanvas.v % 20 > 5) {
                  this.ai = 1;
               } else {
                  this.ai = 15;
               }
            } else if (main.GameCanvas.v % 20 > 5) {
               this.ai = 11;
            } else {
               this.ai = 10;
            }
         }

         if (this.i()) {
            if (this.ag) {
               Mob var6 = this;
               byte var7 = TileMap.i;
               this.P = this.x;
               this.af = 0;
               if (this.Q > 0 && !TileMap.a(this.P, this.Q, 2)) {
                  if (TileMap.a(this.P / var7, this.Q / var7) == 0) {
                     this.ae = true;
                  } else if (TileMap.a(this.P / var7, this.Q / var7) != 0 && !TileMap.a(this.P, this.Q, 2)) {
                     this.P = this.x;
                     this.Q = this.y;
                     this.ae = false;
                  }

                  while(var6.ae && var6.af < 10) {
                     ++var6.af;
                     var6.Q += 24;
                     if (TileMap.a(var6.P, var6.Q, 2)) {
                        if (var6.Q % 24 != 0) {
                           var6.Q %= 24;
                        }
                        break;
                     }
                  }
               }
            }

            if (this.ad != null || arrMobTemplate[this.C].hp == 0) {
               if (this.p != 3 && this.T) {
                  if (this.D != null) {
                     this.D.a(this.E, this.F, false, true);
                  } else if (this.au != null) {
                     this.au.d();
                  }

                  this.T = false;
               }

               if (this.H > 0) {
                  this.updateSuperEff();
               }

               switch(this.p) {
               case 1:
                  this.z = false;
                  this.A = false;
                  this.B = false;
                  this.y += this.q;
                  if (main.GameCanvas.v % 2 == 0) {
                     if (this.r > 1) {
                        --this.r;
                     } else if (this.r < -1) {
                        ++this.r;
                     }
                  }

                  this.x += this.r;
                  if (this.F()) {
                     this.ai = this.as[main.GameCanvas.v % this.as.length];
                  } else if (this.D()) {
                     this.ai = this.aq[main.GameCanvas.v % this.aq.length];
                  } else if (!this.E() && this.e()) {
                     this.ai = 15;
                  } else {
                     this.ai = 11;
                  }

                  if (this.b) {
                     this.b = false;
                     if (this.J) {
                        for(var1 = 0; var1 < GameScr.F.size(); ++var1) {
                           if (((Mob)GameScr.F.elementAt(var1)).mobId == this.mobId) {
                              GameScr.F.removeElementAt(var1);
                           }
                        }
                     }

                     this.q = 0;
                     this.r = 0;
                     this.x = this.y = 0;
                     this.k = this.z().name;
                     this.p = 0;
                     this.timeStatus = 0;
                     return;
                  }

                  if ((TileMap.b(this.x, this.y) & 2) == 2) {
                     this.q = this.q > 4 ? -4 : -this.q;
                     if (this.s == 0) {
                        this.s = 16;
                     }
                  } else {
                     ++this.q;
                  }

                  if (this.s > 0) {
                     --this.s;
                     if (this.s == 0) {
                        this.b = true;
                        return;
                     }
                  }
                  break;
               case 2:
                  if (this.j != 0) {
                     return;
                  }

                  if (this.g) {
                     return;
                  }

                  if (this.ab) {
                     return;
                  }

                  if (this.ac) {
                     return;
                  }

                  this.timeStatus = 0;
                  this.a(this.an);
                  switch(arrMobTemplate[this.C].mobTemplateId) {
                  case 0:
                  case 1:
                  case 2:
                  case 3:
                     ++this.q;
                     if (this.q > 10 + this.mobId % 10 && (this.D == null || ResLog.g(this.D.cx - this.x) > 80) && (this.au == null || ResLog.g(this.au.x - this.x) > 80)) {
                        this.p = 5;
                     }
                     break;
                  case 4:
                  case 5:
                     ++this.q;
                     if (this.q > this.mobId % 3 && (this.D == null || ResLog.g(this.D.cx - this.x) > 80) && (this.au == null || ResLog.g(this.au.x - this.x) > 80)) {
                        this.p = 5;
                     }
                  }

                  if (this.D != null && main.GameCanvas.v % (10 + this.q % 20) == 0) {
                     if (this.D.cx > this.x) {
                        this.o = 1;
                     } else {
                        this.o = -1;
                     }
                  } else if (this.au != null && main.GameCanvas.v % (10 + this.q % 20) == 0) {
                     if (this.au.x > this.x) {
                        this.o = 1;
                     } else {
                        this.o = -1;
                     }
                  }

                  if (this.av > 0) {
                     --this.av;
                     this.p = 2;
                  }

                  return;
               case 3:
                  if (this.j != 0) {
                     return;
                  }

                  if (this.ab) {
                     return;
                  }

                  if (this.ac) {
                     return;
                  }

                  if (this.g) {
                     return;
                  }

                  this.f();
                  return;
               case 4:
                  if (this.j != 0) {
                     return;
                  }

                  if (this.ab) {
                     return;
                  }

                  if (this.ac) {
                     return;
                  }

                  if (this.g) {
                     return;
                  }

                  this.timeStatus = 0;
                  ++this.q;
                  if (this.q > 40 + this.mobId % 5) {
                     this.y -= 2;
                     this.p = 5;
                     this.q = 0;
                     return;
                  }
                  break;
               case 5:
                  if (this.j != 0) {
                     return;
                  } else if (this.ab) {
                     return;
                  } else if (this.ac) {
                     return;
                  } else if (this.g) {
                     if (arrMobTemplate[this.C].mobTemplateId == 4) {
                        ++this.am;
                        ++this.ak;
                        this.al += !this.aj ? 1 : -1;
                        if (this.ak == 10) {
                           this.ak = 0;
                           this.aj = !this.aj;
                        }
                     }

                     return;
                  } else {
                     this.timeStatus = 0;
                     this.g();
                     return;
                  }
               case 6:
                  this.timeStatus = 0;
                  ++this.q;
                  this.y += this.q;
                  if (this.y >= this.yFirst) {
                     this.y = this.yFirst;
                     this.q = 0;
                     this.p = 5;
                     return;
                  }
                  break;
               case 7:
                  if (!this.T && main.GameCanvas.v % 4 == 0) {
                     if (this.F()) {
                        this.ai = this.as[main.GameCanvas.v % this.as.length];
                     } else if (this.D()) {
                        this.ai = this.aq[main.GameCanvas.v % this.aq.length];
                     } else if (this.E()) {
                        if (this.ai != 10) {
                           this.ai = 10;
                        } else {
                           this.ai = 11;
                        }
                     } else if (this.e()) {
                        if (this.ai != 1) {
                           this.ai = 1;
                        } else {
                           this.ai = 15;
                        }
                     } else if (this.ai != 10) {
                        this.ai = 10;
                     } else {
                        this.ai = 11;
                     }
                  }

                  --this.timeStatus;
                  if (this.timeStatus <= 0 && (this.F() || this.D() || this.E() && this.ai == 11 || this.e() && this.ai == 15 || this.C < 58 && this.ai == 11)) {
                     if ((this.Z == null || !this.aa) && this.k != 0) {
                        this.p = 5;
                        if (this.Z != null) {
                           this.o = -this.Z.I;
                           if (ResLog.g(this.x - this.Z.cx) < 24) {
                              this.p = 2;
                           }
                        }

                        this.q = this.r = this.s = 0;
                        this.timeStatus = 0;
                     } else {
                        this.p = 1;
                        this.r = this.Z.I << 1;
                        this.q = -3;
                        this.s = 0;
                     }

                     this.Z = null;
                     return;
                  }

                  if (arrMobTemplate[this.C].mobTemplateId != 0 && this.Z != null) {
                     int var8 = -this.Z.I << 1;
                     if (this.x > this.xFirst - arrMobTemplate[this.C].hp && this.x < this.xFirst + arrMobTemplate[this.C].hp) {
                        this.x -= var8;
                     }
                  }
               }

            }
         }
      }
   }

   public void d() {
      if (this.k > 0 && this.p != 3 && this.p != 7) {
         this.timeStatus = 4;
         this.p = 7;
         if (this.z().mobTemplateId != 0 && ResLog.g(this.x - this.xFirst) < 30) {
            this.x -= 10 * this.o;
         }
      }

   }

   public static BigBoss w() {
      for(int var0 = 0; var0 < GameScr.F.size(); ++var0) {
         Mob var1;
         if ((var1 = (Mob)GameScr.F.elementAt(var0)) instanceof BigBoss) {
            return (BigBoss)var1;
         }
      }

      return null;
   }

   public static BigBoss2 x() {
      for(int var0 = 0; var0 < GameScr.F.size(); ++var0) {
         Mob var1;
         if ((var1 = (Mob)GameScr.F.elementAt(var0)) instanceof BigBoss2) {
            return (BigBoss2)var1;
         }
      }

      return null;
   }

   public static BachTuoc y() {
      for(int var0 = 0; var0 < GameScr.F.size(); ++var0) {
         Mob var1;
         if ((var1 = (Mob)GameScr.F.elementAt(var0)) instanceof BachTuoc) {
            return (BachTuoc)var1;
         }
      }

      return null;
   }

   public static NewBoss a(byte var0) {
      Mob var1;
      return (var1 = (Mob)GameScr.F.elementAt(var0)) instanceof NewBoss ? (NewBoss)var1 : null;
   }

   public void a(Char var1) {
      this.T = true;
      this.au = null;
      this.D = var1;
      this.q = 0;
      this.r = 0;
      this.p = 3;
      this.ah = 0;
      this.o = var1.cx > this.x ? 1 : -1;
      int var2 = var1.cx;
      int var3 = var1.cy;
      if (ResLog.g(var2 - this.x) < this.v << 1 && ResLog.g(var3 - this.y) < this.w << 1) {
         this.s = 0;
      } else {
         this.s = 1;
      }
   }

   boolean e() {
      return this.C >= 58 && this.C <= 65 || this.C == 67 || this.C == 68;
   }

   private boolean D() {
      return this.C == 76;
   }

   private boolean E() {
      return this.C >= 73 && !this.D();
   }

   public void f() {
      int[] var1 = this.s == 0 ? this.aq : this.ar;
      if (this.ah < var1.length) {
         this.a(var1);
         if (this.x >= GameScr.cmx && this.x <= GameScr.cmx + main.GameCanvas.z && this.s == 0 && main.GameCanvas.v % 2 == 0) {
            SoundMn.stopAll();
         }
      }

      if (this.q == 0) {
         int var2 = this.D != null ? this.D.cx : this.au.x;
         int var3 = this.D != null ? this.D.cy : this.au.y;
         if (!this.E()) {
            if (this.x > this.xFirst + arrMobTemplate[this.C].hp) {
               this.q = 1;
            }

            if (this.x < this.xFirst - arrMobTemplate[this.C].hp) {
               this.q = 1;
            }
         }

         if ((arrMobTemplate[this.C].mobTemplateId == 4 || arrMobTemplate[this.C].mobTemplateId == 5) && !this.z) {
            this.y += (var3 - this.y) / 20;
         }

         ++this.r;
         if (this.r > var1.length - 1 || this.q == 1) {
            this.q = 1;
            if (this.s == 0) {
               if (this.D != null) {
                  this.D.a(this.E, this.F, false, true);
               } else {
                  this.au.d();
               }

               this.T = false;
            } else {
               if (this.D != null) {
                  MonsterDart.addMonsterDart(this.x + this.o * this.v, this.y, this.checkIsBoss(), this.E, this.F, this.D, this.z().dartType);
               } else {
                  Char var4;
                  (var4 = new Char()).cx = this.au.x;
                  var4.cy = this.au.y;
                  var4.charID = -100;
                  MonsterDart.addMonsterDart(this.x + this.o * this.v, this.y, this.checkIsBoss(), this.E, this.F, var4, this.z().dartType);
               }

               this.T = false;
            }
         }

         this.o = this.x < var2 ? 1 : -1;
      } else if (this.q == 1 && this.ah == var1.length) {
         this.p = 2;
         this.q = 0;
         this.r = 0;
         this.ah = 0;
      }

      if (this.ah == 5 && this.D != null && this.D.charID == Char.myCharz().charID) {
         if (this.C == 88 && this.s != 0) {
            GameScr.bt = 2;
         }

         if (this.C == 89) {
            GameScr.bt = 2;
         }
      }

   }

   public void g() {
      try {
         if (this.aa) {
            this.p = 1;
            this.r = this.Z.I << 3;
            this.q = -5;
            this.s = 0;
         }

         if (this.A) {
            return;
         }

         if (this.z || this.B) {
            this.a(this.an);
            return;
         }

         byte var1;
         switch(arrMobTemplate[this.C].mobTemplateId) {
         case 0:
            if (!this.D()) {
               this.ai = 0;
               return;
            }

            this.ai = this.an[main.GameCanvas.v % this.an.length];
            break;
         case 1:
         case 2:
         case 3:
            if ((var1 = arrMobTemplate[this.C].rangeMove) == 1) {
               if (main.GameCanvas.v % 2 == 1) {
                  return;
               }
            } else if (var1 > 2) {
               var1 = (byte)(var1 + this.mobId % 2);
            } else if (main.GameCanvas.v % 2 == 1) {
               --var1;
            }

            this.x += var1 * this.o;
            if (this.x > this.xFirst + arrMobTemplate[this.C].hp) {
               this.o = -1;
            } else if (this.x < this.xFirst - arrMobTemplate[this.C].hp) {
               this.o = 1;
            }

            if (ResLog.g(this.x - Char.myCharz().cx) < 40 && ResLog.g(this.x - this.xFirst) < arrMobTemplate[this.C].hp) {
               this.o = this.x > Char.myCharz().cx ? -1 : 1;
               if (ResLog.g(this.x - Char.myCharz().cx) < 20) {
                  this.x -= this.o * 10;
               }

               this.p = 2;
               this.av = 20;
            }

            this.a(this.v > 30 ? this.ao : this.ap);
            return;
         case 4:
            var1 = (byte)(arrMobTemplate[this.C].rangeMove + this.mobId % 2);
            this.x += var1 * this.o;
            if (main.GameCanvas.v % 10 > 2) {
               this.y += var1 * this.a;
            }

            if (this.x > this.xFirst + arrMobTemplate[this.C].hp) {
               this.o = -1;
               this.p = 2;
               this.av = main.GameCanvas.v % 20 + 20;
               this.q = 0;
            } else if (this.x < this.xFirst - arrMobTemplate[this.C].hp) {
               this.o = 1;
               this.p = 2;
               this.av = main.GameCanvas.v % 20 + 20;
               this.q = 0;
            }

            if (this.y > this.yFirst + 24) {
               this.a = -1;
            } else if (this.y < this.yFirst - (20 + main.GameCanvas.v % 10)) {
               this.a = 1;
            }

            this.a(this.ao);
            return;
         case 5:
            var1 = (byte)(arrMobTemplate[this.C].rangeMove + this.mobId % 2);
            this.x += var1 * this.o;
            var1 = (byte)(var1 + (main.GameCanvas.v + this.mobId) % 2);
            if (main.GameCanvas.v % 10 > 2) {
               this.y += var1 * this.a;
            }

            if (this.x > this.xFirst + arrMobTemplate[this.C].hp) {
               this.o = -1;
               this.p = 2;
               this.av = main.GameCanvas.v % 20 + 20;
               this.q = 0;
            } else if (this.x < this.xFirst - arrMobTemplate[this.C].hp) {
               this.o = 1;
               this.p = 2;
               this.av = main.GameCanvas.v % 20 + 20;
               this.q = 0;
            }

            if (this.y > this.yFirst + 24) {
               this.a = -1;
            } else if (this.y < this.yFirst - (20 + main.GameCanvas.v % 10)) {
               this.a = 1;
            }

            if (!TileMap.a(this.x, this.y, 2)) {
               break;
            }

            if (main.GameCanvas.v % 10 > 5) {
               this.y = TileMap.e(this.y);
               this.p = 4;
               this.q = 0;
               this.a = -1;
               return;
            }

            this.a = -1;
         default:
            return;
         }
      } catch (Exception var2) {
      }

   }

   public final MobTemplate z() {
      return arrMobTemplate[this.C];
   }

   public boolean h() {
      if (this.x < GameScr.cmx) {
         return false;
      } else if (this.x > GameScr.cmx + GameScr.d) {
         return false;
      } else if (this.y < GameScr.cmy) {
         return false;
      } else if (this.y > GameScr.cmy + GameScr.e + 30) {
         return false;
      } else if (arrMobTemplate[this.C] == null) {
         return false;
      } else if (arrMobTemplate[this.C].data == null) {
         return false;
      } else if (arrMobTemplate[this.C].data.a == null) {
         return false;
      } else {
         return this.p != 0;
      }
   }

   public boolean i() {
      if (arrMobTemplate[this.C] == null) {
         return false;
      } else if (arrMobTemplate[this.C].data == null) {
         return false;
      } else {
         return this.p != 0;
      }
   }

   public boolean checkIsBoss() {
      return this.I || this.H > 0;
   }

   public final void A() {
      this.V = (int)((long)this.k * 100L / (long)this.l);
      if (this.V >= 100) {
         this.W = this.V;
      }

      this.at = 0;
      if (this.V < 30) {
         this.X = GameScr.aG;
      } else if (this.V < 60) {
         this.X = GameScr.aH;
      } else {
         this.X = GameScr.aJ;
      }
   }

   public void a(mGraphics var1) {
      if (!this.Y) {
         if (this.M) {
            if (!this.changBody) {
               arrMobTemplate[this.C].data.a(var1, this.ai, this.N, this.O, this.o == 1 ? 0 : 1, 2);
            } else {
               SmallImage.b(var1, this.smallBody, this.N, this.O, this.o == 1 ? 0 : 2, 33);
            }
         } else {
            if (this.ag && this.p != 0) {
               byte var4 = TileMap.i;
               if (TileMap.a(this.P + var4 / 2, this.Q + 1, 4)) {
                  var1.e(this.P / var4 * var4, (this.Q - 30) / var4 * var4, var4, 100);
               } else if (TileMap.a((this.P - var4 / 2) / var4, (this.Q + 1) / var4) == 0) {
                  var1.e(this.P / var4 * var4, (this.Q - 30) / var4 * var4, 100, 100);
               } else if (TileMap.a((this.P + var4 / 2) / var4, (this.Q + 1) / var4) == 0) {
                  var1.e(this.P / var4 * var4, (this.Q - 30) / var4 * var4, var4, 100);
               } else if (TileMap.a(this.P - var4 / 2, this.Q + 1, 8)) {
                  var1.e(this.P / 24 * var4, (this.Q - 30) / var4 * var4, var4, 100);
               }

               var1.drawImage(TileMap.x, this.P, this.Q, 3);
               var1.e(GameScr.cmx, GameScr.cmy - main.GameCanvas.ac, GameScr.d, GameScr.e + 2 * main.GameCanvas.ac);
            }

            if (this.h()) {
               if (this.p != 1 || this.s <= 0 || main.GameCanvas.v % 3 != 0) {
                  var1.setColor(0, main.GameCanvas.ac);
                  if (!this.changBody) {
                     arrMobTemplate[this.C].data.a(var1, this.ai, this.x, this.y + this.al, this.o == 1 ? 0 : 1, 2);
                  } else {
                     SmallImage.b(var1, this.smallBody, this.x, this.y + this.al - 9, this.o == 1 ? 0 : 2, 33);
                  }

                  var1.setColor(0, -main.GameCanvas.ac);
                  if (Char.myCharz().aQ != null && Char.myCharz().aQ.equals(this) && this.p != 1 && this.k > 0 && this.X != null) {
                     int var2 = mGraphics.setColor(this.X);
                     int var3 = mGraphics.b(this.X);
                     int var6;
                     int var5 = var6 = var2 * this.V / 100;
                     if (this.W >= this.V) {
                        int var10002 = this.W;
                        int var10003;
                        if (main.GameCanvas.v % 6 > 3) {
                           int var10005 = this.at;
                           var10003 = var10005;
                           this.at = var10005 + 1;
                        } else {
                           var10003 = this.at;
                        }

                        var5 = var2 * (this.W = var10002 - var10003) / 100;
                        if (this.W <= 0) {
                           this.W = 0;
                        }

                        if (this.W < this.V) {
                           this.W = this.V;
                        }

                        if (this.at >= 3) {
                           this.at = 3;
                        }
                     }

                     var1.drawImage(GameScr.aI, this.x - (var2 >> 1), this.y - this.w - 5, 20);
                     var1.setColor(16777215);
                     var1.fillRect(this.x - (var2 >> 1), this.y - this.w - 5, var5, 2);
                     var1.setColor(this.X, 0, 0, var6, var3, 0, this.x - (var2 >> 1), this.y - this.w - 5, 20);
                  }

               }
            }
         }
      }
   }

   public void k() {
      this.k = 0;
      this.aa = true;
      this.k = 0;
      this.p = 1;
      this.q = -3;
      this.r = -this.o;
      this.s = 0;
   }

   public void a(Mob var1) {
      this.au = var1;
      this.T = true;
      this.D = null;
      this.q = 0;
      this.r = 0;
      this.p = 3;
      this.ah = 0;
      this.o = var1.x > this.x ? 1 : -1;
      int var2 = var1.x;
      int var3 = var1.y;
      if (ResLog.g(var2 - this.x) < this.v << 1 && ResLog.g(var3 - this.y) < this.w << 1) {
         if (this.x < var2) {
            this.x = var2 - this.v;
         } else {
            this.x = var2 + this.v;
         }

         this.s = 0;
      } else {
         this.s = 1;
      }
   }

   public int getX() {
      return this.x;
   }

   public int getY() {
      return this.y;
   }

   public int getH() {
      return this.w;
   }

   public int getW() {
      return this.v;
   }

   public void stopMoving() {
      if (this.p == 5) {
         this.p = 2;
         this.q = this.r = this.s = 0;
         this.av = 50;
      }

   }

   public boolean isInvisible() {
      return this.p == 0 || this.p == 1;
   }

   public void r() {
      if (this.j != 0) {
         this.j = 0;
      }

   }

   public void s() {
      this.ab = false;
   }

   public void t() {
      this.ac = false;
   }

   public void B() {
      if (this.ax && this.F() && arrMobTemplate[this.C].data != null) {
         this.aw = (int[][]) Controller.frameNewBoss.get(String.valueOf(this.C));
         this.an = this.aw[0];
         this.ao = this.aw[1];
         this.ap = this.aw[2];
         this.aq = this.aw[3];
         this.ar = this.aw[4];
         this.as = this.aw[5];
         this.ax = false;
      }

   }

   private boolean F() {
      return arrMobTemplate[this.C].data != null && arrMobTemplate[this.C].data.e == 2;
   }
}
