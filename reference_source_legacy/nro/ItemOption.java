package nro;

public final class ItemOption {
   public int param;
   public byte activeCard;
   public ItemOptionTemplate optionTemplate;

   public ItemOption() {
   }

   public ItemOption(int var1, int var2) {
      if (var1 == 22) {
         var1 = 6;
         var2 *= 1000;
      }

      if (var1 == 23) {
         var1 = 7;
         var2 *= 1000;
      }

      this.param = var2;
      this.optionTemplate = GameScr.gI().iOptionTemplates[var1];
   }

   public String getOptionString() {
      return Util.replace(this.optionTemplate.type, "#", String.valueOf(this.param));
   }
}
