package p1;

import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public abstract class z extends d.a implements e {

    /* renamed from: c */
    private static final WeakHashMap f2993c = new WeakHashMap();

    public static z d(d.b bVar) {
        z zVar;
        WeakReference weakReference = (WeakReference) f2993c.get(bVar);
        if (weakReference == null || (zVar = (z) weakReference.get()) == null) {
            throw null;
        }
        return zVar;
    }
}
