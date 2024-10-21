package g0;

import android.os.Bundle;
import com.dsi.ant.message.ipc.AntMessageParcel;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class p extends w.b {

    /* renamed from: a */
    private u.a f1788a = new u.a(220);

    @Override // w.b
    public void b(long j2, long j3, AntMessageParcel antMessageParcel) {
        if (this.f1788a.b()) {
            Bundle bundle = new Bundle();
            bundle.putLong("long_EstTimestamp", j2);
            bundle.putLong("long_EventFlags", j3);
            bundle.putSerializable("int_totalResistance", new BigDecimal(w.c.i(antMessageParcel.a()[8])).divide(new BigDecimal(2), 1, RoundingMode.HALF_UP));
            this.f1788a.a(bundle);
        }
    }

    @Override // w.b
    public List c() {
        return Arrays.asList(this.f1788a);
    }

    @Override // w.b
    public List d() {
        return Arrays.asList(48);
    }
}
