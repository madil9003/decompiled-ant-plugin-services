package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* loaded from: classes.dex */
public class RootTelemetryConfiguration extends AbstractSafeParcelable {
    public static final Parcelable.Creator<RootTelemetryConfiguration> CREATOR = new q1.w();

    /* renamed from: a */
    private final int f1352a;

    /* renamed from: b */
    private final boolean f1353b;

    /* renamed from: c */
    private final boolean f1354c;

    /* renamed from: d */
    private final int f1355d;

    /* renamed from: e */
    private final int f1356e;

    public RootTelemetryConfiguration(int i2, boolean z2, boolean z3, int i3, int i4) {
        this.f1352a = i2;
        this.f1353b = z2;
        this.f1354c = z3;
        this.f1355d = i3;
        this.f1356e = i4;
    }

    public int a() {
        return this.f1355d;
    }

    public int b() {
        return this.f1356e;
    }

    public boolean c() {
        return this.f1353b;
    }

    public boolean d() {
        return this.f1354c;
    }

    public int e() {
        return this.f1352a;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a3 = r1.b.a(parcel);
        r1.b.j(parcel, 1, e());
        r1.b.c(parcel, 2, c());
        r1.b.c(parcel, 3, d());
        r1.b.j(parcel, 4, a());
        r1.b.j(parcel, 5, b());
        r1.b.b(parcel, a3);
    }
}
