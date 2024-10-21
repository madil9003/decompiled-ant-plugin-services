package x;

import android.os.Bundle;
import com.dsi.ant.message.ipc.AntMessageParcel;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class d extends w.b implements w.e {

    /* renamed from: a */
    private final boolean f3529a;

    /* renamed from: c */
    public int f3531c;

    /* renamed from: d */
    public byte f3532d;

    /* renamed from: e */
    public o0.h f3533e;

    /* renamed from: b */
    public int f3530b = 15;

    /* renamed from: f */
    private u.a f3534f = new u.a(201);

    /* renamed from: g */
    private u.a f3535g = new u.a(108);

    public d(boolean z2) {
        this.f3529a = z2;
    }

    public static void g(c cVar, Bundle bundle) {
        cVar.f3524a = 73;
        cVar.f3525b = bundle.getInt("int_sequenceNumber");
        cVar.f3526c = o0.f.c(bundle.getInt("int_commandStatus"));
        w.c.d(cVar.f3527d, 0, bundle.getInt("int_commandNumber"));
        byte[] bArr = cVar.f3527d;
        bArr[3] = -1;
        bArr[2] = -1;
    }

    @Override // w.e
    public void a(byte[] bArr) {
        bArr[0] = (byte) (((Integer) d().get(0)).intValue() & 255);
        int i2 = this.f3531c;
        bArr[1] = (byte) (i2 & 255);
        bArr[2] = (byte) ((i2 & 65280) >> 8);
        int i3 = this.f3530b;
        bArr[3] = (byte) (i3 & 255);
        bArr[4] = (byte) ((i3 & 255) >> 8);
        bArr[5] = this.f3532d;
        bArr[6] = this.f3533e.c();
        bArr[7] = this.f3533e.d();
    }

    @Override // w.b
    public void b(long j2, long j3, AntMessageParcel antMessageParcel) {
        f(antMessageParcel);
        if (this.f3535g.b() || (this.f3529a && this.f3534f.b())) {
            Bundle bundle = new Bundle();
            bundle.putLong("long_EstTimestamp", j2);
            bundle.putLong("long_EventFlags", j3);
            bundle.putInt("int_serialNumber", this.f3531c);
            bundle.putInt("int_manufacturerID", this.f3530b);
            bundle.putInt("int_sequenceNumber", this.f3532d & 255);
            bundle.putInt("int_commandNumber", this.f3533e.b());
            this.f3535g.a(bundle);
            if (this.f3529a) {
                this.f3534f.a(bundle);
            }
        }
    }

    @Override // w.b
    public List c() {
        return Arrays.asList(this.f3529a ? new u.a[]{this.f3535g, this.f3534f} : new u.a[]{this.f3535g});
    }

    @Override // w.b
    public List d() {
        return Arrays.asList(73);
    }

    public void f(AntMessageParcel antMessageParcel) {
        this.f3531c = w.c.k(antMessageParcel.a(), 2);
        this.f3530b = w.c.k(antMessageParcel.a(), 4);
        this.f3532d = antMessageParcel.a()[6];
        this.f3533e = o0.h.e(w.c.k(antMessageParcel.a(), 7));
    }
}
