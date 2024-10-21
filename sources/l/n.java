package l;

/* loaded from: classes.dex */
public final class n extends b {

    /* renamed from: b */
    private static final k f2596b = k.REQUEST_MESSAGE;

    /* renamed from: a */
    private final k.l f2597a;

    public n(k.l lVar) {
        this.f2597a = lVar;
    }

    @Override // l.b
    public byte[] e(int i2, int i3) {
        byte[] bArr = new byte[2];
        j.j.m(i2, bArr, 1, 0);
        j.j.l(this.f2597a.d(), bArr, 1);
        return bArr;
    }

    @Override // l.b
    public k f() {
        return f2596b;
    }

    @Override // j.a
    public String toString() {
        return g() + "\n  Requested message=" + this.f2597a;
    }
}
