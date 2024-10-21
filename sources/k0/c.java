package k0;

import android.os.Bundle;
import com.dsi.ant.message.ipc.AntMessageParcel;
import com.dsi.ant.plugins.antplus.pcc.AntPlusGeocachePcc;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.CountDownLatch;
import k.g;
import k.l;
import v.e;

/* loaded from: classes.dex */
public class c extends u0.b {
    private static final String G = "c";
    private byte[] A;
    private CountDownLatch B;
    private boolean C;
    private int D;
    private int E;
    private boolean F;

    /* renamed from: q */
    private final i0.a f2061q;

    /* renamed from: r */
    private j0.a f2062r;

    /* renamed from: s */
    private final u.a f2063s;

    /* renamed from: t */
    private u.a f2064t;

    /* renamed from: u */
    private int f2065u;

    /* renamed from: v */
    private long f2066v;

    /* renamed from: w */
    private boolean f2067w;

    /* renamed from: x */
    private AntPlusGeocachePcc.ProgrammableGeocacheDeviceData f2068x;

    /* renamed from: y */
    private Queue f2069y;

    /* renamed from: z */
    private int f2070z;

    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a */
        static final /* synthetic */ int[] f2071a;

        /* renamed from: b */
        static final /* synthetic */ int[] f2072b;

