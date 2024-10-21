package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* loaded from: classes.dex */
public final class zzj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzj> CREATOR = new r();

    /* renamed from: a */
    Bundle f1436a;

    /* renamed from: b */
    Feature[] f1437b;

    /* renamed from: c */
    int f1438c;

    /* renamed from: d */
    ConnectionTelemetryConfiguration f1439d;

    public zzj(Bundle bundle, Feature[] featureArr, int i2, ConnectionTelemetryConfiguration connectionTelemetryConfiguration) {
        this.f1436a = bundle;
        this.f1437b = featureArr;
        this.f1438c = i2;
        this.f1439d = connectionTelemetryConfiguration;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a3 = r1.b.a(parcel);
        r1.b.e(parcel, 1, this.f1436a, false);
        r1.b.p(parcel, 2, this.f1437b, i2, false);
        r1.b.j(parcel, 3, this.f1438c);
        r1.b.m(parcel, 4, this.f1439d, i2, false);
        r1.b.b(parcel, a3);
    }
}
