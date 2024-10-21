package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zat;

/* loaded from: classes.dex */
public final class d implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int u2 = r1.a.u(parcel);
        int i2 = 0;
        zat zatVar = null;
        while (parcel.dataPosition() < u2) {
            int o2 = r1.a.o(parcel);
            int k2 = r1.a.k(o2);
            if (k2 == 1) {
                i2 = r1.a.q(parcel, o2);
            } else if (k2 != 2) {
                r1.a.t(parcel, o2);
            } else {
                zatVar = (zat) r1.a.e(parcel, o2, zat.CREATOR);
            }
        }
        r1.a.j(parcel, u2);
        return new zai(i2, zatVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i2) {
        return new zai[i2];
    }
}
