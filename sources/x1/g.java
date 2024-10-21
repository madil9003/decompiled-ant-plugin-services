package x1;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.fitness.data.DataPoint;

/* loaded from: classes.dex */
public final class g extends c2.a implements i {
    public g(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.fitness.data.IDataSourceListener");
    }

    @Override // x1.i
    public final void u(DataPoint dataPoint) {
        Parcel a3 = a();
        c2.f.c(a3, dataPoint);
        c(1, a3);
    }
}
