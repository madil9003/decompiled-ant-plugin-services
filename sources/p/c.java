package p;

import android.os.Bundle;
import com.dsi.ant.message.ipc.AntMessageParcel;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class c extends w.b {

    /* renamed from: g */
    private static int f2867g = 12000;

    /* renamed from: a */
    private u.a f2868a = new u.a(204);

    /* renamed from: b */
    private w.f f2869b = new w.f(255, f2867g);

    /* renamed from: c */
    private w.f f2870c = new w.f(255, f2867g);

    /* renamed from: d */
    private w.f f2871d = new w.f(65535, f2867g);

    /* renamed from: e */
    private w.f f2872e = new w.f(65535, f2867g);

    /* renamed from: f */
    private o.b f2873f;

    public c(o.b bVar) {
        this.f2873f = bVar;
    }

    @Override // w.b
    public void b(long j2, long j3, AntMessageParcel antMessageParcel) {
        this.f2869b.h(w.c.i(antMessageParcel.a()[2]), j2);
        this.f2870c.h(w.c.i(antMessageParcel.a()[3]), j2);
        this.f2871d.h(w.c.k(antMessageParcel.a(), 5), j2);
        this.f2872e.h(w.c.k(antMessageParcel.a(), 7), j2);
        int i2 = w.c.i(antMessageParcel.a()[1]);
        this.f2873f.h(j2, j3, i2, this.f2869b, this.f2870c, this.f2871d, this.f2872e);
        this.f2873f.f(j2, j3, i2, this.f2869b, antMessageParcel);
        if (this.f2868a.b()) {
            Bundle bundle = new Bundle();
            bundle.putLong("long_EstTimestamp", j2);
            bundle.putLong("long_EventFlags", j3);
            bundle.putLong("long_wheelTorqueUpdateEventCount", this.f2869b.c());
            bundle.putLong("long_accumulatedWheelTicks", this.f2870c.c());
            bundle.putSerializable("decimal_accumulatedWheelPeriod", new BigDecimal(this.f2871d.c()).divide(new BigDecimal(2048), 11, RoundingMode.HALF_UP));
            bundle.putSerializable("decimal_accumulatedWheelTorque", new BigDecimal(this.f2872e.c()).divide(new BigDecimal(32), 5, RoundingMode.HALF_UP));
            this.f2868a.a(bundle);
        }
    }

    @Override // w.b
    public List c() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f2868a);
        return arrayList;
    }

    @Override // w.b
    public List d() {
        return Arrays.asList(17);
    }
}
