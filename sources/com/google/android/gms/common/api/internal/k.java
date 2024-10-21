package com.google.android.gms.common.api.internal;

import android.os.Handler;
import com.google.android.gms.common.internal.b;

/* loaded from: classes.dex */
public final class k implements b.e {

    /* renamed from: a */
    final /* synthetic */ l f1266a;

    public k(l lVar) {
        this.f1266a = lVar;
    }

    @Override // com.google.android.gms.common.internal.b.e
    public final void a() {
        Handler handler;
        handler = this.f1266a.f1279m.f1246p;
        handler.post(new j(this));
    }
}
