package g2;

import java.util.ArrayDeque;
import java.util.Queue;

/* loaded from: classes.dex */
final class j {

    /* renamed from: a */
    private final Object f1809a = new Object();

    /* renamed from: b */
    private Queue f1810b;

    /* renamed from: c */
    private boolean f1811c;

    public final void a(i iVar) {
        synchronized (this.f1809a) {
            if (this.f1810b == null) {
                this.f1810b = new ArrayDeque();
            }
            this.f1810b.add(iVar);
        }
    }

    public final void b(d dVar) {
        i iVar;
        synchronized (this.f1809a) {
            if (this.f1810b != null && !this.f1811c) {
                this.f1811c = true;
                while (true) {
                    synchronized (this.f1809a) {
                        iVar = (i) this.f1810b.poll();
                        if (iVar == null) {
                            this.f1811c = false;
                            return;
                        }
                    }
                    iVar.a(dVar);
                }
            }
        }
    }
}
