package k1;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class n implements n2 {

    /* renamed from: a */
    private l f2342a = new l();

    /* renamed from: b */
    private ArrayList f2343b = new ArrayList();

    @Override // k1.n2
    public void a(m2 m2Var) {
        this.f2342a.t(m2Var);
        Iterator it = this.f2343b.iterator();
        if (it.hasNext()) {
            m.a(it.next());
            throw null;
        }
    }
}
