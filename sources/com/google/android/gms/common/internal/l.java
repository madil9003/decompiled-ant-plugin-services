package com.google.android.gms.common.internal;

import android.app.PendingIntent;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.b;

/* loaded from: classes.dex */
public final class l extends b2.e {

    /* renamed from: a */
    final /* synthetic */ b f1397a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(b bVar, Looper looper) {
        super(looper);
        this.f1397a = bVar;
    }

    private static final void a(Message message) {
        m mVar = (m) message.obj;
        mVar.b();
        mVar.e();
    }

    private static final boolean b(Message message) {
        int i2 = message.what;
        return i2 == 2 || i2 == 1 || i2 == 7;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        b.a aVar;
        b.a aVar2;
        ConnectionResult connectionResult;
        ConnectionResult connectionResult2;
        boolean z2;
        if (this.f1397a.C.get() != message.arg1) {
            if (b(message)) {
                a(message);
                return;
            }
            return;
        }
        int i2 = message.what;
        if ((i2 == 1 || i2 == 7 || ((i2 == 4 && !this.f1397a.s()) || message.what == 5)) && !this.f1397a.e()) {
            a(message);
            return;
        }
        int i3 = message.what;
        if (i3 == 4) {
            this.f1397a.f1384z = new ConnectionResult(message.arg2);
            if (b.f0(this.f1397a)) {
                b bVar = this.f1397a;
                z2 = bVar.A;
                if (!z2) {
                    bVar.g0(3, null);
                    return;
                }
            }
            b bVar2 = this.f1397a;
            connectionResult2 = bVar2.f1384z;
            ConnectionResult connectionResult3 = connectionResult2 != null ? bVar2.f1384z : new ConnectionResult(8);
            this.f1397a.f1374p.c(connectionResult3);
            this.f1397a.K(connectionResult3);
            return;
        }
        if (i3 == 5) {
            b bVar3 = this.f1397a;
            connectionResult = bVar3.f1384z;
            ConnectionResult connectionResult4 = connectionResult != null ? bVar3.f1384z : new ConnectionResult(8);
            this.f1397a.f1374p.c(connectionResult4);
            this.f1397a.K(connectionResult4);
            return;
        }
        if (i3 == 3) {
            Object obj = message.obj;
            ConnectionResult connectionResult5 = new ConnectionResult(message.arg2, obj instanceof PendingIntent ? (PendingIntent) obj : null);
            this.f1397a.f1374p.c(connectionResult5);
            this.f1397a.K(connectionResult5);
            return;
        }
        if (i3 == 6) {
            this.f1397a.g0(5, null);
            b bVar4 = this.f1397a;
            aVar = bVar4.f1379u;
            if (aVar != null) {
                aVar2 = bVar4.f1379u;
                aVar2.a(message.arg2);
            }
            this.f1397a.L(message.arg2);
            b.e0(this.f1397a, 5, 1, null);
            return;
        }
        if (i3 == 2 && !this.f1397a.h()) {
            a(message);
            return;
        }
        if (b(message)) {
            ((m) message.obj).c();
            return;
        }
        int i4 = message.what;
        StringBuilder sb = new StringBuilder(45);
        sb.append("Don't know how to handle message: ");
        sb.append(i4);
        Log.wtf("GmsClient", sb.toString(), new Exception());
    }
}
