package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.e;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* loaded from: classes.dex */
public final class zav extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zav> CREATOR = new i();

    /* renamed from: a */
    final int f1431a;

    /* renamed from: b */
    final IBinder f1432b;

    /* renamed from: c */
    private final ConnectionResult f1433c;

    /* renamed from: d */
    private final boolean f1434d;

    /* renamed from: e */
    private final boolean f1435e;

    public zav(int i2, IBinder iBinder, ConnectionResult connectionResult, boolean z2, boolean z3) {
        this.f1431a = i2;
        this.f1432b = iBinder;
        this.f1433c = connectionResult;
        this.f1434d = z2;
        this.f1435e = z3;
    }

    public final ConnectionResult a() {
        return this.f1433c;
    }

    public final e b() {
        IBinder iBinder = this.f1432b;
        if (iBinder == null) {
            return null;
        }
        return e.a.c(iBinder);
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zav)) {
            return false;
        }
        zav zavVar = (zav) obj;
        return this.f1433c.equals(zavVar.f1433c) && q1.e.a(b(), zavVar.b());
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a3 = r1.b.a(parcel);
        r1.b.j(parcel, 1, this.f1431a);
        r1.b.i(parcel, 2, this.f1432b, false);
        r1.b.m(parcel, 3, this.f1433c, i2, false);
        r1.b.c(parcel, 4, this.f1434d);
        r1.b.c(parcel, 5, this.f1435e);
        r1.b.b(parcel, a3);
    }
}
