package w0;

import com.dsi.ant.message.ipc.AntMessageParcel;
import com.dsi.ant.plugins.antplus.utility.search.SearchResultInfo;
import k.l;
import w0.b;

/* loaded from: classes.dex */
public class c extends u0.b {

    /* renamed from: q */
    private final w0.b f3515q;

    /* renamed from: r */
    private b.c f3516r;

    /* renamed from: s */
    private volatile boolean f3517s;

    /* renamed from: t */
    private final b.d f3518t;

    /* renamed from: u */
    private final b.d f3519u;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements b.d {
        a() {
        }

        @Override // w0.b.d
        public void a(b.c cVar, SearchResultInfo searchResultInfo) {
            int i2 = b.f3521a[cVar.ordinal()];
            if (i2 == 1 || i2 == 2) {
                return;
            }
            c.this.f3518t.a(cVar, searchResultInfo);
        }
    }

    /* loaded from: classes.dex */
    static /* synthetic */ class b {

        /* renamed from: a */
        static final /* synthetic */ int[] f3521a;

        static {
            int[] iArr = new int[b.c.values().length];
            f3521a = iArr;
            try {
                iArr[b.c.EXECUTOR_SHUTDOWN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3521a[b.c.INTERRUPTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3521a[b.c.FILTERED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3521a[b.c.SUCCESS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3521a[b.c.TIME_OUT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public c(b.C0065b c0065b, b.d dVar) {
        a aVar = new a();
        this.f3519u = aVar;
        this.f3518t = dVar;
        this.f3515q = new w0.b(c0065b, aVar);
    }

    public void C(int i2) {
        this.f3515q.C(i2);
    }

    public void D() {
        this.f3515q.D();
    }

    @Override // u0.b
    public void d() {
        while (!this.f3517s) {
            x(this.f3515q);
        }
        this.f3518t.a(this.f3516r, null);
    }

    @Override // u0.b
    public String k() {
        return "Repeating search task";
    }

    @Override // u0.b
    public void o() {
        this.f3516r = b.c.EXECUTOR_SHUTDOWN;
        this.f3517s = true;
    }

    @Override // u0.b
    public boolean p(int i2) {
        this.f3516r = b.c.INTERRUPTED;
        this.f3517s = true;
        return true;
    }

    @Override // u0.b
    public void s() {
        this.f3517s = false;
    }

    @Override // u0.b
    public void u(l lVar, AntMessageParcel antMessageParcel) {
    }

    public c(b.C0065b c0065b, d dVar, b.d dVar2) {
        a aVar = new a();
        this.f3519u = aVar;
        this.f3518t = dVar2;
        this.f3515q = new w0.b(c0065b, dVar, aVar);
    }
}
