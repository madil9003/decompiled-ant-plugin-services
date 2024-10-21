package com.dsi.ant.plugins.antplus.utility.search;

import android.os.Handler;
import android.os.Looper;
import com.dsi.ant.channel.AntChannel;
import com.dsi.ant.plugins.antplus.utility.search.f;

/* loaded from: classes.dex */
public class h {

    /* renamed from: a */
    private final f f1086a;

    /* renamed from: b */
    private final f f1087b;

    /* renamed from: c */
    private final d f1088c;

    /* renamed from: d */
    private final d f1089d;

    /* renamed from: e */
    private final long f1090e;

    /* renamed from: f */
    private c f1091f;

    /* renamed from: g */
    private boolean f1092g;

    /* renamed from: h */
    private boolean f1093h;

    /* renamed from: i */
    private boolean f1094i;

    /* renamed from: j */
    private final Object f1095j = new Object();

    /* renamed from: k */
    private final Runnable f1096k = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (h.this.f1095j) {
                h.this.f1094i = true;
            }
            h.this.f1086a.a();
            h.this.f1087b.a();
        }
    }

    /* loaded from: classes.dex */
    public static /* synthetic */ class b {

        /* renamed from: a */
        static final /* synthetic */ int[] f1098a;

        static {
            int[] iArr = new int[f.a.values().length];
            f1098a = iArr;
            try {
                iArr[f.a.TIMEOUT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1098a[f.a.INTERRUPTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1098a[f.a.CRASH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(SearchResultInfo searchResultInfo);

        void b();

        void d(f.a aVar, AntChannel antChannel, AntChannel antChannel2);
    }

    /* loaded from: classes.dex */
    public final class d extends Handler implements f.b {

        /* renamed from: a */
        public AntChannel f1099a;

        /* renamed from: b */
        public f.a f1100b;

        /* renamed from: c */
        public boolean f1101c;

        /* renamed from: d */
        private final f f1102d;

        /* loaded from: classes.dex */
        class a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ SearchResultInfo f1104a;

            a(SearchResultInfo searchResultInfo) {
                this.f1104a = searchResultInfo;
            }

            @Override // java.lang.Runnable
            public void run() {
                h.this.f1091f.a(this.f1104a);
            }
        }

        /* loaded from: classes.dex */
        class b implements Runnable {

            /* renamed from: a */
            final /* synthetic */ f.a f1106a;

            /* renamed from: b */
            final /* synthetic */ AntChannel f1107b;

            b(f.a aVar, AntChannel antChannel) {
                this.f1106a = aVar;
                this.f1107b = antChannel;
            }

            @Override // java.lang.Runnable
            public void run() {
                d dVar;
                synchronized (h.this.f1095j) {
                    int i2 = b.f1098a[this.f1106a.ordinal()];
                    if (i2 != 1) {
                        if (i2 != 2) {
                            if (i2 != 3) {
                            }
                            dVar = d.this;
                            dVar.f1100b = this.f1106a;
                            dVar.f1099a = this.f1107b;
                        } else {
                            synchronized (h.this.f1095j) {
                                if (h.this.f1094i) {
                                    d dVar2 = d.this;
                                    dVar2.f1100b = f.a.TIMEOUT;
                                    dVar2.f1099a = this.f1107b;
                                    dVar2.f1101c = true;
                                } else {
                                    dVar = d.this;
                                    dVar.f1100b = this.f1106a;
                                    dVar.f1099a = this.f1107b;
                                }
                            }
                        }
                        dVar.f1101c = true;
                    } else {
                        if (h.this.f1094i) {
                            dVar = d.this;
                            dVar.f1100b = f.a.TIMEOUT;
                            dVar.f1099a = this.f1107b;
                        } else if (h.this.f1093h) {
                            dVar = d.this;
                            dVar.f1100b = f.a.INTERRUPTED;
                            dVar.f1099a = this.f1107b;
                        } else if (!d.this.f1102d.b(this.f1107b, d.this)) {
                            d.this.f1100b = f.a.CRASH;
                            this.f1107b.m();
                            dVar = d.this;
                            dVar.f1099a = null;
                        }
                        dVar.f1101c = true;
                    }
                }
                h.this.i();
            }
        }

        /* loaded from: classes.dex */
        class c implements Runnable {
            c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                h.this.f1091f.b();
            }
        }

        public d(Looper looper, f fVar) {
            super(looper);
            this.f1102d = fVar;
        }

        @Override // com.dsi.ant.plugins.antplus.utility.search.f.b
        public void a(SearchResultInfo searchResultInfo) {
            post(new a(searchResultInfo));
        }

        @Override // com.dsi.ant.plugins.antplus.utility.search.f.b
        public void b() {
            post(new c());
        }

        @Override // com.dsi.ant.plugins.antplus.utility.search.f.b
        public void c(f.a aVar, AntChannel antChannel) {
            post(new b(aVar, antChannel));
        }
    }

    public h(f fVar, f fVar2, long j2, Looper looper) {
        this.f1086a = fVar;
        this.f1087b = fVar2;
        this.f1090e = j2;
        this.f1088c = new d(looper, fVar);
        this.f1089d = new d(looper, fVar2);
    }

    public void i() {
        synchronized (this.f1095j) {
            d dVar = this.f1088c;
            if (dVar.f1101c && dVar.f1100b == f.a.CRASH) {
                this.f1087b.a();
            }
            d dVar2 = this.f1089d;
            if (dVar2.f1101c && dVar2.f1100b == f.a.CRASH) {
                this.f1086a.a();
            }
            d dVar3 = this.f1088c;
            if (dVar3.f1101c && this.f1089d.f1101c) {
                boolean z2 = false;
                this.f1092g = false;
                dVar3.removeCallbacks(this.f1096k);
                c cVar = this.f1091f;
                this.f1091f = null;
                d dVar4 = this.f1088c;
                AntChannel antChannel = dVar4.f1099a;
                d dVar5 = this.f1089d;
                AntChannel antChannel2 = dVar5.f1099a;
                f.a aVar = dVar4.f1100b;
                int i2 = b.f1098a[dVar5.f1100b.ordinal()];
                if (i2 != 2) {
                    if (i2 != 3) {
                    }
                    z2 = true;
                } else if (aVar != f.a.CRASH) {
                    z2 = true;
                }
                if (z2) {
                    aVar = this.f1089d.f1100b;
                    antChannel2 = antChannel;
                    antChannel = antChannel2;
                }
                cVar.d(aVar, antChannel, antChannel2);
            }
        }
    }

    public void j() {
        synchronized (this.f1095j) {
            this.f1093h = true;
        }
        this.f1086a.a();
        this.f1087b.a();
    }

    public void k(int i2) {
        this.f1086a.c(i2);
        this.f1087b.c(i2);
    }

    public boolean l(AntChannel antChannel, AntChannel antChannel2, c cVar) {
        synchronized (this.f1095j) {
            if (this.f1092g) {
                return false;
            }
            this.f1092g = true;
            this.f1093h = false;
            this.f1094i = false;
            d dVar = this.f1088c;
            dVar.f1101c = false;
            this.f1089d.f1101c = false;
            this.f1091f = cVar;
            long j2 = this.f1090e;
            if (j2 > 0) {
                dVar.postDelayed(this.f1096k, j2);
            }
            if (!this.f1086a.b(antChannel, this.f1088c)) {
                synchronized (this.f1095j) {
                    this.f1092g = false;
                    this.f1088c.removeCallbacks(this.f1096k);
                }
                return false;
            }
            if (!this.f1087b.b(antChannel2, this.f1089d)) {
                synchronized (this.f1095j) {
                    antChannel2.m();
                    d dVar2 = this.f1089d;
                    dVar2.f1100b = f.a.CRASH;
                    dVar2.f1099a = null;
                    dVar2.f1101c = true;
                }
                this.f1086a.a();
            }
            return true;
        }
    }
}
