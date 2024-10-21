package p;

import android.os.Bundle;
import com.dsi.ant.message.ipc.AntMessageParcel;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class e extends w.b {

    /* renamed from: a */
    private u.a f2881a = new u.a(206);

    /* renamed from: b */
    private u.a f2882b = new u.a(207);

    /* renamed from: c */
    private w.f f2883c;

    public e(w.f fVar) {
        this.f2883c = fVar;
    }

    @Override // w.b
    public void b(long j2, long j3, AntMessageParcel antMessageParcel) {
        int i2;
        int i3 = w.c.i(antMessageParcel.a()[3]);
        int i4 = w.c.i(antMessageParcel.a()[4]);
        if (this.f2881a.b()) {
            Bundle bundle = new Bundle();
            bundle.putLong("long_EstTimestamp", j2);
            bundle.putLong("long_EventFlags", j3);
            bundle.putLong("long_powerOnlyUpdateEventCount", this.f2883c.c());
            bundle.putSerializable("decimal_leftTorqueEffectiveness", i3 != 255 ? new BigDecimal(i3).divide(new BigDecimal(2), 1, RoundingMode.HALF_UP) : new BigDecimal(-1));
            bundle.putSerializable("decimal_rightTorqueEffectiveness", i4 != 255 ? new BigDecimal(i4).divide(new BigDecimal(2), 1, RoundingMode.HALF_UP) : new BigDecimal(-1));
            this.f2881a.a(bundle);
        }
        int i5 = w.c.i(antMessageParcel.a()[5]);
        int i6 = w.c.i(antMessageParcel.a()[6]);
        if (this.f2882b.b()) {
            Bundle bundle2 = new Bundle();
            bundle2.putLong("long_EstTimestamp", j2);
            bundle2.putLong("long_EventFlags", j3);
            bundle2.putLong("long_powerOnlyUpdateEventCount", this.f2883c.c());
            bundle2.putSerializable("decimal_leftOrCombinedPedalSmoothness", i5 != 255 ? new BigDecimal(i5).divide(new BigDecimal(2), 1, RoundingMode.HALF_UP) : new BigDecimal(-1));
            if (i6 == 254) {
                bundle2.putBoolean("bool_separatePedalSmoothnessSupport", false);
                i2 = 1;
            } else {
                i2 = 1;
                bundle2.putBoolean("bool_separatePedalSmoothnessSupport", true);
            }
            bundle2.putSerializable("decimal_rightPedalSmoothness", (i6 == 255 || i6 == 254) ? new BigDecimal(-1) : new BigDecimal(i6).divide(new BigDecimal(2), i2, RoundingMode.HALF_UP));
            this.f2882b.a(bundle2);
        }
    }

    @Override // w.b
    public List c() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f2881a);
        arrayList.add(this.f2882b);
        return arrayList;
    }

    @Override // w.b
    public List d() {
        return Arrays.asList(19);
    }
}
