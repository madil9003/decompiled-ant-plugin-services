package b;

import android.app.RemoteInput;

/* loaded from: classes.dex */
public abstract class f {
    static RemoteInput a(f fVar) {
        throw null;
    }

    public static RemoteInput[] b(f[] fVarArr) {
        if (fVarArr == null) {
            return null;
        }
        RemoteInput[] remoteInputArr = new RemoteInput[fVarArr.length];
        for (int i2 = 0; i2 < fVarArr.length; i2++) {
            f fVar = fVarArr[i2];
            remoteInputArr[i2] = a(null);
        }
        return remoteInputArr;
    }
}
