package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;

/* loaded from: classes.dex */
public final class b implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int u2 = r1.a.u(parcel);
        int i2 = 0;
        int i3 = 0;
        String str = null;
        PendingIntent pendingIntent = null;
        ConnectionResult connectionResult = null;
        while (parcel.dataPosition() < u2) {
            int o2 = r1.a.o(parcel);
            int k2 = r1.a.k(o2);
            if (k2 == 1) {
                i3 = r1.a.q(parcel, o2);
            } else if (k2 == 2) {
                str = r1.a.f(parcel, o2);
            } else if (k2 == 3) {
                pendingIntent = (PendingIntent) r1.a.e(parcel, o2, PendingIntent.CREATOR);
            } else if (k2 == 4) {
                connectionResult = (ConnectionResult) r1.a.e(parcel, o2, ConnectionResult.CREATOR);
            } else if (k2 != 1000) {
                r1.a.t(parcel, o2);
            } else {
                i2 = r1.a.q(parcel, o2);
            }
        }
        r1.a.j(parcel, u2);
        return new Status(i2, i3, str, pendingIntent, connectionResult);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i2) {
        return new Status[i2];
    }
}
