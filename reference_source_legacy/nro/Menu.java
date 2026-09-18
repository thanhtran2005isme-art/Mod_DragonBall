package nro;

import javax.microedition.lcdui.Image;

public final class Menu {
   public boolean a;
   private MyVector f;
   public int b;
   public int c;
   public int d;
   private int g;
   private int h;
   private static int[] i;
   private static int j;
   private static int k;
   private static int l;
   private static int m;
   private CommandLine n;
   private CommandLine o;
   private CommandLine p;
   private static Image q = mSystem.load("/mainImage/myTexture2dbtMenu1.png");
   private static Image r = mSystem.load("/mainImage/myTexture2dbtMenu2.png");
   private boolean s;
   public int e;
   private int t;
   private int u;
   private int v;
   private int[] w;
   private boolean x;
   private boolean y;
   private int z;
   private int A;
   private boolean B;
   private boolean C;
   private int D;
   private int E;
   private boolean F;
   private boolean[] G;

   public Menu() {
      this.n = new CommandLine(mResources.bv, 0);
      this.o = new CommandLine(mResources.CLOSE, 0, main.GameCanvas.z - 71, main.GameCanvas.A - mScreen.ce + 1);
      this.p = null;
      this.w = new int[3];
   }

   public final void a(MyVector var1, int var2) {
      this.startAt(var1);
      this.s = true;
   }

   public final void a(MyVector var1, int var2, int var3) {
      this.startAt(var1);
      this.c = var2;

      for(this.d = var3; this.d + this.h > main.GameCanvas.A; this.d -= 2) {
      }

   }

   public final void startAt(MyVector var1) {
      if (!this.a) {
         this.F = false;
         this.B = false;
         this.C = false;
         this.e = 0;
         if (var1.size() == 1) {
            this.b = 0;
            CommandLine var2;
            if ((var2 = (CommandLine)var1.elementAt(0)) != null && var2.caption.equals(mResources.cD)) {
               var2.performAction();
               this.a = false;
               InfoDlg.a();
               return;
            }
         }

         SoundMn.stopAll();
         this.G = new boolean[var1.size()];

         int var4;
         for(var4 = 0; var4 < this.G.length; ++var4) {
            this.G[var4] = false;
         }

         this.s = false;
         ChatPopup.currChatPopup = null;
         Effect2.vEffect2.removeAllElements();
         Effect2.vEffect2Out.removeAllElements();
         InfoDlg.hide();
         if (var1.size() != 0) {
            this.f = var1;
            this.g = 60;
            this.h = 60;

            for(var4 = 0; var4 < var1.size(); ++var4) {
               CommandLine var3;
               (var3 = (CommandLine)var1.elementAt(var4)).isPlaySoundButton = false;
               mFont.n.getWidth(var3.caption);
               var3.c = mFont.n.getWidth(var3.caption, this.g - 10);
            }

            i = new int[var1.size()];
            this.c = (main.GameCanvas.z - var1.size() * this.g) / 2;
            if (this.c <= 0) {
               this.c = 1;
            }

            this.d = main.GameCanvas.A - this.h - (Paint.a + 1) - 1;
            if (main.GameCanvas.isTouch) {
               this.d -= 3;
            }

            this.d += 27;

            for(var4 = 0; var4 < i.length; ++var4) {
               i[var4] = main.GameCanvas.A;
            }

            this.a = true;
            this.b = 0;
            if ((l = this.f.size() * this.g - main.GameCanvas.z) < 0) {
               l = 0;
            }

            j = 0;
            k = 0;
            m = 50;
            this.t = var1.size() * this.g - 1;
            if (this.t > main.GameCanvas.z - 2) {
               this.t = main.GameCanvas.z - 2;
            }

            if (main.GameCanvas.isTouch) {
               this.b = -1;
            }

         }
      }
   }

   private boolean c() {
      return !this.F && i[i.length - 1] > this.d || this.F && i[i.length - 1] < main.GameCanvas.A;
   }

