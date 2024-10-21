package com.dsi.ant.plugins.antplus.bikespdcad;

import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.os.RemoteException;
import com.dsi.ant.channel.AntChannel;
import com.dsi.ant.plugins.antplus.common.AntPluginService;
import com.dsi.ant.plugins.antplus.pccbase.AsyncScanController;
import com.dsi.ant.plugins.antplus.utility.search.ActivitySearchInfo;
import com.dsi.ant.plugins.antplus.utility.search.SearchResultInfo;
import com.dsi.ant.plugins.antplus.utility.search.c;
import com.dsi.ant.plugins.antplus.utility.search.d;
import com.dsi.ant.plugins.antplus.utility.search.e;
import com.dsi.ant.plugins.antplus.utility.search.f;
import com.dsi.ant.plugins.antplus.utility.search.j;
import com.dsi.ant.plugins.internal.pluginsipc.AntPluginDeviceDbProvider;
import j.i;
import java.nio.channels.ClosedChannelException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import v.e;
import w0.b;

/* loaded from: classes.dex */
public class CombinedBikeSpdCadService extends AntPluginService {

    /* renamed from: s */
    private static final String f418s = "CombinedBikeSpdCadService";

    /* renamed from: com.dsi.ant.plugins.antplus.bikespdcad.CombinedBikeSpdCadService$3 */
    /* loaded from: classes.dex */
    class AnonymousClass3 extends ActivitySearchInfo {

        /* renamed from: h */
        final /* synthetic */ b.C0065b f419h;

        /* renamed from: i */
        final /* synthetic */ Looper f420i;

        AnonymousClass3(b.C0065b c0065b, Looper looper) {
            c0065b = c0065b;
            looper = looper;
        }

        @Override // com.dsi.ant.plugins.antplus.utility.search.ActivitySearchInfo
        public boolean b(SearchResultInfo searchResultInfo, Bundle bundle) {
            boolean z2 = (bundle.getInt("int_ChannelDeviceId") & 536870912) != 0;
            if (z2 && searchResultInfo.f976a.b() != p0.c.BIKE_SPDCAD.b()) {
                return false;
            }
            if (z2 || searchResultInfo.f976a.b() != p0.c.BIKE_SPDCAD.b()) {
                return searchResultInfo.f976a.a() == (bundle.getInt("int_ChannelDeviceId") & (-536870913));
            }
            return false;
        }

        @Override // com.dsi.ant.plugins.antplus.utility.search.ActivitySearchInfo
        public Bundle c(SearchResultInfo searchResultInfo, Bundle bundle) {
            int i2;
            Bundle bundle2 = new Bundle();
            bundle2.putInt("int_DevType", searchResultInfo.f976a.b());
            bundle2.putInt("int_TransType", 0);
            bundle2.putInt("int_RfFreq", 57);
            int i3 = c.f426a[p0.c.c(searchResultInfo.f976a.b()).ordinal()];
            if (i3 == 1) {
                i2 = 8086;
            } else if (i3 == 2) {
                i2 = 8118;
            } else {
                if (i3 != 3) {
                    throw new RuntimeException("Non-bike spd/cad device found during spd/cad search.");
                }
                i2 = 8102;
            }
            bundle2.putInt("int_Period", i2);
            return bundle2;
        }

        @Override // com.dsi.ant.plugins.antplus.utility.search.ActivitySearchInfo
        public e d(SearchResultInfo searchResultInfo, Bundle bundle) {
            b.C0065b c0065b;
            int i2;
            b.C0065b c0065b2 = c0065b;
            j.b bVar = searchResultInfo.f976a;
            c0065b2.f3504a = bVar;
            c0065b2.f3507d = 0;
            int i3 = c.f426a[p0.c.c(bVar.b()).ordinal()];
            if (i3 == 1) {
                c0065b = c0065b;
                i2 = 8086;
            } else if (i3 == 2) {
                c0065b = c0065b;
                i2 = 8118;
            } else {
                if (i3 != 3) {
                    throw new RuntimeException("Non-bike spd/cad device found during spd/cad search.");
                }
                c0065b = c0065b;
                i2 = 8102;
            }
            c0065b.f3506c = i2;
            return CombinedBikeSpdCadService.this.u(c0065b, bundle, looper);
        }

