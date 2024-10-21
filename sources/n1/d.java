package n1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;

/* loaded from: classes.dex */
public final class d implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int u2 = r1.a.u(parcel);
        String str = null;
        int i2 = 0;
        long j2 = -1;
        while (parcel.dataPosition() < u2) {
            int o2 = r1.a.o(parcel);
            int k2 = r1.a.k(o2);
            if (k2 == 1) {
                str = r1.a.f(parcel, o2);
            } else if (k2 == 2) {
                i2 = r1.a.q(parcel, o2);
            } else if (k2 != 3) {
                r1.a.t(parcel, o2);
            } else {
                j2 = r1.a.r(parcel, o2);
            }
        }
        r1.a.j(parcel, u2);
        return new Feature(str, i2, j2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i2) {
        return new Feature[i2];
    }
}
