package com.dsi.ant.plugins.antplus.utility.db;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.dsi.ant.plugins.internal.pluginsipc.AntPluginDeviceDbProvider;
import java.util.LinkedList;
import t0.b;

/* loaded from: classes.dex */
public class Service_DeviceDbProvider extends Service {

    /* renamed from: d */
    private static final String f885d = "Service_DeviceDbProvider";

    /* renamed from: a */
    private final Object f886a = new Object();

    /* renamed from: b */
    private LinkedList f887b = new LinkedList();

    /* renamed from: c */
    Integer f888c;

    /* loaded from: classes.dex */
    class a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Bundle f889a;

        /* renamed from: b */
        final /* synthetic */ int f890b;

        a(Bundle bundle, int i2) {
            this.f889a = bundle;
            this.f890b = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Service_DeviceDbProvider.this.c(this.f889a, Integer.valueOf(this.f890b));
        }
    }

    private void b(Integer num) {
        synchronized (this.f886a) {
            this.f887b.remove(num);
            if (!this.f887b.iterator().hasNext()) {
                stopSelf(this.f888c.intValue());
            }
        }
    }

    public void c(Bundle bundle, Integer num) {
        b bVar;
        bundle.setClassLoader(getClassLoader());
        int i2 = bundle.getInt("int_RequestType");
        Bundle bundle2 = new Bundle();
        bundle2.putInt("int_ResultCode", -1);
        try {
            if (i2 == 18) {
                int i3 = bundle.getInt("int_AntDeviceNumber");
                String string = bundle.getString("string_PluginName");
                bVar = new b(this);
                try {
                    AntPluginDeviceDbProvider.DeviceDbDeviceInfo f3 = bVar.f(i3, string);
                    if (f3 != null) {
                        bundle2.putParcelable("parcelable_DeviceDbInfo", f3);
                    }
                    bundle2.putInt("int_ResultCode", 0);
                    bVar.d();
                } finally {
                }
            } else if (i2 == 20) {
                AntPluginDeviceDbProvider.DeviceDbDeviceInfo deviceDbDeviceInfo = (AntPluginDeviceDbProvider.DeviceDbDeviceInfo) bundle.getParcelable("parcelable_DeviceDbInfo");
                String string2 = bundle.getString("string_PluginName");
                Bundle bundle3 = bundle.getBundle("bundle_PluginDeviceParams");
                int i4 = bundle3.getInt("int_DevType");
                int i5 = bundle3.getInt("int_TransType");
                int i6 = bundle3.getInt("int_Period");
                int i7 = bundle3.getInt("int_RfFreq");
                com.dsi.ant.channel.b bVar2 = (com.dsi.ant.channel.b) bundle3.getSerializable("predefinednetwork_NetKey");
                bVar = new b(this);
                try {
                    bVar.b(deviceDbDeviceInfo, string2, bVar2, i4, i5, i6, i7);
                    bundle2.putInt("int_ResultCode", 0);
                    bVar.d();
                } finally {
                }
            } else if (i2 != 22) {
                h1.a.b(f885d, "Unrecognized command");
                bundle2.putInt("int_ResultCode", -2);
            } else {
                AntPluginDeviceDbProvider.DeviceDbDeviceInfo deviceDbDeviceInfo2 = (AntPluginDeviceDbProvider.DeviceDbDeviceInfo) bundle.getParcelable("parcelable_DeviceDbInfo");
                String string3 = bundle.getString("string_DISPLAYNAME");
                boolean z2 = bundle.getBoolean("boolean_IsUserPreferredDevice");
                bVar = new b(this);
                try {
                    bVar.n(deviceDbDeviceInfo2, string3, Boolean.valueOf(z2));
                    bundle2.putInt("int_ResultCode", 0);
                    bVar.d();
                } finally {
                }
            }
        } finally {
            Messenger messenger = (Messenger) bundle.getParcelable("msgr_ResultReceiver");
            try {
                Message obtain = Message.obtain();
                obtain.what = i2;
                obtain.setData(bundle2);
                messenger.send(obtain);
                h1.a.i(f885d, "sent db result: " + num);
            } catch (RemoteException unused) {
                h1.a.b(f885d, "RemoteException sending result to query");
            }
            b(num);
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        synchronized (this.f886a) {
            this.f887b.add(Integer.valueOf(i3));
            this.f888c = Integer.valueOf(i3);
            String str = f885d;
            h1.a.i(str, "received db request: " + i3);
            int onStartCommand = super.onStartCommand(intent, i2, i3);
            Bundle bundleExtra = intent == null ? null : intent.getBundleExtra("com.dsi.ant.plugins.antplus.utility.db.devicedbrequest");
            if (intent != null && bundleExtra != null) {
                new Thread(new a(bundleExtra, i3)).start();
                return onStartCommand;
            }
            h1.a.b(str, "Attempt to start service with illegal arguments");
            b(Integer.valueOf(i3));
            return onStartCommand;
        }
    }
}
