package y1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.result.DataSourcesResult;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class a implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int u2 = r1.a.u(parcel);
        ArrayList arrayList = null;
        Status status = null;
        while (parcel.dataPosition() < u2) {
            int o2 = r1.a.o(parcel);
            int k2 = r1.a.k(o2);
            if (k2 == 1) {
                arrayList = r1.a.i(parcel, o2, DataSource.CREATOR);
            } else if (k2 != 2) {
                r1.a.t(parcel, o2);
            } else {
                status = (Status) r1.a.e(parcel, o2, Status.CREATOR);
            }
        }
        r1.a.j(parcel, u2);
        return new DataSourcesResult(arrayList, status);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i2) {
        return new DataSourcesResult[i2];
    }
}
