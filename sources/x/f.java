package x;

import android.os.Bundle;
import com.dsi.ant.message.ipc.AntMessageParcel;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class f extends w.b implements w.e {

    /* renamed from: a */
    public int f3540a;

    /* renamed from: c */
    public long f3542c;

    /* renamed from: b */
    public int f3541b = 255;

    /* renamed from: d */
    private u.a f3543d = new u.a(101);

    @Override // w.e
    public void a(byte[] bArr) {
        bArr[0] = (byte) (((Integer) d().get(0)).intValue() & 255);
        bArr[1] = -1;
        bArr[2] = (byte) (this.f3541b & 255);
        bArr[3] = (byte) (this.f3540a & 255);
        long j2 = this.f3542c;
        bArr[4] = (byte) (j2 & 255);
        bArr[5] = (byte) ((j2 >> 8) & 255);
        bArr[6] = (byte) ((j2 >> 16) & 255);
        bArr[7] = (byte) ((j2 >> 24) & 255);
    }

    @Override // w.b
    public void b(long j2, long j3, AntMessageParcel antMessageParcel) {
        f(antMessageParcel);
        if (this.f3543d.b()) {
            Bundle bundle = new Bundle();
            bundle.putLong("long_EstTimestamp", j2);
            bundle.putLong("long_EventFlags", j3);
            bundle.putInt("int_softwareRevision", this.f3540a);
            bundle.putInt("int_supplementaryRevision", this.f3541b);
            bundle.putLong("long_serialNumber", this.f3542c);
            this.f3543d.a(bundle);
        }
    }

    @Override // w.b
    public List c() {
        return Arrays.asList(this.f3543d);
    }

    @Override // w.b
    public List d() {
        return Arrays.asList(81);
    }

    public void f(AntMessageParcel antMessageParcel) {
        this.f3540a = w.c.i(antMessageParcel.a()[4]);
        this.f3541b = w.c.i(antMessageParcel.a()[3]);
        this.f3542c = w.c.n(antMessageParcel.a(), 5);
    }
}
