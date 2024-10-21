package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Collections;
import java.util.List;
import q1.e;
import r1.b;
import y1.a;

/* loaded from: classes.dex */
public class DataSourcesResult extends AbstractSafeParcelable {
    public static final Parcelable.Creator<DataSourcesResult> CREATOR = new a();

    /* renamed from: a */
    private final List f1558a;

    /* renamed from: b */
    private final Status f1559b;

    public DataSourcesResult(List list, Status status) {
        this.f1558a = Collections.unmodifiableList(list);
        this.f1559b = status;
    }

    public List a() {
        return this.f1558a;
    }

    public Status b() {
        return this.f1559b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DataSourcesResult)) {
            return false;
        }
        DataSourcesResult dataSourcesResult = (DataSourcesResult) obj;
        return this.f1559b.equals(dataSourcesResult.f1559b) && e.a(this.f1558a, dataSourcesResult.f1558a);
    }

    public int hashCode() {
        return e.b(this.f1559b, this.f1558a);
    }

    public String toString() {
        return e.c(this).a("status", this.f1559b).a("dataSources", this.f1558a).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int a3 = b.a(parcel);
        b.q(parcel, 1, a(), false);
        b.m(parcel, 2, b(), i2, false);
        b.b(parcel, a3);
    }
}
