package n1;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.util.Log;

/* loaded from: classes.dex */
public class b {

    /* renamed from: b */
    private static b f2691b;

    /* renamed from: a */
    private final Context f2692a;

    public b(Context context) {
        this.f2692a = context.getApplicationContext();
    }

    public static b a(Context context) {
        q1.f.g(context);
        synchronized (b.class) {
            if (f2691b == null) {
                m.a(context);
                f2691b = new b(context);
            }
        }
        return f2691b;
    }

    static final i b(PackageInfo packageInfo, i... iVarArr) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr == null) {
            return null;
        }
        if (signatureArr.length != 1) {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
            return null;
        }
        j jVar = new j(packageInfo.signatures[0].toByteArray());
        for (int i2 = 0; i2 < iVarArr.length; i2++) {
            if (iVarArr[i2].equals(jVar)) {
                return iVarArr[i2];
            }
        }
        return null;
    }

    public static final boolean c(PackageInfo packageInfo, boolean z2) {
        if (packageInfo != null && packageInfo.signatures != null) {
            if ((z2 ? b(packageInfo, l.f2698a) : b(packageInfo, l.f2698a[0])) != null) {
                return true;
            }
        }
        return false;
    }
}
