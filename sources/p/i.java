package p;

import android.os.Bundle;
import com.dsi.ant.message.ipc.AntMessageParcel;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class i extends w.b {

    /* renamed from: c */
    private static int f2896c = 32000;

    /* renamed from: a */
    private u.a f2897a = new u.a(216);

    /* renamed from: b */
    private w.f f2898b = new w.f(65535, f2896c);

    @Override // w.b
    public void b(long j2, long j3, AntMessageParcel antMessageParcel) {
        this.f2898b.h(w.c.k(antMessageParcel.a(), 5), j2);
        if (this.f2897a.b()) {
            Bundle bundle = new Bundle();
            bundle.putLong("long_EstTimestamp", j2);
            bundle.putLong("long_EventFlags", j3);
            bundle.putInt("int_numOfDataTypes", w.c.v(antMessageParcel.a()[2]));
            bundle.putInt("int_dataType", w.c.i(antMessageParcel.a()[3]));
            bundle.putSerializable("decimal_timeStamp", new BigDecimal(this.f2898b.c()).divide(new BigDecimal("2048"), 11, RoundingMode.HALF_UP));
            int k2 = w.c.k(antMessageParcel.a(), 7);
            byte b3 = antMessageParcel.a()[4];
            bundle.putSerializable("decimal_measurementValue", new BigDecimal(k2).multiply(new BigDecimal(Math.pow(2.0d, b3))).setScale(b3 < 0 ? b3 * (-1) : 0, RoundingMode.HALF_UP));
            this.f2897a.a(bundle);
        }
    }

    @Override // w.b
    public List c() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f2897a);
        return arrayList;
    }

    @Override // w.b
    public List d() {
        return Arrays.asList(3);
    }
}
