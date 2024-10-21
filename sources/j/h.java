package j;

/* loaded from: classes.dex */
public final class h extends Enum {

    /* renamed from: b */
    public static final h DISABLED;

    /* renamed from: d */
    public static final h FIVE_SECONDS;

    /* renamed from: e */
    public static final h f1910e = new h(0);

    /* renamed from: f */
    public static final h f1911f = new h(2);

    /* renamed from: a */
    private final int f1914a;

    /* renamed from: c */
    public static final h TWO_AND_A_HALF_SECONDS = new h(1);

    /* renamed from: h */
    private static final /* synthetic */ h[] f1913h = a();

    /* renamed from: g */
    private static final h[] f1912g = values();

    static {
        h hVar = new h(0);
        DISABLED = hVar;
        TWO_AND_A_HALF_SECONDS = new h(1);
        h hVar2 = new h(2);
        FIVE_SECONDS = hVar2;
        f1913h = a();
        f1910e = hVar;
        f1911f = hVar2;
        f1912g = values();
    }

    private h(String str, int i2, int i3) {
        super(str, i2);
        this.f1914a = i3;
    }

    private static /* synthetic */ h[] a() {
        return new h[]{DISABLED, TWO_AND_A_HALF_SECONDS, FIVE_SECONDS};
    }

    public static h c(int i2) {
        if (i2 <= 0) {
            return DISABLED;
        }
        h hVar = f1911f;
        int i3 = 0;
        while (true) {
            h[] hVarArr = f1912g;
            if (i3 >= hVarArr.length) {
                return hVar;
            }
            if (i2 <= hVarArr[i3].b()) {
                return hVarArr[i3];
            }
            i3++;
        }
    }

    public static h valueOf(String str) {
        return (h) Enum.valueOf(h.class, str);
    }

    public static h[] values() {
        return (h[]) f1913h.clone();
    }

    public int b() {
        return this.f1914a * 2500;
    }

    public int d() {
        return this.f1914a;
    }
}
