package com.google.android.gms.fitness.data;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Locale;
import q1.f;
import x1.c;

/* loaded from: classes.dex */
public class DataSource extends AbstractSafeParcelable {
    public static final Parcelable.Creator<DataSource> CREATOR;

    /* renamed from: g */
    private static final String f1446g;

    /* renamed from: h */
    private static final String f1447h;

    /* renamed from: a */
    private final DataType f1448a;

    /* renamed from: b */
    private final int f1449b;

    /* renamed from: c */
    private final Device f1450c;

    /* renamed from: d */
    private final zzb f1451d;

    /* renamed from: e */
    private final String f1452e;

    /* renamed from: f */
    private final String f1453f;

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a */
        private DataType f1454a;

        /* renamed from: c */
        private Device f1456c;

        /* renamed from: d */
        private zzb f1457d;

        /* renamed from: b */
        private int f1455b = -1;

        /* renamed from: e */
        private String f1458e = "";

        public DataSource a() {
            f.j(this.f1454a != null, "Must set data type");
            f.j(this.f1455b >= 0, "Must set data source type");
            return new DataSource(this.f1454a, this.f1455b, this.f1456c, this.f1457d, this.f1458e);
        }

        public a b(Context context) {
            c(context.getPackageName());
            return this;
        }

        public a c(String str) {
            this.f1457d = zzb.a(str);
            return this;
        }

        public a d(DataType dataType) {
            this.f1454a = dataType;
            return this;
        }

        public a e(Device device) {
            this.f1456c = device;
            return this;
        }

        public a f(String str) {
            f.b(str != null, "Must specify a valid stream name");
            this.f1458e = str;
            return this;
        }

        public a g(int i2) {
            this.f1455b = i2;
            return this;
        }
    }

    static {
        Locale locale = Locale.ROOT;
        f1446g = "RAW".toLowerCase(locale);
        f1447h = "DERIVED".toLowerCase(locale);
        CREATOR = new c();
    }

    public DataSource(DataType dataType, int i2, Device device, zzb zzbVar, String str) {
        this.f1448a = dataType;
        this.f1449b = i2;
        this.f1450c = device;
        this.f1451d = zzbVar;
        this.f1452e = str;
        StringBuilder sb = new StringBuilder();
        sb.append(f(i2));
        sb.append(":");
        sb.append(dataType.b());
        if (zzbVar != null) {
            sb.append(":");
            sb.append(zzbVar.b());
        }
        if (device != null) {
            sb.append(":");
            sb.append(device.f());
        }
        if (str != null) {
            sb.append(":");
            sb.append(str);
        }
        this.f1453f = sb.toString();
    }

    private static String f(int i2) {
        return i2 != 0 ? i2 != 1 ? f1447h : f1447h : f1446g;
    }

    public DataType a() {
        return this.f1448a;
    }

    public Device b() {
        return this.f1450c;
    }

    public String c() {
        return this.f1452e;
    }

    public int d() {
        return this.f1449b;
    }

    public final String e() {
        String str;
        int i2 = this.f1449b;
        String str2 = i2 != 0 ? i2 != 1 ? "?" : "d" : "r";
        String d3 = this.f1448a.d();
        zzb zzbVar = this.f1451d;
        String concat = zzbVar == null ? "" : zzbVar.equals(zzb.f1556b) ? ":gms" : ":".concat(String.valueOf(this.f1451d.b()));
        Device device = this.f1450c;
        if (device != null) {
            str = ":" + device.c() + ":" + device.e();
        } else {
            str = "";
        }
        String str3 = this.f1452e;
        return str2 + ":" + d3 + concat + str + (str3 != null ? ":".concat(str3) : "");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof DataSource) {
            return this.f1453f.equals(((DataSource) obj).f1453f);
        }
        return false;
    }

    public int hashCode() {
        return this.f1453f.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DataSource{");
        sb.append(f(this.f1449b));
        if (this.f1451d != null) {
            sb.append(":");
            sb.append(this.f1451d);
        }
        if (this.f1450c != null) {
            sb.append(":");
            sb.append(this.f1450c);
        }
        if (this.f1452e != null) {
            sb.append(":");
            sb.append(this.f1452e);
        }
        sb.append(":");
        sb.append(this.f1448a);
        sb.append("}");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int a3 = r1.b.a(parcel);
        r1.b.m(parcel, 1, a(), i2, false);
        r1.b.j(parcel, 3, d());
        r1.b.m(parcel, 4, b(), i2, false);
        r1.b.m(parcel, 5, this.f1451d, i2, false);
        r1.b.n(parcel, 6, c(), false);
        r1.b.b(parcel, a3);
    }
}
