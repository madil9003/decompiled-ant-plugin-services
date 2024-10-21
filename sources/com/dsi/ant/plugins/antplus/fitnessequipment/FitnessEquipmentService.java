package com.dsi.ant.plugins.antplus.fitnessequipment;

import android.os.Bundle;
import android.os.Message;
import android.os.Parcelable;
import com.dsi.ant.channel.AntChannel;
import com.dsi.ant.channel.b;
import com.dsi.ant.plugins.antplus.common.AntPluginService;
import com.dsi.ant.plugins.antplus.common.FitFileCommon;
import com.dsi.ant.plugins.antplus.utility.search.SearchResultInfo;
import com.dsi.ant.plugins.internal.pluginsipc.AntPluginDeviceDbProvider;
import f0.a;
import java.nio.channels.ClosedChannelException;
import java.util.ArrayList;
import java.util.List;
import p0.c;
import v.e;

/* loaded from: classes.dex */
public class FitnessEquipmentService extends AntPluginService {

    /* renamed from: t */
    private static final String f493t = "FitnessEquipmentService";

    /* renamed from: s */
    private a f494s = null;

    @Override // com.dsi.ant.plugins.antplus.common.AntPluginService
    public e n(AntChannel antChannel, AntPluginDeviceDbProvider.DeviceDbDeviceInfo deviceDbDeviceInfo, Bundle bundle, SearchResultInfo searchResultInfo) {
        try {
            return new a(deviceDbDeviceInfo, antChannel);
        } catch (ClosedChannelException unused) {
            return null;
        }
    }

    @Override // com.dsi.ant.plugins.antplus.common.AntPluginService
    public Bundle r(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        c cVar = c.FITNESS_EQUIPMENT;
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
        arrayList.add(c.FITNESS_EQUIPMENT);
        return arrayList;
    }

    @Override // com.dsi.ant.plugins.antplus.common.AntPluginService
    public boolean w(int i2, v0.a aVar, e.a aVar2, Bundle bundle) {
        FitFileCommon.FitFile[] fitFileArr;
        Message obtain;
        if (i2 != 300) {
            return super.w(i2, aVar, aVar2, bundle);
        }
        a aVar3 = this.f494s;
        if (aVar3 == null || aVar3.h()) {
            int i3 = bundle.getInt("int_ChannelDeviceId");
            if (i3 < 0 || i3 > 65535) {
                h1.a.a(f493t, "Requested device number out of range, value: " + i3);
                Message obtain2 = Message.obtain();
                obtain2.what = -9;
                o(aVar, obtain2);
                return false;
            }
            if (i3 != 0 || (i3 = j1.a.b(this)) != -1) {
                int i4 = i3;
                FitFileCommon.FitFile fitFile = (FitFileCommon.FitFile) bundle.getParcelable("parcelable_settings");
                Parcelable[] parcelableArray = bundle.getParcelableArray("arrayParcelable_fitFiles");
                if (parcelableArray == null || parcelableArray.length == 0) {
                    fitFileArr = null;
                } else {
                    FitFileCommon.FitFile[] fitFileArr2 = new FitFileCommon.FitFile[parcelableArray.length];
                    for (int i5 = 0; i5 < parcelableArray.length; i5++) {
                        fitFileArr2[i5] = (FitFileCommon.FitFile) parcelableArray[i5];
                    }
                    fitFileArr = fitFileArr2;
                }
                b bVar = b.ANT_PLUS;
                AntChannel g3 = g(bVar, null, null, aVar, aVar2);
                if (g3 == null) {
                    return true;
                }
                AntChannel g4 = g(bVar, null, null, aVar, aVar2);
                if (g4 == null) {
                    g3.m();
                    return true;
                }
                try {
                    AntPluginDeviceDbProvider.DeviceDbDeviceInfo deviceDbDeviceInfo = new AntPluginDeviceDbProvider.DeviceDbDeviceInfo();
                    deviceDbDeviceInfo.f1176d = Integer.valueOf(i4);
                    a aVar4 = new a(deviceDbDeviceInfo, g3, g4, fitFile, fitFileArr);
                    this.f494s = aVar4;
                    if (!H(aVar2, aVar4, aVar, null, bundle)) {
                        g3.m();
                        g4.m();
                        this.f494s = null;
                    }
                    return true;
                } catch (ClosedChannelException unused) {
                    g3.m();
                    g4.m();
                    h1.a.b(f493t, "Failed to instantiate device: Constructor threw ClosedChannelException.");
                }
            }
            obtain = Message.obtain();
            obtain.what = -4;
        } else {
            h1.a.b(f493t, "Client requested a FE session, but one is already in progress");
            obtain = Message.obtain();
            obtain.what = -6;
        }
        o(aVar, obtain);
        return true;
    }
}
