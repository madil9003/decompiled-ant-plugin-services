package l;

/* loaded from: classes.dex */
public final class a extends b {

    /* renamed from: c */
    private static final k f2540c = k.ADD_CHANNEL_ID_TO_LIST;

    /* renamed from: a */
    private final j.b f2541a;

    /* renamed from: b */
    private final int f2542b;

    public a(j.b bVar, int i2) {
        if (i2 < 0 || i2 > 124) {
            throw new IllegalArgumentException("List Index out of range");
        }
        this.f2541a = bVar;
        this.f2542b = i2;
    }

    @Override // l.b
    public byte[] e(int i2, int i3) {
        byte[] bArr = new byte[6];
        j.j.l(i2, bArr, 0);
        System.arraycopy(this.f2541a.c(), 0, bArr, 1, 4);
        j.j.m(this.f2542b, bArr, 1, 5);
        return bArr;
    }

    @Override // l.b
    public k f() {
        return f2540c;
    }

    @Override // j.a
    public String toString() {
        return g() + "\n  " + this.f2541a.toString() + "\n  List Index=" + this.f2542b;
    }
}
