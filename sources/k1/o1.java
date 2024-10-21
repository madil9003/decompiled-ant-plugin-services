package k1;

/* loaded from: classes.dex */
public class o1 extends s1 implements z1 {

    /* renamed from: g */
    protected static final s1 f2349g;

    static {
        s1 s1Var = new s1("lap", 19);
        f2349g = s1Var;
        l2 l2Var = l2.MESSAGE_INDEX;
        s1Var.h(new s0("message_index", 254, 132, 1.0d, 0.0d, "", false, l2Var));
        l2 l2Var2 = l2.DATE_TIME;
        s1Var.h(new s0("timestamp", 253, 134, 1.0d, 0.0d, "s", false, l2Var2));
        s1Var.h(new s0("event", 0, 0, 1.0d, 0.0d, "", false, l2.EVENT));
        s1Var.h(new s0("event_type", 1, 0, 1.0d, 0.0d, "", false, l2.EVENT_TYPE));
        s1Var.h(new s0("start_time", 2, 134, 1.0d, 0.0d, "", false, l2Var2));
        l2 l2Var3 = l2.SINT32;
        s1Var.h(new s0("start_position_lat", 3, 133, 1.0d, 0.0d, "semicircles", false, l2Var3));
        s1Var.h(new s0("start_position_long", 4, 133, 1.0d, 0.0d, "semicircles", false, l2Var3));
        s1Var.h(new s0("end_position_lat", 5, 133, 1.0d, 0.0d, "semicircles", false, l2Var3));
        s1Var.h(new s0("end_position_long", 6, 133, 1.0d, 0.0d, "semicircles", false, l2Var3));
        l2 l2Var4 = l2.UINT32;
        s1Var.h(new s0("total_elapsed_time", 7, 134, 1000.0d, 0.0d, "s", false, l2Var4));
        s1Var.h(new s0("total_timer_time", 8, 134, 1000.0d, 0.0d, "s", false, l2Var4));
        s1Var.h(new s0("total_distance", 9, 134, 100.0d, 0.0d, "m", false, l2Var4));
        s1Var.h(new s0("total_cycles", 10, 134, 1.0d, 0.0d, "cycles", false, l2Var4));
        ((s0) s1Var.f2382d.get(12)).f2376k.add(new d3("total_strides", 134, 1.0d, 0.0d, "strides"));
        ((d3) ((s0) s1Var.f2382d.get(12)).f2376k.get(0)).b(25, 1L);
        ((d3) ((s0) s1Var.f2382d.get(12)).f2376k.get(0)).b(25, 11L);
        ((s0) s1Var.f2382d.get(12)).f2376k.add(new d3("total_strokes", 134, 1.0d, 0.0d, "strokes"));
        ((d3) ((s0) s1Var.f2382d.get(12)).f2376k.get(1)).b(25, 2L);
        ((d3) ((s0) s1Var.f2382d.get(12)).f2376k.get(1)).b(25, 5L);
        ((d3) ((s0) s1Var.f2382d.get(12)).f2376k.get(1)).b(25, 15L);
        ((d3) ((s0) s1Var.f2382d.get(12)).f2376k.get(1)).b(25, 37L);
        l2 l2Var5 = l2.UINT16;
        s1Var.h(new s0("total_calories", 11, 132, 1.0d, 0.0d, "kcal", false, l2Var5));
        s1Var.h(new s0("total_fat_calories", 12, 132, 1.0d, 0.0d, "kcal", false, l2Var5));
        s1Var.h(new s0("avg_speed", 13, 132, 1000.0d, 0.0d, "m/s", false, l2Var5));
        ((s0) s1Var.f2382d.get(15)).f2375j.add(new w0(110, false, 16, 1000.0d, 0.0d));
        s1Var.h(new s0("max_speed", 14, 132, 1000.0d, 0.0d, "m/s", false, l2Var5));
        ((s0) s1Var.f2382d.get(16)).f2375j.add(new w0(111, false, 16, 1000.0d, 0.0d));
        l2 l2Var6 = l2.UINT8;
        s1Var.h(new s0("avg_heart_rate", 15, 2, 1.0d, 0.0d, "bpm", false, l2Var6));
        s1Var.h(new s0("max_heart_rate", 16, 2, 1.0d, 0.0d, "bpm", false, l2Var6));
        s1Var.h(new s0("avg_cadence", 17, 2, 1.0d, 0.0d, "rpm", false, l2Var6));
        ((s0) s1Var.f2382d.get(19)).f2376k.add(new d3("avg_running_cadence", 2, 1.0d, 0.0d, "strides/min"));
        ((d3) ((s0) s1Var.f2382d.get(19)).f2376k.get(0)).b(25, 1L);
        s1Var.h(new s0("max_cadence", 18, 2, 1.0d, 0.0d, "rpm", false, l2Var6));
        ((s0) s1Var.f2382d.get(20)).f2376k.add(new d3("max_running_cadence", 2, 1.0d, 0.0d, "strides/min"));
        ((d3) ((s0) s1Var.f2382d.get(20)).f2376k.get(0)).b(25, 1L);
        s1Var.h(new s0("avg_power", 19, 132, 1.0d, 0.0d, "watts", false, l2Var5));
        s1Var.h(new s0("max_power", 20, 132, 1.0d, 0.0d, "watts", false, l2Var5));
        s1Var.h(new s0("total_ascent", 21, 132, 1.0d, 0.0d, "m", false, l2Var5));
        s1Var.h(new s0("total_descent", 22, 132, 1.0d, 0.0d, "m", false, l2Var5));
        s1Var.h(new s0("intensity", 23, 0, 1.0d, 0.0d, "", false, l2.INTENSITY));
        s1Var.h(new s0("lap_trigger", 24, 0, 1.0d, 0.0d, "", false, l2.LAP_TRIGGER));
        s1Var.h(new s0("sport", 25, 0, 1.0d, 0.0d, "", false, l2.SPORT));
        s1Var.h(new s0("event_group", 26, 2, 1.0d, 0.0d, "", false, l2Var6));
        s1Var.h(new s0("num_lengths", 32, 132, 1.0d, 0.0d, "lengths", false, l2Var5));
        s1Var.h(new s0("normalized_power", 33, 132, 1.0d, 0.0d, "watts", false, l2Var5));
        s1Var.h(new s0("left_right_balance", 34, 132, 1.0d, 0.0d, "", false, l2.LEFT_RIGHT_BALANCE_100));
        s1Var.h(new s0("first_length_index", 35, 132, 1.0d, 0.0d, "", false, l2Var5));
        s1Var.h(new s0("avg_stroke_distance", 37, 132, 100.0d, 0.0d, "m", false, l2Var5));
        s1Var.h(new s0("swim_stroke", 38, 0, 1.0d, 0.0d, "", false, l2.SWIM_STROKE));
        s1Var.h(new s0("sub_sport", 39, 0, 1.0d, 0.0d, "", false, l2.SUB_SPORT));
        s1Var.h(new s0("num_active_lengths", 40, 132, 1.0d, 0.0d, "lengths", false, l2Var5));
        s1Var.h(new s0("total_work", 41, 134, 1.0d, 0.0d, "J", false, l2Var4));
        s1Var.h(new s0("avg_altitude", 42, 132, 5.0d, 500.0d, "m", false, l2Var5));
        ((s0) s1Var.f2382d.get(38)).f2375j.add(new w0(112, false, 16, 5.0d, 500.0d));
        s1Var.h(new s0("max_altitude", 43, 132, 5.0d, 500.0d, "m", false, l2Var5));
        ((s0) s1Var.f2382d.get(39)).f2375j.add(new w0(114, false, 16, 5.0d, 500.0d));
        s1Var.h(new s0("gps_accuracy", 44, 2, 1.0d, 0.0d, "m", false, l2Var6));
        l2 l2Var7 = l2.SINT16;
        s1Var.h(new s0("avg_grade", 45, 131, 100.0d, 0.0d, "%", false, l2Var7));
        s1Var.h(new s0("avg_pos_grade", 46, 131, 100.0d, 0.0d, "%", false, l2Var7));
        s1Var.h(new s0("avg_neg_grade", 47, 131, 100.0d, 0.0d, "%", false, l2Var7));
        s1Var.h(new s0("max_pos_grade", 48, 131, 100.0d, 0.0d, "%", false, l2Var7));
        s1Var.h(new s0("max_neg_grade", 49, 131, 100.0d, 0.0d, "%", false, l2Var7));
        l2 l2Var8 = l2.SINT8;
        s1Var.h(new s0("avg_temperature", 50, 1, 1.0d, 0.0d, "C", false, l2Var8));
        s1Var.h(new s0("max_temperature", 51, 1, 1.0d, 0.0d, "C", false, l2Var8));
        s1Var.h(new s0("total_moving_time", 52, 134, 1000.0d, 0.0d, "s", false, l2Var4));
        s1Var.h(new s0("avg_pos_vertical_speed", 53, 131, 1000.0d, 0.0d, "m/s", false, l2Var7));
        s1Var.h(new s0("avg_neg_vertical_speed", 54, 131, 1000.0d, 0.0d, "m/s", false, l2Var7));
        s1Var.h(new s0("max_pos_vertical_speed", 55, 131, 1000.0d, 0.0d, "m/s", false, l2Var7));
        s1Var.h(new s0("max_neg_vertical_speed", 56, 131, 1000.0d, 0.0d, "m/s", false, l2Var7));
        s1Var.h(new s0("time_in_hr_zone", 57, 134, 1000.0d, 0.0d, "s", false, l2Var4));
        s1Var.h(new s0("time_in_speed_zone", 58, 134, 1000.0d, 0.0d, "s", false, l2Var4));
        s1Var.h(new s0("time_in_cadence_zone", 59, 134, 1000.0d, 0.0d, "s", false, l2Var4));
        s1Var.h(new s0("time_in_power_zone", 60, 134, 1000.0d, 0.0d, "s", false, l2Var4));
        s1Var.h(new s0("repetition_num", 61, 132, 1.0d, 0.0d, "", false, l2Var5));
        s1Var.h(new s0("min_altitude", 62, 132, 5.0d, 500.0d, "m", false, l2Var5));
        ((s0) s1Var.f2382d.get(58)).f2375j.add(new w0(113, false, 16, 5.0d, 500.0d));
        s1Var.h(new s0("min_heart_rate", 63, 2, 1.0d, 0.0d, "bpm", false, l2Var6));
        s1Var.h(new s0("wkt_step_index", 71, 132, 1.0d, 0.0d, "", false, l2Var));
        s1Var.h(new s0("opponent_score", 74, 132, 1.0d, 0.0d, "", false, l2Var5));
        s1Var.h(new s0("stroke_count", 75, 132, 1.0d, 0.0d, "counts", false, l2Var5));
        s1Var.h(new s0("zone_count", 76, 132, 1.0d, 0.0d, "counts", false, l2Var5));
        s1Var.h(new s0("avg_vertical_oscillation", 77, 132, 10.0d, 0.0d, "mm", false, l2Var5));
        s1Var.h(new s0("avg_stance_time_percent", 78, 132, 100.0d, 0.0d, "percent", false, l2Var5));
        s1Var.h(new s0("avg_stance_time", 79, 132, 10.0d, 0.0d, "ms", false, l2Var5));
        s1Var.h(new s0("avg_fractional_cadence", 80, 2, 128.0d, 0.0d, "rpm", false, l2Var6));
        s1Var.h(new s0("max_fractional_cadence", 81, 2, 128.0d, 0.0d, "rpm", false, l2Var6));
        s1Var.h(new s0("total_fractional_cycles", 82, 2, 128.0d, 0.0d, "cycles", false, l2Var6));
        s1Var.h(new s0("player_score", 83, 132, 1.0d, 0.0d, "", false, l2Var5));
        s1Var.h(new s0("avg_total_hemoglobin_conc", 84, 132, 100.0d, 0.0d, "g/dL", false, l2Var5));
        s1Var.h(new s0("min_total_hemoglobin_conc", 85, 132, 100.0d, 0.0d, "g/dL", false, l2Var5));
        s1Var.h(new s0("max_total_hemoglobin_conc", 86, 132, 100.0d, 0.0d, "g/dL", false, l2Var5));
        s1Var.h(new s0("avg_saturated_hemoglobin_percent", 87, 132, 10.0d, 0.0d, "%", false, l2Var5));
        s1Var.h(new s0("min_saturated_hemoglobin_percent", 88, 132, 10.0d, 0.0d, "%", false, l2Var5));
        s1Var.h(new s0("max_saturated_hemoglobin_percent", 89, 132, 10.0d, 0.0d, "%", false, l2Var5));
        s1Var.h(new s0("avg_left_torque_effectiveness", 91, 2, 2.0d, 0.0d, "percent", false, l2Var6));
        s1Var.h(new s0("avg_right_torque_effectiveness", 92, 2, 2.0d, 0.0d, "percent", false, l2Var6));
        s1Var.h(new s0("avg_left_pedal_smoothness", 93, 2, 2.0d, 0.0d, "percent", false, l2Var6));
        s1Var.h(new s0("avg_right_pedal_smoothness", 94, 2, 2.0d, 0.0d, "percent", false, l2Var6));
        s1Var.h(new s0("avg_combined_pedal_smoothness", 95, 2, 2.0d, 0.0d, "percent", false, l2Var6));
        s1Var.h(new s0("time_standing", 98, 134, 1000.0d, 0.0d, "s", false, l2Var4));
        s1Var.h(new s0("stand_count", 99, 132, 1.0d, 0.0d, "", false, l2Var5));
        s1Var.h(new s0("avg_left_pco", 100, 1, 1.0d, 0.0d, "mm", false, l2Var8));
        s1Var.h(new s0("avg_right_pco", 101, 1, 1.0d, 0.0d, "mm", false, l2Var8));
        s1Var.h(new s0("avg_left_power_phase", 102, 2, 0.7111111d, 0.0d, "degrees", false, l2Var6));
        s1Var.h(new s0("avg_left_power_phase_peak", 103, 2, 0.7111111d, 0.0d, "degrees", false, l2Var6));
        s1Var.h(new s0("avg_right_power_phase", 104, 2, 0.7111111d, 0.0d, "degrees", false, l2Var6));
        s1Var.h(new s0("avg_right_power_phase_peak", 105, 2, 0.7111111d, 0.0d, "degrees", false, l2Var6));
        s1Var.h(new s0("avg_power_position", 106, 132, 1.0d, 0.0d, "watts", false, l2Var5));
        s1Var.h(new s0("max_power_position", 107, 132, 1.0d, 0.0d, "watts", false, l2Var5));
        s1Var.h(new s0("avg_cadence_position", 108, 2, 1.0d, 0.0d, "rpm", false, l2Var6));
        s1Var.h(new s0("max_cadence_position", 109, 2, 1.0d, 0.0d, "rpm", false, l2Var6));
        s1Var.h(new s0("enhanced_avg_speed", 110, 134, 1000.0d, 0.0d, "m/s", false, l2Var4));
        s1Var.h(new s0("enhanced_max_speed", 111, 134, 1000.0d, 0.0d, "m/s", false, l2Var4));
        s1Var.h(new s0("enhanced_avg_altitude", 112, 134, 5.0d, 500.0d, "m", false, l2Var4));
        s1Var.h(new s0("enhanced_min_altitude", 113, 134, 5.0d, 500.0d, "m", false, l2Var4));
        s1Var.h(new s0("enhanced_max_altitude", 114, 134, 5.0d, 500.0d, "m", false, l2Var4));
        s1Var.h(new s0("avg_lev_motor_power", 115, 132, 1.0d, 0.0d, "watts", false, l2Var5));
        s1Var.h(new s0("max_lev_motor_power", 116, 132, 1.0d, 0.0d, "watts", false, l2Var5));
        s1Var.h(new s0("lev_battery_consumption", 117, 2, 2.0d, 0.0d, "percent", false, l2Var6));
        s1Var.h(new s0("avg_vertical_ratio", 118, 132, 100.0d, 0.0d, "percent", false, l2Var5));
        s1Var.h(new s0("avg_stance_time_balance", 119, 132, 100.0d, 0.0d, "percent", false, l2Var5));
        s1Var.h(new s0("avg_step_length", 120, 132, 10.0d, 0.0d, "mm", false, l2Var5));
        s1Var.h(new s0("avg_vam", 121, 132, 1000.0d, 0.0d, "m/s", false, l2Var5));
        s1Var.h(new s0("avg_depth", 122, 134, 1000.0d, 0.0d, "m", false, l2Var4));
        s1Var.h(new s0("max_depth", 123, 134, 1000.0d, 0.0d, "m", false, l2Var4));
        s1Var.h(new s0("min_temperature", 124, 1, 1.0d, 0.0d, "C", false, l2Var8));
        s1Var.h(new s0("enhanced_avg_respiration_rate", 136, 132, 100.0d, 0.0d, "Breaths/min", false, l2Var5));
        s1Var.h(new s0("enhanced_max_respiration_rate", 137, 132, 100.0d, 0.0d, "Breaths/min", false, l2Var5));
        s1Var.h(new s0("avg_respiration_rate", 147, 2, 1.0d, 0.0d, "", false, l2Var6));
        ((s0) s1Var.f2382d.get(111)).f2375j.add(new w0(136, false, 8, 1.0d, 0.0d));
        s1Var.h(new s0("max_respiration_rate", 148, 2, 1.0d, 0.0d, "", false, l2Var6));
        ((s0) s1Var.f2382d.get(112)).f2375j.add(new w0(137, false, 8, 1.0d, 0.0d));
        l2 l2Var9 = l2.FLOAT32;
        s1Var.h(new s0("total_grit", 149, 136, 1.0d, 0.0d, "kGrit", false, l2Var9));
        s1Var.h(new s0("total_flow", 150, 136, 1.0d, 0.0d, "Flow", false, l2Var9));
        s1Var.h(new s0("jump_count", 151, 132, 1.0d, 0.0d, "", false, l2Var5));
        s1Var.h(new s0("avg_grit", 153, 136, 1.0d, 0.0d, "kGrit", false, l2Var9));
        s1Var.h(new s0("avg_flow", 154, 136, 1.0d, 0.0d, "Flow", false, l2Var9));
        s1Var.h(new s0("total_fractional_ascent", 156, 2, 100.0d, 0.0d, "m", false, l2Var6));
        s1Var.h(new s0("total_fractional_descent", 157, 2, 100.0d, 0.0d, "m", false, l2Var6));
        s1Var.h(new s0("avg_core_temperature", 158, 132, 100.0d, 0.0d, "C", false, l2Var5));
        s1Var.h(new s0("min_core_temperature", 159, 132, 100.0d, 0.0d, "C", false, l2Var5));
        s1Var.h(new s0("max_core_temperature", 160, 132, 100.0d, 0.0d, "C", false, l2Var5));
    }

    public o1(s1 s1Var) {
        super(s1Var);
    }

    @Override // k1.z1
    public Short a() {
        return n(26, 0, 65535);
    }

    @Override // k1.z1
    public void b(w wVar) {
        s(253, 0, wVar.e(), 65535);
    }

    @Override // k1.z1
    public void c(m0 m0Var) {
        s(1, 0, Short.valueOf(m0Var.f2338a), 65535);
    }

    @Override // k1.z1
    public m0 d() {
        Short n2 = n(1, 0, 65535);
        if (n2 == null) {
            return null;
        }
        return m0.a(n2);
    }

    @Override // k1.z1
    public w e() {
        return u(m(253, 0, 65535));
    }

    @Override // k1.z1
    public k0 f() {
        Short n2 = n(0, 0, 65535);
        if (n2 == null) {
            return null;
        }
        return k0.a(n2);
    }
}
