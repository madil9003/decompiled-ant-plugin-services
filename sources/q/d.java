package q;

import com.dsi.ant.message.ipc.AntMessageParcel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class d extends w.b {

    /* renamed from: a */
    private c f3006a = new c();

    /* renamed from: b */
    private f f3007b = new f();

    @Override // w.b
    public void b(long j2, long j3, AntMessageParcel antMessageParcel) {
        this.f3006a.f(j2, j3, w.c.k(antMessageParcel.a(), 1), w.c.k(antMessageParcel.a(), 3));
        this.f3007b.f(j2, j3, w.c.k(antMessageParcel.a(), 5), w.c.k(antMessageParcel.a(), 7));
    }

    @Override // w.b
    public List c() {
        ArrayList arrayList = new ArrayList(this.f3006a.c());
        arrayList.addAll(this.f3007b.c());
        return arrayList;
    }

    @Override // w.b
    public List d() {
        return Arrays.asList(0);
    }

    @Override // w.b
    public void e() {
        this.f3006a.e();
        this.f3007b.e();
        super.e();
    }

    public List f() {
        return this.f3006a.c();
    }

    public List g() {
        return this.f3007b.c();
    }
}
