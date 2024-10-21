package t1;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.util.Log;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import q1.a0;
import q1.f;
import v1.c;

/* loaded from: classes.dex */
public class a {

    /* renamed from: b */
    private static final Object f3368b = new Object();

    /* renamed from: c */
    private static volatile a f3369c;

    /* renamed from: a */
    public ConcurrentHashMap f3370a = new ConcurrentHashMap();

    private a() {
    }

    public static a a() {
        if (f3369c == null) {
            synchronized (f3368b) {
                if (f3369c == null) {
                    f3369c = new a();
                }
            }
        }
        a aVar = f3369c;
        f.g(aVar);
        return aVar;
    }

    private static void d(Context context, ServiceConnection serviceConnection) {
        try {
            context.unbindService(serviceConnection);
        } catch (IllegalArgumentException | IllegalStateException | NoSuchElementException unused) {
        }
    }

    private final boolean e(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i2, boolean z2, Executor executor) {
        ComponentName component = intent.getComponent();
        if (component != null) {
            String packageName = component.getPackageName();
            "com.google.android.gms".equals(packageName);
            try {
                if ((c.a(context).a(packageName, 0).flags & 2097152) != 0) {
                    Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
                    return false;
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        if (!f(serviceConnection)) {
            return g(context, intent, serviceConnection, i2, executor);
        }
        ServiceConnection serviceConnection2 = (ServiceConnection) this.f3370a.putIfAbsent(serviceConnection, serviceConnection);
        if (serviceConnection2 != null && serviceConnection != serviceConnection2) {
            Log.w("ConnectionTracker", String.format("Duplicate binding with the same ServiceConnection: %s, %s, %s.", serviceConnection, str, intent.getAction()));
        }
        try {
            boolean g3 = g(context, intent, serviceConnection, i2, executor);
            if (g3) {
                return g3;
            }
            return false;
        } finally {
            this.f3370a.remove(serviceConnection, serviceConnection);
        }
    }

    private static boolean f(ServiceConnection serviceConnection) {
        return !(serviceConnection instanceof a0);
    }

    private static final boolean g(Context context, Intent intent, ServiceConnection serviceConnection, int i2, Executor executor) {
        return (!u1.f.h() || executor == null) ? context.bindService(intent, serviceConnection, i2) : context.bindService(intent, i2, executor, serviceConnection);
    }

    public void b(Context context, ServiceConnection serviceConnection) {
        if (!f(serviceConnection) || !this.f3370a.containsKey(serviceConnection)) {
            d(context, serviceConnection);
            return;
        }
        try {
            d(context, (ServiceConnection) this.f3370a.get(serviceConnection));
        } finally {
            this.f3370a.remove(serviceConnection);
        }
    }

    public final boolean c(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i2, Executor executor) {
        return e(context, str, intent, serviceConnection, i2, true, executor);
    }
}
