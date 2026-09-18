package nro;

import javax.microedition.lcdui.Image;

public final class Paint {
   private static int COLORBACKGROUND = 15787715;
   private static Image[] goc = new Image[6];
   public static int a;
   private static int d;

   static {
      for(int x = 0; x < goc.length; ++x) {
         goc[x] = mSystem.load("/mainImage/myTexture2dgoc" + (x + 1) + ".png");
      }

      a = 24;
      d = 0;
      mSystem.load("/mainImage/myTexture2dcheck.png");
   }

   public Paint() {
      int[] y0000 = new int[]{15970400, -844109861, 2250052, 16374659, 15906669, 12931125, 3108954};
   }

   public static void paintCmdBar(mGraphics graphics, CommandLine left, CommandLine center, CommandLine right) {
      mFont font = mFont.tahoma_7b_dark;
      if (left != null && (d = font.getWidth(left.caption)) > 0) {
         if (left.x >= 0 && left.y > 0) {
            left.a(graphics);
         } else {
            graphics.drawImage(mScreen.cf == 0 ? GameScr.imgLbtn : GameScr.imgLbtnFocus, 1, main.GameCanvas.A - mScreen.ce - 1, 0);
            font.drawStringBd(graphics, left.caption, 35, main.GameCanvas.A - mScreen.ce + 3 + 3, 2);
         }
      }

      if (center != null && (d = font.getWidth(center.caption)) > 0) {
         if (center.x > 0 && center.y > 0) {
            center.a(graphics);
         } else {
            graphics.drawImage(mScreen.cf == 1 ? GameScr.imgLbtn : GameScr.imgLbtnFocus, main.GameCanvas.B - 35, main.GameCanvas.A - mScreen.ce - 1, 0);
            font.drawStringBd(graphics, center.caption, main.GameCanvas.B, main.GameCanvas.A - mScreen.ce + 3 + 3, 2);
         }
      }

      if (right != null && (d = font.getWidth(right.caption)) > 0) {
         if (right.x > 0 && right.y > 0) {
            right.a(graphics);
            return;
         }

         graphics.drawImage(mScreen.cf == 2 ? GameScr.imgLbtn : GameScr.imgLbtnFocus, main.GameCanvas.z - 71, main.GameCanvas.A - mScreen.ce - 1, 0);
         font.drawStringBd(graphics, right.caption, main.GameCanvas.z - 35, main.GameCanvas.A - mScreen.ce + 3 + 3, 2);
      }

   }

   public final void paintCmdBar(mGraphics y, int w, int h, int graphics, int var5, String[] var6) {
      paintFrame(w, h, graphics, 69, y);
      h = h + 20 - mFont.t.getWidth();
      var5 = 0;

      for(h = h; var5 < var6.length; h += mFont.t.getWidth()) {
         mFont.t.drawStringBd(y, var6[var5], w + graphics / 2, h, 2);
         ++var5;
      }

   }

   public static void paintCmdBar(int x, int y, int w, int h, mGraphics graphics) {
      graphics.setColor(9340251);
      graphics.drawRect(x + 18, y, (w - 36) / 2 - 32, h);
      graphics.drawRect(x + 18 + (w - 36) / 2 + 32, y, (w - 36) / 2 - 22, h);
      graphics.drawRect(x, y + 8, w, h - 17);
      graphics.setColor(COLORBACKGROUND);
      graphics.fillRect(x + 18, y + 3, (w - 36) / 2 - 32, h - 4);
      graphics.fillRect(x + 18 + (w - 36) / 2 + 31, y + 3, (w - 38) / 2 - 22, h - 4);
      graphics.fillRect(x + 1, y + 6, w - 1, h - 11);
      graphics.setColor(14667919);
      graphics.fillRect(x + 18, y + 1, (w - 36) / 2 - 32, 2);
      graphics.fillRect(x + 18 + (w - 36) / 2 + 32, y + 1, (w - 36) / 2 - 12, 2);
      graphics.fillRect(x + 18, y + h - 2, (w - 36) / 2 - 31, 2);
      graphics.fillRect(x + 18 + (w - 36) / 2 + 32, y + h - 2, (w - 36) / 2 - 31, 2);
      graphics.fillRect(x + 1, y + 11, 2, h - 18);
      graphics.fillRect(x + w - 2, y + 11, 2, h - 18);
      graphics.drawImage(goc[0], x - 3, y - 2, 20);
      graphics.drawImage(goc[2], x + w + 3, y - 2, StaticObj.TOP_RIGHT);
      graphics.drawImage(goc[1], x - 3, y + h + 3, StaticObj.BOTTOM_LEFT);
      graphics.drawImage(goc[3], x + w + 4, y + h + 2, StaticObj.BOTTOM_RIGHT);
      graphics.drawImage(goc[4], x + w / 2, y, StaticObj.a);
      graphics.drawImage(goc[5], x + w / 2, y + h + 1, StaticObj.c);
   }

   public static void paintFrame(int x, int y, int w, int h, mGraphics graphics) {
      graphics.setColor(13524492);
      graphics.drawRect(x + 6, y, w - 12, h);
      graphics.drawRect(x, y + 6, w, h - 12);
      graphics.drawRect(x + 7, y + 1, w - 14, h - 2);
      graphics.drawRect(x + 1, y + 7, w - 2, h - 14);
      graphics.setColor(14338484);
      graphics.fillRect(x + 8, y + 2, w - 16, h - 3);
      graphics.fillRect(x + 2, y + 8, w - 3, h - 14);
      graphics.drawImage(main.GameCanvas.X[2], x, y, 20);
      graphics.setColor(main.GameCanvas.X[2], 0, 0, 16, 16, 2, x + w + 1, y, StaticObj.TOP_RIGHT);
      graphics.setColor(main.GameCanvas.X[2], 0, 0, 16, 16, 1, x, y + h + 1, StaticObj.BOTTOM_LEFT);
      graphics.setColor(main.GameCanvas.X[2], 0, 0, 16, 16, 3, x + w + 1, y + h + 1, StaticObj.BOTTOM_RIGHT);
   }

   public static void paintFrameSimple(int x, int y, int w, int h, mGraphics graphics) {
      graphics.setColor(6702080);
      graphics.fillRect(x, y, w, h);
      graphics.setColor(14338484);
      graphics.fillRect(x + 1, y + 1, w - 2, h - 2);
   }
}
