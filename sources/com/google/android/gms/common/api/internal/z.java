package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public abstract class z extends LifecycleCallback implements DialogInterface.OnCancelListener {

    /* renamed from: b */
    protected volatile boolean f1311b;

    /* renamed from: c */
    protected final AtomicReference f1312c;

    /* renamed from: d */
    private final Handler f1313d;

    /* renamed from: e */
    protected final com.google.android.gms.common.a f1314e;

    public z(p1.e eVar, com.google.android.gms.common.a aVar) {
        super(eVar);
        this.f1312c = new AtomicReference(null);
        this.f1313d = new a2.f(Looper.getMainLooper());
        this.f1314e = aVar;
    }

    public final void l(ConnectionResult connectionResult, int i2) {
        this.f1312c.set(null);
        m(connectionResult, i2);
    }

    public final void o() {
        this.f1312c.set(null);
        n();
    }

    private static final int p(w wVar) {
        if (wVar == null) {
            return -1;
        }
        return wVar.a();
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void e(int i2, int i3, Intent intent) {
        w wVar = (w) this.f1312c.get();
        if (i2 != 1) {
            if (i2 == 2) {
                int e3 = this.f1314e.e(b());
                if (e3 == 0) {
                    o();
                    return;
                } else {
                    if (wVar == null) {
                        return;
                    }
                    if (wVar.b().a() == 18 && e3 == 18) {
                        return;
                    }
                }
            }
        } else if (i3 == -1) {
            o();
            return;
        } else if (i3 == 0) {
            if (wVar == null) {
                return;
            }
            l(new ConnectionResult(intent != null ? intent.getIntExtra("<<ResolutionFailureErrorDetail>>", 13) : 13, null, wVar.b().toString()), p(wVar));
            return;
        }
        if (wVar != null) {
            l(wVar.b(), wVar.a());
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void f(Bundle bundle) {
        super.f(bundle);
        if (bundle != null) {
            this.f1312c.set(bundle.getBoolean("resolving_error", false) ? new w(new ConnectionResult(bundle.getInt("failed_status"), (PendingIntent) bundle.getParcelable("failed_resolution")), bundle.getInt("failed_client_id", -1)) : null);
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void i(Bundle bundle) {
        super.i(bundle);
        w wVar = (w) this.f1312c.get();
        if (wVar == null) {
            return;
        }
        bundle.putBoolean("resolving_error", true);
        bundle.putInt("failed_client_id", wVar.a());
        bundle.putInt("failed_status", wVar.b().a());
        bundle.putParcelable("failed_resolution", wVar.b().c());
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void j() {
        super.j();
        this.f1311b = true;
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void k() {
        super.k();
        this.f1311b = false;
    }

    protected abstract void m(ConnectionResult connectionResult, int i2);

    protected abstract void n();

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        l(new ConnectionResult(13, null), p((w) this.f1312c.get()));
    }

    public final void s(ConnectionResult connectionResult, int i2) {
        w wVar = new w(connectionResult, i2);
        if (w0.a.a(this.f1312c, null, wVar)) {
            this.f1313d.post(new y(this, wVar));
        }
    }
}
