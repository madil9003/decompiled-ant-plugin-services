package x1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.fitness.data.zzb;

/* loaded from: classes.dex */
public final class a implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int u2 = r1.a.u(parcel);
        String str = null;
        while (parcel.dataPosition() < u2) {
            int o2 = r1.a.o(parcel);
            if (r1.a.k(o2) != 1) {
                r1.a.t(parcel, o2);
            } else {
                str = r1.a.f(parcel, o2);
            }
        }
        r1.a.j(parcel, u2);
        return new zzb(str);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i2) {
        return new zzb[i2];
    }
}
