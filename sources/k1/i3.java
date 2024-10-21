package k1;

/* loaded from: classes.dex */
public class i3 extends s1 {

    /* renamed from: g */
    protected static final s1 f2192g;

    static {
        s1 s1Var = new s1("timestamp_correlation", 162);
        f2192g = s1Var;
        l2 l2Var = l2.DATE_TIME;
        s1Var.h(new s0("timestamp", 253, 134, 1.0d, 0.0d, "s", false, l2Var));
        l2 l2Var2 = l2.UINT16;
        s1Var.h(new s0("fractional_timestamp", 0, 132, 32768.0d, 0.0d, "s", false, l2Var2));
        s1Var.h(new s0("system_timestamp", 1, 134, 1.0d, 0.0d, "s", false, l2Var));
        s1Var.h(new s0("fractional_system_timestamp", 2, 132, 32768.0d, 0.0d, "s", false, l2Var2));
        s1Var.h(new s0("local_timestamp", 3, 134, 1.0d, 0.0d, "s", false, l2.LOCAL_DATE_TIME));
        s1Var.h(new s0("timestamp_ms", 4, 132, 1.0d, 0.0d, "ms", false, l2Var2));
        s1Var.h(new s0("system_timestamp_ms", 5, 132, 1.0d, 0.0d, "ms", false, l2Var2));
    }

    public i3(s1 s1Var) {
        super(s1Var);
    }
}
