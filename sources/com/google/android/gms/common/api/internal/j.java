package com.google.android.gms.common.api.internal;

import o1.a;

/* loaded from: classes.dex */
final class j implements Runnable {

    /* renamed from: a */
    final /* synthetic */ k f1265a;

    public j(k kVar) {
        this.f1265a = kVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a.f fVar;
        a.f fVar2;
        l lVar = this.f1265a.f1266a;
        fVar = lVar.f1268b;
        fVar2 = lVar.f1268b;
        fVar.k(fVar2.getClass().getName().concat(" disconnecting because it was signed out."));
    }
}
