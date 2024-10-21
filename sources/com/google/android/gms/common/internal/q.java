package com.google.android.gms.common.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;

/* loaded from: classes.dex */
public final class q extends j {

    /* renamed from: g */
    final /* synthetic */ b f1407g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(b bVar, int i2, Bundle bundle) {
        super(bVar, i2, null);
        this.f1407g = bVar;
    }

    @Override // com.google.android.gms.common.internal.j
    protected final void f(ConnectionResult connectionResult) {
        if (this.f1407g.s() && b.f0(this.f1407g)) {
            b.b0(this.f1407g, 16);
        } else {
            this.f1407g.f1374p.c(connectionResult);
            this.f1407g.K(connectionResult);
        }
    }

    @Override // com.google.android.gms.common.internal.j
    protected final boolean g() {
        this.f1407g.f1374p.c(ConnectionResult.f1193e);
        return true;
    }
}
