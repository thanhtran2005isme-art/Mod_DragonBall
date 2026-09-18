package nro;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.TextBox;
import main.GameMidlet;

public final class TField implements IActionListener {
   public int a;
   public int b;
   public int width;
   public int height;
   public boolean isFocus;
   private boolean l = false;
   private static int m = 2;
   private static final int[] n = new int[]{18, 14, 11, 9, 6, 4, 2};
   private static int o = 0;
   private static String[] p = new String[]{" 0", ".,@?!_1\"/$-():*+<=>;%&~#%^&*{}[];'/1", "abc2áàảãạâấầẩẫậăắằẳẵặ2", "def3đéèẻẽẹêếềểễệ3", "ghi4íìỉĩị4", "jkl5", "mno6óòỏõọôốồổỗộơớờởỡợ6", "pqrs7", "tuv8úùủũụưứừửữự8", "wxyz9ýỳỷỹỵ9", "*", "#"};
   private static String[] q = new String[]{"0", "1", "abc2", "def3", "ghi4", "jkl5", "mno6", "pqrs7", "tuv8", "wxyz9", "0", "0"};
   public String f = "";
   private String r = "";
   private String s = "";
   private String t = "";
   private int u = 0;
   private int v = 0;
   private int w = 500;
   private int x = 0;
   private int y = -1984;
   private int z = 0;
   private int A = 0;
   private int B = 10;
   private int C = 0;
   public static boolean g;
   private static int D;
   private int E = 0;
   private static int F;
   public boolean h;
   public String name = "";
   public CommandLine j;
   private static Image G;
   private boolean H = true;
   public boolean isPaintCarret = true;
   private static Image I;

   static {
      String[] var10000 = new String[]{"abc", "Abc", "ABC", "123"};
      F = 11;
      G = mSystem.load("/mainImage/myTexture2der.png");
      I = mSystem.load("/mainImage/myTexture2dtf.png");
      int[][] var0 = new int[][]{{32, 48}, {49, 69}, {50, 84}, {51, 85}, {52, 68}, {53, 71}, {54, 74}, {55, 67}, {56, 66}, {57, 77}, {42, 128}, {35, 137}, {33, 113}, {63, 97}, {64, 121, 122}, {46, 111}, {44, 108}};
   }

   public final void a() {
      TextBox var1;
      (var1 = new TextBox(this.name, "", this.w, 0)).addCommand(new Command(mResources.OK, 4, 0));
      var1.addCommand(new Command(mResources.bu, 3, 0));
      var1.setCommandListener(new nr_m(this, var1));

      try {
         if (this.C == 2) {
            var1.setConstraints(65536);
         } else if (this.C == 1) {
            var1.setConstraints(2);
         } else {
            var1.setConstraints(0);
         }
      } catch (Exception var3) {
         var3.printStackTrace();
      }

      var1.setString(this.r);
      var1.setMaxSize(this.w);
      Display.getDisplay(GameMidlet.instance).setCurrent(var1);
   }

   public TField() {
      this.r = "";
      o = mFont.t.getWidth() + 1;
      this.j = new CommandLine(mResources.bj, this, 1000, (Object)null);
      D = 0;
      if (Rms.loadRMSInt("qwerty") == 1) {
         g = true;
      }

   }

   public final void b() {
      if (this.u > 0 && this.r.length() > 0) {
         this.r = this.r.substring(0, this.u - 1) + this.r.substring(this.u, this.r.length());
         --this.u;
         this.e();
         this.f();
      }

   }

   private void e() {
      if (this.C == 2) {
         this.t = this.s;
      } else {
         this.t = this.r;
      }

      if (this.x < 0 && mFont.t.getWidth(this.t) + this.x < this.width - 6 - 13) {
         this.x = this.width - 10 - mFont.t.getWidth(this.t);
      }

      if (this.x + mFont.t.getWidth(this.t.substring(0, this.u)) <= 0) {
         this.x = -mFont.t.getWidth(this.t.substring(0, this.u));
         this.x += 40;
      } else if (this.x + mFont.t.getWidth(this.t.substring(0, this.u)) >= this.width - 22) {
         this.x = this.width - 10 - mFont.t.getWidth(this.t.substring(0, this.u)) - 12;
      }

      if (this.x > 0) {
         this.x = 0;
      }

   }

