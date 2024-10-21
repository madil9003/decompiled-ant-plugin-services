package b1;

import android.os.Bundle;
import android.os.RemoteException;
import com.dsi.ant.message.ipc.AntMessageParcel;
import com.dsi.ant.plugins.antplus.pcc.AntPlusWeightScalePcc;
import j.e;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import k.g;
import k.l;
import v.e;

/* loaded from: classes.dex */
public class c extends u0.b {

    /* renamed from: z */
    private static final String f234z = "c";

    /* renamed from: q */
    z0.a f235q;

    /* renamed from: r */
    CountDownLatch f236r;

    /* renamed from: s */
    private boolean f237s = false;

    /* renamed from: t */
    u.a f238t;

    /* renamed from: u */
    boolean f239u;

    /* renamed from: v */
    boolean f240v;

    /* renamed from: w */
    boolean f241w;

    /* renamed from: x */
    int f242x;

    /* renamed from: y */
    boolean f243y;

    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a */
        static final /* synthetic */ int[] f244a;

        /* renamed from: b */
        static final /* synthetic */ int[] f245b;

        static {
            int[] iArr = new int[l.values().length];
            f245b = iArr;
            try {
                iArr[l.CHANNEL_EVENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f245b[l.BROADCAST_DATA.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f245b[l.ACKNOWLEDGED_DATA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[e.values().length];
            f244a = iArr2;
            try {
                iArr2[e.RX_SEARCH_TIMEOUT.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f244a[e.CHANNEL_CLOSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public c(z0.a aVar, e.a aVar2) {
        u.a aVar3 = new u.a(203);
        this.f238t = aVar3;
        this.f235q = aVar;
        aVar3.c(aVar2.f3454c, aVar2.f3455d);
    }

    public void B() {
        boolean z2;
        try {
            z2 = this.f235q.f3444n.u(this, 1000);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            z2 = false;
        }
        if (z2) {
            this.f235q.k(300);
        } else {
            C(AntPlusWeightScalePcc.d.FAIL_ALREADY_BUSY_EXTERNAL);
        }
    }

    public void C(AntPlusWeightScalePcc.d dVar) {
        synchronized (this.f238t) {
            if (this.f237s) {
                return;
            }
            int b3 = dVar.b();
            Bundle bundle = new Bundle();
            bundle.putInt("int_statusCode", b3);
            if (dVar == AntPlusWeightScalePcc.d.SUCCESS) {
                bundle.putBoolean("bool_historySupport", this.f241w);
                bundle.putBoolean("bool_userProfileExchangeSupport", this.f239u);
                bundle.putBoolean("bool_userProfileSelected", this.f240v);
                bundle.putInt("int_userProfileID", this.f242x);
            }
            this.f238t.a(bundle);
            this.f237s = true;
        }
    }

    @Override // u0.b
    public void d() {
        AntPlusWeightScalePcc.d dVar;
        try {
        } catch (g.a e3) {
            h1.a.b(f234z, "AntCommandFailedException in dowork(): " + e3.toString());
            C(AntPlusWeightScalePcc.d.FAIL_DEVICE_COMMUNICATION_FAILURE);
            throw new RemoteException();
        } catch (InterruptedException unused) {
            h1.a.b(f234z, "Interrupted waiting for result");
            Thread.currentThread().interrupt();
        }
        if (this.f3396a.p().l() != j.c.TRACKING) {
            h1.a.b(f234z, "Failed: Channel not tracking");
            C(AntPlusWeightScalePcc.d.FAIL_DEVICE_COMMUNICATION_FAILURE);
            return;
        }
        this.f236r = new CountDownLatch(1);
        f();
        this.f236r.await(60L, TimeUnit.SECONDS);
        c();
        if (this.f243y) {
            if (this.f242x == 65535) {
                this.f242x = a1.a.f64k;
            }
            dVar = AntPlusWeightScalePcc.d.SUCCESS;
        } else {
            h1.a.b(f234z, "Timed out waiting for capabilities");
            dVar = AntPlusWeightScalePcc.d.FAIL_DEVICE_COMMUNICATION_FAILURE;
        }
        C(dVar);
    }

    @Override // u0.b
    public String k() {
        return "Capabilities Request";
    }

    @Override // u0.b
    public void o() {
        C(AntPlusWeightScalePcc.d.FAIL_DEVICE_COMMUNICATION_FAILURE);
    }

    @Override // u0.b
    public void s() {
    }

    @Override // u0.b
    public void u(l lVar, AntMessageParcel antMessageParcel) {
        int i2;
        int i3 = a.f245b[lVar.ordinal()];
        if (i3 == 1) {
            int i4 = a.f244a[new g(antMessageParcel).j().ordinal()];
            if (i4 == 1) {
                h1.a.b(f234z, "Search timeout occured");
                return;
            } else {
                if (i4 != 2) {
                    return;
                }
                h1.a.b(f234z, "Channel closed");
                c();
            }
        } else {
            if ((i3 != 2 && i3 != 3) || this.f243y) {
                return;
            }
            int i5 = w.c.i(antMessageParcel.a()[1]);
            if (i5 == 1) {
                z0.a aVar = this.f235q;
                aVar.f3616w.b(aVar.p(), this.f235q.q(), antMessageParcel);
                this.f239u = this.f235q.f3616w.i();
                this.f240v = this.f235q.f3616w.j();
                this.f241w = this.f235q.f3616w.h();
                i2 = this.f235q.f3616w.k();
            } else {
                if (i5 != 67) {
                    return;
                }
                int k2 = w.c.k(antMessageParcel.a(), 7);
                int k3 = w.c.k(antMessageParcel.a(), 5);
                if (k2 == 21 && k3 == 119) {
                    this.f239u = true;
                    this.f240v = false;
                    this.f241w = true;
                    i2 = 65535;
                } else {
                    this.f243y = false;
                }
            }
            this.f242x = i2;
            this.f243y = true;
        }
        this.f236r.countDown();
    }
}
