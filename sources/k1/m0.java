package k1;

/* loaded from: classes.dex */
public enum m0 {
    START(0),
    STOP(1),
    CONSECUTIVE_DEPRECIATED(2),
    MARKER(3),
    STOP_ALL(4),
    BEGIN_DEPRECIATED(5),
    END_DEPRECIATED(6),
    END_ALL_DEPRECIATED(7),
    STOP_DISABLE(8),
    STOP_DISABLE_ALL(9),
    INVALID(255);


    /* renamed from: a */
    protected short f2338a;

    m0(short s2) {
        this.f2338a = s2;
    }

    public static m0 a(Short sh) {
        for (m0 m0Var : values()) {
            if (sh.shortValue() == m0Var.f2338a) {
                return m0Var;
            }
        }
        return INVALID;
    }
}
