package nro;

public final class SkillTemplate {
   public byte id;
   public String b;
   public int maxPoint;
   public int d;
   public int type;
   public int f;
   public String[] g;
   public Skill[] h;
   public String i;

   public final boolean a() {
      return this.type == 2;
   }

   public final boolean b() {
      return this.type == 3;
   }

   public final boolean c() {
      return this.type == 4;
   }
}
