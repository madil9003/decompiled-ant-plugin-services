package s0;

import android.os.RemoteException;
import com.dsi.ant.message.ipc.AntMessageParcel;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import s0.g;
import s0.m;

/* loaded from: classes.dex */
public class b extends i {
    private static final String N = "b";
    static byte O = 67;
    static byte P = 68;
    static byte Q = -124;
    static int R = -1;
    static int S = 0;
    static int T = 1;
    static int U = 2;
    static int V = 3;
    static int W = -1;
    static int X = 0;
    static int Y = 1;
    static int Z = 2;

    /* renamed from: a0 */
    static int f3105a0 = 3;

    /* renamed from: b0 */
    static int f3106b0 = 0;

    /* renamed from: c0 */
    static int f3107c0 = 1;

    /* renamed from: d0 */
    static int f3108d0 = 2;

    /* renamed from: e0 */
    static final byte[] f3109e0 = {68, 5, 0, 0, 0, 0, 0, 0};
    int A;
    int B;
    boolean C;
    byte[] D;
    ByteArrayOutputStream E;
    byte[] F;
    m G;
    boolean H;
    int I;
    boolean J;
    boolean K;
    boolean L;
    int M;

    /* renamed from: s */
    long f3110s;

    /* renamed from: t */
    int f3111t;

    /* renamed from: u */
    int f3112u;

    /* renamed from: v */
    int f3113v;

    /* renamed from: w */
    long f3114w;

    /* renamed from: x */
    g.k f3115x;

    /* renamed from: y */
    CountDownLatch f3116y;

    /* renamed from: z */
    int f3117z;

    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a */
        static final /* synthetic */ int[] f3118a;

        /* renamed from: b */
        static final /* synthetic */ int[] f3119b;

