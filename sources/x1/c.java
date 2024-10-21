package x1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Device;
import com.google.android.gms.fitness.data.zzb;

/* loaded from: classes.dex */
public final class c implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int u2 = r1.a.u(parcel);
        DataType dataType = null;
        Device device = null;
        zzb zzbVar = null;
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < u2) {
            int o2 = r1.a.o(parcel);
            int k2 = r1.a.k(o2);
            if (k2 == 1) {
                dataType = (DataType) r1.a.e(parcel, o2, DataType.CREATOR);
            } else if (k2 == 3) {
                i2 = r1.a.q(parcel, o2);
            } else if (k2 == 4) {
                device = (Device) r1.a.e(parcel, o2, Device.CREATOR);
            } else if (k2 == 5) {
                zzbVar = (zzb) r1.a.e(parcel, o2, zzb.CREATOR);
            } else if (k2 != 6) {
                r1.a.t(parcel, o2);
            } else {
                str = r1.a.f(parcel, o2);
            }
        }
        r1.a.j(parcel, u2);
        return new DataSource(dataType, i2, device, zzbVar, str);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i2) {
        return new DataSource[i2];
    }
}
