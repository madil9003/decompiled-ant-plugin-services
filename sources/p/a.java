package p;

import java.math.BigDecimal;

/* loaded from: classes.dex */
public abstract class a {
    public static byte[] a(boolean z2) {
        return new byte[]{1, -85, z2 ? (byte) 1 : (byte) 0, -1, -1, -1, -1, -1};
    }

    public static byte[] b() {
        return new byte[]{1, -86, -1, -1, -1, -1, -1, -1};
    }

    public static byte[] c(byte[] bArr) {
        byte[] bArr2 = new byte[8];
        bArr2[0] = 1;
        bArr2[1] = -70;
        System.arraycopy(bArr, 0, bArr2, 2, 6);
        return bArr2;
    }

    public static byte[] d(BigDecimal bigDecimal) {
        byte[] bArr = {1, 16, 2, -1, -1, -1, -1, -1};
        w.c.c(bArr, 6, bigDecimal.multiply(new BigDecimal("10")).intValue());
        return bArr;
    }

    public static byte[] e(byte b3) {
        return new byte[]{2, 1, -1, -1, b3, 0, 0, -1};
    }

    public static byte[] f(byte[] bArr) {
        byte[] bArr2 = new byte[8];
        bArr2[0] = 1;
        bArr2[1] = -68;
        System.arraycopy(bArr, 0, bArr2, 2, 6);
        return bArr2;
    }
}
