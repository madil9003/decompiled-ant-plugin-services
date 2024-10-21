package t;

import android.os.Bundle;
import android.os.Message;
import com.dsi.ant.plugins.antplus.common.FitFileCommon;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.zip.DataFormatException;
import s0.a;
import s0.g;
import v.e;

/* loaded from: classes.dex */
public class d {

    /* renamed from: i */
    private static final String f3335i = "d";

    /* renamed from: a */
    final c f3336a;

    /* renamed from: b */
    final u0.a f3337b;

    /* renamed from: c */
    final t.c f3338c;

    /* renamed from: d */
    final long f3339d;

    /* renamed from: e */
    final int f3340e;

    /* renamed from: f */
    final int f3341f;

    /* renamed from: g */
    final int f3342g;

    /* renamed from: h */
    final int f3343h;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a */
        static final /* synthetic */ int[] f3344a;

        /* renamed from: b */
        static final /* synthetic */ int[] f3345b;

        static {
            int[] iArr = new int[g.l.values().length];
            f3345b = iArr;
            try {
                iArr[g.l.FAIL_NOT_SUPPORTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3345b[g.l.FAIL_AUTHENTICATION_REJECTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3345b[g.l.FAIL_DEVICE_TRANSMISSION_LOST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[g.k.values().length];
            f3344a = iArr2;
            try {
                iArr2[g.k.AUTH_IDLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3344a[g.k.AUTH_WAITING_FOR_PAIRING.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3344a[g.k.NOT_CONNECTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: a */
        g f3346a;

        /* renamed from: b */
        g.m f3347b = new a();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class a implements g.m {
            a() {
            }

            @Override // s0.g.m
            public void a(g.k kVar, g.j jVar) {
                int i2 = a.f3344a[kVar.ordinal()];
                if (i2 == 1) {
                    b.this.d(500, 0L, 0L);
                } else {
                    if (i2 != 2) {
                        return;
                    }
                    b.this.d(550, 0L, 0L);
                }
            }
        }

        /* renamed from: t.d$b$b */
        /* loaded from: classes.dex */
        public class C0057b implements g.n {
            C0057b() {
            }

            @Override // s0.g.n
            public void a(long j2, long j3) {
            }
        }

        b() {
        }

        private boolean a(g.i iVar) {
            if (iVar == g.i.SUCCESS) {
                return false;
            }
            h1.a.b(d.f3335i, "ANTFS download request failed, code: " + iVar);
            d.this.b(-40);
            return true;
        }

        private boolean b(g.l lVar) {
            if (lVar == g.l.SUCCESS) {
                return false;
            }
            h1.a.b(d.f3335i, "ANTFS request failed, code: " + lVar);
            int i2 = a.f3345b[lVar.ordinal()];
            d.this.b(i2 != 1 ? i2 != 2 ? i2 != 3 ? -40 : -41 : -1040 : -61);
            return true;
        }

        private boolean c() {
            d(800, 0L, 0L);
            if (a(this.f3346a.S(0, new C0057b()))) {
                return false;
            }
            try {
                s0.a aVar = new s0.a(this.f3346a.M(), this.f3346a.O());
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < aVar.f3076b.size(); i2++) {
                    a.b bVar = (a.b) aVar.f3076b.valueAt(i2);
                    if (bVar.f3085b == FitFileCommon.a.FIT_DATA_TYPE.b()) {
                        arrayList.add(Integer.valueOf(bVar.f3084a));
                    }
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    if (b(this.f3346a.T(((Integer) it.next()).intValue()))) {
                        return false;
                    }
                }
                return true;
            } catch (DataFormatException e3) {
                h1.a.b(d.f3335i, "ANTFS directory DataFormatException: " + e3.getMessage());
                d.this.b(-40);
                return false;
            }
        }

        protected void d(int i2, long j2, long j3) {
            d.this.f3336a.a(i2, j2, j3);
        }

        @Override // java.lang.Runnable
        public void run() {
            g.l Q;
            g.l lVar;
            g.m mVar = this.f3347b;
            d dVar = d.this;
            g gVar = new g(mVar, dVar.f3339d, dVar.f3340e);
            this.f3346a = gVar;
            d dVar2 = d.this;
            gVar.Z(dVar2.f3341f, dVar2.f3342g, dVar2.f3343h);
            try {
                if (!d.this.f3337b.u(this.f3346a, 1000)) {
                    d.this.b(-20);
                    return;
                }
                try {
                    d(100, 0L, 0L);
                    if (b(this.f3346a.R(d.this.f3338c))) {
                        if (Q != lVar) {
                            return;
                        } else {
                            return;
                        }
                    }
                    d(800, 0L, 0L);
                    if (!c()) {
                        if (this.f3346a.Q() != g.l.SUCCESS) {
                            h1.a.j(d.f3335i, "DownloadMeasurements Failed to close ANTFS session.");
                        }
                    } else if (d.this.f3336a.f3353c && b(this.f3346a.U())) {
                        if (this.f3346a.Q() != g.l.SUCCESS) {
                            h1.a.j(d.f3335i, "DownloadMeasurements Failed to close ANTFS session.");
                        }
                    } else {
                        d.this.f3336a.b(0);
                        if (this.f3346a.Q() != g.l.SUCCESS) {
                            h1.a.j(d.f3335i, "DownloadMeasurements Failed to close ANTFS session.");
                        }
                    }
                } finally {
                    if (this.f3346a.Q() != g.l.SUCCESS) {
                        h1.a.j(d.f3335i, "DownloadMeasurements Failed to close ANTFS session.");
                    }
                }
            } catch (InterruptedException unused) {
                h1.a.b(d.f3335i, "ANTFS request InterruptedException");
                d.this.b(-40);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a */
        public e.a f3351a;

        /* renamed from: b */
        public final boolean f3352b;

        /* renamed from: c */
        public final boolean f3353c;

        /* renamed from: d */
        t.a f3354d;

        /* renamed from: e */
        Object f3355e = new Object();

        /* renamed from: f */
        public boolean f3356f = false;

        public c(e.a aVar, boolean z2, boolean z3, t.a aVar2) {
            this.f3351a = aVar;
            this.f3353c = z2;
            this.f3352b = z3;
            this.f3354d = aVar2;
        }

        public void a(int i2, long j2, long j3) {
            synchronized (this.f3355e) {
                if (this.f3356f) {
                    h1.a.a(d.f3335i, "Download Measurement ANTFS state message sent after finished sent: " + i2);
                } else {
                    Bundle bundle = new Bundle();
                    bundle.putInt("int_stateCode", i2);
                    bundle.putLong("long_transferredBytes", j2);
                    bundle.putLong("long_totalBytes", j3);
                    Message obtain = Message.obtain();
                    obtain.what = 1;
                    obtain.arg1 = 190;
                    obtain.setData(bundle);
                    this.f3354d.j(this.f3351a, obtain);
                }
            }
        }

        public void b(int i2) {
            synchronized (this.f3355e) {
                if (this.f3356f) {
                    h1.a.a(d.f3335i, "ResetDataAndSetTime extraneous result sent: " + i2);
                } else {
                    Bundle bundle = new Bundle();
                    bundle.putInt("int_statusCode", i2);
                    Message obtain = Message.obtain();
                    obtain.what = 1;
                    obtain.arg1 = 206;
                    obtain.setData(bundle);
                    this.f3354d.j(this.f3351a, obtain);
                    this.f3356f = true;
                }
            }
        }
    }

    public d(c cVar, u0.a aVar, t.c cVar2, long j2, int i2, int i3, int i4, int i5) {
        this.f3336a = cVar;
        this.f3337b = aVar;
        this.f3338c = cVar2;
        this.f3339d = j2;
        this.f3340e = i2;
        this.f3341f = i3;
        this.f3342g = i4;
        this.f3343h = i5;
    }

    public void b(int i2) {
        this.f3336a.b(i2);
    }

    public void c() {
        new Thread(new b()).start();
    }
}
