package v;

import com.dsi.ant.channel.AntChannel;
import com.dsi.ant.message.ipc.AntMessageParcel;
import com.dsi.ant.plugins.internal.pluginsipc.AntPluginDeviceDbProvider;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class b extends c {

    /* renamed from: w */
    private boolean f3428w;

    /* renamed from: x */
    private Boolean f3429x;

    /* renamed from: y */
    private w.b f3430y;

    public b(AntPluginDeviceDbProvider.DeviceDbDeviceInfo deviceDbDeviceInfo, AntChannel antChannel) {
        super(deviceDbDeviceInfo, antChannel);
        this.f3428w = false;
        this.f3429x = null;
    }

    public abstract void B(List list, w.b bVar);

    public abstract w.b C();

    @Override // v.c, v.e
    public Set f() {
        Set f3 = super.f();
        f3.addAll(this.f3430y.c());
        return f3;
    }

    @Override // v.c
    public List w() {
        ArrayList arrayList = new ArrayList();
        w.b C = C();
        this.f3430y = C;
        arrayList.add(C);
        arrayList.add(new y.a());
        arrayList.add(new y.b());
        arrayList.add(new y.c());
        B(arrayList, this.f3430y);
        return arrayList;
    }

    @Override // v.c
    public void x(AntMessageParcel antMessageParcel) {
        if (!this.f3428w) {
            boolean z2 = (antMessageParcel.a()[1] & 128) > 0;
            Boolean bool = this.f3429x;
            if (bool == null) {
                this.f3429x = Boolean.valueOf(z2);
            } else if (z2 != bool.booleanValue()) {
                this.f3428w = true;
            }
        }
        if (this.f3428w) {
            antMessageParcel.a()[1] = (byte) (antMessageParcel.a()[1] & (-129));
            if (!this.f3430y.d().contains(Integer.valueOf(w.c.i(antMessageParcel.a()[1])))) {
                super.x(antMessageParcel);
            }
        }
        this.f3430y.b(p(), q(), antMessageParcel);
    }
}
