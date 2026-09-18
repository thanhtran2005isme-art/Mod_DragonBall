package main;

import javax.microedition.midlet.MIDlet;
import nro.Controller;
import nro.IMessageHandler;
import nro.Session_ME2;
import nro.ScaledInputCanvas;
import nro.SplashScr;

public class GameMidlet extends MIDlet {
   public static String ip = "112.213.94.23";
   public static int port = 14445;
   public static String c;
   public static int d;
   public static int e = 237;
   private static GameCanvas h;
   public static GameMidlet instance;
   private static boolean i;
   public static boolean g;

   public GameMidlet() {
      instance = this;
      GameCanvas var1 = h = new GameCanvas();
         (new Thread(var1)).start();
         Session_ME2.Session_ME().a((IMessageHandler) Controller.onMessage());
         Session_ME2.doSendMessage().a((IMessageHandler) Controller.onMessage());
         Session_ME2.doSendMessage().c = false;
         SplashScr.f();
         SplashScr.a();
         GameCanvas.currentScreen = new SplashScr();
         ScaledInputCanvas.setCurrentScreen(instance);
   }

   protected void destroyApp(boolean var1) {
   }

   protected void pauseApp() {
   }

   public void startApp() {
   }

   public final void a() {
      ScaledInputCanvas.isRunning = false;
      System.gc();
      this.notifyDestroyed();
   }
}
