package g0;

import android.os.Bundle;
import com.dsi.ant.message.ipc.AntMessageParcel;
import com.dsi.ant.plugins.antplus.pcc.AntPlusFitnessEquipmentPcc;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class o extends w.b {

    /* renamed from: a */
    private u.a f1787a = new u.a(227);

    @Override // w.b
    public void b(long j2, long j3, AntMessageParcel antMessageParcel) {
        if (this.f1787a.b()) {
            Bundle bundle = new Bundle();
            bundle.putLong("long_EstTimestamp", j2);
            bundle.putLong("long_EventFlags", j3);
            AntPlusFitnessEquipmentPcc.CalibrationInProgress calibrationInProgress = new AntPlusFitnessEquipmentPcc.CalibrationInProgress();
            calibrationInProgress.f617e = (antMessageParcel.a()[2] & 64) != 0;
            calibrationInProgress.f618f = (antMessageParcel.a()[2] & 128) != 0;
            calibrationInProgress.f619g = AntPlusFitnessEquipmentPcc.CalibrationInProgress.c.c(w.c.q(antMessageParcel.a()[3]));
            calibrationInProgress.f620h = AntPlusFitnessEquipmentPcc.CalibrationInProgress.b.c(w.c.u(antMessageParcel.a()[3]));
            int i2 = w.c.i(antMessageParcel.a()[4]);
            if (i2 != 255) {
                calibrationInProgress.f614b = new BigDecimal(i2).divide(new BigDecimal(2), 1, RoundingMode.HALF_UP).subtract(new BigDecimal(25));
            }
            int k2 = w.c.k(antMessageParcel.a(), 5);
            if (k2 != 65535) {
                calibrationInProgress.f615c = new BigDecimal(k2).divide(new BigDecimal(1000), 3, RoundingMode.HALF_UP);
            }
            int k3 = w.c.k(antMessageParcel.a(), 7);
            if (k3 != 65535) {
                calibrationInProgress.f616d = Integer.valueOf(k3);
            }
            bundle.putParcelable("parcelable_CalibrationInProgress", calibrationInProgress);
            this.f1787a.a(bundle);
        }
    }

    @Override // w.b
    public List c() {
        return Arrays.asList(this.f1787a);
    }

    @Override // w.b
    public List d() {
        return Arrays.asList(2);
    }
}
