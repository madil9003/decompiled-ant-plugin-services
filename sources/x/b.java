package x;

import android.os.Bundle;
import com.dsi.ant.message.ipc.AntMessageParcel;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class b extends w.b {

    /* renamed from: a */
    private u.a f3523a = new u.a(103);

    @Override // w.b
    public void b(long j2, long j3, AntMessageParcel antMessageParcel) {
        if (this.f3523a.b()) {
            byte[] bArr = new byte[8];
            System.arraycopy(antMessageParcel.a(), 1, bArr, 0, 8);
            Bundle bundle = new Bundle();
            bundle.putLong("long_EstTimestamp", j2);
            bundle.putLong("long_EventFlags", j3);
            bundle.putByteArray("arrayByte_rawDataBytes", bArr);
            this.f3523a.a(bundle);
        }
    }

    @Override // w.b
    public List c() {
        return Arrays.asList(this.f3523a);
    }

    @Override // w.b
    public List d() {
        return Arrays.asList(240, 241, 242, 243, 244, 245, 246, 247, 248, 249, 250, 251, 252, 253, 254, 255);
    }
}
