package nro;

import javax.microedition.lcdui.Image;

public final class Info implements IActionListener {
   public MyVector infoWaitToShow = new MyVector("infoWaitToShow");
   public InfoItem info;
   public int c = 100;
   private int k;
   public String[] d;
   private int l;
   private int m;
   private boolean n = false;
   private static Image o = mSystem.load("/mainImage/myTexture2dgocnhon.png");
   public int e;
   public int f;
   private int p;
   public int g;
   public int h;
   public int i;
   public int j;

   public final void a() {
      this.d = null;
      this.infoWaitToShow.removeAllElements();
   }

   public final void a(mGraphics var1, int var2, int var3, int var4) {
      if (this.infoWaitToShow.size() != 0) {
         var1.setColor(var2, var3);
         if (this.d != null && this.d.length != 0 && this.p != 1) {
            int var5 = mGraphics.zoomLevel == 1 ? 0 : 10;
            if (this.info.c == null) {
               PopUp.paintPopUp(var1, this.g, this.h, this.i, this.j, 16777215, false);
            } else {
               mSystem.a(var1, this.g - 23, this.h - var5 / 2, this.i + 15);
            }

            if (this.info.c == null) {
               var1.setColor(o, 0, 0, 9, 8, var4 == 1 ? 0 : 2, this.l - 3 + (var4 == 1 ? -15 : 20), this.m - 20 + this.k + 2, 17);
            }

            var4 = -1;

            for(int var6 = 0; var6 < this.d.length; ++var6) {
               mFont var7 = mFont.k;
               String var8 = this.d[var6];
               int var12;
               if (this.d[var6].startsWith("|")) {
                  String[] var9;
                  if ((var9 = ResLog.a(this.d[var6], "|", 0)).length == 3) {
                     var8 = var9[2];
                  }

                  if (var9.length == 4) {
                     var8 = var9[3];
                     Integer.parseInt(var9[2]);
                  }

                  var4 = var12 = Integer.parseInt(var9[1]);
               } else {
                  var12 = var4;
               }

               switch(var12) {
               case -1:
                  var7 = mFont.k;
                  break;
               case 0:
                  var7 = mFont.tahoma_7b_dark;
                  break;
               case 1:
                  var7 = mFont.h;
                  break;
               case 2:
                  var7 = mFont.b;
                  break;
               case 3:
                  var7 = mFont.p;
                  break;
               case 4:
                  var7 = mFont.r;
                  break;
               case 5:
                  var7 = mFont.q;
               case 6:
               default:
                  break;
               case 7:
                  var7 = mFont.a;
               }

               if (this.info.c == null) {
                  var7.drawStringBd(var1, var8, this.l, this.m - 15 + this.k + var6 * 12 - this.d.length * 12 - 9, 2);
               } else {
                  var12 = this.g - 23;
                  int var14 = this.h - var5 / 2;
                  int var10 = mSystem.d == 1 ? this.i + 28 : this.i + 25;
                  int var11 = this.j + (main.GameCanvas.isTouch ? 0 : 14) + var5;
                  var1.setColor(4465169);
                  var1.fillRect(var12, var14 + var11, var10, 2);
                  if ((var10 = this.info.f * var10 / this.info.g) < 0) {
                     var10 = 0;
                  }

                  var1.setColor(43758);
                  var1.fillRect(var12, var14 + var11, var10, 2);
                  if (this.info.f == 0) {
                     return;
                  }

                  this.info.c.a((mGraphics)var1, (int)(this.g + 5), (int)(this.h + this.j / 2), (int)0);
                  if (mGraphics.zoomLevel == 1) {
                     (this.info.d ? mFont.F : mFont.I).drawStringBd(var1, this.info.c.cName, this.g + 12, this.h + 3, 0);
                  } else {
                     (this.info.d ? mFont.F : mFont.I).drawStringBd(var1, this.info.c.cName, this.g + 12, this.h - 3, 0);
                  }

                  if (!main.GameCanvas.isTouch) {
                     if (!TField.g) {
                        mFont.G.drawStringBd(var1, "Nhấn # để chat", this.g + this.i / 2 + 10, this.h + this.j, 2);
                     } else {
                        mFont.G.drawStringBd(var1, "Nhấn Y để chat", this.g + this.i / 2 + 10, this.h + this.j, 2);
                     }
                  }

                  if (mGraphics.zoomLevel == 1) {
                     TextInfo.a(var1, var8, this.g + 14, this.h + this.j / 2 + 2, this.i - 16, this.j, mFont.H);
                  } else {
                     String[] var15 = mFont.H.getWidth(var8, 120);

                     for(int var13 = 0; var13 < var15.length; ++var13) {
                        mFont.H.drawStringBd(var1, var15[var13], this.g + 12, this.h + 12 + var13 * 12 - 3, 0);
                     }

                     main.GameCanvas.a(var1);
                  }
               }
            }
         }

         var1.setColor(-var2, -var3);
      }

   }

