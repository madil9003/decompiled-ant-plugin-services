package z1;

import c2.e;
import c2.i;
import c2.l;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.result.DataSourcesResult;
import com.google.android.gms.fitness.service.FitnessSensorServiceRequest;
import com.google.android.gms.internal.fitness.zzex;
import com.google.android.gms.internal.fitness.zzez;

/* loaded from: classes.dex */
final class d extends l {

    /* renamed from: a */
    private final a f3623a;

    public /* synthetic */ d(a aVar, c cVar) {
        this.f3623a = aVar;
    }

    @Override // c2.m
    public final void B(zzex zzexVar, e eVar) {
        this.f3623a.d();
        eVar.l(new DataSourcesResult(this.f3623a.a(zzexVar.a()), Status.f1209f));
    }

    @Override // c2.m
    public final void k(zzez zzezVar, i iVar) {
        this.f3623a.d();
        iVar.A(this.f3623a.c(zzezVar.a()) ? Status.f1209f : new Status(13));
    }

    @Override // c2.m
    public final void p(FitnessSensorServiceRequest fitnessSensorServiceRequest, i iVar) {
        this.f3623a.d();
        iVar.A(this.f3623a.b(fitnessSensorServiceRequest) ? Status.f1209f : new Status(13));
    }
}
