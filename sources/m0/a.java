package m0;

import android.os.Bundle;
import com.dsi.ant.message.ipc.AntMessageParcel;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import n0.a;
import w.c;

/* loaded from: classes.dex */
public final class a extends w.b {

    /* renamed from: d */
    private w.a f2616d;

    /* renamed from: e */
    private l0.b f2617e;

    /* renamed from: a */
    private u.a f2613a = new u.a(201);

    /* renamed from: b */
    private u.a f2614b = new u.a(202);

    /* renamed from: c */
    private w.a f2615c = new w.a(255);

    /* renamed from: f */
    private int f2618f = 0;

    public a(w.a aVar, l0.b bVar) {
        this.f2616d = aVar;
        this.f2617e = bVar;
    }

    @Override // w.b
    public void b(long j2, long j3, AntMessageParcel antMessageParcel) {
        a.EnumC0041a enumC0041a;
        int k2 = c.k(antMessageParcel.a(), 5);
        int i2 = c.i(antMessageParcel.a()[7]);
        this.f2615c.a(i2);
        this.f2616d.a(k2);
        if (this.f2615c.d()) {
            this.f2615c.f(0L, i2);
            this.f2615c.a(i2);
            this.f2616d.f(0L, k2);
            this.f2616d.a(k2);
            this.f2618f = 1;
            enumC0041a = a.EnumC0041a.INITIAL_VALUE;
        } else {
            if (this.f2615c.b() > 0) {
                this.f2618f = 1;
            } else {
                int i3 = this.f2618f + 1;
                this.f2618f = i3;
                if (i3 > 8) {
                    enumC0041a = a.EnumC0041a.ZERO_DETECTED;
                }
            }
            enumC0041a = a.EnumC0041a.LIVE_DATA;
        }
        a.EnumC0041a enumC0041a2 = enumC0041a;
        this.f2617e.h(j2, j3, this.f2615c, this.f2616d, enumC0041a2 == a.EnumC0041a.ZERO_DETECTED);
        String str = "decimal_timestampOfLastEvent";
        if (this.f2613a.b()) {
            Bundle bundle = new Bundle();
            bundle.putLong("long_EstTimestamp", j2);
            bundle.putLong("long_EventFlags", j3);
            bundle.putInt("int_computedHeartRate", c.i(antMessageParcel.a()[8]));
            bundle.putLong("long_heartBeatCounter", this.f2615c.c());
            str = "decimal_timestampOfLastEvent";
            bundle.putSerializable(str, new BigDecimal(this.f2616d.c()).divide(new BigDecimal(1024), 10, RoundingMode.HALF_UP).setScale(10));
            bundle.putInt("int_dataState", enumC0041a2.b());
            this.f2613a.a(bundle);
        }
        if (this.f2614b.b()) {
            Bundle bundle2 = new Bundle();
            bundle2.putLong("long_EstTimestamp", j2);
            bundle2.putLong("long_EventFlags", j3);
            bundle2.putSerializable(str, new BigDecimal(this.f2616d.c()).divide(new BigDecimal(1024), 10, RoundingMode.HALF_UP).setScale(10));
            this.f2614b.a(bundle2);
        }
    }

    @Override // w.b
    public List c() {
        ArrayList arrayList = new ArrayList(this.f2617e.c());
        arrayList.add(this.f2613a);
        arrayList.add(this.f2614b);
        return arrayList;
    }

    @Override // w.b
    public List d() {
        return Arrays.asList(0);
    }

    @Override // w.b
    public void e() {
        this.f2616d.g();
        this.f2615c.g();
        super.e();
    }
}
