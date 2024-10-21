package y0;

import android.os.RemoteException;
import com.dsi.ant.message.ipc.AntMessageParcel;
import j.d;
import j.e;
import j.i;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.CountDownLatch;
import k.g;
import k.l;
import s0.j;
import w.c;
import x0.a;
import x0.b;

/* loaded from: classes.dex */
public class a extends u0.b {

    /* renamed from: w */
    private static final String f3590w = "a";

    /* renamed from: q */
    private final x0.b f3591q;

    /* renamed from: r */
    boolean f3592r;

    /* renamed from: s */
    Object f3593s = new Object();

    /* renamed from: t */
    CountDownLatch f3594t;

    /* renamed from: u */
    int f3595u;

    /* renamed from: v */
    LinkedList f3596v;

    /* renamed from: y0.a$a */
    /* loaded from: classes.dex */
    static /* synthetic */ class C0069a {

        /* renamed from: a */
        static final /* synthetic */ int[] f3597a;

        /* renamed from: b */
        static final /* synthetic */ int[] f3598b;

        static {
            int[] iArr = new int[l.values().length];
            f3598b = iArr;
            try {
                iArr[l.CHANNEL_EVENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3598b[l.BROADCAST_DATA.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3598b[l.ACKNOWLEDGED_DATA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[e.values().length];
            f3597a = iArr2;
            try {
                iArr2[e.RX_SEARCH_TIMEOUT.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3597a[e.CHANNEL_CLOSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a */
        public j.b f3599a;

        public b(j.b bVar) {
            this.f3599a = bVar;
        }
    }

    public a(x0.b bVar) {
        this.f3591q = bVar;
    }

    private void B(j.b bVar) {
        int i2 = this.f3595u + 1;
        this.f3595u = i2;
        if (i2 > 3) {
            this.f3595u = 0;
            this.f3596v.removeLast();
        }
        this.f3596v.addFirst(new b(bVar));
        this.f3396a.b(bVar, this.f3595u);
        if (this.f3596v.size() < 4) {
            this.f3396a.i(this.f3596v.size(), true);
        } else {
            this.f3596v.removeLast();
        }
        h1.a.i(f3590w, "IE list using " + this.f3596v.size() + " devices");
    }

    private void C() {
        try {
            if (this.f3596v.size() > 0) {
                this.f3396a.i(0, true);
            }
        } catch (g.a e3) {
            h1.a.b(f3590w, "ACFE trying to clear IE list: " + e3.toString());
            throw new RemoteException();
        }
    }

    private void D() {
        long j2;
        a.C0067a c0067a;
        this.f3595u = -1;
        this.f3596v = new LinkedList();
        h1.a.i(f3590w, "IE list init - current devs: (ID, time, DlFinish) ");
        synchronized (this.f3591q.f3568l.f3557c) {
            Iterator it = this.f3591q.f3568l.f3557c.iterator();
            while (it.hasNext()) {
                a.C0067a c0067a2 = (a.C0067a) it.next();
                h1.a.i(f3590w, "   " + c0067a2.f3558a.a() + ", " + c0067a2.a());
            }
        }
        this.f3596v.clear();
        long j3 = -1;
        while (this.f3596v.size() < 4) {
            synchronized (this.f3591q.f3568l.f3557c) {
                Iterator it2 = this.f3591q.f3568l.f3557c.iterator();
                j2 = 10000;
                c0067a = null;
                while (it2.hasNext()) {
                    a.C0067a c0067a3 = (a.C0067a) it2.next();
                    long a3 = c0067a3.a();
                    if (a3 > j3 && a3 < j2) {
                        c0067a = c0067a3;
                        j2 = a3;
                    }
                }
            }
            if (c0067a == null) {
                break;
            }
            this.f3596v.addFirst(new b(c0067a.f3558a));
            if (this.f3592r) {
                return;
            } else {
                j3 = j2;
            }
        }
        Iterator it3 = this.f3596v.iterator();
        while (it3.hasNext()) {
            b bVar = (b) it3.next();
            int i2 = this.f3595u + 1;
            this.f3595u = i2;
            this.f3396a.b(bVar.f3599a, i2);
            if (this.f3592r) {
                return;
            }
        }
        this.f3396a.i(this.f3596v.size(), true);
    }

    @Override // u0.b
    public void d() {
        this.f3591q.k(2);
        try {
            i();
            if (!this.f3592r) {
                this.f3396a.c(d.BIDIRECTIONAL_SLAVE);
                this.f3396a.z(50);
                this.f3396a.x(8192);
                this.f3396a.A(i.FIFTEEN_SECONDS);
            }
            D();
            while (!this.f3592r) {
                h();
                synchronized (this.f3593s) {
                    this.f3594t = new CountDownLatch(1);
                }
                if (this.f3592r) {
                    break;
                }
                int i2 = 0;
                this.f3396a.u(new j.b(0, 0, 0));
                f();
                this.f3396a.l();
                if (this.f3592r) {
                    break;
                }
                this.f3594t.await();
                if (this.f3592r) {
                    break;
                }
                synchronized (this.f3591q.f3568l.f3557c) {
                    while (i2 < this.f3591q.f3568l.f3557c.size()) {
                        a.C0067a c0067a = (a.C0067a) this.f3591q.f3568l.f3557c.get(i2);
                        if (c0067a.a() > 90000) {
                            this.f3591q.f3568l.b(c0067a);
                            i2--;
                        }
                        i2++;
                    }
                }
            }
        } catch (g.a e3) {
            h1.a.b(f3590w, "ACFE handling message: " + e3.toString());
            this.f3396a.m();
            throw new RemoteException();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
        C();
        this.f3591q.f3567k.close();
    }

    @Override // u0.b
    public String k() {
        return "ANTFS Watch Scan";
    }

    @Override // u0.b
    public void o() {
        p(Integer.MAX_VALUE);
    }

    @Override // u0.b
    public boolean p(int i2) {
        c();
        synchronized (this.f3593s) {
            this.f3592r = true;
            CountDownLatch countDownLatch = this.f3594t;
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
        }
        return true;
    }

    @Override // u0.b
    public void s() {
        this.f3591q.f3567k.b();
        this.f3592r = false;
        z(null);
    }

    @Override // u0.b
    public void u(l lVar, AntMessageParcel antMessageParcel) {
        CountDownLatch countDownLatch;
        b.C0068b c0068b;
        try {
            int i2 = C0069a.f3598b[lVar.ordinal()];
            if (i2 == 1) {
                int i3 = C0069a.f3597a[new g(antMessageParcel).j().ordinal()];
                if (i3 == 1) {
                    h1.a.b(f3590w, "Search timeout occured");
                    return;
                } else {
                    if (i3 != 2) {
                        return;
                    }
                    h1.a.b(f3590w, "Channel closed");
                    this.f3396a.u(new j.b(0, 0, 0));
                    this.f3396a.l();
                    return;
                }
            }
            if (i2 == 2 || i2 == 3) {
                j.b j2 = this.f3396a.o().j();
                B(j2);
                if (c.i(antMessageParcel.a()[1]) == 67) {
                    a.C0067a c3 = this.f3591q.f3568l.c(j2, antMessageParcel.a(), this.f3591q.f3567k);
                    if (c3 != null && (c0068b = (b.C0068b) this.f3591q.f3569m.get(c3.f3562e.c())) != null) {
                        if (j.d(antMessageParcel.a())) {
                            c0068b.n();
                        }
                        c0068b.l();
                    }
                    c();
                    countDownLatch = this.f3594t;
                } else {
                    h1.a.a(f3590w, "Message not a beacon, ignoring");
                    c();
                    countDownLatch = this.f3594t;
                }
                countDownLatch.countDown();
            }
        } catch (g.a e3) {
            h1.a.b(f3590w, "ACFE handling message: " + e3.toString());
            this.f3396a.m();
            throw new RemoteException();
        }
    }
}
