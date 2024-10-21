package k;

import com.dsi.ant.message.ipc.AntMessageParcel;

/* loaded from: classes.dex */
public abstract class b extends j.a {

    /* renamed from: a */
    protected byte[] f1971a;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a */
        static final /* synthetic */ int[] f1972a;

        static {
            int[] iArr = new int[l.values().length];
            f1972a = iArr;
            try {
                iArr[l.BROADCAST_DATA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1972a[l.ACKNOWLEDGED_DATA.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1972a[l.BURST_TRANSFER_DATA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1972a[l.ANT_VERSION.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1972a[l.CAPABILITIES.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1972a[l.CHANNEL_EVENT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f1972a[l.CHANNEL_ID.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f1972a[l.CHANNEL_RESPONSE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f1972a[l.CHANNEL_STATUS.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f1972a[l.SERIAL_NUMBER.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f1972a[l.OTHER.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    public b(byte[] bArr) {
        this.f1971a = bArr;
    }

    public static b e(AntMessageParcel antMessageParcel) {
        if (antMessageParcel == null) {
            return null;
        }
        return f(l.c(antMessageParcel), antMessageParcel.a());
    }

    protected static b f(l lVar, byte[] bArr) {
        switch (a.f1972a[lVar.ordinal()]) {
            case 1:
                return new d(bArr);
            case 2:
                return new k.a(bArr);
            case 3:
                return new e(bArr);
            case 4:
                return new c(bArr);
            case 5:
                return new f(bArr);
            case 6:
                return new g(bArr);
            case 7:
                return new h(bArr);
            case 8:
                return new i(bArr);
            case 9:
                return new j(bArr);
            case 10:
                return new m(bArr);
            default:
                return null;
        }
    }

    public static byte[] g(l lVar, AntMessageParcel antMessageParcel) {
        l c3 = l.c(antMessageParcel);
        if (lVar == c3) {
            return antMessageParcel.a();
        }
        throw new IllegalArgumentException("Message data is for incorrect type. Desired=" + lVar + ". Actual=" + c3);
    }

    @Override // j.a
    public byte[] a() {
        return this.f1971a;
    }

    @Override // j.a
    public int c() {
        return h().d();
    }

    public abstract l h();

    public String i() {
        return h() + "(" + d() + ")";
    }
}
