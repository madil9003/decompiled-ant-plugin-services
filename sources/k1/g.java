package k1;

/* loaded from: classes.dex */
public class g extends s1 {

    /* renamed from: g */
    protected static final s1 f2178g;

    static {
        s1 s1Var = new s1("barometer_data", 209);
        f2178g = s1Var;
        s1Var.h(new s0("timestamp", 253, 134, 1.0d, 0.0d, "s", false, l2.DATE_TIME));
        l2 l2Var = l2.UINT16;
        s1Var.h(new s0("timestamp_ms", 0, 132, 1.0d, 0.0d, "ms", false, l2Var));
        s1Var.h(new s0("sample_time_offset", 1, 132, 1.0d, 0.0d, "ms", false, l2Var));
        s1Var.h(new s0("baro_pres", 2, 134, 1.0d, 0.0d, "Pa", false, l2.UINT32));
    }

    public g(s1 s1Var) {
        super(s1Var);
    }
}
