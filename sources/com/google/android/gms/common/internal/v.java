package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Looper;
import java.util.HashMap;
import java.util.concurrent.Executor;
import q1.y;

/* loaded from: classes.dex */
public final class v extends d {

    /* renamed from: f */
    private final HashMap f1416f = new HashMap();

    /* renamed from: g */
    private final Context f1417g;

    /* renamed from: h */
    private volatile Handler f1418h;

    /* renamed from: i */
    private final u f1419i;

    /* renamed from: j */
    private final t1.a f1420j;

    /* renamed from: k */
    private final long f1421k;

    /* renamed from: l */
    private final long f1422l;

    public v(Context context, Looper looper) {
        u uVar = new u(this, null);
        this.f1419i = uVar;
        this.f1417g = context.getApplicationContext();
        this.f1418h = new b2.e(looper, uVar);
        this.f1420j = t1.a.a();
        this.f1421k = 5000L;
        this.f1422l = 300000L;
    }

    @Override // com.google.android.gms.common.internal.d
    protected final void d(y yVar, ServiceConnection serviceConnection, String str) {
        q1.f.h(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f1416f) {
            t tVar = (t) this.f1416f.get(yVar);
            if (tVar == null) {
                String obj = yVar.toString();
                StringBuilder sb = new StringBuilder(obj.length() + 50);
                sb.append("Nonexistent connection status for service config: ");
                sb.append(obj);
                throw new IllegalStateException(sb.toString());
            }
            if (!tVar.h(serviceConnection)) {
                String obj2 = yVar.toString();
                StringBuilder sb2 = new StringBuilder(obj2.length() + 76);
                sb2.append("Trying to unbind a GmsServiceConnection  that was not bound before.  config=");
                sb2.append(obj2);
                throw new IllegalStateException(sb2.toString());
            }
            tVar.f(serviceConnection, str);
            if (tVar.i()) {
                this.f1418h.sendMessageDelayed(this.f1418h.obtainMessage(0, yVar), this.f1421k);
            }
        }
    }

    @Override // com.google.android.gms.common.internal.d
    public final boolean f(y yVar, ServiceConnection serviceConnection, String str, Executor executor) {
        boolean j2;
        q1.f.h(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f1416f) {
            t tVar = (t) this.f1416f.get(yVar);
            if (tVar == null) {
                tVar = new t(this, yVar);
                tVar.d(serviceConnection, serviceConnection, str);
                tVar.e(str, executor);
                this.f1416f.put(yVar, tVar);
            } else {
                this.f1418h.removeMessages(0, yVar);
                if (tVar.h(serviceConnection)) {
                    String obj = yVar.toString();
                    StringBuilder sb = new StringBuilder(obj.length() + 81);
                    sb.append("Trying to bind a GmsServiceConnection that was already connected before.  config=");
                    sb.append(obj);
                    throw new IllegalStateException(sb.toString());
                }
                tVar.d(serviceConnection, serviceConnection, str);
                int a3 = tVar.a();
                if (a3 == 1) {
                    serviceConnection.onServiceConnected(tVar.b(), tVar.c());
                } else if (a3 == 2) {
                    tVar.e(str, executor);
                }
            }
            j2 = tVar.j();
        }
        return j2;
    }
}
