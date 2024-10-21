package p1;

import com.google.android.gms.common.ConnectionResult;

/* loaded from: classes.dex */
public final class s implements Runnable {

    /* renamed from: a */
    final /* synthetic */ v f2975a;

    public s(v vVar) {
        this.f2975a = vVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        u uVar;
        uVar = this.f2975a.f2985g;
        uVar.a(new ConnectionResult(4));
    }
}
