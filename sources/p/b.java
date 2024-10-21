package p;

import android.os.Bundle;
import com.dsi.ant.message.ipc.AntMessageParcel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class b extends w.b {

    /* renamed from: f */
    private static int f2861f = 12000;

    /* renamed from: c */
    private w.f f2864c;

    /* renamed from: e */
    private o.b f2866e;

    /* renamed from: a */
    private u.a f2862a = new u.a(201);

    /* renamed from: b */
    private u.a f2863b = new u.a(202);

    /* renamed from: d */
    private w.f f2865d = new w.f(65535, f2861f);

    public b(w.f fVar, o.b bVar) {
        this.f2864c = fVar;
        this.f2866e = bVar;
    }

    @Override // w.b
    public void b(long j2, long j3, AntMessageParcel antMessageParcel) {
        this.f2864c.h(w.c.i(antMessageParcel.a()[2]), j2);
        this.f2865d.h(w.c.k(antMessageParcel.a(), 5), j2);
        this.f2866e.g(j2, j3, this.f2864c, this.f2865d);
        this.f2866e.f(j2, j3, 16, this.f2864c, antMessageParcel);
        if (this.f2862a.b()) {
            Bundle bundle = new Bundle();
            bundle.putLong("long_EstTimestamp", j2);
            bundle.putLong("long_EventFlags", j3);
            bundle.putLong("long_powerOnlyUpdateEventCount", this.f2864c.c());
            bundle.putLong("long_accumulatedPower", this.f2865d.c());
            bundle.putInt("int_instantaneousPower", w.c.k(antMessageParcel.a(), 7));
            this.f2862a.a(bundle);
        }
        if (this.f2863b.b()) {
            int i2 = w.c.i(antMessageParcel.a()[3]);
            Bundle bundle2 = new Bundle();
            bundle2.putLong("long_EstTimestamp", j2);
            bundle2.putLong("long_EventFlags", j3);
            boolean z2 = false;
            int i3 = -1;
            if (i2 != 255) {
                int i4 = i2 & 127;
                if (i4 >= 0 && i4 <= 100) {
                    i3 = i4;
                }
                bundle2.putInt("int_pedalPowerPercentage", i3);
                if ((i2 & 128) != 0) {
                    z2 = true;
                }
            } else {
                bundle2.putInt("int_pedalPowerPercentage", -1);
            }
            bundle2.putBoolean("bool_rightPedalIndicator", z2);
            this.f2863b.a(bundle2);
        }
    }

    @Override // w.b
    public List c() {
        ArrayList arrayList = new ArrayList(this.f2866e.c());
        arrayList.add(this.f2862a);
        arrayList.add(this.f2863b);
        return arrayList;
    }

    @Override // w.b
    public List d() {
        return Arrays.asList(16);
    }
}
