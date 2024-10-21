package a;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class a extends e implements Map {

    /* renamed from: h */
    d f0h;

    /* renamed from: a.a$a */
    /* loaded from: classes.dex */
    public class C0000a extends d {
        C0000a() {
        }

        @Override // a.d
        protected void a() {
            a.this.clear();
        }

        @Override // a.d
        protected Object b(int i2, int i3) {
            return a.this.f36b[(i2 << 1) + i3];
        }

        @Override // a.d
        protected Map c() {
            return a.this;
        }

        @Override // a.d
        protected int d() {
            return a.this.f37c;
        }

        @Override // a.d
        protected int e(Object obj) {
            return a.this.f(obj);
        }

        @Override // a.d
        protected int f(Object obj) {
            return a.this.h(obj);
        }

        @Override // a.d
        protected void g(Object obj, Object obj2) {
            a.this.put(obj, obj2);
        }

        @Override // a.d
        protected void h(int i2) {
            a.this.j(i2);
        }

        @Override // a.d
        protected Object i(int i2, Object obj) {
            return a.this.k(i2, obj);
        }
    }

    public a() {
    }

    public a(int i2) {
        super(i2);
    }

    private d m() {
        if (this.f0h == null) {
            this.f0h = new C0000a();
        }
        return this.f0h;
    }

    @Override // java.util.Map
    public Set entrySet() {
        return m().l();
    }

    @Override // java.util.Map
    public Set keySet() {
        return m().m();
    }

    @Override // java.util.Map
    public void putAll(Map map) {
        c(this.f37c + map.size());
        for (Map.Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public Collection values() {
        return m().n();
    }
}
