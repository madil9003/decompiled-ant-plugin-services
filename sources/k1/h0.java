package k1;

/* loaded from: classes.dex */
public class h0 extends s1 {

    /* renamed from: g */
    protected static final s1 f2184g;

    static {
        s1 s1Var = new s1("dive_gas", 259);
        f2184g = s1Var;
        s1Var.h(new s0("message_index", 254, 132, 1.0d, 0.0d, "", false, l2.MESSAGE_INDEX));
        l2 l2Var = l2.UINT8;
        s1Var.h(new s0("helium_content", 0, 2, 1.0d, 0.0d, "percent", false, l2Var));
        s1Var.h(new s0("oxygen_content", 1, 2, 1.0d, 0.0d, "percent", false, l2Var));
        s1Var.h(new s0("status", 2, 0, 1.0d, 0.0d, "", false, l2.DIVE_GAS_STATUS));
        s1Var.h(new s0("mode", 3, 0, 1.0d, 0.0d, "", false, l2.DIVE_GAS_MODE));
    }

    public h0(s1 s1Var) {
        super(s1Var);
    }
}
