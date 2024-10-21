package l;

/* loaded from: classes.dex */
public final class o extends b {

    /* renamed from: b */
    private static final k f2598b = k.SEARCH_TIMEOUT;

    /* renamed from: a */
    private final int f2599a;

    public o(j.h hVar) {
        this.f2599a = hVar.d();
    }

    @Override // l.b
    public byte[] e(int i2, int i3) {
        byte[] bArr = new byte[2];
        j.j.l(i2, bArr, 0);
        j.j.m(this.f2599a, bArr, 1, 1);
        return bArr;
    }

    @Override // l.b
    public k f() {
        return f2598b;
    }

    @Override // j.a
    public String toString() {
        return g() + "\n  Search Timeout=" + j.h.c(this.f2599a * 2500);
    }
}
