package d1;

/* loaded from: classes.dex */
public class f {

    /* renamed from: a */
    public int f1644a;

    /* renamed from: b */
    public p0.c f1645b;

    public static f a(String str) {
        String[] split = str.split("\\.");
        if (split.length != 3 || !split[0].equals("AntPlus")) {
            return null;
        }
        f fVar = new f();
        try {
            fVar.f1644a = Integer.parseInt(split[1]);
            fVar.f1645b = p0.c.c(Integer.parseInt(split[2]));
            return fVar;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public String toString() {
        return "AntPlus." + this.f1644a + "." + this.f1645b.b();
    }
}
