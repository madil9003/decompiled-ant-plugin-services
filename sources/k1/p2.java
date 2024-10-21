package k1;

/* loaded from: classes.dex */
public class p2 extends s1 {

    /* renamed from: g */
    protected static final s1 f2355g;

    static {
        s1 s1Var = new s1("sdm_profile", 5);
        f2355g = s1Var;
        s1Var.h(new s0("message_index", 254, 132, 1.0d, 0.0d, "", false, l2.MESSAGE_INDEX));
        l2 l2Var = l2.BOOL;
        s1Var.h(new s0("enabled", 0, 0, 1.0d, 0.0d, "", false, l2Var));
        s1Var.h(new s0("sdm_ant_id", 1, 139, 1.0d, 0.0d, "", false, l2.UINT16Z));
        s1Var.h(new s0("sdm_cal_factor", 2, 132, 10.0d, 0.0d, "%", false, l2.UINT16));
        s1Var.h(new s0("odometer", 3, 134, 100.0d, 0.0d, "m", false, l2.UINT32));
        s1Var.h(new s0("speed_source", 4, 0, 1.0d, 0.0d, "", false, l2Var));
        s1Var.h(new s0("sdm_ant_id_trans_type", 5, 10, 1.0d, 0.0d, "", false, l2.UINT8Z));
        s1Var.h(new s0("odometer_rollover", 7, 2, 1.0d, 0.0d, "", false, l2.UINT8));
    }

    public p2(s1 s1Var) {
        super(s1Var);
    }
}
