package nro;

import java.util.Vector;

public class MyVector extends Vector {
   private String a;

   public MyVector(String var1) {
      this.a = var1;
   }

   private MyVector() {
   }

   public synchronized void removeAllElements() {
      super.removeAllElements();
   }

   public synchronized boolean removeElement(Object var1) {
      return super.removeElement(var1);
   }

   public synchronized void removeElementAt(int var1) {
      super.removeElementAt(var1);
   }

   public synchronized void addElement(Object var1) {
      if (this.size() > 1000) {
         System.out.println("||||||||||||||||||||||||||||||||||||||||||||" + this.a + " num= " + this.size());
      }

      super.addElement(var1);
   }

   public synchronized void insertElementAt(Object var1, int var2) {
      if (this.size() > 1000) {
         System.out.println("||||||||||||||||||||||||||||||||||||||||||||" + this.a + " num= " + this.size());
      }

      super.insertElementAt(var1, var2);
   }
}
