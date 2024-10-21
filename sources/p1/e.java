package p1;

import android.app.Activity;
import android.content.Intent;
import com.google.android.gms.common.api.internal.LifecycleCallback;

/* loaded from: classes.dex */
public interface e {
    void a(String str, LifecycleCallback lifecycleCallback);

    LifecycleCallback b(String str, Class cls);

    Activity c();

    void startActivityForResult(Intent intent, int i2);
}
