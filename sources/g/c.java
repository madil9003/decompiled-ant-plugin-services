package g;

/* loaded from: classes.dex */
public enum c {
    UNKNOWN(-1),
    SERVICE_INITIALIZING(1),
    NO_ADAPTERS_EXIST(11),
    ANT_DISABLED_AIRPLANE_MODE_ON(12),
    ANT_NOT_ENABLED(13),
    ALL_CHANNELS_IN_USE_LEGACY(20),
    ALL_CHANNELS_IN_USE(21),
    NO_CHANNELS_MATCH_CRITERIA(22),
    RELEASE_PROCESSING(23),
    NETWORK_NOT_AVAILABLE(31);


    /* renamed from: l */
    private static final c[] f1738l = values();

    /* renamed from: a */
    private final int f1740a;

    c(int i2) {
        this.f1740a = i2;
    }

    public static c b(int i2) {
        c cVar = UNKNOWN;
        int i3 = 0;
        while (true) {
            c[] cVarArr = f1738l;
            if (i3 >= cVarArr.length) {
                return cVar;
            }
            if (cVarArr[i3].c(i2)) {
                return cVarArr[i3];
            }
            i3++;
        }
    }

    private boolean c(int i2) {
        return i2 == this.f1740a;
    }

    public int d() {
        return this.f1740a;
    }
}
