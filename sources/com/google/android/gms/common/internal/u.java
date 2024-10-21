package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import java.util.HashMap;
import q1.y;
import q1.z;

/* loaded from: classes.dex */
public final class u implements Handler.Callback {

    /* renamed from: a */
    final /* synthetic */ v f1415a;

    public /* synthetic */ u(v vVar, z zVar) {
        this.f1415a = vVar;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        HashMap hashMap;
        HashMap hashMap2;
        HashMap hashMap3;
        HashMap hashMap4;
        HashMap hashMap5;
        int i2 = message.what;
        if (i2 == 0) {
            hashMap = this.f1415a.f1416f;
            synchronized (hashMap) {
                y yVar = (y) message.obj;
                hashMap2 = this.f1415a.f1416f;
                t tVar = (t) hashMap2.get(yVar);
                if (tVar != null && tVar.i()) {
                    if (tVar.j()) {
                        tVar.g("GmsClientSupervisor");
                    }
                    hashMap3 = this.f1415a.f1416f;
                    hashMap3.remove(yVar);
                }
            }
            return true;
        }
        if (i2 != 1) {
            return false;
        }
        hashMap4 = this.f1415a.f1416f;
        synchronized (hashMap4) {
            y yVar2 = (y) message.obj;
            hashMap5 = this.f1415a.f1416f;
            t tVar2 = (t) hashMap5.get(yVar2);
            if (tVar2 != null && tVar2.a() == 3) {
                String valueOf = String.valueOf(yVar2);
                StringBuilder sb = new StringBuilder(valueOf.length() + 47);
                sb.append("Timeout waiting for ServiceConnection callback ");
                sb.append(valueOf);
                Log.e("GmsClientSupervisor", sb.toString(), new Exception());
                ComponentName b3 = tVar2.b();
                if (b3 == null) {
                    b3 = yVar2.b();
                }
                if (b3 == null) {
                    String d3 = yVar2.d();
                    q1.f.g(d3);
                    b3 = new ComponentName(d3, "unknown");
                }
                tVar2.onServiceDisconnected(b3);
            }
        }
        return true;
    }
}
