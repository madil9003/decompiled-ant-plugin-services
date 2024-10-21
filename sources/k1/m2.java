package k1;

/* loaded from: classes.dex */
public class m2 extends s1 {

    /* renamed from: g */
    protected static final s1 f2340g;

    static {
        s1 s1Var = new s1("record", 20);
        f2340g = s1Var;
        s1Var.h(new s0("timestamp", 253, 134, 1.0d, 0.0d, "s", false, l2.DATE_TIME));
        l2 l2Var = l2.SINT32;
        s1Var.h(new s0("position_lat", 0, 133, 1.0d, 0.0d, "semicircles", false, l2Var));
        s1Var.h(new s0("position_long", 1, 133, 1.0d, 0.0d, "semicircles", false, l2Var));
        l2 l2Var2 = l2.UINT16;
        s1Var.h(new s0("altitude", 2, 132, 5.0d, 500.0d, "m", false, l2Var2));
        ((s0) s1Var.f2382d.get(3)).f2375j.add(new w0(78, false, 16, 5.0d, 500.0d));
        l2 l2Var3 = l2.UINT8;
        s1Var.h(new s0("heart_rate", 3, 2, 1.0d, 0.0d, "bpm", false, l2Var3));
        s1Var.h(new s0("cadence", 4, 2, 1.0d, 0.0d, "rpm", false, l2Var3));
        l2 l2Var4 = l2.UINT32;
        s1Var.h(new s0("distance", 5, 134, 100.0d, 0.0d, "m", true, l2Var4));
        s1Var.h(new s0("speed", 6, 132, 1000.0d, 0.0d, "m/s", false, l2Var2));
        ((s0) s1Var.f2382d.get(7)).f2375j.add(new w0(73, false, 16, 1000.0d, 0.0d));
        s1Var.h(new s0("power", 7, 132, 1.0d, 0.0d, "watts", false, l2Var2));
        s1Var.h(new s0("compressed_speed_distance", 8, 13, 1.0d, 0.0d, "", false, l2.BYTE));
        ((s0) s1Var.f2382d.get(9)).f2375j.add(new w0(6, false, 12, 100.0d, 0.0d));
        ((s0) s1Var.f2382d.get(9)).f2375j.add(new w0(5, true, 12, 16.0d, 0.0d));
        l2 l2Var5 = l2.SINT16;
        s1Var.h(new s0("grade", 9, 131, 100.0d, 0.0d, "%", false, l2Var5));
        s1Var.h(new s0("resistance", 10, 2, 1.0d, 0.0d, "", false, l2Var3));
        s1Var.h(new s0("time_from_course", 11, 133, 1000.0d, 0.0d, "s", false, l2Var));
        s1Var.h(new s0("cycle_length", 12, 2, 100.0d, 0.0d, "m", false, l2Var3));
        l2 l2Var6 = l2.SINT8;
        s1Var.h(new s0("temperature", 13, 1, 1.0d, 0.0d, "C", false, l2Var6));
        s1Var.h(new s0("speed_1s", 17, 2, 16.0d, 0.0d, "m/s", false, l2Var3));
        s1Var.h(new s0("cycles", 18, 2, 1.0d, 0.0d, "cycles", false, l2Var3));
        ((s0) s1Var.f2382d.get(16)).f2375j.add(new w0(19, true, 8, 1.0d, 0.0d));
        s1Var.h(new s0("total_cycles", 19, 134, 1.0d, 0.0d, "cycles", true, l2Var4));
        s1Var.h(new s0("compressed_accumulated_power", 28, 132, 1.0d, 0.0d, "watts", false, l2Var2));
        ((s0) s1Var.f2382d.get(18)).f2375j.add(new w0(29, true, 16, 1.0d, 0.0d));
        s1Var.h(new s0("accumulated_power", 29, 134, 1.0d, 0.0d, "watts", true, l2Var4));
        s1Var.h(new s0("left_right_balance", 30, 2, 1.0d, 0.0d, "", false, l2.LEFT_RIGHT_BALANCE));
        s1Var.h(new s0("gps_accuracy", 31, 2, 1.0d, 0.0d, "m", false, l2Var3));
        s1Var.h(new s0("vertical_speed", 32, 131, 1000.0d, 0.0d, "m/s", false, l2Var5));
        s1Var.h(new s0("calories", 33, 132, 1.0d, 0.0d, "kcal", false, l2Var2));
        s1Var.h(new s0("vertical_oscillation", 39, 132, 10.0d, 0.0d, "mm", false, l2Var2));
        s1Var.h(new s0("stance_time_percent", 40, 132, 100.0d, 0.0d, "percent", false, l2Var2));
        s1Var.h(new s0("stance_time", 41, 132, 10.0d, 0.0d, "ms", false, l2Var2));
        s1Var.h(new s0("activity_type", 42, 0, 1.0d, 0.0d, "", false, l2.ACTIVITY_TYPE));
        s1Var.h(new s0("left_torque_effectiveness", 43, 2, 2.0d, 0.0d, "percent", false, l2Var3));
        s1Var.h(new s0("right_torque_effectiveness", 44, 2, 2.0d, 0.0d, "percent", false, l2Var3));
        s1Var.h(new s0("left_pedal_smoothness", 45, 2, 2.0d, 0.0d, "percent", false, l2Var3));
        s1Var.h(new s0("right_pedal_smoothness", 46, 2, 2.0d, 0.0d, "percent", false, l2Var3));
        s1Var.h(new s0("combined_pedal_smoothness", 47, 2, 2.0d, 0.0d, "percent", false, l2Var3));
        s1Var.h(new s0("time128", 48, 2, 128.0d, 0.0d, "s", false, l2Var3));
        s1Var.h(new s0("stroke_type", 49, 0, 1.0d, 0.0d, "", false, l2.STROKE_TYPE));
        s1Var.h(new s0("zone", 50, 2, 1.0d, 0.0d, "", false, l2Var3));
        s1Var.h(new s0("ball_speed", 51, 132, 100.0d, 0.0d, "m/s", false, l2Var2));
        s1Var.h(new s0("cadence256", 52, 132, 256.0d, 0.0d, "rpm", false, l2Var2));
        s1Var.h(new s0("fractional_cadence", 53, 2, 128.0d, 0.0d, "rpm", false, l2Var3));
        s1Var.h(new s0("total_hemoglobin_conc", 54, 132, 100.0d, 0.0d, "g/dL", false, l2Var2));
        s1Var.h(new s0("total_hemoglobin_conc_min", 55, 132, 100.0d, 0.0d, "g/dL", false, l2Var2));
        s1Var.h(new s0("total_hemoglobin_conc_max", 56, 132, 100.0d, 0.0d, "g/dL", false, l2Var2));
        s1Var.h(new s0("saturated_hemoglobin_percent", 57, 132, 10.0d, 0.0d, "%", false, l2Var2));
        s1Var.h(new s0("saturated_hemoglobin_percent_min", 58, 132, 10.0d, 0.0d, "%", false, l2Var2));
        s1Var.h(new s0("saturated_hemoglobin_percent_max", 59, 132, 10.0d, 0.0d, "%", false, l2Var2));
        s1Var.h(new s0("device_index", 62, 2, 1.0d, 0.0d, "", false, l2.DEVICE_INDEX));
        s1Var.h(new s0("left_pco", 67, 1, 1.0d, 0.0d, "mm", false, l2Var6));
        s1Var.h(new s0("right_pco", 68, 1, 1.0d, 0.0d, "mm", false, l2Var6));
        s1Var.h(new s0("left_power_phase", 69, 2, 0.7111111d, 0.0d, "degrees", false, l2Var3));
        s1Var.h(new s0("left_power_phase_peak", 70, 2, 0.7111111d, 0.0d, "degrees", false, l2Var3));
        s1Var.h(new s0("right_power_phase", 71, 2, 0.7111111d, 0.0d, "degrees", false, l2Var3));
        s1Var.h(new s0("right_power_phase_peak", 72, 2, 0.7111111d, 0.0d, "degrees", false, l2Var3));
        s1Var.h(new s0("enhanced_speed", 73, 134, 1000.0d, 0.0d, "m/s", false, l2Var4));
        s1Var.h(new s0("enhanced_altitude", 78, 134, 5.0d, 500.0d, "m", false, l2Var4));
        s1Var.h(new s0("battery_soc", 81, 2, 2.0d, 0.0d, "percent", false, l2Var3));
        s1Var.h(new s0("motor_power", 82, 132, 1.0d, 0.0d, "watts", false, l2Var2));
        s1Var.h(new s0("vertical_ratio", 83, 132, 100.0d, 0.0d, "percent", false, l2Var2));
        s1Var.h(new s0("stance_time_balance", 84, 132, 100.0d, 0.0d, "percent", false, l2Var2));
        s1Var.h(new s0("step_length", 85, 132, 10.0d, 0.0d, "mm", false, l2Var2));
        s1Var.h(new s0("absolute_pressure", 91, 134, 1.0d, 0.0d, "Pa", false, l2Var4));
        s1Var.h(new s0("depth", 92, 134, 1000.0d, 0.0d, "m", false, l2Var4));
        s1Var.h(new s0("next_stop_depth", 93, 134, 1000.0d, 0.0d, "m", false, l2Var4));
        s1Var.h(new s0("next_stop_time", 94, 134, 1.0d, 0.0d, "s", false, l2Var4));
        s1Var.h(new s0("time_to_surface", 95, 134, 1.0d, 0.0d, "s", false, l2Var4));
        s1Var.h(new s0("ndl_time", 96, 134, 1.0d, 0.0d, "s", false, l2Var4));
        s1Var.h(new s0("cns_load", 97, 2, 1.0d, 0.0d, "percent", false, l2Var3));
        s1Var.h(new s0("n2_load", 98, 132, 1.0d, 0.0d, "percent", false, l2Var2));
        s1Var.h(new s0("respiration_rate", 99, 2, 1.0d, 0.0d, "s", false, l2Var3));
        ((s0) s1Var.f2382d.get(67)).f2375j.add(new w0(108, false, 8, 1.0d, 0.0d));
        s1Var.h(new s0("enhanced_respiration_rate", 108, 132, 100.0d, 0.0d, "Breaths/min", false, l2Var2));
        l2 l2Var7 = l2.FLOAT32;
        s1Var.h(new s0("grit", 114, 136, 1.0d, 0.0d, "", false, l2Var7));
        s1Var.h(new s0("flow", 115, 136, 1.0d, 0.0d, "", false, l2Var7));
        s1Var.h(new s0("ebike_travel_range", 117, 132, 1.0d, 0.0d, "km", false, l2Var2));
        s1Var.h(new s0("ebike_battery_level", 118, 2, 1.0d, 0.0d, "percent", false, l2Var3));
        s1Var.h(new s0("ebike_assist_mode", 119, 2, 1.0d, 0.0d, "depends on sensor", false, l2Var3));
        s1Var.h(new s0("ebike_assist_level_percent", 120, 2, 1.0d, 0.0d, "percent", false, l2Var3));
        s1Var.h(new s0("air_time_remaining", 123, 134, 1.0d, 0.0d, "s", false, l2Var4));
        s1Var.h(new s0("pressure_sac", 124, 132, 100.0d, 0.0d, "bar/min", false, l2Var2));
        s1Var.h(new s0("volume_sac", 125, 132, 100.0d, 0.0d, "L/min", false, l2Var2));
        s1Var.h(new s0("rmv", 126, 132, 100.0d, 0.0d, "L/min", false, l2Var2));
        s1Var.h(new s0("ascent_rate", 127, 133, 1000.0d, 0.0d, "m/s", false, l2Var));
        s1Var.h(new s0("po2", 129, 2, 100.0d, 0.0d, "percent", false, l2Var3));
        s1Var.h(new s0("core_temperature", 139, 132, 100.0d, 0.0d, "C", false, l2Var2));
    }

    public m2() {
        super(r0.b(20));
    }

    public m2(s1 s1Var) {
        super(s1Var);
    }
}
