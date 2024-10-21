package q1;

import android.content.Context;
import android.util.SparseIntArray;
import o1.a;

/* loaded from: classes.dex */
public final class r {

    /* renamed from: a */
    private final SparseIntArray f3049a = new SparseIntArray();

    /* renamed from: b */
    private com.google.android.gms.common.b f3050b;

    public r(com.google.android.gms.common.b bVar) {
        f.g(bVar);
        this.f3050b = bVar;
    }

    public final int a(Context context, int i2) {
        return this.f3049a.get(i2, -1);
    }

    public final int b(Context context, a.f fVar) {
        f.g(context);
        f.g(fVar);
        int i2 = 0;
        if (!fVar.b()) {
            return 0;
        }
        int p2 = fVar.p();
        int a3 = a(context, p2);
        if (a3 == -1) {
            int i3 = 0;
            while (true) {
                if (i3 >= this.f3049a.size()) {
                    i2 = -1;
                    break;
                }
                int keyAt = this.f3049a.keyAt(i3);
                if (keyAt > p2 && this.f3049a.get(keyAt) == 0) {
                    break;
                }
                i3++;
            }
            a3 = i2 == -1 ? this.f3050b.f(context, p2) : i2;
            this.f3049a.put(p2, a3);
        }
        return a3;
    }

    public final void c() {
        this.f3049a.clear();
    }
}
