package t;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.os.RemoteException;
import com.dsi.ant.channel.AntChannel;
import com.dsi.ant.message.ipc.AntMessageParcel;
import com.dsi.ant.plugins.antplus.common.FitFileCommon;
import com.dsi.ant.plugins.internal.pluginsipc.AntPluginDeviceDbProvider;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import s0.a;
import s0.j;
import s0.o;
import t.b;
import t.d;
import v.e;

/* loaded from: classes.dex */
public class a extends v.c {
    private static final String A = "a";

    /* renamed from: w */
    private Context f3285w;

    /* renamed from: x */
    private int f3286x;

    /* renamed from: y */
    b f3287y;

    /* renamed from: z */
    c f3288z;

    /* renamed from: t.a$a */
    /* loaded from: classes.dex */
    private class C0053a extends o.d {

        /* renamed from: d */
        private e.a f3289d;

        public C0053a(boolean z2, e.a aVar) {
            super(203, z2);
            this.f3289d = aVar;
        }

        @Override // s0.o.c
        public boolean h(a.b bVar) {
            return bVar.f3085b == FitFileCommon.a.FIT_DATA_TYPE.b() && bVar.f3088e.contains(a.c.READ);
        }

        @Override // s0.o.d
        protected void j(Message message) {
            a.this.j(this.f3289d, message);
        }
    }

    public a(AntPluginDeviceDbProvider.DeviceDbDeviceInfo deviceDbDeviceInfo, AntChannel antChannel, Context context) {
        super(deviceDbDeviceInfo, antChannel);
        this.f3286x = -1;
        this.f3285w = context;
        this.f3288z = new c(this.f3285w, deviceDbDeviceInfo.f1176d.intValue());
        this.f3287y = new b(this.f3444n, this.f3288z, j1.a.a(this.f3285w), deviceDbDeviceInfo.f1176d.intValue(), 57, 8192, 30);
    }

    @Override // v.d, v.e
    public void b(UUID uuid, Message message) {
        e.a aVar = (e.a) this.f3447b.get(uuid);
        Message obtain = Message.obtain();
        obtain.what = message.what;
        switch (message.what) {
            case 20001:
                Bundle data = message.getData();
                obtain.arg1 = 0;
                j(aVar, obtain);
                o.g(this.f3444n, this.f3288z, new C0053a(data.getBoolean("bool_UseAntFsProgressUpdates"), aVar), j1.a.a(this.f3285w), this.f3451f.f1176d.intValue(), 57, 8192, 30);
                return;
            case 20002:
                obtain.arg1 = 0;
                obtain.arg2 = this.f3286x;
                break;
            case 20003:
                obtain.arg1 = 0;
                j(aVar, obtain);
                Bundle data2 = message.getData();
                this.f3287y.b(new b.C0054b(aVar, data2.getBoolean("bool_downloadNewOnly"), data2.getBoolean("bool_monitorForNewMeasurements"), data2.getBoolean("bool_UseAntFsProgressUpdates"), this));
                return;
            case 20004:
                this.f3287y.e(aVar);
                obtain.arg1 = 0;
                break;
            case 20005:
                obtain.arg1 = 0;
                j(aVar, obtain);
                Bundle data3 = message.getData();
                new d(new d.c(aVar, data3.getBoolean("bool_doSetTime"), data3.getBoolean("bool_UseAntFsProgressUpdates"), this), this.f3444n, this.f3288z, j1.a.a(this.f3285w), this.f3451f.f1176d.intValue(), 57, 8192, 30).c();
                return;
            default:
                obtain.recycle();
                super.b(uuid, message);
                return;
        }
        j(aVar, obtain);
    }

    @Override // v.a, v.e
    public void d() {
        this.f3287y.c();
        this.f3444n.t(true);
        super.d();
    }

    @Override // v.c, v.d, v.a
    public void o(boolean z2) {
        super.o(z2);
        try {
            this.f3424h.x(4096);
            this.f3424h.z(57);
        } catch (g.a e3) {
            h1.a.b(A, "ACFE in bpm checkChannelState: " + e3.toString());
            this.f3424h.m();
            throw new RemoteException();
        }
    }

    @Override // v.c
    public List w() {
        return new ArrayList();
    }

    @Override // v.c
    public void x(AntMessageParcel antMessageParcel) {
        if (w.c.i(antMessageParcel.a()[1]) != 67) {
            super.x(antMessageParcel);
        } else if (w.c.i(antMessageParcel.a()[3]) == 0) {
            this.f3286x = j.b(antMessageParcel.a());
        }
    }
}
