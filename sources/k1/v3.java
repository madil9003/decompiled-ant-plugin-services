package k1;

/* loaded from: classes.dex */
public class v3 extends s1 {

    /* renamed from: g */
    protected static final s1 f2457g;

    static {
        s1 s1Var = new s1("workout", 26);
        f2457g = s1Var;
        s1Var.h(new s0("sport", 4, 0, 1.0d, 0.0d, "", false, l2.SPORT));
        s1Var.h(new s0("capabilities", 5, 140, 1.0d, 0.0d, "", false, l2.WORKOUT_CAPABILITIES));
        l2 l2Var = l2.UINT16;
        s1Var.h(new s0("num_valid_steps", 6, 132, 1.0d, 0.0d, "", false, l2Var));
        s1Var.h(new s0("wkt_name", 8, 7, 1.0d, 0.0d, "", false, l2.STRING));
        s1Var.h(new s0("sub_sport", 11, 0, 1.0d, 0.0d, "", false, l2.SUB_SPORT));
        s1Var.h(new s0("pool_length", 14, 132, 100.0d, 0.0d, "m", false, l2Var));
        s1Var.h(new s0("pool_length_unit", 15, 0, 1.0d, 0.0d, "", false, l2.DISPLAY_MEASURE));
    }

    public v3(s1 s1Var) {
        super(s1Var);
    }
}
