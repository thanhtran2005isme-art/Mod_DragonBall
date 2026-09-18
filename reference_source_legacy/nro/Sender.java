package nro;

import java.util.Vector;

final class Sender implements Runnable {
   private final Vector a;
   private Session_ME2 b;

   public Sender(Session_ME2 var1) {
      this.b = var1;
      this.a = new Vector();
   }

   public final void a(Message var1) {
      this.a.addElement(var1);
   }

   public final void run() {
      while(this.b.connected) {
         try {
            if (this.b.j) {
               while(this.a.size() > 0) {
                  Message var1 = (Message)this.a.elementAt(0);
                  this.a.removeElementAt(0);
                  Session_ME2.a(this.b, var1);
               }
            }

            try {
               Thread.sleep(10L);
            } catch (Exception var2) {
            }
         } catch (Exception var3) {
            var3.printStackTrace();
         }
      }

   }

   static Vector a(Sender var0) {
      return var0.a;
   }
}
