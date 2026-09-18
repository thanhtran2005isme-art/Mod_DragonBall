package nro;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import javax.microedition.io.Connector;
import javax.microedition.io.SocketConnection;

public final class nr_ax {
   SocketConnection a;

   public nr_ax(String var1, int var2) {
      try {
         this.a = (SocketConnection)Connector.open("socket://" + var1 + ":" + var2);
      } catch (IOException var3) {
         var3.printStackTrace();
      }
   }

   public final void a() {
      try {
         this.a.close();
      } catch (IOException var2) {
         var2.printStackTrace();
      }
   }

   public final DataOutputStream b() {
      try {
         return this.a.openDataOutputStream();
      } catch (IOException var2) {
         var2.printStackTrace();
         return null;
      }
   }

   public final DataInputStream c() {
      try {
         return this.a.openDataInputStream();
      } catch (IOException var2) {
         var2.printStackTrace();
         return null;
      }
   }
}
