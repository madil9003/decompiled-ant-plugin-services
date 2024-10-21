package q;

import android.os.Bundle;
import com.dsi.ant.message.ipc.AntMessageParcel;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class f extends w.b {

    /* renamed from: a */
    private u.a f3009a = new u.a(201);

    /* renamed from: b */
    private u.a f3010b = new u.a(202);

    /* renamed from: c */
    private u.a f3011c = new u.a(203);

    /* renamed from: d */
    private w.a f3012d = new w.a(65535);

    /* renamed from: e */
    private w.a f3013e = new w.a(65535);

    /* renamed from: f */
    int f3014f = 8;

    @Override // w.b
    public void b(long j2, long j3, AntMessageParcel antMessageParcel) {
    }

    @Override // w.b
    public List c() {
        return Arrays.asList(this.f3009a, this.f3010b, this.f3011c);
    }

    @Override // w.b
    public List d() {
        return null;
    }

    @Override // w.b
    public void e() {
        this.f3012d.g();
        this.f3013e.g();
        super.e();
    }

    public void f(long j2, long j3, int i2, int i3) {
        BigDecimal scale;
        this.f3012d.a(i2);
        this.f3013e.a(i3);
        if (this.f3011c.b()) {
            Bundle bundle = new Bundle();
            bundle.putLong("long_EstTimestamp", j2);
            bundle.putLong("long_EventFlags", j3);
            bundle.putSerializable("decimal_timestampOfLastEvent", new BigDecimal(this.f3012d.c()).divide(new BigDecimal(1024), 10, RoundingMode.HALF_UP).setScale(10));
            bundle.putLong("long_cumulativeRevolutions", this.f3013e.c());
            this.f3011c.a(bundle);
        }
        if (this.f3013e.d()) {
            return;
        }
        if (this.f3009a.b()) {
            if (this.f3013e.b() == 0 || this.f3012d.b() == 0) {
                int i4 = this.f3014f;
                if (i4 > 0) {
                    this.f3014f = i4 - 1;
                }
                scale = this.f3014f == 0 ? new BigDecimal(0).setScale(0) : null;
            } else {
                scale = new BigDecimal(this.f3013e.b()).divide(new BigDecimal(this.f3012d.b()), 10, RoundingMode.HALF_UP).multiply(new BigDecimal(1024)).setScale(10, RoundingMode.HALF_UP);
                this.f3014f = 16;
            }
            if (scale != null) {
                Bundle bundle2 = new Bundle();
                bundle2.putLong("long_EstTimestamp", j2);
                bundle2.putLong("long_EventFlags", j3);
                bundle2.putSerializable("decimal_calculatedSpeed", scale);
                this.f3009a.a(bundle2);
            }
        }
        if (!this.f3010b.b() || this.f3013e.b() == 0) {
            return;
        }
        Bundle bundle3 = new Bundle();
        bundle3.putLong("long_EstTimestamp", j2);
        bundle3.putLong("long_EventFlags", j3);
        bundle3.putSerializable("decimal_calculatedAccumulatedDistance", new BigDecimal(this.f3013e.c()));
        this.f3010b.a(bundle3);
    }
}
