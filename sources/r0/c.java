package r0;

import android.os.Bundle;
import com.dsi.ant.message.ipc.AntMessageParcel;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class c extends a {

    /* renamed from: b */
    private u.a f3069b = new u.a(202);

    /* renamed from: c */
    private u.a f3070c = new u.a(208);

    @Override // r0.a, w.b
    public void b(long j2, long j3, AntMessageParcel antMessageParcel) {
        if (this.f3069b.b()) {
            Bundle bundle = new Bundle();
            bundle.putLong("long_EstTimestamp", j2);
            bundle.putLong("long_EventFlags", j3);
            bundle.putSerializable("decimal_instantaneousCadence", new BigDecimal(((antMessageParcel.a()[4] & 255) * 256) + ((antMessageParcel.a()[5] & 240) >>> 4)).divide(new BigDecimal(256), 8, RoundingMode.HALF_UP).setScale(8));
            this.f3069b.a(bundle);
        }
        if (this.f3070c.b()) {
            Bundle bundle2 = new Bundle();
            bundle2.putLong("long_EstTimestamp", j2);
            bundle2.putLong("long_EventFlags", j3);
            int i2 = antMessageParcel.a()[8] & 255;
            bundle2.putInt("int_SensorLocation", (i2 >> 6) & 3);
            bundle2.putInt("int_BatteryStatus", ((i2 >> 4) & 3) + 1);
            bundle2.putInt("int_SensorHealth", (i2 >> 2) & 3);
            bundle2.putInt("int_UseState", i2 & 3);
            this.f3070c.a(bundle2);
        }
        super.b(j2, j3, antMessageParcel);
    }

    @Override // r0.a, w.b
    public List c() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f3069b);
        arrayList.add(this.f3070c);
        arrayList.addAll(super.c());
        return arrayList;
    }

    @Override // w.b
    public List d() {
        return Arrays.asList(2, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
    }
}
