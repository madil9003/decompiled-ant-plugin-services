package g0;

import android.os.Bundle;
import com.dsi.ant.message.ipc.AntMessageParcel;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class c extends w.b {

    /* renamed from: a */
    private u.a f1745a = new u.a(203);

    /* renamed from: b */
    private w.a f1746b = new w.a(255);

    /* renamed from: c */
    private w.a f1747c = new w.a(255);

    /* renamed from: d */
    private a f1748d;

    public c(a aVar) {
        this.f1748d = aVar;
    }

    @Override // w.b
    public void b(long j2, long j3, AntMessageParcel antMessageParcel) {
        this.f1746b.a(w.c.i(antMessageParcel.a()[3]));
        boolean z2 = (w.c.i(antMessageParcel.a()[8]) & 4) == 4;
        if (z2) {
            this.f1747c.a(w.c.i(antMessageParcel.a()[4]));
        }
        if (!this.f1745a.b()) {
            this.f1748d.b(j2, j3, antMessageParcel);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putLong("long_EstTimestamp", j2);
        bundle.putLong("long_EventFlags", j3);
        bundle.putSerializable("decimal_elapsedTime", new BigDecimal(this.f1746b.c()).divide(new BigDecimal(4), 2, RoundingMode.HALF_UP));
        bundle.putLong("long_cumulativeDistance", z2 ? this.f1747c.c() : -1L);
        int k2 = w.c.k(antMessageParcel.a(), 5);
        bundle.putSerializable("decimal_instantaneousSpeed", k2 == 65535 ? new BigDecimal(-1) : new BigDecimal(k2).divide(new BigDecimal(1000), 3, RoundingMode.HALF_UP));
        int i2 = w.c.i(antMessageParcel.a()[7]);
        bundle.putInt("int_instantaneousHeartRate", i2 != 255 ? i2 : -1);
        bundle.putInt("int_heartRateDataSourceCode", w.c.i(antMessageParcel.a()[8]) & 3);
        bundle.putBoolean("bool_virtualInstantaneousSpeed", (w.c.i(antMessageParcel.a()[8]) & 8) != 0);
        this.f1745a.a(bundle);
        this.f1748d.b(j2, j3, antMessageParcel);
    }

    @Override // w.b
    public List c() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f1745a);
        arrayList.addAll(this.f1748d.c());
        return arrayList;
    }

    @Override // w.b
    public List d() {
        return Arrays.asList(16);
    }

    @Override // w.b
    public void e() {
        this.f1746b.g();
        this.f1747c.g();
        this.f1748d.e();
    }
}
