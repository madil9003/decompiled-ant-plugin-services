package q0;

import com.dsi.ant.channel.AntChannel;
import com.dsi.ant.plugins.internal.pluginsipc.AntPluginDeviceDbProvider;
import java.util.ArrayList;
import java.util.List;
import r0.b;
import r0.d;
import v.c;

/* loaded from: classes.dex */
public class a extends c {

    /* renamed from: w */
    private b f3015w;

    /* renamed from: x */
    private d f3016x;

    public a(AntPluginDeviceDbProvider.DeviceDbDeviceInfo deviceDbDeviceInfo, AntChannel antChannel) {
        super(deviceDbDeviceInfo, antChannel);
    }

    @Override // v.c
    public List w() {
        this.f3015w = new b();
        this.f3016x = new d();
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f3015w);
        arrayList.add(new r0.c());
        arrayList.add(this.f3016x);
        arrayList.addAll(v());
        return arrayList;
    }
}
