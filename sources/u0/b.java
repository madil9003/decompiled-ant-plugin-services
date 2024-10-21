package u0;

import android.os.Handler;
import android.os.RemoteException;
import com.dsi.ant.channel.AntChannel;
import com.dsi.ant.message.ipc.AntMessageParcel;
import j.c;
import j.e;
import j.k;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import k.l;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a */
    public AntChannel f3396a;

    /* renamed from: e */
    private CountDownLatch f3400e;

    /* renamed from: f */
    private CountDownLatch f3401f;

    /* renamed from: n */
    private Handler f3409n;

    /* renamed from: b */
    private final String f3397b = k().replaceAll(" ", "");

    /* renamed from: c */
    private boolean f3398c = false;

    /* renamed from: d */
    private boolean f3399d = false;

    /* renamed from: g */
    private final Object f3402g = new Object();

    /* renamed from: h */
    private boolean f3403h = false;

    /* renamed from: i */
    private b f3404i = null;

    /* renamed from: j */
    private Thread f3405j = null;

    /* renamed from: k */
    private b f3406k = null;

    /* renamed from: l */
    private b f3407l = null;

    /* renamed from: m */
    private boolean f3408m = false;

    /* renamed from: o */
    private final Object f3410o = new Object();

    /* renamed from: p */
    private final Runnable f3411p = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (b.this.f3410o) {
                if (b.this.f3405j != null && b.this.q(2147483645)) {
                    b.this.f3405j.interrupt();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: u0.b$b */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C0062b {

        /* renamed from: a */
        static final /* synthetic */ int[] f3413a;

        /* renamed from: b */
        static final /* synthetic */ int[] f3414b;

        static {
            int[] iArr = new int[e.values().length];
            f3414b = iArr;
            try {
                iArr[e.CHANNEL_CLOSED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3414b[e.RX_SEARCH_TIMEOUT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[l.values().length];
            f3413a = iArr2;
            try {
                iArr2[l.CHANNEL_RESPONSE.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3413a[l.ANT_VERSION.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3413a[l.CAPABILITIES.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3413a[l.CHANNEL_STATUS.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3413a[l.CHANNEL_ID.ordinal()] = 5;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f3413a[l.CHANNEL_EVENT.ordinal()] = 6;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    private void A() {
        b bVar = this.f3407l;
        if (bVar != null) {
            bVar.A();
            return;
        }
        synchronized (this.f3402g) {
            this.f3401f = new CountDownLatch(1);
            try {
                this.f3396a.n();
            } catch (g.a e3) {
                h1.a.b(this.f3397b, "AntChannelTask flushing msg pipe aborting, ant version command through ACFE unexpectedly: " + e3.toString());
            }
        }
        boolean interrupted = Thread.interrupted();
        try {
            CountDownLatch countDownLatch = this.f3401f;
            TimeUnit timeUnit = TimeUnit.SECONDS;
            if (!countDownLatch.await(3L, timeUnit)) {
                h1.a.b(this.f3397b, "Flush latch failed to signal");
            }
            if (!this.f3400e.await(3L, timeUnit)) {
                h1.a.b(this.f3397b, "Closing latch failed to signal");
            }
        } catch (InterruptedException unused) {
            h1.a.j(this.f3397b, "Waiting for close state on task cleanup interrupted unexpectedly");
        }
        if (interrupted) {
            Thread.currentThread().interrupt();
        }
    }

    private c g() {
        synchronized (this.f3400e) {
            synchronized (this.f3402g) {
                if (!this.f3398c) {
                    try {
                        c l2 = this.f3396a.p().l();
                        if (l2 != c.ASSIGNED && l2 != c.UNASSIGNED) {
                            this.f3398c = true;
                            if (this.f3400e.getCount() > 0) {
                                throw new RuntimeException("AntChannelTask has an active closingTransition in locked closing call");
                            }
                            this.f3400e = new CountDownLatch(1);
                            int i2 = 0;
                            while (true) {
                                try {
                                    this.f3396a.h();
                                    break;
                                } catch (g.a e3) {
                                    if (e3.a() == g.b.TRANSFER_IN_PROGRESS) {
                                        i2++;
                                        if (i2 > 27) {
                                            h1.a.b(this.f3397b, "Close() could not break TRANSFER_PROCESSING loop");
                                            throw new RemoteException();
                                        }
                                        Thread.sleep(100L);
                                    } else if (e3.a() != g.b.CHANNEL_RESPONSE || e3.b().k() != k.CHANNEL_IN_WRONG_STATE) {
                                        h1.a.b(this.f3397b, "ACFE in close call: " + e3.toString());
                                        throw new RemoteException();
                                    }
                                }
                            }
                        }
                        return l2;
                    } catch (g.a e4) {
                        h1.a.b(this.f3397b, "AntCommandFailedException in requestStatus call: " + e4.toString());
                        throw new RemoteException();
                    }
                }
                this.f3400e.await();
                return c.ASSIGNED;
            }
        }
    }

    private void v(l lVar, AntMessageParcel antMessageParcel) {
        synchronized (this.f3402g) {
            b bVar = this.f3406k;
            if (bVar != null) {
                bVar.v(lVar, antMessageParcel);
            } else if (this.f3403h) {
                u(lVar, antMessageParcel);
            }
        }
    }

    public void c() {
        synchronized (this.f3402g) {
            this.f3403h = false;
        }
    }

    public abstract void d();

    public void e(Long l2) {
        synchronized (this.f3410o) {
            this.f3405j = Thread.currentThread();
            if (l2 != null) {
                this.f3409n.postDelayed(this.f3411p, l2.longValue());
            }
        }
        d();
        c();
        synchronized (this.f3410o) {
            this.f3409n.removeCallbacks(this.f3411p);
            this.f3405j = null;
        }
        A();
        synchronized (this.f3402g) {
            this.f3396a = null;
        }
    }

    public void f() {
        synchronized (this.f3402g) {
            this.f3403h = true;
        }
    }

    public void h() {
        b bVar = this.f3407l;
        if (bVar != null) {
            bVar.h();
        } else {
            g();
        }
    }

    public void i() {
        b bVar = this.f3407l;
        if (bVar != null) {
            bVar.i();
            return;
        }
        if (g() == c.ASSIGNED) {
            synchronized (this.f3402g) {
                try {
                    try {
                        this.f3396a.E();
                    } catch (g.a e3) {
                        h1.a.b(this.f3397b, "ACFE in flushAndEnsureUnassignedChannel() unassign(): " + e3.toString());
                        try {
                            if (this.f3396a.p().l() == c.UNASSIGNED) {
                                h1.a.b(this.f3397b, "flushAndEnsureUnassignedChannel() recovered because state is already unassigned");
                                return;
                            }
                        } catch (g.a unused) {
                            h1.a.b(this.f3397b, "ACFE in flushAndEnsureUnassignedChannel() recovery getStatus() call: " + e3.toString());
                        }
                        throw new RemoteException();
                    }
                } finally {
                }
            }
        }
    }

    public b j() {
        return this.f3404i;
    }

    public abstract String k();

    public String l() {
        b bVar = this.f3407l;
        if (bVar == null) {
            return k();
        }
        return k() + " -> subtask of " + bVar.l();
    }

    public int m() {
        return 0;
    }

    public int n() {
        b bVar = this.f3406k;
        return bVar != null ? Math.max(bVar.n(), m()) : m();
    }

    public abstract void o();

    public boolean p(int i2) {
        return false;
    }

    public boolean q(int i2) {
        if (i2 != Integer.MAX_VALUE) {
            synchronized (this.f3402g) {
                b bVar = this.f3406k;
                if (bVar != null) {
                    this.f3408m = bVar.p(i2);
                } else {
                    this.f3408m = true;
                }
            }
            return this.f3408m && p(i2);
        }
        synchronized (this.f3402g) {
            b bVar2 = this.f3406k;
            if (bVar2 != null) {
                this.f3408m = true;
                bVar2.q(i2);
            }
        }
        o();
        return true;
    }

    void r(AntChannel antChannel, b bVar, Handler handler) {
        synchronized (this.f3410o) {
            this.f3409n = handler;
        }
        synchronized (this.f3402g) {
            this.f3396a = antChannel;
            this.f3407l = bVar;
            this.f3403h = false;
            this.f3406k = null;
            this.f3408m = false;
        }
        s();
    }

    public abstract void s();

    public void t(AntChannel antChannel, Handler handler) {
        synchronized (this.f3410o) {
            this.f3409n = handler;
        }
        synchronized (this.f3402g) {
            this.f3396a = antChannel;
            this.f3398c = false;
            this.f3399d = false;
            this.f3400e = new CountDownLatch(0);
            this.f3401f = new CountDownLatch(0);
            this.f3403h = false;
            this.f3406k = null;
            this.f3408m = false;
            this.f3407l = null;
        }
        s();
    }

    public abstract void u(l lVar, AntMessageParcel antMessageParcel);

    /* JADX WARN: Failed to find 'out' block for switch in B:30:0x007b. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009d A[Catch: all -> 0x0169, TRY_LEAVE, TryCatch #2 {, blocks: (B:4:0x0003, B:6:0x0007, B:7:0x000c, B:9:0x0010, B:12:0x0012, B:14:0x0019, B:16:0x001d, B:18:0x0023, B:20:0x0030, B:22:0x0034, B:23:0x006b, B:25:0x006d, B:27:0x006f, B:29:0x0073, B:30:0x007b, B:32:0x0099, B:34:0x009d, B:36:0x009f, B:39:0x00a6, B:40:0x00ca, B:41:0x00cb, B:43:0x007f, B:45:0x008c, B:47:0x0090, B:48:0x0164, B:49:0x0167, B:51:0x00cd, B:56:0x00dc, B:60:0x00f2, B:61:0x00f5, B:62:0x00fd, B:64:0x010a, B:66:0x0112, B:68:0x0127, B:70:0x0130, B:73:0x0137, B:74:0x015b, B:75:0x015c, B:76:0x0163), top: B:3:0x0003, inners: #0, #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void w(k.l r8, com.dsi.ant.message.ipc.AntMessageParcel r9) {
        /*
            Method dump skipped, instructions count: 380
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: u0.b.w(k.l, com.dsi.ant.message.ipc.AntMessageParcel):void");
    }

    public void x(b bVar) {
        y(bVar, null);
    }

    public void y(b bVar, Long l2) {
        if (!Thread.currentThread().equals(this.f3405j)) {
            h1.a.b(this.f3397b, "runSubTask() called on thread other than doWork() thread");
            throw new IllegalStateException();
        }
        while (bVar != null) {
            bVar.r(this.f3396a, this, this.f3409n);
            synchronized (this.f3402g) {
                this.f3406k = bVar;
            }
            h1.a.a(this.f3397b, "Begin doWork() in " + this.f3406k.l());
            this.f3406k.e(l2);
            h1.a.a(this.f3397b, "End doWork() in " + this.f3406k.l());
            if (this.f3408m) {
                Thread.currentThread().interrupt();
                bVar = null;
            } else {
                bVar = this.f3406k.j();
            }
        }
        synchronized (this.f3402g) {
            this.f3406k = null;
        }
    }

    public void z(b bVar) {
        this.f3404i = bVar;
    }
}
