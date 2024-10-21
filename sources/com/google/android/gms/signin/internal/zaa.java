package com.google.android.gms.signin.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* loaded from: classes.dex */
public final class zaa extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zaa> CREATOR = new b();

    /* renamed from: a */
    final int f1567a;

    /* renamed from: b */
    private int f1568b;

    /* renamed from: c */
    private Intent f1569c;

    public zaa(int i2, int i3, Intent intent) {
        this.f1567a = i2;
        this.f1568b = i3;
        this.f1569c = intent;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a3 = r1.b.a(parcel);
        r1.b.j(parcel, 1, this.f1567a);
        r1.b.j(parcel, 2, this.f1568b);
        r1.b.m(parcel, 3, this.f1569c, i2, false);
        r1.b.b(parcel, a3);
    }
}
