package com.dsi.ant.plugins.antplus.multisearch;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.dsi.ant.plugins.antplus.multisearch.b;
import com.dsi.ant.plugins.antplus.pccbase.AntPlusBikeSpdCadCommonPcc;
import com.dsi.ant.plugins.antplus.pccbase.MultiDeviceSearch$MultiDeviceSearchResult;
import com.dsi.ant.plugins.internal.pluginsipc.AntPluginDeviceDbProvider;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.UUID;
import p0.c;
import v.e;

/* loaded from: classes.dex */
public class a implements b.c {

    /* renamed from: a */
    private final MultiSearchService f502a;

    /* renamed from: b */
    private final e.a f503b;

    /* renamed from: c */
    private final HashSet f504c = new HashSet();

    /* renamed from: d */
    private final HashSet f505d = new HashSet();

    /* renamed from: e */
    private final EnumSet f506e = EnumSet.noneOf(c.class);

    /* renamed from: f */
    private final Object f507f;

    /* renamed from: g */
    private com.dsi.ant.plugins.antplus.multisearch.b f508g;

    /* renamed from: h */
    private boolean f509h;

    /* renamed from: i */
    private boolean f510i;

    /* renamed from: j */
    public final UUID f511j;

    /* renamed from: k */
    private final Handler f512k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.dsi.ant.plugins.antplus.multisearch.a$a */
    /* loaded from: classes.dex */
    public class HandlerC0009a extends Handler {
        HandlerC0009a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Bundle data = message.getData();
            data.setClassLoader(getClass().getClassLoader());
            if (!a.this.f511j.equals((UUID) data.getSerializable("uuid_AccessToken")) || a.this.f509h) {
                Message obtain = Message.obtain();
                obtain.what = message.what;
                obtain.arg1 = -3;
                try {
                    a.this.f503b.f3455d.b(obtain);
                } catch (RemoteException unused) {
                    a.this.f502a.L(a.this);
                }
            }
            Message obtain2 = Message.obtain();
            obtain2.what = message.what;
            int i2 = message.what;
            try {
                if (i2 == 10002) {
                    synchronized (a.this.f507f) {
                        a.this.f509h = true;
                    }
                } else if (i2 != 10101) {
                    obtain2.arg1 = -99999999;
                    a.this.f503b.f3455d.b(obtain2);
                    return;
                }
                a.this.f503b.f3455d.b(obtain2);
                return;
            } catch (RemoteException unused2) {
                a.this.f502a.L(a.this);
                return;
            }
            obtain2.arg1 = 0;
            a.this.a(p0.e.USER_CANCELLED.b());
        }
    }

    /* loaded from: classes.dex */
    public class b {

        /* renamed from: a */
        public final int f514a;

        /* renamed from: b */
        public final int f515b;

        public b(int i2, int i3) {
            this.f514a = i2;
            this.f515b = i3;
        }

        public int a() {
            return this.f514a + (this.f515b << 16);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && (obj instanceof b) && a() == ((b) obj).a();
        }

        public int hashCode() {
            return a();
        }
    }

    public a(Bundle bundle, e.a aVar, MultiSearchService multiSearchService) {
        Object obj = new Object();
        this.f507f = obj;
        this.f509h = false;
        this.f510i = false;
        this.f511j = UUID.randomUUID();
        this.f512k = new HandlerC0009a();
        synchronized (obj) {
            this.f502a = multiSearchService;
            this.f503b = aVar;
            for (int i2 : bundle.getIntArray("intarr_deviceTypeList")) {
                c c3 = c.c(i2);
                if (c3 != c.UNKNOWN) {
                    this.f506e.add(c3);
                }
            }
        }
    }

    private boolean j(c cVar) {
        boolean z2;
        synchronized (this.f507f) {
            c cVar2 = c.BIKE_SPDCAD;
            if (cVar != cVar2) {
                return this.f506e.contains(cVar);
            }
            if (!this.f506e.contains(c.BIKE_CADENCE) && !this.f506e.contains(c.BIKE_SPD) && !this.f506e.contains(cVar2)) {
                z2 = false;
                return z2;
            }
            z2 = true;
            return z2;
        }
    }

    private void l(MultiDeviceSearch$MultiDeviceSearchResult multiDeviceSearch$MultiDeviceSearchResult) {
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.arg1 = 1;
        Bundle bundle = new Bundle();
        bundle.putParcelable("dev_Device", multiDeviceSearch$MultiDeviceSearchResult);
        obtain.setData(bundle);
        this.f503b.f3455d.b(obtain);
    }

    private void m(int i2, int i3) {
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.arg1 = 2;
        Bundle bundle = new Bundle();
        bundle.putInt("int_resultID", i2);
        bundle.putInt("int_rssi", i3);
        obtain.setData(bundle);
        this.f503b.f3455d.b(obtain);
    }

    private AntPluginDeviceDbProvider.DeviceDbDeviceInfo o(int i2, int i3) {
        t0.b bVar = new t0.b(this.f502a);
        AntPluginDeviceDbProvider.DeviceDbDeviceInfo f3 = bVar.f(i2, c.c(i3).toString());
        bVar.d();
        if (f3 != null) {
            return f3;
        }
        AntPluginDeviceDbProvider.DeviceDbDeviceInfo deviceDbDeviceInfo = new AntPluginDeviceDbProvider.DeviceDbDeviceInfo();
        deviceDbDeviceInfo.f1176d = Integer.valueOf(i2);
        deviceDbDeviceInfo.f1178f = Boolean.FALSE;
        deviceDbDeviceInfo.f1177e = "Device: " + i2;
        return deviceDbDeviceInfo;
    }

    private MultiDeviceSearch$MultiDeviceSearchResult p(b bVar) {
        if (bVar.f515b == c.BIKE_SPDCAD.b()) {
            return q(bVar);
        }
        return new MultiDeviceSearch$MultiDeviceSearchResult(bVar.a(), c.c(bVar.f515b), o(bVar.f514a, bVar.f515b), false);
    }

    private AntPlusBikeSpdCadCommonPcc.MultiDeviceSearchSpdCadResult q(b bVar) {
        int i2 = bVar.f514a | 536870912;
        AntPluginDeviceDbProvider.DeviceDbDeviceInfo o2 = o(i2, c.BIKE_SPD.b());
        AntPluginDeviceDbProvider.DeviceDbDeviceInfo o3 = o(i2, c.BIKE_CADENCE.b());
        Integer valueOf = Integer.valueOf(o3.f1176d.intValue() & (-536870913));
        o3.f1176d = valueOf;
        o2.f1176d = valueOf;
        if (o2.f1174b == null) {
            String str = "Device: " + o2.f1176d;
            o3.f1177e = str;
            o2.f1177e = str;
        }
        return new AntPlusBikeSpdCadCommonPcc.MultiDeviceSearchSpdCadResult(bVar.a(), o2, o3, false);
    }

    @Override // com.dsi.ant.plugins.antplus.multisearch.b.c
    public void a(int i2) {
        synchronized (this.f507f) {
            if (this.f510i) {
                return;
            }
            this.f510i = true;
            this.f504c.clear();
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.arg1 = 4;
            obtain.arg2 = i2;
            try {
                this.f503b.f3455d.b(obtain);
            } catch (RemoteException unused) {
            }
            this.f502a.L(this);
        }
    }

    @Override // com.dsi.ant.plugins.antplus.multisearch.b.c
    public void b(j.b bVar, Integer num) {
        MultiDeviceSearch$MultiDeviceSearchResult multiDeviceSearch$MultiDeviceSearchResult;
        synchronized (this.f507f) {
            if (!this.f510i && j(c.c(bVar.b()))) {
                b bVar2 = new b(bVar.a(), bVar.b());
                if (this.f504c.add(bVar2)) {
                    multiDeviceSearch$MultiDeviceSearchResult = p(bVar2);
                    if (multiDeviceSearch$MultiDeviceSearchResult.d()) {
                        this.f505d.add(bVar2);
                    }
                } else {
                    multiDeviceSearch$MultiDeviceSearchResult = null;
                }
                boolean contains = this.f505d.contains(bVar2);
                if (multiDeviceSearch$MultiDeviceSearchResult != null) {
                    try {
                        l(multiDeviceSearch$MultiDeviceSearchResult);
                    } catch (RemoteException unused) {
                        this.f502a.L(this);
                        return;
                    }
                }
                if (contains || num == null) {
                    return;
                }
                m(bVar2.a(), num.intValue());
            }
        }
    }

    @Override // com.dsi.ant.plugins.antplus.multisearch.b.c
    public void c() {
        synchronized (this.f507f) {
            if (this.f510i) {
                return;
            }
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.arg1 = 3;
            try {
                this.f503b.f3455d.b(obtain);
            } catch (RemoteException unused) {
                this.f502a.L(this);
            }
        }
    }

    public void i(com.dsi.ant.plugins.antplus.multisearch.b bVar) {
        synchronized (this.f507f) {
            this.f508g = bVar;
            bVar.g(this);
        }
    }

    public void k() {
        synchronized (this.f507f) {
            this.f504c.clear();
            this.f508g.k(this);
            this.f510i = true;
            this.f509h = true;
        }
    }

    public Messenger n() {
        return new Messenger(this.f512k);
    }

    public void r(AntPluginDeviceDbProvider.DeviceDbDeviceInfo deviceDbDeviceInfo, c cVar) {
        MultiDeviceSearch$MultiDeviceSearchResult multiDeviceSearch$MultiDeviceSearchResult;
        synchronized (this.f507f) {
            if (!this.f510i && j(cVar)) {
                b bVar = new b(deviceDbDeviceInfo.f1176d.intValue(), cVar.b());
                if (this.f504c.add(bVar)) {
                    this.f505d.add(bVar);
                    multiDeviceSearch$MultiDeviceSearchResult = new MultiDeviceSearch$MultiDeviceSearchResult(bVar.a(), cVar, deviceDbDeviceInfo, true);
                } else {
                    multiDeviceSearch$MultiDeviceSearchResult = null;
                }
                if (multiDeviceSearch$MultiDeviceSearchResult != null) {
                    try {
                        l(multiDeviceSearch$MultiDeviceSearchResult);
                    } catch (RemoteException unused) {
                        this.f502a.L(this);
                    }
                }
            }
        }
    }
}
