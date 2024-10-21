package x1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.fitness.data.Device;

/* loaded from: classes.dex */
public final class d implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int u2 = r1.a.u(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < u2) {
            int o2 = r1.a.o(parcel);
            int k2 = r1.a.k(o2);
            if (k2 == 1) {
                str = r1.a.f(parcel, o2);
            } else if (k2 == 2) {
                str2 = r1.a.f(parcel, o2);
            } else if (k2 == 4) {
                str3 = r1.a.f(parcel, o2);
            } else if (k2 == 5) {
                i2 = r1.a.q(parcel, o2);
            } else if (k2 != 6) {
                r1.a.t(parcel, o2);
            } else {
                i3 = r1.a.q(parcel, o2);
            }
        }
        r1.a.j(parcel, u2);
        return new Device(str, str2, str3, i2, i3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i2) {
        return new Device[i2];
    }
}
