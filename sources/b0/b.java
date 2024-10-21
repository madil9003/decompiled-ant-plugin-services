package b0;

import android.os.Bundle;
import com.dsi.ant.message.ipc.AntMessageParcel;
import java.util.Arrays;
import java.util.List;
import w.e;

/* loaded from: classes.dex */
public class b extends w.b implements e {

    /* renamed from: g */
    public o0.a f197g;

    /* renamed from: a */
    public int f191a = 255;

    /* renamed from: b */
    public int f192b = 65535;

    /* renamed from: c */
    public int f193c = 65535;

    /* renamed from: d */
    public o0.b f194d = o0.b.OFF;

    /* renamed from: e */
    public o0.c f195e = o0.c.OFF_UNSUPPORTED;

    /* renamed from: f */
    public o0.d f196f = o0.d.OFF_UNSUPPORTED;

    /* renamed from: h */
    public boolean f198h = false;

    /* renamed from: i */
    private u.a f199i = new u.a(202);

    @Override // w.e
    public void a(byte[] bArr) {
        bArr[0] = (byte) (((Integer) d().get(0)).intValue() & 255);
        bArr[1] = (byte) (this.f191a & 255);
        int i2 = this.f192b;
        bArr[2] = (byte) (i2 & 255);
        bArr[3] = (byte) ((i2 >> 8) & 255);
        int i3 = this.f193c;
        bArr[4] = (byte) (i3 & 255);
        bArr[5] = (byte) ((i3 >> 8) & 255);
        bArr[6] = 0;
        if (this.f198h) {
            bArr[6] = (byte) (1 | 0);
        }
        o0.a aVar = this.f197g;
        if (aVar.f2746b) {
            bArr[6] = (byte) (bArr[6] | 2);
        }
        if (aVar.f2745a) {
            bArr[6] = (byte) (bArr[6] | 4);
        }
        bArr[7] = 0;
        byte b3 = (byte) (0 | ((byte) (this.f196f.b() & 3)));
        bArr[7] = b3;
        byte b4 = (byte) (b3 | ((byte) ((this.f195e.b() << 2) & 12)));
        bArr[7] = b4;
        bArr[7] = (byte) (((byte) ((this.f194d.b() << 4) & 240)) | b4);
    }

    @Override // w.b
    public void b(long j2, long j3, AntMessageParcel antMessageParcel) {
        if (this.f199i.b()) {
            Bundle bundle = new Bundle();
            bundle.putLong("long_EstTimestamp", j2);
            bundle.putLong("long_EventFlags", j3);
            bundle.putInt("int_volume", w.c.i(antMessageParcel.a()[2]));
            bundle.putInt("int_totalTrackTime", w.c.k(antMessageParcel.a(), 3));
            bundle.putInt("int_currentTrackTime", w.c.k(antMessageParcel.a(), 5));
            if (!((w.c.i(antMessageParcel.a()[7]) & 128) > 0)) {
                boolean z2 = (w.c.i(antMessageParcel.a()[7]) & 4) > 0;
                boolean z3 = (w.c.i(antMessageParcel.a()[7]) & 2) > 0;
                o0.a aVar = new o0.a();
                aVar.f2745a = z2;
                aVar.f2746b = z3;
                aVar.b(bundle);
            }
            bundle.putInt("int_audioState", (w.c.i(antMessageParcel.a()[8]) & 240) >> 4);
            bundle.putInt("int_repeatState", (w.c.i(antMessageParcel.a()[8]) & 12) >> 2);
            bundle.putInt("int_shuffleState", w.c.i(antMessageParcel.a()[8]) & 3);
            this.f199i.a(bundle);
        }
    }

    @Override // w.b
    public List c() {
        return Arrays.asList(this.f199i);
    }

    @Override // w.b
    public List d() {
        return Arrays.asList(1);
    }

    public void f(Bundle bundle) {
        this.f197g = o0.a.a(bundle);
    }

    public void g(Bundle bundle) {
        this.f191a = bundle.getInt("int_volume");
        this.f192b = bundle.getInt("int_totalTrackTime");
        this.f193c = bundle.getInt("int_currentTrackTime");
        this.f194d = o0.b.c(bundle.getInt("int_audioState"));
        this.f195e = o0.c.c(bundle.getInt("int_repeatState"));
        this.f196f = o0.d.c(bundle.getInt("int_shuffleState"));
    }
}
