package k1;

/* loaded from: classes.dex */
public class i extends s1 {

    /* renamed from: g */
    protected static final s1 f2188g;

    static {
        s1 s1Var = new s1("blood_pressure", 51);
        f2188g = s1Var;
        s1Var.h(new s0("timestamp", 253, 134, 1.0d, 0.0d, "s", false, l2.DATE_TIME));
        l2 l2Var = l2.UINT16;
        s1Var.h(new s0("systolic_pressure", 0, 132, 1.0d, 0.0d, "mmHg", false, l2Var));
        s1Var.h(new s0("diastolic_pressure", 1, 132, 1.0d, 0.0d, "mmHg", false, l2Var));
        s1Var.h(new s0("mean_arterial_pressure", 2, 132, 1.0d, 0.0d, "mmHg", false, l2Var));
        s1Var.h(new s0("map_3_sample_mean", 3, 132, 1.0d, 0.0d, "mmHg", false, l2Var));
        s1Var.h(new s0("map_morning_values", 4, 132, 1.0d, 0.0d, "mmHg", false, l2Var));
        s1Var.h(new s0("map_evening_values", 5, 132, 1.0d, 0.0d, "mmHg", false, l2Var));
        s1Var.h(new s0("heart_rate", 6, 2, 1.0d, 0.0d, "bpm", false, l2.UINT8));
        s1Var.h(new s0("heart_rate_type", 7, 0, 1.0d, 0.0d, "", false, l2.HR_TYPE));
        s1Var.h(new s0("status", 8, 0, 1.0d, 0.0d, "", false, l2.BP_STATUS));
        s1Var.h(new s0("user_profile_index", 9, 132, 1.0d, 0.0d, "", false, l2.MESSAGE_INDEX));
    }

    public i(s1 s1Var) {
        super(s1Var);
    }

    public Integer A() {
        return l(4, 0, 65535);
    }

    public Integer B() {
        return l(2, 0, 65535);
    }

    public k C() {
        Short n2 = n(8, 0, 65535);
        if (n2 == null) {
            return null;
        }
        return k.a(n2);
    }

    public Integer D() {
        return l(0, 0, 65535);
    }

    public Integer E() {
        return l(9, 0, 65535);
    }

    public w e() {
        return u(m(253, 0, 65535));
    }

    public Integer v() {
        return l(1, 0, 65535);
    }

    public Short w() {
        return n(6, 0, 65535);
    }

    public j1 x() {
        Short n2 = n(7, 0, 65535);
        if (n2 == null) {
            return null;
        }
        return j1.a(n2);
    }

    public Integer y() {
        return l(3, 0, 65535);
    }

    public Integer z() {
        return l(5, 0, 65535);
    }
}
