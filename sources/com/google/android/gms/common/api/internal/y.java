package com.google.android.gms.common.api.internal;

import android.app.Dialog;
import android.app.PendingIntent;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiActivity;

/* loaded from: classes.dex */
public final class y implements Runnable {

    /* renamed from: a */
    private final w f1309a;

    /* renamed from: b */
    final /* synthetic */ z f1310b;

    public y(z zVar, w wVar) {
        this.f1310b = zVar;
        this.f1309a = wVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f1310b.f1311b) {
            ConnectionResult b3 = this.f1309a.b();
            if (b3.d()) {
                z zVar = this.f1310b;
                zVar.f1221a.startActivityForResult(GoogleApiActivity.a(zVar.b(), (PendingIntent) q1.f.g(b3.c()), this.f1309a.a(), false), 1);
                return;
            }
            z zVar2 = this.f1310b;
            if (zVar2.f1314e.a(zVar2.b(), b3.a(), null) != null) {
                z zVar3 = this.f1310b;
                zVar3.f1314e.t(zVar3.b(), this.f1310b.f1221a, b3.a(), 2, this.f1310b);
            } else {
                if (b3.a() != 18) {
                    this.f1310b.l(b3, this.f1309a.a());
                    return;
                }
                z zVar4 = this.f1310b;
                Dialog o2 = zVar4.f1314e.o(zVar4.b(), this.f1310b);
                z zVar5 = this.f1310b;
                zVar5.f1314e.p(zVar5.b().getApplicationContext(), new x(this, o2));
            }
        }
    }
}
