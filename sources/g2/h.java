package g2;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
final class h implements i {

    /* renamed from: a */
    private final Executor f1806a;

    /* renamed from: b */
    private final Object f1807b = new Object();

    /* renamed from: c */
    private b f1808c;

    public h(Executor executor, b bVar) {
        this.f1806a = executor;
        this.f1808c = bVar;
    }

    @Override // g2.i
    public final void a(d dVar) {
        synchronized (this.f1807b) {
            if (this.f1808c == null) {
                return;
            }
            this.f1806a.execute(new g(this, dVar));
        }
    }
}
