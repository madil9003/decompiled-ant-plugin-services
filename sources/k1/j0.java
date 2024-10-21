package k1;

/* loaded from: classes.dex */
public class j0 extends s1 {

    /* renamed from: g */
    protected static final s1 f2193g;

    static {
        s1 s1Var = new s1("dive_summary", 268);
        f2193g = s1Var;
        s1Var.h(new s0("timestamp", 253, 134, 1.0d, 0.0d, "s", false, l2.DATE_TIME));
        s1Var.h(new s0("reference_mesg", 0, 132, 1.0d, 0.0d, "", false, l2.MESG_NUM));
        s1Var.h(new s0("reference_index", 1, 132, 1.0d, 0.0d, "", false, l2.MESSAGE_INDEX));
        l2 l2Var = l2.UINT32;
        s1Var.h(new s0("avg_depth", 2, 134, 1000.0d, 0.0d, "m", false, l2Var));
        s1Var.h(new s0("max_depth", 3, 134, 1000.0d, 0.0d, "m", false, l2Var));
        s1Var.h(new s0("surface_interval", 4, 134, 1.0d, 0.0d, "s", false, l2Var));
        l2 l2Var2 = l2.UINT8;
        s1Var.h(new s0("start_cns", 5, 2, 1.0d, 0.0d, "percent", false, l2Var2));
        s1Var.h(new s0("end_cns", 6, 2, 1.0d, 0.0d, "percent", false, l2Var2));
        l2 l2Var3 = l2.UINT16;
        s1Var.h(new s0("start_n2", 7, 132, 1.0d, 0.0d, "percent", false, l2Var3));
        s1Var.h(new s0("end_n2", 8, 132, 1.0d, 0.0d, "percent", false, l2Var3));
        s1Var.h(new s0("o2_toxicity", 9, 132, 1.0d, 0.0d, "OTUs", false, l2Var3));
        s1Var.h(new s0("dive_number", 10, 134, 1.0d, 0.0d, "", false, l2Var));
        s1Var.h(new s0("bottom_time", 11, 134, 1000.0d, 0.0d, "s", false, l2Var));
        s1Var.h(new s0("avg_pressure_sac", 12, 132, 100.0d, 0.0d, "bar/min", false, l2Var3));
        s1Var.h(new s0("avg_volume_sac", 13, 132, 100.0d, 0.0d, "L/min", false, l2Var3));
        s1Var.h(new s0("avg_rmv", 14, 132, 100.0d, 0.0d, "L/min", false, l2Var3));
        s1Var.h(new s0("descent_time", 15, 134, 1000.0d, 0.0d, "s", false, l2Var));
        s1Var.h(new s0("ascent_time", 16, 134, 1000.0d, 0.0d, "s", false, l2Var));
        s1Var.h(new s0("avg_ascent_rate", 17, 133, 1000.0d, 0.0d, "m/s", false, l2.SINT32));
        s1Var.h(new s0("avg_descent_rate", 22, 134, 1000.0d, 0.0d, "m/s", false, l2Var));
        s1Var.h(new s0("max_ascent_rate", 23, 134, 1000.0d, 0.0d, "m/s", false, l2Var));
        s1Var.h(new s0("max_descent_rate", 24, 134, 1000.0d, 0.0d, "m/s", false, l2Var));
        s1Var.h(new s0("hang_time", 25, 134, 1000.0d, 0.0d, "s", false, l2Var));
    }

    public j0(s1 s1Var) {
        super(s1Var);
    }
}
