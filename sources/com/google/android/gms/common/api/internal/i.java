package com.google.android.gms.common.api.internal;

/* loaded from: classes.dex */
public final class i implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f1263a;

    /* renamed from: b */
    final /* synthetic */ l f1264b;

    public i(l lVar, int i2) {
        this.f1264b = lVar;
        this.f1263a = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f1264b.k(this.f1263a);
    }
}
