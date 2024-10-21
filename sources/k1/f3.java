package k1;

/* loaded from: classes.dex */
public class f3 extends s1 {

    /* renamed from: g */
    protected static final s1 f2177g;

    static {
        s1 s1Var = new s1("tank_update", 319);
        f2177g = s1Var;
        s1Var.h(new s0("timestamp", 253, 134, 1.0d, 0.0d, "s", false, l2.DATE_TIME));
        s1Var.h(new s0("sensor", 0, 140, 1.0d, 0.0d, "", false, l2.ANT_CHANNEL_ID));
        s1Var.h(new s0("pressure", 1, 132, 100.0d, 0.0d, "bar", false, l2.UINT16));
    }

    public f3(s1 s1Var) {
        super(s1Var);
    }
}
