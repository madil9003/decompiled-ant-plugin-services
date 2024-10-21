package d1;

import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes.dex */
public class c {

    /* renamed from: e */
    private static final String f1614e = "c";

    /* renamed from: a */
    public int f1615a;

    /* renamed from: b */
    public com.dsi.ant.plugins.antplus.pccbase.a f1616b = null;

    /* renamed from: c */
    public com.dsi.ant.plugins.antplus.pccbase.d f1617c = null;

    /* renamed from: d */
    private b[] f1618d;

    public c(int i2, Collection collection) {
        this.f1615a = i2;
        this.f1618d = new b[collection.size()];
        Iterator it = collection.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            this.f1618d[i3] = new b((DataSource) it.next());
            i3++;
        }
    }

    private b c(DataType dataType) {
        for (b bVar : this.f1618d) {
            if (bVar.f1613c.a().equals(dataType)) {
                return bVar;
            }
        }
        throw new IllegalStateException("This data stream does not have a source for " + dataType + " info.");
    }

    public DataSource a(DataType dataType) {
        return c(dataType).f1613c;
    }

    public z1.b b(DataType dataType) {
        return c(dataType).f1612b;
    }

    public long d(DataType dataType) {
        return c(dataType).f1611a;
    }

    public boolean e() {
        for (b bVar : this.f1618d) {
            if (bVar.f1612b != null) {
                return true;
            }
        }
        return false;
    }

    public void f(DataType dataType, z1.b bVar) {
        h1.a.a(f1614e, "Dispatcher for type " + dataType + " is set to " + bVar);
        b c3 = c(dataType);
        z1.b bVar2 = c3.f1612b;
        if (bVar2 instanceof g) {
            ((g) bVar2).f1647b = bVar;
        } else {
            c3.f1612b = bVar;
        }
    }

    public void g(DataType dataType, long j2) {
        c(dataType).f1611a = j2;
    }

    public void h(DataType dataType, z1.b bVar) {
        h1.a.a(f1614e, "Wildcard dispatcher for type " + dataType + " is set to " + bVar);
        b c3 = c(dataType);
        z1.b bVar2 = c3.f1612b;
        if (bVar2 instanceof g) {
            bVar2 = ((g) bVar2).f1647b;
        }
        if (bVar == null) {
            c3.f1612b = bVar2;
            return;
        }
        g gVar = new g();
        gVar.f1646a = bVar;
        gVar.f1647b = bVar2;
        c3.f1612b = gVar;
    }
}
