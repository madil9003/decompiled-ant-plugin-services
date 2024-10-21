package a2;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes.dex */
public abstract class a implements IInterface {

    /* renamed from: a */
    private final IBinder f98a;

    /* renamed from: b */
    private final String f99b;

    public a(IBinder iBinder, String str) {
        this.f98a = iBinder;
        this.f99b = str;
    }

    public final Parcel a() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f99b);
        return obtain;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f98a;
    }

    public final void c(int i2, Parcel parcel) {
        Parcel obtain = Parcel.obtain();
        try {
            this.f98a.transact(i2, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obtain.recycle();
        }
    }

    public final void j(int i2, Parcel parcel) {
        try {
            this.f98a.transact(1, parcel, null, 1);
        } finally {
            parcel.recycle();
        }
    }
}
