package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.HandlerThread;
import java.util.concurrent.Executor;
import q1.y;

/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a */
    private static int f1386a = 4225;

    /* renamed from: b */
    private static final Object f1387b = new Object();

    /* renamed from: c */
    private static v f1388c = null;

    /* renamed from: d */
    static HandlerThread f1389d = null;

    /* renamed from: e */
    private static boolean f1390e = false;

    public static int a() {
        return f1386a;
    }

    public static d b(Context context) {
        synchronized (f1387b) {
            if (f1388c == null) {
                f1388c = new v(context.getApplicationContext(), f1390e ? c().getLooper() : context.getMainLooper());
            }
        }
        return f1388c;
    }

    public static HandlerThread c() {
        synchronized (f1387b) {
            HandlerThread handlerThread = f1389d;
            if (handlerThread != null) {
                return handlerThread;
            }
            HandlerThread handlerThread2 = new HandlerThread("GoogleApiHandler", 9);
            f1389d = handlerThread2;
            handlerThread2.start();
            return f1389d;
        }
    }

    protected abstract void d(y yVar, ServiceConnection serviceConnection, String str);

    public final void e(String str, String str2, int i2, ServiceConnection serviceConnection, String str3, boolean z2) {
        d(new y(str, str2, i2, z2), serviceConnection, str3);
    }

    public abstract boolean f(y yVar, ServiceConnection serviceConnection, String str, Executor executor);
}
