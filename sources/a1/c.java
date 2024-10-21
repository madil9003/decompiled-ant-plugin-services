package a1;

import com.dsi.ant.message.ipc.AntMessageParcel;
import java.math.BigDecimal;
import java.math.RoundingMode;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: d */
    public static final BigDecimal f83d = new BigDecimal(-1).setScale(0);

    /* renamed from: e */
    public static final BigDecimal f84e = new BigDecimal(-2).setScale(0);

    /* renamed from: a */
    int f85a;

    /* renamed from: b */
    BigDecimal f86b;

    /* renamed from: c */
    BigDecimal f87c;

    public void a(AntMessageParcel antMessageParcel) {
        this.f85a = w.c.k(antMessageParcel.a(), 2);
        int k2 = w.c.k(antMessageParcel.a(), 5);
        this.f86b = k2 == 65535 ? f83d : k2 == 65534 ? f84e : new BigDecimal(k2).divide(new BigDecimal(4), 2, RoundingMode.HALF_DOWN).setScale(2, RoundingMode.HALF_DOWN);
        int k3 = w.c.k(antMessageParcel.a(), 7);
        this.f87c = k3 == 65535 ? f83d : k3 == 65534 ? f84e : new BigDecimal(k3).divide(new BigDecimal(4), 2, RoundingMode.HALF_DOWN).setScale(2, RoundingMode.HALF_DOWN);
    }

    public BigDecimal b() {
        return this.f86b;
    }

    public BigDecimal c() {
        return this.f87c;
    }

    public int d() {
        return this.f85a;
    }
}
