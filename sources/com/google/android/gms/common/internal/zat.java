package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* loaded from: classes.dex */
public final class zat extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zat> CREATOR = new h();

    /* renamed from: a */
    final int f1427a;

    /* renamed from: b */
    private final Account f1428b;

    /* renamed from: c */
    private final int f1429c;

    /* renamed from: d */
    private final GoogleSignInAccount f1430d;

    public zat(int i2, Account account, int i3, GoogleSignInAccount googleSignInAccount) {
        this.f1427a = i2;
        this.f1428b = account;
        this.f1429c = i3;
        this.f1430d = googleSignInAccount;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a3 = r1.b.a(parcel);
        r1.b.j(parcel, 1, this.f1427a);
        r1.b.m(parcel, 2, this.f1428b, i2, false);
        r1.b.j(parcel, 3, this.f1429c);
        r1.b.m(parcel, 4, this.f1430d, i2, false);
        r1.b.b(parcel, a3);
    }

    public zat(Account account, int i2, GoogleSignInAccount googleSignInAccount) {
        this(2, account, i2, googleSignInAccount);
    }
}
