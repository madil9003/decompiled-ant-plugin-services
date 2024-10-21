package k1;

/* loaded from: classes.dex */
public class h extends s1 {

    /* renamed from: g */
    protected static final s1 f2183g;

    static {
        s1 s1Var = new s1("bike_profile", 6);
        f2183g = s1Var;
        s1Var.h(new s0("message_index", 254, 132, 1.0d, 0.0d, "", false, l2.MESSAGE_INDEX));
        s1Var.h(new s0("name", 0, 7, 1.0d, 0.0d, "", false, l2.STRING));
        s1Var.h(new s0("sport", 1, 0, 1.0d, 0.0d, "", false, l2.SPORT));
        s1Var.h(new s0("sub_sport", 2, 0, 1.0d, 0.0d, "", false, l2.SUB_SPORT));
        s1Var.h(new s0("odometer", 3, 134, 100.0d, 0.0d, "m", false, l2.UINT32));
        l2 l2Var = l2.UINT16Z;
        s1Var.h(new s0("bike_spd_ant_id", 4, 139, 1.0d, 0.0d, "", false, l2Var));
        s1Var.h(new s0("bike_cad_ant_id", 5, 139, 1.0d, 0.0d, "", false, l2Var));
        s1Var.h(new s0("bike_spdcad_ant_id", 6, 139, 1.0d, 0.0d, "", false, l2Var));
        s1Var.h(new s0("bike_power_ant_id", 7, 139, 1.0d, 0.0d, "", false, l2Var));
        l2 l2Var2 = l2.UINT16;
        s1Var.h(new s0("custom_wheelsize", 8, 132, 1000.0d, 0.0d, "m", false, l2Var2));
        s1Var.h(new s0("auto_wheelsize", 9, 132, 1000.0d, 0.0d, "m", false, l2Var2));
        s1Var.h(new s0("bike_weight", 10, 132, 10.0d, 0.0d, "kg", false, l2Var2));
        s1Var.h(new s0("power_cal_factor", 11, 132, 10.0d, 0.0d, "%", false, l2Var2));
        l2 l2Var3 = l2.BOOL;
        s1Var.h(new s0("auto_wheel_cal", 12, 0, 1.0d, 0.0d, "", false, l2Var3));
        s1Var.h(new s0("auto_power_zero", 13, 0, 1.0d, 0.0d, "", false, l2Var3));
        l2 l2Var4 = l2.UINT8;
        s1Var.h(new s0("id", 14, 2, 1.0d, 0.0d, "", false, l2Var4));
        s1Var.h(new s0("spd_enabled", 15, 0, 1.0d, 0.0d, "", false, l2Var3));
        s1Var.h(new s0("cad_enabled", 16, 0, 1.0d, 0.0d, "", false, l2Var3));
        s1Var.h(new s0("spdcad_enabled", 17, 0, 1.0d, 0.0d, "", false, l2Var3));
        s1Var.h(new s0("power_enabled", 18, 0, 1.0d, 0.0d, "", false, l2Var3));
        s1Var.h(new s0("crank_length", 19, 2, 2.0d, -110.0d, "mm", false, l2Var4));
        s1Var.h(new s0("enabled", 20, 0, 1.0d, 0.0d, "", false, l2Var3));
        l2 l2Var5 = l2.UINT8Z;
        s1Var.h(new s0("bike_spd_ant_id_trans_type", 21, 10, 1.0d, 0.0d, "", false, l2Var5));
        s1Var.h(new s0("bike_cad_ant_id_trans_type", 22, 10, 1.0d, 0.0d, "", false, l2Var5));
        s1Var.h(new s0("bike_spdcad_ant_id_trans_type", 23, 10, 1.0d, 0.0d, "", false, l2Var5));
        s1Var.h(new s0("bike_power_ant_id_trans_type", 24, 10, 1.0d, 0.0d, "", false, l2Var5));
        s1Var.h(new s0("odometer_rollover", 37, 2, 1.0d, 0.0d, "", false, l2Var4));
        s1Var.h(new s0("front_gear_num", 38, 10, 1.0d, 0.0d, "", false, l2Var5));
        s1Var.h(new s0("front_gear", 39, 10, 1.0d, 0.0d, "", false, l2Var5));
        s1Var.h(new s0("rear_gear_num", 40, 10, 1.0d, 0.0d, "", false, l2Var5));
        s1Var.h(new s0("rear_gear", 41, 10, 1.0d, 0.0d, "", false, l2Var5));
        s1Var.h(new s0("shimano_di2_enabled", 44, 0, 1.0d, 0.0d, "", false, l2Var3));
    }

    public h(s1 s1Var) {
        super(s1Var);
    }
}
