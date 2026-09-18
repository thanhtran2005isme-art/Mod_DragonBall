package nro;

import main.GameMidlet;

import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Display;

public abstract class ScaledInputCanvas extends Canvas implements Runnable {
    public static boolean isRunning;

    public static void setCurrentScreen(GameMidlet var0) {
        Display.getDisplay(var0).setCurrent(main.GameCanvas.h);
    }

    public ScaledInputCanvas() {
        this.setFullScreenMode(true);
        int var10000 = super.getWidth();
        int var2 = super.getHeight();
        int var1 = var10000;
//      if (var10000 * var2 >= 2073600) {
//         mGraphics.zoomLevel = 4;
//      } else if (var1 * var2 >= 691200) {
//         mGraphics.zoomLevel = 3;
//      } else if (var1 * var2 > 153600) {
//         mGraphics.zoomLevel = 2;
//      } else {
        mGraphics.zoomLevel = 1;
//      }
    }

//    public int getHeight() {
//        System.out.println("DONT USE getHeight, PLEASE USE getHeightz()");
//        return -1;
//    }
//
//    public int getWidth() {
//        System.out.println("DONT USE getWidth, PLEASE USE getWidthz()");
//        return -1;
//    }

    public final int getNumGridCellsX() {
        int var1;
        return (var1 = super.getWidth()) / mGraphics.zoomLevel + (var1 % mGraphics.zoomLevel == 0 ? 0 : 1);
    }

    public final int getNumGridCellsY() {
        int var1;
        return (var1 = super.getHeight()) / mGraphics.zoomLevel + (var1 % mGraphics.zoomLevel == 0 ? 0 : 1);
    }

    protected final void pointerDragged(int var1, int var2) {
        var1 /= mGraphics.zoomLevel;
        var2 /= mGraphics.zoomLevel;
        this.onDrag(var1, var2);
    }

    protected final void pointerPressed(int var1, int var2) {
        var1 /= mGraphics.zoomLevel;
        var2 /= mGraphics.zoomLevel;
        this.onPress(var1, var2);
    }

    protected final void pointerReleased(int var1, int var2) {
        var1 /= mGraphics.zoomLevel;
        var2 /= mGraphics.zoomLevel;
        this.onRelease(var1, var2);
    }

    protected abstract void onDrag(int var1, int var2);

    protected abstract void onPress(int var1, int var2);

    protected abstract void onRelease(int var1, int var2);

    protected abstract void d();

    public void run() {
//      try {
//         Thread.sleep(100L);
//      } catch (Exception var10) {
//      }

//      isRunning = true;
//
//      while(isRunning) {
//         long var1 = System.currentTimeMillis();
//         this.d();
//         this.repaint();
//         this.serviceRepaints();
//         long var3 = System.currentTimeMillis() - var1;
//
//         try {
//            if (var3 < 10) {
//               while(true) {
//                  long var6 = System.currentTimeMillis();
//                  Thread.sleep(10 - var3);
//                  if (System.currentTimeMillis() - var6 >= 10 - var3) {
//                     break;
//                  }
//               }
//            } else {
//               Thread.sleep(1L);
//            }
//         } catch (Exception var11) {
//            var11.printStackTrace();
//         }
//      }
        try {
            Thread.sleep(10L);
        } catch (Exception var10) {
        }

        isRunning = true;

        while (isRunning) {
            this.d();
            this.repaint();
            this.serviceRepaints();
            try {
                Thread.sleep(1L);
            } catch (Exception var11) {
                var11.printStackTrace();
            }
        }

    }
}
