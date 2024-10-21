package c2;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes.dex */
public abstract class a implements IInterface {

    /* renamed from: a */
    private final IBinder f283a;

    /* renamed from: b */
    private final String f284b;

    public a(IBinder iBinder, String str) {
        this.f283a = iBinder;
        this.f284b = str;
    }

    public final Parcel a() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f284b);
        return obtain;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f283a;
    }

    public final void c(int i2, Parcel parcel) {
        try {
            this.f283a.transact(1, parcel, null, 1);
        } finally {
            parcel.recycle();
        }
    }
}
