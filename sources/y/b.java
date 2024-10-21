package y;

import android.os.Bundle;
import com.dsi.ant.message.ipc.AntMessageParcel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class b extends w.b {

    /* renamed from: a */
    u.a f3588a = new u.a(205);

    @Override // w.b
    public void b(long j2, long j3, AntMessageParcel antMessageParcel) {
        if (this.f3588a.b()) {
            Bundle bundle = new Bundle();
            bundle.putLong("long_EstTimestamp", j2);
            bundle.putLong("long_EventFlags", j3);
            bundle.putInt("int_manufacturerID", w.c.i(antMessageParcel.a()[2]));
            bundle.putInt("int_serialNumber", w.c.k(antMessageParcel.a(), 3));
            this.f3588a.a(bundle);
        }
    }

    @Override // w.b
    public List c() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f3588a);
        return arrayList;
    }

    @Override // w.b
    public List d() {
        return Arrays.asList(2);
    }
}
