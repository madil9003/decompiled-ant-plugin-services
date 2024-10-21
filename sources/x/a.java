package x;

/* loaded from: classes.dex */
public abstract class a {
    public static byte[] a(int i2, int i3, int i4, int i5, long j2, byte[] bArr) {
        int length = bArr.length + 16;
        byte[] bArr2 = new byte[length];
        bArr2[0] = 72;
        bArr2[1] = (byte) (i2 & 255);
        bArr2[2] = (byte) (i3 & 255);
        bArr2[3] = (byte) (length / 8);
        for (int i6 = 4; i6 <= 7; i6++) {
            bArr2[i6] = -1;
        }
        w.c.d(bArr2, 8, i4);
        w.c.d(bArr2, 10, i5);
        w.c.e(bArr2, 12, j2);
        System.arraycopy(bArr, 0, bArr2, 16, bArr.length);
        return bArr2;
    }

    public static byte[] b(int i2, int i3) {
        return new byte[]{70, -1, -1, (byte) (i3 & 255), -1, 1, (byte) (i2 & 255), 1};
    }
}
