package k1;

/* loaded from: classes.dex */
public class i0 extends s1 {

    /* renamed from: g */
    protected static final s1 f2189g;

    static {
        s1 s1Var = new s1("dive_settings", 258);
        f2189g = s1Var;
        s1Var.h(new s0("timestamp", 253, 134, 1.0d, 0.0d, "", false, l2.DATE_TIME));
        l2 l2Var = l2.MESSAGE_INDEX;
        s1Var.h(new s0("message_index", 254, 132, 1.0d, 0.0d, "", false, l2Var));
        s1Var.h(new s0("name", 0, 7, 1.0d, 0.0d, "", false, l2.STRING));
        s1Var.h(new s0("model", 1, 0, 1.0d, 0.0d, "", false, l2.TISSUE_MODEL_TYPE));
        l2 l2Var2 = l2.UINT8;
        s1Var.h(new s0("gf_low", 2, 2, 1.0d, 0.0d, "percent", false, l2Var2));
        s1Var.h(new s0("gf_high", 3, 2, 1.0d, 0.0d, "percent", false, l2Var2));
        s1Var.h(new s0("water_type", 4, 0, 1.0d, 0.0d, "", false, l2.WATER_TYPE));
        l2 l2Var3 = l2.FLOAT32;
        s1Var.h(new s0("water_density", 5, 136, 1.0d, 0.0d, "kg/m^3", false, l2Var3));
        s1Var.h(new s0("po2_warn", 6, 2, 100.0d, 0.0d, "percent", false, l2Var2));
        s1Var.h(new s0("po2_critical", 7, 2, 100.0d, 0.0d, "percent", false, l2Var2));
        s1Var.h(new s0("po2_deco", 8, 2, 100.0d, 0.0d, "percent", false, l2Var2));
        l2 l2Var4 = l2.BOOL;
        s1Var.h(new s0("safety_stop_enabled", 9, 0, 1.0d, 0.0d, "", false, l2Var4));
        s1Var.h(new s0("bottom_depth", 10, 136, 1.0d, 0.0d, "", false, l2Var3));
        l2 l2Var5 = l2.UINT32;
        s1Var.h(new s0("bottom_time", 11, 134, 1.0d, 0.0d, "", false, l2Var5));
        s1Var.h(new s0("apnea_countdown_enabled", 12, 0, 1.0d, 0.0d, "", false, l2Var4));
        s1Var.h(new s0("apnea_countdown_time", 13, 134, 1.0d, 0.0d, "", false, l2Var5));
        s1Var.h(new s0("backlight_mode", 14, 0, 1.0d, 0.0d, "", false, l2.DIVE_BACKLIGHT_MODE));
        s1Var.h(new s0("backlight_brightness", 15, 2, 1.0d, 0.0d, "", false, l2Var2));
        s1Var.h(new s0("backlight_timeout", 16, 2, 1.0d, 0.0d, "", false, l2.BACKLIGHT_TIMEOUT));
        l2 l2Var6 = l2.UINT16;
        s1Var.h(new s0("repeat_dive_interval", 17, 132, 1.0d, 0.0d, "s", false, l2Var6));
        s1Var.h(new s0("safety_stop_time", 18, 132, 1.0d, 0.0d, "s", false, l2Var6));
        s1Var.h(new s0("heart_rate_source_type", 19, 0, 1.0d, 0.0d, "", false, l2.SOURCE_TYPE));
        s1Var.h(new s0("heart_rate_source", 20, 2, 1.0d, 0.0d, "", false, l2Var2));
        ((s0) s1Var.f2382d.get(22)).f2376k.add(new d3("heart_rate_antplus_device_type", 2, 1.0d, 0.0d, ""));
        ((d3) ((s0) s1Var.f2382d.get(22)).f2376k.get(0)).b(19, 1L);
        ((s0) s1Var.f2382d.get(22)).f2376k.add(new d3("heart_rate_local_device_type", 2, 1.0d, 0.0d, ""));
        ((d3) ((s0) s1Var.f2382d.get(22)).f2376k.get(1)).b(19, 5L);
        s1Var.h(new s0("travel_gas", 21, 132, 1.0d, 0.0d, "", false, l2Var));
        l2 l2Var7 = l2.CCR_SETPOINT_SWITCH_MODE;
        s1Var.h(new s0("ccr_low_setpoint_switch_mode", 22, 0, 1.0d, 0.0d, "", false, l2Var7));
        s1Var.h(new s0("ccr_low_setpoint", 23, 2, 100.0d, 0.0d, "percent", false, l2Var2));
        s1Var.h(new s0("ccr_low_setpoint_depth", 24, 134, 1000.0d, 0.0d, "m", false, l2Var5));
        s1Var.h(new s0("ccr_high_setpoint_switch_mode", 25, 0, 1.0d, 0.0d, "", false, l2Var7));
        s1Var.h(new s0("ccr_high_setpoint", 26, 2, 100.0d, 0.0d, "percent", false, l2Var2));
        s1Var.h(new s0("ccr_high_setpoint_depth", 27, 134, 1000.0d, 0.0d, "m", false, l2Var5));
        s1Var.h(new s0("gas_consumption_display", 29, 0, 1.0d, 0.0d, "", false, l2.GAS_CONSUMPTION_RATE_TYPE));
        s1Var.h(new s0("up_key_enabled", 30, 0, 1.0d, 0.0d, "", false, l2Var4));
        s1Var.h(new s0("dive_sounds", 35, 0, 1.0d, 0.0d, "", false, l2.TONE));
        s1Var.h(new s0("last_stop_multiple", 36, 2, 10.0d, 0.0d, "", false, l2Var2));
        s1Var.h(new s0("no_fly_time_mode", 37, 0, 1.0d, 0.0d, "", false, l2.NO_FLY_TIME_MODE));
    }

    public i0(s1 s1Var) {
        super(s1Var);
    }
}
