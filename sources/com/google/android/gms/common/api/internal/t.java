package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Status;

/* loaded from: classes.dex */
public final class t extends p1.q {

    /* renamed from: b */
    private final c f1301b;

    /* renamed from: c */
    private final g2.e f1302c;

    /* renamed from: d */
    private final p1.j f1303d;

    public t(int i2, c cVar, g2.e eVar, p1.j jVar) {
        super(i2);
        this.f1302c = eVar;
        this.f1301b = cVar;
        this.f1303d = jVar;
        if (i2 == 2 && cVar.c()) {
            throw new IllegalArgumentException("Best-effort write calls cannot pass methods that should auto-resolve missing features.");
        }
    }

    @Override // com.google.android.gms.common.api.internal.v
    public final void a(Status status) {
        this.f1302c.c(this.f1303d.a(status));
    }

    @Override // com.google.android.gms.common.api.internal.v
    public final void b(Exception exc) {
        this.f1302c.c(exc);
    }

    @Override // com.google.android.gms.common.api.internal.v
    public final void c(l lVar) {
        try {
            this.f1301b.b(lVar.u(), this.f1302c);
        } catch (DeadObjectException e3) {
            throw e3;
        } catch (RemoteException e4) {
            a(v.e(e4));
        } catch (RuntimeException e5) {
            this.f1302c.c(e5);
        }
    }

    @Override // com.google.android.gms.common.api.internal.v
    public final void d(e eVar, boolean z2) {
        eVar.b(this.f1302c, z2);
    }

    @Override // p1.q
    public final boolean f(l lVar) {
        return this.f1301b.c();
    }

    @Override // p1.q
    public final Feature[] g(l lVar) {
        return this.f1301b.e();
    }
}
