package g0;

import android.os.Bundle;
import com.dsi.ant.message.ipc.AntMessageParcel;
import com.dsi.ant.plugins.antplus.pcc.AntPlusFitnessEquipmentPcc;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class t extends w.b {

    /* renamed from: a */
    private u.a f1792a = new u.a(224);

    @Override // w.b
    public void b(long j2, long j3, AntMessageParcel antMessageParcel) {
        if (this.f1792a.b()) {
            Bundle bundle = new Bundle();
            bundle.putLong("long_EstTimestamp", j2);
            bundle.putLong("long_EventFlags", j3);
            AntPlusFitnessEquipmentPcc.Capabilities capabilities = new AntPlusFitnessEquipmentPcc.Capabilities();
            int k2 = w.c.k(antMessageParcel.a(), 6);
            capabilities.f641b = k2 != 65535 ? Integer.valueOf(k2) : null;
            int i2 = w.c.i(antMessageParcel.a()[8]);
            capabilities.f642c = (i2 & 1) != 0;
            capabilities.f643d = (i2 & 2) != 0;
            capabilities.f644e = (i2 & 4) != 0;
            bundle.putParcelable("parcelable_Capabilities", capabilities);
            this.f1792a.a(bundle);
        }
    }

    @Override // w.b
    public List c() {
        return Arrays.asList(this.f1792a);
    }

    @Override // w.b
    public List d() {
        return Arrays.asList(54);
    }
}
