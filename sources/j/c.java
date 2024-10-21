package j;

/* loaded from: classes.dex */
public enum c {
    UNASSIGNED(0),
    ASSIGNED(1),
    SEARCHING(2),
    TRACKING(3),
    INVALID(65535);


    /* renamed from: g */
    private static final c[] f1874g = values();

    /* renamed from: a */
    private final int f1876a;

    c(int i2) {
        this.f1876a = i2;
    }

    public static c b(int i2) {
        c cVar = INVALID;
        int i3 = 0;
        while (true) {
            c[] cVarArr = f1874g;
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
        return i2 == this.f1876a;
    }
}
