package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Scope;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executor;
import o1.a;
import o1.e;

/* loaded from: classes.dex */
public abstract class c extends b implements a.f {
    private final q1.b F;
    private final Set G;
    private final Account H;

    public c(Context context, Looper looper, int i2, q1.b bVar, e.a aVar, e.b bVar2) {
        this(context, looper, i2, bVar, (p1.c) aVar, (p1.h) bVar2);
    }

    private final Set i0(Set set) {
        Set h02 = h0(set);
        Iterator it = h02.iterator();
        while (it.hasNext()) {
            if (!set.contains((Scope) it.next())) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        return h02;
    }

    @Override // com.google.android.gms.common.internal.b
    protected final Set B() {
        return this.G;
    }

    protected Set h0(Set set) {
        return set;
    }

    @Override // o1.a.f
    public Set m() {
        return n() ? this.G : Collections.emptySet();
    }

    @Override // com.google.android.gms.common.internal.b
    public final Account t() {
        return this.H;
    }

    @Override // com.google.android.gms.common.internal.b
    protected final Executor v() {
        return null;
    }

    public c(Context context, Looper looper, int i2, q1.b bVar, p1.c cVar, p1.h hVar) {
        this(context, looper, d.b(context), com.google.android.gms.common.a.k(), i2, bVar, (p1.c) q1.f.g(cVar), (p1.h) q1.f.g(hVar));
    }

    protected c(Context context, Looper looper, d dVar, com.google.android.gms.common.a aVar, int i2, q1.b bVar, p1.c cVar, p1.h hVar) {
        super(context, looper, dVar, aVar, i2, cVar == null ? null : new f(cVar), hVar == null ? null : new g(hVar), bVar.h());
        this.F = bVar;
        this.H = bVar.a();
        this.G = i0(bVar.c());
    }
}
