package com.google.android.gms.common.internal;

import android.app.PendingIntent;
import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;

/* loaded from: classes.dex */
abstract class j extends m {

    /* renamed from: d */
    public final int f1393d;

    /* renamed from: e */
    public final Bundle f1394e;

    /* renamed from: f */
    final /* synthetic */ b f1395f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(b bVar, int i2, Bundle bundle) {
        super(bVar, Boolean.TRUE);
        this.f1395f = bVar;
        this.f1393d = i2;
        this.f1394e = bundle;
    }

    @Override // com.google.android.gms.common.internal.m
    protected final /* bridge */ /* synthetic */ void a(Object obj) {
        ConnectionResult connectionResult;
        if (this.f1393d != 0) {
            this.f1395f.g0(1, null);
            Bundle bundle = this.f1394e;
            connectionResult = new ConnectionResult(this.f1393d, bundle != null ? (PendingIntent) bundle.getParcelable("pendingIntent") : null);
        } else {
            if (g()) {
                return;
            }
            this.f1395f.g0(1, null);
            connectionResult = new ConnectionResult(8, null);
        }
        f(connectionResult);
    }

    @Override // com.google.android.gms.common.internal.m
    public final void b() {
    }

    protected abstract void f(ConnectionResult connectionResult);

    protected abstract boolean g();
}
