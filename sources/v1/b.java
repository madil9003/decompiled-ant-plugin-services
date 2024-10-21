package v1;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a */
    protected final Context f3474a;

    public b(Context context) {
        this.f3474a = context;
    }

    public ApplicationInfo a(String str, int i2) {
        return this.f3474a.getPackageManager().getApplicationInfo(str, i2);
    }

    public CharSequence b(String str) {
        return this.f3474a.getPackageManager().getApplicationLabel(this.f3474a.getPackageManager().getApplicationInfo(str, 0));
    }

    public PackageInfo c(String str, int i2) {
        return this.f3474a.getPackageManager().getPackageInfo(str, i2);
    }
}
