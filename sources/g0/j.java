package g0;

import android.os.Bundle;
import com.dsi.ant.message.ipc.AntMessageParcel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class j extends w.b {

    /* renamed from: a */
    private u.a f1765a = new u.a(209);

    /* renamed from: b */
    private w.a f1766b = new w.a(255);

    /* renamed from: c */
    private a f1767c;

    public j(a aVar) {
        this.f1767c = aVar;
    }

    @Override // w.b
    public void b(long j2, long j3, AntMessageParcel antMessageParcel) {
        boolean z2 = (w.c.i(antMessageParcel.a()[8]) & 1) == 1;
        if (z2) {
            this.f1766b.a(w.c.i(antMessageParcel.a()[4]));
        }
        if (this.f1765a.b()) {
            Bundle bundle = new Bundle();
            bundle.putLong("long_EstTimestamp", j2);
            bundle.putLong("long_EventFlags", j3);
            bundle.putLong("long_cumulativeStrokes", z2 ? this.f1766b.c() : -1L);
            int i2 = w.c.i(antMessageParcel.a()[5]);
            if (i2 == 255) {
                i2 = -1;
            }
            bundle.putInt("int_instantaneousCadence", i2);
            int k2 = w.c.k(antMessageParcel.a(), 6);
            bundle.putInt("int_instantaneousPower", k2 != 65535 ? k2 : -1);
            this.f1765a.a(bundle);
        }
        this.f1767c.b(j2, j3, antMessageParcel);
    }

    @Override // w.b
    public List c() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f1765a);
        return arrayList;
    }

    @Override // w.b
    public List d() {
        return Arrays.asList(22);
    }

    @Override // w.b
    public void e() {
        this.f1766b.g();
        this.f1767c.e();
    }
}
