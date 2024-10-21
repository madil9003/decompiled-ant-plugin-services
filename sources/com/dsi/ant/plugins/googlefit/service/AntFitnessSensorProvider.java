package com.dsi.ant.plugins.googlefit.service;

import android.content.Context;
import android.os.Handler;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.service.FitnessSensorServiceRequest;
import d1.d;
import d1.e;
import d1.f;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import p0.c;

/* loaded from: classes.dex */
public class AntFitnessSensorProvider extends z1.a {

    /* renamed from: f */
    private static final String f1166f = "AntFitnessSensorProvider";

    /* renamed from: b */
    private ArrayList f1167b = new ArrayList();

    /* renamed from: c */
    private e1.a f1168c = null;

    /* renamed from: d */
    private final Object f1169d = new Object();

    /* renamed from: e */
    private Handler f1170e = new Handler();

    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AntFitnessSensorProvider.this.f();
        }
    }

    public void f() {
        synchronized (this.f1169d) {
            if (this.f1168c != null) {
                h1.a.a(f1166f, "stopping multidevice search.");
                this.f1168c.n();
                this.f1168c = null;
            }
        }
    }

    @Override // z1.a
    public List a(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            DataType dataType = (DataType) it.next();
            Iterator it2 = this.f1167b.iterator();
            while (it2.hasNext()) {
                ArrayList r2 = ((d1.a) it2.next()).r(dataType);
                if (r2 != null) {
                    arrayList.addAll(r2);
                }
            }
        }
        return arrayList;
    }

    @Override // z1.a
    public boolean b(FitnessSensorServiceRequest fitnessSensorServiceRequest) {
        DataSource a3 = fitnessSensorServiceRequest.a();
        f a4 = f.a(fitnessSensorServiceRequest.a().c());
        if (a4 == null) {
            return false;
        }
        synchronized (this.f1169d) {
            if (this.f1168c == null) {
                h1.a.a(f1166f, "Starting multi device search.");
                EnumSet noneOf = EnumSet.noneOf(c.class);
                Iterator it = this.f1167b.iterator();
                while (it.hasNext()) {
                    noneOf.add(((d1.a) it.next()).t());
                }
                this.f1168c = new e1.a(getApplicationContext(), noneOf, this.f1167b);
                this.f1170e.postDelayed(new a(), 20000L);
            }
        }
        Iterator it2 = this.f1167b.iterator();
        while (it2.hasNext()) {
            d1.a aVar = (d1.a) it2.next();
            if (aVar.t() == a4.f1645b) {
                return aVar.E(fitnessSensorServiceRequest.b(), a4.f1644a, a3.a());
            }
        }
        return false;
    }

    @Override // z1.a
    public boolean c(DataSource dataSource) {
        f a3 = f.a(dataSource.c());
        if (a3 == null) {
            return false;
        }
        Iterator it = this.f1167b.iterator();
        boolean z2 = true;
        boolean z3 = false;
        while (it.hasNext()) {
            d1.a aVar = (d1.a) it.next();
            if (aVar.t() == a3.f1645b) {
                z3 = aVar.m(a3.f1644a, dataSource.a());
            }
            if (!aVar.x()) {
                z2 = false;
            }
        }
        if (z2) {
            f();
        }
        return z3;
    }

    @Override // z1.a, android.app.Service
    public void onCreate() {
        super.onCreate();
        Context applicationContext = getApplicationContext();
        this.f1167b.add(new d(applicationContext));
        this.f1167b.add(new e(applicationContext));
        h1.a.a(f1166f, "Total sensors created: " + this.f1167b.size());
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.f1170e.removeCallbacksAndMessages(null);
        f();
    }
}
