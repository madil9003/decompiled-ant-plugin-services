package com.dsi.ant.plugins.antplus.utility.search;

import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.util.SparseIntArray;
import com.dsi.ant.channel.AntChannel;
import com.dsi.ant.plugins.antplus.utility.search.f;
import u0.a;
import w0.b;

/* loaded from: classes.dex */
public class j implements f {

    /* renamed from: l */
    private static final String f1134l = "j";

    /* renamed from: a */
    private final w0.c f1135a;

    /* renamed from: b */
    private final Looper f1136b;

    /* renamed from: c */
    private final Long f1137c;

    /* renamed from: d */
    private AntChannel f1138d;

    /* renamed from: e */
    private u0.a f1139e;

    /* renamed from: f */
    private e f1140f;

    /* renamed from: g */
    private boolean f1141g;

    /* renamed from: h */
    private final b.d f1142h;

    /* renamed from: i */
    private final a.c f1143i;

    /* renamed from: j */
    private final SparseIntArray f1144j;

    /* renamed from: k */
    private final int[] f1145k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements b.d {

        /* renamed from: com.dsi.ant.plugins.antplus.utility.search.j$a$a */
        /* loaded from: classes.dex */
        class RunnableC0026a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ b.c f1147a;

            /* renamed from: b */
            final /* synthetic */ SearchResultInfo f1148b;

            RunnableC0026a(b.c cVar, SearchResultInfo searchResultInfo) {
                this.f1147a = cVar;
                this.f1148b = searchResultInfo;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.c(this.f1147a, this.f1148b);
            }
        }

        a() {
        }

        public void c(b.c cVar, SearchResultInfo searchResultInfo) {
            int i2 = d.f1152a[cVar.ordinal()];
            if (i2 == 1) {
                j.this.p(searchResultInfo.f976a);
            } else {
                if (i2 != 2) {
                    if (i2 == 3) {
                        j.this.p(searchResultInfo.f976a);
                        j.this.f1140f.a(searchResultInfo);
                        return;
                    } else {
                        if (i2 != 4) {
                            return;
                        }
                        AntChannel t2 = j.this.f1139e.t(false);
                        e eVar = j.this.f1140f;
                        if (t2 == null) {
                            eVar.c(f.a.CRASH, null);
                            return;
                        } else {
                            eVar.c(f.a.INTERRUPTED, t2);
                            return;
                        }
                    }
                }
                j.this.n();
            }
            j.this.f1140f.b();
        }

