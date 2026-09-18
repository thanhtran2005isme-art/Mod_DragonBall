package nro;

public class Npc extends Char {
   public NpcTemplate template;
   public static NpcTemplate[] npcTemplates;
   public boolean de;
   private int a;
   private int b;
   public static boolean df;
   private static int c;
   public int[] dg;
   private int d;
   private long e;
   private long f;
   public int dh;

   static {
      int[] var10000 = new int[]{1, -1, 1, -1};
      var10000 = new int[]{1, -1, -1, 1};
   }

   public Npc(int var1, int var2, int var3, int var4, int var5, int var6) {
      super.bd = true;
      super.aO = var6;
      ResLog.c("npc avatar= " + super.aO);
      super.cx = var3;
      super.cy = var4;
      super.cl = var3;
      super.cm = var4;
      super.statusMe = var2;
      if (var1 != -1) {
         this.template = npcTemplates[var5];
      }

      if (var5 == 23 || var5 == 42) {
         super.al = 45;
      }

      if (var5 == 51) {
         super.bd = false;
         this.a = var2;
         ResLog.c("duaHau = " + var2);
      }

      if (this.template != null) {
         if (this.template.name == null) {
            this.template.name = "";
         }

         this.template.name = ResLog.a(this.template.name);
      }

   }

   public final void a(byte var1, int var2) {
      this.a = var1;
      this.e = this.f = System.currentTimeMillis();
      this.d = var2;
      ResLog.c("in ra second= " + this.d);
   }

   public static void aa() {
      for(int var0 = 0; var0 < GameScr.G.size(); ++var0) {
         Npc var1;
         (var1 = (Npc)GameScr.G.elementAt(var0)).effTask = null;
         var1.indexEffTask = -1;
      }

   }

   public void a() {
      if (this.template.npcTemplateId == 51) {
         this.f = System.currentTimeMillis();
         if (this.f - this.e >= 1000L) {
            --this.d;
            this.e = this.f;
            if (this.d < 0) {
               this.d = 0;
            }
         }
      }

      if (super.bd) {
         this.H();
      }

      if (super.effTask == null) {
         label75: {
            byte[] var1 = new byte[]{-1, 9, 9, 10, 10, 11, 11};
            if (Char.myCharz().ctaskId >= 9 && Char.myCharz().ctaskId <= 10 && Char.myCharz().nClass.a > 0 && var1[Char.myCharz().nClass.a] == this.template.npcTemplateId) {
               if (Char.myCharz().aD == null) {
                  super.effTask = GameScr.y[57];
               } else {
                  if (Char.myCharz().aD == null || Char.myCharz().aD.a + 1 != Char.myCharz().aD.f.length) {
                     break label75;
                  }

                  super.effTask = GameScr.y[62];
               }
            } else {
               GameScr.gI();
               byte var2 = GameScr.A();
               if (Char.myCharz().aD != null || var2 != this.template.npcTemplateId) {
                  if (Char.myCharz().aD == null || var2 != this.template.npcTemplateId) {
                     break label75;
                  }

                  int var10000 = Char.myCharz().aD.a + 1;
                  int var10001 = Char.myCharz().aD.f.length;
                  super.effTask = GameScr.y[98];
               }
            }

            super.indexEffTask = 0;
         }
      }

      super.a();
      if (TileMap.l == 51) {
         if (super.cx > Char.myCharz().cx) {
            super.I = -1;
         } else {
            super.I = 1;
         }

         if (this.template.npcTemplateId % 2 == 0) {
            if (super.as == 1) {
               super.as = 0;
               return;
            }

            super.as = 1;
         }
      }

   }

