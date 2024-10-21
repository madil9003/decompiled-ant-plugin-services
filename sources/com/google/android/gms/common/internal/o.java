package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;

/* loaded from: classes.dex */
public final class o implements ServiceConnection {

    /* renamed from: a */
    private final int f1403a;

    /* renamed from: b */
    final /* synthetic */ b f1404b;

    public o(b bVar, int i2) {
        this.f1404b = bVar;
        this.f1403a = i2;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Object obj;
        if (iBinder == null) {
            b.b0(this.f1404b, 16);
            return;
        }
        obj = this.f1404b.f1372n;
        synchronized (obj) {
            b bVar = this.f1404b;
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            bVar.f1373o = (queryLocalInterface == null || !(queryLocalInterface instanceof q1.d)) ? new k(iBinder) : (q1.d) queryLocalInterface;
        }
        this.f1404b.c0(0, null, this.f1403a);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        Object obj;
        obj = this.f1404b.f1372n;
        synchronized (obj) {
            this.f1404b.f1373o = null;
        }
        Handler handler = this.f1404b.f1370l;
        handler.sendMessage(handler.obtainMessage(6, this.f1403a, 1));
    }
}
