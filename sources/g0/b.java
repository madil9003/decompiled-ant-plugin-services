package g0;

import com.dsi.ant.plugins.antplus.pcc.AntPlusFitnessEquipmentPcc;
import java.math.BigDecimal;
import java.math.RoundingMode;

/* loaded from: classes.dex */
public abstract class b {
    public static byte[] a(boolean z2, boolean z3) {
        byte[] bArr = {1, 0, -1, -1, -1, -1, -1, -1};
        if (z2) {
            bArr[1] = (byte) (bArr[1] | 64);
        }
        if (z3) {
            bArr[1] = (byte) (bArr[1] | 128);
        }
        return bArr;
    }

    public static byte[] b(BigDecimal bigDecimal) {
        byte[] bArr = {(byte) AntPlusFitnessEquipmentPcc.CommandStatus.b.BASIC_RESISTANCE.b(), -1, -1, -1, -1, -1, -1, -1};
        bArr[7] = bigDecimal.multiply(new BigDecimal("2")).setScale(0, RoundingMode.HALF_UP).byteValue();
        return bArr;
    }

    public static byte[] c(BigDecimal bigDecimal) {
        byte[] bArr = {(byte) AntPlusFitnessEquipmentPcc.CommandStatus.b.TARGET_POWER.b(), -1, -1, -1, -1, -1, 0, 0};
        w.c.d(bArr, 6, bigDecimal.multiply(new BigDecimal("4")).setScale(0, RoundingMode.HALF_UP).intValue());
        return bArr;
    }

    public static byte[] d(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        byte[] bArr = {(byte) AntPlusFitnessEquipmentPcc.CommandStatus.b.TRACK_RESISTANCE.b(), -1, -1, -1, -1, -1, -1, -1};
        int intValue = bigDecimal.intValue() != 65535 ? bigDecimal.add(new BigDecimal(200)).multiply(new BigDecimal("100")).setScale(0, RoundingMode.HALF_UP).intValue() : 65535;
        byte byteValue = bigDecimal2.intValue() != 255 ? bigDecimal2.multiply(new BigDecimal("20000")).setScale(0, RoundingMode.HALF_UP).byteValue() : (byte) -1;
        w.c.d(bArr, 5, intValue);
        bArr[7] = byteValue;
        return bArr;
    }

    public static byte[] e(BigDecimal bigDecimal, BigDecimal bigDecimal2, BigDecimal bigDecimal3, BigDecimal bigDecimal4) {
        byte[] bArr = {55, -1, -1, -1, -1, -1, -1, 0};
        int intValue = bigDecimal.intValue() != 65535 ? bigDecimal.multiply(new BigDecimal("100")).setScale(0, RoundingMode.HALF_UP).intValue() : 65535;
        int intValue2 = bigDecimal2.intValue() != 4095 ? bigDecimal2.multiply(new BigDecimal("20")).setScale(0, RoundingMode.HALF_UP).intValue() : 4095;
        byte byteValue = bigDecimal3.intValue() != 255 ? bigDecimal3.multiply(new BigDecimal("100")).setScale(0, RoundingMode.HALF_UP).byteValue() : (byte) -1;
        byte byteValue2 = bigDecimal4.compareTo(new BigDecimal("0")) != 0 ? bigDecimal4.divide(new BigDecimal("0.03"), 0, RoundingMode.HALF_UP).byteValue() : (byte) 0;
        w.c.d(bArr, 1, intValue);
        w.c.f(bArr, 4, intValue2);
        bArr[6] = byteValue;
        bArr[7] = byteValue2;
        return bArr;
    }

    public static byte[] f(BigDecimal bigDecimal, byte b3, BigDecimal bigDecimal2) {
        byte[] bArr = {(byte) AntPlusFitnessEquipmentPcc.CommandStatus.b.WIND_RESISTANCE.b(), -1, -1, -1, -1, -1, -1, -1};
        byte byteValue = bigDecimal.intValue() != 255 ? bigDecimal.multiply(new BigDecimal("100")).setScale(0, RoundingMode.HALF_UP).byteValue() : (byte) -1;
        byte byteValue2 = bigDecimal2.intValue() != 255 ? bigDecimal2.multiply(new BigDecimal("100")).setScale(0, RoundingMode.HALF_UP).byteValue() : (byte) -1;
        if (b3 != -1) {
            b3 = (byte) (b3 + Byte.MAX_VALUE);
        }
        bArr[5] = byteValue;
        bArr[6] = b3;
        bArr[7] = byteValue2;
        return bArr;
    }
}