   public void a(mGraphics var1) {
      if (!Char.isLoadingMap) {
         if (!this.de) {
            if (this.G()) {
               if (super.statusMe != 15) {
                  if (super.cTypePk != 0) {
                     super.a(var1);
                  } else if (this.template != null) {
                     if (this.template.npcTemplateId != 4 && this.template.npcTemplateId != 51 && this.template.npcTemplateId != 50) {
                        var1.drawImage(TileMap.x, super.cx, super.cy, 3);
                     }

                     if (this.template.npcTemplateId == 3) {
                        SmallImage.b(var1, 265, super.cx, super.cy, 0, 33);
                        if (Char.myCharz().aT != null && Char.myCharz().aT.equals(this) && ChatPopup.currChatPopup == null) {
                           var1.setColor(Mob.R, 0, 0, 9, 6, 0, super.cx, super.cy - super.al + 4, 33);
                        }

                        this.b = 60;
                     } else if (this.template.npcTemplateId != 4) {
                        int var2;
                        if (this.template.npcTemplateId != 50 && this.template.npcTemplateId != 51) {
                           if (this.template.npcTemplateId == 6) {
                              SmallImage.b(var1, 545, super.cx, super.cy + 5, 0, 33);
                              if (Char.myCharz().aT != null && Char.myCharz().aT.equals(this) && ChatPopup.currChatPopup == null) {
                                 var1.setColor(Mob.R, 0, 0, 9, 6, 0, super.cx, super.cy - super.al - 9, 33);
                              }

                              mFont.c.drawStringBd(var1, String.valueOf(TileMap.n), super.cx, super.cy - super.al + 19 - mFont.k.getWidth(), 2);
                           } else {
                              var2 = this.template.headId;
                              int var3 = this.template.legId;
                              int var4 = this.template.bodyId;
                              Rms var7 = GameScr.x[var2];
                              Rms var5 = GameScr.x[var3];
                              Rms var8 = GameScr.x[var4];
                              if (super.I == 1) {
                                 SmallImage.b(var1, var7.a[Char.bC[super.as][0][0]].a, super.cx + Char.bC[super.as][0][1] + var7.a[Char.bC[super.as][0][0]].b, super.cy - Char.bC[super.as][0][2] + var7.a[Char.bC[super.as][0][0]].c, 0, 0);
                                 SmallImage.b(var1, var5.a[Char.bC[super.as][1][0]].a, super.cx + Char.bC[super.as][1][1] + var5.a[Char.bC[super.as][1][0]].b, super.cy - Char.bC[super.as][1][2] + var5.a[Char.bC[super.as][1][0]].c, 0, 0);
                                 SmallImage.b(var1, var8.a[Char.bC[super.as][2][0]].a, super.cx + Char.bC[super.as][2][1] + var8.a[Char.bC[super.as][2][0]].b, super.cy - Char.bC[super.as][2][2] + var8.a[Char.bC[super.as][2][0]].c, 0, 0);
                              } else {
                                 SmallImage.b(var1, var7.a[Char.bC[super.as][0][0]].a, super.cx - Char.bC[super.as][0][1] - var7.a[Char.bC[super.as][0][0]].b, super.cy - Char.bC[super.as][0][2] + var7.a[Char.bC[super.as][0][0]].c, 2, 24);
                                 SmallImage.b(var1, var5.a[Char.bC[super.as][1][0]].a, super.cx - Char.bC[super.as][1][1] - var5.a[Char.bC[super.as][1][0]].b, super.cy - Char.bC[super.as][1][2] + var5.a[Char.bC[super.as][1][0]].c, 2, 24);
                                 SmallImage.b(var1, var8.a[Char.bC[super.as][2][0]].a, super.cx - Char.bC[super.as][2][1] - var8.a[Char.bC[super.as][2][0]].b, super.cy - Char.bC[super.as][2][2] + var8.a[Char.bC[super.as][2][0]].c, 2, 24);
                              }

                              if (TileMap.l != 51) {
                                 byte var9 = 15;
                                 if (this.template.npcTemplateId == 47) {
                                    var9 = 47;
                                 }

                                 if (Char.myCharz().aT != null && Char.myCharz().aT.equals(this) && ChatPopup.currChatPopup == null) {
                                    byte var6 = 0;
                                    byte var10 = 0;
                                    if (Char.myCharz().aT.template.npcTemplateId == 28 || Char.myCharz().aT.template.npcTemplateId == 41) {
                                       var6 = 3;
                                       var10 = -12;
                                    }

                                    var1.setColor(Mob.R, 0, 0, 9, 6, 0, super.cx + var6, super.cy - super.al - (var9 - 8) + var10, 33);
                                 }
                              }

                              this.b = 65;
                           }
                        } else if (this.dg != null) {
                           if (this.template.npcTemplateId == 50 && df) {
                              ++c;
                              if (main.GameCanvas.v % 3 == 0) {
                                 EffecMn.addEff(new Effect(19, super.cx + ResLog.random(-50, 50), super.cy, 2, 1, -1));
                              }

                              if (main.GameCanvas.v % 15 == 0) {
                                 EffecMn.addEff(new Effect(18, super.cx + ResLog.random(-5, 5), super.cy + ResLog.random(-90, 0), 2, 1, -1));
                              }

                              if (c == 100) {
                                 GameScr.gI().b(super.cx, super.cy);
                              }

                              if (c == 110) {
                                 df = false;
                                 this.template.npcTemplateId = 4;
                              }
                           }

                           var2 = 0;
                           if (SmallImage.c[this.dg[this.a]] != null && SmallImage.c[this.dg[this.a]].a != null) {
                              var2 = mGraphics.b(SmallImage.c[this.dg[this.a]].a);
                           }

                           SmallImage.b(var1, this.dg[this.a], super.cx + ResLog.random(-1, 1), super.cy, 0, 33);
                           if (Char.myCharz().aT != null && Char.myCharz().aT.equals(this)) {
                              if (ChatPopup.currChatPopup == null) {
                                 var1.setColor(Mob.R, 0, 0, 9, 6, 0, super.cx, super.cy - super.al - 9 + 16 - var2, 33);
                              }

                              mFont.c.drawString(var1, Util.b(this.d), super.cx, super.cy - super.al - 16 - mFont.k.getWidth() - 20 - var2 + 16, 2, mFont.tahoma_7b_dark);
                           } else {
                              mFont.c.drawString(var1, Util.b(this.d), super.cx, super.cy - super.al - 8 - mFont.k.getWidth() - 20 - var2 + 16, 2, mFont.tahoma_7b_dark);
                           }
                        }
                     }

                     if (super.indexEffTask >= 0 && super.effTask != null && super.cTypePk == 0) {
                        SmallImage.b(var1, super.effTask.a[super.indexEffTask].c, super.cx + super.effTask.a[super.indexEffTask].a, super.cy + super.effTask.a[super.indexEffTask].b - this.b, 0, 3);
                        if (main.GameCanvas.v % 2 == 0) {
                           ++super.indexEffTask;
                           if (super.indexEffTask >= super.effTask.a.length) {
                              super.indexEffTask = 0;
                           }
                        }
                     }

                  }
               }
            }
         }
      }
   }

