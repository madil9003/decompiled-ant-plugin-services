package x1;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;

/* loaded from: classes.dex */
public abstract class e {

    /* renamed from: a */
    private static String f3585a = null;

    /* renamed from: b */
    private static int f3586b = -1;

    public static int a(Context context) {
        int i2 = f3586b;
        if (i2 == -1) {
            if (u1.d.d(context)) {
                i2 = 3;
            } else if (u1.d.c(context) || u1.d.a(context)) {
                i2 = 0;
            } else if (!u1.d.b(context.getResources()) || c(context)) {
                String str = Build.PRODUCT;
                i2 = (TextUtils.isEmpty(str) || !str.startsWith("glass_")) ? 1 : 6;
            } else {
                i2 = 2;
            }
            f3586b = i2;
        }
        return i2;
    }

    public static String b(Context context) {
        String str = f3585a;
        if (str != null) {
            return str;
        }
        String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
        f3585a = string;
        return string;
    }

    private static boolean c(Context context) {
        try {
            return ((TelephonyManager) q1.f.g((TelephonyManager) context.getSystemService("phone"))).getPhoneType() != 0;
        } catch (Resources.NotFoundException e3) {
            Log.e("Fitness", "Unable to determine type of device, assuming phone.", e3);
            return true;
        }
    }
}
