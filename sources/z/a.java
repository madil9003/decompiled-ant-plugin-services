package z;

import android.os.RemoteException;
import com.dsi.ant.message.ipc.AntMessageParcel;
import com.dsi.ant.plugins.antplus.pccbase.b;
import j.c;
import j.e;
import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import k.g;
import k.l;
import p0.f;

/* loaded from: classes.dex */
public class a extends u0.b {
    private static final String C = "a";
    protected static int D = 12;
    protected boolean A;

    /* renamed from: q */
    private b.d f3602q;

    /* renamed from: v */
    protected b f3607v;

    /* renamed from: w */
    protected byte[] f3608w;

    /* renamed from: x */
    protected int f3609x;

    /* renamed from: y */
    protected CountDownLatch f3610y;

    /* renamed from: z */
    protected boolean f3611z;

    /* renamed from: r */
    private f f3603r = null;

    /* renamed from: s */
    private Object f3604s = new Object();

    /* renamed from: t */
    private boolean f3605t = true;

    /* renamed from: u */
    private boolean f3606u = false;
    protected int B = 0;

    /* renamed from: z.a$a */
    /* loaded from: classes.dex */
    static /* synthetic */ class C0070a {

        /* renamed from: a */
        static final /* synthetic */ int[] f3612a;

        /* renamed from: b */
        static final /* synthetic */ int[] f3613b;

        static {
            int[] iArr = new int[l.values().length];
            f3613b = iArr;
            try {
                iArr[l.CHANNEL_EVENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3613b[l.BROADCAST_DATA.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3613b[l.ACKNOWLEDGED_DATA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[e.values().length];
            f3612a = iArr2;
            try {
                iArr2[e.RX_SEARCH_TIMEOUT.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3612a[e.CHANNEL_CLOSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3612a[e.TRANSFER_TX_COMPLETED.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3612a[e.TRANSFER_TX_FAILED.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f3612a[e.CHANNEL_COLLISION.ordinal()] = 5;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f3612a[e.RX_FAIL.ordinal()] = 6;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(l lVar, AntMessageParcel antMessageParcel);
    }

    public a(byte[] bArr, b bVar, b.d dVar) {
        this.f3608w = bArr;
        this.f3607v = bVar;
        E(dVar);
        this.f3611z = false;
        this.f3609x = 0;
        this.A = false;
    }

    public void B() {
        this.f3609x++;
        this.f3611z = false;
        this.A = true;
    }

    public void C(f fVar) {
        synchronized (this.f3604s) {
            if (this.f3603r == null) {
                this.f3603r = fVar;
                b.d dVar = this.f3602q;
                if (dVar != null) {
                    dVar.a(fVar);
                }
            } else {
                h1.a.a(C, "Attempted to send extra result: " + fVar + " after already sending result: " + this.f3603r);
            }
        }
    }

    public void D(boolean z2) {
        this.f3605t = z2;
    }

    public void E(b.d dVar) {
        this.f3602q = dVar;
    }

    public void F() {
        if (this.A) {
            return;
        }
        if (this.f3609x >= D) {
            h1.a.a(C, "Unable to send data page after " + D + " requests");
            c();
            this.f3610y.countDown();
            return;
        }
        B();
        try {
            byte[] bArr = this.f3608w;
            if (bArr.length > 8) {
                this.f3396a.e(bArr);
            } else {
                this.f3396a.D(bArr);
            }
        } catch (g.a e3) {
            if (e3.a() == g.b.TRANSFER_IN_PROGRESS) {
                h1.a.i(C, "TRANSFER_PROCESSING error sending ack msg");
                return;
            }
            if (e3.a() == g.b.TRANSFER_FAILED) {
                this.A = false;
                return;
            }
            h1.a.b(C, "ACFE handling message: " + e3.toString());
            c();
            this.f3611z = false;
            this.f3610y.countDown();
        }
    }

    @Override // u0.b
    public void d() {
        if (this.f3608w.length < 8) {
            h1.a.b(C, "Bad params: message payload less than 8 bytes");
            C(f.FAIL_BAD_PARAMS);
            return;
        }
        try {
            if (this.f3396a.p().l() != c.TRACKING) {
                h1.a.b(C, "Failed: Channel not tracking");
                C(f.FAIL_DEVICE_TRANSMISSION_LOST);
                return;
            }
            this.f3610y = new CountDownLatch(1);
            f();
            F();
            while (!this.f3606u && !this.f3611z) {
                try {
                    this.f3610y.await();
                } catch (InterruptedException unused) {
                    h1.a.b(C, "Interrupted waiting for result, isShutdown: " + this.f3606u);
                }
            }
            C(this.f3611z ? f.SUCCESS : f.FAIL_DEVICE_COMMUNICATION_FAILURE);
        } catch (g.a e3) {
            h1.a.b(C, "AntCommandFailedException in dowork(): " + e3.toString());
            C(f.FAIL_DEVICE_COMMUNICATION_FAILURE);
            throw new RemoteException();
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        b bVar = this.f3607v;
        if (bVar == null) {
            if (aVar.f3607v != null) {
                return false;
            }
        } else if (!bVar.equals(aVar.f3607v)) {
            return false;
        }
        if (this.f3611z != aVar.f3611z || this.f3606u != aVar.f3606u || this.A != aVar.A || !Arrays.equals(this.f3608w, aVar.f3608w)) {
            return false;
        }
        b.d dVar = this.f3602q;
        if (dVar == null) {
            if (aVar.f3602q != null) {
                return false;
            }
        } else if (!dVar.equals(aVar.f3602q)) {
            return false;
        }
        return this.f3603r == aVar.f3603r;
    }

    public int hashCode() {
        b bVar = this.f3607v;
        int hashCode = ((((((((((bVar == null ? 0 : bVar.hashCode()) + 31) * 31) + (this.f3611z ? 1231 : 1237)) * 31) + (this.f3606u ? 1231 : 1237)) * 31) + (this.A ? 1231 : 1237)) * 31) + Arrays.hashCode(this.f3608w)) * 31;
        b.d dVar = this.f3602q;
        int hashCode2 = (hashCode + (dVar == null ? 0 : dVar.hashCode())) * 31;
        f fVar = this.f3603r;
        return hashCode2 + (fVar != null ? fVar.hashCode() : 0);
    }

    @Override // u0.b
    public String k() {
        return "Send Transfer Data";
    }

    @Override // u0.b
    public void o() {
        this.f3606u = true;
        p(Integer.MAX_VALUE);
    }

    @Override // u0.b
    public boolean p(int i2) {
        if (!this.f3605t) {
            return false;
        }
        h1.a.a(C, "Cancelling task, transferInProgress: " + this.A);
        this.f3609x = D;
        return true;
    }

    @Override // u0.b
    public void s() {
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:18:0x0030. Please report as an issue. */
    @Override // u0.b
    public void u(l lVar, AntMessageParcel antMessageParcel) {
        b bVar = this.f3607v;
        if (bVar != null) {
            bVar.a(lVar, antMessageParcel);
        }
        int i2 = C0070a.f3613b[lVar.ordinal()];
        if (i2 == 1) {
            switch (C0070a.f3612a[new g(antMessageParcel).j().ordinal()]) {
                case 1:
                    h1.a.b(C, "Search timeout occured");
                    return;
                case 2:
                    h1.a.b(C, "Channel closed");
                    c();
                    this.f3610y.countDown();
                    return;
                case 3:
                    this.A = false;
                    this.f3611z = true;
                    c();
                    this.f3610y.countDown();
                    return;
                case 4:
                    this.A = false;
                    break;
                case 5:
                case 6:
                    if (this.f3611z) {
                        return;
                    }
                    break;
                default:
                    return;
            }
        } else if ((i2 != 2 && i2 != 3) || this.f3611z) {
            return;
        }
        F();
    }
}
