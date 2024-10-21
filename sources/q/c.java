package q;

import android.os.Bundle;
import com.dsi.ant.message.ipc.AntMessageParcel;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class c extends w.b {

    /* renamed from: a */
    private u.a f3001a = new u.a(301);

    /* renamed from: b */
    private u.a f3002b = new u.a(302);

    /* renamed from: c */
    private w.a f3003c = new w.a(65535);

    /* renamed from: d */
    private w.a f3004d = new w.a(65535);

    /* renamed from: e */
    int f3005e = 8;

    @Override // w.b
    public void b(long j2, long j3, AntMessageParcel antMessageParcel) {
    }

    @Override // w.b
    public List c() {
        return Arrays.asList(this.f3001a, this.f3002b);
    }

    @Override // w.b
    public List d() {
        return null;
    }

    @Override // w.b
    public void e() {
        this.f3003c.g();
        this.f3004d.g();
        super.e();
    }

    public void f(long j2, long j3, int i2, int i3) {
        BigDecimal scale;
        this.f3003c.a(i2);
        this.f3004d.a(i3);
        if (this.f3002b.b()) {
            Bundle bundle = new Bundle();
            bundle.putLong("long_EstTimestamp", j2);
            bundle.putLong("long_EventFlags", j3);
            bundle.putSerializable("decimal_timestampOfLastEvent", new BigDecimal(this.f3003c.c()).divide(new BigDecimal(1024), 10, RoundingMode.HALF_UP).setScale(10));
            bundle.putLong("long_cumulativeRevolutions", this.f3004d.c());
            this.f3002b.a(bundle);
        }
        if (this.f3001a.b()) {
            if (this.f3004d.b() == 0 || this.f3003c.b() == 0) {
                int i4 = this.f3005e;
                if (i4 > 0) {
                    this.f3005e = i4 - 1;
                }
                scale = this.f3005e == 0 ? new BigDecimal(0).setScale(0) : null;
            } else {
                scale = new BigDecimal(this.f3004d.b()).divide(new BigDecimal(this.f3003c.b()), 10, RoundingMode.HALF_UP).multiply(new BigDecimal(61440)).setScale(10);
                this.f3005e = 16;
            }
            if (scale != null) {
                Bundle bundle2 = new Bundle();
                bundle2.putLong("long_EstTimestamp", j2);
                bundle2.putLong("long_EventFlags", j3);
                bundle2.putSerializable("decimal_calculatedCadence", scale);
                this.f3001a.a(bundle2);
            }
        }
    }
}
