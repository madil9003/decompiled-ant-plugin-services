package k1;

/* loaded from: classes.dex */
public class a extends s1 {

    /* renamed from: g */
    protected static final s1 f2094g;

    static {
        s1 s1Var = new s1("accelerometer_data", 165);
        f2094g = s1Var;
        s1Var.h(new s0("timestamp", 253, 134, 1.0d, 0.0d, "s", false, l2.DATE_TIME));
        l2 l2Var = l2.UINT16;
        s1Var.h(new s0("timestamp_ms", 0, 132, 1.0d, 0.0d, "ms", false, l2Var));
        s1Var.h(new s0("sample_time_offset", 1, 132, 1.0d, 0.0d, "ms", false, l2Var));
        s1Var.h(new s0("accel_x", 2, 132, 1.0d, 0.0d, "counts", false, l2Var));
        s1Var.h(new s0("accel_y", 3, 132, 1.0d, 0.0d, "counts", false, l2Var));
        s1Var.h(new s0("accel_z", 4, 132, 1.0d, 0.0d, "counts", false, l2Var));
        l2 l2Var2 = l2.FLOAT32;
        s1Var.h(new s0("calibrated_accel_x", 5, 136, 1.0d, 0.0d, "g", false, l2Var2));
        s1Var.h(new s0("calibrated_accel_y", 6, 136, 1.0d, 0.0d, "g", false, l2Var2));
        s1Var.h(new s0("calibrated_accel_z", 7, 136, 1.0d, 0.0d, "g", false, l2Var2));
        l2 l2Var3 = l2.SINT16;
        s1Var.h(new s0("compressed_calibrated_accel_x", 8, 131, 1.0d, 0.0d, "mG", false, l2Var3));
        s1Var.h(new s0("compressed_calibrated_accel_y", 9, 131, 1.0d, 0.0d, "mG", false, l2Var3));
        s1Var.h(new s0("compressed_calibrated_accel_z", 10, 131, 1.0d, 0.0d, "mG", false, l2Var3));
    }

    public a(s1 s1Var) {
        super(s1Var);
    }
}
