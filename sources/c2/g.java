package c2;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.api.Status;

/* loaded from: classes.dex */
public final class g extends a implements i {
    public g(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.fitness.internal.IStatusCallback");
    }

    @Override // c2.i
    public final void A(Status status) {
        Parcel a3 = a();
        f.c(a3, status);
        c(1, a3);
    }
}
