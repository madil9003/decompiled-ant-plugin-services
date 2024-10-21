package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import q1.y;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a */
    private int f1359a;

    /* renamed from: b */
    private long f1360b;

    /* renamed from: c */
    private long f1361c;

    /* renamed from: d */
    private int f1362d;

    /* renamed from: e */
    private long f1363e;

    /* renamed from: g */
    w f1365g;

    /* renamed from: h */
    private final Context f1366h;

    /* renamed from: i */
    private final Looper f1367i;

    /* renamed from: j */
    private final com.google.android.gms.common.internal.d f1368j;

    /* renamed from: k */
    private final com.google.android.gms.common.b f1369k;

    /* renamed from: l */
    final Handler f1370l;

    /* renamed from: o */
    private q1.d f1373o;

    /* renamed from: p */
    protected c f1374p;

    /* renamed from: q */
    private IInterface f1375q;

    /* renamed from: s */
    private o f1377s;

    /* renamed from: u */
    private final a f1379u;

    /* renamed from: v */
    private final InterfaceC0028b f1380v;

    /* renamed from: w */
    private final int f1381w;

    /* renamed from: x */
    private final String f1382x;

    /* renamed from: y */
    private volatile String f1383y;
    private static final Feature[] E = new Feature[0];
    public static final String[] D = {"service_esmobile", "service_googleme"};

    /* renamed from: f */
    private volatile String f1364f = null;

    /* renamed from: m */
    private final Object f1371m = new Object();

    /* renamed from: n */
    private final Object f1372n = new Object();

    /* renamed from: r */
    private final ArrayList f1376r = new ArrayList();

    /* renamed from: t */
    private int f1378t = 1;

    /* renamed from: z */
    private ConnectionResult f1384z = null;
    private boolean A = false;
    private volatile zzj B = null;
    protected AtomicInteger C = new AtomicInteger(0);

    /* loaded from: classes.dex */
    public interface a {
        void a(int i2);

        void j(Bundle bundle);
    }

    /* renamed from: com.google.android.gms.common.internal.b$b */
    /* loaded from: classes.dex */
    public interface InterfaceC0028b {
        void c(ConnectionResult connectionResult);
    }

    /* loaded from: classes.dex */
    public interface c {
        void c(ConnectionResult connectionResult);
    }

    /* loaded from: classes.dex */
    protected class d implements c {
        public d() {
        }

        @Override // com.google.android.gms.common.internal.b.c
        public final void c(ConnectionResult connectionResult) {
            if (connectionResult.e()) {
                b bVar = b.this;
                bVar.o(null, bVar.B());
            } else if (b.this.f1380v != null) {
                b.this.f1380v.c(connectionResult);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface e {
        void a();
    }

    public b(Context context, Looper looper, com.google.android.gms.common.internal.d dVar, com.google.android.gms.common.b bVar, int i2, a aVar, InterfaceC0028b interfaceC0028b, String str) {
        q1.f.h(context, "Context must not be null");
        this.f1366h = context;
        q1.f.h(looper, "Looper must not be null");
        this.f1367i = looper;
        q1.f.h(dVar, "Supervisor must not be null");
        this.f1368j = dVar;
        q1.f.h(bVar, "API availability must not be null");
        this.f1369k = bVar;
        this.f1370l = new l(this, looper);
        this.f1381w = i2;
        this.f1379u = aVar;
        this.f1380v = interfaceC0028b;
        this.f1382x = str;
    }

    public static /* bridge */ /* synthetic */ void a0(b bVar, zzj zzjVar) {
        bVar.B = zzjVar;
        if (bVar.Q()) {
            ConnectionTelemetryConfiguration connectionTelemetryConfiguration = zzjVar.f1439d;
            q1.g.b().c(connectionTelemetryConfiguration == null ? null : connectionTelemetryConfiguration.f());
        }
    }

    public static /* bridge */ /* synthetic */ void b0(b bVar, int i2) {
        int i3;
        int i4;
        synchronized (bVar.f1371m) {
            i3 = bVar.f1378t;
        }
        if (i3 == 3) {
            bVar.A = true;
            i4 = 5;
        } else {
            i4 = 4;
        }
        Handler handler = bVar.f1370l;
        handler.sendMessage(handler.obtainMessage(i4, bVar.C.get(), 16));
    }

    public static /* bridge */ /* synthetic */ boolean e0(b bVar, int i2, int i3, IInterface iInterface) {
        synchronized (bVar.f1371m) {
            if (bVar.f1378t != i2) {
                return false;
            }
            bVar.g0(i3, iInterface);
            return true;
        }
    }

    /*  JADX ERROR: NullPointerException in pass: RegionMakerVisitor
        java.lang.NullPointerException: Cannot read field "wordsInUse" because "<parameter1>" is null
        	at java.base/java.util.BitSet.or(Unknown Source)
        	at jadx.core.utils.BlockUtils.getPathCross(BlockUtils.java:759)
        	at jadx.core.utils.BlockUtils.getPathCross(BlockUtils.java:838)
        	at jadx.core.dex.visitors.regions.IfMakerHelper.restructureIf(IfMakerHelper.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:711)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:152)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:735)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:152)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    static /* bridge */ /* synthetic */ boolean f0(com.google.android.gms.common.internal.b r2) {
        /*
            boolean r0 = r2.A
            r1 = 0
            if (r0 == 0) goto L6
            goto L24
        L6:
            java.lang.String r0 = r2.D()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L11
            goto L24
        L11:
            java.lang.String r0 = r2.A()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L1c
            goto L24
        L1c:
            java.lang.String r2 = r2.D()     // Catch: java.lang.ClassNotFoundException -> L24
            java.lang.Class.forName(r2)     // Catch: java.lang.ClassNotFoundException -> L24
            r1 = 1
        L24:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.b.f0(com.google.android.gms.common.internal.b):boolean");
    }

    public final void g0(int i2, IInterface iInterface) {
        w wVar;
        q1.f.a((i2 == 4) == (iInterface != null));
        synchronized (this.f1371m) {
            this.f1378t = i2;
            this.f1375q = iInterface;
            if (i2 == 1) {
                o oVar = this.f1377s;
                if (oVar != null) {
                    com.google.android.gms.common.internal.d dVar = this.f1368j;
                    String c3 = this.f1365g.c();
                    q1.f.g(c3);
                    dVar.e(c3, this.f1365g.b(), this.f1365g.a(), oVar, V(), this.f1365g.d());
                    this.f1377s = null;
                }
            } else if (i2 == 2 || i2 == 3) {
                o oVar2 = this.f1377s;
                if (oVar2 != null && (wVar = this.f1365g) != null) {
                    String c4 = wVar.c();
                    String b3 = wVar.b();
                    StringBuilder sb = new StringBuilder(String.valueOf(c4).length() + 70 + String.valueOf(b3).length());
                    sb.append("Calling connect() while still connected, missing disconnect() for ");
                    sb.append(c4);
                    sb.append(" on ");
                    sb.append(b3);
                    Log.e("GmsClient", sb.toString());
                    com.google.android.gms.common.internal.d dVar2 = this.f1368j;
                    String c5 = this.f1365g.c();
                    q1.f.g(c5);
                    dVar2.e(c5, this.f1365g.b(), this.f1365g.a(), oVar2, V(), this.f1365g.d());
                    this.C.incrementAndGet();
                }
                o oVar3 = new o(this, this.C.get());
                this.f1377s = oVar3;
                w wVar2 = (this.f1378t != 3 || A() == null) ? new w(F(), E(), false, com.google.android.gms.common.internal.d.a(), H()) : new w(x().getPackageName(), A(), true, com.google.android.gms.common.internal.d.a(), false);
                this.f1365g = wVar2;
                if (wVar2.d() && p() < 17895000) {
                    String valueOf = String.valueOf(this.f1365g.c());
                    throw new IllegalStateException(valueOf.length() != 0 ? "Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: ".concat(valueOf) : new String("Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: "));
                }
                com.google.android.gms.common.internal.d dVar3 = this.f1368j;
                String c6 = this.f1365g.c();
                q1.f.g(c6);
                if (!dVar3.f(new y(c6, this.f1365g.b(), this.f1365g.a(), this.f1365g.d()), oVar3, V(), v())) {
                    String c7 = this.f1365g.c();
                    String b4 = this.f1365g.b();
                    StringBuilder sb2 = new StringBuilder(String.valueOf(c7).length() + 34 + String.valueOf(b4).length());
                    sb2.append("unable to connect to service: ");
                    sb2.append(c7);
                    sb2.append(" on ");
                    sb2.append(b4);
                    Log.w("GmsClient", sb2.toString());
                    c0(16, null, this.C.get());
                }
            } else if (i2 == 4) {
                q1.f.g(iInterface);
                J(iInterface);
            }
        }
    }

    protected String A() {
        return null;
    }

    protected abstract Set B();

    public final IInterface C() {
        IInterface iInterface;
        synchronized (this.f1371m) {
            if (this.f1378t == 5) {
                throw new DeadObjectException();
            }
            q();
            iInterface = this.f1375q;
            q1.f.h(iInterface, "Client is connected but service is null");
        }
        return iInterface;
    }

    public abstract String D();

    protected abstract String E();

    protected String F() {
        return "com.google.android.gms";
    }

    public ConnectionTelemetryConfiguration G() {
        zzj zzjVar = this.B;
        if (zzjVar == null) {
            return null;
        }
        return zzjVar.f1439d;
    }

    protected boolean H() {
        return p() >= 211700000;
    }

    public boolean I() {
        return this.B != null;
    }

    protected void J(IInterface iInterface) {
        this.f1361c = System.currentTimeMillis();
    }

    public void K(ConnectionResult connectionResult) {
        this.f1362d = connectionResult.a();
        this.f1363e = System.currentTimeMillis();
    }

    public void L(int i2) {
        this.f1359a = i2;
        this.f1360b = System.currentTimeMillis();
    }

    public void M(int i2, IBinder iBinder, Bundle bundle, int i3) {
        Handler handler = this.f1370l;
        handler.sendMessage(handler.obtainMessage(1, i3, -1, new p(this, i2, iBinder, bundle)));
    }

    public boolean N() {
        return false;
    }

    public void O(String str) {
        this.f1383y = str;
    }

    public void P(int i2) {
        Handler handler = this.f1370l;
        handler.sendMessage(handler.obtainMessage(6, this.C.get(), i2));
    }

    public boolean Q() {
        return false;
    }

    protected final String V() {
        String str = this.f1382x;
        return str == null ? this.f1366h.getClass().getName() : str;
    }

    public boolean b() {
        return true;
    }

    public void c(e eVar) {
        eVar.a();
    }

    public final void c0(int i2, Bundle bundle, int i3) {
        Handler handler = this.f1370l;
        handler.sendMessage(handler.obtainMessage(7, i3, -1, new q(this, i2, null)));
    }

    public void d(c cVar) {
        q1.f.h(cVar, "Connection progress callbacks cannot be null.");
        this.f1374p = cVar;
        g0(2, null);
    }

    public boolean e() {
        boolean z2;
        synchronized (this.f1371m) {
            int i2 = this.f1378t;
            z2 = true;
            if (i2 != 2 && i2 != 3) {
                z2 = false;
            }
        }
        return z2;
    }

    public final Feature[] f() {
        zzj zzjVar = this.B;
        if (zzjVar == null) {
            return null;
        }
        return zzjVar.f1437b;
    }

    public String g() {
        return this.f1364f;
    }

    public boolean h() {
        boolean z2;
        synchronized (this.f1371m) {
            z2 = this.f1378t == 4;
        }
        return z2;
    }

    public void i() {
        this.C.incrementAndGet();
        synchronized (this.f1376r) {
            int size = this.f1376r.size();
            for (int i2 = 0; i2 < size; i2++) {
                ((m) this.f1376r.get(i2)).d();
            }
            this.f1376r.clear();
        }
        synchronized (this.f1372n) {
            this.f1373o = null;
        }
        g0(1, null);
    }

    public void k(String str) {
        this.f1364f = str;
        i();
    }

    public String l() {
        w wVar;
        if (!h() || (wVar = this.f1365g) == null) {
            throw new RuntimeException("Failed to connect when checking package");
        }
        return wVar.b();
    }

    public boolean n() {
        return false;
    }

    public void o(com.google.android.gms.common.internal.e eVar, Set set) {
        Bundle z2 = z();
        GetServiceRequest getServiceRequest = new GetServiceRequest(this.f1381w, this.f1383y);
        getServiceRequest.f1332d = this.f1366h.getPackageName();
        getServiceRequest.f1335g = z2;
        if (set != null) {
            getServiceRequest.f1334f = (Scope[]) set.toArray(new Scope[set.size()]);
        }
        if (n()) {
            Account t2 = t();
            if (t2 == null) {
                t2 = new Account("<<default account>>", "com.google");
            }
            getServiceRequest.f1336h = t2;
            if (eVar != null) {
                getServiceRequest.f1333e = eVar.asBinder();
            }
        } else if (N()) {
            getServiceRequest.f1336h = t();
        }
        getServiceRequest.f1337i = E;
        getServiceRequest.f1338j = u();
        if (Q()) {
            getServiceRequest.f1341m = true;
        }
        try {
            try {
                synchronized (this.f1372n) {
                    q1.d dVar = this.f1373o;
                    if (dVar != null) {
                        dVar.q(new n(this, this.C.get()), getServiceRequest);
                    } else {
                        Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                    }
                }
            } catch (DeadObjectException e3) {
                Log.w("GmsClient", "IGmsServiceBroker.getService failed", e3);
                P(3);
            } catch (SecurityException e4) {
                throw e4;
            }
        } catch (RemoteException | RuntimeException e5) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e5);
            M(8, null, null, this.C.get());
        }
    }

    public abstract int p();

    protected final void q() {
        if (!h()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    public abstract IInterface r(IBinder iBinder);

    public boolean s() {
        return false;
    }

    public abstract Account t();

    public Feature[] u() {
        return E;
    }

    protected abstract Executor v();

    public Bundle w() {
        return null;
    }

    public final Context x() {
        return this.f1366h;
    }

    public int y() {
        return this.f1381w;
    }

    protected abstract Bundle z();
}
