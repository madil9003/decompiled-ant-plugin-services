package q1;

import android.os.Parcel;

/* loaded from: classes.dex */
public abstract class c0 extends b2.b implements d0 {
    public c0() {
        super("com.google.android.gms.common.internal.ICertData");
    }

    @Override // b2.b
    protected final boolean a(int i2, Parcel parcel, Parcel parcel2, int i3) {
        if (i2 == 1) {
            w1.a D = D();
            parcel2.writeNoException();
            b2.c.b(parcel2, D);
        } else {
            if (i2 != 2) {
                return false;
            }
            int v2 = v();
            parcel2.writeNoException();
            parcel2.writeInt(v2);
        }
        return true;
    }
}
