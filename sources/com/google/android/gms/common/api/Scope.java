package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import q1.f;

/* loaded from: classes.dex */
public final class Scope extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<Scope> CREATOR = new a();

    /* renamed from: a */
    final int f1207a;

    /* renamed from: b */
    private final String f1208b;

    public Scope(int i2, String str) {
        f.f(str, "scopeUri must not be null or empty");
        this.f1207a = i2;
        this.f1208b = str;
    }

    public String a() {
        return this.f1208b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Scope) {
            return this.f1208b.equals(((Scope) obj).f1208b);
        }
        return false;
    }

    public int hashCode() {
        return this.f1208b.hashCode();
    }

    public String toString() {
        return this.f1208b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int a3 = r1.b.a(parcel);
        r1.b.j(parcel, 1, this.f1207a);
        r1.b.n(parcel, 2, a(), false);
        r1.b.b(parcel, a3);
    }

    public Scope(String str) {
        this(1, str);
    }
}
