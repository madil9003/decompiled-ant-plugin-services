package g2;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
final class l implements Executor {

    /* renamed from: a */
    private final Handler f1812a = new d2.a(Looper.getMainLooper());

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f1812a.post(runnable);
    }
}
