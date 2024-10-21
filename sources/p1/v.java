package p1;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.zav;
import com.google.android.gms.signin.internal.zak;
import java.util.Set;
import o1.a;
import o1.e;

/* loaded from: classes.dex */
public final class v extends f2.a implements e.a, e.b {

    /* renamed from: h */
    private static final a.AbstractC0046a f2978h = e2.d.f1680c;

    /* renamed from: a */
    private final Context f2979a;

    /* renamed from: b */
    private final Handler f2980b;

    /* renamed from: c */
    private final a.AbstractC0046a f2981c;

    /* renamed from: d */
    private final Set f2982d;

    /* renamed from: e */
    private final q1.b f2983e;

    /* renamed from: f */
    private e2.e f2984f;

    /* renamed from: g */
    private u f2985g;

    public v(Context context, Handler handler, q1.b bVar) {
        a.AbstractC0046a abstractC0046a = f2978h;
        this.f2979a = context;
        this.f2980b = handler;
        this.f2983e = (q1.b) q1.f.h(bVar, "ClientSettings must not be null");
        this.f2982d = bVar.e();
        this.f2981c = abstractC0046a;
    }

    public static /* bridge */ /* synthetic */ void H(v vVar, zak zakVar) {
        ConnectionResult a3 = zakVar.a();
        if (a3.e()) {
            zav zavVar = (zav) q1.f.g(zakVar.b());
            a3 = zavVar.a();
            if (a3.e()) {
                vVar.f2985g.b(zavVar.b(), vVar.f2982d);
                vVar.f2984f.i();
            } else {
                String valueOf = String.valueOf(a3);
                Log.wtf("SignInCoordinator", "Sign-in succeeded with resolve account failure: ".concat(valueOf), new Exception());
            }
        }
        vVar.f2985g.a(a3);
        vVar.f2984f.i();
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [o1.a$f, e2.e] */
    public final void I(u uVar) {
        e2.e eVar = this.f2984f;
        if (eVar != null) {
            eVar.i();
        }
        this.f2983e.i(Integer.valueOf(System.identityHashCode(this)));
        a.AbstractC0046a abstractC0046a = this.f2981c;
        Context context = this.f2979a;
        Looper looper = this.f2980b.getLooper();
        q1.b bVar = this.f2983e;
        this.f2984f = abstractC0046a.a(context, looper, bVar, bVar.f(), this, this);
        this.f2985g = uVar;
        Set set = this.f2982d;
        if (set == null || set.isEmpty()) {
            this.f2980b.post(new s(this));
        } else {
            this.f2984f.a();
        }
    }

    public final void J() {
        e2.e eVar = this.f2984f;
        if (eVar != null) {
            eVar.i();
        }
    }

    @Override // p1.c
    public final void a(int i2) {
        this.f2984f.i();
    }

    @Override // p1.h
    public final void c(ConnectionResult connectionResult) {
        this.f2985g.a(connectionResult);
    }

    @Override // p1.c
    public final void j(Bundle bundle) {
        this.f2984f.j(this);
    }

    @Override // f2.c
    public final void n(zak zakVar) {
        this.f2980b.post(new t(this, zakVar));
    }
}
