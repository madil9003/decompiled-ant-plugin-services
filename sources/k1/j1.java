package k1;

/* loaded from: classes.dex */
public enum j1 {
    NORMAL(0),
    IRREGULAR(1),
    INVALID(255);


    /* renamed from: a */
    protected short f2198a;

    j1(short s2) {
        this.f2198a = s2;
    }

    public static j1 a(Short sh) {
        for (j1 j1Var : values()) {
            if (sh.shortValue() == j1Var.f2198a) {
                return j1Var;
            }
        }
        return INVALID;
    }
}
