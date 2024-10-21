package com.dsi.ant.plugins.antplus.utility.search;

import android.os.Handler;
import android.os.Looper;
import com.dsi.ant.channel.AntChannel;
import com.dsi.ant.plugins.antplus.utility.search.e;

/* loaded from: classes.dex */
public class g {

    /* renamed from: a */
    private final e f1067a;

    /* renamed from: b */
    private final e f1068b;

    /* renamed from: c */
    private final c f1069c;

    /* renamed from: d */
    private final c f1070d;

    /* renamed from: e */
    private b f1071e;

    /* renamed from: f */
    private boolean f1072f;

    /* renamed from: g */
    private final Object f1073g = new Object();

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a */
        static final /* synthetic */ int[] f1074a;

        static {
            int[] iArr = new int[e.a.values().length];
            f1074a = iArr;
            try {
                iArr[e.a.INTERRUPTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1074a[e.a.TIMEOUT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1074a[e.a.CRASH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void b(e.a aVar, AntChannel antChannel, AntChannel antChannel2);

        void c(SearchResultInfo searchResultInfo, AntChannel antChannel, AntChannel antChannel2);
    }

    /* loaded from: classes.dex */
    public final class c extends Handler implements e.b {

        /* renamed from: a */
        public SearchResultInfo f1075a;

        /* renamed from: b */
        public AntChannel f1076b;

        /* renamed from: c */
        public e.a f1077c;

        /* renamed from: d */
        public boolean f1078d;

        /* loaded from: classes.dex */
        class a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ SearchResultInfo f1080a;

            /* renamed from: b */
            final /* synthetic */ AntChannel f1081b;

            a(SearchResultInfo searchResultInfo, AntChannel antChannel) {
                this.f1080a = searchResultInfo;
                this.f1081b = antChannel;
            }

            @Override // java.lang.Runnable
            public void run() {
                c cVar;
                synchronized (g.this.f1073g) {
                    cVar = c.this;
                    cVar.f1075a = this.f1080a;
                    cVar.f1076b = this.f1081b;
                    cVar.f1078d = true;
                }
                g.this.c();
            }
        }

        /* loaded from: classes.dex */
        class b implements Runnable {

            /* renamed from: a */
            final /* synthetic */ e.a f1083a;

            /* renamed from: b */
            final /* synthetic */ AntChannel f1084b;

            b(e.a aVar, AntChannel antChannel) {
                this.f1083a = aVar;
                this.f1084b = antChannel;
            }

            @Override // java.lang.Runnable
            public void run() {
                c cVar;
                synchronized (g.this.f1073g) {
                    cVar = c.this;
                    cVar.f1075a = null;
                    cVar.f1077c = this.f1083a;
                    cVar.f1076b = this.f1084b;
                    cVar.f1078d = true;
                }
                g.this.c();
            }
        }

        public c(Looper looper) {
            super(looper);
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

    public g(e eVar, e eVar2, Looper looper) {
        this.f1067a = eVar;
        this.f1068b = eVar2;
        this.f1069c = new c(looper);
        this.f1070d = new c(looper);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0060, code lost:            r11 = r11.f1070d;        r7 = r11.f1075a;        r1 = r11.f1077c;        r6 = r5;        r5 = r6;     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0070  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void c() {
        /*
            r11 = this;
            java.lang.Object r0 = r11.f1073g
            monitor-enter(r0)
            com.dsi.ant.plugins.antplus.utility.search.g$c r1 = r11.f1069c     // Catch: java.lang.Throwable -> L76
            boolean r2 = r1.f1078d     // Catch: java.lang.Throwable -> L76
            if (r2 == 0) goto L12
            com.dsi.ant.plugins.antplus.utility.search.SearchResultInfo r1 = r1.f1075a     // Catch: java.lang.Throwable -> L76
            if (r1 == 0) goto L12
            com.dsi.ant.plugins.antplus.utility.search.e r1 = r11.f1068b     // Catch: java.lang.Throwable -> L76
            r1.a()     // Catch: java.lang.Throwable -> L76
        L12:
            com.dsi.ant.plugins.antplus.utility.search.g$c r1 = r11.f1070d     // Catch: java.lang.Throwable -> L76
            boolean r2 = r1.f1078d     // Catch: java.lang.Throwable -> L76
            if (r2 == 0) goto L21
            com.dsi.ant.plugins.antplus.utility.search.SearchResultInfo r1 = r1.f1075a     // Catch: java.lang.Throwable -> L76
            if (r1 == 0) goto L21
            com.dsi.ant.plugins.antplus.utility.search.e r1 = r11.f1067a     // Catch: java.lang.Throwable -> L76
            r1.a()     // Catch: java.lang.Throwable -> L76
        L21:
            com.dsi.ant.plugins.antplus.utility.search.g$c r1 = r11.f1069c     // Catch: java.lang.Throwable -> L76
            boolean r2 = r1.f1078d     // Catch: java.lang.Throwable -> L76
            if (r2 == 0) goto L74
            com.dsi.ant.plugins.antplus.utility.search.g$c r2 = r11.f1070d     // Catch: java.lang.Throwable -> L76
            boolean r3 = r2.f1078d     // Catch: java.lang.Throwable -> L76
            if (r3 != 0) goto L2e
            goto L74
        L2e:
            r3 = 0
            r11.f1072f = r3     // Catch: java.lang.Throwable -> L76
            com.dsi.ant.plugins.antplus.utility.search.g$b r4 = r11.f1071e     // Catch: java.lang.Throwable -> L76
            r5 = 0
            r11.f1071e = r5     // Catch: java.lang.Throwable -> L76
            com.dsi.ant.channel.AntChannel r5 = r1.f1076b     // Catch: java.lang.Throwable -> L76
            com.dsi.ant.channel.AntChannel r6 = r2.f1076b     // Catch: java.lang.Throwable -> L76
            com.dsi.ant.plugins.antplus.utility.search.SearchResultInfo r7 = r1.f1075a     // Catch: java.lang.Throwable -> L76
            com.dsi.ant.plugins.antplus.utility.search.e$a r1 = r1.f1077c     // Catch: java.lang.Throwable -> L76
            com.dsi.ant.plugins.antplus.utility.search.SearchResultInfo r8 = r2.f1075a     // Catch: java.lang.Throwable -> L76
            r9 = 1
            if (r8 == 0) goto L47
            if (r7 != 0) goto L5e
        L45:
            r3 = r9
            goto L5e
        L47:
            if (r7 != 0) goto L5e
            int[] r8 = com.dsi.ant.plugins.antplus.utility.search.g.a.f1074a     // Catch: java.lang.Throwable -> L76
            com.dsi.ant.plugins.antplus.utility.search.e$a r2 = r2.f1077c     // Catch: java.lang.Throwable -> L76
            int r2 = r2.ordinal()     // Catch: java.lang.Throwable -> L76
            r2 = r8[r2]     // Catch: java.lang.Throwable -> L76
            if (r2 == r9) goto L45
            r8 = 2
            if (r2 == r8) goto L59
            goto L5e
        L59:
            com.dsi.ant.plugins.antplus.utility.search.e$a r2 = com.dsi.ant.plugins.antplus.utility.search.e.a.INTERRUPTED     // Catch: java.lang.Throwable -> L76
            if (r1 == r2) goto L5e
            goto L45
        L5e:
            if (r3 == 0) goto L69
            com.dsi.ant.plugins.antplus.utility.search.g$c r11 = r11.f1070d     // Catch: java.lang.Throwable -> L76
            com.dsi.ant.plugins.antplus.utility.search.SearchResultInfo r7 = r11.f1075a     // Catch: java.lang.Throwable -> L76
            com.dsi.ant.plugins.antplus.utility.search.e$a r1 = r11.f1077c     // Catch: java.lang.Throwable -> L76
            r10 = r6
            r6 = r5
            r5 = r10
        L69:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L76
            if (r7 == 0) goto L70
            r4.c(r7, r5, r6)
            goto L73
        L70:
            r4.b(r1, r5, r6)
        L73:
            return
        L74:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L76
            return
        L76:
            r11 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L76
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dsi.ant.plugins.antplus.utility.search.g.c():void");
    }

    public void d() {
        this.f1067a.a();
        this.f1068b.a();
    }

    public boolean e(AntChannel antChannel, AntChannel antChannel2, b bVar) {
        synchronized (this.f1073g) {
            if (this.f1072f) {
                return false;
            }
            this.f1072f = true;
            c cVar = this.f1069c;
            cVar.f1078d = false;
            this.f1070d.f1078d = false;
            this.f1071e = bVar;
            if (!this.f1067a.b(antChannel, cVar)) {
                synchronized (this.f1073g) {
                    this.f1072f = false;
                }
                return false;
            }
            if (!this.f1068b.b(antChannel2, this.f1070d)) {
                synchronized (this.f1073g) {
                    antChannel2.m();
                    c cVar2 = this.f1070d;
                    cVar2.f1077c = e.a.CRASH;
                    cVar2.f1075a = null;
                    cVar2.f1076b = null;
                    cVar2.f1078d = true;
                }
                this.f1067a.a();
            }
            return true;
        }
    }
}
