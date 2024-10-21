package m0;

import android.os.Bundle;
import com.dsi.ant.message.ipc.AntMessageParcel;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import w.c;

/* loaded from: classes.dex */
public class b extends w.b {

    /* renamed from: b */
    private w.a f2620b;

    /* renamed from: d */
    private l0.b f2622d;

    /* renamed from: a */
    private u.a f2619a = new u.a(203);

    /* renamed from: c */
    private w.a f2621c = new w.a(65535);

    public b(w.a aVar, l0.b bVar) {
        this.f2620b = aVar;
        this.f2622d = bVar;
    }

    @Override // w.b
    public void b(long j2, long j3, AntMessageParcel antMessageParcel) {
        int k2 = c.k(antMessageParcel.a(), 3);
        if (this.f2621c.d()) {
            if (this.f2620b.d()) {
                return;
            }
            int k3 = c.k(antMessageParcel.a(), 5);
            this.f2620b.a(k3);
            long c3 = this.f2620b.c();
            int i2 = k3 - k2;
            if (i2 < 0) {
                i2 += 65535;
            }
            this.f2621c.f(c3 - i2, k2);
        }
        this.f2621c.a(k2);
        this.f2622d.i(j2, j3, this.f2621c);
        if (this.f2619a.b()) {
            Bundle bundle = new Bundle();
            bundle.putLong("long_EstTimestamp", j2);
            bundle.putLong("long_EventFlags", j3);
            bundle.putInt("int_manufacturerSpecificByte", c.i(antMessageParcel.a()[2]));
            bundle.putSerializable("decimal_timestampOfPreviousToLastHeartBeatEvent", new BigDecimal(this.f2621c.c()).divide(new BigDecimal(1024), 10, RoundingMode.HALF_UP).setScale(10));
            this.f2619a.a(bundle);
        }
    }

    @Override // w.b
    public List c() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f2619a);
        return arrayList;
    }

    @Override // w.b
    public List d() {
        return Arrays.asList(4);
    }

    @Override // w.b
    public void e() {
        this.f2621c.g();
    }
}
