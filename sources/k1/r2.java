package k1;

/* loaded from: classes.dex */
public class r2 extends s1 {

    /* renamed from: g */
    protected static final s1 f2365g;

    static {
        s1 s1Var = new s1("segment_id", 148);
        f2365g = s1Var;
        l2 l2Var = l2.STRING;
        s1Var.h(new s0("name", 0, 7, 1.0d, 0.0d, "", false, l2Var));
        s1Var.h(new s0("uuid", 1, 7, 1.0d, 0.0d, "", false, l2Var));
        s1Var.h(new s0("sport", 2, 0, 1.0d, 0.0d, "", false, l2.SPORT));
        s1Var.h(new s0("enabled", 3, 0, 1.0d, 0.0d, "", false, l2.BOOL));
        l2 l2Var2 = l2.UINT32;
        s1Var.h(new s0("user_profile_primary_key", 4, 134, 1.0d, 0.0d, "", false, l2Var2));
        s1Var.h(new s0("device_id", 5, 134, 1.0d, 0.0d, "", false, l2Var2));
        s1Var.h(new s0("default_race_leader", 6, 2, 1.0d, 0.0d, "", false, l2.UINT8));
        s1Var.h(new s0("delete_status", 7, 0, 1.0d, 0.0d, "", false, l2.SEGMENT_DELETE_STATUS));
        s1Var.h(new s0("selection_type", 8, 0, 1.0d, 0.0d, "", false, l2.SEGMENT_SELECTION_TYPE));
    }

    public r2(s1 s1Var) {
        super(s1Var);
    }
}
