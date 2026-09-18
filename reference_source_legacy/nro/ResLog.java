package nro;

import java.util.Random;

public final class ResLog {
   private static short[] d = new short[]{0, 18, 36, 54, 71, 89, 107, 125, 143, 160, 178, 195, 213, 230, 248, 265, 282, 299, 316, 333, 350, 367, 384, 400, 416, 433, 449, 465, 481, 496, 512, 527, 543, 558, 573, 587, 602, 616, 630, 644, 658, 672, 685, 698, 711, 724, 737, 749, 761, 773, 784, 796, 807, 818, 828, 839, 849, 859, 868, 878, 887, 896, 904, 912, 920, 928, 935, 943, 949, 956, 962, 968, 974, 979, 984, 989, 994, 998, 1002, 1005, 1008, 1011, 1014, 1016, 1018, 1020, 1022, 1023, 1023, 1024, 1024};
   private static short[] e;
   private static int[] f;
   public static Random a;
   public static boolean b;
   public static boolean c;

   static {
      String[] var10000 = new String[]{"<color=#ff0000ff>[  LOG_CAT  ]</color>", "<color=#ff0000ff>[LOG_SESSION]</color>", "<color=#ffff00ff>[LOG_SESSION]</color>", "<color=#ff0000ff>[LOG_MOBILE ]</color>", ""};
      a = new Random();
      new MyVector("");
   }

   public static void a() {
      e = new short[91];
      f = new int[91];

      for(int var0 = 0; var0 <= 90; ++var0) {
         e[var0] = d[90 - var0];
         if (e[var0] == 0) {
            f[var0] = Integer.MAX_VALUE;
         } else {
            f[var0] = (d[var0] << 10) / e[var0];
         }
      }

   }

   public static final int a(int var0) {
      if ((var0 = c(var0)) >= 0 && var0 < 90) {
         return d[var0];
      } else if (var0 >= 90 && var0 < 180) {
         return d[180 - var0];
      } else {
         return var0 >= 180 && var0 < 270 ? -d[var0 - 180] : -d[360 - var0];
      }
   }

   public static final int b(int var0) {
      if ((var0 = c(var0)) >= 0 && var0 < 90) {
         return e[var0];
      } else if (var0 >= 90 && var0 < 180) {
         return -e[180 - var0];
      } else {
         return var0 >= 180 && var0 < 270 ? -e[var0 - 180] : e[360 - var0];
      }
   }

   public static final int a(int var0, int var1) {
      int var10000;
      int var2;
      if (var0 != 0) {
         var2 = Math.abs((var1 << 10) / var0);

         label44: {
            for(int var3 = 0; var3 <= 90; ++var3) {
               if (f[var3] >= var2) {
                  var10000 = var3;
                  break label44;
               }
            }

            var10000 = 0;
         }

         var2 = var10000;
         if (var1 >= 0 && var0 < 0) {
            var2 = 180 - var2;
         }

         if (var1 < 0 && var0 < 0) {
            var2 += 180;
         }

         if (var1 >= 0 || var0 < 0) {
            return var2;
         }

         var10000 = 360 - var2;
      } else {
         var10000 = var1 > 0 ? 90 : 270;
      }

      var2 = var10000;
      return var2;
   }

   public static final int c(int var0) {
      if (var0 >= 360) {
         var0 -= 360;
      }

      if (var0 < 0) {
         var0 += 360;
      }

      return var0;
   }

   public static void a(mGraphics var0) {
      mFont.tahoma_7b_dark.drawStringBd(var0, "check Controller= " + Service.d, 3, 55, 0);
      mFont.tahoma_7b_dark.drawStringBd(var0, "check Map= " + Service.e, 3, 75, 0);
   }

   public static void b() {
      long var0 = mSystem.currentTimeMillis();
      if (Service.b - var0 > 5000L) {
         Service.gI().sendCheckController();
      }

      if (Service.c - var0 > 5000L) {
         Service.gI().sendCheckMap();
      }

   }

