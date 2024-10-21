package com.google.android.gms.common.internal;

import android.util.Log;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class m {

    /* renamed from: a */
    private Object f1398a;

    /* renamed from: b */
    private boolean f1399b = false;

    /* renamed from: c */
    final /* synthetic */ b f1400c;

    public m(b bVar, Object obj) {
        this.f1400c = bVar;
        this.f1398a = obj;
    }

    protected abstract void a(Object obj);

    public abstract void b();

    public final void c() {
        Object obj;
        synchronized (this) {
            obj = this.f1398a;
            if (this.f1399b) {
                String obj2 = toString();
                StringBuilder sb = new StringBuilder(obj2.length() + 47);
                sb.append("Callback proxy ");
                sb.append(obj2);
                sb.append(" being reused. This is not safe.");
                Log.w("GmsClient", sb.toString());
            }
        }
        if (obj != null) {
            a(obj);
        }
        synchronized (this) {
            this.f1399b = true;
        }
        e();
    }

    public final void d() {
        synchronized (this) {
            this.f1398a = null;
        }
    }

    public final void e() {
        ArrayList arrayList;
        ArrayList arrayList2;
        d();
        arrayList = this.f1400c.f1376r;
        synchronized (arrayList) {
            arrayList2 = this.f1400c.f1376r;
            arrayList2.remove(this);
        }
    }
}
