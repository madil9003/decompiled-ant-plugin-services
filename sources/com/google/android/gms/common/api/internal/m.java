package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.Feature;

/* loaded from: classes.dex */
public final class m {

    /* renamed from: a */
    private final p1.b f1280a;

    /* renamed from: b */
    private final Feature f1281b;

    public /* synthetic */ m(p1.b bVar, Feature feature, p1.m mVar) {
        this.f1280a = bVar;
        this.f1281b = feature;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof m)) {
            m mVar = (m) obj;
            if (q1.e.a(this.f1280a, mVar.f1280a) && q1.e.a(this.f1281b, mVar.f1281b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return q1.e.b(this.f1280a, this.f1281b);
    }

    public final String toString() {
        return q1.e.c(this).a("key", this.f1280a).a("feature", this.f1281b).toString();
    }
}