        @Override // w0.b.d
        public void a(b.c cVar, SearchResultInfo searchResultInfo) {
            j.this.f1140f.post(new RunnableC0026a(cVar, searchResultInfo));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements a.c {
        b() {
        }

        @Override // u0.a.c
        public void a() {
            j.this.f1140f.c(f.a.CRASH, null);
        }
    }

    /* loaded from: classes.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (j.this.f1135a) {
                if (j.this.f1139e != null) {
                    try {
                        j.this.f1139e.n(1000);
                    } catch (InterruptedException unused) {
                        j.this.f1139e.t(true);
                        j.this.f1140f.c(f.a.CRASH, null);
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static /* synthetic */ class d {

        /* renamed from: a */
        static final /* synthetic */ int[] f1152a;

        static {
            int[] iArr = new int[b.c.values().length];
            f1152a = iArr;
            try {
                iArr[b.c.FILTERED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1152a[b.c.TIME_OUT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1152a[b.c.SUCCESS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1152a[b.c.INTERRUPTED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1152a[b.c.EXECUTOR_SHUTDOWN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* loaded from: classes.dex */
    public final class e extends Handler implements f.b {

        /* renamed from: a */
        private boolean f1153a;

        /* renamed from: b */
        private final f.b f1154b;

        /* renamed from: c */
        private final Runnable f1155c;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                synchronized (j.this.f1135a) {
                    if (!e.this.f1153a && !j.this.f1141g) {
                        e.this.f1153a = true;
                        AntChannel t2 = j.this.f1139e.t(false);
                        synchronized (j.this.f1135a) {
                            j.this.f1139e = null;
                            j.this.f1141g = false;
                        }
                        f.b bVar = e.this.f1154b;
                        if (t2 == null) {
                            bVar.c(f.a.CRASH, null);
                        } else {
                            bVar.c(f.a.TIMEOUT, t2);
                        }
                    }
                }
            }
        }

        /* loaded from: classes.dex */
        public class b implements Runnable {

            /* renamed from: a */
            final /* synthetic */ SearchResultInfo f1158a;

            b(SearchResultInfo searchResultInfo) {
                this.f1158a = searchResultInfo;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (e.this.f1153a) {
                    return;
                }
                h1.a.a(j.f1134l, "Device found.");
                e.this.f1154b.a(this.f1158a);
            }
        }

        /* loaded from: classes.dex */
        public class c implements Runnable {

            /* renamed from: a */
            final /* synthetic */ f.a f1160a;

            /* renamed from: b */
            final /* synthetic */ AntChannel f1161b;

            c(f.a aVar, AntChannel antChannel) {
                this.f1160a = aVar;
                this.f1161b = antChannel;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (e.this.f1153a) {
                    return;
                }
                e.this.f1153a = true;
                synchronized (j.this.f1135a) {
                    j.this.f1139e = null;
                    j.this.f1141g = false;
                }
                h1.a.a(j.f1134l, "Scan stopped. Reason code: " + this.f1160a);
                e.this.f1154b.c(this.f1160a, this.f1161b);
            }
        }

        /* loaded from: classes.dex */
        public class d implements Runnable {
            d() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (e.this.f1153a) {
                    return;
                }
                h1.a.i(j.f1134l, "Pinging client.");
                e.this.f1154b.b();
            }
        }

        public e(Looper looper, f.b bVar) {
            super(looper);
            this.f1153a = false;
            a aVar = new a();
            this.f1155c = aVar;
            this.f1154b = bVar;
            if (j.this.f1137c.longValue() > 0) {
                postDelayed(aVar, j.this.f1137c.longValue());
            }
        }

        @Override // com.dsi.ant.plugins.antplus.utility.search.f.b
        public void a(SearchResultInfo searchResultInfo) {
            post(new b(searchResultInfo));
        }

        @Override // com.dsi.ant.plugins.antplus.utility.search.f.b
        public void b() {
            post(new d());
        }

        @Override // com.dsi.ant.plugins.antplus.utility.search.f.b
        public void c(f.a aVar, AntChannel antChannel) {
            post(new c(aVar, antChannel));
        }
    }

    public j(b.C0065b c0065b, Looper looper, long j2) {
        a aVar = new a();
        this.f1142h = aVar;
        this.f1143i = new b();
        this.f1144j = new SparseIntArray();
        this.f1145k = new int[4];
        this.f1136b = looper;
        this.f1137c = Long.valueOf(j2);
        this.f1135a = new w0.c(c0065b, aVar);
    }

    public void n() {
        this.f1144j.clear();
        try {
            this.f1138d.i(0, true);
        } catch (RemoteException | g.a unused) {
        }
    }

    private static int o(j.b bVar) {
        return bVar.a() + (bVar.b() << 16) + (bVar.e() << 24) + (bVar.d() ? 8388608 : 0);
    }

    public void p(j.b bVar) {
        int i2;
        int o2 = o(bVar);
        int i3 = this.f1144j.get(o2) + 1;
        this.f1144j.put(o2, i3);
        int size = this.f1144j.size();
        if (size <= 4) {
            i2 = size - 1;
        } else {
            int i4 = -1;
            int i5 = 0;
            for (int i6 = 0; i6 < 4; i6++) {
                int i7 = this.f1144j.get(this.f1145k[i6]);
                if (i7 < i3 && (i4 < 0 || i5 > i7)) {
                    i4 = i6;
                    i5 = i7;
                }
            }
            i2 = i4;
        }
        if (i2 >= 0) {
            this.f1145k[i2] = o2;
            try {
                this.f1138d.b(bVar, i2);
                if (size <= 4) {
                    this.f1138d.i(size, true);
                }
            } catch (RemoteException | g.a unused) {
            }
        }
    }

    @Override // com.dsi.ant.plugins.antplus.utility.search.f
    public void a() {
        synchronized (this.f1135a) {
            if (this.f1139e != null && !this.f1141g) {
                h1.a.a(f1134l, "interrupting discovery");
                this.f1141g = true;
                this.f1140f.post(new c());
            }
        }
    }

    @Override // com.dsi.ant.plugins.antplus.utility.search.f
    public boolean b(AntChannel antChannel, f.b bVar) {
        synchronized (this.f1135a) {
            if (this.f1139e != null) {
                return false;
            }
            this.f1141g = false;
            this.f1140f = new e(this.f1136b, bVar);
            this.f1138d = antChannel;
            try {
                this.f1139e = new u0.a(antChannel, this.f1143i);
                this.f1135a.D();
                try {
                    this.f1139e.u(this.f1135a, 100);
                    return true;
                } catch (InterruptedException unused) {
                    this.f1139e.t(true);
                    this.f1139e = null;
                    this.f1140f.c(f.a.CRASH, null);
                    return true;
                }
            } catch (RemoteException unused2) {
                this.f1140f.c(f.a.CRASH, null);
                antChannel.m();
                return true;
            }
        }
    }

    @Override // com.dsi.ant.plugins.antplus.utility.search.f
    public void c(int i2) {
        this.f1135a.C(i2);
        n();
    }

    public j(b.C0065b c0065b, Looper looper, long j2, w0.d dVar) {
        a aVar = new a();
        this.f1142h = aVar;
        this.f1143i = new b();
        this.f1144j = new SparseIntArray();
        this.f1145k = new int[4];
        this.f1136b = looper;
        this.f1137c = Long.valueOf(j2);
        this.f1135a = new w0.c(c0065b, dVar, aVar);
    }
}
