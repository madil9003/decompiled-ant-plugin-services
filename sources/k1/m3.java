package k1;

/* loaded from: classes.dex */
public class m3 extends s1 {

    /* renamed from: g */
    protected static final s1 f2341g;

    static {
        s1 s1Var = new s1("video_clip", 187);
        f2341g = s1Var;
        l2 l2Var = l2.UINT16;
        s1Var.h(new s0("clip_number", 0, 132, 1.0d, 0.0d, "", false, l2Var));
        l2 l2Var2 = l2.DATE_TIME;
        s1Var.h(new s0("start_timestamp", 1, 134, 1.0d, 0.0d, "", false, l2Var2));
        s1Var.h(new s0("start_timestamp_ms", 2, 132, 1.0d, 0.0d, "", false, l2Var));
        s1Var.h(new s0("end_timestamp", 3, 134, 1.0d, 0.0d, "", false, l2Var2));
        s1Var.h(new s0("end_timestamp_ms", 4, 132, 1.0d, 0.0d, "", false, l2Var));
        l2 l2Var3 = l2.UINT32;
        s1Var.h(new s0("clip_start", 6, 134, 1.0d, 0.0d, "ms", false, l2Var3));
        s1Var.h(new s0("clip_end", 7, 134, 1.0d, 0.0d, "ms", false, l2Var3));
    }

    public m3(s1 s1Var) {
        super(s1Var);
    }
}
