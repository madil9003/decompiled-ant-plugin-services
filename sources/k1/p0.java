package k1;

/* loaded from: classes.dex */
public class p0 extends s1 {

    /* renamed from: g */
    protected static final s1 f2353g;

    static {
        s1 s1Var = new s1("exd_screen_configuration", 200);
        f2353g = s1Var;
        l2 l2Var = l2.UINT8;
        s1Var.h(new s0("screen_index", 0, 2, 1.0d, 0.0d, "", false, l2Var));
        s1Var.h(new s0("field_count", 1, 2, 1.0d, 0.0d, "", false, l2Var));
        s1Var.h(new s0("layout", 2, 0, 1.0d, 0.0d, "", false, l2.EXD_LAYOUT));
        s1Var.h(new s0("screen_enabled", 3, 0, 1.0d, 0.0d, "", false, l2.BOOL));
    }

    public p0(s1 s1Var) {
        super(s1Var);
    }
}
