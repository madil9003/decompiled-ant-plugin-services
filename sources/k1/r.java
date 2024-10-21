package k1;

/* loaded from: classes.dex */
public class r extends s1 {

    /* renamed from: g */
    protected static final s1 f2362g;

    static {
        s1 s1Var = new s1("capabilities", 1);
        f2362g = s1Var;
        s1Var.h(new s0("languages", 0, 10, 1.0d, 0.0d, "", false, l2.UINT8Z));
        s1Var.h(new s0("sports", 1, 10, 1.0d, 0.0d, "", false, l2.SPORT_BITS_0));
        s1Var.h(new s0("workouts_supported", 21, 140, 1.0d, 0.0d, "", false, l2.WORKOUT_CAPABILITIES));
        s1Var.h(new s0("connectivity_supported", 23, 140, 1.0d, 0.0d, "", false, l2.CONNECTIVITY_CAPABILITIES));
    }

    public r(s1 s1Var) {
        super(s1Var);
    }
}
