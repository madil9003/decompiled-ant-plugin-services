package k1;

/* loaded from: classes.dex */
public class g3 extends s1 {

    /* renamed from: g */
    protected static final s1 f2182g;

    static {
        s1 s1Var = new s1("three_d_sensor_calibration", 167);
        f2182g = s1Var;
        s1Var.h(new s0("timestamp", 253, 134, 1.0d, 0.0d, "s", false, l2.DATE_TIME));
        s1Var.h(new s0("sensor_type", 0, 0, 1.0d, 0.0d, "", false, l2.SENSOR_TYPE));
        l2 l2Var = l2.UINT32;
        s1Var.h(new s0("calibration_factor", 1, 134, 1.0d, 0.0d, "", false, l2Var));
        ((s0) s1Var.f2382d.get(2)).f2376k.add(new d3("accel_cal_factor", 134, 1.0d, 0.0d, "g"));
        ((d3) ((s0) s1Var.f2382d.get(2)).f2376k.get(0)).b(0, 0L);
        ((s0) s1Var.f2382d.get(2)).f2376k.add(new d3("gyro_cal_factor", 134, 1.0d, 0.0d, "deg/s"));
        ((d3) ((s0) s1Var.f2382d.get(2)).f2376k.get(1)).b(0, 1L);
        s1Var.h(new s0("calibration_divisor", 2, 134, 1.0d, 0.0d, "counts", false, l2Var));
        s1Var.h(new s0("level_shift", 3, 134, 1.0d, 0.0d, "", false, l2Var));
        l2 l2Var2 = l2.SINT32;
        s1Var.h(new s0("offset_cal", 4, 133, 1.0d, 0.0d, "", false, l2Var2));
        s1Var.h(new s0("orientation_matrix", 5, 133, 65535.0d, 0.0d, "", false, l2Var2));
    }

    public g3(s1 s1Var) {
        super(s1Var);
    }
}
