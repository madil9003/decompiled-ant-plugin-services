package k1;

/* loaded from: classes.dex */
public class v extends s1 {

    /* renamed from: g */
    protected static final s1 f2449g;

    static {
        s1 s1Var = new s1("course_point", 32);
        f2449g = s1Var;
        s1Var.h(new s0("message_index", 254, 132, 1.0d, 0.0d, "", false, l2.MESSAGE_INDEX));
        s1Var.h(new s0("timestamp", 1, 134, 1.0d, 0.0d, "", false, l2.DATE_TIME));
        l2 l2Var = l2.SINT32;
        s1Var.h(new s0("position_lat", 2, 133, 1.0d, 0.0d, "semicircles", false, l2Var));
        s1Var.h(new s0("position_long", 3, 133, 1.0d, 0.0d, "semicircles", false, l2Var));
        s1Var.h(new s0("distance", 4, 134, 100.0d, 0.0d, "m", false, l2.UINT32));
        s1Var.h(new s0("type", 5, 0, 1.0d, 0.0d, "", false, l2.COURSE_POINT));
        s1Var.h(new s0("name", 6, 7, 1.0d, 0.0d, "", false, l2.STRING));
        s1Var.h(new s0("favorite", 8, 0, 1.0d, 0.0d, "", false, l2.BOOL));
    }

    public v(s1 s1Var) {
        super(s1Var);
    }
}
