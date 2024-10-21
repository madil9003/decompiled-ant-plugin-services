package g0;

import android.os.Bundle;
import com.dsi.ant.plugins.antplus.pcc.AntPlusFitnessEquipmentPcc;
import java.math.BigDecimal;
import java.math.RoundingMode;

/* loaded from: classes.dex */
public class v extends x.c {

    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a */
        static final /* synthetic */ int[] f1794a;

        static {
            int[] iArr = new int[AntPlusFitnessEquipmentPcc.CommandStatus.b.values().length];
            f1794a = iArr;
            try {
                iArr[AntPlusFitnessEquipmentPcc.CommandStatus.b.BASIC_RESISTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1794a[AntPlusFitnessEquipmentPcc.CommandStatus.b.TARGET_POWER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1794a[AntPlusFitnessEquipmentPcc.CommandStatus.b.WIND_RESISTANCE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1794a[AntPlusFitnessEquipmentPcc.CommandStatus.b.TRACK_RESISTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public v() {
        super(new u.a(219));
    }

    @Override // x.c
    protected void f(Bundle bundle) {
        AntPlusFitnessEquipmentPcc.CommandStatus commandStatus = new AntPlusFitnessEquipmentPcc.CommandStatus();
        commandStatus.f646b = AntPlusFitnessEquipmentPcc.CommandStatus.b.c(this.f3524a);
        int i2 = this.f3525b;
        if (i2 == 255) {
            i2 = -1;
        }
        commandStatus.f647c = i2;
        commandStatus.f648d = AntPlusFitnessEquipmentPcc.CommandStatus.c.c(this.f3526c.b());
        byte[] bArr = new byte[4];
        commandStatus.f649e = bArr;
        byte[] bArr2 = this.f3527d;
        System.arraycopy(bArr2, 0, bArr, 0, bArr2.length);
        int i3 = a.f1794a[commandStatus.f646b.ordinal()];
        if (i3 == 1) {
            commandStatus.f650f = new BigDecimal(w.c.i(this.f3527d[3])).divide(new BigDecimal(2), 1, RoundingMode.HALF_UP);
        } else if (i3 == 2) {
            commandStatus.f651g = new BigDecimal(w.c.k(this.f3527d, 2)).divide(new BigDecimal(4), 2, RoundingMode.HALF_UP);
        } else if (i3 == 3) {
            int i4 = w.c.i(this.f3527d[1]);
            commandStatus.f652h = i4 == 255 ? new BigDecimal("0.51") : new BigDecimal(i4).divide(new BigDecimal(100), 2, RoundingMode.HALF_UP);
            int i5 = w.c.i(this.f3527d[2]);
            commandStatus.f653i = Integer.valueOf(i5 != 255 ? i5 - 127 : 0);
            int i6 = w.c.i(this.f3527d[3]);
            commandStatus.f654j = i6 == 255 ? new BigDecimal("1.00") : new BigDecimal(i6).divide(new BigDecimal(100), 2, RoundingMode.HALF_UP);
        } else if (i3 == 4) {
            int k2 = w.c.k(this.f3527d, 1);
            commandStatus.f655k = k2 != 65535 ? new BigDecimal(k2).divide(new BigDecimal(100), 2, RoundingMode.HALF_UP).subtract(new BigDecimal(200)) : new BigDecimal("0.00");
            int i7 = w.c.i(this.f3527d[3]);
            commandStatus.f656l = i7 != 255 ? new BigDecimal(i7).divide(new BigDecimal(20000), 5, RoundingMode.HALF_UP) : new BigDecimal("0.004");
        }
        bundle.putParcelable("parcelable_CommandStatus", commandStatus);
    }
}
