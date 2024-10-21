package u0;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.RemoteException;
import com.dsi.ant.channel.AntChannel;
import com.dsi.ant.message.ipc.AntMessageParcel;
import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import k.l;

/* loaded from: classes.dex */
public class a {

    /* renamed from: p */
    private static final String f3374p = "a";

    /* renamed from: q */
    private static final AtomicInteger f3375q = new AtomicInteger();

    /* renamed from: a */
    private final int f3376a;

    /* renamed from: b */
    private AntChannel f3377b;

    /* renamed from: c */
    private c f3378c;

    /* renamed from: d */
    private boolean f3379d;

    /* renamed from: e */
    private final Object f3380e;

    /* renamed from: f */
    private u0.b f3381f;

    /* renamed from: g */
    private Thread f3382g;

    /* renamed from: h */
    private boolean f3383h;

    /* renamed from: i */
    private final Object f3384i;

    /* renamed from: j */
    private d f3385j;

    /* renamed from: k */
    private final Exchanger f3386k;

    /* renamed from: l */
    private final Object f3387l;

    /* renamed from: m */
    private boolean f3388m;

    /* renamed from: n */
    private final HandlerThread f3389n;

    /* renamed from: o */
    private final Handler f3390o;

    /* renamed from: u0.a$a */
    /* loaded from: classes.dex */
    public class C0061a implements g.d {
        C0061a() {
        }

        @Override // g.d
        public void a(l lVar, AntMessageParcel antMessageParcel) {
            u0.b bVar;
            synchronized (a.this.f3387l) {
                bVar = a.this.f3385j != null ? a.this.f3385j.f3393a : null;
            }
            if (bVar != null) {
                try {
                    bVar.w(lVar, antMessageParcel);
                } catch (RemoteException unused) {
                    a.this.q("RemoteException in " + bVar.l() + " handleMessage()");
                }
            }
        }

        @Override // g.d
        public void b() {
            a.this.q("AntChannel fired OnChannelDeath()");
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        b() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x0079, code lost:            u0.a.this.f3385j = null;     */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x0082, code lost:            h1.a.a(u0.a.f3374p, "Begin doWork() in " + u0.a.this.f3385j.f3393a.l());        u0.a.this.f3385j.f3393a.e(u0.a.this.f3385j.f3394b);        h1.a.a(u0.a.f3374p, "End doWork() in " + u0.a.this.f3385j.f3393a.l());        r0 = u0.a.this.f3387l;     */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x00e3, code lost:            monitor-enter(r0);     */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x00e4, code lost:            java.lang.Thread.interrupted();     */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x00ed, code lost:            if (u0.a.this.f3388m == false) goto L122;     */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x00ef, code lost:            u0.a.this.f3388m = false;        u0.a.this.f3385j = null;     */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x011b, code lost:            if (u0.a.this.f3385j != null) goto L131;     */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x0120, code lost:            u0.a.this.f3385j.f3393a.t(u0.a.this.f3377b, u0.a.this.f3390o);     */
        /* JADX WARN: Code restructure failed: missing block: B:53:0x013d, code lost:            if (u0.a.this.f3383h == false) goto L136;     */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x014b, code lost:            if (u0.a.this.f3385j.f3393a.q(Integer.MAX_VALUE) == false) goto L136;     */
        /* JADX WARN: Code restructure failed: missing block: B:57:0x014d, code lost:            u0.a.this.f3385j = null;     */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x011d, code lost:            monitor-exit(r0);     */
        /* JADX WARN: Code restructure failed: missing block: B:62:0x0153, code lost:            monitor-exit(r0);     */
        /* JADX WARN: Code restructure failed: missing block: B:65:0x00fb, code lost:            r3 = u0.a.this.f3385j.f3393a.j();        r4 = u0.a.this;     */
        /* JADX WARN: Code restructure failed: missing block: B:66:0x0109, code lost:            if (r3 != null) goto L125;     */
        /* JADX WARN: Code restructure failed: missing block: B:67:0x010b, code lost:            r5 = null;     */
        /* JADX WARN: Code restructure failed: missing block: B:68:0x0112, code lost:            r4.f3385j = r5;     */
        /* JADX WARN: Code restructure failed: missing block: B:69:0x010d, code lost:            r5 = new u0.a.d(r4, r3, null);     */
        /* JADX WARN: Code restructure failed: missing block: B:75:0x0159, code lost:            r0 = u0.a.this;        r3 = "RemoteException occured executing DoWork() in task: " + u0.a.this.f3385j.f3393a.l();     */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0193 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                Method dump skipped, instructions count: 459
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: u0.a.b.run():void");
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        void a();
    }

    /* loaded from: classes.dex */
    public final class d {

        /* renamed from: a */
        final u0.b f3393a;

        /* renamed from: b */
        final Long f3394b;

        public d(u0.b bVar, Long l2) {
            this.f3393a = bVar;
            this.f3394b = l2;
        }
    }

