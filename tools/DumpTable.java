import java.lang.reflect.*;import java.io.*;
public class DumpTable{public static void main(String[]a)throws Exception{Class<?>c=Class.forName("nro.cX");short[]o=(short[])c.getField("o").get(null);DataOutputStream d=new DataOutputStream(new FileOutputStream(a[0]));for(short s:o)d.writeShort(s);d.close();System.out.println("len="+o.length);}}
