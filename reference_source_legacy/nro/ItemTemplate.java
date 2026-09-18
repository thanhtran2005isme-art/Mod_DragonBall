package nro;

public final class ItemTemplate {
   public short a;
   public byte type;
   public byte c;
   public String d;
   public String e;
   public short f;
   public short part;
   public boolean h;
   public int i;

   public ItemTemplate(short var1, byte var2, byte var3, String var4, String var5, byte var6, int var7, short var8, short var9, boolean var10) {
      this.a = var1;
      this.type = var2;
      this.c = var3;
      this.d = var4;
      this.d = ResLog.a(this.d);
      this.e = var5;
      this.e = ResLog.a(this.e);
      this.i = var7;
      this.f = var8;
      this.part = var9;
      this.h = var10;
   }
}
