package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zat;

/* loaded from: classes.dex */
public final class zai extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zai> CREATOR = new d();

    /* renamed from: a */
    final int f1572a;

    /* renamed from: b */
    final zat f1573b;

    public zai(int i2, zat zatVar) {
        this.f1572a = i2;
        this.f1573b = zatVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a3 = r1.b.a(parcel);
        r1.b.j(parcel, 1, this.f1572a);
        r1.b.m(parcel, 2, this.f1573b, i2, false);
        r1.b.b(parcel, a3);
    }
}
