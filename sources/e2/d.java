package e2;

import com.google.android.gms.common.api.Scope;
import o1.a;

/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a */
    public static final a.g f1678a;

    /* renamed from: b */
    public static final a.g f1679b;

    /* renamed from: c */
    public static final a.AbstractC0046a f1680c;

    /* renamed from: d */
    static final a.AbstractC0046a f1681d;

    /* renamed from: e */
    public static final Scope f1682e;

    /* renamed from: f */
    public static final Scope f1683f;

    /* renamed from: g */
    public static final o1.a f1684g;

    /* renamed from: h */
    public static final o1.a f1685h;

    static {
        a.g gVar = new a.g();
        f1678a = gVar;
        a.g gVar2 = new a.g();
        f1679b = gVar2;
        b bVar = new b();
        f1680c = bVar;
        c cVar = new c();
        f1681d = cVar;
        f1682e = new Scope("profile");
        f1683f = new Scope("email");
        f1684g = new o1.a("SignIn.API", bVar, gVar);
        f1685h = new o1.a("SignIn.INTERNAL_API", cVar, gVar2);
    }
}
