package nro;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.InputStream;
import javax.microedition.lcdui.Image;

public final class EffectData {
   public Image a;
   private ImageInfo[] h;
   private Frame[] i;
   public short[] b;
   public short[][] c = new short[16][];
   public int d;
   public int e = 0;
   public int f;
   public int g;

   public final void a(String var1) {
      DataInputStream var4;
      try {
         InputStream var3 = FireWorkMn.a(var1);
         var4 = new DataInputStream(var3);
      } catch (Exception var2) {
         return;
      }

      this.b(var4);
   }

   public final void readData2(String var1) {
      DataInputStream var4;
      try {
         InputStream var3 = FireWorkMn.a(var1);
         var4 = new DataInputStream(var3);
      } catch (Exception var2) {
         return;
      }

      this.a(var4);
   }

   private void a(DataInputStream var1) {
      short var2 = 0;
      short var3 = 0;
      int var4 = 0;
      int var5 = 0;

      try {
         byte var6 = var1.readByte();
         this.h = new ImageInfo[var6];

         for(int var7 = 0; var7 < var6; ++var7) {
            this.h[var7] = new ImageInfo();
            this.h[var7].a = var1.readByte();
            this.h[var7].b = (short)var1.readUnsignedByte();
            this.h[var7].c = (short)var1.readUnsignedByte();
            this.h[var7].d = (short)var1.readUnsignedByte();
            this.h[var7].e = (short)var1.readUnsignedByte();
         }

         short var11 = var1.readShort();
         this.i = new Frame[var11];

         int var10;
         for(var10 = 0; var10 < this.i.length; ++var10) {
            this.i[var10] = new Frame();
            byte var12 = var1.readByte();
            this.i[var10].a = new short[var12];
            this.i[var10].b = new short[var12];
            this.i[var10].c = new byte[var12];

            for(int var8 = 0; var8 < var12; ++var8) {
               this.i[var10].a[var8] = var1.readShort();
               this.i[var10].b[var8] = var1.readShort();
               this.i[var10].c[var8] = var1.readByte();
               if (var10 == 0) {
                  if (var2 > this.i[var10].a[var8]) {
                     var2 = this.i[var10].a[var8];
                  }

                  if (var3 > this.i[var10].b[var8]) {
                     var3 = this.i[var10].b[var8];
                  }

                  if (var4 < this.i[var10].a[var8] + this.h[this.i[var10].c[var8]].d) {
                     var4 = this.i[var10].a[var8] + this.h[this.i[var10].c[var8]].d;
                  }

                  if (var5 < this.i[var10].b[var8] + this.h[this.i[var10].c[var8]].e) {
                     var5 = this.i[var10].b[var8] + this.h[this.i[var10].c[var8]].e;
                  }

                  this.f = var4 - var2;
                  this.g = var5 - var3;
               }
            }
         }

         this.b = new short[var1.readShort()];

         for(var10 = 0; var10 < this.b.length; ++var10) {
            this.b[var10] = var1.readShort();
         }

      } catch (Exception var9) {
      }
   }

   private void b(DataInputStream var1) {
      short var2 = 0;
      short var3 = 0;
      int var4 = 0;
      int var5 = 0;

      try {
         byte var6 = var1.readByte();
         ResLog.c("small num= " + var6);
         this.h = new ImageInfo[var6];

         for(int var7 = 0; var7 < var6; ++var7) {
            this.h[var7] = new ImageInfo();
            this.h[var7].a = var1.readByte();
            this.h[var7].b = (short)var1.readUnsignedByte();
            this.h[var7].c = (short)var1.readUnsignedByte();
            this.h[var7].d = (short)var1.readUnsignedByte();
            this.h[var7].e = (short)var1.readUnsignedByte();
         }

         short var16 = var1.readShort();
         this.i = new Frame[var16];

         for(int var14 = 0; var14 < var16; ++var14) {
            this.i[var14] = new Frame();
            byte var8 = var1.readByte();
            this.i[var14].a = new short[var8];
            this.i[var14].b = new short[var8];
            this.i[var14].c = new byte[var8];

            for(int var9 = 0; var9 < var8; ++var9) {
               this.i[var14].a[var9] = var1.readShort();
               this.i[var14].b[var9] = var1.readShort();
               this.i[var14].c[var9] = var1.readByte();
               if (var14 == 0) {
                  if (var2 > this.i[var14].a[var9]) {
                     var2 = this.i[var14].a[var9];
                  }

                  if (var3 > this.i[var14].b[var9]) {
                     var3 = this.i[var14].b[var9];
                  }

                  if (var4 < this.i[var14].a[var9] + this.h[this.i[var14].c[var9]].d) {
                     var4 = this.i[var14].a[var9] + this.h[this.i[var14].c[var9]].d;
                  }

                  if (var5 < this.i[var14].b[var9] + this.h[this.i[var14].c[var9]].e) {
                     var5 = this.i[var14].b[var9] + this.h[this.i[var14].c[var9]].e;
                  }

                  this.f = var4 - var2;
                  this.g = var5 - var3;
               }
            }
         }

         short var15 = var1.readShort();
         this.b = new short[var15];
         if (this.d >= 201) {
            short[] var19 = new short[var15];
            int var11 = 0;
            String var12 = "";
            boolean var13 = false;

            for(var5 = 0; var5 < var15; ++var5) {
               var16 = var1.readShort();
               var12 = var12 + var16 + ",";
               this.b[var5] = var16;
               if (var16 + 500 >= 500) {
                  var19[var11++] = var16;
                  var13 = true;
               } else {
                  short var18 = (short)ResLog.g(var16 + 500);
                  this.c[var18] = new short[var11];
                  System.arraycopy(var19, 0, this.c[var18], 0, var11);
                  var11 = 0;
               }
            }

            if (!var13) {
               this.c[0] = new short[var11];
               System.arraycopy(var19, 0, this.c[0], 0, var11);
            } else {
               for(var5 = 0; var5 < 16; ++var5) {
                  if (this.c[var5] == null) {
                     this.c[var5] = this.c[2];
                  }
               }

            }
         } else {
            for(int var17 = 0; var17 < var15; ++var17) {
               this.b[var17] = var1.readShort();
            }

         }
      } catch (Exception var10) {
      }
   }

