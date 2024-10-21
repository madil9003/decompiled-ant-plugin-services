package p1;

import android.app.Activity;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a */
    private final Object f2966a;

    public d(Activity activity) {
        q1.f.h(activity, "Activity must not be null");
        this.f2966a = activity;
    }

    public final Activity a() {
        return (Activity) this.f2966a;
    }

    public final d.b b() {
        k1.m.a(this.f2966a);
        return null;
    }

    public final boolean c() {
        return this.f2966a instanceof Activity;
    }

    public final boolean d() {
        return false;
    }
}