        @Override // com.dsi.ant.plugins.antplus.utility.search.ActivitySearchInfo
        public String e(SearchResultInfo searchResultInfo, String str) {
            if (searchResultInfo.f976a.b() != p0.c.BIKE_SPDCAD.b()) {
                return str;
            }
            return str + " (S&C)";
        }
    }

    /* loaded from: classes.dex */
    public class a implements c.b {

        /* renamed from: a */
        final /* synthetic */ int f422a;

        a(int i2) {
            this.f422a = i2;
        }

        @Override // com.dsi.ant.plugins.antplus.utility.search.c.b
        public AntChannel a() {
            return CombinedBikeSpdCadService.this.f(com.dsi.ant.channel.b.ANT_PLUS, null, null, null, this.f422a);
        }
    }

    /* loaded from: classes.dex */
    public class b implements d.b {

        /* renamed from: a */
        final /* synthetic */ int f424a;

        b(int i2) {
            this.f424a = i2;
        }

        @Override // com.dsi.ant.plugins.antplus.utility.search.d.b
        public AntChannel a() {
            return CombinedBikeSpdCadService.this.f(com.dsi.ant.channel.b.ANT_PLUS, null, null, null, this.f424a);
        }
    }

    /* loaded from: classes.dex */
    static /* synthetic */ class c {

        /* renamed from: a */
        static final /* synthetic */ int[] f426a;

        static {
            int[] iArr = new int[p0.c.values().length];
            f426a = iArr;
            try {
                iArr[p0.c.BIKE_SPDCAD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f426a[p0.c.BIKE_SPD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f426a[p0.c.BIKE_CADENCE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static Boolean J(Bundle bundle) {
        if (bundle.containsKey("bool_IsSpdCadCombinedSensor")) {
            return Boolean.valueOf(bundle.getBoolean("bool_IsSpdCadCombinedSensor"));
        }
        h1.a.j(f418s, "Detected missing bike combo flag on bike request, enabling old pluginLib version compatibility");
        return null;
    }

    public static boolean K(Bundle bundle) {
        return bundle.getBoolean("bool_IsCadencePcc");
    }

    @Override // com.dsi.ant.plugins.antplus.common.AntPluginService
    protected void D(e.a aVar, v0.a aVar2, Bundle bundle) {
        boolean z2;
        synchronized (this.f435i) {
            Iterator it = this.f435i.iterator();
            while (it.hasNext()) {
                v.e eVar = (v.e) it.next();
                if (!eVar.g(aVar.f3452a, bundle)) {
                    if (!(eVar instanceof q.b)) {
                        if ((!K(bundle) || !(eVar instanceof m.a)) && (K(bundle) || !(eVar instanceof r.a))) {
                            break;
                        } else {
                            z2 = false;
                        }
                    } else {
                        z2 = true;
                    }
                    AsyncScanController.AsyncScanResultDeviceInfo asyncScanResultDeviceInfo = new AsyncScanController.AsyncScanResultDeviceInfo(null, eVar.f3451f, true);
                    Bundle bundle2 = new Bundle();
                    bundle2.putParcelable("parcelable_AsyncScanResultDeviceInfo", asyncScanResultDeviceInfo);
                    bundle2.putBoolean("bool_IsCombinedSensor", z2);
                    Message obtain = Message.obtain();
                    obtain.what = 2;
                    obtain.setData(bundle2);
                    try {
                        aVar2.b(obtain);
                    } catch (RemoteException unused) {
                        h1.a.b(f418s, "RemoteException sending async scan already connected devices, closing scan.");
                        E(aVar.f3454c);
                        return;
                    }
                }
            }
        }
    }

    @Override // com.dsi.ant.plugins.antplus.common.AntPluginService
    public boolean H(e.a aVar, v.e eVar, v0.a aVar2, Bundle bundle, Bundle bundle2) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        Bundle bundle3 = bundle;
        bundle3.putBoolean("bool_IsSpdCadCombinedSensor", eVar instanceof q.b);
        return super.H(aVar, eVar, aVar2, bundle3, bundle2);
    }

    @Override // com.dsi.ant.plugins.antplus.common.AntPluginService
    protected void h(Bundle bundle, e.a aVar, v0.a aVar2, Bundle bundle2) {
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        ArrayList<? extends Parcelable> arrayList2 = new ArrayList<>();
        synchronized (this.f435i) {
            Iterator it = this.f435i.iterator();
            while (it.hasNext()) {
                v.e eVar = (v.e) it.next();
                if (!eVar.g(aVar.f3452a, bundle2)) {
                    int intValue = eVar.f3451f.f1176d.intValue();
                    if (eVar instanceof q.b) {
                        intValue |= 536870912;
                    } else if (K(bundle2) || !(eVar instanceof m.a)) {
                        if (K(bundle2) && (eVar instanceof r.a)) {
                        }
                    }
                    Bundle bundle3 = new Bundle();
                    bundle3.putInt("int_ChannelDeviceId", intValue);
                    arrayList.add(bundle3);
                    arrayList2.add(eVar.f3451f);
                }
            }
        }
        bundle.putParcelableArrayList("albdlCONNECTEDDEVICES", arrayList);
        bundle.putParcelableArrayList("albdlCONNECTEDDEVICEINFOS", arrayList2);
    }

    @Override // com.dsi.ant.plugins.antplus.common.AntPluginService
    protected ActivitySearchInfo m(AntChannel antChannel, Bundle bundle, Looper looper) {
        b.C0065b c0065b = new b.C0065b();
        Bundle r2 = r(bundle);
        int i2 = r2.getInt("int_DevType");
        int i3 = r2.getInt("int_TransType");
        c0065b.f3504a = new j.b(0, i2, i3);
        c0065b.f3505b = r2.getInt("int_RfFreq");
        c0065b.f3506c = r2.getInt("int_Period");
        c0065b.f3507d = bundle.getInt("int_ProximityBin");
        c0065b.f3508e = i.TEN_SECONDS;
        AnonymousClass3 anonymousClass3 = new ActivitySearchInfo() { // from class: com.dsi.ant.plugins.antplus.bikespdcad.CombinedBikeSpdCadService.3

            /* renamed from: h */
            final /* synthetic */ b.C0065b f419h;

            /* renamed from: i */
            final /* synthetic */ Looper f420i;

            AnonymousClass3(b.C0065b c0065b2, Looper looper2) {
                c0065b = c0065b2;
                looper = looper2;
            }

            @Override // com.dsi.ant.plugins.antplus.utility.search.ActivitySearchInfo
            public boolean b(SearchResultInfo searchResultInfo, Bundle bundle2) {
                boolean z2 = (bundle2.getInt("int_ChannelDeviceId") & 536870912) != 0;
                if (z2 && searchResultInfo.f976a.b() != p0.c.BIKE_SPDCAD.b()) {
                    return false;
                }
                if (z2 || searchResultInfo.f976a.b() != p0.c.BIKE_SPDCAD.b()) {
                    return searchResultInfo.f976a.a() == (bundle2.getInt("int_ChannelDeviceId") & (-536870913));
                }
                return false;
            }

            @Override // com.dsi.ant.plugins.antplus.utility.search.ActivitySearchInfo
            public Bundle c(SearchResultInfo searchResultInfo, Bundle bundle2) {
                int i22;
                Bundle bundle22 = new Bundle();
                bundle22.putInt("int_DevType", searchResultInfo.f976a.b());
                bundle22.putInt("int_TransType", 0);
                bundle22.putInt("int_RfFreq", 57);
                int i32 = c.f426a[p0.c.c(searchResultInfo.f976a.b()).ordinal()];
                if (i32 == 1) {
                    i22 = 8086;
                } else if (i32 == 2) {
                    i22 = 8118;
                } else {
                    if (i32 != 3) {
                        throw new RuntimeException("Non-bike spd/cad device found during spd/cad search.");
                    }
                    i22 = 8102;
                }
                bundle22.putInt("int_Period", i22);
                return bundle22;
            }

            @Override // com.dsi.ant.plugins.antplus.utility.search.ActivitySearchInfo
            public com.dsi.ant.plugins.antplus.utility.search.e d(SearchResultInfo searchResultInfo, Bundle bundle2) {
                b.C0065b c0065b2;
                int i22;
                b.C0065b c0065b22 = c0065b;
                j.b bVar = searchResultInfo.f976a;
                c0065b22.f3504a = bVar;
                c0065b22.f3507d = 0;
                int i32 = c.f426a[p0.c.c(bVar.b()).ordinal()];
                if (i32 == 1) {
                    c0065b2 = c0065b;
                    i22 = 8086;
                } else if (i32 == 2) {
                    c0065b2 = c0065b;
                    i22 = 8118;
                } else {
                    if (i32 != 3) {
                        throw new RuntimeException("Non-bike spd/cad device found during spd/cad search.");
                    }
                    c0065b2 = c0065b;
                    i22 = 8102;
                }
                c0065b2.f3506c = i22;
                return CombinedBikeSpdCadService.this.u(c0065b, bundle2, looper);
            }

            @Override // com.dsi.ant.plugins.antplus.utility.search.ActivitySearchInfo
            public String e(SearchResultInfo searchResultInfo, String str) {
                if (searchResultInfo.f976a.b() != p0.c.BIKE_SPDCAD.b()) {
                    return str;
                }
                return str + " (S&C)";
            }
        };
        anonymousClass3.f903d = s(c0065b2, looper2, 20000L, bundle);
        anonymousClass3.f904e = c0065b2.f3507d;
        anonymousClass3.f900a = antChannel;
        t0.b bVar = new t0.b(this);
        try {
            AntPluginDeviceDbProvider.DeviceDbDeviceInfo h2 = bVar.h(r2.getString("str_PluginName"));
            if (h2 != null) {
                if (bVar.j(h2.f1174b.longValue())) {
                    i2 = p0.c.BIKE_SPDCAD.b();
                    c0065b2.f3506c = 8086;
                }
                c0065b2.f3504a = new j.b(h2.f1176d.intValue() & (-536870913), i2, i3);
                c0065b2.f3507d = 0;
                anonymousClass3.f901b = u(c0065b2, bundle, looper2);
                anonymousClass3.f902c = h2.f1177e;
            }
            return anonymousClass3;
        } finally {
            bVar.d();
        }
    }

    @Override // com.dsi.ant.plugins.antplus.common.AntPluginService
    public v.e n(AntChannel antChannel, AntPluginDeviceDbProvider.DeviceDbDeviceInfo deviceDbDeviceInfo, Bundle bundle, SearchResultInfo searchResultInfo) {
        try {
            try {
                int i2 = c.f426a[p0.c.c(antChannel.o().j().b()).ordinal()];
                if (i2 == 1) {
                    return new q.b(deviceDbDeviceInfo, antChannel);
                }
                if (i2 == 2) {
                    return new r.a(deviceDbDeviceInfo, antChannel);
                }
                if (i2 == 3) {
                    return new m.a(deviceDbDeviceInfo, antChannel);
                }
                h1.a.b(f418s, "Device instantiation failed: Unknown device type returned from search");
                return null;
            } catch (ClosedChannelException unused) {
                h1.a.b(f418s, "Device instantiation failed: Constructor threw ClosedChannelException");
                return null;
            }
        } catch (RemoteException unused2) {
            h1.a.b(f418s, "Device instantiation failed: RemoteException on channel");
            return null;
        } catch (g.a e3) {
            h1.a.b(f418s, "Device instantiation failed: ACFE requesting channel ID: " + e3.toString());
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x005d, code lost:            if (r2.g(r6, r7) == false) goto L116;     */
    @Override // com.dsi.ant.plugins.antplus.common.AntPluginService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected v.e p(int r5, java.lang.String r6, android.os.Bundle r7) {
        /*
            r4 = this;
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            java.lang.Boolean r1 = J(r7)
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L14
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r0 & r5
            if (r0 <= 0) goto L12
            goto L14
        L12:
            r0 = 0
            goto L15
        L14:
            r0 = 1
        L15:
            r1 = -536870913(0xffffffffdfffffff, float:-3.6893486E19)
            r5 = r5 & r1
            java.util.ArrayList r1 = r4.f435i
            monitor-enter(r1)
            java.util.ArrayList r4 = r4.f435i     // Catch: java.lang.Throwable -> L65
            java.util.Iterator r4 = r4.iterator()     // Catch: java.lang.Throwable -> L65
        L22:
            boolean r2 = r4.hasNext()     // Catch: java.lang.Throwable -> L65
            if (r2 == 0) goto L62
            java.lang.Object r2 = r4.next()     // Catch: java.lang.Throwable -> L65
            v.e r2 = (v.e) r2     // Catch: java.lang.Throwable -> L65
            if (r0 == 0) goto L35
            boolean r3 = r2 instanceof q.b     // Catch: java.lang.Throwable -> L65
            if (r3 != 0) goto L35
            goto L22
        L35:
            if (r5 == 0) goto L57
            com.dsi.ant.plugins.internal.pluginsipc.AntPluginDeviceDbProvider$DeviceDbDeviceInfo r3 = r2.f3451f     // Catch: java.lang.Throwable -> L65
            java.lang.Integer r3 = r3.f1176d     // Catch: java.lang.Throwable -> L65
            int r3 = r3.intValue()     // Catch: java.lang.Throwable -> L65
            if (r3 != r5) goto L22
            if (r0 != 0) goto L57
            boolean r3 = K(r7)     // Catch: java.lang.Throwable -> L65
            if (r3 == 0) goto L4d
            boolean r3 = r2 instanceof m.a     // Catch: java.lang.Throwable -> L65
            if (r3 != 0) goto L57
        L4d:
            boolean r3 = K(r7)     // Catch: java.lang.Throwable -> L65
            if (r3 != 0) goto L22
            boolean r3 = r2 instanceof r.a     // Catch: java.lang.Throwable -> L65
            if (r3 == 0) goto L22
        L57:
            if (r6 == 0) goto L60
            boolean r3 = r2.g(r6, r7)     // Catch: java.lang.Throwable -> L65
            if (r3 == 0) goto L60
            goto L22
        L60:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L65
            return r2
        L62:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L65
            r4 = 0
            return r4
        L65:
            r4 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L65
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dsi.ant.plugins.antplus.bikespdcad.CombinedBikeSpdCadService.p(int, java.lang.String, android.os.Bundle):v.e");
    }

    @Override // com.dsi.ant.plugins.antplus.common.AntPluginService
    public Bundle r(Bundle bundle) {
        int i2;
        Bundle bundle2 = new Bundle();
        if (K(bundle)) {
            p0.c cVar = p0.c.BIKE_CADENCE;
            bundle2.putString("str_PluginName", cVar.toString());
            bundle2.putSerializable("predefinednetwork_NetKey", com.dsi.ant.channel.b.ANT_PLUS);
            bundle2.putInt("int_DevType", cVar.b());
            i2 = 8102;
        } else {
            p0.c cVar2 = p0.c.BIKE_SPD;
            bundle2.putString("str_PluginName", cVar2.toString());
            bundle2.putSerializable("predefinednetwork_NetKey", com.dsi.ant.channel.b.ANT_PLUS);
            bundle2.putInt("int_DevType", cVar2.b());
            i2 = 8118;
        }
        bundle2.putInt("int_Period", i2);
        bundle2.putInt("int_TransType", 0);
        bundle2.putInt("int_RfFreq", 57);
        return bundle2;
    }

    @Override // com.dsi.ant.plugins.antplus.common.AntPluginService
    protected f s(b.C0065b c0065b, Looper looper, long j2, Bundle bundle) {
        b.C0065b c0065b2 = new b.C0065b();
        c0065b2.f3504a = new j.b(0, p0.c.BIKE_SPDCAD.b(), 0);
        c0065b2.f3506c = 8086;
        c0065b2.f3505b = 57;
        c0065b2.f3507d = c0065b.f3507d;
        c0065b2.f3508e = c0065b.f3508e;
        int i2 = bundle.getInt("int_RssiMode", 0);
        long j3 = j2 > 0 ? j2 / 2 : 10000L;
        return new d(new j(c0065b, looper, j3, new q.a()), new j(c0065b2, looper, j3, new q.a()), j2, new b(i2), looper);
    }

    @Override // com.dsi.ant.plugins.antplus.common.AntPluginService
    protected AntPluginDeviceDbProvider.DeviceDbDeviceInfo[] t(p0.c cVar) {
        Class cls;
        ArrayList arrayList;
        int i2 = c.f426a[cVar.ordinal()];
        if (i2 == 1) {
            cls = q.b.class;
        } else if (i2 == 2) {
            cls = r.a.class;
        } else {
            if (i2 != 3) {
                return null;
            }
            cls = m.a.class;
        }
        synchronized (this.f435i) {
            arrayList = new ArrayList(this.f435i.size());
            Iterator it = this.f435i.iterator();
            while (it.hasNext()) {
                v.e eVar = (v.e) it.next();
                if (cls.isInstance(eVar)) {
                    arrayList.add(eVar);
                }
            }
        }
        AntPluginDeviceDbProvider.DeviceDbDeviceInfo[] deviceDbDeviceInfoArr = new AntPluginDeviceDbProvider.DeviceDbDeviceInfo[arrayList.size()];
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            deviceDbDeviceInfoArr[i3] = ((v.e) arrayList.get(i3)).f3451f;
        }
        return deviceDbDeviceInfoArr;
    }

    @Override // com.dsi.ant.plugins.antplus.common.AntPluginService
    protected com.dsi.ant.plugins.antplus.utility.search.e u(b.C0065b c0065b, Bundle bundle, Looper looper) {
        b.C0065b c0065b2;
        Boolean J = J(bundle);
        if (J == null || (!J.booleanValue() && c0065b.f3504a.a() == 0)) {
            c0065b2 = new b.C0065b();
            c0065b2.f3504a = new j.b(0, p0.c.BIKE_SPDCAD.b(), 0);
            c0065b2.f3506c = 8086;
            c0065b2.f3505b = 57;
            c0065b2.f3507d = c0065b.f3507d;
            c0065b2.f3508e = c0065b.f3508e;
        } else {
            c0065b2 = null;
            if (J(bundle).booleanValue()) {
                b.C0065b c0065b3 = new b.C0065b();
                c0065b3.f3504a = new j.b(c0065b.f3504a.a(), p0.c.BIKE_SPDCAD.b(), 0);
                c0065b3.f3506c = 8086;
                c0065b3.f3505b = c0065b.f3505b;
                c0065b3.f3507d = c0065b.f3507d;
                c0065b3.f3508e = c0065b.f3508e;
                c0065b = c0065b3;
            }
        }
        if (c0065b2 == null) {
            return new com.dsi.ant.plugins.antplus.utility.search.i(c0065b, looper);
        }
        return new com.dsi.ant.plugins.antplus.utility.search.c(new com.dsi.ant.plugins.antplus.utility.search.i(c0065b, looper), new com.dsi.ant.plugins.antplus.utility.search.i(c0065b2, looper), new a(bundle.getInt("int_RssiMode", 0)), looper);
    }

    @Override // com.dsi.ant.plugins.antplus.common.AntPluginService
    public List v() {
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(p0.c.BIKE_CADENCE);
        arrayList.add(p0.c.BIKE_SPD);
        arrayList.add(p0.c.BIKE_SPDCAD);
        return arrayList;
    }
}
