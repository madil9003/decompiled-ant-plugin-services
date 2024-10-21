package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.UserManager;
import android.util.Log;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import q1.u;
import u1.g;

/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a */
    public static final int f1318a = 12451000;

    /* renamed from: b */
    static final AtomicBoolean f1319b = new AtomicBoolean();

    /* renamed from: c */
    private static final AtomicBoolean f1320c = new AtomicBoolean();

    public static String a(int i2) {
        return ConnectionResult.f(i2);
    }

    public static Resources b(Context context) {
        try {
            return context.getPackageManager().getResourcesForApplication("com.google.android.gms");
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public static int c(Context context, int i2) {
        String valueOf;
        String str;
        PackageInfo packageInfo;
        try {
            context.getResources().getString(n1.c.f2693a);
        } catch (Throwable unused) {
            Log.e("GooglePlayServicesUtil", "The Google Play services resources were not found. Check your project configuration to ensure that the resources are included.");
        }
        if (!"com.google.android.gms".equals(context.getPackageName()) && !f1320c.get()) {
            int a3 = u.a(context);
            if (a3 == 0) {
                throw new GooglePlayServicesMissingManifestValueException();
            }
            if (a3 != f1318a) {
                throw new GooglePlayServicesIncorrectManifestValueException(a3);
            }
        }
        boolean z2 = (u1.d.e(context) || u1.d.g(context)) ? false : true;
        q1.f.a(i2 >= 0);
        String packageName = context.getPackageName();
        PackageManager packageManager = context.getPackageManager();
        if (z2) {
            try {
                packageInfo = packageManager.getPackageInfo("com.android.vending", 8256);
            } catch (PackageManager.NameNotFoundException unused2) {
                valueOf = String.valueOf(packageName);
                str = " requires the Google Play Store, but it is missing.";
            }
        } else {
            packageInfo = null;
        }
        try {
            PackageInfo packageInfo2 = packageManager.getPackageInfo("com.google.android.gms", 64);
            n1.b.a(context);
            if (n1.b.c(packageInfo2, true)) {
                if (z2) {
                    q1.f.g(packageInfo);
                    if (!n1.b.c(packageInfo, true)) {
                        valueOf = String.valueOf(packageName);
                        str = " requires Google Play Store, but its signature is invalid.";
                    }
                }
                if (!z2 || packageInfo == null || packageInfo.signatures[0].equals(packageInfo2.signatures[0])) {
                    if (g.a(packageInfo2.versionCode) >= g.a(i2)) {
                        ApplicationInfo applicationInfo = packageInfo2.applicationInfo;
                        if (applicationInfo == null) {
                            try {
                                applicationInfo = packageManager.getApplicationInfo("com.google.android.gms", 0);
                            } catch (PackageManager.NameNotFoundException e3) {
                                Log.wtf("GooglePlayServicesUtil", String.valueOf(packageName).concat(" requires Google Play services, but they're missing when getting application info."), e3);
                                return 1;
                            }
                        }
                        return !applicationInfo.enabled ? 3 : 0;
                    }
                    int i3 = packageInfo2.versionCode;
                    StringBuilder sb = new StringBuilder(String.valueOf(packageName).length() + 82);
                    sb.append("Google Play services out of date for ");
                    sb.append(packageName);
                    sb.append(".  Requires ");
                    sb.append(i2);
                    sb.append(" but found ");
                    sb.append(i3);
                    Log.w("GooglePlayServicesUtil", sb.toString());
                    return 2;
                }
                valueOf = String.valueOf(packageName);
                str = " requires Google Play Store, but its signature doesn't match that of Google Play services.";
            } else {
                valueOf = String.valueOf(packageName);
                str = " requires Google Play services, but their signature is invalid.";
            }
            Log.w("GooglePlayServicesUtil", valueOf.concat(str));
            return 9;
        } catch (PackageManager.NameNotFoundException unused3) {
            Log.w("GooglePlayServicesUtil", String.valueOf(packageName).concat(" requires Google Play services, but they are missing."));
            return 1;
        }
    }

    public static boolean d(Context context, int i2) {
        if (i2 == 18) {
            return true;
        }
        if (i2 == 1) {
            return g(context, "com.google.android.gms");
        }
        return false;
    }

    public static boolean e(Context context) {
        if (!u1.f.b()) {
            return false;
        }
        Object systemService = context.getSystemService("user");
        q1.f.g(systemService);
        Bundle applicationRestrictions = ((UserManager) systemService).getApplicationRestrictions(context.getPackageName());
        return applicationRestrictions != null && "true".equals(applicationRestrictions.getString("restricted_profile"));
    }

    public static boolean f(int i2) {
        return i2 == 1 || i2 == 2 || i2 == 3 || i2 == 9;
    }

    public static boolean g(Context context, String str) {
        ApplicationInfo applicationInfo;
        boolean equals = str.equals("com.google.android.gms");
        if (u1.f.e()) {
            try {
                Iterator<PackageInstaller.SessionInfo> it = context.getPackageManager().getPackageInstaller().getAllSessions().iterator();
                while (it.hasNext()) {
                    if (str.equals(it.next().getAppPackageName())) {
                        return true;
                    }
                }
            } catch (Exception unused) {
                return false;
            }
        }
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(str, 8192);
        } catch (PackageManager.NameNotFoundException unused2) {
        }
        return equals ? applicationInfo.enabled : applicationInfo.enabled && !e(context);
    }
}
