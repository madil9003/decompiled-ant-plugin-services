package k1;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class u0 {

    /* renamed from: b */
    static boolean f2444b = false;

    /* renamed from: a */
    protected ArrayList f2445a = new ArrayList();

    public u0() {
    }

    private int A(d3 d3Var) {
        return d3Var == null ? z() : d3Var.f2160b;
    }

    public /* synthetic */ void E(String str) {
        this.f2445a.add(str);
    }

    private Object F(Integer num, Object obj) {
        HashMap hashMap = d1.f2131f0;
        if (hashMap.get(num) != null) {
            HashMap hashMap2 = d1.f2133g0;
            if (hashMap2.get(num) != null) {
                try {
                    BigDecimal bigDecimal = new BigDecimal(hashMap.get(num).toString());
                    BigDecimal bigDecimal2 = new BigDecimal(hashMap2.get(num).toString());
                    BigDecimal bigDecimal3 = new BigDecimal(obj.toString());
                    if (bigDecimal3.compareTo(bigDecimal) >= 0 && bigDecimal3.compareTo(bigDecimal2) <= 0) {
                        return obj;
                    }
                    return d1.f2129e0.get(num);
                } catch (NumberFormatException unused) {
                    return d1.f2129e0.get(num);
                }
            }
        }
        return obj;
    }

    private void b(int i2, Object obj) {
        boolean z2 = obj instanceof String;
        if (z2 && obj.equals("")) {
            int z3 = z();
            if (z3 != 0 && z3 != 1 && z3 != 2) {
                if (z3 != 7) {
                    if (z3 != 10 && z3 != 13 && z3 != 136 && z3 != 137 && z3 != 139 && z3 != 140) {
                        switch (z3) {
                            case 131:
                            case 132:
                            case 133:
                            case 134:
                                break;
                            default:
                                switch (z3) {
                                    case 142:
                                    case 143:
                                    case 144:
                                        break;
                                    default:
                                        return;
                                }
                        }
                    }
                }
            }
            this.f2445a.set(i2, d1.f2129e0.get(Integer.valueOf(z())));
            return;
        }
        if (z2) {
            if (((String) obj).getBytes(StandardCharsets.UTF_8).length > 254) {
                throw new e1(String.format("Invalid string size. Byte count can not be greater than %d bytes.", 254));
            }
            this.f2445a.set(i2, obj);
            return;
        }
        this.f2445a.set(i2, F(Integer.valueOf(z()), obj));
    }

    private String o(d3 d3Var) {
        return d3Var == null ? h() : d3Var.f2159a;
    }

    protected Object B(int i2, d3 d3Var) {
        double d3;
        double d4;
        if (i2 >= this.f2445a.size()) {
            return null;
        }
        if (d3Var == null) {
            d3 = t();
            d4 = q();
        } else {
            d3 = d3Var.f2161c;
            d4 = d3Var.f2162d;
        }
        int A = A(d3Var);
        Object obj = this.f2445a.get(i2);
        if (!(obj instanceof Number)) {
            return obj;
        }
        HashMap hashMap = d1.f2129e0;
        return hashMap.get(Integer.valueOf(A)).equals(obj) ? hashMap.get(Integer.valueOf(A)) : (d3 == 1.0d && d4 == 0.0d) ? obj : Double.valueOf((((Number) obj).doubleValue() / d3) - d4);
    }

    public boolean C() {
        return D(null);
    }

    public boolean D(d3 d3Var) {
        int z2 = d3Var == null ? z() : d3Var.d();
        return z2 == 1 || z2 == 131 || z2 == 133 || z2 == 142;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:24:0x0080. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:28:0x011e A[Catch: IOException -> 0x0143, TryCatch #1 {IOException -> 0x0143, blocks: (B:3:0x0001, B:6:0x0048, B:24:0x0080, B:25:0x0083, B:26:0x0087, B:28:0x011e, B:29:0x0123, B:33:0x012a, B:38:0x0093, B:39:0x009d, B:40:0x00a7, B:42:0x00b5, B:45:0x00d3, B:46:0x00f6, B:47:0x00ff, B:48:0x0114, B:49:0x0108, B:52:0x0139, B:54:0x013d), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x012a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00b5 A[Catch: IOException -> 0x0143, LOOP:1: B:41:0x00b3->B:42:0x00b5, LOOP_END, TryCatch #1 {IOException -> 0x0143, blocks: (B:3:0x0001, B:6:0x0048, B:24:0x0080, B:25:0x0083, B:26:0x0087, B:28:0x011e, B:29:0x0123, B:33:0x012a, B:38:0x0093, B:39:0x009d, B:40:0x00a7, B:42:0x00b5, B:45:0x00d3, B:46:0x00f6, B:47:0x00ff, B:48:0x0114, B:49:0x0108, B:52:0x0139, B:54:0x013d), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean G(java.io.InputStream r14, int r15) {
        /*
            Method dump skipped, instructions count: 346
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: k1.u0.G(java.io.InputStream, int):boolean");
    }

    public void H(int i2, Object obj, int i3) {
        d3 d3Var;
        if (i3 != 65535) {
            d3Var = y(i3);
            if (d3Var == null) {
                throw new e1("com.garmin.fit.Field.setValue(): " + i3 + " is not a valid subfield index of " + n() + ".");
            }
        } else {
            d3Var = null;
        }
        J(i2, obj, d3Var);
    }

    public void I(Object obj) {
        J(0, obj, null);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:38:0x0067. Please report as an issue. */
    protected void J(int i2, Object obj, d3 d3Var) {
        double d3;
        double d4;
        ArrayList arrayList;
        Integer valueOf;
        Object valueOf2;
        ArrayList arrayList2;
        Object d5;
        while (i2 >= p()) {
            d(new Object());
        }
        if (d3Var == null) {
            d3 = t();
            d4 = q();
        } else {
            d3 = d3Var.f2161c;
            d4 = d3Var.f2162d;
        }
        if (obj != null) {
            if (!(obj instanceof Number) || (d3 == 1.0d && d4 == 0.0d)) {
                b(i2, obj);
                return;
            }
            double doubleValue = (((Number) obj).doubleValue() + d4) * d3;
            int z2 = z();
            if (z2 != 0 && z2 != 1 && z2 != 2) {
                if (z2 == 7) {
                    arrayList2 = this.f2445a;
                    d5 = Double.valueOf(doubleValue).toString();
                } else if (z2 != 10) {
                    if (z2 == 13) {
                        arrayList2 = this.f2445a;
                        d5 = Long.valueOf(Math.round(doubleValue));
                    } else {
                        if (z2 == 136 || z2 == 137) {
                            arrayList = this.f2445a;
                            valueOf = Integer.valueOf(z());
                            valueOf2 = Double.valueOf(doubleValue);
                            arrayList.set(i2, F(valueOf, valueOf2));
                            return;
                        }
                        if (z2 != 139 && z2 != 140) {
                            switch (z2) {
                                default:
                                    switch (z2) {
                                        case 142:
                                            break;
                                        case 143:
                                        case 144:
                                            Long valueOf3 = Long.valueOf(Math.round(doubleValue));
                                            int i3 = d1.f2125c0[z() & 31];
                                            byte[] bArr = new byte[i3];
                                            for (int i4 = 0; i4 < i3; i4++) {
                                                bArr[i4] = (byte) (valueOf3.longValue() >>> (i4 * 8));
                                            }
                                            this.f2445a.set(i2, F(Integer.valueOf(z()), new BigInteger(1, bArr)));
                                            return;
                                        default:
                                            return;
                                    }
                                    arrayList.set(i2, F(valueOf, valueOf2));
                                    return;
                                case 131:
                                case 132:
                                case 133:
                                case 134:
                                    arrayList = this.f2445a;
                                    valueOf = Integer.valueOf(z());
                                    valueOf2 = Long.valueOf(Math.round(doubleValue));
                                    arrayList.set(i2, F(valueOf, valueOf2));
                                    return;
                            }
                        }
                    }
                }
            }
            arrayList = this.f2445a;
            valueOf = Integer.valueOf(z());
            valueOf2 = Long.valueOf(Math.round(doubleValue));
            arrayList.set(i2, F(valueOf, valueOf2));
            return;
        }
        arrayList2 = this.f2445a;
        d5 = null;
        arrayList2.set(i2, d5);
    }

    public void c(Object obj) {
        ArrayList arrayList;
        if (obj == null) {
            arrayList = this.f2445a;
            obj = null;
        } else if (obj instanceof Double) {
            int z2 = z();
            if (z2 != 0) {
                if (z2 == 1) {
                    arrayList = this.f2445a;
                    obj = Byte.valueOf((byte) Math.round(((Number) obj).doubleValue()));
                } else if (z2 != 2) {
                    if (z2 == 7) {
                        arrayList = this.f2445a;
                        obj = obj.toString();
                    } else if (z2 != 10 && z2 != 13) {
                        if (z2 != 136 && z2 != 137) {
                            if (z2 != 139) {
                                if (z2 != 140) {
                                    switch (z2) {
                                        case 131:
                                            break;
                                        case 132:
                                        case 133:
                                            break;
                                        case 134:
                                            break;
                                        default:
                                            return;
                                    }
                                }
                                arrayList = this.f2445a;
                                obj = Long.valueOf(Math.round(((Number) obj).doubleValue()));
                            }
                            arrayList = this.f2445a;
                            obj = Integer.valueOf((int) Math.round(((Number) obj).doubleValue()));
                        }
                        arrayList = this.f2445a;
                    }
                }
            }
            arrayList = this.f2445a;
            obj = Short.valueOf((short) Math.round(((Number) obj).doubleValue()));
        } else {
            if ((obj instanceof String) && obj.equals("")) {
                int z3 = z();
                if (z3 == 0) {
                    arrayList = this.f2445a;
                    obj = d1.f2134h;
                } else if (z3 == 1) {
                    arrayList = this.f2445a;
                    obj = d1.f2137k;
                } else if (z3 == 2) {
                    arrayList = this.f2445a;
                    obj = d1.f2140n;
                } else if (z3 != 7) {
                    if (z3 == 10) {
                        arrayList = this.f2445a;
                        obj = d1.J;
                    } else if (z3 == 13) {
                        arrayList = this.f2445a;
                        obj = d1.S;
                    } else if (z3 == 136) {
                        arrayList = this.f2445a;
                        obj = d1.B;
                    } else if (z3 == 137) {
                        arrayList = this.f2445a;
                        obj = d1.E;
                    } else if (z3 == 139) {
                        arrayList = this.f2445a;
                        obj = d1.M;
                    } else if (z3 != 140) {
                        switch (z3) {
                            case 131:
                                arrayList = this.f2445a;
                                obj = d1.f2143q;
                                break;
                            case 132:
                                arrayList = this.f2445a;
                                obj = d1.f2146t;
                                break;
                            case 133:
                                arrayList = this.f2445a;
                                obj = d1.f2149w;
                                break;
                            case 134:
                                arrayList = this.f2445a;
                                obj = d1.f2152z;
                                break;
                            default:
                                return;
                        }
                    } else {
                        arrayList = this.f2445a;
                        obj = d1.P;
                    }
                }
            }
            arrayList = this.f2445a;
        }
        arrayList.add(obj);
    }

    public void d(Object obj) {
        if (!(obj instanceof Number) || z() != 7) {
            this.f2445a.add(obj);
            return;
        }
        String x2 = x(0, null);
        Number number = (Number) obj;
        if (x2 == null) {
            x2 = "";
        }
        J(0, x2 + String.valueOf((char) number.intValue()), null);
    }

    public Long e(int i2, int i3, boolean z2) {
        int i4 = i2;
        long j2 = 0;
        int i5 = 0;
        int i6 = 0;
        while (i5 < i3) {
            int i7 = i6 + 1;
            Object s2 = s(i6, null);
            if (s2 == null || !(s2 instanceof Number)) {
                return null;
            }
            Long valueOf = Long.valueOf(Long.valueOf(((Number) s2).longValue()).longValue() >> i4);
            int[] iArr = d1.f2125c0;
            int i8 = (iArr[z() & 31] * 8) - i4;
            i4 -= iArr[z() & 31] * 8;
            if (i8 > 0) {
                int i9 = i3 - i5;
                if (i8 > i9) {
                    i8 = i9;
                }
                j2 |= (valueOf.longValue() & ((1 << i8) - 1)) << i5;
                i5 += i8;
                i4 = 0;
            }
            i6 = i7;
        }
        if (z2) {
            long j3 = 1 << (i3 - 1);
            if ((j2 & j3) != 0) {
                j2 = (-j3) + (j2 & (j3 - 1));
            }
        }
        return Long.valueOf(j2);
    }

    public Byte f(int i2, int i3) {
        return g(i2, y(i3));
    }

    protected Byte g(int i2, d3 d3Var) {
        Object B = B(i2, d3Var);
        if (B == null) {
            return null;
        }
        return Byte.valueOf(((Number) B).byteValue());
    }

    protected abstract String h();

    public Integer i(int i2, int i3) {
        return j(i2, y(i3));
    }

    protected Integer j(int i2, d3 d3Var) {
        Object B = B(i2, d3Var);
        if (B == null) {
            return null;
        }
        return Integer.valueOf(((Number) B).intValue());
    }

    public Long k() {
        return m(0, null);
    }

    public Long l(int i2, int i3) {
        return m(i2, y(i3));
    }

    protected Long m(int i2, d3 d3Var) {
        Object B = B(i2, d3Var);
        if (B == null) {
            return null;
        }
        return Long.valueOf(((Number) B).longValue());
    }

    public String n() {
        return o(null);
    }

    public int p() {
        return this.f2445a.size();
    }

    protected abstract double q();

    public Object r(int i2) {
        return s(i2, null);
    }

    protected Object s(int i2, d3 d3Var) {
        if (i2 >= this.f2445a.size()) {
            return null;
        }
        return this.f2445a.get(i2);
    }

    protected abstract double t();

    public Short u(int i2, int i3) {
        return v(i2, y(i3));
    }

    protected Short v(int i2, d3 d3Var) {
        Object B = B(i2, d3Var);
        if (B == null) {
            return null;
        }
        return Short.valueOf(((Number) B).shortValue());
    }

    public String w(int i2, int i3) {
        return x(i2, y(i3));
    }

    protected String x(int i2, d3 d3Var) {
        Object B = B(i2, d3Var);
        int A = A(d3Var);
        if (B == null) {
            return null;
        }
        if (f2444b || !d1.f2129e0.get(Integer.valueOf(A)).equals(B)) {
            return B.toString();
        }
        return null;
    }

    protected abstract d3 y(int i2);

    public abstract int z();

    public u0(u0 u0Var) {
        if (u0Var != null) {
            Iterator it = u0Var.f2445a.iterator();
            while (it.hasNext()) {
                this.f2445a.add(it.next());
            }
        }
    }
}
