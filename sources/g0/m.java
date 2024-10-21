package g0;

import android.os.Bundle;
import com.dsi.ant.message.ipc.AntMessageParcel;
import com.dsi.ant.plugins.antplus.pcc.AntPlusFitnessEquipmentPcc;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;

/* loaded from: classes.dex */
public class m extends w.b {

    /* renamed from: c */
    private a f1776c;

    /* renamed from: d */
    private o.b f1777d;

    /* renamed from: a */
    private u.a f1774a = new u.a(212);

    /* renamed from: b */
    private u.a f1775b = new u.a(213);

    /* renamed from: e */
    private w.f f1778e = new w.f(255, 12000);

    /* renamed from: f */
    private w.f f1779f = new w.f(65535, 12000);

    public m(a aVar, o.b bVar) {
        this.f1776c = aVar;
        this.f1777d = bVar;
    }

    @Override // w.b
    public void b(long j2, long j3, AntMessageParcel antMessageParcel) {
        this.f1776c.b(j2, j3, antMessageParcel);
        int k2 = w.c.k(antMessageParcel.a(), 4);
        this.f1778e.h(w.c.i(antMessageParcel.a()[2]), j2);
        int k3 = w.c.k(antMessageParcel.a(), 6) & 4095;
        if (k3 != 4095) {
            this.f1779f.h(k2, j2);
            this.f1777d.g(j2, j3, this.f1778e, this.f1779f);
        }
        if (this.f1774a.b()) {
            Bundle bundle = new Bundle();
            bundle.putLong("long_EstTimestamp", j2);
            bundle.putLong("long_EventFlags", j3);
            bundle.putLong("long_updateEventCount", this.f1778e.c());
            int i2 = w.c.i(antMessageParcel.a()[3]);
            if (i2 == 255) {
                i2 = -1;
            }
            bundle.putInt("int_instantaneousCadence", i2);
            bundle.putLong("long_accumulatedPower", k3 != 4095 ? this.f1779f.c() : -1L);
            if (k3 == 4095) {
                k3 = -1;
            }
            bundle.putInt("int_instantaneousPower", k3);
            this.f1774a.a(bundle);
        }
        if (this.f1775b.b()) {
            Bundle bundle2 = new Bundle();
            bundle2.putLong("long_EstTimestamp", j2);
            bundle2.putLong("long_EventFlags", j3);
            EnumSet noneOf = EnumSet.noneOf(AntPlusFitnessEquipmentPcc.c.class);
            if ((antMessageParcel.a()[7] & 16) != 0) {
                noneOf.add(AntPlusFitnessEquipmentPcc.c.BICYCLE_POWER_CALIBRATION_REQUIRED);
            }
            if ((antMessageParcel.a()[7] & 32) != 0) {
                noneOf.add(AntPlusFitnessEquipmentPcc.c.RESISTANCE_CALIBRATION_REQUIRED);
            }
            if ((antMessageParcel.a()[7] & 64) != 0) {
                noneOf.add(AntPlusFitnessEquipmentPcc.c.USER_CONFIGURATION_REQUIRED);
            }
            if ((antMessageParcel.a()[8] & 1) != 0) {
                noneOf.add(AntPlusFitnessEquipmentPcc.c.MAXIMUM_POWER_LIMIT_REACHED);
            }
            if ((antMessageParcel.a()[8] & 2) != 0) {
                noneOf.add(AntPlusFitnessEquipmentPcc.c.MINIMUM_POWER_LIMIT_REACHED);
            }
            bundle2.putLong("long_trainerStatusFlags", AntPlusFitnessEquipmentPcc.c.b(noneOf));
            this.f1775b.a(bundle2);
        }
    }

    @Override // w.b
    public List c() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f1774a);
        arrayList.add(this.f1775b);
        arrayList.addAll(this.f1777d.c());
        return arrayList;
    }

    @Override // w.b
    public List d() {
        return Arrays.asList(25);
    }
}
