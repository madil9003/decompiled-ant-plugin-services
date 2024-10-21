package k1;

/* loaded from: classes.dex */
public class n0 extends s1 {

    /* renamed from: g */
    protected static final s1 f2344g;

    static {
        s1 s1Var = new s1("exd_data_concept_configuration", 202);
        f2344g = s1Var;
        l2 l2Var = l2.UINT8;
        s1Var.h(new s0("screen_index", 0, 2, 1.0d, 0.0d, "", false, l2Var));
        s1Var.h(new s0("concept_field", 1, 13, 1.0d, 0.0d, "", false, l2.BYTE));
        ((s0) s1Var.f2382d.get(1)).f2375j.add(new w0(2, false, 4, 1.0d, 0.0d));
        ((s0) s1Var.f2382d.get(1)).f2375j.add(new w0(3, false, 4, 1.0d, 0.0d));
        s1Var.h(new s0("field_id", 2, 2, 1.0d, 0.0d, "", false, l2Var));
        s1Var.h(new s0("concept_index", 3, 2, 1.0d, 0.0d, "", false, l2Var));
        s1Var.h(new s0("data_page", 4, 2, 1.0d, 0.0d, "", false, l2Var));
        s1Var.h(new s0("concept_key", 5, 2, 1.0d, 0.0d, "", false, l2Var));
        s1Var.h(new s0("scaling", 6, 2, 1.0d, 0.0d, "", false, l2Var));
        s1Var.h(new s0("data_units", 8, 0, 1.0d, 0.0d, "", false, l2.EXD_DATA_UNITS));
        s1Var.h(new s0("qualifier", 9, 0, 1.0d, 0.0d, "", false, l2.EXD_QUALIFIERS));
        s1Var.h(new s0("descriptor", 10, 0, 1.0d, 0.0d, "", false, l2.EXD_DESCRIPTORS));
        s1Var.h(new s0("is_signed", 11, 0, 1.0d, 0.0d, "", false, l2.BOOL));
    }

    public n0(s1 s1Var) {
        super(s1Var);
    }
}
