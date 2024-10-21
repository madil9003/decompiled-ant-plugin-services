package a;

import java.util.ConcurrentModificationException;
import java.util.Map;

/* loaded from: classes.dex */
public class e {

    /* renamed from: d */
    static Object[] f31d;

    /* renamed from: e */
    static int f32e;

    /* renamed from: f */
    static Object[] f33f;

    /* renamed from: g */
    static int f34g;

    /* renamed from: a */
    int[] f35a;

    /* renamed from: b */
    Object[] f36b;

    /* renamed from: c */
    int f37c;

    public e() {
        this.f35a = c.f13a;
        this.f36b = c.f15c;
        this.f37c = 0;
    }

    private void a(int i2) {
        if (i2 == 8) {
            synchronized (a.class) {
                Object[] objArr = f33f;
                if (objArr != null) {
                    this.f36b = objArr;
                    f33f = (Object[]) objArr[0];
                    this.f35a = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f34g--;
                    return;
                }
            }
        } else if (i2 == 4) {
            synchronized (a.class) {
                Object[] objArr2 = f31d;
                if (objArr2 != null) {
                    this.f36b = objArr2;
                    f31d = (Object[]) objArr2[0];
                    this.f35a = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    f32e--;
                    return;
                }
            }
        }
        this.f35a = new int[i2];
        this.f36b = new Object[i2 << 1];
    }

