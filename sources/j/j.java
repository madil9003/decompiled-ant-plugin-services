package j;

/* loaded from: classes.dex */
public abstract class j {
    public static boolean a(int i2) {
        return i2 == 1;
    }

    public static String b(int i2) {
        return "0x" + String.format("%02X", Integer.valueOf(i2 & 255));
    }

    public static String c(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b3 : bArr) {
            sb.append('[');
            sb.append(String.format("%02X", Integer.valueOf(b3 & 255)));
            sb.append(']');
        }
        return sb.toString();
    }

    public static final boolean d(int i2, int i3, int i4) {
        return i2 >= i3 && i2 <= i4;
    }

    public static boolean e(int i2, int i3) {
        return (i2 & i3) != 0;
    }

    public static boolean f(int i2, byte[] bArr, int i3) {
        return e(i2, j(bArr, i3));
    }

    public static int g(int i2, int i3, int i4) {
        return (i2 & i3) >> i4;
    }

    public static int h(byte[] bArr, int i2, int i3, int i4) {
        return g(bArr[i2], i3, i4);
    }

    public static int i(boolean z2) {
        return z2 ? 1 : 0;
    }

    public static int j(byte[] bArr, int i2) {
        return (int) k(bArr, i2, 1);
    }

    public static long k(byte[] bArr, int i2, int i3) {
        long j2 = 0;
        for (int i4 = 0; i4 < i3; i4++) {
            j2 += (bArr[i2 + i4] & 255) << (i4 * 8);
        }
        return j2;
    }

    public static void l(int i2, byte[] bArr, int i3) {
        if (i2 > 255 || i2 < 0) {
            throw new IllegalArgumentException("Value outside the bounds of unsigned byte integer");
        }
        bArr[i3] = (byte) i2;
    }

    public static void m(long j2, byte[] bArr, int i2, int i3) {
        long j3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            j3 += 255 << (i4 * 8);
        }
        if (j2 <= j3 && j2 >= 0) {
            for (int i5 = 0; i5 < i2; i5++) {
                bArr[i3 + i5] = (byte) ((j2 >> (i5 * 8)) & 255);
            }
            return;
        }
        throw new IllegalArgumentException("Value (" + j2 + ") outside the bounds of unsigned " + i2 + " byte integer (0-" + j3 + ")");
    }

    public static void n(boolean z2, byte[] bArr, int i2) {
        bArr[i2] = (byte) i(z2);
    }

    public static int o(byte[] bArr, int i2) {
        return bArr[i2];
    }
}
