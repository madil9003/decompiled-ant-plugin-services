package s0;

/* loaded from: classes.dex */
public abstract class j {
    public static int a(byte[] bArr) {
        return w.c.k(bArr, 5);
    }

    public static int b(byte[] bArr) {
        return w.c.k(bArr, 7) & 32767;
    }

    public static int c(byte[] bArr) {
        int i2 = bArr[2] & 7;
        if (i2 == 0) {
            return 65535;
        }
        if (i2 == 1) {
            return 32768;
        }
        if (i2 == 2) {
            return 16384;
        }
        if (i2 == 3) {
            return 8192;
        }
        if (i2 != 4) {
            return i2 != 7 ? -1 : -2;
        }
        return 4096;
    }

    public static boolean d(byte[] bArr) {
        return (bArr[2] & 32) > 0;
    }
}