   public static String a(String var0) {
      if (mSystem.d != 7) {
         return var0;
      } else if (Char.myCharz() != null && Char.myCharz().aD != null && Char.myCharz().aD.c >= 10) {
         return var0;
      } else {
         if (var0.indexOf("Gohan") != -1) {
            var0 = a(var0, "Gohan", "Hango");
         }

         if (var0.indexOf("Gôhan") != -1) {
            var0 = a(var0, "Gôhan", "Hango");
         }

         if (var0.indexOf("Bunma") != -1) {
            var0 = a(var0, "Bunma", "Mabun");
         }

         if (var0.indexOf("Bunman") != -1) {
            var0 = a(var0, "Bunman", "Mabun");
         }

         if (var0.indexOf("Bun ma") != -1) {
            var0 = a(var0, "Bun ma", "Mabun");
         }

         if (var0.indexOf("Đậu thần") != -1) {
            var0 = a(var0, "Đậu thần", "Cây thần");
         }

         if (var0.indexOf("Mabu") != -1) {
            var0 = a(var0, "Mabu", "Buma");
         }

         if (var0.indexOf("Ma bư") != -1) {
            var0 = a(var0, "Ma bư", "Buma");
         }

         if (var0.indexOf("Xayda") != -1) {
            var0 = a(var0, "Xayda", "Dasay");
         }

         if (var0.indexOf("Xay da") != -1) {
            var0 = a(var0, "Xay da", "Dasay");
         }

         if (var0.indexOf("Namếc") != -1) {
            var0 = a(var0, "Namếc", "Mecda");
         }

         if (var0.indexOf("Na mếc") != -1) {
            var0 = a(var0, "Na mếc", "Mecda");
         }

         if (var0.indexOf("Namek") != -1) {
            var0 = a(var0, "Namek", "Mecda");
         }

         if (var0.indexOf("Rồng thần") != -1) {
            var0 = a(var0, "Rồng thần", "Rồng đất");
         }

         if (var0.indexOf("Kame") != -1) {
            var0 = a(var0, "Kame", "Meka");
         }

         if (var0.indexOf("Vegeta") != -1) {
            var0 = a(var0, "Vegeta", "Tageve");
         }

         if (var0.indexOf("Kakalot") != -1) {
            var0 = a(var0, "Kakalot", "Lotkaka");
         }

         if (var0.indexOf("Broly") != -1) {
            var0 = a(var0, "Broly", "Lybro");
         }

         if (var0.indexOf("Ngọc rồng") != -1) {
            var0 = a(var0, "Ngọc rồng", "Ngọc thần");
         }

         if (var0.indexOf("ngọc rồng") != -1) {
            var0 = a(var0, "ngọc rồng", "Ngọc thần");
         }

         if (var0.indexOf("Radic") != -1) {
            var0 = a(var0, "Radic", "Dicra");
         }

         if (var0.indexOf("Ra dic") != -1) {
            var0 = a(var0, "Ra dic", "Dicra");
         }

         if (var0.indexOf("Ra đíc") != -1) {
            var0 = a(var0, "Ra đíc", "Dicra");
         }

         if (var0.indexOf("Cadic") != -1) {
            var0 = a(var0, "Cadic", "Dicca");
         }

         if (var0.indexOf("Ca dic") != -1) {
            var0 = a(var0, "Ca dic", "Dicca");
         }

         if (var0.indexOf("Ca đíc") != -1) {
            var0 = a(var0, "Ca đíc", "Dicca");
         }

         if (var0.indexOf("Quy lão") != -1) {
            var0 = a(var0, "Quy lão", "Lão");
         }

         if (var0.indexOf("quy lão") != -1) {
            var0 = a(var0, "quy lão", "lão");
         }

         if (var0.indexOf("QuyLão") != -1) {
            var0 = a(var0, "Quy Lão", "Lão");
         }

         if (var0.indexOf("Santa") != -1) {
            var0 = a(var0, "Santa", "Tasan");
         }

         if (var0.indexOf("Hạt Mít") != -1) {
            var0 = a(var0, "Hạt Mít", "Hạt Dẻ");
         }

         if (var0.indexOf("Hạt mít") != -1) {
            var0 = a(var0, "Hạt mít", "Hạt dẻ");
         }

         if (var0.indexOf("Tàu bảy bảy") != -1) {
            var0 = a(var0, "Tàu bảy bảy", "Tàu tàu");
         }

         if (var0.indexOf("Uron") != -1) {
            var0 = a(var0, "Uron", "Onru");
         }

         if (var0.indexOf("U ron") != -1) {
            var0 = a(var0, "U ron", "Onru");
         }

         if (var0.indexOf("Urôn") != -1) {
            var0 = a(var0, "Urôn", "Onru");
         }

         if (var0.indexOf("Ngọc Rồng") != -1) {
            var0 = a(var0, "Ngọc Rồng", "Ngọc thần");
         }

         if (var0.indexOf("Ngọc rồng") != -1) {
            var0 = a(var0, "Ngọc rồng", "Ngọc thần");
         }

         if (var0.indexOf("Fide") != -1) {
            var0 = a(var0, "Fide", "Defi");
         }

         if (var0.indexOf("Vegeta") != -1) {
            var0 = a(var0, "Vegeta", "Tageve");
         }

         if (var0.indexOf("Moori") != -1) {
            var0 = a(var0, "Moori", "Rimoo");
         }

         if (var0.indexOf("Aru") != -1) {
            var0 = a(var0, "Aru", "Ura");
         }

         if (var0.indexOf("Kamejoko") != -1) {
            var0 = a(var0, "Kamejoko", "Kojomeka");
         }

         if (var0.indexOf("kamejoko") != -1) {
            var0 = a(var0, "kamejoko", "kojomeka");
         }

         if (var0.indexOf("Kame") != -1) {
            var0 = a(var0, "Kame", "Meka");
         }

         if (var0.indexOf("kame") != -1) {
            var0 = a(var0, "kame", "meka");
         }

         if (var0.indexOf("Masenko") != -1) {
            var0 = a(var0, "Masenko", "Kosenma");
         }

         if (var0.indexOf("Thái Dương Hạ San") != -1) {
            var0 = a(var0, "Thái Dương Hạ San", "Hạ Dương");
         }

         if (var0.indexOf("Solar flare") != -1) {
            var0 = a(var0, "Solar flare", "Solar");
         }

         if (var0.indexOf("Quả cầu kênh khi") != -1) {
            var0 = a(var0, "Quả cầu kênh khi", "Quả cầu");
         }

         if (var0.indexOf("Genki-Dama") != -1) {
            var0 = a(var0, "Genki-Dama", "Dama");
         }

         if (var0.indexOf("Genki-Dama") != -1) {
            var0 = a(var0, "Genki-Dama", "Dama");
         }

         if (var0.indexOf("Makankosappo") != -1) {
            var0 = a(var0, "Makankosappo", "Oppasoknakam");
         }

         return var0;
      }
   }

