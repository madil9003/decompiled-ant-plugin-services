package s1;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.TelemetryData;

/* loaded from: classes.dex */
public final class a extends a2.a {
    public a(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.service.IClientTelemetryService");
    }

    public final void F(TelemetryData telemetryData) {
        Parcel a3 = a();
        a2.c.b(a3, telemetryData);
        j(1, a3);
    }
}
