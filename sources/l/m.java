package l;

/* loaded from: classes.dex */
public final class m extends b {

    /* renamed from: b */
    private static final k f2594b = k.PROXIMITY_SEARCH;

    /* renamed from: a */
    private final int f2595a;

    public m(int i2) {
        if (!j.j.d(i2, 0, 10)) {
            throw new IllegalArgumentException("Search threshold outside valid range");
        }
        this.f2595a = i2;
    }

    @Override // l.b
    public byte[] e(int i2, int i3) {
        byte[] bArr = new byte[5];
        j.j.m(i2, bArr, 1, 0);
        j.j.l(this.f2595a, bArr, 1);
        return bArr;
    }

    @Override // l.b
    public k f() {
        return f2594b;
    }

    @Override // j.a
    public String toString() {
        StringBuilder sb = new StringBuilder(g());
        sb.append("\n  ");
        sb.append("Search threshold bin=");
        int i2 = this.f2595a;
        if (i2 == 0) {
            sb.append("[Proximity search disabled]");
        } else {
            sb.append(i2);
        }
        return sb.toString();
    }
}
