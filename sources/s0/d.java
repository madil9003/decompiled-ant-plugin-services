package s0;

import com.dsi.ant.message.ipc.AntMessageParcel;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import s0.g;

/* loaded from: classes.dex */
public class d extends i {
    private static final String O = "d";
    static final byte[] P = {68, 5, 0, 0, 0, 0, 0, 0};
    ByteArrayOutputStream A;
    boolean B;
    boolean C;
    boolean D;
    int E;
    int F;
    int G;
    int H;
    l I;
    int J;
    int K;
    int L;
    int M;
    private g.i N;

    /* renamed from: s */
    int f3127s;

    /* renamed from: t */
    g.k f3128t;

    /* renamed from: u */
    g.n f3129u;

    /* renamed from: v */
    byte[] f3130v;

    /* renamed from: w */
    CountDownLatch f3131w;

    /* renamed from: x */
    int f3132x;

    /* renamed from: y */
    byte[] f3133y;

    /* renamed from: z */
    ByteArrayOutputStream f3134z;

    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a */
        static final /* synthetic */ int[] f3135a;

        /* renamed from: b */
        static final /* synthetic */ int[] f3136b;

        static {
            int[] iArr = new int[k.l.values().length];
            f3136b = iArr;
            try {
                iArr[k.l.CHANNEL_EVENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3136b[k.l.BROADCAST_DATA.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3136b[k.l.BURST_TRANSFER_DATA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[j.e.values().length];
            f3135a = iArr2;
            try {
                iArr2[j.e.RX_SEARCH_TIMEOUT.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3135a[j.e.CHANNEL_CLOSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3135a[j.e.TRANSFER_TX_COMPLETED.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3135a[j.e.TRANSFER_TX_FAILED.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f3135a[j.e.TRANSFER_RX_FAILED.ordinal()] = 5;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public d(g.m mVar, g.n nVar, int i2) {
        super(mVar);
        this.f3128t = g.k.TRANSPORT_IDLE;
        this.f3132x = -1;
        this.f3134z = new ByteArrayOutputStream();
        this.A = new ByteArrayOutputStream();
        this.B = false;
        this.C = false;
        this.D = false;
        this.E = 0;
        this.F = 0;
        this.G = 0;
        this.H = 0;
        this.I = new l();
        this.N = g.i.FAIL_OTHER;
        this.f3129u = nVar;
        this.f3127s = i2;
    }

    private boolean G() {
        g.i iVar;
        byte[] byteArray = this.A.toByteArray();
        if (byteArray.length < 24) {
            return false;
        }
        if (67 != byteArray[0] || 68 != byteArray[8] || -119 != byteArray[9]) {
            h1.a.j(O, "Invalid burst response received. Will retry request...");
            return false;
        }
        byte b3 = byteArray[10];
        if (b3 != 0) {
            if (b3 == 1) {
                h1.a.b(O, "Download data does not exist.");
                iVar = g.i.FAIL_REJECTED_FILE_DOES_NOT_EXIST;
            } else if (b3 == 2) {
                h1.a.b(O, "Download data exists but is not downloadable.");
                iVar = g.i.FAIL_REJECTED_FILE_NOT_READABLE;
            } else if (b3 == 3) {
                h1.a.b(O, "Client device rejected download: not ready");
                iVar = g.i.FAIL_REJECTED_NOT_READY;
            } else if (b3 == 4) {
                h1.a.b(O, "Client device rejected download: invalid request");
                iVar = g.i.FAIL_REJECTED_INVALID_REQUEST;
            } else {
                if (b3 == 5) {
                    h1.a.b(O, "Client device rejected download: CRC incorrect");
                    this.N = g.i.FAIL_REJECTED_INCORRECT_CRC;
                    H();
                    return false;
                }
                h1.a.b(O, "Invalid download response received: " + ((int) b3));
                iVar = g.i.FAIL_INVALID_RESPONSE;
            }
            this.N = iVar;
            return true;
        }
        this.N = g.i.SUCCESS;
        int n2 = (int) w.c.n(byteArray, 12);
        this.M = (int) w.c.n(byteArray, 16);
        this.J = (int) w.c.n(byteArray, 20);
        String str = O;
        h1.a.i(str, "Download response: OK, Length: " + n2 + " Offset: " + this.M + " File Size: " + this.J);
        int size = this.f3134z.size();
        int i2 = this.M;
        if (i2 > size) {
            h1.a.j(str, "The offset received (" + this.M + ") is larger than expected (" + size + "). Looks like the client skipped data. Retry the previous request.");
            return false;
        }
        int length = byteArray.length - 24;
        int i3 = this.J;
        if (length > i3) {
            length = i3;
        }
        if (n2 <= 0 || n2 >= length) {
            n2 = length;
        }
        if (i2 < size) {
            n2 -= size - i2;
        }
        int value = (int) (this.I.getValue() & 65535);
        try {
            this.I.update(byteArray, (size - this.M) + 24, n2);
            if (!this.B) {
                int k2 = w.c.k(byteArray, byteArray.length - 2);
                if (k2 != this.I.getValue()) {
                    h1.a.j(str, "CRC mismatch: " + k2 + " (client) / " + this.I.getValue() + " (host). Retry request.");
                    this.N = g.i.FAIL_REJECTED_INCORRECT_CRC;
                    this.H = this.H + 1;
                    this.I.a(value);
                    return false;
                }
            }
            this.f3134z.write(byteArray, (size - this.M) + 24, n2);
            if (this.f3134z.size() >= this.J && !this.B) {
                return true;
            }
            I();
            w.c.e(this.f3133y, 4, this.f3134z.size());
            byte[] bArr = this.f3133y;
            bArr[9] = 0;
            w.c.d(bArr, 10, (int) (this.I.getValue() & 65535));
            return false;
        } catch (Exception e3) {
            String str2 = O;
            h1.a.j(str2, "Error updating data/CRC: " + e3.getMessage());
            h1.a.j(str2, "Response length: " + byteArray.length + " Current Offset: " + size + " Data Offset: " + this.M + " Actual block length: " + n2);
            this.N = g.i.FAIL_INVALID_RESPONSE;
            this.H = this.H + 1;
            this.I.a(value);
            return false;
        }
    }

    private void H() {
        this.I.reset();
        this.f3134z.reset();
        w.c.e(this.f3133y, 4, 0L);
        byte[] bArr = this.f3133y;
        bArr[9] = 1;
        w.c.d(bArr, 10, 0);
    }

    private void I() {
        if (this.A.size() > 24) {
            int size = (this.A.size() - 24) + this.M;
            int i2 = this.J;
            if (size > i2) {
                size = i2;
            }
            this.L = 0;
            this.f3129u.a(size, i2);
            h1.a.i(O, "Download progress: " + size + "/" + this.J);
        }
    }

    @Override // s0.i
    public boolean C(g.k kVar) {
        return kVar == g.k.TRANSPORT_IDLE;
    }

    public byte[] E() {
        return this.f3130v;
    }

    public g.i F() {
        return this.N;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0121, code lost:            r8.f3130v = r8.f3134z.toByteArray();        h1.a.a(r1, "Download completed. Total downloaded data: " + r8.f3130v.length + " bytes");        r0 = s0.g.k.TRANSPORT_IDLE;        r8.f3128t = r0;        r8.f3249r.a(r0, s0.g.j.DOWNLOAD_FINISHED);     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0150, code lost:            return;     */
    @Override // u0.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void d() {
        /*
            Method dump skipped, instructions count: 416
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: s0.d.d():void");
    }

    @Override // u0.b
    public String k() {
        return "ANT-FS Host Download Channel Task";
    }

    @Override // u0.b
    public void u(k.l lVar, AntMessageParcel antMessageParcel) {
        String str;
        String str2;
        CountDownLatch countDownLatch;
        try {
            int i2 = a.f3136b[lVar.ordinal()];
            if (i2 == 1) {
                int i3 = a.f3135a[new k.g(antMessageParcel).j().ordinal()];
                if (i3 == 1) {
                    h1.a.b(O, "Search timeout occured");
                    return;
                }
                if (i3 == 2) {
                    h1.a.b(O, "Channel closed");
                    this.B = true;
                    c();
                    countDownLatch = this.f3131w;
                } else if (i3 == 3) {
                    this.E = 0;
                    this.D = false;
                    if (this.C) {
                        return;
                    }
                    this.C = true;
                    c();
                    countDownLatch = this.f3131w;
                } else if (i3 == 4) {
                    this.D = false;
                    return;
                } else {
                    if (i3 != 5) {
                        return;
                    }
                    h1.a.a(O, "Transfer Rx fail");
                    this.B = true;
                    c();
                    countDownLatch = this.f3131w;
                }
            } else {
                if (i2 != 2) {
                    if (i2 != 3) {
                        return;
                    }
                    k.e eVar = new k.e(antMessageParcel);
                    if (eVar.n()) {
                        this.A.reset();
                    }
                    this.A.write(eVar.k());
                    if (this.A.size() == 24) {
                        this.M = (int) w.c.n(eVar.k(), 0);
                        int n2 = (int) w.c.n(eVar.k(), 4);
                        this.J = n2;
                        this.K = Math.min((n2 / 100) + 1, 100);
                    }
                    if ((eVar.m() & 4) > 0) {
                        this.B = false;
                        c();
                        this.f3131w.countDown();
                        return;
                    } else {
                        int i4 = this.L + 1;
                        this.L = i4;
                        if (i4 > this.K) {
                            I();
                            return;
                        }
                        return;
                    }
                }
                if (67 == antMessageParcel.a()[1]) {
                    if (3 == antMessageParcel.a()[3]) {
                        this.F++;
                    }
                    if (this.F > 40) {
                        h1.a.j(O, "No response. Client seems stuck in busy state. Ping.");
                        H();
                        this.f3396a.D(P);
                        this.F = 0;
                        c();
                        this.f3131w.countDown();
                    }
                }
                if (this.f3132x == -1) {
                    if (67 == antMessageParcel.a()[1] && 2 == antMessageParcel.a()[3]) {
                        h1.a.a(O, "Got transport beacon");
                        this.f3132x = 2;
                        c();
                        this.f3131w.countDown();
                        return;
                    }
                    return;
                }
                if (!this.C) {
                    int i5 = this.E + 1;
                    this.E = i5;
                    if (i5 > 30) {
                        c();
                        this.f3131w.countDown();
                        return;
                    } else {
                        if (67 == antMessageParcel.a()[1] && 2 == antMessageParcel.a()[3] && !this.D && this.E % 3 == 0) {
                            this.D = true;
                            this.L = 0;
                            h1.a.a(O, "Retrying download command");
                            this.f3396a.e(this.f3133y);
                            return;
                        }
                        return;
                    }
                }
                if (67 != antMessageParcel.a()[1]) {
                    return;
                }
                if (2 == antMessageParcel.a()[3]) {
                    this.G++;
                }
                if (this.G <= 40) {
                    return;
                }
                h1.a.b(O, "No response.");
                c();
                countDownLatch = this.f3131w;
            }
            countDownLatch.countDown();
        } catch (g.a e3) {
            if (e3.a() == g.b.TRANSFER_IN_PROGRESS) {
                str = O;
                str2 = "TRANSFER_IN_PROGRESS error sending burst msg";
            } else {
                if (e3.a() != g.b.TRANSFER_FAILED) {
                    h1.a.b(O, "ACFE handling message: " + e3.toString());
                    c();
                    this.f3131w.countDown();
                    return;
                }
                this.D = false;
                str = O;
                str2 = "TRANSFER_FAILED error sending burst msg";
            }
            h1.a.i(str, str2);
        } catch (IOException e4) {
            h1.a.b(O, "IOException receiving burst: " + e4.toString());
            c();
            this.f3131w.countDown();
        }
    }
}
