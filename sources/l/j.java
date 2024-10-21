package l;

/* loaded from: classes.dex */
public final class j extends b {

    /* renamed from: b */
    private static final k f2562b = k.LOW_PRIORITY_SEARCH_TIMEOUT;

    /* renamed from: a */
    private final int f2563a;

    public j(j.i iVar) {
        this.f2563a = iVar.d();
    }

    @Override // l.b
    public byte[] e(int i2, int i3) {
        byte[] bArr = new byte[2];
        j.j.l(i2, bArr, 0);
        j.j.m(this.f2563a, bArr, 1, 1);
        return bArr;
    }

    @Override // l.b
    public k f() {
        return f2562b;
    }

    @Override // j.a
    public String toString() {
        return g() + "\n  Search Timeout=" + j.i.c(this.f2563a * 2500);
    }
}
