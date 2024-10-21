package l;

/* loaded from: classes.dex */
public final class f extends b {

    /* renamed from: b */
    private static final k f2550b = k.CHANNEL_RF_FREQUENCY;

    /* renamed from: a */
    private final int f2551a;

    public f(int i2) {
        if (!j(i2)) {
            throw new IllegalArgumentException("RF Frequency out of range");
        }
        this.f2551a = i2;
    }

    public static int i(int i2) {
        return i2 + 2400;
    }

    public static final boolean j(int i2) {
        return j.j.d(i2, 0, 124);
    }

    @Override // l.b
    public byte[] e(int i2, int i3) {
        byte[] bArr = new byte[2];
        j.j.l(i2, bArr, 0);
        j.j.m(this.f2551a, bArr, 1, 1);
        return bArr;
    }

    @Override // l.b
    public k f() {
        return f2550b;
    }

    public int h() {
        return i(this.f2551a);
    }

    @Override // j.a
    public String toString() {
        return g() + "\n  RF frequency=" + h() + "MHz (" + this.f2551a + ")";
    }
}
