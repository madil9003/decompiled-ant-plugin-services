package o0;

/* loaded from: classes.dex */
public enum i {
    OFF(0),
    PLAY(1),
    PAUSE(2),
    STOP(3),
    BUSY(4),
    FAST_FORWARD(5),
    REWIND(6),
    RECORD(7),
    UNKNOWN(255),
    UNRECOGNIZED(-1);


    /* renamed from: a */
    private int f2839a;

    i(int i2) {
        this.f2839a = i2;
    }

    public static i c(int i2) {
        for (i iVar : values()) {
            if (iVar.b() == i2) {
                return iVar;
            }
        }
        i iVar2 = UNRECOGNIZED;
        iVar2.f2839a = i2;
        return iVar2;
    }

    public int b() {
        return this.f2839a;
    }
}
