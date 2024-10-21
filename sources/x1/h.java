package x1;

import android.os.IBinder;
import android.os.IInterface;

/* loaded from: classes.dex */
public abstract class h extends c2.b implements i {
    public static i c(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.data.IDataSourceListener");
        return queryLocalInterface instanceof i ? (i) queryLocalInterface : new g(iBinder);
    }
}
