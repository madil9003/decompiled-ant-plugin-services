package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Binder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.e;

/* loaded from: classes.dex */
public abstract class a extends e.a {
    public static Account j(e eVar) {
        Account account = null;
        if (eVar != null) {
            long clearCallingIdentity = Binder.clearCallingIdentity();
            try {
                try {
                    account = eVar.y();
                } catch (RemoteException unused) {
                    Log.w("AccountAccessor", "Remote account accessor probably died");
                }
            } finally {
                Binder.restoreCallingIdentity(clearCallingIdentity);
            }
        }
        return account;
    }
}
