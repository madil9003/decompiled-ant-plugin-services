package com.dsi.ant.plugins.antplus.bikepower;

import android.os.Bundle;
import com.dsi.ant.channel.AntChannel;
import com.dsi.ant.channel.b;
import com.dsi.ant.plugins.antplus.common.AntPluginService;
import com.dsi.ant.plugins.antplus.utility.search.SearchResultInfo;
import com.dsi.ant.plugins.internal.pluginsipc.AntPluginDeviceDbProvider;
import java.nio.channels.ClosedChannelException;
import java.util.ArrayList;
import java.util.List;
import o.c;
import v.e;

/* loaded from: classes.dex */
public class BikePowerService extends AntPluginService {
    @Override // com.dsi.ant.plugins.antplus.common.AntPluginService
    public e n(AntChannel antChannel, AntPluginDeviceDbProvider.DeviceDbDeviceInfo deviceDbDeviceInfo, Bundle bundle, SearchResultInfo searchResultInfo) {
        try {
            return new c(deviceDbDeviceInfo, antChannel, this);
        } catch (ClosedChannelException unused) {
            return null;
        }
    }

    @Override // com.dsi.ant.plugins.antplus.common.AntPluginService
    public Bundle r(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        p0.c cVar = p0.c.BIKE_POWER;
        bundle2.putString("str_PluginName", cVar.toString());
        bundle2.putSerializable("predefinednetwork_NetKey", b.ANT_PLUS);
        bundle2.putInt("int_DevType", cVar.b());
        bundle2.putInt("int_TransType", 0);
        bundle2.putInt("int_Period", 8182);
        bundle2.putInt("int_RfFreq", 57);
        return bundle2;
    }

    @Override // com.dsi.ant.plugins.antplus.common.AntPluginService
    public List v() {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(p0.c.BIKE_POWER);
        return arrayList;
    }
}
