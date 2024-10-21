package s0;

import android.os.RemoteException;
import com.dsi.ant.message.ipc.AntMessageParcel;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import s0.g;

/* loaded from: classes.dex */
public class e extends i {
    private static final String D = "e";
    private static final byte[] E = {68, 5, 0, 0, 0, 0, 0, 0};
    private int A;
    private int B;
    private int C;

    /* renamed from: s */
    private int f3137s;

    /* renamed from: t */
    private g.k f3138t;

    /* renamed from: u */
    private byte[] f3139u;

    /* renamed from: v */
    private byte[] f3140v;

    /* renamed from: w */
    private CountDownLatch f3141w;

    /* renamed from: x */
    private ByteArrayOutputStream f3142x;

    /* renamed from: y */
    private boolean f3143y;

    /* renamed from: z */
    private boolean f3144z;

    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a */
        static final /* synthetic */ int[] f3145a;

        /* renamed from: b */
        static final /* synthetic */ int[] f3146b;

        static {
            int[] iArr = new int[k.l.values().length];
            f3146b = iArr;
            try {
                iArr[k.l.CHANNEL_EVENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3146b[k.l.BROADCAST_DATA.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3146b[k.l.BURST_TRANSFER_DATA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[j.e.values().length];
            f3145a = iArr2;
            try {
                iArr2[j.e.RX_SEARCH_TIMEOUT.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3145a[j.e.CHANNEL_CLOSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3145a[j.e.TRANSFER_TX_COMPLETED.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3145a[j.e.TRANSFER_TX_FAILED.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f3145a[j.e.TRANSFER_RX_FAILED.ordinal()] = 5;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public e(g.m mVar, int i2) {
        super(mVar);
        this.f3137s = -1;
        this.f3138t = g.k.TRANSPORT_IDLE;
        this.f3142x = new ByteArrayOutputStream();
        this.f3143y = false;
        this.f3144z = false;
        this.A = 0;
        this.B = 0;
        this.C = 0;
        byte[] bArr = {68, 11, 0, 0, 0, 0, 0, 0};
        this.f3139u = bArr;
        w.c.d(bArr, 2, i2);
    }

    private g.l E() {
        byte[] bArr = this.f3140v;
        if (bArr.length < 16 || bArr[8] != 68 || w.c.i(bArr[9]) != 139) {
            return g.l.FAIL_ERASE_BAD_RESPONSE;
        }
        int i2 = w.c.i(this.f3140v[10]);
        return i2 == 0 ? g.l.SUCCESS : i2 == 2 ? g.l.FAIL_ERASE_NOT_READY : g.l.FAIL_ERASE;
    }

    @Override // s0.i
    public boolean C(g.k kVar) {
        return kVar == g.k.TRANSPORT_IDLE;
    }

    @Override // u0.b
    public void d() {
        String str;
        for (int i2 = 0; i2 < 5; i2++) {
            try {
                try {
                    j.c l2 = this.f3396a.p().l();
                    if (l2 != j.c.TRACKING && l2 != j.c.SEARCHING) {
                        h1.a.b(D, "Failed: Connection lost");
                        g.k kVar = g.k.NOT_CONNECTED;
                        this.f3138t = kVar;
                        this.f3249r.a(kVar, g.j.CONNECTION_LOST);
                        D(g.l.FAIL_DEVICE_TRANSMISSION_LOST);
                        return;
                    }
                    String str2 = D;
                    h1.a.a(str2, "Wait for transport beacon");
                    this.f3137s = -1;
                    this.f3141w = new CountDownLatch(1);
                    f();
                    this.f3141w.await(10L, TimeUnit.SECONDS);
                    if (this.f3137s != 2) {
                        str = "Timed out waiting for transport beacon";
                    } else {
                        this.f3143y = false;
                        this.A = 0;
                        this.f3144z = true;
                        this.f3142x.reset();
                        this.f3141w = new CountDownLatch(1);
                        f();
                        try {
                            this.f3396a.D(this.f3139u);
                        } catch (g.a e3) {
                            h1.a.a(D, "Exception sending burst: " + e3.a());
                        }
                        this.f3141w.await();
                        if (this.f3143y) {
                            h1.a.a(D, "Wait for erase response");
                            this.B = 0;
                            this.C = 0;
                            this.f3142x.reset();
                            this.f3141w = new CountDownLatch(1);
                            f();
                            this.f3141w.await();
                            if (this.f3140v != null) {
                                D(E());
                                return;
                            }
                        } else {
                            str2 = D;
                            str = "Failed: Erase Tx retries exceeded";
                        }
                    }
                    h1.a.b(str2, str);
                } catch (g.a e4) {
                    h1.a.b(D, "ACFE occurred requesting status: " + e4.toString());
                    this.f3138t = g.k.NOT_CONNECTED;
                    this.f3396a.m();
                    throw new RemoteException();
                }
            } catch (InterruptedException unused) {
                h1.a.b(D, "Interrupted waiting for result");
                D(g.l.FAIL_EXECUTOR_CANCELLED_TASK);
                Thread.currentThread().interrupt();
                return;
            }
        }
        D(g.l.FAIL_OTHER_DEVICE_COMMUNICATION_ERROR);
    }

    @Override // u0.b
    public String k() {
        return "ANT-FS Host Erase Channel Task";
    }

    @Override // u0.b
    public void u(k.l lVar, AntMessageParcel antMessageParcel) {
        String str;
        String str2;
        CountDownLatch countDownLatch;
        try {
            int i2 = a.f3146b[lVar.ordinal()];
            if (i2 == 1) {
                int i3 = a.f3145a[new k.g(antMessageParcel).j().ordinal()];
                if (i3 == 1) {
                    h1.a.b(D, "Search timeout occured");
                    return;
                }
                if (i3 == 2) {
                    h1.a.b(D, "Channel closed");
                    c();
                    countDownLatch = this.f3141w;
                } else if (i3 == 3) {
                    this.A = 0;
                    this.f3144z = false;
                    if (this.f3143y) {
                        return;
                    }
                    this.f3143y = true;
                    c();
                    countDownLatch = this.f3141w;
                } else if (i3 == 4) {
                    this.f3144z = false;
                    return;
                } else {
                    if (i3 != 5) {
                        return;
                    }
                    h1.a.a(D, "Transfer Rx fail");
                    c();
                    countDownLatch = this.f3141w;
                }
            } else {
                if (i2 != 2) {
                    if (i2 != 3) {
                        return;
                    }
                    k.e eVar = new k.e(antMessageParcel);
                    if (eVar.n()) {
                        this.f3140v = null;
                        this.f3142x.reset();
                    }
                    this.f3142x.write(eVar.k());
                    if ((eVar.m() & 4) > 0) {
                        this.f3140v = this.f3142x.toByteArray();
                        this.f3143y = true;
                        c();
                        this.f3141w.countDown();
                        return;
                    }
                    return;
                }
                if (67 == antMessageParcel.a()[1]) {
                    if (3 == antMessageParcel.a()[3]) {
                        this.B++;
                    }
                    if (this.B > 40) {
                        h1.a.j(D, "No response. Client seems stuck in busy state. Ping.");
                        this.f3396a.D(E);
                        this.B = 0;
                        c();
                        this.f3141w.countDown();
                    }
                }
                if (this.f3137s == -1) {
                    if (67 == antMessageParcel.a()[1] && 2 == antMessageParcel.a()[3]) {
                        h1.a.a(D, "Got transport beacon");
                        this.f3137s = 2;
                        c();
                        this.f3141w.countDown();
                        return;
                    }
                    return;
                }
                if (!this.f3143y) {
                    int i4 = this.A + 1;
                    this.A = i4;
                    if (i4 > 30) {
                        c();
                        this.f3141w.countDown();
                        return;
                    } else {
                        if (67 == antMessageParcel.a()[1] && 2 == antMessageParcel.a()[3] && !this.f3144z && this.A % 3 == 0) {
                            this.f3144z = true;
                            h1.a.a(D, "Retrying erase command");
                            this.f3396a.D(this.f3139u);
                            return;
                        }
                        return;
                    }
                }
                if (67 != antMessageParcel.a()[1]) {
                    return;
                }
                if (2 == antMessageParcel.a()[3]) {
                    this.C++;
                }
                if (this.C <= 40) {
                    return;
                }
                h1.a.b(D, "No response.");
                c();
                countDownLatch = this.f3141w;
            }
            countDownLatch.countDown();
        } catch (g.a e3) {
            if (e3.a() == g.b.TRANSFER_IN_PROGRESS) {
                str = D;
                str2 = "TRANSFER_IN_PROGRESS error sending ack msg";
            } else {
                if (e3.a() != g.b.TRANSFER_FAILED) {
                    h1.a.b(D, "ACFE handling message: " + e3.toString());
                    c();
                    this.f3141w.countDown();
                    return;
                }
                this.f3144z = false;
                str = D;
                str2 = "TRANSFER_FAILED error sending ack msg";
            }
            h1.a.i(str, str2);
        } catch (IOException e4) {
            h1.a.b(D, "IOException receiving burst: " + e4.toString());
            c();
            this.f3141w.countDown();
        }
    }
}
