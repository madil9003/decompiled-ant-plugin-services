package g1;

import java.math.BigDecimal;
import java.util.EnumSet;
import n0.a;

/* loaded from: classes.dex */
public class b implements a.b {

    /* renamed from: a */
    private a.b f1795a;

    /* renamed from: c */
    private EnumSet f1797c;

    /* renamed from: d */
    private int f1798d;

    /* renamed from: f */
    private a.EnumC0041a f1800f;

    /* renamed from: b */
    private long f1796b = -1;

    /* renamed from: e */
    private long f1799e = -1;

    public b(a.b bVar) {
        this.f1795a = bVar;
    }

    @Override // n0.a.b
    public void a(long j2, EnumSet enumSet, int i2, long j3, BigDecimal bigDecimal, a.EnumC0041a enumC0041a) {
        this.f1796b = j2;
        this.f1797c = enumSet;
        this.f1798d = i2;
        this.f1799e = j3;
        this.f1800f = enumC0041a;
    }

    public void b(long j2, EnumSet enumSet, BigDecimal bigDecimal) {
        long j3 = this.f1796b;
        if (j2 == j3) {
            this.f1795a.a(j3, this.f1797c, this.f1798d, this.f1799e, bigDecimal, this.f1800f);
        }
    }
}
