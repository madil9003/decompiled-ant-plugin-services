package n;

import android.os.Bundle;
import com.dsi.ant.message.ipc.AntMessageParcel;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class b extends w.b {

    /* renamed from: a */
    u.a f2640a = new u.a(303);

    @Override // w.b
    public void b(long j2, long j3, AntMessageParcel antMessageParcel) {
        if (this.f2640a.b()) {
            Bundle bundle = new Bundle();
            bundle.putLong("long_EstTimestamp", j2);
            bundle.putLong("long_EventFlags", j3);
            bundle.putBoolean("bool_isStopped", (antMessageParcel.a()[2] & 1) == 1);
            this.f2640a.a(bundle);
        }
    }

    @Override // w.b
    public List c() {
        return Arrays.asList(this.f2640a);
    }

    @Override // w.b
    public List d() {
        return Arrays.asList(5);
    }
}
