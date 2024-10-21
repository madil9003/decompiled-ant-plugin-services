package com.dsi.ant.plugins.antplus.pccbase;

import com.dsi.ant.plugins.antplus.pccbase.a;
import p0.e;

/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: e */
    private final a.f f856e;

    /* renamed from: f */
    private final a.e f857f;

    /* renamed from: a */
    protected volatile boolean f852a = false;

    /* renamed from: b */
    protected boolean f853b = false;

    /* renamed from: c */
    private com.dsi.ant.plugins.antplus.pccbase.a f854c = null;

    /* renamed from: d */
    protected final Object f855d = new Object();

    /* renamed from: g */
    protected final a.f f858g = new a();

    /* renamed from: h */
    protected final a.e f859h = new b();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements a.f {
        a() {
        }

        @Override // com.dsi.ant.plugins.antplus.pccbase.a.f
        public void a(com.dsi.ant.plugins.antplus.pccbase.a aVar, e eVar, p0.b bVar) {
            synchronized (d.this.f855d) {
                if (!d.this.f852a) {
                    d.this.f854c = aVar;
                    d dVar = d.this;
                    dVar.f853b = true;
                    dVar.f856e.a(aVar, eVar, bVar);
                } else if (d.this.f854c != null) {
                    d.this.f854c.o("received device after death");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements a.e {

        /* renamed from: a */
        private boolean f861a = false;

        b() {
        }

        @Override // com.dsi.ant.plugins.antplus.pccbase.a.e
        public void b(p0.b bVar) {
            synchronized (d.this.f855d) {
                if (d.this.h() && !this.f861a) {
                    if (p0.b.DEAD.equals(bVar)) {
                        this.f861a = true;
                    }
                    d.this.f857f.b(bVar);
                }
            }
        }
    }

    public d(a.f fVar, a.e eVar) {
        this.f856e = fVar;
        this.f857f = eVar;
    }

    public void g() {
        synchronized (this.f855d) {
            if (!this.f852a) {
                com.dsi.ant.plugins.antplus.pccbase.a aVar = this.f854c;
                if (aVar != null) {
                    aVar.t();
                    this.f859h.b(p0.b.DEAD);
                }
                if (!this.f853b) {
                    this.f853b = true;
                    this.f856e.a(null, e.USER_CANCELLED, p0.b.DEAD);
                }
                this.f852a = true;
                i();
            }
        }
    }

    public boolean h() {
        boolean z2;
        synchronized (this.f855d) {
            z2 = this.f853b && !this.f852a;
        }
        return z2;
    }

    protected abstract void i();
}
