package k1;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class d3 {

    /* renamed from: a */
    protected String f2159a;

    /* renamed from: b */
    protected int f2160b;

    /* renamed from: c */
    protected double f2161c;

    /* renamed from: d */
    protected double f2162d;

    /* renamed from: e */
    protected String f2163e;

    /* renamed from: f */
    private ArrayList f2164f = new ArrayList();

    /* renamed from: g */
    protected ArrayList f2165g = new ArrayList();

    /* loaded from: classes.dex */
    public class a {

        /* renamed from: a */
        private int f2166a;

        /* renamed from: b */
        private long f2167b;

        protected a(int i2, long j2) {
            this.f2166a = i2;
            this.f2167b = j2;
        }

        protected boolean a(s1 s1Var) {
            Long l2;
            s0 j2 = s1Var.j(this.f2166a);
            return (j2 == null || (l2 = j2.l(0, 65535)) == null || l2.longValue() != this.f2167b) ? false : true;
        }
    }

    public d3(String str, int i2, double d3, double d4, String str2) {
        this.f2159a = str;
        this.f2160b = i2;
        this.f2161c = d3;
        this.f2162d = d4;
        this.f2163e = str2;
    }

    public void a(w0 w0Var) {
        this.f2165g.add(w0Var);
    }

    public void b(int i2, long j2) {
        this.f2164f.add(new a(i2, j2));
    }

    public boolean c(s1 s1Var) {
        Iterator it = this.f2164f.iterator();
        while (it.hasNext()) {
            if (((a) it.next()).a(s1Var)) {
                return true;
            }
        }
        return false;
    }

    public int d() {
        return this.f2160b;
    }
}
