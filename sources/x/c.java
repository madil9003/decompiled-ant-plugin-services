package x;

import android.os.Bundle;
import com.dsi.ant.message.ipc.AntMessageParcel;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class c extends w.b implements w.e {

    /* renamed from: a */
    public int f3524a = 255;

    /* renamed from: b */
    public int f3525b = 255;

    /* renamed from: c */
    public o0.f f3526c = o0.f.UNINITIALIZED;

    /* renamed from: d */
    public final byte[] f3527d = new byte[4];

    /* renamed from: e */
    private final u.a f3528e;

    public c(u.a aVar) {
        this.f3528e = aVar;
    }

    @Override // w.e
    public void a(byte[] bArr) {
        bArr[0] = 71;
        bArr[1] = (byte) (this.f3524a & 255);
        bArr[2] = (byte) (this.f3525b & 255);
        bArr[3] = (byte) (this.f3526c.b() & 255);
        byte[] bArr2 = this.f3527d;
        System.arraycopy(bArr2, 0, bArr, 4, bArr2.length);
    }

    @Override // w.b
    public final void b(long j2, long j3, AntMessageParcel antMessageParcel) {
        g(antMessageParcel);
        u.a aVar = this.f3528e;
        if (aVar == null || !aVar.b()) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putLong("long_EstTimestamp", j2);
        bundle.putLong("long_EventFlags", j3);
        f(bundle);
        this.f3528e.a(bundle);
    }

    @Override // w.b
    public List c() {
        u.a aVar = this.f3528e;
        return Arrays.asList(aVar == null ? new u.a[0] : new u.a[]{aVar});
    }

    @Override // w.b
    public List d() {
        return Arrays.asList(71);
    }

    protected void f(Bundle bundle) {
    }

    public void g(AntMessageParcel antMessageParcel) {
        this.f3524a = w.c.i(antMessageParcel.a()[2]);
        this.f3525b = w.c.i(antMessageParcel.a()[3]);
        this.f3526c = o0.f.c(w.c.i(antMessageParcel.a()[4]));
        byte[] a3 = antMessageParcel.a();
        byte[] bArr = this.f3527d;
        System.arraycopy(a3, 5, bArr, 0, bArr.length);
    }
}
