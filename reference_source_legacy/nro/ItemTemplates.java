package nro;

public final class ItemTemplates {
   public static MyHashTable itemTemplate = new MyHashTable("item template");

   public static void add(ItemTemplate itemTemplate) {
      ItemTemplates.itemTemplate.put(new Short(itemTemplate.a), itemTemplate);
   }

   public static ItemTemplate get(short i) {
      return (ItemTemplate) itemTemplate.get(new Short(i));
   }
}
