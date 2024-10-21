package com.google.android.gms.internal.fitness;

import android.os.Parcel;
import android.os.Parcelable;
import c2.j;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Collections;
import java.util.List;
import q1.e;
import r1.b;

/* loaded from: classes.dex */
public final class zzex extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzex> CREATOR = new j();

    /* renamed from: a */
    private final List f1565a;

    public zzex(List list) {
        this.f1565a = list;
    }

    public final List a() {
        return Collections.unmodifiableList(this.f1565a);
    }

    public final String toString() {
        return e.c(this).a("dataTypes", this.f1565a).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a3 = b.a(parcel);
        b.q(parcel, 1, Collections.unmodifiableList(this.f1565a), false);
        b.b(parcel, a3);
    }
}
