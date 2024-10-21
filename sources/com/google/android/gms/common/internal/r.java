package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;

/* loaded from: classes.dex */
public final class r implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int u2 = r1.a.u(parcel);
        Bundle bundle = null;
        ConnectionTelemetryConfiguration connectionTelemetryConfiguration = null;
        int i2 = 0;
        Feature[] featureArr = null;
        while (parcel.dataPosition() < u2) {
            int o2 = r1.a.o(parcel);
            int k2 = r1.a.k(o2);
            if (k2 == 1) {
                bundle = r1.a.a(parcel, o2);
            } else if (k2 == 2) {
                featureArr = (Feature[]) r1.a.h(parcel, o2, Feature.CREATOR);
            } else if (k2 == 3) {
                i2 = r1.a.q(parcel, o2);
            } else if (k2 != 4) {
                r1.a.t(parcel, o2);
            } else {
                connectionTelemetryConfiguration = (ConnectionTelemetryConfiguration) r1.a.e(parcel, o2, ConnectionTelemetryConfiguration.CREATOR);
            }
        }
        r1.a.j(parcel, u2);
        return new zzj(bundle, featureArr, i2, connectionTelemetryConfiguration);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i2) {
        return new zzj[i2];
    }
}
