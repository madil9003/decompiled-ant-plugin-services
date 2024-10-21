package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class TelemetryData extends AbstractSafeParcelable {
    public static final Parcelable.Creator<TelemetryData> CREATOR = new q1.k();

    /* renamed from: a */
    private final int f1357a;

    /* renamed from: b */
    private List f1358b;

    public TelemetryData(int i2, List list) {
        this.f1357a = i2;
        this.f1358b = list;
    }

    public final int a() {
        return this.f1357a;
    }

    public final List b() {
        return this.f1358b;
    }

    public final void c(MethodInvocation methodInvocation) {
        if (this.f1358b == null) {
            this.f1358b = new ArrayList();
        }
        this.f1358b.add(methodInvocation);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a3 = r1.b.a(parcel);
        r1.b.j(parcel, 1, this.f1357a);
        r1.b.q(parcel, 2, this.f1358b, false);
        r1.b.b(parcel, a3);
    }
}
