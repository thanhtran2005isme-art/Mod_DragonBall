package nro;

public final class EffecMn {
   public static MyVector a = new MyVector("vEff");

   public static void addEff(Effect var0) {
      a.addElement(var0);
   }

   public static void a(int var0) {
      if (b(var0) != null) {
         a.removeElement(b(var0));
      }

   }

   private static Effect b(int var0) {
      for(int var1 = 0; var1 < a.size(); ++var1) {
         Effect var2;
         if ((var2 = (Effect)a.elementAt(var1)).a == var0) {
            return var2;
         }
      }

      return null;
   }

   public static void a(mGraphics var0, int var1, int var2, int var3) {
      for(int var4 = 0; var4 < a.size(); ++var4) {
         if (((Effect)a.elementAt(var4)).h == -var3) {
            ((Effect)a.elementAt(var4)).a(var0, var1, var2);
         }
      }

   }

   public static void a(mGraphics var0) {
      for(int var1 = 0; var1 < a.size(); ++var1) {
         if (((Effect)a.elementAt(var1)).h == 1) {
            ((Effect)a.elementAt(var1)).a(var0);
         }
      }

   }

   public static void b(mGraphics var0) {
      for(int var1 = 0; var1 < a.size(); ++var1) {
         if (((Effect)a.elementAt(var1)).h == 2) {
            ((Effect)a.elementAt(var1)).a(var0);
         }
      }

   }

   public static void c(mGraphics var0) {
      for(int var1 = 0; var1 < a.size(); ++var1) {
         if (((Effect)a.elementAt(var1)).h == 3) {
            ((Effect)a.elementAt(var1)).a(var0);
         }
      }

   }

   public static void d(mGraphics var0) {
      for(int var1 = 0; var1 < a.size(); ++var1) {
         if (((Effect)a.elementAt(var1)).h == 4) {
            ((Effect)a.elementAt(var1)).a(var0);
         }
      }

   }

   public static void a() {
      for(int var0 = 0; var0 < a.size(); ++var0) {
         ((Effect)a.elementAt(var0)).a();
      }

   }
}