   public final void a() {
      if (!GameScr.gI().bc || !GameScr.gI().aZ) {
         if (this.a) {
            if (!this.c()) {
               boolean var1 = false;
               if (!main.GameCanvas.keyPressed[2] && !main.GameCanvas.keyPressed[4]) {
                  if (!main.GameCanvas.keyPressed[8] && !main.GameCanvas.keyPressed[6]) {
                     if (main.GameCanvas.keyPressed[5]) {
                        this.z = 2;
                     } else if (main.GameCanvas.keyPressed[12] && !GameScr.gI().u()) {
                        if (this.c()) {
                           return;
                        }

                        if (this.n.e <= 0) {
                           this.z = 2;
                        }

                        SoundMn.stopAll();
                     } else if (!GameScr.gI().u() && !this.s && (main.GameCanvas.keyPressed[13] || mScreen.a(this.o))) {
                        if (this.c()) {
                           return;
                        }

                        if (!this.C) {
                           this.C = true;
                        }

                        this.F = true;
                        SoundMn.stopAll();
                     }
                  } else {
                     var1 = true;
                     ++this.b;
                     if (this.b > this.f.size() - 1) {
                        this.b = 0;
                     }
                  }
               } else {
                  var1 = true;
                  --this.b;
                  if (this.b < 0) {
                     this.b = this.f.size() - 1;
                  }
               }

               if (var1) {
                  if ((j = this.b * this.g + this.g - main.GameCanvas.z / 2) > l) {
                     j = l;
                  }

                  if (j < 0) {
                     j = 0;
                  }

                  if (this.b == this.f.size() - 1 || this.b == 0) {
                     k = j;
                  }
               }

               var1 = true;
               if (main.GameCanvas.panel.ah != null && main.GameCanvas.panel.ah.t) {
                  if (!main.GameCanvas.isPointerHoldIn(main.GameCanvas.panel.ah.e, 0, main.GameCanvas.panel.ah.a + 2, main.GameCanvas.panel.ah.g)) {
                     var1 = true;
                  } else {
                     var1 = false;
                     main.GameCanvas.panel.ah.b();
                  }
               }

               if (!this.s && main.GameCanvas.m && !main.GameCanvas.b(this.c, this.d, this.t, this.h) && !this.x && !GameScr.gI().u() && var1) {
                  if (!this.c()) {
                     this.u = this.v = 0;
                     this.x = false;
                     main.GameCanvas.k();
                     this.F = true;
                     this.C = true;
                     SoundMn.stopAll();
                  }
               } else {
                  int var2;
                  int var4;
                  if (main.GameCanvas.k) {
                     if (!this.x && main.GameCanvas.b(this.c, this.d, this.t, this.h)) {
                        for(var4 = 0; var4 < this.w.length; ++var4) {
                           this.w[0] = main.GameCanvas.o;
                        }

                        this.v = main.GameCanvas.o;
                        this.x = true;
                        this.y = this.A != 0;
                        this.A = 0;
                     } else if (this.x) {
                        ++this.u;
                        if (this.u > 5 && this.v == main.GameCanvas.o && !this.y) {
                           this.v = -1000;
                           this.b = (j + main.GameCanvas.o - this.c) / this.g;
                        }

                        if ((var4 = main.GameCanvas.o - this.w[0]) != 0 && this.b != -1) {
                           this.b = -1;
                        }

                        for(var2 = this.w.length - 1; var2 > 0; --var2) {
                           this.w[var2] = this.w[var2 - 1];
                        }

                        this.w[0] = main.GameCanvas.o;
                        if ((j -= var4) < 0) {
                           j = 0;
                        }

                        if (j > l) {
                           j = l;
                        }

                        if (k < 0 || k > l) {
                           var4 /= 2;
                        }

                        k -= var4;
                     }
                  }

                  if (main.GameCanvas.m && this.x) {
                     var4 = main.GameCanvas.o - this.w[0];
                     main.GameCanvas.m = false;
                     if (ResLog.g(var4) < 20 && ResLog.g(main.GameCanvas.o - this.v) < 20 && !this.y) {
                        this.A = 0;
                        j = k;
                        this.v = -1000;
                        this.b = (j + main.GameCanvas.o - this.c) / this.g;
                        this.u = 0;
                        this.z = 10;
                     } else if (this.b != -1 && this.u > 5) {
                        this.u = 0;
                        this.z = 1;
                     } else if (this.b == -1 && !this.y) {
                        if (k < 0) {
                           j = 0;
                        } else if (k > l) {
                           j = l;
                        } else {
                           byte var3;
                           if ((var2 = main.GameCanvas.o - this.w[0] + (this.w[0] - this.w[1]) + (this.w[1] - this.w[2])) > 10) {
                              var3 = 10;
                           } else if (var2 < -10) {
                              var3 = -10;
                           } else {
                              var3 = 0;
                           }

                           this.A = -var3 * 100;
                        }
                     }

                     this.x = false;
                     this.u = 0;
                     main.GameCanvas.m = false;
                  }

                  main.GameCanvas.clearKeyPressed();
                  main.GameCanvas.f();
               }
            }
         }
      }
   }

