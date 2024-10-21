package com.dsi.ant.plugins.antplus.multisearch;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.RemoteException;
import com.dsi.ant.channel.AntChannel;
import com.dsi.ant.plugins.antplus.common.AntPluginService;
import com.dsi.ant.plugins.antplus.utility.search.SearchResultInfo;
import com.dsi.ant.plugins.internal.pluginsipc.AntPluginDeviceDbProvider;
import java.util.HashSet;
import java.util.List;
import p0.c;
import v.e;

/* loaded from: classes.dex */
public class MultiSearchService extends AntPluginService {

    /* renamed from: s */
    private final b f497s = new b();

    /* renamed from: t */
    private final HashSet f498t = new HashSet();

    /* renamed from: u */
    private final Object f499u = new Object();

    /* loaded from: classes.dex */
    public class a extends Handler {

        /* renamed from: a */
        final /* synthetic */ com.dsi.ant.plugins.antplus.multisearch.a f500a;

        a(com.dsi.ant.plugins.antplus.multisearch.a aVar) {
            this.f500a = aVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 0) {
                return;
            }
            Bundle data = message.getData();
            data.setClassLoader(AntPluginDeviceDbProvider.DeviceDbDeviceInfo.class.getClassLoader());
            c c3 = c.c(data.getInt("DevType_int"));
            for (Parcelable parcelable : data.getParcelableArray("DevDbInfoList_parcelableArray")) {
                this.f500a.r((AntPluginDeviceDbProvider.DeviceDbDeviceInfo) parcelable, c3);
            }
        }
    }

    private void J(com.dsi.ant.plugins.antplus.multisearch.a aVar) {
        synchronized (this.f499u) {
            this.f498t.add(aVar);
            aVar.i(this.f497s);
        }
    }

    private boolean K(v0.a aVar, e.a aVar2, int i2) {
        synchronized (this.f499u) {
            if (this.f497s.f()) {
                if (this.f497s.h()) {
                    return true;
                }
                if (i2 == 0) {
                    return true;
                }
            }
            AntChannel f3 = f(com.dsi.ant.channel.b.ANT_PLUS, null, aVar, aVar2, i2);
            if (f3 == null) {
                if (this.f497s.f()) {
                    return true;
                }
                Message obtain = Message.obtain();
                obtain.what = -3;
                o(aVar, obtain);
                return false;
            }
            int i3 = this.f497s.i(f3);
            if (i3 == 0) {
                return true;
            }
            Message obtain2 = Message.obtain();
            obtain2.what = i3;
            o(aVar, obtain2);
            return false;
        }
    }

    private void M(com.dsi.ant.plugins.antplus.multisearch.a aVar) {
        Messenger messenger = new Messenger(new a(aVar));
        Intent intent = new Intent("com.dsi.ant.plugins.antplus.queryalreadyconnecteddevices");
        Bundle bundle = new Bundle();
        bundle.putInt("Version_int", 0);
        bundle.putInt("CmdSeqNum_int", 0);
        bundle.putParcelable("ResultMsgr_messenger", messenger);
        bundle.putInt("Mode_int", 0);
        bundle.putInt("DevType_int", 0);
        intent.putExtra("com.dsi.ant.plugins.antplus.queryalreadyconnecteddevices.params", bundle);
        sendBroadcast(intent);
    }

    public void L(com.dsi.ant.plugins.antplus.multisearch.a aVar) {
        synchronized (this.f499u) {
            if (this.f498t.remove(aVar)) {
                aVar.k();
            }
            if (this.f498t.isEmpty()) {
                this.f497s.j();
            }
        }
    }

    @Override // com.dsi.ant.plugins.antplus.common.AntPluginService
    public e n(AntChannel antChannel, AntPluginDeviceDbProvider.DeviceDbDeviceInfo deviceDbDeviceInfo, Bundle bundle, SearchResultInfo searchResultInfo) {
        throw new UnsupportedOperationException("Multi device search does not allow deviceconnection.");
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
    public boolean w(int i2, v0.a aVar, e.a aVar2, Bundle bundle) {
        int i3 = bundle.getInt("int_RssiMode", 0);
        if (i2 != 2) {
            return false;
        }
        synchronized (this.f499u) {
            if (!K(aVar, aVar2, i3)) {
                return true;
            }
            com.dsi.ant.plugins.antplus.multisearch.a aVar3 = new com.dsi.ant.plugins.antplus.multisearch.a(bundle, aVar2, this);
            J(aVar3);
            Message obtain = Message.obtain();
            obtain.what = 0;
            Bundle bundle2 = new Bundle();
            bundle2.putSerializable("uuid_AccessToken", aVar3.f511j);
            bundle2.putParcelable("msgr_PluginComm", aVar3.n());
            bundle2.putBoolean("bool_RssiSupport", this.f497s.h());
            obtain.setData(bundle2);
            try {
                aVar.b(obtain);
            } catch (RemoteException unused) {
                L(aVar3);
            }
            M(aVar3);
            return true;
        }
    }
}
