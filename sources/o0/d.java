package o0;

/* loaded from: classes.dex */
public enum d {
    OFF_UNSUPPORTED(0),
    TRACK_LEVEL(1),
    ALBUM_LEVEL(2),
    CUSTOM(3),
    UNRECOGNIZED(-1);


    /* renamed from: a */
    private int f2771a;

    d(int i2) {
        this.f2771a = i2;
    }

    public static d c(int i2) {
        for (d dVar : values()) {
            if (dVar.b() == i2) {
                return dVar;
            }
        }
        d dVar2 = UNRECOGNIZED;
        dVar2.f2771a = i2;
        return dVar2;
    }

    public int b() {
        return this.f2771a;
    }
}
