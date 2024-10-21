package g0;

import android.os.Bundle;
import com.dsi.ant.message.ipc.AntMessageParcel;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class h extends w.b {

    /* renamed from: a */
    private u.a f1759a = new u.a(207);

    /* renamed from: b */
    private w.a f1760b = new w.a(255);

    /* renamed from: c */
    private w.a f1761c = new w.a(255);

    /* renamed from: d */
    private a f1762d;

    public h(a aVar) {
        this.f1762d = aVar;
    }

    @Override // w.b
    public void b(long j2, long j3, AntMessageParcel antMessageParcel) {
        a aVar;
        long j4;
        long j5;
        boolean z2 = (w.c.i(antMessageParcel.a()[8]) & 2) == 2;
        if (z2) {
            this.f1760b.a(w.c.i(antMessageParcel.a()[3]));
        }
        boolean z3 = (w.c.i(antMessageParcel.a()[8]) & 1) == 1;
        if (z3) {
            this.f1761c.a(w.c.i(antMessageParcel.a()[4]));
        }
        if (this.f1759a.b()) {
            Bundle bundle = new Bundle();
            bundle.putLong("long_EstTimestamp", j2);
            bundle.putLong("long_EventFlags", j3);
            bundle.putSerializable("decimal_cumulativePosVertDistance", z2 ? new BigDecimal(this.f1760b.c()).divide(new BigDecimal(10), 1, RoundingMode.HALF_UP) : new BigDecimal(-1));
            bundle.putLong("long_cumulativeStrides", z3 ? this.f1761c.c() : -1L);
            int i2 = w.c.i(antMessageParcel.a()[5]);
            if (i2 == 255) {
                i2 = -1;
            }
            bundle.putInt("int_instantaneousCadence", i2);
            int k2 = w.c.k(antMessageParcel.a(), 6);
            bundle.putInt("int_instantaneousPower", k2 != 65535 ? k2 : -1);
            this.f1759a.a(bundle);
            aVar = this.f1762d;
            j4 = j2;
            j5 = j3;
        } else {
            aVar = this.f1762d;
            j4 = j2;
            j5 = j3;
        }
        aVar.b(j4, j5, antMessageParcel);
    }

    @Override // w.b
    public List c() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f1759a);
        return arrayList;
    }

    @Override // w.b
    public List d() {
        return Arrays.asList(20);
    }

    @Override // w.b
    public void e() {
        this.f1761c.g();
        this.f1760b.g();
        this.f1762d.e();
    }
}
