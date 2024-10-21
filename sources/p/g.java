package p;

import android.os.Bundle;
import com.dsi.ant.message.ipc.AntMessageParcel;
import com.dsi.ant.plugins.antplus.pcc.AntPlusBikePowerPcc;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class g extends w.b {

    /* renamed from: a */
    private u.a f2889a = new u.a(217);

    @Override // w.b
    public void b(long j2, long j3, AntMessageParcel antMessageParcel) {
        if (this.f2889a.b()) {
            if (w.c.i(antMessageParcel.a()[2]) != 1) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putLong("long_EstTimestamp", j2);
            bundle.putLong("long_EventFlags", j3);
            int i2 = w.c.i(antMessageParcel.a()[5]);
            BigDecimal scale = i2 != 255 ? new BigDecimal(i2).multiply(new BigDecimal("0.5")).add(new BigDecimal("110")).setScale(1, RoundingMode.HALF_UP) : new BigDecimal(-1);
            byte b3 = antMessageParcel.a()[6];
            bundle.putParcelable("parcelable_CrankParameters", new AntPlusBikePowerPcc.CrankParameters(scale, AntPlusBikePowerPcc.d.c(w.c.p(b3)), AntPlusBikePowerPcc.h.c(w.c.t(b3)), AntPlusBikePowerPcc.g.c(w.c.q(b3)), AntPlusBikePowerPcc.e.c(w.c.u(b3)), (w.c.i(antMessageParcel.a()[7]) & 1) != 0));
            this.f2889a.a(bundle);
        }
    }

    @Override // w.b
    public List c() {
        return Arrays.asList(this.f2889a);
    }

    @Override // w.b
    public List d() {
        return Arrays.asList(2);
    }
}
