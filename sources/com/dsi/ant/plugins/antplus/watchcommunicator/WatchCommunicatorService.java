package com.dsi.ant.plugins.antplus.watchcommunicator;

import android.os.Bundle;
import android.os.Message;
import com.dsi.ant.channel.AntChannel;
import com.dsi.ant.plugins.antplus.common.AntPluginService;
import com.dsi.ant.plugins.antplus.utility.search.SearchResultInfo;
import com.dsi.ant.plugins.internal.pluginsipc.AntPluginDeviceDbProvider;
import java.nio.channels.ClosedChannelException;
import java.util.List;
import v.e;
import v0.a;
import x0.b;

/* loaded from: classes.dex */
public class WatchCommunicatorService extends AntPluginService {

    /* renamed from: t */
    private static final String f1164t = "WatchCommunicatorService";

    /* renamed from: s */
    b f1165s;

    @Override // com.dsi.ant.plugins.antplus.common.AntPluginService
    public e n(AntChannel antChannel, AntPluginDeviceDbProvider.DeviceDbDeviceInfo deviceDbDeviceInfo, Bundle bundle, SearchResultInfo searchResultInfo) {
        return null;
    }

    @Override // com.dsi.ant.plugins.antplus.common.AntPluginService
    public Bundle r(Bundle bundle) {
        return null;
    }

    @Override // com.dsi.ant.plugins.antplus.common.AntPluginService
    public List v() {
        return null;
    }

    @Override // com.dsi.ant.plugins.antplus.common.AntPluginService
    public boolean w(int i2, a aVar, e.a aVar2, Bundle bundle) {
        if (i2 != 300) {
            return false;
        }
        b bVar = this.f1165s;
        if (bVar == null || bVar.h()) {
            AntChannel g3 = g(com.dsi.ant.channel.b.ANT_FS, null, null, aVar, aVar2);
            if (g3 == null) {
                return true;
            }
            try {
                this.f1165s = new b(g3, this);
            } catch (ClosedChannelException unused) {
                h1.a.b(f1164t, "Failed to instantiate device: Constructor threw ClosedChannelException.");
                Message obtain = Message.obtain();
                obtain.what = -4;
                o(aVar, obtain);
                return true;
            }
        }
        if (!H(aVar2, this.f1165s, aVar, null, bundle) && this.f1165s.f3446a.size() == 0) {
            this.f1165s.d();
        }
        return true;
    }
}
