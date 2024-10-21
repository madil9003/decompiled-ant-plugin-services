package s1;

import android.content.Context;
import com.google.android.gms.common.api.internal.c;
import com.google.android.gms.common.internal.TelemetryData;
import o1.a;
import o1.d;
import q1.i;
import q1.j;

/* loaded from: classes.dex */
public final class d extends o1.d implements i {

    /* renamed from: k */
    private static final a.g f3281k;

    /* renamed from: l */
    private static final a.AbstractC0046a f3282l;

    /* renamed from: m */
    private static final o1.a f3283m;

    /* renamed from: n */
    public static final /* synthetic */ int f3284n = 0;

    static {
        a.g gVar = new a.g();
        f3281k = gVar;
        c cVar = new c();
        f3282l = cVar;
        f3283m = new o1.a("ClientTelemetry.API", cVar, gVar);
    }

    public d(Context context, j jVar) {
        super(context, f3283m, jVar, d.a.f2854c);
    }

    @Override // q1.i
    public final g2.d a(final TelemetryData telemetryData) {
        c.a a3 = com.google.android.gms.common.api.internal.c.a();
        a3.d(a2.d.f101a);
        a3.c(false);
        a3.b(new p1.i() { // from class: s1.b
            @Override // p1.i
            public final void a(Object obj, Object obj2) {
                TelemetryData telemetryData2 = TelemetryData.this;
                int i2 = d.f3284n;
                ((a) ((e) obj).C()).F(telemetryData2);
                ((g2.e) obj2).b(null);
            }
        });
        return c(a3.a());
    }
}
