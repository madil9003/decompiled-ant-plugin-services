package com.dsi.ant.plugins.antplus.common;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.RemoteException;
import android.os.SystemClock;
import com.dsi.ant.channel.AntChannel;
import com.dsi.ant.channel.Capabilities;
import com.dsi.ant.channel.ChannelNotAvailableException;
import com.dsi.ant.plugins.antplus.R;
import com.dsi.ant.plugins.antplus.pccbase.AsyncScanController;
import com.dsi.ant.plugins.antplus.utility.search.ActivitySearchInfo;
import com.dsi.ant.plugins.antplus.utility.search.SearchResultInfo;
import com.dsi.ant.plugins.antplus.utility.search.e;
import com.dsi.ant.plugins.antplus.utility.search.f;
import com.dsi.ant.plugins.internal.pluginsipc.AntPluginDeviceDbProvider;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import v.e;
import w0.b;

/* loaded from: classes.dex */
public abstract class AntPluginService extends Service {

    /* renamed from: c */
    public ServiceConnection f429c;

    /* renamed from: n */
    HandlerThread f440n;

    /* renamed from: o */
    Messenger f441o;

    /* renamed from: p */
    HandlerThread f442p;

    /* renamed from: q */
    protected Handler f443q;

    /* renamed from: r */
    public Messenger f444r;

    /* renamed from: a */
    private final String f427a = getClass().getSimpleName();

    /* renamed from: b */
    public f.a f428b = null;

    /* renamed from: d */
    private final ArrayList f430d = new ArrayList();

    /* renamed from: e */
    private boolean f431e = false;

    /* renamed from: f */
    private final Object f432f = new Object();

    /* renamed from: g */
    public volatile boolean f433g = false;

    /* renamed from: h */
    public TreeMap f434h = new TreeMap();

    /* renamed from: i */
    public final ArrayList f435i = new ArrayList();

    /* renamed from: j */
    public ConcurrentHashMap f436j = new ConcurrentHashMap();

    /* renamed from: k */
    public final ArrayList f437k = new ArrayList();

    /* renamed from: l */
    protected final Map f438l = new ConcurrentHashMap();

    /* renamed from: m */
    BroadcastReceiver f439m = new a();

    /* renamed from: com.dsi.ant.plugins.antplus.common.AntPluginService$4 */
    /* loaded from: classes.dex */
    public class AnonymousClass4 extends ActivitySearchInfo {

        /* renamed from: h */
        final /* synthetic */ b.C0065b f445h;

        /* renamed from: i */
        final /* synthetic */ Looper f446i;

        AnonymousClass4(b.C0065b c0065b, Looper looper) {
            c0065b = c0065b;
            looper = looper;
        }

