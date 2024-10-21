package v;

import android.os.Bundle;
import android.os.Message;
import android.os.RemoteException;
import com.dsi.ant.channel.AntChannel;
import com.dsi.ant.plugins.internal.pluginsipc.AntPluginDeviceDbProvider;
import java.nio.channels.ClosedChannelException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.UUID;
import v.e;

/* loaded from: classes.dex */
public abstract class d extends a {

    /* renamed from: o */
    private static final String f3441o = "d";

    /* renamed from: l */
    private LinkedList f3442l;

    /* renamed from: m */
    private boolean f3443m;

    /* renamed from: n */
    public u0.a f3444n;

    public d(AntPluginDeviceDbProvider.DeviceDbDeviceInfo deviceDbDeviceInfo, AntChannel antChannel) {
        super(deviceDbDeviceInfo, antChannel);
        this.f3442l = new LinkedList();
        this.f3443m = false;
        try {
            this.f3444n = f.C(this);
        } catch (RemoteException unused) {
            h1.a.b(f3441o, "RemoteException during initizalization");
            s();
            throw new ClosedChannelException();
        }
    }

    private void t() {
        synchronized (this.f3442l) {
            if (this.f3443m) {
                return;
            }
            h hVar = (h) this.f3442l.poll();
            if (hVar != null) {
                boolean b3 = hVar.b(this.f3444n);
                this.f3443m = b3;
                if (b3) {
                    k(300);
                }
            }
        }
    }

    @Override // v.e
    public void b(UUID uuid, Message message) {
        String str;
        String str2;
        e.a aVar = (e.a) this.f3447b.get(uuid);
        Message obtain = Message.obtain();
        Bundle data = message.getData();
        obtain.what = message.what;
        int i2 = message.what;
        if (i2 == 106) {
            int i3 = data.getInt("int_requestedDataPage");
            if (i3 >= 0 && i3 <= 255) {
                obtain.arg1 = 0;
                j(aVar, obtain);
                u(new z.b(i3, this, null), aVar, 107, "int_requestStatus");
                return;
            } else {
                obtain.arg1 = -3;
                str = f3441o;
                str2 = "Cmd requestDataPage failed to start because the requested data page number was invalid.";
            }
        } else {
            if (i2 != 111) {
                super.b(uuid, message);
                return;
            }
            int i4 = data.getInt("int_ManufacturerSpecificPageNumber");
            byte[] byteArray = data.getByteArray("arrayByte_ManufacturerSpecificPageData");
            if (i4 < 240 || i4 > 255) {
                obtain.arg1 = -3;
                str = f3441o;
                str2 = "Cmd sendManufacturerDataPage failed to start because the requested data page number was invalid.";
            } else {
                if (byteArray != null && byteArray.length >= 7) {
                    obtain.arg1 = 0;
                    byte[] bArr = new byte[byteArray.length + 1];
                    w.c.b(bArr, 0, i4);
                    System.arraycopy(byteArray, 0, bArr, 1, byteArray.length);
                    u(new z.a(bArr, this, null), aVar, 107, "int_requestStatus");
                    j(aVar, obtain);
                }
                obtain.arg1 = -3;
                str = f3441o;
                str2 = "Cmd sendManufacturerDataPage failed to start because the requested data payload was less than 7 bytes.";
            }
        }
        h1.a.b(str, str2);
        j(aVar, obtain);
    }

    @Override // v.a
    public void o(boolean z2) {
        if (z2) {
            return;
        }
        synchronized (this.f3442l) {
            this.f3443m = false;
            t();
        }
    }

    public void u(z.a aVar, e.a aVar2, int i2, String str) {
        boolean z2;
        h hVar = new h(aVar, aVar2, i2, str);
        synchronized (this.f3442l) {
            Iterator it = this.f3442l.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z2 = false;
                    break;
                }
                h hVar2 = (h) it.next();
                if (hVar2.equals(hVar)) {
                    hVar2.f3465b.addAll(hVar.f3465b);
                    z2 = true;
                    break;
                }
            }
            if (!z2) {
                this.f3442l.add(hVar);
            }
        }
        t();
    }
}
