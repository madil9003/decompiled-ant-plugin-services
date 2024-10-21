package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
final class k implements q1.d {

    /* renamed from: a */
    private final IBinder f1396a;

    public k(IBinder iBinder) {
        this.f1396a = iBinder;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f1396a;
    }

    @Override // q1.d
    public final void q(q1.c cVar, GetServiceRequest getServiceRequest) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            obtain.writeStrongBinder(cVar != null ? cVar.asBinder() : null);
            if (getServiceRequest != null) {
                obtain.writeInt(1);
                s.a(getServiceRequest, obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f1396a.transact(46, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
