package k1;

/* loaded from: classes.dex */
public class g1 extends s1 {

    /* renamed from: g */
    protected static final s1 f2180g;

    static {
        s1 s1Var = new s1("gps_metadata", 160);
        f2180g = s1Var;
        l2 l2Var = l2.DATE_TIME;
        s1Var.h(new s0("timestamp", 253, 134, 1.0d, 0.0d, "s", false, l2Var));
        l2 l2Var2 = l2.UINT16;
        s1Var.h(new s0("timestamp_ms", 0, 132, 1.0d, 0.0d, "ms", false, l2Var2));
        l2 l2Var3 = l2.SINT32;
        s1Var.h(new s0("position_lat", 1, 133, 1.0d, 0.0d, "semicircles", false, l2Var3));
        s1Var.h(new s0("position_long", 2, 133, 1.0d, 0.0d, "semicircles", false, l2Var3));
        l2 l2Var4 = l2.UINT32;
        s1Var.h(new s0("enhanced_altitude", 3, 134, 5.0d, 500.0d, "m", false, l2Var4));
        s1Var.h(new s0("enhanced_speed", 4, 134, 1000.0d, 0.0d, "m/s", false, l2Var4));
        s1Var.h(new s0("heading", 5, 132, 100.0d, 0.0d, "degrees", false, l2Var2));
        s1Var.h(new s0("utc_timestamp", 6, 134, 1.0d, 0.0d, "s", false, l2Var));
        s1Var.h(new s0("velocity", 7, 131, 100.0d, 0.0d, "m/s", false, l2.SINT16));
    }

    public g1(s1 s1Var) {
        super(s1Var);
    }
}
