package p0;

/* loaded from: classes.dex */
public enum e {
    SUCCESS(0),
    USER_CANCELLED(-2),
    CHANNEL_NOT_AVAILABLE(-3),
    OTHER_FAILURE(-4),
    DEPENDENCY_NOT_INSTALLED(-5),
    DEVICE_ALREADY_IN_USE(-6),
    SEARCH_TIMEOUT(-7),
    ALREADY_SUBSCRIBED(-8),
    BAD_PARAMS(-9),
    ADAPTER_NOT_DETECTED(-10),
    UNRECOGNIZED(-200);


    /* renamed from: a */
    private int f2948a;

    e(int i2) {
        this.f2948a = i2;
    }

    public static e c(int i2) {
        for (e eVar : values()) {
            if (eVar.b() == i2) {
                return eVar;
            }
        }
        e eVar2 = UNRECOGNIZED;
        eVar2.f2948a = i2;
        return eVar2;
    }

    public int b() {
        return this.f2948a;
    }
}
