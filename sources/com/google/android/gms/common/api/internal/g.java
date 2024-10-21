package com.google.android.gms.common.api.internal;

import android.os.Handler;
import com.google.android.gms.common.api.internal.a;

/* loaded from: classes.dex */
final class g implements a.InterfaceC0027a {

    /* renamed from: a */
    final /* synthetic */ b f1261a;

    public g(b bVar) {
        this.f1261a = bVar;
    }

    @Override // com.google.android.gms.common.api.internal.a.InterfaceC0027a
    public final void a(boolean z2) {
        Handler handler;
        Handler handler2;
        b bVar = this.f1261a;
        handler = bVar.f1246p;
        handler2 = bVar.f1246p;
        handler.sendMessage(handler2.obtainMessage(1, Boolean.valueOf(z2)));
    }
}
