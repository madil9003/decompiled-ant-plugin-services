package b1;

import a1.e;
import android.os.Bundle;
import android.os.RemoteException;
import com.dsi.ant.message.ipc.AntMessageParcel;
import com.dsi.ant.plugins.antplus.pcc.AntPlusWeightScalePcc;
import java.math.BigDecimal;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import k.g;
import k.l;
import v.e;

/* loaded from: classes.dex */
public class b extends u0.b {
    private static final String D = "b";

    /* renamed from: q */
    z0.a f222q;

    /* renamed from: r */
    CountDownLatch f223r;

    /* renamed from: s */
    BigDecimal f224s;

    /* renamed from: u */
    boolean f226u;

    /* renamed from: t */
    u.a f225t = new u.a(201);

    /* renamed from: v */
    e f227v = new e();

    /* renamed from: w */
    private boolean f228w = false;

    /* renamed from: x */
    private boolean f229x = false;

    /* renamed from: y */
    private boolean f230y = false;

    /* renamed from: z */
    boolean f231z = false;
    boolean A = false;
    private int B = 1;
    private byte[] C = {58, -1, -1, Byte.MIN_VALUE, -1, 0, 0, 0};

    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a */
        static final /* synthetic */ int[] f232a;

        /* renamed from: b */
        static final /* synthetic */ int[] f233b;

