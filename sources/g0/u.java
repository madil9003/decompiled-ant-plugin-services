package g0;

import android.os.Bundle;
import com.dsi.ant.message.ipc.AntMessageParcel;
import com.dsi.ant.plugins.antplus.pcc.AntPlusFitnessEquipmentPcc;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class u extends w.b {

    /* renamed from: a */
    private u.a f1793a = new u.a(225);

    @Override // w.b
    public void b(long j2, long j3, AntMessageParcel antMessageParcel) {
        if (this.f1793a.b()) {
            Bundle bundle = new Bundle();
            bundle.putLong("long_EstTimestamp", j2);
            bundle.putLong("long_EventFlags", j3);
            AntPlusFitnessEquipmentPcc.UserConfiguration userConfiguration = new AntPlusFitnessEquipmentPcc.UserConfiguration();
            int k2 = w.c.k(antMessageParcel.a(), 2);
            userConfiguration.f675b = k2 != 65535 ? new BigDecimal(k2).divide(new BigDecimal(100), 2, RoundingMode.HALF_UP) : null;
            int s2 = w.c.s(antMessageParcel.a(), 5);
            userConfiguration.f676c = s2 != 4095 ? new BigDecimal(s2).divide(new BigDecimal(20), 2, RoundingMode.HALF_UP) : null;
            int i2 = w.c.i(antMessageParcel.a()[7]);
            userConfiguration.f677d = i2 != 255 ? new BigDecimal(i2).divide(new BigDecimal(100), 2, RoundingMode.HALF_UP) : null;
            int i3 = w.c.i(antMessageParcel.a()[8]);
            userConfiguration.f678e = i3 != 0 ? new BigDecimal(i3).multiply(new BigDecimal("0.03")).setScale(2, RoundingMode.HALF_UP) : null;
            bundle.putParcelable("parcelable_UserConfiguration", userConfiguration);
            this.f1793a.a(bundle);
        }
    }

    @Override // w.b
    public List c() {
        return Arrays.asList(this.f1793a);
    }

    @Override // w.b
    public List d() {
        return Arrays.asList(55);
    }
}
