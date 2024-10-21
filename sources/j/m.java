package j;

/* loaded from: classes.dex */
public class m {

    /* renamed from: a */
    private int f1950a;

    public m(byte[] bArr, int i2) {
        this.f1950a = (int) j.k(bArr, i2 + 0, 2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && (obj instanceof m) && ((m) obj).f1950a == this.f1950a;
    }

    public int hashCode() {
        return 217 + this.f1950a;
    }

    public String toString() {
        return "Timestamp: Rx=" + this.f1950a;
    }
}
