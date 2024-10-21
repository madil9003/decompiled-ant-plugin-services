package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Status;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import o1.a;
import o1.e;

/* loaded from: classes.dex */
public final class l implements e.a, e.b {

    /* renamed from: b */
    private final a.f f1268b;

    /* renamed from: c */
    private final p1.b f1269c;

    /* renamed from: d */
    private final e f1270d;

    /* renamed from: g */
    private final int f1273g;

    /* renamed from: h */
    private final p1.v f1274h;

    /* renamed from: i */
    private boolean f1275i;

    /* renamed from: m */
    final /* synthetic */ b f1279m;

    /* renamed from: a */
    private final Queue f1267a = new LinkedList();

    /* renamed from: e */
    private final Set f1271e = new HashSet();

    /* renamed from: f */
    private final Map f1272f = new HashMap();

    /* renamed from: j */
    private final List f1276j = new ArrayList();

    /* renamed from: k */
    private ConnectionResult f1277k = null;

    /* renamed from: l */
    private int f1278l = 0;

    public l(b bVar, o1.d dVar) {
        Handler handler;
        Context context;
        Handler handler2;
        this.f1279m = bVar;
        handler = bVar.f1246p;
        a.f g3 = dVar.g(handler.getLooper(), this);
        this.f1268b = g3;
        this.f1269c = dVar.d();
        this.f1270d = new e();
        this.f1273g = dVar.f();
        if (!g3.n()) {
            this.f1274h = null;
            return;
        }
        context = bVar.f1237g;
        handler2 = bVar.f1246p;
        this.f1274h = dVar.h(context, handler2);
    }

    public static /* bridge */ /* synthetic */ void A(l lVar, m mVar) {
        if (lVar.f1276j.contains(mVar) && !lVar.f1275i) {
            if (lVar.f1268b.h()) {
                lVar.h();
            } else {
                lVar.D();
            }
        }
    }

