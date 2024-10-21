package com.google.android.gms.common.api.internal;

import android.app.Dialog;

/* loaded from: classes.dex */
final class x extends p1.o {

    /* renamed from: a */
    final /* synthetic */ Dialog f1307a;

    /* renamed from: b */
    final /* synthetic */ y f1308b;

    public x(y yVar, Dialog dialog) {
        this.f1308b = yVar;
        this.f1307a = dialog;
    }

    @Override // p1.o
    public final void a() {
        this.f1308b.f1310b.o();
        if (this.f1307a.isShowing()) {
            this.f1307a.dismiss();
        }
    }
}
