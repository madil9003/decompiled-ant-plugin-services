package p;

import android.os.Bundle;
import com.dsi.ant.message.ipc.AntMessageParcel;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class d extends w.b {

    /* renamed from: g */
    private static int f2874g = 12000;

    /* renamed from: a */
    private u.a f2875a = new u.a(205);

    /* renamed from: b */
    private w.f f2876b = new w.f(255, f2874g);

    /* renamed from: c */
    private w.f f2877c = new w.f(255, f2874g);

    /* renamed from: d */
    private w.f f2878d = new w.f(65535, f2874g);

    /* renamed from: e */
    private w.f f2879e = new w.f(65535, f2874g);

    /* renamed from: f */
    private o.b f2880f;

    public d(o.b bVar) {
        this.f2880f = bVar;
    }

    @Override // w.b
    public void b(long j2, long j3, AntMessageParcel antMessageParcel) {
        this.f2876b.h(w.c.i(antMessageParcel.a()[2]), j2);
        this.f2877c.h(w.c.i(antMessageParcel.a()[3]), j2);
        this.f2878d.h(w.c.k(antMessageParcel.a(), 5), j2);
        this.f2879e.h(w.c.k(antMessageParcel.a(), 7), j2);
        int i2 = w.c.i(antMessageParcel.a()[1]);
        this.f2880f.h(j2, j3, i2, this.f2876b, this.f2877c, this.f2878d, this.f2879e);
        this.f2880f.f(j2, j3, i2, this.f2876b, antMessageParcel);
        if (this.f2875a.b()) {
            Bundle bundle = new Bundle();
            bundle.putLong("long_EstTimestamp", j2);
            bundle.putLong("long_EventFlags", j3);
            bundle.putLong("long_crankTorqueUpdateEventCount", this.f2876b.c());
            bundle.putLong("long_accumulatedCrankTicks", this.f2877c.c());
            bundle.putSerializable("decimal_accumulatedCrankPeriod", new BigDecimal(this.f2878d.c()).divide(new BigDecimal(2048), 11, RoundingMode.HALF_UP));
            bundle.putSerializable("decimal_accumulatedCrankTorque", new BigDecimal(this.f2879e.c()).divide(new BigDecimal(32), 5, RoundingMode.HALF_UP));
            this.f2875a.a(bundle);
        }
    }

    @Override // w.b
    public List c() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f2875a);
        return arrayList;
    }

    @Override // w.b
    public List d() {
        return Arrays.asList(18);
    }
}
