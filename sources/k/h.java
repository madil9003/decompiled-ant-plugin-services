package k;

/* loaded from: classes.dex */
public class h extends b {

    /* renamed from: c */
    private static final l f2024c = l.CHANNEL_ID;

    /* renamed from: b */
    private final j.b f2025b;

    public h(byte[] bArr) {
        super(bArr);
        this.f2025b = new j.b(bArr, 1);
    }

    @Override // k.b
    public l h() {
        return f2024c;
    }

    public j.b j() {
        return this.f2025b;
    }

    @Override // j.a
    public String toString() {
        return i() + "\n  " + this.f2025b.toString();
    }
}
