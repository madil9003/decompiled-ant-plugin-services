package com.google.android.gms.signin.internal;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class c extends a2.a {
    public c(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.signin.internal.ISignInService");
    }

    public final void F(zai zaiVar, f2.c cVar) {
        Parcel a3 = a();
        a2.c.b(a3, zaiVar);
        a2.c.c(a3, cVar);
        c(12, a3);
    }
}
