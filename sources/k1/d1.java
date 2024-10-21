package k1;

import java.math.BigInteger;
import java.util.HashMap;

/* loaded from: classes.dex */
public abstract class d1 {
    public static final String A;
    public static final Float B;
    public static final Float C;
    public static final Float D;
    public static final Double E;
    public static final Double F;
    public static final Double G;
    public static final Short H;
    public static final Short I;
    public static final Short J;
    public static final Integer K;
    public static final Integer L;
    public static final Integer M;
    public static final Long N;
    public static final Long O;
    public static final Long P;
    public static final Short Q;
    public static final Short R;
    public static final Short S;
    public static final Long T;
    public static final Long U;
    public static final Long V;
    public static final BigInteger W;
    public static final BigInteger X;
    public static final BigInteger Y;
    public static final BigInteger Z;

    /* renamed from: a */
    public static boolean f2120a = false;

    /* renamed from: a0 */
    public static final BigInteger f2121a0;

    /* renamed from: b0 */
    public static final BigInteger f2123b0;

    /* renamed from: c0 */
    public static final int[] f2125c0;

    /* renamed from: d0 */
    public static final byte[] f2127d0;

    /* renamed from: e0 */
    public static final HashMap f2129e0;

    /* renamed from: f0 */
    public static final HashMap f2131f0;

    /* renamed from: g0 */
    public static final HashMap f2133g0;

    /* renamed from: h */
    public static final Short f2134h;

    /* renamed from: i */
    public static final Byte f2135i;

    /* renamed from: j */
    public static final Byte f2136j;

    /* renamed from: k */
    public static final Byte f2137k;

    /* renamed from: l */
    public static final Short f2138l;

    /* renamed from: m */
    public static final Short f2139m;

    /* renamed from: n */
    public static final Short f2140n;

    /* renamed from: o */
    public static final Short f2141o;

    /* renamed from: p */
    public static final Short f2142p;

    /* renamed from: q */
    public static final Short f2143q;

    /* renamed from: r */
    public static final Integer f2144r;

    /* renamed from: s */
    public static final Integer f2145s;

    /* renamed from: t */
    public static final Integer f2146t;

    /* renamed from: u */
    public static final Integer f2147u;

    /* renamed from: v */
    public static final Integer f2148v;

    /* renamed from: w */
    public static final Integer f2149w;

    /* renamed from: x */
    public static final Long f2150x;

    /* renamed from: y */
    public static final Long f2151y;

    /* renamed from: z */
    public static final Long f2152z;

    /* renamed from: b */
    public static final int f2122b = a.a().d();

    /* renamed from: c */
    public static final int f2124c = a.a().b();

    /* renamed from: d */
    public static final int f2126d = a.a().c();

    /* renamed from: e */
    public static final String f2128e = new String();

    /* renamed from: f */
    public static final Short f2130f = (short) 255;

    /* renamed from: g */
    public static final Short f2132g = (short) 0;

    /* loaded from: classes.dex */
    public enum a {
        V1_0(1, 0),
        V2_0(2, 0);


        /* renamed from: a */
        private final int f2156a;

        /* renamed from: b */
        private final int f2157b;

        a(int i2, int i3) {
            this.f2156a = i2;
            this.f2157b = i3;
        }

        public static a a() {
            return V2_0;
        }

        public int b() {
            return this.f2156a;
        }

        public int c() {
            return this.f2157b;
        }

        public int d() {
            return this.f2157b | (this.f2156a << 4);
        }
    }

