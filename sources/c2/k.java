package c2;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.internal.fitness.zzez;

/* loaded from: classes.dex */
public final class k implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int u2 = r1.a.u(parcel);
        DataSource dataSource = null;
        while (parcel.dataPosition() < u2) {
            int o2 = r1.a.o(parcel);
            if (r1.a.k(o2) != 1) {
                r1.a.t(parcel, o2);
            } else {
                dataSource = (DataSource) r1.a.e(parcel, o2, DataSource.CREATOR);
            }
        }
        r1.a.j(parcel, u2);
        return new zzez(dataSource);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i2) {
        return new zzez[i2];
    }
}
