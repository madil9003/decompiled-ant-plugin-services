package g0;

import android.os.Bundle;
import com.dsi.ant.message.ipc.AntMessageParcel;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class s extends w.b {

    /* renamed from: a */
    private u.a f1791a = new u.a(223);

    @Override // w.b
    public void b(long j2, long j3, AntMessageParcel antMessageParcel) {
        if (this.f1791a.b()) {
            Bundle bundle = new Bundle();
            bundle.putLong("long_EstTimestamp", j2);
            bundle.putLong("long_EventFlags", j3);
            int k2 = w.c.k(antMessageParcel.a(), 6);
            bundle.putSerializable("decimal_grade", k2 != 65535 ? new BigDecimal(k2).divide(new BigDecimal(100), 2, RoundingMode.HALF_UP).subtract(new BigDecimal(200)) : new BigDecimal("0.00"));
            int i2 = w.c.i(antMessageParcel.a()[8]);
            bundle.putSerializable("decimal_rollingResistanceCoefficient", i2 != 255 ? new BigDecimal(i2).divide(new BigDecimal(20000), 5, RoundingMode.HALF_UP) : new BigDecimal("0.004"));
            this.f1791a.a(bundle);
        }
    }

    @Override // w.b
    public List c() {
        return Arrays.asList(this.f1791a);
    }

    @Override // w.b
    public List d() {
        return Arrays.asList(51);
    }
}
