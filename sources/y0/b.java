package y0;

import com.dsi.ant.message.ipc.AntMessageParcel;
import j.d;
import k.l;
import s0.g;
import s0.i;
import x0.a;

/* loaded from: classes.dex */
public class b extends i {

    /* renamed from: t */
    private static final String f3600t = "b";

    /* renamed from: s */
    private a.C0067a f3601s;

    public b(g.m mVar, a.C0067a c0067a) {
        super(mVar);
        this.f3601s = c0067a;
    }

    @Override // s0.i
    public boolean C(g.k kVar) {
        return kVar == g.k.NOT_CONNECTED;
    }

    @Override // u0.b
    public void d() {
        try {
            i();
            this.f3396a.c(d.BIDIRECTIONAL_SLAVE);
            this.f3396a.z(this.f3601s.f3560c);
            this.f3396a.x(this.f3601s.f3559b);
            this.f3396a.A(j.i.TWENTY_FIVE_SECONDS);
            this.f3396a.u(new j.b(this.f3601s.f3558a.a(), this.f3601s.f3558a.b(), this.f3601s.f3558a.e()));
            this.f3396a.l();
            D(g.l.SUCCESS);
        } catch (g.a e3) {
            h1.a.b(f3600t, "ACFE occurred: " + e3.toString());
            D(g.l.FAIL_OTHER_DEVICE_COMMUNICATION_ERROR);
        } catch (InterruptedException unused) {
            h1.a.a(f3600t, "Interrupted waiting for result");
            D(g.l.FAIL_EXECUTOR_CANCELLED_TASK);
            Thread.currentThread().interrupt();
        }
    }

    @Override // u0.b
    public String k() {
        return "WatchCommunicator Track Device";
    }

    @Override // u0.b
    public void u(l lVar, AntMessageParcel antMessageParcel) {
    }
}
