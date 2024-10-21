package q1;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;

/* loaded from: classes.dex */
public abstract class u {

    /* renamed from: a */
    private static final Object f3051a = new Object();

    /* renamed from: b */
    private static boolean f3052b;

    /* renamed from: c */
    private static String f3053c;

    /* renamed from: d */
    private static int f3054d;

    public static int a(Context context) {
        b(context);
        return f3054d;
    }

    private static void b(Context context) {
        Bundle bundle;
        synchronized (f3051a) {
            if (f3052b) {
                return;
            }
            f3052b = true;
            try {
                bundle = v1.c.a(context).a(context.getPackageName(), 128).metaData;
            } catch (PackageManager.NameNotFoundException e3) {
                Log.wtf("MetadataValueReader", "This should never happen.", e3);
            }
            if (bundle == null) {
                return;
            }
            f3053c = bundle.getString("com.google.app.id");
            f3054d = bundle.getInt("com.google.android.gms.version");
        }
    }
}
