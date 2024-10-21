package com.dsi.ant.channel;

import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import com.dsi.ant.channel.ipc.ServiceResult;
import com.dsi.ant.channel.ipc.aidl.AntChannelCommunicatorAidl;
import com.dsi.ant.message.LibConfig;
import com.dsi.ant.message.ipc.AntMessageParcel;
import g.d;
import g.e;
import j.f;
import j.h;
import j.i;
import k.c;
import k.j;
import k.l;
import l.k;

/* loaded from: classes.dex */
public final class AntChannel implements Parcelable {
    public static final Parcelable.Creator<AntChannel> CREATOR = new a();

    /* renamed from: d */
    private static final String f286d = "AntChannel";

    /* renamed from: a */
    private final h.a f287a;

    /* renamed from: b */
    private final b f288b = new b(this, null);

    /* renamed from: c */
    private volatile boolean f289c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public AntChannel createFromParcel(Parcel parcel) {
            return new AntChannel(AntChannelCommunicatorAidl.CREATOR.createFromParcel(parcel));
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public AntChannel[] newArray(int i2) {
            return new AntChannel[i2];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class b implements d {

        /* renamed from: a */
        private d f290a;

        private b() {
        }

        public void d(d dVar) {
            this.f290a = dVar;
        }

        @Override // g.d
        public void a(l lVar, AntMessageParcel antMessageParcel) {
            if (AntChannel.this.f289c) {
                this.f290a.a(lVar, antMessageParcel);
            }
        }

        @Override // g.d
        public void b() {
            if (AntChannel.this.f289c) {
                this.f290a.b();
            }
        }

        /* synthetic */ b(AntChannel antChannel, a aVar) {
            this();
        }
    }

    public AntChannel(h.a aVar) {
        this.f289c = false;
        if (aVar == null) {
            throw new IllegalArgumentException("Channel communicator provided  was null");
        }
        this.f287a = aVar;
        this.f289c = true;
    }

    private static void f(k kVar, Bundle bundle) {
        ServiceResult i2 = ServiceResult.i(bundle);
        if (i2.h()) {
            return;
        }
        if (!i2.a()) {
            throw new DeadObjectException();
        }
        throw new g.a(kVar, i2);
    }

    private k.b q(l lVar) {
        Bundle bundle = new Bundle();
        AntMessageParcel v2 = this.f287a.v(lVar, bundle);
        f(k.REQUEST_MESSAGE, bundle);
        return k.b.e(v2);
    }

    public void A(i iVar) {
        B(iVar, h.DISABLED);
    }

    public void B(i iVar, h hVar) {
        Bundle bundle = new Bundle();
        this.f287a.p(iVar, bundle);
        f(k.LOW_PRIORITY_SEARCH_TIMEOUT, bundle);
        Bundle bundle2 = new Bundle();
        this.f287a.t(hVar, bundle2);
        f(k.SEARCH_TIMEOUT, bundle2);
    }

    public void C(int i2) {
        Bundle bundle = new Bundle();
        this.f287a.f(i2, bundle);
        f(k.SET_CHANNEL_TRANSMIT_POWER, bundle);
    }

    public void D(byte[] bArr) {
        if (bArr.length != 8) {
            throw new IllegalArgumentException();
        }
        Bundle bundle = new Bundle();
        this.f287a.d(bArr, bundle);
        f(k.ACKNOWLEDGED_DATA, bundle);
    }

    public void E() {
        Bundle bundle = new Bundle();
        this.f287a.h(bundle);
        f(k.UNASSIGN_CHANNEL, bundle);
    }

    public void b(j.b bVar, int i2) {
        Bundle bundle = new Bundle();
        this.f287a.o(bVar, i2, bundle);
        f(k.ADD_CHANNEL_ID_TO_LIST, bundle);
    }

    public void c(j.d dVar) {
        try {
            d(dVar, new f());
        } catch (e unused) {
        }
    }

    public void d(j.d dVar, f fVar) {
        if (fVar.a() && !f.a.f()) {
            throw new e("Configuring fast channel initiation is not supported on installed version of ANT Radio Service");
        }
        Bundle bundle = new Bundle();
        this.f287a.a(dVar, fVar, bundle);
        f(k.ASSIGN_CHANNEL, bundle);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void e(byte[] bArr) {
        if (bArr.length < 8) {
            throw new IllegalArgumentException();
        }
        Bundle bundle = new Bundle();
        this.f287a.b(bArr, bundle);
        f(k.BURST_TRANSFER_DATA, bundle);
    }

    protected void finalize() {
        try {
            m();
        } finally {
            super.finalize();
        }
    }

    public void g() {
        this.f287a.m();
    }

    public void h() {
        Bundle bundle = new Bundle();
        this.f287a.l(bundle);
        f(k.CLOSE_CHANNEL, bundle);
    }

    public void i(int i2, boolean z2) {
        Bundle bundle = new Bundle();
        this.f287a.w(i2, z2, bundle);
        f(k.CONFIG_ID_LIST, bundle);
    }

    public void j() {
        v(EventBufferSettings.f336d);
    }

    public Capabilities k() {
        return this.f287a.i();
    }

    public void l() {
        Bundle bundle = new Bundle();
        this.f287a.q(bundle);
        f(k.OPEN_CHANNEL, bundle);
    }

    public void m() {
        try {
            this.f289c = false;
            this.f287a.e();
        } catch (RemoteException unused) {
        }
    }

    public c n() {
        return (c) q(l.ANT_VERSION);
    }

    public k.h o() {
        return (k.h) q(l.CHANNEL_ID);
    }

    public j p() {
        return (j) q(l.CHANNEL_STATUS);
    }

    public void r(LibConfig libConfig) {
        Bundle bundle = new Bundle();
        if (f.a.e()) {
            this.f287a.j(libConfig, bundle);
        } else {
            new ServiceResult(g.b.INVALID_REQUEST).k(bundle);
        }
        f(k.LIB_CONFIG, bundle);
    }

    public void s(byte[] bArr) {
        if (bArr.length != 8) {
            throw new IllegalArgumentException();
        }
        this.f287a.g(bArr, new Bundle());
    }

    public void t(d dVar) {
        if (dVar == null) {
            this.f289c = false;
            g();
        } else {
            this.f288b.d(dVar);
            this.f287a.n(this.f288b);
            this.f289c = true;
        }
    }

    public void u(j.b bVar) {
        Bundle bundle = new Bundle();
        this.f287a.u(bVar, bundle);
        f(k.CHANNEL_ID, bundle);
    }

    public void v(EventBufferSettings eventBufferSettings) {
        Bundle bundle = new Bundle();
        if (f.a.e()) {
            this.f287a.s(eventBufferSettings, bundle);
        } else {
            new ServiceResult(g.b.INVALID_REQUEST).k(bundle);
        }
        f(k.CONFIGURE_EVENT_BUFFER, bundle);
    }

    public void w() {
        v(EventBufferSettings.f335c);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        h.a aVar = this.f287a;
        if (aVar instanceof AntChannelCommunicatorAidl) {
            ((AntChannelCommunicatorAidl) aVar).writeToParcel(parcel, i2);
        } else {
            Log.e(f286d, "Could not parcel, unknown IPC communicator type");
        }
    }

    public void x(int i2) {
        Bundle bundle = new Bundle();
        this.f287a.r(i2, bundle);
        f(k.CHANNEL_PERIOD, bundle);
    }

    public void y(int i2) {
        Bundle bundle = new Bundle();
        this.f287a.k(i2, bundle);
        f(k.PROXIMITY_SEARCH, bundle);
    }

    public void z(int i2) {
        Bundle bundle = new Bundle();
        this.f287a.c(i2, bundle);
        f(k.CHANNEL_RF_FREQUENCY, bundle);
    }
}
