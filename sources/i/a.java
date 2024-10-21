package i;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes.dex */
public interface a extends IInterface {

    /* renamed from: i.a$a */
    /* loaded from: classes.dex */
    public static abstract class AbstractBinderC0037a extends Binder implements a {

        /* renamed from: i.a$a$a */
        /* loaded from: classes.dex */
        public static class C0038a implements a {

            /* renamed from: b */
            public static a f1847b;

            /* renamed from: a */
            private IBinder f1848a;

            C0038a(IBinder iBinder) {
                this.f1848a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f1848a;
            }

            @Override // i.a
            public IBinder x(int i2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.dsi.ant.ipc.aidl.IAntServiceAidl");
                    obtain.writeInt(i2);
                    if (!this.f1848a.transact(1, obtain, obtain2, 0) && AbstractBinderC0037a.c() != null) {
                        return AbstractBinderC0037a.c().x(i2);
                    }
                    obtain2.readException();
                    return obtain2.readStrongBinder();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.dsi.ant.ipc.aidl.IAntServiceAidl");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof a)) ? new C0038a(iBinder) : (a) queryLocalInterface;
        }

        public static a c() {
            return C0038a.f1847b;
        }
    }

    IBinder x(int i2);
}
