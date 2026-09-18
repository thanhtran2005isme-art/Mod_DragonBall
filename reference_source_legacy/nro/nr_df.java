package nro;

public final class nr_df extends MyVector {
   public static nr_df a = new nr_df("low");
   public static nr_df b = new nr_df("mid");
   public static nr_df c = new nr_df("mid2");
   public static nr_df d = new nr_df("hi");

   private void c() {
      for(int var1 = this.size() - 1; var1 >= 0; --var1) {
         nr_cf var2;
         if ((var2 = (nr_cf)this.elementAt(var1)) != null) {
            var2.a();
            if (var2.b) {
               this.removeElementAt(var1);
            }
         }
      }

   }

   public static void a() {
      d.c();
      b.c();
      c.c();
      a.c();
   }

   public final void a(mGraphics var1) {
      for(int var2 = 0; var2 < this.size(); ++var2) {
         nr_cf var3;
         if ((var3 = (nr_cf)this.elementAt(var2)) != null && !var3.b) {
            ((nr_cf)this.elementAt(var2)).a(var1);
         }
      }

   }

   private void d() {
      for(int var1 = this.size() - 1; var1 >= 0; --var1) {
         nr_cf var2;
         if ((var2 = (nr_cf)this.elementAt(var1)) != null) {
            var2.b = true;
            this.removeElementAt(var1);
         }
      }

   }

   public static void b() {
      d.d();
      a.d();
      b.d();
      c.d();
   }

   public static void a(nr_cf var0) {
      d.addElement(var0);
   }

   public static void b(nr_cf var0) {
      b.addElement(var0);
   }

   public static void c(nr_cf var0) {
      c.addElement(var0);
   }

   public static void d(nr_cf var0) {
      a.addElement(var0);
   }

   private nr_df(String var1) {
      super(var1);
   }
}
