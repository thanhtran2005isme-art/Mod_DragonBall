package nro;

import javax.microedition.rms.RecordStore;
import javax.microedition.rms.RecordStoreException;
import javax.microedition.rms.RecordStoreNotFoundException;

public class Rms {
   public PartImage[] a;

   public Rms(int var1) {
      if (var1 == 0) {
         this.a = new PartImage[3];
      }

      if (var1 == 1) {
         this.a = new PartImage[17];
      }

      if (var1 == 2) {
         this.a = new PartImage[14];
      }

      if (var1 == 3) {
         this.a = new PartImage[2];
      }

   }

   public Rms() {
   }

   public static void saveRMS(String var0, byte[] var1) {
      try {
         RecordStore var2;
         if ((var2 = RecordStore.openRecordStore("vj" + var0, true)).getNumRecords() > 0) {
            var2.setRecord(1, var1, 0, var1.length);
         } else {
            var2.addRecord(var1, 0, var1.length);
         }

         var2.closeRecordStore();
      } catch (Exception var3) {
         ResLog.c("bi loi save -------------------------" + var0);
      }
   }

   public static void DeleteStorage(String var0) {
      for(int var1 = 0; var1 < RecordStore.listRecordStores().length; ++var1) {
         if (RecordStore.listRecordStores().equals(var0)) {
            try {
               RecordStore.deleteRecordStore(var0);
            } catch (RecordStoreNotFoundException var3) {
               var3.printStackTrace();
            } catch (RecordStoreException var4) {
               var4.printStackTrace();
            }
         }
      }

   }

   public static void a() {
      ResLog.c("CLEAR ALL");

      try {
         String[] var0;
         if ((var0 = RecordStore.listRecordStores()) != null) {
            for(int var1 = 0; var1 < var0.length; ++var1) {
               if (var0[var1] != null) {
                  ResLog.c("name = " + var0[var1]);
                  RecordStore.deleteRecordStore(var0[var1]);
               }
            }

         }
      } catch (Exception var2) {
         var2.printStackTrace();
      }
   }

   public static byte[] loadRMS(String var0) {
      try {
         RecordStore var3;
         byte[] var1 = (var3 = RecordStore.openRecordStore("vj" + var0, false)).getRecord(1);
         var3.closeRecordStore();
         return var1;
      } catch (Exception var2) {
         return null;
      }
   }

   public static void saveRMSInt(String var0, int var1) {
      try {
         saveRMS(var0, new byte[]{(byte)var1});
      } catch (Exception var2) {
      }
   }

   public static void saveRMSString(String var0, String var1) {
      try {
         saveRMS(var0, var1.getBytes("UTF-8"));
      } catch (Exception var2) {
         var2.printStackTrace();
      }
   }

   public static String loadRMSString(String var0) {
      byte[] var3;
      if ((var3 = loadRMS(var0)) == null) {
         return null;
      } else {
         try {
            return new String(var3, "UTF-8");
         } catch (Exception var2) {
            return new String(var3);
         }
      }
   }

   public static int loadRMSInt(String var0) {
      byte[] var1;
      return (var1 = loadRMS(var0)) == null ? -1 : var1[0];
   }
}
