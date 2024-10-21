package k;

import com.dsi.ant.message.ipc.AntMessageParcel;

/* loaded from: classes.dex */
public enum l {
    BROADCAST_DATA,
    ACKNOWLEDGED_DATA,
    BURST_TRANSFER_DATA,
    CHANNEL_EVENT,
    CHANNEL_RESPONSE,
    CHANNEL_STATUS,
    CHANNEL_ID,
    ANT_VERSION,
    CAPABILITIES,
    SERIAL_NUMBER,
    OTHER;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a */
        static final /* synthetic */ int[] f2046a;

        static {
            int[] iArr = new int[l.values().length];
            f2046a = iArr;
            try {
                iArr[l.ACKNOWLEDGED_DATA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2046a[l.ANT_VERSION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2046a[l.BROADCAST_DATA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2046a[l.BURST_TRANSFER_DATA.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f2046a[l.CAPABILITIES.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f2046a[l.CHANNEL_EVENT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f2046a[l.CHANNEL_ID.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f2046a[l.CHANNEL_RESPONSE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f2046a[l.CHANNEL_STATUS.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f2046a[l.SERIAL_NUMBER.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f2046a[l.OTHER.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    public static l b(int i2, byte[] bArr) {
        if (i2 == 62) {
            return ANT_VERSION;
        }
        if (i2 == 64) {
            return 1 == j.j.j(bArr, 1) ? CHANNEL_EVENT : CHANNEL_RESPONSE;
        }
        if (i2 == 84) {
            return CAPABILITIES;
        }
        if (i2 == 97) {
            return SERIAL_NUMBER;
        }
        switch (i2) {
            case 78:
                return BROADCAST_DATA;
            case 79:
                return ACKNOWLEDGED_DATA;
            case 80:
                return BURST_TRANSFER_DATA;
            case 81:
                return CHANNEL_ID;
            case 82:
                return CHANNEL_STATUS;
            default:
                return OTHER;
        }
    }

    public static l c(AntMessageParcel antMessageParcel) {
        return b(antMessageParcel.c(), antMessageParcel.a());
    }

    public int d() {
        switch (a.f2046a[ordinal()]) {
            case 1:
                return 79;
            case 2:
                return 62;
            case 3:
                return 78;
            case 4:
                return 80;
            case 5:
                return 84;
            case 6:
            case 8:
                return 64;
            case 7:
                return 81;
            case 9:
                return 82;
            case 10:
                return 97;
            case 11:
                throw new IllegalArgumentException("Other message type");
            default:
                return 0;
        }
    }
}
