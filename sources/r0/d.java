package r0;

import android.os.Bundle;
import com.dsi.ant.message.ipc.AntMessageParcel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class d extends c {

    /* renamed from: d */
    private u.a f3071d = new u.a(207);

    /* renamed from: e */
    private w.a f3072e = new w.a(255);

    @Override // r0.c, r0.a, w.b
    public void b(long j2, long j3, AntMessageParcel antMessageParcel) {
        this.f3072e.a(w.c.i(antMessageParcel.a()[7]));
        if (this.f3071d.b()) {
            Bundle bundle = new Bundle();
            bundle.putLong("long_EstTimestamp", j2);
            bundle.putLong("long_EventFlags", j3);
            bundle.putLong("long_cumulativeCalories", this.f3072e.c());
            this.f3071d.a(bundle);
        }
        super.b(j2, j3, antMessageParcel);
    }

    @Override // r0.c, r0.a, w.b
    public List c() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f3071d);
        arrayList.addAll(super.c());
        return arrayList;
    }

    @Override // r0.c, w.b
    public List d() {
        return Arrays.asList(3);
    }

    @Override // w.b
    public void e() {
        this.f3072e.g();
    }
}
