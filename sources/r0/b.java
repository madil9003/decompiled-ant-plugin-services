package r0;

import android.os.Bundle;
import com.dsi.ant.message.ipc.AntMessageParcel;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class b extends a {

    /* renamed from: b */
    private u.a f3062b = new u.a(205);

    /* renamed from: c */
    private u.a f3063c = new u.a(203);

    /* renamed from: d */
    private u.a f3064d = new u.a(204);

    /* renamed from: e */
    private u.a f3065e = new u.a(206);

    /* renamed from: f */
    private w.a f3066f = new w.a(51199);

    /* renamed from: g */
    private w.a f3067g = new w.a(4095);

    /* renamed from: h */
    private w.a f3068h = new w.a(255);

    @Override // r0.a, w.b
    public void b(long j2, long j3, AntMessageParcel antMessageParcel) {
        this.f3066f.a(w.c.i(antMessageParcel.a()[2]) + (w.c.i(antMessageParcel.a()[3]) * 200));
        this.f3067g.a(((antMessageParcel.a()[5] & 240) >>> 4) + (w.c.i(antMessageParcel.a()[4]) * 16));
        this.f3068h.a(w.c.i(antMessageParcel.a()[7]));
        if (this.f3062b.b()) {
            Bundle bundle = new Bundle();
            bundle.putLong("long_EstTimestamp", j2);
            bundle.putLong("long_EventFlags", j3);
            bundle.putSerializable("decimal_timestampOfLastComputation", new BigDecimal(this.f3066f.c()).divide(new BigDecimal(200), 3, RoundingMode.HALF_UP).setScale(3));
            this.f3062b.a(bundle);
        }
        if (this.f3063c.b()) {
            Bundle bundle2 = new Bundle();
            bundle2.putLong("long_EstTimestamp", j2);
            bundle2.putLong("long_EventFlags", j3);
            bundle2.putSerializable("decimal_cumulativeDistance", new BigDecimal(this.f3067g.c()).divide(new BigDecimal(16)).setScale(4));
            this.f3063c.a(bundle2);
        }
        if (this.f3064d.b()) {
            Bundle bundle3 = new Bundle();
            bundle3.putLong("long_EstTimestamp", j2);
            bundle3.putLong("long_EventFlags", j3);
            bundle3.putLong("long_cumulativeStrides", this.f3068h.c());
            this.f3064d.a(bundle3);
        }
        if (this.f3065e.b()) {
            Bundle bundle4 = new Bundle();
            bundle4.putLong("long_EstTimestamp", j2);
            bundle4.putLong("long_EventFlags", j3);
            bundle4.putSerializable("decimal_updateLatency", new BigDecimal(w.c.i(antMessageParcel.a()[8])).divide(new BigDecimal(32)).setScale(5));
            this.f3065e.a(bundle4);
        }
        super.b(j2, j3, antMessageParcel);
    }

    @Override // r0.a, w.b
    public List c() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f3062b);
        arrayList.add(this.f3063c);
        arrayList.add(this.f3064d);
        arrayList.add(this.f3065e);
        arrayList.addAll(super.c());
        return arrayList;
    }

    @Override // w.b
    public List d() {
        return Arrays.asList(1);
    }

    @Override // w.b
    public void e() {
        this.f3066f.g();
        this.f3067g.g();
        this.f3068h.g();
        super.e();
    }
}
