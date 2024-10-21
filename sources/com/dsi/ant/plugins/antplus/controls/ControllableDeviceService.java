package com.dsi.ant.plugins.antplus.controls;

import a0.a;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Message;
import com.dsi.ant.channel.AntChannel;
import com.dsi.ant.channel.b;
import com.dsi.ant.plugins.antplus.common.AntPluginService;
import com.dsi.ant.plugins.antplus.utility.search.SearchResultInfo;
import com.dsi.ant.plugins.internal.pluginsipc.AntPluginDeviceDbProvider;
import java.nio.channels.ClosedChannelException;
import java.util.List;
import java.util.UUID;
import o0.g;
import p0.c;
import v.e;

/* loaded from: classes.dex */
public class ControllableDeviceService extends AntPluginService {

    /* renamed from: t */
    private static final String f490t = "ControllableDeviceService";

    /* renamed from: s */
    a f491s;

    @Override // com.dsi.ant.plugins.antplus.common.AntPluginService
    public e n(AntChannel antChannel, AntPluginDeviceDbProvider.DeviceDbDeviceInfo deviceDbDeviceInfo, Bundle bundle, SearchResultInfo searchResultInfo) {
        return null;
    }

    @Override // com.dsi.ant.plugins.antplus.common.AntPluginService
    public Bundle r(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        c cVar = c.CONTROLLABLE_DEVICE;
        bundle2.putString("str_PluginName", cVar.toString());
        bundle2.putSerializable("predefinednetwork_NetKey", b.ANT_PLUS);
        bundle2.putInt("int_RfFreq", 57);
        bundle2.putInt("int_TransType", 5);
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
        Message obtain;
        aVar2.f3454c = UUID.randomUUID();
        g c3 = g.c(i2);
        int i3 = 0;
        if (!a.u(c3)) {
            return false;
        }
        a aVar3 = this.f491s;
        if (aVar3 == null || aVar3.h() || !this.f491s.t(c3)) {
            int i4 = bundle.getInt("int_ChannelDeviceId");
            if (i4 >= 0 && i4 <= 65535) {
                a aVar4 = this.f491s;
                if (aVar4 == null || aVar4.h()) {
                    Bundle r2 = r(bundle);
                    if (i4 != 0 || (i4 = j1.a.b(this)) != -1) {
                        int i5 = i4;
                        AntChannel g3 = g(b.ANT_PLUS, null, null, aVar, aVar2);
                        if (g3 == null) {
                            return true;
                        }
                        try {
                            i3 = getPackageManager().getPackageInfo(getPackageName(), 128).versionCode;
                        } catch (PackageManager.NameNotFoundException e3) {
                            h1.a.k(f490t, "Unable to retrieve software version: ", e3);
                        }
                        try {
                            AntPluginDeviceDbProvider.DeviceDbDeviceInfo deviceDbDeviceInfo = new AntPluginDeviceDbProvider.DeviceDbDeviceInfo();
                            deviceDbDeviceInfo.f1176d = Integer.valueOf(i5);
                            this.f491s = new a(deviceDbDeviceInfo, g3, r2, i3);
                        } catch (ClosedChannelException unused) {
                            h1.a.b(f490t, "Failed to instantiate device: Constructor threw ClosedChannelException.");
                        }
                    }
                    obtain = Message.obtain();
                    obtain.what = -4;
                } else if (i4 != 0 && i4 != this.f491s.f3451f.f1176d.intValue()) {
                    h1.a.b(f490t, "Client requested a custom DeviceNumber when one is already set");
                }
                if (!H(aVar2, this.f491s, aVar, null, bundle) && this.f491s.f3446a.size() == 0) {
                    this.f491s.d();
                }
                return true;
            }
            h1.a.a(f490t, "Requested device number out of range, value: " + i4);
            obtain = Message.obtain();
            obtain.what = -9;
            o(aVar, obtain);
            return true;
        }
        obtain = Message.obtain();
        obtain.what = -6;
        o(aVar, obtain);
        return true;
    }
}
