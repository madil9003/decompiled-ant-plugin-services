package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Status;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a */
    private final Map f1257a = Collections.synchronizedMap(new WeakHashMap());

    /* renamed from: b */
    private final Map f1258b = Collections.synchronizedMap(new WeakHashMap());

    private final void f(boolean z2, Status status) {
        HashMap hashMap;
        HashMap hashMap2;
        synchronized (this.f1257a) {
            hashMap = new HashMap(this.f1257a);
        }
        synchronized (this.f1258b) {
            hashMap2 = new HashMap(this.f1258b);
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            if (z2 || ((Boolean) entry.getValue()).booleanValue()) {
                k1.m.a(entry.getKey());
                throw null;
            }
        }
        for (Map.Entry entry2 : hashMap2.entrySet()) {
            if (z2 || ((Boolean) entry2.getValue()).booleanValue()) {
                ((g2.e) entry2.getKey()).c(new o1.b(status));
            }
        }
    }

    public final void b(g2.e eVar, boolean z2) {
        this.f1258b.put(eVar, Boolean.valueOf(z2));
        eVar.a().a(new d(this, eVar));
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void c(int r4, java.lang.String r5) {
        /*
            r3 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "The connection to Google Play services was lost"
            r0.<init>(r1)
            r1 = 1
            if (r4 != r1) goto L10
            java.lang.String r4 = " due to service disconnection."
        Lc:
            r0.append(r4)
            goto L16
        L10:
            r2 = 3
            if (r4 != r2) goto L16
            java.lang.String r4 = " due to dead object exception."
            goto Lc
        L16:
            if (r5 == 0) goto L20
            java.lang.String r4 = " Last reason for disconnect: "
            r0.append(r4)
            r0.append(r5)
        L20:
            com.google.android.gms.common.api.Status r4 = new com.google.android.gms.common.api.Status
            r5 = 20
            java.lang.String r0 = r0.toString()
            r4.<init>(r5, r0)
            r3.f(r1, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.e.c(int, java.lang.String):void");
    }

    public final void d() {
        f(false, b.f1227r);
    }

    public final boolean e() {
        return (this.f1257a.isEmpty() && this.f1258b.isEmpty()) ? false : true;
    }
}
