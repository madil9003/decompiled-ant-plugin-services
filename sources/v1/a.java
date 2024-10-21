package v1;

import android.content.Context;
import u1.f;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a */
    private static Context f3472a;

    /* renamed from: b */
    private static Boolean f3473b;

    public static synchronized boolean a(Context context) {
        Boolean bool;
        Boolean bool2;
        synchronized (a.class) {
            Context applicationContext = context.getApplicationContext();
            Context context2 = f3472a;
            if (context2 != null && (bool2 = f3473b) != null && context2 == applicationContext) {
                return bool2.booleanValue();
            }
            f3473b = null;
            if (!f.g()) {
                try {
                    context.getClassLoader().loadClass("com.google.android.instantapps.supervisor.InstantAppsRuntime");
                    f3473b = Boolean.TRUE;
                } catch (ClassNotFoundException unused) {
                    bool = Boolean.FALSE;
                }
                f3472a = applicationContext;
                return f3473b.booleanValue();
            }
            bool = Boolean.valueOf(applicationContext.getPackageManager().isInstantApp());
            f3473b = bool;
            f3472a = applicationContext;
            return f3473b.booleanValue();
        }
    }
}
