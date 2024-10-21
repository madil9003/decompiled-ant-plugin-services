package s0;

import android.os.RemoteException;
import com.dsi.ant.message.ipc.AntMessageParcel;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import s0.g;

/* loaded from: classes.dex */
public class h extends i {
    private static final String H = "h";
    static final byte[] I = {68, 5, 0, 0, 0, 0, 0, 0};
    private CountDownLatch A;
    private ByteArrayOutputStream B;
    private boolean C;
    private boolean D;
    private int E;
    private int F;
    private int G;

    /* renamed from: s */
    private g.k f3238s;

    /* renamed from: t */
    private byte[] f3239t;

    /* renamed from: u */
    private byte[] f3240u;

    /* renamed from: v */
    private long f3241v;

    /* renamed from: w */
    private byte f3242w;

    /* renamed from: x */
    private int f3243x;

    /* renamed from: y */
    private l f3244y;

    /* renamed from: z */
    private int f3245z;

    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a */
        static final /* synthetic */ int[] f3246a;

        /* renamed from: b */
        static final /* synthetic */ int[] f3247b;

        static {
            int[] iArr = new int[k.l.values().length];
            f3247b = iArr;
            try {
                iArr[k.l.CHANNEL_EVENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3247b[k.l.BROADCAST_DATA.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3247b[k.l.BURST_TRANSFER_DATA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[j.e.values().length];
            f3246a = iArr2;
            try {
                iArr2[j.e.RX_SEARCH_TIMEOUT.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3246a[j.e.CHANNEL_CLOSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3246a[j.e.TRANSFER_TX_COMPLETED.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3246a[j.e.TRANSFER_TX_FAILED.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f3246a[j.e.TRANSFER_RX_FAILED.ordinal()] = 5;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public h(g.m mVar, int i2, long j2, byte b3) {
        super(mVar);
        this.f3238s = g.k.TRANSPORT_IDLE;
        this.f3244y = new l();
        this.f3245z = -1;
        this.B = new ByteArrayOutputStream();
        this.C = false;
        this.D = false;
        this.E = 0;
        this.F = 0;
        this.G = 0;
        this.f3241v = j2;
        this.f3242w = b3;
        this.f3243x = i2;
    }

    private boolean E() {
        byte[] bArr = this.f3240u;
        this.f3240u = null;
        return bArr.length >= 16 && w.c.i(bArr[10]) == 0;
    }

    @Override // s0.i
    public boolean C(g.k kVar) {
        return kVar == g.k.TRANSPORT_IDLE;
    }

    @Override // u0.b
    public void d() {
        for (int i2 = 0; i2 < 5; i2++) {
            try {
                try {
                    j.c l2 = this.f3396a.p().l();
                    if (l2 != j.c.TRACKING && l2 != j.c.SEARCHING) {
                        h1.a.b(H, "Failed: Connection lost");
                        g.k kVar = g.k.NOT_CONNECTED;
                        this.f3238s = kVar;
                        this.f3249r.a(kVar, g.j.CONNECTION_LOST);
                        D(g.l.FAIL_DEVICE_TRANSMISSION_LOST);
                        return;
                    }
                    String str = H;
                    h1.a.a(str, "Wait for transport beacon");
                    this.f3245z = -1;
                    this.A = new CountDownLatch(1);
                    f();
                    this.A.await(10L, TimeUnit.SECONDS);
                    if (this.f3245z != 2) {
                        h1.a.b(str, "Timed out waiting for transport beacon");
                    } else {
                        byte[] bArr = {68, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                        this.f3239t = bArr;
                        w.c.d(bArr, 2, 65534);
                        w.c.e(this.f3239t, 4, 16L);
                        this.C = false;
                        this.E = 0;
                        this.D = true;
                        this.A = new CountDownLatch(1);
                        f();
                        try {
                            this.f3396a.e(this.f3239t);
                        } catch (g.a e3) {
                            h1.a.a(H, "Exception sending burst: " + e3.a());
                        }
                        this.A.await();
                        if (this.C) {
                            if (this.f3240u == null) {
                                h1.a.a(H, "Wait for upload response");
                                this.F = 0;
                                this.G = 0;
                                this.B.reset();
                                this.A = new CountDownLatch(1);
                                f();
                                this.A.await();
                            }
                            if (this.f3240u != null) {
                                if (!E()) {
                                    D(g.l.FAIL_OTHER_DEVICE_COMMUNICATION_ERROR);
                                    return;
                                }
                                byte[] bArr2 = {68, 12, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, Byte.MIN_VALUE, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                                this.f3239t = bArr2;
                                w.c.b(bArr2, 11, this.f3243x);
                                w.c.e(this.f3239t, 12, this.f3241v);
                                byte[] bArr3 = this.f3239t;
                                bArr3[21] = this.f3242w;
                                this.f3244y.update(bArr3, 8, 16);
                                w.c.d(this.f3239t, 30, (int) (this.f3244y.getValue() & 65535));
                                this.C = false;
                                this.E = 0;
                                this.D = true;
                                this.A = new CountDownLatch(1);
                                f();
                                try {
                                    this.f3396a.e(this.f3239t);
                                } catch (g.a e4) {
                                    h1.a.a(H, "Exception sending burst: " + e4.a());
                                }
                                this.A.await();
                                if (this.C) {
                                    if (this.f3240u == null) {
                                        h1.a.a(H, "Wait for upload response");
                                        this.F = 0;
                                        this.G = 0;
                                        this.B.reset();
                                        this.A = new CountDownLatch(1);
                                        f();
                                        this.A.await();
                                    }
                                    if (this.f3240u != null) {
                                        if (E()) {
                                            D(g.l.SUCCESS);
                                            return;
                                        } else {
                                            D(g.l.FAIL_OTHER_DEVICE_COMMUNICATION_ERROR);
                                            return;
                                        }
                                    }
                                }
                            }
                        }
                        h1.a.b(H, "Failed: Tx retries exceeded");
                    }
                } catch (g.a e5) {
                    h1.a.b(H, "ACFE occurred requesting status: " + e5.toString());
                    this.f3238s = g.k.NOT_CONNECTED;
                    this.f3396a.m();
                    throw new RemoteException();
                }
            } catch (InterruptedException unused) {
                h1.a.b(H, "Interrupted waiting for result");
                D(g.l.FAIL_EXECUTOR_CANCELLED_TASK);
                Thread.currentThread().interrupt();
                return;
            }
        }
        D(g.l.FAIL_OTHER_DEVICE_COMMUNICATION_ERROR);
    }

    @Override // u0.b
    public String k() {
        return "ANT-FS Host Set Time Channel Task";
    }

    @Override // u0.b
    public void u(k.l lVar, AntMessageParcel antMessageParcel) {
        String str;
        String str2;
        CountDownLatch countDownLatch;
        try {
            int i2 = a.f3247b[lVar.ordinal()];
            if (i2 == 1) {
                int i3 = a.f3246a[new k.g(antMessageParcel).j().ordinal()];
                if (i3 == 1) {
                    h1.a.b(H, "Search timeout occured");
                    return;
                }
                if (i3 == 2) {
                    h1.a.b(H, "Channel closed");
                    c();
                    countDownLatch = this.A;
                } else if (i3 == 3) {
                    this.E = 0;
                    this.D = false;
                    if (this.C) {
                        return;
                    }
                    this.C = true;
                    c();
                    countDownLatch = this.A;
                } else if (i3 == 4) {
                    this.D = false;
                    return;
                } else {
                    if (i3 != 5) {
                        return;
                    }
                    h1.a.a(H, "Transfer Rx fail");
                    c();
                    countDownLatch = this.A;
                }
            } else {
                if (i2 != 2) {
                    if (i2 != 3) {
                        return;
                    }
                    k.e eVar = new k.e(antMessageParcel);
                    if (eVar.n()) {
                        this.f3240u = null;
                        this.B.reset();
                    }
                    this.B.write(eVar.k());
                    if ((eVar.m() & 4) > 0) {
                        this.f3240u = this.B.toByteArray();
                        this.C = true;
                        c();
                        this.A.countDown();
                        return;
                    }
                    return;
                }
                if (67 == antMessageParcel.a()[1]) {
                    if (3 == antMessageParcel.a()[3]) {
                        this.F++;
                    }
                    if (this.F > 40) {
                        h1.a.j(H, "No response. Client seems stuck in busy state. Ping.");
                        this.f3396a.D(I);
                        this.F = 0;
                        c();
                        this.A.countDown();
                    }
                }
                if (this.f3245z == -1) {
                    if (67 == antMessageParcel.a()[1] && 2 == antMessageParcel.a()[3]) {
                        h1.a.a(H, "Got transport beacon");
                        this.f3245z = 2;
                        c();
                        this.A.countDown();
                        return;
                    }
                    return;
                }
                if (!this.C) {
                    int i4 = this.E + 1;
                    this.E = i4;
                    if (i4 > 30) {
                        c();
                        this.A.countDown();
                        return;
                    } else {
                        if (67 == antMessageParcel.a()[1] && 2 == antMessageParcel.a()[3] && !this.D && this.E % 3 == 0) {
                            this.D = true;
                            h1.a.a(H, "Retrying erase command");
                            this.f3396a.e(this.f3239t);
                            return;
                        }
                        return;
                    }
                }
                if (67 != antMessageParcel.a()[1]) {
                    return;
                }
                if (2 == antMessageParcel.a()[3]) {
                    this.G++;
                }
                if (this.G <= 40) {
                    return;
                }
                h1.a.b(H, "No response.");
                c();
                countDownLatch = this.A;
            }
            countDownLatch.countDown();
        } catch (g.a e3) {
            if (e3.a() == g.b.TRANSFER_IN_PROGRESS) {
                str = H;
                str2 = "TRANSFER_IN_PROGRESS error sending burst msg";
            } else {
                if (e3.a() != g.b.TRANSFER_FAILED) {
                    h1.a.b(H, "ACFE handling message: " + e3.toString());
                    c();
                    this.A.countDown();
                    return;
                }
                this.D = false;
                str = H;
                str2 = "TRANSFER_FAILED error sending burst msg";
            }
            h1.a.i(str, str2);
        } catch (IOException e4) {
            h1.a.b(H, "IOException receiving burst: " + e4.toString());
            c();
            this.A.countDown();
        }
    }
}