   public static String a(String var0, String var1, String var2) {
      StringBuffer var3 = new StringBuffer();
      int var4 = var0.indexOf(var1);
      int var5 = 0;

      for(int var6 = var1.length(); var4 != -1; var4 = var0.indexOf(var1, var5)) {
         var3.append(var0.substring(var5, var4)).append(var2);
         var5 = var4 + var6;
      }

      var3.append(var0.substring(var5, var0.length()));
      return var3.toString();
   }

   public static int d(int var0) {
      return a.nextInt(var0);
   }

   public static int random(int var0, int var1) {
      return var0 == var1 ? var0 : var0 + a.nextInt(var1 - var0);
   }

   public static int e(int var0) {
      int var1;
      for(var1 = 0; var1 == 0; var1 = a.nextInt() % var0) {
      }

      return var1;
   }

   public static int c(int var0, int var1) {
      var0 += a.nextInt(var1 - var0);
      byte var2 = 2;
      if (a.nextInt(var2) == 0) {
         var0 = -var0;
      }

      return var0;
   }

   public static int a(int var0, int var1, int var2, int var3) {
      return f((var0 - var2) * (var0 - var2) + (var1 - var3) * (var1 - var3));
   }

   public static int d(int var0, int var1) {
      return f(var0 * var0 + var1 * var1);
   }

