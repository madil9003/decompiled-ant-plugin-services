package a0;

import android.os.Bundle;
import android.os.Message;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.SparseArray;
import b0.c;
import b0.d;
import com.dsi.ant.channel.AntChannel;
import com.dsi.ant.message.ipc.AntMessageParcel;
import com.dsi.ant.plugins.internal.pluginsipc.AntPluginDeviceDbProvider;
import java.nio.channels.ClosedChannelException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.UUID;
import k.l;
import o0.g;
import v.e;
import x.f;

/* loaded from: classes.dex */
public class a extends e {

    /* renamed from: w */
    private static final String f38w = "a";

    /* renamed from: h */
    public final AntChannel f39h;

    /* renamed from: i */
    TreeMap f40i;

    /* renamed from: j */
    SparseArray f41j;

    /* renamed from: k */
    b0.b f42k;

    /* renamed from: l */
    c f43l;

    /* renamed from: m */
    d f44m;

    /* renamed from: n */
    x.c f45n;

    /* renamed from: o */
    x.e f46o;

    /* renamed from: p */
    f f47p;

    /* renamed from: q */
    ArrayList f48q;

    /* renamed from: r */
    int f49r;

    /* renamed from: s */
    int f50s;

    /* renamed from: t */
    boolean f51t;

    /* renamed from: u */
    int f52u;

    /* renamed from: v */
    byte[] f53v;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a0.a$a */
    /* loaded from: classes.dex */
    public class C0002a implements g.d {
        C0002a() {
        }

        @Override // g.d
        public void a(l lVar, AntMessageParcel antMessageParcel) {
            try {
                a.this.a(lVar, antMessageParcel);
            } catch (RemoteException unused) {
                h1.a.b(a.f38w, "RemoteException handling channel messages");
            }
        }

        @Override // g.d
        public void b() {
            a.this.v();
        }
    }

