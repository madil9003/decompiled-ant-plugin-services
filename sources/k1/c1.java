package k1;

/* loaded from: classes.dex */
public class c1 extends s1 {

    /* renamed from: g */
    protected static final s1 f2115g;

    static {
        s1 s1Var = new s1("file_id", 0);
        f2115g = s1Var;
        s1Var.h(new s0("type", 0, 0, 1.0d, 0.0d, "", false, l2.FILE));
        s1Var.h(new s0("manufacturer", 1, 132, 1.0d, 0.0d, "", false, l2.MANUFACTURER));
        l2 l2Var = l2.UINT16;
        s1Var.h(new s0("product", 2, 132, 1.0d, 0.0d, "", false, l2Var));
        ((s0) s1Var.f2382d.get(2)).f2376k.add(new d3("favero_product", 132, 1.0d, 0.0d, ""));
        ((d3) ((s0) s1Var.f2382d.get(2)).f2376k.get(0)).b(1, 263L);
        ((s0) s1Var.f2382d.get(2)).f2376k.add(new d3("garmin_product", 132, 1.0d, 0.0d, ""));
        ((d3) ((s0) s1Var.f2382d.get(2)).f2376k.get(1)).b(1, 1L);
        ((d3) ((s0) s1Var.f2382d.get(2)).f2376k.get(1)).b(1, 15L);
        ((d3) ((s0) s1Var.f2382d.get(2)).f2376k.get(1)).b(1, 13L);
        ((d3) ((s0) s1Var.f2382d.get(2)).f2376k.get(1)).b(1, 89L);
        s1Var.h(new s0("serial_number", 3, 140, 1.0d, 0.0d, "", false, l2.UINT32Z));
        s1Var.h(new s0("time_created", 4, 134, 1.0d, 0.0d, "", false, l2.DATE_TIME));
        s1Var.h(new s0("number", 5, 132, 1.0d, 0.0d, "", false, l2Var));
        s1Var.h(new s0("product_name", 8, 7, 1.0d, 0.0d, "", false, l2.STRING));
    }

    public c1(s1 s1Var) {
        super(s1Var);
    }
}
