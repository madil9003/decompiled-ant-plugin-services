package z0;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import b1.b;
import b1.d;
import com.dsi.ant.channel.AntChannel;
import com.dsi.ant.message.ipc.AntMessageParcel;
import com.dsi.ant.plugins.antplus.common.FitFileCommon;
import com.dsi.ant.plugins.antplus.pcc.AntPlusWeightScalePcc;
import com.dsi.ant.plugins.internal.pluginsipc.AntPluginDeviceDbProvider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import s0.a;
import s0.i;
import s0.j;
import s0.k;
import s0.o;
import v.c;
import v.e;

/* loaded from: classes.dex */
public class a extends c {

    /* renamed from: w */
    public a1.a f3616w;

    /* renamed from: x */
    private Context f3617x;

    /* renamed from: y */
    int f3618y;

    /* renamed from: z */
    u.a f3619z;

    /* renamed from: z0.a$a */
    /* loaded from: classes.dex */
    private class C0071a extends o.d {

        /* renamed from: d */
        private e.a f3620d;

        public C0071a(boolean z2, e.a aVar) {
            super(204, z2);
            this.f3620d = aVar;
        }

        @Override // s0.o.c
        public i b() {
            return new d(a.this, a());
        }

        @Override // s0.o.c
        public boolean h(a.b bVar) {
            return bVar.f3085b == FitFileCommon.a.FIT_DATA_TYPE.b() && bVar.f3088e.contains(a.c.READ);
        }

        @Override // s0.o.d
        protected void j(Message message) {
            a.this.j(this.f3620d, message);
        }
    }

    public a(AntPluginDeviceDbProvider.DeviceDbDeviceInfo deviceDbDeviceInfo, AntChannel antChannel, Context context) {
        super(deviceDbDeviceInfo, antChannel);
        this.f3618y = 0;
        this.f3617x = context;
    }

    @Override // v.d, v.e
    public void b(UUID uuid, Message message) {
        e.a aVar = (e.a) this.f3447b.get(uuid);
        Message obtain = Message.obtain();
        obtain.what = message.what;
        switch (message.what) {
            case 20001:
                b bVar = new b(this, aVar);
                obtain.arg1 = 0;
                j(aVar, obtain);
                bVar.B();
                return;
            case 20002:
                Bundle data = message.getData();
                data.setClassLoader(getClass().getClassLoader());
                b1.a aVar2 = new b1.a(this, aVar, (AntPlusWeightScalePcc.UserProfile) data.getParcelable("parcelable_UserProfile"));
                obtain.arg1 = 0;
                j(aVar, obtain);
                aVar2.B();
                return;
            case 20003:
                b1.c cVar = new b1.c(this, aVar);
                obtain.arg1 = 0;
                j(aVar, obtain);
                cVar.B();
                return;
            case 20004:
                obtain.arg1 = 0;
                j(aVar, obtain);
                o.g(this.f3444n, new k(this.f3617x), new C0071a(message.getData().getBoolean("bool_UseAntFsProgressUpdates"), aVar), j1.a.a(this.f3617x), this.f3451f.f1176d.intValue(), 57, 8192, 0);
                return;
            default:
                obtain.recycle();
                super.b(uuid, message);
                return;
        }
    }

    @Override // v.a, v.e
    public void d() {
        this.f3444n.t(true);
        super.d();
    }

    @Override // v.c, v.e
    public Set f() {
        Set f3 = super.f();
        Iterator it = f3.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            u.a aVar = (u.a) it.next();
            if (aVar.f3372a.intValue() == 100) {
                this.f3619z = aVar;
                break;
            }
        }
        return f3;
    }

    @Override // v.c
    public List w() {
        this.f3616w = new a1.a();
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f3616w);
        arrayList.addAll(v());
        return arrayList;
    }

    @Override // v.c
    public void x(AntMessageParcel antMessageParcel) {
        int b3;
        w.c.i(antMessageParcel.a()[1]);
        if (w.c.i(antMessageParcel.a()[1]) != 67) {
            super.x(antMessageParcel);
            return;
        }
        if (w.c.i(antMessageParcel.a()[3]) == 0) {
            if (this.f3618y % 64 == 0 && this.f3619z.b() && (b3 = j.b(antMessageParcel.a())) == 21) {
                Bundle bundle = new Bundle();
                bundle.putLong("long_EstTimestamp", p());
                bundle.putLong("long_EventFlags", q());
                bundle.putInt("int_hardwareRevision", -1);
                bundle.putInt("int_manufacturerID", b3);
                bundle.putInt("int_modelNumber", -1);
                this.f3619z.a(bundle);
            }
            this.f3618y++;
        }
    }
}
