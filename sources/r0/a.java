package r0;

import android.os.Bundle;
import com.dsi.ant.message.ipc.AntMessageParcel;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public abstract class a extends w.b {

    /* renamed from: a */
    private u.a f3061a = new u.a(201);

    @Override // w.b
    public void b(long j2, long j3, AntMessageParcel antMessageParcel) {
        if (this.f3061a.b()) {
            Bundle bundle = new Bundle();
            bundle.putLong("long_EstTimestamp", j2);
            bundle.putLong("long_EventFlags", j3);
            bundle.putSerializable("decimal_instantaneousSpeed", new BigDecimal(((antMessageParcel.a()[5] & 15) * 256) + (antMessageParcel.a()[6] & 255)).divide(new BigDecimal(256), 8, RoundingMode.HALF_UP).setScale(8));
            this.f3061a.a(bundle);
        }
    }

    @Override // w.b
    public List c() {
        return Arrays.asList(this.f3061a);
    }
}
