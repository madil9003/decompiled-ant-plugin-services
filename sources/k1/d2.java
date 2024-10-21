package k1;

/* loaded from: classes.dex */
public class d2 extends s1 {

    /* renamed from: g */
    protected static final s1 f2158g;

    static {
        s1 s1Var = new s1("monitoring_info", 103);
        f2158g = s1Var;
        s1Var.h(new s0("timestamp", 253, 134, 1.0d, 0.0d, "s", false, l2.DATE_TIME));
        s1Var.h(new s0("local_timestamp", 0, 134, 1.0d, 0.0d, "s", false, l2.LOCAL_DATE_TIME));
        s1Var.h(new s0("activity_type", 1, 0, 1.0d, 0.0d, "", false, l2.ACTIVITY_TYPE));
        l2 l2Var = l2.UINT16;
        s1Var.h(new s0("cycles_to_distance", 3, 132, 5000.0d, 0.0d, "m/cycle", false, l2Var));
        s1Var.h(new s0("cycles_to_calories", 4, 132, 5000.0d, 0.0d, "kcal/cycle", false, l2Var));
        s1Var.h(new s0("resting_metabolic_rate", 5, 132, 1.0d, 0.0d, "kcal / day", false, l2Var));
    }

    public d2(s1 s1Var) {
        super(s1Var);
    }
}
