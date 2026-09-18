import java.lang.reflect.*;
public class DumpStrings {
  public static void main(String[] args) throws Exception {
    Class<?> c=Class.forName("nro.cX");
    Field f=c.getField("o");
    short[] o=(short[])f.get(null);
    System.out.println("len="+(o==null?-1:o.length));
    Method m=c.getMethod("a", short[].class,int.class,int.class,int.class);
    int[][] tests={{30975,13,574924928},{0,10,0},{2,1,574925210^282}};
    for(int[] t:tests) try { System.out.println(java.util.Arrays.toString(t)+" => "+m.invoke(null,o,t[0],t[1],t[2])); } catch(Throwable e){System.out.println(e);}
  }
}
