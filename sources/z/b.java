package z;

import com.dsi.ant.message.ipc.AntMessageParcel;
import com.dsi.ant.plugins.antplus.pccbase.b;
import j.e;
import k.g;
import k.l;
import p0.f;
import z.a;

/* loaded from: classes.dex */
public class b extends z.a {
    private static final String I = "b";
    private int E;
    private int F;
    private boolean G;
    private boolean H;

    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a */
        static final /* synthetic */ int[] f3614a;

        /* renamed from: b */
        static final /* synthetic */ int[] f3615b;

        static {
            int[] iArr = new int[l.values().length];
            f3615b = iArr;
            try {
                iArr[l.CHANNEL_EVENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3615b[l.BROADCAST_DATA.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3615b[l.ACKNOWLEDGED_DATA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[e.values().length];
            f3614a = iArr2;
            try {
                iArr2[e.RX_SEARCH_TIMEOUT.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3614a[e.CHANNEL_CLOSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3614a[e.TRANSFER_TX_COMPLETED.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3614a[e.TRANSFER_TX_FAILED.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f3614a[e.CHANNEL_COLLISION.ordinal()] = 5;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f3614a[e.RX_FAIL.ordinal()] = 6;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f3614a[e.RX_FAIL_GO_TO_SEARCH.ordinal()] = 7;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    public b(int i2, int i3, a.b bVar, b.d dVar) {
        super(x.a.b(i2, i3), bVar, dVar);
        this.E = 0;
        this.F = 0;
        this.H = false;
    }

    @Override // z.a
    public void B() {
        int i2 = this.f3609x;
        int i3 = z.a.D;
        if (i2 == (i3 / 4) + 1) {
            this.f3608w[5] = 4;
            this.B = 3;
        }
        if (i2 == ((i3 * 3) / 4) + 1) {
            this.f3608w[5] = 8;
            this.B = 7;
        }
        this.E = 0;
        this.F = 0;
        super.B();
    }

    @Override // z.a
    public void C(f fVar) {
        if (fVar == f.SUCCESS && !this.H) {
            fVar = f.FAIL_NOT_SUPPORTED;
        }
        super.C(fVar);
    }

    @Override // z.a, u0.b
    public String k() {
        return "Request Data Page";
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:34:0x0062. Please report as an issue. */
    @Override // z.a, u0.b
    public void u(l lVar, AntMessageParcel antMessageParcel) {
        String str;
        String str2;
        a.b bVar = this.f3607v;
        if (bVar != null) {
            bVar.a(lVar, antMessageParcel);
        }
        int i2 = a.f3615b[lVar.ordinal()];
        if (i2 != 1) {
            if (i2 == 2 || i2 == 3) {
                if (this.f3608w[6] != antMessageParcel.a()[1]) {
                    if (this.f3611z) {
                        if (this.E <= this.B) {
                            int i3 = this.F + 1;
                            this.F = i3;
                            if (i3 <= 2) {
                                return;
                            }
                        }
                        F();
                        return;
                    }
                    return;
                }
                byte b3 = this.f3608w[3];
                if (b3 != -1 && b3 != antMessageParcel.a()[2]) {
                    return;
                }
                this.H = true;
                if (!this.f3611z) {
                    return;
                }
                c();
                this.f3610y.countDown();
                return;
            }
            return;
        }
        switch (a.f3614a[new g(antMessageParcel).j().ordinal()]) {
            case 1:
                h1.a.b(I, "Search timeout occured");
                return;
            case 2:
                str = I;
                str2 = "Failed request, channel closed";
                h1.a.b(str, str2);
                c();
                this.f3610y.countDown();
                return;
            case 3:
                this.A = false;
                this.f3611z = true;
                if (!this.H) {
                    return;
                }
                c();
                this.f3610y.countDown();
                return;
            case 4:
                this.A = false;
                if (this.G) {
                    str = I;
                    str2 = "Failed request, channel dropped to search";
                    h1.a.b(str, str2);
                    c();
                    this.f3610y.countDown();
                    return;
                }
                F();
                return;
            case 5:
            case 6:
                if (this.f3611z) {
                    int i4 = this.E + 1;
                    this.E = i4;
                    if (i4 <= this.B) {
                        return;
                    }
                }
                F();
                return;
            case 7:
                this.G = true;
                return;
            default:
                return;
        }
    }

    public b(int i2, a.b bVar, b.d dVar) {
        this(i2, 255, bVar, dVar);
        this.G = false;
    }
}
