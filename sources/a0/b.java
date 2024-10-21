package a0;

import android.os.Bundle;
import android.os.Message;
import android.os.RemoteException;
import com.dsi.ant.channel.AntChannel;
import com.dsi.ant.plugins.antplus.controls.RemoteControlService;
import com.dsi.ant.plugins.internal.pluginsipc.AntPluginDeviceDbProvider;
import java.nio.channels.ClosedChannelException;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;
import o0.g;
import o0.h;
import v.c;
import v.e;
import v.f;
import x.d;

/* loaded from: classes.dex */
public class b extends c {
    private static final String E = "b";
    private b0.a A;
    private b0.a B;
    private d C;
    byte[] D;

    /* renamed from: w */
    private final EnumSet f59w;

    /* renamed from: x */
    TreeMap f60x;

    /* renamed from: y */
    public u0.a f61y;

    /* renamed from: z */
    private byte f62z;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a */
        static final /* synthetic */ int[] f63a;

        static {
            int[] iArr = new int[g.values().length];
            f63a = iArr;
            try {
                iArr[g.AUDIO_MODE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f63a[g.VIDEO_MODE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f63a[g.GENERIC_MODE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public b(AntPluginDeviceDbProvider.DeviceDbDeviceInfo deviceDbDeviceInfo, int i2, AntChannel antChannel, EnumSet enumSet) {
        super(deviceDbDeviceInfo, antChannel);
        this.f60x = new TreeMap();
        this.D = new byte[8];
        this.f59w = enumSet;
        this.f62z = (byte) 0;
        b0.a aVar = new b0.a();
        this.A = aVar;
        aVar.f184a = i2;
        b0.a aVar2 = new b0.a();
        this.B = aVar2;
        aVar2.f184a = i2;
        d dVar = new d(true);
        this.C = dVar;
        dVar.f3531c = i2;
        try {
            this.f61y = f.C(this);
        } catch (RemoteException unused) {
            h1.a.b(E, "Remote Exception during initizalization");
            s();
            throw new ClosedChannelException();
        }
    }

    public boolean B(EnumSet enumSet) {
        if (!this.f59w.containsAll(enumSet)) {
            return false;
        }
        Iterator it = enumSet.iterator();
        while (it.hasNext()) {
            if (this.f60x.containsKey((g) it.next())) {
                return false;
            }
        }
        return true;
    }

    public void C(UUID uuid) {
        if (this.f60x.containsValue(uuid)) {
            Iterator it = this.f60x.entrySet().iterator();
            while (it.hasNext()) {
                if (((UUID) ((Map.Entry) it.next()).getValue()).equals(uuid)) {
                    it.remove();
                }
            }
        }
    }

    public void D(v0.a aVar, Message message) {
        try {
            aVar.b(message);
        } catch (RemoteException unused) {
            h1.a.b(E, "RemoteException dumbfiring reply to client. Reply code was: " + message.what);
        }
    }

    public boolean E(g gVar, UUID uuid) {
        String str;
        StringBuilder sb;
        String str2;
        if (this.f60x.containsKey(gVar)) {
            return false;
        }
        this.f60x.put(gVar, uuid);
        int i2 = a.f63a[gVar.ordinal()];
        if (i2 == 1) {
            this.A.f188e = false;
            str = E;
            sb = new StringBuilder();
            str2 = "Audio mode enabled with token ";
        } else {
            if (i2 != 2) {
                if (i2 == 3) {
                    str = E;
                    sb = new StringBuilder();
                    str2 = "Generic mode enabled with token ";
                }
                return true;
            }
            this.B.f188e = true;
            str = E;
            sb = new StringBuilder();
            str2 = "Video mode enabled with token ";
        }
        sb.append(str2);
        sb.append(uuid);
        h1.a.a(str, sb.toString());
        return true;
    }

    public boolean F(g gVar, UUID uuid) {
        String str;
        StringBuilder sb;
        String str2;
        if (!this.f60x.containsKey(gVar)) {
            str = E;
            sb = new StringBuilder();
            sb.append(gVar.toString());
            str2 = "Mode not enabled";
        } else {
            if (((UUID) this.f60x.get(gVar)).compareTo(uuid) == 0) {
                return true;
            }
            str = E;
            sb = new StringBuilder();
            sb.append("Client not authorized for");
            sb.append(gVar.toString());
            str2 = "mode";
        }
        sb.append(str2);
        h1.a.b(str, sb.toString());
        return false;
    }

    @Override // v.d, v.e
    public void b(UUID uuid, Message message) {
        e.a aVar = (e.a) this.f3447b.get(uuid);
        Message obtain = Message.obtain();
        obtain.what = message.what;
        int i2 = message.what;
        boolean z2 = false;
        if (i2 == 10002) {
            C(uuid);
            i(aVar, message);
            obtain.arg1 = 0;
        } else if (i2 == 20001) {
            if (F(g.GENERIC_MODE, uuid)) {
                h e3 = h.e(message.getData().getInt("int_commandNumber"));
                c0.a aVar2 = new c0.a(this, aVar, new u.a(208));
                obtain.arg1 = 0;
                j(aVar, obtain);
                d dVar = this.C;
                dVar.f3533e = e3;
                dVar.f3532d = this.f62z;
                dVar.a(this.D);
                aVar2.B(this.D);
                this.f62z = (byte) (this.f62z + 1);
            }
            z2 = true;
        } else if (i2 == 20003) {
            if (F(g.AUDIO_MODE, uuid)) {
                Bundle data = message.getData();
                o0.e c3 = o0.e.c(data.getInt("int_commandNumber"));
                int i3 = data.getInt("int_commandData");
                c0.a aVar3 = new c0.a(this, aVar, new u.a(206));
                obtain.arg1 = 0;
                j(aVar, obtain);
                b0.a aVar4 = this.A;
                aVar4.f186c = i3;
                aVar4.f187d = c3;
                aVar4.f185b = this.f62z;
                aVar4.a(this.D);
                aVar3.B(this.D);
                this.f62z = (byte) (this.f62z + 1);
            }
            z2 = true;
        } else if (i2 != 20004) {
            obtain.recycle();
            super.b(uuid, message);
            obtain = null;
        } else {
            if (F(g.VIDEO_MODE, uuid)) {
                Bundle data2 = message.getData();
                o0.e c4 = o0.e.c(data2.getInt("int_commandNumber"));
                int i4 = data2.getInt("int_commandData");
                c0.a aVar5 = new c0.a(this, aVar, new u.a(207));
                obtain.arg1 = 0;
                j(aVar, obtain);
                b0.a aVar6 = this.B;
                aVar6.f186c = i4;
                aVar6.f187d = c4;
                aVar6.f185b = this.f62z;
                aVar6.a(this.D);
                aVar5.B(this.D);
                this.f62z = (byte) (this.f62z + 1);
            }
            z2 = true;
        }
        if (z2) {
            try {
                obtain.arg1 = -4;
                aVar.f3455d.b(obtain);
            } catch (RemoteException unused) {
                h1.a.b(E, "Remote Exception sending cmd response to caller pcc with token " + uuid);
            }
        }
    }

    @Override // v.e
    public boolean c(e.a aVar, v0.a aVar2, Bundle bundle) {
        if (!super.c(aVar, aVar2, bundle)) {
            return false;
        }
        if (!bundle.containsKey("long_PccMode")) {
            Iterator it = RemoteControlService.J(bundle).iterator();
            while (it.hasNext()) {
                if (!E((g) it.next(), aVar.f3454c)) {
                    C(aVar.f3454c);
                }
            }
            return true;
        }
        if (E(g.b(bundle.getLong("long_PccMode")), aVar.f3454c)) {
            return true;
        }
        Message obtain = Message.obtain();
        obtain.what = -6;
        D(aVar2, obtain);
        return false;
    }

    @Override // v.a, v.e
    public void d() {
        this.f61y.t(true);
        super.d();
    }

    @Override // v.e
    public boolean g(String str, Bundle bundle) {
        EnumSet J = RemoteControlService.J(bundle);
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f3446a.iterator();
        while (it.hasNext()) {
            e.a aVar = (e.a) it.next();
            if (aVar.f3452a.equals(str)) {
                arrayList.add(aVar);
            }
        }
        Iterator it2 = J.iterator();
        while (it2.hasNext()) {
            g gVar = (g) it2.next();
            if (this.f60x.containsKey(gVar)) {
                Iterator it3 = arrayList.iterator();
                while (it3.hasNext()) {
                    if (((e.a) it3.next()).f3454c.equals(this.f60x.get(gVar))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // v.c
    public List w() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new b0.b());
        arrayList.add(new b0.c());
        arrayList.add(new b0.d());
        arrayList.addAll(v());
        return arrayList;
    }
}