    /* loaded from: classes.dex */
    public static /* synthetic */ class b {

        /* renamed from: a */
        static final /* synthetic */ int[] f55a;

        /* renamed from: b */
        static final /* synthetic */ int[] f56b;

        /* renamed from: c */
        static final /* synthetic */ int[] f57c;

        /* renamed from: d */
        static final /* synthetic */ int[] f58d;

        static {
            int[] iArr = new int[l.values().length];
            f58d = iArr;
            try {
                iArr[l.CHANNEL_EVENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f58d[l.BROADCAST_DATA.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f58d[l.ACKNOWLEDGED_DATA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[j.e.values().length];
            f57c = iArr2;
            try {
                iArr2[j.e.TX.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f57c[j.e.CHANNEL_COLLISION.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr3 = new int[g.values().length];
            f56b = iArr3;
            try {
                iArr3[g.AUDIO_MODE.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f56b[g.VIDEO_MODE.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f56b[g.GENERIC_MODE.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            int[] iArr4 = new int[j.c.values().length];
            f55a = iArr4;
            try {
                iArr4[j.c.TRACKING.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f55a[j.c.SEARCHING.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f55a[j.c.ASSIGNED.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    public a(AntPluginDeviceDbProvider.DeviceDbDeviceInfo deviceDbDeviceInfo, AntChannel antChannel, Bundle bundle, int i2) {
        super(deviceDbDeviceInfo, 1);
        this.f40i = new TreeMap();
        this.f42k = new b0.b();
        this.f43l = new c();
        this.f44m = new d();
        this.f45n = new x.c(null);
        this.f46o = new x.e();
        this.f47p = new f();
        this.f48q = new ArrayList();
        this.f50s = 0;
        this.f51t = false;
        this.f52u = 0;
        this.f53v = new byte[8];
        deviceDbDeviceInfo.f1177e = "Controllable Device";
        if (this.f41j == null) {
            r();
        }
        this.f48q.add(this.f43l);
        this.f39h = antChannel;
        try {
            antChannel.t(new C0002a());
            int i3 = b.f55a[antChannel.p().l().ordinal()];
            if (i3 == 1 || i3 == 2) {
                antChannel.h();
            } else if (i3 != 3) {
                int i4 = bundle.getInt("int_RfFreq");
                int i5 = bundle.getInt("int_TransType");
                int i6 = bundle.getInt("int_DevType");
                int i7 = bundle.getInt("int_Period");
                this.f47p.f3542c = deviceDbDeviceInfo.f1176d.intValue();
                this.f47p.f3540a = (byte) (i2 & 255);
                x.e eVar = this.f46o;
                eVar.f3537b = 15;
                eVar.f3538c = 0;
                eVar.f3536a = 0;
                antChannel.c(j.d.BIDIRECTIONAL_MASTER);
                antChannel.z(i4);
                antChannel.x(i7);
                antChannel.u(new j.b(deviceDbDeviceInfo.f1176d.intValue(), i6, i5));
                antChannel.l();
                k(3);
            }
            antChannel.E();
            int i42 = bundle.getInt("int_RfFreq");
            int i52 = bundle.getInt("int_TransType");
            int i62 = bundle.getInt("int_DevType");
            int i72 = bundle.getInt("int_Period");
            this.f47p.f3542c = deviceDbDeviceInfo.f1176d.intValue();
            this.f47p.f3540a = (byte) (i2 & 255);
            x.e eVar2 = this.f46o;
            eVar2.f3537b = 15;
            eVar2.f3538c = 0;
            eVar2.f3536a = 0;
            antChannel.c(j.d.BIDIRECTIONAL_MASTER);
            antChannel.z(i42);
            antChannel.x(i72);
            antChannel.u(new j.b(deviceDbDeviceInfo.f1176d.intValue(), i62, i52));
            antChannel.l();
            k(3);
        } catch (RemoteException unused) {
            h1.a.b(f38w, "RemoteException during initizalization");
            v();
            throw new ClosedChannelException();
        } catch (g.a e3) {
            h1.a.b(f38w, "ACFE during initizalization: " + e3.toString());
            this.f39h.m();
            throw new ClosedChannelException();
        }
    }

    private List q() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new b0.a());
        arrayList.add(new x.d(true));
        return arrayList;
    }

    private void r() {
        List<w.b> q2 = q();
        this.f41j = new SparseArray(q2.size());
        for (w.b bVar : q2) {
            for (Integer num : bVar.d()) {
                if (this.f41j.indexOfKey(num.intValue()) >= 0) {
                    throw new RuntimeException("Page number collision on page number " + num);
                }
                this.f41j.append(num.intValue(), bVar);
            }
        }
    }

    public static boolean u(g gVar) {
        int i2 = b.f56b[gVar.ordinal()];
        return i2 == 1 || i2 == 2 || i2 == 3;
    }

    public void a(l lVar, AntMessageParcel antMessageParcel) {
        if (h()) {
            return;
        }
        int i2 = b.f58d[lVar.ordinal()];
        if (i2 == 1) {
            int i3 = b.f57c[new k.g(antMessageParcel).j().ordinal()];
            if (i3 == 1 || i3 == 2) {
                if (this.f51t) {
                    this.f45n.a(this.f53v);
                    this.f39h.s(this.f53v);
                    int i4 = this.f52u - 1;
                    this.f52u = i4;
                    if (i4 == 0) {
                        this.f51t = false;
                        return;
                    }
                    return;
                }
                int i5 = this.f50s + 1;
                this.f50s = i5;
                if (i5 == 65) {
                    this.f46o.a(this.f53v);
                    this.f39h.s(this.f53v);
                    return;
                } else if (i5 == 130) {
                    this.f47p.a(this.f53v);
                    this.f39h.s(this.f53v);
                    this.f50s = 0;
                    return;
                } else {
                    ((w.e) this.f48q.get((int) Math.floor((i5 % (this.f48q.size() * 2)) / 2))).a(this.f53v);
                    this.f39h.s(this.f53v);
                    return;
                }
            }
            return;
        }
        if (i2 == 2 || i2 == 3) {
            this.f49r++;
            int i6 = w.c.i(antMessageParcel.a()[1]);
            if (i6 != 70) {
                w.b bVar = (w.b) this.f41j.get(i6);
                if (bVar != null) {
                    bVar.b(SystemClock.elapsedRealtime(), 0L, antMessageParcel);
                    return;
                }
                h1.a.i(f38w, "Unknown page received, page " + i6);
                return;
            }
            int i7 = w.c.i((byte) (antMessageParcel.a()[6] & Byte.MAX_VALUE));
            int i8 = w.c.i(antMessageParcel.a()[7]);
            int i9 = w.c.i(antMessageParcel.a()[8]);
            if (i8 == 71 && i9 == 1) {
                this.f52u = i7;
                if (i7 == 0) {
                    h1.a.a(f38w, "Invalid number of times to transmit page requested. Will send once.");
                    this.f52u = 1;
                }
                this.f51t = true;
                return;
            }
            h1.a.j(f38w, "Unsupported data page request for page " + i8 + " received");
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0014. Please report as an issue. */
    @Override // v.e
    public void b(UUID uuid, Message message) {
        e.a aVar = (e.a) this.f3447b.get(uuid);
        Message obtain = Message.obtain();
        obtain.what = message.what;
        switch (message.what) {
            case 20001:
                try {
                    if (s(g.GENERIC_MODE, uuid)) {
                        x.d.g(this.f45n, message.getData());
                        obtain.arg1 = 0;
                        aVar.f3455d.b(obtain);
                        return;
                    }
                    aVar.f3455d.b(obtain);
                    return;
                } catch (RemoteException unused) {
                    h1.a.b(f38w, "Remote Exception sending cmd response to caller pcc with token " + uuid);
                    return;
                }
                obtain.arg1 = -4;
            case 20002:
                if (s(g.AUDIO_MODE, uuid)) {
                    b0.a.f(this.f45n, message.getData(), false);
                    obtain.arg1 = 0;
                    aVar.f3455d.b(obtain);
                    return;
                }
                obtain.arg1 = -4;
                aVar.f3455d.b(obtain);
                return;
            case 20003:
                if (s(g.VIDEO_MODE, uuid)) {
                    b0.a.f(this.f45n, message.getData(), true);
                    obtain.arg1 = 0;
                    aVar.f3455d.b(obtain);
                    return;
                }
                obtain.arg1 = -4;
                aVar.f3455d.b(obtain);
                return;
            case 20004:
                if (s(g.AUDIO_MODE, uuid)) {
                    this.f42k.f(message.getData());
                    obtain.arg1 = 0;
                    aVar.f3455d.b(obtain);
                    return;
                }
                obtain.arg1 = -4;
                aVar.f3455d.b(obtain);
                return;
            case 20005:
                if (s(g.AUDIO_MODE, uuid)) {
                    this.f42k.g(message.getData());
                    obtain.arg1 = 0;
                    aVar.f3455d.b(obtain);
                    return;
                }
                obtain.arg1 = -4;
                aVar.f3455d.b(obtain);
                return;
            case 20006:
                if (s(g.VIDEO_MODE, uuid)) {
                    this.f44m.f(message.getData());
                    obtain.arg1 = 0;
                    aVar.f3455d.b(obtain);
                    return;
                }
                obtain.arg1 = -4;
                aVar.f3455d.b(obtain);
                return;
            case 20007:
                if (s(g.VIDEO_MODE, uuid)) {
                    this.f44m.g(message.getData());
                    obtain.arg1 = 0;
                    aVar.f3455d.b(obtain);
                    return;
                }
                obtain.arg1 = -4;
                aVar.f3455d.b(obtain);
                return;
            default:
                super.b(uuid, message);
                return;
        }
    }

    @Override // v.e
    public boolean c(e.a aVar, v0.a aVar2, Bundle bundle) {
        if (!super.c(aVar, aVar2, bundle)) {
            return false;
        }
        p(g.c(bundle.getInt("int_RequestAccessMode")), aVar.f3454c, bundle);
        return true;
    }

    @Override // v.e
    public void d() {
        this.f39h.m();
        super.d();
    }

    @Override // v.e
    public Set f() {
        if (this.f41j == null) {
            r();
        }
        HashSet hashSet = new HashSet();
        for (int i2 = 0; i2 < this.f41j.size(); i2++) {
            hashSet.addAll(((w.b) this.f41j.valueAt(i2)).c());
        }
        return hashSet;
    }

    @Override // v.e
    public boolean g(String str, Bundle bundle) {
        g c3 = g.c(bundle.getInt("int_RequestAccessMode"));
        return t(c3) && ((e.a) this.f3447b.get(this.f40i.get(c3))).f3452a.equals(str);
    }

    @Override // v.e
    public void i(e.a aVar, Message message) {
        o(aVar.f3454c);
        super.i(aVar, message);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0066, code lost:            if (r4.f48q.contains(r4.f43l) != false) goto L71;     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0068, code lost:            r5 = r4.f48q;        r5.remove(r5.indexOf(r4.f43l));     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00c4, code lost:            if (r4.f48q.contains(r4.f43l) != false) goto L71;     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00ff, code lost:            if (r4.f48q.contains(r4.f43l) != false) goto L71;     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void o(java.util.UUID r5) {
        /*
            Method dump skipped, instructions count: 275
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: a0.a.o(java.util.UUID):void");
    }

    public void p(g gVar, UUID uuid, Bundle bundle) {
        boolean z2 = bundle.getBoolean("bool_IncludesCaps", false);
        this.f40i.put(gVar, uuid);
        int i2 = b.f56b[gVar.ordinal()];
        if (i2 == 1) {
            if (z2) {
                this.f42k.f(bundle);
            }
            this.f43l.f200a.e(true);
            if (!this.f48q.contains(this.f42k)) {
                this.f48q.add(this.f42k);
            }
            if (!this.f43l.f200a.b() && !this.f43l.f200a.d() && this.f48q.contains(this.f43l)) {
                ArrayList arrayList = this.f48q;
                arrayList.remove(arrayList.indexOf(this.f43l));
            }
            if (!this.f43l.f200a.d() || this.f48q.contains(this.f43l)) {
                return;
            }
        } else if (i2 == 2) {
            if (z2) {
                this.f44m.f(bundle);
            }
            this.f43l.f200a.i(true);
            if (!this.f48q.contains(this.f44m)) {
                this.f48q.add(this.f44m);
            }
            if (!this.f43l.f200a.b() && !this.f43l.f200a.a() && this.f48q.contains(this.f43l)) {
                ArrayList arrayList2 = this.f48q;
                arrayList2.remove(arrayList2.indexOf(this.f43l));
            }
            if (!this.f43l.f200a.a() || this.f48q.contains(this.f43l)) {
                return;
            }
        } else {
            if (i2 != 3) {
                throw new RuntimeException("Need to add support for mode " + gVar);
            }
            this.f43l.f200a.g(true);
            if (this.f48q.contains(this.f43l)) {
                return;
            }
        }
        this.f48q.add(this.f43l);
    }

    public boolean s(g gVar, UUID uuid) {
        String str;
        StringBuilder sb;
        String obj;
        if (!this.f40i.containsKey(gVar)) {
            str = f38w;
            sb = new StringBuilder();
            sb.append(gVar.toString());
            obj = " not enabled";
        } else {
            if (((UUID) this.f40i.get(gVar)).compareTo(uuid) == 0) {
                return true;
            }
            str = f38w;
            sb = new StringBuilder();
            sb.append("Client not authorized for ");
            obj = gVar.toString();
        }
        sb.append(obj);
        h1.a.b(str, sb.toString());
        return false;
    }

    public boolean t(g gVar) {
        return this.f40i.containsKey(gVar);
    }

    public void v() {
        k(-100);
    }
}
