package nro;

final class Session_Me implements Runnable {
   private final String b;
   private int c;
   final Session_ME2 sessionMe2;

   Session_Me(Session_ME2 var1, String var2, int var3) {
      this.sessionMe2 = var1;
      this.b = var2;
      this.c = var3;
   }

   public final void run() {
      Session_ME2.n = false;
      (new Thread(new nr_cr(this))).start();
      this.sessionMe2.e = true;
      this.sessionMe2.connected = true;

      try {
         int var3 = this.c;
         String var2 = this.b;
         Session_ME2.a(this.sessionMe2, new nr_ax(var2, var3));
         Session_ME2.a(this.sessionMe2, Session_ME2.a(this.sessionMe2).b());
         this.sessionMe2.a = Session_ME2.a(this.sessionMe2).c();
         this.sessionMe2.sendThread = new Thread(Session_ME2.b(this.sessionMe2));
         this.sessionMe2.sendThread.start();
         this.sessionMe2.collectorThread = new Thread(new MessageCollector(this.sessionMe2));
         this.sessionMe2.collectorThread.start();
         this.sessionMe2.l = System.currentTimeMillis();
         Session_ME2.a(this.sessionMe2, new Message((byte)-27));
         this.sessionMe2.e = false;
         this.sessionMe2.b.onConnectOK(this.sessionMe2.c);
      } catch (Exception var5) {
         try {
            Thread.sleep(500L);
         } catch (InterruptedException var4) {
         }

         if (!Session_ME2.n) {
            if (this.sessionMe2.b != null) {
               this.sessionMe2.close();
            }

         }
      }
   }
}
