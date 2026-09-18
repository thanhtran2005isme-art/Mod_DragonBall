package nro;

public interface IMessageHandler {
   void onMessage(Message var1);

   void onConnectionFail(boolean var1);

   void onDisconnected(boolean var1);

   void onConnectOK(boolean var1);
}
