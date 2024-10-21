package o0;

/* loaded from: classes.dex */
public enum f {
    PASS(0),
    FAIL(1),
    NOT_SUPPORTED(2),
    REJECTED(3),
    PENDING(4),
    UNINITIALIZED(5),
    UNRECOGNIZED(-1);


    /* renamed from: a */
    private int f2806a;

    f(int i2) {
        this.f2806a = i2;
    }

    public static f c(int i2) {
        for (f fVar : values()) {
            if (fVar.b() == i2) {
                return fVar;
            }
        }
        f fVar2 = UNRECOGNIZED;
        fVar2.f2806a = i2;
        return fVar2;
    }

    public int b() {
        return this.f2806a;
    }
}
