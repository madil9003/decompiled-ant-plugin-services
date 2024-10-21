package androidx.versionedparcelable;

import android.os.Parcelable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a */
    protected final a.a f121a;

    /* renamed from: b */
    protected final a.a f122b;

    /* renamed from: c */
    protected final a.a f123c;

    public a(a.a aVar, a.a aVar2, a.a aVar3) {
        this.f121a = aVar;
        this.f122b = aVar2;
        this.f123c = aVar3;
    }

    private void N(e.a aVar) {
        try {
            I(c(aVar.getClass()).getName());
        } catch (ClassNotFoundException e3) {
            throw new RuntimeException(aVar.getClass().getSimpleName() + " does not have a Parcelizer", e3);
        }
    }

    private Class c(Class cls) {
        Class cls2 = (Class) this.f123c.get(cls.getName());
        if (cls2 != null) {
            return cls2;
        }
        Class<?> cls3 = Class.forName(String.format("%s.%sParcelizer", cls.getPackage().getName(), cls.getSimpleName()), false, cls.getClassLoader());
        this.f123c.put(cls.getName(), cls3);
        return cls3;
    }

    private Method d(String str) {
        Method method = (Method) this.f121a.get(str);
        if (method != null) {
            return method;
        }
        System.currentTimeMillis();
        Method declaredMethod = Class.forName(str, true, a.class.getClassLoader()).getDeclaredMethod("read", a.class);
        this.f121a.put(str, declaredMethod);
        return declaredMethod;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Method e(Class cls) {
        Method method = (Method) this.f122b.get(cls.getName());
        if (method != null) {
            return method;
        }
        Class c3 = c(cls);
        System.currentTimeMillis();
        Method declaredMethod = c3.getDeclaredMethod("write", cls, a.class);
        this.f122b.put(cls.getName(), declaredMethod);
        return declaredMethod;
    }

    protected abstract void A(byte[] bArr);

    public void B(byte[] bArr, int i2) {
        w(i2);
        A(bArr);
    }

    protected abstract void C(CharSequence charSequence);

    public void D(CharSequence charSequence, int i2) {
        w(i2);
        C(charSequence);
    }

    protected abstract void E(int i2);

    public void F(int i2, int i3) {
        w(i3);
        E(i2);
    }

    protected abstract void G(Parcelable parcelable);

    public void H(Parcelable parcelable, int i2) {
        w(i2);
        G(parcelable);
    }

    protected abstract void I(String str);

    public void J(String str, int i2) {
        w(i2);
        I(str);
    }

    protected void K(e.a aVar, a aVar2) {
        try {
            e(aVar.getClass()).invoke(null, aVar, aVar2);
        } catch (ClassNotFoundException e3) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e3);
        } catch (IllegalAccessException e4) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e4);
        } catch (NoSuchMethodException e5) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e5);
        } catch (InvocationTargetException e6) {
            if (!(e6.getCause() instanceof RuntimeException)) {
                throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e6);
            }
            throw ((RuntimeException) e6.getCause());
        }
    }

    public void L(e.a aVar) {
        if (aVar == null) {
            I(null);
            return;
        }
        N(aVar);
        a b3 = b();
        K(aVar, b3);
        b3.a();
    }

    public void M(e.a aVar, int i2) {
        w(i2);
        L(aVar);
    }

    protected abstract void a();

    protected abstract a b();

    public boolean f() {
        return false;
    }

    protected abstract boolean g();

    public boolean h(boolean z2, int i2) {
        return !m(i2) ? z2 : g();
    }

    protected abstract byte[] i();

    public byte[] j(byte[] bArr, int i2) {
        return !m(i2) ? bArr : i();
    }

    protected abstract CharSequence k();

    public CharSequence l(CharSequence charSequence, int i2) {
        return !m(i2) ? charSequence : k();
    }

    protected abstract boolean m(int i2);

    protected e.a n(String str, a aVar) {
        try {
            return (e.a) d(str).invoke(null, aVar);
        } catch (ClassNotFoundException e3) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e3);
        } catch (IllegalAccessException e4) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e4);
        } catch (NoSuchMethodException e5) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e5);
        } catch (InvocationTargetException e6) {
            if (e6.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e6.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e6);
        }
    }

    protected abstract int o();

    public int p(int i2, int i3) {
        return !m(i3) ? i2 : o();
    }

    protected abstract Parcelable q();

    public Parcelable r(Parcelable parcelable, int i2) {
        return !m(i2) ? parcelable : q();
    }

    protected abstract String s();

    public String t(String str, int i2) {
        return !m(i2) ? str : s();
    }

    public e.a u() {
        String s2 = s();
        if (s2 == null) {
            return null;
        }
        return n(s2, b());
    }

    public e.a v(e.a aVar, int i2) {
        return !m(i2) ? aVar : u();
    }

    protected abstract void w(int i2);

    public void x(boolean z2, boolean z3) {
    }

    protected abstract void y(boolean z2);

    public void z(boolean z2, int i2) {
        w(i2);
        y(z2);
    }
}
