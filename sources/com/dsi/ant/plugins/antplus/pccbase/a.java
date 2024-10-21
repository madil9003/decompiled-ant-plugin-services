package com.dsi.ant.plugins.antplus.pccbase;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.dsi.ant.plugins.internal.pluginsipc.AntPluginDeviceDbProvider;
import java.util.Iterator;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes.dex */
public abstract class a {
    private static final String B = "a";
    static volatile String C = "";
    static volatile String D = "";

    /* renamed from: a */
    ServiceConnection f817a;

    /* renamed from: c */
    volatile Handler f819c;

    /* renamed from: f */
    volatile Handler f822f;

    /* renamed from: h */
    Messenger f824h;

    /* renamed from: i */
    UUID f825i;

    /* renamed from: j */
    Messenger f826j;

    /* renamed from: p */
    Context f832p;

    /* renamed from: q */
    AntPluginDeviceDbProvider.DeviceDbDeviceInfo f833q;

    /* renamed from: s */
    private Thread f835s;

    /* renamed from: t */
    protected int f836t;

    /* renamed from: u */
    protected boolean f837u;

    /* renamed from: v */
    protected e f838v;

    /* renamed from: w */
    protected volatile com.dsi.ant.plugins.antplus.pccbase.d f839w;

    /* renamed from: b */
    HandlerThread f818b = new HandlerThread("PluginPCCMsgHandler");

    /* renamed from: d */
    Handler.Callback f820d = new b();

    /* renamed from: e */
    HandlerThread f821e = new HandlerThread("PluginPCCEventHandler");

    /* renamed from: g */
    Handler.Callback f823g = new c();

    /* renamed from: k */
    private final ReentrantLock f827k = new ReentrantLock();

    /* renamed from: l */
    Exchanger f828l = new Exchanger();

    /* renamed from: m */
    CyclicBarrier f829m = new CyclicBarrier(2);

    /* renamed from: n */
    boolean f830n = false;

    /* renamed from: o */
    CountDownLatch f831o = new CountDownLatch(1);

    /* renamed from: r */
    Integer f834r = null;

    /* renamed from: x */
    private boolean f840x = false;

    /* renamed from: y */
    private final Object f841y = new Object();

    /* renamed from: z */
    private boolean f842z = false;
    private Object A = new Object();

    /* renamed from: com.dsi.ant.plugins.antplus.pccbase.a$a */
    /* loaded from: classes.dex */
    public class ServiceConnectionC0011a implements ServiceConnection {

        /* renamed from: a */
        final /* synthetic */ Bundle f843a;

