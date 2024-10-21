package c0;

import android.os.Bundle;
import android.os.RemoteException;
import com.dsi.ant.message.ipc.AntMessageParcel;
import j.c;
import j.e;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import k.g;
import k.l;
import v.e;

/* loaded from: classes.dex */
public class a extends u0.b {

    /* renamed from: y */
    private static final String f263y = "a";

    /* renamed from: q */
    a0.b f264q;

    /* renamed from: r */
    CountDownLatch f265r;

    /* renamed from: t */
    u.a f267t;

    /* renamed from: v */
    boolean f269v;

    /* renamed from: s */
    private boolean f266s = false;

    /* renamed from: u */
    boolean f268u = false;

    /* renamed from: w */
    private int f270w = 1;

    /* renamed from: x */
    private final byte[] f271x = new byte[8];

    /* renamed from: c0.a$a */
    /* loaded from: classes.dex */
    static /* synthetic */ class C0005a {

        /* renamed from: a */
        static final /* synthetic */ int[] f272a;

        /* renamed from: b */
        static final /* synthetic */ int[] f273b;

        static {
            int[] iArr = new int[l.values().length];
            f273b = iArr;
            try {
                iArr[l.CHANNEL_EVENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f273b[l.BROADCAST_DATA.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f273b[l.ACKNOWLEDGED_DATA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[e.values().length];
            f272a = iArr2;
            try {
                iArr2[e.RX_SEARCH_TIMEOUT.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f272a[e.TRANSFER_TX_COMPLETED.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f272a[e.TRANSFER_TX_FAILED.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public a(a0.b bVar, e.a aVar, u.a aVar2) {
        this.f264q = bVar;
        this.f267t = aVar2;
        aVar2.c(aVar.f3454c, aVar.f3455d);
    }

    public void B(byte[] bArr) {
        boolean z2 = false;
        System.arraycopy(bArr, 0, this.f271x, 0, 8);
        try {
            z2 = this.f264q.f61y.u(this, 1000);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
        if (z2) {
            this.f264q.k(300);
        } else {
            C(-20);
            h1.a.b(f263y, "channel task not started");
        }
    }

    public void C(int i2) {
        synchronized (this.f267t) {
            if (this.f266s) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putInt("int_requestStatus", i2);
            h1.a.a(f263y, "Firing commandFinished event");
            this.f267t.a(bundle);
            this.f266s = true;
        }
    }

    @Override // u0.b
    public void d() {
        try {
            if (this.f3396a.p().l() != c.TRACKING) {
                h1.a.b(f263y, "Failed: Channel not tracking");
                C(-40);
                return;
            }
            this.f265r = new CountDownLatch(1);
            f();
            try {
                this.f265r.await(60L, TimeUnit.SECONDS);
            } catch (InterruptedException unused) {
                h1.a.a("ChannelTask_SendAcknowledgedDataPage", "Interrupted waiting for result");
                Thread.currentThread().interrupt();
            }
            C(this.f268u ? 0 : -40);
        } catch (g.a e3) {
            h1.a.b(f263y, "AntCommandFailedException in dowork(): " + e3.toString());
            C(-40);
            throw new RemoteException();
        }
    }

    @Override // u0.b
    public String k() {
        return "Audio Command";
    }

    @Override // u0.b
    public void o() {
        C(-40);
    }

    @Override // u0.b
    public void s() {
    }

    @Override // u0.b
    public void u(l lVar, AntMessageParcel antMessageParcel) {
        CountDownLatch countDownLatch;
        try {
            int i2 = C0005a.f273b[lVar.ordinal()];
            if (i2 != 1) {
                if ((i2 == 2 || i2 == 3) && !this.f268u) {
                    int i3 = this.f270w + 1;
                    this.f270w = i3;
                    if (i3 > 30) {
                        h1.a.a(f263y, "Tx retries exceeded sending command");
                        this.f265r.countDown();
                        return;
                    } else {
                        if (i3 % 3 == 0) {
                            h1.a.a(f263y, "Tx retry command");
                            this.f269v = true;
                            this.f3396a.D(this.f271x);
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            int i4 = C0005a.f272a[new g(antMessageParcel).j().ordinal()];
            if (i4 == 1) {
                h1.a.a(f263y, "Search timeout occured");
                c();
                countDownLatch = this.f265r;
            } else {
                if (i4 != 2) {
                    if (i4 != 3) {
                        return;
                    }
                    this.f269v = false;
                    int i5 = this.f270w;
                    this.f270w = i5 + (2 - (i5 % 3));
                    return;
                }
                this.f269v = false;
                this.f268u = true;
                this.f270w = 0;
                countDownLatch = this.f265r;
            }
            countDownLatch.countDown();
        } catch (g.a e3) {
            if (e3.a() == g.b.TRANSFER_IN_PROGRESS) {
                h1.a.i(f263y, "TRANSFER_IN_PROGRESS error sending ack msg");
                return;
            }
            if (e3.a() == g.b.TRANSFER_FAILED) {
                this.f269v = false;
                return;
            }
            h1.a.b(f263y, "ACFE handling message: " + e3.toString());
            C(-40);
            c();
            this.f265r.countDown();
        }
    }
}
