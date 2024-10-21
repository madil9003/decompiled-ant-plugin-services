package k1;

/* loaded from: classes.dex */
public class h3 extends s1 {

    /* renamed from: g */
    protected static final s1 f2187g;

    static {
        s1 s1Var = new s1("time_in_zone", 216);
        f2187g = s1Var;
        s1Var.h(new s0("timestamp", 253, 134, 1.0d, 0.0d, "s", false, l2.DATE_TIME));
        s1Var.h(new s0("reference_mesg", 0, 132, 1.0d, 0.0d, "", false, l2.MESG_NUM));
        s1Var.h(new s0("reference_index", 1, 132, 1.0d, 0.0d, "", false, l2.MESSAGE_INDEX));
        l2 l2Var = l2.UINT32;
        s1Var.h(new s0("time_in_hr_zone", 2, 134, 1000.0d, 0.0d, "s", false, l2Var));
        s1Var.h(new s0("time_in_speed_zone", 3, 134, 1000.0d, 0.0d, "s", false, l2Var));
        s1Var.h(new s0("time_in_cadence_zone", 4, 134, 1000.0d, 0.0d, "s", false, l2Var));
        s1Var.h(new s0("time_in_power_zone", 5, 134, 1000.0d, 0.0d, "s", false, l2Var));
        l2 l2Var2 = l2.UINT8;
        s1Var.h(new s0("hr_zone_high_boundary", 6, 2, 1.0d, 0.0d, "bpm", false, l2Var2));
        l2 l2Var3 = l2.UINT16;
        s1Var.h(new s0("speed_zone_high_boundary", 7, 132, 1000.0d, 0.0d, "m/s", false, l2Var3));
        s1Var.h(new s0("cadence_zone_high_bondary", 8, 2, 1.0d, 0.0d, "rpm", false, l2Var2));
        s1Var.h(new s0("power_zone_high_boundary", 9, 132, 1.0d, 0.0d, "watts", false, l2Var3));
        s1Var.h(new s0("hr_calc_type", 10, 0, 1.0d, 0.0d, "", false, l2.HR_ZONE_CALC));
        s1Var.h(new s0("max_heart_rate", 11, 2, 1.0d, 0.0d, "", false, l2Var2));
        s1Var.h(new s0("resting_heart_rate", 12, 2, 1.0d, 0.0d, "", false, l2Var2));
        s1Var.h(new s0("threshold_heart_rate", 13, 2, 1.0d, 0.0d, "", false, l2Var2));
        s1Var.h(new s0("pwr_calc_type", 14, 0, 1.0d, 0.0d, "", false, l2.PWR_ZONE_CALC));
        s1Var.h(new s0("functional_threshold_power", 15, 132, 1.0d, 0.0d, "", false, l2Var3));
    }

    public h3(s1 s1Var) {
        super(s1Var);
    }
}
