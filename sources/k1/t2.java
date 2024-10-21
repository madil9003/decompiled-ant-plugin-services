package k1;

/* loaded from: classes.dex */
public class t2 extends s1 {

    /* renamed from: g */
    protected static final s1 f2441g;

    static {
        s1 s1Var = new s1("segment_leaderboard_entry", 149);
        f2441g = s1Var;
        s1Var.h(new s0("message_index", 254, 132, 1.0d, 0.0d, "", false, l2.MESSAGE_INDEX));
        l2 l2Var = l2.STRING;
        s1Var.h(new s0("name", 0, 7, 1.0d, 0.0d, "", false, l2Var));
        s1Var.h(new s0("type", 1, 0, 1.0d, 0.0d, "", false, l2.SEGMENT_LEADERBOARD_TYPE));
        l2 l2Var2 = l2.UINT32;
        s1Var.h(new s0("group_primary_key", 2, 134, 1.0d, 0.0d, "", false, l2Var2));
        s1Var.h(new s0("activity_id", 3, 134, 1.0d, 0.0d, "", false, l2Var2));
        s1Var.h(new s0("segment_time", 4, 134, 1000.0d, 0.0d, "s", false, l2Var2));
        s1Var.h(new s0("activity_id_string", 5, 7, 1.0d, 0.0d, "", false, l2Var));
    }

    public t2(s1 s1Var) {
        super(s1Var);
    }
}
