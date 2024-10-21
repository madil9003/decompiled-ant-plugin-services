package c2;

import android.os.Parcel;
import com.google.android.gms.fitness.service.FitnessSensorServiceRequest;
import com.google.android.gms.internal.fitness.zzex;
import com.google.android.gms.internal.fitness.zzez;

/* loaded from: classes.dex */
public abstract class l extends b implements m {
    public l() {
        super("com.google.android.gms.fitness.internal.service.IFitnessSensorService");
    }

    @Override // c2.b
    protected final boolean a(int i2, Parcel parcel, Parcel parcel2, int i3) {
        if (i2 == 1) {
            zzex zzexVar = (zzex) f.a(parcel, zzex.CREATOR);
            e c3 = d.c(parcel.readStrongBinder());
            f.b(parcel);
            B(zzexVar, c3);
        } else if (i2 == 2) {
            FitnessSensorServiceRequest fitnessSensorServiceRequest = (FitnessSensorServiceRequest) f.a(parcel, FitnessSensorServiceRequest.CREATOR);
            i c4 = h.c(parcel.readStrongBinder());
            f.b(parcel);
            p(fitnessSensorServiceRequest, c4);
        } else {
            if (i2 != 3) {
                return false;
            }
            zzez zzezVar = (zzez) f.a(parcel, zzez.CREATOR);
            i c5 = h.c(parcel.readStrongBinder());
            f.b(parcel);
            k(zzezVar, c5);
        }
        return true;
    }
}
