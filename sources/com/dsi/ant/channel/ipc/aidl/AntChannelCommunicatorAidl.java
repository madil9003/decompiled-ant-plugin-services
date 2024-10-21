package com.dsi.ant.channel.ipc.aidl;

import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import com.dsi.ant.channel.BackgroundScanState;
import com.dsi.ant.channel.BurstState;
import com.dsi.ant.channel.Capabilities;
import com.dsi.ant.channel.EventBufferSettings;
import com.dsi.ant.channel.ipc.aidl.b;
import com.dsi.ant.message.LibConfig;
import com.dsi.ant.message.ipc.AntMessageParcel;
import j.h;
import j.i;
import k.l;
import l.g;
import l.j;
import l.m;
import l.n;
import l.o;
import l.p;
import l.q;

/* loaded from: classes.dex */
public class AntChannelCommunicatorAidl implements h.a, Parcelable {
    public static final Parcelable.Creator<AntChannelCommunicatorAidl> CREATOR = new b();

    /* renamed from: j */
    private static final String f356j = "AntChannelCommunicatorAidl";

    /* renamed from: a */
    g.d f357a;

    /* renamed from: b */
    final Object f358b;

    /* renamed from: c */
    final Object f359c;

    /* renamed from: d */
    private final Object f360d;

    /* renamed from: e */
    private HandlerThread f361e;

    /* renamed from: f */
    private Messenger f362f;

    /* renamed from: g */
    private e f363g;

    /* renamed from: h */
    private final Binder f364h;

