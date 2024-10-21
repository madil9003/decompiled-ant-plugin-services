package k1;

/* loaded from: classes.dex */
public class f1 extends s1 {

    /* renamed from: g */
    protected static final s1 f2175g;

    static {
        s1 s1Var = new s1("goal", 15);
        f2175g = s1Var;
        s1Var.h(new s0("message_index", 254, 132, 1.0d, 0.0d, "", false, l2.MESSAGE_INDEX));
        s1Var.h(new s0("sport", 0, 0, 1.0d, 0.0d, "", false, l2.SPORT));
        s1Var.h(new s0("sub_sport", 1, 0, 1.0d, 0.0d, "", false, l2.SUB_SPORT));
        l2 l2Var = l2.DATE_TIME;
        s1Var.h(new s0("start_date", 2, 134, 1.0d, 0.0d, "", false, l2Var));
        s1Var.h(new s0("end_date", 3, 134, 1.0d, 0.0d, "", false, l2Var));
        s1Var.h(new s0("type", 4, 0, 1.0d, 0.0d, "", false, l2.GOAL));
        l2 l2Var2 = l2.UINT32;
        s1Var.h(new s0("value", 5, 134, 1.0d, 0.0d, "", false, l2Var2));
        l2 l2Var3 = l2.BOOL;
        s1Var.h(new s0("repeat", 6, 0, 1.0d, 0.0d, "", false, l2Var3));
        s1Var.h(new s0("target_value", 7, 134, 1.0d, 0.0d, "", false, l2Var2));
        s1Var.h(new s0("recurrence", 8, 0, 1.0d, 0.0d, "", false, l2.GOAL_RECURRENCE));
        s1Var.h(new s0("recurrence_value", 9, 132, 1.0d, 0.0d, "", false, l2.UINT16));
        s1Var.h(new s0("enabled", 10, 0, 1.0d, 0.0d, "", false, l2Var3));
        s1Var.h(new s0("source", 11, 0, 1.0d, 0.0d, "", false, l2.GOAL_SOURCE));
    }

    public f1(s1 s1Var) {
        super(s1Var);
    }
}
