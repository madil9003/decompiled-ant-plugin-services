package com.dsi.ant.plugins.antplus.utility.search;

import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.dsi.ant.channel.AntChannel;
import com.dsi.ant.plugins.antplus.utility.search.e;
import u0.a;
import w0.b;

/* loaded from: classes.dex */
public class i implements com.dsi.ant.plugins.antplus.utility.search.e {

    /* renamed from: h */
    private static final String f1110h = "i";

    /* renamed from: a */
    private final w0.b f1111a;

    /* renamed from: b */
    private final Looper f1112b;

    /* renamed from: c */
    private u0.a f1113c;

    /* renamed from: d */
    private e f1114d;

    /* renamed from: e */
    private boolean f1115e;

    /* renamed from: f */
    private final b.d f1116f;

    /* renamed from: g */
    private final a.c f1117g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements b.d {

        /* renamed from: com.dsi.ant.plugins.antplus.utility.search.i$a$a */
        /* loaded from: classes.dex */
        class RunnableC0025a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ b.c f1119a;

            /* renamed from: b */
            final /* synthetic */ SearchResultInfo f1120b;

            RunnableC0025a(b.c cVar, SearchResultInfo searchResultInfo) {
                this.f1119a = cVar;
                this.f1120b = searchResultInfo;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.c(this.f1119a, this.f1120b);
            }
        }

        a() {
        }

        public void c(b.c cVar, SearchResultInfo searchResultInfo) {
            AntChannel t2;
            e eVar;
            e.a aVar;
            int i2 = d.f1124a[cVar.ordinal()];
            if (i2 == 1 || i2 == 2) {
                t2 = i.this.f1113c.t(false);
                if (t2 != null) {
                    eVar = i.this.f1114d;
                    aVar = e.a.TIMEOUT;
                    eVar.d(aVar, t2);
                    return;
                }
                i.this.f1114d.d(e.a.CRASH, null);
            }
            if (i2 == 3) {
                AntChannel t3 = i.this.f1113c.t(false);
                if (t3 != null) {
                    i.this.f1114d.a(searchResultInfo, t3);
                    return;
                }
            } else {
                if (i2 != 4) {
                    return;
                }
                t2 = i.this.f1113c.t(false);
                if (t2 != null) {
                    eVar = i.this.f1114d;
                    aVar = e.a.INTERRUPTED;
                    eVar.d(aVar, t2);
                    return;
                }
            }
            i.this.f1114d.d(e.a.CRASH, null);
        }

        @Override // w0.b.d
        public void a(b.c cVar, SearchResultInfo searchResultInfo) {
            i.this.f1114d.post(new RunnableC0025a(cVar, searchResultInfo));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements a.c {
        b() {
        }

        @Override // u0.a.c
        public void a() {
            i.this.f1114d.d(e.a.CRASH, null);
        }
    }

    /* loaded from: classes.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (i.this.f1111a) {
                if (i.this.f1113c != null) {
                    try {
                        i.this.f1113c.n(1000);
                    } catch (InterruptedException unused) {
                        i.this.f1113c.t(true);
                        i.this.f1114d.d(e.a.CRASH, null);
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static /* synthetic */ class d {

        /* renamed from: a */
        static final /* synthetic */ int[] f1124a;

        static {
            int[] iArr = new int[b.c.values().length];
            f1124a = iArr;
            try {
                iArr[b.c.FILTERED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1124a[b.c.TIME_OUT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1124a[b.c.SUCCESS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1124a[b.c.INTERRUPTED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1124a[b.c.EXECUTOR_SHUTDOWN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* loaded from: classes.dex */
    public final class e extends Handler implements e.b {

        /* renamed from: a */
        private boolean f1125a;

        /* renamed from: b */
        private final e.b f1126b;

        /* loaded from: classes.dex */
        public class a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ SearchResultInfo f1128a;

            /* renamed from: b */
            final /* synthetic */ AntChannel f1129b;

            a(SearchResultInfo searchResultInfo, AntChannel antChannel) {
                this.f1128a = searchResultInfo;
                this.f1129b = antChannel;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (e.this.f1125a) {
                    return;
                }
                e.this.f1125a = true;
                synchronized (i.this.f1111a) {
                    i.this.f1113c = null;
                    i.this.f1115e = false;
                }
                e.this.f1126b.a(this.f1128a, this.f1129b);
            }
        }

        /* loaded from: classes.dex */
        public class b implements Runnable {

            /* renamed from: a */
            final /* synthetic */ e.a f1131a;

            /* renamed from: b */
            final /* synthetic */ AntChannel f1132b;

            b(e.a aVar, AntChannel antChannel) {
                this.f1131a = aVar;
                this.f1132b = antChannel;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (e.this.f1125a) {
                    return;
                }
                e.this.f1125a = true;
                synchronized (i.this.f1111a) {
                    i.this.f1113c = null;
                    i.this.f1115e = false;
                }
                e.this.f1126b.d(this.f1131a, this.f1132b);
            }
        }

        public e(Looper looper, e.b bVar) {
            super(looper);
            this.f1125a = false;
            this.f1126b = bVar;
        }

        @Override // com.dsi.ant.plugins.antplus.utility.search.e.b
        public void a(SearchResultInfo searchResultInfo, AntChannel antChannel) {
            post(new a(searchResultInfo, antChannel));
        }

        @Override // com.dsi.ant.plugins.antplus.utility.search.e.b
        public void d(e.a aVar, AntChannel antChannel) {
            post(new b(aVar, antChannel));
        }
    }

    public i(b.C0065b c0065b, Looper looper) {
        a aVar = new a();
        this.f1116f = aVar;
        this.f1117g = new b();
        this.f1112b = looper;
        this.f1111a = new w0.b(c0065b, aVar);
    }

    @Override // com.dsi.ant.plugins.antplus.utility.search.e
    public void a() {
        synchronized (this.f1111a) {
            if (this.f1113c != null && !this.f1115e) {
                h1.a.a(f1110h, "Stopping search");
                this.f1115e = true;
                this.f1114d.post(new c());
            }
        }
    }

    @Override // com.dsi.ant.plugins.antplus.utility.search.e
    public boolean b(AntChannel antChannel, e.b bVar) {
        synchronized (this.f1111a) {
            if (this.f1113c != null) {
                return false;
            }
            this.f1115e = false;
            this.f1114d = new e(this.f1112b, bVar);
            try {
                this.f1113c = new u0.a(antChannel, this.f1117g);
                try {
                    this.f1111a.D();
                    this.f1113c.u(this.f1111a, 100);
                    return true;
                } catch (InterruptedException unused) {
                    this.f1113c.t(true);
                    this.f1113c = null;
                    this.f1114d.d(e.a.CRASH, null);
                    return true;
                }
            } catch (RemoteException unused2) {
                this.f1114d.d(e.a.CRASH, null);
                antChannel.m();
                return true;
            }
        }
    }

    public i(b.C0065b c0065b, Looper looper, w0.d dVar) {
        a aVar = new a();
        this.f1116f = aVar;
        this.f1117g = new b();
        this.f1112b = looper;
        this.f1111a = new w0.b(c0065b, dVar, aVar);
    }
}
