package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import q1.e;
import q1.f;

/* loaded from: classes.dex */
public final class DataPoint extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<DataPoint> CREATOR = new x1.b();

    /* renamed from: a */
    private final DataSource f1440a;

    /* renamed from: b */
    private long f1441b;

    /* renamed from: c */
    private long f1442c;

    /* renamed from: d */
    private final Value[] f1443d;

    /* renamed from: e */
    private DataSource f1444e;

    /* renamed from: f */
    private final long f1445f;

    private DataPoint(DataSource dataSource) {
        this.f1440a = (DataSource) f.h(dataSource, "Data source cannot be null");
        List a3 = dataSource.a().a();
        this.f1443d = new Value[a3.size()];
        Iterator it = a3.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            this.f1443d[i2] = new Value(((Field) it.next()).a(), false, 0.0f, null, null, null, null, null);
            i2++;
        }
        this.f1445f = 0L;
    }

    public static DataPoint a(DataSource dataSource) {
        return new DataPoint(dataSource);
    }

    public DataSource b() {
        return this.f1440a;
    }

    public DataType c() {
        return this.f1440a.a();
    }

    public DataSource d() {
        DataSource dataSource = this.f1444e;
        return dataSource != null ? dataSource : this.f1440a;
    }

    public Value e(Field field) {
        return this.f1443d[c().c(field)];
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DataPoint)) {
            return false;
        }
        DataPoint dataPoint = (DataPoint) obj;
        return e.a(this.f1440a, dataPoint.f1440a) && this.f1441b == dataPoint.f1441b && this.f1442c == dataPoint.f1442c && Arrays.equals(this.f1443d, dataPoint.f1443d) && e.a(d(), dataPoint.d());
    }

    public DataPoint f(long j2, long j3, TimeUnit timeUnit) {
        this.f1442c = timeUnit.toNanos(j2);
        this.f1441b = timeUnit.toNanos(j3);
        return this;
    }

    public DataPoint g(long j2, TimeUnit timeUnit) {
        this.f1441b = timeUnit.toNanos(j2);
        return this;
    }

    public final void h() {
        f.c(c().b().equals(b().a().b()), "Conflicting data types found %s vs %s", c(), c());
        f.c(this.f1441b > 0, "Data point does not have the timestamp set: %s", this);
        f.c(this.f1442c <= this.f1441b, "Data point with start time greater than end time found: %s", this);
    }

    public int hashCode() {
        return e.b(this.f1440a, Long.valueOf(this.f1441b), Long.valueOf(this.f1442c));
    }

    public String toString() {
        Object[] objArr = new Object[6];
        objArr[0] = Arrays.toString(this.f1443d);
        objArr[1] = Long.valueOf(this.f1442c);
        objArr[2] = Long.valueOf(this.f1441b);
        objArr[3] = Long.valueOf(this.f1445f);
        objArr[4] = this.f1440a.e();
        DataSource dataSource = this.f1444e;
        objArr[5] = dataSource != null ? dataSource.e() : "N/A";
        return String.format("DataPoint{%s@[%s, %s,raw=%s](%s %s)}", objArr);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int a3 = r1.b.a(parcel);
        r1.b.m(parcel, 1, b(), i2, false);
        r1.b.l(parcel, 3, this.f1441b);
        r1.b.l(parcel, 4, this.f1442c);
        r1.b.p(parcel, 5, this.f1443d, i2, false);
        r1.b.m(parcel, 6, this.f1444e, i2, false);
        r1.b.l(parcel, 7, this.f1445f);
        r1.b.b(parcel, a3);
    }

    public DataPoint(DataSource dataSource, long j2, long j3, Value[] valueArr, DataSource dataSource2, long j4) {
        this.f1440a = dataSource;
        this.f1444e = dataSource2;
        this.f1441b = j2;
        this.f1442c = j3;
        this.f1443d = valueArr;
        this.f1445f = j4;
    }
}
