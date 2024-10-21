package k1;

/* loaded from: classes.dex */
public class q2 extends s1 {

    /* renamed from: g */
    protected static final s1 f2360g;

    static {
        s1 s1Var = new s1("segment_file", 151);
        f2360g = s1Var;
        s1Var.h(new s0("message_index", 254, 132, 1.0d, 0.0d, "", false, l2.MESSAGE_INDEX));
        l2 l2Var = l2.STRING;
        s1Var.h(new s0("file_uuid", 1, 7, 1.0d, 0.0d, "", false, l2Var));
        s1Var.h(new s0("enabled", 3, 0, 1.0d, 0.0d, "", false, l2.BOOL));
        l2 l2Var2 = l2.UINT32;
        s1Var.h(new s0("user_profile_primary_key", 4, 134, 1.0d, 0.0d, "", false, l2Var2));
        s1Var.h(new s0("leader_type", 7, 0, 1.0d, 0.0d, "", false, l2.SEGMENT_LEADERBOARD_TYPE));
        s1Var.h(new s0("leader_group_primary_key", 8, 134, 1.0d, 0.0d, "", false, l2Var2));
        s1Var.h(new s0("leader_activity_id", 9, 134, 1.0d, 0.0d, "", false, l2Var2));
        s1Var.h(new s0("leader_activity_id_string", 10, 7, 1.0d, 0.0d, "", false, l2Var));
        s1Var.h(new s0("default_race_leader", 11, 2, 1.0d, 0.0d, "", false, l2.UINT8));
    }

    public q2(s1 s1Var) {
        super(s1Var);
    }
}
