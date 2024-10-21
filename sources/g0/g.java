package g0;

import android.os.Bundle;
import com.dsi.ant.message.ipc.AntMessageParcel;
import com.dsi.ant.plugins.antplus.pcc.AntPlusFitnessEquipmentPcc;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class g extends w.b {

    /* renamed from: a */
    private u.a f1758a = new u.a(226);

    @Override // w.b
    public void b(long j2, long j3, AntMessageParcel antMessageParcel) {
        if (this.f1758a.b()) {
            Bundle bundle = new Bundle();
            bundle.putLong("long_EstTimestamp", j2);
            bundle.putLong("long_EventFlags", j3);
            AntPlusFitnessEquipmentPcc.CalibrationResponse calibrationResponse = new AntPlusFitnessEquipmentPcc.CalibrationResponse();
            calibrationResponse.f638e = (antMessageParcel.a()[2] & 64) != 0;
            calibrationResponse.f639f = (antMessageParcel.a()[2] & 128) != 0;
            int i2 = w.c.i(antMessageParcel.a()[4]);
            if (i2 != 255) {
                calibrationResponse.f635b = new BigDecimal(i2).divide(new BigDecimal(2), 1, RoundingMode.HALF_UP).subtract(new BigDecimal(25));
            }
            int k2 = w.c.k(antMessageParcel.a(), 5);
            if (k2 != 65535) {
                calibrationResponse.f636c = Integer.valueOf(k2);
            }
            int k3 = w.c.k(antMessageParcel.a(), 7);
            if (k3 != 65535) {
                calibrationResponse.f637d = Integer.valueOf(k3);
            }
            bundle.putParcelable("parcelable_CalibrationResponse", calibrationResponse);
            this.f1758a.a(bundle);
        }
    }

    @Override // w.b
    public List c() {
        return Arrays.asList(this.f1758a);
    }

    @Override // w.b
    public List d() {
        return Arrays.asList(1);
    }
}
