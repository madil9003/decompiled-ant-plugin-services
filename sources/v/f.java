package v;

import com.dsi.ant.message.ipc.AntMessageParcel;
import java.util.concurrent.CountDownLatch;
import k.l;
import u0.a;

/* loaded from: classes.dex */
public final class f extends u0.b {

    /* renamed from: t */
    private static final String f3458t = "f";

    /* renamed from: q */
    private v.a f3459q;

    /* renamed from: s */
    private CountDownLatch f3461s = new CountDownLatch(1);

    /* renamed from: r */
    private a.c f3460r = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements a.c {
        a() {
        }

        @Override // u0.a.c
        public void a() {
            f.this.f3459q.s();
        }
    }

    private f(v.a aVar) {
        this.f3459q = aVar;
    }

    public static u0.a C(v.a aVar) {
        f fVar = new f(aVar);
        aVar.f3424h.g();
        u0.a aVar2 = new u0.a(aVar.f3424h, fVar.f3460r);
        aVar2.s(fVar);
        return aVar2;
    }

    @Override // u0.b
    public void d() {
        this.f3459q.o(false);
        f();
        try {
            this.f3461s.await();
        } catch (InterruptedException unused) {
            h1.a.a(f3458t, "Interrupted while idling");
            Thread.currentThread().interrupt();
        }
    }

    @Override // u0.b
    public String k() {
        return "AntPluginAntDevice Default Processing";
    }

    @Override // u0.b
    public void o() {
        p(Integer.MAX_VALUE);
    }

    @Override // u0.b
    public boolean p(int i2) {
        this.f3461s.countDown();
        return true;
    }

    @Override // u0.b
    public void s() {
        this.f3461s = new CountDownLatch(1);
    }

    @Override // u0.b
    public void u(l lVar, AntMessageParcel antMessageParcel) {
        this.f3459q.r(lVar, antMessageParcel);
    }
}