    public a(AntChannel antChannel, c cVar) {
        int incrementAndGet = f3375q.incrementAndGet();
        this.f3376a = incrementAndGet;
        this.f3379d = false;
        this.f3380e = new Object();
        this.f3383h = false;
        this.f3384i = new Object();
        this.f3386k = new Exchanger();
        this.f3387l = new Object();
        HandlerThread handlerThread = new HandlerThread("AntChannelExecutor-" + incrementAndGet + "-timeout-handler");
        this.f3389n = handlerThread;
        handlerThread.start();
        this.f3390o = new Handler(handlerThread.getLooper());
        this.f3378c = cVar;
        o(antChannel);
    }

    private boolean p() {
        Thread thread = this.f3382g;
        return thread == null || !thread.isAlive();
    }

    public void q(String str) {
        h1.a.b(f3374p, "Executor Dying: " + str);
        synchronized (this.f3380e) {
            if (!this.f3379d) {
                t(true);
                this.f3378c.a();
            }
        }
    }

    private boolean r(int i2) {
        synchronized (this.f3387l) {
            d dVar = this.f3385j;
            if (dVar == null) {
                return true;
            }
            this.f3388m = true;
            if (dVar.f3393a.q(i2)) {
                this.f3382g.interrupt();
                return true;
            }
            this.f3388m = false;
            return false;
        }
    }

    private void w() {
        if (this.f3379d) {
            throw new IllegalStateException("Attempting to start worker thread on dead executor");
        }
        this.f3383h = false;
        Thread thread = new Thread(new b(), "AntChannelExecutor-" + this.f3376a + "-worker");
        this.f3382g = thread;
        thread.start();
    }

    public boolean n(int i2) {
        if (p()) {
            return true;
        }
        synchronized (this.f3387l) {
            if (this.f3385j == null) {
                return true;
            }
            if (!r(2147483646)) {
                return false;
            }
            try {
                this.f3386k.exchange(null, i2, TimeUnit.MILLISECONDS);
                return true;
            } catch (TimeoutException unused) {
                return false;
            }
        }
    }

    protected void o(AntChannel antChannel) {
        this.f3377b = antChannel;
        antChannel.t(new C0061a());
        w();
    }

    public void s(u0.b bVar) {
        synchronized (this.f3387l) {
            if (p()) {
                this.f3381f = bVar;
                return;
            }
            u0.b bVar2 = this.f3381f;
            if (bVar2 == null || this.f3385j.f3393a != bVar2) {
                this.f3381f = bVar;
                if (this.f3385j == null && bVar != null) {
                    try {
                        this.f3386k.exchange(new d(bVar, null));
                    } catch (InterruptedException unused) {
                        h1.a.b(f3374p, "InterruptedException trying to start idleTask");
                        Thread.currentThread().interrupt();
                    }
                }
            } else {
                this.f3381f = bVar;
                if (bVar == null) {
                    r(2147483646);
                } else {
                    r(bVar.m());
                }
            }
        }
    }

    public AntChannel t(boolean z2) {
        if (!z2 && Thread.currentThread() == this.f3382g) {
            throw new IllegalArgumentException("Cannot shutdown executor and get its channel on its own worker thread.");
        }
        synchronized (this.f3384i) {
            if (this.f3379d) {
                return null;
            }
            this.f3379d = true;
            this.f3383h = true;
            if (!p() && this.f3382g != Thread.currentThread()) {
                synchronized (this.f3387l) {
                    if (this.f3385j != null) {
                        r(Integer.MAX_VALUE);
                    } else {
                        this.f3382g.interrupt();
                    }
                }
                try {
                    this.f3382g.join(3000L);
                } catch (InterruptedException unused) {
                    h1.a.b(f3374p, "InterruptedException while waiting for task thread to close.");
                    Thread.currentThread().interrupt();
                }
                if (!p()) {
                    h1.a.a(f3374p, "Task not shutting down gracefully, forcing channel release");
                    z2 = true;
                }
            }
            this.f3389n.quit();
            try {
                this.f3389n.join();
            } catch (InterruptedException unused2) {
                h1.a.j(f3374p, "Interrupted while waiting for timeout handler to shutdown.");
            }
            if (!z2) {
                try {
                    this.f3377b.g();
                } catch (RemoteException unused3) {
                    h1.a.b(f3374p, "RemoteException trying to clear handler in cleanShutdown()");
                }
                return this.f3377b;
            }
            this.f3377b.m();
            this.f3377b = null;
            return this.f3377b;
        }
    }

    public boolean u(u0.b bVar, int i2) {
        return v(bVar, i2, null);
    }

    public boolean v(u0.b bVar, int i2, Long l2) {
        if (bVar == null) {
            throw new NullPointerException("Task parameter was null");
        }
        if (p()) {
            throw new IllegalStateException("Worker thread is not running");
        }
        synchronized (this.f3386k) {
            synchronized (this.f3387l) {
                if (this.f3385j == null) {
                    i2 = 100;
                } else if (!r(bVar.n())) {
                    return false;
                }
                try {
                    this.f3386k.exchange(new d(bVar, l2), i2, TimeUnit.MILLISECONDS);
                    if (!this.f3383h) {
                        return true;
                    }
                    h1.a.a(f3374p, "Executor shutdown while trying to start task.");
                    return false;
                } catch (TimeoutException unused) {
                    h1.a.a(f3374p, "Timeout trying to start task, waited " + i2 + "ms");
                    return false;
                }
            }
        }
    }
}
