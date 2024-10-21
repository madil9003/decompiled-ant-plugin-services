package k1;

/* loaded from: classes.dex */
public class c0 extends s1 {

    /* renamed from: g */
    protected static final s1 f2114g;

    static {
        s1 s1Var = new s1("device_aux_battery_info", 375);
        f2114g = s1Var;
        s1Var.h(new s0("timestamp", 253, 134, 1.0d, 0.0d, "", false, l2.DATE_TIME));
        s1Var.h(new s0("device_index", 0, 2, 1.0d, 0.0d, "", false, l2.DEVICE_INDEX));
        s1Var.h(new s0("battery_voltage", 1, 132, 256.0d, 0.0d, "V", false, l2.UINT16));
        s1Var.h(new s0("battery_status", 2, 2, 1.0d, 0.0d, "", false, l2.BATTERY_STATUS));
        s1Var.h(new s0("battery_identifier", 3, 2, 1.0d, 0.0d, "", false, l2.UINT8));
    }

    public c0(s1 s1Var) {
        super(s1Var);
    }
}
