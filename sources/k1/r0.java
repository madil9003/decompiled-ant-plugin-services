package k1;

/* loaded from: classes.dex */
public abstract class r0 {

    /* renamed from: a */
    private static final s1[] f2363a;

    static {
        f2363a = r0;
        s1[] s1VarArr = {c1.f2115g, b1.f2111g, i3.f2192g, y2.f2535g, x2.f2530g, r.f2362g, a1.f2100g, u1.f2446g, v0.f2450g, e0.f2170g, l3.f2325g, l1.f2239g, p2.f2355g, h.f2183g, t.f2387g, r3.f2366g, h2.f2186g, h3.f2187g, y3.f2536g, b3.f2112g, k1.f2235g, z2.f2539g, p.f2352g, k2.f2236g, c2.f2116g, i0.f2189g, f0.f2174g, g0.f2179g, h0.f2184g, f1.f2175g, b.f2108g, v2.f2456g, o1.f2349g, p1.f2354g, m2.f2340g, l0.f2238g, d0.f2119g, c0.f2114g, k3.f2237g, t3.f2442g, s3.f2386g, g1.f2180g, q.f2357g, h1.f2185g, a.f2094g, q1.f2359g, g.f2178g, g3.f2182g, i2.f2191g, o3.f2351g, g2.f2181g, f2.f2176g, f.f2173g, p3.f2356g, q3.f2361g, n3.f2346g, m3.f2341g, w2.f2467g, n1.f2345g, a3.f2107g, s.f2367g, z0.f2538g, y.f2532g, u.f2443g, v.f2449g, r2.f2365g, t2.f2441g, u2.f2447g, s2.f2385g, q2.f2360g, v3.f2457g, w3.f2468g, x3.f2531g, q0.f2358g, o2.f2350g, j3.f2200g, u3.f2448g, i.f2188g, d2.f2158g, e2.f2171g, i1.f2190g, c3.f2117g, r1.f2364g, c.f2113g, d.f2118g, e.f2169g, p0.f2353g, o0.f2348g, n0.f2344g, j0.f2193g, m1.f2339g, f3.f2177g, e3.f2172g, j2.f2199g};
    }

    public static s0 a(int i2, int i3) {
        int i4 = 0;
        while (true) {
            s1[] s1VarArr = f2363a;
            if (i4 >= s1VarArr.length) {
                return new s0("unknown", i3, 0, 1.0d, 0.0d, "", false, l2.ENUM);
            }
            if (s1VarArr[i4].f2380b == i2) {
                return new s0(s1VarArr[i4].j(i3));
            }
            i4++;
        }
    }

    public static s1 b(int i2) {
        int i3 = 0;
        while (true) {
            s1[] s1VarArr = f2363a;
            if (i3 >= s1VarArr.length) {
                return new s1("unknown", i2);
            }
            s1 s1Var = s1VarArr[i3];
            if (s1Var.f2380b == i2) {
                return new s1(s1Var);
            }
            i3++;
        }
    }

