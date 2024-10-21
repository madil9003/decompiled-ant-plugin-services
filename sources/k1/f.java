package k1;

/* loaded from: classes.dex */
public class f extends s1 {

    /* renamed from: g */
    protected static final s1 f2173g;

    static {
        s1 s1Var = new s1("aviation_attitude", 178);
        f2173g = s1Var;
        s1Var.h(new s0("timestamp", 253, 134, 1.0d, 0.0d, "s", false, l2.DATE_TIME));
        l2 l2Var = l2.UINT16;
        s1Var.h(new s0("timestamp_ms", 0, 132, 1.0d, 0.0d, "ms", false, l2Var));
        s1Var.h(new s0("system_time", 1, 134, 1.0d, 0.0d, "ms", false, l2.UINT32));
        l2 l2Var2 = l2.SINT16;
        s1Var.h(new s0("pitch", 2, 131, 10430.38d, 0.0d, "radians", false, l2Var2));
        s1Var.h(new s0("roll", 3, 131, 10430.38d, 0.0d, "radians", false, l2Var2));
        s1Var.h(new s0("accel_lateral", 4, 131, 100.0d, 0.0d, "m/s^2", false, l2Var2));
        s1Var.h(new s0("accel_normal", 5, 131, 100.0d, 0.0d, "m/s^2", false, l2Var2));
        s1Var.h(new s0("turn_rate", 6, 131, 1024.0d, 0.0d, "radians/second", false, l2Var2));
        s1Var.h(new s0("stage", 7, 0, 1.0d, 0.0d, "", false, l2.ATTITUDE_STAGE));
        s1Var.h(new s0("attitude_stage_complete", 8, 2, 1.0d, 0.0d, "%", false, l2.UINT8));
        s1Var.h(new s0("track", 9, 132, 10430.38d, 0.0d, "radians", false, l2Var));
        s1Var.h(new s0("validity", 10, 132, 1.0d, 0.0d, "", false, l2.ATTITUDE_VALIDITY));
    }

    public f(s1 s1Var) {
        super(s1Var);
    }
}
