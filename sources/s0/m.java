package s0;

/* loaded from: classes.dex */
public interface m {

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a */
        public long f3255a;

        /* renamed from: b */
        public int f3256b;

        /* renamed from: c */
        public int f3257c;

        /* renamed from: d */
        public int f3258d;

        /* renamed from: e */
        public long f3259e;

        /* renamed from: f */
        public byte[] f3260f;

        public a(long j2, byte[] bArr, int i2, int i3, int i4, long j3) {
            this.f3255a = j2;
            this.f3260f = bArr;
            this.f3256b = i2;
            this.f3257c = i3;
            this.f3258d = i4;
            this.f3259e = j3;
        }

        public a(byte[] bArr, int i2, int i3, int i4, long j2) {
            this.f3260f = bArr;
            this.f3256b = i2;
            this.f3257c = i3;
            this.f3258d = i4;
            this.f3259e = j2;
        }
    }

    void a(a aVar);

    void b();

    a c(int i2, int i3, int i4, long j2);

    void close();

    void d(a aVar);
}
