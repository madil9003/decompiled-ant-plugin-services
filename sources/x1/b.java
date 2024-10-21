package x1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.Value;

/* loaded from: classes.dex */
public final class b implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int u2 = r1.a.u(parcel);
        DataSource dataSource = null;
        Value[] valueArr = null;
        DataSource dataSource2 = null;
        long j2 = 0;
        long j3 = 0;
        long j4 = 0;
        while (parcel.dataPosition() < u2) {
            int o2 = r1.a.o(parcel);
            int k2 = r1.a.k(o2);
            if (k2 == 1) {
                dataSource = (DataSource) r1.a.e(parcel, o2, DataSource.CREATOR);
            } else if (k2 == 3) {
                j2 = r1.a.r(parcel, o2);
            } else if (k2 == 4) {
                j3 = r1.a.r(parcel, o2);
            } else if (k2 == 5) {
                valueArr = (Value[]) r1.a.h(parcel, o2, Value.CREATOR);
            } else if (k2 == 6) {
                dataSource2 = (DataSource) r1.a.e(parcel, o2, DataSource.CREATOR);
            } else if (k2 != 7) {
                r1.a.t(parcel, o2);
            } else {
                j4 = r1.a.r(parcel, o2);
            }
        }
        r1.a.j(parcel, u2);
        return new DataPoint(dataSource, j2, j3, valueArr, dataSource2, j4);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i2) {
        return new DataPoint[i2];
    }
}
