package o0;

/* loaded from: classes.dex */
public enum h {
    MENU_UP(0),
    MENU_DOWN(1),
    MENU_SELECT(2),
    MENU_BACK(3),
    HOME(4),
    START(32),
    STOP(33),
    RESET(34),
    LENGTH(35),
    LAP(36),
    NO_COMMAND(65535),
    UNRECOGNIZED(-1);


    /* renamed from: a */
    private int f2827a;

    h(int i2) {
        this.f2827a = i2;
    }

    public static h e(int i2) {
        for (h hVar : values()) {
            if (hVar.b() == i2) {
                return hVar;
            }
        }
        h hVar2 = UNRECOGNIZED;
        hVar2.f2827a = i2;
        return hVar2;
    }

    public int b() {
        return this.f2827a;
    }

    public byte c() {
        return (byte) (this.f2827a & 255);
    }

    public byte d() {
        return (byte) ((this.f2827a & 65280) >> 8);
    }
}
