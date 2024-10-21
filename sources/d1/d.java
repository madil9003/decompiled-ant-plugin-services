package d1;

import android.content.Context;
import com.dsi.ant.plugins.antplus.pccbase.a;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.DataType;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.EnumSet;
import java.util.List;
import n0.a;

/* loaded from: classes.dex */
public class d extends d1.a {

    /* renamed from: m */
    private static final String f1619m = "d";

    /* renamed from: n */
    private static final p0.c f1620n = p0.c.HEARTRATE;

    /* loaded from: classes.dex */
    public class a implements a.f {

        /* renamed from: a */
        final /* synthetic */ c f1621a;

        a(c cVar) {
            this.f1621a = cVar;
        }

        @Override // com.dsi.ant.plugins.antplus.pccbase.a.f
        /* renamed from: b */
        public void a(n0.a aVar, p0.e eVar, p0.b bVar) {
            if (!eVar.equals(p0.e.SUCCESS)) {
                d dVar = d.this;
                dVar.w(dVar.f1594k, this.f1621a, eVar, bVar);
            } else {
                c cVar = this.f1621a;
                cVar.f1616b = aVar;
                d.this.H(cVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements a.b {

        /* renamed from: a */
        final /* synthetic */ c f1623a;

        b(c cVar) {
            this.f1623a = cVar;
        }

        @Override // n0.a.b
        public void a(long j2, EnumSet enumSet, int i2, long j3, BigDecimal bigDecimal, a.EnumC0041a enumC0041a) {
            DataType dataType = DataType.f1479m;
            this.f1623a.g(dataType, j2);
            DataPoint a3 = c1.a.a(this.f1623a.a(dataType), j2);
            c1.a.d(a3, i2);
            d.this.z(this.f1623a, a3);
        }
    }

    public d(Context context) {
        super(context);
        l(this.f1594k);
    }

    private a.f G(c cVar) {
        return new a(cVar);
    }

    @Override // d1.a
    protected com.dsi.ant.plugins.antplus.pccbase.d A(c cVar) {
        h1.a.f(f1619m, "requestAccess for deviceID: " + cVar.f1615a);
        return n0.a.E(this.f1594k, cVar.f1615a, 0, G(cVar), u(cVar));
    }

    @Override // d1.a
    protected void C(c cVar, int i2) {
        DataPoint a3 = c1.a.a(cVar.a(DataType.f1479m), new Date().getTime());
        c1.a.d(a3, i2);
        z(cVar, a3);
    }

    public void H(c cVar) {
        ((n0.a) cVar.f1616b).F(new b(cVar));
    }

    @Override // d1.a
    protected List o() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(DataType.f1479m);
        return arrayList;
    }

    @Override // d1.a
    public p0.c t() {
        return f1620n;
    }
}
