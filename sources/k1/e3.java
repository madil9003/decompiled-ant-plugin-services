package k1;

/* loaded from: classes.dex */
public class e3 extends s1 {

    /* renamed from: g */
    protected static final s1 f2172g;

    static {
        s1 s1Var = new s1("tank_summary", 323);
        f2172g = s1Var;
        s1Var.h(new s0("timestamp", 253, 134, 1.0d, 0.0d, "s", false, l2.DATE_TIME));
        s1Var.h(new s0("sensor", 0, 140, 1.0d, 0.0d, "", false, l2.ANT_CHANNEL_ID));
        l2 l2Var = l2.UINT16;
        s1Var.h(new s0("start_pressure", 1, 132, 100.0d, 0.0d, "bar", false, l2Var));
        s1Var.h(new s0("end_pressure", 2, 132, 100.0d, 0.0d, "bar", false, l2Var));
        s1Var.h(new s0("volume_used", 3, 134, 100.0d, 0.0d, "L", false, l2.UINT32));
    }

    public e3(s1 s1Var) {
        super(s1Var);
    }
}
