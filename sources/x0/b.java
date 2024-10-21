package x0;

import android.os.Bundle;
import android.os.Message;
import android.os.RemoteException;
import android.os.SystemClock;
import com.dsi.ant.channel.AntChannel;
import com.dsi.ant.plugins.antplus.common.FitFileCommon;
import com.dsi.ant.plugins.antplus.watchcommunicator.WatchCommunicatorService;
import com.dsi.ant.plugins.internal.pluginsipc.AntPluginDeviceDbProvider;
import java.nio.channels.ClosedChannelException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import s0.a;
import s0.g;
import s0.i;
import s0.o;
import u0.a;
import v.e;
import x0.a;

/* loaded from: classes.dex */
public class b extends e {

    /* renamed from: n */
    private static final String f3563n = "b";

    /* renamed from: h */
    private u.a f3564h;

    /* renamed from: i */
    private WatchCommunicatorService f3565i;

    /* renamed from: j */
    private u0.a f3566j;

    /* renamed from: k */
    public x0.c f3567k;

    /* renamed from: l */
    public x0.a f3568l;

    /* renamed from: m */
    public Map f3569m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements a.c {
        a() {
        }

        @Override // u0.a.c
        public void a() {
            b.this.d();
        }
    }

    /* renamed from: x0.b$b */
    /* loaded from: classes.dex */
    public class C0068b extends c {

        /* renamed from: j */
        HashMap f3571j;

        /* renamed from: k */
        long f3572k;

