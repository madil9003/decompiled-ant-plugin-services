package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

/* loaded from: classes.dex */
public final class h implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int u2 = r1.a.u(parcel);
        int i2 = 0;
        Account account = null;
        GoogleSignInAccount googleSignInAccount = null;
        int i3 = 0;
        while (parcel.dataPosition() < u2) {
            int o2 = r1.a.o(parcel);
            int k2 = r1.a.k(o2);
            if (k2 == 1) {
                i2 = r1.a.q(parcel, o2);
            } else if (k2 == 2) {
                account = (Account) r1.a.e(parcel, o2, Account.CREATOR);
            } else if (k2 == 3) {
                i3 = r1.a.q(parcel, o2);
            } else if (k2 != 4) {
                r1.a.t(parcel, o2);
            } else {
                googleSignInAccount = (GoogleSignInAccount) r1.a.e(parcel, o2, GoogleSignInAccount.CREATOR);
            }
        }
        r1.a.j(parcel, u2);
        return new zat(i2, account, i3, googleSignInAccount);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i2) {
        return new zat[i2];
    }
}
