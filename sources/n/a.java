package n;

import com.dsi.ant.message.ipc.AntMessageParcel;
import java.util.Arrays;
import java.util.List;
import q.c;

/* loaded from: classes.dex */
public final class a extends w.b {

    /* renamed from: a */
    private c f2639a = new c();

    @Override // w.b
    public void b(long j2, long j3, AntMessageParcel antMessageParcel) {
        this.f2639a.f(j2, j3, w.c.k(antMessageParcel.a(), 5), w.c.k(antMessageParcel.a(), 7));
    }

    @Override // w.b
    public List c() {
        return this.f2639a.c();
    }

    @Override // w.b
    public List d() {
        return Arrays.asList(0);
    }

    @Override // w.b
    public void e() {
        this.f2639a.e();
        super.e();
    }
}
