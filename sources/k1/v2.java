package k1;

/* loaded from: classes.dex */
public class v2 extends s1 implements z1 {

    /* renamed from: g */
    protected static final s1 f2456g;

    static {
        s1 s1Var = new s1("session", 18);
        f2456g = s1Var;
        s1Var.h(new s0("message_index", 254, 132, 1.0d, 0.0d, "", false, l2.MESSAGE_INDEX));
        l2 l2Var = l2.DATE_TIME;
        s1Var.h(new s0("timestamp", 253, 134, 1.0d, 0.0d, "s", false, l2Var));
        s1Var.h(new s0("event", 0, 0, 1.0d, 0.0d, "", false, l2.EVENT));
        s1Var.h(new s0("event_type", 1, 0, 1.0d, 0.0d, "", false, l2.EVENT_TYPE));
        s1Var.h(new s0("start_time", 2, 134, 1.0d, 0.0d, "", false, l2Var));
        l2 l2Var2 = l2.SINT32;
        s1Var.h(new s0("start_position_lat", 3, 133, 1.0d, 0.0d, "semicircles", false, l2Var2));
        s1Var.h(new s0("start_position_long", 4, 133, 1.0d, 0.0d, "semicircles", false, l2Var2));
        s1Var.h(new s0("sport", 5, 0, 1.0d, 0.0d, "", false, l2.SPORT));
        s1Var.h(new s0("sub_sport", 6, 0, 1.0d, 0.0d, "", false, l2.SUB_SPORT));
        l2 l2Var3 = l2.UINT32;
        s1Var.h(new s0("total_elapsed_time", 7, 134, 1000.0d, 0.0d, "s", false, l2Var3));
        s1Var.h(new s0("total_timer_time", 8, 134, 1000.0d, 0.0d, "s", false, l2Var3));
        s1Var.h(new s0("total_distance", 9, 134, 100.0d, 0.0d, "m", false, l2Var3));
        s1Var.h(new s0("total_cycles", 10, 134, 1.0d, 0.0d, "cycles", false, l2Var3));
        ((s0) s1Var.f2382d.get(12)).f2376k.add(new d3("total_strides", 134, 1.0d, 0.0d, "strides"));
        ((d3) ((s0) s1Var.f2382d.get(12)).f2376k.get(0)).b(5, 1L);
        ((d3) ((s0) s1Var.f2382d.get(12)).f2376k.get(0)).b(5, 11L);
        ((s0) s1Var.f2382d.get(12)).f2376k.add(new d3("total_strokes", 134, 1.0d, 0.0d, "strokes"));
        ((d3) ((s0) s1Var.f2382d.get(12)).f2376k.get(1)).b(5, 2L);
        ((d3) ((s0) s1Var.f2382d.get(12)).f2376k.get(1)).b(5, 5L);
        ((d3) ((s0) s1Var.f2382d.get(12)).f2376k.get(1)).b(5, 15L);
        ((d3) ((s0) s1Var.f2382d.get(12)).f2376k.get(1)).b(5, 37L);
        l2 l2Var4 = l2.UINT16;
        s1Var.h(new s0("total_calories", 11, 132, 1.0d, 0.0d, "kcal", false, l2Var4));
        s1Var.h(new s0("total_fat_calories", 13, 132, 1.0d, 0.0d, "kcal", false, l2Var4));
        s1Var.h(new s0("avg_speed", 14, 132, 1000.0d, 0.0d, "m/s", false, l2Var4));
        ((s0) s1Var.f2382d.get(15)).f2375j.add(new w0(124, false, 16, 1000.0d, 0.0d));
        s1Var.h(new s0("max_speed", 15, 132, 1000.0d, 0.0d, "m/s", false, l2Var4));
        ((s0) s1Var.f2382d.get(16)).f2375j.add(new w0(125, false, 16, 1000.0d, 0.0d));
        l2 l2Var5 = l2.UINT8;
        s1Var.h(new s0("avg_heart_rate", 16, 2, 1.0d, 0.0d, "bpm", false, l2Var5));
        s1Var.h(new s0("max_heart_rate", 17, 2, 1.0d, 0.0d, "bpm", false, l2Var5));
        s1Var.h(new s0("avg_cadence", 18, 2, 1.0d, 0.0d, "rpm", false, l2Var5));
        ((s0) s1Var.f2382d.get(19)).f2376k.add(new d3("avg_running_cadence", 2, 1.0d, 0.0d, "strides/min"));
        ((d3) ((s0) s1Var.f2382d.get(19)).f2376k.get(0)).b(5, 1L);
        s1Var.h(new s0("max_cadence", 19, 2, 1.0d, 0.0d, "rpm", false, l2Var5));
        ((s0) s1Var.f2382d.get(20)).f2376k.add(new d3("max_running_cadence", 2, 1.0d, 0.0d, "strides/min"));
        ((d3) ((s0) s1Var.f2382d.get(20)).f2376k.get(0)).b(5, 1L);
        s1Var.h(new s0("avg_power", 20, 132, 1.0d, 0.0d, "watts", false, l2Var4));
        s1Var.h(new s0("max_power", 21, 132, 1.0d, 0.0d, "watts", false, l2Var4));
        s1Var.h(new s0("total_ascent", 22, 132, 1.0d, 0.0d, "m", false, l2Var4));
        s1Var.h(new s0("total_descent", 23, 132, 1.0d, 0.0d, "m", false, l2Var4));
        s1Var.h(new s0("total_training_effect", 24, 2, 10.0d, 0.0d, "", false, l2Var5));
        s1Var.h(new s0("first_lap_index", 25, 132, 1.0d, 0.0d, "", false, l2Var4));
        s1Var.h(new s0("num_laps", 26, 132, 1.0d, 0.0d, "", false, l2Var4));
        s1Var.h(new s0("event_group", 27, 2, 1.0d, 0.0d, "", false, l2Var5));
        s1Var.h(new s0("trigger", 28, 0, 1.0d, 0.0d, "", false, l2.SESSION_TRIGGER));
        s1Var.h(new s0("nec_lat", 29, 133, 1.0d, 0.0d, "semicircles", false, l2Var2));
        s1Var.h(new s0("nec_long", 30, 133, 1.0d, 0.0d, "semicircles", false, l2Var2));
        s1Var.h(new s0("swc_lat", 31, 133, 1.0d, 0.0d, "semicircles", false, l2Var2));
        s1Var.h(new s0("swc_long", 32, 133, 1.0d, 0.0d, "semicircles", false, l2Var2));
        s1Var.h(new s0("num_lengths", 33, 132, 1.0d, 0.0d, "lengths", false, l2Var4));
        s1Var.h(new s0("normalized_power", 34, 132, 1.0d, 0.0d, "watts", false, l2Var4));
        s1Var.h(new s0("training_stress_score", 35, 132, 10.0d, 0.0d, "tss", false, l2Var4));
        s1Var.h(new s0("intensity_factor", 36, 132, 1000.0d, 0.0d, "if", false, l2Var4));
        s1Var.h(new s0("left_right_balance", 37, 132, 1.0d, 0.0d, "", false, l2.LEFT_RIGHT_BALANCE_100));
        s1Var.h(new s0("avg_stroke_count", 41, 134, 10.0d, 0.0d, "strokes/lap", false, l2Var3));
        s1Var.h(new s0("avg_stroke_distance", 42, 132, 100.0d, 0.0d, "m", false, l2Var4));
        s1Var.h(new s0("swim_stroke", 43, 0, 1.0d, 0.0d, "swim_stroke", false, l2.SWIM_STROKE));
        s1Var.h(new s0("pool_length", 44, 132, 100.0d, 0.0d, "m", false, l2Var4));
        s1Var.h(new s0("threshold_power", 45, 132, 1.0d, 0.0d, "watts", false, l2Var4));
        s1Var.h(new s0("pool_length_unit", 46, 0, 1.0d, 0.0d, "", false, l2.DISPLAY_MEASURE));
        s1Var.h(new s0("num_active_lengths", 47, 132, 1.0d, 0.0d, "lengths", false, l2Var4));
        s1Var.h(new s0("total_work", 48, 134, 1.0d, 0.0d, "J", false, l2Var3));
        s1Var.h(new s0("avg_altitude", 49, 132, 5.0d, 500.0d, "m", false, l2Var4));
        ((s0) s1Var.f2382d.get(47)).f2375j.add(new w0(126, false, 16, 5.0d, 500.0d));
        s1Var.h(new s0("max_altitude", 50, 132, 5.0d, 500.0d, "m", false, l2Var4));
        ((s0) s1Var.f2382d.get(48)).f2375j.add(new w0(128, false, 16, 5.0d, 500.0d));
        s1Var.h(new s0("gps_accuracy", 51, 2, 1.0d, 0.0d, "m", false, l2Var5));
        l2 l2Var6 = l2.SINT16;
        s1Var.h(new s0("avg_grade", 52, 131, 100.0d, 0.0d, "%", false, l2Var6));
        s1Var.h(new s0("avg_pos_grade", 53, 131, 100.0d, 0.0d, "%", false, l2Var6));
        s1Var.h(new s0("avg_neg_grade", 54, 131, 100.0d, 0.0d, "%", false, l2Var6));
        s1Var.h(new s0("max_pos_grade", 55, 131, 100.0d, 0.0d, "%", false, l2Var6));
        s1Var.h(new s0("max_neg_grade", 56, 131, 100.0d, 0.0d, "%", false, l2Var6));
        l2 l2Var7 = l2.SINT8;
        s1Var.h(new s0("avg_temperature", 57, 1, 1.0d, 0.0d, "C", false, l2Var7));
        s1Var.h(new s0("max_temperature", 58, 1, 1.0d, 0.0d, "C", false, l2Var7));
        s1Var.h(new s0("total_moving_time", 59, 134, 1000.0d, 0.0d, "s", false, l2Var3));
        s1Var.h(new s0("avg_pos_vertical_speed", 60, 131, 1000.0d, 0.0d, "m/s", false, l2Var6));
        s1Var.h(new s0("avg_neg_vertical_speed", 61, 131, 1000.0d, 0.0d, "m/s", false, l2Var6));
        s1Var.h(new s0("max_pos_vertical_speed", 62, 131, 1000.0d, 0.0d, "m/s", false, l2Var6));
        s1Var.h(new s0("max_neg_vertical_speed", 63, 131, 1000.0d, 0.0d, "m/s", false, l2Var6));
        s1Var.h(new s0("min_heart_rate", 64, 2, 1.0d, 0.0d, "bpm", false, l2Var5));
        s1Var.h(new s0("time_in_hr_zone", 65, 134, 1000.0d, 0.0d, "s", false, l2Var3));
        s1Var.h(new s0("time_in_speed_zone", 66, 134, 1000.0d, 0.0d, "s", false, l2Var3));
        s1Var.h(new s0("time_in_cadence_zone", 67, 134, 1000.0d, 0.0d, "s", false, l2Var3));
        s1Var.h(new s0("time_in_power_zone", 68, 134, 1000.0d, 0.0d, "s", false, l2Var3));
        s1Var.h(new s0("avg_lap_time", 69, 134, 1000.0d, 0.0d, "s", false, l2Var3));
        s1Var.h(new s0("best_lap_index", 70, 132, 1.0d, 0.0d, "", false, l2Var4));
        s1Var.h(new s0("min_altitude", 71, 132, 5.0d, 500.0d, "m", false, l2Var4));
        ((s0) s1Var.f2382d.get(69)).f2375j.add(new w0(127, false, 16, 5.0d, 500.0d));
        s1Var.h(new s0("player_score", 82, 132, 1.0d, 0.0d, "", false, l2Var4));
        s1Var.h(new s0("opponent_score", 83, 132, 1.0d, 0.0d, "", false, l2Var4));
        s1Var.h(new s0("opponent_name", 84, 7, 1.0d, 0.0d, "", false, l2.STRING));
        s1Var.h(new s0("stroke_count", 85, 132, 1.0d, 0.0d, "counts", false, l2Var4));
        s1Var.h(new s0("zone_count", 86, 132, 1.0d, 0.0d, "counts", false, l2Var4));
        s1Var.h(new s0("max_ball_speed", 87, 132, 100.0d, 0.0d, "m/s", false, l2Var4));
        s1Var.h(new s0("avg_ball_speed", 88, 132, 100.0d, 0.0d, "m/s", false, l2Var4));
        s1Var.h(new s0("avg_vertical_oscillation", 89, 132, 10.0d, 0.0d, "mm", false, l2Var4));
        s1Var.h(new s0("avg_stance_time_percent", 90, 132, 100.0d, 0.0d, "percent", false, l2Var4));
        s1Var.h(new s0("avg_stance_time", 91, 132, 10.0d, 0.0d, "ms", false, l2Var4));
        s1Var.h(new s0("avg_fractional_cadence", 92, 2, 128.0d, 0.0d, "rpm", false, l2Var5));
        s1Var.h(new s0("max_fractional_cadence", 93, 2, 128.0d, 0.0d, "rpm", false, l2Var5));
        s1Var.h(new s0("total_fractional_cycles", 94, 2, 128.0d, 0.0d, "cycles", false, l2Var5));
        s1Var.h(new s0("avg_total_hemoglobin_conc", 95, 132, 100.0d, 0.0d, "g/dL", false, l2Var4));
        s1Var.h(new s0("min_total_hemoglobin_conc", 96, 132, 100.0d, 0.0d, "g/dL", false, l2Var4));
        s1Var.h(new s0("max_total_hemoglobin_conc", 97, 132, 100.0d, 0.0d, "g/dL", false, l2Var4));
        s1Var.h(new s0("avg_saturated_hemoglobin_percent", 98, 132, 10.0d, 0.0d, "%", false, l2Var4));
        s1Var.h(new s0("min_saturated_hemoglobin_percent", 99, 132, 10.0d, 0.0d, "%", false, l2Var4));
        s1Var.h(new s0("max_saturated_hemoglobin_percent", 100, 132, 10.0d, 0.0d, "%", false, l2Var4));
        s1Var.h(new s0("avg_left_torque_effectiveness", 101, 2, 2.0d, 0.0d, "percent", false, l2Var5));
        s1Var.h(new s0("avg_right_torque_effectiveness", 102, 2, 2.0d, 0.0d, "percent", false, l2Var5));
        s1Var.h(new s0("avg_left_pedal_smoothness", 103, 2, 2.0d, 0.0d, "percent", false, l2Var5));
        s1Var.h(new s0("avg_right_pedal_smoothness", 104, 2, 2.0d, 0.0d, "percent", false, l2Var5));
        s1Var.h(new s0("avg_combined_pedal_smoothness", 105, 2, 2.0d, 0.0d, "percent", false, l2Var5));
        s1Var.h(new s0("sport_index", 111, 2, 1.0d, 0.0d, "", false, l2Var5));
        s1Var.h(new s0("time_standing", 112, 134, 1000.0d, 0.0d, "s", false, l2Var3));
        s1Var.h(new s0("stand_count", 113, 132, 1.0d, 0.0d, "", false, l2Var4));
        s1Var.h(new s0("avg_left_pco", 114, 1, 1.0d, 0.0d, "mm", false, l2Var7));
        s1Var.h(new s0("avg_right_pco", 115, 1, 1.0d, 0.0d, "mm", false, l2Var7));
        s1Var.h(new s0("avg_left_power_phase", 116, 2, 0.7111111d, 0.0d, "degrees", false, l2Var5));
        s1Var.h(new s0("avg_left_power_phase_peak", 117, 2, 0.7111111d, 0.0d, "degrees", false, l2Var5));
        s1Var.h(new s0("avg_right_power_phase", 118, 2, 0.7111111d, 0.0d, "degrees", false, l2Var5));
        s1Var.h(new s0("avg_right_power_phase_peak", 119, 2, 0.7111111d, 0.0d, "degrees", false, l2Var5));
        s1Var.h(new s0("avg_power_position", 120, 132, 1.0d, 0.0d, "watts", false, l2Var4));
        s1Var.h(new s0("max_power_position", 121, 132, 1.0d, 0.0d, "watts", false, l2Var4));
        s1Var.h(new s0("avg_cadence_position", 122, 2, 1.0d, 0.0d, "rpm", false, l2Var5));
        s1Var.h(new s0("max_cadence_position", 123, 2, 1.0d, 0.0d, "rpm", false, l2Var5));
        s1Var.h(new s0("enhanced_avg_speed", 124, 134, 1000.0d, 0.0d, "m/s", false, l2Var3));
        s1Var.h(new s0("enhanced_max_speed", 125, 134, 1000.0d, 0.0d, "m/s", false, l2Var3));
        s1Var.h(new s0("enhanced_avg_altitude", 126, 134, 5.0d, 500.0d, "m", false, l2Var3));
        s1Var.h(new s0("enhanced_min_altitude", 127, 134, 5.0d, 500.0d, "m", false, l2Var3));
        s1Var.h(new s0("enhanced_max_altitude", 128, 134, 5.0d, 500.0d, "m", false, l2Var3));
        s1Var.h(new s0("avg_lev_motor_power", 129, 132, 1.0d, 0.0d, "watts", false, l2Var4));
        s1Var.h(new s0("max_lev_motor_power", 130, 132, 1.0d, 0.0d, "watts", false, l2Var4));
        s1Var.h(new s0("lev_battery_consumption", 131, 2, 2.0d, 0.0d, "percent", false, l2Var5));
        s1Var.h(new s0("avg_vertical_ratio", 132, 132, 100.0d, 0.0d, "percent", false, l2Var4));
        s1Var.h(new s0("avg_stance_time_balance", 133, 132, 100.0d, 0.0d, "percent", false, l2Var4));
        s1Var.h(new s0("avg_step_length", 134, 132, 10.0d, 0.0d, "mm", false, l2Var4));
        s1Var.h(new s0("total_anaerobic_training_effect", 137, 2, 10.0d, 0.0d, "", false, l2Var5));
        s1Var.h(new s0("avg_vam", 139, 132, 1000.0d, 0.0d, "m/s", false, l2Var4));
        s1Var.h(new s0("avg_depth", 140, 134, 1000.0d, 0.0d, "m", false, l2Var3));
        s1Var.h(new s0("max_depth", 141, 134, 1000.0d, 0.0d, "m", false, l2Var3));
        s1Var.h(new s0("surface_interval", 142, 134, 1.0d, 0.0d, "s", false, l2Var3));
        s1Var.h(new s0("start_cns", 143, 2, 1.0d, 0.0d, "percent", false, l2Var5));
        s1Var.h(new s0("end_cns", 144, 2, 1.0d, 0.0d, "percent", false, l2Var5));
        s1Var.h(new s0("start_n2", 145, 132, 1.0d, 0.0d, "percent", false, l2Var4));
        s1Var.h(new s0("end_n2", 146, 132, 1.0d, 0.0d, "percent", false, l2Var4));
        s1Var.h(new s0("avg_respiration_rate", 147, 2, 1.0d, 0.0d, "", false, l2Var5));
        ((s0) s1Var.f2382d.get(127)).f2375j.add(new w0(169, false, 8, 1.0d, 0.0d));
        s1Var.h(new s0("max_respiration_rate", 148, 2, 1.0d, 0.0d, "", false, l2Var5));
        ((s0) s1Var.f2382d.get(128)).f2375j.add(new w0(170, false, 8, 1.0d, 0.0d));
        s1Var.h(new s0("min_respiration_rate", 149, 2, 1.0d, 0.0d, "", false, l2Var5));
        ((s0) s1Var.f2382d.get(129)).f2375j.add(new w0(180, false, 8, 1.0d, 0.0d));
        s1Var.h(new s0("min_temperature", 150, 1, 1.0d, 0.0d, "C", false, l2Var7));
        s1Var.h(new s0("o2_toxicity", 155, 132, 1.0d, 0.0d, "OTUs", false, l2Var4));
        s1Var.h(new s0("dive_number", 156, 134, 1.0d, 0.0d, "", false, l2Var3));
        s1Var.h(new s0("training_load_peak", 168, 133, 65536.0d, 0.0d, "", false, l2Var2));
        s1Var.h(new s0("enhanced_avg_respiration_rate", 169, 132, 100.0d, 0.0d, "Breaths/min", false, l2Var4));
        s1Var.h(new s0("enhanced_max_respiration_rate", 170, 132, 100.0d, 0.0d, "Breaths/min", false, l2Var4));
        s1Var.h(new s0("enhanced_min_respiration_rate", 180, 132, 100.0d, 0.0d, "", false, l2Var4));
        l2 l2Var8 = l2.FLOAT32;
        s1Var.h(new s0("total_grit", 181, 136, 1.0d, 0.0d, "kGrit", false, l2Var8));
        s1Var.h(new s0("total_flow", 182, 136, 1.0d, 0.0d, "Flow", false, l2Var8));
        s1Var.h(new s0("jump_count", 183, 132, 1.0d, 0.0d, "", false, l2Var4));
        s1Var.h(new s0("avg_grit", 186, 136, 1.0d, 0.0d, "kGrit", false, l2Var8));
        s1Var.h(new s0("avg_flow", 187, 136, 1.0d, 0.0d, "Flow", false, l2Var8));
        s1Var.h(new s0("total_fractional_ascent", 199, 2, 100.0d, 0.0d, "m", false, l2Var5));
        s1Var.h(new s0("total_fractional_descent", 200, 2, 100.0d, 0.0d, "m", false, l2Var5));
        s1Var.h(new s0("avg_core_temperature", 208, 132, 100.0d, 0.0d, "C", false, l2Var4));
        s1Var.h(new s0("min_core_temperature", 209, 132, 100.0d, 0.0d, "C", false, l2Var4));
        s1Var.h(new s0("max_core_temperature", 210, 132, 100.0d, 0.0d, "C", false, l2Var4));
    }

    public v2(s1 s1Var) {
        super(s1Var);
    }

    @Override // k1.z1
    public Short a() {
        return n(27, 0, 65535);
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
