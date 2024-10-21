package com.google.android.gms.fitness.data;

import android.content.Context;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import q1.f;
import x1.d;
import x1.e;

/* loaded from: classes.dex */
public final class Device extends AbstractSafeParcelable {
    public static final Parcelable.Creator<Device> CREATOR = new d();

    /* renamed from: a */
    private final String f1497a;

    /* renamed from: b */
    private final String f1498b;

    /* renamed from: c */
    private final String f1499c;

    /* renamed from: d */
    private final int f1500d;

    /* renamed from: e */
    private final int f1501e;

    public Device(String str, String str2, String str3, int i2, int i3) {
        this.f1497a = (String) f.g(str);
        this.f1498b = (String) f.g(str2);
        if (str3 == null) {
            throw new IllegalStateException("Device UID is null.");
        }
        this.f1499c = str3;
        this.f1500d = i2;
        this.f1501e = i3;
    }

    public static Device a(Context context) {
        int a3 = e.a(context);
        return new Device(Build.MANUFACTURER, Build.MODEL, e.b(context), a3, 2);
    }

    public String b() {
        return this.f1497a;
    }

    public String c() {
        return this.f1498b;
    }

    public int d() {
        return this.f1500d;
    }

    public String e() {
        return this.f1499c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Device)) {
            return false;
        }
        Device device = (Device) obj;
        return q1.e.a(this.f1497a, device.f1497a) && q1.e.a(this.f1498b, device.f1498b) && q1.e.a(this.f1499c, device.f1499c) && this.f1500d == device.f1500d && this.f1501e == device.f1501e;
    }

    public final String f() {
        return String.format("%s:%s:%s", this.f1497a, this.f1498b, this.f1499c);
    }

    public int hashCode() {
        return q1.e.b(this.f1497a, this.f1498b, this.f1499c, Integer.valueOf(this.f1500d));
    }

    public String toString() {
        return String.format("Device{%s:%s:%s}", f(), Integer.valueOf(this.f1500d), Integer.valueOf(this.f1501e));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int a3 = r1.b.a(parcel);
        r1.b.n(parcel, 1, b(), false);
        r1.b.n(parcel, 2, c(), false);
        r1.b.n(parcel, 4, e(), false);
        r1.b.j(parcel, 5, d());
        r1.b.j(parcel, 6, this.f1501e);
        r1.b.b(parcel, a3);
    }
}
