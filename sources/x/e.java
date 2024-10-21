package x;

import android.os.Bundle;
import com.dsi.ant.message.ipc.AntMessageParcel;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class e extends w.b implements w.e {

    /* renamed from: a */
    public int f3536a;

    /* renamed from: b */
    public int f3537b;

    /* renamed from: c */
    public int f3538c;

    /* renamed from: d */
    private u.a f3539d = new u.a(100);

    @Override // w.e
    public void a(byte[] bArr) {
        bArr[0] = (byte) (((Integer) d().get(0)).intValue() & 255);
        bArr[1] = -1;
        bArr[2] = -1;
        bArr[3] = (byte) (this.f3536a & 255);
        int i2 = this.f3537b;
        bArr[4] = (byte) (i2 & 255);
        bArr[5] = (byte) ((i2 >> 8) & 255);
        int i3 = this.f3538c;
        bArr[6] = (byte) (i3 & 255);
        bArr[7] = (byte) ((i3 >> 8) & 255);
    }

    @Override // w.b
    public void b(long j2, long j3, AntMessageParcel antMessageParcel) {
        f(antMessageParcel);
        if (this.f3539d.b()) {
            Bundle bundle = new Bundle();
            bundle.putLong("long_EstTimestamp", j2);
            bundle.putLong("long_EventFlags", j3);
            bundle.putInt("int_hardwareRevision", this.f3536a);
            bundle.putInt("int_manufacturerID", this.f3537b);
            bundle.putInt("int_modelNumber", this.f3538c);
            this.f3539d.a(bundle);
        }
    }

    @Override // w.b
    public List c() {
        return Arrays.asList(this.f3539d);
    }

    @Override // w.b
    public List d() {
        return Arrays.asList(80);
    }

    public void f(AntMessageParcel antMessageParcel) {
        this.f3536a = w.c.i(antMessageParcel.a()[4]);
        this.f3537b = w.c.k(antMessageParcel.a(), 5);
        this.f3538c = w.c.k(antMessageParcel.a(), 7);
    }
}
