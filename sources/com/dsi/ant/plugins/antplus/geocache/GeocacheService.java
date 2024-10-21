package com.dsi.ant.plugins.antplus.geocache;

import android.os.Bundle;
import android.os.Message;
import com.dsi.ant.channel.AntChannel;
import com.dsi.ant.channel.b;
import com.dsi.ant.plugins.antplus.common.AntPluginService;
import com.dsi.ant.plugins.antplus.utility.search.SearchResultInfo;
import com.dsi.ant.plugins.internal.pluginsipc.AntPluginDeviceDbProvider;
import i0.a;
import java.nio.channels.ClosedChannelException;
import java.util.List;
import p0.c;
import v.e;

/* loaded from: classes.dex */
public class GeocacheService extends AntPluginService {

    /* renamed from: t */
    private static final String f495t = "GeocacheService";

    /* renamed from: s */
    a f496s;

    @Override // com.dsi.ant.plugins.antplus.common.AntPluginService
    public e n(AntChannel antChannel, AntPluginDeviceDbProvider.DeviceDbDeviceInfo deviceDbDeviceInfo, Bundle bundle, SearchResultInfo searchResultInfo) {
        return null;
    }

    @Override // com.dsi.ant.plugins.antplus.common.AntPluginService
    public Bundle r(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        c cVar = c.GEOCACHE;
        bundle2.putString("str_PluginName", cVar.toString());
        bundle2.putSerializable("predefinednetwork_NetKey", b.ANT_PLUS);
        bundle2.putInt("int_RfFreq", 57);
        bundle2.putInt("int_TransType", 0);
        bundle2.putInt("int_DevType", cVar.b());
        bundle2.putInt("int_Period", 8192);
        return bundle2;
    }

    @Override // com.dsi.ant.plugins.antplus.common.AntPluginService
    public List v() {
        return null;
    }

    @Override // com.dsi.ant.plugins.antplus.common.AntPluginService
    public boolean w(int i2, v0.a aVar, e.a aVar2, Bundle bundle) {
        if (i2 != 300) {
            return false;
        }
        a aVar3 = this.f496s;
        if (aVar3 == null || aVar3.h()) {
            AntChannel g3 = g(b.ANT_PLUS, null, null, aVar, aVar2);
            if (g3 == null) {
                return true;
            }
            try {
                this.f496s = new a(g3, this);
            } catch (ClosedChannelException unused) {
                h1.a.b(f495t, "Failed to instantiate device: Constructor threw ClosedChannelException.");
                Message obtain = Message.obtain();
                obtain.what = -4;
                o(aVar, obtain);
                return true;
            }
        }
        if (!H(aVar2, this.f496s, aVar, null, bundle) && this.f496s.f3446a.size() == 0) {
            this.f496s.d();
        }
        return true;
    }
}
