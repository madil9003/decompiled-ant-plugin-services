package i0;

import android.os.Bundle;
import android.os.Message;
import android.os.RemoteException;
import com.dsi.ant.channel.AntChannel;
import com.dsi.ant.plugins.antplus.geocache.GeocacheService;
import com.dsi.ant.plugins.antplus.pcc.AntPlusGeocachePcc;
import com.dsi.ant.plugins.internal.pluginsipc.AntPluginDeviceDbProvider;
import j.c;
import j.d;
import j.i;
import java.math.BigDecimal;
import java.nio.channels.ClosedChannelException;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import u0.a;
import v.e;

/* loaded from: classes.dex */
public class a extends e {

    /* renamed from: o */
    private static final String f1849o = "a";

    /* renamed from: p */
    public static final BigDecimal f1850p = new BigDecimal(180).divide(new BigDecimal(2147483648L));

    /* renamed from: q */
    public static final i f1851q = i.TEN_SECONDS;

    /* renamed from: h */
    public final int f1852h;

    /* renamed from: i */
    public final int f1853i;

    /* renamed from: j */
    public final int f1854j;

    /* renamed from: k */
    public final int f1855k;

    /* renamed from: l */
    private u.a f1856l;

    /* renamed from: m */
    public u0.a f1857m;

    /* renamed from: n */
    public j0.b f1858n;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: i0.a$a */
    /* loaded from: classes.dex */
    public class C0039a implements a.c {
        C0039a() {
        }

        @Override // u0.a.c
        public void a() {
            a.this.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class b {

        /* renamed from: a */
        static final /* synthetic */ int[] f1860a;

        static {
            int[] iArr = new int[c.values().length];
            f1860a = iArr;
            try {
                iArr[c.TRACKING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1860a[c.SEARCHING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1860a[c.ASSIGNED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public a(AntChannel antChannel, GeocacheService geocacheService) {
        super(null, 1);
        this.f1852h = 19;
        this.f1853i = 0;
        this.f1854j = 8192;
        this.f1855k = 57;
        AntPluginDeviceDbProvider.DeviceDbDeviceInfo deviceDbDeviceInfo = new AntPluginDeviceDbProvider.DeviceDbDeviceInfo();
        this.f3451f = deviceDbDeviceInfo;
        deviceDbDeviceInfo.f1176d = -1;
        this.f3451f.f1177e = "GeocacheScanner";
        this.f1858n = new j0.b(this.f1856l);
        try {
            this.f1857m = new u0.a(antChannel, new C0039a());
            int i2 = b.f1860a[antChannel.p().l().ordinal()];
            if (i2 == 1 || i2 == 2) {
                throw new IllegalStateException("Channel passed to GeocacheReceiver constructor was open, it must be closed first");
            }
            if (i2 == 3) {
                antChannel.E();
            }
            antChannel.c(d.BIDIRECTIONAL_SLAVE);
            antChannel.z(57);
            antChannel.x(8192);
            antChannel.A(f1851q);
            this.f1857m.s(new k0.e(this));
        } catch (RemoteException unused) {
            h1.a.b(f1849o, "RemoteException during initizalization");
            d();
            throw new ClosedChannelException();
        } catch (g.a e3) {
            h1.a.b(f1849o, "ACFE during initialization: " + e3.toString());
            antChannel.m();
            throw new ClosedChannelException();
        }
    }

    @Override // v.e
    public void b(UUID uuid, Message message) {
        e.a aVar = (e.a) this.f3447b.get(uuid);
        Message obtain = Message.obtain();
        obtain.what = message.what;
        message.getData().setClassLoader(getClass().getClassLoader());
        switch (message.what) {
            case 20002:
                obtain.arg1 = 0;
                j(aVar, obtain);
                this.f1858n.g(aVar);
                return;
            case 20003:
                Bundle data = message.getData();
                k0.b bVar = new k0.b(this, aVar, data.getInt("int_TARGETDEVICEID"), data.getBoolean("bool_updateVisitCount"), data.getBoolean("bool_subscribeProgressUpdates"));
                obtain.arg1 = 0;
                j(aVar, obtain);
                bVar.C();
                return;
            case 20004:
                Bundle data2 = message.getData();
                k0.d dVar = new k0.d(this, aVar, data2.getInt("int_TARGETDEVICEID"), data2.getInt("int_nonce"), data2.getLong("long_serialNumber"), data2.getBoolean("bool_subscribeProgressUpdates"));
                obtain.arg1 = 0;
                j(aVar, obtain);
                dVar.B();
                return;
            case 20005:
                Bundle data3 = message.getData();
                k0.c cVar = new k0.c(this, aVar, data3.getInt("int_TARGETDEVICEID"), data3.getLong("long_ProgrammingPIN"), data3.getBoolean("bool_clearAllExistingData"), aVar.f3456e == 0 ? g1.a.a(data3.getBundle("bundle_programmingData")) : (AntPlusGeocachePcc.ProgrammableGeocacheDeviceData) data3.getParcelable("parcelable_ProgrammableGeocacheDeviceData"), data3.getBoolean("bool_subscribeProgressUpdates"));
                obtain.arg1 = 0;
                j(aVar, obtain);
                cVar.B();
                return;
            default:
                obtain.recycle();
                super.b(uuid, message);
                return;
        }
    }

    @Override // v.e
    public boolean c(e.a aVar, v0.a aVar2, Bundle bundle) {
        this.f1856l.c(aVar.f3454c, aVar.f3455d);
        return super.c(aVar, aVar2, bundle);
    }

    @Override // v.e
    public void d() {
        this.f1857m.t(true);
        super.d();
    }

    @Override // v.e
    public Set f() {
        this.f1856l = new u.a(201);
        HashSet hashSet = new HashSet();
        hashSet.add(this.f1856l);
        return hashSet;
    }
}
