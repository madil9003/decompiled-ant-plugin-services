package j0;

import com.dsi.ant.plugins.antplus.pcc.AntPlusGeocachePcc;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public abstract class c {
    public static List a(int i2, String str) {
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        while (i3 <= str.length()) {
            int i4 = i2 + 1;
            byte[] g3 = g(i2, 2);
            for (int i5 = 0; i5 < 6; i5++) {
                int i6 = i3 + i5;
                if (i6 < str.length()) {
                    w.c.b(g3, i5 + 2, str.charAt(i6));
                } else {
                    g3[i5 + 2] = 0;
                }
            }
            arrayList.add(g3);
            i3 += 6;
            i2 = i4;
        }
        return arrayList;
    }

    public static byte[] b(int i2, BigDecimal bigDecimal) {
        byte[] g3 = g(i2, 0);
        w.c.a(g3, 2, bigDecimal.divide(i0.a.f1850p, 9, RoundingMode.HALF_UP).setScale(0, RoundingMode.HALF_UP).longValue());
        return g3;
    }

    public static byte[] c(int i2, BigDecimal bigDecimal) {
        byte[] g3 = g(i2, 1);
        w.c.a(g3, 2, bigDecimal.divide(i0.a.f1850p, 9, RoundingMode.HALF_UP).setScale(0, RoundingMode.HALF_UP).longValue());
        return g3;
    }

    public static byte[] d(String str) {
        byte[] g3 = g(0, 0);
        if (str.length() > 9) {
            throw new IllegalArgumentException("String is over 8 characters long");
        }
        int[] iArr = new int[9];
        for (int i2 = 0; i2 < 9; i2++) {
            if (i2 < str.length()) {
                char charAt = str.charAt(i2);
                if (charAt < ' ' || charAt > '_') {
                    throw new IllegalArgumentException(charAt + " is not in range of supported characters");
                }
                iArr[i2] = charAt - ' ';
            } else {
                iArr[i2] = 0;
            }
        }
        w.c.b(g3, 1, ((iArr[0] << 2) | ((iArr[1] & 48) >> 4)) & 255);
        w.c.b(g3, 2, (((iArr[1] & 15) << 4) | ((iArr[2] & 60) >> 2)) & 255);
        w.c.b(g3, 3, (((iArr[2] & 3) << 6) | iArr[3]) & 255);
        w.c.b(g3, 4, ((iArr[4] << 2) | ((iArr[5] & 48) >> 4)) & 255);
        w.c.b(g3, 5, (((iArr[5] & 15) << 4) | ((iArr[6] & 60) >> 2)) & 255);
        w.c.b(g3, 6, (((iArr[6] & 3) << 6) | iArr[7]) & 255);
        w.c.b(g3, 7, (iArr[8] << 2) & 255);
        return g3;
    }

    public static byte[] e(long j2, int i2) {
        byte[] g3 = g(1, 255);
        w.c.e(g3, 2, j2);
        w.c.b(g3, 6, i2);
        w.c.b(g3, 7, 255);
        return g3;
    }

    public static byte[] f(int i2, int i3, long j2) {
        byte[] g3 = g(i2, 4);
        w.c.e(g3, 2, j2 - 631065600);
        w.c.d(g3, 6, i3);
        return g3;
    }

    private static byte[] g(int i2, int i3) {
        byte[] bArr = new byte[8];
        w.c.b(bArr, 0, i2);
        w.c.b(bArr, 1, i3);
        return bArr;
    }

    public static List h(AntPlusGeocachePcc.ProgrammableGeocacheDeviceData programmableGeocacheDeviceData, boolean z2) {
        int i2;
        ArrayList arrayList = new ArrayList();
        String str = programmableGeocacheDeviceData.f720b;
        if (str == null) {
            throw new IllegalArgumentException("Required Identification String was null");
        }
        if (programmableGeocacheDeviceData.f721c == null) {
            throw new IllegalArgumentException("Required PIN was null");
        }
        arrayList.add(d(str));
        ArrayList arrayList2 = new ArrayList();
        BigDecimal bigDecimal = programmableGeocacheDeviceData.f722d;
        if (bigDecimal != null) {
            arrayList2.add(b(2, bigDecimal));
            i2 = 3;
        } else {
            i2 = 2;
        }
        BigDecimal bigDecimal2 = programmableGeocacheDeviceData.f723e;
        if (bigDecimal2 != null) {
            arrayList2.add(c(i2, bigDecimal2));
            i2++;
        }
        String str2 = programmableGeocacheDeviceData.f724f;
        if (str2 != null) {
            List a3 = a(i2, str2);
            i2 += a3.size();
            arrayList2.addAll(a3);
        }
        Integer num = programmableGeocacheDeviceData.f726h;
        if (num != null && programmableGeocacheDeviceData.f725g != null) {
            arrayList2.add(f(i2, num.intValue(), programmableGeocacheDeviceData.f725g.getTimeInMillis() / 1000));
            i2++;
        }
        arrayList.add(e(programmableGeocacheDeviceData.f721c.longValue(), i2));
        while (z2 && i2 < 32) {
            arrayList2.add(new byte[]{(byte) i2, -1, -1, -1, -1, -1, -1, -1});
            i2++;
        }
        arrayList.addAll(arrayList2);
        return arrayList;
    }
}
