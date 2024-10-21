package v;

import android.os.Bundle;
import android.os.RemoteException;
import android.util.SparseArray;
import com.dsi.ant.channel.AntChannel;
import com.dsi.ant.message.ipc.AntMessageParcel;
import com.dsi.ant.plugins.internal.pluginsipc.AntPluginDeviceDbProvider;
import j.i;
import j.l;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import k.k;
import k.l;

/* loaded from: classes.dex */
public abstract class c extends d {

    /* renamed from: t */
    private static final String f3431t = "c";

    /* renamed from: u */
    private static final i f3432u;

    /* renamed from: v */
    private static final int f3433v;

    /* renamed from: p */
    SparseArray f3434p;

    /* renamed from: q */
    private g f3435q;

    /* renamed from: r */
    x.h f3436r;

    /* renamed from: s */
    private int f3437s;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a */
        static final /* synthetic */ int[] f3438a;

        /* renamed from: b */
        static final /* synthetic */ int[] f3439b;

        /* renamed from: c */
        static final /* synthetic */ int[] f3440c;

        static {
            int[] iArr = new int[j.c.values().length];
            f3440c = iArr;
            try {
                iArr[j.c.TRACKING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3440c[j.c.SEARCHING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3440c[j.c.ASSIGNED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3440c[j.c.UNASSIGNED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[l.values().length];
            f3439b = iArr2;
            try {
                iArr2[l.ACKNOWLEDGED_DATA.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3439b[l.BROADCAST_DATA.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3439b[l.CHANNEL_EVENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr3 = new int[j.e.values().length];
            f3438a = iArr3;
            try {
                iArr3[j.e.RX_SEARCH_TIMEOUT.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f3438a[j.e.CHANNEL_CLOSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f3438a[j.e.RX_FAIL_GO_TO_SEARCH.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    static {
        i iVar = i.TWENTY_FIVE_SECONDS;
        f3432u = iVar;
        f3433v = 1800000 / iVar.b();
    }

    public c(AntPluginDeviceDbProvider.DeviceDbDeviceInfo deviceDbDeviceInfo, AntChannel antChannel) {
        super(deviceDbDeviceInfo, antChannel);
        this.f3437s = 0;
        if (this.f3434p == null) {
            z();
        }
        try {
            if (antChannel.k().k()) {
                this.f3435q.e();
            }
        } catch (RemoteException unused) {
        }
    }

    private void y(AntMessageParcel antMessageParcel) {
        this.f3436r.b(p(), q(), antMessageParcel);
    }

    private void z() {
        List<w.b> w2 = w();
        this.f3434p = new SparseArray(w2.size());
        for (w.b bVar : w2) {
            for (Integer num : bVar.d()) {
                if (this.f3434p.indexOfKey(num.intValue()) >= 0) {
                    throw new RuntimeException("Page number collision on page number " + num);
                }
                this.f3434p.append(num.intValue(), bVar);
            }
        }
    }

    public boolean A() {
        try {
            this.f3424h.l();
            k(2);
            return true;
        } catch (RemoteException unused) {
            h1.a.b(f3431t, "RemoteException trying to reopen channel");
            s();
            return false;
        } catch (g.a e3) {
            h1.a.b(f3431t, "ACFE reopening channel: " + e3.toString());
            this.f3424h.m();
            return false;
        }
    }

    @Override // v.a, z.a.b
    public void a(l lVar, AntMessageParcel antMessageParcel) {
        int i2 = a.f3439b[lVar.ordinal()];
        if (i2 == 1 || i2 == 2) {
            this.f3437s = 0;
            if (e() != 3) {
                k(3);
            }
            if (this.f3435q.b()) {
                k kVar = (k) k.b.e(antMessageParcel);
                if (kVar.l() && kVar.j().d() && kVar.j().a().a() == l.a.DBM) {
                    j.l a3 = kVar.j().a();
                    Bundle bundle = new Bundle();
                    bundle.putInt("int_rssi", a3.c());
                    bundle.putLong("long_EventFlags", q());
                    bundle.putLong("long_EstTimestamp", p());
                    this.f3435q.a(bundle);
                }
            }
            y(antMessageParcel);
            x(antMessageParcel);
            return;
        }
        if (i2 != 3) {
            return;
        }
        int i3 = a.f3438a[new k.g(antMessageParcel).j().ordinal()];
        if (i3 == 1) {
            h1.a.a(f3431t, "Channel search timeout");
            return;
        }
        if (i3 != 2) {
            if (i3 != 3) {
                return;
            }
            for (int i4 = 0; i4 < this.f3434p.size(); i4++) {
                ((w.b) this.f3434p.valueAt(i4)).e();
            }
            k(2);
            return;
        }
        String str = f3431t;
        h1.a.a(str, "Channel closed, attempting reopen...");
        int i5 = this.f3437s + 1;
        this.f3437s = i5;
        if (i5 <= f3433v) {
            A();
        } else {
            h1.a.j(str, "Device reached max search retry threshold, closing to prevent battery and resource drain");
            d();
        }
    }

    @Override // v.e
    public Set f() {
        if (this.f3434p == null) {
            z();
        }
        HashSet hashSet = new HashSet();
        for (int i2 = 0; i2 < this.f3434p.size(); i2++) {
            hashSet.addAll(((w.b) this.f3434p.valueAt(i2)).c());
        }
        g gVar = new g();
        this.f3435q = gVar;
        hashSet.add(gVar);
        x.h hVar = new x.h();
        this.f3436r = hVar;
        hashSet.addAll(hVar.c());
        return hashSet;
    }

    @Override // v.d, v.a
    public void o(boolean z2) {
        super.o(z2);
        try {
            this.f3424h.A(f3432u);
            int i2 = a.f3440c[this.f3424h.p().l().ordinal()];
            if (i2 == 1) {
                k(3);
                return;
            }
            if (i2 == 2) {
                k(2);
                return;
            }
            if (i2 == 3) {
                k(1);
                A();
            } else {
                if (i2 != 4) {
                    return;
                }
                h1.a.b(f3431t, "Can't recover from channel in unassigned state.");
                this.f3424h.m();
                throw new RemoteException();
            }
        } catch (g.a e3) {
            h1.a.b(f3431t, "ACFE in checkChannelState: " + e3.toString());
            this.f3424h.m();
            throw new RemoteException();
        }
    }

    public List v() {
        return Arrays.asList(new x.b(), new x.e(), new x.f(), new x.g());
    }

    public abstract List w();

    public void x(AntMessageParcel antMessageParcel) {
        int i2 = w.c.i(antMessageParcel.a()[1]);
        w.b bVar = (w.b) this.f3434p.get(i2);
        if (bVar != null) {
            bVar.b(p(), q(), antMessageParcel);
            return;
        }
        h1.a.i(f3431t, "Unknown page received, page " + i2);
    }
}
