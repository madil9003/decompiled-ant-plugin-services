package g0;

import android.os.Bundle;
import com.dsi.ant.message.ipc.AntMessageParcel;
import com.dsi.ant.plugins.antplus.pcc.AntPlusFitnessEquipmentPcc;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class a extends w.b {

    /* renamed from: a */
    private u.a f1741a = new u.a(202);

    /* renamed from: b */
    private u.a f1742b = new u.a(201);

    /* renamed from: c */
    private w.g f1743c = new w.g();

    /* renamed from: d */
    private int f1744d = AntPlusFitnessEquipmentPcc.a.UNKNOWN.b();

    private boolean f(int i2) {
        return i2 != 0;
    }

    @Override // w.b
    public void b(long j2, long j3, AntMessageParcel antMessageParcel) {
        if (this.f1742b.b()) {
            Bundle bundle = new Bundle();
            bundle.putLong("long_EstTimestamp", j2);
            bundle.putLong("long_EventFlags", j3);
            if (this.f1743c.b(f(antMessageParcel.a()[8] & 128))) {
                bundle.putInt("int_lapCount", this.f1743c.a());
                this.f1742b.a(bundle);
            }
        }
        if (this.f1741a.b()) {
            Bundle bundle2 = new Bundle();
            bundle2.putLong("long_EstTimestamp", j2);
            bundle2.putLong("long_EventFlags", j3);
            bundle2.putInt("int_stateCode", (antMessageParcel.a()[8] & 112) >>> 4);
            if (antMessageParcel.a()[1] == 16) {
                this.f1744d = antMessageParcel.a()[2] & 31;
            }
            bundle2.putInt("int_equipmentTypeCode", this.f1744d);
            this.f1741a.a(bundle2);
        }
    }

    @Override // w.b
    public List c() {
        return Arrays.asList(this.f1741a, this.f1742b);
    }

    @Override // w.b
    public List d() {
        return null;
    }
}
