package q1;

import android.app.Activity;
import android.content.Intent;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class o extends q {

    /* renamed from: a */
    final /* synthetic */ Intent f3044a;

    /* renamed from: b */
    final /* synthetic */ Activity f3045b;

    /* renamed from: c */
    final /* synthetic */ int f3046c;

    public o(Intent intent, Activity activity, int i2) {
        this.f3044a = intent;
        this.f3045b = activity;
        this.f3046c = i2;
    }

    @Override // q1.q
    public final void a() {
        Intent intent = this.f3044a;
        if (intent != null) {
            this.f3045b.startActivityForResult(intent, this.f3046c);
        }
    }
}
