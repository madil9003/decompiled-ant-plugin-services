package k0;

import android.os.Bundle;
import com.dsi.ant.message.ipc.AntMessageParcel;
import com.dsi.ant.plugins.antplus.pcc.AntPlusGeocachePcc;
import java.util.concurrent.CountDownLatch;
import k.g;
import k.l;
import v.e;

/* loaded from: classes.dex */
public class d extends u0.b {
    private static final String D = "d";
    private CountDownLatch A;
    private boolean B;
    private boolean C;

    /* renamed from: q */
    private final i0.a f2073q;

    /* renamed from: r */
    private final u.a f2074r;

    /* renamed from: s */
    private u.a f2075s;

    /* renamed from: t */
    private j0.a f2076t;

    /* renamed from: u */
    private int f2077u;

    /* renamed from: v */
    private int f2078v;

    /* renamed from: w */
    private long f2079w;

    /* renamed from: x */
    private long f2080x;

    /* renamed from: y */
    private int f2081y;

    /* renamed from: z */
    private byte[] f2082z;

    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a */
        static final /* synthetic */ int[] f2083a;

        /* renamed from: b */
        static final /* synthetic */ int[] f2084b;

        static {
            int[] iArr = new int[l.values().length];
            f2084b = iArr;
            try {
                iArr[l.CHANNEL_EVENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2084b[l.BROADCAST_DATA.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2084b[l.ACKNOWLEDGED_DATA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[j.e.values().length];
            f2083a = iArr2;
            try {
                iArr2[j.e.RX_SEARCH_TIMEOUT.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f2083a[j.e.CHANNEL_CLOSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f2083a[j.e.TRANSFER_TX_COMPLETED.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f2083a[j.e.TRANSFER_TX_FAILED.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public d(i0.a aVar, e.a aVar2, int i2, int i3, long j2, boolean z2) {
        u.a aVar3 = new u.a(205);
        this.f2074r = aVar3;
        this.f2075s = new u.a(202);
        this.f2080x = -1L;
        this.f2081y = -1;
        this.f2082z = null;
        this.B = false;
        this.C = false;
        this.f2073q = aVar;
        this.f2077u = i2;
        this.f2078v = i3;
        this.f2079w = j2;
        aVar3.c(aVar2.f3454c, aVar2.f3455d);
        if (z2) {
            this.f2075s.c(aVar2.f3454c, aVar2.f3455d);
        }
    }

    private void C(int i2, int i3) {
        if (this.f2075s.b()) {
            Bundle bundle = new Bundle();
            bundle.putInt("int_workUnitsFinished", i2);
            bundle.putInt("int_totalUnitsWork", i3);
            this.f2075s.a(bundle);
        }
    }

    public void B() {
        boolean z2;
        if ((this.f2078v & (-65536)) > 0 || (this.f2079w & (-4294967296L)) > 0) {
            h1.a.b(D, "ReqAuth Paramaters out of valid range");
            D(AntPlusGeocachePcc.b.FAIL_BAD_PARAMS);
            return;
        }
        j0.a c3 = this.f2073q.f1858n.c(this.f2077u);
        this.f2076t = c3;
        if (c3 == null) {
            D(AntPlusGeocachePcc.b.FAIL_DEVICE_NOT_IN_LIST);
            return;
        }
        try {
            z2 = this.f2073q.f1857m.u(this, 1000);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            z2 = false;
        }
        if (z2) {
            this.f2073q.k(300);
        } else {
            D(AntPlusGeocachePcc.b.FAIL_ALREADY_BUSY_EXTERNAL);
        }
    }

    public void D(AntPlusGeocachePcc.b bVar) {
        synchronized (this.f2074r) {
            if (this.C) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putInt("int_statusCode", bVar.b());
            if (bVar == AntPlusGeocachePcc.b.SUCCESS) {
                bundle.putLong("long_authToken", this.f2080x);
            }
            this.f2074r.a(bundle);
            this.C = true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x00f7  */
    @Override // u0.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void d() {
        /*
            Method dump skipped, instructions count: 292
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: k0.d.d():void");
    }

    @Override // u0.b
    public String k() {
        return "Requesting Auth Token from " + this.f2076t.f1957c.f708b;
    }

    @Override // u0.b
    public void o() {
        D(AntPlusGeocachePcc.b.FAIL_DEVICE_COMMUNICATION_FAILURE);
    }

    @Override // u0.b
    public void s() {
    }

    @Override // u0.b
    public void u(l lVar, AntMessageParcel antMessageParcel) {
        try {
            int i2 = a.f2084b[lVar.ordinal()];
            if (i2 == 1) {
                int i3 = a.f2083a[new g(antMessageParcel).j().ordinal()];
                if (i3 == 1) {
                    h1.a.b(D, "Timed out attempting to find device");
                    return;
                }
                if (i3 == 2) {
                    h1.a.b(D, "Channel closed.");
                    this.f2073q.f1858n.e(this.f2077u);
                    c();
                    this.A.countDown();
                    return;
                }
                if (i3 != 3) {
                    if (i3 != 4) {
                        return;
                    }
                    this.B = false;
                    return;
                } else {
                    C(1, 2);
                    this.B = true;
                    this.f2081y = 0;
                    return;
                }
            }
            if (i2 == 2 || i2 == 3) {
                if (this.B && w.c.i(antMessageParcel.a()[1]) == 32) {
                    this.f2080x = w.c.o(antMessageParcel.a(), 2);
                    c();
                    this.A.countDown();
                    return;
                }
                int i4 = this.f2081y + 1;
                this.f2081y = i4;
                if (i4 > 33) {
                    h1.a.b(D, "Did not receive message after 10 requests");
                    D(AntPlusGeocachePcc.b.FAIL_DEVICE_COMMUNICATION_FAILURE);
                    c();
                    this.A.countDown();
                    return;
                }
                if (this.B || i4 % 3 != 0) {
                    return;
                }
                this.f3396a.D(this.f2082z);
            }
        } catch (g.a e3) {
            if (e3.a() == g.b.TRANSFER_IN_PROGRESS) {
                h1.a.i(D, "TRANSFER_PROCESSING error sending ack msg");
                return;
            }
            h1.a.b(D, "ACFE handling message: " + e3.toString());
            D(AntPlusGeocachePcc.b.FAIL_DEVICE_COMMUNICATION_FAILURE);
            c();
            this.A.countDown();
        }
    }
}
