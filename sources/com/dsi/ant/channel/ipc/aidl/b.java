package com.dsi.ant.channel.ipc.aidl;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import com.dsi.ant.channel.Capabilities;
import com.dsi.ant.message.ipc.AntMessageParcel;

/* loaded from: classes.dex */
public interface b extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class a extends Binder implements b {

        /* renamed from: com.dsi.ant.channel.ipc.aidl.b$a$a */
        /* loaded from: classes.dex */
        public static class C0007a implements b {

            /* renamed from: b */
            public static b f403b;

            /* renamed from: a */
            private IBinder f404a;

            C0007a(IBinder iBinder) {
                this.f404a = iBinder;
            }

            @Override // com.dsi.ant.channel.ipc.aidl.b
            public AntMessageParcel E(AntMessageParcel antMessageParcel, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.dsi.ant.channel.ipc.aidl.IAntChannelAidl");
                    if (antMessageParcel != null) {
                        obtain.writeInt(1);
                        antMessageParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.f404a.transact(2, obtain, obtain2, 0) && a.c() != null) {
                        return a.c().E(antMessageParcel, bundle);
                    }
                    obtain2.readException();
                    AntMessageParcel createFromParcel = obtain2.readInt() != 0 ? AntMessageParcel.CREATOR.createFromParcel(obtain2) : null;
                    if (obtain2.readInt() != 0) {
                        bundle.readFromParcel(obtain2);
                    }
                    return createFromParcel;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f404a;
            }

            @Override // com.dsi.ant.channel.ipc.aidl.b
            public void b(byte[] bArr, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.dsi.ant.channel.ipc.aidl.IAntChannelAidl");
                    obtain.writeByteArray(bArr);
                    if (!this.f404a.transact(6, obtain, obtain2, 0) && a.c() != null) {
                        a.c().b(bArr, bundle);
                        return;
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        bundle.readFromParcel(obtain2);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.dsi.ant.channel.ipc.aidl.b
            public void d(byte[] bArr, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.dsi.ant.channel.ipc.aidl.IAntChannelAidl");
                    obtain.writeByteArray(bArr);
                    if (!this.f404a.transact(4, obtain, obtain2, 0) && a.c() != null) {
                        a.c().d(bArr, bundle);
                        return;
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        bundle.readFromParcel(obtain2);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.dsi.ant.channel.ipc.aidl.b
            public void e() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.dsi.ant.channel.ipc.aidl.IAntChannelAidl");
                    if (this.f404a.transact(13, obtain, obtain2, 0) || a.c() == null) {
                        obtain2.readException();
                    } else {
                        a.c().e();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.dsi.ant.channel.ipc.aidl.b
            public Bundle f(Message message, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.dsi.ant.channel.ipc.aidl.IAntChannelAidl");
                    if (message != null) {
                        obtain.writeInt(1);
                        message.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.f404a.transact(14, obtain, obtain2, 0) && a.c() != null) {
                        return a.c().f(message, bundle);
                    }
                    obtain2.readException();
                    Bundle bundle2 = obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                    if (obtain2.readInt() != 0) {
                        bundle.readFromParcel(obtain2);
                    }
                    return bundle2;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.dsi.ant.channel.ipc.aidl.b
            public void g(byte[] bArr, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.dsi.ant.channel.ipc.aidl.IAntChannelAidl");
                    obtain.writeByteArray(bArr);
                    if (!this.f404a.transact(3, obtain, obtain2, 0) && a.c() != null) {
                        a.c().g(bArr, bundle);
                        return;
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        bundle.readFromParcel(obtain2);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.dsi.ant.channel.ipc.aidl.b
            public Capabilities i() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.dsi.ant.channel.ipc.aidl.IAntChannelAidl");
                    if (!this.f404a.transact(12, obtain, obtain2, 0) && a.c() != null) {
                        return a.c().i();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? Capabilities.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.dsi.ant.channel.ipc.aidl.b
            public void o(AntMessageParcel antMessageParcel, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.dsi.ant.channel.ipc.aidl.IAntChannelAidl");
                    if (antMessageParcel != null) {
                        obtain.writeInt(1);
                        antMessageParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.f404a.transact(1, obtain, obtain2, 0) && a.c() != null) {
                        a.c().o(antMessageParcel, bundle);
                        return;
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        bundle.readFromParcel(obtain2);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.dsi.ant.channel.ipc.aidl.b
            public boolean r(Messenger messenger) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.dsi.ant.channel.ipc.aidl.IAntChannelAidl");
                    if (messenger != null) {
                        obtain.writeInt(1);
                        messenger.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.f404a.transact(10, obtain, obtain2, 0) && a.c() != null) {
                        return a.c().r(messenger);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.dsi.ant.channel.ipc.aidl.b
            public boolean s(Messenger messenger) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.dsi.ant.channel.ipc.aidl.IAntChannelAidl");
                    if (messenger != null) {
                        obtain.writeInt(1);
                        messenger.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.f404a.transact(11, obtain, obtain2, 0) && a.c() != null) {
                        return a.c().s(messenger);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.dsi.ant.channel.ipc.aidl.b
            public void t(IBinder iBinder) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.dsi.ant.channel.ipc.aidl.IAntChannelAidl");
                    obtain.writeStrongBinder(iBinder);
                    if (this.f404a.transact(8, obtain, obtain2, 0) || a.c() == null) {
                        obtain2.readException();
                    } else {
                        a.c().t(iBinder);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static b a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.dsi.ant.channel.ipc.aidl.IAntChannelAidl");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof b)) ? new C0007a(iBinder) : (b) queryLocalInterface;
        }

        public static b c() {
            return C0007a.f403b;
        }
    }

    AntMessageParcel E(AntMessageParcel antMessageParcel, Bundle bundle);

    void b(byte[] bArr, Bundle bundle);

    void d(byte[] bArr, Bundle bundle);

    void e();

    Bundle f(Message message, Bundle bundle);

    void g(byte[] bArr, Bundle bundle);

    Capabilities i();

    void o(AntMessageParcel antMessageParcel, Bundle bundle);

    boolean r(Messenger messenger);

    boolean s(Messenger messenger);

    void t(IBinder iBinder);
}
