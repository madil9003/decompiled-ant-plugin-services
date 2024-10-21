package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* loaded from: classes.dex */
public class MethodInvocation extends AbstractSafeParcelable {
    public static final Parcelable.Creator<MethodInvocation> CREATOR = new q1.s();

    /* renamed from: a */
    private final int f1343a;

    /* renamed from: b */
    private final int f1344b;

    /* renamed from: c */
    private final int f1345c;

    /* renamed from: d */
    private final long f1346d;

    /* renamed from: e */
    private final long f1347e;

    /* renamed from: f */
    private final String f1348f;

    /* renamed from: g */
    private final String f1349g;

    /* renamed from: h */
    private final int f1350h;

    /* renamed from: i */
    private final int f1351i;

    public MethodInvocation(int i2, int i3, int i4, long j2, long j3, String str, String str2, int i5, int i6) {
        this.f1343a = i2;
        this.f1344b = i3;
        this.f1345c = i4;
        this.f1346d = j2;
        this.f1347e = j3;
        this.f1348f = str;
        this.f1349g = str2;
        this.f1350h = i5;
        this.f1351i = i6;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a3 = r1.b.a(parcel);
        r1.b.j(parcel, 1, this.f1343a);
        r1.b.j(parcel, 2, this.f1344b);
        r1.b.j(parcel, 3, this.f1345c);
        r1.b.l(parcel, 4, this.f1346d);
        r1.b.l(parcel, 5, this.f1347e);
        r1.b.n(parcel, 6, this.f1348f, false);
        r1.b.n(parcel, 7, this.f1349g, false);
        r1.b.j(parcel, 8, this.f1350h);
        r1.b.j(parcel, 9, this.f1351i);
        r1.b.b(parcel, a3);
    }
}
