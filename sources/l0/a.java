package l0;

import com.dsi.ant.channel.AntChannel;
import com.dsi.ant.plugins.internal.pluginsipc.AntPluginDeviceDbProvider;
import java.util.List;

/* loaded from: classes.dex */
public class a extends v.b {
    private w.a A;
    private m0.a B;
    private m0.b C;

    /* renamed from: z */
    private b f2603z;

    public a(AntPluginDeviceDbProvider.DeviceDbDeviceInfo deviceDbDeviceInfo, AntChannel antChannel) {
        super(deviceDbDeviceInfo, antChannel);
    }

    @Override // v.b
    public void B(List list, w.b bVar) {
        m0.b bVar2 = new m0.b(D(), E());
        this.C = bVar2;
        list.add(bVar2);
    }

    @Override // v.b
    public w.b C() {
        m0.a aVar = new m0.a(D(), E());
        this.B = aVar;
        return aVar;
    }

    public w.a D() {
        if (this.A == null) {
            this.A = new w.a(65535);
        }
        return this.A;
    }

    public b E() {
        if (this.f2603z == null) {
            this.f2603z = new b();
        }
        return this.f2603z;
    }
}
