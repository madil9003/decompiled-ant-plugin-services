package a1;

import com.dsi.ant.message.ipc.AntMessageParcel;
import java.math.BigDecimal;
import java.math.RoundingMode;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: d */
    public static final BigDecimal f88d = new BigDecimal(-1).setScale(0);

    /* renamed from: e */
    public static final BigDecimal f89e = new BigDecimal(-2).setScale(0);

    /* renamed from: a */
    int f90a;

    /* renamed from: b */
    BigDecimal f91b;

    /* renamed from: c */
    BigDecimal f92c;

    public void a(AntMessageParcel antMessageParcel) {
        this.f90a = w.c.k(antMessageParcel.a(), 2);
        int k2 = w.c.k(antMessageParcel.a(), 6);
        this.f91b = k2 == 65535 ? f88d : k2 == 65534 ? f89e : new BigDecimal(k2).divide(new BigDecimal(100), 2, RoundingMode.HALF_DOWN).setScale(2, RoundingMode.HALF_DOWN);
        int i2 = w.c.i(antMessageParcel.a()[8]);
        this.f92c = i2 == 255 ? f88d : i2 == 254 ? f89e : new BigDecimal(i2).divide(new BigDecimal(10), 1, RoundingMode.HALF_DOWN).setScale(1, RoundingMode.HALF_DOWN);
    }

    public BigDecimal b() {
        return this.f92c;
    }

    public BigDecimal c() {
        return this.f91b;
    }

    public int d() {
        return this.f90a;
    }
}
