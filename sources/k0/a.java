package k0;

import com.dsi.ant.channel.AntChannel;
import com.dsi.ant.message.ipc.AntMessageParcel;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import k.g;
import k.l;
import v.e;

/* loaded from: classes.dex */
public class a extends u0.b {
    private static final String B = "a";

    /* renamed from: q */
    private final i0.a f2049q;

    /* renamed from: s */
    int f2051s;

    /* renamed from: u */
    boolean f2053u;

    /* renamed from: v */
    CountDownLatch f2054v;

    /* renamed from: w */
    int f2055w;

    /* renamed from: x */
    int f2056x;

    /* renamed from: y */
    j0.a f2057y;

    /* renamed from: z */
    boolean f2058z = false;
    byte[] A = null;

    /* renamed from: r */
    e.a f2050r = null;

    /* renamed from: t */
    boolean f2052t = false;

    /* renamed from: k0.a$a */
    /* loaded from: classes.dex */
    static /* synthetic */ class C0040a {

        /* renamed from: a */
        static final /* synthetic */ int[] f2059a;

        /* renamed from: b */
        static final /* synthetic */ int[] f2060b;

        static {
            int[] iArr = new int[l.values().length];
            f2060b = iArr;
            try {
                iArr[l.CHANNEL_EVENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2060b[l.BROADCAST_DATA.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2060b[l.ACKNOWLEDGED_DATA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[j.e.values().length];
            f2059a = iArr2;
            try {
                iArr2[j.e.RX_SEARCH_TIMEOUT.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f2059a[j.e.CHANNEL_CLOSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f2059a[j.e.TRANSFER_TX_COMPLETED.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f2059a[j.e.TRANSFER_TX_FAILED.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public a(i0.a aVar, j0.a aVar2, boolean z2) {
        this.f2049q = aVar;
        this.f2057y = aVar2;
        this.f2051s = aVar2.f1957c.f708b;
        this.f2053u = z2;
    }

    public void B(int i2, int i3) {
    }

    @Override // u0.b
    public void d() {
        this.f2055w = -1;
        try {
            h();
            this.f2054v = new CountDownLatch(1);
            try {
                AntChannel antChannel = this.f3396a;
                int i2 = this.f2051s;
                Objects.requireNonNull(this.f2049q);
                Objects.requireNonNull(this.f2049q);
                antChannel.u(new j.b(i2, 19, 0));
                f();
                this.f3396a.l();
                try {
                    this.f2054v.await();
                } catch (InterruptedException unused) {
                    h1.a.b(B, "Interrupted waiting for result");
                    Thread.currentThread().interrupt();
                }
            } catch (g.a e3) {
                h1.a.b(B, "ACFE initializing channel: " + e3.toString());
            }
        } catch (InterruptedException unused2) {
            this.f2057y = null;
        }
    }

    @Override // u0.b
    public String k() {
        return "Background Geocache Data Download " + this.f2051s;
    }

    @Override // u0.b
    public void o() {
        p(Integer.MAX_VALUE);
    }

    @Override // u0.b
    public boolean p(int i2) {
        h1.a.i(B, "Background download cancelling");
        c();
        return true;
    }

    @Override // u0.b
    public void s() {
    }

    @Override // u0.b
    public void u(l lVar, AntMessageParcel antMessageParcel) {
        CountDownLatch countDownLatch;
        try {
            int i2 = C0040a.f2060b[lVar.ordinal()];
            if (i2 == 1) {
                int i3 = C0040a.f2059a[new g(antMessageParcel).j().ordinal()];
                if (i3 == 1) {
                    h1.a.b(B, "Timed out attempting to find device");
                    return;
                }
                if (i3 == 2) {
                    h1.a.b(B, "Channel closed.");
                    this.f2057y = null;
                    this.f2049q.f1858n.e(this.f2051s);
                    c();
                    countDownLatch = this.f2054v;
                } else {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            return;
                        }
                        int i4 = this.f2056x;
                        this.f2056x = i4 + (2 - (i4 % 3));
                        return;
                    }
                    if (!this.f2058z) {
                        return;
                    }
                    h1.a.i(B, "Updated last visit count");
                    this.f2057y.j(this.A);
                    this.f2058z = false;
                    c();
                    countDownLatch = this.f2054v;
                }
                countDownLatch.countDown();
                return;
            }
            if (i2 == 2 || i2 == 3) {
                this.f2057y.a(antMessageParcel);
                int d3 = this.f2057y.d();
                if (d3 < 0) {
                    if (!this.f2053u || this.f2057y.h()) {
                        c();
                        this.f2054v.countDown();
                        return;
                    }
                    this.f2058z = true;
                    byte[] f3 = j0.c.f(this.f2057y.g(), this.f2057y.f1957c.f718l.f726h.intValue() + 1, System.currentTimeMillis() / 1000);
                    this.A = f3;
                    this.f3396a.D(f3);
                    B(this.f2057y.i() + 1, this.f2057y.f() + 1);
                    return;
                }
                int i5 = this.f2055w;
                if (i5 == -1 || i5 != d3) {
                    this.f2056x = -1;
                    this.f2055w = d3;
                    this.A = this.f2057y.b(d3);
                    B(this.f2057y.i(), this.f2057y.f() + 1);
                } else {
                    this.f2056x++;
                }
                int i6 = this.f2056x + 1;
                this.f2056x = i6;
                if (i6 <= 33) {
                    if (i6 % 3 == 0) {
                        this.f3396a.D(this.A);
                    }
                } else {
                    h1.a.a(B, "Did not receive message after 10 requests");
                    this.f2057y = null;
                    c();
                    this.f2054v.countDown();
                }
            }
        } catch (g.a e3) {
            if (e3.a() == g.b.TRANSFER_IN_PROGRESS) {
                h1.a.i(B, "TRANSFER_PROCESSING error sending ack msg");
                return;
            }
            h1.a.b(B, "ACFE handling message: " + e3.toString());
            this.f2057y = null;
            c();
            this.f2054v.countDown();
        }
    }
}
