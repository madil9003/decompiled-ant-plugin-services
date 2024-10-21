package k1;

/* loaded from: classes.dex */
public class o2 extends s1 {

    /* renamed from: g */
    protected static final s1 f2350g;

    static {
        s1 s1Var = new s1("schedule", 28);
        f2350g = s1Var;
        s1Var.h(new s0("manufacturer", 0, 132, 1.0d, 0.0d, "", false, l2.MANUFACTURER));
        s1Var.h(new s0("product", 1, 132, 1.0d, 0.0d, "", false, l2.UINT16));
        ((s0) s1Var.f2382d.get(1)).f2376k.add(new d3("favero_product", 132, 1.0d, 0.0d, ""));
        ((d3) ((s0) s1Var.f2382d.get(1)).f2376k.get(0)).b(0, 263L);
        ((s0) s1Var.f2382d.get(1)).f2376k.add(new d3("garmin_product", 132, 1.0d, 0.0d, ""));
        ((d3) ((s0) s1Var.f2382d.get(1)).f2376k.get(1)).b(0, 1L);
        ((d3) ((s0) s1Var.f2382d.get(1)).f2376k.get(1)).b(0, 15L);
        ((d3) ((s0) s1Var.f2382d.get(1)).f2376k.get(1)).b(0, 13L);
        ((d3) ((s0) s1Var.f2382d.get(1)).f2376k.get(1)).b(0, 89L);
        s1Var.h(new s0("serial_number", 2, 140, 1.0d, 0.0d, "", false, l2.UINT32Z));
        s1Var.h(new s0("time_created", 3, 134, 1.0d, 0.0d, "", false, l2.DATE_TIME));
        s1Var.h(new s0("completed", 4, 0, 1.0d, 0.0d, "", false, l2.BOOL));
        s1Var.h(new s0("type", 5, 0, 1.0d, 0.0d, "", false, l2.SCHEDULE));
        s1Var.h(new s0("scheduled_time", 6, 134, 1.0d, 0.0d, "", false, l2.LOCAL_DATE_TIME));
    }

    public o2(s1 s1Var) {
        super(s1Var);
    }
}
