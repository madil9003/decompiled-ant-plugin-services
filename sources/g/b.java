package g;

/* loaded from: classes.dex */
public enum b {
    UNKNOWN(-1),
    IO_ERROR(1),
    CHANNEL_RESPONSE(2),
    CHANNEL_RELEASING(3),
    INVALID_REQUEST(4),
    TRANSFER_IN_PROGRESS(5),
    TRANSFER_FAILED(6),
    BACKGROUND_SCAN_IN_USE(7),
    CANCELLED(8);


    /* renamed from: k */
    private static final b[] f1725k = values();

    /* renamed from: a */
    private final int f1727a;

    b(int i2) {
        this.f1727a = i2;
    }

    public static b b(int i2) {
        b bVar = UNKNOWN;
        int i3 = 0;
        while (true) {
            b[] bVarArr = f1725k;
            if (i3 >= bVarArr.length) {
                return bVar;
            }
            if (bVarArr[i3].c(i2)) {
                return bVarArr[i3];
            }
            i3++;
        }
    }

    private boolean c(int i2) {
        return i2 == this.f1727a;
    }

    public int d() {
        return this.f1727a;
    }
}
