package k1;

/* loaded from: classes.dex */
public class f2 extends s1 {

    /* renamed from: g */
    protected static final s1 f2176g;

    static {
        s1 s1Var = new s1("nmea_sentence", 177);
        f2176g = s1Var;
        s1Var.h(new s0("timestamp", 253, 134, 1.0d, 0.0d, "s", false, l2.DATE_TIME));
        s1Var.h(new s0("timestamp_ms", 0, 132, 1.0d, 0.0d, "ms", false, l2.UINT16));
        s1Var.h(new s0("sentence", 1, 7, 1.0d, 0.0d, "", false, l2.STRING));
    }

    public f2(s1 s1Var) {
        super(s1Var);
    }
}
