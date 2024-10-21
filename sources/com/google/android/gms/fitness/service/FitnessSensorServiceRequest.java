package com.google.android.gms.fitness.service;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.fitness.data.DataSource;
import q1.e;
import x1.h;
import x1.i;

/* loaded from: classes.dex */
public class FitnessSensorServiceRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<FitnessSensorServiceRequest> CREATOR = new a();

    /* renamed from: a */
    private final DataSource f1560a;

    /* renamed from: b */
    private final i f1561b;

    /* renamed from: c */
    private final long f1562c;

    /* renamed from: d */
    private final long f1563d;

    public FitnessSensorServiceRequest(DataSource dataSource, IBinder iBinder, long j2, long j3) {
        this.f1560a = dataSource;
        this.f1561b = h.c(iBinder);
        this.f1562c = j2;
        this.f1563d = j3;
    }

    public DataSource a() {
        return this.f1560a;
    }

    public z1.b b() {
        return new b(this.f1561b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FitnessSensorServiceRequest)) {
            return false;
        }
        FitnessSensorServiceRequest fitnessSensorServiceRequest = (FitnessSensorServiceRequest) obj;
        return e.a(this.f1560a, fitnessSensorServiceRequest.f1560a) && this.f1562c == fitnessSensorServiceRequest.f1562c && this.f1563d == fitnessSensorServiceRequest.f1563d;
    }

    public int hashCode() {
        return e.b(this.f1560a, Long.valueOf(this.f1562c), Long.valueOf(this.f1563d));
    }

    public String toString() {
        return String.format("FitnessSensorServiceRequest{%s}", this.f1560a);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int a3 = r1.b.a(parcel);
        r1.b.m(parcel, 1, a(), i2, false);
        r1.b.i(parcel, 2, this.f1561b.asBinder(), false);
        r1.b.l(parcel, 3, this.f1562c);
        r1.b.l(parcel, 4, this.f1563d);
        r1.b.b(parcel, a3);
    }
}
