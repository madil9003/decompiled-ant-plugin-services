package p0;

/* loaded from: classes.dex */
public enum b {
    DEAD(-100),
    CLOSED(1),
    SEARCHING(2),
    TRACKING(3),
    PROCESSING_REQUEST(300),
    UNRECOGNIZED(-1);


    /* renamed from: a */
    private int f2915a;

    b(int i2) {
        this.f2915a = i2;
    }

    public static b c(int i2) {
        for (b bVar : values()) {
            if (bVar.b() == i2) {
                return bVar;
            }
        }
        b bVar2 = UNRECOGNIZED;
        bVar2.f2915a = i2;
        return bVar2;
    }

    public int b() {
        return this.f2915a;
    }
}
