package s;

import com.dsi.ant.message.ipc.AntMessageParcel;
import java.util.Arrays;
import java.util.List;
import q.f;
import w.c;

/* loaded from: classes.dex */
public class a extends w.b {

    /* renamed from: a */
    private f f3073a = new f();

    @Override // w.b
    public void b(long j2, long j3, AntMessageParcel antMessageParcel) {
        this.f3073a.f(j2, j3, c.k(antMessageParcel.a(), 5), c.k(antMessageParcel.a(), 7));
    }

    @Override // w.b
    public List c() {
        return this.f3073a.c();
    }

    @Override // w.b
    public List d() {
        return Arrays.asList(0);
    }

    @Override // w.b
    public void e() {
        this.f3073a.e();
        super.e();
    }
}
