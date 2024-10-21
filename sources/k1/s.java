package k1;

/* loaded from: classes.dex */
public class s extends s1 {

    /* renamed from: g */
    protected static final s1 f2367g;

    static {
        s1 s1Var = new s1("climb_pro", 317);
        f2367g = s1Var;
        s1Var.h(new s0("timestamp", 253, 134, 1.0d, 0.0d, "s", false, l2.DATE_TIME));
        l2 l2Var = l2.SINT32;
        s1Var.h(new s0("position_lat", 0, 133, 1.0d, 0.0d, "semicircles", false, l2Var));
        s1Var.h(new s0("position_long", 1, 133, 1.0d, 0.0d, "semicircles", false, l2Var));
        s1Var.h(new s0("climb_pro_event", 2, 0, 1.0d, 0.0d, "", false, l2.CLIMB_PRO_EVENT));
        s1Var.h(new s0("climb_number", 3, 132, 1.0d, 0.0d, "", false, l2.UINT16));
        s1Var.h(new s0("climb_category", 4, 2, 1.0d, 0.0d, "", false, l2.UINT8));
        s1Var.h(new s0("current_dist", 5, 136, 1.0d, 0.0d, "m", false, l2.FLOAT32));
    }

    public s(s1 s1Var) {
        super(s1Var);
    }
}
