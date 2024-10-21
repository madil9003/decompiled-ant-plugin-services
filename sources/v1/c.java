package v1;

import android.content.Context;

/* loaded from: classes.dex */
public class c {

    /* renamed from: b */
    private static c f3475b = new c();

    /* renamed from: a */
    private b f3476a = null;

    public static b a(Context context) {
        return f3475b.b(context);
    }

    public final synchronized b b(Context context) {
        if (this.f3476a == null) {
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            this.f3476a = new b(context);
        }
        return this.f3476a;
    }
}