   public static int f(int var0) {
      if (var0 <= 0) {
         return 0;
      } else {
         int var1 = (var0 + 1) / 2;

         int var2;
         do {
            var2 = var1;
            var1 = var1 / 2 + var0 / (var1 * 2);
         } while(Math.abs(var2 - var1) > 1);

         return var1;
      }
   }

   public static int e(int var0, int var1) {
      var1 = 1;

      for(int var2 = 0; var2 < 2; ++var2) {
         var1 *= var0;
      }

      return var1;
   }

   public static int g(int var0) {
      return var0 > 0 ? var0 : -var0;
   }

   public static boolean a(int var0, int var1, int var2, int var3, int var4, int var5) {
      return var4 >= var0 && var4 <= var0 + var2 && var5 >= var1 && var5 <= var1 + var3;
   }

   public static void b(String var0) {
   }

   public static void c(String var0) {
   }

   public static String[] a(String var0, String var1, int var2) {
      int var3;
      String[] var4;
      if ((var3 = var0.indexOf(var1)) >= 0) {
         var4 = a(var0.substring(var3 + var1.length()), var1, var2 + 1);
      } else {
         var4 = new String[var2 + 1];
         var3 = var0.length();
      }

      var4[var2] = var0.substring(0, var3);
      return var4;
   }

   public static String a(long var0) {
      String var2;
      long var4;
      String var6;
      if (var0 >= 1000000000L) {
         var2 = mResources.bf;
         var4 = var0 % 1000000000L / 100000000L;
         var0 /= 1000000000L;
         var6 = String.valueOf(var0);
         if (var4 > 0L) {
            var6 = var6 + "," + var4 + var2;
         } else {
            var6 = var6 + var2;
         }
      } else if (var0 >= 1000000L) {
         var2 = mResources.bg;
         var4 = var0 % 1000000L / 100000L;
         var0 /= 1000000L;
         var6 = String.valueOf(var0);
         if (var4 > 0L) {
            var6 = var6 + "," + var4 + var2;
         } else {
            var6 = var6 + var2;
         }
      } else {
         var6 = String.valueOf(var0);
      }

      return var6;
   }

   public static String b(long var0) {
      String var2;
      long var4;
      String var6;
      if (var0 >= 1000000000L) {
         var2 = mResources.bf;
         var4 = var0 % 1000000000L / 10000000L;
         var0 /= 1000000000L;
         var6 = String.valueOf(var0);
         if (var4 >= 10L) {
            if (var4 % 10L == 0L) {
               var4 /= 10L;
            }

            var6 = var6 + "," + var4 + var2;
         } else if (var4 > 0L) {
            var6 = var6 + ",0" + var4 + var2;
         } else {
            var6 = var6 + var2;
         }
      } else if (var0 >= 1000000L) {
         var2 = mResources.bg;
         var4 = var0 % 1000000L / 10000L;
         var0 /= 1000000L;
         var6 = String.valueOf(var0);
         if (var4 >= 10L) {
            if (var4 % 10L == 0L) {
               var4 /= 10L;
            }

            var6 = var6 + "," + var4 + var2;
         } else if (var4 > 0L) {
            var6 = var6 + ",0" + var4 + var2;
         } else {
            var6 = var6 + var2;
         }
      } else if (var0 >= 10000L) {
         var2 = "k";
         var4 = var0 % 1000L / 10L;
         var0 /= 1000L;
         var6 = String.valueOf(var0);
         if (var4 >= 10L) {
            if (var4 % 10L == 0L) {
               var4 /= 10L;
            }

            var6 = var6 + "," + var4 + var2;
         } else if (var4 > 0L) {
            var6 = var6 + ",0" + var4 + var2;
         } else {
            var6 = var6 + var2;
         }
      } else {
         var6 = String.valueOf(var0);
      }

      return var6;
   }
}
