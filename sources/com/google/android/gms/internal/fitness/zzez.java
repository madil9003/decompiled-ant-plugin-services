package com.google.android.gms.internal.fitness;

import android.os.Parcel;
import android.os.Parcelable;
import c2.k;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.fitness.data.DataSource;
import r1.b;

/* loaded from: classes.dex */
public final class zzez extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzez> CREATOR = new k();

    /* renamed from: a */
    private final DataSource f1566a;

    public zzez(DataSource dataSource) {
        this.f1566a = dataSource;
    }

    public final DataSource a() {
        return this.f1566a;
    }

    public final String toString() {
        return String.format("ApplicationUnregistrationRequest{%s}", this.f1566a);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a3 = b.a(parcel);
        b.m(parcel, 1, this.f1566a, i2, false);
        b.b(parcel, a3);
    }
}
