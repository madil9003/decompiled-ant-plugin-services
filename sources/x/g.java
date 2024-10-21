package x;

import android.os.Bundle;
import com.dsi.ant.message.ipc.AntMessageParcel;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class g extends w.b {

    /* renamed from: a */
    public long f3544a;

    /* renamed from: b */
    public BigDecimal f3545b;

    /* renamed from: c */
    public int f3546c;

    /* renamed from: d */
    public int f3547d;

    /* renamed from: e */
    public int f3548e;

    /* renamed from: f */
    public int f3549f;

    /* renamed from: g */
    private u.a f3550g = new u.a(102);

    @Override // w.b
    public void b(long j2, long j3, AntMessageParcel antMessageParcel) {
        f(antMessageParcel);
        if (this.f3550g.b()) {
            Bundle bundle = new Bundle();
            bundle.putLong("long_EstTimestamp", j2);
            bundle.putLong("long_EventFlags", j3);
            bundle.putLong("long_cumulativeOperatingTime", this.f3544a);
            bundle.putSerializable("decimal_batteryVoltage", this.f3545b);
            bundle.putInt("int_batteryStatusCode", this.f3546c);
            bundle.putInt("int_cumulativeOperatingTimeResolution", this.f3547d);
            bundle.putInt("int_numberOfBatteries", this.f3548e);
            bundle.putInt("int_batteryIdentifier", this.f3549f);
            this.f3550g.a(bundle);
        }
    }

    @Override // w.b
    public List c() {
        return Arrays.asList(this.f3550g);
    }

    @Override // w.b
    public List d() {
        return Arrays.asList(82);
    }

    public void f(AntMessageParcel antMessageParcel) {
        this.f3544a = w.c.m(antMessageParcel.a(), 4);
        this.f3545b = (antMessageParcel.a()[8] & 15) != 15 ? new BigDecimal(antMessageParcel.a()[8] & 15).add(new BigDecimal(w.c.i(antMessageParcel.a()[7])).divide(new BigDecimal(256), 8, RoundingMode.HALF_UP)).setScale(8) : new BigDecimal(-1);
        this.f3546c = (antMessageParcel.a()[8] & 112) >> 4;
        this.f3547d = (antMessageParcel.a()[8] & 128) > 0 ? 2 : 16;
        int i2 = antMessageParcel.a()[3] & 15;
        this.f3548e = i2;
        if (i2 == 15) {
            this.f3548e = -1;
        }
        int i3 = (antMessageParcel.a()[3] & 240) >> 4;
        this.f3549f = i3;
        if (i3 == 15) {
            this.f3549f = -1;
        }
    }
}
