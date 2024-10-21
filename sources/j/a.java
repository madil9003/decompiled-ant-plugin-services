package j;

import java.util.Arrays;

/* loaded from: classes.dex */
public abstract class a {
    public abstract byte[] a();

    public String b() {
        return j.c(a());
    }

    public abstract int c();

    public String d() {
        return j.b(c());
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return c() == aVar.c() && Arrays.equals(a(), aVar.a());
    }

    public int hashCode() {
        return ((217 + c()) * 31) + a().hashCode();
    }

    public String toString() {
        return d() + ":" + b();
    }
}
