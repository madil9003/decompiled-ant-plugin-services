package k1;

/* loaded from: classes.dex */
public class j3 extends s1 {

    /* renamed from: g */
    protected static final s1 f2200g;

    static {
        s1 s1Var = new s1("totals", 33);
        f2200g = s1Var;
        s1Var.h(new s0("message_index", 254, 132, 1.0d, 0.0d, "", false, l2.MESSAGE_INDEX));
        s1Var.h(new s0("timestamp", 253, 134, 1.0d, 0.0d, "s", false, l2.DATE_TIME));
        l2 l2Var = l2.UINT32;
        s1Var.h(new s0("timer_time", 0, 134, 1.0d, 0.0d, "s", false, l2Var));
        s1Var.h(new s0("distance", 1, 134, 1.0d, 0.0d, "m", false, l2Var));
        s1Var.h(new s0("calories", 2, 134, 1.0d, 0.0d, "kcal", false, l2Var));
        s1Var.h(new s0("sport", 3, 0, 1.0d, 0.0d, "", false, l2.SPORT));
        s1Var.h(new s0("elapsed_time", 4, 134, 1.0d, 0.0d, "s", false, l2Var));
        s1Var.h(new s0("sessions", 5, 132, 1.0d, 0.0d, "", false, l2.UINT16));
        s1Var.h(new s0("active_time", 6, 134, 1.0d, 0.0d, "s", false, l2Var));
        s1Var.h(new s0("sport_index", 9, 2, 1.0d, 0.0d, "", false, l2.UINT8));
    }

    public j3(s1 s1Var) {
        super(s1Var);
    }
}
