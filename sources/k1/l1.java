package k1;

/* loaded from: classes.dex */
public class l1 extends s1 {

    /* renamed from: g */
    protected static final s1 f2239g;

    static {
        s1 s1Var = new s1("hrm_profile", 4);
        f2239g = s1Var;
        s1Var.h(new s0("message_index", 254, 132, 1.0d, 0.0d, "", false, l2.MESSAGE_INDEX));
        l2 l2Var = l2.BOOL;
        s1Var.h(new s0("enabled", 0, 0, 1.0d, 0.0d, "", false, l2Var));
        s1Var.h(new s0("hrm_ant_id", 1, 139, 1.0d, 0.0d, "", false, l2.UINT16Z));
        s1Var.h(new s0("log_hrv", 2, 0, 1.0d, 0.0d, "", false, l2Var));
        s1Var.h(new s0("hrm_ant_id_trans_type", 3, 10, 1.0d, 0.0d, "", false, l2.UINT8Z));
    }

    public l1(s1 s1Var) {
        super(s1Var);
    }
}
