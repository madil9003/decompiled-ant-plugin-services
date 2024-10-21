package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.IInterface;

/* loaded from: classes.dex */
public interface e extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class a extends b2.b implements e {
        public static e c(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
            return queryLocalInterface instanceof e ? (e) queryLocalInterface : new x(iBinder);
        }
    }

    Account y();
}
