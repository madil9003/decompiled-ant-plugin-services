package o1;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.b;
import java.util.Set;
import o1.e;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a */
    private final AbstractC0046a f2840a;

    /* renamed from: b */
    private final g f2841b;

    /* renamed from: c */
    private final String f2842c;

    /* renamed from: o1.a$a */
    /* loaded from: classes.dex */
    public static abstract class AbstractC0046a extends e {
        public f a(Context context, Looper looper, q1.b bVar, Object obj, e.a aVar, e.b bVar2) {
            return b(context, looper, bVar, obj, aVar, bVar2);
        }

        public f b(Context context, Looper looper, q1.b bVar, Object obj, p1.c cVar, p1.h hVar) {
            throw new UnsupportedOperationException("buildClient must be implemented");
        }
    }

    /* loaded from: classes.dex */
    public interface b {
    }

    /* loaded from: classes.dex */
    public static class c {
    }

    /* loaded from: classes.dex */
    public interface d {
    }

    /* loaded from: classes.dex */
    public static abstract class e {
    }

    /* loaded from: classes.dex */
    public interface f extends b {
        boolean b();

        void c(b.e eVar);

        void d(b.c cVar);

        boolean e();

        Feature[] f();

        String g();

        boolean h();

        void i();

        void k(String str);

        String l();

        Set m();

        boolean n();

        void o(com.google.android.gms.common.internal.e eVar, Set set);

        int p();
    }

    /* loaded from: classes.dex */
    public static final class g extends c {
    }

    public a(String str, AbstractC0046a abstractC0046a, g gVar) {
        q1.f.h(abstractC0046a, "Cannot construct an Api with a null ClientBuilder");
        q1.f.h(gVar, "Cannot construct an Api with a null ClientKey");
        this.f2842c = str;
        this.f2840a = abstractC0046a;
        this.f2841b = gVar;
    }

    public final AbstractC0046a a() {
        return this.f2840a;
    }

    public final String b() {
        return this.f2842c;
    }
}
