package j;

/* loaded from: classes.dex */
public enum k {
    RESPONSE_NO_ERROR(0),
    CHANNEL_IN_WRONG_STATE(21),
    CHANNEL_NOT_OPENED(22),
    CHANNEL_ID_NOT_SET(24),
    MESSAGE_SIZE_EXCEEDS_LIMIT(39),
    INVALID_MESSAGE(40),
    INVALID_LIST_ID(48),
    INVALID_PARAMETER_PROVIDED(51),
    UNKNOWN(65535);


    /* renamed from: k */
    private static final k[] f1940k = values();

    /* renamed from: a */
    private final int f1942a;

    k(int i2) {
        this.f1942a = i2;
    }

    public static k b(int i2) {
        k kVar = UNKNOWN;
        int i3 = 0;
        while (true) {
            k[] kVarArr = f1940k;
            if (i3 >= kVarArr.length) {
                return kVar;
            }
            if (kVarArr[i3].c(i2)) {
                return kVarArr[i3];
            }
            i3++;
        }
    }

    private boolean c(int i2) {
        return i2 == this.f1942a;
    }
}
