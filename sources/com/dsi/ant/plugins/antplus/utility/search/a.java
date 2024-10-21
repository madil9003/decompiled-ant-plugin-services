package com.dsi.ant.plugins.antplus.utility.search;

import com.dsi.ant.channel.AntChannel;
import com.dsi.ant.plugins.antplus.utility.search.e;

/* loaded from: classes.dex */
public class a implements e {

    /* renamed from: a */
    private final e f979a;

    /* renamed from: b */
    private final e f980b;

    /* renamed from: c */
    private boolean f981c;

    /* renamed from: d */
    private boolean f982d;

    /* renamed from: e */
    private e.b f983e;

    /* renamed from: f */
    private final Object f984f = new Object();

    /* renamed from: g */
    private final e.b f985g = new C0017a();

    /* renamed from: h */
    private final e.b f986h = new b();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.dsi.ant.plugins.antplus.utility.search.a$a */
    /* loaded from: classes.dex */
    public class C0017a implements e.b {
        C0017a() {
        }

        @Override // com.dsi.ant.plugins.antplus.utility.search.e.b
        public void a(SearchResultInfo searchResultInfo, AntChannel antChannel) {
            e.b bVar;
            synchronized (a.this.f984f) {
                a.this.f981c = false;
                bVar = a.this.f983e;
            }
            bVar.a(searchResultInfo, antChannel);
        }

        @Override // com.dsi.ant.plugins.antplus.utility.search.e.b
        public void d(e.a aVar, AntChannel antChannel) {
            e.a aVar2;
            e.b bVar;
            e.b bVar2;
            int i2 = c.f989a[aVar.ordinal()];
            if (i2 != 1) {
                if (i2 == 2 || i2 == 3) {
                    synchronized (a.this.f984f) {
                        a.this.f981c = false;
                        bVar2 = a.this.f983e;
                    }
                    bVar2.d(aVar, antChannel);
                    return;
                }
                return;
            }
            synchronized (a.this.f984f) {
                if (a.this.f982d) {
                    a.this.f981c = false;
                    aVar2 = e.a.INTERRUPTED;
                } else {
                    a aVar3 = a.this;
                    aVar3.f981c = aVar3.f980b.b(antChannel, a.this.f986h);
                    if (a.this.f981c) {
                        aVar2 = null;
                    } else {
                        aVar2 = e.a.CRASH;
                        antChannel.m();
                        antChannel = null;
                    }
                }
                bVar = a.this.f983e;
            }
            if (aVar2 != null) {
                bVar.d(aVar2, antChannel);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements e.b {
        b() {
        }

        @Override // com.dsi.ant.plugins.antplus.utility.search.e.b
        public void a(SearchResultInfo searchResultInfo, AntChannel antChannel) {
            e.b bVar;
            synchronized (a.this.f984f) {
                a.this.f981c = false;
                bVar = a.this.f983e;
            }
            bVar.a(searchResultInfo, antChannel);
        }

        @Override // com.dsi.ant.plugins.antplus.utility.search.e.b
        public void d(e.a aVar, AntChannel antChannel) {
            e.b bVar;
            synchronized (a.this.f984f) {
                a.this.f981c = false;
                bVar = a.this.f983e;
            }
            bVar.d(aVar, antChannel);
        }
    }

    /* loaded from: classes.dex */
    static /* synthetic */ class c {

        /* renamed from: a */
        static final /* synthetic */ int[] f989a;

        static {
            int[] iArr = new int[e.a.values().length];
            f989a = iArr;
            try {
                iArr[e.a.TIMEOUT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f989a[e.a.INTERRUPTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f989a[e.a.CRASH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public a(e eVar, e eVar2) {
        this.f979a = eVar;
        this.f980b = eVar2;
    }

    @Override // com.dsi.ant.plugins.antplus.utility.search.e
    public void a() {
        synchronized (this.f984f) {
            this.f982d = true;
        }
        this.f979a.a();
        this.f980b.a();
    }

    @Override // com.dsi.ant.plugins.antplus.utility.search.e
    public boolean b(AntChannel antChannel, e.b bVar) {
        synchronized (this.f984f) {
            if (this.f981c) {
                return false;
            }
            this.f982d = false;
            this.f983e = bVar;
            boolean b3 = this.f979a.b(antChannel, this.f985g);
            this.f981c = b3;
            return b3;
        }
    }
}
