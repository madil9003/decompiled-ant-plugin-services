package k1;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class s1 {

    /* renamed from: a */
    protected String f2379a;

    /* renamed from: b */
    protected int f2380b;

    /* renamed from: c */
    protected int f2381c;

    /* renamed from: d */
    protected ArrayList f2382d;

    /* renamed from: e */
    protected ArrayList f2383e;

    /* renamed from: f */
    protected long f2384f;

    public s1(String str, int i2) {
        this.f2379a = str;
        this.f2380b = i2;
        this.f2381c = 0;
        this.f2382d = new ArrayList();
        this.f2383e = new ArrayList();
        this.f2384f = 0L;
    }

    public void g(z zVar) {
        for (int i2 = 0; i2 < this.f2383e.size(); i2++) {
            z zVar2 = (z) this.f2383e.get(i2);
            if (zVar2.L() == zVar.L() && zVar2.K() == zVar.K()) {
                this.f2383e.set(i2, zVar);
                return;
            }
        }
        this.f2383e.add(zVar);
    }

    public void h(s0 s0Var) {
        this.f2382d.add(s0Var);
    }

    public int i(int i2) {
        s0 a3 = r0.a(this.f2380b, i2);
        if (a3 == null) {
            return 65535;
        }
        for (int i3 = 0; i3 < a3.f2376k.size(); i3++) {
            if (((d3) a3.f2376k.get(i3)).c(this)) {
                return i3;
            }
        }
        return 65535;
    }

    public s0 j(int i2) {
        for (int i3 = 0; i3 < this.f2382d.size(); i3++) {
            if (((s0) this.f2382d.get(i3)).f2369d == i2) {
                return (s0) this.f2382d.get(i3);
            }
        }
        return null;
    }

    public Byte k(int i2, int i3, int i4) {
        s0 j2 = j(i2);
        if (j2 == null) {
            return null;
        }
        if (i4 == 65534) {
            return j2.f(i3, i(i2));
        }
        d3 y2 = j2.y(i4);
        if (y2 == null || y2.c(this)) {
            return j2.f(i3, i4);
        }
        return null;
    }

    public Integer l(int i2, int i3, int i4) {
        s0 j2 = j(i2);
        if (j2 == null) {
            return null;
        }
        if (i4 == 65534) {
            return j2.i(i3, i(i2));
        }
        d3 y2 = j2.y(i4);
        if (y2 == null || y2.c(this)) {
            return j2.i(i3, i4);
        }
        return null;
    }

    public Long m(int i2, int i3, int i4) {
        s0 j2 = j(i2);
        if (j2 == null) {
            return null;
        }
        if (i4 == 65534) {
            return j2.l(i3, i(i2));
        }
        d3 y2 = j2.y(i4);
        if (y2 == null || y2.c(this)) {
            return j2.l(i3, i4);
        }
        return null;
    }

    public Short n(int i2, int i3, int i4) {
        s0 j2 = j(i2);
        if (j2 == null) {
            return null;
        }
        if (i4 == 65534) {
            return j2.u(i3, i(i2));
        }
        d3 y2 = j2.y(i4);
        if (y2 == null || y2.c(this)) {
            return j2.u(i3, i4);
        }
        return null;
    }

    public String o(int i2, int i3, int i4) {
        s0 j2 = j(i2);
        if (j2 == null) {
            return null;
        }
        if (i4 == 65534) {
            return j2.w(i3, i(i2));
        }
        d3 y2 = j2.y(i4);
        if (y2 == null || y2.c(this)) {
            return j2.w(i3, i4);
        }
        return null;
    }

    public int p() {
        return this.f2380b;
    }

    public boolean q(int i2) {
        for (int i3 = 0; i3 < this.f2382d.size(); i3++) {
            if (((s0) this.f2382d.get(i3)).f2369d == i2) {
                return true;
            }
        }
        return false;
    }

    public void r(s0 s0Var) {
        for (int i2 = 0; i2 < this.f2382d.size(); i2++) {
            if (((s0) this.f2382d.get(i2)).f2369d == s0Var.f2369d) {
                this.f2382d.set(i2, s0Var);
                return;
            }
        }
        this.f2382d.add(s0Var);
    }

    public void s(int i2, int i3, Object obj, int i4) {
        if (i4 == 65534) {
            i4 = i(i2);
        }
        s0 j2 = j(i2);
        if (j2 == null) {
            j2 = r0.a(this.f2380b, i2);
            h(j2);
        }
        j2.H(i3, obj, i4);
    }

    public void t(s1 s1Var) {
        if (s1Var.f2380b != this.f2380b) {
            return;
        }
        Iterator it = s1Var.f2382d.iterator();
        while (it.hasNext()) {
            r((s0) it.next());
        }
    }

    public w u(Long l2) {
        if (l2 == null) {
            return null;
        }
        w wVar = new w(l2.longValue());
        wVar.b(this.f2384f);
        return wVar;
    }

    public s1(s1 s1Var) {
        this.f2382d = new ArrayList();
        this.f2383e = new ArrayList();
        if (s1Var == null) {
            this.f2379a = "unknown";
            this.f2380b = y1.f2533a;
            this.f2384f = 0L;
            return;
        }
        this.f2379a = s1Var.f2379a;
        this.f2380b = s1Var.f2380b;
        this.f2381c = s1Var.f2381c;
        this.f2384f = s1Var.f2384f;
        Iterator it = s1Var.f2382d.iterator();
        while (it.hasNext()) {
            s0 s0Var = (s0) it.next();
            if (s0Var.p() > 0) {
                this.f2382d.add(new s0(s0Var));
            }
        }
        Iterator it2 = s1Var.f2383e.iterator();
        while (it2.hasNext()) {
            z zVar = (z) it2.next();
            if (zVar.p() > 0) {
                this.f2383e.add(new z(zVar));
            }
        }
    }
}
