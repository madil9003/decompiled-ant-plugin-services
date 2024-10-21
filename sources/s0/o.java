package s0;

import android.os.Bundle;
import android.os.Message;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.zip.DataFormatException;
import s0.a;
import s0.g;

/* loaded from: classes.dex */
public abstract class o {

    /* renamed from: a */
    private static final String f3261a = "o";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ c f3262a;

        /* renamed from: b */
        final /* synthetic */ long f3263b;

        /* renamed from: c */
        final /* synthetic */ int f3264c;

        /* renamed from: d */
        final /* synthetic */ int f3265d;

        /* renamed from: e */
        final /* synthetic */ int f3266e;

        /* renamed from: f */
        final /* synthetic */ int f3267f;

        /* renamed from: g */
        final /* synthetic */ u0.a f3268g;

        /* renamed from: h */
        final /* synthetic */ m f3269h;

        /* renamed from: s0.o$a$a */
        /* loaded from: classes.dex */
        class C0052a implements g.n {
            C0052a() {
            }

            @Override // s0.g.n
            public void a(long j2, long j3) {
            }
        }

        /* loaded from: classes.dex */
        class b implements g.n {

            /* renamed from: a */
            final /* synthetic */ long f3271a;

            /* renamed from: b */
            final /* synthetic */ long f3272b;

            b(long j2, long j3) {
                this.f3271a = j2;
                this.f3272b = j3;
            }

            @Override // s0.g.n
            public void a(long j2, long j3) {
                a.this.f3262a.g(850, this.f3271a + j2, this.f3272b);
            }
        }

