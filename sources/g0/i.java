package g0;

import android.os.Bundle;
import com.dsi.ant.message.ipc.AntMessageParcel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class i extends w.b {

    /* renamed from: a */
    private u.a f1763a = new u.a(208);

    /* renamed from: b */
    private a f1764b;

    public i(a aVar) {
        this.f1764b = aVar;
    }

    @Override // w.b
    public void b(long j2, long j3, AntMessageParcel antMessageParcel) {
        if (!this.f1763a.b()) {
            this.f1764b.b(j2, j3, antMessageParcel);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putLong("long_EstTimestamp", j2);
        bundle.putLong("long_EventFlags", j3);
        int i2 = w.c.i(antMessageParcel.a()[5]);
        if (i2 == 255) {
            i2 = -1;
        }
        int k2 = w.c.k(antMessageParcel.a(), 6);
        int i3 = k2 != 65535 ? k2 : -1;
        bundle.putInt("int_instantaneousCadence", i2);
        bundle.putInt("int_instantaneousPower", i3);
        this.f1763a.a(bundle);
        this.f1764b.b(j2, j3, antMessageParcel);
    }

    @Override // w.b
    public List c() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f1763a);
        return arrayList;
    }

    @Override // w.b
    public List d() {
        return Arrays.asList(21);
    }

    @Override // w.b
    public void e() {
        this.f1764b.e();
    }
}
