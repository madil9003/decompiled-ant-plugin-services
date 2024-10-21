package q1;

import android.R;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import java.util.Locale;

/* loaded from: classes.dex */
public abstract class n {

    /* renamed from: a */
    private static final a.e f3042a = new a.e();

    /* renamed from: b */
    private static Locale f3043b;

    public static String a(Context context) {
        String packageName = context.getPackageName();
        try {
            return v1.c.a(context).b(packageName).toString();
        } catch (PackageManager.NameNotFoundException | NullPointerException unused) {
            String str = context.getApplicationInfo().name;
            return TextUtils.isEmpty(str) ? packageName : str;
        }
    }

    public static String b(Context context) {
        return context.getResources().getString(m1.b.f2630g);
    }

    public static String c(Context context, int i2) {
        return context.getResources().getString(i2 != 1 ? i2 != 2 ? i2 != 3 ? R.string.ok : m1.b.f2624a : m1.b.f2633j : m1.b.f2627d);
    }

    public static String d(Context context, int i2) {
        Resources resources = context.getResources();
        String a3 = a(context);
        if (i2 == 1) {
            return resources.getString(m1.b.f2628e, a3);
        }
        if (i2 == 2) {
            return u1.d.e(context) ? resources.getString(m1.b.f2637n) : resources.getString(m1.b.f2634k, a3);
        }
        if (i2 == 3) {
            return resources.getString(m1.b.f2625b, a3);
        }
        if (i2 == 5) {
            return h(context, "common_google_play_services_invalid_account_text", a3);
        }
        if (i2 == 7) {
            return h(context, "common_google_play_services_network_error_text", a3);
        }
        if (i2 == 9) {
            return resources.getString(m1.b.f2632i, a3);
        }
        if (i2 == 20) {
            return h(context, "common_google_play_services_restricted_profile_text", a3);
        }
        switch (i2) {
            case 16:
                return h(context, "common_google_play_services_api_unavailable_text", a3);
            case 17:
                return h(context, "common_google_play_services_sign_in_failed_text", a3);
            case 18:
                return resources.getString(m1.b.f2636m, a3);
            default:
                return resources.getString(n1.c.f2693a, a3);
        }
    }

    public static String e(Context context, int i2) {
        return (i2 == 6 || i2 == 19) ? h(context, "common_google_play_services_resolution_required_text", a(context)) : d(context, i2);
    }

    public static String f(Context context, int i2) {
        String i3 = i2 == 6 ? i(context, "common_google_play_services_resolution_required_title") : g(context, i2);
        return i3 == null ? context.getResources().getString(m1.b.f2631h) : i3;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0007. Please report as an issue. */
    public static String g(Context context, int i2) {
        String str;
        Resources resources = context.getResources();
        switch (i2) {
            case 1:
                return resources.getString(m1.b.f2629f);
            case 2:
                return resources.getString(m1.b.f2635l);
            case 3:
                return resources.getString(m1.b.f2626c);
            case 4:
            case 6:
            case 18:
                return null;
            case 5:
                Log.e("GoogleApiAvailability", "An invalid account was specified when connecting. Please provide a valid account.");
                return i(context, "common_google_play_services_invalid_account_title");
            case 7:
                Log.e("GoogleApiAvailability", "Network error occurred. Please retry request later.");
                return i(context, "common_google_play_services_network_error_title");
            case 8:
                str = "Internal error occurred. Please see logs for detailed information";
                Log.e("GoogleApiAvailability", str);
                return null;
            case 9:
                str = "Google Play services is invalid. Cannot recover.";
                Log.e("GoogleApiAvailability", str);
                return null;
            case 10:
                str = "Developer error occurred. Please see logs for detailed information";
                Log.e("GoogleApiAvailability", str);
                return null;
            case 11:
                str = "The application is not licensed to the user.";
                Log.e("GoogleApiAvailability", str);
                return null;
            case 12:
            case 13:
            case 14:
            case 15:
            case 19:
            default:
                StringBuilder sb = new StringBuilder(33);
                sb.append("Unexpected error code ");
                sb.append(i2);
                str = sb.toString();
                Log.e("GoogleApiAvailability", str);
                return null;
            case 16:
                str = "One of the API components you attempted to connect to is not available.";
                Log.e("GoogleApiAvailability", str);
                return null;
            case 17:
                Log.e("GoogleApiAvailability", "The specified account could not be signed in.");
                return i(context, "common_google_play_services_sign_in_failed_title");
            case 20:
                Log.e("GoogleApiAvailability", "The current user profile is restricted and could not use authenticated features.");
                return i(context, "common_google_play_services_restricted_profile_title");
        }
    }

    private static String h(Context context, String str, String str2) {
        Resources resources = context.getResources();
        String i2 = i(context, str);
        if (i2 == null) {
            i2 = resources.getString(n1.c.f2693a);
        }
        return String.format(resources.getConfiguration().locale, i2, str2);
    }

    private static String i(Context context, String str) {
        a.e eVar = f3042a;
        synchronized (eVar) {
            Locale b3 = c.a.a(context.getResources().getConfiguration()).b(0);
            if (!b3.equals(f3043b)) {
                eVar.clear();
                f3043b = b3;
            }
            String str2 = (String) eVar.get(str);
            if (str2 != null) {
                return str2;
            }
            Resources b4 = com.google.android.gms.common.c.b(context);
            if (b4 == null) {
                return null;
            }
            int identifier = b4.getIdentifier(str, "string", "com.google.android.gms");
            if (identifier == 0) {
                Log.w("GoogleApiAvailability", str.length() != 0 ? "Missing resource: ".concat(str) : new String("Missing resource: "));
                return null;
            }
            String string = b4.getString(identifier);
            if (TextUtils.isEmpty(string)) {
                Log.w("GoogleApiAvailability", str.length() != 0 ? "Got empty resource: ".concat(str) : new String("Got empty resource: "));
                return null;
            }
            eVar.put(str, string);
            return string;
        }
    }
}
