package nro;

import javax.microedition.lcdui.Image;

public final class nr_cx {
   public int a;
   public int b;
   public short c;
   public int d;
   public int e;
   public int f;
   public int g;
   public byte h;
   public int[] i;
   public int[] j;
   public static MyHashTable k = new MyHashTable("imgNew BgItem");
   public static MyVector l = new MyVector("vKeyNews");
   public static MyVector m = new MyVector("vKeyLast");
   public static byte[] n;
   private int o = 0;
   private int p = 0;
   private static int[] q = new int[]{79, 80, 81, 85, 86, 90, 91, 92, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108};

   public static void a() {
      k.clear();
      l.removeAllElements();
      m.removeAllElements();
   }

   public static boolean a(String var0) {
      for(int var1 = 0; var1 < l.size(); ++var1) {
         if (((String)l.elementAt(var1)).equals(var0)) {
            return true;
         }
      }

      return false;
   }

   private boolean b() {
      for(int var1 = 0; var1 < q.length; ++var1) {
         if (this.c == q[var1]) {
            return true;
         }
      }

      return false;
   }

   public final void a(mGraphics var1) {
      if (!Char.isLoadingMap) {
         if (this.c != 279 || GameScr.gI().bT < 110) {
            int var2 = GameScr.cmx;
            int var3 = GameScr.cmy;
            Image var4;
            if ((var4 = (Image)k.get(String.valueOf(this.c))) != null) {
               if (this.c == 96) {
                  return;
               }

               if (this.h == 4) {
                  this.o = -var2 / 2 + 100;
               }

               if (this.c == 28 && this.h == 3) {
                  this.o = -var2 / 3 + 200;
               }

               if ((this.c == 67 || this.c == 68 || this.c == 69 || this.c == 70) && this.h == 3) {
                  this.o = -var2 / 3 + 200;
               }

               if (this.b() && this.h < 4) {
                  this.o = -(var2 >> 4) + 50;
                  this.p = (var3 >> 5) - 15;
               }

               int var5 = this.d + this.f + this.o;
               int var6 = this.e + this.g + this.p;
               if (this.d + this.f + var4.getWidth() + this.o >= var2 && this.d + this.f + this.o <= var2 + main.GameCanvas.z && this.e + this.g + this.p + var4.getHeight() >= var3 && this.e + this.g + this.p <= var3 + main.GameCanvas.A) {
                  var1.setColor(var4, 0, 0, mGraphics.setColor(var4), mGraphics.b(var4), this.b, this.d + this.f + this.o, this.e + this.g + this.p, 0);
                  if (this.c == 11 && TileMap.l != 122) {
                     var1.e(var5, var6 + 24, 48, 14);

                     for(int var7 = 0; var7 < 2; ++var7) {
                        var1.setColor(TileMap.h, 0, (main.GameCanvas.v % 8 >> 2) * 24, 24, 24, 0, var5 + var7 * 24, var6 + 24, 0);
                     }

                     var1.e(GameScr.cmx, GameScr.cmy, GameScr.d, GameScr.e);
                  }
               }

               if (TileMap.g() && this.c > 137 && this.c != 156 && this.c != 159 && this.c != 157 && this.c != 165 && this.c != 167 && this.c != 168 && this.c != 169 && this.c != 170 && this.c != 238 && TileMap.c - (this.d + this.f + this.o) >= var2 && TileMap.c - (this.d + this.f + this.o + var4.getWidth()) <= var2 + main.GameCanvas.z && this.e + this.g + this.p + var4.getHeight() >= var3 && this.e + this.g + this.p <= var3 + main.GameCanvas.A && (this.c < 241 || this.c >= 266)) {
                  var1.setColor(var4, 0, 0, mGraphics.setColor(var4), mGraphics.b(var4), 2, TileMap.c - (this.d + this.f + this.o) - mGraphics.setColor(var4), this.e + this.g + this.p, 0);
               }
            }

         }
      }
   }
}
