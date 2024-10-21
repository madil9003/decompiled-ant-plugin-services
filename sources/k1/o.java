package k1;

/* loaded from: classes.dex */
public abstract class o {

    /* renamed from: a */
    private static final int[] f2347a = {0, 52225, 55297, 5120, 61441, 15360, 10240, 58369, 40961, 27648, 30720, 46081, 20480, 39937, 34817, 17408};

    public static final int a(int i2, byte b3) {
        int[] iArr = f2347a;
        int i3 = (((i2 >> 4) & 4095) ^ iArr[i2 & 15]) ^ iArr[b3 & 15];
        return (((i3 >> 4) & 4095) ^ iArr[i3 & 15]) ^ iArr[(b3 >> 4) & 15];
    }
}
