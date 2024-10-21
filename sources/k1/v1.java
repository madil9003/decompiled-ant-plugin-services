package k1;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class v1 {

    /* renamed from: a */
    protected int f2451a = y1.f2533a;

    /* renamed from: b */
    protected int f2452b = 0;

    /* renamed from: c */
    protected int f2453c = 1;

    /* renamed from: d */
    protected ArrayList f2454d = new ArrayList();

    /* renamed from: e */
    protected ArrayList f2455e = new ArrayList();

    public int a() {
        Iterator it = this.f2455e.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            i2 += ((a0) it.next()).f();
        }
        return i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof v1)) {
            return false;
        }
        v1 v1Var = (v1) obj;
        if (this.f2451a != v1Var.f2451a || this.f2452b != v1Var.f2452b || this.f2454d.size() != v1Var.f2454d.size()) {
            return false;
        }
        for (int i2 = 0; i2 < this.f2454d.size(); i2++) {
            if (!((x0) this.f2454d.get(i2)).equals(v1Var.f2454d.get(i2))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        return ((((31 + new Integer(this.f2451a).hashCode()) * 47) + new Integer(this.f2452b).hashCode()) * 19) + this.f2454d.hashCode();
    }
}
