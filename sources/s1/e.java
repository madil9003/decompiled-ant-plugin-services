package s1;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.Feature;
import p1.h;
import q1.j;

/* loaded from: classes.dex */
public final class e extends com.google.android.gms.common.internal.c {
    private final j I;

    public e(Context context, Looper looper, q1.b bVar, j jVar, p1.c cVar, h hVar) {
        super(context, looper, 270, bVar, cVar, hVar);
        this.I = jVar;
    }

    @Override // com.google.android.gms.common.internal.b
    public final String D() {
        return "com.google.android.gms.common.internal.service.IClientTelemetryService";
    }

    @Override // com.google.android.gms.common.internal.b
    protected final String E() {
        return "com.google.android.gms.common.telemetry.service.START";
    }

    @Override // com.google.android.gms.common.internal.b
    protected final boolean H() {
        return true;
    }

    @Override // com.google.android.gms.common.internal.b, o1.a.f
    public final int p() {
        return 203400000;
    }

    @Override // com.google.android.gms.common.internal.b
    public final /* synthetic */ IInterface r(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.service.IClientTelemetryService");
        return queryLocalInterface instanceof a ? (a) queryLocalInterface : new a(iBinder);
    }

    @Override // com.google.android.gms.common.internal.b
    public final Feature[] u() {
        return a2.d.f102b;
    }

    @Override // com.google.android.gms.common.internal.b
    protected final Bundle z() {
        return this.I.b();
    }
}
