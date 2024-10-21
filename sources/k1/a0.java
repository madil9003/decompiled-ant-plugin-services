package k1;

/* loaded from: classes.dex */
public class a0 extends y0 {

    /* renamed from: b */
    private y f2096b;

    /* renamed from: c */
    private int f2097c;

    /* renamed from: e */
    private short f2099e;

    /* renamed from: a */
    private z0 f2095a = null;

    /* renamed from: d */
    private int f2098d = 2;

    public short a() {
        Short v2 = h() ? this.f2095a.v() : null;
        return v2 == null ? d1.f2140n.shortValue() : v2.shortValue();
    }

    public String b() {
        if (h()) {
            return this.f2095a.x(0);
        }
        return null;
    }

    public short c() {
        return this.f2099e;
    }

    public short d() {
        if (!h() || this.f2095a.z() == null || this.f2095a.z().equals(d1.f2137k)) {
            return (short) 0;
        }
        return this.f2095a.z().byteValue();
    }

    public short e() {
        if (!h() || this.f2095a.A() == null || this.f2095a.A().equals(d1.f2140n)) {
            return (short) 1;
        }
        return this.f2095a.A().shortValue();
    }

    public int f() {
        return this.f2097c;
    }

    public int g() {
        return this.f2098d;
    }

    public boolean h() {
        return (this.f2095a == null || this.f2096b == null) ? false : true;
    }

    public void i(y yVar) {
        this.f2096b = yVar;
    }

    public void j(z0 z0Var) {
        this.f2095a = z0Var;
        this.f2099e = z0Var.w().shortValue();
        this.f2098d = this.f2095a.y().shortValue();
    }

    public void k(short s2) {
        this.f2099e = s2;
    }

    public void l(int i2) {
        this.f2097c = i2;
    }
}
