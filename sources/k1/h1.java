package k1;

/* loaded from: classes.dex */
public class h1 extends s1 {

    /* renamed from: g */
    protected static final s1 f2185g;

    static {
        s1 s1Var = new s1("gyroscope_data", 164);
        f2185g = s1Var;
        s1Var.h(new s0("timestamp", 253, 134, 1.0d, 0.0d, "s", false, l2.DATE_TIME));
        l2 l2Var = l2.UINT16;
        s1Var.h(new s0("timestamp_ms", 0, 132, 1.0d, 0.0d, "ms", false, l2Var));
        s1Var.h(new s0("sample_time_offset", 1, 132, 1.0d, 0.0d, "ms", false, l2Var));
        s1Var.h(new s0("gyro_x", 2, 132, 1.0d, 0.0d, "counts", false, l2Var));
        s1Var.h(new s0("gyro_y", 3, 132, 1.0d, 0.0d, "counts", false, l2Var));
        s1Var.h(new s0("gyro_z", 4, 132, 1.0d, 0.0d, "counts", false, l2Var));
        l2 l2Var2 = l2.FLOAT32;
        s1Var.h(new s0("calibrated_gyro_x", 5, 136, 1.0d, 0.0d, "deg/s", false, l2Var2));
        s1Var.h(new s0("calibrated_gyro_y", 6, 136, 1.0d, 0.0d, "deg/s", false, l2Var2));
        s1Var.h(new s0("calibrated_gyro_z", 7, 136, 1.0d, 0.0d, "deg/s", false, l2Var2));
    }

    public h1(s1 s1Var) {
        super(s1Var);
    }
}
