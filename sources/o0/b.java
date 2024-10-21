package o0;

/* loaded from: classes.dex */
public enum b {
    OFF(0),
    PLAY(1),
    PAUSE(2),
    STOP(3),
    BUSY(4),
    FAST_FORWARD(5),
    REWIND(6),
    UNKNOWN(15),
    UNRECOGNIZED(-1);


    /* renamed from: a */
    private int f2757a;

    b(int i2) {
        this.f2757a = i2;
    }

    public static b c(int i2) {
        for (b bVar : values()) {
            if (bVar.b() == i2) {
                return bVar;
            }
        }
        b bVar2 = UNRECOGNIZED;
        bVar2.f2757a = i2;
        return bVar2;
    }

    public int b() {
        return this.f2757a;
    }
}
