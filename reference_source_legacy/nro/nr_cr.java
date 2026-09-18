package nro;

final class nr_cr implements Runnable {
   private Session_Me a;

   nr_cr(Session_Me var1) {
      this.a = var1;
   }

   public final void run() {
      try {
         Thread.sleep(20000L);
      } catch (InterruptedException var3) {
      }

      if (this.a.sessionMe2.e) {
         try {
            Session_ME2.a(this.a.sessionMe2).a();
         } catch (Exception var2) {
         }

         Session_ME2.n = true;
         this.a.sessionMe2.e = false;
         this.a.sessionMe2.connected = false;
         this.a.sessionMe2.b.onConnectionFail(this.a.sessionMe2.c);
      }

   }
}
