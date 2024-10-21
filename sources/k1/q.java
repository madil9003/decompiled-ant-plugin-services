package k1;

/* loaded from: classes.dex */
public class q extends s1 {

    /* renamed from: g */
    protected static final s1 f2357g;

    static {
        s1 s1Var = new s1("camera_event", 161);
        f2357g = s1Var;
        s1Var.h(new s0("timestamp", 253, 134, 1.0d, 0.0d, "s", false, l2.DATE_TIME));
        s1Var.h(new s0("timestamp_ms", 0, 132, 1.0d, 0.0d, "ms", false, l2.UINT16));
        s1Var.h(new s0("camera_event_type", 1, 0, 1.0d, 0.0d, "", false, l2.CAMERA_EVENT_TYPE));
        s1Var.h(new s0("camera_file_uuid", 2, 7, 1.0d, 0.0d, "", false, l2.STRING));
        s1Var.h(new s0("camera_orientation", 3, 0, 1.0d, 0.0d, "", false, l2.CAMERA_ORIENTATION_TYPE));
    }

    public q(s1 s1Var) {
        super(s1Var);
    }
}
