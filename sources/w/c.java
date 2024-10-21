package w;

/* loaded from: classes.dex */
public abstract class c {
    public static void a(byte[] bArr, int i2, long j2) {
        if (j2 > 2147483647L || j2 < -2147483648L) {
            throw new IllegalArgumentException("Value outside the bounds of unsigned 4 byte integer");
        }
        bArr[i2] = (byte) (j2 & 255);
        bArr[i2 + 1] = (byte) ((j2 >> 8) & 255);
        bArr[i2 + 2] = (byte) ((j2 >> 16) & 255);
        bArr[i2 + 3] = (byte) ((j2 >> 24) & 255);
    }

    public static void b(byte[] bArr, int i2, int i3) {
        if (i3 > 255 || i3 < 0) {
            throw new IllegalArgumentException("Value outside the bounds of unsigned 1 byte integer");
        }
        bArr[i2] = (byte) (i3 & 255);
    }

    public static void c(byte[] bArr, int i2, int i3) {
        if (i3 > 65535 || i3 < 0) {
            throw new IllegalArgumentException("Value outside the bounds of unsigned 2 byte integer");
        }
        bArr[i2 + 1] = (byte) (i3 & 255);
        bArr[i2] = (byte) ((i3 >> 8) & 255);
    }

    public static void d(byte[] bArr, int i2, int i3) {
        if (i3 > 65535 || i3 < 0) {
            throw new IllegalArgumentException("Value outside the bounds of unsigned 2 byte integer");
        }
        bArr[i2] = (byte) (i3 & 255);
        bArr[i2 + 1] = (byte) ((i3 >> 8) & 255);
    }

    public static void e(byte[] bArr, int i2, long j2) {
        if (j2 > 4294967295L || j2 < 0) {
            throw new IllegalArgumentException("Value outside the bounds of unsigned 4 byte integer");
        }
        bArr[i2] = (byte) (j2 & 255);
        bArr[i2 + 1] = (byte) ((j2 >> 8) & 255);
        bArr[i2 + 2] = (byte) ((j2 >> 16) & 255);
        bArr[i2 + 3] = (byte) ((j2 >> 24) & 255);
    }

    public static void f(byte[] bArr, int i2, int i3) {
        if (i3 > 4095 || i3 < 0) {
            throw new IllegalArgumentException("Value outside the bounds of unsigned 1.5 byte integer");
        }
        bArr[i2] = (byte) ((bArr[i2] & 15) + ((i3 << 4) & 240));
        bArr[i2 + 1] = (byte) ((i3 >> 4) & 255);
    }

    public static short g(byte[] bArr, int i2) {
        return (short) (k(bArr, i2) & 65535);
    }

    public static int h(byte[] bArr, int i2) {
        return ((bArr[i2 + 2] << 16) & 16711680) | (bArr[i2 + 3] << 24) | (bArr[i2] & 255) | ((bArr[i2 + 1] << 8) & 65280);
    }

    public static int i(byte b3) {
        return b3 & 255;
    }

    public static int j(byte[] bArr, int i2) {
        return 65535 & ((bArr[i2 + 1] & 255) + ((bArr[i2] << 8) & 65280));
    }

    public static int k(byte[] bArr, int i2) {
        return 65535 & ((bArr[i2] & 255) + ((bArr[i2 + 1] << 8) & 65280));
    }

    public static int l(byte[] bArr, int i2) {
        return 16777215 & ((bArr[i2 + 2] & 255) + ((bArr[i2 + 1] << 8) & 65280) + ((bArr[i2] << 16) & 16711680));
    }

    public static int m(byte[] bArr, int i2) {
        return 16777215 & ((bArr[i2] & 255) + ((bArr[i2 + 1] << 8) & 65280) + ((bArr[i2 + 2] << 16) & 16711680));
    }

    public static long n(byte[] bArr, int i2) {
        return 4294967295L & ((bArr[i2] & 255) + ((bArr[i2 + 1] << 8) & 65280) + ((bArr[i2 + 2] << 16) & 16711680) + ((bArr[i2 + 3] << 24) & (-16777216)));
    }

    public static long o(byte[] bArr, int i2) {
        return 72057594037927935L & ((bArr[i2] & 255) + ((bArr[i2 + 1] << 8) & 65280) + ((bArr[i2 + 2] << 16) & 16711680) + ((bArr[i2 + 3] << 24) & 4278190080L) + ((bArr[i2 + 4] << 32) & 1095216660480L) + ((bArr[i2 + 5] << 40) & 280375465082880L) + ((bArr[i2 + 6] << 48) & 71776119061217280L));
    }

    public static int p(byte b3) {
        return b3 & 3;
    }

    public static int q(byte b3) {
        return (b3 >> 4) & 3;
    }

    public static int r(byte b3) {
        return b3 & 15;
    }

    public static int s(byte[] bArr, int i2) {
        return (((bArr[i2] >>> 4) & 15) + ((bArr[i2 + 1] << 4) & 4080)) & 4095;
    }

    public static int t(byte b3) {
        return (b3 >> 2) & 3;
    }

    public static int u(byte b3) {
        return (b3 >> 6) & 3;
    }

    public static int v(byte b3) {
        return (b3 >> 4) & 15;
    }
}
