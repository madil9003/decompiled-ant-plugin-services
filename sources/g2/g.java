package g2;

/* loaded from: classes.dex */
final class g implements Runnable {

    /* renamed from: a */
    final /* synthetic */ d f1804a;

    /* renamed from: b */
    final /* synthetic */ h f1805b;

    public g(h hVar, d dVar) {
        this.f1805b = hVar;
        this.f1804a = dVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        b bVar;
        b bVar2;
        obj = this.f1805b.f1807b;
        synchronized (obj) {
            h hVar = this.f1805b;
            bVar = hVar.f1808c;
            if (bVar != null) {
                bVar2 = hVar.f1808c;
                bVar2.a(this.f1804a);
            }
        }
    }
}
