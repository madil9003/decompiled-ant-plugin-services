package com.dsi.ant.plugins.antplus.weightscale;

import android.os.Bundle;
import com.dsi.ant.channel.AntChannel;
import com.dsi.ant.channel.b;
import com.dsi.ant.plugins.antplus.common.AntPluginService;
import com.dsi.ant.plugins.antplus.utility.search.SearchResultInfo;
import com.dsi.ant.plugins.internal.pluginsipc.AntPluginDeviceDbProvider;
import java.nio.channels.ClosedChannelException;
import java.util.ArrayList;
import java.util.List;
import p0.c;
import v.e;
import z0.a;

/* loaded from: classes.dex */
public class WeightScaleService extends AntPluginService {
    @Override // com.dsi.ant.plugins.antplus.common.AntPluginService
    public e n(AntChannel antChannel, AntPluginDeviceDbProvider.DeviceDbDeviceInfo deviceDbDeviceInfo, Bundle bundle, SearchResultInfo searchResultInfo) {
        try {
            return new a(deviceDbDeviceInfo, antChannel, this);
        } catch (ClosedChannelException unused) {
            return null;
        }
    }

    @Override // com.dsi.ant.plugins.antplus.common.AntPluginService
    public Bundle r(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        c cVar = c.WEIGHT_SCALE;
        bundle2.putString("str_PluginName", cVar.toString());
        bundle2.putSerializable("predefinednetwork_NetKey", b.ANT_PLUS);
        bundle2.putInt("int_DevType", cVar.b());
        bundle2.putInt("int_TransType", 0);
        bundle2.putInt("int_Period", 8192);
        bundle2.putInt("int_RfFreq", 57);
        return bundle2;
    }

    @Override // com.dsi.ant.plugins.antplus.common.AntPluginService
    public List v() {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(c.WEIGHT_SCALE);
        return arrayList;
    }
}
