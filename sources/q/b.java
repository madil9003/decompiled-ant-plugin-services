package q;

import android.os.Bundle;
import android.os.Message;
import com.dsi.ant.channel.AntChannel;
import com.dsi.ant.message.ipc.AntMessageParcel;
import com.dsi.ant.plugins.antplus.bikespdcad.CombinedBikeSpdCadService;
import com.dsi.ant.plugins.internal.pluginsipc.AntPluginDeviceDbProvider;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import v.e;

/* loaded from: classes.dex */
public class b extends v.c {

    /* renamed from: w */
    private d f2994w;

    /* renamed from: x */
    private HashMap f2995x;

    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a */
        static final /* synthetic */ int[] f2996a;

        static {
            int[] iArr = new int[EnumC0048b.values().length];
            f2996a = iArr;
            try {
                iArr[EnumC0048b.CADENCE_ONLY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2996a[EnumC0048b.SPEED_ONLY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2996a[EnumC0048b.BOTH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* renamed from: q.b$b */
    /* loaded from: classes.dex */
    public enum EnumC0048b {
        CADENCE_ONLY,
        SPEED_ONLY,
        BOTH
    }

    public b(AntPluginDeviceDbProvider.DeviceDbDeviceInfo deviceDbDeviceInfo, AntChannel antChannel) {
        super(deviceDbDeviceInfo, antChannel);
        this.f2995x = new HashMap();
    }

    @Override // v.e
    public boolean c(e.a aVar, v0.a aVar2, Bundle bundle) {
        boolean c3;
        boolean K = CombinedBikeSpdCadService.K(bundle);
        synchronized (this.f2995x) {
            EnumC0048b enumC0048b = K ? EnumC0048b.CADENCE_ONLY : EnumC0048b.SPEED_ONLY;
            if (this.f2995x.containsKey(aVar.f3454c)) {
                this.f2995x.put(aVar.f3454c, EnumC0048b.BOTH);
                c3 = true;
            } else {
                this.f2995x.put(aVar.f3454c, enumC0048b);
                c3 = super.c(aVar, aVar2, bundle);
            }
        }
        return c3;
    }

    @Override // v.e
    public boolean g(String str, Bundle bundle) {
        e.a aVar;
        synchronized (this.f3446a) {
            Iterator it = this.f3446a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    aVar = null;
                    break;
                }
                aVar = (e.a) it.next();
                if (aVar.f3452a.equals(str)) {
                    break;
                }
            }
        }
        if (aVar == null) {
            return false;
        }
        EnumC0048b enumC0048b = (EnumC0048b) this.f2995x.get(aVar.f3454c);
        if (enumC0048b == EnumC0048b.BOTH) {
            return true;
        }
        if (CombinedBikeSpdCadService.K(bundle) && enumC0048b == EnumC0048b.CADENCE_ONLY) {
            return true;
        }
        return !CombinedBikeSpdCadService.K(bundle) && enumC0048b == EnumC0048b.SPEED_ONLY;
    }

    @Override // v.e
    public void i(e.a aVar, Message message) {
        boolean K = CombinedBikeSpdCadService.K(message.getData());
        EnumC0048b enumC0048b = K ? EnumC0048b.CADENCE_ONLY : EnumC0048b.SPEED_ONLY;
        synchronized (this.f2995x) {
            EnumC0048b enumC0048b2 = (EnumC0048b) this.f2995x.get(aVar.f3454c);
            if (enumC0048b2 != null) {
                if (enumC0048b == enumC0048b2) {
                    super.i(aVar, message);
                    synchronized (this.f2995x) {
                        this.f2995x.remove(aVar.f3454c);
                    }
                } else if (enumC0048b2 == EnumC0048b.BOTH) {
                    this.f2995x.put(aVar.f3454c, K ? EnumC0048b.SPEED_ONLY : EnumC0048b.CADENCE_ONLY);
                    Iterator it = (enumC0048b == EnumC0048b.CADENCE_ONLY ? this.f2994w.f() : enumC0048b == EnumC0048b.SPEED_ONLY ? this.f2994w.g() : null).iterator();
                    while (it.hasNext()) {
                        ((u.a) it.next()).d(aVar.f3454c);
                    }
                }
            }
        }
    }

    @Override // v.e
    public boolean l(int i2, e.a aVar, Message message) {
        int i3 = a.f2996a[((EnumC0048b) this.f2995x.get(aVar.f3454c)).ordinal()];
        if (i3 == 1) {
            Iterator it = this.f2994w.g().iterator();
            while (it.hasNext()) {
                if (i2 == ((u.a) it.next()).f3372a.intValue()) {
                    return false;
                }
            }
        } else if (i3 == 2) {
            Iterator it2 = this.f2994w.f().iterator();
            while (it2.hasNext()) {
                if (i2 == ((u.a) it2.next()).f3372a.intValue()) {
                    return false;
                }
            }
        }
        return super.l(i2, aVar, message);
    }

    @Override // v.c
    public List w() {
        d dVar = new d();
        this.f2994w = dVar;
        return Arrays.asList(dVar);
    }

    @Override // v.c
    public void x(AntMessageParcel antMessageParcel) {
        this.f2994w.b(p(), q(), antMessageParcel);
    }
}
