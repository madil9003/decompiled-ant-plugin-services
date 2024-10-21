package v;

import android.os.RemoteException;
import android.os.SystemClock;
import com.dsi.ant.channel.AntChannel;
import com.dsi.ant.message.ipc.AntMessageParcel;
import com.dsi.ant.plugins.internal.pluginsipc.AntPluginDeviceDbProvider;
import java.nio.channels.ClosedChannelException;
import k.l;
import z.a;

/* loaded from: classes.dex */
public abstract class a extends e implements a.b {

    /* renamed from: k */
    private static final String f3423k = "a";

    /* renamed from: h */
    public final AntChannel f3424h;

    /* renamed from: i */
    long f3425i;

    /* renamed from: j */
    long f3426j;

    /* renamed from: v.a$a */
    /* loaded from: classes.dex */
    public class C0063a implements g.d {
        C0063a() {
        }

        @Override // g.d
        public void a(l lVar, AntMessageParcel antMessageParcel) {
            a.this.r(lVar, antMessageParcel);
        }

        @Override // g.d
        public void b() {
            a.this.s();
        }
    }

    public a(AntPluginDeviceDbProvider.DeviceDbDeviceInfo deviceDbDeviceInfo, AntChannel antChannel) {
        super(deviceDbDeviceInfo, 1);
        this.f3425i = SystemClock.elapsedRealtime();
        this.f3426j = 0L;
        this.f3424h = antChannel;
        n();
    }

    private void n() {
        try {
            this.f3424h.t(new C0063a());
            o(true);
        } catch (RemoteException unused) {
            h1.a.b(f3423k, "RemoteException during initizalization");
            s();
            throw new ClosedChannelException();
        }
    }

    public abstract void a(l lVar, AntMessageParcel antMessageParcel);

    @Override // v.e
    public void d() {
        this.f3424h.m();
        super.d();
    }

    public abstract void o(boolean z2);

    public long p() {
        return this.f3425i;
    }

    public long q() {
        return this.f3426j;
    }

    public void r(l lVar, AntMessageParcel antMessageParcel) {
        this.f3425i = SystemClock.elapsedRealtime();
        a(lVar, antMessageParcel);
    }

    public void s() {
        k(-100);
    }
}