    static {
        Short decode = Short.decode("0xFF");
        f2134h = decode;
        f2135i = Byte.MAX_VALUE;
        f2136j = Byte.MIN_VALUE;
        Byte decode2 = Byte.decode("0x7F");
        f2137k = decode2;
        f2138l = (short) 255;
        f2139m = (short) 0;
        Short decode3 = Short.decode("0xFF");
        f2140n = decode3;
        f2141o = Short.MAX_VALUE;
        f2142p = Short.MIN_VALUE;
        Short decode4 = Short.decode("0x7FFF");
        f2143q = decode4;
        Integer decode5 = Integer.decode("0xFFFF");
        f2144r = decode5;
        Integer decode6 = Integer.decode("0");
        f2145s = decode6;
        Integer decode7 = Integer.decode("0xFFFF");
        f2146t = decode7;
        f2147u = Integer.MAX_VALUE;
        f2148v = Integer.MIN_VALUE;
        Integer decode8 = Integer.decode("0x7FFFFFFF");
        f2149w = decode8;
        Long decode9 = Long.decode("0xFFFFFFFF");
        f2150x = decode9;
        Long decode10 = Long.decode("0");
        f2151y = decode10;
        Long decode11 = Long.decode("0xFFFFFFFF");
        f2152z = decode11;
        String str = new String();
        A = str;
        Float valueOf = Float.valueOf(Float.intBitsToFloat(-1));
        B = valueOf;
        Float valueOf2 = Float.valueOf(Float.MAX_VALUE);
        C = valueOf2;
        Float valueOf3 = Float.valueOf(-3.4028235E38f);
        D = valueOf3;
        Double valueOf4 = Double.valueOf(Double.longBitsToDouble(-1L));
        E = valueOf4;
        Double valueOf5 = Double.valueOf(Double.MAX_VALUE);
        F = valueOf5;
        Double valueOf6 = Double.valueOf(-1.7976931348623157E308d);
        G = valueOf6;
        H = (short) 255;
        I = (short) 0;
        Short decode12 = Short.decode("0x00");
        J = decode12;
        K = 65535;
        L = 0;
        Integer decode13 = Integer.decode("0x0000");
        M = decode13;
        Long decode14 = Long.decode("0xFFFFFFFF");
        N = decode14;
        Long decode15 = Long.decode("0");
        O = decode15;
        Long decode16 = Long.decode("0x00000000");
        P = decode16;
        Q = (short) 255;
        R = (short) 0;
        S = (short) 255;
        T = Long.MAX_VALUE;
        U = Long.MIN_VALUE;
        Long decode17 = Long.decode("0x7FFFFFFFFFFFFFFF");
        V = decode17;
        BigInteger bigInteger = new BigInteger("FFFFFFFFFFFFFFFF", 16);
        W = bigInteger;
        BigInteger bigInteger2 = new BigInteger("00000000000000000");
        X = bigInteger2;
        BigInteger bigInteger3 = new BigInteger("FFFFFFFFFFFFFFFF", 16);
        Y = bigInteger3;
        BigInteger bigInteger4 = new BigInteger("FFFFFFFFFFFFFFFF", 16);
        Z = bigInteger4;
        BigInteger bigInteger5 = new BigInteger("0000000000000000");
        f2121a0 = bigInteger5;
        BigInteger bigInteger6 = new BigInteger("0000000000000000", 16);
        f2123b0 = bigInteger6;
        f2125c0 = new int[]{1, 1, 1, 2, 2, 4, 4, 1, 4, 8, 1, 2, 4, 1, 8, 8, 8};
        f2127d0 = new byte[]{-17, -69, -65};
        HashMap hashMap = new HashMap(20);
        f2129e0 = hashMap;
        hashMap.put(0, decode);
        hashMap.put(1, decode2);
        hashMap.put(2, decode3);
        hashMap.put(131, decode4);
        hashMap.put(132, decode7);
        hashMap.put(133, decode8);
        hashMap.put(134, decode11);
        hashMap.put(7, str);
        hashMap.put(136, valueOf);
        hashMap.put(137, valueOf4);
        hashMap.put(10, decode12);
        hashMap.put(139, decode13);
        hashMap.put(140, decode16);
        hashMap.put(13, (short) 255);
        hashMap.put(142, decode17);
        hashMap.put(143, bigInteger3);
        hashMap.put(144, bigInteger6);
        HashMap hashMap2 = new HashMap(20);
        f2131f0 = hashMap2;
        hashMap2.put(0, (short) 0);
        hashMap2.put(1, Byte.MIN_VALUE);
        hashMap2.put(2, (short) 0);
        hashMap2.put(131, Short.MIN_VALUE);
        hashMap2.put(132, decode6);
        hashMap2.put(133, Integer.MIN_VALUE);
        hashMap2.put(134, decode10);
        hashMap2.put(136, valueOf3);
        hashMap2.put(137, valueOf6);
        hashMap2.put(10, (short) 0);
        hashMap2.put(139, 0);
        hashMap2.put(140, decode15);
        hashMap2.put(13, (short) 0);
        hashMap2.put(142, Long.MIN_VALUE);
        hashMap2.put(143, bigInteger2);
        hashMap2.put(144, bigInteger5);
        HashMap hashMap3 = new HashMap(20);
        f2133g0 = hashMap3;
        hashMap3.put(0, (short) 255);
        hashMap3.put(1, Byte.MAX_VALUE);
        hashMap3.put(2, (short) 255);
        hashMap3.put(131, Short.MAX_VALUE);
        hashMap3.put(132, decode5);
        hashMap3.put(133, Integer.MAX_VALUE);
        hashMap3.put(134, decode9);
        hashMap3.put(136, valueOf2);
        hashMap3.put(137, valueOf5);
        hashMap3.put(10, (short) 255);
        hashMap3.put(139, 65535);
        hashMap3.put(140, decode14);
        hashMap3.put(13, (short) 255);
        hashMap3.put(142, Long.MAX_VALUE);
        hashMap3.put(143, bigInteger);
        hashMap3.put(144, bigInteger4);
    }
}
