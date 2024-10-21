package s0;

import android.os.RemoteException;
import com.dsi.ant.message.ipc.AntMessageParcel;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.concurrent.Exchanger;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes.dex */
public class g extends u0.b {
    private static final String G = "g";
    private int A;

    /* renamed from: r */
    private m f3158r;

    /* renamed from: w */
    private GregorianCalendar f3163w;

    /* renamed from: x */
    private int f3164x;

    /* renamed from: y */
    private byte[] f3165y;

    /* renamed from: z */
    private long f3166z;

    /* renamed from: q */
    private m f3157q = new a();

    /* renamed from: s */
    private Exchanger f3159s = new Exchanger();

    /* renamed from: t */
    private Exchanger f3160t = new Exchanger();

    /* renamed from: u */
    private Semaphore f3161u = new Semaphore(1);

    /* renamed from: v */
    private k f3162v = k.NOT_CONNECTED;
    private int B = 57;
    private int C = 4096;
    private int D = 0;
    private int E = 0;
    s0.n F = new C0051g();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements m {
        a() {
        }

        @Override // s0.g.m
        public void a(k kVar, j jVar) {
            g.this.f3162v = kVar;
            g.this.f3158r.a(kVar, jVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements s0.n {

        /* renamed from: a */
        final /* synthetic */ s0.m f3168a;

        b(s0.m mVar) {
            this.f3168a = mVar;
        }

        @Override // s0.n
        public l run() {
            s0.f fVar = new s0.f(g.this.f3157q, g.this.f3166z, g.this.B, g.this.C, g.this.D);
            l X = g.this.X(fVar);
            l lVar = l.SUCCESS;
            if (X != lVar) {
                return X;
            }
            l X2 = g.this.X(new s0.b(g.this.f3157q, this.f3168a, g.this.A, fVar.F(), fVar.E(), g.this.f3166z));
            return X2 != lVar ? X2 : lVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements s0.n {

        /* renamed from: a */
        final /* synthetic */ s0.d f3170a;

        c(s0.d dVar) {
            this.f3170a = dVar;
        }

        @Override // s0.n
        public l run() {
            l X = g.this.X(this.f3170a);
            if (this.f3170a.F() == i.SUCCESS) {
                g.this.f3165y = this.f3170a.E();
            }
            return X;
        }
    }

    /* loaded from: classes.dex */
    public class d implements s0.n {

        /* renamed from: a */
        final /* synthetic */ s0.h f3172a;

        d(s0.h hVar) {
            this.f3172a = hVar;
        }

        @Override // s0.n
        public l run() {
            l X = g.this.X(this.f3172a);
            g.D(g.this);
            return X;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e implements s0.n {

        /* renamed from: a */
        final /* synthetic */ s0.e f3174a;

        e(s0.e eVar) {
            this.f3174a = eVar;
        }

        @Override // s0.n
        public l run() {
            return g.this.X(this.f3174a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f implements s0.n {

        /* renamed from: a */
        final /* synthetic */ s0.i f3176a;

        f(s0.i iVar) {
            this.f3176a = iVar;
        }

        @Override // s0.n
        public l run() {
            g.this.f3162v = k.NOT_CONNECTED;
            l X = g.this.X(this.f3176a);
            l lVar = l.SUCCESS;
            if (X != lVar) {
                return X;
            }
            g.this.f3162v = k.LINK_IDLE;
            return lVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: s0.g$g */
    /* loaded from: classes.dex */
    public class C0051g implements s0.n {
        C0051g() {
        }

        @Override // s0.n
        public l run() {
            return g.this.X(new s0.c(g.this.f3157q, g.this.B, g.this.C));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class h implements s0.n {
        h() {
        }

        @Override // s0.n
        public l run() {
            g.this.f3157q.a(k.NOT_CONNECTED, j.DISCONNECT_PASS);
            return l.SUCCESS;
        }
    }

    /* loaded from: classes.dex */
    public enum i {
        SUCCESS,
        FAIL_NO_RESPONSE,
        FAIL_CRC_ERROR,
        FAIL_INVALID_RESPONSE,
        FAIL_REJECTED_FILE_DOES_NOT_EXIST,
        FAIL_REJECTED_FILE_NOT_READABLE,
        FAIL_REJECTED_NOT_READY,
        FAIL_REJECTED_INVALID_REQUEST,
        FAIL_REJECTED_INCORRECT_CRC,
        FAIL_DEVICE_TRANSMISSION_LOST,
        FAIL_OTHER
    }

    /* loaded from: classes.dex */
    public enum j {
        CONNECTION_REQUESTED,
        LINK_PASS,
        AUTHENTICATE_SERIAL_PASS,
        AUTHENTICATE_PASS,
        AUTHENTICATE_REJECT,
        AUTHENTICATE_REJECT_BAD_PASSKEY,
        AUTHENTICATE_REJECT_PAIRING,
        AUTHENTICATE_FAIL_NO_RESPONSE,
        AUTHENTICATE_FAIL_BAD_RESPONSE,
        AUTHENTICATE_BEACON_FOUND,
        DOWNLOAD_START,
        DOWNLOAD_RESUME,
        DOWNLOAD_FINISHED,
        UPLOAD_FINISHED,
        ERASE_FINISHED,
        DISCONNECT_PASS,
        CONNECTION_LOST
    }

    /* loaded from: classes.dex */
    public enum k {
        LINK_IDLE,
        LINK_CONNECTING,
        AUTH_IDLE,
        AUTH_REQUESTING_SERIAL,
        AUTH_REQUESTING_PASSTHROUGH,
        AUTH_REQUESTING_PASSKEY,
        AUTH_WAITING_FOR_PAIRING,
        TRANSPORT_IDLE,
        TRANSPORT_DOWNLOADING,
        TRANSPORT_UPLOADING,
        TRANSPORT_ERASING,
        DISCONNECTING,
        SEARCHING,
        NOT_CONNECTED
    }

    /* loaded from: classes.dex */
    public enum l {
        SUCCESS,
        FAIL_REQUEST_IN_PROGRESS,
        FAIL_WRONG_ANTFS_STATE,
        FAIL_AUTHENTICATION_REJECTED,
        FAIL_DEVICE_TRANSMISSION_LOST,
        FAIL_OTHER_DEVICE_COMMUNICATION_ERROR,
        FAIL_EXECUTOR_CANCELLED_TASK,
        FAIL_NOT_SUPPORTED,
        FAIL_DEVICE_NOT_READY,
        FAIL_ERASE,
        FAIL_ERASE_NOT_READY,
        FAIL_ERASE_BAD_RESPONSE
    }

    /* loaded from: classes.dex */
    public interface m {
        void a(k kVar, j jVar);
    }

    /* loaded from: classes.dex */
    public interface n {
        void a(long j2, long j3);
    }

    public g(m mVar, long j2, int i2) {
        this.f3158r = mVar;
        this.f3166z = j2;
        this.A = i2;
    }

    static /* synthetic */ int D(g gVar) {
        int i2 = gVar.E;
        gVar.E = i2 + 1;
        return i2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.util.concurrent.Semaphore] */
    private l P(s0.n nVar) {
        l lVar;
        try {
            if (!this.f3161u.tryAcquire()) {
                return l.FAIL_REQUEST_IN_PROGRESS;
            }
            try {
                this.f3159s.exchange(nVar, 1L, TimeUnit.SECONDS);
                lVar = (l) this.f3160t.exchange(null);
            } catch (TimeoutException unused) {
                lVar = l.FAIL_REQUEST_IN_PROGRESS;
            }
            return lVar;
        } finally {
            this.f3161u.release();
        }
    }

    public l X(s0.i iVar) {
        if (iVar.C(this.f3162v)) {
            super.x(iVar);
            return iVar.B();
        }
        h1.a.b(G, "Can't start " + iVar.k() + " in state: " + this.f3162v);
        return l.FAIL_WRONG_ANTFS_STATE;
    }

    public byte[] M() {
        return this.f3165y;
    }

    public int N() {
        return this.f3164x;
    }

    public GregorianCalendar O() {
        return this.f3163w;
    }

    public l Q() {
        return P(new h());
    }

    public l R(s0.m mVar) {
        return P(new b(mVar));
    }

    public i S(int i2, n nVar) {
        this.f3165y = null;
        s0.d dVar = new s0.d(this.f3157q, nVar, i2);
        P(new c(dVar));
        return dVar.F();
    }

    public l T(int i2) {
        return P(new e(new s0.e(this.f3157q, i2)));
    }

    public l U() {
        return V((System.currentTimeMillis() / 1000) - 631065600, new BigDecimal(TimeZone.getDefault().getOffset(System.currentTimeMillis())).divide(new BigDecimal("900000"), 0, RoundingMode.HALF_UP).byteValueExact());
    }

    public l V(long j2, byte b3) {
        return P(new d(new s0.h(this.f3157q, this.E, j2, b3)));
    }

    public l W(s0.i iVar) {
        return P(new f(iVar));
    }

    public void Y(int i2, int i3) {
        this.B = i2;
        this.C = i3;
    }

    public void Z(int i2, int i3, int i4) {
        Y(i2, i3);
        this.D = i4;
    }

    @Override // u0.b
    public void d() {
        j.c cVar;
        RemoteException remoteException;
        s0.n nVar;
        l lVar;
        f();
        while (true) {
            try {
                cVar = this.f3396a.p().l();
            } catch (g.a e3) {
                h1.a.b(G, "ACFE requesting channel status: " + e3.toString());
                cVar = j.c.INVALID;
            }
            if (cVar != j.c.TRACKING && cVar != j.c.SEARCHING) {
                this.f3157q.a(k.NOT_CONNECTED, j.CONNECTION_LOST);
                return;
            }
            try {
                remoteException = null;
                nVar = (s0.n) this.f3159s.exchange(null, 10L, TimeUnit.SECONDS);
            } catch (InterruptedException unused) {
                return;
            } catch (TimeoutException unused2) {
            }
            if (nVar == null) {
                return;
            }
            try {
                this.f3163w = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
                lVar = nVar.run();
                this.f3164x = (int) Math.ceil((new Date().getTime() - this.f3163w.getTime().getTime()) / 1000.0d);
            } catch (RemoteException e4) {
                remoteException = e4;
                h1.a.b(G, "RemoteException running ANTFS task");
                this.f3157q.a(k.NOT_CONNECTED, j.CONNECTION_LOST);
                lVar = l.FAIL_OTHER_DEVICE_COMMUNICATION_ERROR;
            }
            try {
                try {
                    this.f3160t.exchange(lVar);
                } catch (InterruptedException unused3) {
                    this.f3160t.exchange(lVar);
                    Thread.currentThread().interrupt();
                }
                if (remoteException != null) {
                    throw remoteException;
                }
                if (this.f3162v == k.NOT_CONNECTED) {
                    l run = this.F.run();
                    h1.a.i(G, "ANT-FS host disconnected, result: " + run);
                    return;
                }
            } catch (InterruptedException unused4) {
                h1.a.b(G, "Double interrupt exchanging task result, catastrophic.");
                l lVar2 = l.SUCCESS;
                return;
            }
        }
    }

    @Override // u0.b
    public String k() {
        return "AntFsHostSession";
    }

    @Override // u0.b
    public void o() {
    }

    @Override // u0.b
    public void s() {
    }

    @Override // u0.b
    public void u(k.l lVar, AntMessageParcel antMessageParcel) {
        if (lVar == k.l.CHANNEL_EVENT && new k.g(antMessageParcel).j() == j.e.RX_SEARCH_TIMEOUT) {
            this.F.run();
        }
    }
}
