package com.dsi.ant.plugins.antplus.utility.search;

import android.os.Handler;
import android.os.Looper;
import com.dsi.ant.channel.AntChannel;
import com.dsi.ant.plugins.antplus.utility.search.f;
import com.dsi.ant.plugins.antplus.utility.search.h;

/* loaded from: classes.dex */
public class d implements f {

    /* renamed from: a */
    private final com.dsi.ant.plugins.antplus.utility.search.b f1037a;

    /* renamed from: b */
    private final h f1038b;

    /* renamed from: c */
    private final b f1039c;

    /* renamed from: d */
    private final Looper f1040d;

    /* renamed from: e */
    private final Object f1041e = new Object();

    /* renamed from: f */
    private boolean f1042f;

    /* renamed from: g */
    private boolean f1043g;

    /* renamed from: h */
    private c f1044h;

    /* loaded from: classes.dex */
    class a extends Thread {

        /* renamed from: a */
        final /* synthetic */ AntChannel f1045a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, AntChannel antChannel) {
            super(str);
            this.f1045a = antChannel;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            AntChannel a3 = d.this.f1039c.a();
            synchronized (d.this.f1041e) {
                if (d.this.f1043g) {
                    d.this.f1044h.d(f.a.INTERRUPTED, this.f1045a, a3);
                    return;
                }
                if (a3 != null) {
                    if (!d.this.f1038b.l(this.f1045a, a3, d.this.f1044h)) {
                        this.f1045a.m();
                        a3.m();
                        d.this.f1044h.d(f.a.CRASH, null, null);
                    }
                } else if (!d.this.f1037a.b(this.f1045a, d.this.f1044h)) {
                    this.f1045a.m();
                    d.this.f1044h.c(f.a.CRASH, null);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        AntChannel a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class c extends Handler implements f.b, h.c {

        /* renamed from: a */
        public final f.b f1047a;

        /* loaded from: classes.dex */
        class a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ SearchResultInfo f1049a;

            a(SearchResultInfo searchResultInfo) {
                this.f1049a = searchResultInfo;
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.f1047a.a(this.f1049a);
            }
        }

        /* loaded from: classes.dex */
        public class b implements Runnable {

            /* renamed from: a */
            final /* synthetic */ AntChannel f1051a;

            /* renamed from: b */
            final /* synthetic */ f.a f1052b;

            /* renamed from: c */
            final /* synthetic */ AntChannel f1053c;

            b(AntChannel antChannel, f.a aVar, AntChannel antChannel2) {
                this.f1051a = antChannel;
                this.f1052b = aVar;
                this.f1053c = antChannel2;
            }

            @Override // java.lang.Runnable
            public void run() {
                synchronized (d.this.f1041e) {
                    d dVar = d.this;
                    dVar.f1042f = dVar.f1043g = false;
                }
                AntChannel antChannel = this.f1051a;
                if (antChannel != null) {
                    antChannel.m();
                }
                c.this.f1047a.c(this.f1052b, this.f1053c);
            }
        }

        /* renamed from: com.dsi.ant.plugins.antplus.utility.search.d$c$c */
        /* loaded from: classes.dex */
        public class RunnableC0023c implements Runnable {

            /* renamed from: a */
            final /* synthetic */ f.a f1055a;

            /* renamed from: b */
            final /* synthetic */ AntChannel f1056b;

            RunnableC0023c(f.a aVar, AntChannel antChannel) {
                this.f1055a = aVar;
                this.f1056b = antChannel;
            }

            @Override // java.lang.Runnable
            public void run() {
                synchronized (d.this.f1041e) {
                    d dVar = d.this;
                    dVar.f1042f = dVar.f1043g = false;
                }
                c.this.f1047a.c(this.f1055a, this.f1056b);
            }
        }

        /* renamed from: com.dsi.ant.plugins.antplus.utility.search.d$c$d */
        /* loaded from: classes.dex */
        class RunnableC0024d implements Runnable {
            RunnableC0024d() {
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.f1047a.b();
            }
        }

        public c(f.b bVar, Looper looper) {
            super(looper);
            this.f1047a = bVar;
        }

        @Override // com.dsi.ant.plugins.antplus.utility.search.f.b
        public void a(SearchResultInfo searchResultInfo) {
            post(new a(searchResultInfo));
        }

        @Override // com.dsi.ant.plugins.antplus.utility.search.f.b
        public void b() {
            post(new RunnableC0024d());
        }

        @Override // com.dsi.ant.plugins.antplus.utility.search.f.b
        public void c(f.a aVar, AntChannel antChannel) {
            post(new RunnableC0023c(aVar, antChannel));
        }

        @Override // com.dsi.ant.plugins.antplus.utility.search.h.c
        public void d(f.a aVar, AntChannel antChannel, AntChannel antChannel2) {
            post(new b(antChannel2, aVar, antChannel));
        }
    }

    public d(f fVar, f fVar2, long j2, b bVar, Looper looper) {
        this.f1037a = new com.dsi.ant.plugins.antplus.utility.search.b(fVar, fVar2, j2, looper);
        this.f1038b = new h(fVar, fVar2, j2, looper);
        this.f1039c = bVar;
        this.f1040d = looper;
    }

    @Override // com.dsi.ant.plugins.antplus.utility.search.f
    public void a() {
        synchronized (this.f1041e) {
            this.f1043g = true;
        }
        this.f1037a.a();
        this.f1038b.j();
    }

    @Override // com.dsi.ant.plugins.antplus.utility.search.f
    public boolean b(AntChannel antChannel, f.b bVar) {
        synchronized (this.f1041e) {
            if (this.f1042f) {
                return false;
            }
            this.f1042f = true;
            this.f1043g = false;
            this.f1044h = new c(bVar, this.f1040d);
            new a("DualScan-initation-thread", antChannel).start();
            return true;
        }
    }

    @Override // com.dsi.ant.plugins.antplus.utility.search.f
    public void c(int i2) {
        this.f1037a.c(i2);
        this.f1038b.k(i2);
    }
}
