package nro;

public final class Item {
   public ItemOption[] itemOption;
   public ItemTemplate template;
   public MyVector c;
   public int d;
   public int e;
   public boolean f;
   public int g;
   public int quantity;
   public int i;
   public long j;
   public boolean k;
   public int l;
   public int m;
   public int n;
   public int o;
   public int p;
   public int q;
   public int r;
   public int s;
   public int t;
   public short u = -1;
   public byte v = -1;
   public int w;
   public boolean x;
   public boolean y = false;
   public String z = "";
   public int A;
   public byte B;
   public boolean C;
   public int D = -1;
   public int E = -1;
   public int F = -1;
   public int G = -1;
   public String H = "";

   public Item() {
      int[] var10000 = new int[]{0, 0, 0, 0, 600841, 600841, 667658, 667658, 3346944, 3346688, 4199680, 5052928, 3276851, 3932211, 4587571, 5046280, 6684682, 3359744};
      int[][] var1 = new int[][]{{18687, 16869, 15052, 13235, 11161, 9344}, {45824, 39168, 32768, 26112, 19712, 13056}, {16744192, 15037184, 13395456, 11753728, 10046464, 8404992}, {13500671, 12058853, 10682572, 9371827, 7995545, 6684800}, {16711705, 15007767, 13369364, 11730962, 10027023, 8388621}};
      var10000 = new int[]{2, 1, 1, 1, 1, 1};
   }

   public final void a() {
      this.A = main.GameCanvas.panel.a(this);
   }

   public final boolean a(int var1) {
      for(var1 = 0; var1 < this.itemOption.length; ++var1) {
         ItemOption var2;
         if ((var2 = this.itemOption[var1]) != null && var2.optionTemplate.name == 87) {
            return true;
         }
      }

      return false;
   }

   public final boolean b() {
      return this.template.type >= 0 && this.template.type < 6 || this.template.type == 32 || this.template.type == 35 || this.template.type == 11 || this.template.type == 23;
   }

   public final void a(int var1, int var2, int var3, int var4) {
      this.D = var1;
      this.E = var2;
      this.F = var3;
      this.G = var4;
   }
}
