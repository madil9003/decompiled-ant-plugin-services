package q1;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

/* loaded from: classes.dex */
public final class y {

    /* renamed from: f */
    private static final Uri f3055f = new Uri.Builder().scheme("content").authority("com.google.android.gms.chimera").build();

    /* renamed from: a */
    private final String f3056a;

    /* renamed from: b */
    private final String f3057b;

    /* renamed from: c */
    private final ComponentName f3058c;

    /* renamed from: d */
    private final int f3059d;

    /* renamed from: e */
    private final boolean f3060e;

    public y(String str, String str2, int i2, boolean z2) {
        f.e(str);
        this.f3056a = str;
        f.e(str2);
        this.f3057b = str2;
        this.f3058c = null;
        this.f3059d = i2;
        this.f3060e = z2;
    }

    public final int a() {
        return this.f3059d;
    }

    public final ComponentName b() {
        return this.f3058c;
    }

    public final Intent c(Context context) {
        Bundle bundle;
        if (this.f3056a == null) {
            return new Intent().setComponent(this.f3058c);
        }
        if (this.f3060e) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("serviceActionBundleKey", this.f3056a);
            try {
                bundle = context.getContentResolver().call(f3055f, "serviceIntentCall", (String) null, bundle2);
            } catch (IllegalArgumentException e3) {
                Log.w("ConnectionStatusConfig", "Dynamic intent resolution failed: ".concat(e3.toString()));
                bundle = null;
            }
            r2 = bundle != null ? (Intent) bundle.getParcelable("serviceResponseIntentKey") : null;
            if (r2 == null) {
                String valueOf = String.valueOf(this.f3056a);
                Log.w("ConnectionStatusConfig", valueOf.length() != 0 ? "Dynamic lookup for intent failed for action: ".concat(valueOf) : new String("Dynamic lookup for intent failed for action: "));
            }
        }
        return r2 != null ? r2 : new Intent(this.f3056a).setPackage(this.f3057b);
    }

    public final String d() {
        return this.f3057b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y)) {
            return false;
        }
        y yVar = (y) obj;
        return e.a(this.f3056a, yVar.f3056a) && e.a(this.f3057b, yVar.f3057b) && e.a(this.f3058c, yVar.f3058c) && this.f3059d == yVar.f3059d && this.f3060e == yVar.f3060e;
    }

    public final int hashCode() {
        return e.b(this.f3056a, this.f3057b, this.f3058c, Integer.valueOf(this.f3059d), Boolean.valueOf(this.f3060e));
    }

    public final String toString() {
        String str = this.f3056a;
        if (str != null) {
            return str;
        }
        f.g(this.f3058c);
        return this.f3058c.flattenToString();
    }
}
