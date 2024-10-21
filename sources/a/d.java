package a;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a */
    b f16a;

    /* renamed from: b */
    c f17b;

    /* renamed from: c */
    e f18c;

    /* loaded from: classes.dex */
    final class a implements Iterator {

        /* renamed from: a */
        final int f19a;

        /* renamed from: b */
        int f20b;

        /* renamed from: c */
        int f21c;

        /* renamed from: d */
        boolean f22d = false;

        a(int i2) {
            this.f19a = i2;
            this.f20b = d.this.d();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f21c < this.f20b;
        }

        @Override // java.util.Iterator
        public Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Object b3 = d.this.b(this.f21c, this.f19a);
            this.f21c++;
            this.f22d = true;
            return b3;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.f22d) {
                throw new IllegalStateException();
            }
            int i2 = this.f21c - 1;
            this.f21c = i2;
            this.f20b--;
            this.f22d = false;
            d.this.h(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class b implements Set {
        b() {
        }

        @Override // java.util.Set, java.util.Collection
        /* renamed from: a */
        public boolean add(Map.Entry entry) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection collection) {
            int d3 = d.this.d();
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                d.this.g(entry.getKey(), entry.getValue());
            }
            return d3 != d.this.d();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            d.this.a();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int e3 = d.this.e(entry.getKey());
            if (e3 < 0) {
                return false;
            }
            return a.c.b(d.this.b(e3, 1), entry.getValue());
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection collection) {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return d.k(this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int i2 = 0;
            for (int d3 = d.this.d() - 1; d3 >= 0; d3--) {
                Object b3 = d.this.b(d3, 0);
                Object b4 = d.this.b(d3, 1);
                i2 += (b3 == null ? 0 : b3.hashCode()) ^ (b4 == null ? 0 : b4.hashCode());
            }
            return i2;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return d.this.d() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return new C0001d();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return d.this.d();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray(Object[] objArr) {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class c implements Set {
        c() {
        }

        @Override // java.util.Set, java.util.Collection
        public boolean add(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            d.this.a();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            return d.this.e(obj) >= 0;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection collection) {
            return d.j(d.this.c(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return d.k(this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int i2 = 0;
            for (int d3 = d.this.d() - 1; d3 >= 0; d3--) {
                Object b3 = d.this.b(d3, 0);
                i2 += b3 == null ? 0 : b3.hashCode();
            }
            return i2;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return d.this.d() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return new a(0);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            int e3 = d.this.e(obj);
            if (e3 < 0) {
                return false;
            }
            d.this.h(e3);
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection collection) {
            return d.o(d.this.c(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection collection) {
            return d.p(d.this.c(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return d.this.d();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            return d.this.q(0);
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray(Object[] objArr) {
            return d.this.r(objArr, 0);
        }
    }

    /* renamed from: a.d$d */
    /* loaded from: classes.dex */
    final class C0001d implements Iterator, Map.Entry {

        /* renamed from: a */
        int f26a;

        /* renamed from: c */
        boolean f28c = false;

        /* renamed from: b */
        int f27b = -1;

        C0001d() {
            this.f26a = d.this.d() - 1;
        }

        @Override // java.util.Iterator
        /* renamed from: a */
        public Map.Entry next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.f27b++;
            this.f28c = true;
            return this;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!this.f28c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return a.c.b(entry.getKey(), d.this.b(this.f27b, 0)) && a.c.b(entry.getValue(), d.this.b(this.f27b, 1));
        }

        @Override // java.util.Map.Entry
        public Object getKey() {
            if (this.f28c) {
                return d.this.b(this.f27b, 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            if (this.f28c) {
                return d.this.b(this.f27b, 1);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f27b < this.f26a;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            if (!this.f28c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            Object b3 = d.this.b(this.f27b, 0);
            Object b4 = d.this.b(this.f27b, 1);
            return (b3 == null ? 0 : b3.hashCode()) ^ (b4 != null ? b4.hashCode() : 0);
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.f28c) {
                throw new IllegalStateException();
            }
            d.this.h(this.f27b);
            this.f27b--;
            this.f26a--;
            this.f28c = false;
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            if (this.f28c) {
                return d.this.i(this.f27b, obj);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public String toString() {
            return getKey() + "=" + getValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class e implements Collection {
        e() {
        }

        @Override // java.util.Collection
        public boolean add(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public boolean addAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public void clear() {
            d.this.a();
        }

        @Override // java.util.Collection
        public boolean contains(Object obj) {
            return d.this.f(obj) >= 0;
        }

        @Override // java.util.Collection
        public boolean containsAll(Collection collection) {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return d.this.d() == 0;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return new a(1);
        }

        @Override // java.util.Collection
        public boolean remove(Object obj) {
            int f3 = d.this.f(obj);
            if (f3 < 0) {
                return false;
            }
            d.this.h(f3);
            return true;
        }

        @Override // java.util.Collection
        public boolean removeAll(Collection collection) {
            int d3 = d.this.d();
            int i2 = 0;
            boolean z2 = false;
            while (i2 < d3) {
                if (collection.contains(d.this.b(i2, 1))) {
                    d.this.h(i2);
                    i2--;
                    d3--;
                    z2 = true;
                }
                i2++;
            }
            return z2;
        }

        @Override // java.util.Collection
        public boolean retainAll(Collection collection) {
            int d3 = d.this.d();
            int i2 = 0;
            boolean z2 = false;
            while (i2 < d3) {
                if (!collection.contains(d.this.b(i2, 1))) {
                    d.this.h(i2);
                    i2--;
                    d3--;
                    z2 = true;
                }
                i2++;
            }
            return z2;
        }

        @Override // java.util.Collection
        public int size() {
            return d.this.d();
        }

        @Override // java.util.Collection
        public Object[] toArray() {
            return d.this.q(1);
        }

        @Override // java.util.Collection
        public Object[] toArray(Object[] objArr) {
            return d.this.r(objArr, 1);
        }
    }

    public static boolean j(Map map, Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!map.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static boolean k(Set set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() == set2.size()) {
                    if (set.containsAll(set2)) {
                        return true;
                    }
                }
                return false;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public static boolean o(Map map, Collection collection) {
        int size = map.size();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            map.remove(it.next());
        }
        return size != map.size();
    }

    public static boolean p(Map map, Collection collection) {
        int size = map.size();
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    protected abstract void a();

    protected abstract Object b(int i2, int i3);

    protected abstract Map c();

    protected abstract int d();

    protected abstract int e(Object obj);

    protected abstract int f(Object obj);

    protected abstract void g(Object obj, Object obj2);

    protected abstract void h(int i2);

    protected abstract Object i(int i2, Object obj);

    public Set l() {
        if (this.f16a == null) {
            this.f16a = new b();
        }
        return this.f16a;
    }

    public Set m() {
        if (this.f17b == null) {
            this.f17b = new c();
        }
        return this.f17b;
    }

    public Collection n() {
        if (this.f18c == null) {
            this.f18c = new e();
        }
        return this.f18c;
    }

    public Object[] q(int i2) {
        int d3 = d();
        Object[] objArr = new Object[d3];
        for (int i3 = 0; i3 < d3; i3++) {
            objArr[i3] = b(i3, i2);
        }
        return objArr;
    }

    public Object[] r(Object[] objArr, int i2) {
        int d3 = d();
        if (objArr.length < d3) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), d3);
        }
        for (int i3 = 0; i3 < d3; i3++) {
            objArr[i3] = b(i3, i2);
        }
        if (objArr.length > d3) {
            objArr[d3] = null;
        }
        return objArr;
    }
}
