package k1;

/* loaded from: classes.dex */
public class k3 extends s1 {

    /* renamed from: g */
    protected static final s1 f2237g;

    static {
        s1 s1Var = new s1("training_file", 72);
        f2237g = s1Var;
        l2 l2Var = l2.DATE_TIME;
        s1Var.h(new s0("timestamp", 253, 134, 1.0d, 0.0d, "", false, l2Var));
        s1Var.h(new s0("type", 0, 0, 1.0d, 0.0d, "", false, l2.FILE));
        s1Var.h(new s0("manufacturer", 1, 132, 1.0d, 0.0d, "", false, l2.MANUFACTURER));
        s1Var.h(new s0("product", 2, 132, 1.0d, 0.0d, "", false, l2.UINT16));
        ((s0) s1Var.f2382d.get(3)).f2376k.add(new d3("favero_product", 132, 1.0d, 0.0d, ""));
        ((d3) ((s0) s1Var.f2382d.get(3)).f2376k.get(0)).b(1, 263L);
        ((s0) s1Var.f2382d.get(3)).f2376k.add(new d3("garmin_product", 132, 1.0d, 0.0d, ""));
        ((d3) ((s0) s1Var.f2382d.get(3)).f2376k.get(1)).b(1, 1L);
        ((d3) ((s0) s1Var.f2382d.get(3)).f2376k.get(1)).b(1, 15L);
        ((d3) ((s0) s1Var.f2382d.get(3)).f2376k.get(1)).b(1, 13L);
        ((d3) ((s0) s1Var.f2382d.get(3)).f2376k.get(1)).b(1, 89L);
        s1Var.h(new s0("serial_number", 3, 140, 1.0d, 0.0d, "", false, l2.UINT32Z));
        s1Var.h(new s0("time_created", 4, 134, 1.0d, 0.0d, "", false, l2Var));
    }

    public k3(s1 s1Var) {
        super(s1Var);
    }
}
