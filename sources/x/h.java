package x;

import android.os.Bundle;
import com.dsi.ant.message.ipc.AntMessageParcel;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class h extends w.b {

    /* renamed from: a */
    private final int f3551a = 110;

    /* renamed from: b */
    private final String f3552b = "arrayByteRAWDATAPAGEBYTES";

    /* renamed from: c */
    private u.a f3553c = new u.a(110);

    @Override // w.b
    public void b(long j2, long j3, AntMessageParcel antMessageParcel) {
        if (this.f3553c.b()) {
            byte[] bArr = new byte[8];
            System.arraycopy(antMessageParcel.a(), 1, bArr, 0, 8);
            Bundle bundle = new Bundle();
            bundle.putLong("long_EstTimestamp", j2);
            bundle.putLong("long_EventFlags", j3);
            bundle.putByteArray("arrayByteRAWDATAPAGEBYTES", bArr);
            this.f3553c.a(bundle);
        }
    }

    @Override // w.b
    public List c() {
        return Arrays.asList(this.f3553c);
    }

    @Override // w.b
    public List d() {
        return null;
    }
}