   public final void a(byte[] var1, byte var2) {
      ByteArrayInputStream var3 = new ByteArrayInputStream(var1);
      DataInputStream var4 = new DataInputStream(var3);
      this.a(var4, var2);
   }

   public final void a(byte[] var1) {
      ByteArrayInputStream var2 = new ByteArrayInputStream(var1);
      DataInputStream var3 = new DataInputStream(var2);
      this.b(var3);
   }

   public final void a(mGraphics var1, int var2, int var3, int var4, int var5, int var6) {
      if (this.i != null && this.i.length != 0) {
         Frame var12 = this.i[var2];

         for(int var7 = 0; var7 < var12.a.length; ++var7) {
            byte var9 = var12.c[var7];
            EffectData var8 = this;

            ImageInfo var10000;
            label51: {
               for(int var10 = 0; var10 < var8.h.length; ++var10) {
                  if (var8.h[var10].a == var9) {
                     var10000 = var8.h[var10];
                     break label51;
                  }
               }

               var10000 = null;
            }

            ImageInfo var13 = var10000;

            try {
               if (var5 == -1) {
                  var1.setColor(this.a, var13.b, var13.c, var13.d, var13.e, 0, var3 + var12.a[var7], var4 + var12.b[var7], 0);
               } else if (var5 == 0) {
                  var1.setColor(this.a, var13.b, var13.c, var13.d, var13.e, 0, var3 + var12.a[var7], var4 + var12.b[var7] - (var6 < 4 && var6 > 0 ? main.GameCanvas.ac : 0), 0);
               } else if (var5 == 1) {
                  var1.setColor(this.a, var13.b, var13.c, var13.d, var13.e, 2, var3 - var12.a[var7], var4 + var12.b[var7] - (var6 < 4 && var6 > 0 ? main.GameCanvas.ac : 0), StaticObj.TOP_RIGHT);
               } else if (var5 == 2) {
                  var1.setColor(this.a, var13.b, var13.c, var13.d, var13.e, 7, var3 - var12.a[var7], var4 + var12.b[var7] - (var6 < 4 && var6 > 0 ? main.GameCanvas.ac : 0), StaticObj.f);
               }
            } catch (Exception var11) {
            }
         }
      }

   }

   private void a(DataInputStream var1, byte var2) {
      short var3 = 0;
      short var4 = 0;
      int var5 = 0;
      int var6 = 0;

      try {
         byte var7 = var1.readByte();
         this.h = new ImageInfo[var7];

         int var8;
         for(var8 = 0; var8 < var7; ++var8) {
            this.h[var8] = new ImageInfo();
            this.h[var8].a = var1.readByte();
            if (var2 == 1) {
               this.h[var8].b = (short)var1.readUnsignedByte();
               this.h[var8].c = (short)var1.readUnsignedByte();
            } else {
               this.h[var8].b = var1.readShort();
               this.h[var8].c = var1.readShort();
            }

            this.h[var8].d = (short)var1.readUnsignedByte();
            this.h[var8].e = (short)var1.readUnsignedByte();
         }

         short var11 = var1.readShort();
         this.i = new Frame[var11];

         int var10;
         for(var10 = 0; var10 < this.i.length; ++var10) {
            this.i[var10] = new Frame();
            var7 = var1.readByte();
            this.i[var10].a = new short[var7];
            this.i[var10].b = new short[var7];
            this.i[var10].c = new byte[var7];

            for(var8 = 0; var8 < var7; ++var8) {
               this.i[var10].a[var8] = var1.readShort();
               this.i[var10].b[var8] = var1.readShort();
               this.i[var10].c[var8] = var1.readByte();
               if (var10 == 0) {
                  if (var3 > this.i[var10].a[var8]) {
                     var3 = this.i[var10].a[var8];
                  }

                  if (var4 > this.i[var10].b[var8]) {
                     var4 = this.i[var10].b[var8];
                  }

                  if (var5 < this.i[var10].a[var8] + this.h[this.i[var10].c[var8]].d) {
                     var5 = this.i[var10].a[var8] + this.h[this.i[var10].c[var8]].d;
                  }

                  if (var6 < this.i[var10].b[var8] + this.h[this.i[var10].c[var8]].e) {
                     var6 = this.i[var10].b[var8] + this.h[this.i[var10].c[var8]].e;
                  }

                  this.f = var5 - var3;
                  this.g = var6 - var4;
               }
            }
         }

         this.b = new short[var1.readShort()];

         for(var10 = 0; var10 < this.b.length; ++var10) {
            this.b[var10] = var1.readShort();
         }

      } catch (Exception var9) {
      }
   }
}
