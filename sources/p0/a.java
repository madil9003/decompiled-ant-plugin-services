package p0;

/* loaded from: classes.dex */
public enum a {
    NEW(1),
    GOOD(2),
    OK(3),
    LOW(4),
    CRITICAL(5),
    INVALID(7),
    UNRECOGNIZED(-1);


    /* renamed from: a */
    private int f2907a;

    a(int i2) {
        this.f2907a = i2;
    }

    public static a c(int i2) {
        for (a aVar : values()) {
            if (aVar.b() == i2) {
                return aVar;
            }
        }
        a aVar2 = UNRECOGNIZED;
        aVar2.f2907a = i2;
        return aVar2;
    }

    public int b() {
        return this.f2907a;
    }
}
