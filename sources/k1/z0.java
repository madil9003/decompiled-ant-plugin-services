package k1;

/* loaded from: classes.dex */
public class z0 extends s1 {

    /* renamed from: g */
    protected static final s1 f2538g;

    static {
        s1 s1Var = new s1("field_description", 206);
        f2538g = s1Var;
        l2 l2Var = l2.UINT8;
        s1Var.h(new s0("developer_data_index", 0, 2, 1.0d, 0.0d, "", false, l2Var));
        s1Var.h(new s0("field_definition_number", 1, 2, 1.0d, 0.0d, "", false, l2Var));
        s1Var.h(new s0("fit_base_type_id", 2, 2, 1.0d, 0.0d, "", false, l2.FIT_BASE_TYPE));
        l2 l2Var2 = l2.STRING;
        s1Var.h(new s0("field_name", 3, 7, 1.0d, 0.0d, "", false, l2Var2));
        s1Var.h(new s0("array", 4, 2, 1.0d, 0.0d, "", false, l2Var));
        s1Var.h(new s0("components", 5, 7, 1.0d, 0.0d, "", false, l2Var2));
        s1Var.h(new s0("scale", 6, 2, 1.0d, 0.0d, "", false, l2Var));
        s1Var.h(new s0("offset", 7, 1, 1.0d, 0.0d, "", false, l2.SINT8));
        s1Var.h(new s0("units", 8, 7, 1.0d, 0.0d, "", false, l2Var2));
        s1Var.h(new s0("bits", 9, 7, 1.0d, 0.0d, "", false, l2Var2));
        s1Var.h(new s0("accumulate", 10, 7, 1.0d, 0.0d, "", false, l2Var2));
        s1Var.h(new s0("fit_base_unit_id", 13, 132, 1.0d, 0.0d, "", false, l2.FIT_BASE_UNIT));
        s1Var.h(new s0("native_mesg_num", 14, 132, 1.0d, 0.0d, "", false, l2.MESG_NUM));
        s1Var.h(new s0("native_field_num", 15, 2, 1.0d, 0.0d, "", false, l2Var));
    }

    public z0(s1 s1Var) {
        super(s1Var);
    }

    public Short A() {
        return n(6, 0, 65535);
    }

    public Short v() {
        return n(0, 0, 65535);
    }

    public Short w() {
        return n(1, 0, 65535);
    }

    public String x(int i2) {
        return o(3, i2, 65535);
    }

    public Short y() {
        return n(2, 0, 65535);
    }

    public Byte z() {
        return k(7, 0, 65535);
    }
}
