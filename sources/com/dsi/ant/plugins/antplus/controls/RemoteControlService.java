package com.dsi.ant.plugins.antplus.controls;

import a0.b;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import com.dsi.ant.channel.AntChannel;
import com.dsi.ant.plugins.antplus.common.AntPluginService;
import com.dsi.ant.plugins.antplus.pccbase.AsyncScanController;
import com.dsi.ant.plugins.antplus.utility.search.SearchResultInfo;
import com.dsi.ant.plugins.antplus.utility.search.f;
import com.dsi.ant.plugins.antplus.utility.search.i;
import com.dsi.ant.plugins.antplus.utility.search.j;
import com.dsi.ant.plugins.internal.pluginsipc.AntPluginDeviceDbProvider;
import java.nio.channels.ClosedChannelException;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import o0.g;
import p0.c;
import v.e;
import v0.a;
import w0.b;

/* loaded from: classes.dex */
public class RemoteControlService extends AntPluginService {

    /* renamed from: s */
    private static final String f492s = "RemoteControlService";

    public static EnumSet J(Bundle bundle) {
        return g.d(bundle.getLong("long_ControlsModes"));
    }

    @Override // com.dsi.ant.plugins.antplus.common.AntPluginService
    protected boolean A(int i2, Bundle bundle) {
        Iterator it = this.f435i.iterator();
        while (it.hasNext()) {
            if (((e) it.next()).f3451f.f1176d.intValue() == i2) {
                return true;
            }
        }
        return false;
    }

    @Override // com.dsi.ant.plugins.antplus.common.AntPluginService
    protected void D(e.a aVar, a aVar2, Bundle bundle) {
        EnumSet J = J(bundle);
        synchronized (this.f435i) {
            Iterator it = this.f435i.iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                if (((b) eVar).B(J)) {
                    Message obtain = Message.obtain();
                    obtain.what = 2;
                    Bundle bundle2 = new Bundle();
                    bundle2.putParcelable("parcelable_AsyncScanResultDeviceInfo", new AsyncScanController.AsyncScanResultDeviceInfo(null, eVar.f3451f, true));
                    obtain.setData(bundle2);
                    try {
                        aVar2.b(obtain);
                    } catch (RemoteException unused) {
                        h1.a.b(f492s, "RemoteException sending async scan already connected devices, closing scan.");
                        E(aVar.f3454c);
                        return;
                    }
                }
            }
        }
    }

    @Override // com.dsi.ant.plugins.antplus.common.AntPluginService
    public e n(AntChannel antChannel, AntPluginDeviceDbProvider.DeviceDbDeviceInfo deviceDbDeviceInfo, Bundle bundle, SearchResultInfo searchResultInfo) {
        try {
            return new b(deviceDbDeviceInfo, j1.a.b(this), antChannel, g.d(searchResultInfo.f978c.getLong("long_SupportedModes")));
        } catch (ClosedChannelException unused) {
            return null;
        }
    }

    @Override // com.dsi.ant.plugins.antplus.common.AntPluginService
    protected e p(int i2, String str, Bundle bundle) {
        EnumSet J = J(bundle);
        synchronized (this.f435i) {
            Iterator it = this.f435i.iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                if (i2 == 0 || eVar.f3451f.f1176d.intValue() == i2) {
                    b bVar = (b) eVar;
                    if (bVar.B(J)) {
                        return bVar;
                    }
                }
            }
            return null;
        }
    }

    @Override // com.dsi.ant.plugins.antplus.common.AntPluginService
    public Bundle r(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putString("str_PluginName", "Controllable Devices");
        bundle2.putSerializable("predefinednetwork_NetKey", com.dsi.ant.channel.b.ANT_PLUS);
        bundle2.putInt("int_DevType", 16);
        bundle2.putInt("int_TransType", 0);
        bundle2.putInt("int_Period", 8192);
        bundle2.putInt("int_RfFreq", 57);
        return bundle2;
    }

    @Override // com.dsi.ant.plugins.antplus.common.AntPluginService
    protected f s(b.C0065b c0065b, Looper looper, long j2, Bundle bundle) {
        return new j(c0065b, looper, j2, new c0.b(J(bundle)));
    }

    @Override // com.dsi.ant.plugins.antplus.common.AntPluginService
    protected com.dsi.ant.plugins.antplus.utility.search.e u(b.C0065b c0065b, Bundle bundle, Looper looper) {
        return new i(c0065b, looper, new c0.b(J(bundle)));
    }

    @Override // com.dsi.ant.plugins.antplus.common.AntPluginService
    public List v() {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(c.CONTROLLABLE_DEVICE);
        return arrayList;
    }

    @Override // com.dsi.ant.plugins.antplus.common.AntPluginService
    public boolean w(int i2, a aVar, e.a aVar2, Bundle bundle) {
        if (bundle.containsKey("long_PccMode")) {
            bundle.putLong("long_ControlsModes", bundle.getLong("long_PccMode") | bundle.getLong("long_ControlsModes"));
        }
        return super.w(i2, aVar, aVar2, bundle);
    }
}
