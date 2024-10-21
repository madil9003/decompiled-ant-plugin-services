package g0;

import android.os.Bundle;
import com.dsi.ant.message.ipc.AntMessageParcel;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class d extends w.b {

    /* renamed from: a */
    private u.a f1749a = new u.a(204);

    /* renamed from: b */
    private a f1750b;

    public d(a aVar) {
        this.f1750b = aVar;
    }

    @Override // w.b
    public void b(long j2, long j3, AntMessageParcel antMessageParcel) {
        if (!this.f1749a.b()) {
            this.f1750b.b(j2, j3, antMessageParcel);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putLong("long_EstTimestamp", j2);
        bundle.putLong("long_EventFlags", j3);
        int i2 = w.c.i(antMessageParcel.a()[4]);
        bundle.putSerializable("decimal_cycleLength", i2 == 255 ? new BigDecimal(-1) : new BigDecimal(i2).divide(new BigDecimal(100), 2, RoundingMode.HALF_UP));
        short g3 = w.c.g(antMessageParcel.a(), 5);
        bundle.putSerializable("decimal_inclinePercentage", g3 == Short.MAX_VALUE ? new BigDecimal(32767) : new BigDecimal((int) g3).divide(new BigDecimal(100), 2, RoundingMode.HALF_UP));
        int i3 = w.c.i(antMessageParcel.a()[7]);
        bundle.putInt("int_resistanceLevel", i3 != 255 ? i3 : -1);
        this.f1749a.a(bundle);
        this.f1750b.b(j2, j3, antMessageParcel);
    }

    @Override // w.b
    public List c() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f1749a);
        return arrayList;
    }

    @Override // w.b
    public List d() {
        return Arrays.asList(17);
    }

    @Override // w.b
    public void e() {
        this.f1750b.e();
    }
}
