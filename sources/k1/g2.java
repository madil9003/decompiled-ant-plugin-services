package k1;

/* loaded from: classes.dex */
public class g2 extends s1 {

    /* renamed from: g */
    protected static final s1 f2181g;

    static {
        s1 s1Var = new s1("obdii_data", 174);
        f2181g = s1Var;
        l2 l2Var = l2.DATE_TIME;
        s1Var.h(new s0("timestamp", 253, 134, 1.0d, 0.0d, "s", false, l2Var));
        l2 l2Var2 = l2.UINT16;
        s1Var.h(new s0("timestamp_ms", 0, 132, 1.0d, 0.0d, "ms", false, l2Var2));
        s1Var.h(new s0("time_offset", 1, 132, 1.0d, 0.0d, "ms", false, l2Var2));
        l2 l2Var3 = l2.BYTE;
        s1Var.h(new s0("pid", 2, 13, 1.0d, 0.0d, "", false, l2Var3));
        s1Var.h(new s0("raw_data", 3, 13, 1.0d, 0.0d, "", false, l2Var3));
        s1Var.h(new s0("pid_data_size", 4, 2, 1.0d, 0.0d, "", false, l2.UINT8));
        s1Var.h(new s0("system_time", 5, 134, 1.0d, 0.0d, "", false, l2.UINT32));
        s1Var.h(new s0("start_timestamp", 6, 134, 1.0d, 0.0d, "", false, l2Var));
        s1Var.h(new s0("start_timestamp_ms", 7, 132, 1.0d, 0.0d, "ms", false, l2Var2));
    }

    public g2(s1 s1Var) {
        super(s1Var);
    }
}
