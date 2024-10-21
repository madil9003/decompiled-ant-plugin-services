package g0;

import android.os.Bundle;
import com.dsi.ant.message.ipc.AntMessageParcel;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class q extends w.b {

    /* renamed from: a */
    private u.a f1789a = new u.a(221);

    @Override // w.b
    public void b(long j2, long j3, AntMessageParcel antMessageParcel) {
        if (this.f1789a.b()) {
            Bundle bundle = new Bundle();
            bundle.putLong("long_EstTimestamp", j2);
            bundle.putLong("long_EventFlags", j3);
            bundle.putSerializable("decimal_targetPower", new BigDecimal(w.c.k(antMessageParcel.a(), 7)).divide(new BigDecimal(4), 2, RoundingMode.HALF_UP));
            this.f1789a.a(bundle);
        }
    }

    @Override // w.b
    public List c() {
        return Arrays.asList(this.f1789a);
    }

    @Override // w.b
    public List d() {
        return Arrays.asList(49);
    }
}
