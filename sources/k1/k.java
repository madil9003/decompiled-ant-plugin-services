package k1;

/* loaded from: classes.dex */
public enum k {
    NO_ERROR(0),
    ERROR_INCOMPLETE_DATA(1),
    ERROR_NO_MEASUREMENT(2),
    ERROR_DATA_OUT_OF_RANGE(3),
    ERROR_IRREGULAR_HEART_RATE(4),
    INVALID(255);


    /* renamed from: a */
    protected short f2208a;

    k(short s2) {
        this.f2208a = s2;
    }

    public static k a(Short sh) {
        for (k kVar : values()) {
            if (sh.shortValue() == kVar.f2208a) {
                return kVar;
            }
        }
        return INVALID;
    }
}
