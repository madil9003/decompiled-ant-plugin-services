package k1;

/* loaded from: classes.dex */
public class a1 extends s1 {

    /* renamed from: g */
    protected static final s1 f2100g;

    static {
        s1 s1Var = new s1("file_capabilities", 37);
        f2100g = s1Var;
        s1Var.h(new s0("message_index", 254, 132, 1.0d, 0.0d, "", false, l2.MESSAGE_INDEX));
        s1Var.h(new s0("type", 0, 0, 1.0d, 0.0d, "", false, l2.FILE));
        s1Var.h(new s0("flags", 1, 10, 1.0d, 0.0d, "", false, l2.FILE_FLAGS));
        s1Var.h(new s0("directory", 2, 7, 1.0d, 0.0d, "", false, l2.STRING));
        s1Var.h(new s0("max_count", 3, 132, 1.0d, 0.0d, "", false, l2.UINT16));
        s1Var.h(new s0("max_size", 4, 134, 1.0d, 0.0d, "bytes", false, l2.UINT32));
    }

    public a1(s1 s1Var) {
        super(s1Var);
    }
}
