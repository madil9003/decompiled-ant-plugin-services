package j;

/* loaded from: classes.dex */
public final class i extends Enum {

    /* renamed from: h */
    public static final i FIFTEEN_SECONDS;

    /* renamed from: l */
    public static final i TWENTY_FIVE_SECONDS;

    /* renamed from: m */
    public static final i f1926m = new i(6);

    /* renamed from: n */
    public static final i f1927n = new i(10);

    /* renamed from: a */
    private final int f1930a;

    /* renamed from: b */
    public static final i DISABLED = new i(0);

    /* renamed from: c */
    public static final i TWO_AND_A_HALF_SECONDS = new i(1);

    /* renamed from: d */
    public static final i FIVE_SECONDS = new i(2);

    /* renamed from: e */
    public static final i SEVEN_AND_A_HALF_SECONDS = new i(3);

    /* renamed from: f */
    public static final i TEN_SECONDS = new i(4);

    /* renamed from: g */
    public static final i TWELVE_AND_A_HALF_SECONDS = new i(5);

    /* renamed from: i */
    public static final i SEVENTEEN_AND_A_HALF_SECONDS = new i(7);

    /* renamed from: j */
    public static final i TWENTY_SECONDS = new i(8);

    /* renamed from: k */
    public static final i TWENTY_TWO_AND_A_HALF_SECONDS = new i(9);

    /* renamed from: p */
    private static final /* synthetic */ i[] f1929p = a();

    /* renamed from: o */
    private static final i[] f1928o = values();

    static {
        i iVar = new i(6);
        FIFTEEN_SECONDS = iVar;
        SEVENTEEN_AND_A_HALF_SECONDS = new i(7);
        TWENTY_SECONDS = new i(8);
        TWENTY_TWO_AND_A_HALF_SECONDS = new i(9);
        i iVar2 = new i(10);
        TWENTY_FIVE_SECONDS = iVar2;
        f1929p = a();
        f1926m = iVar;
        f1927n = iVar2;
        f1928o = values();
    }

    private i(String str, int i2, int i3) {
        super(str, i2);
        this.f1930a = i3;
    }

    private static /* synthetic */ i[] a() {
        return new i[]{DISABLED, TWO_AND_A_HALF_SECONDS, FIVE_SECONDS, SEVEN_AND_A_HALF_SECONDS, TEN_SECONDS, TWELVE_AND_A_HALF_SECONDS, FIFTEEN_SECONDS, SEVENTEEN_AND_A_HALF_SECONDS, TWENTY_SECONDS, TWENTY_TWO_AND_A_HALF_SECONDS, TWENTY_FIVE_SECONDS};
    }

    public static i c(int i2) {
        if (i2 <= 0) {
            return DISABLED;
        }
        i iVar = f1927n;
        int i3 = 0;
        while (true) {
            i[] iVarArr = f1928o;
            if (i3 >= iVarArr.length) {
                return iVar;
            }
            if (i2 <= iVarArr[i3].b()) {
                return iVarArr[i3];
            }
            i3++;
        }
    }

    public static i valueOf(String str) {
        return (i) Enum.valueOf(i.class, str);
    }

    public static i[] values() {
        return (i[]) f1929p.clone();
    }

    public int b() {
        return this.f1930a * 2500;
    }

    public int d() {
        return this.f1930a;
    }
}
