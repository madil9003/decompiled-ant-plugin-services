package k1;

/* loaded from: classes.dex */
public class c2 extends s1 {

    /* renamed from: g */
    protected static final s1 f2116g;

    static {
        s1 s1Var = new s1("met_zone", 10);
        f2116g = s1Var;
        s1Var.h(new s0("message_index", 254, 132, 1.0d, 0.0d, "", false, l2.MESSAGE_INDEX));
        l2 l2Var = l2.UINT8;
        s1Var.h(new s0("high_bpm", 1, 2, 1.0d, 0.0d, "", false, l2Var));
        s1Var.h(new s0("calories", 2, 132, 10.0d, 0.0d, "kcal / min", false, l2.UINT16));
        s1Var.h(new s0("fat_calories", 3, 2, 10.0d, 0.0d, "kcal / min", false, l2Var));
    }

    public c2(s1 s1Var) {
        super(s1Var);
    }
}
