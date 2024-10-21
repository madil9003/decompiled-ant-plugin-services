package j;

/* loaded from: classes.dex */
public enum e {
    RX_SEARCH_TIMEOUT(1),
    RX_FAIL(2),
    TX(3),
    TRANSFER_RX_FAILED(4),
    TRANSFER_TX_COMPLETED(5),
    TRANSFER_TX_FAILED(6),
    CHANNEL_CLOSED(7),
    RX_FAIL_GO_TO_SEARCH(8),
    CHANNEL_COLLISION(9),
    TRANSFER_TX_START(10),
    UNKNOWN(65535);


    /* renamed from: m */
    private static final e[] f1897m = values();

    /* renamed from: a */
    private final int f1899a;

    e(int i2) {
        this.f1899a = i2;
    }

    public static e b(int i2) {
        e eVar = UNKNOWN;
        int i3 = 0;
        while (true) {
            e[] eVarArr = f1897m;
            if (i3 >= eVarArr.length) {
                return eVar;
            }
            if (eVarArr[i3].c(i2)) {
                return eVarArr[i3];
            }
            i3++;
        }
    }

    private boolean c(int i2) {
        return i2 == this.f1899a;
    }

    public int d() {
        return this.f1899a;
    }
}
