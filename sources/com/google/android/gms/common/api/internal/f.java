package com.google.android.gms.common.api.internal;

import android.app.Activity;
import com.google.android.gms.common.ConnectionResult;

/* loaded from: classes.dex */
public final class f extends z {

    /* renamed from: f */
    private final a.b f1259f;

    /* renamed from: g */
    private final b f1260g;

    f(p1.e eVar, b bVar, com.google.android.gms.common.a aVar) {
        super(eVar, aVar);
        this.f1259f = new a.b();
        this.f1260g = bVar;
        this.f1221a.a("ConnectionlessLifecycleHelper", this);
    }

    public static void u(Activity activity, b bVar, p1.b bVar2) {
        p1.e c3 = LifecycleCallback.c(activity);
        f fVar = (f) c3.b("ConnectionlessLifecycleHelper", f.class);
        if (fVar == null) {
            fVar = new f(c3, bVar, com.google.android.gms.common.a.k());
        }
        q1.f.h(bVar2, "ApiKey cannot be null");
        fVar.f1259f.add(bVar2);
        bVar.c(fVar);
    }

    private final void v() {
        if (this.f1259f.isEmpty()) {
            return;
        }
        this.f1260g.c(this);
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void h() {
        super.h();
        v();
    }

    @Override // com.google.android.gms.common.api.internal.z, com.google.android.gms.common.api.internal.LifecycleCallback
    public final void j() {
        super.j();
        v();
    }

    @Override // com.google.android.gms.common.api.internal.z, com.google.android.gms.common.api.internal.LifecycleCallback
    public final void k() {
        super.k();
        this.f1260g.d(this);
    }

    @Override // com.google.android.gms.common.api.internal.z
    protected final void m(ConnectionResult connectionResult, int i2) {
        this.f1260g.F(connectionResult, i2);
    }

    @Override // com.google.android.gms.common.api.internal.z
    protected final void n() {
        this.f1260g.a();
    }

    public final a.b t() {
        return this.f1259f;
    }
}
