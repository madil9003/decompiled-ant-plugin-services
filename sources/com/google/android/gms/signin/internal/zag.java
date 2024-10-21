package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.List;

/* loaded from: classes.dex */
public final class zag extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zag> CREATOR = new f2.d();

    /* renamed from: a */
    private final List f1570a;

    /* renamed from: b */
    private final String f1571b;

    public zag(List list, String str) {
        this.f1570a = list;
        this.f1571b = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a3 = r1.b.a(parcel);
        r1.b.o(parcel, 1, this.f1570a, false);
        r1.b.n(parcel, 2, this.f1571b, false);
        r1.b.b(parcel, a3);
    }
}
