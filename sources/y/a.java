package y;

import android.os.Bundle;
import com.dsi.ant.message.ipc.AntMessageParcel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class a extends w.b {

    /* renamed from: a */
    u.a f3587a = new u.a(204);

    @Override // w.b
    public void b(long j2, long j3, AntMessageParcel antMessageParcel) {
        if (this.f3587a.b()) {
            Bundle bundle = new Bundle();
            bundle.putLong("long_EstTimestamp", j2);
            bundle.putLong("long_EventFlags", j3);
            bundle.putLong("long_cumulativeOperatingTime", w.c.m(antMessageParcel.a(), 2) * 2);
            this.f3587a.a(bundle);
        }
    }

    @Override // w.b
    public List c() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f3587a);
        return arrayList;
    }

    @Override // w.b
    public List d() {
        return Arrays.asList(1);
    }
}
