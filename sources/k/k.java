package k;

/* loaded from: classes.dex */
public abstract class k extends b {

    /* renamed from: b */
    private byte[] f2033b;

    public k(byte[] bArr) {
        super(bArr);
        this.f2033b = null;
    }

    public j.g j() {
        return new j.g(this);
    }

    public byte[] k() {
        if (this.f2033b == null) {
            byte[] bArr = new byte[8];
            this.f2033b = bArr;
            System.arraycopy(this.f1971a, 1, bArr, 0, 8);
        }
        return this.f2033b;
    }

    public boolean l() {
        return j.g.c(this);
    }

    @Override // j.a
    public String toString() {
        StringBuilder sb = new StringBuilder(i());
        sb.append("\n  ");
        sb.append("Payload=");
        sb.append(j.j.c(k()));
        if (l()) {
            sb.append("\n  ");
            sb.append(j().toString());
        }
        return sb.toString();
    }
}
