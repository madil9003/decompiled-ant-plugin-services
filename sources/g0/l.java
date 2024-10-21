package g0;

import android.os.Bundle;
import com.dsi.ant.message.ipc.AntMessageParcel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class l extends w.b {

    /* renamed from: a */
    private u.a f1771a = new u.a(211);

    /* renamed from: b */
    private w.a f1772b = new w.a(255);

    /* renamed from: c */
    private a f1773c;

    public l(a aVar) {
        this.f1773c = aVar;
    }

    @Override // w.b
    public void b(long j2, long j3, AntMessageParcel antMessageParcel) {
        boolean z2 = (w.c.i(antMessageParcel.a()[8]) & 1) == 1;
        if (z2) {
            this.f1772b.a(w.c.i(antMessageParcel.a()[4]));
        }
        if (this.f1771a.b()) {
            Bundle bundle = new Bundle();
            bundle.putLong("long_EstTimestamp", j2);
            bundle.putLong("long_EventFlags", j3);
            bundle.putLong("long_cumulativeStrides", z2 ? this.f1772b.c() : -1L);
            int i2 = w.c.i(antMessageParcel.a()[5]);
            if (i2 == 255) {
                i2 = -1;
            }
            bundle.putInt("int_instantaneousCadence", i2);
            int k2 = w.c.k(antMessageParcel.a(), 6);
            bundle.putInt("int_instantaneousPower", k2 != 65535 ? k2 : -1);
            this.f1771a.a(bundle);
        }
        this.f1773c.b(j2, j3, antMessageParcel);
    }

    @Override // w.b
    public List c() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f1771a);
        return arrayList;
    }

    @Override // w.b
    public List d() {
        return Arrays.asList(24);
    }

    @Override // w.b
    public void e() {
        this.f1772b.g();
        this.f1773c.e();
    }
}