        @Override // com.dsi.ant.plugins.antplus.utility.search.ActivitySearchInfo
        public com.dsi.ant.plugins.antplus.utility.search.e d(SearchResultInfo searchResultInfo, Bundle bundle) {
            b.C0065b c0065b = c0065b;
            c0065b.f3504a = searchResultInfo.f976a;
            c0065b.f3507d = 0;
            return AntPluginService.this.u(c0065b, bundle, looper);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Bundle bundleExtra = intent.getBundleExtra("com.dsi.ant.plugins.antplus.queryalreadyconnecteddevices.params");
            int i2 = bundleExtra.getInt("Version_int");
            int i3 = bundleExtra.getInt("Mode_int");
            if (i3 != 0) {
                h1.a.j(AntPluginService.this.f427a, "Received broadcast for already connected devices unrecognized mode: " + i3 + ", version: " + i2);
                return;
            }
            int i4 = bundleExtra.getInt("DevType_int");
            List<p0.c> v2 = AntPluginService.this.v();
            if (v2 == null || v2.size() == 0) {
                return;
            }
            for (p0.c cVar : v2) {
                if (i4 == 0 || i4 == cVar.b()) {
                    AntPluginDeviceDbProvider.DeviceDbDeviceInfo[] t2 = AntPluginService.this.t(cVar);
                    if (t2 != null && t2.length != 0) {
                        Message obtain = Message.obtain();
                        obtain.what = 0;
                        obtain.arg1 = bundleExtra.getInt("CmdSeqNum_int");
                        obtain.arg2 = 0;
                        Bundle bundle = new Bundle();
                        obtain.setData(bundle);
                        bundle.putInt("DevType_int", cVar.b());
                        bundle.putParcelableArray("DevDbInfoList_parcelableArray", t2);
                        try {
                            ((Messenger) bundleExtra.getParcelable("ResultMsgr_messenger")).send(obtain);
                        } catch (RemoteException unused) {
                            h1.a.b(AntPluginService.this.f427a, "RemoteException attempting to send getAlreadyConnnectedDevice broadcast request");
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements ServiceConnection {

        /* renamed from: a */
        private boolean f449a = false;

        b() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            h1.a.i(AntPluginService.this.f427a, "ARS Bound, serviceHasDied: " + this.f449a);
            if (this.f449a) {
                return;
            }
            synchronized (AntPluginService.this.f432f) {
                AntPluginService.this.f428b = new f.a(iBinder);
                synchronized (AntPluginService.this.f430d) {
                    try {
                        Iterator it = AntPluginService.this.f430d.iterator();
                        while (it.hasNext()) {
                            AntPluginService.this.f441o.send((Message) it.next());
                        }
                    } catch (RemoteException unused) {
                        h1.a.b(AntPluginService.this.f427a, "RemoteException sending message to local messenger, inconceivable");
                    }
                    AntPluginService.this.f430d.clear();
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            h1.a.b(AntPluginService.this.f427a, "Plugin-ARS binder OnServiceDisconnected!");
            this.f449a = true;
            AntPluginService.this.I();
            Iterator it = AntPluginService.this.f435i.iterator();
            while (it.hasNext()) {
                ((v.e) it.next()).d();
            }
        }
    }

    /* loaded from: classes.dex */
    public class c extends Handler {

        /* renamed from: a */
        final /* synthetic */ ActivitySearchInfo f451a;

        /* renamed from: b */
        final /* synthetic */ Bundle f452b;

        /* renamed from: c */
        final /* synthetic */ v0.a f453c;

        /* renamed from: d */
        final /* synthetic */ e.a f454d;

        c(ActivitySearchInfo activitySearchInfo, Bundle bundle, v0.a aVar, e.a aVar2) {
            this.f451a = activitySearchInfo;
            this.f452b = bundle;
            this.f453c = aVar;
            this.f454d = aVar2;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            AntChannel antChannel;
            AntChannel antChannel2;
            boolean z2;
            v.e eVar;
            AntChannel antChannel3;
            h1.a.i(AntPluginService.this.f427a, "ReqDev Handler received: " + message.what);
            Message obtain = Message.obtain();
            synchronized (AntPluginService.this.f437k) {
                AntPluginService.this.f437k.remove(this.f451a);
            }
            try {
                try {
                    int i2 = message.what;
                    if (i2 == -2) {
                        obtain.what = -2;
                        this.f453c.b(obtain);
                        AntChannel antChannel4 = this.f451a.f900a;
                        if (antChannel4 != null) {
                            antChannel4.m();
                            return;
                        }
                        return;
                    }
                    if (i2 != 0) {
                        h1.a.b(AntPluginService.this.f427a, "Unknown error from ARS activity: " + obtain.what);
                        obtain.what = -4;
                        this.f453c.b(obtain);
                        AntChannel antChannel5 = this.f451a.f900a;
                        if (antChannel5 != null) {
                            antChannel5.m();
                            return;
                        }
                        return;
                    }
                    synchronized (AntPluginService.this.f435i) {
                        try {
                            int i3 = message.arg1;
                            if (i3 == 0) {
                                Bundle data = message.getData();
                                SearchResultInfo searchResultInfo = (SearchResultInfo) data.getParcelable("clsRESULTINFO");
                                v.e n2 = AntPluginService.this.n(this.f451a.f900a, AntPluginService.this.q(searchResultInfo.f976a.a(), data.getString("str_SelectedDeviceName"), this.f452b), this.f452b, searchResultInfo);
                                if (n2 == null) {
                                    h1.a.b(AntPluginService.this.f427a, "Plugin UI search failed internally: Device instantiation failed.");
                                    obtain.what = -4;
                                    AntPluginService.this.o(this.f453c, obtain);
                                    AntChannel antChannel6 = this.f451a.f900a;
                                    if (antChannel6 != null) {
                                        antChannel6.m();
                                        return;
                                    }
                                    return;
                                }
                                z2 = false;
                                eVar = n2;
                            } else {
                                if (i3 != 1) {
                                    h1.a.b(AntPluginService.this.f427a, "Plugin UI search failed internally: Unrecognized req acc success code.");
                                    obtain.what = -4;
                                    AntPluginService.this.o(this.f453c, obtain);
                                    AntChannel antChannel7 = this.f451a.f900a;
                                    if (antChannel7 != null) {
                                        antChannel7.m();
                                        return;
                                    }
                                    return;
                                }
                                v.e p2 = AntPluginService.this.p(message.getData().getInt("int_ChannelDeviceId"), null, this.f452b);
                                if (p2 == null) {
                                    h1.a.b(AntPluginService.this.f427a, "Already connected device disconnected during search");
                                    obtain.what = -4;
                                    this.f453c.b(obtain);
                                    AntChannel antChannel8 = this.f451a.f900a;
                                    if (antChannel8 != null) {
                                        antChannel8.m();
                                        return;
                                    }
                                    return;
                                }
                                eVar = p2;
                                z2 = true;
                            }
                        } catch (Throwable th) {
                            th = th;
                        }
                        try {
                            try {
                                if (!(AntPluginService.this.H(this.f454d, eVar, this.f453c, null, this.f452b) ? z2 : true) || (antChannel3 = this.f451a.f900a) == null) {
                                    return;
                                }
                                antChannel3.m();
                            } catch (RemoteException unused) {
                                r1 = z2;
                                h1.a.b(AntPluginService.this.f427a, "RemoteException sending search result to client");
                                AntChannel antChannel9 = this.f451a.f900a;
                                if (antChannel9 != null) {
                                    antChannel9.m();
                                }
                                if (!r1 || (antChannel2 = this.f451a.f900a) == null) {
                                    return;
                                }
                                antChannel2.m();
                            } catch (Throwable th2) {
                                th = th2;
                                r1 = z2;
                                if (r1 && (antChannel = this.f451a.f900a) != null) {
                                    antChannel.m();
                                }
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            throw th;
                        }
                    }
                } catch (RemoteException unused2) {
                }
            } catch (Throwable th4) {
                th = th4;
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements f.b {

        /* renamed from: a */
        final /* synthetic */ h f456a;

        d(h hVar) {
            this.f456a = hVar;
        }

        @Override // com.dsi.ant.plugins.antplus.utility.search.f.b
        public void a(SearchResultInfo searchResultInfo) {
            if (AntPluginService.this.A(searchResultInfo.f976a.a(), this.f456a.f476f)) {
                return;
            }
            Message obtain = Message.obtain();
            obtain.what = 2;
            Bundle bundle = searchResultInfo.f978c;
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putParcelable("parcelable_AsyncScanResultDeviceInfo", new AsyncScanController.AsyncScanResultDeviceInfo(null, AntPluginService.this.q(searchResultInfo.f976a.a(), null, this.f456a.f476f), false));
            obtain.setData(bundle);
            try {
                this.f456a.b().b(obtain);
            } catch (RemoteException unused) {
                h1.a.b(AntPluginService.this.f427a, "RemoteException sending async scan result, closing scan.");
                AntPluginService.this.E(this.f456a.f474d.f3454c);
            }
        }

        @Override // com.dsi.ant.plugins.antplus.utility.search.f.b
        public void b() {
            Message obtain = Message.obtain();
            obtain.what = -7;
            try {
                this.f456a.b().b(obtain);
            } catch (RemoteException unused) {
                h1.a.b(AntPluginService.this.f427a, "RemoteException sending async scan timeout ping, closing scan.");
                AntPluginService.this.E(this.f456a.f474d.f3454c);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:6:0x0018, code lost:            if (r4 != 3) goto L33;     */
        @Override // com.dsi.ant.plugins.antplus.utility.search.f.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void c(com.dsi.ant.plugins.antplus.utility.search.f.a r4, com.dsi.ant.channel.AntChannel r5) {
            /*
                r3 = this;
                android.os.Message r0 = android.os.Message.obtain()
                com.dsi.ant.plugins.antplus.common.AntPluginService$h r1 = r3.f456a
                r2 = 1
                r1.f472b = r2
                int[] r1 = com.dsi.ant.plugins.antplus.common.AntPluginService.g.f469b
                int r4 = r4.ordinal()
                r4 = r1[r4]
                r1 = 0
                if (r4 == r2) goto L44
                r2 = 2
                if (r4 == r2) goto L1b
                r1 = 3
                if (r4 == r1) goto L2a
                goto L59
            L1b:
                com.dsi.ant.plugins.antplus.common.AntPluginService r4 = com.dsi.ant.plugins.antplus.common.AntPluginService.this
                java.lang.String r4 = com.dsi.ant.plugins.antplus.common.AntPluginService.a(r4)
                java.lang.String r2 = "AsyncScan: unexpected timeout!"
                h1.a.b(r4, r2)
                r5.m()
                r5 = r1
            L2a:
                com.dsi.ant.plugins.antplus.common.AntPluginService r4 = com.dsi.ant.plugins.antplus.common.AntPluginService.this
                java.lang.String r4 = com.dsi.ant.plugins.antplus.common.AntPluginService.a(r4)
                java.lang.String r1 = "Plugin Async scan: scan crashed."
                h1.a.b(r4, r1)
                r4 = -4
                r0.what = r4
                com.dsi.ant.plugins.antplus.common.AntPluginService r4 = com.dsi.ant.plugins.antplus.common.AntPluginService.this
                com.dsi.ant.plugins.antplus.common.AntPluginService$h r1 = r3.f456a
                v0.a r1 = r1.b()
                r4.o(r1, r0)
                goto L59
            L44:
                com.dsi.ant.plugins.antplus.common.AntPluginService$h r4 = r3.f456a
                com.dsi.ant.plugins.antplus.common.AntPluginService$h$a r4 = r4.f471a
                if (r4 != 0) goto L59
                com.dsi.ant.plugins.antplus.common.AntPluginService r4 = com.dsi.ant.plugins.antplus.common.AntPluginService.this
                java.lang.String r4 = com.dsi.ant.plugins.antplus.common.AntPluginService.a(r4)
                java.lang.String r0 = "Async scan cancelled."
                h1.a.f(r4, r0)
                r5.m()
                r5 = r1
            L59:
                com.dsi.ant.plugins.antplus.common.AntPluginService$h r3 = r3.f456a
                com.dsi.ant.plugins.antplus.common.AntPluginService$h$a r3 = r3.f471a
                if (r3 == 0) goto L62
                r3.a(r5)
            L62:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.dsi.ant.plugins.antplus.common.AntPluginService.d.c(com.dsi.ant.plugins.antplus.utility.search.f$a, com.dsi.ant.channel.AntChannel):void");
        }
    }

    /* loaded from: classes.dex */
    public class e implements h.a {

        /* renamed from: a */
        final /* synthetic */ v0.a f458a;

        /* renamed from: b */
        final /* synthetic */ com.dsi.ant.plugins.antplus.utility.search.e f459b;

        /* renamed from: c */
        final /* synthetic */ h f460c;

        /* renamed from: d */
        final /* synthetic */ Bundle f461d;

        /* loaded from: classes.dex */
        class a implements e.b {
            a() {
            }

            /* JADX WARN: Code restructure failed: missing block: B:9:0x0051, code lost:            if (com.dsi.ant.plugins.antplus.common.AntPluginService.this.H(r10.f460c.f474d, r5, r10.f458a, null, r10.f461d) == false) goto L16;     */
            @Override // com.dsi.ant.plugins.antplus.utility.search.e.b
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void a(com.dsi.ant.plugins.antplus.utility.search.SearchResultInfo r10, com.dsi.ant.channel.AntChannel r11) {
                /*
                    r9 = this;
                    com.dsi.ant.plugins.antplus.common.AntPluginService$e r0 = com.dsi.ant.plugins.antplus.common.AntPluginService.e.this
                    com.dsi.ant.plugins.antplus.common.AntPluginService r0 = com.dsi.ant.plugins.antplus.common.AntPluginService.this
                    j.b r1 = r10.f976a
                    int r1 = r1.a()
                    com.dsi.ant.plugins.antplus.common.AntPluginService$e r2 = com.dsi.ant.plugins.antplus.common.AntPluginService.e.this
                    android.os.Bundle r2 = r2.f461d
                    r3 = 0
                    com.dsi.ant.plugins.internal.pluginsipc.AntPluginDeviceDbProvider$DeviceDbDeviceInfo r0 = r0.q(r1, r3, r2)
                    com.dsi.ant.plugins.antplus.common.AntPluginService$e r1 = com.dsi.ant.plugins.antplus.common.AntPluginService.e.this
                    com.dsi.ant.plugins.antplus.common.AntPluginService r2 = com.dsi.ant.plugins.antplus.common.AntPluginService.this
                    android.os.Bundle r1 = r1.f461d
                    v.e r5 = r2.n(r11, r0, r1, r10)
                    if (r5 != 0) goto L40
                    android.os.Message r10 = android.os.Message.obtain()
                    com.dsi.ant.plugins.antplus.common.AntPluginService$e r0 = com.dsi.ant.plugins.antplus.common.AntPluginService.e.this
                    com.dsi.ant.plugins.antplus.common.AntPluginService r0 = com.dsi.ant.plugins.antplus.common.AntPluginService.this
                    java.lang.String r0 = com.dsi.ant.plugins.antplus.common.AntPluginService.a(r0)
                    java.lang.String r1 = "Plugin async scan connect failed internally: Device instantiation failed."
                    h1.a.b(r0, r1)
                    r0 = -4
                    r10.what = r0
                    com.dsi.ant.plugins.antplus.common.AntPluginService$e r0 = com.dsi.ant.plugins.antplus.common.AntPluginService.e.this
                    com.dsi.ant.plugins.antplus.common.AntPluginService r1 = com.dsi.ant.plugins.antplus.common.AntPluginService.this
                    v0.a r0 = r0.f458a
                    r1.o(r0, r10)
                L3c:
                    r11.m()
                    goto L54
                L40:
                    com.dsi.ant.plugins.antplus.common.AntPluginService$e r10 = com.dsi.ant.plugins.antplus.common.AntPluginService.e.this
                    com.dsi.ant.plugins.antplus.common.AntPluginService r3 = com.dsi.ant.plugins.antplus.common.AntPluginService.this
                    com.dsi.ant.plugins.antplus.common.AntPluginService$h r0 = r10.f460c
                    v.e$a r4 = r0.f474d
                    v0.a r6 = r10.f458a
                    r7 = 0
                    android.os.Bundle r8 = r10.f461d
                    boolean r10 = r3.H(r4, r5, r6, r7, r8)
                    if (r10 != 0) goto L54
                    goto L3c
                L54:
                    com.dsi.ant.plugins.antplus.common.AntPluginService$e r9 = com.dsi.ant.plugins.antplus.common.AntPluginService.e.this
                    com.dsi.ant.plugins.antplus.common.AntPluginService r10 = com.dsi.ant.plugins.antplus.common.AntPluginService.this
                    com.dsi.ant.plugins.antplus.common.AntPluginService$h r9 = r9.f460c
                    v.e$a r9 = r9.f474d
                    java.util.UUID r9 = r9.f3454c
                    r10.E(r9)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.dsi.ant.plugins.antplus.common.AntPluginService.e.a.a(com.dsi.ant.plugins.antplus.utility.search.SearchResultInfo, com.dsi.ant.channel.AntChannel):void");
            }

            @Override // com.dsi.ant.plugins.antplus.utility.search.e.b
            public void d(e.a aVar, AntChannel antChannel) {
                Message obtain = Message.obtain();
                int i2 = g.f470c[aVar.ordinal()];
                if (i2 == 1) {
                    obtain.what = -7;
                    e eVar = e.this;
                    AntPluginService.this.o(eVar.f458a, obtain);
                    e eVar2 = e.this;
                    AntPluginService.this.F(antChannel, eVar2.f460c);
                    return;
                }
                if (i2 == 2) {
                    h1.a.b(AntPluginService.this.f427a, "Connect to async result: interrupted!");
                    antChannel.m();
                } else if (i2 != 3) {
                    return;
                }
                h1.a.b(AntPluginService.this.f427a, "Connect to device: search crashed.");
                obtain.what = -4;
                e eVar3 = e.this;
                AntPluginService.this.o(eVar3.f458a, obtain);
                e eVar4 = e.this;
                AntPluginService.this.E(eVar4.f460c.f474d.f3454c);
            }
        }

        e(v0.a aVar, com.dsi.ant.plugins.antplus.utility.search.e eVar, h hVar, Bundle bundle) {
            this.f458a = aVar;
            this.f459b = eVar;
            this.f460c = hVar;
            this.f461d = bundle;
        }

        @Override // com.dsi.ant.plugins.antplus.common.AntPluginService.h.a
        public void a(AntChannel antChannel) {
            if (antChannel != null) {
                this.f459b.b(antChannel, new a());
                return;
            }
            Message obtain = Message.obtain();
            obtain.what = -4;
            AntPluginService.this.o(this.f458a, obtain);
        }
    }

    /* loaded from: classes.dex */
    public class f implements e.b {

        /* renamed from: a */
        final /* synthetic */ v0.a f464a;

        /* renamed from: b */
        final /* synthetic */ Bundle f465b;

        /* renamed from: c */
        final /* synthetic */ e.a f466c;

        f(v0.a aVar, Bundle bundle, e.a aVar2) {
            this.f464a = aVar;
            this.f465b = bundle;
            this.f466c = aVar2;
        }

        @Override // com.dsi.ant.plugins.antplus.utility.search.e.b
        public void a(SearchResultInfo searchResultInfo, AntChannel antChannel) {
            v.e n2 = AntPluginService.this.n(antChannel, AntPluginService.this.q(searchResultInfo.f976a.a(), null, this.f465b), this.f465b, searchResultInfo);
            if (n2 != null) {
                if (AntPluginService.this.H(this.f466c, n2, this.f464a, null, this.f465b)) {
                    return;
                }
                antChannel.m();
            } else {
                Message obtain = Message.obtain();
                h1.a.b(AntPluginService.this.f427a, "Plugin search by deviceNumber search failed internally: Device instantiation failed.");
                obtain.what = -4;
                AntPluginService.this.o(this.f464a, obtain);
                antChannel.m();
            }
        }

        @Override // com.dsi.ant.plugins.antplus.utility.search.e.b
        public void d(e.a aVar, AntChannel antChannel) {
            Message obtain = Message.obtain();
            int i2 = g.f470c[aVar.ordinal()];
            if (i2 == 1) {
                obtain.what = -7;
            } else {
                if (i2 != 2) {
                    if (i2 != 3) {
                        return;
                    }
                    h1.a.b(AntPluginService.this.f427a, "Plugin search by device number: search crashed!");
                    obtain.what = -4;
                    AntPluginService.this.o(this.f464a, obtain);
                    return;
                }
                h1.a.b(AntPluginService.this.f427a, "Plugin search by device number: search was interrupted.");
                obtain.what = -4;
            }
            AntPluginService.this.o(this.f464a, obtain);
            antChannel.m();
        }
    }

    /* loaded from: classes.dex */
    public static /* synthetic */ class g {

        /* renamed from: a */
        static final /* synthetic */ int[] f468a;

        /* renamed from: b */
        static final /* synthetic */ int[] f469b;

        /* renamed from: c */
        static final /* synthetic */ int[] f470c;

        static {
            int[] iArr = new int[e.a.values().length];
            f470c = iArr;
            try {
                iArr[e.a.TIMEOUT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f470c[e.a.INTERRUPTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f470c[e.a.CRASH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[f.a.values().length];
            f469b = iArr2;
            try {
                iArr2[f.a.INTERRUPTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f469b[f.a.TIMEOUT.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f469b[f.a.CRASH.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            int[] iArr3 = new int[g.c.values().length];
            f468a = iArr3;
            try {
                iArr3[g.c.RELEASE_PROCESSING.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f468a[g.c.SERVICE_INITIALIZING.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f468a[g.c.NO_ADAPTERS_EXIST.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static class h {

        /* renamed from: a */
        public a f471a;

        /* renamed from: b */
        public boolean f472b;

        /* renamed from: c */
        public final com.dsi.ant.plugins.antplus.utility.search.f f473c;

        /* renamed from: d */
        public e.a f474d;

        /* renamed from: e */
        public v0.a f475e;

        /* renamed from: f */
        public Bundle f476f;

        /* loaded from: classes.dex */
        public interface a {
            void a(AntChannel antChannel);
        }

        public h(e.a aVar, com.dsi.ant.plugins.antplus.utility.search.f fVar) {
            this.f473c = fVar;
            this.f474d = aVar;
        }

        public void a() {
            this.f473c.a();
        }

        public v0.a b() {
            return this.f475e;
        }
    }

    /* loaded from: classes.dex */
    class i extends Handler {
        public i(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            h1.a.i(AntPluginService.this.f427a, "PCC Msg Handler received: " + message.what);
            Bundle data = message.getData();
            data.setClassLoader(getClass().getClassLoader());
            UUID uuid = (UUID) data.get("uuid_AccessToken");
            if (uuid != null) {
                v.e eVar = (v.e) AntPluginService.this.f434h.get(uuid);
                if (eVar != null) {
                    int i2 = message.what;
                    if (i2 == 10101 || i2 == 10100) {
                        h1.a.b(AntPluginService.this.f427a, "cmd handler: async message received when target is a device. AntLib probably needs to be upgraded.");
                    }
                    v0.a aVar = message.what == 10002 ? ((e.a) eVar.f3447b.get(uuid)).f3455d : null;
                    eVar.b(uuid, message);
                    if (message.what == 10002) {
                        List list = (List) AntPluginService.this.f438l.remove(aVar.f3469b);
                        if (list != null) {
                            Iterator it = list.iterator();
                            while (it.hasNext()) {
                                ((v0.a) it.next()).c();
                            }
                        }
                        AntPluginService.this.C(uuid, eVar);
                        return;
                    }
                    return;
                }
                h hVar = (h) AntPluginService.this.f436j.get(uuid);
                if (hVar != null) {
                    int i3 = message.what;
                    if (i3 == 10100) {
                        Message obtain = Message.obtain();
                        obtain.what = 10100;
                        obtain.arg1 = 0;
                        try {
                            hVar.f474d.f3455d.b(obtain);
                            Bundle bundle = hVar.f476f;
                            bundle.putAll(message.getData());
                            AntPluginService.this.l(hVar, bundle);
                            return;
                        } catch (RemoteException unused) {
                            h1.a.b(AntPluginService.this.f427a, "RemoteException sending response to CONNECTTOASYNCRESULT cmd, closing scan.");
                            AntPluginService.this.E(hVar.f474d.f3454c);
                            return;
                        }
                    }
                    if (i3 != 10101) {
                        Message obtain2 = Message.obtain();
                        obtain2.what = message.what;
                        obtain2.arg1 = -99999999;
                        AntPluginService.this.o(hVar.f474d.f3455d, obtain2);
                        return;
                    }
                    Message obtain3 = Message.obtain();
                    obtain3.what = 10101;
                    obtain3.arg1 = 0;
                    AntPluginService.this.o(hVar.f474d.f3455d, obtain3);
                    AntPluginService.this.E(uuid);
                    List list2 = (List) AntPluginService.this.f438l.remove(hVar.f474d.f3455d.f3469b);
                    if (list2 != null) {
                        Iterator it2 = list2.iterator();
                        while (it2.hasNext()) {
                            ((v0.a) it2.next()).c();
                        }
                        return;
                    }
                    return;
                }
            }
            h1.a.b(AntPluginService.this.f427a, "Cmd Handler: Token missing or invalid!");
        }
    }

    /* loaded from: classes.dex */
    private static class j extends Handler {

        /* renamed from: a */
        private WeakReference f478a;

        /* renamed from: b */
        private final String f479b;

        public j(Looper looper, AntPluginService antPluginService) {
            super(looper);
            this.f479b = antPluginService.getClass().getSimpleName() + " ";
            this.f478a = new WeakReference(antPluginService);
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x00a3  */
        /* JADX WARN: Removed duplicated region for block: B:44:0x0135  */
        @Override // android.os.Handler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void handleMessage(android.os.Message r9) {
            /*
                Method dump skipped, instructions count: 353
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.dsi.ant.plugins.antplus.common.AntPluginService.j.handleMessage(android.os.Message):void");
        }
    }

    public void F(AntChannel antChannel, h hVar) {
        hVar.f472b = false;
        hVar.f471a = null;
        hVar.f473c.b(antChannel, new d(hVar));
    }

    private void i(v0.a aVar) {
        synchronized (this.f432f) {
            b bVar = new b();
            this.f429c = bVar;
            if (this.f431e) {
                h1.a.a(this.f427a, "ARS bind called when bound or bind is still in progress.");
            } else {
                this.f431e = true;
                if (!f.a.a(this, bVar)) {
                    h1.a.b(this.f427a, "Binding to ARS failed");
                    Message obtain = Message.obtain();
                    obtain.what = -4;
                    o(aVar, obtain);
                    I();
                }
            }
        }
    }

    private Bundle j(e.a aVar, v0.a aVar2, Bundle bundle) {
        Bundle r2 = r(bundle);
        AntChannel f3 = f((com.dsi.ant.channel.b) r2.getSerializable("predefinednetwork_NetKey"), null, aVar2, aVar, bundle.getInt("int_RssiMode", 0));
        if (f3 == null) {
            return null;
        }
        ActivitySearchInfo m2 = m(f3, bundle, this.f440n.getLooper());
        synchronized (this.f437k) {
            this.f437k.add(m2);
        }
        r2.putParcelable("cls_ActivitySearchInfo", m2);
        h(r2, aVar, aVar2, bundle);
        r2.putParcelable("msgr_SearchResultReceiver", new Messenger(new c(m2, bundle, aVar2, aVar)));
        return r2;
    }

    public void k(Message message, v0.a aVar) {
        h1.a.i(this.f427a, "Attempting binding to ARS");
        boolean z2 = false;
        Iterator<ApplicationInfo> it = getPackageManager().getInstalledApplications(0).iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ApplicationInfo next = it.next();
            if (next.packageName.equals("com.dsi.ant.service.socket")) {
                if (next.enabled) {
                    z2 = true;
                }
            }
        }
        if (!z2) {
            h1.a.b(this.f427a, "Binding to ARS failed, not installed");
            Message obtain = Message.obtain();
            obtain.what = -5;
            Bundle bundle = new Bundle();
            bundle.putString("string_DependencyPackageName", "com.dsi.ant.service.socket");
            bundle.putString("string_DependencyName", "ANT Radio Service");
            obtain.setData(bundle);
            o(aVar, obtain);
            return;
        }
        synchronized (this.f432f) {
            if (this.f428b != null) {
                try {
                    this.f441o.send(Message.obtain(message));
                } catch (RemoteException unused) {
                    h1.a.b(this.f427a, "RemoteException sending message to local messenger, inconceivable");
                }
            } else {
                synchronized (this.f430d) {
                    this.f430d.add(Message.obtain(message));
                }
                if (this.f431e) {
                    h1.a.i(this.f427a, "ARS already bound or bind is still in progress.");
                } else {
                    i(aVar);
                }
            }
        }
    }

    private void x(e.a aVar, v0.a aVar2, Bundle bundle) {
        Message obtain;
        if (bundle.containsKey("int_ProximityBin")) {
            if (bundle.getInt("int_ProximityBin") == -1) {
                bundle.putInt("int_ProximityBin", getSharedPreferences(getResources().getString(R.string.pluginmanager_settings_prefname), 0).getInt(getResources().getString(R.string.pluginmgr_settings_key_int_proximitybin), 0));
            }
            Bundle j2 = j(aVar, aVar2, bundle);
            if (j2 == null) {
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("com.dsi.ant.plugins.antplus.pcc.plugindata", j2);
            intent.setComponent(bundle.getBoolean("b_ForceManualSelect") ? new ComponentName("com.dsi.ant.plugins.antplus", "com.dsi.ant.plugins.antplus.utility.search.Activity_SearchAllDevices") : new ComponentName("com.dsi.ant.plugins.antplus", "com.dsi.ant.plugins.antplus.utility.search.Dialog_SearchPreferredDevice"));
            obtain = Message.obtain();
            obtain.what = 1;
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("intent_ActivityToLaunch", intent);
            obtain.setData(bundle2);
        } else {
            h1.a.b(this.f427a, "Bundle is missing proximity parameter");
            obtain = Message.obtain();
            obtain.what = -4;
        }
        o(aVar2, obtain);
    }

    protected boolean A(int i2, Bundle bundle) {
        return p(i2, null, bundle) != null;
    }

    public void B(Bundle bundle, v0.a aVar) {
        int i2 = bundle.getInt("int_RequestAccessMode");
        Messenger messenger = (Messenger) bundle.get("msgr_PluginMsgHandler");
        v0.a aVar2 = new v0.a(messenger);
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(aVar2);
        arrayList.add(aVar);
        this.f438l.put(messenger, arrayList);
        e.a aVar3 = new e.a();
        aVar3.f3452a = bundle.getString("str_ApplicationNamePackage");
        aVar3.f3453b = bundle.getString("str_ApplicationNameTitle");
        aVar3.f3455d = aVar2;
        aVar3.f3456e = bundle.getInt("int_PluginLibVersion", 0);
        aVar3.f3457f = bundle.getInt("more", -1);
        h1.a.i(this.f427a, "ReqAcc Mode: " + i2 + " from " + aVar3.f3452a + ":" + aVar3.f3456e);
        if (w(i2, aVar, aVar3, bundle)) {
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = -99999999;
        o(aVar, obtain);
    }

    public void C(UUID uuid, v.e eVar) {
        synchronized (this.f435i) {
            this.f434h.remove(uuid);
            if (!eVar.f3449d) {
                this.f435i.remove(eVar);
            }
        }
    }

    protected void D(e.a aVar, v0.a aVar2, Bundle bundle) {
        synchronized (this.f435i) {
            Iterator it = this.f435i.iterator();
            while (it.hasNext()) {
                v.e eVar = (v.e) it.next();
                if (!eVar.g(aVar.f3452a, bundle)) {
                    Message obtain = Message.obtain();
                    obtain.what = 2;
                    Bundle bundle2 = new Bundle();
                    bundle2.putParcelable("parcelable_AsyncScanResultDeviceInfo", new AsyncScanController.AsyncScanResultDeviceInfo(null, eVar.f3451f, true));
                    obtain.setData(bundle2);
                    aVar2.b(obtain);
                }
            }
        }
    }

    public void E(UUID uuid) {
        h hVar = (h) this.f436j.get(uuid);
        if (hVar != null) {
            this.f436j.remove(uuid);
            hVar.a();
        }
    }

    public void G(int i2, e.a aVar, v0.a aVar2, Bundle bundle) {
        b.C0065b c0065b = new b.C0065b();
        Bundle r2 = r(bundle);
        if (!bundle.containsKey("int_ProximityBin") || !r2.containsKey("predefinednetwork_NetKey") || !r2.containsKey("int_DevType") || !r2.containsKey("int_TransType") || !r2.containsKey("int_Period") || !r2.containsKey("int_RfFreq")) {
            h1.a.b(this.f427a, "Bundle is missing parameters");
            Message obtain = Message.obtain();
            obtain.what = -4;
            o(aVar2, obtain);
            return;
        }
        c0065b.f3504a = new j.b(i2, r2.getInt("int_DevType"), r2.getInt("int_TransType"));
        c0065b.f3505b = r2.getInt("int_RfFreq");
        c0065b.f3506c = r2.getInt("int_Period");
        c0065b.f3507d = i2 != 0 ? 0 : bundle.getInt("int_ProximityBin");
        c0065b.f3508e = j.i.TEN_SECONDS;
        AntChannel f3 = f((com.dsi.ant.channel.b) r2.getSerializable("predefinednetwork_NetKey"), null, aVar2, aVar, bundle.getInt("int_RssiMode", 0));
        if (f3 == null) {
            return;
        }
        try {
            u(c0065b, bundle, this.f440n.getLooper()).b(f3, new f(aVar2, bundle, aVar));
        } catch (IllegalArgumentException e3) {
            h1.a.k(this.f427a, "Invalid arguments when constructing scan", e3);
            Message obtain2 = Message.obtain();
            obtain2.what = -9;
            o(aVar2, obtain2);
        }
    }

    public boolean H(e.a aVar, v.e eVar, v0.a aVar2, Bundle bundle, Bundle bundle2) {
        boolean z2;
        if (aVar.f3452a == null || aVar.f3453b == null || aVar.f3455d == null) {
            throw new IllegalArgumentException("Client missing required info");
        }
        if (aVar.f3454c == null) {
            aVar.f3454c = UUID.randomUUID();
        }
        if (this.f433g && eVar != null) {
            h1.a.b(this.f427a, "Closing new device because service is closing/already closed");
            eVar.d();
        }
        if (eVar == null || eVar.h()) {
            h1.a.b(this.f427a, "Trying to subscribe to dead device");
            Message obtain = Message.obtain();
            obtain.what = -4;
            o(aVar2, obtain);
            return false;
        }
        if (eVar.g(aVar.f3452a, bundle2)) {
            h1.a.j(this.f427a, "Request Access Failed: App already has access to this device.");
            Message obtain2 = Message.obtain();
            obtain2.what = -8;
            o(aVar2, obtain2);
            return false;
        }
        synchronized (this.f435i) {
            if (!eVar.c(aVar, aVar2, bundle2)) {
                return false;
            }
            if (!this.f435i.contains(eVar)) {
                this.f435i.add(eVar);
            }
            this.f434h.put(aVar.f3454c, eVar);
            Message obtain3 = Message.obtain();
            obtain3.what = 0;
            if (bundle == null) {
                bundle = new Bundle();
            }
            try {
                bundle.putInt("int_ServiceVersion", getPackageManager().getPackageInfo(getPackageName(), 0).versionCode);
            } catch (PackageManager.NameNotFoundException unused) {
                h1.a.b(this.f427a, "Can't retrieve service version from plugin manager!");
                bundle.putInt("int_ServiceVersion", -5);
            }
            bundle.putSerializable("uuid_AccessToken", aVar.f3454c);
            bundle.putParcelable("msgr_PluginComm", this.f444r);
            bundle.putInt("int_InitialDeviceStateCode", eVar.e());
            if (aVar.f3456e == 0) {
                bundle.putString("str_DeviceName", eVar.f3451f.f1177e);
                bundle.putInt("int_AntDeviceID", eVar.f3451f.f1176d.intValue());
            } else {
                bundle.putParcelable("parcelable_DeviceDbInfo", eVar.f3451f);
            }
            if (eVar instanceof v.c) {
                try {
                    z2 = ((v.c) eVar).f3424h.k().k();
                } catch (RemoteException unused2) {
                    z2 = false;
                }
                bundle.putBoolean("bool_RssiSupport", z2);
            }
            obtain3.setData(bundle);
            try {
                aVar2.b(obtain3);
                return true;
            } catch (RemoteException unused3) {
                h1.a.b(this.f427a, "RemoteException sending request access 'SUCCESS' reply to client.");
                C(aVar.f3454c, eVar);
                return false;
            }
        }
    }

    public void I() {
        synchronized (this.f432f) {
            if (this.f431e) {
                try {
                    ServiceConnection serviceConnection = this.f429c;
                    if (serviceConnection != null) {
                        unbindService(serviceConnection);
                    }
                } catch (IllegalArgumentException e3) {
                    h1.a.b(this.f427a, "Unexpected error unbinding service, " + e3);
                }
                this.f429c = null;
                this.f428b = null;
                this.f431e = false;
            }
        }
    }

    public AntChannel f(com.dsi.ant.channel.b bVar, Capabilities capabilities, v0.a aVar, e.a aVar2, int i2) {
        Capabilities capabilities2;
        if (i2 != 1) {
            capabilities2 = null;
        } else {
            capabilities2 = new Capabilities();
            capabilities2.l(true);
        }
        return g(bVar, capabilities, capabilities2, aVar, aVar2);
    }

    public AntChannel g(com.dsi.ant.channel.b bVar, Capabilities capabilities, Capabilities capabilities2, v0.a aVar, e.a aVar2) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        while (true) {
            try {
                try {
                    if (SystemClock.elapsedRealtime() - elapsedRealtime > 15000) {
                        h1.a.b(this.f427a, "Acquire channel stuck in acquire loop for 15s, aborting.");
                        Message obtain = Message.obtain();
                        obtain.what = -4;
                        if (aVar != null) {
                            o(aVar, obtain);
                        }
                        return null;
                    }
                    try {
                        AntChannel a3 = this.f428b.b().a(this, bVar, capabilities, capabilities2);
                        try {
                            a3.j();
                        } catch (g.a e3) {
                            h1.a.b(this.f427a, "Could not set event buffer: " + e3.a().toString());
                        }
                        return a3;
                    } catch (NullPointerException unused) {
                        h1.a.b(this.f427a, "UnexpectedError, acquireChannel_helper called with null ArsComm");
                        Message obtain2 = Message.obtain();
                        obtain2.what = -4;
                        if (aVar != null) {
                            o(aVar, obtain2);
                        }
                        return null;
                    }
                } catch (ChannelNotAvailableException e4) {
                    int i2 = g.f468a[e4.f334a.ordinal()];
                    if (i2 != 1 && i2 != 2) {
                        if (i2 == 3 && aVar2 != null && aVar2.f3456e >= 20100) {
                            h1.a.a(this.f427a, "ARS reports no ANT adapters available");
                            Message obtain3 = Message.obtain();
                            obtain3.what = -10;
                            if (aVar != null) {
                                o(aVar, obtain3);
                            }
                            return null;
                        }
                        h1.a.b(this.f427a, "Could not acquire channel: " + e4.f334a);
                        Message obtain4 = Message.obtain();
                        obtain4.what = -3;
                        if (aVar != null) {
                            o(aVar, obtain4);
                        }
                        return null;
                    }
                    try {
                        Thread.sleep(200L);
                    } catch (InterruptedException unused2) {
                        h1.a.a(this.f427a, "Sleep interupted attempting to acquire not yet ready channel, trying again");
                    }
                }
            } catch (RemoteException unused3) {
                h1.a.b(this.f427a, "RemoteException acquiring channel from ARS");
                Message obtain5 = Message.obtain();
                obtain5.what = -4;
                if (aVar != null) {
                    o(aVar, obtain5);
                }
                return null;
            }
        }
    }

    protected void h(Bundle bundle, e.a aVar, v0.a aVar2, Bundle bundle2) {
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        ArrayList<? extends Parcelable> arrayList2 = new ArrayList<>();
        synchronized (this.f435i) {
            Iterator it = this.f435i.iterator();
            while (it.hasNext()) {
                v.e eVar = (v.e) it.next();
                if (!eVar.g(aVar.f3452a, bundle2)) {
                    Bundle bundle3 = new Bundle();
                    bundle3.putInt("int_ChannelDeviceId", eVar.f3451f.f1176d.intValue());
                    arrayList.add(bundle3);
                    arrayList2.add(eVar.f3451f);
                }
            }
        }
        bundle.putParcelableArrayList("albdlCONNECTEDDEVICES", arrayList);
        bundle.putParcelableArrayList("albdlCONNECTEDDEVICEINFOS", arrayList2);
    }

    protected void l(h hVar, Bundle bundle) {
        AsyncScanController.AsyncScanResultDeviceInfo asyncScanResultDeviceInfo = (AsyncScanController.AsyncScanResultDeviceInfo) bundle.getParcelable("parcelable_AsyncScanResultDeviceInfo");
        v0.a aVar = new v0.a((Messenger) bundle.get("msgr_ReqAccResultReceiver"));
        ((List) this.f438l.get(hVar.f474d.f3455d.f3469b)).add(aVar);
        v.e p2 = p(asyncScanResultDeviceInfo.a(), null, bundle);
        if (p2 != null) {
            H(hVar.f474d, p2, aVar, null, bundle);
            E(hVar.f474d.f3454c);
            return;
        }
        b.C0065b c0065b = new b.C0065b();
        Bundle r2 = r(bundle);
        c0065b.f3504a = new j.b(asyncScanResultDeviceInfo.a(), r2.getInt("int_DevType"), r2.getInt("int_TransType"));
        c0065b.f3505b = r2.getInt("int_RfFreq");
        c0065b.f3506c = r2.getInt("int_Period");
        c0065b.f3507d = 0;
        c0065b.f3508e = j.i.TEN_SECONDS;
        com.dsi.ant.plugins.antplus.utility.search.e u2 = u(c0065b, bundle, this.f440n.getLooper());
        if (hVar.f472b) {
            Message obtain = Message.obtain();
            obtain.what = -4;
            o(aVar, obtain);
        }
        hVar.f471a = new e(aVar, u2, hVar, bundle);
        hVar.a();
    }

    protected ActivitySearchInfo m(AntChannel antChannel, Bundle bundle, Looper looper) {
        b.C0065b c0065b = new b.C0065b();
        Bundle r2 = r(bundle);
        int i2 = r2.getInt("int_DevType");
        int i3 = r2.getInt("int_TransType");
        c0065b.f3504a = new j.b(0, i2, i3);
        c0065b.f3505b = r2.getInt("int_RfFreq");
        c0065b.f3506c = r2.getInt("int_Period");
        c0065b.f3507d = bundle.getInt("int_ProximityBin");
        c0065b.f3508e = j.i.TEN_SECONDS;
        AnonymousClass4 anonymousClass4 = new ActivitySearchInfo() { // from class: com.dsi.ant.plugins.antplus.common.AntPluginService.4

            /* renamed from: h */
            final /* synthetic */ b.C0065b f445h;

            /* renamed from: i */
            final /* synthetic */ Looper f446i;

            AnonymousClass4(b.C0065b c0065b2, Looper looper2) {
                c0065b = c0065b2;
                looper = looper2;
            }

            @Override // com.dsi.ant.plugins.antplus.utility.search.ActivitySearchInfo
            public com.dsi.ant.plugins.antplus.utility.search.e d(SearchResultInfo searchResultInfo, Bundle bundle2) {
                b.C0065b c0065b2 = c0065b;
                c0065b2.f3504a = searchResultInfo.f976a;
                c0065b2.f3507d = 0;
                return AntPluginService.this.u(c0065b2, bundle2, looper);
            }
        };
        anonymousClass4.f903d = s(c0065b2, looper2, 20000L, bundle);
        anonymousClass4.f904e = c0065b2.f3507d;
        anonymousClass4.f900a = antChannel;
        t0.b bVar = new t0.b(this);
        try {
            AntPluginDeviceDbProvider.DeviceDbDeviceInfo h2 = bVar.h(r2.getString("str_PluginName"));
            if (h2 != null) {
                c0065b2.f3504a = new j.b(h2.f1176d.intValue(), i2, i3);
                c0065b2.f3507d = 0;
                anonymousClass4.f901b = u(c0065b2, bundle, looper2);
                anonymousClass4.f902c = h2.f1177e;
            }
            return anonymousClass4;
        } finally {
            bVar.d();
        }
    }

    public abstract v.e n(AntChannel antChannel, AntPluginDeviceDbProvider.DeviceDbDeviceInfo deviceDbDeviceInfo, Bundle bundle, SearchResultInfo searchResultInfo);

    public void o(v0.a aVar, Message message) {
        try {
            aVar.b(message);
        } catch (RemoteException unused) {
            h1.a.b(this.f427a, "RemoteException dumbfiring reply to client. Reply code was: " + message.what);
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        if (this.f441o == null) {
            HandlerThread handlerThread = new HandlerThread("AntPluginService ReqAcc Handler");
            this.f440n = handlerThread;
            handlerThread.start();
            this.f441o = new Messenger(new j(this.f440n.getLooper(), this));
        }
        if (this.f444r == null) {
            HandlerThread handlerThread2 = new HandlerThread("AntPluginService PCC cmd handler");
            this.f442p = handlerThread2;
            handlerThread2.start();
            this.f443q = new i(this.f442p.getLooper());
            this.f444r = new Messenger(this.f443q);
        }
        return this.f441o.getBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        try {
            h1.a.h("BBC" + getPackageManager().getPackageInfo(getPackageName(), 0).versionCode);
        } catch (PackageManager.NameNotFoundException e3) {
            h1.a.j(this.f427a, "ANT+ Plugins Version not found: " + e3.toString());
        }
        registerReceiver(this.f439m, new IntentFilter("com.dsi.ant.plugins.antplus.queryalreadyconnecteddevices"));
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.f433g = true;
        h1.a.i(this.f427a, "Entering OnDestroy()");
        if (this.f441o != null) {
            this.f440n.quit();
            try {
                this.f440n.join(1000L);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
            this.f441o = null;
        }
        synchronized (this.f437k) {
            Iterator it = this.f437k.iterator();
            while (it.hasNext()) {
                ActivitySearchInfo activitySearchInfo = (ActivitySearchInfo) it.next();
                activitySearchInfo.f905f = true;
                ActivitySearchInfo.b bVar = activitySearchInfo.f906g;
                if (bVar != null) {
                    bVar.a();
                }
            }
            this.f437k.clear();
        }
        if (this.f444r != null) {
            this.f442p.quit();
            try {
                this.f442p.join(1000L);
            } catch (InterruptedException unused2) {
                Thread.currentThread().interrupt();
            }
            this.f444r = null;
        }
        synchronized (this.f435i) {
            unregisterReceiver(this.f439m);
            Iterator it2 = this.f435i.iterator();
            while (it2.hasNext()) {
                ((v.e) it2.next()).d();
            }
            Iterator it3 = this.f436j.keySet().iterator();
            while (it3.hasNext()) {
                E((UUID) it3.next());
            }
            this.f435i.clear();
            this.f434h.clear();
        }
        I();
        super.onDestroy();
    }

    protected v.e p(int i2, String str, Bundle bundle) {
        synchronized (this.f435i) {
            Iterator it = this.f435i.iterator();
            while (it.hasNext()) {
                v.e eVar = (v.e) it.next();
                if (i2 == 0 || eVar.f3451f.f1176d.intValue() == i2) {
                    if (str == null || !eVar.g(str, bundle)) {
                        return eVar;
                    }
                }
            }
            return null;
        }
    }

    protected AntPluginDeviceDbProvider.DeviceDbDeviceInfo q(int i2, String str, Bundle bundle) {
        String string = r(bundle).getString("str_PluginName");
        t0.b bVar = new t0.b(this);
        try {
            AntPluginDeviceDbProvider.DeviceDbDeviceInfo f3 = bVar.f(i2, string);
            if (f3 == null) {
                f3 = new AntPluginDeviceDbProvider.DeviceDbDeviceInfo();
                f3.f1178f = Boolean.FALSE;
                if (str == null) {
                    str = "Device: " + i2;
                }
                f3.f1177e = str;
                f3.f1176d = Integer.valueOf(i2);
            }
            return f3;
        } finally {
            bVar.d();
        }
    }

    public abstract Bundle r(Bundle bundle);

    protected com.dsi.ant.plugins.antplus.utility.search.f s(b.C0065b c0065b, Looper looper, long j2, Bundle bundle) {
        return new com.dsi.ant.plugins.antplus.utility.search.j(c0065b, looper, j2);
    }

    protected AntPluginDeviceDbProvider.DeviceDbDeviceInfo[] t(p0.c cVar) {
        AntPluginDeviceDbProvider.DeviceDbDeviceInfo[] deviceDbDeviceInfoArr;
        if (this.f435i.size() <= 0) {
            return null;
        }
        synchronized (this.f435i) {
            deviceDbDeviceInfoArr = new AntPluginDeviceDbProvider.DeviceDbDeviceInfo[this.f435i.size()];
            for (int i2 = 0; i2 < this.f435i.size(); i2++) {
                deviceDbDeviceInfoArr[i2] = ((v.e) this.f435i.get(i2)).f3451f;
            }
        }
        return deviceDbDeviceInfoArr;
    }

    protected com.dsi.ant.plugins.antplus.utility.search.e u(b.C0065b c0065b, Bundle bundle, Looper looper) {
        return new com.dsi.ant.plugins.antplus.utility.search.i(c0065b, looper);
    }

    public abstract List v();

    public boolean w(int i2, v0.a aVar, e.a aVar2, Bundle bundle) {
        if (i2 == 1) {
            x(aVar2, aVar, bundle);
            return true;
        }
        if (i2 == 2) {
            z(aVar2, aVar, bundle);
            return true;
        }
        if (i2 != 3) {
            return false;
        }
        y(aVar2, aVar, bundle);
        return true;
    }

    protected void y(e.a aVar, v0.a aVar2, Bundle bundle) {
        if (!bundle.containsKey("int_AntDeviceID")) {
            Message obtain = Message.obtain();
            obtain.what = -4;
            o(aVar2, obtain);
            return;
        }
        int i2 = bundle.getInt("int_AntDeviceID");
        if (i2 >= 0 && i2 <= 65535) {
            v.e p2 = p(i2, aVar.f3452a, bundle);
            if (p2 != null) {
                H(aVar, p2, aVar2, null, bundle);
                return;
            } else {
                G(i2, aVar, aVar2, bundle);
                return;
            }
        }
        h1.a.a(this.f427a, "Target device number out of range, value: " + i2);
        Message obtain2 = Message.obtain();
        obtain2.what = -9;
        o(aVar2, obtain2);
    }

    protected void z(e.a aVar, v0.a aVar2, Bundle bundle) {
        b.C0065b c0065b = new b.C0065b();
        Bundle r2 = r(bundle);
        c0065b.f3504a = new j.b(0, r2.getInt("int_DevType"), r2.getInt("int_TransType"));
        c0065b.f3505b = r2.getInt("int_RfFreq");
        c0065b.f3506c = r2.getInt("int_Period");
        c0065b.f3507d = bundle.getInt("int_ProximityBin");
        c0065b.f3508e = j.i.TEN_SECONDS;
        com.dsi.ant.channel.b bVar = (com.dsi.ant.channel.b) r2.getSerializable("predefinednetwork_NetKey");
        try {
            com.dsi.ant.plugins.antplus.utility.search.f s2 = s(c0065b, this.f440n.getLooper(), -1L, bundle);
            aVar.f3454c = UUID.randomUUID();
            h hVar = new h(aVar, s2);
            hVar.f475e = aVar2;
            hVar.f476f = bundle;
            this.f436j.put(aVar.f3454c, hVar);
            try {
                D(aVar, aVar2, bundle);
                AntChannel f3 = f(bVar, null, aVar2, aVar, bundle.getInt("int_RssiMode", 0));
                if (f3 == null) {
                    E(aVar.f3454c);
                    return;
                }
                F(f3, hVar);
                Message obtain = Message.obtain();
                obtain.what = 0;
                Bundle bundle2 = new Bundle();
                bundle2.putSerializable("uuid_AccessToken", aVar.f3454c);
                bundle2.putParcelable("msgr_PluginComm", this.f444r);
                obtain.setData(bundle2);
                try {
                    aVar2.b(obtain);
                } catch (RemoteException unused) {
                    h1.a.b(this.f427a, "RemoteException sending async scan init info.");
                    E(aVar.f3454c);
                }
            } catch (RemoteException unused2) {
                h1.a.b(this.f427a, "RemoteException sending async scan already connected devices, closing scan.");
                E(aVar.f3454c);
            }
        } catch (IllegalArgumentException e3) {
            h1.a.k(this.f427a, "Invalid arguments when constructing scan", e3);
            Message obtain2 = Message.obtain();
            obtain2.what = -9;
            o(aVar2, obtain2);
        }
    }
}
