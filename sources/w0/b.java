package w0;

import android.os.RemoteException;
import com.dsi.ant.channel.AntChannel;
import com.dsi.ant.message.LibConfig;
import com.dsi.ant.message.ipc.AntMessageParcel;
import com.dsi.ant.plugins.antplus.utility.search.SearchResultInfo;
import j.e;
import j.i;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
import k.g;
import k.k;
import k.l;

/* loaded from: classes.dex */
public class b extends u0.b {

    /* renamed from: z */
    private static final String f3492z = "b";

    /* renamed from: q */
    private final C0065b f3493q;

    /* renamed from: r */
    private final w0.d f3494r;

    /* renamed from: s */
    private final d f3495s;

    /* renamed from: t */
    private CountDownLatch f3496t;

    /* renamed from: u */
    private SearchResultInfo f3497u;

    /* renamed from: v */
    private k f3498v;

    /* renamed from: w */
    private boolean f3499w;

    /* renamed from: x */
    private boolean f3500x;

    /* renamed from: y */
    private AtomicReference f3501y;

    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a */
        static final /* synthetic */ int[] f3502a;

        /* renamed from: b */
        static final /* synthetic */ int[] f3503b;

        static {
            int[] iArr = new int[l.values().length];
            f3503b = iArr;
            try {
                iArr[l.ACKNOWLEDGED_DATA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3503b[l.BROADCAST_DATA.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3503b[l.CHANNEL_EVENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[c.values().length];
            f3502a = iArr2;
            try {
                iArr2[c.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3502a[c.FILTERED.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* renamed from: w0.b$b */
    /* loaded from: classes.dex */
    public static class C0065b {

        /* renamed from: a */
        public j.b f3504a;

        /* renamed from: b */
        public int f3505b;

        /* renamed from: c */
        public int f3506c;

        /* renamed from: d */
        public int f3507d;

        /* renamed from: e */
        public i f3508e;
    }

    /* loaded from: classes.dex */
    public enum c {
        SUCCESS,
        TIME_OUT,
        FILTERED,
        INTERRUPTED,
        EXECUTOR_SHUTDOWN
    }

    /* loaded from: classes.dex */
    public interface d {
        void a(c cVar, SearchResultInfo searchResultInfo);
    }

    public b(C0065b c0065b, d dVar) {
        this(c0065b, null, dVar);
    }

    private void E(c cVar) {
        c();
        w0.a.a(this.f3501y, null, cVar);
        this.f3496t.countDown();
    }

    public void B() {
        this.f3499w = true;
    }

    public void C(int i2) {
        if (i2 < 0 || i2 > 10) {
            throw new IllegalArgumentException("Proximity threshold must be in the range 0-10");
        }
        this.f3493q.f3507d = i2;
        AntChannel antChannel = this.f3396a;
        if (antChannel != null) {
            try {
                antChannel.y(i2);
            } catch (RemoteException | g.a unused) {
            }
        }
    }

    public void D() {
        this.f3500x = true;
    }

    @Override // u0.b
    public void d() {
        try {
            try {
                if (this.f3500x) {
                    i();
                    this.f3396a.c(j.d.BIDIRECTIONAL_SLAVE);
                    this.f3396a.i(0, true);
                    LibConfig libConfig = new LibConfig();
                    libConfig.d(true);
                    this.f3396a.r(libConfig);
                    this.f3500x = false;
                } else {
                    h();
                }
                this.f3396a.u(this.f3493q.f3504a);
                this.f3396a.z(this.f3493q.f3505b);
                this.f3396a.x(this.f3493q.f3506c);
                this.f3396a.y(this.f3493q.f3507d);
                this.f3396a.A(this.f3493q.f3508e);
                String str = f3492z;
                h1.a.a(str, "Starting search for: " + this.f3493q.f3504a.toString());
                f();
                this.f3396a.l();
                this.f3496t.await();
                if (this.f3501y.get() == c.SUCCESS) {
                    this.f3497u.f976a = this.f3396a.o().j();
                    h1.a.a(str, "Search successful. Tracking: " + this.f3497u.f976a.toString());
                    if (this.f3494r != null && !Thread.currentThread().isInterrupted()) {
                        this.f3494r.B(this, this.f3498v, this.f3497u);
                        x(this.f3494r);
                    }
                } else {
                    h1.a.a(str, "Search unsuccessful, result: " + this.f3501y.get() + " for " + this.f3493q.f3504a.toString());
                }
            } catch (g.a e3) {
                h1.a.c(f3492z, "Problem using channel to search", e3);
                throw new RemoteException();
            } catch (InterruptedException unused) {
                E(c.INTERRUPTED);
                Thread.currentThread().interrupt();
            }
            c();
            c cVar = (c) this.f3501y.get();
            int i2 = a.f3502a[cVar.ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    this.f3495s.a(cVar, null);
                    return;
                }
            } else if (this.f3499w) {
                cVar = c.FILTERED;
            }
            if (Thread.currentThread().isInterrupted()) {
                this.f3495s.a(c.INTERRUPTED, null);
            } else {
                this.f3495s.a(cVar, this.f3497u);
            }
        } catch (Throwable th) {
            c();
            throw th;
        }
    }

    @Override // u0.b
    public String k() {
        return "Search Task";
    }

    @Override // u0.b
    public void o() {
        E(c.EXECUTOR_SHUTDOWN);
    }

    @Override // u0.b
    public boolean p(int i2) {
        E(c.INTERRUPTED);
        return true;
    }

    @Override // u0.b
    public void s() {
        this.f3496t = new CountDownLatch(1);
        this.f3497u = null;
        this.f3498v = null;
        this.f3499w = false;
        this.f3501y = new AtomicReference();
    }

    @Override // u0.b
    public void u(l lVar, AntMessageParcel antMessageParcel) {
        c cVar;
        int i2 = a.f3503b[lVar.ordinal()];
        if (i2 == 1 || i2 == 2) {
            this.f3498v = (k) k.b.e(antMessageParcel);
            SearchResultInfo searchResultInfo = new SearchResultInfo();
            this.f3497u = searchResultInfo;
            searchResultInfo.f977b = this.f3498v.j().a();
            cVar = c.SUCCESS;
        } else {
            if (i2 != 3) {
                return;
            }
            g gVar = new g(antMessageParcel);
            if (gVar.j() != e.RX_SEARCH_TIMEOUT && gVar.j() != e.CHANNEL_CLOSED) {
                return;
            } else {
                cVar = c.TIME_OUT;
            }
        }
        E(cVar);
    }

    public b(C0065b c0065b, w0.d dVar, d dVar2) {
        C0065b c0065b2 = new C0065b();
        this.f3493q = c0065b2;
        j.b bVar = c0065b.f3504a;
        if (bVar == null) {
            throw new IllegalArgumentException("Channel ID cannot be null.");
        }
        c0065b2.f3504a = new j.b(bVar.a(), c0065b.f3504a.b(), c0065b.f3504a.e(), c0065b.f3504a.d());
        int i2 = c0065b.f3505b;
        if (i2 < 0 || i2 > 124) {
            throw new IllegalArgumentException("Selected radio frequency must be in the range 0-124");
        }
        c0065b2.f3505b = i2;
        int i3 = c0065b.f3506c;
        if (i3 < 0 || i3 > 65535) {
            throw new IllegalArgumentException("Selected channel period must be in the range 0-65535");
        }
        c0065b2.f3506c = i3;
        int i4 = c0065b.f3507d;
        if (i4 < 0 || i4 > 10) {
            throw new IllegalArgumentException("Proximity threshold must be in the range 0-10");
        }
        c0065b2.f3507d = i4;
        c0065b2.f3508e = c0065b.f3508e;
        this.f3494r = dVar;
        if (dVar2 == null) {
            throw new IllegalArgumentException("The result receiver must not be null.");
        }
        this.f3495s = dVar2;
    }
}
