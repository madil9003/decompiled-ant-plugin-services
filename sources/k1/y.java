package k1;

/* loaded from: classes.dex */
public class y extends s1 {

    /* renamed from: g */
    protected static final s1 f2532g;

    static {
        s1 s1Var = new s1("developer_data_id", 207);
        f2532g = s1Var;
        l2 l2Var = l2.BYTE;
        s1Var.h(new s0("developer_id", 0, 13, 1.0d, 0.0d, "", false, l2Var));
        s1Var.h(new s0("application_id", 1, 13, 1.0d, 0.0d, "", false, l2Var));
        s1Var.h(new s0("manufacturer_id", 2, 132, 1.0d, 0.0d, "", false, l2.MANUFACTURER));
        s1Var.h(new s0("developer_data_index", 3, 2, 1.0d, 0.0d, "", false, l2.UINT8));
        s1Var.h(new s0("application_version", 4, 134, 1.0d, 0.0d, "", false, l2.UINT32));
    }

    public y(s1 s1Var) {
        super(s1Var);
    }

    public Short v() {
        return n(3, 0, 65535);
    }
}
