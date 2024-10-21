package g0;

import android.os.Bundle;
import com.dsi.ant.message.ipc.AntMessageParcel;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class r extends w.b {

    /* renamed from: a */
    private u.a f1790a = new u.a(222);

    @Override // w.b
    public void b(long j2, long j3, AntMessageParcel antMessageParcel) {
        if (this.f1790a.b()) {
            Bundle bundle = new Bundle();
            bundle.putLong("long_EstTimestamp", j2);
            bundle.putLong("long_EventFlags", j3);
            int i2 = w.c.i(antMessageParcel.a()[6]);
            bundle.putSerializable("decimal_windResistanceCoefficient", i2 == 255 ? new BigDecimal("0.51") : new BigDecimal(i2).divide(new BigDecimal(100), 2, RoundingMode.HALF_UP));
            int i3 = w.c.i(antMessageParcel.a()[7]);
            bundle.putInt("int_windSpeed", i3 == 255 ? 0 : i3 - 127);
            int i4 = w.c.i(antMessageParcel.a()[8]);
            bundle.putSerializable("decimal_draftingFactor", i4 == 255 ? new BigDecimal("1.00") : new BigDecimal(i4).divide(new BigDecimal(100), 2, RoundingMode.HALF_UP));
            this.f1790a.a(bundle);
        }
    }

    @Override // w.b
    public List c() {
        return Arrays.asList(this.f1790a);
    }

    @Override // w.b
    public List d() {
        return Arrays.asList(50);
    }
}
