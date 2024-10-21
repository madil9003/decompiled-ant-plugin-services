package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zav;

/* loaded from: classes.dex */
public final class zak extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zak> CREATOR = new e();

    /* renamed from: a */
    final int f1574a;

    /* renamed from: b */
    private final ConnectionResult f1575b;

    /* renamed from: c */
    private final zav f1576c;

    public zak(int i2, ConnectionResult connectionResult, zav zavVar) {
        this.f1574a = i2;
        this.f1575b = connectionResult;
        this.f1576c = zavVar;
    }

    public final ConnectionResult a() {
        return this.f1575b;
    }

    public final zav b() {
        return this.f1576c;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a3 = r1.b.a(parcel);
        r1.b.j(parcel, 1, this.f1574a);
        r1.b.m(parcel, 2, this.f1575b, i2, false);
        r1.b.m(parcel, 3, this.f1576c, i2, false);
        r1.b.b(parcel, a3);
    }
}
