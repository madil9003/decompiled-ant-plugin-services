package p0;

/* loaded from: classes.dex */
public enum f {
    SUCCESS(0),
    FAIL_CANCELLED(-2),
    UNRECOGNIZED(-3),
    FAIL_OTHER(-10),
    FAIL_ALREADY_BUSY_EXTERNAL(-20),
    FAIL_DEVICE_COMMUNICATION_FAILURE(-40),
    FAIL_DEVICE_TRANSMISSION_LOST(-41),
    FAIL_BAD_PARAMS(-50),
    FAIL_NO_PERMISSION(-60),
    FAIL_NOT_SUPPORTED(-61),
    FAIL_PLUGINS_SERVICE_VERSION(-62);


    /* renamed from: a */
    private int f2961a;

    f(int i2) {
        this.f2961a = i2;
    }

    public static f c(int i2) {
        for (f fVar : values()) {
            if (fVar.b() == i2) {
                return fVar;
            }
        }
        f fVar2 = UNRECOGNIZED;
        fVar2.f2961a = i2;
        return fVar2;
    }

    public int b() {
        return this.f2961a;
    }
}
