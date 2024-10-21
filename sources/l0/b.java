package l0;

import android.os.Bundle;
import com.dsi.ant.message.ipc.AntMessageParcel;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import n0.a;

/* loaded from: classes.dex */
public class b extends w.b {

    /* renamed from: a */
    private u.a f2604a = new u.a(207);

    /* renamed from: b */
    private long f2605b = -1;

    /* renamed from: c */
    private long f2606c = -1;

    /* renamed from: d */
    private long f2607d = -1;

    /* renamed from: e */
    private long f2608e = -1;

    private BigDecimal f(long j2, long j3) {
        BigDecimal bigDecimal = new BigDecimal(j3 - j2);
        bigDecimal.multiply(new BigDecimal("1000"));
        bigDecimal.divide(new BigDecimal("1024"), 7, RoundingMode.HALF_UP);
        return bigDecimal;
    }

    private void g(long j2, long j3, long j4, long j5, a.c cVar) {
        if (this.f2604a.b()) {
            Bundle bundle = new Bundle();
            bundle.putLong("long_EstTimestamp", j2);
            bundle.putLong("long_EventFlags", j3);
            bundle.putSerializable("decimal_calculatedRrInterval", f(j4, j5));
            bundle.putInt("int_rrFlag", cVar.b());
            this.f2604a.a(bundle);
        }
    }

    @Override // w.b
    public void b(long j2, long j3, AntMessageParcel antMessageParcel) {
    }

    @Override // w.b
    public List c() {
        return Arrays.asList(this.f2604a);
    }

    @Override // w.b
    public List d() {
        return null;
    }

    @Override // w.b
    public void e() {
        this.f2605b = -1L;
        this.f2606c = -1L;
        this.f2607d = -1L;
        this.f2608e = -1L;
        super.e();
    }

    public void h(long j2, long j3, w.a aVar, w.a aVar2, boolean z2) {
        a.c cVar;
        a.c cVar2;
        if (this.f2605b < 0) {
            this.f2605b = aVar2.c();
            this.f2608e = aVar.c();
            return;
        }
        if (z2) {
            g(j2, j3, -1L, 1L, a.c.HEART_RATE_ZERO_DETECTED);
            return;
        }
        long c3 = aVar.c();
        long j4 = this.f2608e;
        if (j4 > c3) {
            this.f2605b = -1L;
            this.f2606c = -1L;
            this.f2607d = -1L;
            this.f2608e = -1L;
        } else if (j4 != c3) {
            if (1 + j4 == c3) {
                this.f2607d = this.f2605b;
                long c4 = aVar2.c();
                this.f2605b = c4;
                this.f2608e = c3;
                long j5 = this.f2606c;
                if (j5 < 0) {
                    j5 = this.f2607d;
                    cVar2 = a.c.DATA_SOURCE_CACHED;
                } else {
                    cVar2 = a.c.DATA_SOURCE_PAGE_4;
                }
                g(j2, j3, j5, c4, cVar2);
            } else if (j4 < c3) {
                this.f2607d = this.f2605b;
                long c5 = aVar2.c();
                this.f2605b = c5;
                long j6 = this.f2606c;
                if (j6 < 0) {
                    j6 = c5 - ((c5 - this.f2607d) / (c3 - this.f2608e));
                    cVar = a.c.DATA_SOURCE_AVERAGED;
                } else {
                    cVar = a.c.DATA_SOURCE_PAGE_4;
                }
                g(j2, j3, j6, c5, cVar);
                this.f2608e = c3;
            }
        }
        this.f2606c = -1L;
    }

    public void i(long j2, long j3, w.a aVar) {
        this.f2606c = aVar.c();
    }
}
