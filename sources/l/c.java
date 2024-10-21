package l;

/* loaded from: classes.dex */
public final class c extends b {

    /* renamed from: c */
    private static final k f2543c = k.ASSIGN_CHANNEL;

    /* renamed from: a */
    private final int f2544a;

    /* renamed from: b */
    private final j.f f2545b;

    public c(j.d dVar, j.f fVar) {
        this.f2544a = dVar.d();
        this.f2545b = fVar;
    }

    @Override // l.b
    public byte[] e(int i2, int i3) {
        byte[] bArr = new byte[4];
        j.j.l(i2, bArr, 0);
        j.j.l(this.f2544a, bArr, 1);
        j.j.l(i3, bArr, 2);
        j.j.l(this.f2545b.b(), bArr, 3);
        return bArr;
    }

    @Override // l.b
    public k f() {
        return f2543c;
    }

    public j.d h() {
        return j.d.b(this.f2544a);
    }

    @Override // j.a
    public String toString() {
        return g() + "\n  Channel Type=" + h().toString() + " (" + this.f2544a + ")\n  " + this.f2545b;
    }
}
