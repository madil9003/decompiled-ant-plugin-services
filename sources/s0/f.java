package s0;

import android.os.RemoteException;
import com.dsi.ant.message.ipc.AntMessageParcel;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import s0.g;

/* loaded from: classes.dex */
public class f extends i {
    private static final String F = "f";
    static byte G = 67;
    static int H = -1;
    static int I = 0;
    static int J = 1;
    static final byte[] K = {3, 7, 15, 20, 25, 29, 34, 40, 45, 49, 54, 60, 65, 70, 75, 80};
    static final Random L = new Random();
    int A;
    boolean B;
    boolean C;
    int D;
    byte[] E;

    /* renamed from: s */
    long f3147s;

    /* renamed from: t */
    int f3148t;

    /* renamed from: u */
    int f3149u;

    /* renamed from: v */
    int f3150v;

    /* renamed from: w */
    g.k f3151w;

    /* renamed from: x */
    CountDownLatch f3152x;

    /* renamed from: y */
    int f3153y;

    /* renamed from: z */
    int f3154z;

    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a */
        static final /* synthetic */ int[] f3155a;

        /* renamed from: b */
        static final /* synthetic */ int[] f3156b;

        static {
            int[] iArr = new int[k.l.values().length];
            f3156b = iArr;
            try {
                iArr[k.l.CHANNEL_EVENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3156b[k.l.BROADCAST_DATA.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[j.e.values().length];
            f3155a = iArr2;
            try {
                iArr2[j.e.RX_SEARCH_TIMEOUT.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3155a[j.e.CHANNEL_CLOSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3155a[j.e.TRANSFER_TX_COMPLETED.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3155a[j.e.TRANSFER_TX_FAILED.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public f(g.m mVar, long j2, int i2, int i3, int i4) {
        super(mVar);
        this.f3150v = 0;
        this.f3151w = g.k.LINK_IDLE;
        int i5 = H;
        this.f3153y = i5;
        this.f3154z = i5;
        this.A = i5;
        this.B = false;
        this.C = false;
        this.D = 1;
        this.E = new byte[]{68, 2, 0, 4, 0, 0, 0, 0};
        this.f3147s = j2;
        this.f3148t = i2;
        this.f3149u = i3;
        this.f3150v = i4;
    }

    @Override // s0.i
    public boolean C(g.k kVar) {
        return kVar == g.k.NOT_CONNECTED || kVar == g.k.LINK_IDLE;
    }

    public int E() {
        return this.A;
    }

    public int F() {
        return this.f3154z;
    }

    @Override // u0.b
    public void d() {
        String str;
        try {
            try {
                g.k kVar = g.k.LINK_CONNECTING;
                this.f3151w = kVar;
                this.f3249r.a(kVar, g.j.CONNECTION_REQUESTED);
                int i2 = this.f3150v;
                int ceil = i2 != 0 ? (int) Math.ceil((i2 * 4.0d) / 10.0d) : 10;
                int i3 = 0;
                while (true) {
                    i3++;
                    if (i3 > ceil) {
                        h1.a.b(F, "Failed: Could not link before retry limit reached");
                        g.k kVar2 = g.k.NOT_CONNECTED;
                        this.f3151w = kVar2;
                        this.f3249r.a(kVar2, g.j.CONNECTION_LOST);
                        D(g.l.FAIL_OTHER_DEVICE_COMMUNICATION_ERROR);
                        return;
                    }
                    j.c l2 = this.f3396a.p().l();
                    if (l2 != j.c.TRACKING && l2 != j.c.SEARCHING) {
                        if (this.f3150v == 0) {
                            h1.a.b(F, "Failed: Connection lost");
                            g.k kVar3 = g.k.NOT_CONNECTED;
                            this.f3151w = kVar3;
                            this.f3249r.a(kVar3, g.j.CONNECTION_LOST);
                            D(g.l.FAIL_DEVICE_TRANSMISSION_LOST);
                            return;
                        }
                        h1.a.a(F, "Restarting search...");
                        this.f3396a.l();
                    }
                    this.f3396a.x(this.f3149u);
                    this.f3396a.z(this.f3148t);
                    this.f3153y = H;
                    String str2 = F;
                    h1.a.a(str2, "Wait for link beacon");
                    this.f3152x = new CountDownLatch(1);
                    f();
                    this.f3152x.await(10L, TimeUnit.SECONDS);
                    if (this.f3153y != I) {
                        str = "Time out waiting for link beacon.";
                    } else {
                        h1.a.a(str2, "Sending link command");
                        this.B = false;
                        this.C = true;
                        this.D = 1;
                        w.c.e(this.E, 4, this.f3147s);
                        byte[] bArr = this.E;
                        byte[] bArr2 = K;
                        bArr[2] = bArr2[L.nextInt(bArr2.length)];
                        try {
                            this.f3396a.D(this.E);
                        } catch (g.a e3) {
                            if (e3.a() == g.b.TRANSFER_IN_PROGRESS) {
                                h1.a.i(F, "Failed to send Link Command: TRANSFER_IN_PROGRESS error sending ack msg");
                            } else {
                                h1.a.b(F, "Failed to send Link Command: " + e3.toString());
                            }
                        }
                        this.f3152x = new CountDownLatch(1);
                        f();
                        CountDownLatch countDownLatch = this.f3152x;
                        TimeUnit timeUnit = TimeUnit.SECONDS;
                        countDownLatch.await(10L, timeUnit);
                        if (this.B) {
                            this.f3396a.x(4096);
                            this.f3396a.z(this.E[2]);
                            str2 = F;
                            h1.a.a(str2, "Wait for auth beacon");
                            this.f3152x = new CountDownLatch(1);
                            f();
                            this.f3152x.await(10L, timeUnit);
                            if (this.f3153y == J) {
                                g.k kVar4 = g.k.AUTH_IDLE;
                                this.f3151w = kVar4;
                                this.f3249r.a(kVar4, g.j.LINK_PASS);
                                D(g.l.SUCCESS);
                                return;
                            }
                            str = "Time out waiting for auth beacon.";
                        } else {
                            h1.a.j(F, "Link Tx retries exceeded");
                        }
                    }
                    h1.a.j(str2, str);
                }
            } catch (g.a e4) {
                h1.a.b(F, "ACFE occurred: " + e4.toString());
                throw new RemoteException();
            }
        } catch (InterruptedException unused) {
            h1.a.b(F, "Interrupted waiting for result");
            D(g.l.FAIL_EXECUTOR_CANCELLED_TASK);
            Thread.currentThread().interrupt();
        }
    }

    @Override // u0.b
    public String k() {
        return "ANT-FS Host Link Channel Task";
    }

    @Override // u0.b
    public void u(k.l lVar, AntMessageParcel antMessageParcel) {
        CountDownLatch countDownLatch;
        try {
            int i2 = a.f3156b[lVar.ordinal()];
            if (i2 == 1) {
                int i3 = a.f3155a[new k.g(antMessageParcel).j().ordinal()];
                if (i3 == 1) {
                    h1.a.b(F, "Search timeout occured");
                    return;
                }
                if (i3 == 2) {
                    h1.a.b(F, "Channel closed");
                    c();
                    countDownLatch = this.f3152x;
                } else if (i3 != 3) {
                    if (i3 != 4) {
                        return;
                    }
                    this.C = false;
                    return;
                } else {
                    this.B = true;
                    this.C = false;
                    this.D = 1;
                    c();
                    countDownLatch = this.f3152x;
                }
                countDownLatch.countDown();
                return;
            }
            if (i2 != 2) {
                return;
            }
            int i4 = this.f3153y;
            if (i4 == H) {
                if (G == antMessageParcel.a()[1]) {
                    byte b3 = antMessageParcel.a()[3];
                    this.f3153y = b3;
                    if (b3 != I) {
                        h1.a.b(F, "Beacon in incorrect state");
                        return;
                    }
                    this.f3154z = j.b(antMessageParcel.a());
                    this.A = j.a(antMessageParcel.a());
                    c();
                    this.f3152x.countDown();
                    return;
                }
                return;
            }
            if (this.B || i4 != I) {
                if (i4 == I && G == antMessageParcel.a()[1] && J == antMessageParcel.a()[3]) {
                    if (w.c.n(antMessageParcel.a(), 5) != this.f3147s) {
                        h1.a.j(F, "Serial number mismatch - client connected to another host");
                    } else {
                        this.f3153y = J;
                    }
                    c();
                    this.f3152x.countDown();
                    return;
                }
                return;
            }
            int i5 = this.D + 1;
            this.D = i5;
            if (i5 > 30) {
                c();
                this.f3152x.countDown();
            } else {
                if (this.C || i5 % 3 != 0) {
                    return;
                }
                this.C = true;
                h1.a.a(F, "Retrying link command");
                this.f3396a.D(this.E);
            }
        } catch (g.a e3) {
            if (e3.a() == g.b.TRANSFER_IN_PROGRESS) {
                h1.a.i(F, "TRANSFER_IN_PROGRESS error sending ack msg");
                return;
            }
            h1.a.b(F, "ACFE handling message: " + e3.toString());
            c();
            this.f3152x.countDown();
        }
    }
}
