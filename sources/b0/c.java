package b0;

import android.os.Bundle;
import com.dsi.ant.message.ipc.AntMessageParcel;
import com.dsi.ant.plugins.antplus.pcc.controls.pccbase.AntPlusBaseRemoteControlPcc;
import java.util.Arrays;
import java.util.List;
import w.e;

/* loaded from: classes.dex */
public class c extends w.b implements e {

    /* renamed from: b */
    private u.a f201b = new u.a(233);

    /* renamed from: a */
    public AntPlusBaseRemoteControlPcc.ControlDeviceCapabilities f200a = new AntPlusBaseRemoteControlPcc.ControlDeviceCapabilities();

    @Override // w.e
    public void a(byte[] bArr) {
        bArr[0] = (byte) (((Integer) d().get(0)).intValue() & 255);
        if (this.f200a.c()) {
            bArr[1] = (byte) (bArr[1] | 128);
        } else {
            bArr[1] = (byte) (bArr[1] & Byte.MAX_VALUE);
        }
        bArr[2] = 0;
        bArr[3] = 0;
        bArr[4] = 0;
        bArr[5] = 0;
        bArr[6] = 0;
        if (this.f200a.a()) {
            bArr[7] = (byte) (bArr[7] | 1);
        } else {
            bArr[7] = (byte) (bArr[7] & 254);
        }
        if (this.f200a.b()) {
            bArr[7] = (byte) (bArr[7] | 16);
        } else {
            bArr[7] = (byte) (bArr[7] & 239);
        }
        if (this.f200a.d()) {
            bArr[7] = (byte) (bArr[7] | 32);
        } else {
            bArr[7] = (byte) (bArr[7] & 223);
        }
    }

    @Override // w.b
    public void b(long j2, long j3, AntMessageParcel antMessageParcel) {
        this.f200a.h((w.c.i(antMessageParcel.a()[2]) & 128) > 0);
        this.f200a.e((w.c.i(antMessageParcel.a()[8]) & 1) > 0);
        this.f200a.g((w.c.i(antMessageParcel.a()[8]) & 16) > 0);
        this.f200a.i((w.c.i(antMessageParcel.a()[8]) & 32) > 0);
        this.f200a.f((w.c.i(antMessageParcel.a()[8]) & 64) > 0);
        if (this.f201b.b()) {
            Bundle bundle = new Bundle();
            bundle.putLong("long_EstTimestamp", j2);
            bundle.putLong("long_EventFlags", j3);
            bundle.putParcelable("parcelable_ControlDeviceAvailabilities", this.f200a);
            this.f201b.a(bundle);
        }
    }

    @Override // w.b
    public List c() {
        return Arrays.asList(this.f201b);
    }

    @Override // w.b
    public List d() {
        return Arrays.asList(2);
    }
}
