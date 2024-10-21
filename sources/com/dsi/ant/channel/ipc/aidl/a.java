package com.dsi.ant.channel.ipc.aidl;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import com.dsi.ant.channel.Capabilities;
import com.dsi.ant.channel.ChannelNotAvailableException;
import com.dsi.ant.channel.ipc.aidl.b;
import com.dsi.ant.channel.ipc.aidl.c;
import java.util.Iterator;

/* loaded from: classes.dex */
public class a implements h.b {

    /* renamed from: a */
    private c f393a;

    /* renamed from: com.dsi.ant.channel.ipc.aidl.a$a */
    /* loaded from: classes.dex */
    enum EnumC0006a {
        UNKNOWN(-1),
        ACQUIRE_CHANNEL_PRIVATE_NETWORK(1),
        ACQUIRE_CHANNEL_PREDEFINED_NETWORK(2),
        ACQUIRE_CHANNEL_FROM_ADAPTER_PREDEFINED_NETWORK(3),
        ACQUIRE_CHANNEL_FROM_ADAPTER_PRIVATE_NETWORK(4),
        ACQUIRE_CONTINUOUS_SCAN_CONTROLLER(5);


        /* renamed from: h */
        private static final EnumC0006a[] f400h = values();

        /* renamed from: a */
        private final int f402a;

        EnumC0006a(int i2) {
            this.f402a = i2;
        }
    }

    public a(IBinder iBinder) {
        c a3 = c.a.a(iBinder);
        this.f393a = a3;
        if (a3 == null) {
            throw new IllegalArgumentException("The given service does not seem to be an ANT channel pool which communicates over AIDL.");
        }
    }

    private boolean b(Capabilities capabilities) {
        return capabilities == null || !capabilities.j() || f.a.f();
    }

    private AntIpcResult c(Message message, Bundle bundle) {
        AntIpcResult f3 = this.f393a.f(message, bundle);
        message.recycle();
        return f3;
    }

    @Override // h.b
    public h.a a(Context context, int i2, Capabilities capabilities, Capabilities capabilities2, Bundle bundle) {
        b m2;
        if (!b(capabilities)) {
            bundle.putParcelable("error", new ChannelNotAvailableException(g.c.NO_CHANNELS_MATCH_CRITERIA));
            return null;
        }
        if (f.a.d(context) >= 40400) {
            Message obtain = Message.obtain();
            obtain.what = EnumC0006a.ACQUIRE_CHANNEL_PREDEFINED_NETWORK.f402a;
            Bundle bundle2 = new Bundle();
            bundle2.putInt("com.dsi.channel.data.versioncode", 41600);
            bundle2.putInt("com.dsi.channel.data.predefinednetwork", i2);
            bundle2.putParcelable("com.dsi.channel.data.requiredcapabilities", capabilities);
            bundle2.putParcelable("com.dsi.channel.data.desiredcapabilities", capabilities2);
            obtain.setData(bundle2);
            Iterator it = c(obtain, bundle).a().iterator();
            m2 = it.hasNext() ? b.a.a((IBinder) it.next()) : null;
        } else {
            m2 = this.f393a.m(i2, capabilities, capabilities2, bundle);
        }
        if (m2 != null) {
            return new AntChannelCommunicatorAidl(m2);
        }
        return null;
    }

    @Override // h.b
    public int h(Capabilities capabilities) {
        if (b(capabilities)) {
            return this.f393a.h(capabilities);
        }
        return 0;
    }
}