    public static s1 c(s1 s1Var) {
        int p2 = s1Var.p();
        if (p2 == 0) {
            return new c1(s1Var);
        }
        if (p2 == 1) {
            return new r(s1Var);
        }
        if (p2 == 2) {
            return new e0(s1Var);
        }
        if (p2 == 3) {
            return new l3(s1Var);
        }
        if (p2 == 4) {
            return new l1(s1Var);
        }
        if (p2 == 5) {
            return new p2(s1Var);
        }
        if (p2 == 6) {
            return new h(s1Var);
        }
        if (p2 != 7) {
            if (p2 == 105) {
                return new j2(s1Var);
            }
            if (p2 == 106) {
                return new x2(s1Var);
            }
            if (p2 == 131) {
                return new p(s1Var);
            }
            if (p2 == 132) {
                return new i1(s1Var);
            }
            switch (p2) {
                case 7:
                    break;
                case 8:
                    return new k1(s1Var);
                case 9:
                    return new k2(s1Var);
                case 10:
                    return new c2(s1Var);
                case 12:
                    return new b3(s1Var);
                case 15:
                    return new f1(s1Var);
                case 23:
                    return new d0(s1Var);
                case 49:
                    return new b1(s1Var);
                case 51:
                    return new i(s1Var);
                case 53:
                    return new z2(s1Var);
                case 55:
                    return new e2(s1Var);
                case 72:
                    return new k3(s1Var);
                case 78:
                    return new m1(s1Var);
                case 101:
                    return new p1(s1Var);
                case 103:
                    return new d2(s1Var);
                case 142:
                    return new s2(s1Var);
                case 145:
                    return new r1(s1Var);
                case 158:
                    return new w3(s1Var);
                case 159:
                    return new r3(s1Var);
                case 160:
                    return new g1(s1Var);
                case 161:
                    return new q(s1Var);
                case 162:
                    return new i3(s1Var);
                case 164:
                    return new h1(s1Var);
                case 165:
                    return new a(s1Var);
                case 167:
                    return new g3(s1Var);
                case 169:
                    return new o3(s1Var);
                case 174:
                    return new g2(s1Var);
                case 177:
                    return new f2(s1Var);
                case 178:
                    return new f(s1Var);
                case 184:
                    return new p3(s1Var);
                case 185:
                    return new q3(s1Var);
                case 186:
                    return new n3(s1Var);
                case 187:
                    return new m3(s1Var);
                case 188:
                    return new h2(s1Var);
                case 200:
                    return new p0(s1Var);
                case 201:
                    return new o0(s1Var);
                case 202:
                    return new n0(s1Var);
                case 206:
                    return new z0(s1Var);
                case 207:
                    return new y(s1Var);
                case 208:
                    return new q1(s1Var);
                case 209:
                    return new g(s1Var);
                case 210:
                    return new i2(s1Var);
                case 216:
                    return new h3(s1Var);
                case 225:
                    return new w2(s1Var);
                case 227:
                    return new c3(s1Var);
                case 258:
                    return new i0(s1Var);
                case 259:
                    return new h0(s1Var);
                case 262:
                    return new f0(s1Var);
                case 264:
                    return new q0(s1Var);
                case 268:
                    return new j0(s1Var);
                case 285:
                    return new n1(s1Var);
                case 312:
                    return new a3(s1Var);
                case 317:
                    return new s(s1Var);
                case 319:
                    return new f3(s1Var);
                case 323:
                    return new e3(s1Var);
                case 375:
                    return new c0(s1Var);
                case 393:
                    return new g0(s1Var);
                default:
                    switch (p2) {
                        case 18:
                            return new v2(s1Var);
                        case 19:
                            return new o1(s1Var);
                        case 20:
                            return new m2(s1Var);
                        case 21:
                            return new l0(s1Var);
                        default:
                            switch (p2) {
                                case 26:
                                    return new v3(s1Var);
                                case 27:
                                    return new x3(s1Var);
                                case 28:
                                    return new o2(s1Var);
                                default:
                                    switch (p2) {
                                        case 30:
                                            return new u3(s1Var);
                                        case 31:
                                            return new u(s1Var);
                                        case 32:
                                            return new v(s1Var);
                                        case 33:
                                            return new j3(s1Var);
                                        case 34:
                                            return new b(s1Var);
                                        case 35:
                                            return new y2(s1Var);
                                        default:
                                            switch (p2) {
                                                case 37:
                                                    return new a1(s1Var);
                                                case 38:
                                                    return new u1(s1Var);
                                                case 39:
                                                    return new v0(s1Var);
                                                default:
                                                    switch (p2) {
                                                        case 80:
                                                            return new d(s1Var);
                                                        case 81:
                                                            return new e(s1Var);
                                                        case 82:
                                                            return new c(s1Var);
                                                        default:
                                                            switch (p2) {
                                                                case 127:
                                                                    return new t(s1Var);
                                                                case 128:
                                                                    return new t3(s1Var);
                                                                case 129:
                                                                    return new s3(s1Var);
                                                                default:
                                                                    switch (p2) {
                                                                        case 148:
                                                                            return new r2(s1Var);
                                                                        case 149:
                                                                            return new t2(s1Var);
                                                                        case 150:
                                                                            return new u2(s1Var);
                                                                        case 151:
                                                                            return new q2(s1Var);
                                                                        default:
                                                                            return new s1("unknown", y1.f2533a);
                                                                    }
                                                            }
                                                    }
                                            }
                                    }
                            }
                    }
            }
        }
        return new y3(s1Var);
    }
}
