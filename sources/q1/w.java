package q1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;

/* loaded from: classes.dex */
public final class w implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int u2 = r1.a.u(parcel);
        int i2 = 0;
        boolean z2 = false;
        boolean z3 = false;
        int i3 = 0;
        int i4 = 0;
        while (parcel.dataPosition() < u2) {
            int o2 = r1.a.o(parcel);
            int k2 = r1.a.k(o2);
            if (k2 == 1) {
                i2 = r1.a.q(parcel, o2);
            } else if (k2 == 2) {
                z2 = r1.a.l(parcel, o2);
            } else if (k2 == 3) {
                z3 = r1.a.l(parcel, o2);
            } else if (k2 == 4) {
                i3 = r1.a.q(parcel, o2);
            } else if (k2 != 5) {
                r1.a.t(parcel, o2);
            } else {
                i4 = r1.a.q(parcel, o2);
            }
        }
        r1.a.j(parcel, u2);
        return new RootTelemetryConfiguration(i2, z2, z3, i3, i4);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i2) {
        return new RootTelemetryConfiguration[i2];
    }
}
