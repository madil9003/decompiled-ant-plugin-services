package o;

import android.os.Bundle;
import com.dsi.ant.message.ipc.AntMessageParcel;
import com.dsi.ant.plugins.antplus.pcc.AntPlusBikePowerPcc;
import com.dsi.ant.plugins.antplus.pcc.AntPlusFitnessEquipmentPcc;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class b extends w.b {

    /* renamed from: w */
    private static final String f2711w = "b";

    /* renamed from: a */
    private final u.a f2712a;

    /* renamed from: b */
    private final String f2713b;

    /* renamed from: c */
    private final String f2714c;

    /* renamed from: d */
    private final u.a f2715d;

    /* renamed from: e */
    private final String f2716e;

    /* renamed from: f */
    private final String f2717f;

    /* renamed from: g */
    private final u.a f2718g;

    /* renamed from: h */
    private final String f2719h;

    /* renamed from: i */
    private final String f2720i;

    /* renamed from: j */
    private final u.a f2721j;

    /* renamed from: k */
    private final String f2722k;

    /* renamed from: l */
    private final String f2723l;

    /* renamed from: m */
    private final int f2724m;

    /* renamed from: n */
    private u.a f2725n;

    /* renamed from: o */
    private u.a f2726o;

    /* renamed from: p */
    private c f2727p;

    /* renamed from: q */
    private boolean f2728q;

    /* renamed from: r */
    private boolean f2729r;

    /* renamed from: s */
    private boolean f2730s;

    /* renamed from: t */
    private boolean f2731t;

    /* renamed from: u */
    private boolean f2732u;

    /* renamed from: v */
    private long f2733v;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a */
        static final /* synthetic */ int[] f2734a;

        /* renamed from: b */
        static final /* synthetic */ int[] f2735b;

        static {
            int[] iArr = new int[AntPlusFitnessEquipmentPcc.b.values().length];
            f2735b = iArr;
            try {
                iArr[AntPlusFitnessEquipmentPcc.b.TRAINER_TORQUE_DATA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            int[] iArr2 = new int[AntPlusBikePowerPcc.f.values().length];
            f2734a = iArr2;
            try {
                iArr2[AntPlusBikePowerPcc.f.CRANK_TORQUE_DATA.ordinal()] = 1;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2734a[AntPlusBikePowerPcc.f.WHEEL_TORQUE_DATA.ordinal()] = 2;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2734a[AntPlusBikePowerPcc.f.CTF_DATA.ordinal()] = 3;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public b() {
        this.f2728q = false;
        this.f2729r = false;
        this.f2730s = false;
        this.f2731t = false;
        this.f2732u = false;
        this.f2712a = new u.a(217);
        this.f2713b = "int_dataSource";
        this.f2714c = "decimal_calculatedPower";
        this.f2715d = new u.a(218);
        this.f2716e = "int_dataSource";
        this.f2717f = "decimal_calculatedTorque";
        this.f2718g = new u.a(215);
        this.f2719h = "int_dataSource";
        this.f2720i = "decimal_calculatedSpeed";
        this.f2721j = new u.a(216);
        this.f2722k = "int_dataSource";
        this.f2723l = "decimal_calculatedDistance";
        this.f2724m = AntPlusFitnessEquipmentPcc.b.COAST_OR_STOP_DETECTED.b();
    }

    private int j(int i2) {
        AntPlusFitnessEquipmentPcc.b bVar;
        AntPlusBikePowerPcc.f fVar;
        AntPlusBikePowerPcc.f c3 = AntPlusBikePowerPcc.f.c(i2);
        AntPlusFitnessEquipmentPcc.b c4 = AntPlusFitnessEquipmentPcc.b.c(i2);
        if (this.f2727p == null) {
            if (this.f2730s) {
                this.f2730s = false;
                if (a.f2735b[c4.ordinal()] == 1) {
                    bVar = AntPlusFitnessEquipmentPcc.b.INITIAL_VALUE_TRAINER_TORQUE_DATA;
                }
                bVar = AntPlusFitnessEquipmentPcc.b.UNRECOGNIZED;
            } else {
                if (a.f2735b[c4.ordinal()] == 1) {
                    bVar = AntPlusFitnessEquipmentPcc.b.TRAINER_TORQUE_DATA;
                }
                bVar = AntPlusFitnessEquipmentPcc.b.UNRECOGNIZED;
            }
            return bVar.b();
        }
        if (this.f2730s) {
            this.f2730s = false;
            int i3 = a.f2734a[c3.ordinal()];
            if (i3 == 1) {
                fVar = AntPlusBikePowerPcc.f.INITIAL_VALUE_CRANK_TORQUE_DATA;
            } else if (i3 != 2) {
                if (i3 == 3) {
                    fVar = AntPlusBikePowerPcc.f.INITIAL_VALUE_CTF_DATA;
                }
                fVar = AntPlusBikePowerPcc.f.UNRECOGNIZED;
            } else {
                fVar = AntPlusBikePowerPcc.f.INITIAL_VALUE_WHEEL_TORQUE_DATA;
            }
        } else {
            int i4 = a.f2734a[c3.ordinal()];
            if (i4 == 1) {
                fVar = AntPlusBikePowerPcc.f.CRANK_TORQUE_DATA;
            } else if (i4 != 2) {
                if (i4 == 3) {
                    fVar = AntPlusBikePowerPcc.f.CTF_DATA;
                }
                fVar = AntPlusBikePowerPcc.f.UNRECOGNIZED;
            } else {
                fVar = AntPlusBikePowerPcc.f.WHEEL_TORQUE_DATA;
            }
        }
        return fVar.b();
    }

    private boolean k(long j2, w.a aVar, int i2) {
        if (aVar.b() != 0 || (i2 == AntPlusBikePowerPcc.f.INITIAL_VALUE_CRANK_TORQUE_DATA.b() && i2 == AntPlusBikePowerPcc.f.INITIAL_VALUE_WHEEL_TORQUE_DATA.b() && i2 == AntPlusFitnessEquipmentPcc.b.INITIAL_VALUE_TRAINER_TORQUE_DATA.b() && i2 == AntPlusBikePowerPcc.f.INITIAL_VALUE_CTF_DATA.b())) {
            this.f2731t = false;
            this.f2732u = false;
        } else {
            if (!this.f2731t) {
                this.f2731t = true;
                this.f2733v = j2;
                return true;
            }
            if (this.f2732u || j2 - this.f2733v < 2875) {
                return true;
            }
            this.f2732u = true;
        }
        return false;
    }

    @Override // w.b
    public void b(long j2, long j3, AntMessageParcel antMessageParcel) {
    }

    @Override // w.b
    public List c() {
        return this.f2727p != null ? Arrays.asList(this.f2712a, this.f2715d, this.f2725n, this.f2718g, this.f2721j, this.f2726o) : Arrays.asList(this.f2712a, this.f2715d, this.f2718g, this.f2721j);
    }

    @Override // w.b
    public List d() {
        return null;
    }

    @Override // w.b
    public void e() {
    }

    public void f(long j2, long j3, int i2, w.a aVar, AntMessageParcel antMessageParcel) {
        if ((i2 == 16 && this.f2728q) || !this.f2726o.b() || aVar.b() == 0) {
            return;
        }
        int i3 = w.c.i(antMessageParcel.a()[4]);
        Bundle bundle = new Bundle();
        bundle.putLong("long_EstTimestamp", j2);
        bundle.putLong("long_EventFlags", j3);
        if (i3 != 255) {
            bundle.putInt("int_instantaneousCadence", i3);
        } else {
            bundle.putInt("int_instantaneousCadence", -1);
        }
        bundle.putInt("int_dataSource", w.c.i(antMessageParcel.a()[1]));
        this.f2726o.a(bundle);
    }

    public void g(long j2, long j3, w.a aVar, w.a aVar2) {
        String str;
        int b3;
        try {
            if (!aVar.d() && !aVar2.d()) {
                if (this.f2712a.b() && !this.f2728q) {
                    if (aVar.b() == 0) {
                        if (!this.f2731t) {
                            this.f2731t = true;
                            this.f2733v = j2;
                            return;
                        } else {
                            if (this.f2732u || j2 - this.f2733v < 2875) {
                                return;
                            }
                            Bundle bundle = new Bundle();
                            bundle.putLong("long_EstTimestamp", j2);
                            bundle.putLong("long_EventFlags", j3);
                            bundle.putInt(this.f2713b, this.f2724m);
                            bundle.putSerializable(this.f2714c, new BigDecimal("0").setScale(5));
                            this.f2712a.a(bundle);
                            this.f2732u = true;
                            return;
                        }
                    }
                    this.f2731t = false;
                    this.f2732u = false;
                    Bundle bundle2 = new Bundle();
                    bundle2.putLong("long_EstTimestamp", j2);
                    bundle2.putLong("long_EventFlags", j3);
                    if (this.f2729r) {
                        this.f2729r = false;
                        if (this.f2727p != null) {
                            str = this.f2713b;
                            b3 = AntPlusBikePowerPcc.f.INITIAL_VALUE_POWER_ONLY_DATA.b();
                        } else {
                            str = this.f2713b;
                            b3 = AntPlusFitnessEquipmentPcc.b.INITIAL_VALUE_TRAINER_DATA.b();
                        }
                    } else if (this.f2727p != null) {
                        str = this.f2713b;
                        b3 = AntPlusBikePowerPcc.f.POWER_ONLY_DATA.b();
                    } else {
                        str = this.f2713b;
                        b3 = AntPlusFitnessEquipmentPcc.b.TRAINER_DATA.b();
                    }
                    bundle2.putInt(str, b3);
                    bundle2.putSerializable(this.f2714c, new BigDecimal(aVar2.b()).divide(new BigDecimal(aVar.b()), 5, RoundingMode.HALF_UP));
                    this.f2712a.a(bundle2);
                    return;
                }
                return;
            }
            this.f2729r = true;
            this.f2731t = false;
            this.f2732u = false;
        } catch (ArithmeticException e3) {
            h1.a.b(f2711w, "Sensor sent an unexpected value: " + e3.toString());
        }
    }

    public void h(long j2, long j3, int i2, w.a aVar, w.a aVar2, w.a aVar3, w.a aVar4) {
        int i3;
        int i4;
        BigDecimal scale;
        BigDecimal scale2;
        BigDecimal scale3;
        try {
            int j4 = j(i2);
            this.f2728q = true;
            if (!aVar.d() && !aVar2.d() && !aVar3.d() && !aVar4.d()) {
                if (k(j2, aVar, j4)) {
                    return;
                }
                if (this.f2712a.b()) {
                    Bundle bundle = new Bundle();
                    bundle.putLong("long_EstTimestamp", j2);
                    bundle.putLong("long_EventFlags", j3);
                    bundle.putInt(this.f2713b, j4);
                    if (aVar3.b() != 0 && !this.f2732u) {
                        i3 = j4;
                        scale3 = new BigDecimal(128).multiply(new BigDecimal(3.141592653589793d)).multiply(new BigDecimal(aVar4.b())).divide(new BigDecimal(aVar3.b()), 9, RoundingMode.HALF_UP);
                        bundle.putSerializable(this.f2714c, scale3);
                        this.f2712a.a(bundle);
                    }
                    i3 = j4;
                    scale3 = new BigDecimal("0").setScale(9);
                    bundle.putSerializable(this.f2714c, scale3);
                    this.f2712a.a(bundle);
                } else {
                    i3 = j4;
                }
                if (this.f2715d.b()) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putLong("long_EstTimestamp", j2);
                    bundle2.putLong("long_EventFlags", j3);
                    i4 = i3;
                    bundle2.putInt(this.f2716e, i4);
                    bundle2.putSerializable(this.f2717f, this.f2732u ? new BigDecimal("0").setScale(13) : new BigDecimal(aVar4.b()).divide(new BigDecimal(32), 15, RoundingMode.HALF_UP).divide(new BigDecimal(aVar.b()), 13, RoundingMode.HALF_UP));
                    this.f2715d.a(bundle2);
                } else {
                    i4 = i3;
                }
                if (i2 == AntPlusBikePowerPcc.f.WHEEL_TORQUE_DATA.b() || i2 == AntPlusFitnessEquipmentPcc.b.TRAINER_TORQUE_DATA.b()) {
                    if (this.f2718g.b()) {
                        Bundle bundle3 = new Bundle();
                        bundle3.putLong("long_EstTimestamp", j2);
                        bundle3.putLong("long_EventFlags", j3);
                        bundle3.putInt(this.f2719h, i4);
                        if (aVar3.b() != 0 && !this.f2732u) {
                            scale = new BigDecimal(73728).multiply(new BigDecimal(aVar.b())).divide(new BigDecimal(10), 6, RoundingMode.HALF_UP).divide(new BigDecimal(aVar3.b()), 4, RoundingMode.HALF_UP);
                            bundle3.putSerializable(this.f2720i, scale);
                            this.f2718g.a(bundle3);
                        }
                        scale = new BigDecimal("0").setScale(4);
                        bundle3.putSerializable(this.f2720i, scale);
                        this.f2718g.a(bundle3);
                    }
                    if (this.f2721j.b()) {
                        Bundle bundle4 = new Bundle();
                        bundle4.putLong("long_EstTimestamp", j2);
                        bundle4.putLong("long_EventFlags", j3);
                        bundle4.putInt(this.f2722k, i4);
                        bundle4.putSerializable(this.f2723l, new BigDecimal(aVar2.c()));
                        this.f2721j.a(bundle4);
                    }
                }
                if (i2 == AntPlusBikePowerPcc.f.CRANK_TORQUE_DATA.b() && this.f2725n.b()) {
                    Bundle bundle5 = new Bundle();
                    bundle5.putLong("long_EstTimestamp", j2);
                    bundle5.putLong("long_EventFlags", j3);
                    bundle5.putInt("int_dataSource", i4);
                    if (aVar3.b() != 0 && !this.f2732u) {
                        scale2 = new BigDecimal(122880).multiply(new BigDecimal(aVar.b())).divide(new BigDecimal(aVar3.b()), 3, RoundingMode.HALF_UP);
                        bundle5.putSerializable("decimal_calculatedCrankCadence", scale2);
                        this.f2725n.a(bundle5);
                        return;
                    }
                    scale2 = new BigDecimal("0").setScale(3);
                    bundle5.putSerializable("decimal_calculatedCrankCadence", scale2);
                    this.f2725n.a(bundle5);
                    return;
                }
                return;
            }
            this.f2730s = true;
        } catch (ArithmeticException e3) {
            h1.a.b(f2711w, "Sensor sent an unexpected value: " + e3.toString());
        }
    }

    public void i(long j2, long j3, w.a aVar, int i2, w.a aVar2, w.a aVar3) {
        AntPlusBikePowerPcc.f fVar;
        String str;
        BigDecimal scale;
        BigDecimal scale2;
        BigDecimal scale3;
        if (this.f2727p == null) {
            return;
        }
        try {
            int j4 = j(AntPlusBikePowerPcc.f.CTF_DATA.b());
            AntPlusBikePowerPcc.f fVar2 = AntPlusBikePowerPcc.f.INVALID_CTF_CAL_REQ;
            fVar2.b();
            int P = this.f2727p.P();
            if (P == fVar2.b()) {
                j4 = fVar2.b();
            }
            this.f2728q = true;
            if (!aVar.d() && !aVar2.d() && !aVar3.d()) {
                if (k(j2, aVar, j4)) {
                    return;
                }
                if (this.f2712a.b()) {
                    Bundle bundle = new Bundle();
                    bundle.putLong("long_EstTimestamp", j2);
                    bundle.putLong("long_EventFlags", j3);
                    bundle.putInt(this.f2713b, j4);
                    if (P == fVar2.b()) {
                        scale3 = new BigDecimal("-1");
                        fVar = fVar2;
                        str = "-1";
                    } else {
                        if (!this.f2732u && aVar2.b() != 0 && i2 != 0) {
                            str = "-1";
                            fVar = fVar2;
                            scale3 = new BigDecimal(aVar3.b()).multiply(new BigDecimal(2000)).divide(new BigDecimal(aVar2.b()), 11, RoundingMode.HALF_UP).subtract(new BigDecimal(P)).multiply(new BigDecimal(40000)).multiply(new BigDecimal(3.141592653589793d)).multiply(new BigDecimal(aVar.b())).divide(new BigDecimal(i2), 11, RoundingMode.HALF_UP).divide(new BigDecimal(aVar2.b()), 11, RoundingMode.HALF_UP);
                        }
                        fVar = fVar2;
                        str = "-1";
                        scale3 = new BigDecimal("0").setScale(11);
                    }
                    bundle.putSerializable(this.f2714c, scale3);
                    this.f2712a.a(bundle);
                } else {
                    fVar = fVar2;
                    str = "-1";
                }
                if (this.f2715d.b()) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putLong("long_EstTimestamp", j2);
                    bundle2.putLong("long_EventFlags", j3);
                    bundle2.putInt(this.f2716e, j4);
                    if (P == fVar.b()) {
                        scale2 = new BigDecimal(str);
                    } else {
                        if (!this.f2732u && aVar2.b() != 0 && i2 != 0) {
                            scale2 = new BigDecimal(aVar3.b()).multiply(new BigDecimal(2000)).divide(new BigDecimal(aVar2.b()), 15, RoundingMode.HALF_UP).subtract(new BigDecimal(P)).multiply(new BigDecimal(10)).divide(new BigDecimal(i2), 13, RoundingMode.HALF_UP);
                        }
                        scale2 = new BigDecimal("0").setScale(13);
                    }
                    bundle2.putSerializable(this.f2717f, scale2);
                    this.f2715d.a(bundle2);
                }
                if (this.f2725n.b()) {
                    Bundle bundle3 = new Bundle();
                    bundle3.putLong("long_EstTimestamp", j2);
                    bundle3.putLong("long_EventFlags", j3);
                    bundle3.putInt("int_dataSource", j4);
                    if (aVar2.b() != 0 && !this.f2732u) {
                        scale = new BigDecimal(120000).multiply(new BigDecimal(aVar.b())).divide(new BigDecimal(aVar2.b()), 3, RoundingMode.HALF_UP);
                        bundle3.putSerializable("decimal_calculatedCrankCadence", scale);
                        this.f2725n.a(bundle3);
                        return;
                    }
                    scale = new BigDecimal("0").setScale(3);
                    bundle3.putSerializable("decimal_calculatedCrankCadence", scale);
                    this.f2725n.a(bundle3);
                    return;
                }
                return;
            }
            this.f2730s = true;
        } catch (ArithmeticException e3) {
            h1.a.b(f2711w, "Sensor sent an unexpected value: " + e3.toString());
        }
    }

    public b(c cVar) {
        this.f2728q = false;
        this.f2729r = false;
        this.f2730s = false;
        this.f2731t = false;
        this.f2732u = false;
        this.f2727p = cVar;
        this.f2712a = new u.a(211);
        this.f2713b = "int_dataSource";
        this.f2714c = "decimal_calculatedPower";
        this.f2715d = new u.a(212);
        this.f2716e = "int_dataSource";
        this.f2717f = "decimal_calculatedTorque";
        this.f2718g = new u.a(214);
        this.f2719h = "int_dataSource";
        this.f2720i = "decimal_calculatedWheelSpeed";
        this.f2721j = new u.a(215);
        this.f2722k = "int_dataSource";
        this.f2723l = "decimal_calculatedWheelDistance";
        this.f2725n = new u.a(213);
        this.f2726o = new u.a(203);
        this.f2724m = AntPlusBikePowerPcc.f.COAST_OR_STOP_DETECTED.b();
    }
}
