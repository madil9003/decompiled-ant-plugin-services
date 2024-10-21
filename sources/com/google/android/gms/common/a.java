package com.google.android.gms.common;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.util.Log;
import android.util.TypedValue;
import android.widget.ProgressBar;
import b.c;
import com.google.android.gms.common.api.GoogleApiActivity;
import p1.o;
import p1.p;
import q1.n;
import q1.q;

/* loaded from: classes.dex */
public class a extends b {

    /* renamed from: c */
    private String f1205c;

    /* renamed from: e */
    private static final Object f1203e = new Object();

    /* renamed from: f */
    private static final a f1204f = new a();

    /* renamed from: d */
    public static final int f1202d = b.f1315a;

    public static a k() {
        return f1204f;
    }

    @Override // com.google.android.gms.common.b
    public Intent a(Context context, int i2, String str) {
        return super.a(context, i2, str);
    }

    @Override // com.google.android.gms.common.b
    public PendingIntent b(Context context, int i2, int i3) {
        return super.b(context, i2, i3);
    }

    @Override // com.google.android.gms.common.b
    public final String d(int i2) {
        return super.d(i2);
    }

    @Override // com.google.android.gms.common.b
    public int e(Context context) {
        return super.e(context);
    }

    @Override // com.google.android.gms.common.b
    public int f(Context context, int i2) {
        return super.f(context, i2);
    }

    @Override // com.google.android.gms.common.b
    public final boolean h(int i2) {
        return super.h(i2);
    }

    public Dialog i(Activity activity, int i2, int i3, DialogInterface.OnCancelListener onCancelListener) {
        return n(activity, i2, q.b(activity, a(activity, i2, "d"), i3), onCancelListener);
    }

    public PendingIntent j(Context context, ConnectionResult connectionResult) {
        return connectionResult.d() ? connectionResult.c() : b(context, connectionResult.a(), 0);
    }

    public boolean l(Activity activity, int i2, int i3, DialogInterface.OnCancelListener onCancelListener) {
        Dialog i4 = i(activity, i2, i3, onCancelListener);
        if (i4 == null) {
            return false;
        }
        q(activity, i4, "GooglePlayServicesErrorDialog", onCancelListener);
        return true;
    }

    public void m(Context context, int i2) {
        r(context, i2, null, c(context, i2, 0, "n"));
    }