   public final void e(mGraphics var1) {
      if (!Char.isLoadingMap) {
         if (!this.de) {
            if (this.G()) {
               if (super.statusMe != 15) {
                  if (this.template != null) {
                     if (this.template.npcTemplateId == 3) {
                        if (Char.myCharz().aT != null && Char.myCharz().aT.equals(this)) {
                           mFont.n.drawString(var1, this.template.name, super.cx, super.cy - super.al - mFont.k.getWidth() - 5, 2, mFont.o);
                        } else {
                           mFont.n.drawString(var1, this.template.name, super.cx, super.cy - super.al - 3 - mFont.k.getWidth(), 2, mFont.o);
                        }

                        this.b = 60;
                     } else {
                        if (this.template.npcTemplateId != 4) {
                           if (this.template.npcTemplateId != 50 && this.template.npcTemplateId != 51) {
                              if (this.template.npcTemplateId == 6) {
                                 if (Char.myCharz().aT != null && Char.myCharz().aT.equals(this)) {
                                    mFont.n.drawString(var1, this.template.name, super.cx, super.cy - super.al - mFont.k.getWidth() - 16, 2, mFont.o);
                                    return;
                                 }

                                 mFont.n.drawString(var1, this.template.name, super.cx, super.cy - super.al - 8 - mFont.k.getWidth(), 2, mFont.o);
                                 return;
                              }

                              if (TileMap.l != 51) {
                                 byte var5 = 15;
                                 if (this.template.npcTemplateId == 47) {
                                    var5 = 47;
                                 }

                                 byte var3;
                                 byte var4;
                                 if (Char.myCharz().aT != null && Char.myCharz().aT.equals(this)) {
                                    if (TileMap.l != 113) {
                                       var3 = 0;
                                       var4 = 0;
                                       if (Char.myCharz().aT.template.npcTemplateId == 28 || Char.myCharz().aT.template.npcTemplateId == 41) {
                                          var3 = 3;
                                          var4 = -12;
                                       }

                                       mFont.n.drawString(var1, this.template.name, super.cx + var3, super.cy - super.al - mFont.k.getWidth() - var5 + var4, 2, mFont.o);
                                    }
                                 } else {
                                    var5 = 8;
                                    if (this.template.npcTemplateId == 47) {
                                       var5 = 40;
                                    }

                                    if (TileMap.l != 113) {
                                       var3 = 0;
                                       var4 = 0;
                                       if (this.template.npcTemplateId == 28 || this.template.npcTemplateId == 41) {
                                          var3 = 3;
                                          var4 = -12;
                                       }

                                       mFont.n.drawString(var1, this.template.name, super.cx + var3, super.cy - super.al - var5 - mFont.k.getWidth() + var4, 2, mFont.o);
                                    }
                                 }
                              }

                              this.b = 65;
                           } else if (this.dg != null) {
                              int var2 = 0;
                              if (SmallImage.c[this.dg[this.a]] != null && SmallImage.c[this.dg[this.a]].a != null) {
                                 var2 = mGraphics.b(SmallImage.c[this.dg[this.a]].a);
                              }

                              if (Char.myCharz().aT != null && Char.myCharz().aT.equals(this)) {
                                 mFont.n.drawString(var1, this.template.name, super.cx, super.cy - super.al - mFont.k.getWidth() - var2, 2, mFont.o);
                                 return;
                              }

                              mFont.n.drawString(var1, this.template.name, super.cx, super.cy - super.al - 8 - mFont.k.getWidth() - var2 + 16, 2, mFont.o);
                              return;
                           }
                        }

                     }
                  }
               }
            }
         }
      }
   }

   public final void k() {
      super.statusMe = 15;
      Char.x = null;
   }
}
