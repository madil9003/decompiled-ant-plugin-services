package c2;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.fitness.zzex;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class j implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int u2 = r1.a.u(parcel);
        ArrayList arrayList = null;
        while (parcel.dataPosition() < u2) {
            int o2 = r1.a.o(parcel);
            if (r1.a.k(o2) != 1) {
                r1.a.t(parcel, o2);
            } else {
                arrayList = r1.a.i(parcel, o2, DataType.CREATOR);
            }
        }
        r1.a.j(parcel, u2);
        return new zzex(arrayList);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i2) {
        return new zzex[i2];
    }
}
