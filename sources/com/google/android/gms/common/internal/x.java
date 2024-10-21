package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class x extends b2.a implements e {
    public x(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IAccountAccessor");
    }

    @Override // com.google.android.gms.common.internal.e
    public final Account y() {
        Parcel a3 = a(2, c());
        Account account = (Account) b2.c.a(a3, Account.CREATOR);
        a3.recycle();
        return account;
    }
}
