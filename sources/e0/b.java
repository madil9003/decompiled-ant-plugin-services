package e0;

import android.os.Bundle;
import com.dsi.ant.message.ipc.AntMessageParcel;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import w.c;

/* loaded from: classes.dex */
public class b extends w.b {

    /* renamed from: a */
    private u.a f1649a = new u.a(201);

    /* renamed from: b */
    private w.a f1650b = new w.a(255);

    @Override // w.b
    public void b(long j2, long j3, AntMessageParcel antMessageParcel) {
        this.f1650b.a(c.i(antMessageParcel.a()[3]));
        if (this.f1649a.b()) {
            Bundle bundle = new Bundle();
            bundle.putLong("long_EstTimestamp", j2);
            bundle.putLong("long_EventFlags", j3);
            bundle.putSerializable("decimal_currentTemperature", new BigDecimal((antMessageParcel.a()[7] & 255) + (antMessageParcel.a()[8] << 8)).divide(new BigDecimal(100), 2, RoundingMode.HALF_UP).setScale(2));
            bundle.putLong("long_eventCount", this.f1650b.c());
            bundle.putSerializable("decimal_lowLast24Hours", new BigDecimal((antMessageParcel.a()[4] & 255) + (((byte) (antMessageParcel.a()[5] & 240)) << 4)).divide(new BigDecimal(10), 2, RoundingMode.HALF_UP).setScale(1));
            bundle.putSerializable("decimal_highLast24Hours", new BigDecimal((antMessageParcel.a()[5] & 15) + (antMessageParcel.a()[6] << 4)).divide(new BigDecimal(10), 2, RoundingMode.HALF_UP).setScale(1));
            this.f1649a.a(bundle);
        }
    }

    @Override // w.b
    public List c() {
        return Arrays.asList(this.f1649a);
    }

    @Override // w.b
    public List d() {
        return Arrays.asList(1);
    }

    @Override // w.b
    public void e() {
        this.f1650b.g();
        super.e();
    }
}
