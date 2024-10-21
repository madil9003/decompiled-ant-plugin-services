package com.dsi.ant.channel.ipc.aidl;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Message;
import android.os.Parcel;
import com.dsi.ant.channel.Capabilities;
import com.dsi.ant.channel.ipc.aidl.b;

/* loaded from: classes.dex */
public interface c extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class a extends Binder implements c {

        /* renamed from: com.dsi.ant.channel.ipc.aidl.c$a$a */
        /* loaded from: classes.dex */
        public static class C0008a implements c {

            /* renamed from: b */
            public static c f405b;

            /* renamed from: a */
            private IBinder f406a;

            C0008a(IBinder iBinder) {
                this.f406a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f406a;
            }

            @Override // com.dsi.ant.channel.ipc.aidl.c
            public AntIpcResult f(Message message, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.dsi.ant.channel.ipc.aidl.IAntChannelProviderAidl");
                    if (message != null) {
                        obtain.writeInt(1);
                        message.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.f406a.transact(5, obtain, obtain2, 0) && a.c() != null) {
                        return a.c().f(message, bundle);
                    }
                    obtain2.readException();
                    AntIpcResult createFromParcel = obtain2.readInt() != 0 ? AntIpcResult.CREATOR.createFromParcel(obtain2) : null;
                    if (obtain2.readInt() != 0) {
                        bundle.readFromParcel(obtain2);
                    }
                    return createFromParcel;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.dsi.ant.channel.ipc.aidl.c
            public int h(Capabilities capabilities) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.dsi.ant.channel.ipc.aidl.IAntChannelProviderAidl");
                    if (capabilities != null) {
                        obtain.writeInt(1);
                        capabilities.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.f406a.transact(3, obtain, obtain2, 0) && a.c() != null) {
                        return a.c().h(capabilities);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.dsi.ant.channel.ipc.aidl.c
            public b m(int i2, Capabilities capabilities, Capabilities capabilities2, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.dsi.ant.channel.ipc.aidl.IAntChannelProviderAidl");
                    obtain.writeInt(i2);
                    if (capabilities != null) {
                        obtain.writeInt(1);
                        capabilities.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (capabilities2 != null) {
                        obtain.writeInt(1);
                        capabilities2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.f406a.transact(1, obtain, obtain2, 0) && a.c() != null) {
                        return a.c().m(i2, capabilities, capabilities2, bundle);
                    }
                    obtain2.readException();
                    b a3 = b.a.a(obtain2.readStrongBinder());
                    if (obtain2.readInt() != 0) {
                        bundle.readFromParcel(obtain2);
                    }
                    return a3;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static c a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.dsi.ant.channel.ipc.aidl.IAntChannelProviderAidl");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof c)) ? new C0008a(iBinder) : (c) queryLocalInterface;
        }

        public static c c() {
            return C0008a.f405b;
        }
    }

    AntIpcResult f(Message message, Bundle bundle);

    int h(Capabilities capabilities);

    b m(int i2, Capabilities capabilities, Capabilities capabilities2, Bundle bundle);
}
