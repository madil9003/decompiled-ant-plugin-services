package k1;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes.dex */
public class x {
    private static boolean H = false;
    private int E;
    private int F;
    private byte[] G;

    /* renamed from: a */
    private boolean f2469a;

    /* renamed from: b */
    private e f2470b;

    /* renamed from: c */
    private byte f2471c;

    /* renamed from: d */
    private byte f2472d;

    /* renamed from: e */
    private long f2473e;

    /* renamed from: f */
    private long f2474f;

    /* renamed from: g */
    private int f2475g;

    /* renamed from: h */
    private s1 f2476h;

    /* renamed from: i */
    private int f2477i;

    /* renamed from: m */
    private int f2481m;

    /* renamed from: n */
    private int f2482n;

    /* renamed from: o */
    private int f2483o;

    /* renamed from: p */
    private int f2484p;

    /* renamed from: r */
    private int f2486r;

    /* renamed from: s */
    private long f2487s;

    /* renamed from: v */
    private boolean f2490v;

    /* renamed from: w */
    private InputStream f2491w;

    /* renamed from: z */
    private String f2494z;

    /* renamed from: j */
    private v1[] f2478j = new v1[16];

    /* renamed from: k */
    private HashMap f2479k = new HashMap();

    /* renamed from: l */
    private HashMap f2480l = new HashMap();

    /* renamed from: q */
    private byte[] f2485q = new byte[255];

    /* renamed from: u */
    private c f2489u = new c();

    /* renamed from: y */
    private boolean f2493y = false;
    private int A = 0;
    private ArrayList B = new ArrayList();
    private ArrayList C = new ArrayList();
    private ArrayList D = new ArrayList();

    /* renamed from: t */
    private long f2488t = 0;

    /* renamed from: x */
    private boolean f2492x = true;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a */
        static final /* synthetic */ int[] f2495a;

        /* renamed from: b */
        static final /* synthetic */ int[] f2496b;

