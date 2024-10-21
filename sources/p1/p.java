package p1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/* loaded from: classes.dex */
public final class p extends BroadcastReceiver {

    /* renamed from: a */
    Context f2970a;

    /* renamed from: b */
    private final o f2971b;

    public p(o oVar) {
        this.f2971b = oVar;
    }

    public final void a(Context context) {
        this.f2970a = context;
    }

    public final synchronized void b() {
        Context context = this.f2970a;
        if (context != null) {
            context.unregisterReceiver(this);
        }
        this.f2970a = null;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Uri data = intent.getData();
        if ("com.google.android.gms".equals(data != null ? data.getSchemeSpecificPart() : null)) {
            this.f2971b.a();
            b();
        }
    }
}
