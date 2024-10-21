package h1;

import android.content.Context;
import android.util.Log;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a */
    public static final int f1836a;

    /* renamed from: b */
    private static int f1837b;

    /* renamed from: c */
    private static final String f1838c;

    /* renamed from: d */
    private static String f1839d;

    /* renamed from: h1.a$a */
    /* loaded from: classes.dex */
    public enum EnumC0036a {
        NONE,
        ERROR,
        WARNING,
        INFO,
        DEBUG,
        VERBOSE
    }

    static {
        int ordinal = EnumC0036a.WARNING.ordinal();
        f1836a = ordinal;
        f1837b = ordinal;
        f1838c = a.class.getSimpleName();
        f1839d = "v.NTST: ";
    }

    public static final void a(String str, String str2) {
        if (f1837b >= EnumC0036a.DEBUG.ordinal()) {
            Log.d(str, f1839d + str2);
        }
    }

    public static final void b(String str, String str2) {
        if (f1837b >= EnumC0036a.ERROR.ordinal()) {
            Log.e(str, f1839d + str2);
        }
    }

    public static final void c(String str, String str2, Throwable th) {
        if (f1837b >= EnumC0036a.ERROR.ordinal()) {
            Log.e(str, f1839d + str2, th);
        }
    }

    public static int d() {
        return f1837b;
    }

    public static int e(Context context) {
        return f1837b;
    }

    public static final void f(String str, String str2) {
        if (f1837b >= EnumC0036a.INFO.ordinal()) {
            Log.i(str, f1839d + str2);
        }
    }

    public static void g(int i2, Context context) {
        Log.w(f1838c, "setDebugLevel is disabled as of API level 24, request special debug pluginLib to get more detailed logs");
    }

    public static void h(String str) {
        f1839d = str + ": ";
    }

    public static final void i(String str, String str2) {
        if (f1837b >= EnumC0036a.VERBOSE.ordinal()) {
            Log.v(str, f1839d + str2);
        }
    }

    public static final void j(String str, String str2) {
        if (f1837b >= EnumC0036a.WARNING.ordinal()) {
            Log.w(str, f1839d + str2);
        }
    }

    public static final void k(String str, String str2, Throwable th) {
        if (f1837b >= EnumC0036a.WARNING.ordinal()) {
            Log.w(str, f1839d + str2, th);
        }
    }
}
