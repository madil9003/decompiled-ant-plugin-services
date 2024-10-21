package b0;

import android.os.Bundle;
import com.dsi.ant.message.ipc.AntMessageParcel;
import java.util.Arrays;
import java.util.List;
import o0.i;
import w.e;

/* loaded from: classes.dex */
public class d extends w.b implements e {

    /* renamed from: a */
    public int f202a = 255;

    /* renamed from: b */
    public boolean f203b = false;

    /* renamed from: c */
    public int f204c = 65535;

    /* renamed from: d */
    public int f205d = 65535;

    /* renamed from: e */
    public i f206e = i.OFF;

    /* renamed from: f */
    public boolean f207f = false;

    /* renamed from: g */
    public boolean f208g = false;

    /* renamed from: h */
    private u.a f209h = new u.a(204);

    @Override // w.e
    public void a(byte[] bArr) {
        bArr[0] = (byte) (((Integer) d().get(0)).intValue() & 255);
        bArr[1] = (byte) (this.f202a & 255);
        int i2 = this.f204c;
        bArr[2] = (byte) (i2 & 255);
        bArr[3] = (byte) ((i2 >> 8) & 255);
        int i3 = this.f205d;
        bArr[4] = (byte) (i3 & 255);
        bArr[5] = (byte) ((i3 >> 8) & 255);
        bArr[6] = 0;
        if (this.f207f) {
            bArr[6] = (byte) (0 | 1);
        }
        if (this.f208g) {
            bArr[6] = (byte) (bArr[6] | 2);
        }
        bArr[7] = (byte) (this.f206e.b() & 255);
    }

    @Override // w.b
    public void b(long j2, long j3, AntMessageParcel antMessageParcel) {
        if (this.f209h.b()) {
            Bundle bundle = new Bundle();
            bundle.putLong("long_EstTimestamp", j2);
            bundle.putLong("long_EventFlags", j3);
            bundle.putInt("int_volume", w.c.i(antMessageParcel.a()[2]) & 127);
            bundle.putBoolean("bool_muted", (w.c.i(antMessageParcel.a()[2]) & 128) > 0);
            bundle.putInt("int_timeRemaining", w.c.k(antMessageParcel.a(), 3));
            bundle.putInt("int_timeProgressed", w.c.k(antMessageParcel.a(), 5));
            bundle.putBoolean("boolVideoPlaybackSupported", (w.c.i(antMessageParcel.a()[7]) & 2) > 0);
            bundle.putBoolean("boolVideoRecorderSupported", (w.c.i(antMessageParcel.a()[7]) & 1) > 0);
            bundle.putInt("int_videoState", w.c.i(antMessageParcel.a()[8]));
            this.f209h.a(bundle);
        }
    }

    @Override // w.b
    public List c() {
        return Arrays.asList(this.f209h);
    }

    @Override // w.b
    public List d() {
        return Arrays.asList(7);
    }

    public void f(Bundle bundle) {
        this.f207f = bundle.getBoolean("boolVideoPlaybackSupported");
        this.f208g = bundle.getBoolean("boolVideoRecorderSupported");
    }

    public void g(Bundle bundle) {
        this.f202a = bundle.getInt("int_volume");
        this.f203b = bundle.getBoolean("bool_muted");
        this.f204c = bundle.getInt("int_timeRemaining");
        this.f205d = bundle.getInt("int_timeProgressed");
        this.f206e = i.c(bundle.getInt("int_videoState"));
    }
}