    /* renamed from: i */
    private com.dsi.ant.channel.ipc.aidl.b f365i;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AntChannelCommunicatorAidl.this.f357a.b();
        }
    }

    /* loaded from: classes.dex */
    class b implements Parcelable.Creator {
        b() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public AntChannelCommunicatorAidl createFromParcel(Parcel parcel) {
            parcel.readInt();
            return new AntChannelCommunicatorAidl(b.a.a(parcel.readStrongBinder()), false);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public AntChannelCommunicatorAidl[] newArray(int i2) {
            return new AntChannelCommunicatorAidl[i2];
        }
    }

    /* loaded from: classes.dex */
    static /* synthetic */ class c {

        /* renamed from: a */
        static final /* synthetic */ int[] f367a;

        static {
            int[] iArr = new int[f.values().length];
            f367a = iArr;
            try {
                iArr[f.RX_ANT_MESSAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f367a[f.CHANNEL_DEATH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f367a[f.BURST_STATE_CHANGE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f367a[f.LIB_CONFIG_CHANGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f367a[f.BACKGROUND_SCAN_STATE_CHANGE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f367a[f.EVENT_BUFFER_SETTINGS_CHANGE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f367a[f.UNKNOWN.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes.dex */
    enum d {
        UNKNOWN(-1),
        SET_LIB_CONFIG(1),
        SET_EVENT_BUFFER_SETTINGS(2),
        GET_BURST_STATE(101),
        GET_LIB_CONFIG(102),
        GET_BACKGROUND_SCAN_STATE(103),
        GET_EVENT_BUFFER_SETTINGS(104);


        /* renamed from: i */
        private static final d[] f375i = values();

        /* renamed from: a */
        private final int f377a;

        d(int i2) {
            this.f377a = i2;
        }

        int b() {
            return this.f377a;
        }
    }

    /* loaded from: classes.dex */
    public static final class e extends Handler {

        /* renamed from: a */
        private final Object f378a;

        /* renamed from: b */
        private AntChannelCommunicatorAidl f379b;

        public e(AntChannelCommunicatorAidl antChannelCommunicatorAidl, Looper looper, Object obj) {
            super(looper);
            this.f379b = antChannelCommunicatorAidl;
            this.f378a = obj;
        }

        public void b() {
            synchronized (this.f378a) {
                this.f379b = null;
                removeCallbacksAndMessages(null);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            synchronized (this.f378a) {
                if (this.f379b == null) {
                    return;
                }
                switch (c.f367a[f.b(message.what).ordinal()]) {
                    case 1:
                        Bundle data = message.getData();
                        data.setClassLoader(AntMessageParcel.class.getClassLoader());
                        AntMessageParcel antMessageParcel = (AntMessageParcel) data.getParcelable("com.dsi.ant.channel.data.antmessageparcel");
                        l c3 = l.c(antMessageParcel);
                        if (c3 != l.OTHER) {
                            this.f379b.H(c3, antMessageParcel);
                            break;
                        } else {
                            break;
                        }
                    case 2:
                        this.f379b.E();
                        break;
                    case 3:
                        Bundle data2 = message.getData();
                        data2.setClassLoader(BurstState.class.getClassLoader());
                        BurstState burstState = (BurstState) data2.getParcelable("com.dsi.ant.channel.data.burststate");
                        if (burstState != null) {
                            this.f379b.D(burstState);
                            break;
                        }
                        break;
                    case 4:
                        Bundle data3 = message.getData();
                        data3.setClassLoader(LibConfig.class.getClassLoader());
                        LibConfig libConfig = (LibConfig) data3.getParcelable("com.dsi.ant.channel.data.libconfig");
                        if (libConfig != null) {
                            this.f379b.G(libConfig);
                            break;
                        }
                        break;
                    case 5:
                        Bundle data4 = message.getData();
                        data4.setClassLoader(BackgroundScanState.class.getClassLoader());
                        BackgroundScanState backgroundScanState = (BackgroundScanState) data4.getParcelable("com.dsi.ant.channel.data.backgroundscanstate");
                        if (backgroundScanState != null) {
                            this.f379b.C(backgroundScanState);
                            break;
                        }
                        break;
                    case 6:
                        Bundle data5 = message.getData();
                        data5.setClassLoader(EventBufferSettings.class.getClassLoader());
                        EventBufferSettings eventBufferSettings = (EventBufferSettings) data5.getParcelable("com.dsi.ant.channel.data.eventbuffersettings");
                        if (eventBufferSettings != null) {
                            this.f379b.F(eventBufferSettings);
                            break;
                        }
                        break;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    enum f {
        UNKNOWN(-1),
        RX_ANT_MESSAGE(1),
        CHANNEL_DEATH(2),
        BURST_STATE_CHANGE(101),
        LIB_CONFIG_CHANGE(102),
        BACKGROUND_SCAN_STATE_CHANGE(103),
        EVENT_BUFFER_SETTINGS_CHANGE(104);


        /* renamed from: i */
        private static final f[] f387i = values();

        /* renamed from: a */
        private final int f389a;

        f(int i2) {
            this.f389a = i2;
        }

        static f b(int i2) {
            f fVar = UNKNOWN;
            int i3 = 0;
            while (true) {
                f[] fVarArr = f387i;
                if (i3 >= fVarArr.length) {
                    return fVar;
                }
                if (fVarArr[i3].c(i2)) {
                    return fVarArr[i3];
                }
                i3++;
            }
        }

        private boolean c(int i2) {
            return i2 == this.f389a;
        }
    }

    public AntChannelCommunicatorAidl(com.dsi.ant.channel.ipc.aidl.b bVar) {
        this(bVar, true);
    }

    public void C(BackgroundScanState backgroundScanState) {
        synchronized (this.f359c) {
        }
    }

    public void D(BurstState burstState) {
        synchronized (this.f359c) {
        }
    }

    public void F(EventBufferSettings eventBufferSettings) {
        synchronized (this.f359c) {
        }
    }

    public void G(LibConfig libConfig) {
        synchronized (this.f359c) {
        }
    }

    private Bundle I(Message message, Bundle bundle) {
        Bundle f3 = this.f365i.f(message, bundle);
        message.recycle();
        return f3;
    }

    private boolean J() {
        synchronized (this.f360d) {
            if (this.f361e != null) {
                return true;
            }
            HandlerThread handlerThread = new HandlerThread(f356j + " Receive thread");
            this.f361e = handlerThread;
            handlerThread.start();
            this.f363g = new e(this, this.f361e.getLooper(), this.f360d);
            boolean z2 = false;
            try {
                Messenger messenger = new Messenger(this.f363g);
                this.f362f = messenger;
                z2 = this.f365i.r(messenger);
                if (!z2) {
                    K();
                }
            } catch (RemoteException unused) {
                this.f362f = null;
                Log.e(f356j, "Could not setup IPC Event receiver with remote service.");
            }
            return z2;
        }
    }

    private void K() {
        synchronized (this.f360d) {
            HandlerThread handlerThread = this.f361e;
            if (handlerThread == null) {
                return;
            }
            handlerThread.quit();
            this.f361e = null;
            this.f363g.b();
            this.f363g = null;
            try {
                this.f365i.s(this.f362f);
            } catch (RemoteException unused) {
                Log.e(f356j, "Could not remove IPC Event receiver with remote service.");
            }
            this.f362f = null;
        }
    }

    private void M(l.b bVar, Bundle bundle) {
        L(new AntMessageParcel(bVar), bundle);
    }

    public void B(IBinder iBinder) {
        this.f365i.t(iBinder);
    }

    public void E() {
        synchronized (this.f358b) {
            if (this.f357a != null) {
                K();
                new Thread(new a()).run();
            }
        }
    }

    public void H(l lVar, AntMessageParcel antMessageParcel) {
        synchronized (this.f358b) {
            g.d dVar = this.f357a;
            if (dVar != null) {
                dVar.a(lVar, antMessageParcel);
            }
        }
    }

    public void L(AntMessageParcel antMessageParcel, Bundle bundle) {
        this.f365i.o(antMessageParcel, bundle);
    }

    @Override // h.a
    public void a(j.d dVar, j.f fVar, Bundle bundle) {
        this.f365i.o(new AntMessageParcel(new l.c(dVar, fVar)), bundle);
    }

    @Override // h.a
    public void b(byte[] bArr, Bundle bundle) {
        this.f365i.b(bArr, bundle);
    }

    @Override // h.a
    public void c(int i2, Bundle bundle) {
        this.f365i.o(new AntMessageParcel(new l.f(i2)), bundle);
    }

    @Override // h.a
    public void d(byte[] bArr, Bundle bundle) {
        this.f365i.d(bArr, bundle);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // h.a
    public void e() {
        K();
        try {
            this.f365i.e();
        } catch (IllegalStateException unused) {
        }
    }

    @Override // h.a
    public void f(int i2, Bundle bundle) {
        this.f365i.o(new AntMessageParcel(new p(i2, i())), bundle);
    }

    @Override // h.a
    public void g(byte[] bArr, Bundle bundle) {
        this.f365i.g(bArr, bundle);
    }

    @Override // h.a
    public void h(Bundle bundle) {
        this.f365i.o(new AntMessageParcel(new q()), bundle);
    }

    @Override // h.a
    public Capabilities i() {
        return this.f365i.i();
    }

    @Override // h.a
    public void j(LibConfig libConfig, Bundle bundle) {
        Message obtain = Message.obtain();
        Bundle bundle2 = new Bundle(LibConfig.class.getClassLoader());
        bundle2.putParcelable("com.dsi.ant.channel.data.libconfig", libConfig);
        obtain.what = d.SET_LIB_CONFIG.b();
        obtain.setData(bundle2);
        I(obtain, bundle);
    }

    @Override // h.a
    public void k(int i2, Bundle bundle) {
        this.f365i.o(new AntMessageParcel(new m(i2)), bundle);
    }

    @Override // h.a
    public void l(Bundle bundle) {
        this.f365i.o(new AntMessageParcel(new g()), bundle);
    }

    @Override // h.a
    public void m() {
        synchronized (this.f358b) {
            this.f357a = null;
        }
    }

    @Override // h.a
    public void n(g.d dVar) {
        synchronized (this.f358b) {
            this.f357a = dVar;
        }
    }

    @Override // h.a
    public void o(j.b bVar, int i2, Bundle bundle) {
        M(new l.a(bVar, i2), bundle);
    }

    @Override // h.a
    public void p(i iVar, Bundle bundle) {
        this.f365i.o(new AntMessageParcel(new j(iVar)), bundle);
    }

    @Override // h.a
    public void q(Bundle bundle) {
        this.f365i.o(new AntMessageParcel(new l.l()), bundle);
    }

    @Override // h.a
    public void r(int i2, Bundle bundle) {
        this.f365i.o(new AntMessageParcel(new l.e(i2)), bundle);
    }

    @Override // h.a
    public void s(EventBufferSettings eventBufferSettings, Bundle bundle) {
        Message obtain = Message.obtain();
        Bundle bundle2 = new Bundle(EventBufferSettings.class.getClassLoader());
        bundle2.putParcelable("com.dsi.ant.channel.data.eventbuffersettings", eventBufferSettings);
        obtain.what = d.SET_EVENT_BUFFER_SETTINGS.b();
        obtain.setData(bundle2);
        I(obtain, bundle);
    }

    @Override // h.a
    public void t(h hVar, Bundle bundle) {
        this.f365i.o(new AntMessageParcel(new o(hVar)), bundle);
    }

    @Override // h.a
    public void u(j.b bVar, Bundle bundle) {
        this.f365i.o(new AntMessageParcel(new l.d(bVar)), bundle);
    }

    @Override // h.a
    public AntMessageParcel v(l lVar, Bundle bundle) {
        return this.f365i.E(new AntMessageParcel(new n(lVar)), bundle);
    }

    @Override // h.a
    public void w(int i2, boolean z2, Bundle bundle) {
        this.f365i.o(new AntMessageParcel(new l.h(i2, z2)), bundle);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(1);
        parcel.writeStrongBinder(this.f365i.asBinder());
    }

    AntChannelCommunicatorAidl(com.dsi.ant.channel.ipc.aidl.b bVar, boolean z2) {
        this.f358b = new Object();
        this.f359c = new Object();
        this.f360d = new Object();
        this.f361e = null;
        this.f362f = null;
        this.f365i = bVar;
        J();
        if (!z2) {
            this.f364h = null;
            return;
        }
        Binder binder = new Binder();
        this.f364h = binder;
        try {
            B(binder);
        } catch (RemoteException unused) {
        }
    }
}
