package h;

import android.os.Bundle;
import com.dsi.ant.channel.Capabilities;
import com.dsi.ant.channel.EventBufferSettings;
import com.dsi.ant.message.LibConfig;
import com.dsi.ant.message.ipc.AntMessageParcel;
import j.d;
import j.f;
import j.h;
import j.i;
import k.l;

/* loaded from: classes.dex */
public interface a {
    void a(d dVar, f fVar, Bundle bundle);

    void b(byte[] bArr, Bundle bundle);

    void c(int i2, Bundle bundle);

    void d(byte[] bArr, Bundle bundle);

    void e();

    void f(int i2, Bundle bundle);

    void g(byte[] bArr, Bundle bundle);

    void h(Bundle bundle);

    Capabilities i();

    void j(LibConfig libConfig, Bundle bundle);

    void k(int i2, Bundle bundle);

    void l(Bundle bundle);

    void m();

    void n(g.d dVar);

    void o(j.b bVar, int i2, Bundle bundle);

    void p(i iVar, Bundle bundle);

    void q(Bundle bundle);

    void r(int i2, Bundle bundle);

    void s(EventBufferSettings eventBufferSettings, Bundle bundle);

    void t(h hVar, Bundle bundle);

    void u(j.b bVar, Bundle bundle);

    AntMessageParcel v(l lVar, Bundle bundle);

    void w(int i2, boolean z2, Bundle bundle);
}
