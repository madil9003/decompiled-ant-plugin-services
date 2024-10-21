package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import q1.f;
import x1.j;

/* loaded from: classes.dex */
public class MapValue extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<MapValue> CREATOR = new j();

    /* renamed from: a */
    private final int f1546a;

    /* renamed from: b */
    private final float f1547b;

    public MapValue(int i2, float f3) {
        this.f1546a = i2;
        this.f1547b = f3;
    }

    public final float a() {
        f.j(this.f1546a == 2, "Value is not in float format");
        return this.f1547b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MapValue)) {
            return false;
        }
        MapValue mapValue = (MapValue) obj;
        int i2 = this.f1546a;
        if (i2 == mapValue.f1546a) {
            if (i2 != 2) {
                return this.f1547b == mapValue.f1547b;
            }
            if (a() == mapValue.a()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (int) this.f1547b;
    }

    public final String toString() {
        return this.f1546a != 2 ? "unknown" : Float.toString(a());
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a3 = r1.b.a(parcel);
        r1.b.j(parcel, 1, this.f1546a);
        r1.b.g(parcel, 2, this.f1547b);
        r1.b.b(parcel, a3);
    }
}
