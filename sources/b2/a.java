package b2;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes.dex */
public abstract class a implements IInterface {

    /* renamed from: a */
    private final IBinder f256a;

    /* renamed from: b */
    private final String f257b;

    public a(IBinder iBinder, String str) {
        this.f256a = iBinder;
        this.f257b = str;
    }

    public final Parcel a(int i2, Parcel parcel) {
        Parcel obtain = Parcel.obtain();
        try {
            try {
                this.f256a.transact(i2, parcel, obtain, 0);
                obtain.readException();
                return obtain;
            } catch (RuntimeException e3) {
                obtain.recycle();
                throw e3;
            }
        } finally {
            parcel.recycle();
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f256a;
    }

    public final Parcel c() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f257b);
        return obtain;
    }
}
