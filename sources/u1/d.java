package u1;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;

/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a */
    private static Boolean f3416a;

    /* renamed from: b */
    private static Boolean f3417b;

    /* renamed from: c */
    private static Boolean f3418c;

    /* renamed from: d */
    private static Boolean f3419d;

    /* renamed from: e */
    private static Boolean f3420e;

    /* renamed from: f */
    private static Boolean f3421f;

    /* renamed from: g */
    private static Boolean f3422g;

    public static boolean a(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (f3421f == null) {
            boolean z2 = false;
            if (f.g() && packageManager.hasSystemFeature("android.hardware.type.automotive")) {
                z2 = true;
            }
            f3421f = Boolean.valueOf(z2);
        }
        return f3421f.booleanValue();
    }

    public static boolean b(Resources resources) {
        if (resources == null) {
            return false;
        }
        if (f3416a == null) {
            f3416a = Boolean.valueOf((resources.getConfiguration().screenLayout & 15) > 3 || h(resources));
        }
        return f3416a.booleanValue();
    }

    public static boolean c(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (f3422g == null) {
            boolean z2 = true;
            if (!packageManager.hasSystemFeature("com.google.android.tv") && !packageManager.hasSystemFeature("android.hardware.type.television") && !packageManager.hasSystemFeature("android.software.leanback")) {
                z2 = false;
            }
            f3422g = Boolean.valueOf(z2);
        }
        return f3422g.booleanValue();
    }

    public static boolean d(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (f3418c == null) {
            boolean z2 = false;
            if (f.d() && packageManager.hasSystemFeature("android.hardware.type.watch")) {
                z2 = true;
            }
            f3418c = Boolean.valueOf(z2);
        }
        return f3418c.booleanValue();
    }

    public static boolean e(Context context) {
        if (!d(context)) {
            return false;
        }
        if (f.f()) {
            return f(context) && !f.g();
        }
        return true;
    }

    public static boolean f(Context context) {
        if (f3419d == null) {
            boolean z2 = false;
            if (f.e() && context.getPackageManager().hasSystemFeature("cn.google")) {
                z2 = true;
            }
            f3419d = Boolean.valueOf(z2);
        }
        return f3419d.booleanValue();
    }

    public static boolean g(Context context) {
        if (f3420e == null) {
            boolean z2 = true;
            if (!context.getPackageManager().hasSystemFeature("android.hardware.type.iot") && !context.getPackageManager().hasSystemFeature("android.hardware.type.embedded")) {
                z2 = false;
            }
            f3420e = Boolean.valueOf(z2);
        }
        return f3420e.booleanValue();
    }

    public static boolean h(Resources resources) {
        boolean z2 = false;
        if (resources == null) {
            return false;
        }
        if (f3417b == null) {
            Configuration configuration = resources.getConfiguration();
            if ((configuration.screenLayout & 15) <= 3 && configuration.smallestScreenWidthDp >= 600) {
                z2 = true;
            }
            f3417b = Boolean.valueOf(z2);
        }
        return f3417b.booleanValue();
    }
}
