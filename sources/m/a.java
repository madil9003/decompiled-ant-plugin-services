package m;

import com.dsi.ant.channel.AntChannel;
import com.dsi.ant.plugins.internal.pluginsipc.AntPluginDeviceDbProvider;
import java.util.List;
import q.e;
import v.b;

/* loaded from: classes.dex */
public class a extends b {
    public a(AntPluginDeviceDbProvider.DeviceDbDeviceInfo deviceDbDeviceInfo, AntChannel antChannel) {
        super(deviceDbDeviceInfo, antChannel);
    }

    @Override // v.b
    public void B(List list, w.b bVar) {
        list.add(new e());
        list.add(new n.b());
    }

    @Override // v.b
    public w.b C() {
        return new n.a();
    }
}
