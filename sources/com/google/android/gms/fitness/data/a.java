package com.google.android.gms.fitness.data;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class a implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int u2 = r1.a.u(parcel);
        int i2 = 0;
        boolean z2 = false;
        float f3 = 0.0f;
        String str = null;
        Bundle bundle = null;
        int[] iArr = null;
        float[] fArr = null;
        byte[] bArr = null;
        while (parcel.dataPosition() < u2) {
            int o2 = r1.a.o(parcel);
            switch (r1.a.k(o2)) {
                case 1:
                    i2 = r1.a.q(parcel, o2);
                    break;
                case 2:
                    z2 = r1.a.l(parcel, o2);
                    break;
                case 3:
                    f3 = r1.a.n(parcel, o2);
                    break;
                case 4:
                    str = r1.a.f(parcel, o2);
                    break;
                case 5:
                    bundle = r1.a.a(parcel, o2);
                    break;
                case 6:
                    iArr = r1.a.d(parcel, o2);
                    break;
                case 7:
                    fArr = r1.a.c(parcel, o2);
                    break;
                case 8:
                    bArr = r1.a.b(parcel, o2);
                    break;
                default:
                    r1.a.t(parcel, o2);
                    break;
            }
        }
        r1.a.j(parcel, u2);
        return new Value(i2, z2, f3, str, bundle, iArr, fArr, bArr);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i2) {
        return new Value[i2];
    }
}
