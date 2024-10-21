package com.google.android.gms.common.api.internal;

import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import java.util.Map;
import o1.a;

/* loaded from: classes.dex */
final class n implements Runnable {

    /* renamed from: a */
    final /* synthetic */ ConnectionResult f1282a;

    /* renamed from: b */
    final /* synthetic */ o f1283b;

    public n(o oVar, ConnectionResult connectionResult) {
        this.f1283b = oVar;
        this.f1282a = connectionResult;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Map map;
        p1.b bVar;
        a.f fVar;
        a.f fVar2;
        a.f fVar3;
        a.f fVar4;
        o oVar = this.f1283b;
        map = oVar.f1289f.f1242l;
        bVar = oVar.f1285b;
        l lVar = (l) map.get(bVar);
        if (lVar == null) {
            return;
        }
        if (!this.f1282a.e()) {
            lVar.G(this.f1282a, null);
            return;
        }
        this.f1283b.f1288e = true;
        fVar = this.f1283b.f1284a;
        if (fVar.n()) {
            this.f1283b.h();
            return;
        }
        try {
            o oVar2 = this.f1283b;
            fVar3 = oVar2.f1284a;
            fVar4 = oVar2.f1284a;
            fVar3.o(null, fVar4.m());
        } catch (SecurityException e3) {
            Log.e("GoogleApiManager", "Failed to get service from broker. ", e3);
            fVar2 = this.f1283b.f1284a;
            fVar2.k("Failed to get service from broker.");
            lVar.G(new ConnectionResult(10), null);
        }
    }
}