        a(c cVar, long j2, int i2, int i3, int i4, int i5, u0.a aVar, m mVar) {
            this.f3262a = cVar;
            this.f3263b = j2;
            this.f3264c = i2;
            this.f3265d = i3;
            this.f3266e = i4;
            this.f3267f = i5;
            this.f3268g = aVar;
            this.f3269h = mVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            g.l Q;
            g.l lVar;
            Object obj = new Object();
            g gVar = new g(this.f3262a.a(), this.f3263b, this.f3264c);
            gVar.Z(this.f3265d, this.f3266e, this.f3267f);
            try {
                if (!this.f3268g.u(gVar, 1000)) {
                    o.h(this.f3262a, -20, obj, Boolean.FALSE);
                    return;
                }
                try {
                    i b3 = this.f3262a.b();
                    if (b3 != null && o.f(gVar.W(b3), this.f3262a, obj, false)) {
                        if (Q != lVar) {
                            return;
                        } else {
                            return;
                        }
                    }
                    this.f3262a.g(100, 0L, 0L);
                    if (o.f(gVar.R(this.f3269h), this.f3262a, obj, false)) {
                        if (gVar.Q() != g.l.SUCCESS) {
                            h1.a.j(o.f3261a, "DownloadAll Failed to close ANTFS session.");
                            return;
                        }
                        return;
                    }
                    this.f3262a.g(800, 0L, 0L);
                    if (!this.f3262a.e(gVar)) {
                        if (gVar.Q() != g.l.SUCCESS) {
                            h1.a.j(o.f3261a, "DownloadAll Failed to close ANTFS session.");
                            return;
                        }
                        return;
                    }
                    if (o.e(gVar.S(0, new C0052a()), this.f3262a, obj, false)) {
                        if (gVar.Q() != g.l.SUCCESS) {
                            h1.a.j(o.f3261a, "DownloadAll Failed to close ANTFS session.");
                            return;
                        }
                        return;
                    }
                    try {
                        s0.a aVar = new s0.a(gVar.M(), gVar.O());
                        if (!this.f3262a.f(gVar)) {
                            if (gVar.Q() != g.l.SUCCESS) {
                                h1.a.j(o.f3261a, "DownloadAll Failed to close ANTFS session.");
                                return;
                            }
                            return;
                        }
                        ArrayList arrayList = new ArrayList();
                        long j2 = 0;
                        for (int i2 = 0; i2 < aVar.f3076b.size(); i2++) {
                            a.b bVar = (a.b) aVar.f3076b.valueAt(i2);
                            if (this.f3262a.h(bVar)) {
                                arrayList.add(bVar);
                                j2 += bVar.f3089f;
                            }
                        }
                        Iterator it = arrayList.iterator();
                        long j3 = 0;
                        while (it.hasNext()) {
                            a.b bVar2 = (a.b) it.next();
                            if (o.e(gVar.S(bVar2.f3084a, new b(j3, j2)), this.f3262a, obj, false)) {
                                if (gVar.Q() != g.l.SUCCESS) {
                                    h1.a.j(o.f3261a, "DownloadAll Failed to close ANTFS session.");
                                    return;
                                }
                                return;
                            } else {
                                byte[] M = gVar.M();
                                long j4 = bVar2.f3089f;
                                j3 += j4;
                                this.f3262a.c(bVar2, j4, M);
                            }
                        }
                        o.h(this.f3262a, 0, obj, Boolean.FALSE);
                        if (gVar.Q() != g.l.SUCCESS) {
                            h1.a.j(o.f3261a, "DownloadAll Failed to close ANTFS session.");
                        }
                    } catch (DataFormatException e3) {
                        h1.a.b(o.f3261a, "ANTFS directory DataFormatException: " + e3.getMessage());
                        o.h(this.f3262a, -40, obj, Boolean.FALSE);
                        if (gVar.Q() != g.l.SUCCESS) {
                            h1.a.j(o.f3261a, "DownloadAll Failed to close ANTFS session.");
                        }
                    }
                } finally {
                    if (gVar.Q() != g.l.SUCCESS) {
                        h1.a.j(o.f3261a, "DownloadAll Failed to close ANTFS session.");
                    }
                }
            } catch (InterruptedException unused) {
                h1.a.b(o.f3261a, "ANTFS request InterruptedException");
                o.h(this.f3262a, -40, obj, Boolean.FALSE);
            }
        }
    }

    /* loaded from: classes.dex */
    public static /* synthetic */ class b {

        /* renamed from: a */
        static final /* synthetic */ int[] f3274a;

        /* renamed from: b */
        static final /* synthetic */ int[] f3275b;

        static {
            int[] iArr = new int[g.l.values().length];
            f3275b = iArr;
            try {
                iArr[g.l.FAIL_NOT_SUPPORTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3275b[g.l.FAIL_AUTHENTICATION_REJECTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3275b[g.l.FAIL_DEVICE_TRANSMISSION_LOST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[g.k.values().length];
            f3274a = iArr2;
            try {
                iArr2[g.k.AUTH_IDLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3274a[g.k.AUTH_WAITING_FOR_PAIRING.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class c {
        public abstract g.m a();

        public i b() {
            return null;
        }

        public abstract void c(a.b bVar, long j2, byte[] bArr);

        public abstract void d(int i2);

        public boolean e(g gVar) {
            return true;
        }

        public boolean f(g gVar) {
            return true;
        }

        public abstract void g(int i2, long j2, long j3);

        public abstract boolean h(a.b bVar);
    }

    /* loaded from: classes.dex */
    public static abstract class d extends c {

        /* renamed from: a */
        protected int f3276a;

        /* renamed from: b */
        protected boolean f3277b;

        /* renamed from: c */
        g.m f3278c = new a();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class a implements g.m {
            a() {
            }

            @Override // s0.g.m
            public void a(g.k kVar, g.j jVar) {
                int i2 = b.f3274a[kVar.ordinal()];
                if (i2 == 1) {
                    d.this.g(500, 0L, 0L);
                } else {
                    if (i2 != 2) {
                        return;
                    }
                    d.this.g(550, 0L, 0L);
                }
            }
        }

        public d(int i2, boolean z2) {
            this.f3276a = i2;
            this.f3277b = z2;
        }

        @Override // s0.o.c
        public g.m a() {
            return this.f3278c;
        }

        @Override // s0.o.c
        public void c(a.b bVar, long j2, byte[] bArr) {
            Bundle bundle = new Bundle();
            bundle.putLong("long_targetBytes", j2);
            bundle.putByteArray("arrayByte_rawFileBytes", bArr);
            i(191, bundle);
        }

        @Override // s0.o.c
        public void d(int i2) {
            Bundle bundle = new Bundle();
            bundle.putInt("int_statusCode", i2);
            i(this.f3276a, bundle);
        }

        @Override // s0.o.c
        public void g(int i2, long j2, long j3) {
            if (this.f3277b) {
                Bundle bundle = new Bundle();
                bundle.putInt("int_stateCode", i2);
                bundle.putLong("long_transferredBytes", j2);
                bundle.putLong("long_totalBytes", j3);
                i(190, bundle);
            }
        }

        protected void i(int i2, Bundle bundle) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.arg1 = i2;
            obtain.setData(bundle);
            j(obtain);
        }

        protected abstract void j(Message message);
    }

    public static boolean e(g.i iVar, c cVar, Object obj, boolean z2) {
        if (iVar == g.i.SUCCESS) {
            return false;
        }
        h1.a.b(f3261a, "ANTFS download request failed, code: " + iVar);
        h(cVar, -40, obj, Boolean.valueOf(z2));
        return true;
    }

    public static boolean f(g.l lVar, c cVar, Object obj, boolean z2) {
        if (lVar == g.l.SUCCESS) {
            return false;
        }
        h1.a.b(f3261a, "ANTFS request failed, code: " + lVar);
        int i2 = b.f3275b[lVar.ordinal()];
        h(cVar, i2 != 1 ? i2 != 2 ? i2 != 3 ? -40 : -41 : -1040 : -61, obj, Boolean.valueOf(z2));
        return true;
    }

    public static Thread g(u0.a aVar, m mVar, c cVar, long j2, int i2, int i3, int i4, int i5) {
        Thread thread = new Thread(new a(cVar, j2, i2, i3, i4, i5, aVar, mVar));
        thread.start();
        return thread;
    }

    public static void h(c cVar, int i2, Object obj, Boolean bool) {
        synchronized (obj) {
            if (bool.booleanValue()) {
                h1.a.a(f3261a, "Attempt to send more than one result blocked, what: " + i2);
            } else {
                cVar.d(i2);
            }
        }
    }
}
