package l;

/* loaded from: classes.dex */
public final class e extends b {

    /* renamed from: b */
    private static final k f2548b = k.CHANNEL_PERIOD;

    /* renamed from: a */
    private final int f2549a;

    public e(int i2) {
        this.f2549a = i2;
    }

    public static double i(int i2) {
        return 32768.0d / i2;
    }

    @Override // l.b
    public byte[] e(int i2, int i3) {
        byte[] bArr = new byte[3];
        j.j.l(i2, bArr, 0);
        j.j.m(this.f2549a, bArr, 2, 1);
        return bArr;
    }

    @Override // l.b
    public k f() {
        return f2548b;
    }

    public double h() {
        return i(this.f2549a);
    }

    @Override // j.a
    public String toString() {
        return g() + "\n  Channel period=" + h() + "Hz (" + this.f2549a + ")";
    }
}
