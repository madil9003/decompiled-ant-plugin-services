package k0;

import android.os.Bundle;
import android.os.RemoteException;
import com.dsi.ant.channel.AntChannel;
import com.dsi.ant.plugins.antplus.pcc.AntPlusGeocachePcc;
import j.h;
import j.i;
import v.e;

/* loaded from: classes.dex */
public class b extends a {
    private static final String H = "b";
    private final i0.a C;
    e.a D;
    private final u.a E;
    private u.a F;
    private boolean G;

    public b(i0.a aVar, e.a aVar2, int i2, boolean z2, boolean z3) {
        super(aVar, aVar.f1858n.c(i2), z2);
        u.a aVar3 = new u.a(204);
        this.E = aVar3;
        this.F = new u.a(202);
        this.G = false;
        this.C = aVar;
        this.D = aVar2;
        aVar3.c(aVar2.f3454c, aVar2.f3455d);
        if (z3) {
            this.F.c(aVar2.f3454c, aVar2.f3455d);
        }
    }

    @Override // k0.a
    public void B(int i2, int i3) {
        if (this.F.b()) {
            Bundle bundle = new Bundle();
            bundle.putInt("int_workUnitsFinished", i2);
            bundle.putInt("int_totalUnitsWork", i3);
            this.F.a(bundle);
        }
    }

    public void C() {
        boolean z2;
        j0.a aVar = this.f2057y;
        if (aVar == null) {
            D(AntPlusGeocachePcc.b.FAIL_DEVICE_NOT_IN_LIST);
            return;
        }
        if (aVar.d() < 0 && (!this.f2053u || this.f2057y.h())) {
            D(AntPlusGeocachePcc.b.SUCCESS);
            return;
        }
        try {
            z2 = this.C.f1857m.u(this, 1000);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            z2 = false;
        }
        if (z2) {
            this.C.k(300);
        } else {
            D(AntPlusGeocachePcc.b.FAIL_ALREADY_BUSY_EXTERNAL);
        }
    }

    public void D(AntPlusGeocachePcc.b bVar) {
        synchronized (this.E) {
            if (this.G) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putInt("int_statusCode", bVar.b());
            if (bVar == AntPlusGeocachePcc.b.SUCCESS) {
                Bundle bundle2 = new Bundle();
                if (this.D.f3456e == 0) {
                    g1.a.b(this.f2057y.f1957c, bundle2);
                } else {
                    bundle2.putParcelable("parcelable_GeocacheDeviceData", this.f2057y.f1957c);
                }
                bundle.putBundle("bundle_downloadedData", bundle2);
            }
            this.E.a(bundle);
            this.G = true;
        }
    }

    @Override // k0.a, u0.b
    public void d() {
        try {
        } catch (RemoteException e3) {
            D(AntPlusGeocachePcc.b.FAIL_DEVICE_COMMUNICATION_FAILURE);
            throw e3;
        } catch (g.a e4) {
            h1.a.b(H, "ACFE setting search timeout: " + e4.toString());
        }
        try {
            AntChannel antChannel = this.f3396a;
            i iVar = i0.a.f1851q;
            antChannel.B(iVar, h.FIVE_SECONDS);
            super.d();
            this.f3396a.B(iVar, h.DISABLED);
            D(this.f2057y != null ? AntPlusGeocachePcc.b.SUCCESS : AntPlusGeocachePcc.b.FAIL_DEVICE_COMMUNICATION_FAILURE);
        } catch (Throwable th) {
            this.f3396a.B(i0.a.f1851q, h.DISABLED);
            throw th;
        }
    }

    @Override // k0.a, u0.b
    public String k() {
        return "Geocache Data Download " + this.f2051s;
    }

    @Override // k0.a, u0.b
    public boolean p(int i2) {
        if (i2 != Integer.MAX_VALUE) {
            return false;
        }
        D(AntPlusGeocachePcc.b.FAIL_DEVICE_COMMUNICATION_FAILURE);
        return super.p(i2);
    }

    @Override // k0.a, u0.b
    public void s() {
    }
}
