package nro;

public final class Skill {
   public SkillTemplate template;
   public short b;
   public int point;
   public long d;
   public int e;
   public long f;
   public int g;
   public int h;
   public int i;
   public boolean j = false;
   public short k;
   public String moreInfo;
   public short m;

   public final String a() {
      if (this.e % 1000 == 0) {
         return String.valueOf(this.e / 1000);
      } else {
         int var1 = this.e % 1000;
         return this.e / 1000 + "." + (var1 % 100 == 0 ? var1 / 100 : var1 / 10);
      }
   }
}
