package g0;

import android.os.Bundle;
import com.dsi.ant.message.ipc.AntMessageParcel;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class f extends w.b {

    /* renamed from: a */
    private u.a f1754a = new u.a(206);

    /* renamed from: b */
    private w.a f1755b = new w.a(255);

    /* renamed from: c */
    private w.a f1756c = new w.a(255);

    /* renamed from: d */
    private a f1757d;

    public f(a aVar) {
        this.f1757d = aVar;
    }

    @Override // w.b
    public void b(long j2, long j3, AntMessageParcel antMessageParcel) {
        a aVar;
        long j4;
        long j5;
        boolean z2 = (w.c.i(antMessageParcel.a()[8]) & 2) == 2;
        if (z2) {
            this.f1755b.a(w.c.i(antMessageParcel.a()[6]));
        }
        boolean z3 = (w.c.i(antMessageParcel.a()[8]) & 1) == 1;
        if (z3) {
            this.f1756c.a(w.c.i(antMessageParcel.a()[7]));
        }
        if (this.f1754a.b()) {
            Bundle bundle = new Bundle();
            bundle.putLong("long_EstTimestamp", j2);
            bundle.putLong("long_EventFlags", j3);
            int i2 = w.c.i(antMessageParcel.a()[5]);
            if (i2 == 255) {
                i2 = -1;
            }
            bundle.putInt("int_instantaneousCadence", i2);
            bundle.putSerializable("decimal_cumulativeNegVertDistance", z2 ? new BigDecimal(this.f1755b.c() * (-1)).divide(new BigDecimal(10), 1, RoundingMode.HALF_UP) : new BigDecimal(-1));
            bundle.putSerializable("decimal_cumulativePosVertDistance", z3 ? new BigDecimal(this.f1756c.c()).divide(new BigDecimal(10), 1, RoundingMode.HALF_UP) : new BigDecimal(-1));
            this.f1754a.a(bundle);
            aVar = this.f1757d;
            j4 = j2;
            j5 = j3;
        } else {
            aVar = this.f1757d;
            j4 = j2;
            j5 = j3;
        }
        aVar.b(j4, j5, antMessageParcel);
    }

    @Override // w.b
    public List c() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f1754a);
        return arrayList;
    }

    @Override // w.b
    public List d() {
        return Arrays.asList(19);
    }

    @Override // w.b
    public void e() {
        this.f1755b.g();
        this.f1756c.g();
        this.f1757d.e();
    }
}
