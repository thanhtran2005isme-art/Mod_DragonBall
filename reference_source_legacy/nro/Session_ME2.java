package nro;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public final class Session_ME2 implements ISession {
   private static Session_ME2 instance = new Session_ME2();
   private static Session_ME2 p = new Session_ME2();
   private DataOutputStream q;
   public DataInputStream a;
   public IMessageHandler b;
   public boolean c = true;
   private nr_ax r;
   public boolean connected;
   public boolean e;
   private final Sender s = new Sender(this);
   private Thread initThread;
   public Thread collectorThread;
   public Thread sendThread;
   public int h;
   public int i;
   boolean j;
   public byte[] k = null;
   private byte u;
   private byte v;
   long l;
   public String m = "";
   private long w = 0L;
   public static boolean n;
   private static int x;

   public static Session_ME2 Session_ME() {
      return instance;
   }

   public static Session_ME2 doSendMessage() {
      return p;
   }

   public final void c() {
      Sender.a(this.s).removeAllElements();
   }

   public final boolean d() {
      return this.connected && this.r != null && this.r.a != null && this.a != null;
   }

   public final void a(IMessageHandler var1) {
      this.b = var1;
   }

   public final void connect(String host, int port) {
      System.out.println("Connect to : ip = " + host + "-- port = " + port);
      if (!this.connected && !this.e) {
         if (mSystem.currentTimeMillis() >= this.w) {
            this.w = mSystem.currentTimeMillis() + 50L;
            if (this.c) {
               ServerListScreen.t = -1;
            }

            this.j = false;
            this.cleanNetwork();
            this.initThread = new Thread(new Session_Me(this, host, port));
            this.initThread.start();
         }
      }
   }

   public final void sendMessage(Message var1) {
      ++x;
      this.s.a(var1);
   }

   private synchronized void doSendMessage(Message var1) {
      byte[] var2 = var1.getData();

      try {
         byte var5;
         if (this.j) {
            var5 = this.a(var1.command);
            this.q.writeByte(var5);
         } else {
            this.q.writeByte(var1.command);
         }

         if (var2 != null) {
            int var6 = var2.length;
            if (this.j) {
               byte var3 = this.a((byte)(var6 >> 8));
               this.q.writeByte(var3);
               var5 = this.a((byte)var6);
               this.q.writeByte(var5);
            } else {
               this.q.writeShort(var6);
            }

            if (this.j) {
               for(int var7 = 0; var7 < var2.length; ++var7) {
                  var2[var7] = this.a(var2[var7]);
               }
            }

            this.q.write(var2);
            this.h += 5 + var2.length;
         } else {
            this.q.writeShort(0);
            this.h += 5;
         }

         this.q.flush();
      } catch (IOException var4) {
         var4.printStackTrace();
      }
   }

   private byte a(byte var1) {
      byte[] var10000 = this.k;
      byte var10003 = this.v;
      this.v = (byte)(var10003 + 1);
      var1 = (byte)(var10000[var10003] & 255 ^ var1 & 255);
      if (this.v >= this.k.length) {
         this.v = (byte)(this.v % this.k.length);
      }

      return var1;
   }

   public final void close() {
      this.cleanNetwork();
   }

   private void cleanNetwork() {
      this.k = null;
      this.u = 0;
      this.v = 0;

      try {
         this.connected = false;
         this.e = false;
         if (this.r != null && this.r.a != null) {
            this.r.a();
         }

         this.r = null;
         if (this.q != null) {
            this.q.close();
         }

         this.q = null;
         if (this.a != null) {
            this.a.close();
         }

         this.a = null;
         if (this.sendThread != null) {
            this.sendThread.interrupt();
         }

         this.sendThread = null;
         if (this.collectorThread != null) {
            this.collectorThread.interrupt();
         }

         this.collectorThread = null;
         if (this.c) {
            ServerListScreen.t = 0;
         }

         System.gc();
      } catch (Exception var2) {
         var2.printStackTrace();
      }
   }

   static nr_ax a(Session_ME2 var0) {
      return var0.r;
   }

   static void a(Session_ME2 var0, nr_ax var1) {
      var0.r = var1;
   }

   static void a(Session_ME2 var0, DataOutputStream var1) {
      var0.q = var1;
   }

   static Sender b(Session_ME2 var0) {
      return var0.s;
   }

   static void a(Session_ME2 var0, Message var1) {
      var0.doSendMessage(var1);
   }

   static void c(Session_ME2 var0) {
      var0.cleanNetwork();
   }

   static byte a(Session_ME2 var0, byte var1) {
      byte[] var10000 = (var0 = var0).k;
      byte var10003 = var0.u;
      var0.u = (byte)(var10003 + 1);
      var1 = (byte)(var10000[var10003] & 255 ^ var1 & 255);
      if (var0.u >= var0.k.length) {
         var0.u = (byte)(var0.u % var0.k.length);
      }

      return var1;
   }
}
