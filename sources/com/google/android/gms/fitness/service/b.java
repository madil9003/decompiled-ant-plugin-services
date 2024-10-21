package com.google.android.gms.fitness.service;

import com.google.android.gms.fitness.data.DataPoint;
import q1.f;
import x1.i;

/* loaded from: classes.dex */
final class b implements z1.b {

    /* renamed from: a */
    private final i f1564a;

    public b(i iVar) {
        this.f1564a = (i) f.g(iVar);
    }

    @Override // z1.b
    public final void a(DataPoint dataPoint) {
        dataPoint.h();
        this.f1564a.u(dataPoint);
    }
}
