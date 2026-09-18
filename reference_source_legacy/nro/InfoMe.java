package nro;

public final class InfoMe {
   public int[][] charId = new int[3][];
   public Info b = new Info();
   private int j;
   private int k;
   private int l;
   private int m;
   public int c;
   private int n;
   private int o;
   private int p;
   public int d;
   private int q;
   private int r;
   public boolean e;
   public boolean f = true;
   public int g;
   public int h;
   public CommandLine i;

   public InfoMe() {
      for(int var1 = 0; var1 < this.charId.length; ++var1) {
         this.charId[var1] = new int[3];
      }

   }

   public final void a(mGraphics var1) {
      if (!this.equals(GameScr.aD) || !GameScr.gI().x()) {
         if (!this.equals(GameScr.aD) || GameScr.gI().popUpYesNo == null) {
            if (GameScr.bs) {
               if (main.GameCanvas.currentScreen == GameScr.gI() || main.GameCanvas.currentScreen == CrackBallScr.gI()) {
                  if (ChatPopup.serverChatPopUp == null) {
                     if (this.f) {
                        if (!Char.bG) {
                           if (!main.GameCanvas.panel.isShow || !this.equals(GameScr.aD)) {
                              var1.setColor(-var1.setColor(), -var1.b());
                              var1.e(0, 0, main.GameCanvas.z, main.GameCanvas.A);
                              if (this.b != null) {
                                 this.b.a(var1, this.d, this.c, this.j);
                              }

                              if (this.b.info != null && this.b.info.c == null && this.charId != null) {
                                 SmallImage.b(var1, this.charId[Char.myCharz().cgender][this.k], this.d, this.c + 3 + (main.GameCanvas.v % 10 > 5 ? 1 : 0), this.j == 1 ? 0 : 2, StaticObj.f);
                              }

                              var1.setColor(-var1.setColor(), -var1.b());
                           }
                        }
                     }
                  }
               }
            }
         }
      }
   }

