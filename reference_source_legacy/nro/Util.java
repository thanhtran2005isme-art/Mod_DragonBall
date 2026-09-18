package nro;

import java.io.DataInputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Util {
   public int a;
   public short[] b;
   public short c;
   public String[] d;
   public String[] e;
   public String[] f;
   public String[] g;
   public short h;

   public Util(short var1, byte var2, String var3, String var4, String[] var5, short[] var6, short var7, String[] var8) {
      this.c = var1;
      this.a = var2;
      this.d = mFont.g.getWidth(var3, Panel.aa - 20);
      this.e = mFont.k.getWidth(var4, Panel.aa - 20);
      this.f = var5;
      this.b = var6;
      this.h = var7;
      this.g = var8;
   }

   public Util() {
   }

   public static byte[] a(Message var0) {
      try {
         int var1;
         if ((var1 = var0.reader().readInt()) > 1) {
            byte[] var3 = new byte[var1];
            var0.reader().read(var3);
            return var3;
         }
      } catch (Exception var2) {
         var2.printStackTrace();
      }

      return null;
   }

   public static byte[] readByteArray(DataInputStream var0) {
      try {
         byte[] var1 = new byte[var0.readInt()];
         var0.read(var1);
         return var1;
      } catch (Exception var2) {
         var2.printStackTrace();
         return null;
      }
   }

   public static String replace(String var0, String var1, String var2) {
      StringBuffer var3;
      int var4;
      for(var3 = new StringBuffer(); (var4 = var0.indexOf(var1)) != -1; var0 = var0.substring(var4 + var1.length())) {
         var3.append(var0.substring(0, var4) + var2);
      }

      var3.append(var0);
      return var3.toString();
   }

   public static String a(int var0) {
      long var1 = (long)var0 * 1000L;
      Calendar var4;
      (var4 = Calendar.getInstance()).setTimeZone(TimeZone.getTimeZone("GMT+7"));
      var4.setTime(new Date(var1));
      int var5 = var4.get(11);
      var4.get(12);
      int var2 = var4.get(5);
      int var3 = var4.get(2) + 1;
      var0 = var4.get(1);
      return var2 + "/" + var3 + "/" + var0 + " " + var5 + "h";
   }

   public static String b(int var0) {
      int var1 = 0;
      if (var0 > 60) {
         var1 = var0 / 60;
         var0 %= 60;
      }

      int var2 = 0;
      if (var1 > 60) {
         var2 = var1 / 60;
         var1 %= 60;
      }

      int var3 = 0;
      if (var2 > 24) {
         var3 = var2 / 24;
         var2 %= 24;
      }

      String var4 = "";
      if (var3 > 0) {
         var4 = var4 + var3;
         var4 = var4 + "d";
         var4 = var4 + var2 + "h";
      } else if (var2 > 0) {
         var4 = var4 + var2;
         var4 = var4 + "h";
         var4 = var4 + var1 + "'";
      } else {
         if (var1 > 9) {
            var4 = var4 + var1;
         } else {
            var4 = var4 + "0" + var1;
         }

         var4 = var4 + ":";
         if (var0 > 9) {
            var4 = var4 + var0;
         } else {
            var4 = var4 + "0" + var0;
         }
      }

      return var4;
   }

   public static String a(long var0) {
      String var2 = "";
      long var3 = var0 / 1000L + 1L;

      for(int var5 = 0; (long)var5 < var3; ++var5) {
         if (var0 < 1000L) {
            var2 = var0 + var2;
            break;
         }

         long var6;
         if ((var6 = var0 % 1000L) == 0L) {
            var2 = ".000" + var2;
         } else if (var6 < 10L) {
            var2 = ".00" + var6 + var2;
         } else if (var6 < 100L) {
            var2 = ".0" + var6 + var2;
         } else {
            var2 = "." + var6 + var2;
         }

         var0 /= 1000L;
      }

      return var2;
   }

   public static String c(int var0) {
      int var1 = 0;
      if (var0 > 60) {
         var1 = var0 / 60;
      }

      var0 = 0;
      if (var1 > 60) {
         var0 = var1 / 60;
         var1 %= 60;
      }

      int var2 = 0;
      if (var0 > 24) {
         var2 = var0 / 24;
         var0 %= 24;
      }

      String var3 = "";
      if (var2 > 0) {
         var3 = var3 + var2;
         var3 = var3 + "d";
         var3 = var3 + var0 + "h";
      } else if (var0 > 0) {
         var3 = var3 + var0;
         var3 = var3 + "h";
         var3 = var3 + var1 + "'";
      } else {
         if (var1 == 0) {
            var1 = 1;
         }

         var3 = var3 + var1;
         var3 = var3 + "ph";
      }

      return var3;
   }
}
