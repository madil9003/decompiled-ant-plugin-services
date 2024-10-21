package j;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a */
    private final int f1865a;

    /* renamed from: b */
    private final boolean f1866b;

    /* renamed from: c */
    private final int f1867c;

    /* renamed from: d */
    private final int f1868d;

    public b(int i2, int i3, int i4) {
        this(i2, i3, i4, false);
    }

    public int a() {
        return this.f1865a;
    }

    public int b() {
        return this.f1867c;
    }

    public byte[] c() {
        byte[] bArr = new byte[4];
        int i2 = this.f1867c + (this.f1866b ? 128 : 0);
        j.m(this.f1865a, bArr, 2, 0);
        j.m(i2, bArr, 1, 2);
        j.m(this.f1868d, bArr, 1, 3);
        return bArr;
    }

    public boolean d() {
        return this.f1866b;
    }

    public int e() {
        return this.f1868d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.f1865a == bVar.f1865a && this.f1867c == bVar.f1867c && this.f1866b == bVar.f1866b && this.f1868d == bVar.f1868d;
    }

    public int hashCode() {
        return ((((((this.f1865a + 31) * 31) + this.f1867c) * 31) + (this.f1866b ? 1231 : 1237)) * 31) + this.f1868d;
    }

    public String toString() {
        return "Channel ID: Device number=" + this.f1865a + ", Pair=" + this.f1866b + ", Device Type=" + this.f1867c + ", Transmission Type=" + this.f1868d;
    }

    public b(int i2, int i3, int i4, boolean z2) {
        if (!j.d(i2, 0, 65535)) {
            throw new IllegalArgumentException("Device Number out of range");
        }
        if (!j.d(i3, 0, 127)) {
            throw new IllegalArgumentException("Device Type out of range");
        }
        if (!j.d(i4, 0, 255)) {
            throw new IllegalArgumentException("Transmission type out of range");
        }
        this.f1865a = i2;
        this.f1867c = i3;
        this.f1866b = z2;
        this.f1868d = i4;
    }

    public b(byte[] bArr, int i2) {
        this.f1865a = (int) j.k(bArr, i2 + 0, 2);
        int i3 = i2 + 2;
        this.f1867c = j.h(bArr, i3, 127, 0);
        this.f1866b = j.f(128, bArr, i3);
        this.f1868d = j.j(bArr, i2 + 3);
    }
}
