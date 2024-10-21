package l;

/* loaded from: classes.dex */
public abstract class b extends j.a {
    @Override // j.a
    public byte[] a() {
        return e(0, 0);
    }

    @Override // j.a
    public int c() {
        return f().b();
    }

    public abstract byte[] e(int i2, int i3);

    public abstract k f();

    public String g() {
        return f() + "(" + d() + ") ";
    }
}
