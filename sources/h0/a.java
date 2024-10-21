package h0;

import com.dsi.ant.message.ipc.AntMessageParcel;
import com.dsi.ant.plugins.antplus.common.FitFileCommon;
import j.d;
import java.util.EnumSet;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import k.e;
import k.l;
import s0.a;

/* loaded from: classes.dex */
public class a extends u0.b {
    private static final String J = "a";
    private FitFileCommon.FitFile[] A;
    private int C;
    private int D;
    private int E;

    /* renamed from: q */
    private c f1819q;

    /* renamed from: r */
    CountDownLatch f1820r;

    /* renamed from: t */
    private b f1822t;

    /* renamed from: u */
    private int f1823u;

    /* renamed from: v */
    private int f1824v;

    /* renamed from: w */
    private int f1825w;

    /* renamed from: x */
    private int f1826x;

    /* renamed from: y */
    private int f1827y;

    /* renamed from: z */
    private FitFileCommon.FitFile f1828z;

    /* renamed from: s */
    private final Object f1821s = new Object();
    private long F = -1;
    private boolean G = false;
    private byte[] H = {67, 35, 0, 0, 1, 0, 15, Byte.MIN_VALUE};
    private byte[] I = new byte[8];
    private s0.a B = new s0.a();

    /* renamed from: h0.a$a */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C0035a {

        /* renamed from: a */
        static final /* synthetic */ int[] f1829a;

        /* renamed from: b */
        static final /* synthetic */ int[] f1830b;

        static {
            int[] iArr = new int[l.values().length];
            f1830b = iArr;
            try {
                iArr[l.ACKNOWLEDGED_DATA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1830b[l.BURST_TRANSFER_DATA.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[c.values().length];
            f1829a = iArr2;
            try {
                iArr2[c.LINK.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1829a[c.AUTHENTICATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1829a[c.TRANSPORT.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1829a[c.TRANSITION.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(c cVar);
    }

    /* loaded from: classes.dex */
    public enum c {
        LINK,
        AUTHENTICATE,
        TRANSPORT,
        TRANSITION
    }

    public a(int i2, int i3, int i4, int i5, int i6, b bVar, FitFileCommon.FitFile fitFile, FitFileCommon.FitFile[] fitFileArr) {
        this.f1822t = bVar;
        this.f1823u = i2;
        this.f1824v = i3;
        this.f1825w = i4;
        this.f1826x = i5;
        this.f1827y = i6;
        this.f1828z = fitFile;
        this.A = fitFileArr;
        if (fitFile != null) {
            a.b bVar2 = new a.b();
            bVar2.f3084a = 1;
            bVar2.f3085b = 128;
            bVar2.f3086c[0] = (byte) (fitFile.a() & 255);
            w.c.d(bVar2.f3086c, 1, 1);
            bVar2.f3087d = 0;
            bVar2.f3088e = EnumSet.of(a.c.READ);
            bVar2.f3089f = fitFile.b().length;
            s0.a aVar = this.B;
            bVar2.f3090g = aVar.f3075a.f3083f;
            aVar.f3076b.append(bVar2.f3084a, bVar2);
        }
        if (fitFileArr != null) {
            int i7 = 0;
            while (i7 < fitFileArr.length) {
                a.b bVar3 = new a.b();
                bVar3.f3084a = i7 + 2;
                bVar3.f3085b = 128;
                bVar3.f3086c[0] = (byte) (fitFileArr[i7].a() & 255);
                int i8 = i7 + 1;
                w.c.d(bVar3.f3086c, 1, i8);
                bVar3.f3087d = 1;
                bVar3.f3088e = EnumSet.of(a.c.READ);
                bVar3.f3089f = fitFileArr[i7].b().length;
                s0.a aVar2 = this.B;
                bVar3.f3090g = aVar2.f3075a.f3083f;
                aVar2.f3076b.append(bVar3.f3084a, bVar3);
                i7 = i8;
            }
        }
        this.f1819q = c.LINK;
    }

    private void B(l lVar, AntMessageParcel antMessageParcel) {
        int i2 = C0035a.f1830b[lVar.ordinal()];
        if (i2 == 1 || i2 == 2) {
            if ((lVar != l.BURST_TRANSFER_DATA || new e(antMessageParcel).n()) && 68 == antMessageParcel.a()[1] && 4 == antMessageParcel.a()[2]) {
                byte b3 = antMessageParcel.a()[3];
                long h2 = w.c.h(antMessageParcel.a(), 5);
                String str = J;
                h1.a.a(str, "Received authentication request, command type: " + ((int) b3));
                if (b3 == 1) {
                    try {
                        this.f3396a.e(H((byte) 0));
                    } catch (g.a e3) {
                        h1.a.f(J, "Failed to transmit serial number, reason: " + e3.toString());
                    }
                    byte[] bArr = this.I;
                    bArr[2] = 1;
                    this.f3396a.s(bArr);
                    return;
                }
                if (b3 == 0 && this.F == h2) {
                    this.G = true;
                } else {
                    try {
                        h1.a.b(str, "Authentication request rejected");
                        this.f3396a.e(H((byte) 2));
                    } catch (g.a e4) {
                        h1.a.f(J, "Failed to send authentication response, reason: " + e4.toString());
                    }
                    this.G = false;
                }
                C(c.TRANSITION);
                c();
                this.f1820r.countDown();
            }
        }
    }

    private void C(c cVar) {
        this.f1819q = cVar;
        if (cVar != c.TRANSITION) {
            G(cVar);
        }
    }

    private byte[] D(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr.length + bArr2.length];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    private void E(l lVar, AntMessageParcel antMessageParcel) {
        if (lVar == l.ACKNOWLEDGED_DATA && 68 == antMessageParcel.a()[1] && 2 == antMessageParcel.a()[2]) {
            this.C = antMessageParcel.a()[3];
            this.E = antMessageParcel.a()[4];
            this.F = w.c.h(antMessageParcel.a(), 5);
            C(c.TRANSITION);
            c();
            this.f1820r.countDown();
        }
    }

    private byte[] F(int i2) {
        if (i2 == 0) {
            return this.B.a();
        }
        if (this.B.f3076b.get(i2) == null) {
            return null;
        }
        if (i2 == 1) {
            return this.f1828z.b();
        }
        FitFileCommon.FitFile[] fitFileArr = this.A;
        if (i2 > fitFileArr.length + 1) {
            return null;
        }
        return fitFileArr[i2 - 2].b();
    }

    private byte[] H(byte b3) {
        this.I[2] = 3;
        byte[] bArr = {68, -124, 0, 0, 0, 0, 0, 0};
        bArr[2] = b3;
        w.c.a(bArr, 4, this.f1823u);
        return D(this.I, bArr);
    }

    private byte[] I(int i2) {
        byte[] bArr = {68, -119, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        byte[] F = F(i2);
        if (F == null) {
            bArr[2] = 1;
            return D(this.I, bArr);
        }
        w.c.e(bArr, 4, F.length);
        w.c.e(bArr, 12, F.length);
        s0.l lVar = new s0.l();
        lVar.update(F, 0, F.length);
        this.I[2] = 3;
        int ceil = (((int) Math.ceil(F.length / 8.0d)) * 8) + 32;
        byte[] bArr2 = new byte[ceil];
        byte[] bArr3 = this.I;
        System.arraycopy(bArr3, 0, bArr2, 0, bArr3.length);
        System.arraycopy(bArr, 0, bArr2, this.I.length, 16);
        System.arraycopy(F, 0, bArr2, this.I.length + 16, F.length);
        w.c.d(bArr2, ceil - 2, (int) (65535 & lVar.getValue()));
        return bArr2;
    }

    private byte[] J() {
        byte[] bArr = this.I;
        bArr[2] = 3;
        return D(bArr, new byte[]{68, -117, 1, 0, 0, 0, 0, 0});
    }

    private byte[] K() {
        byte[] bArr = this.I;
        bArr[2] = 3;
        return D(bArr, new byte[]{68, -118, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
    }

    private void L() {
        this.f1820r = new CountDownLatch(1);
        this.G = false;
        this.I[0] = 67;
        P();
        byte[] bArr = this.I;
        bArr[2] = 1;
        bArr[3] = 0;
        long j2 = this.F;
        bArr[4] = (byte) (j2 & 255);
        bArr[5] = (byte) ((j2 >> 8) & 255);
        bArr[6] = (byte) ((j2 >> 16) & 255);
        bArr[7] = (byte) ((j2 >> 24) & 255);
        String k2 = this.f3396a.n().k();
        if (k2.length() > 3) {
            k2 = k2.substring(0, 3);
        }
        if (k2.equals("AJK") || k2.equals("AP2")) {
            this.f3396a.C(3);
        }
        this.f3396a.x(this.D);
        this.f3396a.s(this.I);
        C(c.AUTHENTICATE);
        f();
        this.f3396a.z(this.C);
    }

    private void M() {
        h();
        this.f1820r = new CountDownLatch(1);
        this.f3396a.u(new j.b(this.f1823u, this.f1826x, this.f1827y));
        this.f3396a.x(this.f1825w);
        this.f3396a.s(this.H);
        C(c.LINK);
        f();
        this.f3396a.z(this.f1824v);
        String k2 = this.f3396a.n().k();
        if (k2.length() > 3) {
            k2 = k2.substring(0, 3);
        }
        if (k2.equals("AJK") || k2.equals("AP2")) {
            this.f3396a.C(2);
        }
        this.f3396a.l();
    }

    private void N() {
        this.f1820r = new CountDownLatch(1);
        this.I[2] = 2;
        C(c.TRANSPORT);
        f();
        this.f3396a.s(this.I);
    }

    private void O(l lVar, AntMessageParcel antMessageParcel) {
        String str;
        StringBuilder sb;
        String str2;
        int i2 = C0035a.f1830b[lVar.ordinal()];
        if (i2 == 1 || i2 == 2) {
            if ((lVar != l.BURST_TRANSFER_DATA || new e(antMessageParcel).n()) && 68 == antMessageParcel.a()[1]) {
                byte b3 = antMessageParcel.a()[2];
                String str3 = J;
                h1.a.a(str3, "Received transport command: " + ((int) b3));
                if (9 == b3) {
                    try {
                        this.f3396a.e(I(w.c.k(antMessageParcel.a(), 3)));
                    } catch (g.a e3) {
                        e = e3;
                        str = J;
                        sb = new StringBuilder();
                        str2 = "Failed to send download response, reason: ";
                        sb.append(str2);
                        sb.append(e.toString());
                        h1.a.f(str, sb.toString());
                        byte[] bArr = this.I;
                        bArr[2] = 2;
                        this.f3396a.s(bArr);
                    }
                    byte[] bArr2 = this.I;
                    bArr2[2] = 2;
                    this.f3396a.s(bArr2);
                }
                if (10 == b3) {
                    try {
                        this.f3396a.e(K());
                    } catch (g.a e4) {
                        e = e4;
                        str = J;
                        sb = new StringBuilder();
                        str2 = "Failed to transmit upload response, reason: ";
                        sb.append(str2);
                        sb.append(e.toString());
                        h1.a.f(str, sb.toString());
                        byte[] bArr22 = this.I;
                        bArr22[2] = 2;
                        this.f3396a.s(bArr22);
                    }
                    byte[] bArr222 = this.I;
                    bArr222[2] = 2;
                    this.f3396a.s(bArr222);
                }
                if (11 == b3) {
                    try {
                        this.f3396a.e(J());
                    } catch (g.a e5) {
                        e = e5;
                        str = J;
                        sb = new StringBuilder();
                        str2 = "Failed to transmit erase response, reason: ";
                        sb.append(str2);
                        sb.append(e.toString());
                        h1.a.f(str, sb.toString());
                        byte[] bArr2222 = this.I;
                        bArr2222[2] = 2;
                        this.f3396a.s(bArr2222);
                    }
                } else if (2 == b3) {
                    this.C = antMessageParcel.a()[3];
                    this.E = antMessageParcel.a()[4];
                    P();
                    try {
                        h1.a.a(str3, "Changing channel period to " + this.D + " and Rf to " + this.C);
                        this.f3396a.x(this.D);
                        this.f3396a.s(this.I);
                        this.f3396a.z(this.C);
                        this.f1820r.countDown();
                    } catch (g.a e6) {
                        h1.a.b(J, "ACFE occurred when handling link request in transport state: " + e6.toString());
                        this.f3396a.m();
                    }
                }
                byte[] bArr22222 = this.I;
                bArr22222[2] = 2;
                this.f3396a.s(bArr22222);
            }
        }
    }

    private void P() {
        int i2 = this.E;
        if (i2 == 0) {
            this.D = 65535;
            this.I[1] = 32;
            return;
        }
        if (i2 == 1) {
            this.D = 32768;
            this.I[1] = 33;
            return;
        }
        if (i2 == 2) {
            this.D = 16384;
            this.I[1] = 34;
        } else if (i2 == 3) {
            this.D = 8192;
            this.I[1] = 35;
        } else if (i2 != 4) {
            this.D = 65535;
            this.I[1] = 32;
        } else {
            this.D = 4096;
            this.I[1] = 36;
        }
    }

    protected void G(c cVar) {
        synchronized (this.f1821s) {
            this.f1822t.a(cVar);
        }
    }

    @Override // u0.b
    public void d() {
        String str;
        String str2;
        try {
            try {
                i();
                this.f3396a.c(d.BIDIRECTIONAL_MASTER);
                while (true) {
                    M();
                    this.f1820r.await();
                    L();
                    if (!this.f1820r.await(10L, TimeUnit.SECONDS)) {
                        str = J;
                        str2 = "Timed out in Auth state, dropping back to link state";
                    } else if (this.G) {
                        h1.a.a(J, "Send authentication response");
                        byte[] H = H((byte) 1);
                        int i2 = 0;
                        while (i2 < 3) {
                            try {
                                this.f3396a.e(H);
                                break;
                            } catch (g.a e3) {
                                h1.a.a(J, "Failed to transmit auth response, reason: " + e3.toString());
                                i2++;
                            }
                        }
                        if (i2 <= 3) {
                            h1.a.a(J, "Start transport state");
                            N();
                            this.f1820r.await();
                            return;
                        }
                        str = J;
                        str2 = "Retry limit exceeded for auth response, dropping back to link state";
                    } else {
                        h1.a.b(J, "Authentication rejected, dropping back to link state");
                    }
                    h1.a.j(str, str2);
                }
            } catch (InterruptedException unused) {
                h1.a.b(J, "Interrupted waiting for result");
                this.f3396a.m();
                Thread.currentThread().interrupt();
            }
        } catch (g.a e4) {
            h1.a.b(J, "ACFE occurred: " + e4.toString());
            this.f3396a.m();
        }
    }

    @Override // u0.b
    public String k() {
        return "Passthrough ANT-FS Transport Controller";
    }

    @Override // u0.b
    public void o() {
    }

    @Override // u0.b
    public void s() {
    }

    @Override // u0.b
    public void u(l lVar, AntMessageParcel antMessageParcel) {
        int i2 = C0035a.f1829a[this.f1819q.ordinal()];
        if (i2 == 1) {
            E(lVar, antMessageParcel);
            return;
        }
        if (i2 == 2) {
            B(lVar, antMessageParcel);
        } else if (i2 == 3) {
            O(lVar, antMessageParcel);
        } else if (i2 != 4) {
            h1.a.a(J, "Message received but lost because task is in unknown state");
        }
    }
}