   private void d(int var1) {
      if (var1 == 432) {
         var1 = 119;
      }

      if (this.C != 2 && this.C != 3 || var1 >= 48 && var1 <= 57 || var1 >= 65 && var1 <= 90 || var1 >= 97 && var1 <= 122) {
         if (this.r.length() < this.w) {
            String var2 = this.r.substring(0, this.u) + (char)var1;
            if (this.u < this.r.length()) {
               var2 = var2 + this.r.substring(this.u, this.r.length());
            }

            this.r = var2;
            ++this.u;
            this.f();
            this.e();
         }

      }
   }

   public final boolean keyPress(int var1) {
       System.out.println(var1);
      if (var1 != 8 && var1 != -8 && var1 != 204) {
         if (var1 >= 65 && var1 <= 122 && !g) {
            g = true;
            D = 0;
            Rms.saveRMSInt("qwerty", 1);
         }

         if (g) {
            if (var1 == 45) {
               if (var1 == this.y && this.z < n[m]) {
                  this.r = this.r.substring(0, this.u - 1) + '_';
                  this.t = this.r;
                  this.f();
                  this.e();
                  this.y = -1984;
                  return false;
               }

               this.y = 45;
            }

            if (var1 >= 32) {
               this.d(var1);
               return false;
            }
         }

         if (var1 == F) {
            ++this.E;
            if (this.E > 3) {
               this.E = 0;
            }

            this.z = 1;
            this.y = var1;
            return false;
         } else {
            if (var1 == 42) {
               var1 = 58;
            }

            if (var1 == 35) {
               var1 = 59;
            }

            if (var1 >= 48 && var1 <= 59) {
               if (this.C != 0 && this.C != 2 && this.C != 3) {
                  if (this.C == 1) {
                     this.d(var1);
                     this.z = 1;
                  }
               } else {
                  String[] var3;
                  if (this.C != 2 && this.C != 3) {
                     var3 = p;
                  } else {
                     var3 = q;
                  }

                  char var4;
                  String var5;
                  if (var1 == this.y) {
                     this.A = (this.A + 1) % var3[var1 - 48].length();
                     var4 = var3[var1 - 48].charAt(this.A);
                     if (this.E == 0) {
                        var4 = Character.toLowerCase(var4);
                     } else if (this.E == 1) {
                        var4 = Character.toUpperCase(var4);
                     } else if (this.E == 2) {
                        var4 = Character.toUpperCase(var4);
                     } else {
                        var4 = var3[var1 - 48].charAt(var3[var1 - 48].length() - 1);
                     }

                     var5 = this.r.substring(0, this.u - 1) + var4;
                     if (this.u < this.r.length()) {
                        var5 = var5 + this.r.substring(this.u, this.r.length());
                     }

                     this.r = var5;
                     this.z = n[m];
                     this.f();
                  } else if (this.r.length() < this.w) {
                     if (this.E == 1 && this.y != -1984) {
                        this.E = 0;
                     }

                     this.A = 0;
                     var4 = var3[var1 - 48].charAt(this.A);
                     if (this.E == 0) {
                        var4 = Character.toLowerCase(var4);
                     } else if (this.E == 1) {
                        var4 = Character.toUpperCase(var4);
                     } else if (this.E == 2) {
                        var4 = Character.toUpperCase(var4);
                     } else {
                        var4 = var3[var1 - 48].charAt(var3[var1 - 48].length() - 1);
                     }

                     var5 = this.r.substring(0, this.u) + var4;
                     if (this.u < this.r.length()) {
                        var5 = var5 + this.r.substring(this.u, this.r.length());
                     }

                     this.r = var5;
                     this.z = n[m];
                     ++this.u;
                     this.f();
                     this.e();
                  }

                  this.y = var1;
               }
            } else {
               this.A = 0;
               this.y = -1984;
               if (var1 == 14) {
                  if (this.u > 0) {
                     --this.u;
                     this.e();
                     this.B = 10;
                     return false;
                  }
               } else if (var1 == 15) {
                  if (this.u < this.r.length()) {
                     ++this.u;
                     this.e();
                     this.B = 10;
                     return false;
                  }
               } else {
                  if (var1 == 19) {
                     this.b();
                     return false;
                  }

                  this.y = var1;
               }
            }

            return true;
         }
      } else {
         this.b();
         return true;
      }
   }

