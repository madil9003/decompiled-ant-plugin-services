package d1;

import android.content.Context;
import com.dsi.ant.plugins.antplus.pccbase.a;
import com.dsi.ant.plugins.antplus.pccbase.b;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.DataType;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.EnumSet;
import java.util.List;
import n0.b;

/* loaded from: classes.dex */
public class e extends d1.a {

    /* renamed from: m */
    private static final String f1625m = "e";

    /* renamed from: n */
    private static final p0.c f1626n = p0.c.STRIDE_SDM;

    /* loaded from: classes.dex */
    public class a implements b.a {
        a() {
        }

        @Override // com.dsi.ant.plugins.antplus.pccbase.b.a
        public void a(long j2, EnumSet enumSet, int i2, int i3, int i4) {
        }
    }

    /* loaded from: classes.dex */
    public class b implements b.c {
        b() {
        }

        @Override // com.dsi.ant.plugins.antplus.pccbase.b.c
        public void a(long j2, EnumSet enumSet, int i2, int i3, long j3) {
        }
    }

    /* loaded from: classes.dex */
    public class c implements b.InterfaceC0012b {
        c() {
        }

        @Override // com.dsi.ant.plugins.antplus.pccbase.b.InterfaceC0012b
        public void a(long j2, EnumSet enumSet, byte[] bArr) {
        }
    }

    /* loaded from: classes.dex */
    public class d implements a.f {

        /* renamed from: a */
        final /* synthetic */ d1.c f1630a;

        d(d1.c cVar) {
            this.f1630a = cVar;
        }

        @Override // com.dsi.ant.plugins.antplus.pccbase.a.f
        /* renamed from: b */
        public void a(n0.b bVar, p0.e eVar, p0.b bVar2) {
            if (!eVar.equals(p0.e.SUCCESS)) {
                e eVar2 = e.this;
                eVar2.w(eVar2.f1594k, this.f1630a, eVar, bVar2);
            } else {
                d1.c cVar = this.f1630a;
                cVar.f1616b = bVar;
                e.this.L(cVar);
            }
        }
    }

    /* renamed from: d1.e$e */
    /* loaded from: classes.dex */
    public class C0030e implements b.f {
        C0030e() {
        }

        @Override // n0.b.f
        public void a(long j2, EnumSet enumSet, BigDecimal bigDecimal) {
        }
    }

    /* loaded from: classes.dex */
    public class f implements b.e {
        f() {
        }

        @Override // n0.b.e
        public void a(long j2, EnumSet enumSet, BigDecimal bigDecimal) {
        }
    }

    /* loaded from: classes.dex */
    public class g implements b.d {

        /* renamed from: a */
        private BigDecimal f1634a = null;

        /* renamed from: b */
        final /* synthetic */ d1.c f1635b;

        g(d1.c cVar) {
            this.f1635b = cVar;
        }

        @Override // n0.b.d
        public void a(long j2, EnumSet enumSet, BigDecimal bigDecimal) {
            d1.c cVar = this.f1635b;
            DataType dataType = DataType.f1482p;
            long d3 = cVar.d(dataType);
            BigDecimal bigDecimal2 = this.f1634a;
            if (bigDecimal2 != null) {
                e.this.J(this.f1635b, d3, j2, bigDecimal.subtract(bigDecimal2));
            }
            this.f1635b.g(dataType, j2);
            this.f1634a = bigDecimal;
        }
    }

    /* loaded from: classes.dex */
    public class h implements b.h {

        /* renamed from: a */
        private Long f1637a = null;

        /* renamed from: b */
        final /* synthetic */ d1.c f1638b;

        h(d1.c cVar) {
            this.f1638b = cVar;
        }

        @Override // n0.b.h
        public void a(long j2, EnumSet enumSet, long j3) {
            d1.c cVar = this.f1638b;
            DataType dataType = DataType.f1463e;
            long d3 = cVar.d(dataType);
            Long l2 = this.f1637a;
            if (l2 != null) {
                e.this.K(this.f1638b, d3, j2, j3 - l2.longValue());
            }
            this.f1638b.g(dataType, j2);
            this.f1637a = Long.valueOf(j3);
        }
    }

    /* loaded from: classes.dex */
    public class i implements b.InterfaceC0042b {
        i() {
        }

        @Override // n0.b.InterfaceC0042b
        public void a(long j2, EnumSet enumSet, BigDecimal bigDecimal) {
        }
    }

    /* loaded from: classes.dex */
    public class j implements b.c {
        j() {
        }

        @Override // n0.b.c
        public void a(long j2, EnumSet enumSet, BigDecimal bigDecimal) {
        }
    }

    /* loaded from: classes.dex */
    public class k implements b.g {
        k() {
        }

        @Override // n0.b.g
        public void a(long j2, EnumSet enumSet, b.j jVar, p0.a aVar, b.i iVar, b.k kVar) {
        }
    }

    /* loaded from: classes.dex */
    public class l implements b.a {
        l() {
        }

        @Override // n0.b.a
        public void a(long j2, EnumSet enumSet, long j3) {
        }
    }

    public e(Context context) {
        super(context);
        l(context);
    }

    private a.f I(d1.c cVar) {
        return new d(cVar);
    }

    public void J(d1.c cVar, long j2, long j3, BigDecimal bigDecimal) {
        DataPoint b3 = c1.a.b(cVar.a(DataType.f1482p), j2, j3);
        c1.a.c(b3, bigDecimal);
        z(cVar, b3);
    }

    public void K(d1.c cVar, long j2, long j3, long j4) {
        DataPoint b3 = c1.a.b(cVar.a(DataType.f1463e), j2, j3);
        c1.a.e(b3, j4);
        z(cVar, b3);
    }

    @Override // d1.a
    protected com.dsi.ant.plugins.antplus.pccbase.d A(d1.c cVar) {
        h1.a.f(f1625m, "requestAccess for deviceID: " + cVar.f1615a);
        return n0.b.H(this.f1594k, cVar.f1615a, 0, I(cVar), u(cVar));
    }

    @Override // d1.a
    protected void C(d1.c cVar, int i2) {
        long time = new Date().getTime();
        DataType dataType = DataType.f1482p;
        DataPoint b3 = c1.a.b(cVar.a(dataType), cVar.d(dataType), time);
        c1.a.c(b3, new BigDecimal(i2));
        z(cVar, b3);
        DataType dataType2 = DataType.f1463e;
        DataPoint b4 = c1.a.b(cVar.a(dataType2), cVar.d(dataType2), time);
        c1.a.e(b4, i2);
        z(cVar, b4);
    }

    protected void L(d1.c cVar) {
        n0.b bVar = (n0.b) cVar.f1616b;
        bVar.N(new C0030e());
        bVar.M(new f());
        bVar.L(new g(cVar));
        bVar.P(new h(cVar));
        bVar.J(new i());
        bVar.K(new j());
        bVar.O(new k());
        bVar.I(new l());
        bVar.E(new a());
        bVar.G(new b());
        bVar.F(new c());
    }

    @Override // d1.a
    protected List o() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(DataType.f1463e);
        arrayList.add(DataType.f1482p);
        return arrayList;
    }

    @Override // d1.a
    public p0.c t() {
        return f1626n;
    }
}
