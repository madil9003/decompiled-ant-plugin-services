package com.google.android.gms.signin.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class b implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int u2 = r1.a.u(parcel);
        int i2 = 0;
        Intent intent = null;
        int i3 = 0;
        while (parcel.dataPosition() < u2) {
            int o2 = r1.a.o(parcel);
            int k2 = r1.a.k(o2);
            if (k2 == 1) {
                i2 = r1.a.q(parcel, o2);
            } else if (k2 == 2) {
                i3 = r1.a.q(parcel, o2);
            } else if (k2 != 3) {
                r1.a.t(parcel, o2);
            } else {
                intent = (Intent) r1.a.e(parcel, o2, Intent.CREATOR);
            }
        }
        r1.a.j(parcel, u2);
        return new zaa(i2, i3, intent);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i2) {
        return new zaa[i2];
    }
}
