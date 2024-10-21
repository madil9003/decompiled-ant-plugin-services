package q1;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.zzj;

/* loaded from: classes.dex */
public abstract class t extends b2.b implements c {
    public t() {
        super("com.google.android.gms.common.internal.IGmsCallbacks");
    }

    @Override // b2.b
    protected final boolean a(int i2, Parcel parcel, Parcel parcel2, int i3) {
        if (i2 == 1) {
            C(parcel.readInt(), parcel.readStrongBinder(), (Bundle) b2.c.a(parcel, Bundle.CREATOR));
        } else if (i2 == 2) {
            w(parcel.readInt(), (Bundle) b2.c.a(parcel, Bundle.CREATOR));
        } else {
            if (i2 != 3) {
                return false;
            }
            z(parcel.readInt(), parcel.readStrongBinder(), (zzj) b2.c.a(parcel, zzj.CREATOR));
        }
        parcel2.writeNoException();
        return true;
    }
}
