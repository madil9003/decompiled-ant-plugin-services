package k1;

/* loaded from: classes.dex */
public class u1 extends s1 {

    /* renamed from: g */
    protected static final s1 f2446g;

    static {
        s1 s1Var = new s1("mesg_capabilities", 38);
        f2446g = s1Var;
        s1Var.h(new s0("message_index", 254, 132, 1.0d, 0.0d, "", false, l2.MESSAGE_INDEX));
        s1Var.h(new s0("file", 0, 0, 1.0d, 0.0d, "", false, l2.FILE));
        s1Var.h(new s0("mesg_num", 1, 132, 1.0d, 0.0d, "", false, l2.MESG_NUM));
        s1Var.h(new s0("count_type", 2, 0, 1.0d, 0.0d, "", false, l2.MESG_COUNT));
        s1Var.h(new s0("count", 3, 132, 1.0d, 0.0d, "", false, l2.UINT16));
        ((s0) s1Var.f2382d.get(4)).f2376k.add(new d3("num_per_file", 132, 1.0d, 0.0d, ""));
        ((d3) ((s0) s1Var.f2382d.get(4)).f2376k.get(0)).b(2, 0L);
        ((s0) s1Var.f2382d.get(4)).f2376k.add(new d3("max_per_file", 132, 1.0d, 0.0d, ""));
        ((d3) ((s0) s1Var.f2382d.get(4)).f2376k.get(1)).b(2, 1L);
        ((s0) s1Var.f2382d.get(4)).f2376k.add(new d3("max_per_file_type", 132, 1.0d, 0.0d, ""));
        ((d3) ((s0) s1Var.f2382d.get(4)).f2376k.get(2)).b(2, 2L);
    }

    public u1(s1 s1Var) {
        super(s1Var);
    }
}
