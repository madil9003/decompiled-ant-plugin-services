package j;

/* loaded from: classes.dex */
public class l {

    /* renamed from: a */
    private int f1943a;

    /* renamed from: b */
    private int f1944b;

    /* renamed from: c */
    private int f1945c;

    /* loaded from: classes.dex */
    public enum a {
        DBM(32),
        UNKNOWN(Integer.MIN_VALUE);


        /* renamed from: a */
        private final int f1949a;

        a(int i2) {
            this.f1949a = i2;
        }

        public static a b(int i2) {
            a aVar = DBM;
            return i2 == aVar.c() ? aVar : UNKNOWN;
        }

        public int c() {
            return this.f1949a;
        }
    }

    public l(int i2, int i3, int i4) {
        this.f1943a = i2;
        this.f1944b = i3;
        this.f1945c = i4;
    }

    public a a() {
        return a.b(this.f1943a);
    }

    public int b() {
        return this.f1943a;
    }

    public int c() {
        return this.f1944b;
    }

    public int d() {
        return this.f1945c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return lVar.f1943a == this.f1943a && lVar.f1944b == this.f1944b && lVar.f1945c == this.f1945c;
    }

    public int hashCode() {
        return ((((217 + this.f1943a) * 31) + this.f1944b) * 31) + this.f1945c;
    }

    public String toString() {
        return "RSSI: Value=" + this.f1944b + a() + ", Threshold Config=" + this.f1945c + "dB";
    }

    public l(byte[] bArr, int i2) {
        this.f1943a = j.j(bArr, i2 + 0);
        this.f1944b = j.o(bArr, i2 + 1);
        this.f1945c = j.o(bArr, i2 + 2);
    }
}
