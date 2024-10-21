package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import q1.e;

/* loaded from: classes.dex */
public class Feature extends AbstractSafeParcelable {
    public static final Parcelable.Creator<Feature> CREATOR = new n1.d();

    /* renamed from: a */
    private final String f1198a;

    /* renamed from: b */
    private final int f1199b;

    /* renamed from: c */
    private final long f1200c;

    public Feature(String str, int i2, long j2) {
        this.f1198a = str;
        this.f1199b = i2;
        this.f1200c = j2;
    }

    public String a() {
        return this.f1198a;
    }

    public long b() {
        long j2 = this.f1200c;
        return j2 == -1 ? this.f1199b : j2;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Feature) {
            Feature feature = (Feature) obj;
            if (((a() != null && a().equals(feature.a())) || (a() == null && feature.a() == null)) && b() == feature.b()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return q1.e.b(a(), Long.valueOf(b()));
    }

    public final String toString() {
        e.a c3 = q1.e.c(this);
        c3.a("name", a());
        c3.a("version", Long.valueOf(b()));
        return c3.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a3 = r1.b.a(parcel);
        r1.b.n(parcel, 1, a(), false);
        r1.b.j(parcel, 2, this.f1199b);
        r1.b.l(parcel, 3, b());
        r1.b.b(parcel, a3);
    }

    public Feature(String str, long j2) {
        this.f1198a = str;
        this.f1200c = j2;
        this.f1199b = -1;
    }
}
