package x1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.fitness.data.Field;

/* loaded from: classes.dex */
public final class f implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int u2 = r1.a.u(parcel);
        String str = null;
        int i2 = 0;
        Boolean bool = null;
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
                bool = r1.a.m(parcel, o2);
            }
        }
        r1.a.j(parcel, u2);
        return new Field(str, i2, bool);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i2) {
        return new Field[i2];
    }
}