    final Dialog n(Context context, int i2, q qVar, DialogInterface.OnCancelListener onCancelListener) {
        if (i2 == 0) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.alertDialogTheme, typedValue, true);
        AlertDialog.Builder builder = "Theme.Dialog.Alert".equals(context.getResources().getResourceEntryName(typedValue.resourceId)) ? new AlertDialog.Builder(context, 5) : null;
        if (builder == null) {
            builder = new AlertDialog.Builder(context);
        }
        builder.setMessage(n.d(context, i2));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        String c3 = n.c(context, i2);
        if (c3 != null) {
            builder.setPositiveButton(c3, qVar);
        }
        String g3 = n.g(context, i2);
        if (g3 != null) {
            builder.setTitle(g3);
        }
        Log.w("GoogleApiAvailability", String.format("Creating dialog for Google Play services availability issue. ConnectionResult=%s", Integer.valueOf(i2)), new IllegalArgumentException());
        return builder.create();
    }

    public final Dialog o(Activity activity, DialogInterface.OnCancelListener onCancelListener) {
        ProgressBar progressBar = new ProgressBar(activity, null, R.attr.progressBarStyleLarge);
        progressBar.setIndeterminate(true);
        progressBar.setVisibility(0);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setView(progressBar);
        builder.setMessage(n.d(activity, 18));
        builder.setPositiveButton("", (DialogInterface.OnClickListener) null);
        AlertDialog create = builder.create();
        q(activity, create, "GooglePlayServicesUpdatingDialog", onCancelListener);
        return create;
    }

    public final p p(Context context, o oVar) {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        p pVar = new p(oVar);
        context.registerReceiver(pVar, intentFilter);
        pVar.a(context);
        if (g(context, "com.google.android.gms")) {
            return pVar;
        }
        oVar.a();
        pVar.b();
        return null;
    }

    final void q(Activity activity, Dialog dialog, String str, DialogInterface.OnCancelListener onCancelListener) {
        n1.a.a(dialog, onCancelListener).show(activity.getFragmentManager(), str);
    }

    final void r(Context context, int i2, String str, PendingIntent pendingIntent) {
        int i3;
        String str2;
        Log.w("GoogleApiAvailability", String.format("GMS core API Availability. ConnectionResult=%s, tag=%s", Integer.valueOf(i2), null), new IllegalArgumentException());
        if (i2 == 18) {
            s(context);
            return;
        }
        if (pendingIntent == null) {
            if (i2 == 6) {
                Log.w("GoogleApiAvailability", "Missing resolution for ConnectionResult.RESOLUTION_REQUIRED. Call GoogleApiAvailability#showErrorNotification(Context, ConnectionResult) instead.");
                return;
            }
            return;
        }
        String f3 = n.f(context, i2);
        String e3 = n.e(context, i2);
        Resources resources = context.getResources();
        NotificationManager notificationManager = (NotificationManager) q1.f.g(context.getSystemService("notification"));
        c.d n2 = new c.d(context).k(true).e(true).i(f3).n(new c.b().g(e3));
        if (u1.d.d(context)) {
            q1.f.i(u1.f.d());
            n2.m(context.getApplicationInfo().icon).l(2);
            if (u1.d.e(context)) {
                n2.a(m1.a.f2623a, resources.getString(m1.b.f2638o), pendingIntent);
            } else {
                n2.g(pendingIntent);
            }
        } else {
            n2.m(R.drawable.stat_sys_warning).o(resources.getString(m1.b.f2631h)).p(System.currentTimeMillis()).g(pendingIntent).h(e3);
        }
        if (u1.f.g()) {
            q1.f.i(u1.f.g());
            synchronized (f1203e) {
                str2 = this.f1205c;
            }
            if (str2 == null) {
                str2 = "com.google.android.gms.availability";
                NotificationChannel notificationChannel = notificationManager.getNotificationChannel("com.google.android.gms.availability");
                String b3 = n.b(context);
                if (notificationChannel == null) {
                    notificationChannel = new NotificationChannel("com.google.android.gms.availability", b3, 4);
                } else if (!b3.contentEquals(notificationChannel.getName())) {
                    notificationChannel.setName(b3);
                }
                notificationManager.createNotificationChannel(notificationChannel);
            }
            n2.f(str2);
        }
        Notification b4 = n2.b();
        if (i2 == 1 || i2 == 2 || i2 == 3) {
            d.f1319b.set(false);
            i3 = 10436;
        } else {
            i3 = 39789;
        }
        notificationManager.notify(i3, b4);
    }

    final void s(Context context) {
        new e(this, context).sendEmptyMessageDelayed(1, 120000L);
    }

    public final boolean t(Activity activity, p1.e eVar, int i2, int i3, DialogInterface.OnCancelListener onCancelListener) {
        Dialog n2 = n(activity, i2, q.c(eVar, a(activity, i2, "d"), 2), onCancelListener);
        if (n2 == null) {
            return false;
        }
        q(activity, n2, "GooglePlayServicesErrorDialog", onCancelListener);
        return true;
    }

    public final boolean u(Context context, ConnectionResult connectionResult, int i2) {
        PendingIntent j2;
        if (v1.a.a(context) || (j2 = j(context, connectionResult)) == null) {
            return false;
        }
        r(context, connectionResult.a(), null, a2.e.a(context, 0, GoogleApiActivity.a(context, j2, i2, true), a2.e.f103a | 134217728));
        return true;
    }
}