        static {
            int[] iArr = new int[l.values().length];
            f233b = iArr;
            try {
                iArr[l.CHANNEL_EVENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f233b[l.BROADCAST_DATA.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f233b[l.ACKNOWLEDGED_DATA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[j.e.values().length];
            f232a = iArr2;
            try {
                iArr2[j.e.RX_SEARCH_TIMEOUT.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f232a[j.e.CHANNEL_CLOSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f232a[j.e.TRANSFER_TX_COMPLETED.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f232a[j.e.TRANSFER_TX_FAILED.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public b(z0.a aVar, e.a aVar2) {
        this.f222q = aVar;
        this.f225t.c(aVar2.f3454c, aVar2.f3455d);
    }

    public void B() {
        boolean z2;
        try {
            z2 = this.f222q.f3444n.u(this, 1000);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            z2 = false;
        }
        if (z2) {
            this.f222q.k(300);
        } else {
            C(AntPlusWeightScalePcc.d.FAIL_ALREADY_BUSY_EXTERNAL);
        }
    }

    public void C(AntPlusWeightScalePcc.d dVar) {
        synchronized (this.f225t) {
            if (this.f228w) {
                return;
            }
            int b3 = dVar.b();
            Bundle bundle = new Bundle();
            bundle.putInt("int_statusCode", b3);
            if (dVar == AntPlusWeightScalePcc.d.SUCCESS) {
                bundle.putSerializable("decimal_bodyWeight", this.f224s);
            }
            this.f225t.a(bundle);
            this.f228w = true;
        }
    }

    @Override // u0.b
    public void d() {
        try {
            if (this.f3396a.p().l() != j.c.TRACKING) {
                h1.a.b(D, "Failed: Channel not tracking");
                C(AntPlusWeightScalePcc.d.FAIL_DEVICE_COMMUNICATION_FAILURE);
                return;
            }
            this.f224s = null;
            this.f222q.f3616w.l();
            this.f223r = new CountDownLatch(1);
            f();
            try {
                this.f223r.await(60L, TimeUnit.SECONDS);
            } catch (InterruptedException unused) {
                h1.a.b(D, "Interrupted waiting for result");
                Thread.currentThread().interrupt();
            }
            if (!this.A) {
                h1.a.b(D, "Timed out receiving capabilities");
                C(AntPlusWeightScalePcc.d.FAIL_DEVICE_COMMUNICATION_FAILURE);
                return;
            }
            this.f223r = new CountDownLatch(1);
            if (this.f231z) {
                this.f3396a.D(this.C);
            } else {
                this.f226u = true;
            }
            try {
                this.f223r.await(60L, TimeUnit.SECONDS);
            } catch (InterruptedException unused2) {
                h1.a.b(D, "Interrupted waiting for result");
                Thread.currentThread().interrupt();
            }
            C(this.f224s != null ? AntPlusWeightScalePcc.d.SUCCESS : this.f229x ? AntPlusWeightScalePcc.d.FAIL_WEIGHT_VALUE_NOT_STABILIZED : AntPlusWeightScalePcc.d.FAIL_DEVICE_COMMUNICATION_FAILURE);
            if (this.f224s != null) {
                this.f223r = new CountDownLatch(1);
                this.f230y = true;
                f();
                try {
                    this.f223r.await(60L, TimeUnit.SECONDS);
                } catch (InterruptedException unused3) {
                    h1.a.b(D, "Interrupted waiting for result");
                    Thread.currentThread().interrupt();
                }
            }
        } catch (g.a e3) {
            h1.a.b(D, "AntCommandFailedException in dowork(): " + e3.toString());
            C(AntPlusWeightScalePcc.d.FAIL_DEVICE_COMMUNICATION_FAILURE);
            throw new RemoteException();
        }
    }

    @Override // u0.b
    public String k() {
        return "Basic Measurement Request";
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
        try {
            int i2 = a.f233b[lVar.ordinal()];
            if (i2 == 1) {
                int i3 = a.f232a[new g(antMessageParcel).j().ordinal()];
                if (i3 == 1) {
                    h1.a.b(D, "Search timeout occured");
                    return;
                }
                if (i3 == 2) {
                    h1.a.b(D, "Channel closed");
                    c();
                    this.f223r.countDown();
                    return;
                } else if (i3 == 3) {
                    this.f226u = true;
                    this.f3396a.s(this.C);
                    this.B = 0;
                    return;
                } else {
                    if (i3 != 4) {
                        return;
                    }
                    int i4 = this.B;
                    this.B = i4 + (2 - (i4 % 3));
                    return;
                }
            }
            if (i2 == 2 || i2 == 3) {
                int i5 = w.c.i(antMessageParcel.a()[1]);
                if (!this.A) {
                    if (i5 == 1) {
                        z0.a aVar = this.f222q;
                        aVar.f3616w.b(aVar.p(), this.f222q.q(), antMessageParcel);
                        this.f231z = this.f222q.f3616w.i();
                        this.A = true;
                        this.f223r.countDown();
                        return;
                    }
                    return;
                }
                if (!this.f226u && this.f231z) {
                    int i6 = this.B + 1;
                    this.B = i6;
                    if (i6 > 30) {
                        h1.a.b(D, "Tx retries exceeded sending user profile");
                        c();
                        this.f223r.countDown();
                        return;
                    } else if (i6 % 3 == 0) {
                        this.f3396a.D(this.C);
                    }
                }
                if (this.f230y) {
                    if (i5 != 1) {
                        if (i5 == 67 && antMessageParcel.a()[3] == 0) {
                            h1.a.a(D, "Weight scale measurement complete.  Now beaconing");
                            c();
                            this.f223r.countDown();
                            return;
                        }
                        return;
                    }
                    z0.a aVar2 = this.f222q;
                    aVar2.f3616w.b(aVar2.p(), this.f222q.q(), antMessageParcel);
                    if (this.f222q.f3616w.f() == null || this.f222q.f3616w.g().compareTo(new BigDecimal(0)) == -1) {
                        h1.a.a(D, "Weight scale measurement complete. Now computing");
                        c();
                        this.f223r.countDown();
                        return;
                    }
                    return;
                }
                if (i5 == 1) {
                    this.f229x = true;
                    z0.a aVar3 = this.f222q;
                    aVar3.f3616w.b(aVar3.p(), this.f222q.q(), antMessageParcel);
                    if (this.f222q.f3616w.f() != null && this.f222q.f3616w.g() != a1.a.f66m) {
                        this.f229x = false;
                        this.f224s = this.f222q.f3616w.f();
                        c();
                        this.f223r.countDown();
                        return;
                    }
                }
                if (this.f231z) {
                    int i7 = this.B + 1;
                    this.B = i7;
                    if (i7 < 5) {
                        this.f3396a.s(this.C);
                    }
                }
            }
        } catch (g.a e3) {
            if (e3.a() == g.b.TRANSFER_IN_PROGRESS) {
                h1.a.i(D, "TRANSFER_PROCESSING error sending ack msg");
                return;
            }
            h1.a.b(D, "ACFE handling message: " + e3.toString());
            C(AntPlusWeightScalePcc.d.FAIL_DEVICE_COMMUNICATION_FAILURE);
            c();
            this.f223r.countDown();
        }
    }
}
