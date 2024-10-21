package s0;

import s0.g;

/* loaded from: classes.dex */
public abstract class i extends u0.b {

    /* renamed from: q */
    private g.l f3248q;

    /* renamed from: r */
    g.m f3249r;

    public i(g.m mVar) {
        this.f3249r = mVar;
    }

    public g.l B() {
        return this.f3248q;
    }

    public abstract boolean C(g.k kVar);

    public void D(g.l lVar) {
        this.f3248q = lVar;
    }

    @Override // u0.b
    public void o() {
        D(g.l.FAIL_EXECUTOR_CANCELLED_TASK);
        this.f3249r.a(g.k.NOT_CONNECTED, g.j.CONNECTION_LOST);
    }

    @Override // u0.b
    public void s() {
    }
}