        static {
            int[] iArr = new int[l.values().length];
            f2072b = iArr;
            try {
                iArr[l.CHANNEL_EVENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2072b[l.BROADCAST_DATA.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2072b[l.ACKNOWLEDGED_DATA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[j.e.values().length];
            f2071a = iArr2;
            try {
                iArr2[j.e.RX_SEARCH_TIMEOUT.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f2071a[j.e.CHANNEL_CLOSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f2071a[j.e.TRANSFER_TX_COMPLETED.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f2071a[j.e.TRANSFER_TX_FAILED.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public c(i0.a aVar, e.a aVar2, int i2, long j2, boolean z2, AntPlusGeocachePcc.ProgrammableGeocacheDeviceData programmableGeocacheDeviceData, boolean z3) {
        u.a aVar3 = new u.a(203);
        this.f2063s = aVar3;
        this.f2064t = new u.a(202);
        this.f2070z = -1;
        this.A = null;
        this.C = false;
        this.D = 0;
        this.F = false;
        this.f2061q = aVar;
        this.f2065u = i2;
        this.f2066v = j2;
        this.f2067w = z2;
        this.f2068x = programmableGeocacheDeviceData;
        aVar3.c(aVar2.f3454c, aVar2.f3455d);
        if (z3) {
            this.f2064t.c(aVar2.f3454c, aVar2.f3455d);
        }
    }

    private void C(int i2, int i3) {
        if (this.f2064t.b()) {
            Bundle bundle = new Bundle();
            bundle.putInt("int_workUnitsFinished", i2);
            bundle.putInt("int_totalUnitsWork", i3);
            this.f2064t.a(bundle);
        }
    }

    public void B() {
        boolean z2;
        j0.a c3 = this.f2061q.f1858n.c(this.f2065u);
        this.f2062r = c3;
        if (c3 == null) {
            D(AntPlusGeocachePcc.b.FAIL_DEVICE_NOT_IN_LIST);
            return;
        }
        int d3 = c3.d();
        if (d3 >= 0 && (d3 < 2 || !this.f2067w)) {
            D(AntPlusGeocachePcc.b.FAIL_DEVICE_DATA_NOT_DOWNLOADED);
            return;
        }
        if (this.f2066v != this.f2062r.f1957c.f718l.f721c.longValue() && this.f2062r.f1957c.f718l.f721c.longValue() != 4294967295L) {
            D(AntPlusGeocachePcc.b.FAIL_NO_PERMISSION);
            return;
        }
        if (!this.f2067w) {
            AntPlusGeocachePcc.ProgrammableGeocacheDeviceData programmableGeocacheDeviceData = this.f2068x;
            if (programmableGeocacheDeviceData.f720b == null) {
                programmableGeocacheDeviceData.f720b = this.f2062r.f1957c.f718l.f720b;
            }
            if (programmableGeocacheDeviceData.f721c == null) {
                programmableGeocacheDeviceData.f721c = this.f2062r.f1957c.f718l.f721c;
            }
            if (programmableGeocacheDeviceData.f722d == null) {
                programmableGeocacheDeviceData.f722d = this.f2062r.f1957c.f718l.f722d;
            }
            if (programmableGeocacheDeviceData.f723e == null) {
                programmableGeocacheDeviceData.f723e = this.f2062r.f1957c.f718l.f723e;
            }
            if (programmableGeocacheDeviceData.f724f == null) {
                programmableGeocacheDeviceData.f724f = this.f2062r.f1957c.f718l.f724f;
            }
            if (programmableGeocacheDeviceData.f726h == null) {
                programmableGeocacheDeviceData.f726h = this.f2062r.f1957c.f718l.f726h;
            }
            if (programmableGeocacheDeviceData.f725g == null) {
                programmableGeocacheDeviceData.f725g = this.f2062r.f1957c.f718l.f725g;
            }
        }
        try {
            LinkedList linkedList = new LinkedList(j0.c.h(this.f2068x, true));
            this.f2069y = linkedList;
            if (linkedList.size() > 32) {
                throw new IllegalArgumentException("Too many programmable pages, probably hint string too long");
            }
            this.E = this.f2069y.size();
            try {
                z2 = this.f2061q.f1857m.u(this, 1000);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                z2 = false;
            }
            if (z2) {
                this.f2061q.k(300);
            } else {
                D(AntPlusGeocachePcc.b.FAIL_ALREADY_BUSY_EXTERNAL);
            }
        } catch (IllegalArgumentException e3) {
            h1.a.b(G, e3.toString());
            D(AntPlusGeocachePcc.b.FAIL_BAD_PARAMS);
        } catch (NullPointerException e4) {
            h1.a.b(G, e4.toString());
            D(AntPlusGeocachePcc.b.FAIL_BAD_PARAMS);
        }
    }

    public void D(AntPlusGeocachePcc.b bVar) {
        synchronized (this.f2063s) {
            if (this.F) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putInt("int_statusCode", bVar.b());
            this.f2063s.a(bundle);
            this.F = true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x00db  */
    @Override // u0.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void d() {
        /*
            Method dump skipped, instructions count: 273
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: k0.c.d():void");
    }

    @Override // u0.b
    public String k() {
        return "Programming Device " + this.f2065u;
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
        CountDownLatch countDownLatch;
        try {
            int i2 = a.f2072b[lVar.ordinal()];
            if (i2 != 1) {
                if (i2 == 2 || i2 == 3) {
                    int i3 = this.f2070z + 1;
                    this.f2070z = i3;
                    if (i3 <= 33) {
                        if (i3 % 3 == 0) {
                            this.f3396a.D(this.A);
                            return;
                        }
                        return;
                    } else {
                        h1.a.b(G, "Did not receive message after 10 requests");
                        D(AntPlusGeocachePcc.b.FAIL_DEVICE_COMMUNICATION_FAILURE);
                        c();
                        this.B.countDown();
                        return;
                    }
                }
                return;
            }
            int i4 = a.f2071a[new g(antMessageParcel).j().ordinal()];
            if (i4 == 1) {
                h1.a.b(G, "Timed out attempting to find device");
                return;
            }
            if (i4 == 2) {
                h1.a.b(G, "Channel closed");
                c();
                countDownLatch = this.B;
            } else {
                if (i4 != 3) {
                    if (i4 != 4) {
                        return;
                    }
                    int i5 = this.f2070z;
                    this.f2070z = i5 + (2 - (i5 % 3));
                    return;
                }
                if (this.f2069y.size() > 0) {
                    int i6 = this.D + 1;
                    this.D = i6;
                    C(i6, this.E);
                    byte[] bArr = (byte[]) this.f2069y.remove();
                    this.A = bArr;
                    this.f2070z = 0;
                    this.f3396a.D(bArr);
                    return;
                }
                this.f2062r.f1957c.f718l = this.f2068x;
                this.f2061q.f1858n.f(this.f2065u);
                this.C = true;
                c();
                countDownLatch = this.B;
            }
            countDownLatch.countDown();
        } catch (g.a e3) {
            if (e3.a() == g.b.TRANSFER_IN_PROGRESS) {
                h1.a.i(G, "TRANSFER_PROCESSING error sending ack msg");
                return;
            }
            h1.a.b(G, "ACFE handling message: " + e3.toString());
            D(AntPlusGeocachePcc.b.FAIL_DEVICE_COMMUNICATION_FAILURE);
            c();
            this.B.countDown();
        }
    }
}
