package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.Feature;
import o1.a;

/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a */
    private final Feature[] f1248a;

    /* renamed from: b */
    private final boolean f1249b;

    /* renamed from: c */
    private final int f1250c;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a */
        private p1.i f1251a;

        /* renamed from: c */
        private Feature[] f1253c;

        /* renamed from: b */
        private boolean f1252b = true;

        /* renamed from: d */
        private int f1254d = 0;

        /* synthetic */ a(p1.w wVar) {
        }

        public c a() {
            q1.f.b(this.f1251a != null, "execute parameter required");
            return new r(this, this.f1253c, this.f1252b, this.f1254d);
        }

        public a b(p1.i iVar) {
            this.f1251a = iVar;
            return this;
        }

        public a c(boolean z2) {
            this.f1252b = z2;
            return this;
        }

        public a d(Feature... featureArr) {
            this.f1253c = featureArr;
            return this;
        }
    }

    public c(Feature[] featureArr, boolean z2, int i2) {
        this.f1248a = featureArr;
        boolean z3 = false;
        if (featureArr != null && z2) {
            z3 = true;
        }
        this.f1249b = z3;
        this.f1250c = i2;
    }

    public static a a() {
        return new a(null);
    }

    public abstract void b(a.b bVar, g2.e eVar);

    public boolean c() {
        return this.f1249b;
    }

    public final int d() {
        return this.f1250c;
    }

    public final Feature[] e() {
        return this.f1248a;
    }
}
