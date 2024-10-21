package g0;

import android.os.Bundle;
import com.dsi.ant.message.ipc.AntMessageParcel;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class n extends w.b {

    /* renamed from: a */
    private a f1780a;

    /* renamed from: b */
    private o.b f1781b;

    /* renamed from: c */
    private u.a f1782c = new u.a(214);

    /* renamed from: d */
    private w.f f1783d = new w.f(255, 12000);

    /* renamed from: e */
    private w.f f1784e = new w.f(255, 12000);

    /* renamed from: f */
    private w.f f1785f = new w.f(65535, 12000);

    /* renamed from: g */
    private w.f f1786g = new w.f(65535, 12000);

    public n(a aVar, o.b bVar) {
        this.f1780a = aVar;
        this.f1781b = bVar;
    }

    @Override // w.b
    public void b(long j2, long j3, AntMessageParcel antMessageParcel) {
        this.f1780a.b(j2, j3, antMessageParcel);
        this.f1783d.h(w.c.i(antMessageParcel.a()[2]), j2);
        this.f1784e.h(w.c.i(antMessageParcel.a()[3]), j2);
        this.f1785f.h(w.c.k(antMessageParcel.a(), 4), j2);
        this.f1786g.h(w.c.k(antMessageParcel.a(), 6), j2);
        this.f1781b.h(j2, j3, w.c.i(antMessageParcel.a()[1]), this.f1783d, this.f1784e, this.f1785f, this.f1786g);
        if (this.f1782c.b()) {
            Bundle bundle = new Bundle();
            bundle.putLong("long_EstTimestamp", j2);
            bundle.putLong("long_EventFlags", j3);
            bundle.putLong("long_updateEventCount", this.f1783d.c());
            bundle.putLong("long_accumulatedWheelTicks", this.f1784e.c());
            bundle.putSerializable("decimal_accumulatedWheelPeriod", new BigDecimal(this.f1785f.c()).divide(new BigDecimal(2048), 11, RoundingMode.HALF_UP));
            bundle.putSerializable("decimal_accumulatedTorque", new BigDecimal(this.f1786g.c()).divide(new BigDecimal(32), 5, RoundingMode.HALF_UP));
            this.f1782c.a(bundle);
        }
    }

    @Override // w.b
    public List c() {
        return Arrays.asList(this.f1782c);
    }

    @Override // w.b
    public List d() {
        return Arrays.asList(26);
    }
}
