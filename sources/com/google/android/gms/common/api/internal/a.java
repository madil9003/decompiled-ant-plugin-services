package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public final class a implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {

    /* renamed from: e */
    private static final a f1222e = new a();

    /* renamed from: a */
    private final AtomicBoolean f1223a = new AtomicBoolean();

    /* renamed from: b */
    private final AtomicBoolean f1224b = new AtomicBoolean();

    /* renamed from: c */
    private final ArrayList f1225c = new ArrayList();

    /* renamed from: d */
    private boolean f1226d = false;

    /* renamed from: com.google.android.gms.common.api.internal.a$a */
    /* loaded from: classes.dex */
    public interface InterfaceC0027a {
        void a(boolean z2);
    }

    private a() {
    }

    public static a b() {
        return f1222e;
    }

    public static void c(Application application) {
        a aVar = f1222e;
        synchronized (aVar) {
            if (!aVar.f1226d) {
                application.registerActivityLifecycleCallbacks(aVar);
                application.registerComponentCallbacks(aVar);
                aVar.f1226d = true;
            }
        }
    }

    private final void f(boolean z2) {
        synchronized (f1222e) {
            Iterator it = this.f1225c.iterator();
            while (it.hasNext()) {
                ((InterfaceC0027a) it.next()).a(z2);
            }
        }
    }

    public void a(InterfaceC0027a interfaceC0027a) {
        synchronized (f1222e) {
            this.f1225c.add(interfaceC0027a);
        }
    }

    public boolean d() {
        return this.f1223a.get();
    }

    public boolean e(boolean z2) {
        if (!this.f1224b.get()) {
            if (!u1.f.a()) {
                return z2;
            }
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (!this.f1224b.getAndSet(true) && runningAppProcessInfo.importance > 100) {
                this.f1223a.set(true);
            }
        }
        return d();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        boolean compareAndSet = this.f1223a.compareAndSet(true, false);
        this.f1224b.set(true);
        if (compareAndSet) {
            f(false);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        boolean compareAndSet = this.f1223a.compareAndSet(true, false);
        this.f1224b.set(true);
        if (compareAndSet) {
            f(false);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int i2) {
        if (i2 == 20 && this.f1223a.compareAndSet(false, true)) {
            this.f1224b.set(true);
            f(true);
        }
    }
}
