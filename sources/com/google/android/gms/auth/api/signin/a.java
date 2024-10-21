package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class a implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int u2 = r1.a.u(parcel);
        int i2 = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        Uri uri = null;
        String str5 = null;
        String str6 = null;
        ArrayList arrayList = null;
        String str7 = null;
        String str8 = null;
        long j2 = 0;
        while (parcel.dataPosition() < u2) {
            int o2 = r1.a.o(parcel);
            switch (r1.a.k(o2)) {
                case 1:
                    i2 = r1.a.q(parcel, o2);
                    break;
                case 2:
                    str = r1.a.f(parcel, o2);
                    break;
                case 3:
                    str2 = r1.a.f(parcel, o2);
                    break;
                case 4:
                    str3 = r1.a.f(parcel, o2);
                    break;
                case 5:
                    str4 = r1.a.f(parcel, o2);
                    break;
                case 6:
                    uri = (Uri) r1.a.e(parcel, o2, Uri.CREATOR);
                    break;
                case 7:
                    str5 = r1.a.f(parcel, o2);
                    break;
                case 8:
                    j2 = r1.a.r(parcel, o2);
                    break;
                case 9:
                    str6 = r1.a.f(parcel, o2);
                    break;
                case 10:
                    arrayList = r1.a.i(parcel, o2, Scope.CREATOR);
                    break;
                case 11:
                    str7 = r1.a.f(parcel, o2);
                    break;
                case 12:
                    str8 = r1.a.f(parcel, o2);
                    break;
                default:
                    r1.a.t(parcel, o2);
                    break;
            }
        }
        r1.a.j(parcel, u2);
        return new GoogleSignInAccount(i2, str, str2, str3, str4, uri, str5, j2, str6, arrayList, str7, str8);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i2) {
        return new GoogleSignInAccount[i2];
    }
}
