package q1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.MethodInvocation;
import com.google.android.gms.common.internal.TelemetryData;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class k implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int u2 = r1.a.u(parcel);
        int i2 = 0;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < u2) {
            int o2 = r1.a.o(parcel);
            int k2 = r1.a.k(o2);
            if (k2 == 1) {
                i2 = r1.a.q(parcel, o2);
            } else if (k2 != 2) {
                r1.a.t(parcel, o2);
            } else {
                arrayList = r1.a.i(parcel, o2, MethodInvocation.CREATOR);
            }
        }
        r1.a.j(parcel, u2);
        return new TelemetryData(i2, arrayList);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i2) {
        return new TelemetryData[i2];
    }
}
