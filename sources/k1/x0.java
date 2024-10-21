package k1;

/* loaded from: classes.dex */
public class x0 extends y0 {

    /* renamed from: a */
    protected int f2527a = 255;

    /* renamed from: b */
    protected int f2528b = 0;

    /* renamed from: c */
    protected int f2529c;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof x0)) {
            return false;
        }
        x0 x0Var = (x0) obj;
        return this.f2527a == x0Var.f2527a && this.f2528b == x0Var.f2528b && this.f2529c == x0Var.f2529c;
    }

    public int hashCode() {
        return ((((47 + new Integer(this.f2527a).hashCode()) * 31) + new Integer(this.f2528b).hashCode()) * 19) + new Integer(this.f2529c).hashCode();
    }
}
