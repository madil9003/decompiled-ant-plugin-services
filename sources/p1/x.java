package p1;

import android.os.Bundle;
import com.google.android.gms.common.api.internal.LifecycleCallback;

/* loaded from: classes.dex */
final class x implements Runnable {

    /* renamed from: a */
    final /* synthetic */ LifecycleCallback f2986a;

    /* renamed from: b */
    final /* synthetic */ String f2987b;

    /* renamed from: c */
    final /* synthetic */ y f2988c;

    public x(y yVar, LifecycleCallback lifecycleCallback, String str) {
        this.f2988c = yVar;
        this.f2986a = lifecycleCallback;
        this.f2987b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Bundle bundle;
        Bundle bundle2;
        Bundle bundle3;
        y yVar = this.f2988c;
        i2 = yVar.f2991b;
        if (i2 > 0) {
            LifecycleCallback lifecycleCallback = this.f2986a;
            bundle = yVar.f2992c;
            if (bundle != null) {
                bundle3 = yVar.f2992c;
                bundle2 = bundle3.getBundle(this.f2987b);
            } else {
                bundle2 = null;
            }
            lifecycleCallback.f(bundle2);
        }
        i3 = this.f2988c.f2991b;
        if (i3 >= 2) {
            this.f2986a.j();
        }
        i4 = this.f2988c.f2991b;
        if (i4 >= 3) {
            this.f2986a.h();
        }
        i5 = this.f2988c.f2991b;
        if (i5 >= 4) {
            this.f2986a.k();
        }
        i6 = this.f2988c.f2991b;
        if (i6 >= 5) {
            this.f2986a.g();
        }
    }
}
