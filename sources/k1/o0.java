package k1;

/* loaded from: classes.dex */
public class o0 extends s1 {

    /* renamed from: g */
    protected static final s1 f2348g;

    static {
        s1 s1Var = new s1("exd_data_field_configuration", 201);
        f2348g = s1Var;
        l2 l2Var = l2.UINT8;
        s1Var.h(new s0("screen_index", 0, 2, 1.0d, 0.0d, "", false, l2Var));
        s1Var.h(new s0("concept_field", 1, 13, 1.0d, 0.0d, "", false, l2.BYTE));
        ((s0) s1Var.f2382d.get(1)).f2375j.add(new w0(2, false, 4, 1.0d, 0.0d));
        ((s0) s1Var.f2382d.get(1)).f2375j.add(new w0(3, false, 4, 1.0d, 0.0d));
        s1Var.h(new s0("field_id", 2, 2, 1.0d, 0.0d, "", false, l2Var));
        s1Var.h(new s0("concept_count", 3, 2, 1.0d, 0.0d, "", false, l2Var));
        s1Var.h(new s0("display_type", 4, 0, 1.0d, 0.0d, "", false, l2.EXD_DISPLAY_TYPE));
        s1Var.h(new s0("title", 5, 7, 1.0d, 0.0d, "", false, l2.STRING));
    }

    public o0(s1 s1Var) {
        super(s1Var);
    }
}
