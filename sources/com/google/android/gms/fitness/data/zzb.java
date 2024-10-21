package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import q1.f;

/* loaded from: classes.dex */
public final class zzb extends AbstractSafeParcelable {

    /* renamed from: a */
    private final String f1557a;

    /* renamed from: b */
    public static final zzb f1556b = new zzb("com.google.android.gms");
    public static final Parcelable.Creator<zzb> CREATOR = new x1.a();

    public zzb(String str) {
        this.f1557a = (String) f.g(str);
    }

    public static zzb a(String str) {
        return "com.google.android.gms".equals(str) ? f1556b : new zzb(str);
    }

    public final String b() {
        return this.f1557a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzb) {
            return this.f1557a.equals(((zzb) obj).f1557a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f1557a.hashCode();
    }

    public final String toString() {
        return String.format("Application{%s}", this.f1557a);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a3 = r1.b.a(parcel);
        r1.b.n(parcel, 1, this.f1557a, false);
        r1.b.b(parcel, a3);
    }
}
