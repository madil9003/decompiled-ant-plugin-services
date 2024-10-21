package com.google.android.gms.common;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import q1.b0;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a */
    public static final int f1315a = d.f1318a;

    /* renamed from: b */
    private static final b f1316b = new b();

    public Intent a(Context context, int i2, String str) {
        if (i2 != 1 && i2 != 2) {
            if (i2 != 3) {
                return null;
            }
            return b0.c("com.google.android.gms");
        }
        if (context != null && u1.d.e(context)) {
            return b0.a();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("gcore_");
        sb.append(f1315a);
        sb.append("-");
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
        }
        sb.append("-");
        if (context != null) {
            sb.append(context.getPackageName());
        }
        sb.append("-");
        if (context != null) {
            try {
                sb.append(v1.c.a(context).c(context.getPackageName(), 0).versionCode);
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return b0.b("com.google.android.gms", sb.toString());
    }

    public PendingIntent b(Context context, int i2, int i3) {
        return c(context, i2, i3, null);
    }

    public PendingIntent c(Context context, int i2, int i3, String str) {
        Intent a3 = a(context, i2, str);
        if (a3 == null) {
            return null;
        }
        return b2.d.a(context, i3, a3, b2.d.f259a | 134217728);
    }

    public String d(int i2) {
        return d.a(i2);
    }

    public int e(Context context) {
        return f(context, f1315a);
    }

    public int f(Context context, int i2) {
        int c3 = d.c(context, i2);
        if (d.d(context, c3)) {
            return 18;
        }
        return c3;
    }

    public boolean g(Context context, String str) {
        return d.g(context, str);
    }

    public boolean h(int i2) {
        return d.f(i2);
    }
}
