package com.google.android.gms.fitness.data;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import q1.e;
import q1.f;

/* loaded from: classes.dex */
public final class Value extends AbstractSafeParcelable {
    public static final Parcelable.Creator<Value> CREATOR = new a();

    /* renamed from: a */
    private final int f1548a;

    /* renamed from: b */
    private boolean f1549b;

    /* renamed from: c */
    private float f1550c;

    /* renamed from: d */
    private String f1551d;

    /* renamed from: e */
    private Map f1552e;

    /* renamed from: f */
    private int[] f1553f;

    /* renamed from: g */
    private float[] f1554g;

    /* renamed from: h */
    private byte[] f1555h;

    public Value(int i2, boolean z2, float f3, String str, Bundle bundle, int[] iArr, float[] fArr, byte[] bArr) {
        a.a aVar;
        this.f1548a = i2;
        this.f1549b = z2;
        this.f1550c = f3;
        this.f1551d = str;
        if (bundle == null) {
            aVar = null;
        } else {
            bundle.setClassLoader((ClassLoader) f.g(MapValue.class.getClassLoader()));
            aVar = new a.a(bundle.size());
            for (String str2 : bundle.keySet()) {
                aVar.put(str2, (MapValue) f.g((MapValue) bundle.getParcelable(str2)));
            }
        }
        this.f1552e = aVar;
        this.f1553f = iArr;
        this.f1554g = fArr;
        this.f1555h = bArr;
    }

    public int a() {
        f.j(this.f1548a == 1, "Value is not in int format");
        return Float.floatToRawIntBits(this.f1550c);
    }

    public int b() {
        return this.f1548a;
    }

    public boolean c() {
        return this.f1549b;
    }

    public void d(float f3) {
        f.j(this.f1548a == 2, "Attempting to set an float value to a field that is not in FLOAT format.  Please check the data type definition and use the right format.");
        this.f1549b = true;
        this.f1550c = f3;
    }

    public void e(int i2) {
        f.j(this.f1548a == 1, "Attempting to set an int value to a field that is not in INT32 format.  Please check the data type definition and use the right format.");
        this.f1549b = true;
        this.f1550c = Float.intBitsToFloat(i2);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Value)) {
            return false;
        }
        Value value = (Value) obj;
        int i2 = this.f1548a;
        if (i2 == value.f1548a && this.f1549b == value.f1549b) {
            if (i2 != 1) {
                return i2 != 3 ? i2 != 4 ? i2 != 5 ? i2 != 6 ? i2 != 7 ? this.f1550c == value.f1550c : Arrays.equals(this.f1555h, value.f1555h) : Arrays.equals(this.f1554g, value.f1554g) : Arrays.equals(this.f1553f, value.f1553f) : e.a(this.f1552e, value.f1552e) : e.a(this.f1551d, value.f1551d);
            }
            if (a() == value.a()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return e.b(Float.valueOf(this.f1550c), this.f1551d, this.f1552e, this.f1553f, this.f1554g, this.f1555h);
    }

    public String toString() {
        String a3;
        if (!this.f1549b) {
            return "unset";
        }
        switch (this.f1548a) {
            case 1:
                return Integer.toString(a());
            case 2:
                return Float.toString(this.f1550c);
            case 3:
                String str = this.f1551d;
                return str == null ? "" : str;
            case 4:
                Map map = this.f1552e;
                return map == null ? "" : new TreeMap(map).toString();
            case 5:
                return Arrays.toString(this.f1553f);
            case 6:
                return Arrays.toString(this.f1554g);
            case 7:
                byte[] bArr = this.f1555h;
                return (bArr == null || (a3 = u1.e.a(bArr, 0, bArr.length, false)) == null) ? "" : a3;
            default:
                return "unknown";
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        Bundle bundle;
        int a3 = r1.b.a(parcel);
        r1.b.j(parcel, 1, b());
        r1.b.c(parcel, 2, c());
        r1.b.g(parcel, 3, this.f1550c);
        r1.b.n(parcel, 4, this.f1551d, false);
        Map map = this.f1552e;
        if (map == null) {
            bundle = null;
        } else {
            Bundle bundle2 = new Bundle(map.size());
            for (Map.Entry entry : this.f1552e.entrySet()) {
                bundle2.putParcelable((String) entry.getKey(), (Parcelable) entry.getValue());
            }
            bundle = bundle2;
        }
        r1.b.e(parcel, 5, bundle, false);
        r1.b.k(parcel, 6, this.f1553f, false);
        r1.b.h(parcel, 7, this.f1554g, false);
        r1.b.f(parcel, 8, this.f1555h, false);
        r1.b.b(parcel, a3);
    }
}
