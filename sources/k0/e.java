package k0;

import android.os.RemoteException;
import com.dsi.ant.channel.AntChannel;
import com.dsi.ant.message.ipc.AntMessageParcel;
import java.util.Iterator;
import java.util.Objects;
import k.g;
import k.l;

/* loaded from: classes.dex */
public class e extends u0.b {

    /* renamed from: w */
    private static final String f2085w = "e";

    /* renamed from: q */
    private final i0.a f2086q;

    /* renamed from: r */
    boolean f2087r = false;

    /* renamed from: s */
    j0.a f2088s = null;

    /* renamed from: t */
    int f2089t = 0;

    /* renamed from: u */
    int f2090u;

    /* renamed from: v */
    int f2091v;

    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a */
        static final /* synthetic */ int[] f2092a;

        /* renamed from: b */
        static final /* synthetic */ int[] f2093b;

        static {
            int[] iArr = new int[l.values().length];
            f2093b = iArr;
            try {
                iArr[l.CHANNEL_EVENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2093b[l.BROADCAST_DATA.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2093b[l.ACKNOWLEDGED_DATA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[j.e.values().length];
            f2092a = iArr2;
            try {
                iArr2[j.e.RX_SEARCH_TIMEOUT.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f2092a[j.e.CHANNEL_CLOSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f2092a[j.e.TRANSFER_TX_FAILED.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public e(i0.a aVar) {
        this.f2086q = aVar;
    }

    private void B(int i2) {
        int i3 = this.f2090u + 1;
        this.f2090u = i3;
        if (i3 > 3) {
            this.f2090u = 0;
        }
        AntChannel antChannel = this.f3396a;
        Objects.requireNonNull(this.f2086q);
        Objects.requireNonNull(this.f2086q);
        antChannel.b(new j.b(i2, 19, 0), this.f2090u);
        int i4 = this.f2091v;
        if (i4 < 4) {
            int i5 = i4 + 1;
            this.f2091v = i5;
            this.f3396a.i(i5, true);
        }
        h1.a.i(f2085w, "IE list using " + this.f2091v + " devices");
    }

    private void C() {
        try {
            if (this.f2091v > 0) {
                this.f3396a.i(0, true);
            }
        } catch (g.a e3) {
            h1.a.b(f2085w, "ACFE trying to clear IE list: " + e3.toString());
            throw new RemoteException();
        }
    }

    private void D() {
        int i2;
        this.f2090u = -1;
        this.f2091v = 0;
        int[] iArr = {-1, -1, -1, -1};
        long j2 = -1;
        int i3 = -1;
        for (int i4 = -2; i3 < 3 && i4 != -1; i4 = i2) {
            Iterator it = this.f2086q.f1858n.f1965c.iterator();
            long j3 = 20000;
            i2 = -1;
            while (it.hasNext()) {
                j0.a aVar = (j0.a) it.next();
                long e3 = aVar.e();
                if (e3 > j2 && e3 < j3) {
                    i2 = aVar.f1957c.f708b;
                    j3 = e3;
                }
            }
            if (i2 >= 0) {
                i3++;
                iArr[i3] = i2;
                j2 = j3;
            }
            if (this.f2087r) {
                return;
            }
        }
        while (i3 >= 0) {
            this.f2090u++;
            AntChannel antChannel = this.f3396a;
            int i5 = iArr[i3];
            Objects.requireNonNull(this.f2086q);
            Objects.requireNonNull(this.f2086q);
            antChannel.b(new j.b(i5, 19, 0), this.f2090u);
            if (this.f2087r) {
                return;
            } else {
                i3--;
            }
        }
        int i6 = this.f2090u + 1;
        this.f2091v = i6;
        this.f3396a.i(i6, true);
    }

    @Override // u0.b
    public void d() {
        this.f2086q.k(2);
        try {
            h();
            if (this.f2087r) {
                return;
            }
            try {
                D();
                if (this.f2087r) {
                    C();
                    return;
                }
                AntChannel antChannel = this.f3396a;
                Objects.requireNonNull(this.f2086q);
                Objects.requireNonNull(this.f2086q);
                antChannel.u(new j.b(0, 19, 0));
                f();
                this.f3396a.l();
                Thread.sleep(10000L);
                if (this.f2087r) {
                    C();
                    return;
                }
                c();
                h();
                if (this.f2087r) {
                    C();
                    return;
                }
                Iterator it = this.f2086q.f1858n.f1965c.iterator();
                boolean z2 = true;
                j0.a aVar = null;
                e eVar = this;
                while (it.hasNext()) {
                    j0.a aVar2 = (j0.a) it.next();
                    if (aVar2.e() > 30000) {
                        u0.b aVar3 = new k0.a(this.f2086q, aVar2, false);
                        eVar.z(aVar3);
                        if (aVar2.d() >= 0) {
                            z2 = false;
                        }
                        eVar = aVar3;
                    } else if (aVar == null && aVar2.d() >= 0) {
                        aVar = aVar2;
                    }
                }
                if (z2 && aVar != null) {
                    eVar.z(new k0.a(this.f2086q, aVar, false));
                }
                C();
            } catch (g.a e3) {
                h1.a.b(f2085w, "ACFE initializing channel: " + e3.toString());
                C();
            }
        } catch (InterruptedException unused) {
            C();
            Thread.currentThread().interrupt();
        }
    }

    @Override // u0.b
    public String k() {
        return "Geocache Device Scan";
    }

    @Override // u0.b
    public void o() {
        p(Integer.MAX_VALUE);
    }

    @Override // u0.b
    public boolean p(int i2) {
        h1.a.i(f2085w, "Background scan cancelling");
        this.f2087r = true;
        c();
        return true;
    }

    @Override // u0.b
    public void s() {
        this.f2088s = null;
        this.f2087r = false;
        z(null);
    }

    @Override // u0.b
    public void u(l lVar, AntMessageParcel antMessageParcel) {
        AntChannel antChannel;
        AntChannel antChannel2;
        try {
            int i2 = a.f2093b[lVar.ordinal()];
            if (i2 == 1) {
                int i3 = a.f2092a[new g(antMessageParcel).j().ordinal()];
                if (i3 == 1) {
                    this.f2088s = null;
                    AntChannel antChannel3 = this.f3396a;
                    Objects.requireNonNull(this.f2086q);
                    Objects.requireNonNull(this.f2086q);
                    antChannel3.u(new j.b(0, 19, 0));
                    antChannel = this.f3396a;
                } else {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            return;
                        }
                        int i4 = this.f2089t;
                        this.f2089t = i4 + (2 - (i4 % 3));
                        return;
                    }
                    if (this.f2088s == null) {
                        return;
                    }
                    this.f2088s = null;
                    AntChannel antChannel4 = this.f3396a;
                    Objects.requireNonNull(this.f2086q);
                    Objects.requireNonNull(this.f2086q);
                    antChannel4.u(new j.b(0, 19, 0));
                    antChannel = this.f3396a;
                }
                antChannel.l();
                return;
            }
            if (i2 == 2 || i2 == 3) {
                if (this.f2088s == null) {
                    int a3 = this.f3396a.o().j().a();
                    j0.a c3 = this.f2086q.f1858n.c(a3);
                    this.f2088s = c3;
                    if (c3 != null) {
                        c3.a(antMessageParcel);
                        B(this.f2088s.f1957c.f708b);
                        this.f3396a.h();
                        return;
                    }
                    this.f2088s = new j0.a(a3);
                    this.f2089t = -1;
                }
                this.f2088s.a(antMessageParcel);
                j0.a aVar = this.f2088s;
                if (aVar.f1957c.f718l.f720b == null) {
                    int i5 = this.f2089t + 1;
                    this.f2089t = i5;
                    if (i5 <= 10) {
                        if (i5 % 3 != 0) {
                            this.f3396a.D(aVar.b(aVar.d()));
                            return;
                        }
                        return;
                    }
                    antChannel2 = this.f3396a;
                } else {
                    this.f2086q.f1858n.a(aVar);
                    B(this.f2088s.f1957c.f708b);
                    antChannel2 = this.f3396a;
                }
                antChannel2.h();
            }
        } catch (g.a e3) {
            if (e3.a() == g.b.TRANSFER_IN_PROGRESS) {
                h1.a.i(f2085w, "TRANSFER_PROCESSING error sending ack msg");
                return;
            }
            h1.a.b(f2085w, "ACFE handling message: " + e3.toString());
        }
    }
}
