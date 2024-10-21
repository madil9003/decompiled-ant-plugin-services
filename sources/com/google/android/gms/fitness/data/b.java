package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class b implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int u2 = r1.a.u(parcel);
        String str = null;
        ArrayList arrayList = null;
        String str2 = null;
        String str3 = null;
        while (parcel.dataPosition() < u2) {
            int o2 = r1.a.o(parcel);
            int k2 = r1.a.k(o2);
            if (k2 == 1) {
                str = r1.a.f(parcel, o2);
            } else if (k2 == 2) {
                arrayList = r1.a.i(parcel, o2, Field.CREATOR);
            } else if (k2 == 3) {
                str2 = r1.a.f(parcel, o2);
            } else if (k2 != 4) {
                r1.a.t(parcel, o2);
            } else {
                str3 = r1.a.f(parcel, o2);
            }
        }
        r1.a.j(parcel, u2);
        return new DataType(str, arrayList, str2, str3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i2) {
        return new DataType[i2];
    }
}
