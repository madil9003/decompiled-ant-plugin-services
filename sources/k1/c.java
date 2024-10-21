package k1;

/* loaded from: classes.dex */
public class c extends s1 {

    /* renamed from: g */
    protected static final s1 f2113g;

    static {
        s1 s1Var = new s1("ant_channel_id", 82);
        f2113g = s1Var;
        s1Var.h(new s0("channel_number", 0, 2, 1.0d, 0.0d, "", false, l2.UINT8));
        l2 l2Var = l2.UINT8Z;
        s1Var.h(new s0("device_type", 1, 10, 1.0d, 0.0d, "", false, l2Var));
        s1Var.h(new s0("device_number", 2, 139, 1.0d, 0.0d, "", false, l2.UINT16Z));
        s1Var.h(new s0("transmission_type", 3, 10, 1.0d, 0.0d, "", false, l2Var));
        s1Var.h(new s0("device_index", 4, 2, 1.0d, 0.0d, "", false, l2.DEVICE_INDEX));
    }

    public c(s1 s1Var) {
        super(s1Var);
    }
}
