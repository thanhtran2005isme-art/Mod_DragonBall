package nro;

public final class nr_o {
   public static MyHashTable a = new MyHashTable("VSKILL");

   public static void a(Skill var0) {
      a.put(new Short(var0.b), var0);
   }

   public static Skill a(short var0) {
      return (Skill)a.get(new Short(var0));
   }
}