        ServiceConnectionC0011a(Bundle bundle) {
            this.f843a = bundle;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            synchronized (a.this.f841y) {
                if (a.this.f840x) {
                    return;
                }
                a.this.f824h = new Messenger(iBinder);
                Message obtain = Message.obtain();
                obtain.what = 0;
                obtain.setData(this.f843a);
                try {
                    a.this.f824h.send(obtain);
                } catch (RemoteException unused) {
                    a.this.s(this.f843a);
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            a aVar = a.this;
            if (aVar.f830n) {
                aVar.o("OnServiceDisconnected fired");
            } else {
                aVar.s(this.f843a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements Handler.Callback {
        b() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            h1.a.i(a.B, "Plugin Msg Handler received: " + message.what + ", " + message.arg1);
            if (a.this.f827k.tryLock()) {
                try {
                    a.this.p(message);
                } finally {
                    a.this.f827k.unlock();
                }
            } else {
                try {
                    a.this.f828l.exchange(message);
                    a.this.f829m.await();
                } catch (InterruptedException unused) {
                    a.this.o("InterruptedException in mPluginMsgHandler trying to fwd message " + message.what);
                    Thread.currentThread().interrupt();
                    return true;
                } catch (BrokenBarrierException unused2) {
                    a.this.o("BrokenBarrierException in mPluginMsgHandler trying to fwd message " + message.what);
                    return true;
                }
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements Handler.Callback {
        c() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            com.dsi.ant.plugins.antplus.pccbase.d dVar = a.this.f839w;
            if (dVar == null) {
                return true;
            }
            try {
                a.this.f831o.await();
            } catch (InterruptedException unused) {
                h1.a.f(a.B, "Plugin event thread interrupted while waiting for initialization to complete.");
                Thread.currentThread().interrupt();
            }
            synchronized (dVar.f855d) {
                if (!dVar.h()) {
                    return true;
                }
                int i2 = message.what;
                if (i2 == 1) {
                    a.this.q(message);
                } else if (i2 != 3) {
                    h1.a.j(a.B, "Unrecognized plugin event received: " + message.arg1);
                } else {
                    int i3 = message.arg1;
                    a.this.f834r = Integer.valueOf(i3);
                    h1.a.i(a.B, "State event: " + i3);
                    if (i3 == -100) {
                        a.this.o("Device dead");
                    } else {
                        a.this.f838v.b(p0.b.c(i3));
                    }
                }
                return true;
            }
        }
    }

    /* loaded from: classes.dex */
    public class d extends Handler {

        /* renamed from: a */
        final /* synthetic */ CountDownLatch f847a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(Looper looper, CountDownLatch countDownLatch) {
            super(looper);
            this.f847a = countDownLatch;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            this.f847a.countDown();
        }
    }

    /* loaded from: classes.dex */
    public interface e {
        void b(p0.b bVar);
    }

    /* loaded from: classes.dex */
    public interface f {
        void a(a aVar, p0.e eVar, p0.b bVar);
    }

    /* loaded from: classes.dex */
    public static class g extends Handler {

        /* renamed from: a */
        protected a f849a;

        /* renamed from: b */
        protected f f850b;

        public void a(String str, p0.e eVar) {
            h1.a.j(a.B, "RequestAccess failed: " + str);
            this.f849a.t();
            this.f850b.a(null, eVar, p0.b.DEAD);
        }

        public boolean b(Message message) {
            int i2 = message.what;
            if (i2 == -5) {
                Bundle data = message.getData();
                a.C = data.getString("string_DependencyPackageName");
                a.D = data.getString("string_DependencyName");
                a("Missing Dependency: " + a.C + " not installed.", p0.e.DEPENDENCY_NOT_INSTALLED);
                return true;
            }
            if (i2 != 0) {
                return false;
            }
            Bundle data2 = message.getData();
            int i3 = data2.getInt("int_ServiceVersion", 0);
            Messenger messenger = (Messenger) data2.getParcelable("msgr_PluginComm");
            UUID uuid = (UUID) data2.get("uuid_AccessToken");
            int i4 = data2.getInt("int_InitialDeviceStateCode");
            AntPluginDeviceDbProvider.DeviceDbDeviceInfo deviceDbDeviceInfo = (AntPluginDeviceDbProvider.DeviceDbDeviceInfo) data2.getParcelable("parcelable_DeviceDbInfo");
            if (deviceDbDeviceInfo == null) {
                deviceDbDeviceInfo = new AntPluginDeviceDbProvider.DeviceDbDeviceInfo(0);
                deviceDbDeviceInfo.f1176d = Integer.valueOf(data2.getInt("int_AntDeviceID", -1));
                deviceDbDeviceInfo.f1177e = data2.getString("str_DeviceName");
                deviceDbDeviceInfo.f1178f = Boolean.FALSE;
            }
            this.f849a.f837u = data2.getBoolean("bool_RssiSupport", false);
            this.f849a.r(deviceDbDeviceInfo, uuid, messenger, i4, i3);
            this.f850b.a(this.f849a, p0.e.c(i2), p0.b.c(i4));
            this.f849a.f831o.countDown();
            return true;
        }

        public void c(a aVar, f fVar) {
            this.f849a = aVar;
            this.f850b = fVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            String obj;
            h1.a.i(a.B, "ReqAcc Handler received: " + message.what);
            message.getData().setClassLoader(getClass().getClassLoader());
            if (b(message)) {
                return;
            }
            p0.e c3 = p0.e.c(message.what);
            if (c3 == p0.e.UNRECOGNIZED) {
                obj = "Unrecognized return code (need app lib upgrade): " + message.what + "!!!";
            } else {
                obj = c3.toString();
            }
            a(obj, c3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class h extends g {
        protected h() {
        }

        @Override // com.dsi.ant.plugins.antplus.pccbase.a.g
        public boolean b(Message message) {
            if (message.what != -7) {
                return super.b(message);
            }
            a("Search for device timed out.", p0.e.SEARCH_TIMEOUT);
            return true;
        }
    }

    /* loaded from: classes.dex */
    public final class i extends com.dsi.ant.plugins.antplus.pccbase.d {
        protected i(f fVar, e eVar) {
            super(fVar, eVar);
        }

        @Override // com.dsi.ant.plugins.antplus.pccbase.d
        protected void i() {
            a.this.h();
        }
    }

    public a() {
        this.f821e.start();
        this.f822f = new Handler(this.f821e.getLooper(), this.f823g);
        this.f818b.start();
        this.f819c = new Handler(this.f818b.getLooper(), this.f820d);
    }

    private void A(int i2) {
        synchronized (this.f827k) {
            try {
                Messenger messenger = this.f826j;
                if (messenger != null) {
                    messenger.send(i(i2, null));
                }
            } catch (RemoteException unused) {
                h1.a.b(B, "RemoteException, unable to cleanly release (cmd " + i2 + ")");
            }
        }
    }

    private void C() {
        synchronized (this.A) {
            if (this.f842z) {
                try {
                    this.f832p.unbindService(this.f817a);
                } catch (IllegalArgumentException e3) {
                    h1.a.b(B, "Unexpected error unbinding service, " + e3);
                }
                this.f842z = false;
            }
        }
    }

    private void g(Intent intent, Bundle bundle) {
        synchronized (this.A) {
            if (!this.f842z) {
                this.f842z = true;
                if (!this.f832p.bindService(intent, this.f817a, 1)) {
                    h1.a.b(B, "Binding to plugin failed");
                    s(bundle);
                }
            }
        }
    }

    public static String j() {
        return D;
    }

    public static String k() {
        return C;
    }

    private Messenger l() {
        return new Messenger(this.f819c);
    }

    public void s(Bundle bundle) {
        h();
        Messenger messenger = (Messenger) bundle.getParcelable("msgr_ReqAccResultReceiver");
        Message obtain = Message.obtain();
        obtain.what = -4;
        try {
            messenger.send(obtain);
        } catch (RemoteException unused) {
            h1.a.b(B, "Remote exception sending failure msg to client");
        }
    }

    public static com.dsi.ant.plugins.antplus.pccbase.d u(Context context, int i2, int i3, a aVar, f fVar, e eVar) {
        Bundle bundle = new Bundle();
        bundle.putInt("int_RequestAccessMode", 3);
        bundle.putInt("int_AntDeviceID", i2);
        bundle.putInt("int_ProximityBin", i3);
        return v(context, bundle, aVar, new h(), fVar, eVar);
    }

    protected static com.dsi.ant.plugins.antplus.pccbase.d v(Context context, Bundle bundle, a aVar, g gVar, f fVar, e eVar) {
        if (fVar == null || eVar == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid argument: ");
            sb.append(fVar == null ? "resultReceiver " : "stateReceiver ");
            sb.append(" is null ");
            throw new IllegalArgumentException(sb.toString());
        }
        Objects.requireNonNull(aVar);
        i iVar = new i(fVar, eVar);
        aVar.f839w = iVar;
        aVar.f838v = iVar.f859h;
        gVar.c(aVar, iVar.f858g);
        w(context, bundle, aVar, gVar);
        return iVar;
    }

    public static void w(Context context, Bundle bundle, a aVar, Handler handler) {
        if (handler == null) {
            throw new IllegalArgumentException("resultHandler passed from client was null");
        }
        String packageName = context.getPackageName();
        String charSequence = context.getPackageManager().getApplicationLabel(context.getApplicationInfo()).toString();
        bundle.putString("str_ApplicationNamePackage", packageName);
        bundle.putString("str_ApplicationNameTitle", charSequence);
        if (!bundle.containsKey("int_RssiMode")) {
            bundle.putInt("int_RssiMode", 1);
        }
        aVar.f(context, bundle, handler);
    }

    private void x(Messenger messenger, String str, String str2) {
        Message obtain = Message.obtain();
        obtain.what = -5;
        Bundle bundle = new Bundle();
        bundle.putString("string_DependencyPackageName", str);
        bundle.putString("string_DependencyName", str2);
        obtain.setData(bundle);
        try {
            messenger.send(obtain);
        } catch (RemoteException unused) {
            o("Remote exception sending plugin 'dependency not installed' msg to client");
        }
    }

    private Message z(Message message) {
        synchronized (this.f827k) {
            int i2 = message.what;
            this.f835s = Thread.currentThread();
            if (this.f826j == null) {
                return null;
            }
            try {
                try {
                    if (!this.f827k.tryLock(7000L, TimeUnit.MILLISECONDS)) {
                        throw new TimeoutException();
                    }
                    this.f826j.send(message);
                    while (true) {
                        try {
                            Message message2 = (Message) this.f828l.exchange(null, 5L, TimeUnit.SECONDS);
                            if (message2.what == i2) {
                                Message obtain = Message.obtain(message2);
                                try {
                                    this.f829m.await();
                                    return obtain;
                                } catch (InterruptedException unused) {
                                    o("InterruptedException in sendPluginCommand finally on message " + i2);
                                    Thread.currentThread().interrupt();
                                    return null;
                                } catch (BrokenBarrierException unused2) {
                                    o("BrokenBarrierException in sendPluginCommand finally on message " + i2);
                                    return null;
                                }
                            }
                            p(message2);
                            try {
                                this.f829m.await();
                            } catch (InterruptedException unused3) {
                                o("InterruptedException in sendPluginCommand (at non-success mPluginCommProcessingBarrier) on message " + i2);
                                Thread.currentThread().interrupt();
                                return null;
                            } catch (BrokenBarrierException unused4) {
                                o("BrokenBarrierException in sendPluginCommand (at non-success mPluginCommProcessingBarrier) on message " + i2);
                                return null;
                            }
                        } catch (InterruptedException unused5) {
                            o("InterruptedException in sendPluginCommand (at mPluginCommMsgExch.exchange()) on message " + i2);
                            Thread.currentThread().interrupt();
                            return null;
                        } catch (TimeoutException unused6) {
                            o("TimeoutException in sendPluginCommand (at mPluginCommMsgExch.exchange()) on message " + i2);
                            return null;
                        }
                    }
                } catch (RemoteException unused7) {
                    o("RemoteException sending message " + i2 + " to plugin");
                    return null;
                } finally {
                    this.f827k.unlock();
                }
            } catch (InterruptedException unused8) {
                o("InterruptedException obtaining mPluginCommLock in sendPluginCommand on message " + i2);
                Thread.currentThread().interrupt();
                return null;
            } catch (TimeoutException unused9) {
                o("TimeoutException obtaining mPluginCommLock in sendPluginCommand on message " + i2);
                return null;
            }
        }
    }

    public boolean B(int i2) {
        Message i3 = i(10000, null);
        i3.arg1 = i2;
        Message y2 = y(i3);
        if (y2 == null) {
            h1.a.b(B, "subscribeToEvent died in sendPluginCommand()");
            return false;
        }
        if (y2.arg1 == 0) {
            y2.recycle();
            return true;
        }
        h1.a.b(B, "Subscribing to event " + i2 + " failed with code " + y2.arg1);
        y2.recycle();
        return false;
    }

    public void D(int i2) {
        Message i3 = i(10001, null);
        i3.arg1 = i2;
        Message y2 = y(i3);
        if (y2 == null) {
            h1.a.b(B, "unsubscribeFromEvent died in sendPluginCommand()");
            return;
        }
        if (y2.arg1 == 0) {
            y2.recycle();
            return;
        }
        throw new RuntimeException("Unsubscribing to event " + i2 + " failed with code " + i3.arg1);
    }

    protected void f(Context context, Bundle bundle, Handler handler) {
        PackageInfo packageInfo;
        this.f832p = context;
        Messenger messenger = new Messenger(handler);
        bundle.putParcelable("msgr_PluginMsgHandler", l());
        bundle.putParcelable("msgr_ReqAccResultReceiver", messenger);
        h1.a.h("BBD30900");
        try {
            h1.a.e(this.f832p.createPackageContext("com.dsi.ant.plugins.antplus", 4));
        } catch (PackageManager.NameNotFoundException e3) {
            h1.a.b(B, "Unable to configure logging, plugins package not found: " + e3);
        }
        bundle.putInt("int_PluginLibVersion", 30900);
        bundle.putString("string_PluginLibVersion", "3.9.0");
        bundle.putInt("more", 1);
        Intent n2 = n();
        Iterator<PackageInfo> it = this.f832p.getPackageManager().getInstalledPackages(0).iterator();
        while (true) {
            if (!it.hasNext()) {
                packageInfo = null;
                break;
            } else {
                packageInfo = it.next();
                if (packageInfo.packageName.equals(n2.getComponent().getPackageName())) {
                    break;
                }
            }
        }
        if (packageInfo == null) {
            h1.a.b(B, "Binding to plugin failed, not installed");
            x((Messenger) bundle.getParcelable("msgr_ReqAccResultReceiver"), n2.getComponent().getPackageName(), "ANT+ Plugins Service");
            return;
        }
        if (packageInfo.versionCode >= m()) {
            this.f817a = new ServiceConnectionC0011a(bundle);
            g(n2, bundle);
            return;
        }
        h1.a.b(B, "Binding to plugin failed, version requirement not met");
        x((Messenger) bundle.getParcelable("msgr_ReqAccResultReceiver"), n2.getComponent().getPackageName(), "ANT+ Plugins Service minimum v." + m());
    }

    public void h() {
        synchronized (this.f841y) {
            if (this.f840x) {
                return;
            }
            this.f840x = true;
            Messenger messenger = this.f824h;
            if (messenger != null) {
                CountDownLatch countDownLatch = new CountDownLatch(1);
                Bundle bundle = new Bundle();
                bundle.putParcelable("msgr_PluginMsgHandler", l());
                bundle.putParcelable("msgr_ReqAccResultReceiver", new Messenger(new d(this.f818b.getLooper(), countDownLatch)));
                Context context = this.f832p;
                if (context != null) {
                    String packageName = context.getPackageName();
                    String charSequence = this.f832p.getPackageManager().getApplicationLabel(this.f832p.getApplicationInfo()).toString();
                    bundle.putString("str_ApplicationNamePackage", packageName);
                    bundle.putString("str_ApplicationNameTitle", charSequence);
                }
                bundle.putInt("int_PluginLibVersion", 30900);
                bundle.putString("string_PluginLibVersion", "3.9.0");
                Message obtain = Message.obtain();
                obtain.what = 1;
                obtain.setData(bundle);
                try {
                    messenger.send(obtain);
                    countDownLatch.await(500L, TimeUnit.MILLISECONDS);
                } catch (RemoteException | InterruptedException unused) {
                }
            }
            this.f818b.quit();
            try {
                this.f818b.join(1000L);
            } catch (InterruptedException unused2) {
                h1.a.b(B, "Plugin Msg Handler thread failed to shut down cleanly, InterruptedException");
                Thread.currentThread().interrupt();
            }
            this.f822f = null;
            this.f821e.quit();
            try {
                this.f821e.join(1000L);
            } catch (InterruptedException unused3) {
                h1.a.b(B, "Plugin Event Handler thread failed to shut down cleanly, InterruptedException");
                Thread.currentThread().interrupt();
            }
            C();
            if (this.f827k.tryLock()) {
                this.f827k.unlock();
            } else {
                this.f835s.interrupt();
            }
            synchronized (this.f827k) {
                this.f826j = null;
            }
        }
    }

    protected Message i(int i2, Bundle bundle) {
        Message obtain = Message.obtain();
        obtain.what = i2;
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putSerializable("uuid_AccessToken", this.f825i);
        obtain.setData(bundle);
        return obtain;
    }

    protected abstract int m();

    protected abstract Intent n();

    public void o(String str) {
        h1.a.j(B, "ConnectionDied: " + str);
        if (this.f839w == null || this.f839w.f852a) {
            return;
        }
        t();
        this.f838v.b(p0.b.DEAD);
    }

    protected void p(Message message) {
        Handler handler = this.f822f;
        if (handler != null) {
            Message obtainMessage = handler.obtainMessage(message.what, message.arg1, message.arg2, message.obj);
            obtainMessage.setData(message.getData());
            obtainMessage.replyTo = message.replyTo;
            handler.sendMessage(obtainMessage);
        }
    }

    protected abstract void q(Message message);

    void r(AntPluginDeviceDbProvider.DeviceDbDeviceInfo deviceDbDeviceInfo, UUID uuid, Messenger messenger, int i2, int i3) {
        this.f833q = deviceDbDeviceInfo;
        this.f825i = uuid;
        this.f826j = messenger;
        this.f836t = i3;
        if (this.f834r == null) {
            this.f834r = Integer.valueOf(i2);
        }
        this.f830n = true;
    }

    public void t() {
        synchronized (this.f827k) {
            this.f834r = -100;
            try {
                A(10002);
            } finally {
                h();
            }
        }
    }

    protected Message y(Message message) {
        Bundle data = message.getData();
        if (data == null) {
            data = new Bundle();
            message.setData(data);
        }
        data.putSerializable("uuid_AccessToken", this.f825i);
        return z(message);
    }
}
