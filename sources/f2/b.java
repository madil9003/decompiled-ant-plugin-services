package f2;

import android.os.Parcel;
import com.google.android.gms.signin.internal.zak;

/* loaded from: classes.dex */
public abstract class b extends a2.b implements c {
    public b() {
        super("com.google.android.gms.signin.internal.ISignInCallbacks");
    }

    @Override // a2.b
    protected final boolean F(int i2, Parcel parcel, Parcel parcel2, int i3) {
        switch (i2) {
            case 3:
                break;
            case 4:
            case 6:
                break;
            case 5:
            default:
                return false;
            case 7:
                break;
            case 8:
                n((zak) a2.c.a(parcel, zak.CREATOR));
                break;
            case 9:
                break;
        }
        parcel2.writeNoException();
        return true;
    }
}
