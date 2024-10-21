package e0;

import android.util.Log;
import com.dsi.ant.message.ipc.AntMessageParcel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import w.c;

/* loaded from: classes.dex */
public class a extends w.b {

    /* renamed from: a */
    d0.a f1648a;

    public a(d0.a aVar) {
        this.f1648a = aVar;
    }

    @Override // w.b
    public void b(long j2, long j3, AntMessageParcel antMessageParcel) {
        d0.a aVar;
        int i2;
        int i3 = c.i(antMessageParcel.a()[4]) & 3;
        if (i3 == 0) {
            aVar = this.f1648a;
            i2 = 65535;
        } else if (i3 != 1) {
            Log.d("EnvironmentDevice", "Unknown transmission rate flags in trans info byte (" + ((int) antMessageParcel.a()[4]) + ") , defaulting to 1Hz");
            aVar = this.f1648a;
            i2 = 32768;
        } else {
            aVar = this.f1648a;
            i2 = 8192;
        }
        aVar.B(i2);
    }

    @Override // w.b
    public List c() {
        return new ArrayList();
    }

    @Override // w.b
    public List d() {
        return Arrays.asList(0);
    }

    @Override // w.b
    public void e() {
    }
}
