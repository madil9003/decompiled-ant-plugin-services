package j;

/* loaded from: classes.dex */
public enum d {
    BIDIRECTIONAL_SLAVE(0),
    BIDIRECTIONAL_MASTER(16),
    SHARED_BIDIRECTIONAL_SLAVE(32),
    SHARED_BIDIRECTIONAL_MASTER(48),
    SLAVE_RECEIVE_ONLY(64),
    UNKNOWN(65535);


    /* renamed from: h */
    private static final d[] f1883h = values();

    /* renamed from: a */
    private int f1885a;

    d(int i2) {
        this.f1885a = i2;
    }

    public static d b(int i2) {
        d dVar = UNKNOWN;
        int i3 = 0;
        while (true) {
            d[] dVarArr = f1883h;
            if (i3 >= dVarArr.length) {
                break;
            }
            if (dVarArr[i3].c(i2)) {
                dVar = dVarArr[i3];
                break;
            }
            i3++;
        }
        dVar.f1885a = i2;
        return dVar;
    }

    private boolean c(int i2) {
        return i2 == this.f1885a;
    }

    public int d() {
        return this.f1885a;
    }
}
