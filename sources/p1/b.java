package p1;

import o1.a;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a */
    private final int f2962a;

    /* renamed from: b */
    private final o1.a f2963b;

    /* renamed from: c */
    private final a.d f2964c;

    /* renamed from: d */
    private final String f2965d;

    private b(o1.a aVar, a.d dVar, String str) {
        this.f2963b = aVar;
        this.f2964c = dVar;
        this.f2965d = str;
        this.f2962a = q1.e.b(aVar, dVar, str);
    }

    public static b a(o1.a aVar, a.d dVar, String str) {
        return new b(aVar, dVar, str);
    }

    public final String b() {
        return this.f2963b.b();
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return q1.e.a(this.f2963b, bVar.f2963b) && q1.e.a(this.f2964c, bVar.f2964c) && q1.e.a(this.f2965d, bVar.f2965d);
    }

    public final int hashCode() {
        return this.f2962a;
    }
}
