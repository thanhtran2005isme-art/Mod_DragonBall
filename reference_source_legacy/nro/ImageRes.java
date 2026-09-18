package nro;

import java.io.DataInputStream;
import java.io.IOException;
import javax.microedition.lcdui.Image;

public final class ImageRes {
   private static byte[] a = new byte[]{-22, 2, 12, 4, 5, 2, -10};
   private int b = 0;

   public static Image a(String var0) {
      Image var1 = null;
      var0 = "/x" + mGraphics.zoomLevel + var0;

      try {
         DataInputStream var2;
         int var3;
         byte[] var4 = new byte[var3 = (var2 = new DataInputStream("".getClass().getResourceAsStream(var0))).available()];
         var2.read(var4, 0, var3);
         ImageRes var12;
         (var12 = new ImageRes()).b = 0;

         for(int var5 = 0; var5 < var4.length; ++var5) {
            byte var7 = var4[var5];
            var7 = (byte)(a[var12.b++] & 255 ^ var7 & 255);
            if (var12.b >= a.length) {
               var12.b %= a.length;
            }

            var4[var5] = var7;
         }

         var1 = Image.createImage(var4, 0, var3);
      } catch (IOException var9) {
      } catch (IllegalArgumentException var10) {
      } catch (NullPointerException var11) {
      }

      if (var1 == null) {
         try {
            var1 = Image.createImage(var0);
         } catch (IOException var8) {
            return null;
         }
      }

      return var1;
   }
}
