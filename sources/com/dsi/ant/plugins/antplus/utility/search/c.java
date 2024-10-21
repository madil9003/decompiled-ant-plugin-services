package com.dsi.ant.plugins.antplus.utility.search;

import android.os.Handler;
import android.os.Looper;
import com.dsi.ant.channel.AntChannel;
import com.dsi.ant.plugins.antplus.utility.search.e;
import com.dsi.ant.plugins.antplus.utility.search.g;

/* loaded from: classes.dex */
public class c implements e {

    /* renamed from: a */
    private final com.dsi.ant.plugins.antplus.utility.search.a f1011a;

    /* renamed from: b */
    private final g f1012b;

    /* renamed from: c */
    private final b f1013c;

    /* renamed from: d */
    private final Looper f1014d;

    /* renamed from: e */
    private final Object f1015e = new Object();

    /* renamed from: f */
    private boolean f1016f;

    /* renamed from: g */
    private boolean f1017g;

    /* renamed from: h */
    private HandlerC0021c f1018h;

    /* loaded from: classes.dex */
    class a extends Thread {

        /* renamed from: a */
        final /* synthetic */ AntChannel f1019a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, AntChannel antChannel) {
            super(str);
            this.f1019a = antChannel;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            AntChannel a3 = c.this.f1013c.a();
            synchronized (c.this.f1015e) {
                if (c.this.f1017g) {
                    c.this.f1018h.b(e.a.INTERRUPTED, this.f1019a, a3);
                    return;
                }
                if (a3 != null) {
                    if (!c.this.f1012b.e(this.f1019a, a3, c.this.f1018h)) {
                        this.f1019a.m();
                        a3.m();
                        c.this.f1018h.b(e.a.CRASH, null, null);
                    }
                } else if (!c.this.f1011a.b(this.f1019a, c.this.f1018h)) {
                    this.f1019a.m();
                    c.this.f1018h.d(e.a.CRASH, null);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        AntChannel a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.dsi.ant.plugins.antplus.utility.search.c$c */
    /* loaded from: classes.dex */
    public final class HandlerC0021c extends Handler implements e.b, g.b {

        /* renamed from: a */
        public final e.b f1021a;

        /* renamed from: com.dsi.ant.plugins.antplus.utility.search.c$c$a */
        /* loaded from: classes.dex */
        class a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ AntChannel f1023a;

            /* renamed from: b */
            final /* synthetic */ SearchResultInfo f1024b;

            /* renamed from: c */
            final /* synthetic */ AntChannel f1025c;

            a(AntChannel antChannel, SearchResultInfo searchResultInfo, AntChannel antChannel2) {
                this.f1023a = antChannel;
                this.f1024b = searchResultInfo;
                this.f1025c = antChannel2;
            }

            @Override // java.lang.Runnable
            public void run() {
                synchronized (c.this.f1015e) {
                    c cVar = c.this;
                    cVar.f1016f = cVar.f1017g = false;
                }
                AntChannel antChannel = this.f1023a;
                if (antChannel != null) {
                    antChannel.m();
                }
                HandlerC0021c.this.f1021a.a(this.f1024b, this.f1025c);
            }
        }

        /* renamed from: com.dsi.ant.plugins.antplus.utility.search.c$c$b */
        /* loaded from: classes.dex */
        public class b implements Runnable {

            /* renamed from: a */
            final /* synthetic */ AntChannel f1027a;

            /* renamed from: b */
            final /* synthetic */ e.a f1028b;

            /* renamed from: c */
            final /* synthetic */ AntChannel f1029c;

            b(AntChannel antChannel, e.a aVar, AntChannel antChannel2) {
                this.f1027a = antChannel;
                this.f1028b = aVar;
                this.f1029c = antChannel2;
            }

            @Override // java.lang.Runnable
            public void run() {
                synchronized (c.this.f1015e) {
                    c cVar = c.this;
                    cVar.f1016f = cVar.f1017g = false;
                }
                AntChannel antChannel = this.f1027a;
                if (antChannel != null) {
                    antChannel.m();
                }
                HandlerC0021c.this.f1021a.d(this.f1028b, this.f1029c);
            }
        }

        /* renamed from: com.dsi.ant.plugins.antplus.utility.search.c$c$c */
        /* loaded from: classes.dex */
        class RunnableC0022c implements Runnable {

            /* renamed from: a */
            final /* synthetic */ SearchResultInfo f1031a;

            /* renamed from: b */
            final /* synthetic */ AntChannel f1032b;

            RunnableC0022c(SearchResultInfo searchResultInfo, AntChannel antChannel) {
                this.f1031a = searchResultInfo;
                this.f1032b = antChannel;
            }

            @Override // java.lang.Runnable
            public void run() {
                synchronized (c.this.f1015e) {
                    c cVar = c.this;
                    cVar.f1016f = cVar.f1017g = false;
                }
                HandlerC0021c.this.f1021a.a(this.f1031a, this.f1032b);
            }
        }

        /* renamed from: com.dsi.ant.plugins.antplus.utility.search.c$c$d */
        /* loaded from: classes.dex */
        public class d implements Runnable {

            /* renamed from: a */
            final /* synthetic */ e.a f1034a;

            /* renamed from: b */
            final /* synthetic */ AntChannel f1035b;

            d(e.a aVar, AntChannel antChannel) {
                this.f1034a = aVar;
                this.f1035b = antChannel;
            }

            @Override // java.lang.Runnable
            public void run() {
                synchronized (c.this.f1015e) {
                    c cVar = c.this;
                    cVar.f1016f = cVar.f1017g = false;
                }
                HandlerC0021c.this.f1021a.d(this.f1034a, this.f1035b);
            }
        }

        public HandlerC0021c(e.b bVar, Looper looper) {
            super(looper);
            this.f1021a = bVar;
        }

        @Override // com.dsi.ant.plugins.antplus.utility.search.e.b
        public void a(SearchResultInfo searchResultInfo, AntChannel antChannel) {
            post(new RunnableC0022c(searchResultInfo, antChannel));
        }

        @Override // com.dsi.ant.plugins.antplus.utility.search.g.b
        public void b(e.a aVar, AntChannel antChannel, AntChannel antChannel2) {
            post(new b(antChannel2, aVar, antChannel));
        }

        @Override // com.dsi.ant.plugins.antplus.utility.search.g.b
        public void c(SearchResultInfo searchResultInfo, AntChannel antChannel, AntChannel antChannel2) {
            post(new a(antChannel2, searchResultInfo, antChannel));
        }

        @Override // com.dsi.ant.plugins.antplus.utility.search.e.b
        public void d(e.a aVar, AntChannel antChannel) {
            post(new d(aVar, antChannel));
        }
    }

    public c(e eVar, e eVar2, b bVar, Looper looper) {
        this.f1011a = new com.dsi.ant.plugins.antplus.utility.search.a(eVar, eVar2);
        this.f1012b = new g(eVar, eVar2, looper);
        this.f1013c = bVar;
        this.f1014d = looper;
    }

    @Override // com.dsi.ant.plugins.antplus.utility.search.e
    public void a() {
        synchronized (this.f1015e) {
            this.f1017g = true;
        }
        this.f1011a.a();
        this.f1012b.d();
    }

    @Override // com.dsi.ant.plugins.antplus.utility.search.e
    public boolean b(AntChannel antChannel, e.b bVar) {
        synchronized (this.f1015e) {
            if (this.f1016f) {
                return false;
            }
            this.f1016f = true;
            this.f1017g = false;
            this.f1018h = new HandlerC0021c(bVar, this.f1014d);
            new a("DualSearch-initation-thread", antChannel).start();
            return true;
        }
    }
}
