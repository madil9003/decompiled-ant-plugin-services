package b0;

import android.os.Bundle;
import com.dsi.ant.message.ipc.AntMessageParcel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import o0.f;
import w.e;

/* loaded from: classes.dex */
public class a extends w.b implements e {

    /* renamed from: a */
    public int f184a;

    /* renamed from: b */
    public byte f185b;

    /* renamed from: c */
    public int f186c;

    /* renamed from: d */
    public o0.e f187d;

    /* renamed from: e */
    public boolean f188e = false;

    /* renamed from: f */
    u.a f189f = new u.a(202);

    /* renamed from: g */
    u.a f190g = new u.a(203);

    public static void f(x.c cVar, Bundle bundle, boolean z2) {
        cVar.f3524a = 16;
        cVar.f3525b = bundle.getInt("int_sequenceNumber");
        cVar.f3526c = f.c(bundle.getInt("int_commandStatus"));
        int i2 = bundle.getInt("int_commandNumber");
        byte[] bArr = cVar.f3527d;
        bArr[0] = (byte) (i2 | (z2 ? 128 : 0));
        bArr[3] = -1;
        bArr[2] = -1;
        bArr[1] = -1;
    }

    @Override // w.e
    public void a(byte[] bArr) {
        bArr[0] = (byte) (((Integer) d().get(0)).intValue() & 255);
        int i2 = this.f184a;
        bArr[1] = (byte) (i2 & 255);
        bArr[2] = (byte) ((i2 & 65280) >> 8);
        bArr[3] = this.f185b;
        bArr[4] = -1;
        bArr[5] = -1;
        bArr[6] = (byte) this.f186c;
        byte b3 = (byte) this.f187d.b();
        bArr[7] = b3;
        if (this.f188e) {
            bArr[7] = (byte) (b3 | Byte.MIN_VALUE);
        }
    }

    @Override // w.b
    public void b(long j2, long j3, AntMessageParcel antMessageParcel) {
        Boolean valueOf = Boolean.valueOf((antMessageParcel.a()[8] & 128) > 0);
        if (this.f189f.b() || this.f190g.b()) {
            Bundle bundle = new Bundle();
            bundle.putLong("long_EstTimestamp", j2);
            bundle.putLong("long_EventFlags", j3);
            bundle.putInt("int_serialNumber", w.c.k(antMessageParcel.a(), 2));
            bundle.putInt("int_sequenceNumber", w.c.i(antMessageParcel.a()[4]));
            bundle.putInt("int_commandNumber", antMessageParcel.a()[8] & Byte.MAX_VALUE);
            bundle.putInt("int_commandData", w.c.i(antMessageParcel.a()[7]));
            (valueOf.booleanValue() ? this.f190g : this.f189f).a(bundle);
        }
    }

    @Override // w.b
    public List c() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f189f);
        arrayList.add(this.f190g);
        return arrayList;
    }

    @Override // w.b
    public List d() {
        return Arrays.asList(16);
    }
}
