package g0;

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
    private u.a f1751a = new u.a(205);

    /* renamed from: b */
    private w.a f1752b = new w.a(255);

    /* renamed from: c */
    private a f1753c;

    public e(a aVar) {
        this.f1753c = aVar;
    }

    @Override // w.b
    public void b(long j2, long j3, AntMessageParcel antMessageParcel) {
        boolean z2 = (w.c.i(antMessageParcel.a()[8]) & 1) == 1;
        if (z2) {
            this.f1752b.a(w.c.i(antMessageParcel.a()[7]));
        }
        if (this.f1751a.b()) {
            Bundle bundle = new Bundle();
            bundle.putLong("long_EstTimestamp", j2);
            bundle.putLong("long_EventFlags", j3);
            int k2 = w.c.k(antMessageParcel.a(), 3);
            bundle.putSerializable("decimal_instantaneousMetabolicEquivalents", k2 == 65535 ? new BigDecimal(-1) : new BigDecimal(k2).divide(new BigDecimal(100), 2, RoundingMode.HALF_UP));
            int k3 = w.c.k(antMessageParcel.a(), 5);
            bundle.putSerializable("decimal_instantaneousCaloricBurn", k3 == 65535 ? new BigDecimal(-1) : new BigDecimal(k3).divide(new BigDecimal(10), 1, RoundingMode.HALF_UP));
            bundle.putLong("long_cumulativeCalories", z2 ? this.f1752b.c() : -1L);
            this.f1751a.a(bundle);
        }
        this.f1753c.b(j2, j3, antMessageParcel);
    }

    @Override // w.b
    public List c() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f1751a);
        return arrayList;
    }

    @Override // w.b
    public List d() {
        return Arrays.asList(18);
    }

    @Override // w.b
    public void e() {
        this.f1752b.g();
        this.f1753c.e();
    }
}
