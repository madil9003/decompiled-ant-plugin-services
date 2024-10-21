package k1;

/* loaded from: classes.dex */
public class n1 extends s1 {

    /* renamed from: g */
    protected static final s1 f2345g;

    static {
        s1 s1Var = new s1("jump", 285);
        f2345g = s1Var;
        s1Var.h(new s0("timestamp", 253, 134, 1.0d, 0.0d, "s", false, l2.DATE_TIME));
        l2 l2Var = l2.FLOAT32;
        s1Var.h(new s0("distance", 0, 136, 1.0d, 0.0d, "m", false, l2Var));
        s1Var.h(new s0("height", 1, 136, 1.0d, 0.0d, "m", false, l2Var));
        s1Var.h(new s0("rotations", 2, 2, 1.0d, 0.0d, "", false, l2.UINT8));
        s1Var.h(new s0("hang_time", 3, 136, 1.0d, 0.0d, "s", false, l2Var));
        s1Var.h(new s0("score", 4, 136, 1.0d, 0.0d, "", false, l2Var));
        l2 l2Var2 = l2.SINT32;
        s1Var.h(new s0("position_lat", 5, 133, 1.0d, 0.0d, "semicircles", false, l2Var2));
        s1Var.h(new s0("position_long", 6, 133, 1.0d, 0.0d, "semicircles", false, l2Var2));
        s1Var.h(new s0("speed", 7, 132, 1000.0d, 0.0d, "m/s", false, l2.UINT16));
        ((s0) s1Var.f2382d.get(8)).f2375j.add(new w0(8, false, 16, 1000.0d, 0.0d));
        s1Var.h(new s0("enhanced_speed", 8, 134, 1000.0d, 0.0d, "m/s", false, l2.UINT32));
    }

    public n1(s1 s1Var) {
        super(s1Var);
    }
}