   public final void a(mGraphics var1) {
      if (!GameScr.gI().bc || !GameScr.gI().aZ) {
         var1.setColor(-var1.setColor(), -var1.b());
         var1.setColor(-k, 0);

         for(int var2 = 0; var2 < this.f.size(); ++var2) {
            if (var2 == this.b) {
               var1.drawImage(r, this.c + var2 * this.g + 1, i[var2] + 1, 0);
            } else {
               var1.drawImage(q, this.c + var2 * this.g + 1, i[var2] + 1, 0);
            }

            CommandLine var3;
            String[] var4;
            if ((var4 = (var3 = (CommandLine)this.f.elementAt(var2)).c) == null) {
               var4 = new String[]{((CommandLine)this.f.elementAt(var2)).caption};
            }

            int var5 = i[var2] + (this.h - var4.length * 14) / 2 + 1;

            for(int var6 = 0; var6 < var4.length; ++var6) {
               if (var2 == this.b) {
                  mFont.g.drawStringBd(var1, var4[var6], this.c + var2 * this.g + this.g / 2, var5 + var6 * 14, 2);
               } else if (var3.a) {
                  mFont.a.drawStringBd(var1, var4[var6], this.c + var2 * this.g + this.g / 2, var5 + var6 * 14, 2);
               } else {
                  mFont.tahoma_7b_dark.drawStringBd(var1, var4[var6], this.c + var2 * this.g + this.g / 2, var5 + var6 * 14, 2);
               }
            }
         }

         var1.setColor(-var1.setColor(), -var1.b());
      }
   }

   public final void b() {
      if (this.A != 0 && !this.x) {
         if ((j += this.A / 100) < 0) {
            j = 0;
         } else if (j > l) {
            j = l;
         } else {
            k = j;
         }

         this.A = this.A * 9 / 10;
         if (this.A < 100 && this.A > -100) {
            this.A = 0;
         }
      }

      if (k != j && !this.x) {
         this.D = j - k << 2;
         this.E += this.D;
         k += this.E >> 4;
         this.E &= 15;
      }

      int[] var10000;
      int var1;
      int var2;
      CommandLine var3;
      if (!this.F) {
         ++this.e;

         for(var1 = 0; var1 < i.length; ++var1) {
            if (i[var1] > this.d) {
               if ((var2 = i[var1] - this.d >> 1) <= 0) {
                  var2 = 1;
               }

               if (this.e > var1) {
                  var10000 = i;
                  var10000[var1] -= var2;
               }
            }
         }

         if (i[i.length - 1] <= this.d) {
            this.e = 0;
         }
      } else {
         ++this.e;

         for(var1 = 0; var1 < i.length; ++var1) {
            if (i[var1] < main.GameCanvas.A) {
               if ((var2 = (main.GameCanvas.A - i[var1] >> 1) + 2) <= 0) {
                  var2 = 1;
               }

               if (this.e > var1) {
                  var10000 = i;
                  var10000[var1] += var2;
               }
            }
         }

         if (i[i.length - 1] >= main.GameCanvas.A) {
            this.e = 0;
            this.F = false;
            this.a = false;
            InfoDlg.hide();
            if (this.C) {
               main.GameCanvas.panel.ah = null;
               Char.x = null;
               if (main.GameCanvas.G != null && main.GameCanvas.G.ah != null) {
                  main.GameCanvas.G.ah = null;
               }
            } else if (this.B) {
               main.GameCanvas.panel.ah = null;
               if (main.GameCanvas.G != null && main.GameCanvas.G.ah != null) {
                  main.GameCanvas.G.ah = null;
               }

               if (this.b >= 0 && (var3 = (CommandLine)this.f.elementAt(this.b)) != null) {
                  SoundMn.stopAll();
                  var3.performAction();
               }
            }
         }
      }

      if (m != 0 && (m >>= 1) < 0) {
         m = 0;
      }

      if (!this.c()) {
         if (this.z > 0) {
            --this.z;
            if (this.z == 0) {
               if (this.b >= 0 && !this.G[this.b]) {
                  this.F = true;
                  this.B = true;
                  main.GameCanvas.panel.ah = null;
                  return;
               }

               InfoDlg.hide();
               if (this.b >= 0 && (var3 = (CommandLine)this.f.elementAt(this.b)) != null) {
                  var3.performAction();
               }
            }
         }

      }
   }
}