   public final void b() {
      if (this.infoWaitToShow.size() != 0 && this.info.f == 0) {
         ++this.e;
         if (this.e >= this.info.b) {
            this.e = 0;
            this.infoWaitToShow.removeElementAt(0);
            if (this.infoWaitToShow.size() == 0) {
               return;
            }

            InfoItem var1 = (InfoItem)this.infoWaitToShow.firstElement();
            this.info = var1;
            this.c();
         }
      }

   }

   public final void c() {
      this.c = 100;
      if (main.GameCanvas.z == 128) {
         this.c = 128;
      }

      int var1;
      if (this.info.c != null) {
         this.d = new String[]{this.info.a};
         if (mGraphics.zoomLevel == 1) {
            var1 = this.d.length;
         } else {
            var1 = mFont.H.getWidth(this.info.a, 120).length;
         }
      } else {
         this.d = mFont.k.getWidth(this.info.a, this.c - 10);
         var1 = this.d.length;
      }

      this.k = 7;
      this.g = this.l - this.c / 2 - 1;
      this.h = this.m - 15 + this.k - var1 * 12 - 15;
      this.i = this.c + 2 + (this.info.c != null ? 30 : 0);
      this.j = (var1 + 1) * 12 + 1 + (this.info.c != null ? 5 : 0);
   }

   public final void a(String var1, int var2, Char var3, boolean var4) {
      this.p = var2;
      if (this.infoWaitToShow.size() > 10) {
         this.infoWaitToShow.removeElementAt(0);
      }

      if (this.infoWaitToShow.size() > 0) {
         var1.equals(((InfoItem)this.infoWaitToShow.lastElement()).a);
      }

      InfoItem var5 = new InfoItem(var1);
      if (this.p == 0) {
         var5.b = var1.length();
      }

      if (var5.b < 70) {
         var5.b = 70;
      }

      if (this.p == 1) {
         var5.b = 10000000;
      }

      if (this.p == 3) {
         var5.b = 300;
         var5.h = mSystem.currentTimeMillis();
         var5.f = var1.length();
         if (var5.f < 15) {
            var5.f = 15;
         }

         if (var5.f > 100) {
            var5.f = 100;
         }

         var5.g = var5.f;
      }

      if (var3 != null) {
         var5.c = var3;
         var5.d = var4;
         main.GameCanvas.panel.a(var5);
         if (main.GameCanvas.isTouch && main.GameCanvas.panel.at) {
            GameScr.aD.i = new CommandLine(mResources.bp, this, 1000, var5);
         }
      }

      if (var3 != null && main.GameCanvas.panel.at || var3 == null) {
         this.infoWaitToShow.addElement(var5);
      }

      if (this.infoWaitToShow.size() == 1) {
         this.info = (InfoItem)this.infoWaitToShow.firstElement();
         this.c();
      }

      if (main.GameCanvas.isTouch && var3 != null && main.GameCanvas.panel.at && main.GameCanvas.z - 50 > 155 + this.i) {
         GameScr.aD.i.x = main.GameCanvas.z - this.i - 50;
         GameScr.aD.i.y = 35;
      }

   }

   public final void perform(int var1, Object var2) {
      if (var1 == 1000) {
         ChatTextField var10000 = ChatTextField.gI();
         GameScr.gI();
         var10000.a(mResources.cP);
      }

   }
}
