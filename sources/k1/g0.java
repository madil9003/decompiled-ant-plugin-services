package k1;

/* loaded from: classes.dex */
public class g0 extends s1 {

    /* renamed from: g */
    protected static final s1 f2179g;

    static {
        s1 s1Var = new s1("dive_apnea_alarm", 393);
        f2179g = s1Var;
        s1Var.h(new s0("message_index", 254, 132, 1.0d, 0.0d, "", false, l2.MESSAGE_INDEX));
        l2 l2Var = l2.UINT32;
        s1Var.h(new s0("depth", 0, 134, 1000.0d, 0.0d, "m", false, l2Var));
        l2 l2Var2 = l2.SINT32;
        s1Var.h(new s0("time", 1, 133, 1.0d, 0.0d, "s", false, l2Var2));
        l2 l2Var3 = l2.BOOL;
        s1Var.h(new s0("enabled", 2, 0, 1.0d, 0.0d, "", false, l2Var3));
        s1Var.h(new s0("alarm_type", 3, 0, 1.0d, 0.0d, "", false, l2.DIVE_ALARM_TYPE));
        s1Var.h(new s0("sound", 4, 0, 1.0d, 0.0d, "", false, l2.TONE));
        s1Var.h(new s0("dive_types", 5, 0, 1.0d, 0.0d, "", false, l2.SUB_SPORT));
        s1Var.h(new s0("id", 6, 134, 1.0d, 0.0d, "", false, l2Var));
        s1Var.h(new s0("popup_enabled", 7, 0, 1.0d, 0.0d, "", false, l2Var3));
        s1Var.h(new s0("trigger_on_descent", 8, 0, 1.0d, 0.0d, "", false, l2Var3));
        s1Var.h(new s0("trigger_on_ascent", 9, 0, 1.0d, 0.0d, "", false, l2Var3));
        s1Var.h(new s0("repeating", 10, 0, 1.0d, 0.0d, "", false, l2Var3));
        s1Var.h(new s0("speed", 11, 133, 1000.0d, 0.0d, "mps", false, l2Var2));
    }

    public g0(s1 s1Var) {
        super(s1Var);
    }
}
