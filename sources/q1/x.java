package q1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ConnectionTelemetryConfiguration;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;

/* loaded from: classes.dex */
public final class x implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int u2 = r1.a.u(parcel);
        RootTelemetryConfiguration rootTelemetryConfiguration = null;
        int[] iArr = null;
        int[] iArr2 = null;
        boolean z2 = false;
        boolean z3 = false;
        int i2 = 0;
        while (parcel.dataPosition() < u2) {
            int o2 = r1.a.o(parcel);
            switch (r1.a.k(o2)) {
                case 1:
                    rootTelemetryConfiguration = (RootTelemetryConfiguration) r1.a.e(parcel, o2, RootTelemetryConfiguration.CREATOR);
                    break;
                case 2:
                    z2 = r1.a.l(parcel, o2);
                    break;
                case 3:
                    z3 = r1.a.l(parcel, o2);
                    break;
                case 4:
                    iArr = r1.a.d(parcel, o2);
                    break;
                case 5:
                    i2 = r1.a.q(parcel, o2);
                    break;
                case 6:
                    iArr2 = r1.a.d(parcel, o2);
                    break;
                default:
                    r1.a.t(parcel, o2);
                    break;
            }
        }
        r1.a.j(parcel, u2);
        return new ConnectionTelemetryConfiguration(rootTelemetryConfiguration, z2, z3, iArr, i2, iArr2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i2) {
        return new ConnectionTelemetryConfiguration[i2];
    }
}
