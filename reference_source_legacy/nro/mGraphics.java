package nro;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public final class mGraphics {
   public Graphics graphics;
   public static int zoomLevel = 1;

   public final void setColor(int var1, int var2, int var3, int var4, int var5, int var6) {
      var1 *= zoomLevel;
      var2 *= zoomLevel;
      var3 *= zoomLevel;
      var4 *= zoomLevel;
      this.graphics.fillArc(var1, var2, var3, var4, 0, 360);
   }

   public final void drawImage(Image var1, int var2, int var3, int var4) {
      if (var1 != null) {
         var2 *= zoomLevel;
         var3 *= zoomLevel;
         this.graphics.drawImage(var1, var2, var3, var4);
      }
   }

   public final void setColor(Image var1, float var2, float var3, int var4) {
      int var5 = var4;
      float var6 = var3;
      if (var1 != null) {
         var3 = var2 * (float) zoomLevel;
         var6 *= (float) zoomLevel;
         this.graphics.drawImage(var1, (int)var3, (int)var6, var5);
      }

   }

   public final void setColor(int var1, int var2, int var3, int var4) {
      var1 *= zoomLevel;
      var2 *= zoomLevel;
      var3 *= zoomLevel;
      var4 *= zoomLevel;
      this.graphics.drawLine(var1, var2, var3, var4);
   }

   public final void setColor(int var1, int var2, int var3, int var4, int var5) {
      var1 *= zoomLevel;
      var2 *= zoomLevel;
      var3 *= zoomLevel;
      var4 *= zoomLevel;
      this.graphics.setColor(var5);
      this.graphics.fillRect(var1, var2, var3, var4);
   }

   public final void b(int var1, int var2, int var3, int var4) {
      this.fillRect(var1, var2, var3, var4);
   }

   public final void drawRect(int var1, int var2, int var3, int var4) {
      this.fillRect(var1, var2, 1, var4);
      this.fillRect(var1 + var3, var2, 1, var4);
      this.fillRect(var1, var2, var3, 1);
      this.fillRect(var1, var2 + var4, var3 + 1, 1);
   }

   public final void setColor(Image var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      if (var1 != null) {
         var7 *= zoomLevel;
         var8 *= zoomLevel;
         var2 *= zoomLevel;
         var3 *= zoomLevel;
         var4 *= zoomLevel;
         var5 *= zoomLevel;
         this.graphics.drawRegion(var1, var2, var3, var4, var5, var6, var7, var8, var9);
      }
   }

   public final void b(Image var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      if (var1 != null) {
         this.setColor(var1, 0, var3, var4, var5, var6, var7, var8, var9);
      }
   }

   public final void setColor(Image var1, int var2, int var3, int var4, int var5) {
      for(var2 = 0; var2 < var4 / setColor(var1) + 1; ++var2) {
         for(var3 = 0; var3 < var5 / b(var1) + 1; ++var3) {
            this.graphics.drawImage(var1, 0 + var2 * setColor(var1), 0 + var3 * b(var1), 0);
         }
      }

   }

   public static int setColor(float image, int var1, int var2) {
      ResLog.c("blend color");
      image = (float)(var2 >> 16 & 255);
      float var3 = (float)(var2 >> 8 & 255);
      float var4 = (float)(var2 & 255);
      image *= 0.4F;
      var3 *= 0.4F;
      var4 *= 0.4F;
      if (image > 255.0F) {
         image = 255.0F;
      }

      if (image < 0.0F) {
         image = 0.0F;
      }

      if (var3 > 255.0F) {
         var3 = 255.0F;
      }

      if (var3 < 0.0F) {
         var3 = 0.0F;
      }

      if (var4 < 0.0F) {
         var4 = 0.0F;
      }

      if (var4 > 255.0F) {
         var4 = 255.0F;
      }

      return -16777216 | (int)image << 16 | (int)var3 << 8 | (int)var4 & 255;
   }

   public final void fillRect(int var1, int var2, int var3, int var4) {
      var1 *= zoomLevel;
      var2 *= zoomLevel;
      var3 *= zoomLevel;
      var4 *= zoomLevel;
      this.graphics.fillRect(var1, var2, var3, var4);
   }

   public final int setColor() {
      return this.graphics.getTranslateX() / zoomLevel;
   }

   public final int b() {
      return this.graphics.getTranslateY() / zoomLevel;
   }

   public final void e(int var1, int var2, int var3, int var4) {
      var1 *= zoomLevel;
      var2 *= zoomLevel;
      var3 *= zoomLevel;
      var4 *= zoomLevel;
      this.graphics.setClip(var1, var2, var3, var4);
   }

   public final int drawRect() {
      return this.graphics.getClipX();
   }

   public final int fillRect() {
      return this.graphics.getClipY();
   }

   public final int e() {
      return this.graphics.getClipWidth();
   }

   public final int f() {
      return this.graphics.getClipHeight();
   }

   public final void setColor(int var1) {
      this.graphics.setColor(var1);
   }

   public final void setColor(int var1, int var2) {
      var1 *= zoomLevel;
      var2 *= zoomLevel;
      this.graphics.translate(var1, var2);
   }

   public static int setColor(Image image) {
      return image.getWidth() / zoomLevel;
   }

   public static int b(Image image) {
      return image.getHeight() / zoomLevel;
   }

   public static int drawRect(Image image) {
      return image.getWidth();
   }

   public static int fillRect(Image image) {
      return image.getHeight();
   }
}
