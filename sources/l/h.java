package l;

/* loaded from: classes.dex */
public final class h extends b {

    /* renamed from: c */
    private static final k f2553c = k.CONFIG_ID_LIST;

    /* renamed from: a */
    private final int f2554a;

    /* renamed from: b */
    private final boolean f2555b;

    public h(int i2, boolean z2) {
        if (i2 < 0 || i2 > 4) {
            throw new IllegalArgumentException("List Index out of range");
        }
        this.f2554a = i2;
        this.f2555b = z2;
    }

    @Override // l.b
    public byte[] e(int i2, int i3) {
        byte[] bArr = new byte[3];
        j.j.l(i2, bArr, 0);
        j.j.m(this.f2554a, bArr, 1, 1);
        j.j.n(this.f2555b, bArr, 2);
        return bArr;
    }

    @Override // l.b
    public k f() {
        return f2553c;
    }

    @Override // j.a
    public String toString() {
        StringBuilder sb = new StringBuilder(g());
        sb.append("\n  ");
        sb.append("Size=");
        sb.append(this.f2554a);
        sb.append("\n  ");
        sb.append(this.f2555b ? "Exclude" : "Include");
        return sb.toString();
    }
}
