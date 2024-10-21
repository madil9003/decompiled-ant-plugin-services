package g2;

import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
final class m extends d {

    /* renamed from: a */
    private final Object f1813a = new Object();

    /* renamed from: b */
    private final j f1814b = new j();

    /* renamed from: c */
    private boolean f1815c;

    /* renamed from: d */
    private volatile boolean f1816d;

    /* renamed from: e */
    private Object f1817e;

    /* renamed from: f */
    private Exception f1818f;

    private final void k() {
        q1.f.j(this.f1815c, "Task is not yet complete");
    }

    private final void l() {
        if (this.f1816d) {
            throw new CancellationException("Task is already canceled.");
        }
    }

    private final void m() {
        if (this.f1815c) {
            throw a.a(this);
        }
    }

    private final void n() {
        synchronized (this.f1813a) {
            if (this.f1815c) {
                this.f1814b.b(this);
            }
        }
    }

    @Override // g2.d
    public final d a(b bVar) {
        this.f1814b.a(new h(f.f1802a, bVar));
        n();
        return this;
    }

    @Override // g2.d
    public final d b(Executor executor, b bVar) {
        this.f1814b.a(new h(executor, bVar));
        n();
        return this;
    }

    @Override // g2.d
    public final Exception c() {
        Exception exc;
        synchronized (this.f1813a) {
            exc = this.f1818f;
        }
        return exc;
    }

    @Override // g2.d
    public final Object d() {
        Object obj;
        synchronized (this.f1813a) {
            k();
            l();
            Exception exc = this.f1818f;
            if (exc != null) {
                throw new c(exc);
            }
            obj = this.f1817e;
        }
        return obj;
    }

    @Override // g2.d
    public final boolean e() {
        return this.f1816d;
    }

    @Override // g2.d
    public final boolean f() {
        boolean z2;
        synchronized (this.f1813a) {
            z2 = this.f1815c;
        }
        return z2;
    }

    @Override // g2.d
    public final boolean g() {
        boolean z2;
        synchronized (this.f1813a) {
            z2 = false;
            if (this.f1815c && !this.f1816d && this.f1818f == null) {
                z2 = true;
            }
        }
        return z2;
    }

    public final void h(Object obj) {
        synchronized (this.f1813a) {
            m();
            this.f1815c = true;
            this.f1817e = obj;
        }
        this.f1814b.b(this);
    }

    public final boolean i(Exception exc) {
        q1.f.h(exc, "Exception must not be null");
        synchronized (this.f1813a) {
            if (this.f1815c) {
                return false;
            }
            this.f1815c = true;
            this.f1818f = exc;
            this.f1814b.b(this);
            return true;
        }
    }

    public final boolean j(Object obj) {
        synchronized (this.f1813a) {
            if (this.f1815c) {
                return false;
            }
            this.f1815c = true;
            this.f1817e = obj;
            this.f1814b.b(this);
            return true;
        }
    }
}