    private static int b(int[] iArr, int i2, int i3) {
        try {
            return c.a(iArr, i2, i3);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    private static void d(int[] iArr, Object[] objArr, int i2) {
        if (iArr.length == 8) {
            synchronized (a.class) {
                if (f34g < 10) {
                    objArr[0] = f33f;
                    objArr[1] = iArr;
                    for (int i3 = (i2 << 1) - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    f33f = objArr;
                    f34g++;
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (a.class) {
                if (f32e < 10) {
                    objArr[0] = f31d;
                    objArr[1] = iArr;
                    for (int i4 = (i2 << 1) - 1; i4 >= 2; i4--) {
                        objArr[i4] = null;
                    }
                    f31d = objArr;
                    f32e++;
                }
            }
        }
    }

    public void c(int i2) {
        int i3 = this.f37c;
        int[] iArr = this.f35a;
        if (iArr.length < i2) {
            Object[] objArr = this.f36b;
            a(i2);
            if (this.f37c > 0) {
                System.arraycopy(iArr, 0, this.f35a, 0, i3);
                System.arraycopy(objArr, 0, this.f36b, 0, i3 << 1);
            }
            d(iArr, objArr, i3);
        }
        if (this.f37c != i3) {
            throw new ConcurrentModificationException();
        }
    }

    public void clear() {
        int i2 = this.f37c;
        if (i2 > 0) {
            int[] iArr = this.f35a;
            Object[] objArr = this.f36b;
            this.f35a = c.f13a;
            this.f36b = c.f15c;
            this.f37c = 0;
            d(iArr, objArr, i2);
        }
        if (this.f37c > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        return f(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return h(obj) >= 0;
    }

    int e(Object obj, int i2) {
        int i3 = this.f37c;
        if (i3 == 0) {
            return -1;
        }
        int b3 = b(this.f35a, i3, i2);
        if (b3 < 0 || obj.equals(this.f36b[b3 << 1])) {
            return b3;
        }
        int i4 = b3 + 1;
        while (i4 < i3 && this.f35a[i4] == i2) {
            if (obj.equals(this.f36b[i4 << 1])) {
                return i4;
            }
            i4++;
        }
        for (int i5 = b3 - 1; i5 >= 0 && this.f35a[i5] == i2; i5--) {
            if (obj.equals(this.f36b[i5 << 1])) {
                return i5;
            }
        }
        return ~i4;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            if (size() != eVar.size()) {
                return false;
            }
            for (int i2 = 0; i2 < this.f37c; i2++) {
                try {
                    Object i3 = i(i2);
                    Object l2 = l(i2);
                    Object obj2 = eVar.get(i3);
                    if (l2 == null) {
                        if (obj2 != null || !eVar.containsKey(i3)) {
                            return false;
                        }
                    } else if (!l2.equals(obj2)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                    return false;
                }
            }
            return true;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (size() != map.size()) {
                return false;
            }
            for (int i4 = 0; i4 < this.f37c; i4++) {
                try {
                    Object i5 = i(i4);
                    Object l3 = l(i4);
                    Object obj3 = map.get(i5);
                    if (l3 == null) {
                        if (obj3 != null || !map.containsKey(i5)) {
                            return false;
                        }
                    } else if (!l3.equals(obj3)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused2) {
                }
            }
            return true;
        }
        return false;
    }

    public int f(Object obj) {
        return obj == null ? g() : e(obj, obj.hashCode());
    }

    int g() {
        int i2 = this.f37c;
        if (i2 == 0) {
            return -1;
        }
        int b3 = b(this.f35a, i2, 0);
        if (b3 < 0 || this.f36b[b3 << 1] == null) {
            return b3;
        }
        int i3 = b3 + 1;
        while (i3 < i2 && this.f35a[i3] == 0) {
            if (this.f36b[i3 << 1] == null) {
                return i3;
            }
            i3++;
        }
        for (int i4 = b3 - 1; i4 >= 0 && this.f35a[i4] == 0; i4--) {
            if (this.f36b[i4 << 1] == null) {
                return i4;
            }
        }
        return ~i3;
    }

    public Object get(Object obj) {
        int f3 = f(obj);
        if (f3 >= 0) {
            return this.f36b[(f3 << 1) + 1];
        }
        return null;
    }

    public int h(Object obj) {
        int i2 = this.f37c * 2;
        Object[] objArr = this.f36b;
        if (obj == null) {
            for (int i3 = 1; i3 < i2; i3 += 2) {
                if (objArr[i3] == null) {
                    return i3 >> 1;
                }
            }
            return -1;
        }
        for (int i4 = 1; i4 < i2; i4 += 2) {
            if (obj.equals(objArr[i4])) {
                return i4 >> 1;
            }
        }
        return -1;
    }

    public int hashCode() {
        int[] iArr = this.f35a;
        Object[] objArr = this.f36b;
        int i2 = this.f37c;
        int i3 = 1;
        int i4 = 0;
        int i5 = 0;
        while (i4 < i2) {
            Object obj = objArr[i3];
            i5 += (obj == null ? 0 : obj.hashCode()) ^ iArr[i4];
            i4++;
            i3 += 2;
        }
        return i5;
    }

    public Object i(int i2) {
        return this.f36b[i2 << 1];
    }

    public boolean isEmpty() {
        return this.f37c <= 0;
    }

    public Object j(int i2) {
        Object[] objArr = this.f36b;
        int i3 = i2 << 1;
        Object obj = objArr[i3 + 1];
        int i4 = this.f37c;
        int i5 = 0;
        if (i4 <= 1) {
            d(this.f35a, objArr, i4);
            this.f35a = c.f13a;
            this.f36b = c.f15c;
        } else {
            int i6 = i4 - 1;
            int[] iArr = this.f35a;
            if (iArr.length <= 8 || i4 >= iArr.length / 3) {
                if (i2 < i6) {
                    int i7 = i2 + 1;
                    int i8 = i6 - i2;
                    System.arraycopy(iArr, i7, iArr, i2, i8);
                    Object[] objArr2 = this.f36b;
                    System.arraycopy(objArr2, i7 << 1, objArr2, i3, i8 << 1);
                }
                Object[] objArr3 = this.f36b;
                int i9 = i6 << 1;
                objArr3[i9] = null;
                objArr3[i9 + 1] = null;
            } else {
                a(i4 > 8 ? i4 + (i4 >> 1) : 8);
                if (i4 != this.f37c) {
                    throw new ConcurrentModificationException();
                }
                if (i2 > 0) {
                    System.arraycopy(iArr, 0, this.f35a, 0, i2);
                    System.arraycopy(objArr, 0, this.f36b, 0, i3);
                }
                if (i2 < i6) {
                    int i10 = i2 + 1;
                    int i11 = i6 - i2;
                    System.arraycopy(iArr, i10, this.f35a, i2, i11);
                    System.arraycopy(objArr, i10 << 1, this.f36b, i3, i11 << 1);
                }
            }
            i5 = i6;
        }
        if (i4 != this.f37c) {
            throw new ConcurrentModificationException();
        }
        this.f37c = i5;
        return obj;
    }

    public Object k(int i2, Object obj) {
        int i3 = (i2 << 1) + 1;
        Object[] objArr = this.f36b;
        Object obj2 = objArr[i3];
        objArr[i3] = obj;
        return obj2;
    }

    public Object l(int i2) {
        return this.f36b[(i2 << 1) + 1];
    }

    public Object put(Object obj, Object obj2) {
        int i2;
        int e3;
        int i3 = this.f37c;
        if (obj == null) {
            e3 = g();
            i2 = 0;
        } else {
            int hashCode = obj.hashCode();
            i2 = hashCode;
            e3 = e(obj, hashCode);
        }
        if (e3 >= 0) {
            int i4 = (e3 << 1) + 1;
            Object[] objArr = this.f36b;
            Object obj3 = objArr[i4];
            objArr[i4] = obj2;
            return obj3;
        }
        int i5 = ~e3;
        int[] iArr = this.f35a;
        if (i3 >= iArr.length) {
            int i6 = 8;
            if (i3 >= 8) {
                i6 = (i3 >> 1) + i3;
            } else if (i3 < 4) {
                i6 = 4;
            }
            Object[] objArr2 = this.f36b;
            a(i6);
            if (i3 != this.f37c) {
                throw new ConcurrentModificationException();
            }
            int[] iArr2 = this.f35a;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr2, 0, this.f36b, 0, objArr2.length);
            }
            d(iArr, objArr2, i3);
        }
        if (i5 < i3) {
            int[] iArr3 = this.f35a;
            int i7 = i5 + 1;
            System.arraycopy(iArr3, i5, iArr3, i7, i3 - i5);
            Object[] objArr3 = this.f36b;
            System.arraycopy(objArr3, i5 << 1, objArr3, i7 << 1, (this.f37c - i5) << 1);
        }
        int i8 = this.f37c;
        if (i3 == i8) {
            int[] iArr4 = this.f35a;
            if (i5 < iArr4.length) {
                iArr4[i5] = i2;
                Object[] objArr4 = this.f36b;
                int i9 = i5 << 1;
                objArr4[i9] = obj;
                objArr4[i9 + 1] = obj2;
                this.f37c = i8 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public Object remove(Object obj) {
        int f3 = f(obj);
        if (f3 >= 0) {
            return j(f3);
        }
        return null;
    }

    public int size() {
        return this.f37c;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f37c * 28);
        sb.append('{');
        for (int i2 = 0; i2 < this.f37c; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            Object i3 = i(i2);
            if (i3 != this) {
                sb.append(i3);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            Object l2 = l(i2);
            if (l2 != this) {
                sb.append(l2);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public e(int i2) {
        if (i2 == 0) {
            this.f35a = c.f13a;
            this.f36b = c.f15c;
        } else {
            a(i2);
        }
        this.f37c = 0;
    }
}
