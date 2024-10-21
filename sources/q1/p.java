package q1;

import android.content.Intent;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class p extends q {

    /* renamed from: a */
    final /* synthetic */ Intent f3047a;

    /* renamed from: b */
    final /* synthetic */ p1.e f3048b;

    public p(Intent intent, p1.e eVar, int i2) {
        this.f3047a = intent;
        this.f3048b = eVar;
    }

    @Override // q1.q
    public final void a() {
        Intent intent = this.f3047a;
        if (intent != null) {
            this.f3048b.startActivityForResult(intent, 2);
        }
    }
}
