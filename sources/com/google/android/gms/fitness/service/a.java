package com.google.android.gms.fitness.service;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.fitness.data.DataSource;

/* loaded from: classes.dex */
public final class a implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int u2 = r1.a.u(parcel);
        DataSource dataSource = null;
        IBinder iBinder = null;
        long j2 = 0;
        long j3 = 0;
        while (parcel.dataPosition() < u2) {
            int o2 = r1.a.o(parcel);
            int k2 = r1.a.k(o2);
            if (k2 == 1) {
                dataSource = (DataSource) r1.a.e(parcel, o2, DataSource.CREATOR);
            } else if (k2 == 2) {
                iBinder = r1.a.p(parcel, o2);
            } else if (k2 == 3) {
                j2 = r1.a.r(parcel, o2);
            } else if (k2 != 4) {
                r1.a.t(parcel, o2);
            } else {
                j3 = r1.a.r(parcel, o2);
            }
        }
        r1.a.j(parcel, u2);
        return new FitnessSensorServiceRequest(dataSource, iBinder, j2, j3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i2) {
        return new FitnessSensorServiceRequest[i2];
    }
}
