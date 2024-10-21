package l;

/* loaded from: classes.dex */
public final class d extends b {

    /* renamed from: b */
    private static final k f2546b = k.CHANNEL_ID;

    /* renamed from: a */
    private final j.b f2547a;

    public d(j.b bVar) {
        this.f2547a = bVar;
    }

    @Override // l.b
    public byte[] e(int i2, int i3) {
        byte[] bArr = new byte[5];
        j.j.l(i2, bArr, 0);
        System.arraycopy(this.f2547a.c(), 0, bArr, 1, 4);
        return bArr;
    }

    @Override // l.b
    public k f() {
        return f2546b;
    }

    @Override // j.a
    public String toString() {
        return g() + "\n  " + this.f2547a.toString();
    }
}
