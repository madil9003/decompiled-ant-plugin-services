package e1;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.dsi.ant.plugins.antplus.pccbase.MultiDeviceSearch$MultiDeviceSearchResult;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import n0.c;
import p0.e;

/* loaded from: classes.dex */
public class a {

    /* renamed from: k */
    private static final String f1651k = n0.c.class.getSimpleName();

    /* renamed from: a */
    private final Context f1652a;

    /* renamed from: b */
    private n0.c f1653b;

    /* renamed from: c */
    private EnumSet f1654c;

    /* renamed from: f */
    private List f1657f;

    /* renamed from: g */
    private HandlerThread f1658g;

    /* renamed from: h */
    private final Handler f1659h;

    /* renamed from: d */
    private ArrayList f1655d = new ArrayList();

    /* renamed from: e */
    private final Object f1656e = new Object();

    /* renamed from: i */
    private c.e f1660i = new b();

    /* renamed from: j */
    private c.InterfaceC0043c f1661j = new c();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e1.a$a */
    /* loaded from: classes.dex */
    public class HandlerC0031a extends Handler {
        HandlerC0031a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 0) {
                if (a.this.f1653b == null) {
                    h1.a.a(a.f1651k, "Multi device search started");
                    a.this.f1653b = new n0.c(a.this.f1652a, a.this.f1654c, a.this.f1660i, a.this.f1661j);
                    return;
                }
                return;
            }
            if (i2 == 1) {
                if (a.this.f1653b != null) {
                    h1.a.a(a.f1651k, "Multi device search Stopped");
                    a.this.f1653b.g();
                    a.this.f1653b = null;
                }
                a.this.f1659h.removeCallbacksAndMessages(0);
                a.this.f1659h.getLooper().quit();
                h1.a.a(a.f1651k, "Multi device search destroyed");
                return;
            }
            if (i2 != 2) {
                return;
            }
            MultiDeviceSearch$MultiDeviceSearchResult multiDeviceSearch$MultiDeviceSearchResult = (MultiDeviceSearch$MultiDeviceSearchResult) message.obj;
            d dVar = new d();
            dVar.f1665a = multiDeviceSearch$MultiDeviceSearchResult;
            synchronized (a.this.f1656e) {
                Iterator it = a.this.f1657f.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    d1.a aVar = (d1.a) it.next();
                    if (aVar.t().equals(multiDeviceSearch$MultiDeviceSearchResult.b())) {
                        h1.a.f(a.f1651k, "Adding ANT device found: " + multiDeviceSearch$MultiDeviceSearchResult.c());
                        a.this.f1655d.add(dVar);
                        aVar.k(a.this.f1652a, multiDeviceSearch$MultiDeviceSearchResult.a());
                        break;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements c.e {
        b() {
        }

        @Override // n0.c.e
        public void a(e eVar) {
            new Intent().putExtra("com.dsi.ant.antplus.pluginsampler.multidevicesearch.result", eVar.b());
            h1.a.b(a.f1651k, "onSearchStopped(), reason: " + eVar);
            a.this.f1659h.sendEmptyMessage(1);
        }

        @Override // n0.c.e
        public void b(c.d dVar) {
            h1.a.f(a.f1651k, "onSearchStarted");
        }

        @Override // n0.c.e
        public void c(MultiDeviceSearch$MultiDeviceSearchResult multiDeviceSearch$MultiDeviceSearchResult) {
            a.this.m(multiDeviceSearch$MultiDeviceSearchResult);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements c.InterfaceC0043c {
        c() {
        }

        @Override // n0.c.InterfaceC0043c
        public void a(int i2, int i3) {
            synchronized (a.this.f1656e) {
                Iterator it = a.this.f1655d.iterator();
                while (it.hasNext()) {
                    d dVar = (d) it.next();
                    if (dVar.f1665a.f816d == i2) {
                        dVar.f1666b = i3;
                        h1.a.a(a.f1651k, "Updating RSSI: " + i3 + ", resultID: " + i2);
                        Iterator it2 = a.this.f1657f.iterator();
                        while (it2.hasNext()) {
                            ((d1.a) it2.next()).F(dVar.f1665a.a(), i3);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    class d {

        /* renamed from: a */
        public MultiDeviceSearch$MultiDeviceSearchResult f1665a;

        /* renamed from: b */
        public int f1666b = Integer.MIN_VALUE;

        d() {
        }
    }

    public a(Context context, EnumSet enumSet, List list) {
        HandlerThread handlerThread = new HandlerThread("MultiDeviceSearchHandler");
        this.f1658g = handlerThread;
        handlerThread.start();
        this.f1657f = list;
        this.f1652a = context;
        this.f1654c = enumSet;
        HandlerC0031a handlerC0031a = new HandlerC0031a(this.f1658g.getLooper());
        this.f1659h = handlerC0031a;
        handlerC0031a.sendEmptyMessage(0);
    }

    public void m(MultiDeviceSearch$MultiDeviceSearchResult multiDeviceSearch$MultiDeviceSearchResult) {
        Message obtain = Message.obtain();
        obtain.what = 2;
        obtain.obj = multiDeviceSearch$MultiDeviceSearchResult;
        this.f1659h.sendMessage(obtain);
    }

    public void n() {
        this.f1659h.sendEmptyMessage(1);
    }
}