        static {
            int[] iArr = new int[k.l.values().length];
            f3119b = iArr;
            try {
                iArr[k.l.CHANNEL_EVENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3119b[k.l.BROADCAST_DATA.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3119b[k.l.BURST_TRANSFER_DATA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[j.e.values().length];
            f3118a = iArr2;
            try {
                iArr2[j.e.RX_SEARCH_TIMEOUT.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3118a[j.e.CHANNEL_CLOSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3118a[j.e.TRANSFER_TX_COMPLETED.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3118a[j.e.TRANSFER_TX_FAILED.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f3118a[j.e.TRANSFER_RX_FAILED.ordinal()] = 5;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public b(g.m mVar, m mVar2, int i2, int i3, int i4, long j2) {
        super(mVar);
        this.f3115x = g.k.AUTH_IDLE;
        this.f3117z = W;
        int i5 = R;
        this.A = i5;
        this.B = i5;
        this.C = false;
        this.E = new ByteArrayOutputStream();
        this.H = false;
        this.I = -1;
        this.J = false;
        this.K = false;
        this.L = false;
        this.M = 0;
        this.G = mVar2;
        this.f3113v = i2;
        this.f3111t = i3;
        this.f3112u = i4;
        this.f3110s = j2;
    }

    private void E() {
        String str;
        String str2;
        loop0: for (int i2 = 0; i2 < 10; i2++) {
            byte[] bArr = {68, 4, (byte) Z, 0, 0, 0, 0, 0};
            this.D = bArr;
            w.c.e(bArr, 4, this.f3110s);
            this.A = R;
            if (J()) {
                h1.a.a(N, "Wait for pairing command response");
                this.K = true;
                K(5);
                int i3 = 0;
                while (this.B == V && this.K && !this.L) {
                    K(1);
                    i3++;
                    if (i3 > 120) {
                        str = N;
                        str2 = "Failed waiting for client to send pairing response";
                        break loop0;
                    }
                }
                int i4 = this.A;
                boolean z2 = i4 == U;
                boolean z3 = i4 == S;
                byte[] bArr2 = this.F;
                if (bArr2 != null && bArr2.length >= 16 && !this.K) {
                    boolean z4 = O == bArr2[0] && P == bArr2[8] && Q == bArr2[9];
                    boolean z5 = z4 && f3106b0 == bArr2[10];
                    boolean z6 = z4 && f3106b0 != bArr2[10];
                    if (z4 && f3108d0 == bArr2[10]) {
                        return;
                    }
                    if (z6 && !z5) {
                        h1.a.a(N, "Wait for beacon");
                        this.A = R;
                        K(5);
                        int i5 = this.A;
                        z2 = i5 == U;
                        z3 = i5 == S;
                    }
                } else if (this.L) {
                    str = N;
                    str2 = "Did not see a pairing response, channel closed.";
                } else {
                    h1.a.a(N, "Did not see a pairing response, retry pairing command");
                }
                if (z2 || z3) {
                    return;
                }
            } else {
                str = N;
                str2 = "Failed waiting for pairing cmd to be sent";
            }
            h1.a.b(str, str2);
            return;
        }
    }

    private void F(byte[] bArr) {
        for (int i2 = 0; i2 < 15; i2++) {
            byte[] bArr2 = {68, 4, (byte) f3105a0, (byte) bArr.length, 0, 0, 0, 0};
            w.c.e(bArr2, 4, this.f3110s);
            byte[] bArr3 = new byte[bArr.length + 8];
            this.D = bArr3;
            System.arraycopy(bArr2, 0, bArr3, 0, 8);
            System.arraycopy(bArr, 0, this.D, 8, bArr.length);
            this.A = R;
            if (!J()) {
                h1.a.b(N, "Failed waiting for passkey cmd to be sent");
                return;
            }
            String str = N;
            h1.a.a(str, "Wait for passkey command response");
            K(1);
            int i3 = this.A;
            boolean z2 = i3 == U;
            boolean z3 = i3 == S;
            byte[] bArr4 = this.F;
            if (bArr4 != null && bArr4.length >= 16) {
                boolean z4 = O == bArr4[0] && P == bArr4[8] && Q == bArr4[9];
                boolean z5 = z4 && f3106b0 == bArr4[10];
                boolean z6 = z4 && f3106b0 != bArr4[10];
                if (z4 && f3108d0 == bArr4[10]) {
                    return;
                }
                if (z6 && !z5) {
                    h1.a.a(str, "Wait for beacon");
                    this.A = R;
                    K(1);
                    int i4 = this.A;
                    z2 = i4 == U;
                    z3 = i4 == S;
                }
            } else {
                if (this.L) {
                    h1.a.b(str, "Did not see a passkey response, channel closed.");
                    return;
                }
                h1.a.a(str, "Did not see a passkey response, retry passkey command");
            }
            if (z2 || z3) {
                return;
            }
        }
    }

    private void G() {
        for (int i2 = 0; i2 < 15; i2++) {
            byte[] bArr = {68, 4, (byte) X, 0, 0, 0, 0, 0};
            this.D = bArr;
            w.c.e(bArr, 4, this.f3110s);
            this.A = R;
            if (!J()) {
                h1.a.b(N, "Failed waiting for passthrough cmd to be sent");
                return;
            }
            String str = N;
            h1.a.a(str, "Wait for passthrough command response");
            K(1);
            int i3 = this.A;
            boolean z2 = i3 == U;
            boolean z3 = i3 == S;
            byte[] bArr2 = this.F;
            if (bArr2 != null && bArr2.length >= 16) {
                boolean z4 = O == bArr2[0] && P == bArr2[8] && Q == bArr2[9];
                boolean z5 = z4 && f3106b0 == bArr2[10];
                boolean z6 = z4 && f3106b0 != bArr2[10];
                if (z4 && f3108d0 == bArr2[10]) {
                    return;
                }
                if (z6 && !z5) {
                    h1.a.a(str, "Wait for beacon");
                    this.A = R;
                    K(1);
                    int i4 = this.A;
                    z2 = i4 == U;
                    z3 = i4 == S;
                }
            } else {
                if (this.L) {
                    h1.a.b(str, "Did not see a passthrough response, channel closed.");
                    return;
                }
                h1.a.a(str, "Did not see a passthrough response, retry passthrough command");
            }
            if (z2 || z3) {
                return;
            }
        }
    }

    private void H() {
        this.f3114w = 0L;
        for (int i2 = 0; i2 < 15; i2++) {
            byte[] bArr = {68, 4, (byte) Y, 0, 0, 0, 0, 0};
            this.D = bArr;
            w.c.e(bArr, 4, this.f3110s);
            if (!J()) {
                h1.a.b(N, "Failed waiting for serial number cmd to be sent");
                return;
            }
            String str = N;
            h1.a.a(str, "Wait for serial number command response");
            K(1);
            if (this.L) {
                h1.a.b(str, "Aborting serial number request on closed channel");
                return;
            } else {
                if (this.E.size() >= 16) {
                    return;
                }
                h1.a.a(str, "Rx failure when receiving client serial number request response, retry");
            }
        }
    }

    private void I() {
        c();
        this.f3116y.countDown();
    }

    private boolean J() {
        this.H = false;
        if (this.L) {
            h1.a.b(N, "Not waiting for command response, channel already closed on search timeout");
            return false;
        }
        String str = N;
        h1.a.a(str, "Waiting 30 seconds for command response");
        K(30);
        int i2 = this.A;
        if (i2 == U || i2 == S) {
            this.H = true;
            return false;
        }
        if (this.L) {
            return false;
        }
        if (this.H) {
            h1.a.a(str, "Command successfully sent");
            return true;
        }
        h1.a.b(str, "Failed: Auth Tx retries exceeded");
        return false;
    }

    private void K(int i2) {
        this.f3116y = new CountDownLatch(1);
        f();
        this.f3116y.await(i2, TimeUnit.SECONDS);
    }

    @Override // s0.i
    public boolean C(g.k kVar) {
        return true;
    }

    @Override // u0.b
    public void d() {
        byte[] bArr;
        int i2;
        g.m mVar;
        g.j jVar;
        byte[] bArr2;
        try {
            try {
                j.c l2 = this.f3396a.p().l();
                if (l2 != j.c.TRACKING && l2 != j.c.SEARCHING) {
                    h1.a.b(N, "Failed: Connection lost");
                    g.k kVar = g.k.NOT_CONNECTED;
                    this.f3115x = kVar;
                    this.f3249r.a(kVar, g.j.CONNECTION_LOST);
                    D(g.l.FAIL_DEVICE_TRANSMISSION_LOST);
                    return;
                }
                g.k kVar2 = g.k.AUTH_IDLE;
                this.f3115x = kVar2;
                this.f3249r.a(kVar2, g.j.LINK_PASS);
                String str = N;
                h1.a.a(str, "Wait for auth beacon");
                this.f3117z = W;
                this.f3114w = 0L;
                K(10);
                if (this.L) {
                    h1.a.b(str, "Aborting authentication process on closed channel");
                    g.k kVar3 = g.k.NOT_CONNECTED;
                    this.f3115x = kVar3;
                    this.f3249r.a(kVar3, g.j.CONNECTION_LOST);
                    D(g.l.FAIL_DEVICE_TRANSMISSION_LOST);
                    return;
                }
                int i3 = this.f3117z;
                if (i3 == X) {
                    h1.a.a(str, "Sending passthrough command");
                    g.k kVar4 = g.k.AUTH_REQUESTING_PASSTHROUGH;
                    this.f3115x = kVar4;
                    this.f3249r.a(kVar4, g.j.AUTHENTICATE_BEACON_FOUND);
                    G();
                } else if (i3 == Z) {
                    if (!this.C) {
                        h1.a.b(str, "Pairing authentication required, but not enabled in client device");
                        g.k kVar5 = g.k.NOT_CONNECTED;
                        this.f3115x = kVar5;
                        this.f3249r.a(kVar5, g.j.AUTHENTICATE_REJECT_PAIRING);
                        D(g.l.FAIL_AUTHENTICATION_REJECTED);
                        return;
                    }
                    h1.a.a(str, "Sending pairing command");
                    g.k kVar6 = g.k.AUTH_WAITING_FOR_PAIRING;
                    this.f3115x = kVar6;
                    this.f3249r.a(kVar6, g.j.AUTHENTICATE_BEACON_FOUND);
                    E();
                } else {
                    if (i3 != f3105a0) {
                        h1.a.b(str, "Invalid authentication type in beacon");
                        g.k kVar7 = g.k.NOT_CONNECTED;
                        this.f3115x = kVar7;
                        this.f3249r.a(kVar7, g.j.AUTHENTICATE_FAIL_BAD_RESPONSE);
                        D(g.l.FAIL_OTHER_DEVICE_COMMUNICATION_ERROR);
                        return;
                    }
                    h1.a.a(str, "Sending serial number command");
                    g.k kVar8 = g.k.AUTH_REQUESTING_SERIAL;
                    this.f3115x = kVar8;
                    this.f3249r.a(kVar8, g.j.AUTHENTICATE_BEACON_FOUND);
                    H();
                }
                if (this.D[2] == ((byte) Y) && (bArr2 = this.F) != null && bArr2.length >= 16 && O == bArr2[0] && P == bArr2[8] && Q == bArr2[9]) {
                    this.f3114w = w.c.n(bArr2, 12);
                    h1.a.a(str, "Successfully received serial number: " + this.f3114w);
                    this.G.b();
                    m.a c3 = this.G.c(this.f3111t, this.f3112u, this.f3113v, this.f3114w);
                    this.G.close();
                    if (c3 == null) {
                        h1.a.a(str, "No passkey stored, request pairing");
                        g.k kVar9 = g.k.AUTH_WAITING_FOR_PAIRING;
                        this.f3115x = kVar9;
                        this.f3249r.a(kVar9, g.j.AUTHENTICATE_BEACON_FOUND);
                        E();
                    } else {
                        h1.a.a(str, "Passkey found, request passkey auth");
                        F(c3.f3260f);
                        byte[] bArr3 = this.F;
                        if (bArr3 != null && bArr3.length >= 16 && O == bArr3[0] && P == bArr3[8] && Q == bArr3[9]) {
                            byte b3 = bArr3[10];
                            if (b3 == f3108d0) {
                                this.G.b();
                                this.G.a(c3);
                                this.G.close();
                                h1.a.b(str, "Passkey authentication request rejected");
                                g.k kVar10 = g.k.NOT_CONNECTED;
                                this.f3115x = kVar10;
                                this.f3249r.a(kVar10, g.j.AUTHENTICATE_REJECT_BAD_PASSKEY);
                                D(g.l.FAIL_AUTHENTICATION_REJECTED);
                                return;
                            }
                            if (b3 != f3107c0) {
                                this.G.b();
                                this.G.a(c3);
                                this.G.close();
                                h1.a.b(str, "Undefined passkey authentication response " + ((int) b3));
                                g.k kVar11 = g.k.NOT_CONNECTED;
                                this.f3115x = kVar11;
                                this.f3249r.a(kVar11, g.j.AUTHENTICATE_FAIL_BAD_RESPONSE);
                                D(g.l.FAIL_OTHER_DEVICE_COMMUNICATION_ERROR);
                                return;
                            }
                        }
                    }
                }
                byte[] bArr4 = this.F;
                if (bArr4 != null && bArr4.length >= 16 && O == bArr4[0] && P == bArr4[8] && Q == bArr4[9]) {
                    byte b4 = bArr4[10];
                    if (b4 != f3107c0) {
                        if (b4 != f3108d0) {
                            g.k kVar12 = g.k.NOT_CONNECTED;
                            this.f3115x = kVar12;
                            this.f3249r.a(kVar12, g.j.AUTHENTICATE_FAIL_BAD_RESPONSE);
                            h1.a.b(str, "Undefined authentication response " + ((int) b4));
                            D(g.l.FAIL_OTHER_DEVICE_COMMUNICATION_ERROR);
                            return;
                        }
                        h1.a.b(str, "Authentication request rejected");
                        g.k kVar13 = g.k.NOT_CONNECTED;
                        this.f3115x = kVar13;
                        if (this.D[2] == ((byte) Z)) {
                            mVar = this.f3249r;
                            jVar = g.j.AUTHENTICATE_REJECT_PAIRING;
                        } else {
                            mVar = this.f3249r;
                            jVar = g.j.AUTHENTICATE_REJECT;
                        }
                        mVar.a(kVar13, jVar);
                        D(g.l.FAIL_AUTHENTICATION_REJECTED);
                        return;
                    }
                    h1.a.a(str, "Authentication request accepted");
                    if (this.D[2] == ((byte) Z) && (i2 = (bArr = this.F)[11]) > 0) {
                        int i4 = ((i2 / 8) * 8) + 16;
                        if (i2 % 8 != 0) {
                            i4 += 8;
                        }
                        if (bArr.length != i4) {
                            h1.a.b(str, "Client reported mismatched auth message length, told us " + i2 + " but we received " + (this.F.length - 16) + " and expected " + (i4 - 16));
                            g.k kVar14 = g.k.NOT_CONNECTED;
                            this.f3115x = kVar14;
                            this.f3249r.a(kVar14, g.j.AUTHENTICATE_FAIL_BAD_RESPONSE);
                            D(g.l.FAIL_OTHER_DEVICE_COMMUNICATION_ERROR);
                            return;
                        }
                        long n2 = w.c.n(bArr, 12);
                        if (n2 == 0) {
                            long j2 = this.f3114w;
                            if (j2 != 0) {
                                n2 = j2;
                            }
                        }
                        byte[] bArr5 = new byte[i2];
                        for (int i5 = 0; i5 < i2; i5++) {
                            bArr5[i5] = this.F[i5 + 16];
                        }
                        this.G.b();
                        this.G.d(new m.a(bArr5, this.f3111t, this.f3112u, this.f3113v, n2));
                        this.G.close();
                        h1.a.a(N, "Passkey for device " + n2 + " saved after pairing");
                    }
                }
                int i6 = this.A;
                if (i6 == U) {
                    h1.a.a(N, "Successful transition to Transport state");
                    g.k kVar15 = g.k.TRANSPORT_IDLE;
                    this.f3115x = kVar15;
                    this.f3249r.a(kVar15, g.j.AUTHENTICATE_PASS);
                    D(g.l.SUCCESS);
                    return;
                }
                if (i6 == S) {
                    h1.a.b(N, "Auth failed, host dropped to link");
                    g.k kVar16 = g.k.NOT_CONNECTED;
                    this.f3115x = kVar16;
                    this.f3249r.a(kVar16, g.j.AUTHENTICATE_REJECT);
                    D(g.l.FAIL_AUTHENTICATION_REJECTED);
                    return;
                }
                h1.a.b(N, "Timed out waiting for transport beacon");
                g.k kVar17 = g.k.NOT_CONNECTED;
                this.f3115x = kVar17;
                this.f3249r.a(kVar17, g.j.AUTHENTICATE_REJECT);
                D(g.l.FAIL_DEVICE_TRANSMISSION_LOST);
            } catch (g.a e3) {
                h1.a.b(N, "ACFE occurred requesting status: " + e3.toString());
                this.f3115x = g.k.NOT_CONNECTED;
                this.f3396a.m();
                throw new RemoteException();
            }
        } catch (InterruptedException unused) {
            h1.a.b(N, "Interrupted waiting for result");
            g.k kVar18 = g.k.NOT_CONNECTED;
            this.f3115x = kVar18;
            this.f3249r.a(kVar18, g.j.AUTHENTICATE_FAIL_NO_RESPONSE);
            D(g.l.FAIL_EXECUTOR_CANCELLED_TASK);
            Thread.currentThread().interrupt();
        }
    }

    @Override // u0.b
    public String k() {
        return "ANT-FS Host Auth Channel Task";
    }

    @Override // u0.b
    public void u(k.l lVar, AntMessageParcel antMessageParcel) {
        try {
            int i2 = a.f3119b[lVar.ordinal()];
            boolean z2 = true;
            if (i2 == 1) {
                int i3 = a.f3118a[new k.g(antMessageParcel).j().ordinal()];
                if (i3 == 1) {
                    h1.a.b(N, "Search timeout occured");
                    return;
                }
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            return;
                        }
                        this.J = false;
                        return;
                    }
                    this.J = false;
                    this.I = -1;
                    if (this.D != null && !this.H) {
                        this.H = true;
                        this.f3116y.countDown();
                        return;
                    }
                    return;
                }
                h1.a.b(N, "Channel closed");
                this.L = true;
            } else {
                if (i2 == 2) {
                    if (O == antMessageParcel.a()[1]) {
                        this.B = antMessageParcel.a()[3];
                    }
                    if (this.f3117z == W) {
                        if (O == antMessageParcel.a()[1] && T == antMessageParcel.a()[3]) {
                            byte b3 = antMessageParcel.a()[4];
                            this.f3117z = b3;
                            if (this.f3111t == 22 && this.f3112u == 18 && b3 == Z) {
                                this.f3117z = X;
                            }
                            if ((antMessageParcel.a()[2] & 8) <= 0) {
                                z2 = false;
                            }
                            this.C = z2;
                            this.A = T;
                            h1.a.i(N, "Auth type discovered: " + this.f3117z);
                            I();
                            return;
                        }
                        return;
                    }
                    if (O == antMessageParcel.a()[1] && !this.K) {
                        if (V == antMessageParcel.a()[3]) {
                            this.M++;
                        }
                        if (this.M > 40) {
                            h1.a.j(N, "No response. Client seems stuck in busy state. Ping.");
                            this.f3396a.D(f3109e0);
                            this.M = 0;
                            return;
                        }
                    }
                    if (!this.H) {
                        if (O == antMessageParcel.a()[1] && V != antMessageParcel.a()[3] && !this.J) {
                            this.I++;
                        }
                        if (O == antMessageParcel.a()[1] && U == antMessageParcel.a()[3]) {
                            this.A = U;
                        } else if (O == antMessageParcel.a()[1] && S == antMessageParcel.a()[3]) {
                            this.A = S;
                        } else if (this.I <= 45) {
                            if (O == antMessageParcel.a()[1] && T == antMessageParcel.a()[3] && !this.J && this.I % 3 == 0) {
                                byte[] bArr = this.D;
                                if (bArr.length == 8) {
                                    this.J = true;
                                    this.f3396a.D(bArr);
                                } else if (bArr.length > 8) {
                                    this.J = true;
                                    this.f3396a.e(bArr);
                                }
                            }
                        }
                        I();
                    }
                    if (this.A == R && O == antMessageParcel.a()[1]) {
                        if (O == antMessageParcel.a()[1] && U == antMessageParcel.a()[3]) {
                            this.A = U;
                        } else if (O != antMessageParcel.a()[1] || S != antMessageParcel.a()[3]) {
                            return;
                        } else {
                            this.A = S;
                        }
                        I();
                        return;
                    }
                    return;
                }
                if (i2 != 3) {
                    return;
                }
                k.e eVar = new k.e(antMessageParcel);
                if (eVar.n()) {
                    this.E.reset();
                    this.F = null;
                }
                this.E.write(eVar.k());
                if ((eVar.m() & 4) <= 0) {
                    return;
                }
                if (this.E.size() > 0) {
                    this.F = this.E.toByteArray();
                }
                this.K = false;
                this.H = true;
            }
            I();
        } catch (g.a e3) {
            if (e3.a() == g.b.TRANSFER_IN_PROGRESS) {
                h1.a.i(N, "TRANSFER_IN_PROGRESS error sending ack msg");
                return;
            }
            if (e3.a() == g.b.TRANSFER_FAILED) {
                this.J = false;
                return;
            }
            h1.a.b(N, "ACFE handling message: " + e3.toString());
            I();
        } catch (IOException e4) {
            h1.a.b(N, "IOException receiving burst: " + e4.toString());
            I();
        }
    }
}
