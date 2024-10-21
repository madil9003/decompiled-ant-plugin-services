package k1;

/* loaded from: classes.dex */
public class y3 extends s1 {

    /* renamed from: g */
    protected static final s1 f2536g;

    static {
        s1 s1Var = new s1("zones_target", 7);
        f2536g = s1Var;
        l2 l2Var = l2.UINT8;
        s1Var.h(new s0("max_heart_rate", 1, 2, 1.0d, 0.0d, "", false, l2Var));
        s1Var.h(new s0("threshold_heart_rate", 2, 2, 1.0d, 0.0d, "", false, l2Var));
        s1Var.h(new s0("functional_threshold_power", 3, 132, 1.0d, 0.0d, "", false, l2.UINT16));
        s1Var.h(new s0("hr_calc_type", 5, 0, 1.0d, 0.0d, "", false, l2.HR_ZONE_CALC));
        s1Var.h(new s0("pwr_calc_type", 7, 0, 1.0d, 0.0d, "", false, l2.PWR_ZONE_CALC));
    }

    public y3(s1 s1Var) {
        super(s1Var);
    }
}
