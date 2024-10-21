package b1;

import android.os.RemoteException;
import com.dsi.ant.message.ipc.AntMessageParcel;
import j.e;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import k.l;
import s0.g;
import s0.i;

/* loaded from: classes.dex */
public class d extends i {
    private static final String A = "d";

    /* renamed from: s */
    private CountDownLatch f246s;

    /* renamed from: t */
    private boolean f247t;

    /* renamed from: u */
    private boolean f248u;

    /* renamed from: v */
    private boolean f249v;

    /* renamed from: w */
    private boolean f250w;

    /* renamed from: x */
    private int f251x;

    /* renamed from: y */
    private z0.a f252y;

    /* renamed from: z */
    private byte[] f253z;

    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a */
        static final /* synthetic */ int[] f254a;

        /* renamed from: b */
        static final /* synthetic */ int[] f255b;

        static {
            int[] iArr = new int[l.values().length];
            f255b = iArr;
            try {
                iArr[l.CHANNEL_EVENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f255b[l.BROADCAST_DATA.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f255b[l.ACKNOWLEDGED_DATA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[e.values().length];
            f254a = iArr2;
            try {
                iArr2[e.RX_SEARCH_TIMEOUT.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f254a[e.CHANNEL_CLOSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f254a[e.TRANSFER_TX_COMPLETED.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f254a[e.TRANSFER_TX_FAILED.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public d(z0.a aVar, g.m mVar) {
        super(mVar);
        this.f247t = false;
        this.f248u = false;
        this.f249v = false;
        this.f251x = -1;
        this.f253z = new byte[]{70, -1, -1, -1, -1, 0, 67, 2};
        this.f252y = aVar;
    }

    @Override // s0.i
    public boolean C(g.k kVar) {
        return kVar == g.k.NOT_CONNECTED;
    }

    @Override // u0.b
    public void d() {
        g.l lVar;
        try {
            try {
                if (this.f3396a.p().l() != j.c.TRACKING) {
                    h1.a.b(A, "Failed: Channel not tracking");
                    D(g.l.FAIL_OTHER_DEVICE_COMMUNICATION_ERROR);
                    return;
                }
                this.f246s = new CountDownLatch(1);
                f();
                this.f246s.await(60L, TimeUnit.SECONDS);
                if (!this.f248u) {
                    if (this.f249v) {
                        h1.a.a(A, "Device is already in ANT-FS mode");
                        D(g.l.SUCCESS);
                        return;
                    } else {
                        h1.a.b(A, "Timed out waiting for capabilities");
                        D(g.l.FAIL_OTHER_DEVICE_COMMUNICATION_ERROR);
                        return;
                    }
                }
                if (!this.f250w || this.f247t) {
                    h1.a.b(A, "Device does not support ANT-FS");
                    D(g.l.FAIL_NOT_SUPPORTED);
                    return;
                }
                try {
                    this.f3396a.D(this.f253z);
                } catch (g.a e3) {
                    if (e3.a() != g.b.TRANSFER_IN_PROGRESS) {
                        h1.a.b(A, "Failed to send ANT-FS session request: " + e3.toString());
                        D(g.l.FAIL_OTHER_DEVICE_COMMUNICATION_ERROR);
                        return;
                    }
                    h1.a.i(A, "Failed to send ANT-FS session request: TRANSFER_IN_PROGRESS error sending ack msg");
                }
                this.f246s = new CountDownLatch(1);
                f();
                this.f246s.await(15L, TimeUnit.SECONDS);
                c();
                if (this.f249v) {
                    h1.a.a(A, "Successfully entered ANT-FS mode");
                    lVar = g.l.SUCCESS;
                } else {
                    h1.a.a(A, "Timed out waiting for link beacon");
                    lVar = g.l.FAIL_OTHER_DEVICE_COMMUNICATION_ERROR;
                }
                D(lVar);
            } catch (InterruptedException unused) {
                h1.a.b(A, "Interrupted waiting for result");
                D(g.l.FAIL_EXECUTOR_CANCELLED_TASK);
                Thread.currentThread().interrupt();
            }
        } catch (g.a e4) {
            h1.a.b(A, "ACFE occurred: " + e4.toString());
            throw new RemoteException();
        }
    }

    @Override // u0.b
    public String k() {
        return "ANT-FS Session Request";
    }

    @Override // u0.b
    public void u(l lVar, AntMessageParcel antMessageParcel) {
        int i2;
        int i3 = a.f255b[lVar.ordinal()];
        if (i3 == 1) {
            int i4 = a.f254a[new k.g(antMessageParcel).j().ordinal()];
            if (i4 == 1) {
                h1.a.b(A, "Search timeout occured");
                return;
            }
            if (i4 == 2) {
                h1.a.b(A, "Channel closed");
                c();
                this.f246s.countDown();
                return;
            }
            if (i4 == 3) {
                this.f247t = true;
                i2 = 0;
            } else {
                if (i4 != 4) {
                    return;
                }
                int i5 = this.f251x;
                i2 = i5 + (2 - (i5 % 3));
            }
            this.f251x = i2;
            return;
        }
        if (i3 == 2 || i3 == 3) {
            if (!this.f248u) {
                int i6 = w.c.i(antMessageParcel.a()[1]);
                if (i6 == 1) {
                    h1.a.a(A, "Received weight page");
                    z0.a aVar = this.f252y;
                    aVar.f3616w.b(aVar.p(), this.f252y.q(), antMessageParcel);
                    this.f250w = this.f252y.f3616w.h();
                    this.f248u = true;
                } else {
                    if (i6 != 67) {
                        return;
                    }
                    h1.a.a(A, "Received beacon");
                    this.f249v = true;
                }
                c();
                this.f246s.countDown();
                return;
            }
            if (this.f247t) {
                if (this.f249v) {
                    return;
                }
                if (w.c.i(antMessageParcel.a()[1]) == 67) {
                    this.f249v = true;
                    c();
                    this.f246s.countDown();
                }
                int i7 = this.f251x + 1;
                this.f251x = i7;
                if (i7 < 4) {
                    this.f3396a.s(this.f253z);
                    return;
                }
                return;
            }
            int i8 = this.f251x + 1;
            this.f251x = i8;
            if (i8 > 10) {
                h1.a.b(A, "Tx retries exceeded sending ANT-FS Session request");
            } else {
                if (i8 % 3 != 0) {
                    return;
                }
                try {
                    this.f3396a.D(this.f253z);
                    return;
                } catch (g.a e3) {
                    if (e3.a() == g.b.TRANSFER_IN_PROGRESS) {
                        h1.a.i(A, "TRANSFER_PROCESSING error sending ack msg");
                        return;
                    }
                    h1.a.b(A, "ACFE handling message: " + e3.toString());
                }
            }
            c();
            this.f246s.countDown();
        }
    }
}
