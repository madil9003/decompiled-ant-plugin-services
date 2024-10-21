package k1;

/* loaded from: classes.dex */
public class e extends s1 {

    /* renamed from: g */
    protected static final s1 f2169g;

    static {
        s1 s1Var = new s1("ant_tx", 81);
        f2169g = s1Var;
        s1Var.h(new s0("timestamp", 253, 134, 1.0d, 0.0d, "s", false, l2.DATE_TIME));
        s1Var.h(new s0("fractional_timestamp", 0, 132, 32768.0d, 0.0d, "s", false, l2.UINT16));
        l2 l2Var = l2.BYTE;
        s1Var.h(new s0("mesg_id", 1, 13, 1.0d, 0.0d, "", false, l2Var));
        s1Var.h(new s0("mesg_data", 2, 13, 1.0d, 0.0d, "", false, l2Var));
        ((s0) s1Var.f2382d.get(3)).f2375j.add(new w0(3, false, 8, 1.0d, 0.0d));
        ((s0) s1Var.f2382d.get(3)).f2375j.add(new w0(4, false, 8, 1.0d, 0.0d));
        ((s0) s1Var.f2382d.get(3)).f2375j.add(new w0(4, false, 8, 1.0d, 0.0d));
        ((s0) s1Var.f2382d.get(3)).f2375j.add(new w0(4, false, 8, 1.0d, 0.0d));
        ((s0) s1Var.f2382d.get(3)).f2375j.add(new w0(4, false, 8, 1.0d, 0.0d));
        ((s0) s1Var.f2382d.get(3)).f2375j.add(new w0(4, false, 8, 1.0d, 0.0d));
        ((s0) s1Var.f2382d.get(3)).f2375j.add(new w0(4, false, 8, 1.0d, 0.0d));
        ((s0) s1Var.f2382d.get(3)).f2375j.add(new w0(4, false, 8, 1.0d, 0.0d));
        ((s0) s1Var.f2382d.get(3)).f2375j.add(new w0(4, false, 8, 1.0d, 0.0d));
        s1Var.h(new s0("channel_number", 3, 2, 1.0d, 0.0d, "", false, l2.UINT8));
        s1Var.h(new s0("data", 4, 13, 1.0d, 0.0d, "", false, l2Var));
    }

    public e(s1 s1Var) {
        super(s1Var);
    }
}
