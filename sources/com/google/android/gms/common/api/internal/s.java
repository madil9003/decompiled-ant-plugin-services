package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* loaded from: classes.dex */
public abstract class s extends p1.q {

    /* renamed from: b */
    protected final g2.e f1300b;

    public s(int i2, g2.e eVar) {
        super(i2);
        this.f1300b = eVar;
    }

    @Override // com.google.android.gms.common.api.internal.v
    public final void a(Status status) {
        this.f1300b.c(new o1.b(status));
    }

    @Override // com.google.android.gms.common.api.internal.v
    public final void b(Exception exc) {
        this.f1300b.c(exc);
    }

    @Override // com.google.android.gms.common.api.internal.v
    public final void c(l lVar) {
        try {
            h(lVar);
        } catch (DeadObjectException e3) {
            a(v.e(e3));
            throw e3;
        } catch (RemoteException e4) {
            a(v.e(e4));
        } catch (RuntimeException e5) {
            this.f1300b.c(e5);
        }
    }

    protected abstract void h(l lVar);
}
