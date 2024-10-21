package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.b;
import com.google.android.gms.common.internal.zat;
import o1.e;
import q1.f;

/* loaded from: classes.dex */
public class a extends com.google.android.gms.common.internal.c implements e2.e {
    public static final /* synthetic */ int M = 0;
    private final boolean I;
    private final q1.b J;
    private final Bundle K;
    private final Integer L;

    public a(Context context, Looper looper, boolean z2, q1.b bVar, Bundle bundle, e.a aVar, e.b bVar2) {
        super(context, looper, 44, bVar, aVar, bVar2);
        this.I = true;
        this.J = bVar;
        this.K = bundle;
        this.L = bVar.g();
    }

    public static Bundle j0(q1.b bVar) {
        bVar.f();
        Integer g3 = bVar.g();
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", bVar.a());
        if (g3 != null) {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", g3.intValue());
        }
        bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", false);
        bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", false);
        bundle.putString("com.google.android.gms.signin.internal.serverClientId", null);
        bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
        bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", false);
        bundle.putString("com.google.android.gms.signin.internal.hostedDomain", null);
        bundle.putString("com.google.android.gms.signin.internal.logSessionId", null);
        bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", false);
        return bundle;
    }

    @Override // com.google.android.gms.common.internal.b
    public final String D() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    @Override // com.google.android.gms.common.internal.b
    protected final String E() {
        return "com.google.android.gms.signin.service.START";
    }

    @Override // e2.e
    public final void a() {
        d(new b.d());
    }

    @Override // e2.e
    public final void j(f2.c cVar) {
        f.h(cVar, "Expecting a valid ISignInCallbacks");
        try {
            Account b3 = this.J.b();
            ((c) C()).F(new zai(1, new zat(b3, ((Integer) f.g(this.L)).intValue(), "<<default account>>".equals(b3.name) ? l1.a.a(x()).b() : null)), cVar);
        } catch (RemoteException e3) {
            Log.w("SignInClientImpl", "Remote service probably died when signIn is called");
            try {
                cVar.n(new zak(1, new ConnectionResult(8, null), null));
            } catch (RemoteException unused) {
                Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", e3);
            }
        }
    }

    @Override // com.google.android.gms.common.internal.b, o1.a.f
    public final boolean n() {
        return this.I;
    }

    @Override // com.google.android.gms.common.internal.b, o1.a.f
    public final int p() {
        return com.google.android.gms.common.d.f1318a;
    }

    @Override // com.google.android.gms.common.internal.b
    public final /* synthetic */ IInterface r(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
        return queryLocalInterface instanceof c ? (c) queryLocalInterface : new c(iBinder);
    }

    @Override // com.google.android.gms.common.internal.b
    protected final Bundle z() {
        if (!x().getPackageName().equals(this.J.d())) {
            this.K.putString("com.google.android.gms.signin.internal.realClientPackageName", this.J.d());
        }
        return this.K;
    }
}
