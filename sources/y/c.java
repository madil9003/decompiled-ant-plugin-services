package y;

import android.os.Bundle;
import com.dsi.ant.message.ipc.AntMessageParcel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class c extends w.b {

    /* renamed from: a */
    u.a f3589a = new u.a(206);

    @Override // w.b
    public void b(long j2, long j3, AntMessageParcel antMessageParcel) {
        if (this.f3589a.b()) {
            Bundle bundle = new Bundle();
            bundle.putLong("long_EstTimestamp", j2);
            bundle.putLong("long_EventFlags", j3);
            bundle.putInt("int_hardwareVersion", w.c.i(antMessageParcel.a()[2]));
            bundle.putInt("int_softwareVersion", w.c.i(antMessageParcel.a()[3]));
            bundle.putInt("int_modelNumber", w.c.i(antMessageParcel.a()[4]));
            this.f3589a.a(bundle);
        }
    }

    @Override // w.b
    public List c() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f3589a);
        return arrayList;
    }

    @Override // w.b
    public List d() {
        return Arrays.asList(3);
    }
}
