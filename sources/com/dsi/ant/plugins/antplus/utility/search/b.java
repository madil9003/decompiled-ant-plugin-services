package com.dsi.ant.plugins.antplus.utility.search;

import android.os.Handler;
import android.os.Looper;
import com.dsi.ant.channel.AntChannel;
import com.dsi.ant.plugins.antplus.utility.search.f;

/* loaded from: classes.dex */
public class b implements f {

    /* renamed from: a */
    private final f f990a;

    /* renamed from: b */
    private final f f991b;

    /* renamed from: c */
    private final long f992c;

    /* renamed from: d */
    private final Looper f993d;

    /* renamed from: e */
    private boolean f994e;

    /* renamed from: f */
    private boolean f995f;

    /* renamed from: g */
    private boolean f996g;

    /* renamed from: h */
    private f.b f997h;

    /* renamed from: i */
    private final Object f998i = new Object();

    /* renamed from: j */
    private final Runnable f999j = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (b.this.f998i) {
                b.this.f995f = true;
            }
            b.this.f990a.a();
            b.this.f991b.a();
        }
    }

    /* renamed from: com.dsi.ant.plugins.antplus.utility.search.b$b */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C0018b {

        /* renamed from: a */
        static final /* synthetic */ int[] f1001a;

        static {
            int[] iArr = new int[f.a.values().length];
            f1001a = iArr;
            try {
                iArr[f.a.TIMEOUT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1001a[f.a.INTERRUPTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1001a[f.a.CRASH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends Handler implements f.b {

        /* renamed from: a */
        public f f1002a;

        /* renamed from: b */
        public c f1003b;

        /* loaded from: classes.dex */
        class a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ SearchResultInfo f1005a;

            a(SearchResultInfo searchResultInfo) {
                this.f1005a = searchResultInfo;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f997h.a(this.f1005a);
            }
        }

        /* renamed from: com.dsi.ant.plugins.antplus.utility.search.b$c$b */
        /* loaded from: classes.dex */
        class RunnableC0019b implements Runnable {
            RunnableC0019b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f997h.b();
            }
        }

        /* renamed from: com.dsi.ant.plugins.antplus.utility.search.b$c$c */
        /* loaded from: classes.dex */
        class RunnableC0020c implements Runnable {

            /* renamed from: a */
            final /* synthetic */ f.a f1008a;

            /* renamed from: b */
            final /* synthetic */ AntChannel f1009b;

            RunnableC0020c(f.a aVar, AntChannel antChannel) {
                this.f1008a = aVar;
                this.f1009b = antChannel;
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.e(this.f1008a, this.f1009b);
            }
        }

        public c(Looper looper) {
            super(looper);
        }

        public void e(f.a aVar, AntChannel antChannel) {
            f.b bVar;
            int i2 = C0018b.f1001a[aVar.ordinal()];
            if (i2 != 1) {
                if (i2 == 2) {
                    synchronized (b.this.f998i) {
                        if (b.this.f995f) {
                            aVar = f.a.TIMEOUT;
                        }
                    }
                } else if (i2 != 3) {
                    return;
                }
                synchronized (b.this.f998i) {
                    b.this.f994e = false;
                    this.f1003b.removeCallbacks(b.this.f999j);
                    removeCallbacks(b.this.f999j);
                    bVar = b.this.f997h;
                }
            } else {
                synchronized (b.this.f998i) {
                    if (b.this.f995f) {
                        b.this.f994e = false;
                        this.f1003b.removeCallbacks(b.this.f999j);
                        removeCallbacks(b.this.f999j);
                    } else if (b.this.f996g) {
                        b.this.f994e = false;
                        this.f1003b.removeCallbacks(b.this.f999j);
                        removeCallbacks(b.this.f999j);
                        aVar = f.a.INTERRUPTED;
                    } else {
                        b.this.f994e = this.f1002a.b(antChannel, this.f1003b);
                        if (b.this.f994e) {
                            aVar = null;
                        } else {
                            aVar = f.a.CRASH;
                            antChannel.m();
                            antChannel = null;
                        }
                    }
                    bVar = b.this.f997h;
                }
                if (aVar == null) {
                    return;
                }
            }
            bVar.c(aVar, antChannel);
        }

        @Override // com.dsi.ant.plugins.antplus.utility.search.f.b
        public void a(SearchResultInfo searchResultInfo) {
            post(new a(searchResultInfo));
        }

        @Override // com.dsi.ant.plugins.antplus.utility.search.f.b
        public void b() {
            post(new RunnableC0019b());
        }

        @Override // com.dsi.ant.plugins.antplus.utility.search.f.b
        public void c(f.a aVar, AntChannel antChannel) {
            post(new RunnableC0020c(aVar, antChannel));
        }
    }

    public b(f fVar, f fVar2, long j2, Looper looper) {
        this.f990a = fVar;
        this.f991b = fVar2;
        this.f992c = j2;
        this.f993d = looper;
    }

    @Override // com.dsi.ant.plugins.antplus.utility.search.f
    public void a() {
        synchronized (this.f998i) {
            this.f996g = true;
        }
        this.f990a.a();
        this.f991b.a();
    }

    @Override // com.dsi.ant.plugins.antplus.utility.search.f
    public boolean b(AntChannel antChannel, f.b bVar) {
        synchronized (this.f998i) {
            if (this.f994e) {
                return false;
            }
            this.f995f = false;
            this.f996g = false;
            this.f997h = bVar;
            c cVar = new c(this.f993d);
            c cVar2 = new c(this.f993d);
            cVar.f1003b = cVar2;
            cVar.f1002a = this.f991b;
            cVar2.f1003b = cVar;
            f fVar = this.f990a;
            cVar2.f1002a = fVar;
            this.f994e = fVar.b(antChannel, cVar);
            long j2 = this.f992c;
            if (j2 > 0) {
                cVar.postDelayed(this.f999j, j2);
            }
            return this.f994e;
        }
    }

    @Override // com.dsi.ant.plugins.antplus.utility.search.f
    public void c(int i2) {
        this.f990a.c(i2);
        this.f991b.c(i2);
    }
}
