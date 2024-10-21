package b;

import android.os.Bundle;
import b.c;

/* loaded from: classes.dex */
public abstract class e {

    /* renamed from: a */
    private static final Object f182a = new Object();

    /* renamed from: b */
    private static final Object f183b = new Object();

    public static Bundle a(c.a aVar) {
        Bundle bundle = new Bundle();
        bundle.putInt("icon", aVar.d());
        bundle.putCharSequence("title", aVar.i());
        bundle.putParcelable("actionIntent", aVar.a());
        Bundle bundle2 = aVar.c() != null ? new Bundle(aVar.c()) : new Bundle();
        bundle2.putBoolean("android.support.allowGeneratedReplies", aVar.b());
        bundle.putBundle("extras", bundle2);
        bundle.putParcelableArray("remoteInputs", c(aVar.f()));
        bundle.putBoolean("showsUserInterface", aVar.h());
        bundle.putInt("semanticAction", aVar.g());
        return bundle;
    }

    private static Bundle b(f fVar) {
        new Bundle();
        throw null;
    }

    private static Bundle[] c(f[] fVarArr) {
        if (fVarArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[fVarArr.length];
        for (int i2 = 0; i2 < fVarArr.length; i2++) {
            f fVar = fVarArr[i2];
            bundleArr[i2] = b(null);
        }
        return bundleArr;
    }
}
