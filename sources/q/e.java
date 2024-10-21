package q;

import android.os.Bundle;
import com.dsi.ant.message.ipc.AntMessageParcel;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class e extends w.b {

    /* renamed from: a */
    private u.a f3008a = new u.a(207);

    @Override // w.b
    public void b(long j2, long j3, AntMessageParcel antMessageParcel) {
        if (this.f3008a.b()) {
            Bundle bundle = new Bundle();
            bundle.putLong("long_EstTimestamp", j2);
            bundle.putLong("long_EventFlags", j3);
            bundle.putSerializable("decimal_batteryVoltage", (antMessageParcel.a()[4] & 15) != 15 ? new BigDecimal(15 & antMessageParcel.a()[4]).add(new BigDecimal(w.c.i(antMessageParcel.a()[3])).divide(new BigDecimal(256), 8, RoundingMode.HALF_UP)).setScale(8) : new BigDecimal(-1));
            bundle.putInt("int_batteryStatus", (antMessageParcel.a()[4] & 112) >> 4);
            this.f3008a.a(bundle);
        }
    }

    @Override // w.b
    public List c() {
        return Arrays.asList(this.f3008a);
    }

    @Override // w.b
    public List d() {
        return Arrays.asList(4);
    }
}
