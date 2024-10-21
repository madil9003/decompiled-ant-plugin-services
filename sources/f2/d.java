package f2;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.signin.internal.zag;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class d implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int u2 = r1.a.u(parcel);
        ArrayList arrayList = null;
        String str = null;
        while (parcel.dataPosition() < u2) {
            int o2 = r1.a.o(parcel);
            int k2 = r1.a.k(o2);
            if (k2 == 1) {
                arrayList = r1.a.g(parcel, o2);
            } else if (k2 != 2) {
                r1.a.t(parcel, o2);
            } else {
                str = r1.a.f(parcel, o2);
            }
        }
        r1.a.j(parcel, u2);
        return new zag(arrayList, str);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i2) {
        return new zag[i2];
    }
}
