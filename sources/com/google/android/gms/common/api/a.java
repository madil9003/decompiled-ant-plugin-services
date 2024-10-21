package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class a implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int u2 = r1.a.u(parcel);
        int i2 = 0;
        String str = null;
        while (parcel.dataPosition() < u2) {
            int o2 = r1.a.o(parcel);
            int k2 = r1.a.k(o2);
            if (k2 == 1) {
                i2 = r1.a.q(parcel, o2);
            } else if (k2 != 2) {
                r1.a.t(parcel, o2);
            } else {
                str = r1.a.f(parcel, o2);
            }
        }
        r1.a.j(parcel, u2);
        return new Scope(i2, str);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i2) {
        return new Scope[i2];
    }
}
