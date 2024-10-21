package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* loaded from: classes.dex */
public class ConnectionTelemetryConfiguration extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ConnectionTelemetryConfiguration> CREATOR = new q1.x();

    /* renamed from: a */
    private final RootTelemetryConfiguration f1323a;

    /* renamed from: b */
    private final boolean f1324b;

    /* renamed from: c */
    private final boolean f1325c;

    /* renamed from: d */
    private final int[] f1326d;

    /* renamed from: e */
    private final int f1327e;

    /* renamed from: f */
    private final int[] f1328f;

    public ConnectionTelemetryConfiguration(RootTelemetryConfiguration rootTelemetryConfiguration, boolean z2, boolean z3, int[] iArr, int i2, int[] iArr2) {
        this.f1323a = rootTelemetryConfiguration;
        this.f1324b = z2;
        this.f1325c = z3;
        this.f1326d = iArr;
        this.f1327e = i2;
        this.f1328f = iArr2;
    }

    public int a() {
        return this.f1327e;
    }

    public int[] b() {
        return this.f1326d;
    }

    public int[] c() {
        return this.f1328f;
    }

    public boolean d() {
        return this.f1324b;
    }

    public boolean e() {
        return this.f1325c;
    }

    public final RootTelemetryConfiguration f() {
        return this.f1323a;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a3 = r1.b.a(parcel);
        r1.b.m(parcel, 1, this.f1323a, i2, false);
        r1.b.c(parcel, 2, d());
        r1.b.c(parcel, 3, e());
        r1.b.k(parcel, 4, b(), false);
        r1.b.j(parcel, 5, a());
        r1.b.k(parcel, 6, c(), false);
        r1.b.b(parcel, a3);
    }
}
