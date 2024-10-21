package a1;

import com.dsi.ant.message.ipc.AntMessageParcel;
import java.math.BigDecimal;
import java.math.RoundingMode;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: d */
    public static final BigDecimal f78d = new BigDecimal(-1).setScale(0);

    /* renamed from: e */
    public static final BigDecimal f79e = new BigDecimal(-2).setScale(0);

    /* renamed from: a */
    private BigDecimal f80a;

    /* renamed from: b */
    BigDecimal f81b;

    /* renamed from: c */
    int f82c;

    public void a(AntMessageParcel antMessageParcel) {
        this.f82c = w.c.k(antMessageParcel.a(), 2);
        int k2 = w.c.k(antMessageParcel.a(), 5);
        this.f80a = k2 == 65535 ? f78d : k2 == 65534 ? f79e : new BigDecimal(k2).divide(new BigDecimal(100), 2, RoundingMode.HALF_DOWN).setScale(2, RoundingMode.HALF_DOWN);
        int k3 = w.c.k(antMessageParcel.a(), 7);
        this.f81b = k3 == 65535 ? f78d : k3 == 65534 ? f79e : new BigDecimal(k3).divide(new BigDecimal(100), 2, RoundingMode.HALF_DOWN).setScale(2, RoundingMode.HALF_DOWN);
    }

    public BigDecimal b() {
        return this.f81b;
    }

    public BigDecimal c() {
        return this.f80a;
    }

    public int d() {
        return this.f82c;
    }
}
