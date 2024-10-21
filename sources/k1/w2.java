package k1;

/* loaded from: classes.dex */
public class w2 extends s1 {

    /* renamed from: g */
    protected static final s1 f2467g;

    static {
        s1 s1Var = new s1("set", 225);
        f2467g = s1Var;
        l2 l2Var = l2.DATE_TIME;
        s1Var.h(new s0("timestamp", 254, 134, 1.0d, 0.0d, "", false, l2Var));
        s1Var.h(new s0("duration", 0, 134, 1000.0d, 0.0d, "s", false, l2.UINT32));
        l2 l2Var2 = l2.UINT16;
        s1Var.h(new s0("repetitions", 3, 132, 1.0d, 0.0d, "", false, l2Var2));
        s1Var.h(new s0("weight", 4, 132, 16.0d, 0.0d, "kg", false, l2Var2));
        s1Var.h(new s0("set_type", 5, 2, 1.0d, 0.0d, "", false, l2.SET_TYPE));
        s1Var.h(new s0("start_time", 6, 134, 1.0d, 0.0d, "", false, l2Var));
        s1Var.h(new s0("category", 7, 132, 1.0d, 0.0d, "", false, l2.EXERCISE_CATEGORY));
        s1Var.h(new s0("category_subtype", 8, 132, 1.0d, 0.0d, "", false, l2Var2));
        s1Var.h(new s0("weight_display_unit", 9, 132, 1.0d, 0.0d, "", false, l2.FIT_BASE_UNIT));
        l2 l2Var3 = l2.MESSAGE_INDEX;
        s1Var.h(new s0("message_index", 10, 132, 1.0d, 0.0d, "", false, l2Var3));
        s1Var.h(new s0("wkt_step_index", 11, 132, 1.0d, 0.0d, "", false, l2Var3));
    }

    public w2(s1 s1Var) {
        super(s1Var);
    }
}
