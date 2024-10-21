package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

/* loaded from: classes.dex */
public final class n extends q1.t {

    /* renamed from: a */
    private b f1401a;

    /* renamed from: b */
    private final int f1402b;

    public n(b bVar, int i2) {
        this.f1401a = bVar;
        this.f1402b = i2;
    }

    @Override // q1.c
    public final void C(int i2, IBinder iBinder, Bundle bundle) {
        q1.f.h(this.f1401a, "onPostInitComplete can be called only once per call to getRemoteService");
        this.f1401a.M(i2, iBinder, bundle, this.f1402b);
        this.f1401a = null;
    }

    @Override // q1.c
    public final void w(int i2, Bundle bundle) {
        Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
    }

    @Override // q1.c
    public final void z(int i2, IBinder iBinder, zzj zzjVar) {
        b bVar = this.f1401a;
        q1.f.h(bVar, "onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService");
        q1.f.g(zzjVar);
        b.a0(bVar, zzjVar);
        C(i2, iBinder, zzjVar.f1436a);
    }
}
