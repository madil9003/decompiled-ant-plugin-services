package k;

/* loaded from: classes.dex */
public class m extends b {

    /* renamed from: c */
    private static final l f2047c = l.SERIAL_NUMBER;

    /* renamed from: b */
    private final long f2048b;

    public m(byte[] bArr) {
        super(bArr);
        this.f2048b = j.j.k(bArr, 0, 4);
    }

    @Override // k.b
    public l h() {
        return f2047c;
    }

    @Override // j.a
    public String toString() {
        return i() + "\n  Serial number=" + this.f2048b;
    }
}
