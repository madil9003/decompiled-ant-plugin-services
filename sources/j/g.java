package j;

/* loaded from: classes.dex */
public class g {

    /* renamed from: a */
    private b f1903a = null;

    /* renamed from: b */
    private l f1904b = null;

    /* renamed from: c */
    private m f1905c = null;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a */
        static final /* synthetic */ int[] f1906a;

        static {
            int[] iArr = new int[k.l.values().length];
            f1906a = iArr;
            try {
                iArr[k.l.BROADCAST_DATA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1906a[k.l.ACKNOWLEDGED_DATA.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1906a[k.l.BURST_TRANSFER_DATA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public g(k.k kVar) {
        if (c(kVar)) {
            f(kVar);
        }
    }

    public static boolean c(k.b bVar) {
        int i2 = a.f1906a[bVar.h().ordinal()];
        return (i2 == 1 || i2 == 2 || i2 == 3) && bVar.a().length > 9;
    }

    private void f(k.b bVar) {
        byte[] a3 = bVar.a();
        int j2 = j.j(a3, 9);
        int i2 = 10;
        if (j.e(128, j2)) {
            this.f1903a = new b(a3, 10);
            i2 = 14;
        }
        if (j.e(64, j2)) {
            this.f1904b = new l(a3, i2);
            i2 += 3;
        }
        if (j.e(32, j2)) {
            this.f1905c = new m(a3, i2);
        }
    }

    public l a() {
        return this.f1904b;
    }

    public boolean b() {
        return this.f1903a != null;
    }

    public boolean d() {
        return this.f1904b != null;
    }

    public boolean e() {
        return this.f1905c != null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        if (gVar.b() != b() || gVar.d() != d() || gVar.e() != e()) {
            return false;
        }
        if (b() && !this.f1903a.equals(gVar.f1903a)) {
            return false;
        }
        if (!d() || this.f1904b.equals(gVar.f1904b)) {
            return !e() || this.f1905c.equals(gVar.f1905c);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = b() ? 217 + this.f1903a.hashCode() : 7;
        if (d()) {
            hashCode = (hashCode * 31) + this.f1904b.hashCode();
        }
        return e() ? (hashCode * 31) + this.f1905c.hashCode() : hashCode;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Extended data:");
        if (b()) {
            sb.append(" ");
            sb.append(this.f1903a.toString());
        }
        if (d()) {
            sb.append(" ");
            sb.append(this.f1904b.toString());
        }
        if (e()) {
            sb.append(" ");
            sb.append(this.f1905c.toString());
        }
        return sb.toString();
    }
}
