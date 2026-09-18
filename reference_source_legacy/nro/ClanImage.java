package nro;

public final class ClanImage {
   public int ID;
   public String name;
   public short[] idImage;
   public int xu;
   public int luong;
   public static MyVector vClanImage = new MyVector("vClanImage");
   public static MyHashTable idImages = new MyHashTable("h id images");

   public static void getClanImage(ClanImage var0) {
      Service.gI().b((byte)var0.ID);
      vClanImage.addElement(var0);
   }

   public static ClanImage getClanImage(short var0) {
      for(int var1 = 0; var1 < vClanImage.size(); ++var1) {
         ClanImage var2;
         if ((var2 = (ClanImage) vClanImage.elementAt(var1)).ID == var0) {
            return var2;
         }
      }

      return null;
   }

   public static boolean isExistClanImage(int var0) {
      for(int var1 = 0; var1 < vClanImage.size(); ++var1) {
         if (((ClanImage) vClanImage.elementAt(var1)).ID == var0) {
            return true;
         }
      }

      return false;
   }
}
