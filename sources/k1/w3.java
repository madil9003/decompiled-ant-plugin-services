package k1;

/* loaded from: classes.dex */
public class w3 extends s1 {

    /* renamed from: g */
    protected static final s1 f2468g;

    static {
        s1 s1Var = new s1("workout_session", 158);
        f2468g = s1Var;
        s1Var.h(new s0("message_index", 254, 132, 1.0d, 0.0d, "", false, l2.MESSAGE_INDEX));
        s1Var.h(new s0("sport", 0, 0, 1.0d, 0.0d, "", false, l2.SPORT));
        s1Var.h(new s0("sub_sport", 1, 0, 1.0d, 0.0d, "", false, l2.SUB_SPORT));
        l2 l2Var = l2.UINT16;
        s1Var.h(new s0("num_valid_steps", 2, 132, 1.0d, 0.0d, "", false, l2Var));
        s1Var.h(new s0("first_step_index", 3, 132, 1.0d, 0.0d, "", false, l2Var));
        s1Var.h(new s0("pool_length", 4, 132, 100.0d, 0.0d, "m", false, l2Var));
        s1Var.h(new s0("pool_length_unit", 5, 0, 1.0d, 0.0d, "", false, l2.DISPLAY_MEASURE));
    }

    public w3(s1 s1Var) {
        super(s1Var);
    }
}
