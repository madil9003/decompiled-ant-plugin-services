package a;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class b implements Collection, Set {

    /* renamed from: e */
    private static final int[] f2e = new int[0];

    /* renamed from: f */
    private static final Object[] f3f = new Object[0];

    /* renamed from: g */
    private static Object[] f4g;

    /* renamed from: h */
    private static int f5h;

    /* renamed from: i */
    private static Object[] f6i;

    /* renamed from: j */
    private static int f7j;

    /* renamed from: a */
    private int[] f8a;

    /* renamed from: b */
    Object[] f9b;

    /* renamed from: c */
    int f10c;

    /* renamed from: d */
    private d f11d;

    /* loaded from: classes.dex */
    public class a extends d {
        a() {
        }

        @Override // a.d
        protected void a() {
            b.this.clear();
        }

        @Override // a.d
        protected Object b(int i2, int i3) {
            return b.this.f9b[i2];
        }

        @Override // a.d
        protected Map c() {
            throw new UnsupportedOperationException("not a map");
        }

        @Override // a.d
        protected int d() {
            return b.this.f10c;
        }

        @Override // a.d
        protected int e(Object obj) {
            return b.this.e(obj);
        }

        @Override // a.d
        protected int f(Object obj) {
            return b.this.e(obj);
        }

        @Override // a.d
        protected void g(Object obj, Object obj2) {
            b.this.add(obj);
        }

        @Override // a.d
        protected void h(int i2) {
            b.this.h(i2);
        }

        @Override // a.d
        protected Object i(int i2, Object obj) {
            throw new UnsupportedOperationException("not a map");
        }
    }

    public b() {
        this(0);
    }

    private void a(int i2) {
        if (i2 == 8) {
            synchronized (b.class) {
                Object[] objArr = f6i;
                if (objArr != null) {
                    this.f9b = objArr;
                    f6i = (Object[]) objArr[0];
                    this.f8a = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f7j--;
                    return;
                }
            }
        } else if (i2 == 4) {
            synchronized (b.class) {
                Object[] objArr2 = f4g;
                if (objArr2 != null) {
                    this.f9b = objArr2;
                    f4g = (Object[]) objArr2[0];
                    this.f8a = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    f5h--;
                    return;
                }
            }
        }
        this.f8a = new int[i2];
        this.f9b = new Object[i2];
    }

    private static void c(int[] iArr, Object[] objArr, int i2) {
        if (iArr.length == 8) {
            synchronized (b.class) {
                if (f7j < 10) {
                    objArr[0] = f6i;
                    objArr[1] = iArr;
                    for (int i3 = i2 - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    f6i = objArr;
                    f7j++;
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (b.class) {
                if (f5h < 10) {
                    objArr[0] = f4g;
                    objArr[1] = iArr;
                    for (int i4 = i2 - 1; i4 >= 2; i4--) {
                        objArr[i4] = null;
                    }
                    f4g = objArr;
                    f5h++;
                }
            }
        }
    }

    private d d() {
        if (this.f11d == null) {
            this.f11d = new a();
        }
        return this.f11d;
    }

    private int f(Object obj, int i2) {
        int i3 = this.f10c;
        if (i3 == 0) {
            return -1;
        }
        int a3 = c.a(this.f8a, i3, i2);
        if (a3 < 0 || obj.equals(this.f9b[a3])) {
            return a3;
        }
        int i4 = a3 + 1;
        while (i4 < i3 && this.f8a[i4] == i2) {
            if (obj.equals(this.f9b[i4])) {
                return i4;
            }
            i4++;
        }
        for (int i5 = a3 - 1; i5 >= 0 && this.f8a[i5] == i2; i5--) {
            if (obj.equals(this.f9b[i5])) {
                return i5;
            }
        }
        return ~i4;
    }

    private int g() {
        int i2 = this.f10c;
        if (i2 == 0) {
            return -1;
        }
        int a3 = c.a(this.f8a, i2, 0);
        if (a3 < 0 || this.f9b[a3] == null) {
            return a3;
        }
        int i3 = a3 + 1;
        while (i3 < i2 && this.f8a[i3] == 0) {
            if (this.f9b[i3] == null) {
                return i3;
            }
            i3++;
        }
        for (int i4 = a3 - 1; i4 >= 0 && this.f8a[i4] == 0; i4--) {
            if (this.f9b[i4] == null) {
                return i4;
            }
        }
        return ~i3;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(Object obj) {
        int i2;
        int f3;
        if (obj == null) {
            f3 = g();
            i2 = 0;
        } else {
            int hashCode = obj.hashCode();
            i2 = hashCode;
            f3 = f(obj, hashCode);
        }
        if (f3 >= 0) {
            return false;
        }
        int i3 = ~f3;
        int i4 = this.f10c;
        int[] iArr = this.f8a;
        if (i4 >= iArr.length) {
            int i5 = 8;
            if (i4 >= 8) {
                i5 = (i4 >> 1) + i4;
            } else if (i4 < 4) {
                i5 = 4;
            }
            Object[] objArr = this.f9b;
            a(i5);
            int[] iArr2 = this.f8a;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.f9b, 0, objArr.length);
            }
            c(iArr, objArr, this.f10c);
        }
        int i6 = this.f10c;
        if (i3 < i6) {
            int[] iArr3 = this.f8a;
            int i7 = i3 + 1;
            System.arraycopy(iArr3, i3, iArr3, i7, i6 - i3);
            Object[] objArr2 = this.f9b;
            System.arraycopy(objArr2, i3, objArr2, i7, this.f10c - i3);
        }
        this.f8a[i3] = i2;
        this.f9b[i3] = obj;
        this.f10c++;
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(Collection collection) {
        b(this.f10c + collection.size());
        Iterator it = collection.iterator();
        boolean z2 = false;
        while (it.hasNext()) {
            z2 |= add(it.next());
        }
        return z2;
    }

    public void b(int i2) {
        int[] iArr = this.f8a;
        if (iArr.length < i2) {
            Object[] objArr = this.f9b;
            a(i2);
            int i3 = this.f10c;
            if (i3 > 0) {
                System.arraycopy(iArr, 0, this.f8a, 0, i3);
                System.arraycopy(objArr, 0, this.f9b, 0, this.f10c);
            }
            c(iArr, objArr, this.f10c);
        }
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        int i2 = this.f10c;
        if (i2 != 0) {
            c(this.f8a, this.f9b, i2);
            this.f8a = f2e;
            this.f9b = f3f;
            this.f10c = 0;
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return e(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public int e(Object obj) {
        return obj == null ? g() : f(obj, obj.hashCode());
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (size() != set.size()) {
                return false;
            }
            for (int i2 = 0; i2 < this.f10c; i2++) {
                try {
                    if (!set.contains(i(i2))) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    public Object h(int i2) {
        Object[] objArr = this.f9b;
        Object obj = objArr[i2];
        int i3 = this.f10c;
        if (i3 <= 1) {
            c(this.f8a, objArr, i3);
            this.f8a = f2e;
            this.f9b = f3f;
            this.f10c = 0;
        } else {
            int[] iArr = this.f8a;
            if (iArr.length <= 8 || i3 >= iArr.length / 3) {
                int i4 = i3 - 1;
                this.f10c = i4;
                if (i2 < i4) {
                    int i5 = i2 + 1;
                    System.arraycopy(iArr, i5, iArr, i2, i4 - i2);
                    Object[] objArr2 = this.f9b;
                    System.arraycopy(objArr2, i5, objArr2, i2, this.f10c - i2);
                }
                this.f9b[this.f10c] = null;
            } else {
                a(i3 > 8 ? i3 + (i3 >> 1) : 8);
                this.f10c--;
                if (i2 > 0) {
                    System.arraycopy(iArr, 0, this.f8a, 0, i2);
                    System.arraycopy(objArr, 0, this.f9b, 0, i2);
                }
                int i6 = this.f10c;
                if (i2 < i6) {
                    int i7 = i2 + 1;
                    System.arraycopy(iArr, i7, this.f8a, i2, i6 - i2);
                    System.arraycopy(objArr, i7, this.f9b, i2, this.f10c - i2);
                }
            }
        }
        return obj;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        int[] iArr = this.f8a;
        int i2 = this.f10c;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            i3 += iArr[i4];
        }
        return i3;
    }

    public Object i(int i2) {
        return this.f9b[i2];
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f10c <= 0;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator iterator() {
        return d().m().iterator();
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        int e3 = e(obj);
        if (e3 < 0) {
            return false;
        }
        h(e3);
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(Collection collection) {
        Iterator it = collection.iterator();
        boolean z2 = false;
        while (it.hasNext()) {
            z2 |= remove(it.next());
        }
        return z2;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(Collection collection) {
        boolean z2 = false;
        for (int i2 = this.f10c - 1; i2 >= 0; i2--) {
            if (!collection.contains(this.f9b[i2])) {
                h(i2);
                z2 = true;
            }
        }
        return z2;
    }

    @Override // java.util.Collection, java.util.Set
    public int size() {
        return this.f10c;
    }

    @Override // java.util.Collection, java.util.Set
    public Object[] toArray() {
        int i2 = this.f10c;
        Object[] objArr = new Object[i2];
        System.arraycopy(this.f9b, 0, objArr, 0, i2);
        return objArr;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f10c * 14);
        sb.append('{');
        for (int i2 = 0; i2 < this.f10c; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            Object i3 = i(i2);
            if (i3 != this) {
                sb.append(i3);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public b(int i2) {
        if (i2 == 0) {
            this.f8a = f2e;
            this.f9b = f3f;
        } else {
            a(i2);
        }
        this.f10c = 0;
    }

    @Override // java.util.Collection, java.util.Set
    public Object[] toArray(Object[] objArr) {
        if (objArr.length < this.f10c) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), this.f10c);
        }
        System.arraycopy(this.f9b, 0, objArr, 0, this.f10c);
        int length = objArr.length;
        int i2 = this.f10c;
        if (length > i2) {
            objArr[i2] = null;
        }
        return objArr;
    }
}