        /* renamed from: x0.b$b$a */
        /* loaded from: classes.dex */
        public class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                u0.a aVar = b.this.f3566j;
                C0068b c0068b = C0068b.this;
                b bVar = b.this;
                x0.c cVar = bVar.f3567k;
                long a3 = j1.a.a(bVar.f3565i);
                int a4 = C0068b.this.f3575d.f3558a.a();
                a.C0067a c0067a = C0068b.this.f3575d;
                o.g(aVar, cVar, c0068b, a3, a4, c0067a.f3560c, c0067a.f3559b, 30);
            }
        }

        public C0068b(boolean z2, a.C0067a c0067a) {
            super(z2, null, c0067a, false);
            this.f3571j = new HashMap();
            this.f3572k = -1L;
        }

        @Override // x0.b.c, s0.o.c
        public /* bridge */ /* synthetic */ i b() {
            return super.b();
        }

        @Override // x0.b.c, s0.o.d, s0.o.c
        public void c(a.b bVar, long j2, byte[] bArr) {
            long j3 = bVar.f3090g;
            long j4 = bVar.f3091h;
            if (j3 != j4) {
                j3 = this.f3578g + j4;
            }
            Bundle bundle = new Bundle();
            bundle.putSerializable("uuid_targetDeviceUUID", this.f3575d.f3562e.c());
            bundle.putLong("long_targetBytes", j2);
            bundle.putByteArray("arrayByte_rawFileBytes", bArr);
            synchronized (this.f3571j) {
                for (e.a aVar : this.f3571j.values()) {
                    Message obtain = Message.obtain();
                    obtain.what = 1;
                    obtain.arg1 = 203;
                    obtain.arg2 = 191;
                    obtain.setData(bundle);
                    if (b.this.j(aVar, obtain)) {
                        long i2 = b.this.f3567k.i(aVar.f3452a, this.f3575d);
                        this.f3577f = i2;
                        if (j3 > i2) {
                            b.this.f3567k.l(aVar.f3452a, this.f3575d, j3);
                        }
                    }
                }
            }
        }

        @Override // x0.b.c, s0.o.d, s0.o.c
        public void d(int i2) {
            h1.a.a(b.f3563n, "Check for new activities on device " + this.f3575d.f3562e.d() + " finished. Result: " + i2);
            if (i2 == 0) {
                this.f3572k = SystemClock.elapsedRealtime();
            }
        }

        @Override // x0.b.c, s0.o.c
        public /* bridge */ /* synthetic */ boolean e(g gVar) {
            return super.e(gVar);
        }

        @Override // x0.b.c, s0.o.c
        public boolean f(g gVar) {
            long j2;
            synchronized (this.f3571j) {
                Iterator it = this.f3571j.values().iterator();
                j2 = Long.MAX_VALUE;
                while (it.hasNext()) {
                    long i2 = b.this.f3567k.i(((e.a) it.next()).f3452a, this.f3575d);
                    if (i2 < j2) {
                        j2 = i2;
                    }
                }
            }
            this.f3577f = j2;
            this.f3578g = gVar.N();
            return true;
        }

        @Override // x0.b.c, s0.o.c
        public /* bridge */ /* synthetic */ boolean h(a.b bVar) {
            return super.h(bVar);
        }

        @Override // x0.b.c, s0.o.d
        protected void j(Message message) {
            h1.a.b(b.f3563n, "Check for new activities attempting to send unexpected message, event: " + message.arg1);
            message.recycle();
        }

        public boolean k(e.a aVar) {
            synchronized (this.f3571j) {
                this.f3572k = -1L;
                if (this.f3571j.containsKey(aVar.f3454c)) {
                    return false;
                }
                this.f3571j.put(aVar.f3454c, aVar);
                return true;
            }
        }

        public void l() {
            synchronized (this.f3571j) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (!this.f3571j.isEmpty()) {
                    long j2 = this.f3572k;
                    if (j2 == -1 || elapsedRealtime - 300000 > j2) {
                        new Thread(new a()).start();
                        return;
                    }
                }
                this.f3572k = elapsedRealtime;
            }
        }

        public boolean m(e.a aVar) {
            boolean z2;
            synchronized (this.f3571j) {
                z2 = this.f3571j.remove(aVar.f3454c) == null;
                if (this.f3571j.isEmpty()) {
                    b.this.f3569m.remove(this);
                }
            }
            return z2;
        }

        public void n() {
            this.f3572k = -1L;
        }
    }

    /* loaded from: classes.dex */
    public class c extends o.d {

        /* renamed from: d */
        protected a.C0067a f3575d;

        /* renamed from: e */
        private boolean f3576e;

        /* renamed from: f */
        protected long f3577f;

        /* renamed from: g */
        protected int f3578g;

        /* renamed from: h */
        private e.a f3579h;

        public c(boolean z2, e.a aVar, a.C0067a c0067a, boolean z3) {
            super(202, z3);
            this.f3576e = z2;
            this.f3579h = aVar;
            this.f3575d = c0067a;
            this.f3578g = -1;
        }

        @Override // s0.o.c
        public i b() {
            return new y0.b(a(), this.f3575d);
        }

        @Override // s0.o.d, s0.o.c
        public void c(a.b bVar, long j2, byte[] bArr) {
            long i2 = b.this.f3567k.i(this.f3579h.f3452a, this.f3575d);
            this.f3577f = i2;
            long j3 = bVar.f3090g;
            long j4 = bVar.f3091h;
            if (j3 != j4) {
                j3 = this.f3578g + j4;
            }
            if (j3 > i2) {
                b.this.f3567k.l(this.f3579h.f3452a, this.f3575d, j3);
            }
            super.c(bVar, j2, bArr);
        }

        @Override // s0.o.d, s0.o.c
        public void d(int i2) {
            b.this.f3567k.close();
            super.d(i2);
        }

        @Override // s0.o.c
        public boolean e(g gVar) {
            b.this.f3567k.b();
            if (!b.this.f3567k.k()) {
                return super.e(gVar);
            }
            h1.a.b(b.f3563n, "Detected device parameter collision with only serial number different, this situation is currently unsupported. If you see this contact thisisant.com and we can discuss adding the ability to handle this.");
            d(-61);
            return false;
        }

        @Override // s0.o.c
        public boolean f(g gVar) {
            this.f3577f = b.this.f3567k.i(this.f3579h.f3452a, this.f3575d);
            this.f3578g = gVar.N();
            return true;
        }

        @Override // s0.o.c
        public boolean h(a.b bVar) {
            if (bVar.f3085b == FitFileCommon.a.FIT_DATA_TYPE.b() && bVar.f3086c[0] == 4) {
                boolean z2 = this.f3576e;
                if (!z2) {
                    return true;
                }
                if (z2 && bVar.f3091h > this.f3577f) {
                    return true;
                }
                if (z2 && bVar.f3091h == 0) {
                    return true;
                }
            }
            return false;
        }

        @Override // s0.o.d
        protected void j(Message message) {
            b.this.j(this.f3579h, message);
        }
    }

    public b(AntChannel antChannel, WatchCommunicatorService watchCommunicatorService) {
        super(null, 1);
        this.f3569m = Collections.synchronizedMap(new HashMap());
        this.f3565i = watchCommunicatorService;
        AntPluginDeviceDbProvider.DeviceDbDeviceInfo deviceDbDeviceInfo = new AntPluginDeviceDbProvider.DeviceDbDeviceInfo();
        this.f3451f = deviceDbDeviceInfo;
        deviceDbDeviceInfo.f1176d = -1;
        this.f3451f.f1177e = "WatchCommunicator";
        this.f3567k = new x0.c(watchCommunicatorService);
        this.f3568l = new x0.a(this.f3564h);
        try {
            u0.a aVar = new u0.a(antChannel, new a());
            this.f3566j = aVar;
            aVar.s(new y0.a(this));
        } catch (RemoteException unused) {
            h1.a.b(f3563n, "RemoteException during initizalization");
            d();
            throw new ClosedChannelException();
        }
    }

    private a.C0067a q(UUID uuid) {
        a.C0067a c0067a;
        synchronized (this.f3568l.f3557c) {
            Iterator it = this.f3568l.f3557c.iterator();
            while (true) {
                if (!it.hasNext()) {
                    c0067a = null;
                    break;
                }
                c0067a = (a.C0067a) it.next();
                if (c0067a.f3562e.c().equals(uuid)) {
                    break;
                }
            }
        }
        if (c0067a == null) {
            this.f3567k.b();
            c0067a = this.f3567k.g(uuid);
            this.f3567k.close();
            if (c0067a == null) {
                return null;
            }
        } else {
            this.f3567k.b();
            this.f3567k.j(c0067a);
            this.f3567k.close();
        }
        return c0067a;
    }

    private void r(e.a aVar, UUID uuid, boolean z2, boolean z3) {
        a.C0067a q2 = q(uuid);
        if (q2 != null) {
            o.g(this.f3566j, this.f3567k, new c(z3, aVar, q2, z2), j1.a.a(this.f3565i), q2.f3558a.a(), q2.f3560c, q2.f3559b, 30);
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.arg1 = 202;
        Bundle bundle = new Bundle();
        bundle.putInt("int_statusCode", -50);
        obtain.setData(bundle);
        j(aVar, obtain);
    }

    @Override // v.e
    public void b(UUID uuid, Message message) {
        e.a aVar = (e.a) this.f3447b.get(uuid);
        Message obtain = Message.obtain();
        obtain.what = message.what;
        switch (message.what) {
            case 20001:
                obtain.arg1 = 0;
                j(aVar, obtain);
                this.f3568l.d(aVar);
                return;
            case 20002:
            case 20003:
                Bundle data = message.getData();
                UUID uuid2 = (UUID) data.getSerializable("uuid_targetDeviceUUID");
                obtain.arg1 = 0;
                j(aVar, obtain);
                r(aVar, uuid2, data.getBoolean("bool_UseAntFsProgressUpdates"), message.what == 20003);
                return;
            case 20004:
                UUID uuid3 = (UUID) message.getData().getSerializable("uuid_targetDeviceUUID");
                a.C0067a q2 = q(uuid3);
                if (q2 == null) {
                    obtain.arg1 = -3;
                    j(aVar, obtain);
                    return;
                }
                obtain.arg1 = 0;
                j(aVar, obtain);
                C0068b c0068b = (C0068b) this.f3569m.get(uuid3);
                if (c0068b == null) {
                    c0068b = new C0068b(true, q2);
                    this.f3569m.put(uuid3, c0068b);
                }
                c0068b.k(aVar);
                return;
            case 20005:
                UUID uuid4 = (UUID) message.getData().getSerializable("uuid_targetDeviceUUID");
                C0068b c0068b2 = (C0068b) this.f3569m.get(uuid4);
                if (c0068b2 != null) {
                    c0068b2.m(aVar);
                }
                obtain.arg1 = 0;
                j(aVar, obtain);
                Message obtain2 = Message.obtain();
                Bundle bundle = new Bundle();
                obtain2.what = 1;
                obtain2.arg1 = 203;
                bundle.putSerializable("uuid_targetDeviceUUID", uuid4);
                obtain2.arg2 = 202;
                bundle.putInt("int_statusCode", -2);
                obtain2.setData(bundle);
                return;
            default:
                obtain.recycle();
                super.b(uuid, message);
                return;
        }
    }

    @Override // v.e
    public boolean c(e.a aVar, v0.a aVar2, Bundle bundle) {
        this.f3564h.c(aVar.f3454c, aVar.f3455d);
        return super.c(aVar, aVar2, bundle);
    }

    @Override // v.e
    public void d() {
        this.f3566j.t(true);
        super.d();
    }

    @Override // v.e
    public Set f() {
        this.f3564h = new u.a(201);
        HashSet hashSet = new HashSet();
        hashSet.add(this.f3564h);
        return hashSet;
    }
}
