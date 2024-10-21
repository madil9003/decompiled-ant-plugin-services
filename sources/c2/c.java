package c2;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.fitness.result.DataSourcesResult;

/* loaded from: classes.dex */
public final class c extends a implements e {
    public c(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.fitness.internal.IDataSourcesCallback");
    }

    @Override // c2.e
    public final void l(DataSourcesResult dataSourcesResult) {
        Parcel a3 = a();
        f.c(a3, dataSourcesResult);
        c(1, a3);
    }
}
