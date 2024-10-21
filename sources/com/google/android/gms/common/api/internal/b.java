package com.google.android.gms.common.api.internal;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.MethodInvocation;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;
import com.google.android.gms.common.internal.TelemetryData;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public class b implements Handler.Callback {

    /* renamed from: r */
    public static final Status f1227r = new Status(4, "Sign-out occurred while this API call was in progress.");

    /* renamed from: s */
    private static final Status f1228s = new Status(4, "The user must be signed in to make this API call.");

    /* renamed from: t */
    private static final Object f1229t = new Object();

    /* renamed from: u */
    private static b f1230u;

    /* renamed from: e */
    private TelemetryData f1235e;

    /* renamed from: f */
    private q1.i f1236f;

    /* renamed from: g */
    private final Context f1237g;

    /* renamed from: h */
    private final com.google.android.gms.common.a f1238h;

    /* renamed from: i */
    private final q1.r f1239i;

    /* renamed from: p */
    private final Handler f1246p;

    /* renamed from: q */
    private volatile boolean f1247q;

    /* renamed from: a */
    private long f1231a = 5000;

    /* renamed from: b */
    private long f1232b = 120000;

    /* renamed from: c */
    private long f1233c = 10000;

    /* renamed from: d */
    private boolean f1234d = false;

    /* renamed from: j */
    private final AtomicInteger f1240j = new AtomicInteger(1);

    /* renamed from: k */
    private final AtomicInteger f1241k = new AtomicInteger(0);

    /* renamed from: l */
    private final Map f1242l = new ConcurrentHashMap(5, 0.75f, 1);

    /* renamed from: m */
    private f f1243m = null;

    /* renamed from: n */
    private final Set f1244n = new a.b();

    /* renamed from: o */
    private final Set f1245o = new a.b();

    private b(Context context, Looper looper, com.google.android.gms.common.a aVar) {
        this.f1247q = true;
        this.f1237g = context;
        a2.f fVar = new a2.f(looper, this);
        this.f1246p = fVar;
        this.f1238h = aVar;
        this.f1239i = new q1.r(aVar);
        if (u1.d.a(context)) {
            this.f1247q = false;
        }
        fVar.sendMessage(fVar.obtainMessage(6));
    }

    public static Status h(p1.b bVar, ConnectionResult connectionResult) {
        String b3 = bVar.b();
        String valueOf = String.valueOf(connectionResult);
        StringBuilder sb = new StringBuilder(String.valueOf(b3).length() + 63 + valueOf.length());
        sb.append("API: ");
        sb.append(b3);
        sb.append(" is not available on this device. Connection failed with: ");
        sb.append(valueOf);
        return new Status(connectionResult, sb.toString());
    }

    private final l i(o1.d dVar) {
        p1.b d3 = dVar.d();
        l lVar = (l) this.f1242l.get(d3);
        if (lVar == null) {
            lVar = new l(this, dVar);
            this.f1242l.put(d3, lVar);
        }
        if (lVar.L()) {
            this.f1245o.add(d3);
        }
        lVar.D();
        return lVar;
    }

    private final q1.i j() {
        if (this.f1236f == null) {
            this.f1236f = q1.h.a(this.f1237g);
        }
        return this.f1236f;
    }

    private final void k() {
        TelemetryData telemetryData = this.f1235e;
        if (telemetryData != null) {
            if (telemetryData.a() > 0 || f()) {
                j().a(telemetryData);
            }
            this.f1235e = null;
        }
    }

    private final void l(g2.e eVar, int i2, o1.d dVar) {
        p b3;
        if (i2 == 0 || (b3 = p.b(this, i2, dVar.d())) == null) {
            return;
        }
        g2.d a3 = eVar.a();
        final Handler handler = this.f1246p;
        handler.getClass();
        a3.b(new Executor() { // from class: p1.l
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                handler.post(runnable);
            }
        }, b3);
    }

    public static b x(Context context) {
        b bVar;
        synchronized (f1229t) {
            if (f1230u == null) {
                f1230u = new b(context.getApplicationContext(), com.google.android.gms.common.internal.d.c().getLooper(), com.google.android.gms.common.a.k());
            }
            bVar = f1230u;
        }
        return bVar;
    }

    public final void D(o1.d dVar, int i2, c cVar, g2.e eVar, p1.j jVar) {
        l(eVar, cVar.d(), dVar);
        t tVar = new t(i2, cVar, eVar, jVar);
        Handler handler = this.f1246p;
        handler.sendMessage(handler.obtainMessage(4, new p1.r(tVar, this.f1241k.get(), dVar)));
    }

    public final void E(MethodInvocation methodInvocation, int i2, long j2, int i3) {
        Handler handler = this.f1246p;
        handler.sendMessage(handler.obtainMessage(18, new q(methodInvocation, i2, j2, i3)));
    }

    public final void F(ConnectionResult connectionResult, int i2) {
        if (g(connectionResult, i2)) {
            return;
        }
        Handler handler = this.f1246p;
        handler.sendMessage(handler.obtainMessage(5, i2, 0, connectionResult));
    }

    public final void a() {
        Handler handler = this.f1246p;
        handler.sendMessage(handler.obtainMessage(3));
    }

    public final void b(o1.d dVar) {
        Handler handler = this.f1246p;
        handler.sendMessage(handler.obtainMessage(7, dVar));
    }

    public final void c(f fVar) {
        synchronized (f1229t) {
            if (this.f1243m != fVar) {
                this.f1243m = fVar;
                this.f1244n.clear();
            }
            this.f1244n.addAll(fVar.t());
        }
    }

    public final void d(f fVar) {
        synchronized (f1229t) {
            if (this.f1243m == fVar) {
                this.f1243m = null;
                this.f1244n.clear();
            }
        }
    }

    public final boolean f() {
        if (this.f1234d) {
            return false;
        }
        RootTelemetryConfiguration a3 = q1.g.b().a();
        if (a3 != null && !a3.c()) {
            return false;
        }
        int a4 = this.f1239i.a(this.f1237g, 203400000);
        return a4 == -1 || a4 == 0;
    }

    public final boolean g(ConnectionResult connectionResult, int i2) {
        return this.f1238h.u(this.f1237g, connectionResult, i2);
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        p1.b bVar;
        p1.b bVar2;
        p1.b bVar3;
        p1.b bVar4;
        p1.b bVar5;
        int i2 = message.what;
        l lVar = null;
        switch (i2) {
            case 1:
                this.f1233c = true == ((Boolean) message.obj).booleanValue() ? 10000L : 300000L;
                this.f1246p.removeMessages(12);
                for (p1.b bVar6 : this.f1242l.keySet()) {
                    Handler handler = this.f1246p;
                    handler.sendMessageDelayed(handler.obtainMessage(12, bVar6), this.f1233c);
                }
                return true;
            case 2:
                k1.m.a(message.obj);
                throw null;
            case 3:
                for (l lVar2 : this.f1242l.values()) {
                    lVar2.C();
                    lVar2.D();
                }
                return true;
            case 4:
            case 8:
            case 13:
                p1.r rVar = (p1.r) message.obj;
                l lVar3 = (l) this.f1242l.get(rVar.f2974c.d());
                if (lVar3 == null) {
                    lVar3 = i(rVar.f2974c);
                }
                if (!lVar3.L() || this.f1241k.get() == rVar.f2973b) {
                    lVar3.E(rVar.f2972a);
                } else {
                    rVar.f2972a.a(f1227r);
                    lVar3.J();
                }
                return true;
            case 5:
                int i3 = message.arg1;
                ConnectionResult connectionResult = (ConnectionResult) message.obj;
                Iterator it = this.f1242l.values().iterator();
                while (true) {
                    if (it.hasNext()) {
                        l lVar4 = (l) it.next();
                        if (lVar4.r() == i3) {
                            lVar = lVar4;
                        }
                    }
                }
                if (lVar == null) {
                    StringBuilder sb = new StringBuilder(76);
                    sb.append("Could not find API instance ");
                    sb.append(i3);
                    sb.append(" while trying to fail enqueued calls.");
                    Log.wtf("GoogleApiManager", sb.toString(), new Exception());
                } else if (connectionResult.a() == 13) {
                    String d3 = this.f1238h.d(connectionResult.a());
                    String b3 = connectionResult.b();
                    StringBuilder sb2 = new StringBuilder(String.valueOf(d3).length() + 69 + String.valueOf(b3).length());
                    sb2.append("Error resolution was canceled by the user, original error message: ");
                    sb2.append(d3);
                    sb2.append(": ");
                    sb2.append(b3);
                    lVar.f(new Status(17, sb2.toString()));
                } else {
                    bVar = lVar.f1269c;
                    lVar.f(h(bVar, connectionResult));
                }
                return true;
            case 6:
                if (this.f1237g.getApplicationContext() instanceof Application) {
                    a.c((Application) this.f1237g.getApplicationContext());
                    a.b().a(new g(this));
                    if (!a.b().e(true)) {
                        this.f1233c = 300000L;
                    }
                }
                return true;
            case 7:
                i((o1.d) message.obj);
                return true;
            case 9:
                if (this.f1242l.containsKey(message.obj)) {
                    ((l) this.f1242l.get(message.obj)).I();
                }
                return true;
            case 10:
                Iterator it2 = this.f1245o.iterator();
                while (it2.hasNext()) {
                    l lVar5 = (l) this.f1242l.remove((p1.b) it2.next());
                    if (lVar5 != null) {
                        lVar5.J();
                    }
                }
                this.f1245o.clear();
                return true;
            case 11:
                if (this.f1242l.containsKey(message.obj)) {
                    ((l) this.f1242l.get(message.obj)).K();
                }
                return true;
            case 12:
                if (this.f1242l.containsKey(message.obj)) {
                    ((l) this.f1242l.get(message.obj)).b();
                }
                return true;
            case 14:
                k1.m.a(message.obj);
                throw null;
            case 15:
                m mVar = (m) message.obj;
                Map map = this.f1242l;
                bVar2 = mVar.f1280a;
                if (map.containsKey(bVar2)) {
                    Map map2 = this.f1242l;
                    bVar3 = mVar.f1280a;
                    l.A((l) map2.get(bVar3), mVar);
                }
                return true;
            case 16:
                m mVar2 = (m) message.obj;
                Map map3 = this.f1242l;
                bVar4 = mVar2.f1280a;
                if (map3.containsKey(bVar4)) {
                    Map map4 = this.f1242l;
                    bVar5 = mVar2.f1280a;
                    l.B((l) map4.get(bVar5), mVar2);
                }
                return true;
            case 17:
                k();
                return true;
            case 18:
                q qVar = (q) message.obj;
                if (qVar.f1297c == 0) {
                    j().a(new TelemetryData(qVar.f1296b, Arrays.asList(qVar.f1295a)));
                } else {
                    TelemetryData telemetryData = this.f1235e;
                    if (telemetryData != null) {
                        List b4 = telemetryData.b();
                        if (telemetryData.a() != qVar.f1296b || (b4 != null && b4.size() >= qVar.f1298d)) {
                            this.f1246p.removeMessages(17);
                            k();
                        } else {
                            this.f1235e.c(qVar.f1295a);
                        }
                    }
                    if (this.f1235e == null) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(qVar.f1295a);
                        this.f1235e = new TelemetryData(qVar.f1296b, arrayList);
                        Handler handler2 = this.f1246p;
                        handler2.sendMessageDelayed(handler2.obtainMessage(17), qVar.f1297c);
                    }
                }
                return true;
            case 19:
                this.f1234d = false;
                return true;
            default:
                StringBuilder sb3 = new StringBuilder(31);
                sb3.append("Unknown message id: ");
                sb3.append(i2);
                Log.w("GoogleApiManager", sb3.toString());
                return false;
        }
    }

    public final int m() {
        return this.f1240j.getAndIncrement();
    }

    public final l w(p1.b bVar) {
        return (l) this.f1242l.get(bVar);
    }
}