   public final void paint(mGraphics var1) {
      if (this.H) {
         var1.e(0, 0, main.GameCanvas.z, main.GameCanvas.A);
      }

      boolean var2 = this.isFocus;
      if (this.C == 2) {
         this.t = this.s;
      } else {
         this.t = this.r;
      }

      int var10002 = this.a;
      int var10003 = this.b - 1;
      int var10004 = this.width;
      int var10005 = this.height;
      int var10006 = 6 + this.x + this.a;
      int var10007 = this.b + (this.height - mFont.t.getWidth()) / 2;
      String var12 = this.name;
      String var11 = this.t;
      int var10 = var10007;
      int var9 = var10006;
      int var8 = var10005;
      int var7 = var10004;
      int var6 = var10003;
      int var5 = var10002;
      mGraphics var3 = var1;
      var1.setColor(0);
      int var13;
      if (var2) {
         var1.setColor(I, 0, 81, 29, 27, 0, var5, var6, 0);
         var1.setColor(I, 0, 135, 29, 27, 0, var5 + var7 - 29, var6, 0);
         var1.setColor(I, 0, 108, 29, 27, 0, var5 + var7 - 58, var6, 0);

         for(var13 = 0; var13 < (var7 - 58) / 29; ++var13) {
            var3.setColor(I, 0, 108, 29, 27, 0, var5 + 29 + var13 * 29, var6, 0);
         }
      } else {
         var1.setColor(I, 0, 0, 29, 27, 0, var5, var6, 0);
         var1.setColor(I, 0, 54, 29, 27, 0, var5 + var7 - 29, var6, 0);
         var1.setColor(I, 0, 27, 29, 27, 0, var5 + var7 - 58, var6, 0);

         for(var13 = 0; var13 < (var7 - 58) / 29; ++var13) {
            var3.setColor(I, 0, 27, 29, 27, 0, var5 + 29 + var13 * 29, var6, 0);
         }
      }

      var3.e(var5 + 3, var6 + 1, var7 - 4, var8);
      if (var11 != null && !var11.equals("")) {
         mFont.t.drawStringBd(var3, var11, var9, var10, 0);
      } else if (var12 != null) {
         if (var2) {
            mFont.i.drawStringBd(var3, var12, var9, var10 + 2, 0);
         } else {
            mFont.j.drawStringBd(var3, var12, var9, var10 + 2, 0);
         }
      }

      var1.setColor(0);
      if (this.isFocus && this.isPaintCarret) {
         if (this.z == 0 && (this.B > 0 || this.v / 5 % 2 == 0)) {
            var1.setColor(7999781);
            var1.fillRect(7 + this.x + this.a + mFont.t.getWidth(this.t.substring(0, this.u)) - 1, this.b + (this.height - o) / 2 + 1, 1, o);
         }

         main.GameCanvas.a(var1);
         if (this.r != null && this.r.length() > 0 && main.GameCanvas.isTouch && var2) {
            var1.drawImage(G, this.a + this.width - 13, this.b + this.height / 2 + 1, 3);
         }
      }

   }

   private void f() {
      if (this.C == 2) {
         this.s = "";

         for(int var1 = 0; var1 < this.r.length(); ++var1) {
            this.s = this.s + "*";
         }

         if (this.z > 0 && this.u > 0) {
            this.s = this.s.substring(0, this.u - 1) + this.r.charAt(this.u - 1) + this.s.substring(this.u, this.s.length());
         }
      }

   }

   public final void update() {
      this.isPaintCarret = true;
      ++this.v;
      if (this.z > 0) {
         --this.z;
         if (this.z == 0) {
            this.A = 0;
            if (this.E == 1 && this.y != F) {
               this.E = 0;
            }

            this.y = -1984;
            this.f();
         }
      }

      if (this.B > 0) {
         --this.B;
      }

      if (main.GameCanvas.m) {
         if (main.GameCanvas.isPointerHoldIn(this.a + this.width - 20, this.b, 40, this.height)) {
            this.r = "";
            this.u = 0;
            this.e();
            this.f();
            this.isFocus = true;
            return;
         }

         if (main.GameCanvas.isPointerHoldIn(this.a, this.b, this.width, this.height)) {
            this.a();
            return;
         }

         this.isFocus = false;
      }

   }

   public final String getText() {
      return this.r;
   }

   public final void setText(String var1) {
      if (var1 != null) {
         this.y = -1984;
         this.z = 0;
         this.A = 0;
         this.r = var1;
         this.t = var1;
         this.f();
         this.u = var1.length();
         this.e();
      }
   }

   public final void b(int var1) {
      this.w = var1;
   }

   public final void setIputType(int var1) {
      this.C = var1;
      short var2 = 500;
      this.w = var2;
   }

   public final void perform(int var1, Object var2) {
      switch(var1) {
      case 1000:
         this.b();
      default:
      }
   }
}