    public static /* bridge */ /* synthetic */ void B(l lVar, m mVar) {
        Handler handler;
        Handler handler2;
        Feature feature;
        Feature[] g3;
        if (lVar.f1276j.remove(mVar)) {
            handler = lVar.f1279m.f1246p;
            handler.removeMessages(15, mVar);
            handler2 = lVar.f1279m.f1246p;
            handler2.removeMessages(16, mVar);
            feature = mVar.f1281b;
            ArrayList arrayList = new ArrayList(lVar.f1267a.size());
            for (v vVar : lVar.f1267a) {
                if ((vVar instanceof p1.q) && (g3 = ((p1.q) vVar).g(lVar)) != null && u1.a.b(g3, feature)) {
                    arrayList.add(vVar);
                }
            }
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                v vVar2 = (v) arrayList.get(i2);
                lVar.f1267a.remove(vVar2);
                vVar2.b(new o1.g(feature));
            }
        }
    }

    private final Feature d(Feature[] featureArr) {
        if (featureArr != null && featureArr.length != 0) {
            Feature[] f3 = this.f1268b.f();
            if (f3 == null) {
                f3 = new Feature[0];
            }
            a.a aVar = new a.a(f3.length);
            for (Feature feature : f3) {
                aVar.put(feature.a(), Long.valueOf(feature.b()));
            }
            for (Feature feature2 : featureArr) {
                Long l2 = (Long) aVar.get(feature2.a());
                if (l2 == null || l2.longValue() < feature2.b()) {
                    return feature2;
                }
            }
        }
        return null;
    }

    private final void e(ConnectionResult connectionResult) {
        Iterator it = this.f1271e.iterator();
        if (!it.hasNext()) {
            this.f1271e.clear();
            return;
        }
        k1.m.a(it.next());
        if (q1.e.a(connectionResult, ConnectionResult.f1193e)) {
            this.f1268b.l();
        }
        throw null;
    }

    public final void f(Status status) {
        Handler handler;
        handler = this.f1279m.f1246p;
        q1.f.d(handler);
        g(status, null, false);
    }

    private final void g(Status status, Exception exc, boolean z2) {
        Handler handler;
        handler = this.f1279m.f1246p;
        q1.f.d(handler);
        if ((status == null) == (exc == null)) {
            throw new IllegalArgumentException("Status XOR exception should be null");
        }
        Iterator it = this.f1267a.iterator();
        while (it.hasNext()) {
            v vVar = (v) it.next();
            if (!z2 || vVar.f1304a == 2) {
                if (status != null) {
                    vVar.a(status);
                } else {
                    vVar.b(exc);
                }
                it.remove();
            }
        }
    }

    private final void h() {
        ArrayList arrayList = new ArrayList(this.f1267a);
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            v vVar = (v) arrayList.get(i2);
            if (!this.f1268b.h()) {
                return;
            }
            if (o(vVar)) {
                this.f1267a.remove(vVar);
            }
        }
    }

    public final void i() {
        C();
        e(ConnectionResult.f1193e);
        n();
        Iterator it = this.f1272f.values().iterator();
        if (it.hasNext()) {
            k1.m.a(it.next());
            throw null;
        }
        h();
        l();
    }

    public final void k(int i2) {
        Handler handler;
        Handler handler2;
        long j2;
        Handler handler3;
        Handler handler4;
        long j3;
        q1.r rVar;
        C();
        this.f1275i = true;
        this.f1270d.c(i2, this.f1268b.g());
        b bVar = this.f1279m;
        handler = bVar.f1246p;
        handler2 = bVar.f1246p;
        Message obtain = Message.obtain(handler2, 9, this.f1269c);
        j2 = this.f1279m.f1231a;
        handler.sendMessageDelayed(obtain, j2);
        b bVar2 = this.f1279m;
        handler3 = bVar2.f1246p;
        handler4 = bVar2.f1246p;
        Message obtain2 = Message.obtain(handler4, 11, this.f1269c);
        j3 = this.f1279m.f1232b;
        handler3.sendMessageDelayed(obtain2, j3);
        rVar = this.f1279m.f1239i;
        rVar.c();
        Iterator it = this.f1272f.values().iterator();
        if (it.hasNext()) {
            k1.m.a(it.next());
            throw null;
        }
    }

    private final void l() {
        Handler handler;
        Handler handler2;
        Handler handler3;
        long j2;
        handler = this.f1279m.f1246p;
        handler.removeMessages(12, this.f1269c);
        b bVar = this.f1279m;
        handler2 = bVar.f1246p;
        handler3 = bVar.f1246p;
        Message obtainMessage = handler3.obtainMessage(12, this.f1269c);
        j2 = this.f1279m.f1233c;
        handler2.sendMessageDelayed(obtainMessage, j2);
    }

    private final void m(v vVar) {
        vVar.d(this.f1270d, L());
        try {
            vVar.c(this);
        } catch (DeadObjectException unused) {
            a(1);
            this.f1268b.k("DeadObjectException thrown while running ApiCallRunner.");
        }
    }

    private final void n() {
        Handler handler;
        Handler handler2;
        if (this.f1275i) {
            handler = this.f1279m.f1246p;
            handler.removeMessages(11, this.f1269c);
            handler2 = this.f1279m.f1246p;
            handler2.removeMessages(9, this.f1269c);
            this.f1275i = false;
        }
    }

    private final boolean o(v vVar) {
        boolean z2;
        Handler handler;
        Handler handler2;
        long j2;
        Handler handler3;
        Handler handler4;
        long j3;
        Handler handler5;
        Handler handler6;
        Handler handler7;
        long j4;
        if (!(vVar instanceof p1.q)) {
            m(vVar);
            return true;
        }
        p1.q qVar = (p1.q) vVar;
        Feature d3 = d(qVar.g(this));
        if (d3 == null) {
            m(vVar);
            return true;
        }
        String name = this.f1268b.getClass().getName();
        String a3 = d3.a();
        long b3 = d3.b();
        StringBuilder sb = new StringBuilder(name.length() + 77 + String.valueOf(a3).length());
        sb.append(name);
        sb.append(" could not execute call because it requires feature (");
        sb.append(a3);
        sb.append(", ");
        sb.append(b3);
        sb.append(").");
        Log.w("GoogleApiManager", sb.toString());
        z2 = this.f1279m.f1247q;
        if (!z2 || !qVar.f(this)) {
            qVar.b(new o1.g(d3));
            return true;
        }
        m mVar = new m(this.f1269c, d3, null);
        int indexOf = this.f1276j.indexOf(mVar);
        if (indexOf >= 0) {
            m mVar2 = (m) this.f1276j.get(indexOf);
            handler5 = this.f1279m.f1246p;
            handler5.removeMessages(15, mVar2);
            b bVar = this.f1279m;
            handler6 = bVar.f1246p;
            handler7 = bVar.f1246p;
            Message obtain = Message.obtain(handler7, 15, mVar2);
            j4 = this.f1279m.f1231a;
            handler6.sendMessageDelayed(obtain, j4);
            return false;
        }
        this.f1276j.add(mVar);
        b bVar2 = this.f1279m;
        handler = bVar2.f1246p;
        handler2 = bVar2.f1246p;
        Message obtain2 = Message.obtain(handler2, 15, mVar);
        j2 = this.f1279m.f1231a;
        handler.sendMessageDelayed(obtain2, j2);
        b bVar3 = this.f1279m;
        handler3 = bVar3.f1246p;
        handler4 = bVar3.f1246p;
        Message obtain3 = Message.obtain(handler4, 16, mVar);
        j3 = this.f1279m.f1232b;
        handler3.sendMessageDelayed(obtain3, j3);
        ConnectionResult connectionResult = new ConnectionResult(2, null);
        if (p(connectionResult)) {
            return false;
        }
        this.f1279m.g(connectionResult, this.f1273g);
        return false;
    }

    private final boolean p(ConnectionResult connectionResult) {
        Object obj;
        f fVar;
        Set set;
        f fVar2;
        obj = b.f1229t;
        synchronized (obj) {
            b bVar = this.f1279m;
            fVar = bVar.f1243m;
            if (fVar != null) {
                set = bVar.f1244n;
                if (set.contains(this.f1269c)) {
                    fVar2 = this.f1279m.f1243m;
                    fVar2.s(connectionResult, this.f1273g);
                    return true;
                }
            }
            return false;
        }
    }

    private final boolean q(boolean z2) {
        Handler handler;
        handler = this.f1279m.f1246p;
        q1.f.d(handler);
        if (!this.f1268b.h() || this.f1272f.size() != 0) {
            return false;
        }
        if (!this.f1270d.e()) {
            this.f1268b.k("Timing out service connection.");
            return true;
        }
        if (z2) {
            l();
        }
        return false;
    }

    public final void C() {
        Handler handler;
        handler = this.f1279m.f1246p;
        q1.f.d(handler);
        this.f1277k = null;
    }

    public final void D() {
        Handler handler;
        ConnectionResult connectionResult;
        q1.r rVar;
        Context context;
        handler = this.f1279m.f1246p;
        q1.f.d(handler);
        if (this.f1268b.h() || this.f1268b.e()) {
            return;
        }
        try {
            b bVar = this.f1279m;
            rVar = bVar.f1239i;
            context = bVar.f1237g;
            int b3 = rVar.b(context, this.f1268b);
            if (b3 != 0) {
                ConnectionResult connectionResult2 = new ConnectionResult(b3, null);
                String name = this.f1268b.getClass().getName();
                String obj = connectionResult2.toString();
                StringBuilder sb = new StringBuilder(name.length() + 35 + obj.length());
                sb.append("The service for ");
                sb.append(name);
                sb.append(" is not available: ");
                sb.append(obj);
                Log.w("GoogleApiManager", sb.toString());
                G(connectionResult2, null);
                return;
            }
            b bVar2 = this.f1279m;
            a.f fVar = this.f1268b;
            o oVar = new o(bVar2, fVar, this.f1269c);
            if (fVar.n()) {
                ((p1.v) q1.f.g(this.f1274h)).I(oVar);
            }
            try {
                this.f1268b.d(oVar);
            } catch (SecurityException e3) {
                e = e3;
                connectionResult = new ConnectionResult(10);
                G(connectionResult, e);
            }
        } catch (IllegalStateException e4) {
            e = e4;
            connectionResult = new ConnectionResult(10);
        }
    }

    public final void E(v vVar) {
        Handler handler;
        handler = this.f1279m.f1246p;
        q1.f.d(handler);
        if (this.f1268b.h()) {
            if (o(vVar)) {
                l();
                return;
            } else {
                this.f1267a.add(vVar);
                return;
            }
        }
        this.f1267a.add(vVar);
        ConnectionResult connectionResult = this.f1277k;
        if (connectionResult == null || !connectionResult.d()) {
            D();
        } else {
            G(this.f1277k, null);
        }
    }

    public final void F() {
        this.f1278l++;
    }

    public final void G(ConnectionResult connectionResult, Exception exc) {
        Handler handler;
        q1.r rVar;
        boolean z2;
        Status h2;
        Status h3;
        Status h4;
        Handler handler2;
        Handler handler3;
        long j2;
        Handler handler4;
        Status status;
        Handler handler5;
        Handler handler6;
        handler = this.f1279m.f1246p;
        q1.f.d(handler);
        p1.v vVar = this.f1274h;
        if (vVar != null) {
            vVar.J();
        }
        C();
        rVar = this.f1279m.f1239i;
        rVar.c();
        e(connectionResult);
        if ((this.f1268b instanceof s1.e) && connectionResult.a() != 24) {
            this.f1279m.f1234d = true;
            b bVar = this.f1279m;
            handler5 = bVar.f1246p;
            handler6 = bVar.f1246p;
            handler5.sendMessageDelayed(handler6.obtainMessage(19), 300000L);
        }
        if (connectionResult.a() == 4) {
            status = b.f1228s;
            f(status);
            return;
        }
        if (this.f1267a.isEmpty()) {
            this.f1277k = connectionResult;
            return;
        }
        if (exc != null) {
            handler4 = this.f1279m.f1246p;
            q1.f.d(handler4);
            g(null, exc, false);
            return;
        }
        z2 = this.f1279m.f1247q;
        if (!z2) {
            h2 = b.h(this.f1269c, connectionResult);
            f(h2);
            return;
        }
        h3 = b.h(this.f1269c, connectionResult);
        g(h3, null, true);
        if (this.f1267a.isEmpty() || p(connectionResult) || this.f1279m.g(connectionResult, this.f1273g)) {
            return;
        }
        if (connectionResult.a() == 18) {
            this.f1275i = true;
        }
        if (!this.f1275i) {
            h4 = b.h(this.f1269c, connectionResult);
            f(h4);
            return;
        }
        b bVar2 = this.f1279m;
        handler2 = bVar2.f1246p;
        handler3 = bVar2.f1246p;
        Message obtain = Message.obtain(handler3, 9, this.f1269c);
        j2 = this.f1279m.f1231a;
        handler2.sendMessageDelayed(obtain, j2);
    }

    public final void H(ConnectionResult connectionResult) {
        Handler handler;
        handler = this.f1279m.f1246p;
        q1.f.d(handler);
        a.f fVar = this.f1268b;
        String name = fVar.getClass().getName();
        String valueOf = String.valueOf(connectionResult);
        StringBuilder sb = new StringBuilder(name.length() + 25 + valueOf.length());
        sb.append("onSignInFailed for ");
        sb.append(name);
        sb.append(" with ");
        sb.append(valueOf);
        fVar.k(sb.toString());
        G(connectionResult, null);
    }

    public final void I() {
        Handler handler;
        handler = this.f1279m.f1246p;
        q1.f.d(handler);
        if (this.f1275i) {
            D();
        }
    }

    public final void J() {
        Handler handler;
        handler = this.f1279m.f1246p;
        q1.f.d(handler);
        f(b.f1227r);
        this.f1270d.d();
        for (p1.f fVar : (p1.f[]) this.f1272f.keySet().toArray(new p1.f[0])) {
            E(new u(null, new g2.e()));
        }
        e(new ConnectionResult(4));
        if (this.f1268b.h()) {
            this.f1268b.c(new k(this));
        }
    }

    public final void K() {
        Handler handler;
        com.google.android.gms.common.a aVar;
        Context context;
        handler = this.f1279m.f1246p;
        q1.f.d(handler);
        if (this.f1275i) {
            n();
            b bVar = this.f1279m;
            aVar = bVar.f1238h;
            context = bVar.f1237g;
            f(aVar.e(context) == 18 ? new Status(21, "Connection timed out waiting for Google Play services update to complete.") : new Status(22, "API failed to connect while resuming due to an unknown error."));
            this.f1268b.k("Timing out connection while resuming.");
        }
    }

    public final boolean L() {
        return this.f1268b.n();
    }

    @Override // p1.c
    public final void a(int i2) {
        Handler handler;
        Handler handler2;
        Looper myLooper = Looper.myLooper();
        handler = this.f1279m.f1246p;
        if (myLooper == handler.getLooper()) {
            k(i2);
        } else {
            handler2 = this.f1279m.f1246p;
            handler2.post(new i(this, i2));
        }
    }

    public final boolean b() {
        return q(true);
    }

    @Override // p1.h
    public final void c(ConnectionResult connectionResult) {
        G(connectionResult, null);
    }

    @Override // p1.c
    public final void j(Bundle bundle) {
        Handler handler;
        Handler handler2;
        Looper myLooper = Looper.myLooper();
        handler = this.f1279m.f1246p;
        if (myLooper == handler.getLooper()) {
            i();
        } else {
            handler2 = this.f1279m.f1246p;
            handler2.post(new h(this));
        }
    }

    public final int r() {
        return this.f1273g;
    }

    public final int s() {
        return this.f1278l;
    }

    public final a.f u() {
        return this.f1268b;
    }

    public final Map w() {
        return this.f1272f;
    }
}
