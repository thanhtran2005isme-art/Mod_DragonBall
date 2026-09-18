package nro;

import java.io.DataInputStream;
import java.io.IOException;
import javax.microedition.lcdui.Image;

public final class mFont {

    private int K;
    private int L;
    private Image M;
    private String N;
    private int[][] O;
    private static String P = " 0123456789+-*='_?.,<>/[]{}!@#$%^&*():aáàảãạâấầẩẫậăắằẳẵặbcdđeéèẻẽẹêếềểễệfghiíìỉĩịjklmnoóòỏõọôốồổỗộơớờởỡợpqrstuúùủũụưứừửữựvxyýỳỷỹỵzwAÁÀẢÃẠĂẰẮẲẴẶÂẤẦẨẪẬBCDĐEÉÈẺẼẸÊẾỀỂỄỆFGHIÍÌỈĨỊJKLMNOÓÒỎÕỌÔỐỒỔỖỘƠỚỜỞỠỢPQRSTUÚÙỦŨỤƯỨỪỬỮỰVXYÝỲỶỸỴZW";
    public static mFont a;
    public static mFont b;
    public static mFont c;
    public static mFont d;
    public static mFont e;
    public static mFont tahoma_7b_dark;
    public static mFont g;
    public static mFont h;
    public static mFont i;
    public static mFont j;
    public static mFont k;
    public static mFont l;
    public static mFont m;
    public static mFont n;
    public static mFont o;
    public static mFont p;
    public static mFont q;
    public static mFont r;
    public static mFont s;
    public static mFont t;
    private static mFont Q;
    private static mFont R;
    private static mFont S;
    public static mFont u;
    private static mFont T;
    public static mFont v;
    public static mFont w;
    public static mFont x;
    public static mFont y;
    public static mFont z;
    public static mFont A;
    public static mFont B;
    public static mFont C;
    public static mFont D;
    public static mFont E;
    public static mFont F;
    public static mFont G;
    public static mFont H;
    public static mFont I;
    public static mFont J;
    private String U;

    static {
        a = new mFont(P, "/myfont/tahoma_7b_red.png", "/myfont/tahoma_7b", 0);
        b = new mFont(P, "/myfont/tahoma_7b_blue.png", "/myfont/tahoma_7b", 0);
        c = new mFont(P, "/myfont/tahoma_7b_white.png", "/myfont/tahoma_7b", 0);
        d = new mFont(P, "/myfont/tahoma_7b_yellow.png", "/myfont/tahoma_7b", 0);
        e = new mFont(P, "/myfont/tahoma_7b_yellow.png", "/myfont/tahoma_7b", 0);
        tahoma_7b_dark = new mFont(P, "/myfont/tahoma_7b_brown.png", "/myfont/tahoma_7b", 0);
        g = new mFont(P, "/myfont/tahoma_7b_green2.png", "/myfont/tahoma_7b", 0);
        h = new mFont(P, "/myfont/tahoma_7b_green.png", "/myfont/tahoma_7b", 0);
        i = new mFont(P, "/myfont/tahoma_7b_focus.png", "/myfont/tahoma_7b", 0);
        j = new mFont(P, "/myfont/tahoma_7b_unfocus.png", "/myfont/tahoma_7b", 0);
        k = new mFont(P, "/myfont/tahoma_7.png", "/myfont/tahoma_7", 0);
        l = new mFont(P, "/myfont/tahoma_7_blue1.png", "/myfont/tahoma_7", 0);
        m = new mFont(P, "/myfont/tahoma_7_green2.png", "/myfont/tahoma_7", 0);
        n = new mFont(P, "/myfont/tahoma_7_yellow.png", "/myfont/tahoma_7", 0);
        o = new mFont(P, "/myfont/tahoma_7_grey.png", "/myfont/tahoma_7", 0);
        p = new mFont(P, "/myfont/tahoma_7_red.png", "/myfont/tahoma_7", 0);
        q = new mFont(P, "/myfont/tahoma_7_blue.png", "/myfont/tahoma_7", 0);
        r = new mFont(P, "/myfont/tahoma_7_green.png", "/myfont/tahoma_7", 0);
        s = new mFont(P, "/myfont/tahoma_7_white.png", "/myfont/tahoma_7", 0);
        t = new mFont(P, "/myfont/tahoma_8b.png", "/myfont/tahoma_8b", -1);
        Q = new mFont(" 0123456789+-", "/myfont/number_yellow.png", "/myfont/number", 0);
        R = new mFont(" 0123456789+-", "/myfont/number_red.png", "/myfont/number", 0);
        S = new mFont(" 0123456789+-", "/myfont/number_green.png", "/myfont/number", 0);
        u = new mFont(" 0123456789+-", "/myfont/number_gray.png", "/myfont/number", 0);
        T = new mFont(" 0123456789+-", "/myfont/number_orange.png", "/myfont/number", 0);
        v = R;
        w = c;
        x = Q;
        y = S;
        z = T;
        A = l;
        B = p;
        C = n;
        D = r;
        E = o;
        F = n;
        G = g;
        H = s;
        I = h;
        J = l;
    }

