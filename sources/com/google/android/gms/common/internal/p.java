package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.b;

/* loaded from: classes.dex */
public final class p extends j {

    /* renamed from: g */
    public final IBinder f1405g;

    /* renamed from: h */
    final /* synthetic */ b f1406h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(b bVar, int i2, IBinder iBinder, Bundle bundle) {
        super(bVar, i2, bundle);
        this.f1406h = bVar;
        this.f1405g = iBinder;
    }

    @Override // com.google.android.gms.common.internal.j
    protected final void f(ConnectionResult connectionResult) {
        if (this.f1406h.f1380v != null) {
            this.f1406h.f1380v.c(connectionResult);
        }
        this.f1406h.K(connectionResult);
    }

    @Override // com.google.android.gms.common.internal.j
    protected final boolean g() {
        String str;
        String interfaceDescriptor;
        b.a aVar;
        b.a aVar2;
        try {
            IBinder iBinder = this.f1405g;
            q1.f.g(iBinder);
            interfaceDescriptor = iBinder.getInterfaceDescriptor();
        } catch (RemoteException unused) {
            str = "service probably died";
        }
        if (!this.f1406h.D().equals(interfaceDescriptor)) {
            String D = this.f1406h.D();
            StringBuilder sb = new StringBuilder(String.valueOf(D).length() + 34 + String.valueOf(interfaceDescriptor).length());
            sb.append("service descriptor mismatch: ");
            sb.append(D);
            sb.append(" vs. ");
            sb.append(interfaceDescriptor);
            str = sb.toString();
            Log.w("GmsClient", str);
            return false;
        }
        IInterface r2 = this.f1406h.r(this.f1405g);
        if (r2 == null || !(b.e0(this.f1406h, 2, 4, r2) || b.e0(this.f1406h, 3, 4, r2))) {
            return false;
        }
        this.f1406h.f1384z = null;
        Bundle w2 = this.f1406h.w();
        b bVar = this.f1406h;
        aVar = bVar.f1379u;
        if (aVar == null) {
            return true;
        }
        aVar2 = bVar.f1379u;
        aVar2.j(w2);
        return true;
    }
}
