package com.google.android.gms.common.api.internal;

import android.os.Handler;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.b;
import java.util.Map;
import java.util.Set;
import o1.a;

/* loaded from: classes.dex */
public final class o implements b.c, p1.u {

    /* renamed from: a */
    private final a.f f1284a;

    /* renamed from: b */
    private final p1.b f1285b;

    /* renamed from: c */
    private com.google.android.gms.common.internal.e f1286c = null;

    /* renamed from: d */
    private Set f1287d = null;

    /* renamed from: e */
    private boolean f1288e = false;

    /* renamed from: f */
    final /* synthetic */ b f1289f;

    public o(b bVar, a.f fVar, p1.b bVar2) {
        this.f1289f = bVar;
        this.f1284a = fVar;
        this.f1285b = bVar2;
    }

    public final void h() {
        com.google.android.gms.common.internal.e eVar;
        if (!this.f1288e || (eVar = this.f1286c) == null) {
            return;
        }
        this.f1284a.o(eVar, this.f1287d);
    }

    @Override // p1.u
    public final void a(ConnectionResult connectionResult) {
        Map map;
        map = this.f1289f.f1242l;
        l lVar = (l) map.get(this.f1285b);
        if (lVar != null) {
            lVar.H(connectionResult);
        }
    }

    @Override // p1.u
    public final void b(com.google.android.gms.common.internal.e eVar, Set set) {
        if (eVar == null || set == null) {
            Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
            a(new ConnectionResult(4));
        } else {
            this.f1286c = eVar;
            this.f1287d = set;
            h();
        }
    }

    @Override // com.google.android.gms.common.internal.b.c
    public final void c(ConnectionResult connectionResult) {
        Handler handler;
        handler = this.f1289f.f1246p;
        handler.post(new n(this, connectionResult));
    }
}
