package k1;

/* loaded from: classes.dex */
public class u2 extends s1 {

    /* renamed from: g */
    protected static final s1 f2447g;

    static {
        s1 s1Var = new s1("segment_point", 150);
        f2447g = s1Var;
        s1Var.h(new s0("message_index", 254, 132, 1.0d, 0.0d, "", false, l2.MESSAGE_INDEX));
        l2 l2Var = l2.SINT32;
        s1Var.h(new s0("position_lat", 1, 133, 1.0d, 0.0d, "semicircles", false, l2Var));
        s1Var.h(new s0("position_long", 2, 133, 1.0d, 0.0d, "semicircles", false, l2Var));
        l2 l2Var2 = l2.UINT32;
        s1Var.h(new s0("distance", 3, 134, 100.0d, 0.0d, "m", false, l2Var2));
        s1Var.h(new s0("altitude", 4, 132, 5.0d, 500.0d, "m", false, l2.UINT16));
        ((s0) s1Var.f2382d.get(4)).f2375j.add(new w0(6, false, 16, 5.0d, 500.0d));
        s1Var.h(new s0("leader_time", 5, 134, 1000.0d, 0.0d, "s", false, l2Var2));
        s1Var.h(new s0("enhanced_altitude", 6, 134, 5.0d, 500.0d, "m", false, l2Var2));
    }

    public u2(s1 s1Var) {
        super(s1Var);
    }
}
