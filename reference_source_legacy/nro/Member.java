package nro;

public final class Member {
   public int a;
   public short b;
   public short c = -1;
   public short d;
   public short e;
   public String f;
   public byte g;
   public String h;
   public int i;
   public int j;
   public int k;
   public int l;
   public String m;

   public static String a(int var0) {
      if (var0 == 0) {
         return mResources.db;
      } else if (var0 == 1) {
         return mResources.dc;
      } else {
         return var0 == 2 ? mResources.de : "";
      }
   }
}
