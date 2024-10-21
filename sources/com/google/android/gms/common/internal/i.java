package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;

/* loaded from: classes.dex */
public final class i implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int u2 = r1.a.u(parcel);
        int i2 = 0;
        boolean z2 = false;
        boolean z3 = false;
        IBinder iBinder = null;
        ConnectionResult connectionResult = null;
        while (parcel.dataPosition() < u2) {
            int o2 = r1.a.o(parcel);
            int k2 = r1.a.k(o2);
            if (k2 == 1) {
                i2 = r1.a.q(parcel, o2);
            } else if (k2 == 2) {
                iBinder = r1.a.p(parcel, o2);
            } else if (k2 == 3) {
                connectionResult = (ConnectionResult) r1.a.e(parcel, o2, ConnectionResult.CREATOR);
            } else if (k2 == 4) {
                z2 = r1.a.l(parcel, o2);
            } else if (k2 != 5) {
                r1.a.t(parcel, o2);
            } else {
                z3 = r1.a.l(parcel, o2);
            }
        }
        r1.a.j(parcel, u2);
        return new zav(i2, iBinder, connectionResult, z2, z3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i2) {
        return new zav[i2];
    }
}
