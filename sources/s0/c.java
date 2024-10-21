package s0;

import android.os.RemoteException;
import com.dsi.ant.message.ipc.AntMessageParcel;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import s0.g;

/* loaded from: classes.dex */
public class c extends i {

    /* renamed from: w */
    private static final String f3120w = "c";

    /* renamed from: s */
    byte[] f3121s;

    /* renamed from: t */
    CountDownLatch f3122t;

    /* renamed from: u */
    int f3123u;

    /* renamed from: v */
    int f3124v;

    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a */
        static final /* synthetic */ int[] f3125a;

        /* renamed from: b */
        static final /* synthetic */ int[] f3126b;

        static {
            int[] iArr = new int[k.l.values().length];
            f3126b = iArr;
            try {
                iArr[k.l.CHANNEL_EVENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            int[] iArr2 = new int[j.e.values().length];
            f3125a = iArr2;
            try {
                iArr2[j.e.CHANNEL_CLOSED.ordinal()] = 1;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3125a[j.e.RX_SEARCH_TIMEOUT.ordinal()] = 2;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3125a[j.e.TRANSFER_TX_COMPLETED.ordinal()] = 3;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public c(g.m mVar, int i2, int i3) {
        super(mVar);
        this.f3121s = new byte[]{68, 3, 0, 0, 0, 0, 0, 0};
        this.f3123u = i3;
        this.f3124v = i2;
    }

    @Override // s0.i
    public boolean C(g.k kVar) {
        return kVar == g.k.NOT_CONNECTED;
    }

    @Override // u0.b
    public void d() {
        try {
            try {
                if (this.f3396a.p().l() != j.c.TRACKING) {
                    this.f3396a.x(this.f3123u);
                    this.f3396a.z(this.f3124v);
                    h1.a.b(f3120w, "Failed: Connection lost");
                    this.f3249r.a(g.k.NOT_CONNECTED, g.j.CONNECTION_LOST);
                    D(g.l.FAIL_DEVICE_TRANSMISSION_LOST);
                    return;
                }
                try {
                    this.f3396a.D(this.f3121s);
                } catch (g.a e3) {
                    if (e3.a() != g.b.TRANSFER_IN_PROGRESS) {
                        throw e3;
                    }
                    h1.a.a(f3120w, "Failed to send Link Command: TRANSFER_IN_PROGRESS error sending ack msg");
                }
                this.f3122t = new CountDownLatch(1);
                f();
                this.f3122t.await(1L, TimeUnit.SECONDS);
                this.f3396a.x(this.f3123u);
                this.f3396a.z(this.f3124v);
                this.f3249r.a(g.k.NOT_CONNECTED, g.j.DISCONNECT_PASS);
                D(g.l.SUCCESS);
            } catch (InterruptedException unused) {
                h1.a.b(f3120w, "Interrupted waiting for result");
                D(g.l.FAIL_EXECUTOR_CANCELLED_TASK);
                Thread.currentThread().interrupt();
            }
        } catch (g.a e4) {
            h1.a.b(f3120w, "ACFE occurred disconnecting: " + e4.toString());
            throw new RemoteException();
        }
    }

    @Override // u0.b
    public String k() {
        return "ANT-FS Host Disconnect Channel Task";
    }

    @Override // u0.b
    public void u(k.l lVar, AntMessageParcel antMessageParcel) {
        if (a.f3126b[lVar.ordinal()] != 1) {
            return;
        }
        int i2 = a.f3125a[new k.g(antMessageParcel).j().ordinal()];
        if (i2 == 1) {
            h1.a.b(f3120w, "Channel closed");
        } else if (i2 == 2) {
            h1.a.b(f3120w, "Search timeout occured");
            return;
        } else if (i2 != 3) {
            return;
        }
        c();
        this.f3122t.countDown();
    }
}
