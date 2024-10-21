package d0;

import android.os.RemoteException;
import com.dsi.ant.channel.AntChannel;
import com.dsi.ant.plugins.internal.pluginsipc.AntPluginDeviceDbProvider;
import e0.b;
import java.util.ArrayList;
import java.util.List;
import v.c;

/* loaded from: classes.dex */
public class a extends c {

    /* renamed from: z */
    private static final String f1579z = "a";

    /* renamed from: w */
    e0.a f1580w;

    /* renamed from: x */
    b f1581x;

    /* renamed from: y */
    public int f1582y;

    public a(AntPluginDeviceDbProvider.DeviceDbDeviceInfo deviceDbDeviceInfo, AntChannel antChannel) {
        super(deviceDbDeviceInfo, antChannel);
        this.f1582y = -1;
    }

    public void B(int i2) {
        if (i2 != this.f1582y) {
            try {
                this.f3424h.x(i2);
                this.f1582y = i2;
            } catch (RemoteException unused) {
                h1.a.b(f1579z, "RemoteException trying to set period");
            } catch (g.a e3) {
                h1.a.b(f1579z, "ACFE trying to set period: " + e3.toString());
            }
        }
    }

    @Override // v.c
    public List w() {
        this.f1580w = new e0.a(this);
        this.f1581x = new b();
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f1580w);
        arrayList.add(this.f1581x);
        arrayList.addAll(v());
        return arrayList;
    }
}