    private mFont(String var1, String var2, String var3, int var4) {
        try {
            this.N = var1;
            this.K = var4;
            this.U = var2;
            var1 = null;
            this.M = mSystem.load(this.U);
            DataInputStream var9 = null;
            try {
                var9 = new DataInputStream(FireWorkMn.a(var3));
                this.O = new int[var9.readShort()][];

                for (int var10 = 0; var10 < this.O.length; ++var10) {
                    this.O[var10] = new int[4];
                    this.O[var10][0] = var9.readShort();
                    this.O[var10][1] = var9.readShort();
                    this.O[var10][2] = var9.readShort();
                    this.O[var10][3] = var9.readShort();
                    int var5 = this.O[var10][3];
                    this.L = var5;
                }

            } catch (Exception var7) {
                try {
                    var9.close();
                } catch (IOException var6) {
                    var6.printStackTrace();
                }
            }
        } catch (Exception var8) {
            var8.printStackTrace();
            System.out.println("paht data:" + var2);
        }
    }

    public final int getWidth() {
        return this.L;
    }

    public final int getWidth(String var1) {
        int var3 = 0;

        for (int var4 = 0; var4 < var1.length(); ++var4) {
            int var2;
            if ((var2 = this.N.indexOf(var1.charAt(var4))) == -1) {
                var2 = 0;
            }

            var3 += this.O[var2][2] + this.K;
        }

        return var3;
    }

    public final void drawStringBd(mGraphics var1, String var2, int var3, int var4, int var5) {
        int var6 = var2.length();
        if (var5 == 0) {
            var5 = var3;
        } else if (var5 == 1) {
            var5 = var3 - this.getWidth(var2);
        } else {
            var5 = var3 - (this.getWidth(var2) >> 1);
        }

        for (int var7 = 0; var7 < var6; ++var7) {
            if ((var3 = this.N.indexOf(var2.charAt(var7))) == -1) {
                var3 = 0;
            }

            if (var3 >= 0) {
                var1.setColor(this.M, this.O[var3][0], this.O[var3][1], this.O[var3][2], this.O[var3][3], 0, var5, var4, 20);
            }

            var5 += this.O[var3][2] + this.K;
        }

    }

    public final void drawString(mGraphics var1, String var2, int var3, int var4, int var5, mFont var6) {
        int var7 = var2.length();
        if (var5 == 0) {
            var5 = var3;
        } else if (var5 == 1) {
            var5 = var3 - this.getWidth(var2);
        } else {
            var5 = var3 - (this.getWidth(var2) >> 1);
        }

        for (int var8 = 0; var8 < var7; ++var8) {
            if ((var3 = this.N.indexOf(var2.charAt(var8))) == -1) {
                var3 = 0;
            }

            if (var3 >= 0) {
                if (!main.GameCanvas.a) {
                    var1.setColor(var6.M, this.O[var3][0], this.O[var3][1], this.O[var3][2], this.O[var3][3], 0, var5 + 1, var4, 20);
                    var1.setColor(var6.M, this.O[var3][0], this.O[var3][1], this.O[var3][2], this.O[var3][3], 0, var5, var4 + 1, 20);
                }

                var1.setColor(this.M, this.O[var3][0], this.O[var3][1], this.O[var3][2], this.O[var3][3], 0, var5, var4, 20);
            }

            var5 += this.O[var3][2] + this.K;
        }

    }

    public final String[] getWidth(String var1, int var2) {
        int var3 = var2;
        String var10 = var1;
        mFont var8 = this;
        MyVector var4 = new MyVector("vLine");
        String var5 = "";

        for (int var6 = 0; var6 < var10.length(); ++var6) {
            if (var10.charAt(var6) != '\n' && var10.charAt(var6) != '\b') {
                var5 = var5 + var10.charAt(var6);
                if (var8.getWidth(var5) > var3) {
                    int var7;
                    for (var7 = var5.length() - 1; var7 >= 0 && var5.charAt(var7) != ' '; --var7) {
                    }

                    if (var7 < 0) {
                        var7 = var5.length() - 1;
                    }

                    var4.addElement(var5.substring(0, var7));
                    var6 = var6 - (var5.length() - var7) + 1;
                    var5 = "";
                }

                if (var6 == var10.length() - 1 && !var5.trim().equals("")) {
                    var4.addElement(var5);
                }
            } else {
                var4.addElement(var5);
                var5 = "";
            }
        }

        MyVector var9 = var4;
        String[] var11 = new String[var4.size()];

        for (var3 = 0; var3 < var9.size(); ++var3) {
            var11[var3] = var9.elementAt(var3).toString();
        }

        return var11;
    }

    public final void b(mGraphics var1, String var2, int var3, int var4, int var5) {
        this.drawStringBd(var1, var2, var3, var4, 2);
    }

    public final void b(mGraphics var1, String var2, int var3, int var4, int var5, mFont var6) {
        this.drawString(var1, var2, var3, var4, var5, var6);
    }
}