   public final void a() {
      if (this.b != null && this.b.infoWaitToShow != null && this.b.infoWaitToShow.size() == 0 && this.c != -40) {
         --this.b.f;
         if (this.b.f <= 0) {
            this.c = -40;
            this.b.e = 0;
            this.b.infoWaitToShow.removeAllElements();
            this.b.d = null;
            this.b.f = 200;
         }
      }

      if (!this.equals(GameScr.aD) || GameScr.gI().popUpYesNo == null) {
         if (this.f) {
            if (this.c != this.m) {
               this.o = this.m - this.c << 2;
               this.n += this.o;
               this.c += this.n >> 4;
               this.n &= 15;
            }

            if (this.d != this.p) {
               this.r = this.p - this.d << 2;
               this.q += this.r;
               this.d += this.q >> 4;
               this.q &= 15;
            }

            ++this.l;
            if (this.l == 5) {
               this.l = 0;
               if (this.k == 0) {
                  this.k = 1;
               } else {
                  this.k = 0;
               }
            }

            if (this.b != null) {
               if (this.b == null || this.b.info != null) {
                  if (!this.e) {
                     if (this.g > 0) {
                        --this.g;
                        if (this.g == 0) {
                           main.GameCanvas.panel.l();
                           main.GameCanvas.panel.show();
                        }
                     }

                     if (main.GameCanvas.v % 3 == 0) {
                        if (Char.myCharz().I == 1) {
                           this.p = Char.myCharz().cx - 20 - GameScr.cmx;
                        }

                        if (Char.myCharz().I == -1) {
                           this.p = Char.myCharz().cx + 20 - GameScr.cmx;
                        }

                        if (this.p <= 24) {
                           this.p += this.b.c / 2;
                        }

                        if (this.p >= main.GameCanvas.z - 24) {
                           this.p -= this.b.c / 2;
                        }

                        this.m = Char.myCharz().cy - 40 - GameScr.cmy;
                        if (this.b.d != null && this.m < (this.b.d.length + 1) * 12 + 10) {
                           this.m = (this.b.d.length + 1) * 12 + 10;
                        }

                        if (this.b.info.c != null) {
                           if (main.GameCanvas.z - 50 > 155 + this.b.i) {
                              this.p = main.GameCanvas.z - 60 - this.b.i / 2;
                              this.m = this.b.j + 10;
                           } else {
                              this.p = main.GameCanvas.z - 20 - this.b.i / 2;
                              this.m = 45 + this.b.j;
                              if (main.GameCanvas.z > main.GameCanvas.A || main.GameCanvas.z < 220) {
                                 this.p = main.GameCanvas.z - 20 - this.b.i / 2;
                                 this.m = this.b.j + 10;
                              }
                           }
                        }
                     }

                     if (this.d > Char.myCharz().cx - GameScr.cmx) {
                        this.j = -1;
                     } else {
                        this.j = 1;
                     }
                  }

                  if (this.b.info != null) {
                     if (this.b.infoWaitToShow.size() > 1) {
                        InfoItem var1;
                        if (this.b.info.f == 0) {
                           ++this.b.e;
                           if (this.b.e >= this.b.info.b) {
                              this.b.e = 0;
                              this.b.infoWaitToShow.removeElementAt(0);
                              var1 = (InfoItem)this.b.infoWaitToShow.firstElement();
                              this.b.info = var1;
                              this.b.c();
                              return;
                           }
                        } else {
                           this.b.info.i = System.currentTimeMillis();
                           if (this.b.info.i - this.b.info.h >= 1000L) {
                              this.b.info.h = System.currentTimeMillis();
                              --this.b.info.f;
                           }

                           if (this.b.info.f == 0) {
                              this.b.infoWaitToShow.removeElementAt(0);
                              if (this.b.infoWaitToShow.size() == 0) {
                                 return;
                              }

                              var1 = (InfoItem)this.b.infoWaitToShow.firstElement();
                              this.b.info = var1;
                              this.b.c();
                              return;
                           }
                        }
                     } else if (this.b.infoWaitToShow.size() == 1) {
                        if (this.b.info.f == 0) {
                           ++this.b.e;
                           if (this.b.e >= this.b.info.b) {
                              this.e = true;
                           }

                           if (this.b.e == this.b.info.b) {
                              this.m = -40;
                              this.p = Char.myCharz().cx - GameScr.cmx + (Char.myCharz().I == 1 ? -20 : 20);
                           }

                           if (this.b.e >= this.b.info.b + 20) {
                              this.b.e = 0;
                              this.b.infoWaitToShow.removeAllElements();
                              this.b.d = null;
                              return;
                           }
                        } else {
                           this.b.info.i = System.currentTimeMillis();
                           if (this.b.info.i - this.b.info.h >= 1000L) {
                              this.b.info.h = System.currentTimeMillis();
                              --this.b.info.f;
                           }

                           if (this.b.info.f == 0) {
                              this.e = true;
                              this.m = -40;
                              this.p = Char.myCharz().cx - GameScr.cmx + (Char.myCharz().I == 1 ? -20 : 20);
                              this.b.e = 0;
                              this.b.infoWaitToShow.removeAllElements();
                              this.b.d = null;
                              this.i = null;
                           }
                        }
                     }
                  }

               }
            }
         }
      }
   }

   public final void a(String var1, Char var2, boolean var3) {
      this.h = var2.charID;
      this.b.a(var1, 3, var2, var3);
      this.e = false;
   }

   public final void a(String var1, int var2) {
      var1 = ResLog.a(var1);
      if (this.b.infoWaitToShow.size() <= 0 || !var1.equals(((InfoItem)this.b.infoWaitToShow.lastElement()).a)) {
         if (this.b.infoWaitToShow.size() > 10) {
            for(int var3 = 0; var3 < 5; ++var3) {
               this.b.infoWaitToShow.removeElementAt(0);
            }
         }

         this.b.a(var1, var2, (Char)null, false);
         if (this.b.infoWaitToShow.size() == 1) {
            this.c = 0;
            this.d = Char.myCharz().cx - GameScr.cmx + (Char.myCharz().I == 1 ? -20 : 20);
         }

         this.e = false;
      }
   }
}
