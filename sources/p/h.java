package p;

import android.os.Bundle;
import com.dsi.ant.message.ipc.AntMessageParcel;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class h extends w.b {

    /* renamed from: f */
    private static int f2890f = 12000;

    /* renamed from: a */
    private u.a f2891a = new u.a(208);

    /* renamed from: b */
    private w.f f2892b = new w.f(255, f2890f);

    /* renamed from: c */
    private w.f f2893c = new w.f(65535, f2890f);

    /* renamed from: d */
    private w.f f2894d = new w.f(65535, f2890f);

    /* renamed from: e */
    private o.b f2895e;

    public h(o.b bVar) {
        this.f2895e = bVar;
    }

    @Override // w.b
    public void b(long j2, long j3, AntMessageParcel antMessageParcel) {
        this.f2892b.h(w.c.i(antMessageParcel.a()[2]), j2);
        int j4 = w.c.j(antMessageParcel.a(), 3);
        this.f2893c.h(w.c.j(antMessageParcel.a(), 5), j2);
        this.f2894d.h(w.c.j(antMessageParcel.a(), 7), j2);
        this.f2895e.i(j2, j3, this.f2892b, j4, this.f2893c, this.f2894d);
        if (this.f2891a.b()) {
            Bundle bundle = new Bundle();
            bundle.putLong("long_EstTimestamp", j2);
            bundle.putLong("long_EventFlags", j3);
            bundle.putLong("long_ctfUpdateEventCount", this.f2892b.c());
            bundle.putSerializable("decimal_instantaneousSlope", new BigDecimal(j4).divide(new BigDecimal(10), 1, RoundingMode.HALF_UP));
            bundle.putSerializable("decimal_accumulatedTimeStamp", new BigDecimal(this.f2893c.c()).divide(new BigDecimal(2000), 4, RoundingMode.HALF_UP));
            bundle.putLong("long_accumulatedTorqueTicksStamp", this.f2894d.c());
            this.f2891a.a(bundle);
        }
    }

    @Override // w.b
    public List c() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f2891a);
        return arrayList;
    }

    @Override // w.b
    public List d() {
        return Arrays.asList(32);
    }
}
