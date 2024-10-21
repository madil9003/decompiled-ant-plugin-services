package o0;

/* loaded from: classes.dex */
public enum c {
    OFF_UNSUPPORTED(0),
    CURRENT_TRACK(1),
    ALL_SONGS(2),
    CUSTOM(3),
    UNRECOGNIZED(-1);


    /* renamed from: a */
    private int f2764a;

    c(int i2) {
        this.f2764a = i2;
    }

    public static c c(int i2) {
        for (c cVar : values()) {
            if (cVar.b() == i2) {
                return cVar;
            }
        }
        c cVar2 = UNRECOGNIZED;
        cVar2.f2764a = i2;
        return cVar2;
    }

    public int b() {
        return this.f2764a;
    }
}
