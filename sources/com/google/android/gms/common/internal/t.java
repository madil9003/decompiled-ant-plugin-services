package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Executor;
import q1.a0;
import q1.y;

/* loaded from: classes.dex */
final class t implements ServiceConnection, a0 {

    /* renamed from: a */
    private final Map f1408a = new HashMap();

    /* renamed from: b */
    private int f1409b = 2;

    /* renamed from: c */
    private boolean f1410c;

    /* renamed from: d */
    private IBinder f1411d;

    /* renamed from: e */
    private final y f1412e;

    /* renamed from: f */
    private ComponentName f1413f;

    /* renamed from: g */
    final /* synthetic */ v f1414g;

    public t(v vVar, y yVar) {
        this.f1414g = vVar;
        this.f1412e = yVar;
    }

    public final int a() {
        return this.f1409b;
    }

    public final ComponentName b() {
        return this.f1413f;
    }

    public final IBinder c() {
        return this.f1411d;
    }

    public final void d(ServiceConnection serviceConnection, ServiceConnection serviceConnection2, String str) {
        this.f1408a.put(serviceConnection, serviceConnection2);
    }

    public final void e(String str, Executor executor) {
        t1.a aVar;
        Context context;
        Context context2;
        t1.a aVar2;
        Context context3;
        Handler handler;
        Handler handler2;
        long j2;
        this.f1409b = 3;
        v vVar = this.f1414g;
        aVar = vVar.f1420j;
        context = vVar.f1417g;
        y yVar = this.f1412e;
        context2 = vVar.f1417g;
        boolean c3 = aVar.c(context, str, yVar.c(context2), this, this.f1412e.a(), executor);
        this.f1410c = c3;
        if (c3) {
            handler = this.f1414g.f1418h;
            Message obtainMessage = handler.obtainMessage(1, this.f1412e);
            handler2 = this.f1414g.f1418h;
            j2 = this.f1414g.f1422l;
            handler2.sendMessageDelayed(obtainMessage, j2);
            return;
        }
        this.f1409b = 2;
        try {
            v vVar2 = this.f1414g;
            aVar2 = vVar2.f1420j;
            context3 = vVar2.f1417g;
            aVar2.b(context3, this);
        } catch (IllegalArgumentException unused) {
        }
    }

    public final void f(ServiceConnection serviceConnection, String str) {
        this.f1408a.remove(serviceConnection);
    }

    public final void g(String str) {
        Handler handler;
        t1.a aVar;
        Context context;
        handler = this.f1414g.f1418h;
        handler.removeMessages(1, this.f1412e);
        v vVar = this.f1414g;
        aVar = vVar.f1420j;
        context = vVar.f1417g;
        aVar.b(context, this);
        this.f1410c = false;
        this.f1409b = 2;
    }

    public final boolean h(ServiceConnection serviceConnection) {
        return this.f1408a.containsKey(serviceConnection);
    }

    public final boolean i() {
        return this.f1408a.isEmpty();
    }

    public final boolean j() {
        return this.f1410c;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        HashMap hashMap;
        Handler handler;
        hashMap = this.f1414g.f1416f;
        synchronized (hashMap) {
            handler = this.f1414g.f1418h;
            handler.removeMessages(1, this.f1412e);
            this.f1411d = iBinder;
            this.f1413f = componentName;
            Iterator it = this.f1408a.values().iterator();
            while (it.hasNext()) {
                ((ServiceConnection) it.next()).onServiceConnected(componentName, iBinder);
            }
            this.f1409b = 1;
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        HashMap hashMap;
        Handler handler;
        hashMap = this.f1414g.f1416f;
        synchronized (hashMap) {
            handler = this.f1414g.f1418h;
            handler.removeMessages(1, this.f1412e);
            this.f1411d = null;
            this.f1413f = componentName;
            Iterator it = this.f1408a.values().iterator();
            while (it.hasNext()) {
                ((ServiceConnection) it.next()).onServiceDisconnected(componentName);
            }
            this.f1409b = 2;
        }
    }
}
