package s0;

import java.util.zip.Checksum;

/* loaded from: classes.dex */
public class l implements Checksum {

    /* renamed from: b */
    private static final int[] f3253b = {0, 52225, 55297, 5120, 61441, 15360, 10240, 58369, 40961, 27648, 30720, 46081, 20480, 39937, 34817, 17408};

    /* renamed from: a */
    private int f3254a = 0;

    public void a(int i2) {
        this.f3254a = i2;
    }

    @Override // java.util.zip.Checksum
    public long getValue() {
        return this.f3254a & 65535;
    }

    @Override // java.util.zip.Checksum
    public void reset() {
        this.f3254a = 0;
    }

    @Override // java.util.zip.Checksum
    public void update(int i2) {
        int[] iArr = f3253b;
        int i3 = this.f3254a;
        int i4 = ((((i3 >>> 4) & 4095) ^ iArr[i3 & 15]) ^ iArr[i2 & 15]) & 65535;
        int i5 = iArr[i4 & 15];
        this.f3254a = (iArr[(i2 >>> 4) & 15] ^ (((i4 >>> 4) & 4095) ^ i5)) & 65535;
    }

    @Override // java.util.zip.Checksum
    public void update(byte[] bArr, int i2, int i3) {
        if (i3 > bArr.length) {
            throw new IllegalArgumentException("Block length should not exceed the data block size");
        }
        if (i2 > bArr.length) {
            throw new IllegalArgumentException("Block offset should not exceed the data block size");
        }
        int i4 = i2 + i3;
        if (i4 <= bArr.length) {
            while (i2 < i4) {
                update(bArr[i2] & 255);
                i2++;
            }
            return;
        }
        throw new IllegalArgumentException("Block offset and length combined should not exceed the data block size: " + i2 + "/" + i3 + "/" + bArr.length);
    }
}
