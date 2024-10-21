package com.dsi.ant.channel;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a */
    private final h.b f339a;

    public a(IBinder iBinder) {
        this.f339a = new com.dsi.ant.channel.ipc.aidl.a(iBinder);
    }

    private static void d(AntChannel antChannel) {
        if (antChannel.k().h()) {
            try {
                antChannel.w();
            } catch (g.a unused) {
            }
        }
    }

    public AntChannel a(Context context, b bVar, Capabilities capabilities, Capabilities capabilities2) {
        if (b.INVALID == bVar) {
            throw new IllegalArgumentException("Invalid predefined network requested");
        }
        Bundle bundle = new Bundle();
        h.a a3 = this.f339a.a(context, bVar.b(), capabilities, capabilities2, bundle);
        if (a3 == null) {
            bundle.setClassLoader(ChannelNotAvailableException.class.getClassLoader());
            throw ((ChannelNotAvailableException) bundle.getParcelable("error"));
        }
        AntChannel antChannel = new AntChannel(a3);
        d(antChannel);
        return antChannel;
    }

    public int b() {
        return c(null);
    }

    public int c(Capabilities capabilities) {
        return this.f339a.h(capabilities);
    }
}
