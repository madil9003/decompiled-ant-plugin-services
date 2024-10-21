package x1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.fitness.data.MapValue;

/* loaded from: classes.dex */
public final class j implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int u2 = r1.a.u(parcel);
        int i2 = 0;
        float f3 = 0.0f;
        while (parcel.dataPosition() < u2) {
            int o2 = r1.a.o(parcel);
            int k2 = r1.a.k(o2);
            if (k2 == 1) {
                i2 = r1.a.q(parcel, o2);
            } else if (k2 != 2) {
                r1.a.t(parcel, o2);
            } else {
                f3 = r1.a.n(parcel, o2);
            }
        }
        r1.a.j(parcel, u2);
        return new MapValue(i2, f3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i2) {
        return new MapValue[i2];
    }
}