        static {
            int[] iArr = new int[e.values().length];
            f2496b = iArr;
            try {
                iArr[e.FILE_HDR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2496b[e.RECORD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2496b[e.RESERVED1.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2496b[e.ARCH.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f2496b[e.MESG_NUM_0.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f2496b[e.MESG_NUM_1.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f2496b[e.NUM_FIELDS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f2496b[e.FIELD_NUM.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f2496b[e.FIELD_SIZE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f2496b[e.FIELD_TYPE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f2496b[e.NUM_DEV_FIELDS.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f2496b[e.DEV_FIELD_NUM.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f2496b[e.DEV_FIELD_SIZE.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f2496b[e.DEV_FIELD_DEV_ID.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f2496b[e.FIELD_DATA.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f2496b[e.DEV_FIELD_DATA.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            int[] iArr2 = new int[d.values().length];
            f2495a = iArr2;
            try {
                iArr2[d.CONTINUE.ordinal()] = 1;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f2495a[d.MESG.ordinal()] = 2;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                f2495a[d.MESG_DEF.ordinal()] = 3;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f2495a[d.END_OF_FILE.ordinal()] = 4;
            } catch (NoSuchFieldError unused20) {
            }
        }
    }

    /* loaded from: classes.dex */
    public class b {

        /* renamed from: a */
        int f2497a;

        /* renamed from: b */
        int f2498b;

        /* renamed from: c */
        long f2499c = 0;

        /* renamed from: d */
        long f2500d = 0;

        b(int i2, int i3) {
            this.f2497a = i2;
            this.f2498b = i3;
        }

        public long a(long j2, int i2) {
            long j3 = this.f2500d + (((1 << i2) - 1) & (j2 - this.f2499c));
            this.f2500d = j3;
            this.f2499c = j2;
            return j3;
        }

        public long b(long j2) {
            this.f2500d = j2;
            this.f2499c = j2;
            return j2;
        }
    }

    /* loaded from: classes.dex */
    public class c {

        /* renamed from: a */
        ArrayList f2502a = new ArrayList();

        c() {
        }

        public long a(int i2, int i3, long j2, int i4) {
            b bVar = null;
            int i5 = 0;
            while (i5 < this.f2502a.size()) {
                bVar = (b) this.f2502a.get(i5);
                if (bVar.f2497a == i2 && bVar.f2498b == i3) {
                    break;
                }
                i5++;
            }
            if (i5 == this.f2502a.size()) {
                bVar = new b(i2, i3);
                this.f2502a.add(bVar);
            }
            return bVar.a(j2, i4);
        }

        public void b(int i2, int i3, long j2) {
            b bVar = null;
            int i4 = 0;
            while (i4 < this.f2502a.size()) {
                bVar = (b) this.f2502a.get(i4);
                if (bVar.f2497a == i2 && bVar.f2498b == i3) {
                    break;
                } else {
                    i4++;
                }
            }
            if (i4 == this.f2502a.size()) {
                bVar = new b(i2, i3);
                this.f2502a.add(bVar);
            }
            bVar.b(j2);
        }
    }

    /* loaded from: classes.dex */
    public enum d {
        CONTINUE,
        MESG,
        MESG_DEF,
        END_OF_FILE
    }

    /* loaded from: classes.dex */
    public enum e {
        FILE_HDR,
        RECORD,
        RESERVED1,
        ARCH,
        MESG_NUM_0,
        MESG_NUM_1,
        NUM_FIELDS,
        FIELD_NUM,
        FIELD_SIZE,
        FIELD_TYPE,
        NUM_DEV_FIELDS,
        DEV_FIELD_NUM,
        DEV_FIELD_SIZE,
        DEV_FIELD_DEV_ID,
        FIELD_DATA,
        DEV_FIELD_DATA,
        FILE_CRC_HIGH
    }

    public x() {
        g();
        this.E = 0;
        this.F = 0;
        this.G = new byte[512];
        if (d1.f2120a) {
            System.out.printf("Fit.Decode: Starting decode...\n", new Object[0]);
        }
    }

    private void a(int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            for (int i5 = 0; i5 < i2 / 2; i5++) {
                byte[] bArr = this.f2485q;
                int i6 = i4 * i2;
                int i7 = i6 + i5;
                byte b3 = bArr[i7];
                int i8 = ((i6 + i2) - i5) - 1;
                bArr[i7] = bArr[i8];
                bArr[i8] = b3;
            }
        }
    }

    public void b(x1 x1Var) {
        if (x1Var == null || this.B.contains(x1Var)) {
            return;
        }
        this.B.add(x1Var);
    }

    public boolean c(InputStream inputStream) {
        int i2 = this.F;
        return (i2 > 0 && i2 < this.E) || inputStream.available() > 0;
    }

    public boolean d(InputStream inputStream) {
        boolean z2 = true;
        while (true) {
            try {
                int i2 = this.F;
                if (i2 < this.E) {
                    int i3 = a.f2495a[h(this.G[i2]).ordinal()];
                    if (i3 != 1 && i3 != 2 && i3 != 3) {
                        if (i3 != 4) {
                            z2 = false;
                        } else {
                            g();
                        }
                    }
                    this.F++;
                } else {
                    this.F = 0;
                    byte[] bArr = this.G;
                    int read = inputStream.read(bArr, 0, bArr.length);
                    this.E = read;
                    if (read < 0) {
                        return z2;
                    }
                }
            } catch (IOException e3) {
                throw new e1(e3);
            } catch (e1 unused) {
                if (f()) {
                    g();
                }
                this.E = 0;
                this.F = 0;
                return false;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0092, code lost:            if (r18.f2476h.q(r6.f2369d) != false) goto L64;     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0094, code lost:            r18.f2476h.j(r6.f2369d).c(r7);     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x00a1, code lost:            r6.c(r7);        r18.f2476h.h(r6);     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0141, code lost:            if (r18.f2476h.q(r6.f2369d) != false) goto L64;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void e(k1.s0 r19, java.util.ArrayList r20) {
        /*
            Method dump skipped, instructions count: 335
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: k1.x.e(k1.s0, java.util.ArrayList):void");
    }

    public boolean f() {
        return this.f2493y;
    }

    public void g() {
        if (this.f2492x) {
            this.f2474f = 3L;
            this.f2471c = (byte) 0;
            this.f2475g = 0;
            this.f2470b = e.FILE_HDR;
            this.f2486r = 0;
            this.f2490v = false;
            H = false;
            this.f2493y = false;
            this.f2494z = null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:241:0x066b. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:33:0x00d5. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:105:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x02d0  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x077b A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0242  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public k1.x.d h(byte r22) {
        /*
            Method dump skipped, instructions count: 1996
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: k1.x.h(byte):k1.x$d");
    }

    public boolean i(InputStream inputStream) {
        this.f2491w = inputStream;
        return k();
    }

    public boolean j(InputStream inputStream, x1 x1Var) {
        b(x1Var);
        return i(inputStream);
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x0127, code lost:            r9.F = 0;        r2 = r9.f2491w;        r3 = r9.G;        r2 = r2.read(r3, 0, r3.length);        r9.E = r2;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean k() {
        /*
            Method dump skipped, instructions count: 413
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: k1.x.k():boolean");
    }
}
