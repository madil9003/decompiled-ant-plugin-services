package o1;

import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.internal.l;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import o1.a;
import p1.j;
import p1.n;
import p1.v;
import q1.b;

/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a */
    private final Context f2844a;

    /* renamed from: b */
    private final String f2845b;

    /* renamed from: c */
    private final o1.a f2846c;

    /* renamed from: d */
    private final a.d f2847d;

    /* renamed from: e */
    private final p1.b f2848e;

    /* renamed from: f */
    private final Looper f2849f;

    /* renamed from: g */
    private final int f2850g;

    /* renamed from: h */
    private final e f2851h;

    /* renamed from: i */
    private final j f2852i;

    /* renamed from: j */
    protected final com.google.android.gms.common.api.internal.b f2853j;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: c */
        public static final a f2854c = new C0047a().a();

        /* renamed from: a */
        public final j f2855a;

        /* renamed from: b */
        public final Looper f2856b;

        /* renamed from: o1.d$a$a */
        /* loaded from: classes.dex */
        public static class C0047a {

            /* renamed from: a */
            private j f2857a;

            /* renamed from: b */
            private Looper f2858b;

            public a a() {
                if (this.f2857a == null) {
                    this.f2857a = new p1.a();
                }
                if (this.f2858b == null) {
                    this.f2858b = Looper.getMainLooper();
                }
                return new a(this.f2857a, this.f2858b);
            }
        }

        private a(j jVar, Account account, Looper looper) {
            this.f2855a = jVar;
            this.f2856b = looper;
        }

        /* synthetic */ a(j jVar, Account account, Looper looper, h hVar) {
            this(jVar, null, looper);
        }
    }

    private d(Context context, Activity activity, o1.a aVar, a.d dVar, a aVar2) {
        q1.f.h(context, "Null context is not permitted.");
        q1.f.h(aVar, "Api must not be null.");
        q1.f.h(aVar2, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        this.f2844a = context.getApplicationContext();
        String str = null;
        if (u1.f.i()) {
            try {
                str = (String) Context.class.getMethod("getAttributionTag", new Class[0]).invoke(context, new Object[0]);
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            }
        }
        this.f2845b = str;
        this.f2846c = aVar;
        this.f2847d = dVar;
        this.f2849f = aVar2.f2856b;
        p1.b a3 = p1.b.a(aVar, dVar, str);
        this.f2848e = a3;
        this.f2851h = new n(this);
        com.google.android.gms.common.api.internal.b x2 = com.google.android.gms.common.api.internal.b.x(this.f2844a);
        this.f2853j = x2;
        this.f2850g = x2.m();
        this.f2852i = aVar2.f2855a;
        if (activity != null && !(activity instanceof GoogleApiActivity) && Looper.myLooper() == Looper.getMainLooper()) {
            com.google.android.gms.common.api.internal.f.u(activity, x2, a3);
        }
        x2.b(this);
    }

    private final g2.d i(int i2, com.google.android.gms.common.api.internal.c cVar) {
        g2.e eVar = new g2.e();
        this.f2853j.D(this, i2, cVar, eVar, this.f2852i);
        return eVar.a();
    }

    protected b.a b() {
        b.a aVar = new b.a();
        aVar.d(null);
        aVar.c(Collections.emptySet());
        aVar.e(this.f2844a.getClass().getName());
        aVar.b(this.f2844a.getPackageName());
        return aVar;
    }

    public g2.d c(com.google.android.gms.common.api.internal.c cVar) {
        return i(2, cVar);
    }

    public final p1.b d() {
        return this.f2848e;
    }

    protected String e() {
        return this.f2845b;
    }

    public final int f() {
        return this.f2850g;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final a.f g(Looper looper, l lVar) {
        a.f a3 = ((a.AbstractC0046a) q1.f.g(this.f2846c.a())).a(this.f2844a, looper, b().a(), this.f2847d, lVar, lVar);
        String e3 = e();
        if (e3 != null && (a3 instanceof com.google.android.gms.common.internal.b)) {
            ((com.google.android.gms.common.internal.b) a3).O(e3);
        }
        if (e3 == null || !(a3 instanceof p1.g)) {
            return a3;
        }
        throw null;
    }

    public final v h(Context context, Handler handler) {
        return new v(context, handler, b().a());
    }

    public d(Context context, o1.a aVar, a.d dVar, a aVar2) {
        this(context, null, aVar, dVar, aVar2);
    }
}
